<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>文本域</title>
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
			<legend>1、基本文本域</legend>
			<table class="tableStyle" formMode="transparent" >
				<tr>
					<td width="10%">备注：</td><td width="90%"><textarea></textarea></td>
				</tr>
			</table>
	   </fieldset> 
	   <div class="height_15"></div>
	   
	   <fieldset> 
			<legend>2、设置初始值</legend>
			<table class="tableStyle" formMode="transparent" >
				<tr>
					<td width="10%">备注：</td><td width="90%"><textarea>这是初始值</textarea></td>
				</tr>
			</table>
	   </fieldset> 
	   <div class="height_15"></div>
	   
	   <fieldset> 
			<legend>3、自定义尺寸</legend> 
			<table class="tableStyle" formMode="transparent" >
				<tr>
					<td width="10%">备注：</td><td width="90%"><textarea style="width:350px;height:150px;"></textarea></td>
				</tr>
			</table>
	   </fieldset>
	   <div class="height_15"></div>
	   
	   <fieldset> 
			<legend>4、显示水印</legend> 
			<table class="tableStyle" formMode="transparent" >
				<tr>
					<td width="10%">备注：</td><td width="90%"><textarea watermark="请填写备注信息"></textarea></td>
				</tr>
			</table>
	   </fieldset>
	   <div class="height_15"></div>
	   
	   <fieldset> 
			<legend>5、限制输入字数</legend> 
			<table class="tableStyle" formMode="transparent" >
				<tr>
					<td width="10%">备注：</td><td width="90%"><textarea maxNum="150"></textarea></td>
				</tr>
			</table>
	   </fieldset>
	   <div class="height_15"></div>
	   
	   <fieldset> 
			<legend>6、高度可变</legend> 
			<table class="tableStyle" formMode="transparent" >
				<tr>
					<td width="10%">备注：</td><td width="90%"><textarea resize="true"></textarea></td>
				</tr>
			</table>
	   </fieldset>
	   <div class="height_15"></div>
	   
	   <fieldset> 
			<legend>7、高度自适应</legend> 
			<table class="tableStyle" formMode="transparent" >
				<tr>
					<td width="10%">备注：</td><td width="90%"><textarea autoHeight="true"></textarea></td>
				</tr>
			</table>
	   </fieldset>
	   <div class="height_15"></div>
	   
	   <fieldset> 
			<legend>8、动态生成文本域</legend>
			<input type="button" value="点击生成文本域" id="testBtn"/>
			<div class="height_10"></div>
			
	   </fieldset>
	   <div class="height_15"></div>
	   
	   <fieldset> 
			<legend>9、禁用/启用</legend>
			<table class="tableStyle" formMode="transparent">
				<tr>
					<td width="10%">备注：</td><td width="90%"><textarea id="textarea-9" disabled="true"></textarea></td>
				</tr>
				<tr>
					<td colspan="2">
					<input type="button" value="启用" onclick="enableSelect()" style="width:105px;"/>
      				  <input type="button" value="禁用" onclick="disableSelect()" style="width:105px;"/>
					</td>
				</tr>
			</table>
	   </fieldset>
	   <div class="height_15"></div>
	   
	   
	   <fieldset> 
			<legend>10、浏览器原始文本域</legend> 
			<table class="tableStyle" formMode="transparent" >
				<tr>
					<td width="10%">备注：</td><td><textarea  keepDefaultStyle="true"></textarea></td>
				</tr>
			</table>
	   </fieldset>

	</div>


<script type="text/javascript">

    //动态生成文本域
	$(function(){
		$("#testBtn").click(function(){
			var $ta=$('<textarea class="textarea" watermark="请填写备注信息"></textarea>');
			$(this).after($ta);
			$ta.render();
		})
	})
	
	 //设为不可用
	function disableSelect(){
		$("#textarea-9").attr("disabled",true);
	}
	//设为可用
	function enableSelect(){
	    $("#textarea-9").attr("disabled",false);
	}

</script>

</body>
</html>