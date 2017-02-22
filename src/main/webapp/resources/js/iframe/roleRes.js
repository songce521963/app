$(document).ready(function() {
	//获取组织结构树
	searchTree();
});
//Tree全局设定
var setting = {
	view: {
		selectedMulti: false
	},
	check: {
		enable: true,
		chkStyle: "checkbox",
		radioType: "all"
	},
    data: {
        simpleData: {
            enable: true
        }
    },
    callback: {
		onClick: zTreeOnClick,
		onCheck: zTreeOnCheck
	}
};
//组织结构树的初始化操作
function searchTree() {
	var data = {roleId : parent.roleId}
	var roleId = parent.roleId;
	var contextPath = $("meta[name='contextPath']").attr("content");
	var url = contextPath+"/management/role/queryResTree.html";
	//获组织结构取树
	$.getAjax(url,data,undefined,function(data){
		$.fn.zTree.init($("#treeDemo"), setting, data);
	});
}

//监听组织结构树点击事件
function zTreeOnClick(event, treeId, treeNode){
	treeObj = $.fn.zTree.getZTreeObj("treeDemo");
	node = treeObj.getSelectedNodes()[0];
	treeObj.checkNode(node, true, true);
}
//监听组织结构树点击radio事件
function zTreeOnCheck(event, treeId, treeNode){
	treeObj = $.fn.zTree.getZTreeObj("treeDemo");
	node = treeObj.getCheckedNodes(true)[0];
	treeObj.selectNode(node);
}
//获取当前选中的节点
function getSelectNode(){
	var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
	var nodes = treeObj.getCheckedNodes(true);
	return nodes;
}

