$(document).ready(function(){
	//1.初始化Table
    var otable = new TableInit();
    otable.Init();
    /*//validationCheck
    $("#leaveFrom").validationEngine({
    	promptPosition:"centerRight"
    });
    
    //提交请假表单
    $('#leaveSubmit').bind('click',leaveSubmit);*/
    $('#addUserInfo').bind('click',addUserInfo);
    $('#deleteDo').bind('click',deleteDo);
    
});
var id;
function addUserInfo(){
	location.href="add.html";
}

function deleteDo(){
	deleteUserById(id);
}

//建立table对象
var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
    	$('#userListTbl').bootstrapTable({
        url: 'queryUserList.html',     //请求后台的URL（*）
        method: 'post',           //请求方式（*）
        contentType: 'application/x-www-form-urlencoded',
        toolbar: '#toolbar',        //工具按钮用哪个容器
        striped: true,           //是否显示行间隔色
        cache: false,            //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,          //是否显示分页（*）
        sortable: false,           //是否启用排序
        sortOrder: "asc",          //排序方式
        queryParams: oTableInit.queryParams,//传递参数（*）
        sidePagination: "server",      //分页方式：client客户端分页，server服务端分页（*）
        pageNumber:1,            //初始化加载第一页，默认第一页
        pageSize: 10,            //每页的记录行数（*）
        pageList: [10,50],    //可供选择的每页的行数（*）
        search : true,					//显示serch输入框
        searchAlign:"left",
        showRefresh : false,
        showToggle : false,
        showPaginationSwitch : false,
        strictSearch: true,			//精确查询
        clickToSelect: false,        //是否启用点击选中行
        //height: 560,            //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "id",           //每一行的唯一标识，一般为主键列
        cardView: false,          //是否显示详细视图
        detailView: false,          //是否显示父子表
        paginationPreText:"上一页",
        paginationNextText:"下一页",
        singleSelect : false,     //只能选择一行
        columns: [{
            checkbox:true,
            align: 'center',
            valign: 'middle',
            width: '5%',
	    },{
          title: 'ID',
          halign:'center',
          field: 'id',
          align: 'center',
          width: '10%',
        },{
            title: '姓名',
            halign:'center',
            field: 'name',
            align: 'center',
            width: '10%',
        }, {
            title: '密码',
            halign:'center',
            field: 'password',
            align: 'center',
            width: '10%',
		}, {
            title: '性别',
            halign:'center',
            field: 'sex',
            align: 'center',
            width: '10%',
		}, {
            title: '年龄',
            halign:'center',
            field: 'age',
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
	     }],
	     onLoadSuccess : function(data){
	    	 if(data['error']==true){
	    		//清除之前的信息提示
		         $('#myAlert').alert('close');
		    	 common.addErrorMessage(data['message']);
	    	 }
	    	
	     }
      });
    };
    
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
    	    	var id = row['id'];
    	    	location.href="edit/"+id+".html";
    	    },
    	    'click .remove': function (e, value, row, index) {
    	    	id = row['id'];
    	    	$('#deleteModal').modal('show');
    	    }
    };
    
    function totalNameFormatter(data) {
        return data.length;
    }
    //得到查询的参数
   oTableInit.queryParams = function (params) {
	   var data={
  			 pageSize : params.limit,  
  			 pageNum : params.pageNumber,  
  			 search : params.search, 
  	 	}
		return data;
    };
    return oTableInit;
};

function deleteUserById(id){
	$.ajax({
		type : "post",
		url : "deleteUser.html",
		data : {
			id : id
		},
		success : function(data) {
	         //清除之前的信息提示
	         $('#myAlert').alert('close');
	         if(data['error']==false){
				//添加成功mes
		       	common.addSuccessMessage(data['message']);
		       	//隐藏
		       	$('#deleteModal').modal('hide')
	        	//刷新会员列表
	        	$('#userListTbl').bootstrapTable('refresh');
	         }else{
	        	 common.addErrorMessage(data['message']);
	         }
		}
	});
}
