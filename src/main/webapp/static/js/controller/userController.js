meedesidy.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
	$stateProvider.state('newUser',{
		url: '/user/new',
		templateUrl: 'pages/user/new.jsp',
		controller: 'user'
	}).state('editUser',{
		url: '/user/edit/{id}',
		templateUrl: 'pages/user/new.jsp',
		controller: 'user'
	});
}]);

meedesidy.controller('user', ['$scope', '$http', '$state', '$stateParams', 'pageQuery' , function($scope, $http, $state, $stateParams, pageQuery) {
	pageQuery.pageQuery(1,23,4);
//	servicetest.firstname;
	//	检查参数id
	if($stateParams.id){
		$http({	
			method: 'get',
			url: '/meedesidy/user/get',
			params: {id: $stateParams.id}
		}).then(function(resp){
			$scope.user = resp.data
		}),(function(resp){
			$scope.user = {"id":1,"name":"李德健","createAt":null,"remark":"最好的人","pindex":0,"psize":0,"ptotal":0,"password":"123123","createdAt":"2017-03-01","age":26,"phone":"13622844833"}
			console.error(resp);
		});
		
		$http.get("/meedesidy/role/all").then(function (response) {
	        $scope.allRole = response.data;
	        $scope.selectedRole = [];
			$($scope.user.roles).each(function(index, item) {
				$scope.selectedRole.push(item.id);
			});
	    });
	}else{
		$http.get("/meedesidy/role/all").then(function (response) {
			$scope.selectedRole = [];
	        $scope.allRole = response.data;
	    });
	}
	
	$scope.isSelected = function(id){
        return $scope.selectedRole.indexOf(id)>=0;
	}
	
//	编辑用户 传参数
	$scope.edit_user = function(user){
		$scope.user = user;
		$state.go('editUser',{'user': user});
	};
	
//	设置分页查询默认参数
	$scope.searchParams = { pindex: 1, psize: 10, name: null };
	
//	分页查询
	$scope.pageQuery = function(pindex){
		$scope.searchParams.pindex = pindex;
		$scope.search();
	};
	
//	查询
	$scope.search = function() {
				$http({
					method: "post",
					url: "/meedesidy/user/pageQuery",
					data: $.param($scope.searchParams),
					headers : { 'Content-Type': 'application/x-www-form-urlencoded' }
				}).then(function(resp){
					$scope.datas = resp.data.result;
				}),(function(resp){
					console.info(resp);
				});

	};
	
	$scope.delUser = function(param){
		console.info(param.id);
		$.confirm("确认删除？", function() {
			$http.delete("/meedesidy/user/" + param.id).then(function (resp) {
				$scope.search();
			});
		});
	}
	
//	提交保存表单
	$scope.processForm = function(){
		$scope.user.roles = []
		$scope.user.role_ids = []
		$("input[name='role_ids']").each(function(index, item) {
			if($(this).attr('checked') == 'checked'){
				$scope.user.role_ids.push($(this).val());
			}
		});
		$http({
			method: "post",
			url: "/meedesidy/user/save",
			data: $.param($scope.user),
			headers : { 'Content-Type': 'application/x-www-form-urlencoded' }
		}).then(function success_cb(resp){
			if(resp.data){
				$state.go("user");
			};
		}, function error_cb(resp){
			if(resp.status == 500){
				alert("保存失败");
			};
		});
	};

//	进入页面 请求数据
	$http({
		method: "post",
		url: "/meedesidy/user/pageQuery",
		data: $.param($scope.searchParams),
		headers : { 'Content-Type': 'application/x-www-form-urlencoded' }
	}).then(function(resp){
		$scope.datas = resp.data.result;
		$scope.total = resp.data.total;
		$scope.searchParams.ptotal = Math.ceil($scope.total / $scope.searchParams.psize);
	}),(function(resp){
		console.info(resp);
	});
	$scope.total = $scope.total == null ? 0 : $scope.total
	$scope.searchParams.ptotal = Math.ceil($scope.total / $scope.searchParams.psize);
}]);

meedesidy.filter('showRole', function() {
	return function(roles) {
		var result = "["
		$(roles).each(function(index, item) {
			result += item.name;
			result += ",";
		});
		if(result.length > 1){
			result = result.substring(0, result.length - 1);
		}
		return result + "]";
    }
})