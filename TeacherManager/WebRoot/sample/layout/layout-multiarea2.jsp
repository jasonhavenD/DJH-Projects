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
	<table width="100%">
		<tr>
			<td colspan="2">
				<IFRAME scrolling="auto" width="100%" frameBorder=0 id=frmrightChild name=frmrightChild onload="iframeHeight('frmrightChild')" 
 src="<%=path%>/sample/layout/layout-multiarea-content4.jsp"  allowTransparency="true"></IFRAME>
			</td>
		</tr>
		<tr>
			<td width="50%">
				<IFRAME scrolling="auto" width="100%" frameBorder=0 id=frmrightChild2 name=frmrightChild2 onload="iframeHeight('frmrightChild2')" 
 src="<%=path%>/sample/layout/layout-multiarea-content1.jsp"  allowTransparency="true"></IFRAME>
			</td>
			<td width="50%">
				<IFRAME scrolling="auto" width="100%" frameBorder=0 id=frmrightChild3 name=frmrightChild3 onload="iframeHeight('frmrightChild3')" 
 src="<%=path%>/sample/layout/layout-multiarea-content2.jsp"  allowTransparency="true"></IFRAME>
			</td>
		</tr>
		<tr>
			<td>
				<IFRAME scrolling="auto" width="100%" frameBorder=0 id=frmrightChild4 name=frmrightChild4 onload="iframeHeight('frmrightChild4')" 
 src="<%=path%>/sample/layout/layout-multiarea-content1.jsp"  allowTransparency="true"></IFRAME>
			</td>
			<td>
				<IFRAME scrolling="auto" width="100%" frameBorder=0 id=frmrightChild5 name=frmrightChild5 onload="iframeHeight('frmrightChild5')" 
 src="<%=path%>/sample/layout/layout-multiarea-content2.jsp"  allowTransparency="true"></IFRAME>
			</td>
		</tr>
	</table>
</body>
</html>