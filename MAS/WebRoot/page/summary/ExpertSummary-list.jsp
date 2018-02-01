<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>定性指标统计</title>
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

		<script>


//查询
function findContestApply() {
	document.getElementById("form1").submit();
}

$(document).ready(function() {
	// ------------------------------
		//角色判断
		var rol = $("#rol").val();
		var totalRows = $("#totalRows").val();
		//if (rol == 3) {

			//for ( var i = 0; i < totalRows; i++) {
				//$(".attach").hide();//隐藏上传
			//}

		//}
	});

function find(){
	window.location.href = "summary_findFia.action?fiamodel.majorId="
	+'${fiamodel.majorId}'
	+ "&fiamodel.year=" + '${fiamodel.year}'
	+ "&fiamodel.departmentId=" + '${fiamodel.departmentId}'
	+"&rows=" + rows + "&page=" + page;
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

	window.location.href = "summary_findFia.action?fiamodel.majorId="
	+'${fiamodel.majorId}'
	+ "&fiamodel.year=" + '${fiamodel.year}'
	+ "&fiamodel.departmentId=" + '${fiamodel.departmentId}'
	+"&rows=" + rows + "&page=" + page;

}

function setRows(rows) {

	window.location.href = "summary_findFia.action?fiamodel.majorId="
	+'${fiamodel.majorId}'
	+ "&fiamodel.year=" + '${fiamodel.year}'
	+ "&fiamodel.departmentId=" + '${fiamodel.departmentId}'
	+"&rows=" + rows.value;
}
//导出
function exportSubContestTExcel() {
	window.location.href = "exportSubContestTExcelexpert.action?exportName=expertsummary"
	+ "&fiamodel.majorId="+'${fiamodel.majorId}'
	+ "&fiamodel.year=" + '${fiamodel.year}'
	+ "&fiamodel.departmentId=" + '${fiamodel.departmentId}';
}
</script>


	</head>
	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>评估数据统计
			<b class="tip"></b>定性指标统计
		</div>
		<form action="summary_findFia.action?page=1&rows=10" id="form1" name="form1"
			method="post" enctype="multipart/form-data">

			<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							附件表查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td width="10%">
							统计年份
						</td>
						<td>
							<select name="fiamodel.year" id="year">
								<option value="">
									全部年份
								</option>
								<s:iterator value="yearList" var="yearvar">
									<option value="<s:property/>"
										<s:if test="#yearvar == fiamodel.year">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>



						<td>
							所在学院
						</td>
						<td>
							<select size="1" id="coll" name="fiamodel.departmentId"
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
							<select size="1" name="fiamodel.majorId" id="major">
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
				</tbody>
				<tfoot>
					<tr>
						<td width="10%" colspan="4">
							<a href="javascript:findContestApply();"
								class="btn btn-primary add">查询</a>
							<a href="#" onclick="exportSubContestTExcel()"
								class="btn btn-primary add">导出定性指标统计信息</a> &nbsp;&nbsp;
							<span style="color: red;">(先查询，再导出)</span>
						</td>
						<td align="right" colspan="2">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>

		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				各专业附件列表
			</caption>
			<thead>
				<tr class="tr_title">
					<td>
						#
					</td>
					<td>
						年份
					</td>
					<td>
						专业
					</td>
					<td>
						专业评估编号
					</td>
					<td>
						指标名称
					</td>
					<td>
						上传否
					</td>
					<td>
						平均得分
					</td>
				</tr>
			</thead>
			<tbody>
				<s:if test="fiaList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有附件信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="fiaList" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td>
							<s:property value="year" />
						</td>
						<td>
							<s:property value="mas.major.mname" />
						</td>
						<td>
							<s:property value="mas.masCode" />
						</td>

						<td>
							<s:property value="mas.masCode" />
							-
							<s:property
								value="mas.assessingneedtarget.appraisalsystem.indicatorName" />
						</td>
						<s:if test="uploadStatus==1">
							<td>
								<font color="green">已经上传</font>
							</td>
						</s:if>
						<s:else>
							<td>
								<font color="red">未上传</font>
							</td>
						</s:else>

						<td>
							<s:property value="asseisingValue" />
						</td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="fiaList.size() > 0">
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
