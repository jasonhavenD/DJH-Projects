<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>学生培养情况统计</title>

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
	window.location.href = "summary_findSStudentculturesummaryList.action?"
			+ "studentculturesummaryModel.majorId="
			+ '${studentculturesummaryModel.majorId}'
			+ "&studentculturesummaryModel.departmentId="
			+ '${studentculturesummaryModel.departmentId}'
			+ "&studentculturesummaryModel.year="
			+ '${studentculturesummaryModel.year}' + "&rows=" + rows + "&page="
			+ page;
}

function setRows(rows) {
	window.location.href = "summary_findSStudentculturesummaryList.action?"
			+ "studentculturesummaryModel.majorId="
			+ '${studentculturesummaryModel.majorId}'
			+ "&studentculturesummaryModel.departmentId="
			+ '${studentculturesummaryModel.departmentId}'
			+ "&studentculturesummaryModel.year="
			+ '${studentculturesummaryModel.year}' + "&rows=" + rows.value;
}
//查询信息
function findContestApply() {
	document.getElementById("form1").submit();
}
//导出
function exportSubContestTExcel() {
	window.location.href = "exportSubContestTExcelStudentculture.action?exportName=studentculturesummary"
	+ "&studentculturesummaryModel.majorId="+ '${studentculturesummaryModel.majorId}'
	+ "&studentculturesummaryModel.departmentId="+ '${studentculturesummaryModel.departmentId}'
	+ "&studentculturesummaryModel.year="+ '${studentculturesummaryModel.year}';
}
</script>
	</head>
	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>评估数据统计
			<b class="tip"></b>学生培养情况信息统计
		</div>
		<form
			action="summary_findSStudentculturesummaryList.action?page=1&rows=10"
			id="form1" name="form1" method="post" enctype="multipart/form-data">
			<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />

			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							学生培养统计查询
						</td>
					</tr>

				</thead>
				<tbody id="mytable">
					<tr>
						<td>
							统计年份
						</td>
						<td>
							<select name="studentculturesummaryModel.year" id="year">
								<option value="">
									全部年份
								</option>
								<s:iterator value="yearList" var="yearvar">
									<option value="<s:property/>"
										<s:if test="#yearvar == studentculturesummaryModel.year">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							学院
						</td>
						<td>
							<select size="1" id="coll"
								name="studentculturesummaryModel.departmentId"
								class="department" onchange="collchange();">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList" var="dvar">
									<option value="<s:property value='dno'/>" <s:if test="#dvar.dno == studentculturesummaryModel.departmentId"></s:if>>
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							专业
						</td>
						<td>
							<select size="1" name="studentculturesummaryModel.majorId"
								id="major">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList" var="mvar">
									<option value="<s:property value='mno'/>" <s:if test="#mvar.mno == studentculturesummaryModel.majorId"></s:if>>
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
								class="btn btn-primary add">导出学生培养情况</a> &nbsp;&nbsp;
							<span style="color: red;">(先查询，再导出)</span>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
		<div class="table-div">
		<table class="table table-striped table-bordered table-condensed" style="overflow:hidden">
			<caption class="t_caption">
				学生培养情况信息统计列表
			</caption>
			<thead>
				<tr class="tr_title" style="height: 30px;">
					<td width="5%"  style="text-align: center; vertical-align: middle;  font-size: 15px;">
						#
					</td>
					<td width="10%"  style="text-align: center; vertical-align: middle;  font-size: 15px;">
						专业代码
					</td>
					<td width="10%"  style="text-align: center; vertical-align: middle;  font-size: 15px;">
						专业名称
					</td>

					<td width="5%"  style="text-align: center; vertical-align: middle;  font-size: 15px;">
						统计年份
					</td>
					<td width="5%"  style="text-align: center; vertical-align: middle;  font-size: 15px;">
						在籍学生数
					</td>
					<td width="5%"  style="text-align: center; vertical-align: middle;  font-size: 15px;">
						学术论文数
					</td>
					<td width="5%"  style="text-align: center; vertical-align: middle;  font-size: 15px;">
						专利数
					</td>
					<td width="15%">
						<table width="100%">
							<tr>
								<caption  style="text-align: center; vertical-align: middle;  font-size: 15px;">
									竞赛人数
								</caption>
								<td  style="text-align: center; vertical-align: middle;  font-size: 15px;">
									国家级
								</td>
								<td  style="text-align: center; vertical-align: middle;  font-size: 15px;">
									省级
								</td>
								<td  style="text-align: center; vertical-align: middle;  font-size: 15px;">
									校级
								</td>
							</tr>
						</table>
					</td>
					<td width="15%">
						<table width="100%">
							<tr>
								<caption  style="text-align: center; vertical-align: middle;  font-size: 15px;">
									科创人数
								</caption>
								<td  style="text-align: center; vertical-align: middle;  font-size: 15px;">
									国家级
								</td>
								<td  style="text-align: center; vertical-align: middle;  font-size: 15px;">
									省级
								</td  style="text-align: center; vertical-align: middle;  font-size: 15px;">
								<td>
									校级
								</td  style="text-align: center; vertical-align: middle;  font-size: 15px;">
							</tr>
						</table>
					</td>
					<td width="5%"  style="text-align: center; vertical-align: middle;  font-size: 15px;">
						专业第一志愿率
					</td>
					<td width="5%"  style="text-align: center; vertical-align: middle;  font-size: 15px;">
						专业热门度
					</td>
					<td style="text-align: center; vertical-align: middle;  font-size: 15px;">
						<!--<table width="100%">
							<tr>
								 <caption>
									就业率
								</caption>
								<td>-->
									初次就业率
								<!--</td>
								<td>
									就业率
								</td>
							</tr>
						</table>-->
					</td>
					<td width="10%">
						<table width="100%">
							<tr>
								<caption  style="text-align: center; vertical-align: middle;  font-size: 15px;">
									国内外交流项目
								</caption>
								<td  style="text-align: center; vertical-align: middle;">
									项目数
								</td>
								<td  style="text-align: center; vertical-align: middle;">
									人数
								</td>
							</tr>
						</table>
					</td>
					<!--  <td width="5%">
						备注
					</td>-->
				</tr>
			</thead>
			<tbody>
				<s:if test="studentculturesummaryList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有项目信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="studentculturesummaryList" status="L">
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
						<td width="5%" style="text-align: center;">
							<s:property value="year" />
						</td>
						<td width="5%" style="text-align: center;">
							<s:property value="studentNumber" />
						</td>
						<td width="5%" style="text-align: center;">
							<s:property value="researchPaperNumber" />
						</td>
						<td width="5%" style="text-align: center;">
							<s:property value="patentNumber" />
						</td>
						<td width="15%" style="text-align: center;">
							<table width="100%">
								<tr>
									<td width="20px;" style="text-align: center;">
										<s:property value="raceNumber1" />
									</td>
									<td width="20px;" style="text-align: center;">
										<s:property value="raceNumber2" />
									</td>
									<td width="20px;" style="text-align: center;">
										<s:property value="raceNumber3" />
									</td>
								</tr>
							</table>
						</td>
						<td width="15%">
							<table width="100%">
								<tr>
									<td width="35px;" style="text-align: center;">
										<s:property value="studentInnovationNumber11" />
									</td>
									<td width="23px;" style="text-align: center;">
										<s:property value="studentInnovationNumber12" />
									</td>
									<td width="20px;" style="text-align: center;">
										<s:property value="studentInnovationNumber13" />
									</td>
								</tr>
							</table>
						</td>
						<td width="5%" style="text-align: center;">
							<s:property value="firstVolunteerRate" />
						</td>
						<td width="5%" style="text-align: center;">
							<s:property value="popularityRate" />
						</td>
						<td width="10%" style="text-align: center;">
							<table width="100%">
								<tr>
									<td style="text-align: center;">
										<s:property value="initialemploymentrate" />
									</td>
									<!-- <td width="5%">
										<s:property value="employmentrate" />
									</td>  -->
								</tr>
							</table>
						</td>
						<td width="10%">
							<table width="100%">
								<tr>
									<td width="30px;" style="text-align: center;">
										<s:property value="exchangeprojects" />
									</td>
									<td width="20px;" style="text-align: center;">
										<s:property value="exchangepeople" />
									</td>
								</tr>
							</table>
						</td>
						<!--<td width="5%">
							<s:property value="beizhu" />
						</td>-->
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="studentculturesummaryList.size() > 0">
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
