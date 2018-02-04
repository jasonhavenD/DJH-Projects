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
<div style="width:300px;">
	<div class="navIconSmall" onclick="top.Dialog.alert('个人中心')">
		<img src="<%=path%>/libs/icons/png/01.png" width="60" height="60"/><br />
		个人中心
	</div>
	<div class="navIconSmall" onclick="top.Dialog.alert('个人收藏夹')">
		<img src="<%=path%>/libs/icons/png/02.png"/><br />
		个人收藏夹
	</div>
	<div class="navIconSmall" onclick="top.Dialog.alert('高级搜索')">
		<img src="<%=path%>/libs/icons/png/03.png"/><br />
		高级搜索
	</div>
	<div class="navIconSmall" onclick="top.Dialog.alert('文档管理')">
		<img src="<%=path%>/libs/icons/png/04.png"/><br />
		文档管理
	</div>
	<div class="navIconSmall" onclick="top.Dialog.alert('帮助中心')">
		<img src="<%=path%>/libs/icons/png/05.png"/><br />
		帮助中心
	</div>
	<div class="navIconSmall" onclick="top.Dialog.alert('个人存储空间')">
		<img src="<%=path%>/libs/icons/png/06.png"/><br />
		个人存储空间
	</div>
	<div class="navIconSmall" onclick="top.Dialog.alert('附件管理')">
		<img src="<%=path%>/libs/icons/png/07.png"/><br />
		附件管理
	</div>
	<div class="navIconSmall" onclick="top.Dialog.alert('通知消息')">
		<img src="<%=path%>/libs/icons/png/08.png"/><br />
		通知消息
	</div>
	<div class="navIconSmall" onclick="top.Dialog.alert('回收站')">
		<img src="<%=path%>/libs/icons/png/09.png"/><br />
		回收站
	</div>
	<div class="clear"></div>
</div>	
</body>
</html>