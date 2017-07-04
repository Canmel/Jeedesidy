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

meedesidy.controller('menu', [ '$scope', '$http', '$state', '$stateParams', function($scope, $http, $state, $stateParams) {
	var type = 'menu';

    //	检查参数id
    if($stateParams.id){
        $http({
            method: 'get',
            url: '/meedesidy/'+ type +'/get',
            params: {id: $stateParams.id}
        }).then(function(resp){
            $scope.menu = resp.data
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
		$scope.datas = resp.data.result;
		$scope.total = resp.data.total;
		$scope.searchParams.ptotal = Math.ceil($scope.total / $scope.searchParams.psize);
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
			console.info(resp.data.result);
			$scope.datas = resp.data.result;
		}), (function(resp) {
			console.info(resp);
		});

	};

	//	提交保存表单
	$scope.processForm = function() {
		test = $scope.menu;
		console.info($scope.menu);
		return;
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
		console.log(resp);
		$scope.topMenus = resp
	});




} ]);