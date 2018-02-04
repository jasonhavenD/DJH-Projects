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
<form action="<%=path%>/sample/popup/window.jsp" target="frmright" class="padding_top10">
		<table class="tableStyle" formMode="line">
		<tr>
			<td>姓名：</td><td><input type="text"/></td>
		</tr>
		<tr>
			<td>曾用名：</td><td><input type="text"/></td>
		</tr>
		<tr>
			<td>民族：</td>
			<td>
				<select id="sel">
				    <option value="1">汉族</option>
				    <option value="2">满族</option>
				    <option value="3">维吾尔族</option>
				 </select>
			</td>
		</tr>
		<tr>
			<td>邮政编码：</td><td><input type="text"/></td>
		</tr>
		<tr>
			<td>常用地址：</td><td><input type="text" style="width:250px;"/></td>
		</tr>
		<tr>
			<td>备注：</td>
			<td>
				<textarea></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="提交"/>
				<input type="reset" value="取消" onclick="closeWin()"/>
			</td>
		</tr>
	</table>
	</form>		
	<script>
	function closeWin(){
		top.Dialog.close()
	}
	</script>
	
</body>
</html>