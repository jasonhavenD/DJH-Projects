<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>锁定列</title>
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/" scrollerY="false"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!--动态选项卡start-->
<script type="text/javascript" src="<%=path%>/libs/js/nav/dynamicTab.js"></script>
<!--动态选项卡end-->

</head>
<body>
	<div id="tab_menu"></div>
	<div class="box1">
		<div id="page" style="width:100%;"></div>
	</div>
<script>
 var tab;
function initComplete(){
	
	 tab = new TabView( {
		containerId :'tab_menu',
		pageid :'page',
		cid :'tab1',
		position :"top"
	});
	tab.add( {
		id :'tab1_index1',
		title :"数据表格",
		url :"<%=path%>/sample/layout/grid-addtab-content1.jsp",
		isClosed :false
	});
}
function tabAddHandler(mid,mtitle,murl){
		tab.add( {
		id :mid,
		title :mtitle,
		url :murl,
		isClosed :true
	});
	tab.activate(mid)
}
	

function customHeightSet(contentHeight){
	$("#page").height(contentHeight-50);
}
</script>
</body>
</html>