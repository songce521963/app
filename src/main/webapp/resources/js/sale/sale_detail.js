$(document).ready(function() {
    // 1.初始化Table
	createTable();
//    var oTable = new TableInit();
//    oTable.Init();

    common.commonFormatNumber();
});

function params(params) {
    var base = {
        pageSize : params.limit, // 页面大小
        pageNum : params.pageNumber, // 页码
        search : params.search, // 查询条件
        companyId : $("#companyId").val(),
        departmentId : $("#departmentId").val(),
        year : $("#year").val(),
        quarter : $("#quarter").val(),
        toMonthHide : $("#toMonthHide").val(),
        week : $("#week").val(),
        toDayHide : $("#toDayHide").val()
    }
    return base;
}
// 建立table对象
 function createTable() {
        $('#saleDetailListTbl').tablePage({
            url : contextPath + '/sale/sale_detail_query',
            search : false,
            params : params,
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
            }, {
                title : '商品销售总额',
                halign : 'center',
                field : 'saleTotals',
                align : 'center',
                width : '10%',
                formatter : formatterDecNum
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

