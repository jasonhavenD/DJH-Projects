<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>教学成果奖详细信息</title>

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
	window.location.href = "teachResultBase_see.action?rows=" + rows + "&page="
			+ page;
}

function setRows(rows) {
	window.location.href = "teachResultBase_see.action?rows=" + rows.value+"&page=1";
}
//导出列表
function exportSubContestTExcel(){
 	window.location.href = "exportSubContestTExcel1.action?exportName=teachresult"
			+ "&insNumber=" + document.getElementById("teachresultbaseinfo.tresultBaseNo").value;
}
//上传附件弹出框
function upFile(){
	document.getElementById("iframe").src="attachFileList.action?importName=teachresult";
             $('#alert-win').dialog({
                 width: 450,
                 height: 240,
                 buttons: { "关闭": function () {
          		findContestApply();
                 $(this).dialog("close");} }
             });
}
function findContestApply(){
	document.getElementById("refashChengyuan").submit();
}
</script>

	</head>

	<body style="background-color:#e4dfd9"  onload="init()">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业数据采集
			<b class="tip"></b>教学成果奖详细信息
		</div>
		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				教学成果奖信息
			</caption>
			<thead>
				<tr>
					<td colspan="99">
						教学成果奖信息
					</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="width: 60px;">
						奖励项目编号
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="teachresultbaseinfo.tresultBaseNo" id="teachresultbaseinfo.tresultBaseNo" disabled="true"
							value='<s:property value="teachresultbaseinfo.tresultBaseNo" />'
							type="text" />
					</td>
					<td style="width: 60px;">
						奖励项目名称
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="teachresultbaseinfo.tresultName" disabled="true"
							value='<s:property value="teachresultbaseinfo.tresultName" />'
							type="text" />
					</td>
					<td style="width: 60px;">
						获奖级别
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="teachresultbaseinfo.tresultJibie" disabled="true"
							value='<s:property value="teachresultbaseinfo.tresultJibie" />'
							type="text" />
					</td>
				</tr>
				<tr>
					<td style="width: 60px;">
						获奖等级
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="teachresultbaseinfo.tresultClass" disabled="true"
							value='<s:property value="teachresultbaseinfo.tresultClass" />'
							type="text" />
					</td>
					<td style="width: 60px;">
						获奖年份
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="teachresultbaseinfo.year" disabled="true"
							value='<s:property value="teachresultbaseinfo.year" />'
							type="text" />
					</td>
					<td>
						证书编号
						<font color="FF0000">*</font>
					</td>
					<td>
						<input type="text" name="teachresultbaseinfo.approvalNumber"
							disabled="true"
							value='<s:property value="teachresultbaseinfo.approvalNumber" />' />
					</td>
				</tr>
				<tr>
					<td>
						授予单位
						<font color="FF0000">*</font>
					</td>
					<td colspan="6">
						<textarea name="teachresultbaseinfo.rewardDepart" id="text"
							disabled="true"
							style="margin: 0; width: 99%; word-break: break-all; border-style: none; border: 0; overflow: hidden; resize: none;">
								<s:property value="teachresultbaseinfo.rewardDepart" />
							</textarea>
					</td>
				</tr>
				<tr>
					<td>
						备注
					</td>
					<td colspan="6">
						<textarea name="teachresultbaseinfo.beizhu" id="text"
							disabled="true"
							style="margin: 0; width: 99%; word-break: break-all; border-style: none; border: 0; overflow: hidden; resize: none;">
								<s:property value="teachresultbaseinfo.beizhu" />
							</textarea>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td>
						<a class="btn btn-primary add"
							href="teachResultBase_find.action?rows=<s:property value="trows" />&page=<s:property value="tpage" />">返回上一页</a>&nbsp;&nbsp;

					</td>
					<td colspan="3">
						<a href="#" onclick="exportSubContestTExcel();"
							class="btn btn-primary add">导出教学成果成员列表</a> &nbsp;&nbsp;
					</td>
					<input type="hidden" id="rol" value="<s:property value="rol"/>" />
					<td>
						<a id = "add" class="btn btn-primary add"
							href="teachResultBase_editB.action?tresultNo=0"> 添加 </a>
						<!--选择导入的文件 -->
						<a id="attach" href="javascript:void(0);"
							onclick="upFile();return false;" class="btn btn-primary add">导入当前教学成果奖成员</a>
					</td>
					<td>
						<!--清空所有教学成果奖成员信息 -->
						<a id="deleteAll"
							href="clearB.action?tresultBaseNo=<s:property value="tresultBaseNo"/>"
							onclick="return confirm('确认删除所有奖项成员信息吗？');"
							class="btn btn-primary add">清空所有奖项成员</a>
						<!--清空当前页教学成果奖成员信息 -->
						<a id="deleteThis" href="clearListB.action"
							onclick="return confirm('确认删除当前页奖项成员信息吗？');"
							class="btn btn-primary add">清空当前页奖项成员</a>
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
						教学成果奖名称
					</td>
					<td>
						获奖人排名
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
				<s:if test="teachresultList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有教学成果成员信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="teachresultList" status="L">
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
							<s:property value="teachresultbaseinfo.tresultName" />
						</td>
						<td>
							<s:property value="tresultRank" />
						</td>
						<td>
							<s:property value="beizhu" />
						</td>

						<td>
							<span class="edit"><a class="btn btn-mini btn-primary"
								href="teachResultBase_editB.action?tresultNo=<s:property value="tresultNo"/>">
								修改成员信息 </a></span>
							<span class="del"><a class="btn btn-mini btn-primary"
								onclick="return confirm('确认删除吗？');"
								href="teachResultBase_deleteB.action?tresultNo=<s:property value="tresultNo"/>">
								删除 </a></span>

						</td>
					</tr>
				</s:iterator>

			</tbody>
			<tfoot>
				<s:if test="teachresultList.size() > 0">
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
		<form
			action="teachResultBase_initSee.action?tresultBaseNo=<s:property value="tresultBaseNo"/>"
			id="refashChengyuan">
	</body>
</html>
