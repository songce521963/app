<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;" />
	<meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
	<meta name="contextPath" content="${pageContext.request.contextPath }"/>
	<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
	<link rel="longtian" href="${pageContext.request.contextPath }/resources/img/LogoL1.png" type="image/x-icon" />
  	<title><decorator:title /></title>
  	<!-- css -->
	<link href="${pageContext.request.contextPath }/resources/bootstrap/css/bootstrap.css" rel="stylesheet"></link>
	<link href="${pageContext.request.contextPath }/resources/bootstrap/font-awesome/css/font-awesome.css" rel="stylesheet"></link>
	<link href="${pageContext.request.contextPath }/resources/bootstrap/css/theme.css" rel="stylesheet"></link>
	<link href="${pageContext.request.contextPath }/resources/bootstrap/css/bootstrap-table.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath }/resources/bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath }/resources/icheck/css/all.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath }/resources/validationEngine/css/validationEngine.jquery.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath }/resources/css/index.css" rel="stylesheet" ></link>
	<!-- js -->
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/bootstrap/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap-table.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap-table-zh-CN.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/validationEngine/js/jquery.validationEngine.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/validationEngine/js/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/icheck/js/icheck.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/unit/common.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/unit/ajax.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/unit/table.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/unit/ajaxValidation.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/index.js"></script>
    <decorator:head />
  </head>
  <body class="theme-blue">
  	<jsp:include page="../views/common/header.jsp"></jsp:include>
  	<jsp:include page="../views/common/left.jsp"></jsp:include>
  	<div class="content">
  	 	<decorator:body />
  	</div>
  </body>
</html>