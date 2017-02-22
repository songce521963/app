<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>会员查询</title>
		<link href="${pageContext.request.contextPath }/resources/css/management/resources.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath }/resources/zTree/css/metroStyle/metroStyle.css" rel="stylesheet" type="text/css">
		<!--js-->
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/zTree/js/jquery.ztree.core.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/management/resources.js"></script>
	</head>
<body>
<!-- 头部 -->
	<div id="alert"></div>
	<div class="header">
		<h1 class="page-title">资源管理</h1>
		<ul class="breadcrumb">
			<li><a href="${pageContext.request.contextPath }/account/index/show.html">主页</a> </li>
			<li class="active">资源管理</li>
        </ul>
	</div>
    <!-- 查询面板 -->
    <div class="col-md-4 col-sm-12 col-xs-12">
    	<div class="btn-group" style="margin-bottom:10px;">
		    <button type="button" class="btn btn-link dropdown-toggle" data-toggle="dropdown">
		      <span class="glyphicon glyphicon-plus"></span> 新增菜单
		    </button>
		    <ul class="dropdown-menu">
		      <li>
		      	<button id="menu" class="btn btn-link btn-sm">
					<span class="glyphicon glyphicon-tasks"></span>&nbsp;&nbsp;添加菜单
				</button>
		      </li>
		      <li class="divider"></li>
		      <li>
		      	<button id="page" class="btn btn-link btn-sm">
					<span class="glyphicon glyphicon-leaf"></span>&nbsp;&nbsp;添加页面
				</button>
		      </li>
		      <li class="divider"></li>
		      <li>
		      	<button id="function"  class="btn btn-link btn-sm">
					<span class="glyphicon glyphicon-tag"></span>&nbsp;&nbsp;添加功能
				</button>
		      </li>
		    </ul>
		  <button type="button" class="btn btn-link"  data-toggle="modal" data-target="#removeResModal">
		      <span class="glyphicon glyphicon-remove"></span> 删除
		  </button>
		  <button type="button" class="btn btn-link">
		     <span class="glyphicon glyphicon-share-alt"></span> 移动
		  </button>
		  <button type="button" class="btn btn-link">
		     <span class="glyphicon glyphicon-sort"></span> 排序
		  </button>
		</div>
		
    	<ul id="resources" class="ztree"></ul>
	</div>
	    <div class="col-md-8 col-sm-12 col-xs-12">
	    	<!-- <button style="float: right;margin-top:11px;" class="btn  btn-link" data-toggle="modal"
				data-target="#reportModal">
				<span class="glyphicon glyphicon-import"></span> Excle导入
			</button> -->
			<div class="panel panel-primary">
				<div class="panel-heading">
				      <h3 class="panel-title">菜单信息</h3>
				</div>
		  		<div class="panel-body">
		  			<form id="resourcesFrom" class="form-horizontal">
			     		 <div class="form-group">
			     		  <label class="col-md-2 col-sm-2 control-label">父节点名</label>
						  <div class="col-md-4  col-sm-9">
						     <input type="text" class="form-control disabled" name="parentName" disabled="disabled" placeholder="">
						  </div>
						    <label for="firstname" class="col-md-2 col-sm-2 control-label">资源类型</label>
					      <div class="col-md-4  col-sm-9">
					      	 <select id="resType" name="resType" class="form-control disabled" disabled="disabled">
							         <option value="0">根目录</option>
							         <option value="1">菜单</option>
							         <option value="2">页面</option>
							         <option value="3">功能</option>
							 </select>
					      </div>
						  <label for="firstname" class="col-md-2 col-sm-2 control-label">资源名称</label>
						  <div class="col-md-3  col-sm-9">
						     <input type="text" class="validate[required,maxSize[20]] form-control" name="resName" placeholder="请输入资源名称">
						  </div>
					      <label for="firstname" class="col-md-2 col-sm-2 control-label">是否隐藏</label>
					      <div class="col-md-2  col-sm-9">
					         <select id="isHidden" name ="isHidden" class="form-control">
					         	 <option value="1">显示</option>
						         <option value="0">隐藏</option>
							 </select>
					      </div>
					      <label for="firstname" class="col-md-2 col-sm-2 control-label">排序</label>
					      <div class="col-md-1  col-sm-9">
					         <input type="text" class="form-control" name="resLevel">
					      </div>
					      <label for="firstname" class="col-md-2 col-sm-2 control-label">资源路径</label>
					      <div class="col-md-5  col-sm-9">
					         <input type="text" class="form-control" name="resUrl" placeholder="请输入资源路径">
					      </div>
					      <label for="firstname" class="col-md-2 col-sm-2 control-label">图标样式</label>
					      <div class="col-md-3  col-sm-3">
					         <input type="text" class="form-control" name="resIcon" placeholder="请输入图标样式">
					      </div>
					      <label for="firstname" class="col-md-2 col-sm-2 control-label">描述</label>
					      <div class="col-md-10  col-sm-9">
					      	 <textarea name="comments"  class="validate[maxSize[20]] form-control" rows="3" placeholder="请输入菜单描述"></textarea>
					      </div>
					       <input type="hidden" name="id"/>
					       <input type="hidden" name="parentId"/>
					       <input type="hidden" name="parentName"/>
					       <input type="hidden" name="resFid"/>
					       <input type="hidden" name="resFname"/>
					       <input type="hidden" name="resType"/>
					      </div>
				   </form>
				   <div class="panel-footer">
			            <button type="button" id="addAndUpdateRes" class="btn btn-primary" style="float: right;"> 提交</button>
			        </div>
		   		</div>
			</div>
    	</div>
<!-- 删除组织模态框（Modal） -->
<div class="modal fade" id="removeResModal" tabindex="-1" role="dialog" 
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
            <button type="button" id="removeResSubmit" class="btn btn-primary"> 确认</button>
         </div>
      </div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</body>
</html>