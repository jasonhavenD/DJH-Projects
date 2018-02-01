<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>教学经费修改</title>

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
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/MajorByDno.js">
</script>


		<script type="text/javascript">
//日历插件
$(function() {
	$(".datepicker").datepicker();
})

function Numbers(e) {
	var keynum
	var keychar
	var numcheck

	if (window.event) // IE
	{
		keynum = e.keyCode
	} else if (e.which) // Netscape/Firefox/Opera
	{
		keynum = e.which
	}
	keychar = String.fromCharCode(keynum)
	numcheck = /\d/
	return numcheck.test(keychar)
}

//确认修改教学经费
function modifyEditTeachingcost() {
	var regx = /^\d+(?:\.\d{0,4})?$/;

	if (document.getElementById("coll").value.length == 0) {
		alert("学院不能为空");
		document.getElementById("coll").focus();
	} else if (document.getElementById("year").value.length == 0) {
		alert("年份不能为空");
		document.getElementById("year").focus();
	} else if (!document.getElementById("year").value.match(regx)||document.getElementById("year").value.length != 4) {
		alert("年份格式错误，注意为数字");
		document.getElementById("year").focus();
	} else if (document.getElementById("cost").value.length == 0) {
		alert("教学经费不能为空");
		document.getElementById("cost").focus();
	} else if (!document.getElementById("cost").value.match(regx)) {
		alert("教学经费格式错误，注意为数字");
		document.getElementById("cost").focus();
	} else if (confirm("是否修改教学经费信息")) {
		document.getElementById("editTeachingcost").submit();
	}
}
</script>

	</head>

	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业数据采集
			<b class="tip"></b>修改教学经费信息
		</div>

		<form action="editTeachingcost.action" id="editTeachingcost" method="post">



			<table class="table table-striped table-bordered table-condensed">
				<caption class="t_caption">教学经费修改</caption>
				<thead>
					<tr>
						<td colspan="99">
							教学经费修改
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<s:if test='teachingcost!=null'>
						<td style="width: 60px;">
							教学经费编号:
							<font color="FF0000">*</font>
						</td>
						<td >

								<input name="teachingcost.costNumber"  id="costNumber" readonly="readonly" type="text" value='<s:property value="teachingcost.costNumber" />' />

						</td>
						</s:if>

						<td style="width: 60px;">
							使用类型:
							<font color="FF0000">*</font>
						</td>
						<td>
							<select size="1" id="teachCostTypeNo" name="teachingcost.teachingcosttype.teachCostTypeNo">
								<s:iterator value="ttList" var="L" >
									<option value="<s:property value='teachCostTypeNo'/>"
										<s:if test="#L.teachCostTypeNo == teachingcost.teachingcosttype.teachCostTypeNo">selected="selected"</s:if>>
										<s:property value="useType"/>
									</option>
								</s:iterator>
							</select>

						</td>
						<td style="width: 60px;">
							年份：
							<font color="red">*</font>
						</td>
						<td>
							<input name="teachingcost.year" type="text" id="year"  onkeypress="return Numbers(event)"
							value='<s:property value="teachingcost.year"/>' />
						</td>
						</tr>
						<tr>

					<td>
							所在学院：
							<font color="red">*</font>
						</td>
						<td>
							<select name="teachingcost.major.department.dno" id="coll" onchange="collchange();">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList" var="departmentvar">
									<option value="<s:property value="dno"/>"
										<s:if test="#departmentvar.dno == teachingcost.major.department.dno">selected="selected"</s:if>>
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>

					<td>
							所在专业：
							<font color="red">*</font>
						</td>
						<td colspan="3">
							<select name="teachingcost.major.mno" id="major">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList" var="major">
									<option value="<s:property value="mno"/>"
										<s:if test="#major.mno == teachingcost.major.mno">selected="selected"</s:if>>
										<s:property value="mname" />
									</option>
								</s:iterator>
							</select>
						</td>


					</tr>
						<tr>
						<td style="width: 60px;">
							教学经费：
							<font color="red">*</font>
						</td>
						<td>
							<input name="teachingcost.cost" type="text" id="cost" value='<s:property value="teachingcost.cost" />' />
							<!--<span id="costError" style="color:red">(单位：万元)</span>-->
						<td>
							经费用途：
						</td>
						<td colspan="3">
							<input name="teachingcost.useness" type="text" value='<s:property value="teachingcost.useness" />' />
						</td>


					</tr>

				</tbody>
				<tfoot>
					<tr>
						<td colspan="99">

								<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
								<a href="javascript:modifyEditTeachingcost()"
								class="btn btn-primary add">保存</a>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</body >
</html>
