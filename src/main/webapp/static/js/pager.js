 meedesidy.service('pager', function($http,$q) {
        this.name = "service";
        this.myFunc = function (x) {
            return x.toString(16);//转16进制
        }
        this.query = function(){
            alert();
            return null;
        }
    });
