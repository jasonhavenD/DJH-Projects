<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>颜色选择器</title>
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!-- 颜色选择器start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/color.js"></script>
<!-- 颜色选择器end -->

</head>
<body>
  <div class="box1" panelWidth="800">
  	<fieldset>
      <legend>1、基本使用</legend>
      <input type="text" class="color" id="color1"/>
      <input type="button" value="获取值"  onclick="getValue()"/>
  	</fieldset>
  	<div class="height_15"></div>
  	
  	<fieldset>
      <legend>2、初始时默认值</legend>
      <input type="text" class="color" value="00FF00"/>
  	</fieldset>
  	<div class="height_15"></div>
  	
  	<fieldset>
      <legend>3、禁用/启用</legend>
      <input type="text" class="color" id="color3" disabled="true"/>
       <input type="button" value="启用" onclick="enableSelect()" style="width:105px;"/>
        <input type="button" value="禁用" onclick="disableSelect()" style="width:105px;"/>
  	</fieldset>
  	<div class="height_15"></div>
      
   <fieldset>
      <legend>4、动态创建</legend>
      <input type="button" value="点击生成颜色选择器" id="testBtn" onclick="createColor()"/>
  	</fieldset>
  	<div class="height_15"></div>
  	
  	 <fieldset>
      <legend>5、动态赋值</legend>
     <input type="text" class="color" id="color5"/>
     <input type="button" value="点击赋值" onclick="setValue('FF00FF')"/>
  	</fieldset>
  	<div class="height_15"></div>
  </div>
<script>
	//获取值
	function getValue(){
		top.Dialog.alert($("#color1").val())
	}
	
	//设为不可用
	function disableSelect(){
		$("#color3").attr("disabled",true);
	}
	//设为可用
	function enableSelect(){
	    $("#color3").attr("disabled",false);
	}
	
	//动态创建
	function createColor(){
		var $color=$('<input type="text" class="color"/>');
		$("#testBtn").after($color);
		$color.render();
	}
	
	//动态赋值
	function setValue(str){
		$("#color5").val(str);
		$("#color5")[0].style.backgroundColor="#"+str;
	}
</script>
</body>
</html>