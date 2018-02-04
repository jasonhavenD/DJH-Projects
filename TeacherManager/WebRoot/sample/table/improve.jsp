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
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/" scrollerY="false" autoRender="false"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!-- 日期选择框start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/datePicker/WdatePicker.js"></script>
<!-- 日期选择框end -->

<!--数字分页start-->
<script type="text/javascript" src="<%=path%>/libs/js/nav/pageNumber.js"></script>
<!--数字分页end-->
<script>
var fixObjHeight=130;
function initComplete(){
	$(".tableStyle").find('tr').hover(function(){
			$(this).addClass('highlight');
		}, function(){
			$(this).removeClass('highlight');
		});
		//点击着色
		//$(".tableStyle").find("tr").click(function(){
			//$(this).siblings().removeClass('selected');
			//$(this).addClass('selected');
		//});
		
		$("#select-1").render();
		$("#date-1").render();
		$("#btn-1").render();
		$("#page-1").render();
}
function customHeightSet(contentHeight){
	$("#scrollContent").height(contentHeight-fixObjHeight);
}
</script>
</head>
<body>
<div class="box2"><div id="box_topcenter" class="box_topcenter"><div class="box_topleft"><div class="box_topright"><div class="title"><span>表单标题</span></div><div class="boxSubTitle"></div><div class="clear"></div></div></div></div><div class="box_middlecenter"><div class="box_middleleft"><div class="box_middleright"><div class="boxContent" style="overflow: visible;">
<div class="padding_top5">
		<table>
			<tr>
				<td>院系:</td>
				<td><select id="select-1">
					<option value="0">请选择</option>
					<option value="1">院系1</option>
					<option value="2">院系2</option>
					<option value="3">院系3</option>
				</select></td>
				<td>时间：</td>
				<td><input type="text" class="date" id="date-1"/></td>
				<td>关键词：</td>
				<td><input type="text" class="textinput" /></td>
				<td><button id="btn-1"><span class="icon_find">查询</span></button></td>
			</tr>
		</table>
</div>
</div></div></div></div><div id="box_bottomcenter" class="box_bottomcenter"><div class="box_bottomleft"><div class="box_bottomright"></div></div></div></div>
<div id="scrollContent"   style="overflow-x:hidden;">
	<table class="tableStyle">
		<tr>
			<th class="th">姓名</th>
			<th class="th">性别</th>
			<th class="th">年龄</th>
			<th class="th">工作</th>
			<th class="th">联系方式</th>
			<th class="th">住址</th>
			<th class="th">婚姻状况</th>
			<th class="th">备注</th>
			<th class="th">操作</th>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr class="odd">
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr class="odd">
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr class="odd">
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr class="odd">
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr class="odd">
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr class="odd">
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr class="odd">
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr class="odd">
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr class="odd">
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		
		
	</table>
</div>


<div style="height:35px;">
	<div class="float_left padding5">
	</div>
	<div class="float_right padding5">
		<div class="pageNumber" total="200" showSelect="true" showInput="true" id="page-1"></div>
	</div>
	<div class="clear"></div>
</div>
</body>
</html>