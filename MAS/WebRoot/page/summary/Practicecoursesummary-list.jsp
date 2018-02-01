<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>课程与实践情况统计</title>

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
	window.location.href = "summary_findSPracticecoursesummaryList.action?"
			+ "practicecoursesummaryModel.majorId=" + '${practicecoursesummaryModel.majorId}'
			+ "&practicecoursesummaryModel.departmentId=" + '${practicecoursesummaryModel.departmentId}'
			+ "&practicecoursesummaryModel.year=" + '${practicecoursesummaryModel.year}'
			+ "&rows=" + rows + "&page=" + page;
}

function setRows(rows) {
	window.location.href = "summary_findSPracticecoursesummaryList.action?"
			+ "practicecoursesummaryModel.majorId=" + '${practicecoursesummaryModel.majorId}'
			+ "&practicecoursesummaryModel.departmentId=" + '${practicecoursesummaryModel.departmentId}'
			+ "&practicecoursesummaryModel.year=" + '${practicecoursesummaryModel.year}'
			+ "&rows=" + rows.value;
}
//查询信息
function findContestApply() {
	document.getElementById("form1").submit();
}
//导出
function exportSubContestTExcel() {
	window.location.href = "exportSubContestTExcelpracticecourse.action?exportName=practicecoursesummary"
	+ "&practicecoursesummaryModel.majorId=" + '${practicecoursesummaryModel.majorId}'
	+ "&practicecoursesummaryModel.departmentId=" + '${practicecoursesummaryModel.departmentId}'
	+ "&practicecoursesummaryModel.year=" + '${practicecoursesummaryModel.year}' ;
}
</script>
	</head>
	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>评估数据统计
			<b class="tip"></b>课程与实践情况统计
		</div>
		<form
			action="summary_findSPracticecoursesummaryList.action?page=1&rows=10"
			id="form1" name="form1" method="post" enctype="multipart/form-data">
			<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />

			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							课程与实践统计查询
						</td>
					</tr>

				</thead>
				<tbody id="mytable">
					<tr>
						<td>
							统计年份
						</td>
						<td>
							<select name="practicecoursesummaryModel.year" id="year">
								<option value="">
									全部年份
								</option>
								<s:iterator value="yearList" var="yearvar">
									<option value="<s:property/>"
										<s:if test="#yearvar == practicecoursesummaryModel.year">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							学院
						</td>
						<td>
							<select size="1" id="coll" name="practicecoursesummaryModel.departmentId"
								class="department" onchange="collchange();">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList" var="dvar">
									<option value="<s:property value='dno'/>" <s:if test="#dvar.dno == practicecoursesummaryModel.departmentId"></s:if>>
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							专业
						</td>
						<td>
							<select size="1" name="practicecoursesummaryModel.majorId" id="major">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList" var="mvar">
									<option value="<s:property value='mno'/>" <s:if test="#mvar.mno == practicecoursesummaryModel.majorId"></s:if>>
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
								class="btn btn-primary add">导出实践教学情况</a> &nbsp;&nbsp;
							<span style="color: red;">(先查询，再导出)</span>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
		<div class="table-div">
		<table class="table table-striped table-bordered table-condensed" style="overflow:hidden">
			<caption class="t_caption">
				课程与实践情况统计列表
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
					<td width="10%" style="text-align: center; vertical-align: middle;  font-size: 15px;">
						统计年份
					</td>
					<td width="10%" style="text-align: center; vertical-align: middle;  font-size: 15px;">
						年度计划调整次数
					</td>
					<td width="15%" style="text-align: center; vertical-align: middle;  font-size: 15px;">
						<table width="100%">
							<tr>
								<caption style="text-align: center; vertical-align: middle;  font-size: 15px;">
									课程总学时
								</caption>
								<td  style="text-align: center; vertical-align: middle;  font-size: 13px;">
									教授授课
								</td>
								<td  style="text-align: center; vertical-align: middle;  font-size: 13px;">
									高职授课
								</td>
								<td  style="text-align: center; vertical-align: middle;  font-size: 13px;">
									课程总学时
								</td>
							</tr>
						</table>
					</td>
					<td width="10%" style="text-align: center; vertical-align: middle;  font-size: 15px;">
						总教学经费
					</td>
					<td width="15%"  style="text-align: center; vertical-align: middle;  font-size: 15px;">
						<table width="100%">
							<tr>
								<caption style="text-align: center; vertical-align: middle;  font-size: 15px;">
									课程总数
								</caption>
								<td style="text-align: center; vertical-align: middle;  font-size: 13px;">
									课程总数
								</td>
								<td width="33%" style="text-align: center; vertical-align: middle;  font-size: 13px;">
									开出
								</td>
								<td  width="34%" style="text-align: center; vertical-align: middle;  font-size: 13px;">
									优质
								</td>
							</tr>
						</table>
					</td>
					<td width="10%" style="text-align: center; vertical-align: middle;  font-size: 15px;">
						实习基地总数
					</td>
					<td width="10%" style="text-align: center; vertical-align: middle;  font-size: 15px;">
						学生科创<br/>主持项目数
					</td>
					<!-- <td width="5%">
						操作标识
					</td> -->
				</tr>
			</thead>
			<tbody>
				<s:if test="practicecoursesummaryList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有项目信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="practicecoursesummaryList" status="L">
					<tr align="center">
						<td width="5%" style="text-align: center;">
							<s:property value="#L.index+1" />
						</td>
						<td width="10%" style="text-align: center;">
							<s:property value="major.mno" />
						</td>
						<td width="10%" style="text-align: center;">
							<s:property value="major.mname" />
						</td>
						<td width="10%" style="text-align: center;">
							<s:property value="year" />
						</td>
						<td width="10%" style="text-align: center;">
							<s:property value="planChangeNumber" />
						</td>
						<td width="15%">
							<table width="100%">
								<tr>
									<td width="14px;" style="text-align: center;">
										<s:property value="professorTeachTime" />
									</td>
									<td width="15px;" style="text-align: center;">
										<s:property value="inprofessorTteachTime" />
									</td>
									<td width="20px;" style="text-align: center;">
										<s:property value="TeachTotalTime" />
									</td>
								</tr>
							</table>
						</td>

						<td width="10%"  style="text-align: center;">
							<s:property value="TotalTeachCost" />
						</td>
						<td width="15%">
							<table width="100%">
								<tr>
									<td width="18px;" style="text-align: center;">
										<s:property value="CourseTotaoNum" />
									</td>
									<td width="18px;" style="text-align: center;">
										<s:property value="OpenCourseTotaoNum" />
									</td>
									<td width="20px;" style="text-align: center;">
										<s:property value="GoodCourseTotaoNum" />
									</td>
								</tr>
							</table>
						</td>
						<td width="10%" style="text-align: center;">
							<s:property value="PracticeBaseTotalNum" />
						</td>
						<td width="10%" style="text-align: center;">
							<s:property value="StudentPersistProjectNum" />
						</td>
						<!-- <td width="5%">
							<s:property value="tag" />
						</td> -->
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="practicecoursesummaryList.size() > 0">
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
