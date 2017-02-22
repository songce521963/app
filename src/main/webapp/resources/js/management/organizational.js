$(document).ready(function() {
	//ajaxFormValidation初始化
	init();
	//获取组织结构树
	searchTree();
    
    /**
     * 部门信息处理
     * */
    //添加部门页面打开的时候，填充数据
    $('#addDepModal').on('show.bs.modal', addDepShowModal);
    //添加部门页面关闭的时候，清空错误提示和数据
    $('#addDepModal').on('hidden.bs.modal', addDepClearDataAndError);
    //组织情报更新
    $('#orgEdit').bind('click',orgEdit);
    //更新部门页面打开的时候，填充数据
    $('#updateDepModal').on('show.bs.modal', updateDepShowModal)
    //更新部门页面关闭的时候，清空错误提示和数据
    $('#updateDepModal').on('hidden.bs.modal', updateDepClearDataAndError);
    
    /**
     * 职位信息处理
     * */
    //添加职位页面打开的时候，填充数据
    $('#addPositionModal').on('show.bs.modal', addPositionShowModal)
    //添加职位页面关闭的时候，清空错误提示和数据
    $('#addPositionModal').on('hidden.bs.modal', addPositionClearDataAndError);
    //更新职位页面打开的时候，填充数据
    $('#updatePositionModal').on('show.bs.modal', updatePositionShowModal)
    //更新职位页面关闭的时候，清空错误提示和数据
    $('#updatePositionModal').on('hidden.bs.modal', updatePositionClearDataAndError);
    
    /**
     * 人员信息处理
     * */
    
    //添加人员信息页面打开的时候，填充数据
    $('#addPersonModal').on('show.bs.modal', addPersonShowModal)
    
    //添加人员Modal关闭时清空数据
    $('#addPersonModal').on('hidden.bs.modal', function () {
    		common.removeModelFormData('addPersonFrom')});
    
    //删除组织信息并且删除下面的人员信息
    $('#orgRemove').bind('click',orgRemove);
    $('#removeOrgSubmit').bind('click',removeOrgSubmit);
    
    //删除所有选中的用户
    $('#removeAllUser').bind('click',removeAllUser);
    $('#removeAllUserSubmit').bind('click',removeAllUserSubmit);
    //删除单个用户
    $('#removeUserSubmit').bind('click',removeUserSubmit);
    
    //选中的人员调岗
    $('#moveUser').bind('click',moveUser);
    $('#moveUserSubmit').bind('click',moveUserSubmit);
    $('#moveUserConfirmSubmit').bind('click',moveUserConfirmSubmit);
    
    //组织移动
    $('#moveOrg').bind('click',moveOrg);
    $('#moveOrgSubmit').bind('click',moveOrgSubmit);
    $('#moveOrgConfirmSubmit').bind('click',moveOrgConfirmSubmit);
    
});

//当前Tree对象
var treeObj; 
//当前选中的节点
var node;
//删除的userId
var userId;
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

function init(){
	//添加组织情报formValidation
    $("#addDepFrom").ajaxValidation("addOrgSubmit.html",
    		//成功失败都会执行
    		function(json){
		    	 //隐藏Modal
		      	 $('#addDepModal').modal('hide');
    		},
    		//成功时执行
    		function(json){
    			//添加TreeNode
		    	var aNode = json['obj'];
		    	var treeObj = $.fn.zTree.getZTreeObj("tree");
		      	var selectNode = treeObj.getSelectedNodes()[0];
		      	//刷新Tree
		        var newNode = {id:aNode['id'],pId:aNode['parentId'],name:aNode['orgName'],orgType:aNode['orgType'],orgFid:aNode['orgFid'],orgFname:aNode['orgFname'],parentName:node['name'],comments:aNode['comments'],iconSkin:'dep'};
		        newNode = treeObj.addNodes(selectNode,aNode['index'],newNode);
     });
    
    //更新组织情报formValidation
    $("#updateDepFrom").ajaxValidation("updateOrgSubmit.html",
    		//成功失败都会执行
    		function(json){
		    	 //隐藏Modal
		      	 $('#updateDepModal').modal('hide');
    		},
    		//成功时执行
    		function(json){
    			var uNode = json['obj'];
		       	node.name=uNode.orgName; //修改之后的显示名
		       	node.comments = uNode.comments; //修改之后的描述
		        treeObj.updateNode(node); //更新Tree
     });
    
    //添加组织情报formValidation
    $("#addPositionFrom").ajaxValidation("addOrgSubmit.html",
    		//成功失败都会执行
    		function(json){
		    	 //隐藏Modal
		      	 $('#addPositionModal').modal('hide');
    		},
    		//成功时执行
    		function(json){
    			 var aNode = json['obj'];
		       	 var treeObj = $.fn.zTree.getZTreeObj("tree");
		       	 var selectNode = treeObj.getSelectedNodes()[0];
		       	 //刷新Tree
		         var newNode = {id:aNode['id'],pId:aNode['parentId'],name:aNode['orgName'],orgType:aNode['orgType'],orgFid:aNode['orgFid'],orgFname:aNode['orgFname'],parentName:node['name'],comments:aNode['comments'],iconSkin:'pos'};
		         newNode = treeObj.addNodes(selectNode,-1,newNode);
     });
    
    //更新组织情报formValidation
    $("#updatePositionFrom").ajaxValidation("updateOrgSubmit.html",
    		//成功失败都会执行
    		function(json){
		    	 //隐藏Modal
		      	 $('#updatePositionModal').modal('hide');
    		},
    		//成功时执行
    		function(json){
    			 var uNode = json['obj'];
		       	 node.name=uNode.orgName; //修改之后的显示名
		       	 node.comments = uNode.comments; //修改之后的描述
		         treeObj.updateNode(node); //更新Tree
		         //刷新会员列表
		         $('#userListTbl').bootstrapTable('refresh');
     });
    
    //新增人员身份证号formValidation
    $("#addPersonFrom").ajaxValidation("addPersonSubmit.html",
        	//成功失败都会执行
        	function(json){
    		   	 //隐藏Modal
    		   	 $('#addPersonModal').modal('hide'); 
        	},
        	//成功时执行
        	function(json){
        		//刷新会员列表
            	$('#userListTbl').bootstrapTable('refresh');
    });
    
    //修改人员身份证号formValidation
    $("#updatePersonFrom").ajaxValidation("updatePersonSubmit.html",
    	//成功失败都会执行
    	function(json){
		   	 //隐藏Modal
		   	 $('#updatePersonModal').modal('hide');
    	},
    	//成功时执行
    	function(json){
    		//刷新会员列表
        	$('#userListTbl').bootstrapTable('refresh');
     });
    
}

//组织结构树的初始化操作
function searchTree() {
	//获组织结构取树
	$.getAjax('queryOrgTree.html',{},undefined,function(data){
		$.fn.zTree.init($("#tree"), setting, data); //初始化tree
		//设置树跟被选中
		treeObj = $.fn.zTree.getZTreeObj("tree");
		var nodes = treeObj.getNodes();
		if (nodes.length>0) {
			//选中
			treeObj.selectNode(nodes[0]);
			node = treeObj.getSelectedNodes()[0];
			//获取选中的节点
			$('#searchFrom input[name=orgFid]').val(nodes[0].orgFid);
			//初始化Table
			createTable();
		}
	});
}

//监听组织结构树点击事件
function zTreeOnClick(event, treeId, treeNode){
	treeObj = $.fn.zTree.getZTreeObj("tree");
	node = treeObj.getSelectedNodes()[0];
	//alert(node['id']+'--'+node['pId']+'--'+node['name']+'--'+node['orgFname']+'--'+node['orgFid']+'--'+node['orgType']);
	//刷新会员列表
	$('#searchFrom input[name=orgFid]').val(node.orgFid);
	$('#userListTbl').bootstrapTable('refresh');
  	//设置功能权限
	var type = treeNode.orgType;
	if(type == "2"){
		$('#dep').attr({disabled:"disabled"});
		$('#position').attr({disabled:"disabled"});
	}else{
		$('#dep').removeAttr("disabled");
		$('#position').removeAttr("disabled");
	}
}

//组织情报更新
function orgEdit(){
	var orgEdit = $('#orgEdit');
	var type = node.orgType;
	if(type=="1"){
		$('#updateDepModal').modal('show');
	}else if(type=="2"){
		$('#updatePositionModal').modal('show');
	}else{
		common.addWarningMessage("根节点不能编辑!");
	}
}

//删除所有选中的用户
function removeAllUser(){
	var checked = $('#userListTbl').bootstrapTable('getSelections');
	if(checked.length>0){
		$('#removeAllUserModal').modal('show');
	}else{
		common.addWarningMessage("请选择要删除的用户!");
	}
}

//选中的用户进行调岗
function moveUser(){
	var checked = $('#userListTbl').bootstrapTable('getSelections');
	var moveUser = $('#moveUser');
	if(checked.length>0){
		$('#moveUserModal').modal('show');
		moveUserIframe.location.href="iframe/moveUser.html";
	}else{
		common.addWarningMessage("请选择要调岗的用户!");
	}
}
//组织单位移动
function moveOrg(){
	var type = node.orgType;
	if(type!='0'){
		$('#moveOrgModal').modal('show');
		moveOrgIframe.location.href="iframe/moveOrg.html";
	}else{
		common.addWarningMessage("根节点不能移动!");
	}
}

//删除所有选中的用户
function removeAllUserSubmit(){
	var ids = new Array();
	var checked = $('#userListTbl').bootstrapTable('getSelections');
	for (var int = 0; int < checked.length; int++) {
		ids.push(checked[int].id);
	}
	removeUserInfo(ids);
}
//删除单个用户
function removeUserSubmit(){
	var ids = new Array();
	ids.push(userId);
	removeUserInfo(ids);
}
//删除用户执行事件
function removeUserInfo(ids){
	$.simpleAjax("removeUserSubmit.html",{ids : ids},function(data){
		 //隐藏Modal
      	 $('#removeAllUserModal').modal('hide');
      	 $('#removeUserModal').modal('hide');
	},function(data){
		//刷新会员列表
    	$('#userListTbl').bootstrapTable('refresh');
	});
}

//用户调岗提交
function moveUserSubmit(){
	//获取iframe里选中的节点
	var moveNode=moveUserIframe.window.getSelectNode();
	if(moveNode==undefined){
		alert("请选择要调岗的职位或组织！");
	}else{
		$('#moveUserMessage').text("您确认要把选中的人员移动到【"+moveNode.name+"】吗？");
		$('#moveUserConfirmModal').modal('show');
	}
	
}

//用户调岗执行事件
function moveUserConfirmSubmit(){
	var moveNode=moveUserIframe.window.getSelectNode();
	var checked = $('#userListTbl').bootstrapTable('getSelections');
	var users = new Array();
	var user;
	for ( var i in checked) {
		user={
			id:checked[i].id,
			userName:checked[i].userName
		}
		users.push(user);
	}
	var org = {id:moveNode.id,orgName:moveNode.name,orgFid:moveNode.orgFid,orgFname:moveNode.orgFname};
	var ajaxData={"user": users,"org":org}
	$.jsonAjax("moveUserSubmit.html",ajaxData,function(data){
		//隐藏Modal
      	 $('#moveUserConfirmModal').modal('hide');
      	 $('#moveUserModal').modal('hide');
	},function(data){
		//刷新会员列表
		$('#userListTbl').bootstrapTable('refresh');
	});
}

//移动组织提交
function moveOrgSubmit(){
	//获取iframe里选中的节点
	var moveNode=moveOrgIframe.window.getSelectNode();
	if(moveNode==undefined){
		alert("请选择要移动的组织机构！");
	}else{
		$('#moveOrgMessage').text("您确认要把选中的组织【"+node.name+"】移动到【"+moveNode.name+"】吗？");
		$('#moveOrgConfirmModal').modal('show');
	}
}

//移动组织执行事件
function moveOrgConfirmSubmit(){
	var moveNode=moveOrgIframe.window.getSelectNode();
	var parentNode=node.getParentNode();
	var moveOrg = {id:node.id,orgName:node.name,parentId:node.pId,orgFid:node.orgFid,orgFname:node.orgFname,orgType:node.orgType,parentName:parentNode.name,parentOrgFid:parentNode.orgFid,parentOrgFname:parentNode.orgFname};
	var org = {id:moveNode.id,orgName:moveNode.name,orgFid:moveNode.orgFid,orgFname:moveNode.orgFname};
	var ajaxData={"moveOrg": moveOrg,"org":org}
	$.jsonAjax("moveOrgSubmit.html",ajaxData,function(data){
		 //隐藏Modal
      	 $('#moveOrgConfirmModal').modal('hide');
      	 $('#moveOrgModal').modal('hide');
	},function(data){
		var treeObj = $.fn.zTree.getZTreeObj("tree");
       	//删除要移动的节点以及子节点
       	treeObj.removeNode(node);
       	var targetNode = treeObj.getNodesByParam("id", moveNode.id, null)[0];
       	treeObj.selectNode(targetNode);
		node = treeObj.getSelectedNodes()[0];
       	//新增移动节点以及子节点
       	var uNodes = data['obj'];
       	newNode = treeObj.addNodes(node,-1,uNodes);
	});
}

//组织情报删除
function orgRemove(){
	var type = node.orgType;
	var message;
	if(type=="1"){
		message = "您确定要删除部门：【"+node.name+"】，以及子节点的数据吗？";
		$('#message').text(message);
		$('#removeOrgModal').modal('show');
	}else if(type=="2"){
		message = "您确定要删除职位：【"+node.name+"】，以及子节点的数据吗？";
		$('#message').text(message);
		$('#removeOrgModal').modal('show');
	}else{
		common.addWarningMessage("根节点不能删除!");
	}
}
//添加部门页面 打开时 数据填充
function addDepShowModal(){
	var name = node.name;
	var from =$('#addDepFrom');
	from.find('input').each(function(i,value){
		 var input = $(this);
		 var inputName = input.attr('name');
		  if(inputName!= undefined && inputName!=''){
			  input.val(node[inputName]);
		  }else{
			  input.val('');
		  }
	});
	from.find("input[name='parentId']").val(node.id);
	from.find("input[name='orgType']").val('1');
	from.find('p').html(name);
}

//清空数据和错误提示
function addDepClearDataAndError(){
	 var from =$('#addDepFrom');
	 //其他text的内容设定
	 from.find('input').each(function(i,value){
		 var input = $(this);
		 input.val('');
	 });
	 from.find('textarea[name=comments]').val('');
	 //隐藏错误信息
	 from.validationEngine('hide');
}

//更新部门页面打开的时候，填充数据
function updateDepShowModal(){
	var from =$('#updateDepFrom');
	from.find('input').each(function(i,value){
		 var input = $(this);
		 var inputName = input.attr('name');
		  if(inputName!= undefined && inputName!=''){
			  input.val(node[inputName]);
		  }else{
			  input.val('');
		  }
	});
	from.find('textarea[name=comments]').val(node.comments);
	from.find("input[name='orgName']").val(node.name);
	from.find("input[name='oldOrgName']").val(node.name);
	from.find("input[name='parentId']").val(node.pId);
	from.find('p').html(node.parentName);
}
//更新部门页面关闭的时候，清空错误提示和数据
function updateDepClearDataAndError(){
	 var from =$('#updateDepFrom');
	 //其他text的内容设定
	 from.find('input').each(function(i,value){
		 var input = $(this);
		 input.val('');
	 });
	 from.find("input[name='orgName']").val('');
	 from.find("input[name='parentId']").val('');
	 from.find('textarea[name=comments]').val('');
	 //隐藏错误信息
	 from.validationEngine('hide');
}
//添加职位页面 打开时 数据填充
function addPositionShowModal(){
	var name = node.name;
	var from =$('#addPositionFrom');
	from.find('input').each(function(i,value){
		 var input = $(this);
		 var inputName = input.attr('name');
		  if(inputName!= undefined && inputName!=''){
			  input.val(node[inputName]);
		  }else{
			  input.val('');
		  }
	});
	from.find("input[name='parentId']").val(node.id);
	from.find("input[name='orgType']").val('2');
	from.find('p').html(name);
}

//清空数据和错误提示
function addPositionClearDataAndError(){
	 var from =$('#addPositionFrom');
	 //其他text的内容设定
	 from.find('input').each(function(i,value){
		 var input = $(this);
		 input.val('');
	 });
	 from.find('textarea[name=comments]').val('');
	 //隐藏错误信息
	 from.validationEngine('hide');
}

//更新职位页面打开的时候，填充数据
function updatePositionShowModal(row){
	var from =$('#updatePositionFrom');
	from.find('input').each(function(i,value){
		 var input = $(this);
		 var inputName = input.attr('name');
		  if(inputName!= undefined && inputName!=''){
			  input.val(node[inputName]);
		  }else{
			  input.val('');
		  }
	});
	from.find('textarea[name=comments]').val(node.comments);
	from.find("input[name='orgName']").val(node.name);
	from.find("input[name='parentId']").val(node.pId);
	from.find("input[name='oldOrgName']").val(node.name);
	from.find('p').html(node.parentName);
}

//更新职位页面关闭的时候，清空错误提示和数据
function updatePositionClearDataAndError(){
	 var from =$('#updatePositionFrom');
	 //其他text的内容设定
	 from.find('input').each(function(i,value){
		 var input = $(this);
		 input.val('');
	 });
	 from.find("input[name='orgName']").val('');
	 from.find("input[name='parentId']").val('');
	 from.find('textarea[name=comments]').val('');
	 //隐藏错误信息
	 from.validationEngine('hide');
}

//添加人员页面 打开时 数据填充
function addPersonShowModal(){
	var from =$('#addPersonFrom');
	from.find('p').html(node.name);
	from.find("input[name='orgId']").val(node.id);
	from.find("input[name='orgName']").val(node.name);
	from.find("input[name='userFid']").val(node.orgFid);
	from.find("input[name='userFname']").val(node.orgFname);
}

//清空数据和错误提示
function addPersonClearDataAndError(){
	 var from =$('#addPersonFrom');
	 //其他text的内容设定
	 from.find('input').each(function(i,value){
		 var input = $(this);
		 input.val('');
	 });
	 //隐藏错误信息
	 from.validationEngine('hide');
}

//删除组织信息并且删除下面的人员信息
function removeOrgSubmit(){
	var data = {orgFid : node.orgFid};
	$.simpleAjax('removeOrgSubmit.html',data,function(data){
		//成功失败都会执行
      	 $('#removeOrgModal').modal('hide'); //隐藏Modal
	},function(data){
		//成功时执行
		//删除当前节点
       	treeObj.removeNode(node);
       	//获取父节点对象
       	var parentNode = treeObj.getNodesByParam("id", node.pId, null)[0];
       	//选中删除节点的父节点
		treeObj.selectNode(parentNode);
		//获取选中的全路径
		$('#searchFrom input[name=orgFid]').val(parentNode.orgFid);
    	//刷新会员列表
    	$('#userListTbl').bootstrapTable('refresh');
    	//设定当前选中节点
    	node = treeObj.getSelectedNodes()[0];
	});
}

//建立table对象
function createTable(){
	$('#userListTbl').tablePage({
		url : 'queryUserJson.html',     //请求后台的URL（*）
		params : params,
		columns: [{
            checkbox:true,
            align: 'center',
            valign: 'middle',
            width: '5%',
	    },{
          title: '基本信息',
          halign:'center',
          align: 'left',
          width: '20%',
          formatter: function (value, row, index){
        	  return [	'<button type="button" class="showDeal btn btn-link" style="padding: 0px;">',
			            '<span class="fa fa-user fa-fw"></span> '+row['userName'],
			            '</button>',
			            '</br><i class="fa fa-list-alt fa-fw"></i> '+row['userCode']
        	  	].join('');
          },
		  events : 'actionEvents'
        }, {
            title: '联系方式',
            halign:'center',
            align: 'left',
            width: '25%',
            formatter: function (value, row, index){
            	var email = row['email']?row['email']:'-';
            	var phone = row['phone']?row['phone']:'-';
          	  return "<i class='fa fa-envelope-o fa-fw'></i> "+email+"</br><i class='glyphicon glyphicon-phone fa-fw'></i> "+phone;
            },
        }, {
            title: '所在职位(部门)',
            halign:'center',
            align: 'left',
            width: '42%',
            formatter: function (value, row, index){
            	  return "<i class='glyphicon glyphicon-education'></i> "+row['orgName']+"</br><i class='glyphicon glyphicon-tree-conifer'></i> "+row['userFname'];
              },
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
			orgFid:$('#searchFrom input[name=orgFid]').val()
	}
	return base;
}
function actionFormatter(value, row, index) {
    return [
	            '<button type="button" class="edit btn btn-link" style="padding: 0px;">',
	            '<span class="glyphicon glyphicon-edit"></span> 编辑',
	            '</button>',
	            '<button type="button" class="remove btn btn-link" style="padding: 0px;">',
	            '<span class="glyphicon glyphicon-remove"></span> 删除',
	            '</button>'
	        ].join('');
  };
  
  window.actionEvents = {
  	    'click .edit': function (e, value, row, index) {
  	    	//填充数据
  	    	common.setModelFormData('updatePersonFrom',row);
  	    	showEidtPopup('updatePersonFrom',row);
  	    	//显示模态框
  	        $('#updatePersonModal').modal('show');
  	    },
  	    'click .remove': function (e, value, row, index) {
  	    	userId=row['id'];
  	    	$('#removeUserModal #message').text("您确认要删除员工【"+row['userName']+"】的信息吗？");
  	    	$('#removeUserModal').modal('show');
  	    },
  	    //选中人员显示人员基本信息
  	    'click .showDeal': function (e, value, row, index) {
  	    	//填充数据
  	    	common.setModelFormData('userNameInfoFrom',row);
  	    	showEidtPopup('userNameInfoFrom',row);
  	    	//显示模态框
  	        $('#userNameInfoModal').modal('show');
	    },
  	    
 };

//更新人员页面 打开时 数据填充
function showEidtPopup(formId,row){
  	  var from =$('#'+formId);
  	  var html = "<i class='fa fa-user fa-fw'></i> "+row['userName']+"&nbsp;&nbsp;&nbsp;<i class='fa fa-list-alt fa-fw'></i> "+row['userCode'];
  	  html=html+"&nbsp;&nbsp;&nbsp;<i class='glyphicon glyphicon-education'></i> "+row['orgName'];
  	  html=html+"</br><i class='glyphicon glyphicon-tree-conifer'></i> "+row['userFname'];
	  //用户基本信息
	  from.find('.userBass').html(html);
	  from.find('#oldFieldValue').val(row['cardId']);
}

//添加自定义check
common.addCustomCheck({
	"checkAddDepNameIsExist" : {
		"url" : "checkDepNameIsExist.html",
		// you may want to pass extra data on the ajax call
		"extraData" : "checkType=add",
		"extraDataDynamic" : ['#parentId','#orgType' ],
		"alertText" : "* 当前节点部门名称已经存在,请重新输入部门名称！",
		"alertTextLoad" : "* 正在确认当前节点部门名称是否已经存在，请稍等。"
	},
	"checkUpdateDepNameIsExist" : {
		"url" : "checkDepNameIsExist.html",
		// you may want to pass extra data on the ajax call
		"extraData" : "checkType=update",
		"extraDataDynamic" : ['#oldFieldValue','#parentId','#orgType' ],
		"alertText" : "* 不能修改成当前节点已存在的部门,请重新输入部门名称！",
		"alertTextLoad" : "* 正在确认当前节点部门名称是否已经存在，请稍等。"
	},
	"checkAddCardId" : {
		"url" : "checkCardId.html",
		// you may want to pass extra data on the ajax call
		"extraData" : "checkType=add",
		/*"extraDataDynamic" : ['#oldFieldValue'],*/
		"alertText" : "* 当前身份证号的用户已经存在,请重新输入您的身份证号！",
		"alertTextLoad" : "* 正在确认当前身份证号的用户是否已经存在，请稍等。"
	},
	"checkUpdateCardId" : {
		"url" : "checkCardId.html",
		// you may want to pass extra data on the ajax call
		"extraData" : "checkType=update",
		"extraDataDynamic" : ['#oldFieldValue'],
		"alertText" : "* 当前身份证号的用户已经存在,请重新输入您的身份证号！",
		"alertTextLoad" : "* 正在确认当前身份证号的用户是否已经存在，请稍等。"
	}
});