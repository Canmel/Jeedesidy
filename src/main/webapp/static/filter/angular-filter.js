meedesidy.filter('datetime', function(){
	return function(text){
		return text.substr(0,19);
	}
});

meedesidy.filter('yyyymmdd',function(){
	return function(text){
		return text.substr(0,10);
	}
})