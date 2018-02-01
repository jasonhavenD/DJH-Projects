<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>编辑学生信息</title>

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
			src="${pageContext.request.contextPath}/Scripts/cal.js">
</script>

		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/stuNumber_uniqueness.js">
</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/MajorByDno.js">
</script>

	</head>

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
function modifyEditStudent() {
 if(document.getElementById("stuNumber").value!=""){
		if(checkNull("student.stuName","stuNameError")&&checkNull("major","majorError")&&checkNull("grade","gradeError")&&checkNull("class","classError")&&checkNull("student.eductionalSystme","eductionalSystmeError")){
			if(document.getElementById("stuNumberError").innerHTML=="学号可用"||document.getElementById("stuNumberError").innerHTML.length==0)
			{

			  if (confirm("是否修改")) {
				document.getElementById("editStudent").submit();}
			}else{alert("学号错误")}

	   }
	}else{
		  	 alert("学号不能为空");
		  }
}
function checkNull(tagName,tagErrorName){
		var tagValue=document.getElementById(tagName).value;

		if(tagValue.length==0){
			document.getElementById(tagErrorName).innerHTML="该选项不能为空";
			document.getElementById(tagErrorName).style.color="red";
			return false;
		}else{
		    document.getElementById(tagErrorName).innerHTML="已填写";
		    document.getElementById(tagErrorName).style.color="green";
		    return true;
		}
}


//验证输入日期
function checkBirth() {
	var datestring = document.getElementById("date").value;

	var re = /^(\d{4}-\d{1,2}-\d{1,2})(\s?\d{2}:\d{2}:\d{2})?$/;
	if (!re.test(datestring)) {
		document.getElementById("birspan").innerHTML = "日期格式不正确！";
		document.getElementById("birspan").setAttribute("style",
				"font-size:12px;color:red;");
	} else {
		document.getElementById("birspan").innerHTML = "日期格式正确！";
		document.getElementById("birspan").setAttribute("style",
				"font-size:12px;color:green;");
	}
}
//验证电子邮件
function checkEmail() {
	var string = document.getElementById("email").value;
	var regu = "^(([0-9a-zA-Z]+)|([0-9a-zA-Z]+[_.0-9a-zA-Z-]*[0-9a-zA-Z]+))@([a-zA-Z0-9-]+[.])+([a-zA-Z]{2}|net|NET|com|COM|gov|GOV|mil|MIL|org|ORG|edu|EDU|int|INT)$"
	var re = new RegExp(regu);
	if (string.search(re) != -1) {
		document.getElementById("emailspan").innerHTML = "电子邮件格式正确！";
		document.getElementById("emailspan").setAttribute("style",
				"font-size:12px;color:green;");
	} else {
		document.getElementById("emailspan").innerHTML = "电子邮件格式不正确！";
		document.getElementById("emailspan").setAttribute("style",
				"font-size:12px;color:red;");
	}
}
</script>

	</head>

	<body style="background-color:#e4dfd9"  onload="init();">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>查询学生信息
			<b class="tip"></b>编辑学生信息
		</div>

		<form action="editStudent.action" id="editStudent" method="post">


			<table class="table table-striped table-bordered table-condensed">
				<caption class="t_caption">
					学生信息编辑
				</caption>
				<thead>
					<tr>
						<td colspan="99">
							学生信息编辑
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>

						<td>
							学号：
							<font color="red">*</font>
						</td>
						<td width="27%">
							<input type="text" name="student.stuNumber" maxlength="10"
								id="stuNumber" onblur="stublur();"
								value='<s:property value="student.stuNumber" />' />
							<span id="stuNumberError"></span>
						</td>
						<td style="width: 60px;">
							姓名：
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="student.stuName" maxlength="10"
								id="student.stuName"
								value='<s:property value="student.stuName" />' />
							<span id="stuNameError"></span>
						</td>
						<td style="width: 60px;">
							民族：
							<font color="red">*</font>
						</td>
						<td>
							<select size="1" name="student.national.nationNnumber"
								id="national">
								<s:iterator value="nationalList" var="nationalvar">
									<option value="<s:property value='nationNnumber'/>"
										<s:if test="#nationalvar.nationNnumber == student.national.nationNnumber">selected="selected"</s:if>>
										<s:property value="nationName" />
									</option>
								</s:iterator>
							</select>

						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							性别：
						</td>
						<td>
							<select name="student.sex" id="sex">
								<option value="男"
									<s:if test='student.sex=="男"'> selected="selected"</s:if>>
									男
								</option>
								<option value="女"
									<s:if test='student.sex=="女"'> selected="selected"</s:if>>
									女
								</option>
							</select>

						</td>
						<td style="width: 60px;">
							学院名称:
							<font color="red">*</font>
						</td>
						<td>
							<select size="1" name="student.major.department.dno"
								class="department" id="coll" onchange="collchange();">
								<s:iterator value="departmentList" var="depart">
									<option value="<s:property value='dno'/>"
										<s:if test="#depart.dname==student.major.department.dname">selected="selected"</s:if>>
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width: 60px;">
							专业：
							<font color="red">*</font>
						</td>
						<td>
							<select size="1" name="student.major.mno" id="major">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList" var="majorvar">
									<option value="<s:property value='mno'/>"
										<s:if test="#majorvar.mno == student.major.mno">selected="selected"</s:if>>
										<s:property value="mname" />
									</option>
								</s:iterator>
							</select>
							<span id="majorError"></span>
						</td>

					</tr>
					<tr>
						<td style="width: 60px;">
							年级：
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="student.grade" id="grade" maxlength="4"
								onkeypress="return Numbers(event)"
								value='<s:property value="student.grade" />' />
							<span style="color: red" id="gradeError">（入学年份）</span>
						</td>
						<td>
							班级：
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="student.class_" id="class"
								maxlength="32" value='<s:property value="student.class_" />' />
							<span style="color: red" id="classError"></span>
						</td>


						<td>
							入学年份：
						</td>
						<td>
							<input type="text" name="student.year" maxlength="4"
								onkeypress="return Numbers(event)"
								value='<s:property value="student.year" />' />
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							毕业日期：
						</td>
						<td>
							<input name="student.graduationDate" id="graduationDate"
								value='<fmt:formatDate pattern="yyyy-MM-dd" value="${student.graduationDate}"/>'
								type="text" onclick="fPopCalendar(event,this,this)"
								onfocus="this.select()" />
						</td>
						<td style="width: 60px;">
							学制：
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="student.eductionalSystme" maxlength="1"
								id="student.eductionalSystme"
								value='<s:property value="student.eductionalSystme" />' />
							<span id="eductionalSystmeError"></span>
						</td>
						<td style="width: 60px;">
							是否有学籍：
							<font color="red">*</font>
						</td>
						<td>

							<select name="student.isRoll" id="isRoll">
								<option value="有学籍"
									<s:if test='student.isRoll=="有学籍"'> selected="selected"</s:if>>
									有学籍
								</option>
								<option value="无学籍"
									<s:if test='student.isRoll=="无学籍"'> selected="selected"</s:if>>
									无学籍
								</option>
							</select>
						</td>

					</tr>
					<tr>
						<td style="width: 60px;">
							是否在校：
							<font color="red">*</font>
						</td>
						<td>

							<select name="student.isInSchool" id="isInSchool">
								<option value="在校"
									<s:if test='student.isInSchool=="在校"'> selected="selected"</s:if>>
									在校
								</option>
								<option value="不在校"
									<s:if test='student.isInSchool=="不在校"'> selected="selected"</s:if>>
									不在校
								</option>
							</select>
						</td>

						<td style="width: 60px;">
							出生日期：
							<font color="red">*</font>
						</td>

						<td>
							<input name="student.birth" id="birth"
								value='<fmt:formatDate pattern="yyyy-MM-dd" value="${student.birth}"/>'
								type="text" onclick=
	fPopCalendar(event, this, this);
onfocus="this.select()" />
						</td>
						<td style="width: 60px;">
							当前学生状态：

						</td>
						<td>
							<input type="text" name="student.status"
								value='<s:property value="student.status" />' />
						</td>

					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="99">
							<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
							<a class="btn btn-primary add" id="save"
								href="javascript:modifyEditStudent()">保存</a>&nbsp;&nbsp;
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</body>
</html>
