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
		<title>组织排序</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/bootstrap/css/bootstrap.css"></link>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/bootstrap/font-awesome/css/font-awesome.css"></link>
		<script src="${pageContext.request.contextPath }/resources/bootstrap/js/jquery-1.11.1.min.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath }/resources/bootstrap/plugins/bootstrap-order/css/bootstrap-order.min.css" rel="stylesheet" type="text/css">
		<!--js-->
		<script src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap.js"  type="text/javascript"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/organizational.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/unit/common.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/unit/ajax.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/unit/table.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/unit/ajaxValidation.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/iframe/orderOrg.js"></script>
	</head>
<body>
<div>
    <ul id="treeDemo" class="ztree"></ul>
</div>
</body>
</html>