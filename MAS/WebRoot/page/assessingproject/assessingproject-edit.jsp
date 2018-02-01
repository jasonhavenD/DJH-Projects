<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>评估项目基本信息</title>

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
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/tip.js">
</script>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
		<!-- 日历控件 -->
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/calendar.js">
</script>
		<script type="text/javascript">

function modifyEdit() {
	if (document.getElementById("masprojectName").value == ""
			|| document.getElementById("masprojectOpenDate").value == ""
			|| document.getElementById("masprojectEndDate").value == "") {
		confirm("*选项不能为空");
	} else {
		if (confirm("是否保存")) {
			document.getElementById("edit").submit();
		}
	}
}

//验证输入日期
function checkBirth() {
	var datestring = document.getElementById("birth").value;
	var re = /^(\d{4}-\d{1,2}-\d{1,2})(\s?\d{2}:\d{2}:\d{2})?$/;
	if (!re.test(datestring)) {
		document.getElementById("birspan").innerHTML = "日期格式不正确！";
		document.getElementById("birspan").setAttribute("style",
				"font-size:12px;color:red;");
	} else {
		document.getElementById("birspan").innerHTML = "日期格式正确！";
		document.getElementById("birspan").setAttribute("style",
				"font-size:12px;color:green;");
	}
}
//验证电子邮件
function checkEmail() {
	var string = document.getElementById("email").value;
	var regu = "^(([0-9a-zA-Z]+)|([0-9a-zA-Z]+[_.0-9a-zA-Z-]*[0-9a-zA-Z]+))@([a-zA-Z0-9-]+[.])+([a-zA-Z]{2}|net|NET|com|COM|gov|GOV|mil|MIL|org|ORG|edu|EDU|int|INT)$"
	var re = new RegExp(regu);
	if (string.search(re) != -1) {
		document.getElementById("emailspan").innerHTML = "电子邮件格式正确！";
		document.getElementById("emailspan").setAttribute("style",
				"font-size:12px;color:green;");
	} else {
		document.getElementById("emailspan").innerHTML = "电子邮件格式不正确！";
		document.getElementById("emailspan").setAttribute("style",
				"font-size:12px;color:red;");
	}
}
</script>
	</head>

	<body onload="init();"style="background-color:#e4dfd9">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>查询评估项目基本信息
			<b class="tip"></b>编辑评估项目基本信息
		</div>

		<form action="editAproject.action" id="edit" method="post">


			<table class="table table-striped table-bordered table-condensed">
				<caption class="t_caption">
					评估项目信息编辑
				</caption>
				<thead>
					<tr>
						<td colspan="99">
							评估项目编辑
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td>
							开启评估项目名称
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="aproject.masprojectName"
								id="masprojectName"
								value='<s:property value="aproject.masprojectName" />' />
						</td>
						<td style="width: 60px;">
							评估开启时间
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="aproject.masprojectOpenDate"
								id="masprojectOpenDate"
								value='<fmt:formatDate pattern="yyyy-MM-dd" value="${aproject.masprojectOpenDate}"/>'
								type="text" onclick="fPopCalendar(event,this,this)"
								onfocus="this.select()" />
						</td>
						<td>
							评估结束时间
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="aproject.masprojectEndDate"
								id="masprojectEndDate"
								value='<fmt:formatDate pattern="yyyy-MM-dd" value="${aproject.masprojectEndDate}"/>'
								type="text" onclick="fPopCalendar(event,this,this)"
								onfocus="this.select()" />
						</td>
					</tr>
					<tr>
						<td>
							评估说明
						</td>
						<td colspan="5">
							<input type="text" name="aproject.assessingExplation"
								value='<s:property value="aproject.assessingExplation" />' />
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="99">
							<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
							<a class="btn btn-primary add" href="javascript:modifyEdit()">保存</a>&nbsp;&nbsp;
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</body>
</html>
