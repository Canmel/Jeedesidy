meedesidy.service('pageQuery', function($http, $q) {
	this.pageQuery = function(index, url, $scope) {
		var d = $q.defer(); // $q创建一个deferred对象
		$scope.searchParams.pindex = index;
		$http({
	        method: 'GET',
	        url: '/meedesidy/' + url + '/pageQuery',
	        params: $scope.searchParams
	    }).success(function(resp) {
//	    	在$q中，可以使用resolve方法，变成完成状态；使用reject方法，变成拒绝状态
			d.resolve(resp);
			$scope = resp
		}).error(function(resp) {
            d.reject("error");
		});
		return d.promise
	}
});