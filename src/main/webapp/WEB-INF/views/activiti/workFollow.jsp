<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>部署管理</title>
		<link href="${pageContext.request.contextPath }/resources/bootstrap/css/bootstrap-table.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath }/resources/validationEngine/css/validationEngine.jquery.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath }/resources/css/activiti/workFollow.css" rel="stylesheet">
		<!--js-->
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap-table.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap-table-zh-CN.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/validationEngine/js/jquery.validationEngine.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/validationEngine/js/jquery.validationEngine-zh_CN.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/bootstrap/js/ajaxfileupload.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/activiti/workFollow.js"></script>
	</head>
<body>
<!-- 头部 -->
	<div id="alert"></div>
	<div class="header">
		<h1 class="page-title">部署管理</h1>
		<ul class="breadcrumb">
			<li><a href="${pageContext.request.contextPath }/account/index/show.html">主页</a> </li>
			<li class="active">部署管理</li>
        </ul>
	</div>
   	<button style="float: left;margin-top:11px;" class="btn  btn-link" data-toggle="modal"
		data-target="#addWorkFollowModal">
		<span class="glyphicon glyphicon-plus"></span> 部署流程
	</button>
	<!-- table -->
	<table id="deploymentListTbl" class="table table-striped"></table>
	
<!-- 导入模态框（Modal） -->
<div class="modal fade" id="addWorkFollowModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">&times;
            </button>
            <h4 class="modal-title" id="myModalLabel">Excle导入</h4>
         </div>
         <div class="modal-body">
         	<form id="addWorkFollowFrom" class="form-horizontal" role="form">
	         	<div class="form-group">
	         		<label for="firstname" class="col-sm-2 control-label">流程名称</label>
			      	<div class="col-sm-9">
				         <input id="filename" type="text" class="validate[required,maxSize[20]] form-control" name="filename" 
				            placeholder="请输入流程名称">
			      	</div>
			   	</div>
			   	<div class="form-group">
	         		<label class="col-sm-2 control-label">流程文件</label>
			      	<div class="col-sm-9">
				         <input type="file" id="file" name="file"  class="validate[required]"
				            placeholder="请输入流程文件">
			      	</div>
			   	</div>
			   	<input id="_csrf" type="hidden"                        
						name="${_csrf.parameterName}"
						value="${_csrf.token}"/> 
		   	</form>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button type="button" id="addWorkFollowSubmit" class="btn btn-primary"> 导入</button>
         </div>
      </div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- 显示流程定义图 模态框（Modal）-->
<div class="modal fade" id="getImgModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog" style="width:900px;height:500px;">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">&times;
            </button>
            <h4 class="modal-title" id="myModalLabel">流程定义图</h4>
         </div>
         <div class="modal-body">
         	 <img id="searchTaskImg" src="" width="840px" >
         </div>
      </div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- 删除流程定义模态框（Modal） -->
<div class="modal fade" id="deleteProcessDefModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">&times;
            </button>
            <h4 class="modal-title" id="myModalLabel">确认</h4>
         </div>
         <div id="message" class="modal-body">您确定要删除当前数据吗？</div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button type="button" id="deleteProcessDefSubmit" class="btn btn-primary"> 确认</button>
         </div>
      </div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</body>
</html>