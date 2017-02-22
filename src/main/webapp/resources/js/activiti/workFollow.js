$(function(){
	//1.初始化Table
	createTable();
	//验证
    $("#addWorkFollowFrom").validationEngine("attach");
    //添加流程定义
    $('#addWorkFollowSubmit').bind('click',addWorkFollowSubmit);
    //删除流程定义
    $('#deleteProcessDefSubmit').bind('click',deleteProcessDefSubmit);
});
var deploymentId;
function addWorkFollowSubmit(){
	//如果验证成功，则提交
	if ($('#addWorkFollowFrom').validationEngine('validate')) {
		var data = {
				"filename":$('#filename').val(),
				"_csrf":$('#_csrf').val()
		};
		$.fileUploadAjax('newdeploy.html','file',data,function(data){
			//隐藏导入Modal
        	$('#addWorkFollowModal').modal('hide');
        	//清除之前的信息提示
        	$('#myAlert').alert('close');
		},function(data){
			//添加成功mes
	       	common.addSuccessMessage(data['message']);
	       //刷新会员列表
        	$('#deploymentListTbl').bootstrapTable('refresh');
		},function(data){
			common.addErrorMessage(data['message']);
		});
	}
}

//建立table对象
function createTable(){
	$('#deploymentListTbl').tablePage({
		url : 'queryDepProcessDefinitionList.html',     //请求后台的URL（*）
		params : params,
		columns: [{
            checkbox:true,
            align: 'center',
            valign: 'middle',
            width: '4%',
	     },{
            title: '部署ID',
            field: 'deployId',
            halign:'center',
            align: 'center',
            width: '8%'
          },{
            title: '部署名称',
            field: 'deployName',
            halign:'center',
            align: 'left',
            width: '10%'
          }, {
            title: '流程定义ID',
            field: 'procdefId',
            halign:'center',
            align: 'left',
            width: '10%'
	      },  {
	        title: '流程定义名称',
	        field: 'procdefName',
	        halign:'center',
	        align: 'left',
	        width: '10%'
	      },  {
	        title: '流程定义Key',
	        field: 'procdefKey',
	        halign:'center',
	        align: 'left',
	        width: '5%'
	      },  {
	        title: '流程定义版本',
	        field: 'procdefVersion',
	        halign:'center',
	        align: 'center',
	        width: '2%'
	      }, {
	        title: '流程定义规则文件名',
	        field: 'resourceName',
	        halign:'center',
	        align: 'left',
	        width: '10%'
	      },  {
	        title: '流程定义规则图片名',
	        field: 'dgrmResourceName',
	        halign:'center',
	        align: 'left',
	        width: '10%'
	      }, {
              title: '发布时间',
              field: 'depoyTimeFormat',
              halign:'center',
              align: 'center',
              width: '10%'
          }, {
              title: '操作',
              halign:'center',
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
			'<button type="button" class="look btn btn-link" style="margin-right:10px;padding: 0px;">',
			'<span class="glyphicon glyphicon-search"></span> 查看流程定义图',
			'</button>',
	            '<button type="button" class="remove btn btn-link" style="padding: 0px;">',
	            '<span class="glyphicon glyphicon-remove"></span> 删除',
	            '</button>'
	        ].join('');
};
  
window.actionEvents = {
		'click .look': function (e, value, row, index) {
			$('#searchTaskImg').attr('src',contextPath+"/activiti/workFollow/searchTaskImg.html?deploymentId="+row['deployId']+"&imageName="+row['dgrmResourceName']);
			//$('#getImgModal img').attr('src','/app/resources/diagrams/'+row['dgrmResourceName'])
			$('#getImgModal').modal('show');
	    },
  	    'click .remove': function (e, value, row, index) {
  	    	deploymentId=row['deployId'];
  	    	$('#deleteProcessDefModal').modal('show');
  	    }
};

//删除流程定义
function deleteProcessDefSubmit(){
	var ajaxData = {deploymentId:deploymentId}
	$.jsonAjax("deleteProcessDefinitionByDeploymentId.html",ajaxData,function(data){
		//隐藏Modal
      	$('#deleteProcessDefModal').modal('hide');
	},function(data){
		//刷新会员列表
       	$('#deploymentListTbl').bootstrapTable('refresh');
	});
}
