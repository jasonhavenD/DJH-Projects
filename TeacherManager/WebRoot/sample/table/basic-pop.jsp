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
			<legend>1、普通弹窗表格</legend>
			<input type="button" value="查看效果"  
onclick='top.Dialog.open({URL:"<%=path%>/sample/table/basic-pop-content1.jsp",Title:"普通弹窗表格",Width:650,Height:400});'/>
<p>
就是把内容放在body中，整体内容随滚动条滚动，没什么特别的地方。
</p>
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset> 
			<legend>2、有上下固定区域的弹窗表格</legend>
			<input type="button" value="查看效果"  
		onclick='top.Dialog.open({URL:"<%=path%>/sample/table/basic-pop-content2.jsp",Title:"有上下固定区域的",ShowMaxButton:true,Width:650,Height:400});'/>
<p>
让弹窗内容也像右侧内页那样有滚动区域和固定区域。
</p>		
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset> 
			<legend>3、表头固定的弹窗表格</legend>
			<input type="button" value="查看效果"  
			onclick='top.Dialog.open({URL:"<%=path%>/sample/table/basic-pop-content3.jsp",Title:"表头固定",ShowMaxButton:true,Width:650,Height:400});'/>
<p>
按照上述方法，也可实现弹窗中表格表头固定。
</p>				
	  </fieldset>
	  <div class="height_15"></div>
	  
	</div>
</body>
</html>