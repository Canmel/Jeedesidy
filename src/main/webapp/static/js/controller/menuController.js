meedesidy.config([ '$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
	//	配置基本路由
	$stateProvider.state('newMenu', {
		url : '/menu/new',
		templateUrl : 'pages/menu/new.jsp',
		controller : 'menu'
	}).state('editMenu', {
		url : '/menu/edit/{id}',
		templateUrl : 'pages/menu/new.jsp',
		controller : 'menu'
	});
} ]);

meedesidy.controller('menu', [ '$scope', '$http', '$state', '$stateParams', 'pageQuery', 'moddalSevice', function($scope, $http, $state, $stateParams, pageQuery, moddalSevice) {
	var type = 'menu';
	
	$scope.pageQuery = function(index) {
		pageQuery.pageQuery(index,"menu",$scope).then(function(data) {
			query_callBack(data)
		},function(data){
            alert(data)//错误时走这儿
        });
	}
    //	检查参数id
    if($stateParams.id){
        $http({
            method: 'get',
            url: '/meedesidy/'+ type +'/get',
            params: {id: $stateParams.id}
        }).then(function(resp){
            $scope.menu = resp.data;
            if($scope.menu.menuType.id != undefined && $scope.menu.menuType.id != null){
            	$scope.menu.menuType_id = $scope.menu.menuType.id
            }
        }),(function(resp){
            console.error(resp);
        })
    }

	$scope.menu = {
		type : "SUBMENU"
	}

	//	设置分页查询默认参数
	$scope.searchParams = {
		pindex : 1,
		psize : 10,
		name : null
	};

	//	进入页面 请求数据
	$http({
		method : "post",
		url : "/meedesidy/" + type + "/pageQuery",
		data : $.param($scope.searchParams),
		headers : {
			'Content-Type' : 'application/x-www-form-urlencoded'
		}
	}).then(function(resp) {
		query_callBack(resp.data)
	}), (function(resp) {
		console.info(resp);
	});

	//	查询
	$scope.search = function() {
		$http({
			method : "post",
			url : "/meedesidy/" + type + "/pageQuery",
			data : $.param($scope.searchParams),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).then(function(resp) {
			query_callBack(resp.data);
		}), (function(resp) {
			console.info(resp);
		});
	};
	
	$scope.delete = function(name, id) {
		moddalSevice.confirm("是否删除"+name+"？","确认删除", '/meedesidy/menu/'+ id).then(function(data) {
			pageQuery.pageQuery(1,"menu",$scope).then(function(result) {
				query_callBack(result)
			},function(result){
	            alert(result)//错误时走这儿
	        });
		});
	}

	//	提交保存表单
	$scope.processForm = function() {
		$http({
			method : "post",
			url : "/meedesidy/" + type + "/save",
			data : $.param($scope.menu),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(resp) {
			console.info(resp);
			if (resp.id) {
				$state.go("menu");
			}
		});
	};


	$http({
		method : "post",
		url : "/meedesidy/menu/query",
		params : {
			'menuType.id' : "1"
		},
		headers : {
			'Content-Type' : 'application/x-www-form-urlencoded'
		}
	}).success(function(resp) {
		$scope.topMenus = resp
	});
	
	function query_callBack(data){
		$scope.datas = data.result;
		$scope.total = data.total;
		$scope.searchParams.ptotal = Math.ceil($scope.total / $scope.searchParams.psize);
	}
} ]);
