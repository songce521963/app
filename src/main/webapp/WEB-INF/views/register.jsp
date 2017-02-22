<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>公司注册 </title>
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
	<!-- js -->
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/bootstrap/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap-table.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap-table-zh-CN.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/validationEngine/js/jquery.validationEngine.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/validationEngine/js/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/unit/common.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/unit/ajax.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/unit/table.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/unit/ajaxValidation.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/register.js"></script>
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
    <div class="panel panel-default">
        <p class="panel-heading no-collapse" style="font-size:20px;">注册</p>
        <div class="panel-body">
       
            <form id="registerForm" action="registerInfo.html" method="post">
            	 <h4>公司信息</h4>
        	</br>
        	
                <div class="form-group">
                    <label>公司名称<span class="text-danger">*</label>
                    <input type="text" name="companyName" id="companyName" class="validate[required,ajax[checkCompanyNameIsExist]] form-control span12"
                    placeholder="请输入公司名称（必填*）">
                </div>
                
                <div class="form-group">
                <label>公司名称（英）<span class="text-danger">*</label>
                    <input type="text" name="companyNameE" class="validate[required] form-control span12"
                    placeholder="请输入公司名称（英）（必填*）">
                </div>
                
                <div class="form-group">
                    <label>公司简称<span class="text-danger">*</label>
                    <input type="text" name="shortName" class="validate[required] form-control span12"
                    placeholder="请输入简称（必填*）">
                </div>
                
                <div class="form-group">
                <label>公司简称（英）<span class="text-danger">*</label>
                    <input type="text" name="shortNameE" class="validate[required] form-control span12"
                    placeholder="请输入简称（英）（必填*）">
                </div>
                
        	<h4>公司管理员信息</h4>
        	</br>
            
                <div class="form-group">
                    <label>用户名(邮箱地址)<span class="text-danger">*</label>
                    <input type="text" name="email" class="validate[required,custom[email],ajax[checkEmailIsExist]] form-control span12"
                    placeholder="请输入用户名（必填*）">
                </div>
                
                <div class="form-group">
                <label>密码<span class="text-danger">*</label>
                    <input id="userPassword" type="password" name="userPassword" class="validate[required] form-control span12"
                    placeholder="请输入密码（必填*）">
                </div>
                
                <div class="form-group">
                <label>确认密码<span class="text-danger">*</label>
                    <input type="password" name="userPasswordConfirm" class="validate[required,equals[userPassword]] form-control span12"
                    placeholder="请再次输入密码（必填*）">
                </div>
                
				<button id="registerSubmit" type="button" class="btn btn-primary pull-right submit" style="background:#337ab7;">注册</button>
            </form>
            </div>
        </div>
    </div>
	</body>
</html>
