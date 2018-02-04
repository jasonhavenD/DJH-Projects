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
	$(function(){
		$("#text0").val(top.document.getElementById("frmright").contentWindow.tdText0);
		$("#text1").val(top.document.getElementById("frmright").contentWindow.tdText1);
		$("#text2").val(top.document.getElementById("frmright").contentWindow.tdText2);
		$("#text3").val(top.document.getElementById("frmright").contentWindow.tdText3);
	})
	function refreshRow(){
		var val0=$("#text0").val();
		var val1=$("#text1").val();
		var val2=$("#text2").val();
		var val3=$("#text3").val();
		top.document.getElementById("frmright").contentWindow.refreshRow(val0,val1,val2,val3);
		top.Dialog.close();
	}
</script>
<body>
	<div class="box1" whiteBg="true">
	<form>
	<table class="tableStyle" formMode="transparent">
		<tr>
			<td>属性1：</td><td><input type="text" id="text0"/></td>
		</tr>
		<tr>
			<td>属性2：</td><td><input type="text" id="text1"/></td>
		</tr>
		<tr>
			<td>属性3：</td><td><input type="text" id="text2"/></td>
		</tr>
		<tr>
			<td>属性4：</td><td><input type="text" id="text3"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value=" 提 交 " onclick="refreshRow()"/>
				<input type="reset" value=" 重 置 "/>
			</td>
		</tr>
	</table>
	</form>
	</div>
</body>
</html>