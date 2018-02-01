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
			src="${pageContext.request.contextPath}/Scripts/ajax/MajorByDno.js">
</script>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/timeManage.js">
</script>
		<script type="text/javascript">
//日历插件
$(function() {
	$(".datepicker").datepicker();
})

$(document).ready(function() {
timeManage();
	$("#mytable tr:even td").css("background", "#fff");
	$("#mytable tr:even td").attr("bg", "#fff");
	$("#mytable tr:odd td").attr("bg", "#fff");
	$("#mytable tr td").hover(function() {
		$(this).parent().find("td").css("background", "#fff")
	}, function() {
		var bgc = $(this).attr("bg");
		$(this).parent().find("td").css("background", bgc)
	});
})

$(document).ready(function() {
	// ------------------------------	     
		$(".college").change(
				function() {

					$('#major option').remove();

					$.ajax( {
						type : "POST",
						url : 'findByCollegeIdListMajorStu.action',
						data : 'collegeId=' + $(this).val(),
						success : function(jsonArray) {

							var json = eval("(" + jsonArray + ")")
							var porHtml = "<option value=''>全部专业</option>";
							for ( var i = 0; i < json.length; i++) {
								porHtml += "<option value=" + json[i].majorId
										+ " >" + json[i].majorName
										+ "</option>";
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
$(document).ready(function() {
	// ------------------------------	
		//角色判断
		var rol = $("#rol").val();
		var totalRows = $("#totalRows").val();
		//if (rol == 3) {
			//$("#attach").hide();//隐藏导入
			//$("#add").hide();//隐藏导入
			//for ( var i = 0; i < totalRows; i++) {
				//$(".edit").hide();
				//$(".del").hide();

			//}
		//}
	});
//查询
function findContestApply() {
	document.getElementById("form1").submit();
}

function jump(op) {
	if ("first" == op) {
		page = 1;
	} else if ("up" == op) {
		page = parseInt(page) - 1;
	} else if ("down" == op) {
		page = parseInt(page) + 1;
	} else if ("last" == op) {
		page = totalPage;
	} else {
		var jumpPage = parseInt(document.getElementById("jumpPage").value);
		if (jumpPage <= totalPage && jumpPage > 0)
			page = jumpPage;
		else
			alert("超出页码范围");
	}
	var ttname = "" + '${mcoursemodel.tname}';
	ttname = encodeURI(ttname);
	ttname = encodeURI(ttname);
	window.location.href = "findMcourse.action?&mcoursemodel.tno=" + '${mcoursemodel.tno}'
			+ "&mcoursemodel.tname=" + ttname+"&rows=" + rows + "&page="
			+ page;
}

function setRows(rows) {
var ttname = "" + '${mcoursemodel.tname}';
	ttname = encodeURI(ttname);
	ttname = encodeURI(ttname);
	window.location.href = "findMcourse.action?&mcoursemodel.tno=" + '${mcoursemodel.tno}'
			+ "&mcoursemodel.tname=" + ttname+"&rows=" + rows.value+"&page=1";
}

//导出
function exportSubContestTExcel() {
	var ttname = "" + '${mcoursemodel.tname}';
	ttname = encodeURI(ttname);
	ttname = encodeURI(ttname);
	var openSemester = "" + '${mcoursemodel.openSemester}';
	openSemester = encodeURI(openSemester);
	openSemester = encodeURI(openSemester);
	var ctype = "" + '${mcoursemodel.ctype}';
	ctype = encodeURI(ctype);
	ctype = encodeURI(ctype);
	var professionalTitleName = "" + '${mcoursemodel.professionalTitleName}';
	professionalTitleName = encodeURI(professionalTitleName);
	professionalTitleName = encodeURI(professionalTitleName);
	window.location.href = "exportSubContestTExcel.action?exportName=mcourse"
			+ "&mcoursemodel.id=" + '${mcoursemodel.id}'
			+ "&mcoursemodel.openSemester=" + openSemester
			+ "&mcoursemodel.tno=" + '${mcoursemodel.tno}'
			+ "&mcoursemodel.tname=" + ttname
			+ "&mcoursemodel.professionalTitleName=" + professionalTitleName
			+ "&mcoursemodel.ctype=" + ctype + "&mcoursemodel.year="
			+ '${mcoursemodel.year}' + "&mcoursemodel.departmentId="
			+ '${mcoursemodel.departmentId}' + "&mcoursemodel.majorId="
			+ '${mcoursemodel.majorId}';
}
//上传附件弹出框
function upFile() {
	document.getElementById("iframe").src = "attachFileList.action?importName=mcourse";
	$('#alert-win').dialog( {
		width : 450,
		height : 240,
		buttons : {
			"关闭" : function() {
				findContestApply();
				$(this).dialog("close");
			}
		}
	});
}
</script>
	</head>

	<body style="background-color:#e4dfd9">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业所开课程
			<b class="tip"></b>查询专业所开课程信息
		</div>
		<form action="findMcourse.action?page=1&rows=10" id="form1"
			name="form1" method="post" enctype="multipart/form-data">

			<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							专业所开课程查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td style="width: 60px;">
							课程名称
						</td>
						<td>
							<select size="1" id="cname" name="mcoursemodel.Id">
								<option value="">
									--选择--
								</option>
								<s:iterator value="courseList" var="cnamevar">
									<option value="<s:property value='cno'/>"
									<s:if test="#cnamevar.cno == mcoursemodel.Id"></s:if>>
										<s:property value="cname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width: 60px;">
							学期
						</td>
						<td>
							<select size="1" id="openSemester"
								name="mcoursemodel.openSemester">
								<option value="">
									--选择--
								</option>
								<s:iterator value="openSemesterList" var="openvar">
									<option value="<s:property/>"
									<s:if test="#openvar ==mcoursemodel.openSemester"></s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width: 60px;">
							课程类型
						</td>
						<td>
							<select size="1" id="ctype" name="mcoursemodel.ctype">
								<option value="">
									--选择--
								</option>
								<option value="专业课"
								<s:if test="'专业课' == mcoursemodel.ctype"></s:if>>
									专业课
								</option>
								<option value="公共选修课"
								<s:if test="'公共选修课' == mcoursemodel.ctype"></s:if>>
									公共选修课
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							所在学院
						</td>
						<td>
							<select size="1" id="coll" name="mcoursemodel.departmentId"
								class="department" onchange="collchange();">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList" var="departmentvar">
									<option value="<s:property value='dno'/>">
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							所在专业
						</td>
						<td>
							<select size="1" name="mcoursemodel.majorId" id="major">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList" var="majorvar">
									<option value="<s:property value='mno'/>">
										<s:property value="mname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							年份
						</td>
						<td>
							<select name="mcoursemodel.year" id="year">
								<option value="">
									全部年份
								</option>
								<s:iterator value="yearList" var="yearvar">
									<option value="<s:property/>"
									<s:if test="#yearvar == mcoursemodel.year">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							教师编号
						</td>
						<td>
							<input name="mcoursemodel.tno" type="text" value="<s:property value='mcoursemodel.tno'/>"/>
						</td>
						<td>
							教师姓名
						</td>
						<td>
							<input name="mcoursemodel.tname" type="text" value="<s:property value='mcoursemodel.tname'/>"/>
						</td>
						<td>
							职称
						</td>
						<td>
							<select name="mcoursemodel.professionalTitleName" id="ptitle">
								<option value="">
									--选择--
								</option>
								<s:iterator value="ptitleList" var="ptitlevar">
									<option value="<s:property/>"
									<s:if test="#ptitlevar == mcoursemodel.professionalTitleName">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="5">
							<a href="javascript:findContestApply();"
								class="btn btn-primary add">查询</a>&nbsp;&nbsp;
							<a href="#" onclick="exportSubContestTExcel()"
								class="btn btn-primary add">导出专业开课列表</a> &nbsp;&nbsp;
							<span style="color: red;">(先查询，再导出)</span>

						</td>
						<td align="center">
							<a id="add" href="editToMcourse.action?openCourseNo=0" style=""
								class="btn btn-primary add">添加</a>
							<!--选择导入的文件 -->
							<a id="attach" href="javascript:void(0);"
								onclick="upFile();return false;" class="btn btn-primary add">导入</a>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				专业所开课程查询结果
			</caption>
			<thead>
				<tr>
					<td>
						#
					</td>
					<td>
						课程名称
					</td>
					<td>
						专业名称
					</td>
					<td>
						课程类型
					</td>
					<td>
						教师编号
					</td>
					<td>
						教师姓名
					</td>
					<td>
						职称
					</td>
					<td>
						学期
					</td>
					<!--<td>
						所属专业
					</td>
					--><td>
						上课学时
					</td>
					<td>
						总学时
					</td>
					<td>
						开课年份
					</td>
					<td>
						操作
					</td>
				</tr>
			</thead>
			<tbody>
				<s:if test="mcourseList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有查询到课程信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="mcourseList" id="mcourse" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td>
							<s:property value="course.cname" />
						</td>
						<td>
							<s:property value="major.mname" />
						</td>
						<td>
							<s:property value="ctype" />
						</td>
						<td>
							<s:property value="teacher.tno" />
						</td>
						<td>
							<s:property value="teacher.tname" />
						</td>
						<td>
							<s:property value="professionalTitleName" />
						</td>
						<td>
							<s:property value="openSemester" />
						</td>
						<!--<td>
							<s:property value="inMajor" />

						</td>
						--><td>
							<s:property value="classhours" />

						</td>
						<td>
							<s:property value="courseHours" />

						</td>
						<td>
							<s:property value="year" />
						</td>
						<td>

							<span class="edit"> <a class="btn btn-mini btn-primary"
								href="editToMcourse.action?openCourseNo=<s:property value="openCourseNo"/>">
									修改 </a> </span><span class="del"> <a
								class="btn btn-mini btn-primary"
								href="deleteMcourse.action?openCourseNo=<s:property value="openCourseNo"/>"
								onclick="return confirm('是否删除')"> 删除 </a> </span>
						</td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="mcourseList.size() > 0">
					<tr>
						<td colspan="99">
							<s:include value="../common/paging.jsp"></s:include>
						</td>
					</tr>
				</s:if>
			</tfoot>
		</table>
		<div id="alert-win" title="附件" style="display: none;">
			<iframe style="border: 0; width: 100%; height: 100%;" id="iframe"
				src="">
			</iframe>
		</div>
	</body>
</html>
