<%@ page language="java" import="java.util.*"   pageEncoding="UTF-8"  %>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>竞赛获奖情况查询</title>

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

//查询赛项
function findCompetition() {
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
	window.location.href = "findCompetition.action?rows=" + rows + "&page="
			+ page;
}

function setRows(rows) {
	window.location.href = "findCompetition.action?rows=" + rows.value+"&page=1";
}

//导出我的赛项列表
function exportSubContestTExcel() {
    var comType = ""+'${comodel.comType}'; 
	var comName = ""+'${comodel.comName}'; 
	var comRank = ""+'${comodel.comRank}'; 
	 
	comName = encodeURI(comName); 
 	comName = encodeURI(comName);
 	comType = encodeURI(comType); 
 	comType = encodeURI(comType);
 	comRank = encodeURI(comRank); 
 	comRank = encodeURI(comRank); 
	window.location.href = "exportSubContestTExcel.action?exportName=competition"
			+ "&comodel.comNumber="
			+ '${comodel.comNumber}'
			+ "&comodel.comName="
			+ comName
			+ "&comodel.comType="
			+ comType
			+ "&comodel.comRank="
			+ comRank
			+ "&comodel.year="
			+ '${comodel.year}'
			+ "&comodel.note="
			+ '${comodel.note}' + "&comodel.tag=" + '${comodel.tag}'
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
//上传附件弹出框
function upFile() {
	document.getElementById("iframe").src = "attachFileList.action?importName=competition";
	$('#alert-win').dialog( {
		width : 450,
		height : 240,
		buttons : {
			"关闭" : function() {
				findCompetition();
				$(this).dialog("close");
			}
		}
	});
}
function upFileStu(){
				document.getElementById("iframe").src="attachFileList.action?importName=stucption";
                $('#alert-win').dialog({
                    width: 450,
                    height: 240,
                    buttons: { "关闭": function () { 
             		findCompetition();
                    $(this).dialog("close");} }
                });	
			}
</script>

	</head>

	<body style="background-color:#e4dfd9">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业数据采集
			<b class="tip"></b>查询竞赛获奖情况
		</div>

		<form action="findCompetition.action?page=1&rows=10" id="form1" name="form1"
			method="post" enctype="multipart/form-data">
			<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							竞赛获奖情况查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td style="width: 60px;">
							竞赛名称
						</td>
						<td>
							<input name="comodel.comName"
								value='<s:property value="comodel.comName"/>' type="text" />
						</td>
						<td>
							年份
						</td>
						<td colspan="3">
							<select name="comodel.year" id="year">
								<option value="">
									全部年份
								</option>
								<s:iterator value="yearList" var="yearvar">
									<option value="<s:property/>"
										<s:if test="#yearvar == comodel.year">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							获奖级别
						</td>
						<td>
							<select name="comodel.comType" id="comType">
								<option value="">
									请选择
								</option>
								<s:iterator value="typeList" var="comTypevar">
									<option value="<s:property/>"
										<s:if test="#comTypevar == comodel.comType">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width: 60px;">
							获奖等级
						</td>
						<td colspan="3">
							<select name="comodel.comRank" id="comRank">
								<option value="">
									全部等级
								</option>
								<s:iterator value="rankList" var="comRankvar">
									<option value="<s:property/>"
										<s:if test="#comRankvar == comodel.comRank">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>	
					</tr>
				</tbody>

				<tfoot>
					<tr>
						<td colspan="2">
							<a href="javascript:findCompetition();"
								class="btn btn-primary add">查询</a>&nbsp;&nbsp;
							<a href="#" onclick="exportSubContestTExcel()"
								class="btn btn-primary add">导出项目竞赛列表</a> &nbsp;&nbsp;
							<span style="color: red;">(先查询，再导出)</span>

						</td>
						<td colspan="2">
							<a id="add" class="btn btn-primary add" href="editToCompetition.action?comNumber=0">
								添加</a>							
						</td>
						<td>
							<!--选择导入的项目文件 -->
							<a id="attach" href="javascript:void(0);"
								onclick="upFile();return false;" class="btn btn-primary add">导入竞赛项目</a>
							
						</td>
							<!--选择导入的成员文件 -->
						<td>
							<span class="del"><a id="attach" href="javascript:void(0);"
								onclick="upFileStu();return false;" class="btn btn-primary add">导入所有竞赛项目成员</a></span>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>


		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				竞赛获奖情况列表
			</caption>
			<thead>
				<tr class="tr_title" style="height: 30px;">
					<td>
						#
					</td>
					<td>
						竞赛名称
					</td>

					<td>
						竞赛类别
					</td>
					<td>
						获奖等级
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
				<s:if test="competitionfindlist.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有竞赛获奖信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="competitionfindlist" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td>

							<s:property value="comName" />

						</td>
						<td>
							<s:property value="comType" />
						</td>
						<td>

							<s:property value="comRank" />

						</td>
						<td>
							<s:property value="year" />
						</td>
							<td>
								<s:property value="note" />
							</td>


							<td>
								<a class="btn btn-mini btn-primary"
									href="findStuCption.action?comNumber=<s:property value="comNumber"/>&trows=<s:property value="rows"/>&tpage=<s:property value="page"/>&page=1&rows=10">
									查看 </a>
									<span class="edit">
								<a class="btn btn-mini btn-primary"
									href="editToCompetition.action?comNumber=<s:property value="comNumber"/>">
									修改 </a></span>
									<span class="del">
								<a class="btn btn-mini btn-primary"
									onclick="return confirm('确认删除   <s:property value="comName"/> 吗？');"
									href="deleteCompetition.action?comNumber=<s:property value="comNumber"/>">
									删除 </a></span>

							</td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="competitionfindlist.size() > 0">
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
