<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>编辑课程信息</title>

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
			src="${pageContext.request.contextPath}/Scripts/ajax/course_uniqueness.js">
</script>

		<!--<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/ajax/DnameByDno.js"></script>

-->
		<script type="text/javascript">
function modifyEdit() {
	if (document.getElementById("courseNoError").innerHTML == "课程编号已存在") {
		alert("请完善课程信息");
	} else {
		if (document.getElementById("courseNo").value != "") {
			if (document.getElementById("cname").value != "") {
				if (confirm("是否保存")) {
					document.getElementById("editCourse").submit();
				}
			} else {
				document.getElementById("cnameErroe").innerHTML = "课程名称不能为空";
				document.getElementById("cnameErroe").style.color = "red";
				alert("请输入课程名称");
			}
		} else {
			alert("请输入课程编号");
		}
	}
}
</script>
	</head>

	<body onload="init();"style="background-color:#e4dfd9">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>查询课程信息信息
			<b class="tip"></b>编辑课程信息信息
		</div>

		<form action="editCourse.action" id="editCourse" method="post">


			<table class="table table-striped table-bordered table-condensed">
				<caption class="h_caption">
					课程信息编辑
				</caption>
				<thead>
					<tr>
						<td colspan="99">
							课程信息编辑
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td style="width: 60px;">
							课程编号
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="course.cno" onblur="couserblur();"
								id="courseNo" value="<s:property value='course.cno' />" />
							<span id="courseNoError"></span>
						</td>
						<td style="width: 60px;">
							课程名称
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" id="cname" name="course.cname"
								value='<s:property value="course.cname"/>' />
							<span id="cnameErroe"></span>
						</td>
						<td style="width: 60px;">
							课程类别
						</td>
						<td>
							<select size="1" name="course.ctype" id="ctype">
								<option value="其他">
									其他
								</option>
								<option value="专业课"
									<s:if test=' "专业课" == course.ctype'>selected="selected"</s:if>>
									专业课
								</option>
								<option value="公共选修课"
									<s:if test=' "公共选修课" == course.ctype'>selected="selected"</s:if>>
									公共选修课
								</option>
								<option value="公共必修课"
									<s:if test=' "公共必修课" == course.ctype'>selected="selected"</s:if>>
									公共必修课
								</option>
								<option value="学科基础课"
									<s:if test=' "学科基础课" == course.ctype'>selected="selected"</s:if>>
									学科基础课
								</option>
								<option value="学科大类基础课"
									<s:if test=' "学科大类基础课" == course.ctype'>selected="selected"</s:if>>
									学科大类基础课
								</option>
								<option value="实践教学环节"
									<s:if test=' "实践教学环节" == course.ctype'>selected="selected"</s:if>>
									实践教学环节
								</option>
							</select>
							<span id="testModeError"></span>
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							开课学院
							<font color="red">*</font>
						</td>
						<td>
							<select size="1" name="course.department.dno" class="department"
								id="dno">
								<s:iterator value="departmentList" var="departmentvar">
									<option value="<s:property value='dno'/>"
										<s:if test="#departmentvar.dno == course.department.dno">selected="selected"</s:if>>
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
							<span id="dnoError"></span>
						</td>
						<td style="width: 60px; text-align: right;">
							是否双语授课
						</td>
						<td>
							<select size="1" id="isDouble"
								name="course.isDoubleLanguageTeach">
								<option value="是"
									<s:if test=' "是" == course.isDoubleLanguageTeach'>selected="selected"</s:if>>
									是
								</option>
								<option value="否"
									<s:if test=' "否" == course.isDoubleLanguageTeach'>selected="selected"</s:if>>
									否
								</option>
							</select>
						</td>
						<td style="width: 60px;">
							考核方式
						</td>
						<td>
							<select size="1" name="course.testMode" id="testMode">
								<option value="考查"
									<s:if test=' "考查" == course.testMode'>selected="selected"</s:if>>
									考查
								</option>
								<option value="考试"
									<s:if test=' "考试" == course.testMode'>selected="selected"</s:if>>
									考试
								</option>

								<option value="未知"
									<s:if test=' "未知"" == course.testMode'>selected="selected"</s:if>>
									未知
								</option>
								<span id="testModeError"></span>
						</td>
					</tr>
					<tr>

						<td style="width: 60px;">
							学时
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="course.courseHours" id="courseHours"
								value='<s:property value="course.courseHours"/>' />
							<span id="courseHoursErroe"></span>
						</td>
						<td style="width: 60px;">
							学分
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="course.credit" id="credit"
								value='<s:property value="course.credit"/>' />

						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							方案版本
						</td>
						<td colspan="5">
							<textarea rows="5" cols="99" name="course.version">${request.course.version}</textarea>
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
