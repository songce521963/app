var timeStart;
var timeEnd;
var checkCount = 0;

$(document).ready(function() {
	// 日期插件绑定
	// 日视图
	$('#dayStart').datetimepicker({
		language : 'zh-CN',
		todayBtn : true,
		autoclose : true,
		todayHighlight : true,
		pickerPosition : 'bottom-left',
		startView : 4, // 开始视图是"十年"
		maxView : 4, // 最大视图十年
		minView : 2
	// 最小视图日
	});
	$('#dayEnd').datetimepicker({
		language : 'zh-CN',
		todayBtn : true,
		autoclose : true,
		todayHighlight : true,
		pickerPosition : 'bottom-left',
		startView : 4, // 开始视图是"十年"
		maxView : 4, // 最大视图十年
		minView : 2
	// 最小视图日
	});
	// 月视图
	$('#monthStart').datetimepicker({
		language : 'zh-CN',
		autoclose : true,
		todayHighlight : true,
		pickerPosition : 'bottom-left',
		startView : 4, // 开始视图是"十年"
		maxView : 4, // 最大视图十年
		minView : 3
	// 最小视图月
	});
	$('#monthEnd').datetimepicker({
		language : 'zh-CN',
		autoclose : true,
		todayHighlight : true,
		pickerPosition : 'bottom-left',
		startView : 4, // 开始视图是"十年"
		maxView : 4, // 最大视图十年
		minView : 3
	// 最小视图月
	});
	// 年视图
	$('#yearStart').datetimepicker({
		language : 'zh-CN',
		autoclose : true,
		todayHighlight : true,
		pickerPosition : 'bottom-left',
		startView : 4, // 开始视图是"十年"
		maxView : 4, // 最大视图十年
		minView : 4
	// 最小视图年
	});
	$('#yearEnd').datetimepicker({
		language : 'zh-CN',
		autoclose : true,
		todayHighlight : true,
		pickerPosition : 'bottom-left',
		startView : 4, // 开始视图是"十年"
		maxView : 4, // 最大视图十年
		minView : 4
	// 最小视图年
	});
});

// 参数准备
function params(params) {
	var base = {
		pageSize : params.limit, // 页面大小
		pageNum : params.pageNumber, // 页码
		search : params.search, // 查询条件
		sumWay : document.getElementById("sumWay").value,
		timeStart : timeStart,
		timeEnd : timeEnd,
		orgLevel : document.getElementById("storeSelector").value
	// 店铺级别编号
	}
	return base;
}

// 建立table对象
function createTable() {
	$('#saleSumTbl').tablePage({
	    url : 'sale_list_query.html',
	    search : false,
	    params : params,
	    columns : [ {
	        checkbox : true,
	        align : 'center',
	        valign : 'middle',
	        width : '3%',
	    }, {
	        title : '店铺名称',
	        halign : 'center',
	        field : 'departmentName',
	        align : 'center',
	        width : '10%',
	        formatter : searchDetail
	    }, {
	        title : '时间',
	        halign : 'center',
	        field : 'formatDate',
	        align : 'center',
	        width : '10%'
	    }, {
	        title : '日',
	        halign : 'center',
	        field : 'toDayHide',
	        align : 'center',
	        width : '10%',
	        visible : false
	    }, {
	        title : '周',
	        halign : 'center',
	        field : 'week',
	        align : 'center',
	        width : '10%',
	        visible : false
	    }, {
	        title : '月',
	        halign : 'center',
	        field : 'toMonthHide',
	        align : 'center',
	        width : '10%',
	        visible : false
	    }, {
	        title : '季度',
	        halign : 'center',
	        field : 'quarter',
	        align : 'center',
	        width : '10%',
	        visible : false
	    }, {
	        title : '年',
	        halign : 'center',
	        field : 'year',
	        align : 'center',
	        width : '10%',
	        visible : false
	    }, {
	        title : '订单总数',
	        halign : 'center',
	        field : 'orderCounts',
	        align : 'center',
	        width : '10%',
	        formatter : formatterNum
	    }, {
	        title : '销售总额',
	        halign : 'center',
	        field : 'orderPriceSum',
	        align : 'center',
	        width : '10%',
	        formatter : formatterDecNum
	    }],
	    onLoadSuccess : function(data) {
	    	// 数字格式化
            common.commonFormatNumber();
            
			// 清除之前的信息提示
			if (data['error'] == true) {
				$('#myAlert').alert('close');
				common.addErrorMessage(data['message']);
			}
		}
	});
};

function searchDetail(value, row, index) {
	var sumWay = $('#sumWayHidden').val();
	var href = contextPath + "/sale/sale_detail/" + row['departmentName'] + "/"
			+ row['departmentId'] + "/" + row['year'] + "/" + row['quarter']
			+ "/" + row['toMonthHide'] + "/" + row['week'] + "/" + row['toDayHide']+"/"
			+ sumWay +".html";
//	href =encodeURI(encodeURI(href));

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

// 统计下拉框-触发事件
function gradeChange() {
	var sumWay = document.getElementById("sumWay").value;
	$('#sumWayHidden').val(sumWay);
	if ("01" == sumWay) {
		$("#dayStart").removeClass("hidden");
		$("#dayEnd").removeClass("hidden");
		$("#monthStart").addClass("hidden");
		$("#monthEnd").addClass("hidden");
		$("#yearStart").addClass("hidden");
		$("#yearEnd").addClass("hidden");
	} else if ("02" == sumWay) {
		$("#dayStart").removeClass("hidden");
		$("#dayEnd").removeClass("hidden");
		$("#monthStart").addClass("hidden");
		$("#monthEnd").addClass("hidden");
		$("#yearStart").addClass("hidden");
		$("#yearEnd").addClass("hidden");
	} else if ("03" == sumWay) {
		$("#monthStart").removeClass("hidden");
		$("#monthEnd").removeClass("hidden");
		$("#dayStart").addClass("hidden");
		$("#dayEnd").addClass("hidden");
		$("#yearStart").addClass("hidden");
		$("#yearEnd").addClass("hidden");
	} else if ("04" == sumWay) {
		$("#monthStart").removeClass("hidden");
		$("#monthEnd").removeClass("hidden");
		$("#dayStart").addClass("hidden");
		$("#dayEnd").addClass("hidden");
		$("#yearStart").addClass("hidden");
		$("#yearEnd").addClass("hidden");
	} else if ("05" == sumWay) {
		$("#yearStart").removeClass("hidden");
		$("#yearEnd").removeClass("hidden");
		$("#dayStart").addClass("hidden");
		$("#dayEnd").addClass("hidden");
		$("#monthStart").addClass("hidden");
		$("#monthEnd").addClass("hidden");
	}
}

// 点击"查询"按钮
function checkBtnClick() {
	checkCount += 1;
	var sumWay = document.getElementById("sumWay").value;
	var start;
	var end;
	if ("01" == sumWay || "02" == sumWay) {
		start = $('#dStart').val();
		end = $('#dEnd').val();
	} else if ("03" == sumWay || "04" == sumWay) {
		start = $('#mStart').val();
		end = $('#mEnd').val();
	} else if ("05" == sumWay) {
		start = $('#yStart').val();
		end = $('#yEnd').val();
	}
	var res = compareDate(start, end);
	if (res == false) {
		$('#checkDateModal').modal('show');
	} else {
		showTable(checkCount);
	}
}

function showTable(checkCount) {
	// 时间参数设置
	selection();
	if (checkCount == 1) {
		// 初始化销售Table
		createTable();
	} else {
		// 刷新Table
		$('#saleSumTbl').bootstrapTable('refresh');
	}
}

// 查询条件
function selection() {
	var sumWay = document.getElementById("sumWay");
	var sumSelector = sumWay.options[sumWay.selectedIndex].value;
	if ("01" == sumSelector) {
		timeStart = $('#dStart').val();
		timeEnd = $('#dEnd').val();
	} else if ("02" == sumSelector) {
		var start = $('#dStart').val();
		var end = $('#dEnd').val();
		if (start == "") {
			timeStart = start;
		} else {
			timeStart = getDateOfMonday(start);
		}
		if (end == "") {
			timeEnd = end;
		} else {
			timeEnd = getDateOfSunday(end);
		}
	} else if ("03" == sumSelector) {
		timeStart = $('#mStart').val();
		timeEnd = $('#mEnd').val();
	} else if ("04" == sumSelector) {
		timeStart = $('#mStart').val();
		timeEnd = $('#mEnd').val();
	} else if ("05" == sumSelector) {
		timeStart = $('#yStart').val();
		timeEnd = $('#yEnd').val();
	}
}

// check所选日期的大小（start<=end）
function compareDate(start, end) {
	var d1 = new Date(start);
	var d2 = new Date(end);
	if (start != "" && end != "" && d1 > d2) {
		return false;
	} else {
		return true;
	}
}

// 获得日期所在周的周一的日期
function getDateOfMonday(date) {
	var oneDayLong = 24 * 60 * 60 * 1000;
	var day = new Date(date);
	var dayTime = day.getTime();
	var weekDay = day.getDay();
	var MondayTime = dayTime - (weekDay - 1) * oneDayLong;
	var mm = new Date(MondayTime);
	var monday = mm.getFullYear() + "-" + (mm.getMonth() + 1) + "-"
			+ mm.getDate();
	return monday;
}

// 获得日期所在周的周日的日期
function getDateOfSunday(date) {
	var oneDayLong = 24 * 60 * 60 * 1000;
	var day = new Date(date);
	var dayTime = day.getTime();
	var weekDay = day.getDay();
	var SundayTime = null;
	if (weekDay == 0) {
		SundayTime = dayTime + weekDay * oneDayLong;
	} else {
		SundayTime = dayTime + (7 - weekDay) * oneDayLong;
	}
	var ss = new Date(SundayTime);
	var sunday = ss.getFullYear() + "-" + (ss.getMonth() + 1) + "-"
			+ ss.getDate();
	return sunday;
}
