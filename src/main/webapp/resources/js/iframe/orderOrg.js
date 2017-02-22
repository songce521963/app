$(document).ready(function() {
	index = new BootstrapOrder();
	setOrderOrgList();
});

var order;
var index;
function setOrderOrgList(){
	var nodes = parent.getSelectChildNode();
	var item={};
	for ( var node in nodes) {
		item['id']=node['level'];
		item['name']=node['name'];
		item['num']=node['level'];
		index.addItem(item);
	}
}
