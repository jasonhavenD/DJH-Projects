<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<!--分离模式框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css" id="theme" themeColor="blue"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/" splitMode="true" href="<%=path%>/libs/skins/blue/style.css"/>
<link rel="stylesheet" type="text/css" id="customSkin" href="<%=path%>/system/layout/skin/style.css"/>
<!--分离模式框架必需end-->

<!-- 日期控件start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/datePicker/WdatePicker.js"></script>
<!-- 日期控件end -->

<!-- 树组件start -->
<script type="text/javascript" src="<%=path%>/libs/js/tree/ztree/ztree.js"></script>
<link type="text/css" rel="stylesheet" href="<%=path%>/libs/js/tree/ztree/ztree.css"></link>
<!-- 树组件end -->

<!-- 树形下拉框start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/selectTree.js"></script>
<!-- 树形下拉框end -->

<!-- 表单验证start -->
<script src="<%=path%>/libs/js/form/validationRule.js" type="text/javascript"></script>
<script src="<%=path%>/libs/js/form/validation.js" type="text/javascript"></script>
<!-- 表单验证end -->


</head>
<body>
	<div class="box1" id="formContent" whiteBg="true">
	<form>
	<table class="tableStyle" formMode="transparent">
		<input type="hidden" name="bo.id" value="<s:property value='bo.id' />" />
		<tr>
			<td width="150">用户名：</td><td><input type="text" class="validate[required,custom[noSpecialCaracters]]" watermark="请输入英文或数字"/><span class="star">*</span></td>
		</tr>
		<tr>
			<td>密码：</td><td><input type="password" id="pwd" class="validate[required,length[6,11],custom[noSpecialCaracters]]"/><span class="star">*</span> </td>
		</tr>
		<tr>
			<td>密码确认：</td><td><input type="password" class="validate[required,confirm[pwd]]"/><span class="star">*</span></td>
		</tr>
		<tr>
			<td width="150">姓名：</td><td><input type="text" class="validate[required,custom[chinese],length[0,20]]"/><span class="star">*</span></td>
		</tr>
		<tr>
			<td>所属部门：</td>
			<td>
			<div class="selectTree validate[required]"  data='{"treeNodes":[{ "id":"1", "parentId":"0", "name":"部门1", "open": "true"},{ "id":"2", "parentId":"0", "name":"部门2", "open": "true"}]}'></div><span class="star">*</span>	</td>
		</tr>
		<tr>
			<td>性别：</td><td><div style="width:120px;"><input type="radio" id="radio-1" name="ra" value="radio-1" /><label for="radio-1" class="hand">男</label>
				<input type="radio" id="radio-2" name="ra" value="radio-2"/><label for="radio-2" class="hand">女</label></td>
		</tr>
		<tr>
			<td>入职时间：</td><td><input  type="text" class="date"/></td>
		</tr>
		<tr>
			<td>学历：</td><td><select selectedValue="2"  data='{"list":[{"value":"1","key":"大专"},{"value":"2","key":"本科"},{"value":"3","key":"硕士"},{"value":"4","key":"博士"}]}'></select></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="提交" onclick='top.Dialog.alert("通过异步提交表单来新增数据。见JAVA版或.NET版演示。");'/>
				<input type="button" value="取消" onclick='top.Dialog.close()'/>
			</td>
		</tr>
	</table>
	</form>
	</div>
	
</html>