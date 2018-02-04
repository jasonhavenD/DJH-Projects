<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>iframe示例</title>
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js" id="theme" themeColor="blue"></script>
<script>
var pResizeTimer = null;
$(function(){
	heightSet();
	window.onresize = function(){
		if ( pResizeTimer ) clearTimeout (pResizeTimer);
   		pResizeTimer = setTimeout ("heightSet()", 100);
	}
})
function heightSet(){
var windowHeight=document.documentElement.clientHeight;
$("#mainContent").height(windowHeight-50);
}
</script>
</head>
<body style="background-color:#dbeefd;">
<div style="height:30px;">
这是与框架无关的第三方主页。将框架内页作为iframe嵌入到下方：
</div>
<div id="mainContent">
<IFRAME scrolling="no" width="100%" height="100%"  frameBorder=0  src="<%=path%>/sample/split/user-management.jsp"  allowTransparency="true"></IFRAME>
</div>
</body>
</html>