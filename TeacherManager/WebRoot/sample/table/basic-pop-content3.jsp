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
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/" scrollerY="false"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!--数字分页start-->
<script type="text/javascript" src="<%=path%>/libs/js/nav/pageNumber.js"></script>
<!--数字分页end-->
<script>
	var fixObjHeight=100;
	function customHeightSet(contentHeight){
		$("#scrollContent").height(contentHeight-fixObjHeight);
	}
</script>
<body>
<div class="padding5" style="height:28px;">
	<table>
		<tr>
			<td>院系:</td>
			<td><select id="dd">
				<option value="0">请选择</option>
				<option value="1">院系1</option>
				<option value="2">院系2</option>
				<option value="3">院系3</option>
			</select></td>
			<td>关键词：</td>
			<td><input type="text" /></td>
			<td><button type="button"><span class="icon_find">查询</span></button></td>
		</tr>
	</table>
</div>
<div>
	<table class="tableStyle" sortMode="true" headFixMode="true" useMultColor="true">
		<tr>
			<th width="80">姓名</th>
			<th width="60">性别</th>
			<th>住址</th>
			<th width="100">婚姻状况</th>
			<th width="80">操作</th>
		</tr>
	</table>
</div>

<div id="scrollContent" style="overflow-x:hidden;">
	<table class="tableStyle" headFixMode="true" mode="list">
		<tbody>
		<tr>
			<td width="80">张小三</td>
			<td width="60">男</td>
			<td>住址内容,住址内容,住址内容</td>
			<td width="100">已婚</td>
			<td width="80"><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td width="80">张小三</td>
			<td width="60">男</td>
			<td>住址内容,住址内容,住址内容</td>
			<td width="100">已婚</td>
			<td width="80"><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		</tbody>
	</table>
</div>
<div style="height:35px;">
	<div class="float_left padding5">
	</div>
	<div class="float_right padding5">
		<div class="pageNumber" total="200" showSelect="false" showInput="false" id="page-7"></div>
	</div>
	<div class="clear"></div>
</div>
</body>