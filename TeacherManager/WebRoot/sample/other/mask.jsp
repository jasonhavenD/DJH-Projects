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
   <legend>1、基本使用</legend>
	<div style="border:solid 1px #cccccc;padding:10px;width:300px;" id="content1">
	要遮罩的内容<br/>
	<img src="<%=path%>/libs/images/demo/demo1.jpg"/>
	
	</div>
	<input type="button" value="开启遮罩" onclick="openMask1()"/>
	<input type="button" value="关闭遮罩" onclick="closeMask1()"/>
  </fieldset>
  <div class="height_15"></div>
  
  <fieldset>
  <legend>2、添加提示语</legend>
	<div style="border:solid 1px #cccccc;padding:10px;width:300px;" id="content2">
	要遮罩的内容<br/>
	<img src="<%=path%>/libs/images/demo/demo1.jpg"/>
	
	</div>
	<input type="button" value="开启遮罩" onclick="openMask2()"/>
	<input type="button" value="关闭遮罩" onclick="closeMask2()"/>
  </fieldset>
  <div class="height_15"></div>
  
   <fieldset>
   <legend>3、延时遮罩</legend>
	<div style="border:solid 1px #cccccc;padding:10px;width:300px;" id="content3">
	要遮罩的内容<br/>
	<img src="<%=path%>/libs/images/demo/demo1.jpg"/>
	
	</div>
	<input type="button" value="点击1秒后遮罩" onclick="openMask3()"/>
	<input type="button" value="关闭遮罩" onclick="closeMask3()"/>
  </fieldset>
  <div class="height_15"></div>
  
  <fieldset>
   <legend>4、出现加载图标</legend>
	<div style="border:solid 1px #cccccc;padding:10px;width:300px;" id="content4">
	要遮罩的内容<br/>
	<img src="<%=path%>/libs/images/demo/demo1.jpg"/>
	
	</div>
	<input type="button" value="开启遮罩" onclick="openMask4()"/>
	<input type="button" value="关闭遮罩" onclick="closeMask4()"/>
  </fieldset>
  <div class="height_15"></div>
  
  
   <fieldset>
   <legend>5、改变遮罩颜色</legend>
	<div style="border:solid 1px #cccccc;padding:10px;width:300px;" id="content5">
	要遮罩的内容<br/>
	<img src="<%=path%>/libs/images/demo/demo1.jpg"/>
	
	</div>
	<input type="button" value="开启遮罩" onclick="openMask5()"/>
	<input type="button" value="关闭遮罩" onclick="closeMask5()"/>
  </fieldset>
  <div class="height_15"></div>
  
  </div>
<script>
function openMask1(){
	$("#content1").mask();
}
function closeMask1(){
	$("#content1").unmask();
}

function openMask2(){
	$("#content2").mask("当前不可用！",0,false);
}
function closeMask2(){
	$("#content2").unmask();
}

function openMask3(){
	$("#content3").mask(null,1000,false);
}
function closeMask3(){
	$("#content3").unmask();
}


function openMask4(){
	$("#content4").mask("正在加载中",null,true);
}
function closeMask4(){
	$("#content4").unmask();
}
function openMask5(){
	$("#content5").mask("当前不可用！",null,false,"#ffffff");
}
function closeMask5(){
	$("#content5").unmask();
}
</script>
</body>
</html>