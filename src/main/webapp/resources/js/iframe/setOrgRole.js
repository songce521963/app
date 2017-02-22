$(document).ready(function() {
	//1.初始化Table
	createTable();
});

//获取选取的角色对象
function getSelectionsRole(){
	 return $('#roleListTbl').bootstrapTable('getSelections');
}

//建立table对象
function createTable(){
	$('#roleListTbl').tablePage({
		url : contextPath+'/management/orgRole/queryRoleList.html',
		params : params,
		showRefresh : true,
		columns: [{
            checkbox:true,
            align: 'center',
            valign: 'middle',
            width: '5%',
	     },{
            title: '角色名',
            field: 'roleName',
            halign:'center',
            align: 'left',
            width: '35%',
            formatter: function(value, row, index){
          	  return "<i class='glyphicon glyphicon-paperclip' style='top: 3px;'></i> "+value;
            }
          }, {
              title: '角色Key',
              field: 'roleKey',
              halign:'center',
              align: 'left',
              width: '35%',
          }]
	});
}
function params(params) {
	//获取子页面选取的RoleId
	var role = parent.getOrgRoleTableList();
	var strIds="";
		for (var int = 0; int < role.length; int++) {
			if((role[int]['orgType']!='3' && role[int]['isInh']==='0') || (role[int]['orgType']==='3')){
				strIds+=role[int]['roleId']+",";
			}
	}
	var ajaxData={
			pageSize:params.limit,
			pageNum:params.pageNumber,
			search:params.search,
			strIds :strIds
	};
	return ajaxData;
}