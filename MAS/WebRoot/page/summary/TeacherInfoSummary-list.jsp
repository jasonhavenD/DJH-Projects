<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>专业教师情况统计</title>
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

		<script type="text/javascript">
//日历插件
$(function() {
	$(".datepicker").datepicker();
})

$(document).ready(function() {
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
	window.location.href = "summary_findSTeacherinfosummaryList.action?"
			+ "teacherinfosummaryModel.majorId="
			+ '${teacherinfosummaryModel.majorId}'
			+ "&teacherinfosummaryModel.departmentId="
			+ '${teacherinfosummaryModel.departmentId}'
			+ "&teacherinfosummaryModel.year="
			+ '${teacherinfosummaryModel.year}' + "&rows=" + rows + "&page="
			+ page;
}

function setRows(rows) {
	window.location.href = "summary_findSTeacherinfosummaryList.action?"
			+ "teacherinfosummaryModel.majorId="
			+ '${teacherinfosummaryModel.majorId}'
			+ "&teacherinfosummaryModel.departmentId="
			+ '${teacherinfosummaryModel.departmentId}'
			+ "&teacherinfosummaryModel.year="
			+ '${teacherinfosummaryModel.year}' + "&rows=" + rows.value;
}
//查询信息
function findContestApply() {
	document.getElementById("form1").submit();
}
//导出
function exportSubContestTExcel() {
	window.location.href = "exportSubContestTExcelTeacherinfo.action?exportName=teacherinfosummary"
	+ "&teacherinfosummaryModel.majorId="
	+ '${teacherinfosummaryModel.majorId}'
	+ "&teacherinfosummaryModel.departmentId="
	+ '${teacherinfosummaryModel.departmentId}'
	+ "&teacherinfosummaryModel.year="
	+ '${teacherinfosummaryModel.year}';
}
</script>
	</head>
	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>评估数据统计
			<b class="tip"></b>专业教师信息统计
		</div>
		<form
			action="summary_findSTeacherinfosummaryList.action?page=1&rows=10"
			id="form1" name="form1" method="post" enctype="multipart/form-data">
			<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />

			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							专业教师基本情况统计查询
						</td>
					</tr>

				</thead>
				<tbody id="mytable">
					<tr>
						<td>
							统计年份
						</td>
						<td>
							<select name="teacherinfosummaryModel.year" id="year">
								<option value="">
									全部年份
								</option>
								<s:iterator value="yearList" var="yearvar">
									<option value="<s:property/>"
										<s:if test="#yearvar == teacherinfosummaryModel.year">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							学院
						</td>
						<td>
							<select size="1" id="coll" name="teacherinfosummaryModel.departmentId"
								class="department" onchange="collchange();">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList" var="dvar">
									<option value="<s:property value='dno'/>" <s:if test="#dvar.dno == teacherinfosummaryModel.departmentId"></s:if>>
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							专业
						</td>
						<td>
							<select size="1" name="teacherinfosummaryModel.majorId" id="major">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList" var="mvar">
									<option value="<s:property value='mno'/>" <s:if test="#mvar.mno == teacherinfosummaryModel.majorId"></s:if>>
										<s:property value="mname" />
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="6">
							<a href="javascript:findContestApply();"
								class="btn btn-primary add">查询</a>&nbsp;&nbsp;
							<a href="#" onclick="exportSubContestTExcel()"
								class="btn btn-primary add">导出专业教师基本情况</a> &nbsp;&nbsp;
							<span style="color: red;">(先查询，再导出)</span>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
		<div class="table-div">
		<table class="table table-striped table-bordered table-condensed" style="overflow:hidden">
			<caption class="t_caption">
				专业教师信息统计列表
			</caption>
			<thead>
				<tr class="tr_title" style="height: 30px;">
					<td width="5%" style="text-align: center; vertical-align: middle;  font-size: 15px;">
						#
					</td>
					<td width="10%" style="text-align: center; vertical-align: middle;  font-size: 15px;">
						专业代码
					</td>
					<td width="10%" style="text-align: center; vertical-align: middle;  font-size: 15px;">
						专业名称
					</td>

					<td width="8%" style="text-align: center; vertical-align: middle;  font-size: 15px;">
						统计年份
					</td>
					<td width="8%" style="text-align: center; vertical-align: middle;  font-size: 15px;">
						职工数
					</td>
					<td width="8%" style="text-align: center; vertical-align: middle;  font-size: 15px;">
						学生数
					</td>
					<td width="8%" style="text-align: center; vertical-align: middle;  font-size: 15px;">
						专任教师数
					</td>
					<td width="8%" style="text-align: center; vertical-align: middle;  font-size: 15px;">
						师生比
					</td>
					<td width="10%" style="text-align: center; vertical-align: middle;  font-size: 15px;">
						<table width="100%">
							<tr>
								<caption>
									人数
								</caption>
								<td width="50px">
									博士
								</td>
								<td width="50px">
									教授
								</td>
								<td width="50px">
									副教授
								</td>
							</tr>
						</table>
					</td>
					<td width="10%">
						<table width="100%">
							<tr>
								<caption>
									人才数
								</caption>
								<td width="50px">
									国家级
								</td>
								<td width="50px">
									省级
								</td>
								<td width="50px">
									校级
								</td>
							</tr>
						</table>
					</td>
					<!-- <td width="8%">
						行业经历人数
					</td> -->
					<td width="8%" style="text-align: center; vertical-align: middle; font-size: 15px;">
						中青年专<br />业教师人数
					</td>
					<td width="8%" style="text-align: center; vertical-align: middle; font-size: 15px;">
						中青年专业教<br>师参加培训人数
					</td>
					<!-- <td width="8%">
						操作标识
					</td> -->
				</tr>
			</thead>
			<tbody>
				<s:if test="teacherinfosummaryList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有项目信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="teacherinfosummaryList" status="L">
					<tr>
						<td width="5%" style="text-align: center;">
							<s:property value="#L.index+1" />
						</td>
						<td width="5%" style="text-align: center;">
							<s:property value="major.mno" />
						</td>
						<td width="10%" style="text-align: center;">
							<s:property value="major.mname" />
						</td>
						<td width="8%" style="text-align: center;">
							<s:property value="year" />
						</td>
						<td width="8%" style="text-align: center;">
							<s:property value="facultyNumber" />
						</td>
							<td width="8%" style="text-align: center;">
							<s:property value="stuNumber" />
						</td>
						<td width="8%" style="text-align: center;">
							<s:property value="professionaTteacherNumbers" />
						</td>
						<td width="8%" style="text-align: center;">
							1：<s:property value="studentsTeachersRatio" />
						</td>
						<td width="10%">
							<table width="100%">
								<tr>
									<td width="20px;" style="text-align: center;">
										<s:property value="doctorNumber" />
									</td>
									<td width="20px;" style="text-align: center;">
										<s:property value="professorNuber" />
									</td>
									<td width="20px;" style="text-align: center;">
										<s:property value="associateProfessorNumber" />
									</td>
								</tr>
							</table>
						</td>
						<td width="10%">
							<table width="100%">
								<tr>
									<td width="20px;" style="text-align: center;">
										<s:property value="talentnuber1" />
									</td>
									<td width="20px;" style="text-align: center;">
										<s:property value="talentnuber2" />
									</td>
									<td width="20px;" style="text-align: center;">
										<s:property value="talentnuber3" />
									</td>
								</tr>
							</table>
						</td>
						<!--
						<td width="8%">
							<s:property value="industryExperienceNumber" />
						</td> -->
						<td width="9%" style="text-align: center;">
							<s:property value="youngTeacherNumber" />
						</td>
						<td width="10%" style="text-align: center;">
							<s:property value="trainTeacherNumber" />
						</td>
						<!-- <td width="10%">
							<s:property value="tag" />
						</td>-->
					</tr>
				</s:iterator>
			</tbody>

			<tfoot>
				<s:if test="teacherinfosummaryList.size() > 0">
					<tr>
						<td colspan="99">
							<s:include value="../common/paging.jsp"></s:include>
						</td>
					</tr>
				</s:if>
			</tfoot>
		</table>
		</div>
	</body>
</html>
