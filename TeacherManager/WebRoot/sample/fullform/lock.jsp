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
<body style="overflow:hidden;">
<div id="screenLock" class="screenLock">
<form>
<table width="100%">
	<tr>
	<td  class="ali03">登录密码解锁：</td>
	<td><input type="password" id="lockInput"/>
	<input type="text" style="width:2px;display:none;"/>
	</td>
	</tr>
	<tr>
	<td ></td>
	<td><span id="passInfo" class="red"></span></td>
	</tr>
</table>
</form>
</div>
<script>
//手动触发验证
$(function(){
	$("#lockInput").val("");
	$("#lockInput").keydown(function(event){
		 	if(event.keyCode==13){
				validateForm();
			}
		 })
})
function validateForm(){
	var password = $("#lockInput").val();
    if(password==""){
    	$("#passInfo").text("密码不能为空");
    }
    else{
    	$.post("<%=path%>/userAction.do?method=unlockScreen",{"password":password},function(result){
    		if(result.isPass){
    			$("#passInfo").text("");
    	    	top.Dialog.close();
    		}else{
    			$("#passInfo").text("密码错误");
    		}
    	});
    	
    }
} 
</script>
</body>
</html>