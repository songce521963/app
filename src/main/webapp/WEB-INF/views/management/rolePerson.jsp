<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>按角色授权</title>
		<!-- css -->
		<link href="${pageContext.request.contextPath }/resources/css/management/rolePerson.css" rel="stylesheet">
		<!--js-->
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/management/rolePerson.js"></script>
	</head>
<body>
<!-- 头部 -->
	<div id="alert"></div>
	<div class="header">
		<h1 class="page-title">按角色授权</h1>
		<ul class="breadcrumb">
			<li><a href="${pageContext.request.contextPath }/account/index/show.html">主页</a> </li>
			<li class="active">按角色授权</li>
        </ul>
	</div>
    <!-- 查询角色 -->
    <div class="col-md-5 col-sm-12 col-xs-12" style="padding-top:53px;">
    	<!-- 角色对应的资源 -->
		<table id="roleListTbl" class="table table-striped"></table>
	</div>
	<!--  -->
    <div class="col-md-7 col-sm-12 col-xs-12">
		<div class="btn-group" style="float: left;margin-top:11px;">
		  <button id="setRes" type="button" class="btn btn-link">
		    <span class="glyphicon glyphicon-plus"></span> 设置用户
		  </button>
		  <button id="deleteRolePersonAll" type="button" class="btn btn-link"  class="btn btn-link">
		    <span class="glyphicon glyphicon-remove"></span> 删除所有
		  </button>
		</div>
    	<!-- table -->
		<table id="personListTbl" class="table table-striped"></table>
   	</div>

<!-- 设置角色人员模态框（Modal） -->
<div class="modal fade" id="setRolePersonModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true" style="margin: 0px auto">
   <div class="modal-dialog" style="width: 45%">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">&times;
            </button>
            <h4 class="modal-title" id="myModalLabel">设置角色人员</h4>
         </div>
         <div id="message" class="modal-body" style="height: 65%">
         	<iframe name="setRolePersonIframe" frameborder="0" height="100%" width="100%" marginheight="auto" marginwidth="auto" noresize="noresize"></iframe>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button type="button" id="setRolePersonSubmit" class="btn btn-primary"> 确认</button>
         </div>
      </div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 删除角色模态框（Modal） -->
<div class="modal fade" id="deleteRolePersonModal" tabindex="-1" role="dialog" 
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
            <button type="button" id="deleteRolePersonSubmit" class="btn btn-primary"> 确认</button>
         </div>
      </div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 删除角色模态框（Modal） -->
<div class="modal fade" id="deleteRolePersonAllModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">&times;
            </button>
            <h4 class="modal-title" id="myModalLabel">确认</h4>
         </div>
         <div id="message" class="modal-body">您确定要删除所有被选中的数据吗？</div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button type="button" id="deleteRolePersonAllSubmit" class="btn btn-primary"> 确认</button>
         </div>
      </div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</body>
</html>