<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>专业信息</title>

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
			src="${pageContext.request.contextPath}/Scripts/ajax/MajorByDno.js">
</script>
<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/timeManage.js">
</script>
		<script type="text/javascript">
		$(document).ready(function() {
		timeManage();
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
			window.location.href = "find.action?majormodel.majorId=" + '${majormodel.majorId}'
					+ "&majormodel.departmentId=" + '${majormodel.departmentId}'
					+ "&rows=" + rows + "&page=" + page;
		}

		function setRows(rows) {
			window.location.href ="find.action?majormodel.majorId=" + '${majormodel.majorId}'
					+ "&majormodel.departmentId=" + '${majormodel.departmentId}'
					+ "&rows=" + rows.value;
		}
	</script>
	</head>

	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专家分配管理
			<b class="tip"></b>查询专业信息
		</div>
		<form action="find.action?page=1&rows=10" id="form1" name="form1"
			method="post" enctype="multipart/form-data">


			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							专业信息查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td>
							所在学院
						</td>
						<td>
							<select size="1" id="coll" name="majormodel.departmentId"
								class="department" onchange="collchange();">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList">
									<option value="<s:property value='dno'/>">
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							所在专业
						</td>
						<td colspan="3">
							<select size="1" name="majormodel.majorId" id="major">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorListfind">
									<option value="<s:property value='mno'/>">
										<s:property value="mname" />
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="6">
							<a href="javascript:findContestApply();"
								class="btn btn-primary add">查询</a>
						</td>
						<td align="center">
						<!--
						<a href="editToSysuserinfo.action?userCode=0" style=""
								class="btn btn-primary add">添加</a>
						</td>
						 -->
					</tr>
				</tfoot>
			</table>
		</form>

		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				专业信息查询结果
			</caption>
			<thead>
				<tr>
					<td>
						#
					</td>
					<td>
						学院名称
					</td>
					<td>
						专业名称
					</td>
					<td>
						操作
					</td>
				</tr>
			</thead>
			<tbody>
				<s:if test="majorList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有查询到相关专业信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="majorList" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td>
							<s:property value="department.dname" />
						</td>
						<td>
							<s:property value="mname" />
						</td>
						<td>
							<a  class="btn btn-mini btn-primary"
								href="addExpert.action?mno=<s:property value="mno"/>&trows=<s:property value="rows"/>&tpage=<s:property value="page"/>&page=1&rows=10">
								分配专家 </a>
						</td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="majorList.size() > 0">
					<tr>
						<td colspan="99">
							<s:include value="../common/paging.jsp"></s:include>
						</td>
					</tr>
					<tr>
					<td colspan="99">
						<a class="btn btn-primary add" href="addType.action">返回专业专家分配方式页面</a>&nbsp;&nbsp;
					</td>

				</tr>
				</s:if>
			</tfoot>
		</table>

	</body>
</html>
