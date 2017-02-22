<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>基础数据管理</title>
<link
	href="${pageContext.request.contextPath }/resources/bootstrap/css/bootstrap-table.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/resources/bootstrap/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/resources/icheck/css/all.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/resources/validationEngine/css/validationEngine.jquery.css"
	rel="stylesheet">
<!--js-->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap-table.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/validationEngine/js/jquery.validationEngine.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/validationEngine/js/jquery.validationEngine-zh_CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/icheck/js/icheck.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/master/masterData_list.js"></script>
</head>
<body>
	<!-- 头部 -->
	<div id="alert"></div>
	<div class="header">
		<h1 class="page-title">基础数据管理</h1>
		<ul class="breadcrumb">
			<li><a
				href="${pageContext.request.contextPath }/account/index/show.html">主页</a>
			</li>
			<li class="active">基础数据管理</li>
		</ul>
	</div>
	<button style="float: left; margin-top: 11px;" class="btn  btn-link"
		data-toggle="modal" data-target="#addMasterDataModal">
		<span class="glyphicon glyphicon-plus"></span> 添加基础数据
	</button>
	<button id="deleteAll" style="float: left; margin-top: 11px;"
		class="btn  btn-link">
		<span class="glyphicon glyphicon-remove"></span> 批量删除
	</button>

	<!-- table -->
	<table id="masterDataListTbl" class="table table-striped"></table>

	<!-- 删除基础数据模态框（Modal） -->
	<div class="modal fade" id="deleteMasterDataModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">确认</h4>
				</div>
				<div class="modal-body">确定要删除选中的基础数据信息吗？</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消
					</button>
					<button id="deleteDo" type="button" class="btn btn-primary">
						确认删除</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 添加基础数据信息模态框 -->
	<div class="modal fade" id="addMasterDataModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<form id="addMasterDataForm" class="form-horizontal" role="form">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">添加基础数据信息</h4>
					</div>
					<div class="modal-body">

						<div class="form-group">
							<label for="name" class="col-sm-3 control-label">分类区分名&nbsp;<span
								class="text-danger">*</label>
							<div class="col-sm-9">
								<select name="catgoryId1" class="form-control" id="tCategory">
									<option value="01">产地</option>
									<option value="02">维修单分类</option>
									<option value="03">结算方式</option>
								</select>
							</div>
						</div>

						<!-- 			<div class="form-group"> -->
						<!-- 				 <label for="name" class="col-sm-3 control-label">Code&nbsp;&nbsp;&nbsp;&nbsp;值&nbsp;<span class="text-danger">*</label> -->
						<!-- 				 <div class="col-sm-9"> -->
						<!-- 					<input type="text"  name="keyCd" class="validate[required,maxSize[50],ajax[checkAddKeyCdIsExist]] form-control" id="keyCd"  -->
						<!-- 					         placeholder="请输入Code（必填*）"> -->
						<!-- 				 </div> -->
						<!-- 			</div> -->

						<div class="form-group">
							<label for="name" class="col-sm-3 control-label">表&nbsp;&nbsp;&nbsp;示&nbsp;&nbsp;&nbsp;值&nbsp;<span
								class="text-danger">*</label>
							<div class="col-sm-9">
								<input type="text" name="keyValue"
									class="validate[required,maxSize[255]] form-control" id="tVal"
									placeholder="请输入表示值（必填*）">
							</div>
						</div>

						<div class="form-group">
							<label for="name" class="col-sm-3 control-label">表&nbsp;示&nbsp;顺&nbsp;序&nbsp;<span
								class="text-danger">*</label>
							<div class="col-sm-9">
								<input type="text" name="dispOrder"
									class="validate[required,maxSize[11],custom[integer]] form-control"
									id="tOrder" placeholder="请输入表示顺序（必填*）">
							</div>
						</div>

						<div class="form-group">
							<label for="name" class="col-sm-3 control-label">描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述&nbsp;&nbsp;</label>
							<div class="col-sm-9">
								<textarea class="validate[maxSize[255]] form-control"
									name="description" id="tDes" placeholder="请输入描述"></textarea>
							</div>
						</div>

					</div>
					<input type="hidden" name="uuid" />

					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消
						</button>
						<button id="addMasterDataSubmit" type="button"
							class="btn btn-primary submit">添加</button>
					</div>
				</form>
			</div>
		</div>
	</div>


	<!-- 编辑基础数据信息模态框（Modal） -->
	<div class="modal fade" id="editMasterDataModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<form id="editMasterDataForm" class="form-horizontal" role="form">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">修改基础数据信息</h4>
					</div>
					<div class="modal-body">

						<div class="form-group">
							<label for="name" class="col-sm-3 control-label">分类区分名&nbsp;<span
								class="text-danger">*</label>
							<div class="col-sm-9">
								<select name="catgoryId1" class="form-control" id="tCategory"
									disabled value="value" readonly="true">
									<option value="01">产地</option>
									<option value="02">维修单分类</option>
									<option value="03">结算方式</option>
								</select>
							</div>
						</div>

						<div class="form-group">
							<label for="name" class="col-sm-3 control-label">Code&nbsp;&nbsp;&nbsp;&nbsp;值&nbsp;<span
								class="text-danger">*</label>
							<div class="col-sm-9">
								<input type="text" name="keyCd" class="form-control" id="keyCd"
									disabled value="value" readonly="true"
									placeholder="请输入Code（必填*）">
							</div>
						</div>

						<div class="form-group">
							<label for="name" class="col-sm-3 control-label">表&nbsp;&nbsp;&nbsp;示&nbsp;&nbsp;&nbsp;值&nbsp;<span
								class="text-danger">*</label>
							<div class="col-sm-9">
								<input type="text" name="keyValue"
									class="validate[required,maxSize[255]] form-control"
									id="keyValue" placeholder="请输入表示值（必填*）">
							</div>
						</div>

						<div class="form-group">
							<label for="name" class="col-sm-3 control-label">表&nbsp;示&nbsp;顺&nbsp;序&nbsp;<span
								class="text-danger">*</label>
							<div class="col-sm-9">
								<input type="text" name="dispOrder"
									class="validate[required,maxSize[11]] form-control"
									id="dispOrder" placeholder="请输入表示顺序（必填*）">
							</div>
						</div>

						<div class="form-group">
							<label for="name" class="col-sm-3 control-label">描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述&nbsp;&nbsp;</label>
							<div class="col-sm-9">
								<textarea class="validate[maxSize[255]] form-control"
									name="description" id="description" placeholder="请输入描述"></textarea>
							</div>
						</div>
						<input type="hidden" name="uuid" />
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消
						</button>
						<button id="updateMasterDataSubmit" type="button"
							class="btn btn-primary">更新</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>