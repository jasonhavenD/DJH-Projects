<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>本科实验实训场地修改</title>

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


		<script type="text/javascript">
function checkNumber(e)
{   var regx = /\d$/;
var tagValue = document.getElementById(e).value;
if (tagValue!=null && !tagValue.match(regx)) {
			alert("选项数据应为数字");
			document.getElementById(e).focus();
			return false;
		}
		else {
		return true;
		}
}

	//确认修改教学经费
	function modifyContestIdInfoS() {

		if (document.getElementById("traNumber").value.length == 0) {
			alert("实验室编号选项不能为空");
			document.getElementById("traNumber").focus();
		} else if (document.getElementById("traname").value.length == 0) {
			alert("实验室名称选项不能为空");
			document.getElementById("traname").focus();
		} else if (document.getElementById("traCharacter").value.length == 0) {
			alert("实验室性质选项不能为空");
			document.getElementById("traCharacter").focus();
		} else if (document.getElementById("area").value.length == 0) {
			alert("面积选项不能为空");
			document.getElementById("area").focus();
		} else if (document.getElementById("aptCount").value.length == 0) {
			alert("最大可容纳学生人数选项不能为空");
			document.getElementById("aptCount").focus();
		} else if (document.getElementById("eaquipAllVal").value.length == 0) {
			alert("实验仪器设备总价值选项不能为空");
			document.getElementById("eaquipAllVal").focus();
		} else if (document.getElementById("equipVal").value.length == 0) {
			alert("1000元以上设备总价值选项不能为空");
			document.getElementById("equipVal").focus();
		}
		 else if (confirm("是否修改本科实验实训场地信息")) {
			document.getElementById("editTrainingvenue").submit();
		}
	}
</script>

	</head>

	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业数据采集
			<b class="tip"></b>修改本科实验实训场地信息
		</div>

		<form action="editTrainingvenue.action" id="editTrainingvenue"
			method="post">
			<table class="table table-striped table-bordered table-condensed">
				<caption class="t_caption">
					本科实验实训场地
				</caption>
				<thead>
					<tr>
						<td colspan="99">
							本科实验实训场地修改
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 60px;">
							实验室编号
							<font color="FF0000">*</font>
						</td>
						<td>
						<s:if test='trainingvenue==null'>
							<input name="trainingvenue.traNumer" id="traNumber"
								value='<s:property value="trainingvenue.traNumer"/>'
								type="text" />
						</td>
						</s:if>
						<s:else>
						<input name="trainingvenue.traNumer" id="traNumber" readonly="readonly"  id="traNumber"
								value='<s:property value="trainingvenue.traNumer"/>'
								type="text" />
								</s:else>
						<td style="width: 60px;">
							实验室名称
							<font color="FF0000">*</font>
						</td>
						<td>
							<input name="trainingvenue.traName" id="traname"
								value='<s:property value="trainingvenue.traName"/>' type="text" />
						</td>
						<td style="width: 60px;">
							实验室性质
							<font color="FF0000">*</font>
						</td>
						<td>
							<input name="trainingvenue.traCharacter" id="traCharacter"
								value='<s:property value="trainingvenue.traCharacter"/>'
								type="text" />
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							面积
							<font color="FF0000">*</font>
						</td>
						<td>
							<input type="text" name="trainingvenue.area" onblur="return checkNumber('area')"
								value='<s:property value="trainingvenue.area" />' id="area" />
						</td>
						<td style="width: 60px;">
							最大可容纳的学生人数
							<font color="FF0000">*</font>
						</td>
						<td>
							<input type="text" name="trainingvenue.aptCount" onblur="return checkNumber('aptCount')"
								value='<s:property value="trainingvenue.aptCount"/>'
								id="aptCount" />
						</td>
						<td>
							实验仪器设备总价值
							<font color="FF0000">*</font>
						</td>
						<td>
							<input type="text" name="trainingvenue.eaquipAllVal" onblur="return checkNumber('eaquipAllVal')"
								value='<s:property value="trainingvenue.eaquipAllVal" />'
								id="eaquipAllVal" />
						</td>

					</tr>
					<tr>
						<td>
							1000元以上设备总价值
							<font color="FF0000">*</font>
						</td>
						<td>
							<input type="text" name="trainingvenue.equipVal" onblur="return checkNumber('equipVal')"
								value='<s:property value="trainingvenue.equipVal" />'
								id="equipVal" />
						</td>
						<td>
							实验室开放使用人数
						</td>
						<td>
							<input type="text" name="trainingvenue.useCount" id="useCount"
								value='<s:property value="trainingvenue.useCount"/>' />
						</td>
						<td>
							承担课程数
						</td>
						<td>
							<input name="trainingvenue.courseCount" id="courseCount"
								value='<s:property value="trainingvenue.courseCount"/>'
								type="text" />
						</td>
					</tr>
					<tr>
						<td>
							本科生实验实习实训项目数
						</td>
						<td>
							<input name="trainingvenue.pjCount" id="pjCount"
								value='<s:property value="trainingvenue.pjCount"/>' type="text" />
						</td>
						<td>
							学年度承担的实验教学人时数
						</td>
						<td>
							<input name="trainingvenue.thHcount" id="thHcount"
								value='<s:property value="trainingvenue.thHcount"/>' type="text" />
						</td>
						<td>
							学年度承担的实验教学人次数
						</td>
						<td>
							<input name="trainingvenue.thPcount" id="thPcount"
								value='<s:property value="trainingvenue.thPcount"/>' type="text" />
						</td>
					</tr>
					<tr>
						<td>
							使用年份
						</td>
						<td colspan="6">
							<input name="trainingvenue.year" maxlength="4"
								value='<s:property value="trainingvenue.year"/>' type="text" />
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="99">
							<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>
							<a href="javascript:modifyContestIdInfoS()"
								class="btn btn-primary add">保存</a>&nbsp;&nbsp;
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</body>
</html>
