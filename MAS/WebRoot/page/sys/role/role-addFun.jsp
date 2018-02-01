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
	window.location.href = "addFun.action?rows=" + rows + "&page=" + page;
}

function setRows(rows) {
	window.location.href = "addFun.action?rows=" + rows.value;
}
</script>
	</head>
	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>功能权限列表
			<b class="tip"></b>分配功能权限
		</div>
		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				功能权限列表
			</caption>
			<thead>
				<tr>
					<td>
						#
					</td>
					<td>
						功能名称
					</td>
					<td>
						是否已有该功能
					</td>
					<td>
						操作
					</td>
				</tr>
			</thead>
			<tbody>
				<s:if test="rolejuriList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="rolejuriList" id="rolejuri" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td>
							<s:property value="Name" />
						</td>
						<s:if test="0==year">
							<td>
								是
							</td>
							<td>
								<a class="btn btn-mini btn-primary"
									href="deleteSysrolejuri.action?roleMenuCode=<s:property value="majorId"/>"
									id="delete"> 删除 </a>
							</td>
						</s:if>
						<s:else>
							<td>
								否
							</td>
							<td>
								<a class="btn btn-mini btn-primary"
									href="editSysrolejuri.action?roleCode=<s:property value="roleCode"/>&funModleCode=<s:property value="Id"/>"
									id="add"> 添加 </a>
							</td>
						</s:else>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="rolejuriList.size()> 0">
					<tr>
						<td colspan="99">
							<s:include value="../../common/paging.jsp"></s:include>
						</td>
					</tr>
				</s:if>
				<tr>
					<td colspan="99">
						<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
					</td>

				</tr>
			</tfoot>
		</table>
	</body>
</html>
