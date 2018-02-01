<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>分配结果信息</title>

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
	</script>
	</head>

	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专家分配管理
			<b class="tip"></b>分配结果信息
		</div>
		<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							分配结果
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td>
							<font color="green">已分配成功的专家专业信息：</font><br/><s:property value="successmsg" escape="false"/>
						</td>
					</tr>
					<tr>
						<td>
							<font color="red">未分配成功的专家专业信息：</font><br/><s:property value="errormsg" escape="false"/>
						</td>
					</tr>
				</tbody>
		</table>
	</body>
</html>
