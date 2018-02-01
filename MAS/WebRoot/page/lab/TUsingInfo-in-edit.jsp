<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>实践教学资源情况</title>

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
			src="${pageContext.request.contextPath}/Scripts/ajax/MajorByDno.js">
</script>


		<script type="text/javascript">
//日历插件
$(function() {
	$(".datepicker").datepicker();
})

//确认修改赛项

function Numbers(e) {
	var keynum
	var keychar
	var numcheck

	if (window.event) // IE
	{
		keynum = e.keyCode
	} else if (e.which) // Netscape/Firefox/Opera
	{
		keynum = e.which
	}
	keychar = String.fromCharCode(keynum)
	numcheck = /\d/;
	return numcheck.test(keychar)
}

function modifyTraininguseinginformation() {
    if (document.getElementById("coll").value.length == 0) {
		confirm("所在学院选项不能为空!");
		document.getElementById("coll").focus();
	}
    else if (document.getElementById("year").value.length == 0) {
		alert("年份选项不能为空!");
		document.getElementById("year").focus();
	} else if (document.getElementById("year").value.length != 4) {
		alert("年份选项只能为4位数字!");
		document.getElementById("year").focus();
	} else if (document.getElementById("resourceConstructionNumber").value.length == 0) {
		alert("共建教学资源数选项不能为空!");
		document.getElementById("resourceConstructionNumber").focus();
	} else if (document.getElementById("experimentalEquipmentMean").value.length == 0) {
		alert("实验设备生均值选项不能为空!");
		document.getElementById("experimentalEquipmentMean").focus();
	} else if (document.getElementById("laboratorySatisfactionRate").value.length == 0) {
		alert("实验室满足率选项不能为空!");
		document.getElementById("laboratorySatisfactionRate").focus();
	}
	else if (document.getElementById("experimentNumber").value.length == 0) {
		alert("实验开放人时数选项选项不能为空!");
		document.getElementById("experimentNumber").focus();
	} else if (document.getElementById("schooBaseNumber").value.length == 0) {
		alert("校内基地数选项选项不能为空!");
		document.getElementById("schooBaseNumber").focus();
	} else if (document.getElementById("outBaseNumber").value.length === 0) {
		alert("校外基地数选项选项不能为空!");
		document.getElementById("outBaseNumber").focus();
	} else if (document.getElementById("schooBaseRate").value.length == 0) {
		alert("校内基地满足率选项选项不能为空!");
		document.getElementById("schooBaseRate").focus();
	} else if (document.getElementById("outBaseRate").value.length == 0) {
		alert("校外基地满足率选项选项不能为空!");
		document.getElementById("outBaseRate").focus();
	}

	else if (confirm("是否保存")) {
		document.getElementById("editTraininguseinginformation").submit();
	}
}
</script>

	</head>

	<body style="background-color:#e4dfd9"  onload="init();">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业数据采集
			<b class="tip"></b>实践教学情况
		</div>

		<form action="editTraininguseinginformation.action"
			id="editTraininguseinginformation" method="post">



			<table class="table table-striped table-bordered table-condensed">
				<caption class="t_caption">
					实践教学情况信息
				</caption>
				<thead>
					<tr>
						<td colspan="99">
							实践教学情况
						</td>
					</tr>
				</thead>
				<tbody>

					<tr>
						<td>
							所在学院
							<font color="red">*</font>
						</td>
						<td>
							<select name="traininguseinginformation.major.department.dno"
								id="coll" onchange="collchange();">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList" var="departmentvar">
									<option value="<s:property value="dno"/>"
										<s:if test="#departmentvar.dno == traininguseinginformation.major.department.dno">selected="selected"</s:if>>
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>

						<td>
							所在专业
							<font color="red">*</font>
						</td>
						<td>
							<select name="traininguseinginformation.major.mno" id="major">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList" var="major">
									<option value="<s:property value="mno"/>"
										<s:if test="#major.mno == traininguseinginformation.major.mno">selected="selected"</s:if>>
										<s:property value="mname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							年份
							<font color="red">*</font>
						</td>
						<td>
							<input name="traininguseinginformation.year" id="year"
								maxlength="4"
								value='<s:property value="traininguseinginformation.year"/>'
								type="text" onkeypress="return Numbers(event)" readonly="readonly"/>
						</td>
					</tr><tr>
						<td style="width: 60px;">
							共建教学资源数<font color="red">*</font>
						</td>
						<td>
							<input
								name="traininguseinginformation.resourceConstructionNumber"
								id="resourceConstructionNumber"
								onkeypress="return Numbers(event)"
								value='<s:property value="traininguseinginformation.resourceConstructionNumber"/>'
								type="text" />
						</td>

						<td style="width: 60px;">
							实验设备生均值<font color="red">*</font>
						</td>
						<td>
							<input name="traininguseinginformation.experimentalEquipmentMean"
								id="experimentalEquipmentMean"
								onkeypress="return Numbers(event)"
								value='<s:property value="traininguseinginformation.experimentalEquipmentMean"/>'
								type="text" readonly="readonly"/>
						</td>
						<td style="width: 60px;">
							实验室满足率<font color="red">*</font>
						</td>

						<td>
							<input
								name="traininguseinginformation.laboratorySatisfactionRate"
								id="laboratorySatisfactionRate"
								onkeyup="value=value.replace(/[^\d.]/g,'')"
								value='<s:property value="traininguseinginformation.laboratorySatisfactionRate"/>'
								type="text" />
						</td>
					</tr>
					<tr>
						<td>
							实验开放人时数<font color="red">*</font>
						</td>
						<td>
							<input name="traininguseinginformation.experimentNumber"
								id="experimentNumber" onkeypress="return Numbers(event)"
								value='<s:property value="traininguseinginformation.experimentNumber"/>'
								type="text" readonly="readonly"/>
						</td>
						<td>
							校内基地数<font color="red">*</font>
						</td>

						<td>
							<input name="traininguseinginformation.schooBaseNumber"
								id="schooBaseNumber" onkeypress="return Numbers(event)"
								value='<s:property value="traininguseinginformation.schooBaseNumber"/>'
								type="text" />
						</td>


						<td>
							校外基地数<font color="red">*</font>
						</td>

						<td>
							<input name="traininguseinginformation.outBaseNumber"
								id="outBaseNumber" onkeypress="return Numbers(event)"
								value='<s:property value="traininguseinginformation.outBaseNumber"/>'
								type="text" />
						</td>
						</tr>
					<tr>
						<td>
							校内基地满足率<font color="red">*</font>
						</td>

						<td>
							<input name="traininguseinginformation.schooBaseRate"
								id="schooBaseRate" onkeyup="value=value.replace(/[^\d.]/g,'')"
								value='<s:property value="traininguseinginformation.schooBaseRate"/>'
								type="text" />
						</td>
                        <td>
							校外基地满足率<font color="red">*</font>
						</td>

						<td colspan="3">
							<input name="traininguseinginformation.outBaseRate"
								id="outBaseRate" onkeyup="value=value.replace(/[^\d.]/g,'')"
								value='<s:property value="traininguseinginformation.outBaseRate"/>'
								type="text" />
						</td>
					</tr>

				</tbody>
				<tfoot>
					<tr>
						<td colspan="99">

							<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
							<a href="javascript:modifyTraininguseinginformation()"
								class="btn btn-primary add">保存</a>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</body>
</html>
