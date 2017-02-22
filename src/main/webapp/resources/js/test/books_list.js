/*       Books_list.js     */

var booksIds;

$(document).ready(function(){
	//初始化Table
	createTable();
	
	//删除图书信息
	$("#deleteDo").bind("click", deleteDo);
	
	// 数字类型格式化
    common.commonFormatNumber();
  
});


//建立table对象
function createTable(){
	$('#booksListTable').tablePage({
		url : 'queryBooks.html',     //请求后台的URL（*）
		search : false,
		params : function (params) {
			var base ={
					pageSize : params.limit,  //页面大小
					pageNum : params.pageNumber, //页码
					search : params.search, //查询条件
					bookSort : $("#bookSort").val(),
					bookNumber :  $("#bookNumber").val(),
					bookName : $("#bookName").val(),
					bookAuthor : $("#bookAuthor").val()
			}
			return base;
	    },
        columns : [ {
            checkbox : true,
            align : 'center',
            valign : 'middle',
            width : '3%',
        }, {
            title : '图书名称',
            halign : 'center',
            field : 'bookName',
            align : 'center',
            width : '15%',
            formatter : onlySearch
        }, {
            title : '图书编号',
            halign : 'center',
            field : 'bookNumber',
            align : 'center',
            width : '10%',
        }, {
            title : '图书作者',
            halign : 'center',
            field : 'bookAuthor',
            align : 'center',
            width : '12%',
        }, {
            title : '所属分类',
            halign : 'center',
            field : 'bookSortInfo',
            align : 'center',
            width : '12%',
        }, {
            title : '图书单价',
            halign : 'center',
            field : 'bookPrice',
            align : 'center',
            width : '10%',
            formatter : formatterNum
        },  {
            title : '进店折扣',
            halign : 'center',
            field : 'bookDiscount',
            align : 'center',
            width : '8%',
        }, {
            title : '图书描述',
            halign : 'center',
            field : 'descriptiondis',
            align : 'center',
            width : '15%',
        }, {
            field : 'action',
            halign : 'center',
            title : '操作',
            align : 'center',
            formatter : actionFormatter,
            events : 'actionEvents'
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
	
	// 操作栏
    function actionFormatter(value, row, index) {
        return [
                '<button type="button" class="edit btn btn-link"  style="padding: 0px;margin-right:10px;">',
                '<span class="glyphicon glyphicon-edit"></span> 编辑',
                '</button>',
                '<button type="button" class="copy btn btn-link" style="padding: 0px;margin-right:10px;">',
                '<span class="glyphicon glyphicon-share"></span> 拷贝',
                '</button>',
                '<button type="button" class="remove btn btn-link" style="padding: 0px;margin-right:10px;">',
                '<span class="glyphicon glyphicon-remove"></span> 删除',
                '</button>' ].join('');
    }    
    window.actionEvents = {
            'click .edit' : function(e, value, row, index) {
                location.href = contextPath
                        + "/test/booksSearchOrEditOrCopy/"
                        + row['uuid'] + "/update.html";
            },
            'click .copy' : function(e, value, row, index) {
                location.href = contextPath
		                + "/test/booksSearchOrEditOrCopy/"
		                + row['uuid'] + "/copy.html";
            },
            'click .remove' : function(e, value, row, index) {
               	booksIds = new Array();
            	booksIds.push(row['uuid']);
                $('#deleteBooksModal').modal('show');
            }
     };
    //查看图书信息
    function onlySearch(value, row, index){
    	var href = contextPath 
    			+ "/test/booksSearchOrEditOrCopy/"
        		+ row['uuid'] +"/search.html";

    	return [ '<a href="' + href + '">' + value + '</a>' ].join('');
    }
    
    // 数字格式化
    function formatterNum(value, row, index) {
        return [ "<span class='commonFormatNumber' formatDecNum='2'>" + value + "</span>" ]
    }
	
};

//查询按钮
function searchBooks(){
	$('#booksListTable').bootstrapTable('refresh');
}

//获取删除checkbox选中数据
function delGrid() {
    var checked = $('#booksListTable').bootstrapTable('getSelections');

    if (checked.length > 0) {
        // 1 显示modal 框
        $('#deleteBooksModal').modal('show');

        // 2 把checked id
        booksIds = new Array();
        for ( var i in checked) {
        	booksIds.push(checked[i].uuid)
        }
    } else {
        alert('请选择要删除的人员！');
    }
}

//删除图书信息
function deleteDo(){
	$.jsonAjax(contextPath + "/test/moveBooksByIds.html",
			booksIds,function(data){
		//隐藏
       	$('#deleteBooksModal').modal('hide')
    	//刷新会员列表
    	$('#booksListTable').bootstrapTable('refresh');
	});	
}


