<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>学生国内外交流情况</title>

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


		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/Communicationsitu_uniqueness.js">
</script>

		<script type="text/javascript">
$(document).ready(function() {
	var flag=document.getElementById("flag").value;
	if(flag==1){
		alert("该专业在该年份已存在数据！");
		document.getElementById("flag").value=0;
		alert(document.getElementById("flag").value);
	}
})
function Numbers(e)
{
var keynum
var keychar
var numcheck

if(window.event) // IE
{
keynum = e.keyCode
}
else if(e.which) // Netscape/Firefox/Opera
{
keynum = e.which
}
keychar = String.fromCharCode(keynum)
numcheck = /\d/;
return numcheck.test(keychar)
}
//日历插件
$(function() {
	$(".datepicker").datepicker();
})
function checkNumber(e)
{   var regx = /^[1-9]\d*|0$/;
var tagValue = document.getElementById(e).value;
if (!tagValue.match(regx)) {
			alert("选项数据应为数字且非负");
			document.getElementById(e).focus();
			return false;
		}
		else {
		return true;
		}
}
//确认修改赛项
function modifyEdit() {

		if (document.getElementById("coll").value.length==0) {
			confirm("请输入学院");
			document.getElementById("coll").focus();
		}else if(document.getElementById("projCounts").value.length==0){
			alert("请输入交流项目数");
			document.getElementById("projCounts").focus();
		}else if(document.getElementById("stuCount").value.length==0){
			alert("请输入参与人生数");
			document.getElementById("stuCount").focus();
		}else if(document.getElementById("year").value.length==0){
			alert("请输入年份");
			document.getElementById("year").focus();
		}
		else if (confirm("是否修改")) {
			document.getElementById("editCommunicationsitu").submit();
		}
}

</script>

	</head>

	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业数据采集
			<b class="tip"></b>修改学生国内外交流项目信息
		</div>

		<form action="editCommunicationsitu.action?flag=0" id="editCommunicationsitu"
			method="post">

			<input type="hidden" id="flag" value="<s:property value="flag"/>" />"

			<table class="table table-striped table-bordered table-condensed">
				<caption class="t_caption">
					学生国内外交流项目情况
				</caption>
				<thead>
					<tr>
						<td colspan="99">
							学生国内外交流项目
						</td>
					</tr>
				</thead>
				<tbody>

					<tr>
						<!--<td>
							编号
							<font color="red">*</font>
						</td>

						<td>
							<s:if test="communicationsitu==null">
								<input name="communicationsitu.comNumber" id="comNumber"

									value='<s:property value="communicationsitu.comNumber"/>'
									type="text" />
							</s:if>
							<s:else>
								<s:property value="communicationsitu.comNumber" />
							</s:else>
						</td>
						--><td>
							所在学院
							<font color="red">*</font>
						</td>
						<td>
							<select name="communicationsitu.major.department.dno" id="coll"
								onchange="collchange();">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList" var="departmentvar">
									<option value="<s:property value="dno"/>"
										<s:if test="#departmentvar.dno == communicationsitu.major.department.dno">selected="selected"</s:if>>
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>

						<td>
							所在专业:
							<font color="red">*</font>
						</td>
						<td>
							<select name="communicationsitu.major.mno" id="major">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList" var="major">
									<option value="<s:property value="mno"/>"
										<s:if test="#major.mno == communicationsitu.major.mno">selected="selected"</s:if>>
										<s:property value="mname" />
									</option>
								</s:iterator>
							</select>
						</td>

					</tr>
					<tr>
						<td>
							交流项目数:
							<font color="red">*</font>
						</td>
						<td>
							<input name="communicationsitu.projCounts" onblur="return checkNumber('projCounts')" id="projCounts"
								value='<s:property value="communicationsitu.projCounts"/>'
								type="text" />
						</td>
						<td>
							参与学生人数:
							<font color="red">*</font>
						</td>
						<td>
							<input name="communicationsitu.stuCount" onblur="return checkNumber('stuCount')" id="stuCount"
								value='<s:property value="communicationsitu.stuCount"/>'
								type="text" />
						</td>

					</tr>
						<tr>

						<td>
							年份:
							<font color="red">*</font>
						</td>
						<td>
							<input name="communicationsitu.year" id="year" onkeypress="return Numbers(event)" maxlength="4"
								value='<s:property value="communicationsitu.year"/>' type="text" />
						</td>
							<td>
								备注
							</td>
							<td colspan="5">
								<input name="communicationsitu.note"
									value='<s:property value="communicationsitu.note"/>'
									type="text" />
							</td>
						</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="99">


							<a class="btn btn-primary add" href="findCommunicationsitu.action?page=<s:property value="page"/>&rows=<s:property value="rows"/>&flag=0">返回上一页</a>&nbsp;&nbsp;
							<a href="javascript:modifyEdit()" class="btn btn-primary add">保存</a>

						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</body>
</html>
