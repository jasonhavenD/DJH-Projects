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

<!--篮子菜单start-->
<script type="text/javascript" src="<%=path%>/libs/js/nav/stack.js"></script>
<!--框架必需end-->
</head>
<body>
	<div class="stack">
		<img src="<%=path%>/libs/images/stacks/stack.png" alt="stack"/>
		<ul id="stack">
			<li><a href="javascript:;"><span>示例1</span><img src="<%=path%>/libs/images/stacks/aperture.png"/></a></li>
			<li><a href="javascript:;"><span>示例2</span><img src="<%=path%>/libs/images/stacks/photoshop.png"/></a></li>
			<li><a href="javascript:;"><span>示例3</span><img src="<%=path%>/libs/images/stacks/safari.png"/></a></li>
			<li><a href="javascript:;"><span>示例4</span><img src="<%=path%>/libs/images/stacks/coda.png"/></a></li>
			<li><a href="javascript:;"><span>示例5</span><img src="<%=path%>/libs/images/stacks/finder.png"/></a></li>			
		</ul>
	</div>
</body>
</html>