$(document).ready(function() {
	// ajaxValidation初始化
	init();
	// 创建列表事件
	createTable();
	// 登录提交事件
	/* $('#addMasterDataSubmit').bind('click',addMasterDataSubmit); */
	// 更新提交事件
	$('#updateMasterDataSubmit').bind('click', updateMasterDataSubmit);
	// 删除确认事件
	$('#deleteDo').bind('click', deleteMasterDataByUuids);
	// 删除全部按钮事件
	$('#deleteAll').bind('click', deleteAll);
	// 添加model 隐藏时需要清除内容
	$('#addMasterDataModal').on('hidden.bs.modal', function() {
		common.removeModelFormData('addMasterDataForm');
	})

	$('#editMasterDataForm').validationEngine({
		promptPosition : "centerRight"
	});
});

//添加基础数据信息
function init() {
	$("#addMasterDataForm").ajaxValidation("addMasterData.html",
	// 成功失败都会执行
	function(json) {
		// 隐藏Modal
		$('#addMasterDataModal').modal('hide');
	},
	// 成功时执行
	function(json) {
		// 刷新会员列表
		$('#masterDataListTbl').bootstrapTable('refresh');
	});
}

// 修改
function updateMasterDataSubmit() {
	$.formAjax("editMasterData.html", "editMasterDataForm", function(data) {
		// 隐藏Modal
		$('#editMasterDataModal').modal('hide');
	}, function(data) {
		// 刷新列表
		$('#masterDataListTbl').bootstrapTable('refresh');
	});
}

// 主键
var uuids;

// 批量删除
function deleteAll() {
	var checked = $('#masterDataListTbl').bootstrapTable('getSelections');
	if (checked.length > 0) {
		// 1 显示modal 框
		$('#deleteMasterDataModal').modal('show');
		// 2 把checked uuid 赋值到 uuids
		// 清空 uuids
		uuids = new Array();
		for ( var i in checked) {
			uuids.push(checked[i].uuid)
		}
	} else {
		alert('请选择要删除的人员！');
	}
}

// 单个删除
function deleteMasterDataByUuids() {
	$.jsonAjax('deleteMasterData.html', uuids, function(data) {
		// 隐藏
		$('#deleteMasterDataModal').modal('hide')
	}, function(data) {
		// 刷新基础数据信息列表
		$('#masterDataListTbl').bootstrapTable('refresh');
	});
}

function params(params) {
	var base = {
		pageSize : params.limit, // 页面大小
		pageNum : params.pageNumber, // 页码
		search : params.search, // 查询条件
	}
	return base;
}

// 建立table对象
function createTable() {
	$('#masterDataListTbl').tablePage({
		url : 'queryMasterDataList.html', // 请求后台的URL（*）
		params : params,
		columns : [ {
			checkbox : true,
			align : 'center',
			valign : 'middle',
			width : '5%',
		}, {
			title : '分类区分名',
			halign : 'center',
			field : 'category',
			align : 'center',
			width : '15%',
		}, {
			title : 'Code',
			halign : 'center',
			field : 'keyCd',
			align : 'center',
			width : '6%',
		}, {
			title : '表示值',
			halign : 'center',
			field : 'keyValue',
			align : 'center',
			width : '15%',
		}, {
			title : '表示顺序',
			halign : 'center',
			field : 'dispOrder',
			align : 'center',
			width : '6%',
		}, {
			title : '描述',
			halign : 'center',
			field : 'descriptionDis',
			align : 'left'

		}, {
			field : 'action',
			halign : 'center',
			title : '操作',
			align : 'center',
			width : '10%',
			formatter : actionFormatter,
			events : 'actionEvents'
		} ]
	});
}
function actionFormatter(value, row, index) {
	return [
			'<button type="button" class="edit btn btn-link"  style="padding: 0px;margin-right:10px;">',
			'<span class="glyphicon glyphicon-edit"></span> 编辑',
			'</button>',
			'<button type="button" class="remove btn btn-link" style="padding: 0px;margin-right:10px;">',
			'<span class="glyphicon glyphicon-remove"></span> 删除', '</button>' ].join('');

};
window.actionEvents = {
	'click .edit' : function(e, value, row, index) {
		alert(11111111111);
		// 修改时，数据填充
		common.setModelFormData('editMasterDataForm', row)
		$('#editMasterDataModal').modal('show');
	},
	'click .remove' : function(e, value, row, index) {
		uuids = new Array();
		uuids.push(row['uuid']);
		$('#deleteMasterDataModal').modal('show');
	}
};

// 添加自定义check
// common.addCustomCheck({
// "checkAddKeyCdIsExist" : {
// "url" : "checkKeyCdIsExist.html",
// // you may want to pass extra data on the ajax call
// "alertText" : "* 您输入的Code值已经存在，请重新输入！",
// "alertTextLoad" : "* 正在确认您输入的Code值是否已经存在，请稍等。"
// }
// });

