$(document).ready(function() {
	//获取资源结构树
	searchTree();
    //validationCheck
    $("#resourcesFrom").validationEngine();
    
    //添加菜单栏
    $("#menu").bind('click',addMenu);
    //添加页面
    $("#page").bind('click',addPage);
    //添加功能
    $("#function").bind('click',addFunction);
    //添加更新执行事件
    $("#addAndUpdateRes").bind('click',addAndUpdateRes);
    //删除资源
    $("#removeResSubmit").bind('click',removeResSubmit);
    
});
//当前Tree对象
var treeObj; 
//当前选中的节点
var node;
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
	$.getAjax('queryResTree.html',{},undefined,function(data){
		$.fn.zTree.init($("#resources"), setting, data);
		//设置树跟被选中
		treeObj = $.fn.zTree.getZTreeObj("resources");
		var nodes = treeObj.getNodes();
		if (nodes.length>0) {
			//选中
			treeObj.selectNode(nodes[0]);
			node = treeObj.getSelectedNodes()[0];
			setResourcesInfoBySelectNode();
		}
	});
}

//监听组织结构树点击事件
function zTreeOnClick(event, treeId, treeNode){
	treeObj = $.fn.zTree.getZTreeObj("resources");
	node = treeObj.getSelectedNodes()[0];
	/*alert(node['id']+'--'+node['pId']+'--'+node['name']+'--'+node['resLevel']+'--'+node['resType']);*/
	//刷新会员列表
	setResourcesInfoBySelectNode();
  	//设置功能权限
	var type = treeNode.resType;
	if(type == "0"){
		$('#function').attr({disabled:"disabled"});
		$('#menu').removeAttr("disabled");
		$('#page').removeAttr("disabled");
	}else if(type == "1"){
		$('#menu').attr({disabled:"disabled"});
		$('#function').attr({disabled:"disabled"});
		$('#page').removeAttr("disabled");
	}else if(type == "2"){
		$('#menu').attr({disabled:"disabled"});
		$('#page').attr({disabled:"disabled"});
		$('#function').removeAttr("disabled");
	}else{
		$('#menu').attr({disabled:"disabled"});
		$('#page').attr({disabled:"disabled"});
		$('#function').attr({disabled:"disabled"});
	}
	
}

//设置菜单内容
function setResourcesInfoBySelectNode(){
	var from = $('#resourcesFrom');
	from.find('input').each(function(i,value){
		 var input = $(this);
		 var inputName = input.attr('name');
		  if(inputName!= undefined && inputName!=''){
			  if(node[inputName] != undefined && node[inputName] != ''){
				  input.val(node[inputName]);
			  }else{
				  if(inputName=="parentName"){
					  input.val("没有");
				  }else{
					  input.val("");
				  }
			  }
		  }else{
			  input.val("");
		  }
	});
	from.find('input[name=resName]').val(node['name']);
	from.find('input[name=resIcon]').val(node['resIcon']);
	var type =node['resType'];
	$('#resType').val(type);
	$('#isHidden').val(node['isHidden']);
	from.find('input[name=parentId]').val(node['pId']);
	if(node['comments']==undefined){
		from.find('textarea[name=comments]').val('');
	}else{
		from.find('textarea[name=comments]').val(node['comments']);
	}

	var title ="";
	if(type=='0'){
		title="更新菜单Root信息"
	}else if(type=='1'){
		title="更新菜单信息"
	}else if(type=='2'){
		title="更新页面信息"
	}else if(type=='3'){
		title="更新功能信息"
	}
	$('.panel h3').text(title);
	$('#addAndUpdateRes').text("确认更新");
	$('#addAndUpdateRes').removeAttr("disabled");
}

//添加菜单
function addMenu(){
	//设置from内容
	setResourcesInfoByAddBtn("1");
}
//添加页面
function addPage(){
	//设置from内容
	setResourcesInfoByAddBtn("2");
}
//添加功能
function addFunction(){
	//设置from内容
	setResourcesInfoByAddBtn("3");
}
//设置from内容
function setResourcesInfoByAddBtn(type){
	var from = $('#resourcesFrom');
	from.find('input[name=id]').val('');
	from.find('input').each(function(i,value){
		 var input = $(this);
		 var inputName = input.attr('name');
		  if(inputName!= undefined && inputName!=''){
			  input.val("");
		  }
	});
	from.find('input[name=parentName]').val(node['name']);
	from.find('input[name=parentId]').val(node['id']);
	from.find('input[name=resFid]').val(node['resFid']);
	from.find('input[name=resFname]').val(node['resFname']);
	from.find('input[name=resType]').val(type);
	$('#resType').val(type);

	from.find('textarea[name=comments]').val('');
	var title ="";
	if(type=='1'){
		title="添加菜单信息";
		$('#isHidden').val("1");
	}else if(type=='2'){
		title="添加页面信息";
		$('#isHidden').val("1");
	}else if(type=='3'){
		title="添加功能信息";
		$('#isHidden').val("0");
	}
	$('.panel h3').text(title);
	$('#addAndUpdateRes').text("确认添加");
	$('#addAndUpdateRes').removeAttr("disabled");
}

//添加更新操作
function addAndUpdateRes(){
	var from = $('#resourcesFrom');
	//如果验证成功，则提交
	if (from.validationEngine('validate')) {
		//设置按钮禁用
      	$('#addAndUpdateRes').attr({disabled:"disabled"});
		$.ajax({
	        type: "post",
	        url: "addAndUpdateRes.html",
	        data: from.serialize(),
	        success: function(data){
	         //隐藏Modal
	       	 $('#addDepModal').modal('hide');
	         //清除之前的信息提示
	         $('#myAlert').alert('close');
	         if(data['error']==false){
	        	 var aNode = data['obj'];
	        	 //添加成功mes
		       	 common.addSuccessMessage(data['message']);
		       	 var treeObj = $.fn.zTree.getZTreeObj("resources");
		       	 var selectNode = treeObj.getSelectedNodes()[0];
		       	 var id = $('input[name=id]').val();
		       	 if(id==undefined || id==''){
		       		 //添加tree
			         var newNode = {id:aNode['id'],pId:aNode['parentId'],name:aNode['resName'],resType:aNode['resType'],resLevel:aNode['resLevel'],resUrl:aNode['resUrl'],parentName:node['name'],comments:aNode['comments'],isHidden:aNode['isHidden'],resFid:aNode['resFid'],resFname:aNode['resFname']};
			         newNode = treeObj.addNodes(selectNode,aNode['index'],newNode);
		       	 }else{
		       		 //更新tree
			       	 //修改之后的资源名称
			       	 node.name=aNode.resName;
			       	 //修改之后url
			       	 node.resUrl = aNode.resUrl;
			       	 //修改之后level
			       	 node.resLevel = aNode.resLevel;
			       	 //修改之后是否隐藏
			       	 node.isHidden = aNode.isHidden;
			       	 //修改之后的描述
			       	 node.comments = aNode.comments;
			       	 //修改之后是否隐藏
			       	 node.resFid = aNode.resFid;
			       	 //修改之后的描述
			       	 node.resFname = aNode.resFname;
			       	 //修改之后的图标样式
			       	 node.resIcon = aNode.resIcon;
			       	 //更新Tree
			         treeObj.updateNode(node);
		       	 }
	         }else{
	        	 common.addErrorMessage(data['message']);
	         }
	         
	        }
		});
	}
}


//删除资源
function removeResSubmit(){
	$.ajax({
        type: "post",
        url: "removeResSubmit.html",
        data: {resFid:node['resFid']},
        success: function(data){
         //隐藏Modal
       	 $('#removeResModal').modal('hide');
         //清除之前的信息提示
         $('#myAlert').alert('close');
         if(data['error']==false){
        	 var aNode = data['obj'];
        	 //添加成功mes
	       	 common.addSuccessMessage(data['message']);
	         //删除当前节点
	       	 treeObj.removeNode(node);
	       	 //获取父节点对象
	       	 var parentNode = treeObj.getNodesByParam("id", node.pId, null)[0];
	       	 //选中删除节点的父节点
			 treeObj.selectNode(parentNode);
         }else{
        	 common.addErrorMessage(data['message']);
         }
         
        }
	});
}

