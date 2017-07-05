var meedesidy = angular.module('meedesidy', ['ui.router']);

meedesidy.service('servicetest', ['$window',          //service方式  
	    function($window) {
		$window.alert('bbbb'); // 内置服务可以注入
		this.firstname = "tank";
		this.lastname = function() {
			return "zhang";
		}
	}
]);
var test = {};
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
}]);

