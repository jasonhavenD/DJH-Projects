<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>教学计划变更</title>

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
		if (rol == 2||rol == 3||rol == 4||rol == 5) {
			$("#clear").hide();//隐藏清空
		}
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
	var changeType = "" + '${tplanmodel.changeType}';
	changeType = encodeURI(changeType);
	changeType = encodeURI(changeType);
	var changeMode = "" + '${tplanmodel.changeMode}';
	changeMode = encodeURI(changeMode);
	changeMode = encodeURI(changeMode);
	window.location.href = "findTplan.action?tplanmodel.id="
			+ '${tplanmodel.id}' + "&tplanmodel.grade=" + '${tplanmodel.grade}'
			+ "&tplanmodel.changeType=" + changeType
			+ "&tplanmodel.changeMode=" + changeMode
			+ "&tplanmodel.changeDate=" + '${tplanmodel.changeDate}'
			+ "&tplanmodel.adjustNature=" + '${tplanmodel.adjustNature}'
			+ "&tplanmodel.year=" + '${tplanmodel.year}'
			+ "&tplanmodel.departmentId=" + '${tplanmodel.departmentId}'
			+ "&tplanmodel.majorId=" + '${tplanmodel.majorId}'

			+ "&rows=" + rows + "&page=" + page;
}

function setRows(rows) {
var changeType = "" + '${tplanmodel.changeType}';
	changeType = encodeURI(changeType);
	changeType = encodeURI(changeType);
	var changeMode = "" + '${tplanmodel.changeMode}';
	changeMode = encodeURI(changeMode);
	changeMode = encodeURI(changeMode);
	window.location.href = "findTplan.action?tplanmodel.id="
			+ '${tplanmodel.id}' + "&tplanmodel.grade=" + '${tplanmodel.grade}'
			+ "&tplanmodel.changeType=" + changeType
			+ "&tplanmodel.changeMode=" + changeMode
			+ "&tplanmodel.changeDate=" + '${tplanmodel.changeDate}'
			+ "&tplanmodel.adjustNature=" + '${tplanmodel.adjustNature}'
			+ "&tplanmodel.year=" + '${tplanmodel.year}'
			+ "&tplanmodel.departmentId=" + '${tplanmodel.departmentId}'
			+ "&tplanmodel.majorId=" + '${tplanmodel.majorId}' + "&rows="
			+ rows.value+"&page=1";
}

//导出
function exportSubContestTExcel() {
	var changeType = "" + '${tplanmodel.changeType}';
	changeType = encodeURI(changeType);
	changeType = encodeURI(changeType);
	var changeMode = "" + '${tplanmodel.changeMode}';
	changeMode = encodeURI(changeMode);
	changeMode = encodeURI(changeMode);
	window.location.href = "exportSubContestTExcel.action?exportName=tplan"
			+ "&tplanmodel.id=" + '${tplanmodel.id}' + "&tplanmodel.grade="
			+ '${tplanmodel.grade}' + "&tplanmodel.changeType=" + changeType
			+ "&tplanmodel.changeMode=" + changeMode
			+ "&tplanmodel.changeDate=" + '${tplanmodel.changeDate}'
			+ "&tplanmodel.adjustNature=" + '${tplanmodel.adjustNature}'
			+ "&tplanmodel.year=" + '${tplanmodel.year}'
			+ "&tplanmodel.departmentId=" + '${tplanmodel.departmentId}'
			+ "&tplanmodel.majorId=" + '${tplanmodel.majorId}';
}
//上传附件弹出框
function upFile() {
	document.getElementById("iframe").src = "attachFileList.action?importName=tplan";
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
			<b class="tip"></b>教学计划变更
			<b class="tip"></b>查询教学计划变更信息
		</div>
		<form action="findTplan.action?page=1&rows=10" id="form1" name="form1"
			method="post" enctype="multipart/form-data">

			<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							教学计划变更查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td style="width: 60px;">
							课程名称
						</td>
						<td>
							<select size="1" id="cname" name="tplanmodel.Id">
								<option value="">
									--选择--
								</option>
								<s:iterator value="courseList" var="cnamevar">
									<option value="<s:property value='cno'/>"
									<s:if test="#cnamevar.cno == tplanmodel.Id">selected="selected"</s:if>>
										<s:property value="cname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width: 60px;">
							年级
						</td>
						<td>
							<select size="1" id="grade" name="tplanmodel.grade">
								<option value="">
									--选择--
								</option>
								<s:iterator value="gradeList" var="gradevar">
									<option value="<s:property />"
									<s:if test="#gradevar== tplanmodel.grade">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width: 60px;">
							调整性质
						</td>
						<td>
							<select name="tplanmodel.adjustNature" id="adjustNature">
								<option value="">
									--选择--
								</option>
								<option value="0" <s:if test=" 0 == tplanmodel.adjustNature">selected="selected"</s:if>>
									优化方案
								</option>
								<option value="1" <s:if test=" 1 == tplanmodel.adjustNature">selected="selected"</s:if>>
									其他
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							变动类型
						</td>
						<td>
							<select name="tplanmodel.changeType" id="changeType">
								<option value="">
									--选择--
								</option>
								<option value="增加课程" <s:if test=" '增加课程'== tplanmodel.changeType">selected="selected"</s:if>>
									增加课程
								</option>
								<option value="取消课程" <s:if test=" '取消课程'== tplanmodel.changeType">selected="selected"</s:if>>
									取消课程
								</option>
								<option value="学分调整" <s:if test=" '学分调整'== tplanmodel.changeType">selected="selected"</s:if>>
									学分调整
								</option>
								<option value="课程性质变更" <s:if test=" '课程性质变更'== tplanmodel.changeType">selected="selected"</s:if>>
									课程性质变更
								</option>
								<option value="开课学期调整" <s:if test=" '开课学期调整'== tplanmodel.changeType">selected="selected"</s:if>>
									开课学期调整
								</option>
								<option value="其他" <s:if test=" '其他'== tplanmodel.changeType">selected="selected"</s:if>>
									其他
								</option>
							</select>
						</td>
						<td>
							所在学院
						</td>
						<td>
							<select size="1" id="coll" name="tplanmodel.departmentId"
								class="department" onchange="collchange();">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList" var="departmentvar">
									<option value="<s:property value='dno'/>"
									<s:if test="#departmentvar.dno == tplanmodel.departmentId"></s:if>>
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							所在专业
						</td>
						<td>
							<select size="1" name="tplanmodel.majorId" id="major">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList" var="majorvar">
									<option value="<s:property value='mno'/>"
									<s:if test="#majorvar.mno == tplanmodel.majorId"></s:if>>
										<s:property value="mname" />
									</option>
								</s:iterator>
							</select>
						</td>

					</tr>
					<tr>
						<td style="width: 60px;">
							变更方式
						</td>
						<td>
							<select name="tplanmodel.changeMode" id="changeMode">
								<option value="">
									--选择--
								</option>
								<option value="临时变更"
								<s:if test="'临时变更' == tplanmodel.changeMode">selected="selected"</s:if>>
									临时变更
								</option>
								<option value="永久变更"
								<s:if test="'永久变更' == tplanmodel.changeMode">selected="selected"</s:if>>
									永久变更
								</option>
							</select>
						</td>
						<td>
							年份
						</td>
						<td colspan="3">
							<select name="tplanmodel.year" id="year">
								<option value="">
									全部年份
								</option>
								<s:iterator value="yearList" var="yearvar">
									<option value="<s:property/>"
									<s:if test="#yearvar == tplanmodel.year">selected="selected"</s:if>>
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
								class="btn btn-primary add">导出教学计划变更列表</a> &nbsp;&nbsp;
							<span style="color: red;">(先查询，再导出)</span>

						</td>
						<td align="center">
							<a id="add" href="editToTplan.action?teachPlanChaneId=0" style=""
								class="btn btn-primary add">添加</a>
							<!--选择导入的文件 -->
							<a id="attach" href="javascript:void(0);"
								onclick="upFile();return false;" class="btn btn-primary add">导入</a>
							<!--清空所有信息 -->
							<span class="del"><a id="clear" href="clearTplan.action"
								onclick="return confirm('确认删除所有教学计划变更信息吗？');"
								class="btn btn-primary add">清空所有数据</a></span>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
		<table  style="white-space: normal;" class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				教学计划变更查询结果
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
						课程性质
					</td>
					<td>
						变动类型
					</td>
					<td>
						变更方式
					</td>
					<td>
						变更日期
					</td>
					<td>
						调整性质
					</td>
					<td>
						年级
					</td>
					<td>
						年份
					</td>
					<td>
						操作
					</td>
				</tr>
			</thead>
			<tbody>
				<s:if test="tplanList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有查询到课程信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="tplanList" id="tplan" status="L">
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
							<s:property value="courseNature" />
						</td>
						<td>
							<s:property value="changeType" />
						</td>
						<td>
							<s:property value="changeMode" />
						</td>
						<td>
							<fmt:formatDate pattern="yyyy-MM-dd" value="${changeDate}" />
						</td>
						<td>
							<s:set name="adjustNature" value="adjustNature"></s:set>
							<s:if test='0==adjustNature'>优化方案</s:if>
							<s:if test='1==adjustNature'>其他</s:if>
						</td>
						<td>
							<s:property value="grade" />

						</td>
						<td>
							<s:property value="year" />
						</td>
						<td>
							<span class="edit"> <a class="btn btn-mini btn-primary"
								href="editToTplan.action?teachPlanChaneId=<s:property value="teachPlanChaneId"/>">
									查看详细/修改 </a> </span>
							<span class="del"> <a id="del"
								class="btn btn-mini btn-primary"
								href="deleteTplan.action?teachPlanChaneId=<s:property value="teachPlanChaneId"/>" onclick="return confirm('是否删除')">
									删除 </a> </span>
						</td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="tplanList.size() > 0">
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
