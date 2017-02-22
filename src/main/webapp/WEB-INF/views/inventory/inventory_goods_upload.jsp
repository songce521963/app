<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>商品导入</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/bootstrap/js/ajaxfileupload.js"></script>
<%--         <script type="text/javascript" src="${pageContext.request.contextPath }/resources/ckeditor/ckeditor.js"></script> --%>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/unit/commonCheckUtil.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/inventory/inventory_goods_upload.js"></script>
</head>
<body>
	<!-- 头部 -->
	<div id="alert"></div>
	<div class="header">
		<h1 class="page-title">商品导入</h1>
	</div>

	<!-- 	<div style="width: 80%;"> -->
	<!-- 		<input type="file" id="file" name="file" placeholder="请选择商品上传文件" -->
	<!-- 			style="margin: 0 auto; display: block;" /> <input id="_csrf" -->
	<%-- 			type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> --%>
	<!-- 		<button style="margin: 0 auto; display: block;" type="button" -->
	<!-- 			onclick="uploadFile()">商品导入</button> -->
	<!-- 	</div> -->

	<!-- 	<table style="width: 100%"> -->
	<!-- 		<tbody> -->
	<!-- 			<tr> -->
	<!-- 				<td width="40%"><span style=""><b>数据</b></span></td> -->
	<!-- 				<td width="60%"><input type="file" id="file" name="file" -->
	<!-- 					placeholder="请选择商品上传文件" /> <input id="_csrf" type="hidden" -->
	<%-- 					name="${_csrf.parameterName}" value="${_csrf.token}" /></td> --%>
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<td></td> -->
	<!-- 				<td><button type="button" onclick="uploadFile()">商品导入</button></td> -->
	<!-- 			</tr> -->
	<!-- 		</tbody> -->
	<!-- 	</table> -->

	<div style="width: 80%;">
		<div style="margin: 0 auto; width: 30%">
			<div style="text-align: center; margin: 0">
				<span style="font-size: x-large;"><b>导入注意事项</b></span>
			</div>
			<br> <span style="font-size: large;"><b>1.请先下载模板，在第一个sheet<导入内容>中填入数据
					，有下拉框的推荐使用下拉选择，保持格式一致。 <br>
					2.如果个别数据导入失败并提示错误信息时，请将需要再次 导入的数据复制到新的模板中修改后再次导入，以避免
					上传的文件中因有第一次导入成功的数据而重复插入。</b></span>
		</div>

	</div>

	<button type="button" onclick="downLoadTemplate()">下载模板</button>
	<input type="file" id="file" name="file" placeholder="请选择商品上传文件" />
	<input id="_csrf" type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />

	<button type="button" onclick="uploadFile()">商品导入</button>

	<table id="goodsListTbl" class="table table-striped"></table>
	<br />
	<br />
</body>
</html>