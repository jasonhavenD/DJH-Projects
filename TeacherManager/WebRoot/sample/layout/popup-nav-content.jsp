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
<style>
.l-layout-center{
    border:none!important;
}
.l-layout-left{
   border:none!important;
}
.l-layout-drophandle-left{
    width: 10px;
    background-image: url(<%=path%>/libs/images/formEle/spliter_bg_v.jpg)!important;
	background-repeat:repeat-y!important;
}
</style>
</head>
<body>
<div id="layout1">
        <div   position="left" panelTitle="菜单目录">
        	<div id="leftCon">
        	<IFRAME width="100%" height="100%" frameBorder=0 id=frmrightChildLeft name=frmrightChildLeft
					src="<%=path%>/sample/layout/popup-nav-content-left.jsp" allowTransparency="true"></IFRAME>
			</div>
        </div>
        <div  position="center" panelTitle="详细信息">
        	<IFRAME  width="100%" height="100%" frameBorder=0 id=frmrightChild name=frmrightChild 
				src="<%=path%>/sample/layout/popup-nav-content-right.jsp" allowTransparency="true"></IFRAME>
        </div>
    </div> 
<script type="text/javascript">
	function initComplete(){
		var layout=$("#layout1").layout({ leftWidth: 200}); 
	}
	function customHeightSet(contentHeight){
		$("#leftCon").height(contentHeight-30);
	}
</script>
</body>
</html>