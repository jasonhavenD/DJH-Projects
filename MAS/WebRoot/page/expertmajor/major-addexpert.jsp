<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>专业分配专家</title>

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
			var name = ""+'${basemodel.name}';
			name = encodeURI(name);
			name = encodeURI(name);
			window.location.href = "findExpert.action?rows=" + rows
			+ "&page=" + page
			+ "&basemodel.id=" + '${basemodel.id}'
			+ "&basemodel.name=" + name
			+ "&basemodel.year=" + '${basemodel.year}';
		}

		function setRows(rows) {
			var name = ""+'${basemodel.name}';
			name = encodeURI(name);
			name = encodeURI(name);
			window.location.href = "findExpert.action?rows=" + rows.value
			+ "&basemodel.id=" + '${basemodel.id}'
			+ "&basemodel.name=" + name
			+ "&basemodel.year=" + '${basemodel.year}';
		}
</script>
	</head>
	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专家列表
			<b class="tip"></b>分配专家
		</div>
		<form action="findExpert.action?page=1&rows=10" id="form1" name="form1"
			method="post" enctype="multipart/form-data">
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							专家信息查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td>
							专家编号
						</td>
						<td>
							<input name="basemodel.Id" value="<s:property value='basemodel.Id' />" type="text"/>
						</td>
						<td>
							专家名
						</td>
						<td>
							<input name="basemodel.Name" value="<s:property value='basemodel.Name' />" type="text"/>
						</td>
						<td>
							是否已经分配给专业
						</td>
						<td>
							<select size="1" name="basemodel.year" id="year">
								<option value="">
									--选择--
								</option>
								<option value="0"
									<s:if test="'0'==basemodel.year">selected="selected"</s:if>>
									是
								</option>
								<option value="否"
									<s:if test="'1'==basemodel.year">selected="selected"</s:if>>
									否
								</option>
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
					</tr>
				</tfoot>
			</table>
		</form>
		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				专家列表
			</caption>
			<thead>
				<tr>
					<td>
						#
					</td>
					<td>
						专家编号
					</td>
					<td>
						专家名
					</td>
					<td>
						是否已分配给该专业
					</td>
					<td>
						操作
					</td>
				</tr>
			</thead>
			<tbody>
				<s:if test="expertmajorList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="expertmajorList" id="expertmajor" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td>
							<s:property value="Id" />
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
									href="deleteExpertmajor.action?expertMajorCode=<s:property value="majorId"/>"
									id="delete">取消 </a>
							</td>
						</s:if>
						<s:else>
							<td>
								否
							</td>
							<td>
								<a class="btn btn-mini btn-primary"
									href="editExpertmajor.action?mno=<s:property value="mno"/>&expertCode=<s:property value="Id"/>"
									id="add">分配 </a>
							</td>
						</s:else>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="expertmajorList.size()> 0">
					<tr>
						<td colspan="99">
							<s:include value="../common/paging.jsp"></s:include>
						</td>
					</tr>
				</s:if>
				<tr>
					<td colspan="99">
						<a class="btn btn-primary add" href="find.action?rows=<s:property value="trows" />&page=<s:property value="tpage" />">返回上一页</a>&nbsp;&nbsp;
					</td>

				</tr>
			</tfoot>
		</table>
	</body>
</html>
