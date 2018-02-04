<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户信息</title>

<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"  scrollerX="false"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!-- 树组件start -->
<script type="text/javascript" src="<%=path%>/libs/js/tree/ztree/ztree.js"></script>
<link type="text/css" rel="stylesheet" href="<%=path%>/libs/js/tree/ztree/ztree.css"></link>
<!-- 树组件end -->

<!-- 树形下拉框start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/selectTree.js"></script>
<!-- 树形下拉框end -->

<!-- 日期选择框start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/datePicker/WdatePicker.js"></script>
<!-- 日期选择框end -->

<!-- 双向选择器start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/lister.js"></script>
<!-- 双向选择器end -->

<!-- 树形双选器start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/listerTree.js"></script>
<!-- 树形双选器end -->

<!-- 颜色选择器start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/color.js"></script>
<!-- 颜色选择器start -->

<!-- 数字步进器start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/stepper.js"></script>
<!-- 数字步进器end -->

<!-- 软键盘控件start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/keypad.js"></script>
<!-- 软键盘控件start -->

<!-- 评星级控件start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/rating.js"></script>
<!-- 评星级控件end -->

<!-- 表单验证start -->
<script src="<%=path%>/libs/js/form/validationRule.js" type="text/javascript"></script>
<script src="<%=path%>/libs/js/form/validation.js" type="text/javascript"></script>
<!-- 表单验证end -->

</head>
<body style="background-color:#ffffff;">
	<form id="myFormId" action="<%=path%>/fullform/saveForm.do" method="post" target="frmright" failAlert="表单填写不正确，请按要求填写！">
	<table class="tableStyle" formMode="transparent">
		<tr>
			<td width="150">文本框：</td><td><input name="bo.text" type="text"  class="validate[required]" watermark="员工姓名"/><span class="star">*</span></td>
		</tr>
		
		<tr>
			<td>单选按钮：</td>
			<td><input type="radio" id="radio-1" name="bo.radio" value="男" /><label for="radio-1" class="hand">男</label>
				<input type="radio" id="radio-2" name="bo.radio" value="女"/><label for="radio-2" class="hand">女</label>
			</td>
		</tr>
		<tr>
			<td>多选按钮：</td>
			<td><input type="checkbox" id="checkbox-1" name="bo.checkboxs" value="唱歌"/><label for="checkbox-1" class="hand">唱歌</label>
				<input type="checkbox" id="checkbox-2" name="bo.checkboxs" value="跳舞" /><label for="checkbox-2" class="hand">跳舞</label>
			</td>
		</tr>
		<tr>
			<td>单选下拉框：</td>
			<td>
			<select prompt="请选择员工" data='{"list":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"}]}'></select>
			</td>
		</tr>
		<tr>
			<td>文本框：</td><td><input  type="text"/></td>
		</tr>
		<tr>
			<td>文本框：</td><td><input  type="text"/></td>
		</tr>
		<tr>
			<td>文本框：</td><td><input  type="text"/></td>
		</tr>
		<tr>
			<td>文本框：</td><td><input  type="text"/></td>
		</tr>
		<tr>
			<td>日期选择框：</td><td><input type="text" name="bo.datetime" class="date"/></td>
		</tr>
		<tr>
			<td>颜色选择器：</td>
			<td>
				<input type="text" class="color" name="bo.color"/>
			</td>
		</tr>
		<tr>
			<td>数字步进器：</td>
			<td>
				<input type="text" class="stepper" name="bo.spinbox" value="0"/>
			</td>
		</tr>
		<tr>
			<td>软键盘控件：</td>
			<td>
				<input type="text" name="bo.keypad" class="keypad"/>
			</td>
		</tr>
		<tr>
			<td>评星级控件：</td>
			<td>
				<div class="rating" name="bo.raty"></div>
			</td>
		</tr>
		<tr>
			<td>文本域：</td>
			<td>
				<textarea name="bo.textarea"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value=" 提 交 "/>
				<input type="button" value=" 重 置 "/>
			</td>
		</tr>
	</table>
	</form>
	


</body>
</html>