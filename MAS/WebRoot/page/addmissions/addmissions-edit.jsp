<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>编辑招生情况信息</title>

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
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/MajorByDno.js">
</script>
		<script type="text/javascript">
function modifyEdit() {
	if(document.getElementById("major").value=="" || document.getElementById("year").value=="" ||document.getElementById("hotDeggree").value=="" ||document.getElementById("firstChoice").value==""){
		confirm("*选项不能为空");
	}else{
		if (confirm("是否修改")) {
			document.getElementById("edit").submit();
		}
	}
}
function checkNumber(e)
{   var regx = /\d$/;
	var tagValue = document.getElementById(e).value;
	if (!tagValue.match(regx)) {
			alert("年份数据类型应为数字");
			document.getElementById(e).focus();
			return false;
		}
		else {
		return true;
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

	<body onload="init();"style="background-color:#e4dfd9">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>查询招生情况信息
			<b class="tip"></b>编辑招生情况信息
		</div>

		<form action="editAddmissions.action" id="edit" method="post">


			<table class="table table-striped table-bordered table-condensed">
				<caption class="t_caption">
					招生情况信息编辑
				</caption>
				<thead>
					<tr>
						<td colspan="99">
							招生情况信息编辑
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
							<select name="adm.major.department.dno" id="coll"
								onchange="collchange();">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList" var="departmentvar">
									<option value="<s:property value="dno"/>"
										<s:if test="#departmentvar.dno == adm.major.department.dno">selected="selected"</s:if>>
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
							<select name="adm.major.mno" id="major">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList" var="major">
									<option value="<s:property value="mno"/>"
										<s:if test="#major.mno == adm.major.mno">selected="selected"</s:if>>
										<s:property value="mname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width: 60px;">
							年份
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="adm.addmYear" id="year" maxlength="4"
								value='<s:property value="adm.addmYear" />' onblur="return checkNumber('year')"/>
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							计划人数
						</td>
						<td>
							<input type="text" name="adm.expectCount" id="expectCount"
								onkeypress="return Numbers(event)"
								value='<s:property value="adm.expectCount" />' />
						</td>
						<td style="width: 60px;">
							招生人数
						</td>
						<td>
							<input type="text" name="adm.addmCount"
								onkeypress="return Numbers(event)"
								value='<s:property value="adm.addmCount" />' />
						</td>
						<td style="width: 60px;">
							专业第一志愿率
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="adm.firstChoice" id="firstChoice"
								value='<s:property value="adm.firstChoice" />' />
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							入学平均分
						</td>
						<td>
							<input type="text" name="adm.entranceEverage"
								value='<s:property value="adm.entranceEverage" />' />
						</td>
						<td style="width: 60px;">
							专业报考热门度
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="adm.hotDeggree" id="hotDeggree"
								value='<s:property value="adm.hotDeggree" />' />
						</td>
						<td>
							备注
						</td>
						<td>
							<input type="text" name="adm.note"
								value='<s:property value="adm.note" />' />
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
