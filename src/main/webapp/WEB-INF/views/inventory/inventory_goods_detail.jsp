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
	src="${pageContext.request.contextPath }/resources/bootstrap/js/ajaxfileupload.js"></script>
<%--         <script type="text/javascript" src="${pageContext.request.contextPath }/resources/ckeditor/ckeditor.js"></script> --%>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/unit/commonCheckUtil.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/unit/jquery.qrcode.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/inventory/inventory_goods_detail.js"></script>
</head>
<body>
	<!-- 头部 -->
	<div id="alert"></div>
	<div class="header">
		<h1 class="page-title">商品详细</h1>
		<ul class="breadcrumb">
			<li><a
				href="${pageContext.request.contextPath}/account/index/show.html">主页</a></li>
			<li><a
				href="${pageContext.request.contextPath}/inventory/inventory_goods_list">商品一览</a></li>
			<li class="active"><span>商品详细</span></li>
		</ul>
	</div>
	<!-- table -->

	<form id="goodsForm" method="post" name="goodsForm"
		class="form-horizontal" role="form"
		action="${pageContext.request.contextPath}/inventory/edit_goods_detail.html">
		<div class="form-group">
			<label for="goodsName" class="col-md-2 control-label">商品名称</label>
			<div class="col-md-4">
				<input type="text"
					class="validate[maxSize[20],required] form-control" id="goodsName"
					name="goodsName" placeholder="请输入商品名称（必填*）"
					value="${goodsModel.goodsName}">
			</div>
		</div>

		<div class="form-group">
			<label for="spec" class="col-md-2 control-label">商品规格</label>
			<div class="col-md-4">
				<input type="text"
					class="validate[maxSize[20],required] form-control" id="spec"
					name="spec" placeholder="请输入商品规格（必填*）" value="${goodsModel.spec}">
			</div>
		</div>

		<div class="form-group">
			<label for="batchCode" class="col-md-2 control-label">商品批号</label>
			<div class="col-md-4">
				<input type="text" class="validate[maxSize[20]] form-control"
					id="batchCode" name="batchCode" placeholder="请输入商品批号"
					value="${goodsModel.batchCode}">
			</div>
		</div>

		<div class="form-group">
			<label for="primaryCategory" class="col-md-2 control-label">商品所属栏目</label>
			<div class="col-md-4">
				<select id="primaryCategory" name="primaryCategory"
					class="form-control"> ${goodsModel.primaryCategoryList}
				</select>
			</div>
		</div>

		<div class="form-group">
			<label for="smallCategory" class="col-md-2 control-label">商品所属分类</label>
			<div class="col-md-4">
				<select id="smallCategory" name="smallCategory" class="form-control">
					${goodsModel.smallCategoryList}
				</select>
			</div>
		</div>

		<div class="form-group">
			<label for="weight" class="col-md-2 control-label">重量</label>
			<div class="col-md-3 form-inline">
				<input type="text"
					class="validate[custom[number],maxSize[17]] form-control commonFormatNumber"
					id="weight" name="weight" formatDecNum="2" placeholder="请输入商重量"
					value="${goodsModel.weight}" /><label for="buyingPrice"
					class="control-label">克</label>
			</div>
		</div>

		<div class="form-group" id="inputPicture1">
			<label for="weight" class="col-md-2 control-label">商品图片</label>
			<div class="col-md-4 form-inline">
				<input type="file" id="picture" name="picture" class=""
					placeholder="请选择商品图片文件"> <input id="_csrf" type="hidden"
					name="${_csrf.parameterName}" value="${_csrf.token}" />
			</div>
		</div>

		<div class="form-group" id="inputPicture2">
			<label for="weight" class="col-md-2 control-label"></label>
			<div class="col-md-4 form-inline">
				<button type="button" id="pictureSubmit" class="btn btn-primary">上传图片</button>
			</div>
		</div>

		<div class="form-group">
			<label for="" class="col-md-2 control-label"></label>
			<div class="col-md-3 form-inline">
				<img id="picSrcImg" alt="" src="${goodsModel.picSrc}" /> <input
					type="hidden" id="picSrc" name="picSrc"
					value="${goodsModel.picSrc}" />
			</div>
		</div>

		<div class="form-group">
			<label for="description" class="col-md-2 control-label">商品描述</label>
			<div class="col-md-4">
				<textarea id="description" name="description"
					class="validate[maxSize[255]] form-control" rows="3"
					placeholder="请输入商品描述">${goodsModel.description}</textarea>
			</div>
		</div>

		<!--        <div class="form-group"> -->
		<!--           <label for="description" class="col-md-2 control-label">商品描述</label> -->

		<!--        </div> -->













		<div class="form-group">
			<label for="buyingPrice" class="col-md-2 control-label">买入价</label>
			<div class="col-md-3 form-inline">
				<input type="text"
					class="validate[custom[number],maxSize[17]] form-control commonFormatNumber"
					id="buyingPrice" name="buyingPrice" formatDecNum="2"
					placeholder="请输入买入价" value="${goodsModel.buyingPrice}"><label
					for="buyingPrice" class="control-label">元</label>
			</div>
		</div>

		<div class="form-group">
			<label for="sellingPrice1" class="col-md-2 control-label">保底价</label>
			<div class="col-md-3 form-inline">
				<input type="text"
					class="validate[custom[number],maxSize[17]] form-control commonFormatNumber"
					id="sellingPrice1" name="sellingPrice1" formatDecNum="2"
					placeholder="请输入 卖出价1" value="${goodsModel.sellingPrice1}"><label
					for="sellingPrice1" class="control-label">元</label>
			</div>
		</div>

		<div class="form-group">
			<label for="sellingPrice2" class="col-md-2 control-label">标签价</label>
			<div class="col-md-3 form-inline">
				<input type="text"
					class="validate[custom[number],maxSize[17]] form-control commonFormatNumber"
					id="sellingPrice2" name="sellingPrice2" formatDecNum="2"
					placeholder="请输入 卖出价2" value="${goodsModel.sellingPrice2}"><label
					for="sellingPrice2" class="control-label">元</label>
			</div>
		</div>

		<!--        <div class="form-group"> -->
		<!--           <label for="sellingPrice3" class="col-md-2 control-label">保留用价格</label> -->
		<!--           <div class="col-md-3 form-inline"> -->
		<!--              <input type="text" class="validate[custom[number],maxSize[11]] form-control commonFormatNumber" id="sellingPrice3" name="sellingPrice3" -->
		<%--                 placeholder="请输入 卖出价3" value="${goodsModel.sellingPrice3}"><label for="sellingPrice3" class="control-label">元</label> --%>
		<!--           </div> -->
		<!--        </div> -->

		<div class="form-group">
			<label for="discount" class="col-md-2 control-label">折扣</label>
			<div class="col-md-3 form-inline">
				<input type="text"
					class="validate[custom[number],maxSize[3]] form-control commonFormatNumber"
					id="discount" name="discount" placeholder="请输入折扣"
					value="${goodsModel.discount}"><label for="sellingPrice3"
					class="control-label">折</label>
			</div>
		</div>

		<div class="form-group">
			<label for="quantity" class="col-md-2 control-label">商品数量</label>
			<div class="col-md-3 form-inline">
				<input type="text"
					class="validate[custom[number],maxSize[13]] form-control commonFormatNumber"
					id="quantity" name="quantity" placeholder="请输入商品数量"
					value="${goodsModel.quantity}">
			</div>
		</div>

		<div class="form-group">
			<label for="replenish" class="col-md-2 control-label">提醒补货数量</label>
			<div class="col-md-3 form-inline">
				<input type="text"
					class="validate[custom[number],maxSize[13]] form-control commonFormatNumber"
					id="replenish" name="replenish" placeholder="请输入提醒补货数量"
					value="${goodsModel.replenish}">
			</div>
		</div>

		<div class="form-group">
			<div class="col-md-2">&nbsp;</div>
			<div class="col-md-3 form-inline">
				<button type="button" id="submitBtn" class="btn btn-primary submit"
					style="float: left;">提交</button>
				<button type="button" id="showQRbtn" onclick="showQRCode()"
					class="btn btn-primary" style="float: left;">查看二维码</button>
			</div>
		</div>

		<input type="hidden" id="goodsId" name="goodsId"
			value="${goodsModel.goodsId}"> <input type="hidden"
			id="pageFlag" name="pageFlag" value="${goodsModel.pageFlag}">
	</form>

	<!-- 	<div class="col-md-4"> -->
	<!--           <div class="adjoined-bottom" style="border: 1px solid #d2d2dd"> -->
	<!--               <div class="grid-container" > -->
	<!--                   <div class="grid-width-100"> -->
	<!--                       <div id="editor"> -->
	<!--                           <h1>Hello world!</h1> -->
	<!--                           <p>I'm an instance of <a href="http://ckeditor.com">CKEditor</a>.</p> -->
	<!--                       </div> -->
	<!--                   </div> -->
	<!--               </div> -->
	<!--           </div> -->
	<!--     </div> -->

	<!-- 商品二维码 -->
	<div class="modal fade" id="QRCodeModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width: 350px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel" align="center">${goodsModel.goodsName}</h4>
				</div>
				<div class="modal-body" align="center">
					<div id="QRCode"></div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

</body>
</html>