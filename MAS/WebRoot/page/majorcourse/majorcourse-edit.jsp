<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>专业课开课</title>

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
		<!-- 学院级联专业-->
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/MajorByDno.js">
</script>
		<!-- 教师编号验证 -->
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/TnameByTno.js"></script>


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
numcheck = /\d/;   
return numcheck.test(keychar)   
}

function modifyEdit() {
   if (document.getElementById("cname").value.length ==0){
	        alert("课程名称选项不能为空");
			document.getElementById("cname").focus();
	}
    else if (document.getElementById("ctype").value.length ==0){
	        alert("课程类型选项不能为空");
			document.getElementById("ctype").focus();
	}
	else if (document.getElementById("openSemester").value.length ==0){
	        alert("开课学期选项不能为空");
			document.getElementById("openSemester").focus();
	}
	else if (document.getElementById("major").value.length ==0){
	        alert("所在专业选项不能为空");
			document.getElementById("major").focus();
	}
    else if (document.getElementById("tno").value.length ==0){
	        alert("教师编号选项不能为空");
			document.getElementById("tno").focus();
	}
	else if(document.getElementById("year").value.length==0){  
        alert("年份选项不能为空!"); 
        document.getElementById("year").focus(); 
    }
     else if (document.getElementById("tno").value.length ==0){
	        alert("教师编号选项不能为空");
			document.getElementById("tno").focus();
	}
	else if(document.getElementById("classhours").value.length==0){  
        alert("上课学时不能为空!"); 
        document.getElementById("classhours").focus(); 
    }  
     else if(document.getElementById("courseHours").value.length==0){  
        alert("总学时不能为空!"); 
        document.getElementById("courseHours").focus();  
    }
    else if(document.getElementById("courseHours").value<document.getElementById("classhours").value) {
        alert("总学时不能小于上课学时!"); 
        document.getElementById("courseHours").focus();
    }
    else if (confirm("是否保存")) {
			document.getElementById("edit").submit();
		}
}


$(document).ready(function() {
	if (thesisNumber == 0) {
	} else {
		stublur();
	}
});

</script>
	</head>

	<!--<body onload="init()">
		-->
		<body style="background-color:#e4dfd9">
	<div class="alert alert-info">
		当前位置
		<b class="tip"></b>专业所开课程查询
		<b class="tip"></b>编辑专业所开课程信息
	</div>
	<form action="editMcourse.action" id="edit" method="post">
		<table class="table table-bordered table-condensed">
			<caption class="t_caption">
				专业所开课程信息
			</caption>
			<thead>
				<tr>
					<td colspan="99">
						编辑专业所开课程信息
					</td>
				</tr>
			</thead>
			<tbody id="mytable">
				<tr>
					<td>
						课程名称：
						<font color="red">*</font>
					</td>
					<td>
						<s:if test='mcourse==null'>
							<select size="1" id="cname" name="mcourse.course.cno">
								<option value="">
									--请选择--
								</option>
								<s:iterator value="courseList" var="cnamevar">

									<option value="<s:property value='cno'/>"
										<s:if test="#cnamevar.cname == mcourse.course.cname">selected="selected"</s:if>>
										<s:property value="cname" />
									</option>
								</s:iterator>
							</select>
						</s:if>
						<s:else>

							<input name="mcourse.course.cname" readonly="readonly"
								value='<s:property value="mcourse.course.cname"/>' type="text"
								id="cname" />
						</s:else>
					</td>
					<td style="width: 12%;">
						课程类型：
						<font color="red">*</font>
					</td>
					<td>
						<select size="1" id="ctype" name="mcourse.ctype">

							<option value="专业课"
								<s:if test="'专业课' == mcourse.ctype">selected="selected"</s:if>>
								专业课
							</option>
							<option value="公共选修课"
								<s:if test="'公共选修课' == mcourse.ctype">selected="selected"</s:if>>
								公共选修课
							</option>
						</select>
					</td>
					<td>
						学期：
						<font color="red">*</font>
					</td>
					<td>

						<!--<input name="mcourse.openSemester"
								value='<s:property value="mcourse.openSemester"/>' type="text" id="openSemester"/>
						-->

						<select size="1" id="openSemester" name="mcourse.openSemester">
							<option value="">
								--请选择--
							</option>
							<option value="春"
								<s:if test='"春 "== mcourse.openSemester'>selected="selected"</s:if>>
								春
							</option>
							<option value="夏"
								<s:if test='"夏" == mcourse.openSemester'>selected="selected"</s:if>>
								夏
							</option>
							<option value="秋"
								<s:if test='"秋" == mcourse.openSemester'>selected="selected"</s:if>>
								秋
							</option>
						</select>

					</td>
				</tr>
				<tr>
					<td>
						开课学院：
						<font color="red">*</font>
					</td>
					<td>
						<select name="mcourse.major.department.dno" id="coll"
							onchange="collchange();">
							<option value="">
								全部学院
							</option>
							<s:iterator value="departmentList" var="departmentvar">
								<option value="<s:property value="dno"/>"
									<s:if test="#departmentvar.dno == mcourse.major.department.dno">selected="selected"</s:if>>
									<s:property value="dname" />
								</option>
							</s:iterator>
						</select>
					</td>
					<td>
						开课专业：
						<font color="red">*</font>
					</td>
					<td>
						<select size="1" name="mcourse.major.mno" id="major">
							<option value="">
								全部专业
							</option>
							<s:iterator value="majorList" var="majorvar">
								<option value="<s:property value='mno'/>"
									<s:if test="#majorvar.mno == mcourse.major.mno">selected="selected"</s:if>>
									<s:property value="mname" />
								</option>
							</s:iterator>
						</select>
					</td>
					<!--<td style="width: 12%;">
							所属专业
							<font color="red">*</font>
						</td>
						<td style="width: 12%;">
							<select size="1" name="mcourse.inMajor" id="inmajor">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList" var="inmajorvar">
									<option value="<s:property value='mname'/>"
										<s:if test="#inmajorvar.mname == mcourse.inMajor">selected="selected"</s:if>>
										<s:property value="mname" />
									</option>
								</s:iterator>
							</select>
						</td>
					-->
					<td>
						上课学时
						<font color="red">*</font>
					</td>
					<td>
						<input name="mcourse.classhours"
							onkeypress="return Numbers(event)"
							value='<s:property value="mcourse.classhours"/>' type="text"
							id="classhours" />
					</td>

				</tr>
				<tr>
					<td style="width: 12%;">
						教师编号：
						<font color="red">*</font>
					</td>
					<td>
						<input name="mcourse.teacher.tno" id="tno"
							value='<s:property value="mcourse.teacher.tno"/>'
							onblur="tnochange()" type="text" />
						<span id="tnoError"></span>
					</td>
					<td style="width: 12%;">
						教师姓名：
						<font color="red">*</font>
					</td>
					<td>
						<!--<label id="sla">
								<s:property value="mcourse.teacher.tname" />
							</label>
						-->
						<input type="text" name="mcourse.teacher.tname" id="teacherName"
							value='<s:property value="mcourse.teacher.tname"/>'
							readonly="readonly" />
					</td>
					<td style="width: 12%;">
						职称
						<font color="red">*</font>
					</td>
					<td>
						<select name="mcourse.professionalTitleName" id="ptitle">
							<option value="">
								--选择--
							</option>
							<s:iterator value="ptitleList" var="ptitlevar">
								<option value="<s:property/>"
									<s:if test="#ptitlevar == mcourse.professionalTitleName">selected="selected"</s:if>>
									<s:property />
								</option>
							</s:iterator>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						总学时
						<font color="red">*</font>
					</td>
					<td>
						<input name="mcourse.courseHours"
							onkeypress="return Numbers(event)"
							value='<s:property value="mcourse.courseHours"/>' type="text"
							id="courseHours" />
					</td>
					<td style="width: 12%;">
						年份
						<font color="red">*</font>
					</td>
					<td>
						<input name="mcourse.year" onkeypress="return Numbers(event)"
							value='<s:property value="mcourse.year"/>' type="text" id="year" />
					</td>
					<td style="width: 12%;">
						备注
					</td>
					<td colspan="5">
						<input name="mcourse.beizhu"
							value='<s:property value="mcourse.beizhu"/>' type="text" />
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
