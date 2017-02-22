$(document).ready(function() {
	//1.初始化Table
	createTable();
});

//获取选取的角色对象
function getSelectionsPserson(){
	 return $('#personListTbl').bootstrapTable('getSelections');
}

//建立table对象
function createTable(){
	$('#personListTbl').tablePage({
		url : contextPath+'/management/rolePerson/queryPersonListByNotRoleId.html',
		params : params,
		showRefresh : true,
		columns: [{
            checkbox:true,
            align: 'center',
            valign: 'middle',
            width: '5%',
        },{
            title: '人员姓名',
            field: 'userName',
            halign:'center',
            align: 'left',
            width:'30%',
            formatter: function(value, row, index){
            	return "<i class='fa fa-user fa-fw' style='top: 3px;'></i> "+value;
            },
          },{
              title: '人员编号',
              halign:'center',
              field: 'userCode',
              align: 'left',
              width:'30%',
              formatter: function(value, row, index){
              	return "<i class='fa fa-list-alt fa-fw' style='top: 3px;'></i> "+value;
              },
          },{
              title: '所属职位（组织）',
              field: 'orgName',
              halign:'center',
              align: 'left',
              width:'30%',
              formatter: function(value, row, index){
              	  return "<i class='glyphicon glyphicon-education' style='top: 3px;'></i> "+value;
              }
          }]
	});
}
function params(params) {
	var ajaxData={
			pageSize:params.limit,
			pageNum:params.pageNumber,
			search:params.search,
			roleId:parent.roleId
	};
	return ajaxData;
}
