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
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/" scrollerY="false"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!--去除虚线链接start-->
<style>
a {
	behavior:url(<%=path%>/libs/js/method/focus.htc)
}
</style>
<!--去除虚线链接end-->
</head>
<body>
<table width="100%">
	<tr>
		<td width="100" class="ver01">
		<div class="singleNavMin">
			<div class="current"><span><a href="<%=path%>/sample/layout/nav-single-content1.jsp" target="frmrightChild">选项1</a></span></div>
			<div><span><a href="<%=path%>/sample/layout/nav-single-content2.jsp" target="frmrightChild">选项2</a></span></div>
			<div><span><a href="<%=path%>/sample/layout/nav-single-content1.jsp" target="frmrightChild">选项3</a></span></div>
			<div><span><a href="<%=path%>/sample/layout/nav-single-content2.jsp" target="frmrightChild">选项4</a></span></div>
			<div><span><a href="<%=path%>/sample/layout/nav-single-content1.jsp" target="frmrightChild">选项5</a></span></div>
		</div>
		
		</td>
		<td class="ver01">
		<div class="box1">
			<div class="cusBoxContent" style="overflow-y:auto;overflow-x:hidden;">
		<IFRAME height="100%" width="100%" frameBorder=0 id=frmrightChild name=frmrightChild 
			src="<%=path%>/sample/layout/nav-single-content1.jsp" allowTransparency="true"></IFRAME>
			</div>
		</div>
		</td>
	</tr>
</table>
<script type="text/javascript">
	function customHeightSet(contentHeight){
		$(".cusBoxContent").height(contentHeight-20)
	}
</script>
</body>
</html>