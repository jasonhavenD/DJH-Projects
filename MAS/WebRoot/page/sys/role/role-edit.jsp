<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>编辑角色信息</title>

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
		<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/ajax/FunctionToPcode.js">
</script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/ajax/role_uniqueness.js">
</script>
		<script type="text/javascript">
function modifyEdit() {
	if(document.getElementById("roleCode").value=="" || document.getElementById("roleName").value=="" || document.getElementById("state").value==""){
		confirm("*选项不能为空");
	}else{
		if (confirm("是否修改")) {
			document.getElementById("edit").submit();
		}
	}
}
</script>
</head>

	<body style="background-color:#e4dfd9"  onload="init();">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>查询角色信息
			<b class="tip"></b>编辑角色信息
		</div>

		<form action="editSysrole.action"
			id="edit" method="post">


			<table class="table table-striped table-bordered table-condensed">
				<caption class="t_caption">
					角色信息编辑
				</caption>
				<thead>
					<tr>
						<td colspan="99">
							角色信息编辑
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td>
							角色编号
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="role.roleCode" id="roleCode"
									value='<s:property value="role.roleCode" />' onblur="onblurRole();"
									<s:if test="roleCode != 0">readonly="readonly"</s:if>
									/>
						</td>
						<td>
							角色名称
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="role.roleName" id="roleName"
									value='<s:property value="role.roleName" />' />
						</td>
						<td>
							角色描述
						</td>
						<td>
							<input type="text" name="role.roleDescription" id="roleDescription"
									value='<s:property value="role.roleDescription" />' />
						</td>
					</tr>
					<tr>
						<td>
							状态
							<font color="red">*</font>
						</td>
						<td colspan="5">
							<select name="role.state" id="state">
								<option value="1"
									<s:if test="1==role.state">selected="selected"</s:if>>
									可以分配于用户
								</option>
								<option value="0"
									<s:if test="0==role.state">selected="selected"</s:if>>
									不可以分配于用户
								</option>
							</select>
						</td>
					</tr>

				</tbody>
				<tfoot>
					<tr>
						<td colspan="99">
							<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
							<a class="btn btn-primary add" href="javascript:modifyEdit()">保存</a>&nbsp;&nbsp;
							<span id="roleError"></span>
						</td>

					</tr>
				</tfoot>
			</table>
		</form>
	</body>
</html>
