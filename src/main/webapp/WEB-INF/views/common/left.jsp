<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <div class="sidebar-nav">
   	<ul>
	   <c:forEach items="${sessionScope.menu}" var="menuVo">
	   		<li><a href="#" onclick="changeMeun()" data-target="#${menuVo.resIcon}" class="nav-header <c:if test="${sessionScope.active ne menuVo.resId}">collapsed</c:if>" data-toggle="collapse"><i class="fa fa-fw fa-dashboard"></i> ${menuVo.resName}<i class="fa fa-collapse"></i></a></li>
	   		<li><ul id="${menuVo.resIcon}" class="nav nav-list collapse <c:if test="${sessionScope.active eq menuVo.resId}">in</c:if>">
   					<c:forEach items="${menuVo.child}" var="child" >
		   				<li><a href="${pageContext.request.contextPath}${child.resUrl}" <c:if test="${sessionScope.url eq child.resUrl}">style="background: #d2d2dd"</c:if> ><span class="fa fa-caret-right"></span> ${child.resName}</a></li>
		   			</c:forEach>
		   	</ul></li>
	   </c:forEach>
	</ul>
</div>
