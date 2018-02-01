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
			window.location.href = "searchAdvice.action?rows=" + rows
			+ "&page=" + page;
			//alert("findExperts.action?rows=" + rows + "&page=" + page);
		}

		function setRows(rows) {
			var name = ""+'${basemodel.name}';
			name = encodeURI(name);
			name = encodeURI(name);
			window.location.href = "searchAdvice.action?rows=" + rows.value;
		}
	</script>
	</head>
	<style>

.test_box {
    width: 600px;
    min-height: 40px;
    max-height: 200px;
    _height: 120px;
    padding: 3px;
    outline: 0;
    border: 1px solid #a0b3d6;
    font-size: 14px;
    word-wrap: break-word;
    overflow-x: hidden;
    overflow-y: auto;
    _overflow-y: visible;
    line-height:16px;
    text-align:justify;
    border:0px;
}
</style>

	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>定性数据处理
			<b class="tip"></b>专家建议
		</div>

	   <!-- 专家建议查询 -->
	   <form action="searchAdvice.action?page=1&rows=10" id="form1" name="form1"
			method="post" enctype="multipart/form-data">
		<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							专家建议查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td style="width: 60px;">
							专业名称
						</td>
						<td>
					       <select size="1" name="mno" id="major">
								<s:iterator value="majorList">
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
						<td colspan="4"><!--
							<a class="btn btn-primary add" href="findExperts.action?mno=<s:property value="major.mno"/>&trows=<s:property value="rows"/>&tpage=<s:property value="page"/>&page=1&rows=10">
								查询</a>&nbsp;&nbsp;

						--><a href=""
								class="btn btn-primary add">查询</a>&nbsp;&nbsp;
					   </td>

					</tr>
				</tfoot>
			</table>
</form>
		<table width=100% border="1" style="table-layout:fixed;" class="table table-striped table-bordered "  >
			<caption class="t_caption">
				专家提出的问题与建议
			</caption>
			<thead>
				<tr>
					<td style="width: 60px;">
						#
					</td>
     				<td style="width: 160px;">
						专业名称
					</td>
					<td style="width: 100px;">
						专家
					</td>
					<td style="width: 600px;">
						问题
					</td>
					<td style="width: 600px;">
						建议
					</td>
				</tr>
			</thead>

			<tbody>
						<tr>
							<td colspan="99" style="text-align: center;">没有查询到信息！</td>
						</tr>

		</tbody>
	</body>
</html>
