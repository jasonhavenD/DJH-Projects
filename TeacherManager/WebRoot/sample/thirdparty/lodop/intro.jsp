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
<div class="box1" panelWidth="800">
	<fieldset>
      	<legend>控件介绍</legend>
      	lodop打印控件（俗称“露肚皮”）是一款功能非常强大的组件。通常如果使用网页自带的打印功能，会把网页上所有能看到的元素全部打印出来。而是用该控件可以实现只打印需要的内容。<br/>
      	另外，它还自带可视化编辑功能，这样可以很方便的实现套打。<br/>
      	需要注意的是，免费版提供了大部分的功能，但有少量功能是需要付费注册的。例如不经预览而直接打印，如果用免费版使用这个功能，则会在打印出来的文件左下角出现一个版权提示。<br/>
      	在本框架的source目录下的“常用文档”目录有该控件的官方示例和使用手册。<br/>
		以下是该控件自带示例的部分效果截图。<br/>
      </fieldset>
      <div class="height_15"></div>
      
      <fieldset>
      	<legend>自定义要打印的内容</legend>
      	<img src="<%=path%>/sample/thirdparty/lodop/1.jpg"/>
      </fieldset>
      <div class="height_15"></div>
      
      <fieldset>
      	<legend>可视化编辑位置和内容</legend>
      	<img src="<%=path%>/sample/thirdparty/lodop/2.jpg"/>
      </fieldset>
      <div class="height_15"></div>
      
      <fieldset>
      	<legend>套打</legend>
      	<img src="<%=path%>/sample/thirdparty/lodop/3.jpg"/>
      </fieldset>
      <div class="height_15"></div>
      
      <fieldset>
      	<legend>条形码打印</legend>
      	<img src="<%=path%>/sample/thirdparty/lodop/4.jpg"/>
      </fieldset>
      <div class="height_15"></div>
      
      <fieldset>
      	<legend>设置纸张方向</legend>
      	<img src="<%=path%>/sample/thirdparty/lodop/5.jpg"/>
      </fieldset>
      <div class="height_15"></div>
</div>      
</body>
</html>