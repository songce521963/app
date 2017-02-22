/*       Books_info.js     */
$(document).ready(function() {
	// 数字类型格式化
	common.commonFormatNumber();

	// 查询的情况下，画面内容不可入力
	if ($("#pageFlag").val() == "search") {
		// 查询画面不可入里项目
		$("#boooksForm").find("input").each(function(index, element) {
			$(element).attr("disabled", true);
		});

		$("#boooksForm").find("select").each(function(index, element) {
			$(element).attr("disabled", true);
		});

		$("#boooksForm").find("textarea").each(function(index, element) {
			$(element).attr("disabled", true);
		});

		// 查询画面删除项
		$("#submitBtn").remove();
	} else {
			//图书编号自定义check
			common.addCustomCheck({
				"checkBookNumber" : {
					"url" : contextPath + "/test/checkBookNumber.html",
					//因为book_info.jsp页面是通过传递参数跳转进来的，"/booksSearchOrEditOrCopy/{uuid}/{flag}"
					//所以在ready外面获取不到contextPath路径（参照ready和onloada详解）
					//所以这里要把自定义check放到ready里面
					//"url" : "checkBookNumber.html",
					"extraDataDynamic" : [ '#oldFieldValue', "#uuid","#pageFlag" ],
					"alertText" : "* 您输入的图书编号已经存在,请重新输入！",
					"alertTextLoad" : "* 正在确认您输入的图书编号是否已经存在，请稍等。"
				}
			});
		
		//form提交验证
		$("#boooksForm").validationEngine({
			
			//表单验证通过后执行onSuccess方法
			onSuccess : function() {
				// 为了要封装到bean中，用Integer接收，所以数字去逗号
				common.commonFormatRemoveComma();
			}
		});
	}
});



