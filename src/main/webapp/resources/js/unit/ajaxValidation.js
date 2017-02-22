$.fn.ajaxValidation = function (url, callback, success, error) {
	$(this).validationEngine({
    	ajaxFormValidation : true,
    	ajaxFormValidationURL : url,
    	ajaxFormValidationMethod : "post",
    	onBeforeAjaxFormValidation : function(form, options){},
    	onAjaxFormComplete : function(status, form, json, options){
	         //清除之前的信息提示
	         $('#myAlert').alert('close');
	         if(callback !== undefined){
	        	 callback(json);
		     }
	         if(json['error']==false){
	        	 //添加成功mes
		       	 common.addSuccessMessage(json['message']);
		       	 if(success !== undefined){
		       		success(json);
		       	 }
	         }else{
	        	 if(json['errorCode']==='101'){
   	        		window.top.location = contextPath+"/account/login/show.html";
   	        	}else{
   	        		common.addErrorMessage(json['message']);
       	        	if(error!==undefined){
       	        		error(json);
       		       	}
   	        	}
	         }
    	}
    });
}
