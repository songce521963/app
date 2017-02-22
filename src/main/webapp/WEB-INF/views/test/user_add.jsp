<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>添加人员</title>
		<!--css-->
		<link href="${pageContext.request.contextPath }/resources/bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath }/resources/validationEngine/css/validationEngine.jquery.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath }/resources/icheck/css/all.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath }/resources/css/test/user_add.css" rel="stylesheet">
		<!--js-->
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/validationEngine/js/jquery.validationEngine.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/validationEngine/js/jquery.validationEngine-zh_CN.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/icheck/js/icheck.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/test/user_add.js"></script>
	</head>
<body>
<!-- 头部 -->
	<div id="alert"></div>
	<div class="header">
		<h1 class="page-title">添加人员</h1>
		<ul class="breadcrumb">
			<li><a href="${pageContext.request.contextPath }/account/index/show.html">主页</a> </li>
			<li><a href="${pageContext.request.contextPath }/test/user/list.html">人员管理</a> </li>
			<li class="active">添加人员</li>
        </ul>
	</div>
	<form class="form-horizontal" action="addUser.html" method="post" role="form">
	   <div class="form-group">
	      <label for="name" class="col-sm-2 control-label">姓名</label>
	      <div class="col-sm-10">
		      <input type="text"  name="name" class="form-control" id="name" 
		         placeholder="请输入姓名">
	       </div>
	   </div>
	   <div class="form-group">
	      <label for="name" class="col-sm-2 control-label">密码</label>
	      <div class="col-sm-10">
	      <input type="text"  name="password" class="form-control" id="password" 
	         placeholder="请输入密码">
	         </div>
	   </div>
	   <div class="form-group">
	      <label for="name" class="col-sm-2 control-label">性别</label>
	      <div class="col-sm-10">
      				<span>
						<input type="radio" id="flat-radio-1" name="sex" value="01" checked>
						<label for="flat-radio-1">&nbsp;男</label> &nbsp;&nbsp;&nbsp;&nbsp;
					</span>
					<span>
						<input type="radio"  id="flat-radio-2" name="sex" value="02" > 
						<label for="flat-radio-2">&nbsp;女</label> &nbsp;&nbsp;&nbsp;&nbsp;
					</span>
	         </div>
	   </div>
	   <div class="form-group">
	      <label for="name" class="col-sm-2 control-label">年龄</label>
	      <div class="col-sm-10">
	      <input type="text"  name="age" class="form-control" id="age" 
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
	  <div class="form-group">
      	<div class="col-sm-offset-2 col-sm-10">
         <button type="submit" class="btn btn-default">登录</button>
      </div>
   </div>
   <input id="_csrf" type="hidden"                        
						name="${_csrf.parameterName}"
						value="${_csrf.token}"/> 
	</form>
      	
</body>
</html>