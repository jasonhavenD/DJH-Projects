<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>角色信息</title>

		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/admin-all.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/other.css" />
	

		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/textarea.js">
</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/tip.js">
</script>
	
		<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/ajax/FunctionToPcode.js">
</script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/ajax/role_uniqueness.js">
</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/jquery-1.7.2.js">
</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/jquery-ui-1.8.22.custom.min.js">
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
	/*var ro=$("#ro").val();
	var totalRows=$("#totalRows").val();
	var roleList=$("#roleList").val();
	if (ro == 0) {
		alert(ro);
		alert(totalRows);
		alert(roleList);
		for ( var i = 0; i < totalRows; i++) {
			alert(ro);
			$(".rol").hide();
		}
	}*/
})

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
	window.location.href = "initSearch.action?rows=" + rows + "&page=" + page;
}

function setRows(rows) {
	window.location.href = "initSearch.action?rows=" + rows.value;
}
</script>
	</head>

	<body style="background-color:#e4dfd9" onload="init();">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>角色列表
			<b class="tip"></b>查询角色信息
		</div>
		<table class="table table-striped table-bordered table-condensed">
			<tfoot>
				<tr>
					<td align="center">
						<a href="editToSysrole.action?roleCode=0" style=""
							class="btn btn-primary add">添加角色</a>
					</td>
				</tr>
			</tfoot>
		</table>

		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				角色列表
			</caption>
			<thead>
				<tr>
					<td>
						#
					</td>
					<td>
						角色编号
					</td>
					<td>
						角色名称
					</td>
					<td>
						角色描述
					</td>
					<td>
						状态
					</td>
					<td>
						操作
					</td>
				</tr>
			</thead>
			<tbody>
				<s:if test="roleList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有角色信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="roleList" id="role" status="L">
					<input id="ro" type="hidden" value="<s:property value="ro"/>" />
					<input id="totalRows" type="hidden" value="<s:property value="totalRows"/>" />
					<input id="roleList" type="hidden" value="<s:property value="roleList.roleName"/>" />
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td>
							<s:property value="roleCode" />
						</td>
						<td>
							<s:property value="roleName" />
						</td>
						<td>
							<s:property value="roleDescription" />
						</td>
						<td>
							<s:if test='1 == state'>可以分配于用户</s:if>
							<s:if test='0 == state'>不可以分配于用户</s:if>
						</td>
						<td>
							<a class="btn btn-mini btn-primary"
								href="editToSysrole.action?roleCode=<s:property value="roleCode"/>">
								修改 </a>
							<!--<a  class="btn btn-mini btn-primary"
								href="deleteSysrole.action?roleCode=<s:property value="roleCode"/>">
								删除 </a>
							-->
							<span class="rol">
							<a  class="btn btn-mini btn-primary"
								href="addFun.action?roleCode=<s:property value="roleCode"/>&page=1&rows=10">
								分配功能权限 </a>
							</span>
						</td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="roleList.size()> 0">
					<tr>
						<td colspan="99">
							<s:include value="../../common/paging.jsp"></s:include>
						</td>
					</tr>
				</s:if>
			</tfoot>
		</table>

	</body>
</html>
