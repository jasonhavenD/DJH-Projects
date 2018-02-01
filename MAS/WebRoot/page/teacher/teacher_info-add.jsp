<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>职工信息添加</title>
<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/jquery-1.7.2.js">
</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/jquery-ui-1.8.22.custom.min.js">
</script>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/admin-all.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/other.css" />

		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/textarea.js">
</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/tip.js">
</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/cal.js">

</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/MajorByDno.js">
</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/tno_uniqueness.js">
</script>

		<script type="text/javascript">
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
//日历插件
$(function() {
	$(".datepicker").datepicker();
})
function modifyEdit() {
	if (document.getElementById("teacherNumberError").innerHTML == "教工号可用"
			&& checkNull('teacher.tname', 'teacherNameError')
			&& checkNull('sex', 'sexError')
			&& checkNull('cType', 'cTypeError')
			&& checkNull('teacher.degree.degreeNo', 'degreeError')
			&& checkNull('teacher.academicdegree.bestDegreeNo',
					'bestdegreeError')
			&& checkNull('coll', 'collError')
			&& checkNull('major', 'majorError')
			&& checkNull('teacher.jobtype.jobTypeNo', 'jobTypeError')
			&& checkNull('teacher.teacherscategory.teachersCategoryNo',
					'teachersCategoryNoError')) {

		if (confirm("是否修改")) {
			document.getElementById("addTeacher").submit();
		}
	} else {
		alert("信息未填写完善");
	}
}

function checkNull(tagName, tagErrorName) {
	var tagValue = document.getElementById(tagName).value;

	if (tagValue.length == 0) {
		document.getElementById(tagErrorName).innerHTML = "该选项不能为空";
		document.getElementById(tagErrorName).style.color = "red";
		return false;
	} else {
		document.getElementById(tagErrorName).innerHTML = "已填写";
		document.getElementById(tagErrorName).style.color = "green";
		return true;
	}
}

/*//验证输入日期
 function checkBirth() {
 var datestring = document.getElementById("sdate").value;

 var re = /^(\d{4}-\d{1,2}-\d{1,2})(\s?\d{2}:\d{2}:\d{2})?$/;
 //var regx=/(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)/;
 alert(datestring.toString());
 alert("校验："+datestring.toString().match(re));
 if (!datestring.match(re)) {
 document.getElementById("sdateError").innerHTML = "日期格式不正确！";
 document.getElementById("sdateError").setAttribute("style",
 "font-size:12px;color:red;");
 return false;
 } else {
 document.getElementById("sdateError").innerHTML = "日期格式正确！";
 document.getElementById("sdateError").setAttribute("style",
 "font-size:12px;color:green;");
 return true;
 }
 }*/
</script>

	</head>

	<body style="background-color:#e4dfd9"  onload="init();">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>查询教师信息
			<b class="tip"></b>添加教师信息
		</div>

		<form action="addTeacher.action" id="addTeacher" method="post">

			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							职工信息添加
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td style="width: 60px;">
							教师编号：
							<span style="color: red;">&nbsp;&nbsp;*</span>
						</td>
						<td>
							<input type = "text" name = "teacher.tno" maxlength = "10" id = "tno" onblur= "teacherblur();" />
							<span id="teacherNumberError">（填写10位长度的数字）</span>
						</td>


						<td style="width: 60px;">
							教师姓名:
							<span style="color: red;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*</span>
						</td>

						<td>
							<input name="teacher.tname" id="teacher.tname"
								onblur="return checkNull('teacher.tname','teacherNameError');"
								value='<s:property value="teacher.tname"/>' type="text" />
							<span id="teacherNameError"></span>
						</td>
						<td>
							出生日期:
							<span style="color: red;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*</span>
						</td>
						<td>
							<input name="teacher.birthDay" id="sdate"
								onblur="return checkNull('sdate','sdateError');"
								value='<fmt:formatDate pattern="yyyy-MM-dd" value="${teacher.birthDay}" />'
								type="text" onclick="fPopCalendar(event,this,this)"
								onfocus="this.select()" />
							<span id="sdateError"></span>

						</td>

					</tr>
					<tr>
						<td style="width: 60px;">
							教师性别:
							<span style="color: red;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*</span>
						</td>
						<td>
							<input type="hidden" class="s"
								value="<s:property value="teacher.sex"/>" />
							<select size="1" name="teacher.sex" id="sex"
								onblur="return checkNull('sex','sexError');">
								<option value="">
									--选择--
								</option>
								<option value="男"
									<s:if test=' "男"== teacher.sex'>selected="selected"</s:if>>
									男
								</option>
								<option value="女"
									<s:if test=' "女" == teacher.sex'>selected="selected"</s:if>>
									女
								</option>
							</select>
							<span id="sexError"></span>
						</td>
						<td style="width: 60px;">
							职称 :
							<span style="color: red;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*</span>
						</td>
						<td>
							<select size="1" id="cType"
								name="teacher.professionaltitle.professionalTitleNo"
								onblur="return checkNull('cType','cTypeError');">
								<option value="">
									全部类型
								</option>
								<s:iterator value="professionalTitleList">
									<option value="<s:property value='professionalTitleNo'/>"
										<s:if test="professionalTitleNo == teacher.professionaltitle.professionalTitleNo">selected="selected"</s:if>>
										<s:property value="professionalTitleName" />
									</option>
								</s:iterator>
							</select>
							<span id="cTypeError"></span>
						</td>
						<td>
							职称评定时间:
						</td>
						<td>


							<input name="teacher.titleEvaluationTime" id="opensdate"
								value='<fmt:formatDate pattern="yyyy-MM-dd" value="${teacher.titleEvaluationTime}"/>'
								type="text" onclick="fPopCalendar(event,this,this)"
								onfocus="this.select()" />



						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							学历:
							<span style="color: red;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*</span>
						</td>
						<td>
							<select size="1" id="teacher.degree.degreeNo"
								name="teacher.degree.degreeNo"
								onblur="return checkNull('teacher.degree.degreeNo','degreeError');">
								<option value="">
									全部类型
								</option>
								<s:iterator value="degreeList">
									<option value="<s:property value='degreeNo'/>"
										<s:if test="degreeNo == teacher.degree.degreeNo">selected="selected"</s:if>>
										<s:property value="degreeName" />
									</option>
								</s:iterator>
							</select>
							<span id="degreeError"></span>
						</td>
						<td style="width: 60px;">
							学位:
							<span style="color: red;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*</span>
						</td>
						<td>
							<select size="1" id="teacher.academicdegree.bestDegreeNo"
								name="teacher.academicdegree.bestDegreeNo"
								onblur="return checkNull('teacher.academicdegree.bestDegreeNo','bestdegreeError');">
								<option value="">
									全部类型
								</option>
								<s:iterator value="academicdegreeList">
									<option value="<s:property value='bestDegreeNo'/>"
										<s:if test="bestDegreeNo == teacher.academicdegree.bestDegreeNo">selected="selected"</s:if>>
										<s:property value="bestDegreeName" />
									</option>
								</s:iterator>
							</select>
							<span id="bestdegreeError"></span>
						</td>
						<td>
							入校时间
						</td>
						<td>


							<input name="teacher.entryDate" id="entrysdate"
								value='<fmt:formatDate pattern="yyyy-MM-dd" value="${teacher.entryDate}"/>'
								type="text" onclick="fPopCalendar(event,this,this)"
								onfocus="this.select()" />
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							师资类别:
							<span style="color: red;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*</span>
						</td>
						<td>
							<select size="1" id="teacher.teacherscategory.teachersCategoryNo"
								onblur="return checkNull('teacher.teacherscategory.teachersCategoryNo','teachersCategoryNoError'); "
								name="teacher.teacherscategory.teachersCategoryNo">
								<option value="">
									全部类型
								</option>
								<s:iterator value="teachersCategoryList">
									<option value="<s:property value='teachersCategoryNo'/>"
										<s:if test="teachersCategoryNo == teacher.teacherscategory.teachersCategoryNo">selected="selected"</s:if>>
										<s:property value="teachersCategoryName" />
									</option>
								</s:iterator>
							</select>
							<span id="teachersCategoryNoError"></span>
						</td>
						<td style="width: 60px;">
							所属学院:
							<span style="color: red;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*</span>
						</td>
						<td>
							<select size="1" name="teacher.major.department.dno"
								class="department" id="coll" onchange="collchange()"
								onblur=" return checkNull('coll','collError');">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList">
									<option value="<s:property value='dno'/>">
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
							<span id="collError"></span>
						</td>
						<td style="width: 60px;">
							所属专业:
							<span style="color: red;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*</span>
						</td>
						<td>
							<select size="1" name="teacher.major.mno" id="major"
								onblur="return checkNull('major','majorError');">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList">
									<option value="<s:property value='mno'/>">
										<s:property value="mname" />
									</option>
								</s:iterator>
							</select>
							<span id="majorError"></span>
						</td>
					</tr>

					<tr>
						<td style="width: 60px;">
							在职状态:
							<span style="color: red;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*</span>
						</td>
						<td>
							<select name="teacher.inServiceState" id="teacher.inServiceState">
								<option value="在职"
									<s:if test=' "在职" == teacher.inServiceState'>selected="selected"</s:if>>
									在职
								</option>
								<option value="离职"
									<s:if test=' "离职" == teacher.inServiceState'>selected="selected"</s:if>>
									离职
								</option>
							</select>
						</td>
						<td style="width: 60px;">
							所在部门
						</td>
						<td>
							<input type="text" name="teacher.departmentGroup"
								value='<s:property value="teacher.departmentGroup"/>' />
						</td>
						<td style="width: 60px;">
							毕业学校
						</td>
						<td>
							<input type="text" name="teacher.graduatedSchool"
								value='<s:property value="teacher.graduatedSchool"/>' />
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							所学专业
						</td>
						<td>
							<input type="text" name="teacher.graduatedMajor"
								value='<s:property value="teacher.graduatedMajor"/>' />
						</td>
						<td style="width: 60px;">
							岗位类型:
							<span style="color: red;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*</span>
						</td>
						<td>
							<select size="1" id="teacher.jobtype.jobTypeNo"
								name="teacher.jobtype.jobTypeNo"
								onblur="return checkNull('teacher.jobtype.jobTypeNo','jobTypeError');">
								<option value="">
									全部类型
								</option>
								<s:iterator value="jobTypeList">
									<option value="<s:property value='jobTypeNo'/>"
										<s:if test="jobTypeNo == teacher.jobtype.jobTypeNo">selected="selected"</s:if>>
										<s:property value="jobTypeName" />
									</option>
								</s:iterator>
							</select>
							<span id="jobTypeError"></span>
						</td>
						<td style="width: 60px;">
							学位获得年份
						</td>
						<td>
							<input name="teacher.getScholarYear" type="text"
								value='<s:property value="teacher.getScholarYear"/>' />

						</td>
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							研究方向
						</td>
						<td>
							<input type="text" />
						</td>
						<td style="width: 60px;">
							学缘:
							<span style="color: red;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*</span>
						</td>
						<td>
							<select size="1" id="teacher.learningedge.learnEdgeNo"
								onblur="return checkNull('teacher.learningedge.learnEdgeNo','learnEdgeNoError'); "
								name="teacher.learningedge.learnEdgeNo">
								<option value="">
									全部类型
								</option>
								<s:iterator value="learningEdgelist">
									<option value="<s:property value='learnEdgeNo'/>"
										<s:if test="learnEdgeNo == teacher.learningedge.learnEdgeNo">selected="selected"</s:if>>
										<s:property value="learnEdgeName" />
									</option>
								</s:iterator>
							</select>
							<span id="learnEdgeNoError"></span>
						</td>
						<td style="width: 60px;">
							学科类别:
							<span style="color: red;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*</span>
						</td>
						<td>
							<select size="1" id="teacher.subjectcategory.subjectCategoryNo"
								onblur="return checkNull('teacher.subjectcategory.subjectCategoryNo','subjectCategoryNoError'); "
								name="teacher.subjectcategory.subjectCategoryNo">
								<option value="">
									全部类型
								</option>
								<s:iterator value="subjectCategoryList">
									<option value="<s:property value='subjectCategoryNo'/>"
										<s:if test="subjectCategoryNo == teacher.subjectcategory.subjectCategoryNo">selected="selected"</s:if>>
										<s:property value="subjectCategoryName" />
									</option>
								</s:iterator>
							</select>
							<span id="subjectCategoryNoError"></span>
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							是否双师
							<span style="color: red;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*</span>
						</td>
						<td>
							<select name="teacher.isDoubleTeacher"
								id="teacher.isDoubleTeacher">
								<option value="是"
									<s:if test=' "是" == teacher.isDoubleTeacher'>selected="selected"</s:if>>
									是
								</option>
								<option value="否"
									<s:if test=' "否" == teacher.isDoubleTeacher'>selected="selected"</s:if>>
									否
								</option>
							</select>

						</td>


						<td style="width: 60px;">
							是否工程背景
							<span style="color: red;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*</span>
						</td>
						<td>
							<select name="teacher.isEngineerBackground"
								id="teacher.isEngineerBackground">
								<option value="是"
									<s:if test=' "是" == teacher.isEngineerBackground'>selected="selected"</s:if>>
									是
								</option>
								<option value="否"
									<s:if test=' "否" == teacher.isEngineerBackground'>selected="selected"</s:if>>
									否
								</option>
							</select>

						</td>
						<td style="width: 60px;">
							是否具有行业培训
							<span style="color: red;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*</span>
						</td>
						<td>


							<select name="teacher.isIndustryBackground"
								id="teacher.isIndustryBackground">
								<option value="是"
									<s:if test=' "是" == teacher.isIndustryBackground'>selected="selected"</s:if>>
									是
								</option>
								<option value="否"
									<s:if test=' "否" == teacher.isIndustryBackground'>selected="selected"</s:if>>
									否
								</option>
							</select>

						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							实践教学能力培训
							<span style="color: red;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*</span>
						</td>
						<td>
							<select name="teacher.isPracticeTeachTraining"
								id="teacher.isPracticeTeachTraining">
								<option value="是"
									<s:if test=' "是" == teacher.isPracticeTeachTraining'>selected="selected"</s:if>>
									是
								</option>
								<option value="否"
									<s:if test=' "否" == teacher.isPracticeTeachTraining'>selected="selected"</s:if>>
									否
								</option>
							</select>
						</td>
						<td style="width: 60px;">
							导师类别
							<span style="color: red;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*</span>
						</td>
						<td>
							<select name="tutorType" id="tutorType">

								<option value="无"
									<s:if test=' "无" == teacher.tutorType'>selected="selected"</s:if>>
									无
								</option>
								<option value="博士导师"
									<s:if test=' "博士导师" == teacher.tutorType'>selected="selected"</s:if>>
									博士导师
								</option>
								<option value="硕士导师"
									<s:if test=' "硕士导师" == teacher.tutorType'>selected="selected"</s:if>>
									硕士导师
								</option>
								<option value="博士、硕士导师"
									<s:if test=' "博士、硕士导师" == teacher.tutorType'>selected="selected"</s:if>>
									博士、硕士导师
								</option>
							</select>
						</td>
						<td style="width: 60px;">
							是否外聘教师
							<span style="color: red;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*</span>
						</td>
						<td>
							<select name="teacher.isOuterTeacher" id="teacher.isOuterTeacher">
								<option value="是"
									<s:if test=' "是" == teacher.isOuterTeacher'>selected="selected"</s:if>>
									是
								</option>
								<option value="否"
									<s:if test=' "否" == teacher.isOuterTeacher'>selected="selected"</s:if>>
									否
								</option>
							</select>

						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="99">
							<a href="javascript:history.back(-1)" class="btn btn-primary add">返回上一层</a>&nbsp;&nbsp;
							<a href="javascript:modifyEdit();" class="btn btn-primary add">保存</a>&nbsp;&nbsp;

						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</body>
</html>
