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

<!--尺寸拖拽调整start-->
<script type="text/javascript" src="<%=path%>/libs/js/drag/dragResize.js"></script>
<!--尺寸拖拽调整end-->
<script type="text/javascript">
	function initComplete(){
		 $("#img")[0].ondragstart=function(){
		 	return false;
		 }
		 $('#img').dragResize();
		 //$('#myBox').find(".boxContent").dragResize({ handles: 's' });
		 $('#myBox').dragResize({ handles: 'e' });
		 
	}
</script>
<body>
		<img src="<%=path%>/libs/images/demo/demo1.jpg" id="img" style="z-index:3; position:absolute;"/>
	
	
	<div class="box2_custom" boxType="box2" panelWidth="300" panelHeight="200" panelTitle="可横向拉伸" iconClass="icon_list" style="top:300px;z-index:2; position:absolute;" id="myBox">

	</div>
  <div class="height_15"></div>
  
  
  
  
</body>
</html>