<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>创新创业项目查询</title>

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
						url : 'innovation_findMajorByDno.action',
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
	
//查询教材信息
function search() {
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
	var ttname = "" + '${innovationModel.name}';
	ttname = encodeURI(ttname);
	ttname = encodeURI(ttname);
	var openSemester = "" + '${innovationModel.type}';
	openSemester = encodeURI(openSemester);
	openSemester = encodeURI(openSemester);
	var ctype = "" + '${innovationModel.level}';
	ctype = encodeURI(ctype);
	ctype = encodeURI(ctype);
	window.location.href = "innovation_find.action?innovationModel.name=" + ttname
			+ "&innovationModel.level=" +ctype
			+ "&innovationModel.type=" + openSemester
			+"&rows=" + rows + "&page="
			+ page;
}

function setRows(rows) {
var ttname = "" + '${innovationModel.name}';
	ttname = encodeURI(ttname);
	ttname = encodeURI(ttname);
	var openSemester = "" + '${innovationModel.type}';
	openSemester = encodeURI(openSemester);
	openSemester = encodeURI(openSemester);
	var ctype = "" + '${innovationModel.level}';
	ctype = encodeURI(ctype);
	ctype = encodeURI(ctype);
	window.location.href = "innovation_find.action?innovationModel.name=" + ttname
			+ "&innovationModel.level=" +ctype
			+ "&innovationModel.type=" + openSemester
			+"&rows=" + rows.value+"&page=1";
}


//导出我的赛项列表
function exportSubContestTExcel() {
	var ttname = "" + '${innovationModel.name}';
	ttname = encodeURI(ttname);
	ttname = encodeURI(ttname);
	var openSemester = "" + '${innovationModel.type}';
	openSemester = encodeURI(openSemester);
	openSemester = encodeURI(openSemester);
	var ctype = "" + '${innovationModel.level}';
	ctype = encodeURI(ctype);
	ctype = encodeURI(ctype);
	window.location.href = "exportSubContestTExcel.action?exportName=innovap"
			+ "&innovationModel.id=" + '${innovationModel.id}'
			+ "&innovationModel.name=" + ttname
			+ "&innovationModel.level=" +ctype
			+ "&innovationModel.type=" + openSemester
			+ "&innovationModel.year=" + '${innovationModel.year}'
			+ "&innovationModel.cost=" + '${innovationModel.cost}'
			+ "&innovationModel.setDate=" + '${innovationModel.setDate}'
			+ "&innovationModel.endDate=" + '${innovationModel.endDate}'
			+ "&innovationModel.assessment=" + '${innovationModel.assessment}'
			+ "&innovationModel.note=" + '${innovationModel.note}'
			+ "&innovationModel.tag=" + '${innovationModel.tag}';
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
	
	function findContestApply() {
	document.getElementById("form1").submit();
}
//上传附件弹出框
function upFile() {
	document.getElementById("iframe").src = "attachFileList.action?importName=innoproject";
	$('#alert-win').dialog( {
		width : 450,
		height : 240,
		buttons : {
			"关闭" : function() {
				search();
				$(this).dialog("close");
			}
		}
	});
}
function upFileM() {
	document.getElementById("iframe").src = "attachFileList.action?importName=innovationmember";
	$('#alert-win').dialog( {
		width : 450,
		height : 240,
		buttons : {
			"关闭" : function() {
				search();
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
			<b class="tip"></b>专业数据采集
			<b class="tip"></b>查询科创项目信息
		</div>

		<form action="innovation_find.action?rows=10&page=1" id="form1" name="form1"
			method="post" enctype="multipart/form-data">
			<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							科创项目信息查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td style="width: 60px;">
							项目名称
						</td>
						<td>
							<input name="innovationModel.Name"
								value='<s:property value="innovationModel.Name"/>' type="text" />
						</td>
						<td style="width: 60px;">
							项目级别
						</td>
						<td>
							<select name="innovationModel.level" id="level">
								<option value="">
									全部
								</option>
								<s:iterator value="levelList" var="levelvar">
									<option value="<s:property/>"
										<s:if test="#levelvar == innovationModel.level">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width: 60px;">
							项目类型
						</td>
						<td>
							<select name="innovationModel.type" id="type">
								<option value="">
									全部类型
								</option>
								<s:iterator value="typeList" var="typevar">
									<option value="<s:property/>"
										<s:if test="#typevar == innovationModel.type">selected="selected"</s:if>>
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
							<a href="javascript:search();" class="btn btn-primary add">查询</a>&nbsp;&nbsp;
							<a href="#" onclick="exportSubContestTExcel()"
								class="btn btn-primary add">导出科创项目列表</a> &nbsp;&nbsp;
							<span style="color: red;">(先查询，再导出)</span>

						</td>
						<td>

							<a id="add" class="btn btn-primary add"
								href="innovation_edit.action?innoNumber=''"> 添加</a>
							<!--选择导入的文件 -->
							<a id="attach" href="javascript:void(0);"
								onclick="upFile();return false;" class="btn btn-primary add">导入科创项目</a>
							<span class="del"><a id="attachall" href="javascript:void(0);"
								onclick="upFileM();return false;" class="btn btn-primary add">导入所有科创项目成员信息</a></span>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
		<table style="white-space: normal;" class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				创新创业项目列表
			</caption>
			<thead>
				<tr class="tr_title" style="height: 30px;">
					<td>
						#
					</td>
					<td>
						项目编号
					</td>
					<td>
						项目名称
					</td>

					<td>
						项目级别
					</td>
					<td>
						项目类型
					</td>
					<td>
						项目经费(万元)
					</td>
					<td>
						立项时间
					</td>
					<td>
						结题时间
					</td>
					<!--<td>
						验收结论
					</td>
					--><td>
						备注
					</td>
					<!--<td>
						标签
					</td>
					--><td>
						操作
					</td>

				</tr>
			</thead>
			<tbody>
				<s:if test="innovationprojectList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有项目信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="innovationprojectList" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td>
							<s:property value="innoNumber" />
						</td>
						<td>
							<s:property value="innoName" />
						</td>
						<td>
							<s:property value="level" />
						</td>
						<td>
							<s:property value="type" />
						</td>
						<td>
							<s:property value="cost" />
						</td>
						<td>
							<s:date name="setDate" format="yyyy-MM-dd" />
						</td>
						<td>
							<s:date name="endDate" format="yyyy-MM-dd" />
						</td>
						<!--<td>
							<s:property value="assessment" />
						</td>
						--><td>
							<s:property value="note" />
						</td>
						<!--<td>
							<s:property value="tag" />
						</td>
						--><td>
							<a class="btn btn-mini btn-primary"
								href="innovation_initSee.action?innoNumber=<s:property value="innoNumber"/>&trows=<s:property value="rows"/>&tpage=<s:property value="page"/>">
								查看 </a>
							<span class="edit"> <a class="btn btn-mini btn-primary"
								href="innovation_edit.action?innoNumber=<s:property value="innoNumber"/>">
									修改 </a>
							</span>
							<span class="del"> <a class="btn btn-mini btn-primary"
								onclick="return confirm('确认删除   <s:property value="innoName"/> 吗？');"
								href="innovation_delete.action?innoNumber=<s:property value="innoNumber"/>">
									删除 </a>
							</span>
						</td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="innovationprojectList.size() > 0">
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
		<tfoot>
			<!--<tr>
				<td colspan="99">
					<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
				</td>
			</tr>
		--></tfoot>
	</body>
</html>
