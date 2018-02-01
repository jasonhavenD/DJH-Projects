<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>专业评估指标统计信息</title>

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
			src="${pageContext.request.contextPath}/Scripts/ajax/MajorByDno.js">
</script>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
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

//查询
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
	var tname = "" + '${basemodel.name}';
	tname = encodeURI(tname);
	tname = encodeURI(tname);
	var tid = "" + '${basemodel.id}';
	tid = encodeURI(tid);
	tid = encodeURI(tid);
	window.location.href = "findMas.action?basemodel.id="
			+ tid + "&basemodel.name=" + tname+ "&basemodel.departmentId="
			+ '${basemodel.departmentId}' + "&basemodel.majorId="
			+ '${basemodel.majorId}' + "&rows=" + rows
			+ "&page=" + page;
}

function setRows(rows) {
	var tname = "" + '${basemodel.name}';
	tname = encodeURI(tname);
	tname = encodeURI(tname);
	var tid = "" + '${basemodel.id}';
	tid = encodeURI(tid);
	tid = encodeURI(tid);
	window.location.href = "findMas.action?basemodel.id="
			+ tid + "&basemodel.name=" + tname+ "&basemodel.departmentId="
			+ '${basemodel.departmentId}' + "&basemodel.majorId="
			+ '${basemodel.majorId}' + "&rows="
			+ rows.value;
}
//导出信息
function exportSubContestTExcel() {

 	var tname=""+'${teachermodel.tname}';
 	tname=encodeURI(tname);
	tname = encodeURI(tname);
	var tid = "" + '${basemodel.id}';
	tid = encodeURI(tid);
	tid = encodeURI(tid);

	var mid = "" + '${basemodel.majorId}';
	mid = encodeURI(mid);
	mid = encodeURI(mid);

	var did = "" + '${basemodel.departmentId}';
	did = encodeURI(did);
	did = encodeURI(did);

	window.location.href = "exportMas.action?exportName=assessmentIndexInfo"
			+"&basemodel.id="+tid
			+"&basemodel.departmentId="+did
			+"&basemodel.majorId=" + mid
			+"&basemodel.Name=" +tname;
}

</script>

	</head>

	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业评估指标统计信息
			<b class="tip"></b>查询专业评估指标统计信息
		</div>

		<form action="findMas.action?page=1&rows=10" id="form1"
			name="form1" method="post" enctype="multipart/form-data">
<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />

			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							专业评估指标统计信息
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 60px;">
							指标名称
						</td>
						<td>
							<select size="1" id="basemodel.Id" name="basemodel.Id">
								<option value="">
									全部指标
								</option>
								<s:iterator value="assessingneedtargetsList">
									<option value="<s:property value='appraisalsystem.indicatorId'/>">
										<s:property value="appraisalsystem.indicatorName"/>
									</option>
								</s:iterator>
							</select>
						</td>
						<!--<td>
							<select size="1" id="basemodel.Id" name="basemodel.Id">
								<option value="">
									一级指标
								</option>
								<s:iterator value="firstassessingneedtargetsList" >
									<option value="<s:property value='appraisalsystem.indicatorName'/>">
										<s:property value="appraisalsystem.indicatorName"/>
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							<select size="1" id="basemodel.Id" name="basemodel.Id">
								<option value="">
									二级指标
								</option>
								<s:iterator value="secondassessingneedtargetsList">
									<option value="<s:property value='appraisalsystem.indicatorName'/>">
										<s:property value="appraisalsystem.indicatorName"/>
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							<select size="1" id="basemodel.Id" name="basemodel.Id">
								<option value="">
									三级指标
								</option>
								<s:iterator value="thirdassessingneedtargetsList">
									<option value="<s:property value='appraisalsystem.indicatorName'/>">
										<s:property value="appraisalsystem.indicatorName"/>
									</option>
								</s:iterator>
							</select>
						</td>
						--><td>
							所在学院
						</td>
						<td>
							<select size="1" id="coll" name="basemodel.departmentId"
								class="department" onchange="collchange();">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList">
									<option value="<s:property value='dno'/>">
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							所在专业
						</td>
						<td>
							<select size="1" name="basemodel.majorId" id="major">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList">
									<option value="<s:property value='mno'/>">
										<s:property value="mname" />
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							开启评估项目名称
						</td>
						<td colspan="5">
							<select size="1" name="basemodel.Name" id="pName">
								<s:iterator value="aprojectList">
									<option value="<s:property value='masprojectName'/>">
										<s:property value="masprojectName" />
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
								class="btn btn-primary add">导出</a> &nbsp;&nbsp;
							<span style="color: red;">(先查询，再导出)</span>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>

		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				专业评估指标统计信息列表
			</caption>
			<thead>
				<tr>
					<td>
						#
					</td>
					<td>
						专业
					</td>
					<td>
						开启评估项目名称
					</td>
					<td>
						指标名称
					</td>
					<td>
						指标权重
					</td>
					<td>
						评估得分
					</td>
				</tr>
			</thead>
			<tbody>
				<s:if test="masList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有查询到相关信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="masList" id="target" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td>
							<s:property value="major.mname" />
						</td>
						<td>
							<s:property value="assessingneedtarget.assessingproject.masprojectName" />
						</td>
						<td>
							<s:property value="assessingneedtarget.appraisalsystem.indicatorName" />
						</td>
						<td>
							<s:property value="assessingneedtarget.indicatorWeight" />
						</td>
						<td>
							<s:property value="assessingScore" />
						</td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="masList.size() > 0">
					<tr>
						<td colspan="99">
							<s:include value="../common/paging.jsp"></s:include>
						</td>
					</tr>
				</s:if>
			</tfoot>
		</table>

	</body>
</html>
