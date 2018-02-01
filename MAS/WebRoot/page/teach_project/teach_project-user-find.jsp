<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>教学质量工程信息详细信息</title>

		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/admin-all.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/other.css" />
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/jquery-1.7.2.js">
</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/jquery-ui-1.8.22.custom.min.js">
</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/textarea.js">
</script>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />

<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/timeManage.js">
</script>
		<script type="text/javascript">
//日历插件
$(function() {
	$(".datepicker").datepicker();

	var _this = $('.list').find('thead');
	$('.tby').hide();
	//折叠
	_this.click(function() {
		var i = $(this).find('i');
		if (i.attr('class') == 'tip-down') {
			i.attr('class', 'tip-up')
		} else {
			i.attr('class', 'tip-down')
		}
		$(this).parent().find('tbody').toggle();
	})

})
$(document).ready(function() {
	// ------------------------------
		//角色判断
		var rol = $("#rol").val();
		var totalRows = $("#totalRows").val();
		if (rol == 2) {
			$("#attach").hide();//隐藏导入
			for ( var i = 0; i < totalRows; i++) {
				$("#edit").hide();
				$("#del").hide();

			}
		}
	});
$(document).ready(function() {
timeManage();
	$("#mytable tr:even td").css("background", "#fff");
	$("#mytable tr:even td").attr("bg", "#fff");
	$("#mytable tr:odd td").attr("bg", "#fff");
	$("#mytable tr td").hover(function() {
		$(this).parent().find("td").css("background", "#fff")
	}, function() {
		var bgc = $(this).attr("bg");
		$(this).parent().find("td").css("background", bgc)
	});

})

function jump(op) {
	if ("first" == op) {
		page = 1;
	} else if ("up" == op) {
		page = parseInt(page) - 1;
	} else if ("down" == op) {
		page = parseInt(page) + 1;
	} else if ("last" == op) {
		page = totalPage;
	} else {
		var jumpPage = parseInt(document.getElementById("jumpPage").value);
		if (jumpPage <= totalPage && jumpPage > 0)
			page = jumpPage;
		else
			alert("超出页码范围");
	}
	window.location.href = "teachproject_see.action?rows=" + rows + "&page="
			+ page;
}

function setRows(rows) {
	window.location.href = "teachproject_see.action?rows=" + rows.value+"&page=1";
}
//导出我的赛项列表
function exportSubContestTExcel1() {
	var a = document.getElementById("teachproject.tprojectNo").value;

	window.location.href = "exportSubContestTExcel1.action?exportName=teachprojectuser"
			+ "&comNumber="+ document.getElementById("teachproject.tprojectNo").value;;

}
//上传附件弹出框
function upFile() {
	document.getElementById("iframe").src = "attachFileList.action?importName=teachprojectuser";
	$('#alert-win').dialog( {
		width : 450,
		height : 240,
		buttons : {
			"关闭" : function() {
				refashChengyuan();
				$(this).dialog("close");
			}
		}
	});
}
function refashChengyuan(){
	document.getElementById("refashChengyuan").submit();
}
</script>

	</head>

	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业数据采集
			<b class="tip"></b>教学质量工程信息
		</div>
		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				教学质量工程信息
			</caption>
			<thead>
				<tr>
					<td colspan="99">
						教学质量工程信息
					</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="width: 60px;">
						质量工程编号
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="teachproject.tprojectNo" id="teachproject.tprojectNo"
							disabled="true"
							value='<s:property value="teachproject.tprojectNo" />'
							type="text" />
					</td>
					<td style="width: 60px;">
						质量工程名称
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="teachproject.tprojectName" disabled="true"
							value='<s:property value="teachproject.tprojectName" />'
							type="text" />
					</td>
					<td style="width: 60px;">
						质量工程级别
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="teachproject.tprojecJibie" disabled="true"
							value='<s:property value="teachproject.tprojecJibie" />'
							type="text" />
					</td>
				</tr>
				<tr>
					<td style="width: 60px;">
						质量工程类型
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="teachproject.tprojecType" disabled="true"
							value='<s:property value="teachproject.tprojecType" />'
							type="text" />
					</td>
					<td style="width: 60px;">
						获批年份
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="teachproject.year" disabled="true"
							value='<s:property value="teachproject.year" />' type="text" />
					</td>
					<td>
						批准文号
						<font color="FF0000">*</font>
					</td>
					<td>
						<input type="text" name="teachproject.approvalNumber"
							disabled="true"
							value='<s:property value="teachproject.approvalNumber" />' />
					</td>
				</tr>
				<tr>
				</tr>
				<tr>
					<td>
						备注
					</td>
					<td colspan="6">
						<input type="text" name="teachproject.beizhu"
							disabled="true"
							value='<s:property value="teachproject.beizhu" />' />
					</td>
				</tr>
			</tbody>
			<tfoot>
			<tr>
				<td>
					<a class="btn btn-primary add" href="teachproject_find.action?rows=<s:property value="trows" />&page=<s:property value="tpage" />">返回上一页</a>&nbsp;&nbsp;
				</td>
				<td colspan="3">
					<a href="#" onclick="exportSubContestTExcel1()"
						class="btn btn-primary add">导出质量工程成员列表</a> &nbsp;&nbsp;
				</td>
				<td>
					<a id = "add" class="btn btn-primary add"
								href="teachproject_editU.action?tpUno=0">
								添加 </a>
					<!--选择导入的文件 -->
					<a id="attach" href="javascript:void(0);"
						onclick="upFile();return false;" class="btn btn-primary add">导入当前工程成员信息</a>
				</td>
				<td>
					<!--清空所有成员信息 -->
					<a id="deleteAll" href="clearU.action?tprojectNo=<s:property value="tprojectNo"/>"
						onclick="return confirm('确认删除所有成员信息吗？');" class="btn btn-primary add">清空所有成员</a>
					<!--清空当前页成员信息 -->
					<a id="deleteThis" href="clearListU.action"
						onclick="return confirm('确认删除当前页成员信息吗？');" class="btn btn-primary add">清空当前页成员</a>
				</td>
			</tr>
		</tfoot>
		</table>

		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				成员列表
			</caption>
			<thead>
				<tr class="tr_title" style="height: 30px;">
					<td>
						#
					</td>
					<td>
						教师工号
					</td>
					<td>
						教师姓名
					</td>
					<td>
						教学质量工程名称
					</td>
					<td>
						成员排名
					</td>
					<td>
						备注
					</td>
					<td>
						操作
					</td>

				</tr>
			</thead>
			<tbody>
				<s:if test="teachprojectuserList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有教学质量工程信息！

						</td>
					</tr>
				</s:if>
				<s:iterator value="teachprojectuserList" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td>
							<s:property value="teacher.tno" />
						</td>
						<td>
							<s:property value="teacher.tname" />
						</td>
						<td>
							<s:property value="teachproject.tprojectName" />
						</td>
						<td>
							<s:property value="rank" />
						</td>
						<td>
							<s:property value="beizhu" />
						</td>

						<td>
							<span class="edit"> <a class="btn btn-mini btn-primary"
								href="teachproject_editU.action?tpUno=<s:property value="tpUno"/>">
									修改成员信息 </a> </span>
							<span class="del"> <a class="btn btn-mini btn-primary"
								onclick="return confirm('确认删除吗？');"
								href="teachproject_deleteU.action?tpUno=<s:property value="tpUno"/>">
									删除 </a> </span>
						</td>
						<input type="hidden" id="rol" value="<s:property value="rol"/>" />
					</tr>
				</s:iterator>

			</tbody>
			<tfoot>
				<s:if test="teachprojectuserList.size() > 0">
					<tr>
						<td colspan="99">
							<s:include value="../common/paging.jsp"></s:include>
						</td>
					</tr>
				</s:if>
			</tfoot>

		</table>
		<div id="alert-win" title="附件" style="display: none;">
			<iframe style="border: 0; width: 100%; height: 100%;" id="iframe"
				src="">
			</iframe>
		</div>
		<form action="teachproject_initSee.action?tprojectNo=<s:property value="tprojectNo"/>" id="refashChengyuan">
	</body>
</html>
