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

<!--弹出式提示框start-->
<script type="text/javascript" src="<%=path%>/libs/js/popup/messager.js"></script>
<!--弹出式提示框end-->
</head>
<body>
<div id="scrollContent">
	<div class="box1" panelWidth="800">
  	 <fieldset> 
     <legend>1、基本使用</legend>
     	<input type="button" value="弹出提示" onclick='open1()'/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
     <legend>2、自定义提示框标题</legend>
     	<input type="button" value="弹出自定义提示框标题提示框" onclick='open2()'/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
     <legend>3、自定义提示持续时间</legend>
     	<input type="button" value="自定义持续时间为10秒" onclick='open3()'/>
     	<input type="button" value="打开后不自动关闭" onclick='open3_2()'/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
     <legend>4、播放声音</legend>
     	<input type="button" value="提示出现时播放声音" onclick='open4()'/>
     	<input type="button" value="提示出现时播放声音2" onclick='open4_2()'/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
     <legend>5、自定义尺寸</legend>
     	<input type="button" value="弹出自定义提示框尺寸提示框" onclick='open5()'/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
     <legend>6、综合实例</legend>
     	<input type="button" value="弹出提示窗口" onclick='open6()'/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
     <legend>7、自定义样式</legend>
     	<input type="button" value="弹出自定义样式提示框" onclick='open7()'/>
	  </fieldset>
	 </div>
</div>
<script>
	function open1(){
		$.messager.show(0,'提示内容');
	}
	function open2(){
		$.messager.show('自定义标题','提示内容');
	}
	function open3(){
		$.messager.show(0,'提示内容',10000);
	}
	function open3_2(){
		$.messager.show(0,'','stay');
	}
	function open4(){
		$.messager.show(0,'提示内容！',10000,'message.mp3');
	}
	function open4_2(){
		$.messager.show(0,'提示内容！',10000,'msg.wav');
	}
	function open5(){
		$.messager.lays(300, 200);
		$.messager.show(0,'提示内容',4000);
	}
	function open6(){
		$.messager.lays(250, 140);
		$.messager.show(0,'<ul><li><a href="javascript:openWin()"><span class="icon_lightOn">系统消息：3条</span></a></li><div class="clear"></div>'+
		'<li><a href="javascript:openWin()"><span class="icon_lightOn">公共消息：10条</span></a></li><div class="clear"></div>'+
		'<li><a href="javascript:openWin()"><span class="icon_lightOn">私人消息：5条</span></a></li><div class="clear"></div>'+
		'<li><a href="javascript:openWin()"><span class="icon_lightOn">未读消息：15条</span></a></li><div class="clear"></div></ul>','stay','message.mp3');
	}
	function openWin(){
		top.Dialog.open({URL:"<%=path%>/sample/popup/messager-content1.jsp",Title:"信件箱"});
	}
	function open7(){
		$.messager.show('警告','警告信息内容','10000','','box_msg_custom');
	}
	
	function customHeightSet(contentHeight){
		$("#scrollContent").height(contentHeight);
	}
</script>
</body>
</html>