<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>专业教师科研教研情况统计</title>
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
function findScoreCountList(){
	window.location.href="findSTeacherresearchsummaryCountList.action"
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
	window.location.href = "summary_findSTeacherresearchsummaryList.action?"
			+ "teacherresearchsummaryModel.majorId="
			+ '${teacherresearchsummaryModel.majorId}'
			+ "&teacherresearchsummaryModel.departmentId="
			+ '${teacherresearchsummaryModel.departmentId}'
			+ "&teacherresearchsummaryModel.year="
			+ '${teacherresearchsummaryModel.year}' + "&rows=" + rows
			+ "&page=" + page;
}

function setRows(rows) {
	window.location.href = "summary_findSTeacherresearchsummaryList.action?"
			+ "teacherresearchsummaryModel.majorId="
			+ '${teacherresearchsummaryModel.majorId}'
			+ "&teacherresearchsummaryModel.departmentId="
			+ '${teacherresearchsummaryModel.departmentId}'
			+ "&teacherresearchsummaryModel.year="
			+ '${teacherresearchsummaryModel.year}' + "&rows=" + rows.value;
}
//查询信息
function findContestApply() {
	document.getElementById("form1").submit();
}
//导出
function exportSubContestTExcel() {
	window.location.href = "exportSubContestTExcelTeacherresearch.action?exportName=teacherresearchsummary"
			+ "&teacherresearchsummaryModel.majorId="
			+ '${teacherresearchsummaryModel.majorId}'
			+ "&teacherresearchsummaryModel.departmentId="
			+ '${teacherresearchsummaryModel.departmentId}'
			+ "&teacherresearchsummaryModel.year="
			+ '${teacherresearchsummaryModel.year}';
}
</script>
	</head>
	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业数据采集
			<b class="tip"></b>专业教师科研科教信息统计
		</div>
		<form
			action="summary_findSTeacherresearchsummaryList.action?page=1&rows=5"
			id="form1" name="form1" method="post" enctype="multipart/form-data">
			<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />

			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="6">
							专业教师科研科教信息统计查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td>
							统计年份
						</td>
						<td>
							<select name="teacherresearchsummaryModel.year" id="year">
								<option value="">
									全部年份
								</option>
								<s:iterator value="yearList" var="yearvar">
									<option value="<s:property/>"
										<s:if test="#yearvar == teacherresearchsummaryModel.year">selected="selected"</s:if>>
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
								name="teacherresearchsummaryModel.departmentId"
								class="department" onchange="collchange();">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList" var="dvar">
									<option value="<s:property value='dno'/>"
										<s:if test="#dvar.dno == teacherresearchsummaryModel.departmentId"></s:if>>
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							专业
						</td>
						<td>
							<select size="1" name="teacherresearchsummaryModel.majorId"
								id="major">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList" var="mvar">
									<option value="<s:property value='mno'/>"
										<s:if test="#mvar.mno == teacherresearchsummaryModel.majorId"></s:if>>
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
								class="btn btn-primary add">导出教学科研情况</a> &nbsp;&nbsp;
							<span style="color: red;">(先查询，再导出)</span>
						</td>
						<td style="height:30px; font-size: 15px; text-align: center;">
							<a href="javascript:findScoreCountList();"
								class="btn btn-primary add">查看统计图</a>&nbsp;&nbsp;
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
		<div class="table-div">
		<table class="table table-striped table-bordered table-condensed" style="overflow:hidden">
			<caption class="t_caption">
				专业教师科研科教信息统计列表
			</caption>
			<thead>
				<tr class="tr_title" style="height: 30px;">
					<td width="3px;" style="vertical-align: middle; font-size: 13px;">
						#
					</td>
					<td width="3px;" style="vertical-align: middle; font-size: 13px;">
						专业代码
					</td>
					<td width="3px;" style="vertical-align: middle; font-size: 13px;">
						专业名称
					</td>
					<td width="3px;" style="vertical-align: middle; font-size: 13px;">
						统计年份
					</td>
					<td>
						<table width="100%" height="30px;">
							<tr>
								<caption style="font-size: 16px;">
									科研项目数
								</caption>
								<td width="50px">
									国家级
								</td>
								<td width="50px">
									省级
								</td>
								<td width="50px">
									其他
								</td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" height="30px;">
							<tr>
								<caption style="font-size: 16px;">
									教改论文数
								</caption>
								<td width="50px">
									A类
								</td>
								<td width="50px">
									B类
								</td>
								<td width="50px">
									公开发表
								</td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" height="30px;">
							<tr>
								<caption style="font-size: 16px;">
									教改项目数
								</caption>
								<td width="50px">
									省级
								</td>
								<td width="50px">
									校级
								</td>
								<td width="50px">
									其他
								</td>
							</tr>
						</table>
					</td>

					<td>
						<table width="100%" height="30px;">
							<tr>
								<caption style="font-size: 16px;">
									质量工程项目数
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
					<td>
						<table width="100%" height="30px;">
							<tr>
								<caption style="font-size: 16px;">
									教学成果奖
								</caption>
								<td width="50px">
									国特等
								</td>
								<td width="30%">
									国一等
								</td>
								<td width="30%">
									国二等
								</td>
								<td>
									省特等
								</td>
								<td width="30%">
									省一等
								</td>
								<td width="30%">
									省二等
								</td>

								<td>
									校特等
								</td>
								<td width="30%">
									校一等
								</td>
								<td width="30%">
									校二等
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</thead>
			<tbody>
				<s:if test="teacherresearchsummaryList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有项目信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="teacherresearchsummaryList" status="L">
					<tr>

						<td style="text-align: center;">
							<s:property value="#L.index+1" />
						</td>
						<td width="3px;" style="text-align: center;">
							<s:property value="major.mno" />
						</td>
						<td width="3px;" style="text-align: center;">
							<s:property value="major.mname" />
						</td>
						<td width="3px;" style="text-align: center;">
							<s:property value="year" />
						</td>
						<td>
							<table width="100%">
								<tr>
									<td width="23px" style="text-align: center;">
										<s:property value="researchProjectNumber1" />
									</td>
									<td width="20px" style="text-align: center;">
										<s:property value="researchProjectNumber2" />
									</td>
									<td width="20px" style="text-align: center;">
										<s:property value="researchProjectNumber3" />
									</td>
								</tr>
							</table>
						</td>
						<td>
							<table width="100%">
								<tr>
									<td width="20px" style="text-align: center;">
										<s:property value="educationProjectNumber1" />
									</td>
									<td width="20px" style="text-align: center;">
										<s:property value="educationProjectNumber2" />
									</td>
									<td width="23px" style="text-align: center;">
										<s:property value="educationProjectNumber3" />
									</td>
								</tr>
							</table>
						</td>
						<td>
							<table width="100%">
								<tr>
									<td width="22px" style="text-align: center;">
										<s:property value="educationPaperNumber1" />
									</td>
									<td width="20px" style="text-align: center;">
										<s:property value="educationPaperNumber2" />
									</td>
									<td width="20px" style="text-align: center;">
										<s:property value="educationPaperNumber3" />
									</td>
								</tr>
							</table>
						</td>

						<td>
							<table width="100%">
								<tr>
									<td width="20px" style="text-align: center;">
										<s:property value="qualitylEngineeringNumber1" />
									</td>
									<td width="20px" style="text-align: center;">
										<s:property value="qualitylEngineeringNumber2" />
									</td>
									<td width="20px" style="text-align: center;">
										<s:property value="qualitylEngineeringNumber3" />
									</td>
								</tr>
							</table>
						</td>

						<td>
							<table width="100%">
								<tr>
									<td width="20px" style="text-align: center;">
										<s:property value="teachingAchievementNumber11" />
									</td>
									<td width="20px" style="text-align: center;">
										<s:property value="teachingAchievementNumber21" />
									</td>
									<td width="20px" style="text-align: center;">
										<s:property value="teachingAchievementNumber31" />
									</td>
									<td width="20px" style="text-align: center;">
										<s:property value="teachingAchievementNumber12" />
									</td>
									<td width="20px" style="text-align: center;">
										<s:property value="teachingAchievementNumber22" />
									</td>
									<td width="20px" style="text-align: center;">
										<s:property value="teachingAchievementNumber32" />
									</td>
									<td width="20px" style="text-align: center;">
										<s:property value="teachingAchievementNumber13" />
									</td>
									<td width="20px" style="text-align: center;">
										<s:property value="teachingAchievementNumber23" />
									</td>
									<td width="20px" style="text-align: center;">
										<s:property value="teachingAchievementNumber33" />
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		<table cellspacing="0"
			class="table table-striped table-bordered table-condensed" style="overflow:hidden">
			<thead>
				<tr class="tr_title">
					<td style="vertical-align: middle; font-size: 13px;">
						#
					</td>
					<td style="vertical-align: middle; font-size: 13px;">
						专业代码
					</td>
					<td style="vertical-align: middle; font-size: 13px;">
						专业名称
					</td>
					<td style="vertical-align: middle; font-size: 13px;">
						统计年份
					</td>
					<td>
						<table width="100%" height="30px;">
							<tr>
								<caption style="font-size: 16px;">
									出版教材数
								</caption>
								<td style="text-align: center;">
									主编
								</td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" height="30px;">
							<tr>
								<caption style="font-size: 16px;">
									科研论文数
								</caption>
								<td width="45px">
									EI/SCI/SSCI
									<!--<br />
									（A类）

								-->
								</td>
								<td width="45px">
									A类
									<!--<br />
									（SCI、EI等）

								-->
								</td>
								<td width="45px">
									B类
									<!--<br />
									（其他）

								-->
								</td>
							</tr>
						</table>
					</td>

					<td style="text-align: center;">
						<table cellspacing="0" width="100%" height="60px;">
							<tr>
								<caption style="vertical-align: middle; font-size: 16px;">
									科研奖励数
								</caption>
								<td>
								<table cellspacing="0" width="100%">
									<tr>
									<caption style="vertical-align: middle; font-size: 15px;">
										国家一等奖
									</caption>
									<td style="text-align: center;">
									第一
									</td>
									<td style="text-align: center;">
									第二
								</td>
								<td style="text-align: center;">
									第三
								</td>
									</tr>
								</table>
								</td>

								<td>
								<table cellspacing="0" width="100%">
									<tr>
									<caption  style="vertical-align: middle; font-size: 15px;">
										国家二等奖
									</caption>
									<td style="text-align: center;">
									第一
									</td>
									<td style="text-align: center;">
									第二
								</td>
								<td style="text-align: center;">
									第三
								</td>
									</tr>
								</table>
								</td>
								<td>
								<table cellspacing="0" width="100%">
									<tr>
									<caption  style="vertical-align: middle; font-size: 15px;">
										国家三等奖
									</caption>
									<td style="text-align: center;">
									第一
									</td>
									<td style="text-align: center;">
									第二
								</td>
								<td style="text-align: center;">
									第三
								</td>
									</tr>
								</table>
								</td>
								<td>
								<table cellspacing="0" width="100%">
									<tr>
									<caption  style="vertical-align: middle; font-size: 15px;">
										省级一等奖
									</caption>
									<td style="text-align: center;">
									第一
									</td>
									<td style="text-align: center;">
									第二
								</td>
								<td style="text-align: center;">
									第三
								</td>
									</tr>
								</table>
								</td>
								<td>
								<table cellspacing="0" width="100%">
									<tr>
									<caption  style="vertical-align: middle; font-size: 15px;">
										省级二等奖
									</caption>
									<td style="text-align: center;">
									第一
									</td>
									<td style="text-align: center;">
									第二
								</td>
								<td style="text-align: center;">
									第三
								</td>
									</tr>
								</table>
								</td>
								<td>
								<table cellspacing="0" width="100%">
									<tr>
									<caption  style="vertical-align: middle; font-size: 15px;">
										省级三等奖
									</caption>
									<td style="text-align: center;">
									第一
									</td>
									<td style="text-align: center;">
									第二
								</td>
								<td style="text-align: center;">
									第三
								</td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</thead>
			<tbody>
				<s:if test="teacherresearchsummaryList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有项目信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="teacherresearchsummaryList" status="L">
					<tr>
						<td width="5px;" style="text-align: center;">
							<s:property value="#L.index+1" />
						</td>
						<td width="5px;" style="text-align: center;">
							<s:property value="major.mno" />
						</td>
						<td width="5px;" style="text-align: center;">
							<s:property value="major.mname" />
						</td>
						<td width="5px;" style="text-align: center;">
							<s:property value="year" />
						</td>
						<td>
							<table width="100%">
								<tr>
									<td style="text-align: center;">
										<s:property value="textbookNumber1" />
									</td>
								</tr>
							</table>
						</td>
						<td>
							<table width="100%">
								<tr>
									<td width="35px" style="text-align: center;">
										<s:property value="researchPaperNumber1" />
									</td>
									<td width="20px" style="text-align: center;">
										<s:property value="researchPaperNumber2" />
									</td>
									<td width="20px" style="text-align: center;">
										<s:property value="researchPaperNumber3" />
									</td>
								</tr>
							</table>
						</td>

						<td>
							<table width="100%">
								<tr>
									<td  style="text-align: center;">
										<s:property value="researchAwardNumber111" />
									</td>
									<td style="text-align: center;">
										<s:property value="researchAwardNumber211" />
									</td>
									<td style="text-align: center;">
										<s:property value="researchAwardNumber311" />
									</td>
									<td style="text-align: center;">
										<s:property value="researchAwardNumber121" />
									</td>
									<td style="text-align: center;">
										<s:property value="researchAwardNumber221" />
									</td>
									<td style="text-align: center;">
										<s:property value="researchAwardNumber321" />
									</td>
									<td style="text-align: center;">
										<s:property value="researchAwardNumber131" />
									</td>
									<td style="text-align: center;">
										<s:property value="researchAwardNumber231" />
									</td>
									<td style="text-align: center;">
										<s:property value="researchAwardNumber331" />
									</td>
									<td style="text-align: center;">
										<s:property value="researchAwardNumber112" />
									</td>
									<td style="text-align: center;">
										<s:property value="researchAwardNumber212" />
									</td>
									<td style="text-align: center;">
										<s:property value="researchAwardNumber312" />
									</td>
									<td style="text-align: center;">
										<s:property value="researchAwardNumber122" />
									</td>
									<td style="text-align: center;">
										<s:property value="researchAwardNumber222" />
									</td>
									<td style="text-align: center;">
										<s:property value="researchAwardNumber322" />
									</td>
									<td style="text-align: center;">
										<s:property value="researchAwardNumber132" />
									</td>
									<td style="text-align: center;">
										<s:property value="researchAwardNumber232" />
									</td>
									<td style="text-align: center;">
										<s:property value="researchAwardNumber332" />
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="teacherresearchsummaryList.size() > 0">
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
