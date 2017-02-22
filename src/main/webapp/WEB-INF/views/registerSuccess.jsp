<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册成功</title>
    <meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
	<meta name="contextPath" content="${pageContext.request.contextPath }"/>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link href='http://fonts.useso.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
  	<!-- css -->
	<link href="${pageContext.request.contextPath }/resources/bootstrap/css/bootstrap.css" rel="stylesheet"></link>
	<link href="${pageContext.request.contextPath }/resources/bootstrap/font-awesome/css/font-awesome.css" rel="stylesheet"></link>
	<link href="${pageContext.request.contextPath }/resources/bootstrap/css/theme.css" rel="stylesheet"></link>
	<link href="${pageContext.request.contextPath }/resources/bootstrap/css/bootstrap-table.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath }/resources/bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath }/resources/icheck/css/all.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath }/resources/validationEngine/css/validationEngine.jquery.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath }/resources/css/index.css" rel="stylesheet" ></link>
</head>
    
		<body class="theme-blue" style="background-color: #5CACEE;">
		    <style type="text/css">
		        #line-chart {
		            height:300px;
		            width:800px;
		            margin: 0px auto;
		            margin-top: 1em;
		        }
		        .navbar-default .navbar-brand, .navbar-default .navbar-brand:hover { 
		            color: #fff;
		        }
		    </style>
		    
		 <div class="dialog">
		    <div class="panel">
		     <p class="panel-heading no-collapse" style="font-size:20px;">注册成功</p>
		        <div class="panel-title"></div>
		        <div class="panel-body" style="height:250px;">
		       		<h1>&nbsp;&nbsp;&nbsp;已经注册成功！</h1>
		           	<a href="${pageContext.request.contextPath }/account/login/show.html">
					<button class="btn btn-lg btn-primary" style="margin-top:10%;margin-left:35%;background:red;">立即登录</button>
					</a>
		        </div>
		    </div>
		  </div>
	</body>
</html>
