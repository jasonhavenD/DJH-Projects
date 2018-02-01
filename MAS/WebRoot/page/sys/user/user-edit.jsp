<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>编辑用户信息</title>

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
			src="${pageContext.request.contextPath}/Scripts/ajax/user_uniqueness.js">
</script>
				<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/ajax/MajorByDno.js"></script>

		<script type="text/javascript">
function modifyEdit() {
	if (document.getElementById("userCode").value == ""
			|| document.getElementById("userName").value == ""
			|| document.getElementById("password").value == ""
			|| document.getElementById("roleCode").value == ""
			|| document.getElementById("coll").value == ""
			|| document.getElementById("major").value == "") {
		confirm("*选项不能为空");
	} else {
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
			<b class="tip"></b>查询用户信息
			<b class="tip"></b>编辑用户信息
		</div>

		<form action="editSysuserinfo.action" id="edit" method="post">


			<table class="table table-striped table-bordered table-condensed">
				<caption class="t_caption">
					用户信息编辑<font color="red">(添加或修改专家请在专家管理页面操作)</font>
				</caption>
				<thead>
					<tr>
						<td colspan="99">
							用户信息编辑
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td>
							用户编号
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="user.userCode" id="userCode"
								value='<s:property value="user.userCode" />'
								onblur="onbluruser();"
								<s:if test="userCode != 0">readonly="readonly"</s:if>
							/>
						</td>
						<td>
							用户名称
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="user.userName" id="userName"
								value='<s:property value="user.userName" />' />
						</td>
						<td>
							密码
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="user.password" id="password"
								value='<s:property value="user.password" />' />
						</td>
					</tr>
					<tr>
						<td>
							所在学院
							<font color="red">*</font>
						</td>
						<td>
							<select name="user.department.dno" id="coll"
								>
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList" var="departmentvar">
									<option value="<s:property value="dno"/>"
										<s:if test="#departmentvar.dno == user.department.dno">selected="selected"</s:if>>
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
							<select name="user.major.mno" id="major">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList" var="major">
									<option value="<s:property value="mno"/>"
										<s:if test="#major.mno == user.major.mno">selected="selected"</s:if>>
										<s:property value="mname" />

									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							角色
							<font color="red">*</font>
						</td>
						<td>
							<select name="user.sysrole.roleCode" id="roleCode">
								<option value="">
									全部角色
								</option>
								<s:iterator value="roleList" var="role">
									<option value="<s:property value="roleCode"/>"
										<s:if test="#role.roleCode == user.sysrole.roleCode">selected="selected"</s:if>>
										<s:property value="roleName" />
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>
					<tr>

						<td>
							用户描述
						</td>
						<td colspan="3">
							<input type="text" name="user.useDesc" id="useDesc"
								value='<s:property value="user.useDesc" />' />
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
