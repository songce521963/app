$(document).ready(function(){
	//1.初始化Table
	createTable();
});

//建立table对象
function createTable(){
	$('#historyTaskListTbl').tablePage({
		url : 'queryHistoryTaskList.html',     //请求后台的URL（*）
		params : params,
		columns: [{
            title: '业务名称',
            halign:'center',
            field: 'depName',
            align: 'center',
            width: '12%',
        },{
          title: '任务ID',
          halign:'center',
          field: 'id',
          align: 'center',
          width: '10%',
        },{
            title: '任务名称',
            halign:'center',
            field: 'name',
            align: 'center',
            width: '12%',
        }, {
            title: '结束时间',
            halign:'center',
            field: 'endTime',
            align: 'center',
            width: '12%',
		}, {
            title: '办理人',
            halign:'center',
            field: 'assigneeName',
            align: 'center',
            width: '12%',
		},{
            title: '任务状态',
            halign:'center',
            field: 'deleteReason',
            align: 'center',
            width: '12%',
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
            '<button type="button" class="searchTask btn btn-link" style="padding: 0px;margin-right:10px;">',
            '<span class="glyphicon glyphicon-search"></span> 查看任务',
            '</button>',
            '<button type="button" class="searchImg btn btn-link" style="padding: 0px;margin-right:10px;">',
            '<span class="glyphicon glyphicon-search"></span> 查看当前流程图',
            '</button>'
        ].join('');
};


window.actionEvents = {
	    'click .searchTask': function (e, value, row, index) {
	    	location.href = contextPath+"/activiti/leaveBillAudit/hisRrecord/"+row['businessId']+".html";
	    },
	    'click .searchImg': function (e, value, row, index) {
	    	location.href = contextPath+"/activiti/workFollow/auditShow/"+row['id']+".html";
	    },
};
