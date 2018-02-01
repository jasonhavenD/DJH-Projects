<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>编辑课程资源信息</title>

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
	if(document.getElementById("major").value=="" || document.getElementById("year").value=="" ||document.getElementById("course").value==""){
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
</script>
	</head>

	<body onload="init();" style="background-color:#e4dfd9">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>查询课程资源信息
			<b class="tip"></b>编辑课程资源信息
		</div>

		<form action="editCurriculumresource.action" id="edit" method="post">


			<table class="table table-striped table-bordered table-condensed">
				<caption class="t_caption">
					课程资源信息编辑
				</caption>
				<thead>
					<tr>
						<td colspan="99">
							课程资源信息编辑
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td>
							课程名称
							<font color="red">*</font>
						</td>
						<td>
							<select name="cur.course.cno" id="course">
								<option value="">
									全部课程
								</option>
								<s:iterator value="courseList" var="coursevar">
									<option value="<s:property value="cno"/>"
										<s:if test="#coursevar.cno == cur.course.cno">selected="selected"</s:if>>
										<s:property value="cname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							所在学院
							<font color="red">*</font>
						</td>
						<td>
							<select name="cur.major.department.dno" id="coll"
								onchange="collchange();">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList" var="departmentvar">
									<option value="<s:property value="dno"/>"
										<s:if test="#departmentvar.dno == cur.major.department.dno">selected="selected"</s:if>>
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
							<select name="cur.major.mno" id="major">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList" var="major">
									<option value="<s:property value="mno"/>"
										<s:if test="#major.mno == cur.major.mno">selected="selected"</s:if>>
										<s:property value="mname" />
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							是否开出
							<font color="red">*</font>
						</td>
						<td>
							<select name="cur.isOpen">
								<option value="Y"
									<s:if test="'Y'==cur.isOpen">selected="selected"</s:if>>
									是
								</option>
								<option value="N"
									<s:if test="'N'==cur.isOpen">selected="selected"</s:if>>
									否
								</option>
							</select>
						</td>
						<td style="width: 60px;">
							是否优质课程
							<font color="red">*</font>
						</td>
						<td>
							<select name="cur.isExcellent">
								<option value="Y"
									<s:if test="'Y'==cur.isExcellent">selected="selected"</s:if>>
									是
								</option>
								<option value="N"
									<s:if test="'N'==cur.isExcellent">selected="selected"</s:if>>
									否
								</option>
							</select>
						</td>
						<td style="width: 60px;">
							课程规划
						</td>
						<td>
							<input type="text" name="cur.coursePlann"
								value='<s:property value="cur.coursePlann" />' />
						</td>

					</tr>
					<tr>
					
						<td style="width: 60px;">
							年份
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="cur.year" id="year" maxlength="4"
								value='<s:property value="cur.year" />' onblur="return checkNumber('year')"
								/>
						</td>
						<td>
							备注
						</td>
						<td colspan="3">
							<input type="text" name="cur.note"
								value='<s:property value="cur.note" />' />
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
