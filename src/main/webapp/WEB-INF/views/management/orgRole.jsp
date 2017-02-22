<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>按组织授权</title>
		<!-- css -->
		<link href="${pageContext.request.contextPath }/resources/css/management/orgRole.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath }/resources/zTree/css/metroStyle/metroStyle.css" rel="stylesheet" type="text/css">
		<!--js-->
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/zTree/js/jquery.ztree.core.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/management/orgRole.js"></script>
	</head>
<body>
<!-- 头部 -->
	<div id="alert"></div>
	<div class="header">
		<h1 class="page-title">按组织授权</h1>
		<ul class="breadcrumb">
			<li><a href="${pageContext.request.contextPath }/account/index/show.html">主页</a> </li>
			<li class="active">按组织授权</li>
        </ul>
	</div>
    <!-- 查询面板 -->
    <div class="col-md-4 col-sm-12 col-xs-12">
    	<ul id="tree" class="ztree"></ul>
	</div>
    <div class="col-md-8 col-sm-12 col-xs-12">
    	<form id="searchFrom">
    		<input type="hidden" name="orgFid"/>
    	</form>
    	<button style="float: left;margin-top:-10px; margin-bottom:10px;" class="btn  btn-link" data-toggle="modal"
			data-target="#setOrgRoleModal">
			<span class="glyphicon glyphicon-plus"></span> 添加角色
		</button>
		<!-- table -->
		<table id="roleListTbl" class="table table-striped"></table>
    </div>
<!-- 设置角色资源模态框（Modal） -->
<div class="modal fade" id="setOrgRoleModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true" style="margin: 0px auto">
   <div class="modal-dialog"  style="width: 45%">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">&times;
            </button>
            <h4 class="modal-title" id="myModalLabel">设置角色资源</h4>
         </div>
         <div id="message" class="modal-body" style="height: 65%">
         	<iframe name="setOrgRoleIframe" frameborder="0" height="100%" width="100%" marginheight="auto" marginwidth="auto" noresize="noresize"></iframe>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button type="button" id="setOrgRoleSubmit" class="btn btn-primary"> 确认</button>
         </div>
      </div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- 删除组织模态框（Modal） -->
<div class="modal fade" id="removeUserRoleModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">&times;
            </button>
            <h4 class="modal-title" id="myModalLabel">确认</h4>
         </div>
         <div id="message" class="modal-body">您确定要删除此条数据吗？</div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button type="button" id="removeUserRoleSubmit" class="btn btn-primary"> 确认</button>
         </div>
      </div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</body>
</html>