<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>人员管理</title>
		<link href="${pageContext.request.contextPath }/resources/bootstrap/css/bootstrap-table.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath }/resources/bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath }/resources/validationEngine/css/validationEngine.jquery.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath }/resources/css/test/user_list.css" rel="stylesheet">
		<!--js-->
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap-table.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap-table-zh-CN.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/validationEngine/js/jquery.validationEngine.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/validationEngine/js/jquery.validationEngine-zh_CN.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/test/user_list.js"></script>
	</head>
<body>
<!-- 头部 -->
	<div id="alert">
		<c:if test="${message!=''}">
			<div id="myAlert" class="alert alert-success">
			   <a href="#" class="close" data-dismiss="alert">&times;</a>
			   <strong>成功！</strong>${message}
			</div>
		</c:if>
	</div>
	<div class="header">
		<h1 class="page-title">人员管理</h1>
		<ul class="breadcrumb">
			<li><a href="${pageContext.request.contextPath }/account/index/show.html">主页</a> </li>
			<li class="active">人员管理</li>
        </ul>
	</div>
	<button id="addUserInfo" style="float: right;margin-top:11px;" class="btn  btn-link">
		<span class="glyphicon glyphicon-plus"></span> 添加人员信息
	</button>
    <!-- table -->
	<table id="userListTbl" class="table table-striped"></table>
	
<!-- 模态框（Modal） -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">
               	确认
            </h4>
         </div>
         <div class="modal-body">
				确定要删除吗？
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭
            </button>
            <button id="deleteDo" type="button" class="btn btn-primary">
             		  提交
            </button>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->      
</body>
</html>