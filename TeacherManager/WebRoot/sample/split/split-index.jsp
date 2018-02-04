<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
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
<div id="scrollContent">
<div class="box1" panelWidth="800">
	<fieldset>
      	<legend>注意</legend>
      	框架提供分离模式（设置主页参数splitMode="true"），用来适应以下两种情况：<br/>
      	1、单独使用框架的内页<br/>
      	2、框架内页作为iframe嵌入到第三方页面或框架中。<br/>
      如果只是不想让内页自动使用主页的皮肤配置，那么设置主页参数autoGetSkin="false"即可，无需使用分离模式。
      </fieldset>
      <div class="height_15"></div>
      
      <fieldset>
      	<legend>单独使用框架内页</legend>
      	<a href="<%=path%>/sample/split/datagrid.jsp" target="_blank">打开表格示例</a><br/><br/>
      	<a href="<%=path%>/sample/split/form.jsp" target="_blank">打开表单示例</a><br/><br/>
      	<a href="<%=path%>/sample/split/user-management.jsp" target="_blank">打开综合示例</a>
      </fieldset>
      <div class="height_15"></div>
      
      <fieldset>
      	<legend>框架内页被嵌入到第三方页面中</legend>
      	<a href="<%=path%>/sample/split/iframe.jsp" target="_blank">点击打开示例</a><br/><br/>
      </fieldset>
      <div class="height_15"></div>
</div>
</div>
</body>
</html>