$.fn.tablePage = function (option) {
	var queryParams = function (params) {
		var base ={
				pageSize : params.limit,  //页面大小
				pageNum : params.pageNumber, //页码
				search : params.search, //查询条件
		}
		$.extend(base, option.params); 
		return base;
    };
    
    var DEFAULTPROPERTY={
			method: 'post',           //请求方式（*）
	        contentType: 'application/x-www-form-urlencoded',
	        toolbar: '#toolbar',        //工具按钮用哪个容器
	        striped: true,           //是否显示行间隔色
	        cache: false,            //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
	        pagination: true,          //是否显示分页（*）
	        sortable: false,           //是否启用排序
	        sortOrder: "asc",          //排序方式
	        queryParams: option.params,  //传递参数（*）
	        sidePagination: "server",      //分页方式：client客户端分页，server服务端分页（*）
	        pageNumber:1,            //初始化加载第一页，默认第一页
	        pageSize: 10,            //每页的记录行数（*）
	        pageList: [10,50],    //可供选择的每页的行数（*）
	        search : true,					//显示serch输入框
	        searchAlign:"right",
	        showRefresh : false,
	        showToggle : false,
	        showPaginationSwitch : false,
	        strictSearch: true,			//精确查询
	        clickToSelect: false,        //是否启用点击选中行
	        //height: 560,            //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
	        uniqueId: "id",           //每一行的唯一标识，一般为主键列
	        cardView: false,          //是否显示详细视图
	        detailView: false,          //是否显示父子表
	        paginationPreText:"上一页",
	        paginationNextText:"下一页",
	        singleSelect : false,     //只能选择一行
		    onLoadSuccess : function(data){
		    	 if(data['error']==true){
		    		if(data['errorCode']==='101'){
	     	        	window.top.location = contextPath+"/account/login/show.html";
     	        	}else{
     	        		common.addErrorMessage(data['message']);
     	        	}
		    	 }
		    },
		    onLoadError : function(status,data){
		    	var message;
	            if(data.responseJSON){
	            	message= data.responseJSON.message;
	            }else{
	            	message = "ajax调用失败";
	            }
	            alert(message);
		    }
    }
    $.extend(DEFAULTPROPERTY, option); 
	$(this).bootstrapTable(DEFAULTPROPERTY);
}