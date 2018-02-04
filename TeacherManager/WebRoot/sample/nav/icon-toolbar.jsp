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

<!-- 日期选择框start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/datePicker/WdatePicker.js"></script>
<!-- 日期选择框end -->

<!--修正IE6不支持PNG图start-->
<style>
img {
	behavior:url("<%=path%>/libs/js/method/pngFix/pngbehavior.htc");
}
</style>
<!--修正IE6不支持PNG图end-->
</head>
<body>
 	<fieldset> 
     <legend>大尺寸工具栏</legend>
	 <div class="box_tool padding_bottom3 padding_right5">
		<div class="center">
		<div class="left">
		<div class="right">
			<a href="javascript:;">
			<div class="navIconTool" onclick="top.Dialog.alert('搜索')">
				<img src="<%=path%>/libs/icons/navIcon/tool_01.png"/><br />
				搜索
			</div>
			</a>
			<a href="javascript:;">
			<div class="navIconTool" onclick="top.Dialog.alert('应用')">
				<img src="<%=path%>/libs/icons/navIcon/tool_02.png"/><br />
				应用
			</div>
			</a>
			<a href="javascript:;">
			<div class="navIconTool" onclick="top.Dialog.alert('统计')">
				<img src="<%=path%>/libs/icons/navIcon/tool_03.png"/><br />
				统计
			</div>
			</a>
			<a href="javascript:;">
			<div class="navIconTool" onclick="top.Dialog.alert('导入')">
				<img src="<%=path%>/libs/icons/navIcon/tool_04.png"/><br />
				导入
			</div>
			</a>
			<a href="javascript:;">
			<div class="navIconTool" onclick="top.Dialog.alert('增加')">
				<img src="<%=path%>/libs/icons/navIcon/tool_05.png"/><br />
				增加
			</div>
			</a>
			<a href="javascript:;">
			<div class="navIconTool" onclick="top.Dialog.alert('删除')">
				<img src="<%=path%>/libs/icons/navIcon/tool_06.png"/><br />
				删除
			</div>
			</a>
			<a href="javascript:;">
			<div class="navIconTool" onclick="top.Dialog.alert('锁定')">
				<img src="<%=path%>/libs/icons/navIcon/tool_07.png"/><br />
				锁定
			</div>
			</a>
			<a href="javascript:;">
			<div class="navIconTool" onclick="top.Dialog.alert('导出')">
				<img src="<%=path%>/libs/icons/navIcon/tool_08.png"/><br />
				导出
			</div>
			</a>
			<a href="javascript:;">
			<div class="navIconTool" onclick="top.Dialog.alert('打印预览')">
				<img src="<%=path%>/libs/icons/navIcon/tool_09.png"/><br />
				打印预览
			</div>
			</a>
			<a href="javascript:;">
			<div class="navIconTool" onclick="top.Dialog.alert('打印')">
				<img src="<%=path%>/libs/icons/navIcon/tool_10.png"/><br />
				打印
			</div>
			</a>
			<a href="javascript:;">
			<div class="navIconTool" onclick="top.Dialog.alert('关于')">
				<img src="<%=path%>/libs/icons/navIcon/tool_11.png"/><br />
				关于
			</div>
			</a>
			<div class="clear"></div>
		</div>		
		</div>	
		</div>
	</div>    	
	</fieldset>
	
	<fieldset> 
     <legend>中尺寸工具栏</legend>
	<div class="box_tool_mid padding_top5 padding_right5">
		<div class="center">
		<div class="left">
		<div class="right">
			<div class="padding_top8 padding_left10">
			<table>
				<tr>
					<td>类型：</td>
					<td><select id="dd">
						<option value="0">请选择</option>
						<option value="1">类型1</option>
						<option value="2">类型2</option>
						<option value="3">类型3</option>
					</select></td>
					<td>时间：</td>
					<td><input type="text" class="date"/></td>
					<td>关键词：</td>
					<td><input type="text" /></td>
					<td>
						<label for="checkbox-1" >全站搜索</label><input type="checkbox" id="checkbox-1" value="0"/>
					</td>
					<td><button><span class="icon_find">查询</span></button></td>
				</tr>
			</table>
			</div>			
		</div>		
		</div>	
		</div>
		<div class="clear"></div>
	</div>     	
	</fieldset>
	
	<fieldset> 
     <legend>迷你工具栏</legend>
	<div class="box_tool_min padding_top2 padding_bottom2 padding_right5">
		<div class="center">
		<div class="left">
		<div class="right">
			<div class="padding_top5 padding_left10">
			<a href="javascript:;"><span class="icon_view">查看</span></a>
			<div class="box_tool_line"></div>
			<a href="javascript:;"><span class="icon_edit">修改</span></a>
			<div class="box_tool_line"></div>
			<a href="javascript:;"><span class="icon_add">新增</span></a>
			<div class="box_tool_line"></div>
			<a href="javascript:;"><span class="icon_delete">删除</span></a>
			<div class="box_tool_line"></div>
			<a href="javascript:;"><span class="icon_find">查找</span></a>
			<div class="box_tool_line"></div>
			<a href="javascript:;"><span class="icon_mark">标记</span></a>
			<div class="box_tool_line"></div>
			<a href="javascript:;"><span class="icon_no">取消</span></a>
			<div class="box_tool_line"></div>
			<a href="javascript:;"><span class="icon_print">打印</span></a>
			<div class="box_tool_line"></div>
			<a href="javascript:;"><span class="icon_refresh">刷新</span></a>
			<div class="box_tool_line"></div>
			<a href="javascript:;"><span class="icon_save">保存</span></a>
			<div class="clear"></div>
			</div>
		</div>		
		</div>	
		</div>
		<div class="clear"></div>
	</div>     	
	</fieldset>
</body>
</html>