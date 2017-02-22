$(document).ready(function(){
	//1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
    
    /*//validationCheck
    $("#leaveFrom").validationEngine({
    	promptPosition:"centerRight"
    });
    
    //提交请假表单
    $('#leaveSubmit').bind('click',leaveSubmit);*/
});
//建立table对象
var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
    	$('#LeaveListTbl').bootstrapTable({
        url: 'queryLeaveBill.html',     //请求后台的URL（*）
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
        pageSize: 20,            //每页的记录行数（*）
        pageList: [20,50],    //可供选择的每页的行数（*）
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
          title: '申请人',
          halign:'center',
          field: 'createUser',
          align: 'center',
          width: '10%',
        },{
            title: '请假是由',
            halign:'center',
            field: 'leaveTypeName',
            align: 'center',
            width: '10%',
        }, {
            title: '开始时间',
            halign:'center',
            field: 'fromTime',
            align: 'center',
            width: '10%',
		}, {
            title: '结束时间',
            halign:'center',
            field: 'endTime',
            align: 'center',
            width: '10%',
		}, {
            title: '请假天数',
            halign:'center',
            field: 'days',
            align: 'center',
            width: '8%',
		}, {
            title: '备注',
            halign:'center',
            field: 'comments',
            align: 'left',
            width: '20%',
		}, {
            title: '申请状态',
            halign:'center',
            field: 'stateName',
            align: 'center',
            width: '10%',
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
    	var state = row['state'];
    	if(state === '01'){
    		return [
    	            '<button type="button" class="edit btn btn-link"  style="padding: 0px;margin-right:10px;">',
    	            '<span class="glyphicon glyphicon-edit"></span> 编辑',
    	            '</button>',
    	            '<button type="button" class="remove btn btn-link" style="padding: 0px;margin-right:10px;">',
    	            '<span class="glyphicon glyphicon-remove"></span> 删除',
    	            '</button>',
    	            '<button type="button" class="apply btn btn-link" style="padding: 0px;margin-right:10px;">',
    	            '<span class="glyphicon glyphicon-share"></span> 申请',
    	            '</button>'
    	        ].join('');
    	}else{
    		return [
    	            '<button type="button" class="search btn btn-link"  style="padding: 0px;margin-right:10px;">',
    	            '<span class="glyphicon glyphicon-search"></span> 查看申请记录',
    	            '</button>'
    	        ].join('');
    	}
      
    };
    
    window.actionEvents = {
    	    'click .edit': function (e, value, row, index) {
    	    },
    	    'click .remove': function (e, value, row, index) {
    	    },
    	    'click .apply': function (e, value, row, index) {
    	    	location.href="apply/"+row['id'];
    	    },
    	    'click .search': function (e, value, row, index) {
    	    	location.href=contextPath+"/activiti/leaveBillAudit/hisRrecord/"+row['id'];
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
