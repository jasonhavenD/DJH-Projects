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

<!--布局控件start-->
<script type="text/javascript" src="<%=path%>/libs/js/nav/layout.js"></script>
<!--布局控件end-->
</head>
<body >
<div id="layout1">
    <div position="top" style="" panelTitle="组织机构">
    	上部区域
    </div>
    <div position="center" style="">
    	这是中间区域
    </div>
    <div position="bottom" style="" panelTitle="便捷工具">
    	下部区域
    </div>
</div> 
	
	
<script type="text/javascript">
	
	function initComplete(){
		var layout=$("#layout1").layout({ topHeight: 200,bottomHeight:150}); 
	}
</script>
</body>
</html>