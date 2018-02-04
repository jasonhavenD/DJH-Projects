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

<script>
	 $(document).ready(function(){
	 	$("#testBtn1").click(function(){
			$('#demo2').eq(0).css({
				"width":"400px"
			})
		})
		$("#testBtn2").click(function(){
			$('#demo2').eq(0).css({
				"width":"200px"
			})
		})
	 })
</script>
</head>
<body>
	<div class="box1" panelWidth="800">
 <fieldset>
   <legend>1、基本使用</legend>
	<div class="textSlice" style="width:80px;">要截取的文字内容要截取的文字内容</div>
  </fieldset>
  <div class="height_15"></div>
  
  
  <fieldset>
   <legend>2、动态改变容器尺寸</legend>
	<div class="textSlice" id="demo2" style="width:180px;border:solid 1px #cccccc;">这是一段很长的文字，当容器放不下则会出现省略号。这是一段很长的文字，当容器放不下则会出现省略号。这是一段很长的文字，当容器放不下则会出现省略号。</div>
		<input type="button" id="testBtn1" value="动态增大容器尺寸"/>
		<input type="button" id="testBtn2" value="动态减小容器尺寸"/>
  </fieldset>
  <div class="height_15"></div>
  
  <fieldset>
   <legend>3、与提示连用</legend>
	<span class="textSlice" style="width:280px;border:solid 1px #cccccc;" title="这是一段很长的文字，当容器放不下则会出现省略号。这是一段很长的文字，当容器放不下则会出现省略号。这是一段很长的文字，当容器放不下则会出现省略号。">这是一段很长的文字，当容器放不下则会出现省略号。这是一段很长的文字，当容器放不下则会出现省略号。这是一段很长的文字，当容器放不下则会出现省略号。</span>
  </fieldset>
  <div class="height_15"></div>
  
  </div>
</body>
</html>