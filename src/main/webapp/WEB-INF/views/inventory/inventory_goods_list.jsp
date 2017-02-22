<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>商品详细</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/inventory/inventory_goods_list.js"></script>
</head>
<body>
	<!-- 头部 -->
	<div id="alert">
		<c:if test="${message!=''}">
			<div id="myAlert"
				class="alert alert-success fade in col-md-5 col-sm-12 col-xs-12">
				<a href="#" class="close" data-dismiss="alert">&times;</a>
				${message}
			</div>
		</c:if>
	</div>
	<div class="header">
		<h1 class="page-title">商品一览</h1>
		        <ul class="breadcrumb">
		            <li><a href="${pageContext.request.contextPath}/account/index/show.html">主页</a></li>
		            <li class="active">商品一览</li>
		        </ul>
	</div>

	<!-- table -->
	<table class="table table-bordered">
		<tbody>
			<tr>
				<td class="col-md-1"><label class="control-label">商品名称</label></td>
				<td class="col-md-3"><input type="text" class="form-control"
					id="goodsName" name="goodsName" placeholder="请输入商品名称" /></td>
				<td class="col-md-1"><label class="control-label">商品批号</label></td>
				<td class="col-md-3"><input type="text" class="form-control"
					id="batchCode" name="batchCode" placeholder="请输入商品批号" /></td>
				<td class="col-md-1"><label class="control-label">商品规格</label></td>
				<td class="col-md-2"><input type="text" class="form-control"
					id="spec" name="spec" placeholder="请输入商品规格" /></td>
				<td class="col-md-1"
					style="vertical-align: middle; text-align: center" rowspan="2">
					<button id="search" type="button" class="btn btn-primary"
						onclick="refGrid()">查询</button>
				</td>
			</tr>

			<tr>
				<td class="col-md-1"><label class="control-label">商品所属栏目</label></td>
				<td class="col-md-3"><select id="primaryCategory"
					name="primaryCategory" class="form-control"><option
							value=''>全部</option> ${goodsModel.primaryCategoryList}
				</select></td>
				<td class="col-md-1"><label class="control-label">商品所属分类</label></td>
				<td class="col-md-3"><select id="smallCategory"
					name="smallCategory" class="form-control"><option value=''>全部</option>
						${goodsModel.smallCategoryList}
				</select></td>
				<td class="col-md-1"><label class="control-label"></label> <label>需要补货商品
				</label></td>
				<td class="col-md-2" align="center"><input type="checkbox"
					value="" id="checkCount" /></td>
			</tr>
		</tbody>
	</table>

	<!--     商品添加按钮 -->
	<button style="float: left; margin-top: 11px;" class="btn btn-link"
		onclick="location.href='${pageContext.request.contextPath}/inventory/inventory_goods_detail.html'">
		<span class="glyphicon glyphicon-plus"></span>添加商品
	</button>
	<button style="float: left; margin-top: 11px;" class="btn btn-link"
		onclick="delPhy()">
		<span class="glyphicon glyphicon-remove"></span>删除商品
	</button>
	<button style="float: left; margin-top: 11px;" class="btn btn-link"
		onclick="delGrid()">
		<span class="glyphicon glyphicon-remove-circle"></span>商品下架
	</button>

	<table id="goodsListTbl" class="table table-striped"></table>

	<!-- 模态框（Modal） -->
	<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">确认</h4>
				</div>
				<div class="modal-body">确定要下架此商品吗？</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
					<button id="deleteDo" type="button" class="btn btn-primary">
						提交</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
	</div>
	<!-- /.modal -->

	<div class="modal fade" id="deletePhyModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">确认</h4>
				</div>
				<div class="modal-body">确定要删除吗？</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
					<button id="deletePhyDo" type="button" class="btn btn-primary">
						提交</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
	</div>
	<!-- /.modal -->

	<div class="modal fade" id="recoveryModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">确认</h4>
				</div>
				<div class="modal-body">确定要让此商品重新上架吗？</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
					<button id="recoveryDo" type="button" class="btn btn-primary">
						提交</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
	</div>
	<!-- /.modal -->
</body>
</html>