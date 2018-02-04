<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>文本/密码框</title>
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
			<legend>1、基本文本框</legend> 
			<table class="tableStyle" formMode="transparent">
				<tr>
					<td width="10%">姓名：</td><td width="40%"><input type="text"/></td>
					<td width="10%">密码：</td><td width="40%"><input type="password"/></td>
				</tr>
			</table>
	   </fieldset> 
	   <div class="height_15"></div>
	   
	   <fieldset> 
			<legend>2、自定义宽度</legend> 
			<table class="tableStyle" formMode="transparent">
				<tr>
					<td width="10%">曾用名：</td><td colspan="3"><input type="text" style="width:300px;" /></td>
				</tr>
			</table>
	   </fieldset>
	   <div class="height_15"></div>
	   
	   <fieldset> 
			<legend>3、显示水印</legend> 
			<table class="tableStyle" formMode="transparent">
				<tr>
					<td width="10%">用户名：</td><td colspan="3"><input type="text" watermark="输入字母或数字"/></td>
				</tr>
			</table>
			<div class="height_10"></div>
			注意：当文本框启用了水印并且无输入时，那么在提交表单时使用表单的onsubmit事件会导致文本框的value值不为空。
			<br/>解决办法详见开发手册中的对应的章节。
	   </fieldset>
	   <div class="height_15"></div>
	   
	   <fieldset> 
			<legend>4、可清除内容</legend> 
			<table class="tableStyle" formMode="transparent">
				<tr>
					<td width="10%">姓名：</td><td width="40%"><input type="text" clearable="true"/></td>
					<td width="10%">密码：</td><td width="40%"><input type="password" clearable="true"/></td>
				</tr>
			</table>
	   </fieldset>
	   <div class="height_15"></div>
	   
	   <fieldset> 
			<legend>5、限制输入字数</legend> 
			<p>限制输入个数的基本做法是使用maxlength。效果如下：</p>
			<table class="tableStyle" formMode="transparent">
				<tr>
					<td width="10%">姓名：</td><td width="40%"><input type="text" maxlength="6"/></td>
					<td width="10%">密码：</td><td width="40%"><input type="password" maxlength="6"/></td>
				</tr>
			</table>
			<br/>
			<p>如果想显示还剩余多少字，使用maxNum。效果如下：</p>
			<table class="tableStyle" formMode="transparent">
				<tr>
					<td width="10%">姓名：</td><td width="40%"><input type="text" maxNum="6"/></td>
					<td width="10%">密码：</td><td width="40%"><input type="password" maxNum="6"/></td>
				</tr>
			</table>
	   </fieldset>
	   <div class="height_15"></div>
	   
	   <fieldset> 
			<legend>6、限制输入类型</legend> 
			<table class="tableStyle" formMode="transparent">
				<tr>
					<td width="10%">示例1：</td><td colspan="3"><input type="text" style="width:200px;" inputMode="numberOnly"  watermark="限制输入正整数"/></td>
				</tr>
				<tr>
					<td width="10%">示例2：</td><td colspan="3"><input type="text" style="width:200px;" inputMode="positiveDecimal"  watermark="限制输入非负整数或小数"/></td>
				</tr>
			</table>
	   </fieldset>
	   <div class="height_15"></div>
	   
	   <fieldset> 
			<legend>7、密码框默认自动监测Caps键（此功能可关闭）</legend> 
			<table class="tableStyle" formMode="transparent">
				<tr>
					<td width="10%">密码：</td><td colspan="3"><input type="password"/>（打开大写键后进行输入）</td>
				</tr>
			</table>
	   </fieldset>
	   <div class="height_15"></div>
	   
	   <fieldset> 
			<legend>8、显示密码强度</legend> 
			<table class="tableStyle" formMode="transparent">
				<tr>
					<td width="10%">密码：</td><td colspan="3"><input type="password" checkStrength="true"/></td>
				</tr>
			</table>
			表单验证组件自带了密码强度检测，所以如果使用使用了表单验证，不需要开启此功能。
	   </fieldset>
	   <div class="height_15"></div>
	   
	   <fieldset> 
			<legend>9、密码框设置初始值</legend> 
<table class="tableStyle" formMode="transparent">
	<tr>
		<td width="10%">密码：</td><td colspan="3"><input type="password" value="123456"/></td>
	</tr>
</table>
	   </fieldset>
	   <div class="height_15"></div>
	   
	   <fieldset> 
			<legend>10、禁用/启用</legend> 
				<table class="tableStyle" formMode="transparent">
					<tr>
						<td width="10%">姓名：</td><td width="40%"><input type="text" id="input-10-1" disabled="true"/></td>
						<td width="10%">密码：</td><td width="40%"><input type="password" id="input-10-2" disabled="true"/></td>
					</tr>
					<tr>
						<td colspan="4">
		  				 <input type="button" value="启用" onclick="enableSelect()" style="width:105px;"/>
		  				  <input type="button" value="禁用" onclick="disableSelect()" style="width:105px;"/>
						</td>
					</tr>
				</table>
	   </fieldset> 
	   <div class="height_15"></div>
	   
	   <fieldset> 
			<legend>11、动态生成</legend>
			<input type="button" value="点击生成文本框" id="testBtn"/><br/><br/>
			<input type="button" value="点击生成密码框" id="testBtn2"/>
			<div class="height_10"></div>
	   </fieldset>
	   <div class="height_15"></div>
	   
	    <fieldset> 
			<legend>12、监听回车事件</legend> 
				在文本框中输入后按回车会切换到密码框。密码框输入后按回车来进行登录处理。
				<table class="tableStyle" formMode="transparent" style="width:340px;">
					<tr>
						<td width="20%">姓名：</td><td width="80%"><input type="text" id="input-12-1"/></td>
					</tr>
					<tr>
						<td>密码：</td><td><input type="password" id="input-12-2"/></td>
					</tr>
					<tr>
						<td colspan="2"><input type="button" value="登录" style="width:105px;"/>&nbsp;&nbsp;<input type="reset" value="重置" style="width:105px;"/></td>
					</tr>
				</table>
	   </fieldset> 
	   <div class="height_15"></div>
	   
	   
	   <fieldset> 
			<legend>13、浏览器原始文本框</legend> 
			<table class="tableStyle" formMode="transparent">
				<tr>
					<td width="10%">姓名：</td><td colspan="3"><input type="text" keepDefaultStyle="true"/></td>
				</tr>
			</table>
	   </fieldset>

	</div>


<script type="text/javascript">

    //动态生成文本框
	$(function(){
		$("#testBtn").click(function(){
			var $input=$('<input type="text" watermark="输入字母或数字">');
			$(this).after($input);
			$input.render();
		})
		$("#testBtn2").click(function(){
			var $pass=$('<input type="password" checkStrength="true">');
			$(this).after($pass);
			$pass.render();
		})
		
		$("#input-12-1").bind("enter",function(){
			$("#input-12-2").focus();
		})
		$("#input-12-2").bind("enter",function(){
			top.Dialog.alert("进行提交处理");
		})
	})
	
	 //设为不可用
	function disableSelect(){
		$("#input-10-1").attr("disabled",true);
		
		$("#input-10-2").attr("disabled",true);
	}
	//设为可用
	function enableSelect(){
	    $("#input-10-1").attr("disabled",false);
	    
	    $("#input-10-2").attr("disabled",false);
	}

</script>

</body>
</html>