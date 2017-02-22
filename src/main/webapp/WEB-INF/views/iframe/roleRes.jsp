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
		<link href="${pageContext.request.contextPath }/resources/zTree/css/metroStyle/metroStyle.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath }/resources/css/iframe/roleRes.css" rel="stylesheet">
		<!--js-->
		<script src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap.js"  type="text/javascript"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/zTree/js/jquery.ztree.core.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/zTree/js/jquery.ztree.excheck.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/unit/common.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/unit/ajax.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/unit/table.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/unit/ajaxValidation.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/iframe/roleRes.js"></script>
	</head>
<body>
<div>
    <ul id="treeDemo" class="ztree"></ul>
</div>
</body>
</html>