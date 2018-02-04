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

<!--修正IE6不支持PNG图start-->
<style>
img {
	behavior:url("<%=path%>/libs/js/method/pngFix/pngbehavior.htc");
}
</style>
<!--修正IE6不支持PNG图end-->

<style>
.icons_style1 img{
	width:86px;
	height:86px;
}
.icons_style1 td{
text-align:center;
}
</style>
</head>
<body>
使用大图标时，直接引入图片。
<div class="icons_style1">
	<table class="tableStyle">
	<tr>
		<th colspan="6">风格二，图标位置：libs/icons/png_128目录</th>
		
	</tr>
	<tr>
		<td><img src="<%=path%>/libs/icons/png_128/01.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_128/02.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_128/03.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_128/04.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_128/05.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_128/06.png" /></td>
	</tr>
	<tr>
		<td>01.png</td>
		<td>02.png</td>
		<td>03.png</td>
		<td>04.png</td>
		<td>05.png</td>
		<td>06.png</td>
	</tr>
	<tr>
		<td><img src="<%=path%>/libs/icons/png_128/07.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_128/08.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_128/09.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_128/10.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_128/11.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_128/12.png" /></td>
	</tr>
	<tr>
		<td>07.png</td>
		<td>08.png</td>
		<td>09.png</td>
		<td>10.png</td>
		<td>11.png</td>
		<td>12.png</td>
	</tr>
	<tr>
		<td><img src="<%=path%>/libs/icons/png_128/13.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_128/14.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_128/15.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_128/16.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_128/17.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_128/18.png" /></td>
	</tr>
	<tr>
		<td>13.png</td>
		<td>14.png</td>
		<td>15.png</td>
		<td>16.png</td>
		<td>17.png</td>
		<td>18.png</td>
	</tr>
	<tr>
		<td><img src="<%=path%>/libs/icons/png_128/19.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_128/20.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_128/21.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_128/22.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_128/23.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_128/24.png" /></td>
	</tr>
	<tr>
		<td>19.png</td>
		<td>20.png</td>
		<td>21.png</td>
		<td>22.png</td>
		<td>23.png</td>
		<td>24.png</td>
	</tr>
	<tr>
		<td><img src="<%=path%>/libs/icons/png_128/25.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_128/26.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_128/27.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_128/28.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_128/29.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_128/30.png" /></td>
	</tr>
	<tr>
		<td>25.png</td>
		<td>26.png</td>
		<td>27.png</td>
		<td>28.png</td>
		<td>29.png</td>
		<td>30.png</td>
	</tr>
	<tr>
		<td><img src="<%=path%>/libs/icons/png_128/31.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_128/32.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_128/33.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_128/34.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_128/35.png" /></td>
		<td></td>
	</tr>
	<tr>
		<td>31.png</td>
		<td>32.png</td>
		<td>33.png</td>
		<td>34.png</td>
		<td>35.png</td>
		<td></td>
	</tr>

	</table>
</div>		
</body>
</html>