<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>编辑指标信息</title>

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
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/UserMajorByDno.js">
</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/user_uniqueness.js">
</script>
		<script type="text/javascript">
function modifyEdit() {
	if (document.getElementById("indicatorId").value == ""
			|| document.getElementById("indicatorName").value == ""
			|| document.getElementById("pid").value == ""
			|| document.getElementById("type").value == "") {
		confirm("*选项不能为空");
	} else {
		if (confirm("是否修改")) {
			document.getElementById("edit").submit();
		}
	}
}
</script>
	</head>

	<body onload="init();"style="background-color:#e4dfd9">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>查询指标信息
			<b class="tip"></b>编辑指标信息
		</div>

		<form action="editTarget.action" id="edit" method="post">


			<table class="table table-striped table-bordered table-condensed">
				<caption class="t_caption">
					指标信息编辑
				</caption>
				<thead>
					<tr>
						<td colspan="99">
							指标信息编辑
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td>
							指标编号
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="app.indicatorId" id="indicatorId"
								value='<s:property value="app.indicatorId" />'
								onblur="onbluruser();" 
								<s:if test="indicatorId != 0">readonly="readonly"</s:if>
							/>
						</td>
						<td>
							指标名
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="app.indicatorName" id="indicatorName"
								value='<s:property value="app.indicatorName" />' />
						</td>
						<td>
							父编号
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="app.pid" id="pid"
								value='<s:property value="app.pid" />' />
						</td>
					</tr>

					<tr>
						<td>
							指标类型
							<font color="red">*</font>
						</td>
						<td>
							<select name="app.type" id="type">
								<option value="">
									全部类型
								</option>
								<option value="1"
									<s:if test="1==app.type">selected="selected"</s:if>>
									定量指标
								</option>
								<option value="0"
									<s:if test="0==app.type">selected="selected"</s:if>>
									定性指标
								</option>
							</select>
						</td>
						<td>
							指标描述
						</td>
						<td colspan="3">
							<input type="text" name="app.indNameExp" id="indNameExp"
								value='<s:property value="app.indNameExp" />' />
						</td>
					</tr>

				</tbody>
				<tfoot>
					<tr>
						<td colspan="99">
							<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
							<a class="btn btn-primary add" href="javascript:modifyEdit()">保存</a>&nbsp;&nbsp;
							<span id="userError"></span>
						</td>

					</tr>
				</tfoot>
			</table>
		</form>
	</body>
</html>
