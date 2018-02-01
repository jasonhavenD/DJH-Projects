<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>编辑专家信息</title>

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
	if (document.getElementById("expertId").value == ""
			|| document.getElementById("expertName").value == "") {
		confirm("*选项不能为空");
	} else {
		if (confirm("是否保存")) {
			document.getElementById("edit").submit();
		}
	}
}
</script>
	</head>

	<body style="background-color:#e4dfd9"  onload="init();">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>查询专家信息
			<b class="tip"></b>编辑专家信息
		</div>

		<form action="editExpertmanage.action" id="edit" method="post">


			<table class="table table-striped table-bordered table-condensed">
				<caption class="t_caption">
					专家信息编辑
				</caption>
				<thead>
					<tr>
						<td colspan="99">
							专家信息编辑
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td>
							专家编号
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="expert.expertId" id="expertId"
								value='<s:property value="expert.expertId" />'
								onblur="onbluruser();"
								<s:if test="expert != null">readonly="readonly"</s:if>
							/>
						</td>
						<td>
							专家名称
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="expert.expertName" id="expertName"
								value='<s:property value="expert.expertName" />' />
						</td>
							<td>
							密码
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="expert.password" id="password"
								value='<s:property value="expert.password" />' />
						</td>
					</tr>
					<tr>
					<td>
						专家类型
						</td>
						<td>
							<select name="expert.type" id="type">
								<option value="">
									全部类型
								</option>
								<option value="1"
									<s:if test="1==expert.type">selected="selected"</s:if>>
									校内专家
								</option>
								<option value="0"
									<s:if test="0==expert.type">selected="selected"</s:if>>
									校外专家
								</option>
							</select>
						</td>
						<td>
							专家描述
						</td>
						<td colspan="5">
							<input type="text" name="expert.note" id="note"
								value='<s:property value="expert.note" />' />
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
