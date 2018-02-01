<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
			src="${pageContext.request.contextPath}/Scripts/textarea.js">
</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/tip.js">
</script>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
		<script type="text/javascript">

function modifyEdit() {
	if (document.getElementById("masprojectNo").value == ""
			|| document.getElementById("indicatorId").value == ""
			|| document.getElementById("indicatorWeight").value == ""|| document.getElementById("status").value == "") {
		confirm("*选项不能为空");
	} else {
		if (confirm("是否保存")) {
			document.getElementById("edit").submit();
		}
	}
}
</script>
	</head>

	<body onload="init();" style="background-color:#e4dfd9">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>查询项目评估所需指标信息
			<b class="tip"></b>编辑项目评估所需指标信息
		</div>

		<form action="editAssneed.action" id="edit" method="post">


			<table class="table table-striped table-bordered table-condensed">
				<caption class="t_caption">
					项目评估所需指标信息编辑
				</caption>
				<thead>
					<tr>
						<td colspan="99">
							项目评估所需指标编辑
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						 <td>
							开启评估项目名称
							<font color="red">*</font>
						</td>
						<td>
							<select size="1" id="masprojectNo" name="assneed.assessingproject.masprojectNo">
								<option value="">
									--选择--
								</option>
								<s:iterator value="aprojectList" var="aprnamevar">
									<option value="<s:property value='masprojectNo'/>"
										<s:if test="#aprnamevar.masprojectNo == assneed.assessingproject.masprojectNo">selected="selected"</s:if>>
										<s:property value="masprojectName" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width: 60px;">
							指标名称
							<font color="red">*</font>
						</td>
						<td>
							<select size="1" id="indicatorId" name="assneed.appraisalsystem.indicatorId">
								<option value="">
									--选择--
								</option>
								<s:iterator value="appList" var="appnamevar">
									<option value="<s:property value='indicatorId'/>"
										<s:if test="#appnamevar.indicatorId == assneed.appraisalsystem.indicatorId">selected="selected"</s:if>>
										<s:property value="indicatorName" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							指标权重
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="assneed.indicatorWeight" id="indicatorWeight"
								value='<s:property value="assneed.indicatorWeight" />' />
						</td>
					</tr>
					<tr>
						<td>
							状态
							<font color="red">*</font>
						</td>
						<td colspan="5">
							<select name="assneed.status" id="status">
							<option value="">
									--选择--
								</option>
								<option value="0"
									<s:if test=" 0 == assneed.status">selected="selected"</s:if>>
									不可用
								</option>
								<option value="1"
									<s:if test="1 == assneed.status">selected="selected"</s:if>>
									可用
								</option>
							</select>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="99">
							<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
							<a class="btn btn-primary add" href="javascript:modifyEdit()">保存</a>&nbsp;&nbsp;
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</body>
</html>
