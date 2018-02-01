<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>指标信息</title>

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
			src="${pageContext.request.contextPath}/Scripts/ajax/UserMajorByDno.js">
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
// ------------------------------	
		//角色判断
		var rol = $("#rol").val();
		var totalRows = $("#totalRows").val();
		if (rol == 6) {
			for ( var i = 0; i < totalRows; i++) {
				$(".edit").hide();
				$(".del").hide();
				$(add).hide();
			}
		}
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
	window.location.href = "find.action?basemodel.id=" + '${basemodel.id}'
			+ "&basemodel.name=" + '${basemodel.name}' 
			+ "&rows=" + rows + "&page=" + page;
}

function setRows(rows) {
	window.location.href ="find.action?basemodel.id=" + '${basemodel.id}'
			+ "&basemodel.name=" + '${basemodel.name}' 
			+ "&rows=" + rows.value;
}
</script>
	</head>

	<body style="background-color:#e4dfd9">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>评估指标列表
			<b class="tip"></b>查询指标信息
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
							指标信息查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td>
							指标类型
						</td>
						<td>
							<select name="basemodel.Id">
								<option value="">
									--选择--
								</option>
								<option value="1">
									定量指标
								</option>
								<option value="0">
									定性指标
								</option>
							</select>
						</td>
						<td>
							指标名
						</td>
						<td colspan="3">
							<input name="basemodel.Name" type="text"/>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="5">
							<a href="javascript:findContestApply();"
								class="btn btn-primary add">查询</a>
						</td>
						<td align="center" id = "add">
							<a href="editToTarget.action?indicatorId=0" style=""
								class="btn btn-primary add">添加</a>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>

		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				指标信息查询结果
			</caption>
			<thead>
				<tr>
					<td>
						#
					</td>
					<td>
						指标编号
					</td>
					<td>
						指标名
					</td>
					<td>
						指标描述
					</td>
					<td>
						指标类型
					</td>
					<td>
						操作
					</td>
				</tr>
			</thead>
			<tbody>
				<s:if test="appList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有查询到相关用户信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="appList" id="app" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td>
							<s:property value="indicatorId" />
						</td>
						<td>
							<s:property value="indicatorName" />
						</td>
						<td>
							<s:property value="indNameExp" />
						</td>
						<td>
							<s:if test='1 == type'>定量指标</s:if>
							<s:if test='0 == type'>定性指标</s:if>
						</td>
						<td>
						
				
						
						<span class="edit"> <a class="btn btn-mini btn-primary"
								href="editToTarget.action?indicatorId=<s:property value="indicatorId"/>">
								修改 </a> </span>
							<span class="del"> <a class="btn btn-mini btn-primary"
								href="deleteTarget.action?indicatorId=<s:property value="indicatorId"/>">
								删除 </a> </span>
						
						
						<!--  
							<a class="btn btn-mini btn-primary"
								href="editToTarget.action?indicatorId=<s:property value="indicatorId"/>">
								修改 </a>
							<a class="btn btn-mini btn-primary"
								href="deleteTarget.action?indicatorId=<s:property value="indicatorId"/>">
								删除 </a>
						-->
						</td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="appList.size() > 0">
					<tr>
						<td colspan="99">
							<s:include value="../common/paging.jsp"></s:include>
						</td>
					</tr>
				</s:if>
			</tfoot>
		</table>

	</body>
</html>
