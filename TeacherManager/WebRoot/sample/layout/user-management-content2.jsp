<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->
</head>
<body>
	<div class="box1" id="formContent" whiteBg="true">
	<table class="tableStyle" formMode="view">
		<tr><th colspan="4">详细信息</th></tr>
		<tr><td width="15%">姓名：</td><td width="35%">张小三</td><td width="15%">性别：</td><td width="35%">男</td</tr>
		<tr><td>曾用名：</td><td>张三</td><td>婚姻情况：</td><td>未婚</td</tr>
		<tr><td>籍贯：</td><td>黑龙江</td><td>民族：</td><td>汉族</td></tr>
		<tr><td>职业：</td><td>软件设计师</td><td>学历：</td><td>本科毕业</td></tr>
		<tr><td>入职时间：</td><td>2012-1-1</td><td>年龄：</td><td>30</td></tr>
		<tr><td>邮编：</td><td>100110</td><td>电话：</td><td>010-00000000</td></tr>
		<tr><td>地址：</td><td>北京市海淀区北京市海淀区北京市海淀区北京市海淀区</td><td>爱好：</td><td>唱歌 跳舞</td></tr>
	</table>
	</div>
</body>
</html>