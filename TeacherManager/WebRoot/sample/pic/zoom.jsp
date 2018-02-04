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

<!--单图区域放大start-->
<script type="text/javascript" src="<%=path%>/libs/js/pic/imgZoom.js"></script>
<!--单图区域放大end-->
</head>
<body>
  <div class="box1" panelWidth="800">
 <fieldset>
   <legend>1、基本使用</legend>
   <a href="<%=path%>/libs/images/demo/demo4.jpg" class="imgZoom" > 
		<img src="<%=path%>/libs/images/demo/demo1.jpg"> 
	</a> 
  </fieldset>
  <div class="height_15"></div>
  
  <fieldset>
   <legend>2、自定义放大区域尺寸</legend>
  <a href="<%=path%>/libs/images/demo/demo4.jpg" class="imgZoom" zoomWidth="250" zoomHeight="250" > 
		<img src="<%=path%>/libs/images/demo/demo1.jpg"> 
	</a>
  </fieldset>
  <div class="height_15"></div>
  
  <fieldset>
   <legend>3、遮罩模式</legend>
   <a href="<%=path%>/libs/images/demo/demo4.jpg" class="imgZoom" zoomType="reverse"> 
		<img src="<%=path%>/libs/images/demo/demo1.jpg"> 
	</a> 
  </fieldset>
  <div class="height_15"></div>
  
  </div>
</body>
</html>