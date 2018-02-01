<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>课程基本信息</title>

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
			src="${pageContext.request.contextPath}/Scripts/ajax/timeManage.js">
</script>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
		<script type="text/javascript">
//日历插件
$(function() {
	$(".datepicker").datepicker();
})


//查询赛项
function findContestApply() {
	document.getElementById("form1").submit();
}

//查看赛项详细信息
function findContestInfo(conId) {
	window.location.href = "searchContestInfoToTCO.action?contestId=" + conId;
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
	var cctype = ""+'${cmodel.ctype}'; 
	var cname = ""+'${cmodel.name}'; 
	var cisDoubleLanguageTeach = ""+'${cmodel.isDoubleLanguageTeach}'; 
	var ctestMode = ""+'${cmodel.testMode}'; 
	cname = encodeURI(cname); 
 	cname = encodeURI(cname);
 	cctype = encodeURI(cctype); 
 	cctype = encodeURI(cctype);
 	cisDoubleLanguageTeach = encodeURI(cisDoubleLanguageTeach); 
 	cisDoubleLanguageTeach = encodeURI(cisDoubleLanguageTeach); 
 	ctestMode = encodeURI(ctestMode); 
 	ctestMode = encodeURI(ctestMode);
				window.location.href = "findCourse.action?cmodel.id="+'${cmodel.id}'
					+ "&cmodel.name=" + cname
					+ "&cmodel.departmentId=" + '${cmodel.departmentId}'
					+ "&cmodel.year=" + '${cmodel.year}'
					+ "&cmodel.ctype=" + cctype
					+ "&cmodel.isDoubleLanguageTeach=" + cisDoubleLanguageTeach
					+ "&cmodel.testMode=" + ctestMode
					+ "&rows=" + rows + "&page=" + page;

}

function setRows(rows) {
var cctype = ""+'${cmodel.ctype}'; 
	var cname = ""+'${cmodel.name}'; 
	var cisDoubleLanguageTeach = ""+'${cmodel.isDoubleLanguageTeach}'; 
	var ctestMode = ""+'${cmodel.testMode}'; 
	cname = encodeURI(cname); 
 	cname = encodeURI(cname);
 	cctype = encodeURI(cctype); 
 	cctype = encodeURI(cctype);
 	cisDoubleLanguageTeach = encodeURI(cisDoubleLanguageTeach); 
 	cisDoubleLanguageTeach = encodeURI(cisDoubleLanguageTeach); 
 	ctestMode = encodeURI(ctestMode); 
 	ctestMode = encodeURI(ctestMode);
	window.location.href = "findCourse.action?cmodel.id="+'${cmodel.id}'
					+ "&cmodel.name=" + cname
					+ "&cmodel.departmentId=" + '${cmodel.departmentId}'
					+ "&cmodel.year=" + '${cmodel.year}'
					+ "&cmodel.ctype=" + cctype
					+ "&cmodel.isDoubleLanguageTeach=" + cisDoubleLanguageTeach
					+ "&cmodel.testMode=" + ctestMode + "&rows=" + rows.value;
}
//导入
//上传附件弹出框
function upFile() {
	document.getElementById("iframe").src = "attachFileList.action?importName=course";
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
//导出我的赛项列表
function exportSubContestTExcel() {
	var cctype = ""+'${cmodel.ctype}'; 
	var cname = ""+'${cmodel.name}'; 
	var cisDoubleLanguageTeach = ""+'${cmodel.isDoubleLanguageTeach}'; 
	var ctestMode = ""+'${cmodel.testMode}'; 
	cname = encodeURI(cname); 
 	cname = encodeURI(cname);
 	cctype = encodeURI(cctype); 
 	cctype = encodeURI(cctype);
 	cisDoubleLanguageTeach = encodeURI(cisDoubleLanguageTeach); 
 	cisDoubleLanguageTeach = encodeURI(cisDoubleLanguageTeach); 
 	ctestMode = encodeURI(ctestMode); 
 	ctestMode = encodeURI(ctestMode);
	
	window.location.href = "exportExcel.action?exportName=course"
			+ "&cmodel.id="+'${cmodel.id}'
			+ "&cmodel.name=" + cname
			+ "&cmodel.departmentId=" + '${cmodel.departmentId}'
			+ "&cmodel.year=" + '${cmodel.year}'
			+ "&cmodel.ctype=" + cctype
			+ "&cmodel.isDoubleLanguageTeach=" + cisDoubleLanguageTeach
			+ "&cmodel.testMode=" + ctestMode;
}


//角色判断
$(document).ready(function() {
timeManage();
	// ------------------------------	
		//角色判断
		var rol = $("#rol").val();
		var totalRows = $("#totalRows").val();
		if (rol == 4) {
			$("#attach").hide();//隐藏导入
			$("#add").hide();//隐藏导入
			for ( var i = 0; i < totalRows; i++) {
				$(".edit").hide();
				$(".del").hide();

			}
		}
	});

		</script>

	</head>

	<body style="background-color:#e4dfd9">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>课程基本信息
			<b class="tip"></b>查询课程信息
		</div>

		<form action="findCourse.action?page=1&rows=10" id="form1"
			name="form1" method="post" enctype="multipart/form-data">

<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							课程信息查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td style="width: 60px;">
							课程编号
						</td>
						<td>
							<input name="cmodel.Id" value='<s:property value="cmodel.Id"/>' type="text" />
						</td>
						<td style="width: 60px;">
							课程名称
						</td>
						<td>
							<input name="cmodel.Name" value='<s:property value="cmodel.Name"/>' type="text" />
						</td>
						
						<td>
							所在学院
						</td>
						<td>
							<select size="1" id="coll" name="cmodel.departmentId" onchange="collchange();">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList" var="departmentvar">
									<option value="<s:property value='dno'/>"
										<s:if test="#departmentvar.dno == cmodel.departmentId">selected="selected"</s:if>>
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<!--<td>
							开课年份
						</td>
						<td>
							<select name="cmodel.year" id="year">
								<option value="">
									选择年份
								</option>
								<s:iterator value="yearList">
									<option value="<s:property/>">
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>

					--></tr>
					<tr>
						<td style="width: 60px;">
							课程类别
						</td>
						<td>
							<select size="1" id="ctype" name="cmodel.ctype">
								<option value="">
									全部类别
								</option>
								<s:iterator value="ctList" var="ctvar">
									<option value="<s:property/>"
										<s:if test="#ctvar == cmodel.ctype">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width: 60px;" >
							是否双语授课
						</td>
						<td>
							<select size="1" id="isDoubleLanguageTeach"
								name="cmodel.isDoubleLanguageTeach">
								<option value="">
									--请选择--
								</option>
								<s:iterator value="isDouList" var="isDouvar"> 
									<option value="<s:property/>"
										<s:if test="#isDouvar == cmodel.isDoubleLanguageTeach">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width: 60px;">
							考核方式
						</td>
						<td>
							<select size="1" id="testMode" name="cmodel.testMode">
								<option value="">
									全部方式
								</option>
								<s:iterator value="testModeList" var="testModevar">
									<option value="<s:property/>"
										<s:if test="#testModevar == cmodel.testMode">selected="selected"</s:if>>
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
								class="btn btn-primary add">导出课程信息列表</a> &nbsp;&nbsp;
							<span style="color: red;">(先查询，再导出)</span>

						</td>
						<td align="center">
							<a id="add" href="editToCourse.action?CourseId=0" style=""
								class="btn btn-primary add">添加</a>
							<!-- 选择导入的文件 -->
							<a id="attach" href="javascript:void(0);"
								onclick="upFile();return false;" class="btn btn-primary add">导入</a>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>

		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				课程信息查询结果
			</caption>
			<thead>
				<tr>
					<td>
						#
					</td>
					<td>
						课程编号
					</td>
					
					<td>
						课程名称
					</td>
					<td>
						学院名称
					</td>
					<td>
						课程类别
					</td>
					<td>
						是否双语授课
					</td>
					<td>
						考核方式
					</td>
					<td>
						学时
					</td>
					<td>
						学分
					</td>
					<td>
						方案版本
					</td>
					<td>
						操作
					</td>
				</tr>
			</thead>
			<tbody>
				<s:if test="courseList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有查询到课程信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="courseList" id="course" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td>
							<s:property value="cno" />
						</td>
						<td>
							<s:property value="cname" />
						</td>
						<td>
							<s:property value="department.dname" />
						</td>
						<td>
							<s:property value="ctype" />
						</td>
						<td>
							<s:property value="isDoubleLanguageTeach" />
						</td>
						<td>
							<s:property value="testMode" />

						</td>
						<td>
							<s:property value="courseHours" />

						</td>
						<td>
							<s:property value="credit" />
						</td>
						<td>
							<s:property value="version" />
						</td>
						<td>
						<span class="edit">
							<a class="btn btn-mini btn-primary"
								href="editToCourse.action?courseId=<s:property value="cno"/>">
								修改 </a>
						</span>
						<span class="del">
							<a class="btn btn-mini btn-primary" 
								href="deleteCourse.action?courseId=<s:property value="cno"/>" onclick="return confirm('是否删除')">
								删除 </a>
						</span>
						</td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="courseList.size() > 0">
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
