var goodsIds;
var goodsId;

$(document).ready(function() {
	// 1.初始化Table
	var oTable = new TableInit();
	oTable.Init();

	$("#deleteDo").bind("click", deleteDo);
	$("#deletePhyDo").bind("click", deletePhyDo);
	$("#recoveryDo").bind("click", recoveryDo);

	setTimeout(function() {
		$('#myAlert').alert('close');
	}, 5000);

	// 数字类型格式化
	common.commonFormatNumber();
});

// 建立table对象
var TableInit = function() {
	var oTableInit = new Object();
	// 初始化Table
	oTableInit.Init = function() {
		$('#goodsListTbl').tablePage({
			url : 'inventory_goods_list_query.html',
			search : false,
			params : function(params) {
				var base = {
					pageSize : params.limit, // 页面大小
					pageNum : params.pageNumber, // 页码
					search : params.search, // 查询条件
					goodsName : $("#goodsName").val(),
					batchCode : $("#batchCode").val(),
					spec : $("#spec").val(),
					primaryCategory : $("#primaryCategory").val(),
					smallCategory : $("#smallCategory").val(),
					checkCount : $("#checkCount").is(':checked')
				}
				return base;
			},
			columns : [ {
				checkbox : true,
				align : 'center',
				valign : 'middle',
				width : '3%',
			}, {
				title : '商品名称',
				halign : 'center',
				field : 'goodsName',
				align : 'center',
				width : '10%',
				formatter : searchDetail
			}, {
				title : '商品批号',
				halign : 'center',
				field : 'batchCode',
				align : 'center',
				width : '10%',
			}, {
				title : '商品规格',
				halign : 'center',
				field : 'spec',
				align : 'center',
				width : '10%',
			}, {
				title : '商品所属分类',
				halign : 'center',
				field : 'smallCategoryInfo',
				align : 'center',
				width : '8%',
			}, {
				title : '买入价(元)',
				halign : 'center',
				field : 'buyingPrice',
				align : 'center',
				width : '8%',
				formatter : formatterNum
			}, {
				title : '保底价(元)',
				halign : 'center',
				field : 'sellingPrice1',
				align : 'center',
				width : '8%',
				formatter : formatterNum
			}, {
				title : '标签价(元)',
				halign : 'center',
				field : 'sellingPrice2',
				align : 'center',
				width : '8%',
				formatter : formatterNum
			}, {
				// title : '卖出价3(元)',
				// halign : 'center',
				// field : 'sellingPrice3',
				// align : 'center',
				// width : '8%',
				// formatter : formatterNum
				// }, {
				title : '折扣',
				halign : 'center',
				field : 'discount',
				align : 'center',
				width : '3%',
			}, {
				title : '商品数量',
				halign : 'center',
				field : 'quantity',
				align : 'center',
				width : '5%',
			}, {
				title : '提醒补货数量',
				halign : 'center',
				field : 'replenish',
				align : 'center',
				width : '5%',
			}, {
				field : 'action',
				halign : 'center',
				title : '操作',
				align : 'center',
				formatter : actionFormatter,
				events : 'actionEvents'
			}, {
				title : '删除',
				halign : 'center',
				align : 'center',
				width : '5%',
				formatter : dActionFormatter,
				events : 'events'
			} ],
			onLoadSuccess : function(data) {
				// 数字格式化
				common.commonFormatNumber();

				if (data['error'] == true) {
					// 清除之前的信息提示
					$('#myAlert').alert('close');
					common.addErrorMessage(data['message']);
				}
			}
		});
	};

	// 查询详细
	function searchDetail(value, row, index) {
		var href = contextPath + "/inventory/inventory_goods_detail_param/"
				+ row['goodsId'] + "/search.html";

		return [ '<a href="' + href + '">' + value + '</a>' ].join('');

	}

	// 操作栏1
	function actionFormatter(value, row, index) {
		var retStr = "";
		if (row["isActive"] == "0") {
			retStr = '<button type="button" class="open btn btn-link"  style="padding: 0px;margin-right:10px;">'
					+ '<span class="glyphicon glyphicon-open"></span>重新上架'
					+ '</button>';
			;
		} else {
			retStr = '<button type="button" class="edit btn btn-link"  style="padding: 0px;margin-right:10px;">'
					+ '<span class="glyphicon glyphicon-edit"></span>编辑'
					+ '</button>'
					+ '<button type="button" class="copy btn btn-link"  style="padding: 0px;margin-right:10px;">'
					+ '<span class="glyphicon glyphicon-share"></span>拷贝'
					+ '</button>'
					+ '<button type="button" class="remove-circle btn btn-link"  style="padding: 0px;margin-right:10px;">'
					+ '<span class="glyphicon glyphicon-remove-circle"></span>下架'
					+ '</button>';
		}
		return [ retStr ].join('');
	}

	// 操作栏2
	function dActionFormatter(value, row, index) {
		return [
				'<button type="button" class="remove btn btn-link" style="padding: 0px;margin-right:10px;">',
				'<span class="glyphicon glyphicon-remove"></span> 删除商品',
				'</button>' ].join('');
	}

	// 数字格式化
	function formatterNum(value, row, index) {
		return [ "<span class='commonFormatNumber' formatDecNum='2' >" + value
				+ "</span>" ]
	}

	window.actionEvents = {
		'click .edit' : function(e, value, row, index) {
			location.href = contextPath
					+ "/inventory/inventory_goods_detail_param/"
					+ row['goodsId'] + "/update.html";
		},
		'click .copy' : function(e, value, row, index) {
			location.href = contextPath
					+ "/inventory/inventory_goods_detail_param/"
					+ row['goodsId'] + "/copy.html";
		},
		'click .remove-circle' : function(e, value, row, index) {
			goodsIds = new Array();
			goodsIds.push(row['goodsId']);

			$('#deleteModal').modal('show');
		},
		'click .open' : function(e, value, row, index) {
			goodsId = row["goodsId"];

			$('#recoveryModal').modal('show');
		}
	};

	window.events = {
		'click .remove' : function(e, value, row, index) {
			goodsIds = new Array();
			goodsIds.push(row['goodsId']);
			$('#deletePhyModal').modal('show');
		}
	};

	return oTableInit;
};

// 下架商品信息
function deleteDo() {
	$.jsonAjax(contextPath + "/inventory/inventory_goods_delete.html",
			goodsIds, function(data) {
				// 隐藏
				$('#deleteModal').modal('hide')
				// 刷新商品列表
				$('#goodsListTbl').bootstrapTable('refresh');
			});
}

// 商品重新上架
function recoveryDo() {
	$.jsonAjax(contextPath + '/inventory/recovery_goods.html', {
		goodsId : goodsId
	}, function(data) {
		// 隐藏
		$('#recoveryModal').modal('hide')
	}, function(data) {
		$('#goodsListTbl').bootstrapTable('refresh');
	});
}

// 删除商品信息
function deletePhyDo() {
	$.jsonAjax(contextPath + "/inventory/order_exist_goods.html", goodsIds,
			function(data) {
				$('#deletePhyModal').modal('hide')
			}, function(data) {
				$('#goodsListTbl').bootstrapTable('refresh');
			});
}

// 下架删除checkbox选中数据
function delGrid() {
	var checked = $('#goodsListTbl').bootstrapTable('getSelections');

	if (checked.length > 0) {
		// 1 显示modal 框
		$('#deleteModal').modal('show');

		// 2 把checked id 赋值到 ids
		// 清空 ids
		goodsIds = new Array();
		for ( var i in checked) {
			goodsIds.push(checked[i].goodsId)
		}
	} else {
		alert('请选择要删除的人员！');
	}
}

// 物理删除checkbox选中数据
function delPhy() {
	var checked = $('#goodsListTbl').bootstrapTable('getSelections');

	if (checked.length > 0) {
		// 1 显示modal 框
		$('#deletePhyModal').modal('show');

		// 2 把checked id 赋值到 ids
		// 清空 ids
		goodsIds = new Array();
		for ( var i in checked) {
			goodsIds.push(checked[i].goodsId)
		}
	} else {
		alert('请选择要删除的人员！');
	}
}

// 数据查询按下
function refGrid() {
	// alert($("input[type='checkbox']").is(':checked'));
	$('#goodsListTbl').bootstrapTable('refresh');
}