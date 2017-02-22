$(document).ready(function(){
	//创建列表事件
	createTable();
	//登录提交事件
    $('#addUserSubmit').bind('click',addUserSubmit);
    //更新提交事件
    $('#updateUserSubmit').bind('click',updateUserSubmit);
    //删除确认事件
    $('#deleteDo').bind('click',deleteUserByIds);
    //删除全部按钮事件
    $('#deleteAll').bind('click',deleteAll);
    //添加model 隐藏时需要清除内容
    $('#addModal').on('hidden.bs.modal', function () {
    	common.removeModelFormData('addUserForm');
    })
    
    $('#addUserForm').validationEngine({
    	promptPosition:"centerRight"
    });
});

//删除主键
var ids;

function deleteAll(){
	var checked = $('#userListTbl').bootstrapTable('getSelections');
	if(checked.length>0){
		//1 显示modal 框
		$('#deleteModal').modal('show');
		//2 把checked id 赋值到 ids
		//清空 ids
		ids = new Array();
		for ( var i in checked) {
			ids.push(checked[i].id)
		}
	}else{
		alert('请选择要删除的人员！');
	}
}

//修改
function updateUserSubmit(){
	$.formAjax("editUser.html","editUserForm",function(data){
		 //隐藏Modal
      	 $('#editModal').modal('hide');
	},function(data){
		//刷新列表
	     $('#userListTbl').bootstrapTable('refresh');
	});
}
function addUserSubmit(){
	$.formAjax("addUser.html","addUserForm",function(data){
		 //隐藏Modal
     	 $('#addModal').modal('hide');
	},function (data){
		 //刷新列表
	     $('#userListTbl').bootstrapTable('refresh');
	});
}

function deleteUserByIds(){
	$.jsonAjax('deleteUser.html',ids,function(data){
		//隐藏
       	$('#deleteModal').modal('hide')
	},function(data){
		//刷新会员列表
    	$('#userListTbl').bootstrapTable('refresh');
	});
}

//建立table对象
function createTable(){
	$('#userListTbl').tablePage({
		url : 'queryUserList.html',     //请求后台的URL（*）
		params : params,
		columns: [{
          checkbox:true,
          align: 'center',
          valign: 'middle',
          width: '5%',
	    },{
        title: 'ID',
        halign:'center',
        field: 'uuid',
        align: 'center',
        width: '10%',
      },{
          title: '姓名',
          halign:'center',
          field: 'uName',
          align: 'center',
          width: '10%',
      }, {
          title: '密码',
          halign:'center',
          field: 'uPassword',
          align: 'center',
          width: '10%',
		}, {
          title: '性别',
          halign:'center',
          field: 'uSex',
          align: 'center',
          width: '10%',
		}, {
          title: '年龄',
          halign:'center',
          field: 'uAge',
          align: 'center',
          width: '8%',
		}, {
          title: '班级',
          halign:'center',
          field: 'uClass',
          align: 'left',
          width: '20%',
		},{
			field: 'action',
			halign:'center',
			title: '操作',
			align: 'center',
			formatter: actionFormatter,
			events : 'actionEvents'
	     }]
	});
}

function params(params) {
	var base ={
			pageSize : params.limit,  //页面大小
			pageNum : params.pageNumber, //页码
			search : params.search, //查询条件
	}
	return base;
}

function actionFormatter(value, row, index) {
	return [
			'<button type="button" class="edit btn btn-link"  style="padding: 0px;margin-right:10px;">',
			'<span class="glyphicon glyphicon-edit"></span> 编辑',
			'</button>',
			'<button type="button" class="remove btn btn-link" style="padding: 0px;margin-right:10px;">',
			'<span class="glyphicon glyphicon-remove"></span> 删除',
			'</button>'
      ].join('');

};
window.actionEvents = {
	    'click .edit': function (e, value, row, index) {
	    	//修改时，数据填充
	    	common.setModelFormData('editUserForm',row)
	    	$('#editModal').modal('show');
	    },
	    'click .remove': function (e, value, row, index) {
	    	ids = new Array();
	    	ids.push(row['id']);
	    	$('#deleteModal').modal('show');
	    }
};
