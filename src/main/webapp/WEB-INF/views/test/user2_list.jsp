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
		<link href="${pageContext.request.contextPath }/resources/icheck/css/all.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath }/resources/validationEngine/css/validationEngine.jquery.css" rel="stylesheet">
		<!--js-->
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap-table.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap-table-zh-CN.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/validationEngine/js/jquery.validationEngine.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/validationEngine/js/jquery.validationEngine-zh_CN.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/icheck/js/icheck.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/test/user2_list.js"></script>
	</head>
<body>
<!-- 头部 -->
	<div id="alert">
	</div>
	<div class="header">
		<h1 class="page-title">人员管理2</h1>
		<ul class="breadcrumb">
			<li><a href="${pageContext.request.contextPath }/account/index/show.html">主页</a> </li>
			<li class="active">人员管理2</li>
        </ul>
	</div>
	<button style="float: right;margin-top:11px;" class="btn  btn-link" data-toggle="modal" data-target="#addModal">
		<span class="glyphicon glyphicon-plus"></span> 添加人员信息
	</button>
	<button id="deleteAll" style="float: right;margin-top:11px;" class="btn  btn-link">
		<span class="glyphicon glyphicon-remove"></span> 批量删除
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
</div>   
<!-- 编辑模态框（Modal） -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
      	<form id="editUserForm" class="form-horizontal" role="form">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">
               	修改人员信息
            </h4>
         </div>
         <div class="modal-body">
         	<div class="form-group">
				      <label for="name" class="col-sm-2 control-label">姓名</label>
				      <div class="col-sm-10">
					      <input type="text"  name="uName" class="form-control" id="name" 
					         placeholder="请输入姓名">
				       </div>
				   </div>
				   <div class="form-group">
				      <label for="name" class="col-sm-2 control-label">密码</label>
				      <div class="col-sm-10">
				      <input type="text"  name="uPassword" class="form-control" id="password" 
				         placeholder="请输入密码">
				         </div>
				   </div>
				   <div class="form-group">
				      <label for="name" class="col-sm-2 control-label">性别</label>
				      <div class="col-sm-10">
			      				<span>
									<input type="radio" id="flat-radio-1" name="uSex" value="01" checked>
									<label for="flat-radio-1">&nbsp;男</label> &nbsp;&nbsp;&nbsp;&nbsp;
								</span>
								<span>
									<input type="radio"  id="flat-radio-2" name="uSex" value="02" > 
									<label for="flat-radio-2">&nbsp;女</label> &nbsp;&nbsp;&nbsp;&nbsp;
								</span>
				         </div>
				   </div>
				   <div class="form-group">
				      <label for="name" class="col-sm-2 control-label">年龄</label>
				      <div class="col-sm-10">
				      <input type="text"  name="uAge" class="form-control" id="age" 
				         placeholder="请输入年龄">
				         </div>
				   </div>
				   <div class="form-group" class="col-sm-2 control-label">
				      <label for="name" class="col-sm-2 control-label">班级</label>
				      <div class="col-sm-10">
					      <input type="text"  name="uClass" class="form-control" id="uClass" 
					         placeholder="请输入班级">
				         </div>
				   </div>
				   <input type="hidden" name="uuid"/>
				   <input type="hidden" name="version"/>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭
            </button>
            <button id="updateUserSubmit" type="button" class="btn btn-primary">
             		修改
            </button>
         </div>
         </form>
      </div><!-- /.modal-content -->
</div><!-- /.modal --> 
</div>

<!-- 模态框（Modal） -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
      	<form id="addUserForm" class="form-horizontal" role="form">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">
               	添加人员信息
            </h4>
         </div>
         <div class="modal-body">
         	<div class="form-group">
				      <label for="name" class="col-sm-2 control-label">姓名</label>
				      <div class="col-sm-10">
					      <input type="text"  name="uName" class="validate[required] form-control" id="name" 
					         placeholder="请输入姓名">
				       </div>
				   </div>
				   <div class="form-group">
				      <label for="name" class="col-sm-2 control-label">密码</label>
				      <div class="col-sm-10">
				      <input type="text"  name="uPassword" class="validate[required] form-control" id="password" 
				         placeholder="请输入密码">
				         </div>
				   </div>
				   <div class="form-group">
				      <label for="name" class="col-sm-2 control-label">性别</label>
				      <div class="col-sm-10">
			      				<span>
									<input type="radio" id="flat-radio-1" name="uSex" value="01" checked>
									<label for="flat-radio-1">&nbsp;男</label> &nbsp;&nbsp;&nbsp;&nbsp;
								</span>
								<span>
									<input type="radio"  id="flat-radio-2" name="uSex" value="02" > 
									<label for="flat-radio-2">&nbsp;女</label> &nbsp;&nbsp;&nbsp;&nbsp;
								</span>
				       </div>
				   </div>
				   <div class="form-group">
				      <label for="name" class="col-sm-2 control-label">年龄</label>
				      <div class="col-sm-10">
				      <input type="text"  name="uAge" class="form-control" id="age" 
				         placeholder="请输入年龄">
				         </div>
				   </div>
				   <div class="form-group" class="col-sm-2 control-label">
				      <label for="name" class="col-sm-2 control-label">班级</label>
				      <div class="col-sm-10">
					      <input type="text"  name="uClass" class="form-control" id="uClass" 
					         placeholder="请输入班级">
				         </div>
				   </div>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭
            </button>
            <button id="addUserSubmit" type="button" class="btn btn-primary">
             		 登录
            </button>
         </div>
         </form>
      </div><!-- /.modal-content -->
</div><!-- /.modal --> 
</div>
</body>
</html>