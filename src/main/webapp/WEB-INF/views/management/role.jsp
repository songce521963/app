<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>会员查询</title>
		<link href="${pageContext.request.contextPath }/resources/css/management/role.css" rel="stylesheet">
		<!--js-->
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/management/role.js"></script>
	</head>
<body>
<!-- 头部 -->
	<div id="alert"></div>
	<div class="header">
		<h1 class="page-title">角色管理</h1>
		<ul class="breadcrumb">
			<li><a href="${pageContext.request.contextPath }/account/index/show.html">主页</a> </li>
			<li class="active">角色管理</li>
        </ul>
	</div>
    <!-- 查询角色 -->
    <div class="col-md-5 col-sm-12 col-xs-12">
    	<div class="btn-group" style="margin-top:10px;margin-bottom:10px;" >
		  <button id="addRoleBtn" type="button" class="btn btn-link" data-toggle="modal" data-target="#addRoleModal">
		    <span class="glyphicon glyphicon-plus"></span> 新增角色
		  </button>
		</div>
		
    	<!-- 角色对应的资源 -->
		<table id="roleListTbl" class="table table-striped"></table>
	</div>
	<!--  -->
    <div class="col-md-7 col-sm-12 col-xs-12">
		<div class="btn-group" style="float: left;margin-top:11px;">
		  <button id="setRes" type="button" class="btn btn-link">
		    <span class="glyphicon glyphicon-plus"></span> 设置资源
		  </button>
		</div>
    	<!-- table -->
		<table id="resourcesListTbl" class="table table-striped"></table>
   	</div>
<!-- 添加部门模态框（Modal） -->
<div class="modal fade" id="addRoleModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
     	 <form id="addRoleFrom" class="form-horizontal" role="form">
         <div class="modal-header">
         	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h4 class="modal-title" id="myModalLabel">添加角色信息</h4>
         </div>
         <div class="modal-body">
         		<div class="form-group">
			      <label for="firstname" class="col-sm-2 control-label">角色名称&nbsp;<span class="text-danger">*</label>
			      <div class="col-sm-9">
			         <input type="text" class="validate[required,maxSize[20]] form-control" name="roleName" 
			            placeholder="请输入角色名称（必填*）">
			      </div>
			   </div>
			   <div class="form-group">
			      <label for="firstname" class="col-sm-2 control-label">角色Key&nbsp;<span class="text-danger">*</label>
			      <div class="col-sm-9">
			         <input type="text" class="validate[required,maxSize[20],ajax[checkAddRoleKeyIsExist]] form-control" id="roleKey" name="roleKey" 
			            placeholder="请输入角色Key（必填*）">
			      </div>
			   </div>
			   <div class="form-group">
			      <label for="firstname" class="col-sm-2 control-label">描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述&nbsp;&nbsp;</label>
			      <div class="col-sm-9">
			      	 <textarea name="comments"  class="validate[maxSize[20]] form-control" rows="3" placeholder="请输入角色描述"></textarea>
			      </div>
			   </div>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button type="button" class="btn btn-primary submit">添加</button>
         </div>
         	</form>
      </div><!-- /.modal-content -->
   </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 更新部门模态框（Modal） -->
<div class="modal fade" id="updateRoleModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
     	 <form id="updateRoleFrom" class="form-horizontal" role="form">
         <div class="modal-header">
         	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h4 class="modal-title" id="myModalLabel">更新角色信息</h4>
         </div>
         <div class="modal-body">
         		<div class="form-group">
			      <label for="firstname" class="col-sm-2 control-label">角色名称&nbsp;<span class="text-danger">*</label>
			      <div class="col-sm-9">
			         <input type="text" class="validate[required,maxSize[20]] form-control" name="roleName" 
			            placeholder="请输入角色名称（必填*）">
			      </div>
			   </div>
			   <div class="form-group">
			      <label for="firstname" class="col-sm-2 control-label">角色Key&nbsp;<span class="text-danger">*</label>
			      <div class="col-sm-9">
			         <input type="text" class="validate[required,maxSize[20],ajax[checkUpdateRoleKeyIsExist]] form-control" id="uRoleKey" name="roleKey" 
			            placeholder="请输入角色Key（必填*）">
			      </div>
			   </div>
			   <div class="form-group">
			      <label for="firstname" class="col-sm-2 control-label">描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述&nbsp;&nbsp;</label>
			      <div class="col-sm-9">
			      	 <textarea name="comments"  class="validate[maxSize[20]] form-control" rows="3" placeholder="请输入部门描述"></textarea>
			      </div>
			   </div>
			   <input type="hidden" name="id"/>
			   <input type="hidden" name="oldRoleKey" id="oldRoleKey">
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button  type="submit" class="btn btn-primary">更新</button>
         </div>
         	</form>
      </div><!-- /.modal-content -->
   </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 删除角色模态框（Modal） -->
<div class="modal fade" id="deleteRoleModal" tabindex="-1" role="dialog" 
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
            <button type="button" id="removeRoleSubmit" class="btn btn-primary"> 确认</button>
         </div>
      </div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 设置角色资源模态框（Modal） -->
<div class="modal fade" id="setRoleResModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">&times;
            </button>
            <h4 class="modal-title" id="myModalLabel">设置角色资源</h4>
         </div>
         <div id="message" class="modal-body">
         	<iframe name="setRoleResIframe" frameborder="0" height="500px" width="100%" noresize="noresize"></iframe>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button type="button" id="setRoleResSubmit" class="btn btn-primary"> 确认</button>
         </div>
      </div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</body>
</html>