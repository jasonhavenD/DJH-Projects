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

<!--文本变色start-->
<script type="text/javascript" src="<%=path%>/libs/js/text/color.js"></script>
<!--文本变色end--> 

<script>
	function initComplete(){
		var timer;
		$("#start").click(function(){
			changeColor();
			timer=setInterval(changeColor,2000)
		})
		$("#stop").click(function(){
			clearInterval(timer)
			$("#text1").animate({color:"#000000"})
		})
		
		var timer2;
		$("#start2").click(function(){
			changeColor2();
			timer2=setInterval(changeColor2,2000)
		})
		$("#stop2").click(function(){
			clearInterval(timer2)
			$(".tableStyle").find("td").animate({color:"#000000"})
		})
	}
	//单行变色
	function changeColor(){
		$("#text1").animate({color:"red"})
		$("#text1").animate({color:"#bc27d2"})
		$("#text1").animate({color:"#2794d2"})
	}
	//多行变色
	function changeColor2(){
		$(".tableStyle").find("td").animate({color:"red"})
		$(".tableStyle").find("td").animate({color:"#2794d2"})
		$(".tableStyle").find("td").animate({color:"#bc27d2"})
	}
</script>
</head>
<body>
<div class="box1" panelWidth="800">
 <fieldset>
   <legend>1、单行变色</legend>
	<div id="text1">提醒：您有新的消息!</div>
	<input type="button" id="start" value="开始">
	<input type="button" id="stop" value="停止">
  </fieldset>
  <div class="height_15"></div>
  
  
  <fieldset>
   <legend>2、多行变色</legend>
	<input type="button" id="start2" value="开始">
	<input type="button" id="stop2" value="停止">
	<table class="tableStyle">
		<tr>
			<th>姓名</th><th>性别</th><th>年龄</th>
		</tr>
		<tr id="a1">
			<td>张小三</td><td>男</td><td>25</td>
		</tr>
		<tr id="a2">
			<td>张小三</td><td>男</td><td>25</td>
		</tr>
		<tr id="a3">
			<td>张小三</td><td>男</td><td>25</td>
		</tr>
		<tr>
			<td>张小三</td><td>男</td><td>25</td>
		</tr>
	</table>
  </fieldset>
  <div class="height_15"></div>
  
  </div>
</body>
</html>