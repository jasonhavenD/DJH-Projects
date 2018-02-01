<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>功能信息</title>

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
		<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/ajax/FunctionToPcode.js">
</script>
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

//查询
function findContestApply() {
	document.getElementById("form1").submit();
}

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
	window.location.href = "find.action?funcmodel.id=" + '${funcmodel.id}'
			+ "&funcmodel.pfun=" + '${funcmodel.pfun}' + "&funcmodel.state="
			+ '${funcmodel.state}' + "&rows=" + rows + "&page=" + page;
}

function setRows(rows) {
	window.location.href = "find.action?funcmodel.id=" + '${funcmodel.id}'
			+ "&funcmodel.pfun=" + '${funcmodel.pfun}' + "&funcmodel.state="
			+ '${funcmodel.state}' + "&rows=" + rows.value;
}
</script>
	</head>

	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>功能列表
			<b class="tip"></b>查询功能信息
		</div>
		<form action="find.action?page=1&rows=10" id="form1" name="form1"
			method="post" enctype="multipart/form-data">

<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							功能信息查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td>
							一级目录名称
						</td>
						<td>
							<select id="firstp" onchange="firstpchange();" >
								<option value="">
									--全部一级目录--
								</option>
								<s:iterator value="firstpList">
									<option value="<s:property value="funModleCode"/>">
										<s:property value="funModleName" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							二级目录名称
						</td>
						<td>
							<select id="secondp" name="funcmodel.pfun"
								onchange="secondpchange();">
								<option value="">
									--全部二级目录--
								</option>
								<s:iterator value="secondpList">
									<option value="<s:property value="funModleCode"/>">
										<s:property value="funModleName" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							功能名称
						</td>
						<td>
							<select name="funcmodel.Id" id="funcid">
								<option value="">
									全部功能
								</option>
								<s:iterator value="thirdpList">
									<<option value="<s:property value="funModleCode"/>">
										<s:property value="funModleName" />
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							状态
						</td>
						<td colspan="5">
							<select name="funcmodel.state">
								<option value="">
									--选择--
								</option>
								<option value="1">
									可以分配于角色
								</option>
								<option value="0">
									不可以分配于角色
								</option>
							</select>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="5">
							<a href="javascript:findContestApply();"
								class="btn btn-primary add">查询
							</a>
						</td>
						<td align="center">
							<a href="editToSysFunmodle.action?funModleCode=0" style=""
								class="btn btn-primary add">添加</a>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>

		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				功能信息查询结果
			</caption>
			<thead>
				<tr>
					<td>
						#
					</td>
					<td>
						功能编号
					</td>
					<td>
						功能名称
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
				<s:if test="funcList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有查询到相关功能信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="funcList" id="func" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td>
							<s:property value="funModleCode" />
						</td>
						<td>
							<s:property value="funModleName" />
						</td>
						<td>
							<s:if test='1 == state'>可以分配于角色</s:if>
							<s:if test='0 == state'>不可以分配于角色</s:if>
						</td>
						<td>
							<a class="btn btn-mini btn-primary"
								href="editToSysFunmodle.action?funModleCode=<s:property value="funModleCode"/>">
								修改 </a>
							<a class="btn btn-mini btn-primary"
								href="deleteSysFunmodle.action?funModleCode=<s:property value="funModleCode"/>">
								删除 </a>
						</td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="funcList.size() > 0">
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
