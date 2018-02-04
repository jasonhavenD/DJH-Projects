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

<!--layout布局控件start-->
<link href="<%=path%>/libs/thirdparty/layout/css/style.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=path%>/libs/thirdparty/layout/js/jquery-ui-1.7.2.custom.min.js"></script>
<script type="text/javascript" src="<%=path%>/libs/thirdparty/layout/js/jquery.layout.js"></script>
<script type="text/javascript" src="<%=path%>/libs/thirdparty/layout/js/layout.js"></script>
<!--layout布局控件end-->
<script>
$(function(){
		$(window).resize(function(){
			var parentTopHeight = $(window.top.document.getElementById("hbox")).outerHeight() + $(window.parent.document.getElementById("rbox_topcenter")).outerHeight();
		    var  parentBottomHeight = $(window.top.document.getElementById("fbox")).outerHeight() + $(window.parent.document.getElementById("rbox_bottomcenter")).outerHeight() + 1;
			var parentMainHeight = window.top.document.documentElement.clientHeight;
			try {
				window.top.document.getElementsByTagName('iframe')['frmright'].style.height = parentMainHeight-parentTopHeight-parentBottomHeight+'px'; 
			}
			catch(e){}
		})
	})
</script>
</head>
<body>
<div class="ui-layout-north">
	 <div class="header">上方标题</div>
    <div class="content">
		上方面板内容
    </div>
</div>
<div class="ui-layout-center">
     <div class="header">下方标题</div>
    <div class="content">
		下方面板内容
    </div>
</div>
</body>
</html>