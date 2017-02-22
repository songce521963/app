$(document).ready(function() {
	// 1.初始化Table
	var oTable = new TableInit();
	oTable.Init();

	common.commonFormatNumber();
});

// 建立table对象
var TableInit = function() {
	var oTableInit = new Object();
	// 初始化Table
	oTableInit.Init = function() {
		$('#orderDetailListTbl').tablePage({
			url : contextPath + '/order/order_detail_list_query',
			search : false,
			params : function(params) {
				var base = {
					pageSize : params.limit, // 页面大小
					pageNum : params.pageNumber, // 页码
					search : params.search, // 查询条件
					orderId : $("#orderId").val()
				}
				return base;
			},
			columns : [ {
				title : '商品编号',
				halign : 'center',
				field : 'goodsId',
				align : 'center',
				width : '10%',
				formatter : searchDetail
			}, {
				title : '商品名称',
				halign : 'center',
				field : 'goodsName',
				align : 'center',
				width : '10%'
			}, {
				title : '商品规格',
				halign : 'center',
				field : 'spec',
				align : 'center',
				width : '10%'
			}, {
				title : '商品买入价',
				halign : 'center',
				field : 'buyingPrice',
				align : 'center',
				width : '10%',
				formatter : formatterDecNum
			}, {
				title : '客户购买单价',
				halign : 'center',
				field : 'price',
				align : 'center',
				width : '10%',
				formatter : formatterDecNum
			}, {
				title : '客户购买数量',
				halign : 'center',
				field : 'quantity',
				align : 'center',
				width : '10%',
				formatter : formatterNum
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

//	function checkGoodsIsExist(value, row, index) {
//		var href;
//		var url = contextPath + "/inventory/check_goods_exist";
//		var data = {
//			goodsId : row['goodsId']
//		};
//		$.getAjax(url, data, undefined, function(data) {
//			if (data == null) {
//				common.addErrorMessage("商品在数据库已经不存在！");
//			} else {
//				href = contextPath + "/inventory/inventory_goods_detail_param/"
//						+ row['goodsId'] + "/order.html";
//
//			}
//		});
//		return [ '<a href="' + href + '">' + value + '</a>' ].join('');
//	}

	// 查询详细
	function searchDetail(value, row, index) {
//		checkGoodsIsExist(value, row, index);
		 var href = contextPath + "/inventory/inventory_goods_detail_param/"
		 + row['goodsId'] + "/order.html";
		
		 return [ '<a href="' + href + '">' + value + '</a>' ].join('');
	}

	// 数字格式化
	function formatterNum(value, row, index) {
		return [ "<span class='commonFormatNumber'>" + value + "</span>" ]
	}

	// 小数格式化
	function formatterDecNum(value, row, index) {
		return [ "<span class='commonFormatNumber' formatDecNum='2'>" + value
				+ "</span>" ]
	}

	return oTableInit;
};