$(document).ready(function() {
	//获取组织结构树
	searchTree();
    //添加角色页面打开的时候，填充数据
    $('#setOrgRoleModal').on('show.bs.modal', setOrgRoleModal);
    //添加组织角色关系提交事件
    $('#setOrgRoleSubmit').bind('click',setOrgRoleSubmit);
    //删除组织角色关系提交事件
    $('#removeUserRoleSubmit').bind('click',removeUserRoleSubmit);
    
});
//当前Tree对象
var treeObj; 
//当前选中的节点
var node;
//组织角色关系ID
var userRoleId;
//Tree全局设定
var setting = {
	view: {
		selectedMulti: false
	},
    data: {
        simpleData: {
            enable: true
        }
    },
    callback: {
		onClick: zTreeOnClick
	}
};

//组织结构树的初始化操作
function searchTree() {
	//获组织结构取树
	$.getAjax('queryOrgAndUserTree.html',{},undefined,function(data){
		$.fn.zTree.init($("#tree"), setting, data);
		//设置树跟被选中
		treeObj = $.fn.zTree.getZTreeObj("tree");
		var nodes = treeObj.getNodes();
		if (nodes.length>0) {
			//选中
			treeObj.selectNode(nodes[0]);
			node = treeObj.getSelectedNodes()[0];
			//建立table对象
			createTable();
		}
	});
}

//监听组织结构树点击事件
function zTreeOnClick(event, treeId, treeNode){
	treeObj = $.fn.zTree.getZTreeObj("tree");
	node = treeObj.getSelectedNodes()[0];
	//刷新会员列表
	$('#roleListTbl').bootstrapTable('refresh');
}

//设置角色资源页面打开的时候，填充数据
function setOrgRoleModal(){
	setOrgRoleIframe.location.href="iframe/setOrgRole.html";   
}

//设置角色执行页面
function setOrgRoleSubmit(){
	//获取子页面选取的RoleId
	var selected=setOrgRoleIframe.window.getSelectionsRole();
	if(selected.length==0){
		alert("请至少选择一条记录！");
		return;
	}
	var ajaxData={"list": selected,"id":node['id']};
	$.jsonAjax("setOrgRoleSubmit.html",ajaxData,function(data){
		 //隐藏Modal
      	 $('#setOrgRoleModal').modal('hide');
	},function(data){
		//刷新会员列表
    	$('#roleListTbl').bootstrapTable('refresh');
	});
}
//建立table对象
function createTable(){
	$('#roleListTbl').tablePage({
		url : 'queryRoleListByOrgIdOrUserId.html',     //请求后台的URL（*）
		params : params,
		search : false,
		columns: [{
            title: '角色名称',
            halign:'center',
            align: 'left',
            width: '25%',
            formatter: function(value, row, index){
            	var html ="";
            	html+="<i class='glyphicon glyphicon-paperclip' style='top: 3px;'></i> "+row['roleName'];
          	  	return html;
            }
        },{
            title: '角色Key',
            halign:'center',
            align: 'left',
            width: '20%',
            formatter: function(value, row, index){
	            	var html ="";
	            	html+="<i class='glyphicon glyphicon-barcode' style='top: 3px;'></i> "+row['roleKey'];
	          	  	return html;
            }
          }, {
            title: '继承组织',
            halign:'center',
            align: 'left',
            width: '48%',
            formatter: function(value, row, index){
          	  var type = row['orgType'];
          	  if(type!='3'){
          		  var html ="";
	            	  html+="<i class='glyphicon glyphicon-tree-conifer' style='top: 3px;'></i> "+row['orgFname'];
	              	  return html;
          	  }else{
          		  return "-";
          	  }
            }
		},{
			field: 'action',
			halign:'center',
			title: '操作',
			align: 'center',
			formatter: actionFormatter,
			events : 'actionEvents'
	     }],
	     rowStyle: function rowStyle(row, index) {
	    	 var isInh = row['isInh'];
	    	 var type = row['orgType'];
			 if(type!='3' && isInh!='0'){
				 return {
					 	css: {"color": "#C9C9C9"}
			    	 };
			 }else{
				 return {};
			 }
	    	  
	    }
	});
}
function params(params) {
	var base ={
			pageSize : params.limit,  //页面大小
			pageNum : params.pageNumber, //页码
			search : params.search, //查询条件
			id : node['id'],
    		fid : node['orgFid'],
	}
	return base;
}
function actionFormatter(value, row, index) {
	var type = row['orgType'];
	if(type!='3'){
		var isInh = row['isInh'];
		if(isInh==='1'){
			return [
    	            '<button type="button" class="on btn btn-link" style="padding: 0px;">',
    	            '<span class="glyphicon glyphicon-ok-circle" style="top: 2px;"></span> 启用',
    	            '</button>'
    	        ].join('');
		}else if(isInh==='2'){
			return [
    	            '-'
    	        ].join('');
		}else{
			return [
    	            '<button type="button" class="off btn btn-link" style="padding: 0px;">',
    	            '<span class="glyphicon glyphicon-remove-circle" style="top: 2px;"></span> 禁用',
    	            '</button>'
    	        ].join('');
		}
	}else{
		return [
	            '<button type="button" class="remove btn btn-link" style="padding: 0px;">',
	            '<span class="glyphicon glyphicon-remove" style="top: 2px;"></span> 删除',
	            '</button>'
	        ].join('');
	}
	
}

window.actionEvents = {
	    'click .on': function (e, value, row, index) {
	    	onRoleBtnSubmit(row['notInhId']);
	    },
	    'click .off': function (e, value, row, index) {
	    	offRoleBtnSubmit(row['id'],node['id'],node['orgFid']);
	    },
	    'click .remove': function (e, value, row, index) {
	    	userRoleId=row['id'];
	    	$('#removeUserRoleModal').modal('show');
	    }
}
  
//禁用按钮按下
function offRoleBtnSubmit(userRoleId,setOrgId,setOrgFid){
	var data = {
			userRoleId:userRoleId,
			setOrgId:setOrgId,
			setOrgFid:setOrgFid
	};
	$.simpleAjax("offRoleBtnSubmit.html", data ,undefined,function(data){
		//刷新权限列表
    	$('#roleListTbl').bootstrapTable('refresh');
	});
}

//启用按钮按下
function onRoleBtnSubmit(notInhId){
	var data = {id:notInhId};
	$.simpleAjax("onRoleBtnSubmit.html", data ,function(data){
		//隐藏Modal
       	$('#removeUserRoleModal').modal('hide');
	},function(data){
		//刷新权限列表
		$('#roleListTbl').bootstrapTable('refresh');
	});
}

//删除按钮按下
function removeUserRoleSubmit(){
	var data = {
			userRoleId:userRoleId,
			orgFid:node['orgFid']
	};
	$.simpleAjax("removeUserRoleSubmit.html", data ,function(data){
		//隐藏Modal
       	$('#removeUserRoleModal').modal('hide');
	},function(data){
		//刷新权限列表
    	$('#roleListTbl').bootstrapTable('refresh');
	});
}

//子页面获取角色信息
function getOrgRoleTableList(){
	return $('#roleListTbl').bootstrapTable('getData');
}
 