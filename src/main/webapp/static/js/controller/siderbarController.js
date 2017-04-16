meedesidy.config([ '$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {} ]);

meedesidy.controller('sidebar', [ '$scope', '$http', '$state', '$stateParams', function($scope, $http, $state, stateParams) {
	$scope.showMenu = function($event){
		var ul = $($event.target).parent('li').find("ul");
		if(!$(ul).hasClass("active")){
			$(ul).slideDown();
			$(ul).eq(0).addClass('active');
			$($event.target).addClass('active');
		}else{
			$(ul).slideUp();
			$(ul).eq(0).removeClass('active');
			$($event.target).removeClass('active');
		};
	}
	
	$http({
		method : 'get',
		url : '/meedesidy/menu/all'
	}).then(function(resp) {
		$scope.menus = resp.data;
	}), (function(resp) {
		$scope.menus = [ {
			id : 1,
			name : '系统管理',
			resouce : '',
			pid : 0
		}, {
			id : 2,
			name : '菜单管理',
			resouce : '/menu',
			pid : 1
		}, {
			id : 3,
			name : '用户管理',
			resouce : '/user',
			pid : 1
		} ];
	});
	$scope.go = function($event, url) {
		$(".sidebar-menu").find('li').removeClass('active');
		$(".sidebar-menu").find('a').removeClass('active');
		console.info($($event.target).parents("li").eq(1).find("a").addClass("active"));
		$($event.target).parent().addClass('active');
		$state.go(url);
	}

	$scope.hasMenu = function(v) {
		0 == 0
	}
} ]);