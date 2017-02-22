$(document).ready(function(){
    //提交请假表单
    $('#edit').bind('click',edit);
    $('#editDo').bind('click',editDo);
});

function edit(){
	$('#myModal').modal('show');
}

function editDo(){
	$('#userEditForm').submit();
}