<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="navbar navbar-default" role="navigation">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle collapsed"
			data-toggle="collapse" data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="" href="index.html"><span class="navbar-brand"><span
				class="fa fa-paper-plane"></span> 某某企业管理系统</span></a>
	</div>
	<div class="navbar-collapse collapse" style="height: 1px;">
		<ul id="main-menu" class="nav navbar-nav navbar-right">
			<li class="dropdown hidden-xs"><a href="#"
				class="dropdown-toggle" data-toggle="dropdown"> <span
					class="glyphicon glyphicon-user padding-right-small"
					style="position: relative; top: 3px;"></span>
					${sessionScope.user.userName} <i class="fa fa-caret-down"></i>
			</a>
			<ul class="dropdown-menu">
				<li><a tabindex="-1" href="#" data-toggle="modal" data-target="#modifyPasswordModal">修改密码</a></li>
				<li><a tabindex="-1" href="#" onclick="logOut()">注销</a></li>
			</ul></li>
		</ul>
	</div>
</div>
<!-- 登出操作 -->
<c:url var="logoutUrl" value="/logout"/>
	<form id="logOut" action="${logoutUrl}"
		method="post" class="hidden">
	<input type="submit"
		value="Log out" />
	<input type="hidden"
		name="${_csrf.parameterName}"
	value="${_csrf.token}"/>
</form>


<!-- 修改密码模态框（Modal） -->
<div class="modal fade" id="modifyPasswordModal" tabindex="-1" role="dialog"
   aria-labelledby="modifyPasswordModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content" style="width:70%;">
		<form id="modifyPasswordForm" class="form-horizontal" role="form">
			<div class="modal-header">
	            <button type="button" class="close" 
	               data-dismiss="modal" aria-hidden="true">
	                  &times;
	            </button>
	            <h4 class="modal-title" id="myModalLabel">
	               			修改密码
	            </h4>
         	</div>
         	<div class="modal-body">
         				
				   <div class="form-group ">
		                <label class="col-sm-3 control-label">新&nbsp;&nbsp;密&nbsp;&nbsp;码&nbsp;<span class="text-danger">*</label>
		                <div class="col-sm-9">
		                    <input id="newPassword" type="password" name="newPassword" class="validate[required,maxSize[100]] form-control"
		                    placeholder="请输入新密码（必填*）">
		                </div>
	               </div>
	               
	                <div class="form-group ">
		                <label class="col-sm-3 control-label">确认密码&nbsp;<span class="text-danger">*</label>
		                <div class="col-sm-9">
		                    <input type="password" name="newPasswordConfirm" class="validate[required,equals[newPassword],maxSize[100]] form-control"
		                    placeholder="请再次输入新密码（必填*）">
		                </div>
	               </div>
	               
	               <input type="hidden" name="id" value="${sessionScope.user.id}">
            </div> 
	         <div class="modal-footer">
	            <button type="button" class="btn btn-default" 
	               data-dismiss="modal">取消
	            </button>
	            <button id="updateSubmit" type="button" class="btn btn-primary">
	               						更新
	            </button>
	         </div>
         </form>
      </div>
   </div>
</div>

<!-- 修改密码成功，重新登陆模态框 -->
<div class="modal fade" id="modifyPasswordConfirmModal" tabindex="-1" role="dialog" 
   aria-labelledby="modifyPasswordModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
			<div class="modal-header">
	            <button type="button" class="close" 
	               data-dismiss="modal" aria-hidden="true">
	                  &times;
	            </button>
	            <h4 class="modal-title" id="myModalLabel">
	               			提示
	            </h4>
         	</div>
         	<div class="modal-body">			
				  修改密码成功，请重新登录！
            </div> 
	         <div class="modal-footer">
	         
	            <button id="updateConfirm" type="button" class="btn btn-primary">
	               						确认
	            </button>
	        </div>
      </div>
   </div>
</div>

