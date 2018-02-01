<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>实验实训场地使用情况</title>

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
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/MajorByDno.js">
</script>
<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/timeManage.js">
</script>
		<script type="text/javascript">
//日历插件
$(function() {
	$(".datepicker").datepicker();
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
$(document).ready(function() {
	// ------------------------------
		//角色判断
		var rol = $("#rol").val();
		var totalRows = $("#totalRows").val();
		if (rol == 4) {
			$("#attach").hide();//隐藏导入
			$("#add").hide();//隐藏导入
			for ( var i = 0; i < totalRows; i++) {
				$(".edit").hide();
				$(".del").hide();

			}
		}
	});

//导入弹出框
function upFile() {
	document.getElementById("iframe").src = "attachFileList.action?importName=traingvenueUse";
	$('#alert-win').dialog( {
		width : 450,
		height : 240,
		buttons : {
			"关闭" : function() {
				findContestApply();
				$(this).dialog("close");
			}
		}
	});
}

//查询赛项
function findContestApply() {
	document.getElementById("form1").submit();
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
var name = "" + '${tramodel.name}';
	name = encodeURI(name);
	name = encodeURI(name);
	window.location.href = "findTrainingvenueuse.action?tramodel.id=" + '${tramodel.id}'
			+ "&tramodel.name=" + name
			+ "&tramodel.departmentId=" + '${tramodel.departmentId}'
			+ "&tramodel.year=" + '${tramodel.year}' + "&tramodel.majorId="
			+ '${tramodel.majorId}'+ "&rows=" + rows
			+ "&page=" + page;
}

function setRows(rows) {
	var name = "" + '${tramodel.name}';
	name = encodeURI(name);
	name = encodeURI(name);

	window.location.href = "findTrainingvenueuse.action?tramodel.id=" + '${tramodel.id}'
			+ "&trausemodel.name=" + name
			+ "&trausemodel.departmentId=" + '${trausemodel.departmentId}'
			+ "&trausemodel.year=" + '${trausemodel.year}' + "&trausemodel.majorId="
			+ '${trausemodel.majorId}' + "&rows=" + rows.value+"&page=1";
}

//导出
function exportSubContestTExcel() {

	var pname = ""+'${trausemodel.name}';
 	name = encodeURI(pname);
 	name = encodeURI(pname);
	window.location.href = "exportSubContestTExcel.action?exportName=traingvenueUse"
			+"&trausemodel.id=" + '${trausemodel.id}'
			+ "&trausemodel.name=" + name
			+ "&trausemodel.departmentId=" + '${trausemodel.departmentId}'
			+ "&trausemodel.year=" + '${trausemodel.year}' + "&trausemodel.majorId="
			+ '${trausemodel.majorId}'
}
</script>

	</head>

	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>实验实训场地使用情况
			<b class="tip"></b>查询实验实训场地使用情况
		</div>

		<form action="findTrainingvenueuse.action?page=1&rows=10" id="form1" name="form1"
			method="post" enctype="multipart/form-data">

			<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							实验实训场地使用情况查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td style="width: 60px;">
							实验室编号
						</td>
						<td>
							<input name="trausemodel.id"
								value='<s:property value="trausemodel.id"/>' type="text" />
						</td>
						<td style="width: 60px;">
							实验室名称
						</td>
						<td>
							<input name="trausemodel.name"
								value='<s:property value="trausemodel.name"/>' type="text" />
						</td>
						<td>
						年份
						</td>
						<td>
							<select name="trausemodel.year" id="year">
								<option value="">
									全部年份
								</option>
								<s:iterator value="yearList" var="yearvar">
									<option value="<s:property/>"
										<s:if test="#yearvar == trausemodel.year">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>
						</tr>
						<tr>
						<td>
							所在学院
						</td>
						<td>
							<select size="1" id="coll" name="trausemodel.departmentId"
								class="department" onchange="collchange();">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList" var="dvar">
									<option value="<s:property value='dno'/>" <s:if test="#dvar.dno==trausemodel.departmentId"></s:if>>
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							所在专业
						</td>
						<td colspan="3">
							<select size="1" name="trausemodel.majorId" id="major">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList" var="mvar">
									<option value="<s:property value='mno'/>" <s:if test="#mvar.mno==trausemodel.majorId"></s:if>>
										<s:property value="mname" />
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>
					</tbody>

				<tfoot>
					<tr>
						<td colspan="5">
							<a href="javascript:findContestApply();"
								class="btn btn-primary add">查询</a>&nbsp;&nbsp;
							<a href="#" onclick="exportSubContestTExcel()"
								class="btn btn-primary add">导出实验实训场地使用信息列表</a> &nbsp;&nbsp;
							<span style="color: red;">(先查询，再导出)</span>

						</td>
						<td align="right" colspan="2">
							<span id="add"> <a id="add"
								href="editToTrainingvenueuse.action?useNumber=0" style=""
								class="btn btn-primary add">添加</a>
							</span>
							<!--选择导入的文件 --> <a
								id="attach" href="javascript:void(0);"
								onclick="upFile();return false;" class="btn btn-primary add">导入</a>
								<!--清空所有信息 -->
							<span class="del"><a id="clear" href="clearTrainingvenueuse.action"
								onclick="return confirm('确认删除所有实验实训场地信息吗？');"
								class="btn btn-primary add">清空所有数据</a></span>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>

		<table style="white-space: normal;" class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				实验实训场地使用场地使用情况查询结果
			</caption>
			<thead>
				<tr>
					<td width="3%">
						#
					</td>
					<td width="10%">
						所在学院
					</td>
					<td width="6%">
						所在专业
					</td>
					<td width="8%">
						实验室编号
					</td>
					<td width="8%">
						实验室名称
					</td>
					<td width="4%">
						课程数
					</td>
					<td>
						专业实验教学人时数
					</td>
					<td>
						专业实验教学人次数
					</td>
					<td>
						使用年份
					</td>
					<td>
						操作
					</td>
				</tr>
			</thead>
			<tbody>
				<s:if test="trainingvenueuseList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有查询到信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="trainingvenueuseList" id="traininguse" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>

						<td>
							<s:property value="major.department.dname" />
						</td>
						<td>
							<s:property value="major.mname" />
						</td>
						<td>
							<s:property value="trainingvenue.traNumer" />
						</td>
						<td>
							<s:property value="trainingvenue.traName" />
						</td>
						<td>
							<s:property value="courseCount" />
						</td>
						<td>
							<s:property value="thHcount" />
						</td>
						<td>
							<s:property value="thPcount" />
						</td>
						<td>
							<s:property value="year" />
						</td>
						<td>

							<span class="edit"><a class="btn btn-mini btn-primary"
								href="editToTrainingvenueuse.action?useNumber=<s:property value="useNumber"/>">
								修改 </a></span>
							<span class="del"><a class="btn btn-mini btn-primary" onclick="return confirm('是否删除')"
								href="deleteTrainingvenueuse.action?useNumber=<s:property value="useNumber"/>">
								删除 </a></span>
						</td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="trainingvenueuseList.size() > 0">
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
	</body>
</html>
