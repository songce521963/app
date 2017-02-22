<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>公司信息管理</title>
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
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/company/companyData.js"></script>
	</head>
<body>
<!-- 头部 -->
	<div id="alert">
	</div>
	<div class="header">
		<h1 class="page-title">公司信息管理</h1>
		<ul class="breadcrumb">
			<li><a href="${pageContext.request.contextPath }/account/index/show.html">主页</a> </li>
			<li class="active">公司信息管理</li>
        </ul>
	</div>
	<button id="editCompany" type="button" class="btn btn-link">
		 <h4><span class="glyphicon glyphicon-edit"></span> 完善公司信息</h4>
	</button>		
<!-- 完善公司信息 -->
<form id="companyForm" class="form-horizontal">

	<div class="rows col-md-2"></div>
		<div class="col-md-6" style="border-radius: 10px;border:1px solid #C0C0C0">	
		</br>
			<div class="form-group">
		      <label for="companyName" class="col-md-2 control-label">公&nbsp;&nbsp;&nbsp;&nbsp;司&nbsp;&nbsp;&nbsp;&nbsp;名&nbsp;&nbsp;&nbsp;&nbsp;称&nbsp;&nbsp;&nbsp;<span class="text-danger">*</label>
		      <div class="col-md-8">
	                <input type="text" class="validate[required,maxSize[255]] form-control" 
	                		id="companyName" name="companyName" disabled="true"
	                   placeholder="请输入公司名称（必填*）" value="${company.companyName}">
	             </div>
		    </div>
		    <div class="form-group">
		      <label for="companyNameE" class="col-md-2 control-label">公&nbsp;司&nbsp;名&nbsp;称&nbsp;（英）&nbsp;<span class="text-danger">*</label>
		      <div class="col-md-8">
	                <input type="text" class="validate[required,custom[onlyLetterSp],maxSize[255]] form-control" id="companyNameE" 
	                	name="companyNameE" disabled="true" placeholder="请输入公司的英文名称（必填*）" value="${company.companyNameE}">
	          </div>
		    </div>
		    <div class="form-group">
		      <label for="shortName" class="col-md-2 control-label">公&nbsp;&nbsp;&nbsp;&nbsp;司&nbsp;&nbsp;&nbsp;&nbsp;简&nbsp;&nbsp;&nbsp;&nbsp;称&nbsp;&nbsp;&nbsp;<span class="text-danger">*</label>
		      <div class="col-md-8">
	                <input type="text" class="validate[required,maxSize[255]] form-control" id="shortName" 
	                	name="shortName" disabled="true" placeholder="请输入公司简称（必填*）" value="${company.shortName}">
	          </div>
		    </div>
		    <div class="form-group">
		      <label for="shortNameE" class="col-md-2 control-label">公&nbsp;司&nbsp;简&nbsp;称&nbsp;（英）&nbsp;<span class="text-danger">*</label>
		      <div class="col-md-8">
	                <input type="text" class="validate[required,custom[onlyLetterSp],maxSize[255]] form-control" id="shortNameE" 
	                	name="shortNameE" disabled="true" placeholder="请输入公司的英文简称（必填*）" value="${company.shortNameE}">
	          </div>
		    </div>
		    <div class="form-group">
		      <label for="alphaCd" class="col-md-2 control-label">字&nbsp;&nbsp;&nbsp;母&nbsp;&nbsp;&nbsp;表&nbsp;&nbsp;Code&nbsp;&nbsp;&nbsp;</label>
		      <div class="col-md-8">
	                <input type="text" class="validate[custom[onlyLetterSp],maxSize[255]] form-control" id="alphaCd" 
	                	name="alphaCd" disabled="true" placeholder="请输入公司字母表Code" value="${company.alphaCd}">
	          </div>
		    </div>
		    <div class="form-group">
		      <label for="legalPerson" class="col-md-2 control-label">公&nbsp;&nbsp;&nbsp;&nbsp;司&nbsp;&nbsp;&nbsp;&nbsp;法&nbsp;&nbsp;&nbsp;&nbsp;人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
		      <div class="col-md-8">
	                <input type="text" class="validate[maxSize[255]] form-control" id="legalPerson" 
	                	name="legalPerson" disabled="true" placeholder="请输入公司法人" value="${company.legalPerson}">
	             </div>
		    </div>
		    <div class="form-group">
		      <label for="registerCode" class="col-md-2 control-label">工&nbsp;商&nbsp;注&nbsp;册&nbsp;代&nbsp;码&nbsp;&nbsp;</label>
		      <div class="col-md-8">
	                <input type="text" class="validate[maxSize[255],ajax[checkCompanyRegisterCode]] form-control" id="registerCode" 
	                	name="registerCode" disabled="true" placeholder="请输入公司工商注册代码" value="${company.registerCode}">
	             </div>
		    </div>
		    
		    <input type="hidden" id="oldFieldValue" value="${company.registerCode}">
		    <input type="hidden" name="uuid" value="${company.uuid}">
		    
		    
		    <div style = "text-align:right;">
			    <button id="cancelEditCompany" type="button" class="btn btn-default active"
			    		style="width:15%" disabled="true">
			    	取&nbsp;消
			    </button>
			    &nbsp;
			    <button id="saveEditCompany" type="button" class="btn btn-primary active submit" 
			    		style="width:15%" disabled="true">
			    	保&nbsp;存
			    </button>
			    </br>
			    </br>
		    </div>		    
		</div>	   
		
</form>

	
</body>
</html>