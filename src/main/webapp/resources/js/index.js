$(document).ready(function(){
	//修改密码
	$('#updateSubmit').bind('click',updateSubmit);
	//确认修改密码
	$('#updateConfirm').bind('click',updateConfirm);
	//新密码验证
	$('#modifyPasswordForm').validationEngine({
    	promptPosition:"centerRight"
    });
	//关闭模态框时清空数据
	$('#modifyPasswordModal').on('hidden.bs.modal', function () {
    	common.removeModelFormData('modifyPasswordForm')
    });
});
	


$(function() {
       /* var uls = $('.sidebar-nav > ul > *').clone();
        uls.addClass('visible-xs');
        $('#main-menu').append(uls.clone());*/
});

function changeMeun(){
	$('.sidebar-nav .in').collapse('hide');
}

function logOut(){
	$('#logOut').submit();
}

//修改密码
function updateSubmit(){
	var url = contextPath+"/password/newPassword/modifyPassword.html"
	$.formAjax(url,"modifyPasswordForm",function(data){
		 //隐藏Modal
      	 $('#modifyPasswordModal').modal('hide');
	},function(data){
		$('#modifyPasswordConfirmModal').modal('show');
	});
}

//确认修改密码
function updateConfirm(){
	$('#logOut').submit();
}
