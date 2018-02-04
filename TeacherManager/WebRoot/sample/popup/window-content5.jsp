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
<script>
	function window1Func(){
		alert("这是第一个窗口的方法！");
	}
</script>
<body>
	<fieldset> 
     <legend>dom节点获取</legend>
     	弹出窗口后新窗口的表单内容会回填到这里：<input type="text" id="input1"/><br />
		<input type="button" value="弹出窗口" onclick='top.Dialog.open({URL:"<%=path%>/sample/popup/window-content6.jsp",Width:300,Height:200,Title:"第二个窗口"});'/>
	  </fieldset>
	  <div class="height_25"></div>
	  
	  <fieldset> 
     <legend>方法互调</legend>
     <input type="button" value="弹出窗口" onclick='top.Dialog.open({URL:"<%=path%>/sample/popup/window-content7.jsp",Width:300,Height:200,Title:"第三个窗口"});'/>
	  </fieldset>
	
</body>
</html>