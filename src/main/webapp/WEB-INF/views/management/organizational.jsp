<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>组织人员管理</title>
		<link href="${pageContext.request.contextPath }/resources/css/management/organizational.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath }/resources/zTree/css/metroStyle/metroStyle.css" rel="stylesheet" type="text/css">
		<!--js-->
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/zTree/js/jquery.ztree.core.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/management/organizational.js"></script>
	</head>
<body>
<!-- 头部 -->
	<div id="alert"></div>
	<div class="header">
		<h1 class="page-title">组织人员管理</h1>
		<ul class="breadcrumb">
			<li><a href="${pageContext.request.contextPath }/account/index/show.html">主页</a> </li>
			<li class="active">组织人员管理</li>
        </ul>
	</div>
    <!-- 查询面板 -->
    <div class="col-md-4 col-sm-12 col-xs-12">
    	<div class="btn-group" style="margin-bottom:10px;">
		    <button type="button" class="btn btn-link dropdown-toggle" data-toggle="dropdown">
		      <span class="glyphicon glyphicon-plus"></span> 新增
		    </button>
		    <ul class="dropdown-menu">
		      <li>
		      	<button id="dep" class="btn btn-link btn-sm" data-toggle="modal" data-target="#addDepModal">
					<span class="glyphicon glyphicon-bookmark"></span>&nbsp;&nbsp;添加部门
				</button>
		      </li>
		      <li class="divider"></li>
		      <li>
		      	<button id="position" class="btn btn-link btn-sm" data-toggle="modal" data-target="#addPositionModal">
					<span class="glyphicon glyphicon-education"></span>&nbsp;&nbsp;添加职位
				</button>
		      </li>
		      <li class="divider"></li>
		      <li>
		      	<button id="person"  class="btn btn-link btn-sm" data-toggle="modal" data-target="#addPersonModal">
					<span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;添加人员
				</button>
		      </li>
		    </ul>
		  <button id="orgEdit" type="button" class="btn btn-link">
		      <span class="glyphicon glyphicon-edit"></span> 编辑
		  </button>
		  <button id="orgRemove" type="button" class="btn btn-link">
		      <span class="glyphicon glyphicon-remove"></span> 删除
		  </button>
		  <button id="moveOrg" type="button" class="btn btn-link" class="btn btn-link">
		     <span class="glyphicon glyphicon-share-alt"></span> 移动
		  </button>
		  <button id="order" type="button" class="btn btn-link">
		     <span class="glyphicon glyphicon-sort"></span> 排序
		  </button>
		</div>
		
    	<ul id="tree" class="ztree"></ul>
	</div>
    <div class="col-md-8 col-sm-12 col-xs-12">
    	<form id="searchFrom">
    		<input type="hidden" name="orgFid"/>
    	</form>
    	<button style="float: left;margin-top:-10px;" class="btn  btn-link" data-toggle="modal"
			data-target="#reportModal">
			<span class="glyphicon glyphicon-import"></span> Excle导入
		</button>
		<button id="removeAllUser" style="float: left;margin-top:-10px;" class="btn btn-link" >
			<span class="glyphicon glyphicon-remove"></span> 批量删除
		</button>
		<button id="moveUser" style="float: left;margin-top:-10px;" class="btn btn-link">
			<span class="glyphicon glyphicon-share-alt"></span> 调岗
		</button>
		<!-- table -->
		<table id="userListTbl" class="table table-striped"></table>
    </div>
<!-- 添加部门模态框（Modal） -->
<div class="modal fade" id="addDepModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
     	 <form id="addDepFrom" class="form-horizontal" role="form">
         <div class="modal-header">
         	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h4 class="modal-title" id="myModalLabel">添加部门信息</h4>
         </div>
         <div class="modal-body">
         	
         		<div class="form-group">
				    <label class="col-sm-2 control-label">父节点名&nbsp;&nbsp;</label>
				    <div class="col-sm-9">
				      <p class="form-control-static" style="color: #767676;"></p>
				    </div>
				</div>
         		<div class="form-group">
			      <label for="firstname" class="col-sm-2 control-label">部门名称&nbsp;<span class="text-danger">*</span></label>
			      <div class="col-sm-9">
			         <input type="text" id="orgName" class="validate[required,maxSize[20],ajax[checkAddDepNameIsExist]] form-control" name="orgName" 
			            placeholder="请输入部门名称（必填*）">
			      </div>
			   </div>
			   <div class="form-group">
			      <label for="firstname" class="col-sm-2 control-label">描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述&nbsp;&nbsp;</label>
			      <div class="col-sm-9">
			      	 <textarea name="comments"  class="validate[maxSize[20]] form-control" rows="3" placeholder="请输入部门描述"></textarea>
			      </div>
			   </div>
			   <input type="hidden" id="parentId" name="parentId"/>
			   <input type="hidden" name="orgFid"/>
			   <input type="hidden" name="orgFname"/>
			   <input type="hidden" id="orgType" name="orgType"/>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal"> 取消</button>
            <button id="addDepSubmit" type="button" class="btn btn-primary submit">添加</button>
         </div>
         	</form>
      </div><!-- /.modal-content -->
   </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 更新部门模态框（Modal） -->
<div class="modal fade" id="updateDepModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
     	 <form id="updateDepFrom" class="form-horizontal" role="form">
         <div class="modal-header">
         	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h4 class="modal-title" id="myModalLabel">修改部门信息</h4>
         </div>
         <div class="modal-body">
         		<div class="form-group">
				    <label class="col-sm-2 control-label">父节点名&nbsp;&nbsp;</label>
				    <div class="col-sm-9">
				      <p class="form-control-static" style="color: #767676;"></p>
				    </div>
				</div>
         		<div class="form-group">
			      <label for="firstname" class="col-sm-2 control-label">部门名称&nbsp;<span class="text-danger">*</span></label>
			      <div class="col-sm-9">
			         <input type="text" id="uOrgName" class="validate[required,maxSize[20],ajax[checkUpdateDepNameIsExist]] form-control" name="orgName" 
			            placeholder="请输入部门名称（必填*）">
			      </div>
			   </div>
			   <div class="form-group">
			      <label for="firstname" class="col-sm-2 control-label">描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述&nbsp;&nbsp;</label>
			      <div class="col-sm-9">
			      	 <textarea name="comments"  class="validate[maxSize[20]] form-control" rows="3" placeholder="请输入部门描述"></textarea>
			      </div>
			   </div>
			   <input type="hidden" name="id"/>
			   <input type="hidden" id="parentId" name="parentId"/>
			   <input type="hidden" name="orgFid"/>
			   <input type="hidden" name="orgFname"/>
			   <input type="hidden" id="orgType" name="orgType"/>
			   <input type="hidden" id="oldFieldValue" name="oldOrgName"/>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal"> 取消</button>
            <button id="updateDepSubmit" type="button" class="btn btn-primary submit">更新</button>
         </div>
         	</form>
      </div><!-- /.modal-content -->
   </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 添加职位模态框（Modal） -->
<div class="modal fade" id="addPositionModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
     	 <form id="addPositionFrom" class="form-horizontal" role="form">
         <div class="modal-header">
         	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h4 class="modal-title" id="myModalLabel">添加职位信息</h4>
         </div>
         <div class="modal-body">
         	
         		<div class="form-group">
				    <label class="col-sm-2 control-label">父节点名&nbsp;&nbsp;</label>
				    <div class="col-sm-9">
				      <p class="form-control-static" style="color: #767676;"></p>
				    </div>
				</div>
         		<div class="form-group">
			      <label for="firstname" class="col-sm-2 control-label">职位名称&nbsp;<span class="text-danger">*</span></label>
			      <div class="col-sm-9">
			         <input type="text" id="pOrgName" class="validate[required,maxSize[20],ajax[checkAddDepNameIsExist]] form-control" name="orgName" 
			            placeholder="请输入职位名称（必填*）">
			      </div>
			   </div>
			   <div class="form-group">
			      <label for="firstname" class="col-sm-2 control-label">描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述&nbsp;&nbsp;</label>
			      <div class="col-sm-9">
			      	 <textarea name="comments"  class="validate[maxSize[20]] form-control" rows="3" placeholder="请输入部门描述"></textarea>
			      </div>
			   </div>
			   <input type="hidden" id="parentId" name="parentId"/>
			   <input type="hidden" id="orgType" name="orgType"/>
			   <input type="hidden" name="orgFid"/>
			   <input type="hidden" name="orgFname"/>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal"> 取消</button>
            <button id="addPositionSubmit" type="button" class="btn btn-primary submit">添加</button>
         </div>
         	</form>
      </div><!-- /.modal-content -->
   </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 更新职位模态框（Modal） -->
<div class="modal fade" id="updatePositionModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
     	 <form id="updatePositionFrom" class="form-horizontal" role="form">
         <div class="modal-header">
         	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h4 class="modal-title" id="myModalLabel">修改职位信息</h4>
         </div>
         <div class="modal-body">
         		<div class="form-group">
				    <label class="col-sm-2 control-label">父节点名&nbsp;&nbsp;</label>
				    <div class="col-sm-9">
				      <p class="form-control-static" style="color: #767676;"></p>
				    </div>
				</div>
         		<div class="form-group">
			      <label for="firstname" class="col-sm-2 control-label">职位名称&nbsp;<span class="text-danger">*</span></label>
			      <div class="col-sm-9">
			         <input type="text" id="uPOrgName" class="validate[required,maxSize[20],ajax[checkUpdateDepNameIsExist]] form-control" name="orgName" 
			            placeholder="请输入部门名称（必填*）">
			      </div>
			   </div>
			   <div class="form-group">
			      <label for="firstname" class="col-sm-2 control-label">描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述&nbsp;&nbsp;</label>
			      <div class="col-sm-9">
			      	 <textarea name="comments"  class="validate[maxSize[20]] form-control" rows="3" placeholder="请输入部门描述"></textarea>
			      </div>
			   </div>
			   <input type="hidden" name="id"/>
			   <input type="hidden" id="parentId" name="parentId"/>
			   <input type="hidden" name="orgFid"/>
			   <input type="hidden" name="orgFname"/>
			   <input type="hidden" id="orgType" name="orgType"/>
			   <input type="hidden" id="oldFieldValue" name="oldOrgName"/>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal"> 取消</button>
            <button id="updatePositionSubmit" type="button" class="btn btn-primary submit">更新</button>
         </div>
         	</form>
      </div><!-- /.modal-content -->
   </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 删除组织模态框（Modal） -->
<div class="modal fade" id="removeOrgModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">&times;
            </button>
            <h4 class="modal-title" id="myModalLabel">确认</h4>
         </div>
         <div id="message" class="modal-body">您确定要删除此条数据吗？</div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button type="button" id="removeOrgSubmit" class="btn btn-primary"> 确认</button>
         </div>
      </div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- 添加人员模态框（Modal） -->
<div class="modal fade" id="addPersonModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
     	 <form id="addPersonFrom" class="form-horizontal" role="form">
         <div class="modal-header">
         	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h4 class="modal-title" id="myModalLabel">添加人员信息</h4>
         </div>
         <div class="modal-body">
         	<h4>基本信息</h4>
         	<div class="" style="border-radius: 8px;border:1px solid #C0C0C0; padding: 0px 8px 0px 8px;">
         		</br>
         		<div class="form-group">
				    <label class="col-sm-2 control-label">父节点名&nbsp;</label>
				    <div class="col-sm-9">
				      <p class="form-control-static" style="color: #767676;"></p>
				    </div>
				</div>
				<div class="form-group">
			      <label for="firstname" class="col-sm-2 control-label">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名&nbsp;<span class="text-danger">*</span></label>
			      <div class="col-sm-9">
			         <input type="text" class="validate[required,maxSize[50]] form-control" name="userName" 
			            placeholder="请输入姓名（必填*）">
			      </div>
			   	</div>
			   	<div class="form-group">
				      <label for="name" class="col-sm-2 control-label">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别&nbsp;<span class="text-danger">*</span></label>
				      <div class="col-sm-9" style="padding-top: 5px;">
			      		<span>
							<input type="radio" id="flat-radio-1" name="sex" value="男" checked>
								<label for="flat-radio-1">&nbsp;男</label> &nbsp;&nbsp;&nbsp;&nbsp;
						</span>
						<span>
							<input type="radio"  id="flat-radio-2" name="sex" value="女" > 
								<label for="flat-radio-2">&nbsp;女</label> &nbsp;&nbsp;&nbsp;&nbsp;
						</span>
				      </div>
				</div>
				<div class="form-group">
			      	<label for="firstname" class="col-sm-2 control-label">手机号码&nbsp;<span class="text-danger">*</span></label>
			      	<div class="col-sm-9">
			         	<input type="text" class="validate[required,custom[integer],custom[phone],maxSize[11]] form-control" name="phone" 
			            placeholder="请输入手机号码（必填*）">
			      </div>
			   	</div>
			   	<div class="form-group">
			      <label for="firstname" class="col-sm-2 control-label">身份证号&nbsp;<span class="text-danger">*</span></label>
			      <div class="col-sm-9">
			         <input type="text" class="validate[required,maxSize[18],ajax[checkAddCardId]] form-control" name="cardId" 
			            placeholder="请输入身份证号（必填*）">
			      </div>
			   	</div>	
			</div></br>
			<h4>详细信息</h4>
         	<div class="rows" style="border-radius: 10px;border:1px solid #C0C0C0">
         		</br>
         		<div class="form-group col-sm-6">
			      <label for="firstname" class="col-sm-4 control-label">英&nbsp;&nbsp;文&nbsp;&nbsp;名</label>
			      <div class="col-sm-8">
			         <input type="text" class="validate[maxSize[50]] form-control" name="nameEng"
			         placeholder="请输入英文名">
			      </div>
			   	</div>	
         		<div class="form-group col-sm-6">
			      <label for="firstname" class="col-sm-4 control-label">拼&nbsp;&nbsp;音&nbsp;&nbsp;码</label>
			      <div class="col-sm-8">
			         <input type="text" class="validate[maxSize[10]] form-control" name="alpphaCd"
			         placeholder="请输入拼音码">
			      </div>
			   	</div>			   		   	
			   	<div class="form-group col-sm-6">
			      <label for="firstname" class="col-sm-4 control-label">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄</label>
			      <div class="col-sm-8">
			         <input type="text" class="validate[maxSize[11],custom[integer]] form-control" name="age"
			         placeholder="请输入年龄">
			      </div>
			   	</div>
			   	<div class="form-group col-sm-6">
			      <label for="firstname" class="col-sm-4 control-label">工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄</label>
			      <div class="col-sm-8">
			         <input type="text" class="validate[maxSize[11],custom[integer]] form-control" name="workYears"
			         placeholder="请输入工龄">
			      </div>
			   	</div>			   
			   <div class="form-group">
			      <label for="firstname" class="col-sm-2 control-label">联系电话</label>
			      <div class="col-sm-9">
			         <input type="text" class="validate[maxSize[50],custom[integer]] form-control" name="phone2"
			         placeholder="请输入联系电话">
			      </div>
			   </div>
			   <div class="form-group">
			      <label for="firstname" class="col-sm-2 control-label">微信账号</label>
			      <div class="col-sm-9">
			         <input type="text" class="validate[maxSize[50]] form-control" name="msm1"
			         placeholder="请输入微信账号">
			      </div>
			   	</div>
			   	<div class="form-group">
			      <label for="firstname" class="col-sm-2 control-label">Q&nbsp;&nbsp;Q账号</label>
			      <div class="col-sm-9">
			         <input type="text" class="validate[maxSize[50],custom[integer]] form-control" name="msm2"
			         placeholder="请输入QQ账号">
			      </div>
			   	</div>	
			   <div class="form-group">
			      <label for="firstname" class="col-sm-2 control-label">电子邮箱</label>
			      <div class="col-sm-9">
			         <input type="text" class="validate[custom[email] maxSize[50]] form-control" name="email"
			         placeholder="请输入电子邮箱">
			      </div>
			   </div>    	
         	</div>
			   <input type="hidden" name="orgId"/>
			   <input type="hidden" name="orgName"/>
			   <input type="hidden" name="userFid"/>
			   <input type="hidden" name="userFname"/>
			   
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal"> 取消</button>
            <button id="addPersonSubmit" type="button" class="btn btn-primary submit">添加</button>
         </div>
         	</form>
      </div><!-- /.modal-content -->
   </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 修改人员模态框（Modal） -->
<div class="modal fade" id="updatePersonModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
     	 <form id="updatePersonFrom" class="form-horizontal" role="form">
         <div class="modal-header">
         	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h4 class="modal-title" id="myModalLabel">更新人员信息</h4>
         </div>
         <div class="modal-body">
				<h4>基本信息</h4>
			  <div class="" style="border-radius: 10px;border:1px solid #C0C0C0; padding: 0px 8px 0px 8px;">
				  	</br>
					  <div class="form-group">
						   <label class="col-sm-2 control-label"></label>
						   <div class="col-sm-9">
						   		<p class="userBass form-control-static" style="color: #767676;"></p>
							 </div>
						</div>	
						<div class="form-group">
								<label for="firstname" class="col-sm-2 control-label">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名&nbsp;<span class="text-danger">*</span></label>
								<div class="col-sm-9">
								   <input type="text" class="validate[required,maxSize[50]] form-control" name="userName" 
								            placeholder="请输入姓名（必填*）">
								</div>
						</div>
						<div class="form-group">
								<label for="name" class="col-sm-2 control-label">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别&nbsp;<span class="text-danger">*</span></label>
								<div class="col-sm-9" style="padding-top: 5px;">
								 		<span>
												<input type="radio" id="flat-radio-1" name="sex" value="男"/>
												<label for="flat-radio-1">&nbsp;男</label> &nbsp;&nbsp;&nbsp;&nbsp;
										</span>
										<span>
												<input type="radio"  id="flat-radio-2" name="sex" value="女"/> 
												<label for="flat-radio-2">&nbsp;女</label> &nbsp;&nbsp;&nbsp;&nbsp;
										</span>
								</div>
						</div>	
					 	<div class="form-group">
						    <label for="firstname" class="col-sm-2 control-label">手机号码&nbsp;<span class="text-danger">*</span></label>
						    <div class="col-sm-9">
						        <input type="text" class="validate[required,custom[phone],custom[integer],maxSize[11]] form-control" name="phone" 
						            placeholder="请输入手机号码（必填*）">
						    </div>
						</div>		
						<div class="form-group">
						    <label for="firstname" class="col-sm-2 control-label">身份证号&nbsp;<span class="text-danger">*</span></label>
						      <div class="col-sm-9">
						         <input type="text" class="validate[required,maxSize[18],ajax[checkUpdateCardId]] form-control" name="cardId" 
						            placeholder="请输入身份证号（必填*）">
						      </div>
						</div>	
				</div></br>
				
				<h4>详细信息</h4>
			  <div class="rows" style="border-radius: 10px;border:1px solid #C0C0C0">
			   		</br>			
			   		<div class="form-group col-sm-6">
					      <label for="firstname" class="col-sm-4 control-label">英&nbsp;&nbsp;文&nbsp;&nbsp;名</label>
					      <div class="col-sm-8">
						         <input type="text" class="validate[maxSize[50]] form-control" name="nameEng"
						         placeholder="请输入英文名">
					      </div>
					 	</div>
					 	<div class="form-group col-sm-6">
					      <label for="firstname" class="col-sm-4 control-label">拼&nbsp;&nbsp;音&nbsp;&nbsp;码</label>
					      <div class="col-sm-8">
						         <input type="text" class="validate[maxSize[10]] form-control" name="alpphaCd"
						         placeholder="请输入拼音码">
					      </div>
					 	</div>			   	
					 	<div class="form-group col-sm-6">
					      <label for="firstname" class="col-sm-4 control-label">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄</label>
					      <div class="col-sm-8">
						         <input type="text" class="validate[maxSize[11],custom[integer]] form-control" name="age"
						         placeholder="请输入年龄">
					      </div>
					 	</div>
					 	<div class="form-group col-sm-6">
					      <label for="firstname" class="col-sm-4 control-label">工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄</label>
					      <div class="col-sm-8">
						         <input type="text" class="validate[maxSize[11],custom[integer]] form-control" name="workYears"
						         placeholder="请输入工龄">
					      </div>
					 	</div>
					  <div class="form-group">
					      <label for="firstname" class="col-sm-2 control-label">联系电话</label>
					      <div class="col-sm-9">
						         <input type="text" class="validate[maxSize[50],custom[integer]] form-control" name="phone2"
						         placeholder="请输入联系电话">
					      </div>
					  </div>
					  <div class="form-group">
					      <label for="firstname" class="col-sm-2 control-label">微信账号</label>
					      <div class="col-sm-9">
						         <input type="text" class="validate[maxSize[50]] form-control" name="msm1"
						         placeholder="请输入微信账号">
					      </div>
					 	</div>
					 	<div class="form-group">
					      <label for="firstname" class="col-sm-2 control-label">Q&nbsp;&nbsp;Q账号</label>
					      <div class="col-sm-9">
						         <input type="text" class="validate[maxSize[50],custom[integer]] form-control" name="msm2"
						         placeholder="请输入QQ账号">
					      </div>
					 	</div>	
					  <div class="form-group">
					      <label for="firstname" class="col-sm-2 control-label">电子邮箱</label>
					      <div class="col-sm-9">
						         <input type="text" class="validate[custom[email] maxSize[50]] form-control" name="email"
						         placeholder="请输入电子邮箱">
					      </div>
					  </div>			  
			   </div>
			   	<input type="hidden" name="id"/>
				<input type="hidden" name="userFname"/>
				<input type="hidden" id="oldFieldValue"/>
			</div>
			   
         <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal"> 取消</button>
            <button id="updatePersonSubmit" type="button" class="btn btn-primary submit">更新</button>
         </div>
         	</form>
      </div><!-- /.modal-content -->
   </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 删除组织模态框（Modal） -->
<div class="modal fade" id="removeAllUserModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">&times;
            </button>
            <h4 class="modal-title" id="myModalLabel">确认</h4>
         </div>
         <div id="message" class="modal-body">您确定要删除被选中的数据吗？</div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button type="button" id="removeAllUserSubmit" class="btn btn-primary"> 确认</button>
         </div>
      </div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 删除组织模态框（Modal） -->
<div class="modal fade" id="removeUserModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">&times;
            </button>
            <h4 class="modal-title" id="myModalLabel">确认</h4>
         </div>
         <div id="message" class="modal-body"></div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button type="button" id="removeUserSubmit" class="btn btn-primary"> 确认</button>
         </div>
      </div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 查看用户信息模态框（userNameInfoModal） -->
<div class="modal fade" id="userNameInfoModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
     	 <form id="userNameInfoFrom" class="form-horizontal" role="form">
         <div class="modal-header">
         	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h4 class="modal-title" id="myModalLabel">人员基本信息</h4>
         </div>
         <div class="modal-body">
				<h4>基本信息</h4>
				<div class="" style="border-radius: 10px;border:1px solid #C0C0C0">
				  	</br>
		     		<div class="form-group">
						    <label class="col-sm-2 control-label"></label>
						    <div class="col-sm-9">
						      <p class="userBass form-control-static" style="color: #767676;"></p>
						    </div>
						</div>
						<div class="form-group">
					      <label for="firstname" class="col-sm-2 control-label">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</label>
					      <div class="col-sm-9">
					         <input type="text" class="form-control" disabled="disabled" name="userName" 
					            placeholder="请输入姓名（必填*）">
					      </div>
					  </div>
						<div class="form-group">
					  		<label for="name" class="col-sm-2 control-label" >性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别</label>
						    <div class="col-sm-9">
					      		<span>
									<input type="radio" id="flat-radio-1" name="sex" value="男" readonly="true"/>
									<label for="flat-radio-1">&nbsp;男</label> &nbsp;&nbsp;&nbsp;&nbsp;
								</span>
								<span>
									<input type="radio"  id="flat-radio-2" name="sex" value="女" readonly="true"/> 
									<label for="flat-radio-2">&nbsp;女</label> &nbsp;&nbsp;&nbsp;&nbsp;
								</span>
						    </div>
						</div>
						<div class="form-group">
					      <label for="firstname" class="col-sm-2 control-label">手机号码</label>
					      <div class="col-sm-9">
					         <input type="text" class="readonly form-control" disabled="disabled" name="phone" 
					            placeholder="请输入手机号码（必填*）">
					      </div>
					  </div>
						<div class="form-group">
					      <label for="firstname" class="col-sm-2 control-label">身份证号</label>
					      <div class="col-sm-9">
					         <input type="text" class="form-control" disabled="disabled" name="cardId" 
					            placeholder="请输入身份证号（必填*）">
					      </div>
					  </div>				
		     </div></br>
				 <h4>详细信息</h4>
					<div class="rows" style="border-radius: 10px;border:1px solid #C0C0C0">
					 		</br>	
							<div class="form-group  col-sm-6">
					    	  <label for="firstname" class="col-sm-4 control-label">英&nbsp;&nbsp;文&nbsp;&nbsp;名</label>
					      	<div class="col-sm-8">
					        	 <input type="text" class="readonly form-control" disabled="disabled" name="nameEng"
					        	 placeholder="请输入英文名">
					      	</div>
					   	</div>		
					   	<div class="form-group  col-sm-6">
					      <label for="firstname" class="col-sm-4 control-label">拼&nbsp;&nbsp;音&nbsp;&nbsp;码</label>
					      <div class="col-sm-8">
					         <input type="text" class="readonly form-control" disabled="disabled" name="alpphaCd"
					         placeholder="请输入拼音码">
					      </div>
					   	</div>
					   	<div class="form-group  col-sm-6">
					      <label for="firstname" class="col-sm-4 control-label">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄</label>
					      <div class="col-sm-8">
					         <input type="text" class="readonly form-control" disabled="disabled" name="age"
					         placeholder="请输入年龄">
					      </div>
					   	</div>
					   	<div class="form-group  col-sm-6">
					      <label for="firstname" class="col-sm-4 control-label">工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄</label>
					      <div class="col-sm-8">
					         <input type="text" class="readonly form-control" disabled="disabled" name="workYears"
					         placeholder="请输入工龄">
					      </div>
					   	</div>	
					    <div class="form-group">
					      <label for="firstname" class="col-sm-2 control-label">&nbsp;联系电话</label>
					      <div class="col-sm-9">
					         <input type="text" class="readonly form-control" disabled="disabled" name="phone2"
					         placeholder="请输入联系电话">
					      </div>
					    </div>
					   <div class="form-group">
					      <label for="firstname" class="col-sm-2 control-label">&nbsp;微信账号</label>
					      <div class="col-sm-9">
					         <input type="text" class="readonly form-control" disabled="disabled" name="msm1"
					         placeholder="请输入微信账号">
					      </div>
					   	</div>
					   	<div class="form-group">
					      <label for="firstname" class="col-sm-2 control-label">&nbsp;Q&nbsp;&nbsp;Q账号</label>
					      <div class="col-sm-9">
					         <input type="text" class="readonly form-control" disabled="disabled" name="msm2"
					         placeholder="请输入QQ账号">
					      </div>
					   	</div>	
					   <div class="form-group">
					      <label for="firstname" class="col-sm-2 control-label">&nbsp;电子邮箱</label>
					      <div class="col-sm-9">
					         <input type="text" class="form-control readonly" disabled="disabled" name="email"
					         placeholder="请输入电子邮箱">
					      </div>
					   </div>
		 		</div>
		</div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal"> 关闭</button>
         </div>
         	</form>
      </div><!-- /.modal-content -->
   </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 人员调岗模态框（Modal） -->
<div class="modal fade" id="moveUserModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">&times;
            </button>
            <h4 class="modal-title" id="myModalLabel">人员调岗</h4>
         </div>
         <div id="message" class="modal-body">
         	<iframe name="moveUserIframe" frameborder="0" height="500px" width="100%" noresize="noresize"></iframe>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button type="button" id="moveUserSubmit" class="btn btn-primary"> 确认</button>
         </div>
      </div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 人员调岗确认模态框（Modal） -->
<div class="modal fade" id="moveUserConfirmModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">&times;
            </button>
            <h4 class="modal-title" id="myModalLabel">确认</h4>
         </div>
         <div id="moveUserMessage" class="modal-body">您确定要删除当前数据吗？</div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button type="button" id="moveUserConfirmSubmit" class="btn btn-primary"> 确认</button>
         </div>
      </div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- 组织移动模态框（Modal） -->
<div class="modal fade" id="moveOrgModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">&times;
            </button>
            <h4 class="modal-title" id="myModalLabel">组织移动</h4>
         </div>
         <div id="message" class="modal-body">
         	<iframe name="moveOrgIframe" frameborder="0" height="500px" width="100%" noresize="noresize"></iframe>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button type="button" id="moveOrgSubmit" class="btn btn-primary"> 确认</button>
         </div>
      </div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 组织移动确认模态框（Modal） -->
<div class="modal fade" id="moveOrgConfirmModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">&times;
            </button>
            <h4 class="modal-title" id="myModalLabel">确认</h4>
         </div>
         <div id="moveOrgMessage" class="modal-body">您确定要删除当前数据吗？</div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button type="button" id="moveOrgConfirmSubmit" class="btn btn-primary"> 确认</button>
         </div>
      </div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</body>
</html>