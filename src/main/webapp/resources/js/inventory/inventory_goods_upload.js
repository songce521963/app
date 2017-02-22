$(document).ready(function() {
    // 1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
});

var TableInit = function() {
    var oTableInit = new Object();
    // 初始化Table
    oTableInit.Init = function() {
        $('#goodsListTbl').tablePage({
            // url : 'inventory_goods_list_query.html',
            data : [],
            search : false,
            pagination : false,
            columns : [ {
                title : '错误序号',
                halign : 'center',
                field : 'number',
                align : 'center',
                width : '10%'
            }, {
                title : '错误信息',
                halign : 'center',
                field : 'erroMessage',
                align : 'center',
                width : '90%'
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

    return oTableInit;
};

// 图片上传
function uploadFile() {
    if (!commonCheckUtil.checkExcel('file')) {
        return;
    }

    var data = {
        "_csrf" : $('#_csrf').val()
    };
    var url = contextPath + "/inventory/iframe/uploadGoodsInfo.html";
    $.fileUploadAjax(url, 'file', data, undefined, function(data) {
        var messageList = data['messageList'];

        if (messageList.length == 0) {
            messageList[0] = "数据全部导入成功！";
        }

        var erroData = {
            rows : [],
            total : messageList.length
        };

        for (var i = 0; i < messageList.length; i++) {
            erroData.rows.push({
                number : i + 1,
                erroMessage : messageList[i]
            });
        }

        $('#goodsListTbl').bootstrapTable('load', erroData);

        // var oTable = new TableInit();
        // oTable.Init();
    }, function(data) {
        alert(data['message']);
    });
}

// 下载模板
function downLoadTemplate() {
    location.href = contextPath + "/resources/template/GoodsInfo.xlsx";
}