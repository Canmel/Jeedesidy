meedesidy.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider) {
    //	配置基本路由
    $stateProvider.state('newRole', {
        url: '/role/new',
        templateUrl: 'pages/role/new.jsp',
        controller: 'role'
    }).state('editRole', {
        url: '/role/edit/{id}',
        templateUrl: 'pages/role/new.jsp',
        controller: 'role'
    });
}]);

meedesidy.controller('role', ['$scope', '$http', '$state', '$stateParams', function ($scope, $http, $state, $stateParams) {
    var type = 'role';

    //	检查参数id
    if ($stateParams.id) {
        $http({
            method: 'get',
            url: '/meedesidy/' + type + '/get',
            params: {id: $stateParams.id}
        }).then(function (resp) {
            $scope.role = resp.data
        })
    }

    $scope.role = {}

    //	设置分页查询默认参数
    $scope.searchParams = {
        pindex: 1,
        psize: 10,
        name: null
    };

    //	进入页面 请求数据
    $http({
        method: "post",
        url: "/meedesidy/" + type + "/pageQuery",
        data: $.param($scope.searchParams),
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        }
    }).then(function (resp) {
        $scope.datas = resp.data.result;
        $scope.total = resp.data.total;
        $scope.searchParams.ptotal = Math.ceil($scope.total / $scope.searchParams.psize);
    });

    //	查询
    $scope.search = function () {
        $http({
            method: "post",
            url: "/meedesidy/" + type + "/pageQuery",
            data: $.param($scope.searchParams),
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        }).then(function (resp) {
            $scope.datas = resp.data.result;
        }), (function (resp) {
            console.error(resp);
        });

    };

    //	提交保存表单
    $scope.processForm = function () {
        $scope.role == {};
        $http({
            method: "post",
            url: "/meedesidy/" + type + "/save",
            data: $.param($scope.role),
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        }).success(function (resp) {
            console.info(resp);
            if (resp.id) {
                $state.go("role");
            }
        });
    };
}]);