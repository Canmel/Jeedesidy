var meedesidy = angular.module('meedesidy', ['ui.router']);

meedesidy.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
	//	默认路由
	$urlRouterProvider.otherwise('index');
	//	配置基本路由
	$stateProvider.state('index', {
		url: '/index',
		templateUrl: 'pages/index.jsp'
	}).state('menu', {
		url: '/menu',
		templateUrl: 'pages/menu/index.jsp',
		controller: 'menu'
	}).state('user', {
        url: '/user',
        templateUrl: 'pages/user/index.jsp',
        controller: 'user'
    }).state('role', {
        url: '/role',
        templateUrl: 'pages/role/index.jsp',
        controller: 'role'
    });
	
	
//	返回当前页面的url  $location.absUrl();   注入服务 $location 即可
}]);

