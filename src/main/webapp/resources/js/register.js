$(document).ready(function(){
	$("#registerForm").validationEngine({
		ajaxFormValidationMethod :'post',
	});
});

//添加自定义check
//公司名称check
common.addCustomCheck({
	"checkCompanyNameIsExist" : {
		"url" : "checkRegisterCompanyNameIsExist.html",
		// you may want to pass extra data on the ajax call
		"alertText" : "* 您输入的公司名称已经存在，请重新输入！",
		"alertTextLoad" : "* 正在确认您输入的公司名称是否已经存在，请稍等。"
	}
});

//邮箱地址check
common.addCustomCheck({
	"checkEmailIsExist" : {
		"url" : "checkRegisterEmailIsExist.html",
		// you may want to pass extra data on the ajax call
		"alertText" : "* 您输入的郵箱地址已经存在，请重新输入！",
		"alertTextLoad" : "* 正在确认您输入的郵箱地址是否已经存在，请稍等。"
	}
});

//公司英文简称check
//common.addCustomCheck({
//	"checkShortNameEIsExist" : {
//		"url" : "checkRegisterShortNameEIsExist.html",
//		// you may want to pass extra data on the ajax call
//		"alertText" : "* 您输入的公司英文简称已经存在，请重新输入！",
//		"alertTextLoad" : "* 正在确认您输入的公司英文简称是否已经存在，请稍等。"
//	}
//});