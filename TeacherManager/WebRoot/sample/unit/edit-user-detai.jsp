<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查看用户信息</title>
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<!--框架必需end-->
</head>
<body>
	<div class="box1" id="formContent" whiteBg="true">
	<table class="tableStyle" formMode="view">
		<tr>
			<th colspan="2">用户信息</th>
		</tr>
		<tr>
			<td width="150">用户名：</td>
			<td><c:out value="${user.userLoginName}"/></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><c:out value="${user.userPassword}"/></td>
		</tr>
		<tr>
			<td width="150">姓名：</td>
			<td><c:out value="${user.userName}"/></td>
		</tr>
		<tr>
			<td>所属部门：</td>
			<td><c:out value="${user.organization.orgName}"/></td>
		</tr>
		<tr>
			<td>性别：</td>
			<td>
				<c:if test="${user.userSex==1}">男</c:if>
				<c:if test="${user.userSex==0}">女</c:if>
			</td>
		</tr>
		<tr>
			<td>入职时间：</td>
			<td><c:out value="${user.userEmployTime}"/></td>
		</tr>
		<tr>
			<td>学历：</td>
			<td>
				<c:choose>
					<c:when test="${user.userEducation == '1'}">专科</c:when>
					<c:when test="${user.userEducation == '2'}">本科</c:when>
					<c:when test="${user.userEducation == '3'}">硕士</c:when>
					<c:when test="${user.userEducation == '4'}">博士</c:when>
				</c:choose>
			</td>
		</tr>
	</table>
	</div>
</body>
</html>