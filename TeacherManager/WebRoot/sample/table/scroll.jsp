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

<!-- 日期选择框start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/datePicker/WdatePicker.js"></script>
<!-- 日期选择框end -->

<!--数字分页start-->
<script type="text/javascript" src="<%=path%>/libs/js/nav/pageNumber.js"></script>
<!--数字分页end-->
</head>
<body>
<div class="box2" panelTitle="功能面板" id="searchPanel">
		<table>
			<tr>
				<td>院系:</td>
				<td><select id="dd">
					<option value="0">请选择</option>
					<option value="1">院系1</option>
					<option value="2">院系2</option>
					<option value="3">院系3</option>
				</select></td>
				<td>时间：</td>
				<td><input type="text" class="date"/></td>
				<td>关键词：</td>
				<td><input type="text" /></td>
				<td><button><span class="icon_find">查询</span></button></td>
			</tr>
			<tr>
				<td colspan="7">
					使用横向滚动条的表格不可使用表头固定模式。
				</td>
			</tr>
		</table>
	</div>
<div id="scrollContent" class="border_gray">
	<table class="tableStyle" thTrueWidth="true" mode="list" fixedCellHeight="true">
		<tr>
			<th trueWidth="150">姓名</th>
			<th trueWidth="100">性别</th>
			<th trueWidth="100">年龄</th>
			<th trueWidth="250">工作</th>
			<th trueWidth="250">联系方式</th>
			<th trueWidth="350">住址</th>
			<th trueWidth="150">婚姻状况</th>
			<th trueWidth="250">备注</th>
			<th trueWidth="100">操作</th>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师软件设计师软件设计师软件设计师软件设计师软件设计师软件设计师
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
		
		
	</table>
</div>


<div style="height:35px;">
	<div class="float_left padding5">
		<button><span class="icon_page">新建</span></button>
		<button><span class="icon_mark">待发布</span></button>
		<button><span class="icon_reply">发布</span></button>
		<button><span class="icon_item">复制</span></button>
		<button><span class="icon_xls">导出</span></button>
	</div>
	<div class="float_right padding5">
		<div class="pageNumber" total="200" showSelect="true" showInput="true" id="page-7"></div>
	</div>
	<div class="clear"></div>
</div>
<script>
var fixObjHeight=160;
function initComplete(){
	 $("#searchPanel").bind("stateChange",function(e,state){
		if(state=="hide"){
			fixObjHeight=90;
		}
		else if(state=="show"){
			fixObjHeight=160;
		}
		triggerCustomHeightSet();
	});
}
function customHeightSet(contentHeight){
	var windowWidth=document.documentElement.clientWidth;
	$("#scrollContent").height(contentHeight-fixObjHeight);
	$("#scrollContent").width(windowWidth-4);
}
</script>
</body>
</html>