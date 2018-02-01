<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>课程资源</title>

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
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/MajorByDno.js">
</script>
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
//上传附件弹出框
function upFile() {
	document.getElementById("iframe").src = "attachFileList.action?importName=cur";
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
	window.location.href = "find.action?curmodel.id=" + '${curmodel.id}'
			+ "&curmodel.majorId=" + '${curmodel.majorId}'
			+ "&curmodel.departmentId=" + '${curmodel.departmentId}'
			+ "&curmodel.year=" + '${curmodel.year}' + "&curmodel.isOpen="
			+ '${curmodel.isOpen}' + "&curmodel.isExcellent="
			+ '${curmodel.isExcellent}'
			+ "&rows=" + rows + "&page=" + page;
}

function setRows(rows) {
	window.location.href = "find.action?curmodel.id=" + '${curmodel.id}'
			+ "&curmodel.majorId=" + '${curmodel.majorId}'
			+ "&curmodel.departmentId=" + '${curmodel.departmentId}'
			+ "&curmodel.year=" + '${curmodel.year}' + "&curmodel.isOpen="
			+ '${curmodel.isOpen}' + "&curmodel.isExcellent="
			+ '${curmodel.isExcellent}'
			+ "&rows=" + rows.value;
}
$(document).ready(function() {
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
		if (rol == 2||rol == 3||rol == 4||rol == 5) {
			$("#clear").hide();//隐藏清空
		}
	});
//导出
function exportSubContestTExcel() {
	window.location.href = "exportSubContestTExcel.action?exportName=cur"
			+ "&curmodel.id=" + '${curmodel.id}' + "&curmodel.majorId="
			+ '${curmodel.majorId}' + "&curmodel.departmentId="
			+ '${curmodel.departmentId}' + "&curmodel.year="
			+ '${curmodel.year}' + "&curmodel.isOpen=" + '${curmodel.isOpen}'
			+ "&curmodel.isExcellent=" + '${curmodel.isExcellent}';
}
</script>

	</head>

	<body style="background-color:#e4dfd9">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业课程资源
			<b class="tip"></b>查询专业课程资源信息
		</div>
		<form action="find.action?page=1&rows=10" id="form1" name="form1"
			method="post" enctype="multipart/form-data">

			<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							课程资源信息查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td>
							课程名称
						</td>
						<td>
							<select size="1" name="curmodel.Id" id="course">
								<option value="">
									全部课程
								</option>
								<s:iterator value="courseList" var="cnamevar">
									<option value="<s:property value='cno'/>"
									<s:if test="#cnamevar.cno == curmodel.Id">selected="selected"</s:if>>
										<s:property value="cname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width: 60px;">
							是否开出
						</td>
						<td>
						<select size="1" name="curmodel.isOpen" id="isOpen">
								<option value="">全部选项</option>
								<option value="Y"
									<s:if test="'Y'==curmodel.isOpen">selected="selected"</s:if>>
									是
								</option>
								<option value="N"
									<s:if test="'N'==curmodel.isOpen">selected="selected"</s:if>>
									否
								</option>
							</select>
						</td>
						<td style="width: 60px;">
							是否优质课程
						</td>
						<td>
							<select name="curmodel.isExcellent" id="isExcellent">
								<option value="">
									--选择--
								</option>
								<option value="Y"
								<s:if test="'Y'==curmodel.isExcellent">selected="selected"</s:if>>
									是
								</option>
								<option value="N"
								<s:if test="'N'==curmodel.isExcellent">selected="selected"</s:if>>
									否
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							获取年份
						</td>
						<td>
							<select name="curmodel.year" id="year">
								<option value="">
									全部年份
								</option>
								<s:iterator value="yearList" var="yearvar">
									<option value="<s:property/>"
										<s:if test="#yearvar == curmodel.year">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							所在学院
						</td>
						<td>
							<select size="1" id="coll" name="curmodel.departmentId"
								class="department" onchange="collchange();">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList" var="departmentvar">
									<option value="<s:property value='dno'/>"
									<s:if test="#departmentvar.dno ==curmodel.departmentId"></s:if>>
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							所在专业
						</td>
						<td>
							<select size="1" name="curmodel.majorId" id="major">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList" var="majorvar">
									<option value="<s:property value='mno'/>"
									<s:if test="#majorvar.mno ==curmodel.majorId"></s:if>>
										<s:property value="mname" />
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
								class="btn btn-primary add">导出课程资源信息列表</a> &nbsp;&nbsp;
							<span style="color: red;">(先查询，再导出)</span>

						</td>
						<td align="center">
							<a id="add" href="editToCurriculumresource.action?sourNumer=0"
								style="" class="btn btn-primary add">添加</a>
							<!--选择导入的文件 -->
							<a id="attach" href="javascript:void(0);"
								onclick="upFile();return false;" class="btn btn-primary add">导入</a>
							<!--清空所有信息 -->
							<span class="del"><a id="clear" href="clearCurriculumresource.action"
								onclick="return confirm('确认删除所有课程资源信息吗？');"
								class="btn btn-primary add">清空所有数据</a></span>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>

		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				课程资源信息查询结果
			</caption>
			<thead>
				<tr>
					<td>
						#
					</td>
					<td>
						编号
					</td>
					<td>
						课程名称
					</td>
					<td>
						专业名称
					</td>
					<td>
						是否开出
					</td>
					<td>
						是否优质课程
					</td>
					<td>
						课程规划
					</td>
					<td>
						年份
					</td>
					<td>
						备注
					</td>
					<td>
						操作
					</td>
				</tr>
			</thead>
			<tbody>
				<s:if test="curList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有查询到相关课程资源信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="curList" id="cur" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td>
							<s:property value="sourNumer" />
						</td>
						<td>
							<s:property value="course.cname" />
						</td>
						<td>
							<s:property value="major.mname" />
						</td>
						<td>
							<s:property value="isOpen" />
						</td>
						<td>
							<s:property value="isExcellent" />
						</td>
						<td>
							<s:property value="coursePlann" />
						</td>
						<td>
							<s:property value="year" />

						</td>
						<td>
							<s:property value="note" />
						</td>
						<td>
							<span class="edit"> <a class="btn btn-mini btn-primary"
								href="editToCurriculumresource.action?sourNumer=<s:property value="sourNumer"/>">
									修改 </a> </span>
							<span class="del"> <a class="btn btn-mini btn-primary"
								href="deleteCurriculumresource.action?sourNumer=<s:property value="sourNumer"/>"
								onclick="return confirm('是否删除')"> 删除 </a> </span>
						</td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="curList.size() > 0">
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
