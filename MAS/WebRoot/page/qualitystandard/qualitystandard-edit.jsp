<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>编辑质量标准建设信息</title>

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
		<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/ajax/MajorByDno.js">
</script>
		<script type="text/javascript">
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
numcheck = /\d/
return numcheck.test(keychar)
}
function modifyEdit() {

	var b=document.getElementById("allCount").value;
	var a=document.getElementById("completeCount").value;
	if(parseInt(a)>parseInt(b)){
		confirm("完成数不能大于总数");
	}else if(document.getElementById("major").value=="" ||document.getElementById("allCount").value=="" ||document.getElementById("completeCount").value==""){
		confirm("*选项不能为空");
	}else{
		if (confirm("是否保存")) {
			document.getElementById("edit").submit();
		}
	}
}
$(document).ready(
		function() {

			$(".college").change(
					function() {
						$('#major option').remove();

						$.ajax( {
							type : "POST",
							url : 'findByCollegeIdListMajor.action',
							data : 'collegeId=' + $(this).val(),
							success : function(jsonArray) {

								var json = eval("(" + jsonArray + ")")
								var porHtml = "";
								for ( var i = 0; i < json.length; i++) {
									porHtml += "<option value="
											+ json[i].majorId + " >"
											+ json[i].majorName + "</option>";
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

</script>
</head>

	<body style="background-color:#e4dfd9"  onload="init();">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>查询质量标准建设信息
			<b class="tip"></b>编辑质量标准建设信息
		</div>

		<form action="editQualitystandard.action"
			id="edit" method="post">


			<table class="table table-striped table-bordered table-condensed">
				<caption class="t_caption">
					质量标准建设信息编辑
				</caption>
				<thead>
					<tr>
						<td colspan="99">
							质量标准建设信息编辑
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td>
							所在学院
							<font color="red">*</font>
						</td>
						<td>
							<select name="quastan.major.department.dno" id="coll" onchange="collchange();">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList" var="departmentvar">
									<option value="<s:property value="dno"/>"
										<s:if test="#departmentvar.dno == quastan.major.department.dno">selected="selected"</s:if>>
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							所在专业
							<font color="red">*</font>
						</td>
						<td>
							<select name="quastan.major.mno" id="major">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList" var="major">
									<option value="<s:property value="mno"/>"
										<s:if test="#major.mno == quastan.major.mno">selected="selected"</s:if>>
										<s:property value="mname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width: 60px;">
							总数
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="quastan.allCount"	id="allCount" onkeypress="return Numbers(event)"
								value='<s:property value="quastan.allCount" />' />
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							完成数
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="quastan.completeCount" id="completeCount" onkeypress="return Numbers(event)"
								value='<s:property value="quastan.completeCount" />' />
						</td>
						<td>
							备注
						</td>
						<td colspan="3">
							<input type="text" name="quastan.note"
								value='<s:property value="quastan.note" />' />
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
