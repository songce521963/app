$(document).ready(function(){
	//ajaxFormValidation初始化
	init();
	
	//编辑公司信息
	$('#editCompany').bind('click',editCompany);
	
	//取消编辑公司信息
	$('#cancelEditCompany').bind('click',setdisplay);
		
});

//编辑公司信息
function editCompany(){	
	 $("#companyForm").find('input[type=text]').each(function(index, element) {
            $(element).attr("disabled", false);
        });
	 $("#companyForm").find('button[type=button]').each(function(index, element) {
         $(element).attr("disabled", false);
     });
}

function init(){
//保存编辑公司信息，check公司工商注册代码
$("#companyForm").ajaxValidation("editCompany.html",
	undefined,
	function(data){
		setdisplay();
	});
}


function setdisplay(){
	$('#companyForm input[type=text]').each(function(e,i){
		$(this).attr("disabled", true);
	});
	$('#companyForm button').each(function(e,i){
		$(this).attr("disabled", true);
	});
	
}
//添加自定义check
common.addCustomCheck({
	"checkCompanyRegisterCode" : {
		"url" : "checkRegisterCode.html",
		// you may want to pass extra data on the ajax call
		"extraDataDynamic" : ['#oldFieldValue'],
		"alertText" : "* 当前公司工商注册代码已经存在,请重新输入您公司的工商注册代码！",
		"alertTextLoad" : "* 正在确认当前工商注册代码的公司是否已经存在，请稍等。"
	},
})
