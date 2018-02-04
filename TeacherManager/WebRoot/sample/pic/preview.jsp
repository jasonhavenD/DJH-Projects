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

<!--图片预览start-->
<script type="text/javascript" src="<%=path%>/libs/js/pic/imgPreview.js"></script>
<!--图片预览end-->
</head>
<body>
 <div class="box1" panelWidth="800">
 <fieldset>
   <legend>1、不含标题</legend>
	<a href="javascript:;" ref="<%=path%>/libs/images/demo/demo1.jpg" class="imgPreview"><img src="<%=path%>/libs/images/demo/demo1.jpg" width="80" height="60"/></a>
	<a href="javascript:;" ref="<%=path%>/libs/images/demo/demo2.jpg" class="imgPreview"><img src="<%=path%>/libs/images/demo/demo2.jpg" width="80" height="60"/></a>
	<a href="javascript:;" ref="<%=path%>/libs/images/demo/demo3.jpg" class="imgPreview"><img src="<%=path%>/libs/images/demo/demo3.jpg" width="80" height="60"/></a>
  </fieldset>
  <div class="height_15"></div>
  
  
   <fieldset>
   <legend>2、含标题</legend>
   <a href="javascript:;" ref="<%=path%>/libs/images/demo/demo1.jpg" class="imgPreview" title="标题1" keepDefaultStyle="true"><img src="<%=path%>/libs/images/demo/demo1.jpg" width="80" height="60"/></a>
	<a href="javascript:;" ref="<%=path%>/libs/images/demo/demo2.jpg" class="imgPreview" title="标题2" keepDefaultStyle="true"><img src="<%=path%>/libs/images/demo/demo2.jpg" width="80" height="60"/></a>
	<a href="javascript:;" ref="<%=path%>/libs/images/demo/demo3.jpg" class="imgPreview" title="标题3" keepDefaultStyle="true"><img src="<%=path%>/libs/images/demo/demo3.jpg" width="80" height="60"/></a>
  </fieldset>
  <div class="height_15"></div>
  
  
  <fieldset>
   <legend>3、含边框效果</legend>
  	 <div class="picItem2"><a href="javascript:;" ref="<%=path%>/libs/images/demo/demo1.jpg" class="imgPreview"><img src="<%=path%>/libs/images/demo/demo1.jpg"/></a></div>
	<div class="picItem2"><a href="javascript:;" ref="<%=path%>/libs/images/demo/demo2.jpg" class="imgPreview"><img src="<%=path%>/libs/images/demo/demo2.jpg"/></a></div>
	<div class="picItem2"><a href="javascript:;" ref="<%=path%>/libs/images/demo/demo3.jpg" class="imgPreview"><img src="<%=path%>/libs/images/demo/demo3.jpg"/></a></div>
  </fieldset>
  <div class="height_15"></div>
  
  
   <fieldset>
   <legend>4、文字链接</legend>
   <a href="javascript:;" ref="<%=path%>/libs/images/demo/demo2.jpg" title="标题4" keepDefaultStyle="true" class="imgPreview">文字链接</a>
  </fieldset>
  <div class="height_15"></div>
  
  </div>
</body>
</html>