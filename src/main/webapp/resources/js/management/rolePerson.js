$(document).ready(function() {
	//1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
   
    //设置角色资源页面打开的时候，填充数据
    $('#setRolePersonModal').on('show.bs.modal', function(){
    	setRolePersonIframe.location.href="iframe/setRolePerson.html";   
    });
    //设置资源提交时事件
    $('#setRolePersonSubmit').bind('click',setRolePersonSubmit);
    
    //删除权限
    $('#deleteRolePersonSubmit').bind('click',deleteRolePerson);
    
    //删除所有按钮按下
    $('#deleteRolePersonAll').bind('click',deleteRolePersonAll);
    //删除所有被选中的权限
    $('#deleteRolePersonAllSubmit').bind('click',deleteRolePersonAllSubmit);
    
    $('#setRes').on('click',function(){
    	if(roleId==undefined){
    		common.addWarningMessage("请先创建角色！");
    		return;
    	}
    	//显示模态框
        $('#setRolePersonModal').modal('show');
    });
    
});

var roleId;
var userRoleId;

//设置资源提交时事件
function setRolePersonSubmit(){
	//获取iframe里选中的节点
	var person=setRolePersonIframe.window.getSelectionsPserson();
	if(person.length==0){
		common.addWarningMessage("请至少选择一条记录！");
		return;
	}
	var userRoles = new Array();
	for (var int = 0; int < person.length; int++) {
		var userRole = {"userId":person[int].id,"roleId":roleId};
		userRoles.push(userRole);
	}
	var ajaxData={"userRoles": userRoles}
	//执行设置资源事件
	$.jsonAjax("setRolePersonSubmit.html",ajaxData,function(data){
		 //隐藏Modal
     	 $('#setRolePersonModal').modal('hide');
	},function(data){
		//刷新会员列表
		$('#personListTbl').bootstrapTable('refresh');
	});
}

//删除权限
function deleteRolePerson(){
	var userRoleIds = new Array();
	userRoleIds.push(userRoleId);
	deleteRolePersonSubmit(userRoleIds);
}
//删除所有被选中的权限
function deleteRolePersonAllSubmit(){
	var userRoleIds = new Array();
	var selecteds = $('#personListTbl').bootstrapTable('getSelections');
	for ( var i in selecteds) {
		userRoleIds.push(selecteds[i]['userRoleId']);
	}
	deleteRolePersonSubmit(userRoleIds);
}
//删除权限方法
function deleteRolePersonSubmit(userRoleIds){
	var ajaxData={"userRoleIds": userRoleIds};
	//执行设置资源事件
	$.jsonAjax("deleteRolePersonSubmit.html",ajaxData,function(data){
		//隐藏Modal
      	 $('#deleteRolePersonModal').modal('hide');
      	 $('#deleteRolePersonAllModal').modal('hide');
	},function(data){
		//刷新会员列表
		$('#personListTbl').bootstrapTable('refresh');
	});
}

//删除所有按钮按下
function deleteRolePersonAll(){
	var checked = $('#personListTbl').bootstrapTable('getSelections');
	if(checked.length>0){
		$('#deleteRolePersonAllModal').modal('show');
	}else{
		common.addWarningMessage("请选择要删除的用户!");
	}
}

//建立table对象
var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
    	$('#roleListTbl').bootstrapTable({
        url: 'queryRoleList.html',     //请求后台的URL（*）
        method: 'post',           //请求方式（*）
        contentType: 'application/x-www-form-urlencoded',
        striped: true,           //是否显示行间隔色
        clickToSelect: false,        //是否启用点击选中行
        singleSelect : false,     //只能选择一行
        columns: [{
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
              width: '35%'
	     }],
	     onClickRow: function (row, $element, field) {
	    	 $('#roleListTbl .info').removeClass("info");
	    	 $($element).addClass("info");
	    	 roleId = row['id'];
	    	 //刷新角色列表
	         $('#personListTbl').bootstrapTable('refresh');
	     },
	     onLoadSuccess : function(data){
	    	 if(data.length>0){
	    		 roleId=data[0].id;
	    		 $('#roleListTbl tr[data-index=0]').addClass("info");
	    	 }
	    	 //1.初始化Table
	    	 var oTable = new TablePersonInit();
	    	 oTable.Init();
	    	 if(data['error']==true){
		    		if(data['errorCode']==='101'){
	     	        	window.top.location = contextPath+"/account/login/show.html";
	   	        	}else{
	   	        		common.addErrorMessage(data['message']);
	   	        	}
		     }
	     }
      });
    };
    
    return oTableInit;
  };
  
  //建立table对象
  var TablePersonInit = function () {
      var oTableInit = new Object();
      //初始化Table
      oTableInit.Init = function () {
      	$('#personListTbl').bootstrapTable({
          url: 'queryPersonListByRoleId.html',     //请求后台的URL（*）
          method: 'post',           //请求方式（*）
          contentType: 'application/x-www-form-urlencoded',
          queryParams:oTableInit.queryParams,
          striped: true,           //是否显示行间隔色
          cache: false,            //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
          pagination: true,          //是否显示分页（*）
          sortable: false,           //是否启用排序
          sortOrder: "asc",          //排序方式
          sidePagination: "server",      //分页方式：client客户端分页，server服务端分页（*）
          pageSize: 10,            //每页的记录行数（*）
          pageList: [10,50],    //可供选择的每页的行数（*）
          search : true,					//显示serch输入框
          searchAlign:"right",
          paginationPreText:"上一页",
          paginationNextText:"下一页",
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
            width:'28%',
            formatter: function(value, row, index){
            	return "<i class='fa fa-user fa-fw' style='top: 3px;'></i> "+value;
            },
          },{
              title: '人员编号',
              halign:'center',
              field: 'userCode',
              align: 'left',
              width:'28%',
              formatter: function(value, row, index){
              	return "<i class='fa fa-list-alt fa-fw' style='top: 3px;'></i> "+value;
              },
          },{
              title: '所属职位（组织）',
              field: 'orgName',
              halign:'center',
              align: 'left',
              width:'28%',
              formatter: function(value, row, index){
              	  return "<i class='glyphicon glyphicon-education' style='top: 3px;'></i> "+value;
              }
          } ,{
  			field: 'id',
  			halign:'center',
  			title: '操作',
  			align: 'center',
  			formatter: actionFormatter,
  			events : 'actionEvents'
  	     }],
          onLoadSuccess : function(data){
        	  if(data['error']==true){
		    		if(data['errorCode']==='101'){
	     	        	window.top.location = contextPath+"/account/login/show.html";
	   	        	}else{
	   	        		common.addErrorMessage(data['message']);
	   	        	}
		      }
          }
        });
      };
      
      function actionFormatter(value, row, index) {
          return [
    	            '<button type="button" class="remove btn btn-link" style="padding: 0px;margin-right:10px;">',
    	            '<span class="glyphicon glyphicon-remove"></span> 删除',
    	            '</button>'
    	        ].join('');
        };
        
        window.actionEvents = {
        	    'click .remove': function (e, value, row, index) {
        	    	userRoleId=row['userRoleId'];
        	    	$('#deleteRolePersonModal').modal('show');
        	    }
        };
      //得到查询的参数
     oTableInit.queryParams = function (params) {
    	var pageSize = params.limit;  //页面大小
 		var pageNum = params.pageNumber; //页码
    	var search = params.search; //页码
 		var temp = "pageNum="+pageNum+"&pageSize="+pageSize+"&roleId="+roleId+"&search="+search;
  		return temp;
      };
      return oTableInit;
 };
    
    
 