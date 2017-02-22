<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>图书管理</title>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/bootstrap/js/ajaxfileupload.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/unit/commonCheckUtil.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/unit/jquery.qrcode.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/test/books_info.js"></script>
	</head>
	<body>
	<!-- 头部 -->
		<div id="alert">
			<c:if test="${!empty message}">
				<div id="myAlert" class="alert alert-success">
				   <a href="#" class="close" data-dismiss="alert">&times;</a>
				   <strong>成功！</strong>${message}
				</div>
			</c:if>
		</div>
	
		<div class="header">
			<h1 class="page-title">图书详细</h1>
			<ul class="breadcrumb">
				<li><a href="${pageContext.request.contextPath }/account/index/show.html">主页</a></li>
				<li class="active">图书详细</li>
	        </ul>
		</div>
	<!-- 图书信息form -->	
		<form id="boooksForm" name="booksForm" method="post" class="form-horizontal" role="form"
			action="${pageContext.request.contextPath}/test/addAndUpdateBookInfo.html">
					
			<div class="form-group">
		      <label for="bookSort" class="col-md-2 control-label">图书所属分类</label>
		      <div class="col-md-4">
			     <select id="bookSort" name ="bookSort" class="form-control">
	                 ${booksModel.bookSortList }
	             </select>
		      </div>
		    </div>
		   
			<div class="form-group">
		      <label for="bookNumber" class="col-md-2 control-label">图书编号</label>
		      <div class="col-md-4">
	                <input type="text" class="validate[ajax[checkBookNumber]] form-control" id="bookNumber" name="bookNumber"
	                   placeholder="请输入图书编号" value="${booksModel.bookNumber}">
	          </div>
		    </div>
		    
		    <div class="form-group">
		      <label for="bookName" class="col-md-2 control-label">图书名称</label>
		      <div class="col-md-4">
	                <input type="text" class="validate[required,maxSize[50]] form-control" id="bookName" name="bookName"
	                   placeholder="请输入图书名称（必填*）" value="${booksModel.bookName}">
	          </div>
		    </div>
		    
		    <div class="form-group">
		      <label for="bookAuthor" class="col-md-2 control-label">图书作者</label>
		      <div class="col-md-4">
	                <input type="text" class="validate[maxSize[50]] form-control" id="bookAuthor" name="bookAuthor"
	                   placeholder="请输入图书作者" value="${booksModel.bookAuthor}">
	          </div>
		    </div>
		    
		    <div class="form-group">
		      <label for="bookPrice" class="col-md-2 control-label">图书单价</label>
		      <div class="col-md-3 form-inline">
	                <input type="text" class="validate[custom[number],maxSize[6]] commonFormatNumber form-control" id="bookPrice" name="bookPrice"
	                   formatDecNum="2" placeholder="请输入图书单价" value="${booksModel.bookPrice}">
	                   <label for="bookDiscount" class="control-label">&nbsp;元</label>
	          </div>
		    </div>
		    
		    <div class="form-group">
	          <label for="bookDiscount" class="col-md-2 control-label">进店折扣</label>
	          <div class="col-md-3 form-inline">
	             <input type="text" class="validate[custom[number],maxSize[9]] commonFormatNumber form-control" id="bookDiscount" name="bookDiscount"
	                placeholder="请输入折扣" value="${booksModel.bookDiscount}">
	                <label for="bookDiscount" class="control-label">&nbsp;折</label>
	          </div>
	       </div>
	       
		    <div class="form-group">
		      <label for="bookDesc" class="col-md-2 control-label">图书描述</label>
		      <div class="col-md-4">
	                <textarea class="validate[maxSize[255]] form-control" name="bookDesc" id="bookDesc"
			      placeholder="请输入图书描述">${booksModel.bookDesc}</textarea>
	          </div>
		    </div>
		    
		    <div class="form-group">
	          <div class="col-md-2">&nbsp;</div>
	          <div class="col-md-3 form-inline">
			      <button type="button" id="submitBtn" class="btn btn-primary submit" style="float: left;">提交</button>
	          </div>
	       </div>
		    <input id="_csrf" type="hidden"                        
						name="${_csrf.parameterName}"
						value="${_csrf.token}"/>
			<input type="hidden" id="oldFieldValue" value="${booksModel.bookNumber}"/>
						
			<input type="hidden" id="uuid" name="uuid" value="${booksModel.uuid}">
       		<input type="hidden" id="pageFlag" name="pageFlag" value="${booksModel.pageFlag}"> 
		</form>
		  	               
	</body>
</html>