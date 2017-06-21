(function($){
	$.confirm = function(str,confirm_back, cancel_back) {
		$("#confirm_modal").modal('show');
		$(".confirm_body").html(str);
		$("#confirm").unbind('click').click(function(){
			confirm_back();
			$("#confirm_modal").modal('hide')
		});
		$("#cancel").unbind('click').click(function(){
			cancel_back();
		});
	}
	
})(jQuery)