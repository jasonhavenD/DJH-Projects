<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>评估项目基本信息</title>

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

})

$(document).ready(function() {
	// ------------------------------	     
		$(".college").change(
				function() {

					$('#major option').remove();

					$.ajax( {
						type : "POST",
						url : 'findByCollegeIdListMajorStu.action',
						data : 'collegeId=' + $(this).val(),
						success : function(jsonArray) {

							var json = eval("(" + jsonArray + ")")
							var porHtml = "<option value=''>全部专业</option>";
							for ( var i = 0; i < json.length; i++) {
								porHtml += "<option value=" + json[i].majorId
										+ " >" + json[i].majorName
										+ "</option>";
							}
							$("#major").append(porHtml);
						},
						error : function(XMLHttpRequest, textStatus,
								errorThrown) {
							alert('通信失败:' + errorThrown);
						}
					});
				});
	});

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
	var tname = "" + '${basemodel.name}';
	tname = encodeURI(tname);
	tname = encodeURI(tname);
	window.location.href = "findAproject.action?basemodel.name=" + tname
			+ "&rows=" + rows + "&page=" + page;
}
$(document).ready(function() {
	// ------------------------------	
		//角色判断
		var rol = $("#rol").val();
		var totalRows = $("#totalRows").val();
		if (rol == 2 || rol == 3 || rol == 4) {
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
	window.location.href = "findAproject.action?basemodel.name=" + tname
			+ "&rows=" + rows.value;
}
</script>

	</head>

	<body style="background-color:#e4dfd9">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>评估项目基本信息
			<b class="tip"></b>查询评估项目基本信息
		</div>

		<form action="findAproject.action?page=1&rows=10" id="form1"
			name="form1" method="post" enctype="multipart/form-data">

			<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							评估项目基本信息
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 60px;">
							开启评估项目名称
						</td>
						<td>
							<input name="basemodel.Name" type="text" />
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="5">
							<a href="javascript:findContestApply();"
								class="btn btn-primary add">查询</a>&nbsp;&nbsp;
							<span class="edit"> <a id="add"
								href="editToAproject.action?masprojectNo=0" style=""
								class="btn btn-primary add">添加</a> </span>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>

		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				评估项目基本信息列表
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
						评估开启时间
					</td>
					<td>
						评估结束时间
					</td>
					<td>
						评估说明
					</td>
					<td>
						操作
					</td>
				</tr>
			</thead>
			<tbody>
				<s:if test="aprojectList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有查询到相关信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="aprojectList" id="aproject" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td>
							<s:property value="masprojectName" />
						</td>
						<td>
							<fmt:formatDate pattern="yyyy-MM-dd"
								value="${masprojectOpenDate}" />
						</td>
						<td>
							<fmt:formatDate pattern="yyyy-MM-dd" value="${masprojectEndDate}" />
						</td>
						<td>
							<s:property value="assessingExplation" />
						</td>
						<td>
							<span class="edit"> <a class="btn btn-mini btn-primary"
								href="editToAproject.action?masprojectNo=<s:property value="masprojectNo"/>">
									修改 </a> </span>
							<span class="del">  <a class="btn btn-mini btn-primary"
								href="deleteAproject.action?masprojectNo=<s:property value="masprojectNo"/>">
								删除 </a></span> 

							</span>
							<s:if test="0==tag">

								<%--<span> <a class="btn btn-mini btn-primary"
									href="openAproject.action?masprojectNo=<s:property value="masprojectNo"/>">开启
								</a>
								</span>

							--%></s:if>
							<s:else>

								<span class = "edit"> <a class="btn btn-mini btn-primary"
									href="closeAproject.action?masprojectNo=<s:property value="masprojectNo"/>">关闭</a>
								</span>

							</s:else>
						</td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="aprojectList.size() > 0">
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
