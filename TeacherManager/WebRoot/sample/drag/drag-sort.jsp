<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!--拖拽排序start-->
<script type="text/javascript" src="<%=path%>/libs/js/drag/dragSort.js"></script>
<!--拖拽排序end-->
<script type="text/javascript">
	function initComplete(){
		$("#list1, #list2").dragSort({ dragSelector: "div", dragBetween: true, dragEnd: saveOrder, placeHolderTemplate: "<li class='placeHolder'><div></div></li>" });
	}
	function saveOrder() {
		var serialStr = "";
		$("#list1 li").each(function(i, elm) { serialStr += (i > 0 ? "|" : "") + $(elm).children().html(); });
		$("input[name=list1SortOrder]").val(serialStr);
	};
</script>
<style>
	#list1, #list2 { width:100%; list-style-type:none; margin:0px; min-height:70px;  }
	#list1 li, #list2 li { float:left; padding:5px; width:80px; height:80px; }
	#list1 div, #list2 div { width:70px; height:70px; text-align:center; text-align:center;line-height:70px; }
	.placeHolder div { background-color:#ffffec !important; border:dashed 1px gray !important;border-radius: 3px 3px 3px 3px; }
	.group_line{
		border-bottom:solid 1px #000000;
		height:30px;
	}
	.group_line2{
		height:30px;
	}
</style>

<body>
<ul id="list2">
	<li><div><img src="<%=path%>/libs/icons/png_64/10.png"/></div></li>
	<li><div><img src="<%=path%>/libs/icons/png_64/11.png"/></div></li>
	<li><div><img src="<%=path%>/libs/icons/png_64/12.png"/></div></li>
	<li><div><img src="<%=path%>/libs/icons/png_64/13.png"/></div></li>
	<li><div><img src="<%=path%>/libs/icons/png_64/14.png"/></div></li>
	<li><div><img src="<%=path%>/libs/icons/png_64/15.png"/></div></li>
	<li><div><img src="<%=path%>/libs/icons/png_64/16.png"/></div></li>
	<li><div><img src="<%=path%>/libs/icons/png_64/17.png"/></div></li>
	<li><div><img src="<%=path%>/libs/icons/png_64/18.png"/></div></li>
	<dt class="clear"></dt>
</ul>
<div class="group_line"></div>
<div class="group_line2"></div>
<ul id="list1">
	<li><div><img src="<%=path%>/libs/icons/png_64/01.png"/></div></li>
	<li><div><img src="<%=path%>/libs/icons/png_64/02.png"/></div></li>
	<li><div><img src="<%=path%>/libs/icons/png_64/03.png"/></div></li>
	<li><div><img src="<%=path%>/libs/icons/png_64/04.png"/></div></li>
	<li><div><img src="<%=path%>/libs/icons/png_64/05.png"/></div></li>
	<li><div><img src="<%=path%>/libs/icons/png_64/06.png"/></div></li>
	<li><div><img src="<%=path%>/libs/icons/png_64/07.png"/></div></li>
	<li><div><img src="<%=path%>/libs/icons/png_64/08.png"/></div></li>
	<li><div><img src="<%=path%>/libs/icons/png_64/09.png"/></div></li>
	<dt class="clear"></dt>
</ul>
<input name="list1SortOrder" type="hidden" />
</body>
</html>