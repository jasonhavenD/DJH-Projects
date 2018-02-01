<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>学生发表论文</title>

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
	var comName = "" + '${stutmodel.comName}';
	comName = encodeURI(comName);
	comName = encodeURI(comName);
	var sname = "" + '${stutmodel.name}';
	sname = encodeURI(sname);
	sname = encodeURI(sname);
	var journal = "" + '${stutmodel.journal}';
	journal = encodeURI(journal);
	journal = encodeURI(journal);
	var journalType= "" + '${stutmodel.journalType}';
	journalType = encodeURI(journalType);
	journalType = encodeURI(journalType);
	window.location.href = "findStuthesis.action?stutmodel.id="
			+ '${stutmodel.id}' + "&stutmodel.name=" + sname
			+ "&stutmodel.majorId=" + '${stutmodel.majorId}'
			+ "&stutmodel.departmentId=" + '${stutmodel.departmentId}'
			+ "&stutmodel.year=" + '${stutmodel.year}' + "&stutmodel.comName="
			+ comName + "&stutmodel.journal=" + journal
			+ "&stutmodel.journalType=" + journalType

			+ "&rows=" + rows + "&page=" + page;
}

function setRows(rows) {
	var comName = "" + '${stutmodel.comName}';
	comName = encodeURI(comName);
	comName = encodeURI(comName);
	var sname = "" + '${stutmodel.name}';
	sname = encodeURI(sname);
	sname = encodeURI(sname);
	var journal = "" + '${stutmodel.journal}';
	journal = encodeURI(journal);
	journal = encodeURI(journal);
	var journalType= "" + '${stutmodel.journalType}';
	journalType = encodeURI(journalType);
	journalType = encodeURI(journalType);
	window.location.href = "findStuthesis.action?stutmodel.id="
			+ '${stutmodel.id}' + "&stutmodel.name=" + sname
			+ "&stutmodel.majorId=" + '${stutmodel.majorId}'
			+ "&stutmodel.departmentId=" + '${stutmodel.departmentId}'
			+ "&stutmodel.year=" + '${stutmodel.year}' + "&stutmodel.comName="
			+ comName + "&stutmodel.journal=" + journal
			+ "&stutmodel.journalType=" + journalType
			+ "&rows=" + rows.value+"&page=1";
}
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

//导出
function exportSubContestTExcel() {

	var comName = "" + '${stutmodel.comName}';
	comName = encodeURI(comName);
	comName = encodeURI(comName);
	var sname = "" + '${stutmodel.name}';
	sname = encodeURI(sname);
	sname = encodeURI(sname);
	var journal = "" + '${stutmodel.journal}';
	journal = encodeURI(journal);
	journal = encodeURI(journal);
	var journalType= "" + '${stutmodel.journalType}';
	journalType = encodeURI(journalType);
	journalType = encodeURI(journalType);
	window.location.href = "exportSubContestTExcel.action?exportName=stut"+"&stutmodel.id="
			+ '${stutmodel.id}' + "&stutmodel.name=" + sname
			+ "&stutmodel.majorId=" + '${stutmodel.majorId}'
			+ "&stutmodel.departmentId=" + '${stutmodel.departmentId}'
			+ "&stutmodel.year=" + '${stutmodel.year}' + "&stutmodel.comName="
			+ comName + "&stutmodel.journal=" + journal
			+ "&stutmodel.journalType=" + journalType;
}
//上传附件弹出框
			function upFile(){
				document.getElementById("iframe").src="attachFileList.action?importName=stut";
                $('#alert-win').dialog({
                    width: 450,
                    height: 240,
                    buttons: { "关闭": function () {
             		findContestApply();
                    $(this).dialog("close");} }
                });
			}
</script>

	</head>

	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>学生发表论文
			<b class="tip"></b>查询学生发表论文信息
		</div>
		<form action="findStuthesis.action?page=1&rows=10" id="form1"
			name="form1" method="post" enctype="multipart/form-data">
<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />

			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							学生发表论文信息查询
						</td>
					</tr>
				</thead>
<tbody id="mytable">
					<tr>
						<td style="width: 60px;">
							论文名称
						</td>
						<td>
							<input name="stutmodel.comName" type="text" value="<s:property value='stutmodel.comName'/>"/>
						</td>
						<td style="width: 60px;">
							期刊类型
						</td>
						<td>
							<select name="stutmodel.journalType" id="isOpen">
								<option value="">
									--选择--
								</option>
								<option value="SCI" <s:if test="stutmodel.journalType=='SCI'">selected="selected"</s:if>>
									SCI
								</option>
								<option value="EI" <s:if test="stutmodel.journalType=='EI'">selected="selected"</s:if>>
									EI
								</option>
								<option value="其它" <s:if test="stutmodel.journalType=='其它'">selected="selected"</s:if>>
									其它
								</option>
								<option value="北大中文核心期刊" <s:if test="stutmodel.journalType=='北大中文核心期刊'">selected="selected"</s:if>>
									北大中文核心期刊
								</option>
							</select>
						</td>
						<td style="width: 60px;">
							发表期刊
						</td>
						<td>
							<select name="stutmodel.journal" id="year">
								<option value="">
									--选择--
								</option>
								<s:iterator value="journalList" var="journalvar">
									<option value="<s:property/>" <s:if test="#journalvar==stutmodel.journal">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							获取年份
						</td>
						<td>
							<select name="stutmodel.year" id="year">
								<option value="">
									全部年份
								</option>
								<s:iterator value="yearList" var="yearvar">
									<option value="<s:property/>" <s:if test="#yearvar==stutmodel.year">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							学生所在学院
						</td>
						<td>
							<select size="1" id="coll" name="stutmodel.departmentId"
								class="department" onchange="collchange();">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList" var="dvar">
									<option value="<s:property value='dno'/>" <s:if test="#dvar.dno==stutmodel.departmentId"></s:if>>
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							学生所在专业
						</td>
						<td>
							<select size="1" name="stutmodel.majorId" id="major">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList" var="mvar">
									<option value="<s:property value='mno'/>" <s:if test="#mvar.mno==stutmodel.majorId"></s:if>>
										<s:property value="mname" />
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							学号
						</td>
						<td>
							<input name="stutmodel.Id" type="text" value="<s:property value='stutmodel.Id'/>"/>
						</td>
						<td>
							姓名
						</td>
						<td colspan="3">
							<input name="stutmodel.Name" type="text" value="<s:property value='stutmodel.Name'/>"/>
						</td>
					</tr>
				</tbody>

				<tfoot>
					<tr>
						<td colspan="5">
							<a href="javascript:findContestApply();"
								class="btn btn-primary add">查询</a>&nbsp;&nbsp;
							<a href="#" onclick="exportSubContestTExcel()"
								class="btn btn-primary add">导出学生发表论文信息列表</a> &nbsp;&nbsp;
							<span style="color: red;">(先查询，再导出)</span>

						</td>
						<td align="center">
							<a id="add" href="editToStuthesis.action?thesisNumber=0" style=""
								class="btn btn-primary add">添加</a>
							<!--选择导入的文件 -->
							<a  id="attach" href="javascript:void(0);"
								onclick="upFile();return false;"
								class="btn btn-primary add">导入</a>

						</td>
					</tr>
				</tfoot>
			</table>
		</form>

		<table style="white-space: normal;" class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				学生发表论文信息查询结果
			</caption>
			<thead>
				<tr>
					<td>
						#
					</td>
					<td>
						论文名称
					</td>
					<td>
						学号
					</td>
					<td>
						姓名
					</td>
					<td>
						专业名称
					</td>
					<td>
						发表期刊
					</td>
					<td>
						期刊类型
					</td>
					<td>
						发表年份
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
				<s:if test="stuthesisList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有查询到相关课程资源信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="stuthesisList" id="cur" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td width="25%">
							<s:property value="comName" />
						</td>
						<td>
							<s:property value="student.stuNumber" />
						</td>
						<td>
							<s:property value="student.stuName" />
						</td>
						<td>
							<s:property value="student.major.mname" />
						</td>
						<td>
							<s:property value="journal" />
						</td>
						<td>
							<s:property value="journalType" />
						</td>
						<td>
							<s:property value="year" />

						</td>
						<td>
							<s:property value="note" />
						</td>
						<td width="7%">
						<span class="edit">
							<a class="btn btn-mini btn-primary"
								href="editToStuthesis.action?thesisNumber=<s:property value="thesisNumber"/>">
								修改 </a></span>
								<span class="del">
							<a class="btn btn-mini btn-primary"
								href="deleteStuthesis.action?thesisNumber=<s:property value="thesisNumber"/>" onclick="return confirm('是否删除')">
								删除 </a></span>
						</td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="stuthesisList.size() > 0">
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
