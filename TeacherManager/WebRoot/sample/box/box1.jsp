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
<div style="width:800px;">
<fieldset style="border-color:#999999;">
    <legend>1、基本示例：</legend>
    <div class="box1" panelWidth="300" panelHeight="150">
         内容部分
	</div>
	参数请参见文档。
</fieldset>
<div class="height_15"></div>


<fieldset style="border-color:#999999;">
    <legend>2、动态创建：</legend>
    <input type="button"  value="点击创建" onclick="createBox()" id="testBtn"/>
</fieldset>
<div class="height_15"></div>


<fieldset style="border-color:#999999;">
    <legend>3、动态改尺寸：</legend>
    <div class="box1" panelWidth="300" panelHeight="150" id="boxDemo">内容部分</div><br/>
	<input type="button"  value="点击改尺寸" onclick="changeBox()"/>
</fieldset>
<div class="height_15"></div>

<fieldset style="border-color:#999999;">
    <legend>4、box1在提示信息时的应用：</legend>
    <div class="box1" panelWidth="450">
		<div class="msg_icon1"></div>
		<div class="padding_left50 padding_right15 padding_top20 minHeight_100 font_14 font_bold" >
		项目添加成功，点击这里返回继续添加。
		</div>
	</div>
	<br/>
	<div class="box1" panelWidth="450">
		<div class="msg_icon2"></div>
		<div class="padding_left50 padding_right15 padding_top20 minHeight_100 font_14 font_bold" >
		点击这里返回前一页。
		</div>
	</div>
	<br/>
	
	<div class="box1" panelWidth="450">
		<div class="msg_icon3"></div>
		<div class="padding_left50 padding_right15 padding_top20 minHeight_100 font_14 font_bold" >
		您的FlashPlayer版本过低，点击这里进行升级。
		</div>
	</div>
	<br/>
	
	<div class="box1" panelWidth="450">
		<div class="msg_icon4"><span>标题可修改</span></div>
		<div class="padding_left50 padding_right15 padding_top20 minHeight_100 font_14 font_bold" >
		这里放置自定义提示的内容。
		</div>
	</div>
</fieldset>
<div class="height_15"></div>

<fieldset style="border-color:#999999;">
    <legend>5、水平居中效果：</legend>
    <div class="box1" panelWidth="450" position="center">
		<div class="msg_icon1"></div>
		<div class="padding_left50 padding_right15 padding_top20 minHeight_100 font_14 font_bold" >
		项目添加成功，点击这里返回继续添加。
		</div>
	</div>
</fieldset>
<div class="height_15"></div>

<fieldset style="border-color:#999999;">
    <legend>6、适应白色背景：</legend>
   <div style="background-color:#ffffff;padding:10px;">
	    <div class="box1" panelWidth="450" whiteBg="true">
			<div class="msg_icon1"></div>
			<div class="padding_left50 padding_right15 padding_top20 minHeight_100 font_14 font_bold" >
			项目添加成功，点击这里返回继续添加。
			</div>
		</div>
	</div>
</fieldset>
<div class="height_15"></div>


<fieldset style="border-color:#999999;">
    <legend>7、自定义风格：</legend>
    <div class="box1_custom" boxType="box1" panelWidth="450" panelHeight="210">
		内容部分
	</div>
</fieldset>
<div class="height_15"></div>
	

</div>

<script>
function createBox(){
	var $box=$('<div class="box1" panelWidth="300" panelHeight="150">内容部分</div>');
	$("#testBtn").after($box);
	$box.render();
}
function changeBox(){
	$("#boxDemo").attr("panelWidth",400);
	$("#boxDemo").attr("panelHeight",200);
	$("#boxDemo").render();
}
</script>
</body>
</html>