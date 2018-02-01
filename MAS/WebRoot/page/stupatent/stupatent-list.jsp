<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>学生获得专利</title>

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
		//角色判断
		var rol = $("#rol").val();
		var totalRows = $("#totalRows").val();
		if (rol == 2) {
			$("#attach").hide();//隐藏导入
			$("#add").hide();//隐藏导入
			for ( var i = 0; i < totalRows; i++) {
				$(".edit").hide();
				$(".del").hide();

			}
		}
	});


//查询赛项
function findContestApply() {
	document.getElementById("form1").submit();
}

//导入弹出框
function upFile() {
	document.getElementById("iframe").src = "attachFileList.action?importName=stup";
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
	var name = ""+'${stupmodel.name}';
	var stuName = ""+'${stupmodel.stuName}';
				name = encodeURI(name);
				name = encodeURI(name);
				stuName = encodeURI(stuName);
				stuName = encodeURI(stuName);
	window.location.href = "findStupatent.action?stupmodel.id="
			+ '${stupmodel.id}' + "&stupmodel.name=" + name
			+ "&stupmodel.majorId=" + '${stupmodel.majorId}'
			+ "&stupmodel.departmentId=" + '${stupmodel.departmentId}'
			+ "&stupmodel.year=" + '${stupmodel.year}'
			+ "&stupmodel.stuNumber=" + '${stupmodel.stuNumber}'
			+ "&stupmodel.stuName=" + stuName
			+ "&stupmodel.authorityDate=" + '${stupmodel.authorityDate}'
			+ "&stupmodel.pateType=" + '${stupmodel.pateType}'
			+ "&stupmodel.patentNumber=" + '${stupmodel.patentNumber}'
			+ "&stupmodel.note=" + '${stupmodel.note}'

			+ "&rows=" + rows + "&page=" + page;
}

function setRows(rows) {
var name = ""+'${stupmodel.name}';
	var stuName = ""+'${stupmodel.stuName}';
				name = encodeURI(name);
				name = encodeURI(name);
				stuName = encodeURI(stuName);
				stuName = encodeURI(stuName);
	window.location.href = "findStupatent.action?stupmodel.id="
			+ '${stupmodel.id}' + "&stupmodel.name=" + name
			+ "&stupmodel.majorId=" + '${stupmodel.majorId}'
			+ "&stupmodel.departmentId=" + '${stupmodel.departmentId}'
			+ "&stupmodel.year=" + '${stupmodel.year}'
			+ "&stupmodel.stuNumber=" + '${stupmodel.stuNumber}'
			+ "&stupmodel.stuName=" + stuName
			+ "&stupmodel.authorityDate=" + '${stupmodel.authorityDate}'
			+ "&stupmodel.pateType=" + '${stupmodel.pateType}'
			+ "&stupmodel.patentNumber=" + '${stupmodel.patentNumber}'
			+ "&stupmodel.note=" + '${stupmodel.note}'

			+ "&rows=" + rows.value+"&page=1";
}

//导出我的赛项列表
function exportSubContestTExcel() {
var name = ""+'${stupmodel.name}';
	var stuName = ""+'${stupmodel.stuName}';
				name = encodeURI(name);
				name = encodeURI(name);
				stuName = encodeURI(stuName);
				stuName = encodeURI(stuName);
	window.location.href = "exportSubContestTExcel.action?exportName=stup"
			+ "&stupmodel.id=" + '${stupmodel.id}' + "&stupmodel.name="
			+ name + "&stupmodel.majorId="
			+ '${stupmodel.majorId}' + "&stupmodel.departmentId="
			+ '${stupmodel.departmentId}' + "&stupmodel.year="
			+ '${stupmodel.year}' + "&stupmodel.stuNumber="
			+ '${stupmodel.stuNumber}' + "&stupmodel.stuName="
			+ stuName + "&stupmodel.authorityDate="
			+ '${stupmodel.authorityDate}' + "&stupmodel.pateType="
			+ '${stupmodel.pateType}' + "&stupmodel.patentNumber="
			+ '${stupmodel.patentNumber}' + "&stupmodel.note="
			+ '${stupmodel.note}'
}
</script>

	</head>

	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>学生获得专利
			<b class="tip"></b>查询学生获得专利信息
		</div>

		<form action="findStupatent.action?page=1&rows=10" id="form1"
			name="form1" method="post" enctype="multipart/form-data">
			<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />

			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							学生获得专利信息查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td style="width: 60px;">
							专利号
						</td>
						<td>
							<input name="stupmodel.patentNumber"
								value='<s:property value="stupmodel.patentNumber"/>' type="text" />
						</td>
						<td style="width: 60px;">
							专利名称
						</td>
						<td>
							<input name="stupmodel.Name"
								value='<s:property value="stupmodel.Name"/>' type="text" />
						</td>
						<td>
							获取年份
						</td>
						<td>
							<select name="stupmodel.year" id="year">
								<option value="">
									全部年份
								</option>
								<s:iterator value="yearList" var="yearvar">
									<option value="<s:property/>"
										<s:if test="#yearvar == stupmodel.year">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>

					</tr>
					<tr>
						<td style="width: 60px;">
							专利类别
						</td>
						<td colspan="3">
							<input name="stupmodel.pateType"
								value='<s:property value="stupmodel.pateType"/>' type="text" />
						</td>

						<td>
							申请人所在学院
						</td>
						<td>
							<select size="1" id="coll" name="stupmodel.departmentId"
								class="department" onchange="collchange();">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList" var="dvar">
									<option value="<s:property value='dno'/>" <s:if test="#dvar.dno==stupmodel.departmentId"></s:if>>
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							申请人学号
						</td>
						<td>
							<input name="stupmodel.stuNumber"
								value='<s:property value="stupmodel.stuNumber"/>' type="text" />
						</td>
						<td style="width: 60px;">
							申请人
						</td>
						<td>
							<input name="stupmodel.stuName"
								value='<s:property value="stupmodel.stuName"/>' type="text" />
						</td>


						<td>
							申请人所在专业
						</td>
						<td>
							<select size="1" name="stupmodel.majorId" id="major">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList" var="mvar">
									<option value="<s:property value='mno'/>" <s:if test="#mvar.mno==stupmodel.majorId"></s:if>>
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
								class="btn btn-primary add">导出学生获得专利信息列表</a> &nbsp;&nbsp;
							<span style="color: red;">(先查询，再导出)</span>

						</td>
						<td align="center">
							<span id="add"> <a href="editToStupatent.action?pnumber=0"
								style="" class="btn btn-primary add">添加</a>
							<!--选择导入的文件 --> <a
								id="attach" href="javascript:void(0);"
								onclick="upFile();return false;" class="btn btn-primary add">导入</a>
							</span>

						</td>
					</tr>
				</tfoot>
			</table>
		</form>

		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				学生获得专利信息查询结果
			</caption>
			<thead>
				<tr>
					<td>
						#
					</td>

					<td>
						专利号
					</td>
					<td>
						专利名称
					</td>
					<td>
						申请人学号
					</td>
					<td>
						申请人
					</td>
					<td>
						获取年份
					</td>
					<td>
						授权日期
					</td>
					<td>
						专利类别
					</td>
					<!--<td>
						获奖证书编号
					</td>
					--><td>
						备注
					</td>
					<td>
						操作
					</td>
				</tr>
			</thead>
			<tbody>
				<s:if test="stupList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有查询到专利信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="stupList" id="stupatent" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td>
							<s:property value="patentNumber" />
						</td>
						<td>
							<s:property value="pateName" />
						</td>
						<td>
							<s:property value="student.stuNumber" />
						</td>
						<td>
							<s:property value="student.stuName" />
						</td>

						<td>
							<s:property value="year" />

						</td>
						<td>
						<s:date name="authorityDate" format="yyyy-MM-dd" />


						</td>
						<td>
							<s:property value="pateType" />

						</td>
						<!--<td>
							<s:property value="certiNumber" />
						</td>
						--><td>
							<s:property value="note" />
						</td>
						<td>
							<span class="edit"> <a class="btn btn-mini btn-primary"
								href="editToStupatent.action?pnumber=<s:property value="pnumber"/>">
									修改 </a> </span>
							<span class="del"> <a class="btn btn-mini btn-primary"
								href="deleteStupatent.action?pnumber=<s:property value="pnumber"/>" onclick="return confirm('是否删除')">
									删除 </a> </span>
						</td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="stupList.size() > 0">

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
