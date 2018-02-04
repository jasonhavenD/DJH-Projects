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

<!--数字分页start-->
<script type="text/javascript" src="<%=path%>/libs/js/nav/pageNumber.js"></script>
<!--数字分页end-->

<!--lodop打印控件start-->
<script src="<%=path%>/libs/thirdparty/lodop/LodopFuncs.js" type="text/javascript"></script>
<object  id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width="0" height="0" style="line-height:0px;"> 
       <embed id="LODOP_EM" type="application/x-print-lodop" width="0" height="0" style="line-height:0px;"></embed>
</object>
<!--lodop打印控件end-->

<!--打印的表格样式start-->
<style id="printStyle">
.tablePrint{
 	border-collapse: collapse;
	border: 1px solid #000000;
	width: 100%;
	background-color: White;
}
.tablePrint th{
 	border-left: 1.0pt solid windowtext;
	border-right: 1.0pt solid windowtext;
	border-bottom: 1.0pt solid windowtext;
	word-wrap: normal;
	word-break: keep-all;
	overflow:hidden;
	border-color: #000000;
	height:32px; 
	padding: 0 2px 0 4px;
	background-color:#cccccc;
	color:#000000;
	font-weight: normal;
	line-height:32px; 
}
.tablePrint td{
 	border-left: 1.0pt solid windowtext;
	border-right: 1.0pt solid windowtext;
	border-bottom: 1.0pt solid windowtext;
	border-color: #000000;
	height:30px; 
	padding: 1px 2px 1px 4px;
}
.tablePrint .printHide{
	display:none;
}
</style>
<!--打印的表格样式end-->
</head>
<body>
<div>
<div style="display:none;" id="content"><img src="<%=path%>/sample/thirdparty/lodop/view2.jpg"/></div>
注意：需要连接打印机才能正常测试。如果没有测试条件，可以<a style="color:red" onclick="popWin()">点击这里</a>查看实际效果截图，或者<a href="http://qui-frame.googlecode.com/files/PDFCreator-0_9_9_setup.exe" style="color:red">点击下载</a>并安装虚拟打印机进行测试。
<br/>如果安装了虚拟打印机，还有一个额外的功能，就是能够把要打印的数据直接输出成PDF文件（在打印预览窗口点击打印按钮）。
</div>
<div class="box_tool_min padding_top2 padding_bottom2 padding_right5">
	<div class="center">
	<div class="left">
	<div class="right">
		<div class="padding_top5 padding_left10">
		<a href="javascript:;" onclick="printHandler()"><span class="icon_print">打印本页数据</span></a>
		<div class="box_tool_line"></div>
		<a href="javascript:;" onclick="printHandler2()"><span class="icon_print">打印选中数据</span></a>
		<div class="clear"></div>
		</div>
	</div>		
	</div>	
	</div>
	<div class="clear"></div>
</div> 
<table class="tableStyle" mode="list" id="myTable" useCheckbox="true" selectRowButtonOnly="false">
		<tr>
			<th class="printHide"></th>
			<th>姓名</th>
			<th>性别</th>
			<th>年龄</th>
			<th>工作</th>
			<th>联系方式</th>
			<th>住址</th>
			<th>婚姻状况</th>
			<th>备注</th>
			<th class="printHide">操作</th>
		</tr>
		<tr>
			<td class="printHide"><input type="checkbox" value="1"/></td>
			<td>员工</td>
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
			<td class="printHide"><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td class="printHide"><input type="checkbox" value="2"/></td>
			<td>员工2</td>
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
			<td class="printHide"><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td class="printHide"><input type="checkbox" value="3"/></td>
			<td>员工3</td>
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
			<td class="printHide"><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td class="printHide"><input type="checkbox" value="4"/></td>
			<td>员工4</td>
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
			<td class="printHide"><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td class="printHide"><input type="checkbox" value="5"/></td>
			<td>员工5</td>
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
			<td class="printHide"><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td class="printHide"><input type="checkbox" value="6"/></td>
			<td>员工6</td>
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
			<td class="printHide"><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td class="printHide"><input type="checkbox" value="7"/></td>
			<td>员工7</td>
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
			<td class="printHide"><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td class="printHide"><input type="checkbox" value="8"/></td>
			<td>员工8</td>
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
			<td class="printHide"><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td class="printHide"><input type="checkbox" value="9"/></td>
			<td>员工9</td>
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
			<td class="printHide"><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td class="printHide"><input type="checkbox" value="10"/></td>
			<td>员工10</td>
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
			<td class="printHide"><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td class="printHide"><input type="checkbox" value="11"/></td>
			<td>员工11</td>
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
			<td class="printHide"><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td class="printHide"><input type="checkbox" value="12"/></td>
			<td>员工12</td>
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
			<td class="printHide"><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td class="printHide"><input type="checkbox" value="13"/></td>
			<td>员工13</td>
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
			<td class="printHide"><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td class="printHide"><input type="checkbox" value="14"/></td>
			<td>员工14</td>
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
			<td class="printHide"><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td class="printHide"><input type="checkbox" value="15"/></td>
			<td>员工15</td>
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
			<td class="printHide"><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td class="printHide"><input type="checkbox" value="16"/></td>
			<td>员工16</td>
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
			<td class="printHide"><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td class="printHide"><input type="checkbox" value="17"/></td>
			<td>员工17</td>
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
			<td class="printHide"><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td class="printHide"><input type="checkbox" value="18"/></td>
			<td>员工18</td>
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
			<td class="printHide"><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
	</table>
<script>
function printHandler(){
	 var LODOP=getLodop(document.getElementById('LODOP_OB'),document.getElementById('LODOP_EM')); 
    var strBodyStyle="<style>"+document.getElementById("printStyle").innerHTML+"</style>";
    var tableHtml;
    var tableObj=$('<table class="tablePrint"></table>')
    var tableCon=$('<div></div>')
    tableCon.append(tableObj);
    tableObj.append($("#myTable").html());
    tableHtml=tableCon.html();
	var strBodyHtml=strBodyStyle+"<body>"+tableHtml+"</body>";
    LODOP.PRINT_INIT("打印本页数据");	
	LODOP.ADD_PRINT_TABLE(15,0,"99%","96%",strBodyHtml);
	LODOP.PREVIEW();
}
function printHandler2(){
	 var $checkboxRows=$("#myTable").find("input[type=checkbox]");
	var isChecked=false; 
    var tableObj=$('<table class="tablePrint"></table>')
    $checkboxRows.each(function(){
		if($(this).attr("checked")){
			tableObj.append($(this).parents("tr"));
			isChecked=true;
		}
	})
	if(!isChecked){
		top.Dialog.alert('请至少选择一行'); 
        return;
	}
	var th=$('<thead><th>姓名</th><th>性别</th><th>年龄</th><th>工作</th><th>联系方式</th><th>住址</th><th>婚姻状况</th><th>备注</th></thead>');
	tableObj.prepend(th)
	var tableCon=$('<div></div>')
    tableCon.append(tableObj);
	 var LODOP=getLodop(document.getElementById('LODOP_OB'),document.getElementById('LODOP_EM')); 
    var strBodyStyle="<style>"+document.getElementById("printStyle").innerHTML+"</style>";
    var tableHtml;
    tableHtml=tableCon.html();
	var strBodyHtml=strBodyStyle+"<body>"+tableHtml+"</body>";
    LODOP.PRINT_INIT("打印选中数据");	
	LODOP.ADD_PRINT_TABLE(15,0,"99%","96%",strBodyHtml);
	LODOP.PREVIEW();
}

function popWin(){
	top.Dialog.open({
      InnerHtml: $("#content").html(),
      Title:"效果预览",
      Width:820,
      Height:520
    });
}
</script>
</body>
</html>