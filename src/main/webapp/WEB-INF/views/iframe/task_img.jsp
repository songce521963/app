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
		<script src="${pageContext.request.contextPath }/resources/bootstrap/js/jquery-1.11.1.min.js" type="text/javascript"></script>
		<!--js-->
		<script src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap.js"  type="text/javascript"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/unit/common.js"></script>
	</head>
<body>
<!-- 1.获取到规则流程图 -->
<img style="position: absolute;top: 0px;left: 0px;" src="${pageContext.request.contextPath }/activiti/workFollow/searchTaskImg.html?deploymentId=${pd.deploymentId}&imageName=${pd.diagramResourceName}">

<!-- 2.根据当前活动的坐标，动态绘制DIV -->
<div style="position: absolute;border:1px solid red;top:${map.y}px;left: ${map.x}px;width: ${map.width}px;height:${map.height}px; "></div></body>
</body>
</html>