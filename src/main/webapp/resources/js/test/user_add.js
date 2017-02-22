$(document).ready(function(){
	// 日期绑定
    $('.form_date').datetimepicker({
        language:  'zh-CN',
        todayBtn:  0,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,		//开始视图是日
		minView: 0,			//最小小时
    });
    
    //validationCheck
    $("#leaveFrom").validationEngine({
    	promptPosition:"centerRight"
    });
    
    //提交请假表单
    $('#leaveSubmit').bind('click',leaveSubmit);
    

    
});
