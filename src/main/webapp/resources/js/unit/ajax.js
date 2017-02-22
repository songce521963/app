jQuery.extend({
	
	/**  
     * ajax post提交  contentType：application/json
     * @param url  
     * @param param  
     * @param callback回调函数  
     * @return  
     */  
	jsonAjax : function(url, param, callback, success, error) {  
		if(layerFlg==0){
    		//制御 铺层
    		common.layerHtml();
    		$.ajax({  
                type: "post",  
                url: url,  
                contentType : "application/json",
                data: JSON.stringify(param),  
                dataType: "json",  
                success: function(data){
               	 //删除铺层
                 common.removeLayerHtml();
               	 if(callback!==undefined){
               		 callback(data);
     		     }
               	 if(data['error']==false){
        				//添加成功mes
        		       	common.addSuccessMessage(data['message']);
        		       	if(success!==undefined){
        		       		success(data);
        		       	}
        	         }else{
        	        	if(data['errorCode']==='101'){
        	        		window.top.location = contextPath+"/account/login/show.html";
        	        	}else{
        	        		common.addErrorMessage(data['message']);
            	        	if(error!==undefined){
            	        		error(data);
            		       	}
        	        	}
        	         }
                },  
                error:  function(XMLHttpRequest, textStatus, errorThrown) {
                	//删除铺层
                    common.removeLayerHtml();
                    var message;
                    if(XMLHttpRequest.responseJSON){
                    	message= XMLHttpRequest.responseJSON.message;
                    }else{
                    	message = "ajax调用失败";
                    }
                    alert(message);
                }
            });  
		}
     },
     /**  
      * ajax post提交  
      * @param url  
      * @param param  
      * @param callback回调函数  
      * @return  
      */ 
     formAjax : function(url, formId, callback, success, error) {  
    	 if(layerFlg==0){
    		 //制御 铺层
     		 common.layerHtml();
    		 if($('#'+formId).validationEngine('validate')){
        		 $.ajax({  
                     type: "post",  
                     url: url,  
                     data: $('#'+formId).serialize(),
                     dataType: "json",
                     success: function(data){
                    	 //删除铺层
                         common.removeLayerHtml();
                    	 if(callback!==undefined){
                    		 callback(data);
          		       	 }
                    	 if(data['error']==false){
             				//添加成功mes
             		       	common.addSuccessMessage(data['message']);
             		       	if(success!==undefined){
             		       		success(data);
             		       	}
             	         }else{
             	        	if(data['errorCode']==='101'){
             	        		window.top.location = contextPath+"/account/login/show.html";
             	        	}else{
             	        		common.addErrorMessage(data['message']);
                 	        	if(error!==undefined){
                 	        		error(data);
                 		       	}
             	        	}
             	         }
                     },  
                     error:  function(XMLHttpRequest, textStatus, errorThrown) {
                    	//删除铺层
                         common.removeLayerHtml();
                         var message;
                         if(XMLHttpRequest.responseJSON){
                         	message= XMLHttpRequest.responseJSON.message;
                         }else{
                         	message = "ajax调用失败";
                         }
                         alert(message);
                     }
                 });  
        	 }else{
        		 common.removeLayerHtml();
        	 }
    	 }
     },
     /**  
      * ajax post提交  简单传值
      * @param url  
      * @param param  
      * @param callback回调函数  
      * @return  
      */ 
     simpleAjax : function(url, data, callback, success, error) { 
    	 if(layerFlg==0){
    		 //制御 铺层
     		 common.layerHtml();
    		 $.ajax({  
                 type: "post",  
                 url: url,  
                 data: data,
                 dataType: "json",
                 success: function(data){
                	//删除铺层
                     common.removeLayerHtml();
                	 if(callback!==undefined){
                		 callback(data);
      		       	 }
                	 if(data['error']==false){
         				//添加成功mes
         		       	common.addSuccessMessage(data['message']);
         		       	if(success!==undefined){
         		       		success(data);
         		       	}
         	         }else{
         	        	if(data['errorCode']==='101'){
         	        		window.top.location = contextPath+"/account/login/show.html";
         	        	}else{
         	        		common.addErrorMessage(data['message']);
             	        	if(error!==undefined){
             	        		error(data);
             		       	}
         	        	}
         	         }
                 },  
                 error:  function(XMLHttpRequest, textStatus, errorThrown) {
                     //删除铺层
                     common.removeLayerHtml();
                     var message;
                     if(XMLHttpRequest.responseJSON){
                     	message= XMLHttpRequest.responseJSON.message;
                     }else{
                     	message = "ajax调用失败";
                     }
                     alert(message);
                 }
             }); 
    	 }
     },
     /**  
      * ajax get提交  
      * @param url  
      * @param callback回调函数  
      * @return  
      */ 
     getAjax : function(url, data, callback, success, error) {  
    	 if(layerFlg==0){
    		 //制御 铺层
     		 common.layerHtml();
     		$.ajax({  
                type: "post",  
                url: url,
                data : data,
                dataType: "json",
                success: function(data){
                	//删除铺层
                    common.removeLayerHtml();
               	 	if(callback!==undefined){
               	 		callback(data);
     		       	 }
               	 if(data['error']==true){
               		if(data['errorCode']==='101'){
         	        		window.top.location = contextPath+"/account/login/show.html";
         	        	}else{
         	        		common.addErrorMessage(data['message']);
             	        	if(error!==undefined){
             	        		error(data);
             		       	}
         	        	}
        	         }else{
         		       	if(success!==undefined){
         		       		success(data);
         		       	}
        	         }
                },  
                error:  function(XMLHttpRequest, textStatus, errorThrown) {
                	//删除铺层
                    common.removeLayerHtml();
                    var message;
                    if(XMLHttpRequest.responseJSON){
                    	message= XMLHttpRequest.responseJSON.message;
                    }else{
                    	message = "ajax调用失败";
                    }
                    alert(message);
                }
            });  
     		 
    	 }
    	 
     },
     fileUploadAjax : function(url, fileId, param, callback, success, error) {  
    	 if(layerFlg==0){
    		 //制御 铺层
     		 common.layerHtml();
     		$.ajaxFileUpload({
                url: url, //用于文件上传的服务器端请求地址
                secureuri: false, //是否需要安全协议，一般设置为false
                fileElementId: fileId, //文件上传域的ID
                global:false,
                data: param,
                type : 'post',
                dataType: 'json', //返回值类型 一般设置为json
                success: function (data, status){  //服务器成功响应处理函数
                	//删除铺层
                    common.removeLayerHtml();
               	 	if(callback!==undefined){
               	 		callback(data);
     		       	 }
               	 if(data['error']==true){
               		if(data['errorCode']==='101'){
         	        		window.top.location = contextPath+"/account/login/show.html";
         	        	}else{
             	        	if(error!==undefined){
             	        		error(data);
             		       	}
         	        	}
        	         }else{
         		       	if(success!==undefined){
         		       		success(data);
         		       	}
        	         }
    	        },
    	        error:  function(XMLHttpRequest, textStatus, errorThrown) {
    	        	//删除铺层
                    common.removeLayerHtml();
                    var message;
                    if(XMLHttpRequest.responseJSON){
                    	message= XMLHttpRequest.responseJSON.message;
                    }else{
                    	message = "ajax调用失败";
                    }
                    alert(message);
                }
            });
    	 }
    	 
     }
	
});