<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>项目评估所需指标信息</title>

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
			src="${pageContext.request.contextPath}/Scripts/observer.js">
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
});
//查询
function findContestApply() {
	var tname = $("#tname").val();
	tname = encodeURI(tname);
	tname = encodeURI(tname);
	var pname =$("#pName").val();
	pname = encodeURI(pname);
	pname = encodeURI(pname);
	var Id =$("#targetId").val();
	window.location.href = "findassneed.action?basemodel.id="
			+ Id + "&basemodel.name=" + tname + "&basemodel.year=" + pname + "&rows=10"
			+ "&page=1";
}
function addAllTarget(){
	if(confirm("添加所有指标需要一段时间，是否要继续？")){
		window.location.href ="addAllAssNeedTarget.action";
	}
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
	var tname = "" + '${basemodel.name}';
	tname = encodeURI(tname);
	tname = encodeURI(tname);
	var pname ="" + '${basemodel.year}';
	pname = encodeURI(pname);
	pname = encodeURI(pname);
	window.location.href = "findassneed.action?basemodel.id="
			+ '${basemodel.id}'+ "&basemodel.name=" + tname + "&basemodel.year=" + pname+ "&rows=" + rows
			+ "&page=" + page;
}
$(document).ready(function() {
	// ------------------------------	
		//角色判断
		
		var rol = $("#rol").val();
		var totalRows = $("#totalRows").val();
		
		if (rol == 2 || rol == 3 || rol == 4 || rol == 6) {
			$("#attach").hide();//隐藏导入
			$("#add").hide();//隐藏导入
			for ( var i = 0; i < totalRows; i++) {
				$(".edit").hide();
				$(".del").hide();
			}
		}
	});
function setRows(rows) {
	var tname = "" + '${basemodel.name}';
	tname = encodeURI(tname);
	tname = encodeURI(tname);
	var pname ="" + '${basemodel.year}';
	pname = encodeURI(pname);
	pname = encodeURI(pname);
	window.location.href = "findassneed.action?basemodel.id="
			+ '${basemodel.id}'+ "&basemodel.name=" + tname + "&basemodel.year=" + pname+ "&rows="
			+ rows.value;
}
</script>

	</head>

	<body style="background-color:#e4dfd9">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>项目评估所需指标信息
			<b class="tip"></b>查询项目评估所需指标信息
		</div>

		<form action="findassneed.action?page=1&rows=10" id="form1"
			name="form1" method="post" enctype="multipart/form-data">

			<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							项目评估所需指标信息
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 60px;">
							开启评估项目名称
						</td>
						<td>
							<select size="1" name="basemodel.year" id="pName">
								<s:iterator value="aprojectList">
									<option value="<s:property value='masprojectName'/>">
										<s:property value="masprojectName" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width: 60px;">
							指标编号
						</td>
						<td>
							<input name="basemodel.Id" id="targetId" type="text" />
						</td>
						<td style="width: 60px;">
							指标名称
						</td>
						<td>
							<input name="basemodel.Name" id="tname" type="text" />
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td>
							<a href="javascript:findContestApply();"
								class="btn btn-primary add">查询</a>&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
						<td>
							<span id="add"><a
								href="editToAssneed.action?assessingNeedTargetNo=0" style=""
								class="btn btn-primary add">添加</a>
							</span>
						</td>
						<td colspan="2">
							<a href="initTargetMind.action" class="btn btn-primary add">查看专业指标体系图</a>
						</td>
						<td colspan="2">
							<a href="javascript:addAllTarget();" class="btn btn-primary add">一键添加所有指标</a>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>

		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				项目评估所需指标信息列表
			</caption>
			<thead>
				<tr>
					<td>
						#
					</td>
					<td>
						开启评估项目名称
					</td>
					<td>
						指标编号
					</td>
					<td>
						指标名称
					</td>
					<td>
						指标权重
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
				<s:if test="assneedList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有查询到相关信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="assneedList" id="assneed" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td>
							<s:property value="assessingproject.masprojectName" />
						</td>
						<td>
							<s:property value="appraisalsystem.indicatorId" />
						</td>
						<td>
							<s:property value="appraisalsystem.indicatorName" />
						</td>
						<td>
							<s:property value="indicatorWeight" />
						</td>
						<td>
							<s:set name="status" value="status"></s:set>
							<s:if test='0==status'>不可用</s:if>
							<s:else>可用</s:else>
						</td>
						<td>
							<span class="edit"> <a class="btn btn-mini btn-primary"
								href="editToAssneed.action?assessingNeedTargetNo=<s:property value="assessingNeedTargetNo"/>">
									修改 </a> </span>
							<span class="del"> <a class="btn btn-mini btn-primary"
								href="deleteassneed.action?assessingNeedTargetNo=<s:property value="assessingNeedTargetNo"/>">
									删除 </a> </span>
						</td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="assneedList.size() > 0">
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
