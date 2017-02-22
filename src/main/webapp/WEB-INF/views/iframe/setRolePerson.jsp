<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="_csrf" content="${_csrf.token}"/>
		<meta name="_csrf_header" content="${_csrf.headerName}"/>
		<meta name="contextPath" content="${pageContext.request.contextPath }"/>
		<title>会员查询</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/bootstrap/css/bootstrap.css"></link>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/bootstrap/font-awesome/css/font-awesome.css"></link>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/bootstrap/css/bootstrap-table.css" >
		<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/iframe/setRolePerson.css" >
		<!--js-->
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/bootstrap/js/jquery-1.11.1.min.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap.js"  ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap-table.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap-table-zh-CN.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/unit/common.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/unit/ajax.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/unit/table.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/unit/ajaxValidation.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/iframe/setRolePerson.js"></script>
	</head>
<body>
<div>
    <!-- 角色对应的资源 -->
	<table id="personListTbl" class="table table-striped"></table>
</div>
</body>
</html>