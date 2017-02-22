$(document).ready(function() {
    // 数字格式化
    common.commonFormatNumber();

    // 1.初始化Table
    var oTable = new TableInit();
    oTable.Init();

    // 日期绑定
    $('.form_date').datetimepicker({
        language : 'zh-CN',
        todayBtn : 0,
        autoclose : 1,
        todayHighlight : 1,
        startView : 2, // 开始视图是日
        minView : 0, // 最小小时
    });
});

// 建立table对象
var TableInit = function() {
    var oTableInit = new Object();
    // 初始化Table
    oTableInit.Init = function() {
        $('#orderListTbl').tablePage({
            url : 'order_list_query',
            search : false,
            params : function(params) {
                var base = {
                    pageSize : params.limit, // 页面大小
                    pageNum : params.pageNumber, // 页码
                    search : params.search, // 查询条件
                    orderId : $("#orderId").val(),
                    customerName : $("#customerName").val(),
                    customerPhone : $("#customerPhone").val(),
                    orderPriceFrom : $("#orderPriceFrom").val(),
                    orderPriceTo : $("#orderPriceTo").val(),
                    status : $("#status").val(),
                    createDateFrom : $("#createDateFrom").val(),
                    createDateTo : $("#createDateTo").val(),
                }
                return base;
            },
            columns : [ {
                title : '订单编号',
                halign : 'center',
                field : 'orderId',
                align : 'center',
                width : '10%',
                formatter : searchDetail
            }, {
                title : '顾客姓名',
                halign : 'center',
                field : 'customerName',
                align : 'center',
                width : '10%',
            }, {
                title : '顾客电话',
                halign : 'center',
                field : 'customerPhone',
                align : 'center',
                width : '10%',
            }, {
                title : '商品总价',
                halign : 'center',
                field : 'goodsPrice',
                align : 'center',
                width : '8%',
                formatter : formatterNum
            }, {
                title : '邮费',
                halign : 'center',
                field : 'postage',
                align : 'center',
                width : '8%',
                formatter : formatterNum
            }, {
                title : '订单总价',
                halign : 'center',
                field : 'orderPrice',
                align : 'center',
                width : '8%',
                formatter : formatterNum
            }, {
                title : '订单状态',
                halign : 'center',
                field : 'statusInfo',
                align : 'center',
                width : '8%',
            }, {
                title : '发起订单日期',
                halign : 'center',
                field : 'createDt',
                align : 'center',
                width : '8%',
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
        var href = contextPath + "/order/order_detail/" + row['orderId']
                + ".html";

        return [ '<a href="' + href + '">' + value + '</a>' ].join('');
    }

    function formatterNum(value, row, index) {
        return [ "<span class='commonFormatNumber' formatDecNum='2'>" + value
                + "</span>" ]
    }

    return oTableInit;
};

// 数据查询按下
function refGrid() {
    // 数字去逗号
    common.commonFormatRemoveComma();

    $('#orderListTbl').bootstrapTable('refresh');
}