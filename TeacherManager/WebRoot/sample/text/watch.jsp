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

<!--监听文字改变start-->
<script type="text/javascript" src="<%=path%>/libs/js/method/typewatch.js"></script>
<!--监听文字改变end--> 
<script type="text/javascript">
	$(function(){
		$("#text1").typeWatch( { captureLength:2,highlight:false,wait:2000, callback:finished } );
	})
	
	function finished(txt) {
		top.Dialog.alert('输入: ' + txt);
	}
</script>
</head>
<body>
<div class="box1" panelWidth="800">
 <fieldset>
   <legend>1、基本使用</legend>
	<textarea id="text1" watermark="请输入两个以上的字"></textarea>
  </fieldset>
  <div class="height_15"></div>
  
  
  </div>
</body>
</html>