<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>图书管理</title>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/test/books_list.js"></script>
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
			<h1 class="page-title">图书管理</h1>
			<ul class="breadcrumb">
				<li><a href="${pageContext.request.contextPath }/account/index/show.html">主页</a></li>
				<li class="active">图书管理</li>
	        </ul>
		</div>
	<!-- 查询Table -->	
		<table class="table table-bordered">
	        <tbody>
	        	<tr>
	            	<td class="col-md-1" style="text-align:center;">
	                	<label  class="control-label" style="padding-top: 6px;">图书所属分类</label></td>
	                <td class="col-md-3">
	                	<select class="form-control" id="bookSort" name="bookSort">
	                		${booksModel.bookSortList }
	                	</select>
	                </td>
	                
	                <td class="col-md-1" style="text-align:center;">
	                	<label  class="control-label" style="padding-top: 6px;">图书编号</label></td>
	                <td class="col-md-3">
		                <input type="text" class="form-control" id="bookNumber" name="bookNumber"
		                   placeholder="请输入图书编号" />
	                </td>
	                
	            </tr>
	            <tr>
	            	<td class="col-md-1" style="text-align:center;">
	                	<label  class="control-label" style="padding-top: 6px;">图书名称</label></td>
	                <td class="col-md-3">
	                    <input type="text" class="form-control" id="bookName" name="bookName"
	                       placeholder="请输入图书名称" />
	                </td>
	            	                	
	                <td class="col-md-1" style="text-align:center;">
	                	<label  class="control-label" style="padding-top: 6px;">图书作者</label></td>
	                <td class="col-md-3">
	                    <input type="text" class="form-control" id="bookAuthor" name="bookAuthor"
	                       placeholder="请输入图书作者" />
	                </td>
	                <td class="col-md-4" align="center" colspan="4">
	                    <button id="searchBooks" type="button" class="btn btn-primary" style="background:#337ab7;"
	                    		onclick="searchBooks()">查询</button>
	                </td>		                                
	            </tr>	            
	         </tbody>
	      </table> 
	<!-- 按钮组 -->
	    <button style="float: left;margin-top:11px;" class="btn btn-link" 
	    		onclick="location.href='${pageContext.request.contextPath}/test/booksInfo.html'">
	        <span class="glyphicon glyphicon-plus"></span>添加图书
	    </button>
	    <button style="float: left;margin-top:11px;" class="btn btn-link" onclick="delGrid()">
	        <span class="glyphicon glyphicon-remove"></span>批量删除
	    </button> 
	<!-- 图书列表 --> 
		<table id="booksListTable" class="table table-striped"></table>
		
		
	<!-- 删除模态框 -->	
	<div class="modal fade" id="deleteBooksModal" tabindex="-1" role="dialog" 
	   aria-labelledby="myModalLabel" aria-hidden="true">
	   <div class="modal-dialog">
	      <div class="modal-content">
	         <div class="modal-header">
	            <button type="button" class="close" 
	               data-dismiss="modal" aria-hidden="true">
	                  &times;
	            </button>
	            <h3 class="modal-title" id="myModalLabel">
	                确认信息
	            </h3>
	         </div>
	         <div class="modal-body">
	                确定要删除吗？
	         </div>
	         <div class="modal-footer">
	            <button type="button" class="btn btn-default" data-dismiss="modal">
	               取消
	            </button>
	            <button id="deleteDo" type="button" class="btn btn-primary">
	               确定
	            </button>
	         </div>
	      </div><!-- /.modal-content -->
	</div><!-- /.modal -->     	               
	</body>
</html>