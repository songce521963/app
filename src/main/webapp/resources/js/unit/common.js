$(function(){
	//设定RequestHeader
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	if((token!=undefined && token!='') && (header!=undefined && header!='')){
		$(document).ajaxSend(function(e, xhr, options) {
			xhr.setRequestHeader(header, token);
		});
	}
	var a = $('input[type=CHECKBOX],input[type=RADIO]').length;
	if(a!==0){
		$('input').iCheck({
			    checkboxClass: 'icheckbox_flat',
			    radioClass: 'iradio_flat'
		});
	}
	
	var layer = $('.submit').length;
	
	if(layer!==0){
		$('.submit').bind('click',function(){
			if(layerFlg==0){
				common.layerHtml();
	        	//提交表单submit事件
	        	$(this).parents('form').submit();
	    	}
		});
	}
	//获取根目录
    contextPath = $("meta[name='contextPath']").attr("content");
});

var layerFlg = 0;
var contextPath;
var common={
	//设置成功message
	addSuccessMessage:function(msg){
		//清除之前的信息提示
        $('#myAlert').alert('close');
	  	var html ='<div ';
	  	html+='id="myAlert" class="alert alert-success fade in col-md-5 col-sm-12 col-xs-12">';
	  	html+='<a href="#" class="close" data-dismiss="alert">&times;</a>';
	  	html+=msg
	  	html+='</div>';  
	  	$('#alert').prepend(html);
	  	setTimeout(function(){
	  		$('#myAlert').alert('close');
	  	},5000);
	  },
	 //设置错误message
	 addErrorMessage: function(megs){
		//清除之前的信息提示
	    $('#myAlert').alert('close');
	  	var msg='';
		if(megs instanceof Array){
			for (var int = 0; int < megs.length; int++) {
				msg += megs[int]+'<br/>'
			}
		}else{
			msg=megs;
		}
		var html ='<div ';
		html+='id="myAlert" class="alert alert-danger fade in col-md-5 col-sm-12 col-xs-12">';
		html+='<a href="#" class="close" data-dismiss="alert">&times;</a>';
		html+=msg
		html+='</div>';  
		$('#alert').prepend(html);
		setTimeout(function(){
	  		$('#myAlert').alert('close');
	  	},5000)
	  },
	   //设置错误message
	   addWarningMessage: function(megs){
			//清除之前的信息提示
		    $('#myAlert').alert('close');
		  	var msg='';
			if(megs instanceof Array){
				for (var int = 0; int < megs.length; int++) {
					msg += megs[int]+'<br/>'
				}
			}else{
				msg=megs;
			}
			var html ='<div ';
			html+='id="myAlert" class="alert alert-warning fade in col-md-5 col-sm-12 col-xs-12">';
			html+='<a href="#" class="close" data-dismiss="alert">&times;</a>';
			html+=msg
			html+='</div>';  
			$('#alert').prepend(html);
			setTimeout(function(){
		  		$('#myAlert').alert('close');
		  	},5000)
		  },
	  //填充model数据
	  setModelFormData : function(formId,row){
		  	//清除之前数据
		    common.removeModelFormData(formId);
		    var form = $('#'+formId);
		    //form的name属性对应的值
		    var name;
		    //对象的个数
		    var count;
		    // 选取input类型的对象
		    var jDom;
		    //input[type=text],input[type=hidden] 内容填充
			form.find('input[type=text],input[type=hidden]').each(function(i,e){
				name = $(this).attr('name');
				$(this).val(row[name]);
			});
			//input[type=radio] 内容填充
			jDom = form.find('input[type=radio]');
			count = jDom.length;
			if(count>0){
				jDom.each(function(i,e){
					name = $(this).attr('name');
					var val = row[name];
					var value = $(this).val();
					if(val===value){
						$(this).prop('checked', true);
						$(this).parent().addClass('checked');
					}else{
						$(this).removeAttr("checked");
						$(this).parent().removeClass('checked');
					}
				});
			}
			//设置checkbox 内容填充
			jDom = form.find('input[type=checkbox]');
			count = jDom.length;
			if(count>0){
				jDom.each(function(i,e){
					//TODO
				});
			}
			//设置textarea 内容填充
			jDom = form.find('textarea');
			count = jDom.length;
			if(count>0){
				jDom.each(function(i,e){
					name = $(this).attr('name');
					$(this).val(row[name]);
				});
			}
			
			
			//设置select 内容填充
			jDom = form.find('select');
			count = jDom.length;
			if(count>0){
				jDom.each(function(i,e){
					name = $(this).attr('name');
					$(this).val(row[name]);
				});
			}
			//TODO
	  },
	  //清空model数据
	  removeModelFormData :function(formId){
		  	var form = $('#'+formId);
		  	//form的name属性对应的值
		    var name;
		    //对象的个数
		    var count;
		    // 选取input类型的对象
		    var jDom;
		    //input[type=text],input[type=hidden] 内容清除
			form.find('input[type=text],input[type=hidden]').each(function(i,e){
				$(this).val('');
			});
			//设置radio 的默认值
			jDom = form.find('input[type=radio]')
			count = jDom.length;
			if(count>0){
				jDom.each(function(i,e){
					if(i==0){
						name = $(this).attr('name');
						$(this).prop('checked', true);
						$(this).parent().addClass('checked');
					}else{
						var nexName= $(this).attr('name');
						if(name!==nexName){
							name = $(this).attr('name');
							$(this).prop('checked', true);
							$(this).parent().addClass('checked');
						}else{
							$(this).removeAttr("checked");
							$(this).parent().removeClass('checked');
						}
					}
				});
			}
			//设置checkbox 内容清除
			jDom = form.find('input[type=checkbox]');
			count = jDom.length;
			if(count>0){
				jDom.each(function(i,e){
					//TODO
				});
			}
			
			//设置textarea 内容填充
			jDom = form.find('textarea');
			count = jDom.length;
			if(count>0){
				jDom.each(function(i,e){
					$(this).val('');
				});
			}
			
			//设置select 内容清除
			jDom = form.find('select');
			count = jDom.length;
			if(count>0){
				jDom.each(function(i,e){
					name = $(this).attr('name');
					$(this).find('option:first').prop("selected", 'selected');
				});
			}
			//设置password 内容清除
			jDom = form.find('input[type=password]');
			count = jDom.length;
			if(count>0){
				jDom.each(function(i,e){
					$(this).val('');
				});
			}
			
			//TODO
			
			//清除错误信息
			form.validationEngine('hide');
	  },
	  addCustomCheck : function(options){
		  $.extend($.validationEngineLanguage.allRules, options); 
	  },
	  
	  // 数字类型格式化
	  commonFormatNumber : function() {
	      var tempFormatNumber = function tempFormatNumber(n, formatDecNum){
	          if (n == '') {
	              return '';
	          }
	          
	          // 取负号
	          var negative = "";
	          // 负号处理
	          if (n.substring(0, 1) == "-") {
	              negative = "-";
	          }
	          
              // 只留逗号小数点
              var b = n.replace(/[^\d^\.]+/gm,'');
              
              // 整数位
              var intNum = "";
              
              // 小数位
              var decimalNum = "";
              
              var num = b.split(".");
              
              if (num.length > 1) {
                  for (var i = 0;  i < num.length - 1; i++) {
                      // 获取整数位
                      intNum += num[i].toString();
                  }
              } else {
                  intNum = num[0].toString();
              }
              
              // 去首位0
              intNum = intNum.replace(/^[0]+/,'');
              
              // 获取小数位
              if (formatDecNum == 0) {
                  decimalNum = "";
              } else {
                  if (num.length > 1) {
                      decimalNum = "." + num[num.length - 1];
                  } else {
                      decimalNum = ".";
                  }
                  
                  formatDecNum = parseInt(formatDecNum, 10);
                  
                  // 小数位差值
                  var tempNum = formatDecNum - decimalNum.length + 1;
                  
                  if (tempNum > 0) {
                      // 位数不够补全0
                      for (var i = 0; i < tempNum; i++) {
                          decimalNum += "0";
                      }
                  } else {
                      decimalNum = decimalNum.substring(0, formatDecNum + 1);
                  }
              }
              
              // 整数位加逗号
              var len = intNum.length;
                
              var firstLen = len % 3;
              var arg = intNum.split('');
              var ret = "";
                
              for (var i = 0; i < arg.length; i++) {
                  if (i == firstLen && i != 0) {
                      ret += ",";
                  }
                    
                  if (i - firstLen >= 3 && (i - firstLen) % 3 == 0) {
                      ret += ",";
                  }
                    
                  ret += arg[i].toString();
              }
              
              if (ret == "") {
                  ret = "0";
              }
              
              var result = ret + decimalNum;
              
              if (result == "0.00") {
                  return 0;
              } else {
                  return negative + ret + decimalNum;
              }
          };
	      
	      $(".commonFormatNumber").each(function(index, element) {
	          // 小数位数
              var formatDecNum = $(this).attr("formatDecNum");
              
              if (formatDecNum == undefined || formatDecNum == 'undefined') {
                  formatDecNum = 0;
              }
              
              // input标签
              if ($(element).is('input')) {
                  $(element).val(tempFormatNumber($(element).val(), formatDecNum));
                  
                  $(element).blur(function() {
                      $(element).val(tempFormatNumber($(element).val(), formatDecNum));
                  });
              }
              
              // span
              else if ($(element).is('span')) {
                  $(element).html(tempFormatNumber($(element).html(), formatDecNum));
              }
	      });
	  }, 
	  commonFormatRemoveComma : function() {
	      $("input.commonFormatNumber").each(function(index, element) {
              $(element).val($(element).val().replace(new RegExp(',','gm'),''));
          });
	  },
	  //铺层用
	  layerHtml : function(){
		  	layerFlg=1;
		    var height = $(document.body).outerWidth(true);
			var width = $(window).width();
			var html = '<div id="layer" style="position:fixed;z-index:99998;left:0px;top:0px;opacity: 0;background-color:#333;width:'+width+'px;height:'+height+'px;">'+
					'</div>';
			$('body').append(html);
			//禁用1秒
	      	setTimeout(function(){
	      		layerFlg=0;
	      	}, 1000);
	  },
	  //解层用
	  removeLayerHtml : function(){
		  	$('#layer').remove();
	  }
}