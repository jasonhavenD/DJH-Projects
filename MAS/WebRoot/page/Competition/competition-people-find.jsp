<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>竞赛获奖详细信息</title>

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
	//导出我的赛项列表
			function exportSubContestTExcel1(){
			var a=document.getElementById("competition.comNumber").value;
			
		    window.location.href = "exportSubContestTExcel1.action?exportName=stucption"+"&stuComNumber="+document.getElementById("competition.comNumber").value;
			alert(comNumber);
			}
			
//上传附件弹出框
			function upFile(){
				document.getElementById("iframe").src="attachFileList.action?importName=stucption";
                $('#alert-win').dialog({
                    width: 450,
                    height: 240,
                    buttons: { "关闭": function () { 
             		refashChengyuan();
                    $(this).dialog("close");} }
                });	
			}
			



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
	window.location.href = "findStuCption.action?rows=" + rows + "&page="
			+ page;
}
function refashChengyuan(){
	document.getElementById("refashChengyuan").submit();
}
function setRows(rows) {
	window.location.href = "findStuCption.action?rows=" + rows.value+"&page=1";
}
</script>

	</head>

	<body onload="init()"style="background-color:#e4dfd9">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业数据采集
			<b class="tip"></b>查询竞赛获奖情况
			<b class="tip"></b>竞赛获奖详细信息
		</div>

		<table class="table table-striped table-bordered table-condensed">
			<thead>
				<tr>
					<td colspan="99">
						编辑竞赛获奖信息
					</td>
				</tr>
			</thead>
			<tbody id="mytable">
				<tr>
					<td style="width: 60px;">
						竞赛编号:
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="competition.comNumber" id="competition.comNumber"
							value='<s:property value="competition.comNumber"/>'
							readonly="readonly" type="text" />
					</td>
					<td style="width: 60px;">
						竞赛名称:
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="competition.comName" id="competition.comName"
							value='<s:property value="competition.comName"/>'
							readonly="readonly" type="text" />
					</td>
					<td>
						获奖类别:
						<font color="FF0000">*</font>
					</td>
					<td colspan="3">
						<input name="competition.comType" id="competition.comType"
							value='<s:property value="competition.comType"/>'
							readonly="readonly" type="text" />
					</td>

				</tr>
				<tr>
					<td style="width: 60px;">
						获奖等级:
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="competition.comRank" id="competition.comRank"
							value='<s:property value="competition.comRank"/>'
							readonly="readonly" type="text" />
					</td>
					<td style="width: 60px;">
						年份:
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="competition.year" id="competition.year"
							value='<s:property value="competition.year"/>'
							readonly="readonly" type="text" />
					</td>
					<td style="width: 60px;">
						备注
					</td>
					<td  colspan="3">
						<input name="competition.note" id="competition.note"
							value='<s:property value="competition.note"/>'
							readonly="readonly" type="text" />
					</td>
				</tr>
				<tfoot>
					<tr>
						<td>
							<a class="btn btn-primary add"
								href="findCompetition.action?rows=<s:property value="trows" />&page=<s:property value="tpage" />">返回上一页</a>&nbsp;&nbsp;

						</td>
						<td colspan="3">
							<a href="#" onclick="exportSubContestTExcel1()"
								class="btn btn-primary add">导出竞赛获奖成员列表</a> &nbsp;&nbsp;
							<span style="color: red;">(先查询，再导出)</span>
						</td>
						<td>
							<a id="add" class="btn btn-primary add"
								href="modifitoStuCption.action?innoMemNumber=0"> 添加</a>
						</td>
						<td>
							<!--选择导入的文件 -->
							<a id="attach" href="javascript:void(0);"
								onclick="upFile();return false;" class="btn btn-primary add">导入当前竞赛项目成员</a>
						</td>
						<td>
							<!--清空所有竞赛成员信息 -->
							<a id="deleteAll" href="clearStuCption.action?comNumber=<s:property value="comNumber"/>"
								onclick="return confirm('确认删除所有竞赛成员信息吗？');" class="btn btn-primary add">清空所有成员</a>			
							<!--清空当前页竞赛成员信息 -->
							<a id="deleteThis" href="clearListStuCption.action"
								onclick="return confirm('确认删除当前页竞赛成员信息吗？');" class="btn btn-primary add">清空当前页成员</a>			
						</td>
					</tr>
				</tfoot>
			</tbody>
		</table>

		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				竞赛成员列表
			</caption>
			<thead>
				<tr class="tr_title" style="height: 30px;">
					<td>
						#
					</td>
					<td>
						学号
					</td>
					<td>
						学生姓名
					</td>
					<td>
						竞赛名称
					</td>
					<td>
						成员排名
					</td>
					<td>
						操作
					</td>

				</tr>
			</thead>
			<tbody>
				<s:if test="studentcoepetitionlist.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有成员信息！
						</td>

					</tr>
				</s:if>
				<s:iterator value="studentcoepetitionlist" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td>
							<s:property value="student.stuNumber" />
						</td>
						<td>
							<s:property value="student.stuName" />
						</td>
						<td>
							<s:property value="competition.comName" />
						</td>
						<td>
							<s:property value="rank" />
						</td>

						<td>
							<span class="edit"><a class="btn btn-mini btn-primary"
								href="modifitoStuCption.action?innoMemNumber=<s:property value="innoMemNumber"/>">
								修改成员信息 </a></span>
							<span class="del"><a class="btn btn-mini btn-primary"
								onclick="return confirm('确认删除   <s:property value="innoMemNumber"/> 吗？');"
								href="deleteStuCption.action?innoMemNumber=<s:property value="innoMemNumber"/>">
								删除 </a></span>

						</td>
					</tr>
				</s:iterator>

			</tbody>
			<tfoot>
				<s:if test="studentcoepetitionlist.size() > 0">
					<tr>
						<td colspan="99">
							<s:include value="../common/paging.jsp"></s:include>
						</td>
					</tr>
				</s:if>
			</tfoot>

		</table>
		<input type="hidden" id="rol" value="<s:property value="rol"/>" />
		<div id="alert-win" title="附件" style="display: none;">
			<iframe style="border: 0; width: 100%; height: 100%;" id="iframe"
				src="">
			</iframe>
		</div>
		<form
			action="findStuCption.action?comNumber=<s:property value="comNumber"/> "
			id="refashChengyuan" />
	</body>
</html>
