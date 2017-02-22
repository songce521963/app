$(document).ready(function() {
	var resourcesListTbl;
	//1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
    //初始化Table
    var oTableRes = new TableResInit();
    oTableRes.Init();
    //validationCheck
    //添加角色提交事件
    $("#addRoleFrom").ajaxValidation("addRoleSubmit.html",function(json){
    	 //隐藏Modal
      	 $('#addRoleModal').modal('hide');
    },function(json){
        //重新设置角色ID
      	 roleId = json['obj'].id;
      	 //刷新角色列表
      	 $('#roleListTbl').bootstrapTable('refresh');
        //刷新资源列表
      	 $('#resourcesListTbl').bootstrapTable('refresh');
    });
    
    //更细角色提交事件
    $("#updateRoleFrom").ajaxValidation("updateRoleSubmit.html",function(json){
   	 	//隐藏Modal
     	 $('#updateRoleModal').modal('hide');
    },function(json){
     	 //重新设置角色ID
       	 roleId = json['obj'].id;
       	 //刷新角色列表
       	 $('#roleListTbl').bootstrapTable('refresh');
         //刷新资源列表
       	 $('#resourcesListTbl').bootstrapTable('refresh');
    });
    
    //添加角色页面关闭的时候，清空错误提示和数据
    $('#addRoleModal').on('hidden.bs.modal', function () {
    	common.removeModelFormData('addRoleFrom');
    });
    //删除角色
    $('#removeRoleSubmit').bind('click',removeRoleSubmit);
    //设置角色资源页面打开的时候，填充数据
    $('#setRoleResModal').on('show.bs.modal', function(){
    	setRoleResIframe.location.href="iframe/roleRes.html";   
    });
    //设置资源提交时事件
    $('#setRoleResSubmit').bind('click',setRoleResSubmit);
    
    //点击设置资源
    $('#setRes').on('click',function(){
    	if(roleId==undefined){
    		common.addWarningMessage("请先创建角色！");
    		return;
    	}
    	//显示模态框
        $('#setRoleResModal').modal('show');
    });
});

var roleId;

//设置资源提交时事件
function setRoleResSubmit(){
	//获取iframe里选中的节点
	var nodes=setRoleResIframe.window.getSelectNode();
	//编辑参数
	var ajaxData={"roleId": roleId,"nodes":nodes};
	//执行设置资源事件
	$.jsonAjax("setRoleResources.html",ajaxData,function(data){
		 //隐藏Modal
     	 $('#setRoleResModal').modal('hide');
	},function(data){
		//刷新会员列表
		$('#resourcesListTbl').bootstrapTable('refresh');
	});
}

//删除角色信息
function removeRoleSubmit(){
	var data = {roleId:roleId};
	$.simpleAjax("deleteRoleSubmit.html", data ,function(data){
		//刷新角色列表
		$('#deleteRoleModal').modal('hide');
	},function(data){
		//刷新权限列表
    	$('#roleListTbl').bootstrapTable('refresh');
	});
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
              width: '35%',
          },{
			field: 'id',
			halign:'center',
			title: '操作',
			align: 'center',
			formatter: actionFormatter,
			events : 'actionEvents'
	     }],
	     onClickRow: function (row, $element, field) {
	    	 $('#roleListTbl .info').removeClass("info");
	    	 $($element).addClass("info");
	    	 roleId = row['id'];
	    	 $('#setRes').removeAttr("disabled");
	    	 //刷新角色列表
	         $('#resourcesListTbl').bootstrapTable('refresh');
	     },
	     onLoadSuccess : function(data){
	    	 if(data.length>0){
	    		 roleId=data[0].id;
	    		 $('#roleListTbl tr[data-index=0]').addClass("info");
	    	 }else{
	    		 roleId=undefined;
	    	 }
	    	 //刷新角色列表
	    	 $('#resourcesListTbl').bootstrapTable('refresh',{url: 'queryResourcesList.html'});
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
	            '<button type="button" class="edit btn btn-link" style="padding: 0px;margin-right:10px;">',
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
    	    	common.setModelFormData('updateRoleFrom',row)
    	    	$('#oldRoleKey').val(row['roleKey'])
    	    	//显示模态框
    	        $('#updateRoleModal').modal('show');
    	        e.stopPropagation();
    	    },
    	    'click .remove': function (e, value, row, index) {
    	    	roleId=row['id'];
    	    	$('#deleteRoleModal').modal('show');
    	    	e.stopPropagation();
    	    }
    };
    
    return oTableInit;
  };
  
  
//更新人员页面 打开时 数据填充
function showEidtPopup(row){
	  var from =$('#updateRoleFrom');
	  // input 设置
	  from.find('input').each(function(i,value){
	  var input = $(this);
	  var inputName = input.attr('name');
	  if(inputName!= undefined && inputName!=''){
			  input.val(row[inputName]);
		  }
	  });
	  $('#oldRoleKey').val(row['roleKey']);
	  from.find('textarea[name=comments]').val(row['comments']);
}

//建立table对象
  var TableResInit = function () {
      var oTableInit = new Object();
      //初始化Table
      oTableInit.Init = function () {
      	resourcesListTbl =$('#resourcesListTbl').bootstrapTable({
          method: 'post',           //请求方式（*）
          contentType: 'application/x-www-form-urlencoded',
          queryParams:oTableInit.queryParams,
          striped: true,           //是否显示行间隔色
          cache: false,            //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
          sortable: false,           //是否启用排序
          sortOrder: "asc",          //排序方式
          search : true,					//显示serch输入框
          searchAlign:"right",
          paginationPreText:"上一页",
          paginationNextText:"下一页",
          columns: [{
            title: '资源路径名称',
            field: 'resFname',
            halign:'center',
            align: 'left',
            width:'32%',
            formatter: function(value, row, index){
            	return "<i class='glyphicon glyphicon-leaf' style='top: 3px;'></i> "+value;
            },
          },{
              title: '动作资源',
              halign:'center',
              field: 'id',
              align: 'left',
              width:'50%',
              formatter: function(value, row, index){
            	  var data = row['res'];
            	  var html ='';
            	  for(var o in data){  
            		  var name = data[o]['resName'];
            		  html+='<span class="label label-primary" style="padding: .4em .6em .5em;display: inline-block;">'+name+'</span>  ';
            	  }  
              	return html;
              },
          },{
              title: '角色名称',
              field: 'roleName',
              halign:'center',
              align: 'left',
              formatter: function(value, row, index){
              	  return "<i class='glyphicon glyphicon-paperclip' style='top: 3px;'></i> "+value;
              }
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
      
      //得到查询的参数
     oTableInit.queryParams = function (params) {
    	var ajaxData={
    		search :params.search,
    		roleId:roleId
    	}
  		return ajaxData;
      };
      return oTableInit;
 };
 