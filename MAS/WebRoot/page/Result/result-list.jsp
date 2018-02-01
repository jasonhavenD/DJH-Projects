<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>科研成果查询</title>

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
		//if (rol == 3) {
			//$("#attach").hide();//隐藏导入
			//$("#add").hide();//隐藏导入
			//for ( var i = 0; i < totalRows; i++) {
				//$(".edit").hide();
				//$(".del").hide();

			//}
		//}
	});
$(document).ready(function() {
	// ------------------------------	     
		$(".college").change(
				function() {

					$('#major option').remove();

					$.ajax( {
						type : "POST",
						url : 'findMajorByDno.action',
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
	var Name = "" + '${amodel.name}';
	var certificateJibie = "" + '${amodel.certificateJibie}';
	var certificateType = "" + '${amodel.certificateType}';
	var certificateClass = "" + '${amodel.certificateClass}';

	Name = encodeURI(Name);
	Name = encodeURI(Name);
	certificateJibie = encodeURI(certificateJibie);
	certificateJibie = encodeURI(certificateJibie);
	certificateType = encodeURI(certificateType);
	certificateType = encodeURI(certificateType);
	certificateClass = encodeURI(certificateClass);
	certificateClass = encodeURI(certificateClass);
	window.location.href = "findAchievements.action?amodel.id="
			+ '${amodel.id}'
			+ "&amodel.name="
			+ Name
			+ "&amodel.departRank="
			+ '${amodel.departRank}'
			+ "&amodel.certificateJibie="
			+ certificateJibie
			+ "&amodel.certificateType="
			+ certificateType
			+ "&amodel.certificateClass="
			+ certificateClass
			+"&amodel.majorId="+'${amodel.majorId}' +"&amodel.departmentId="+'${amodel.departmentId}'+"&rows=" + rows + "&page=" + page;
}

function setRows(rows) {

var Name = "" + '${amodel.name}';
	var certificateJibie = "" + '${amodel.certificateJibie}';
	var certificateType = "" + '${amodel.certificateType}';
	var certificateClass = "" + '${amodel.certificateClass}';

	Name = encodeURI(Name);
	Name = encodeURI(Name);
	certificateJibie = encodeURI(certificateJibie);
	certificateJibie = encodeURI(certificateJibie);
	certificateType = encodeURI(certificateType);
	certificateType = encodeURI(certificateType);
	certificateClass = encodeURI(certificateClass);
	certificateClass = encodeURI(certificateClass);
	
	window.location.href = "findAchievements.action?amodel.id="
			+ '${amodel.id}'
			+ "&amodel.name="
			+ Name
			+ "&amodel.departRank="
			+ '${amodel.departRank}'
			+ "&amodel.certificateJibie="
			+ certificateJibie
			+ "&amodel.certificateType="
			+ certificateType
			+ "&amodel.certificateClass="
			+ certificateClass
			+"&amodel.majorId="+'${amodel.majorId}' +"&amodel.departmentId="+'${amodel.departmentId}'+"&rows=" + rows.value+"&page=1";
			
}

//导出
function exportSubContestTExcel() {
	var Name = "" + '${amodel.name}';
	var certificateJibie = "" + '${amodel.certificateJibie}';
	var certificateType = "" + '${amodel.certificateType}';
	var certificateClass = "" + '${amodel.certificateClass}';

	Name = encodeURI(Name);
	Name = encodeURI(Name);
	certificateJibie = encodeURI(certificateJibie);
	certificateJibie = encodeURI(certificateJibie);
	certificateType = encodeURI(certificateType);
	certificateType = encodeURI(certificateType);
	certificateClass = encodeURI(certificateClass);
	certificateClass = encodeURI(certificateClass);
	window.location.href = "exportSubContestTExcel.action?exportName=achievements"
			+ "&amodel.id="
			+ '${amodel.id}'
			+ "&amodel.name="
			+ Name
			+ "&amodel.departRank="
			+ '${amodel.departRank}'
			+ "&amodel.certificateJibie="
			+ certificateJibie
			+ "&amodel.certificateType="
			+ certificateType
			+ "&amodel.certificateClass="
			+ certificateClass
			+ "&amodel.certificateDate="
			+ '${amodel.certificateDate}'
			+ "&amodel.beizhu="
			+ '${amodel.beizhu}'
			+ "&amodel.tag="
			+ '${amodel.tag}';
}

//查询
function findContestApply() {
	document.getElementById("form1").submit();
}

//查看成果详细信息
function findContestInfo(certificateNo) {
	window.location.href = "findAchievements.action?certificateNo=" + Id;
}
//修改成果信息
function modifyAchievements(certificateNo) {

	window.location.href = "editToAchievements.action?certificateNo="
			+ certificateNo;

}

//上传附件弹出框
function upFile() {
	document.getElementById("iframe").src = "attachFileList.action?importName=achievements";
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
			<b class="tip"></b>专业数据采集
			<b class="tip"></b>查询科研成果信息
		</div>

		<form action="findAchievements.action?page=1&rows=10" id="form1" name="form1"
			method="post" enctype="multipart/form-data">
			<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							科研成果信息查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td style="width: 60px;">
							成果编号
						</td>
						<td>
							<input name="amodel.Id" value='<s:property value="amodel.Id"/>'
								type="text" />
						</td>
						<td style="width: 60px;">
							成果名称
						</td>
						<td>
							<input name="amodel.Name"
								value='<s:property value="amodel.Name"/>' type="text" />
						</td>
						<td>
							获奖时间
						</td>
						<td>
							<select name="amodel.certificateDate" id="certificateDate">
								<option value="">
									全部年份
								</option>
								<s:iterator value="certificateDateList" var="certificateDatevar">
									<option value="<s:property/>"
										<s:if test="#certificateDatevar == amodel.certificateDate">selected="selected"</s:if>>
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
							<select name="amodel.certificateJibie" id="certificateJibie">
								<option value="">
									全部级别
								</option>
								<s:iterator value="C_jibie" var="certificateJibievar">
									<option value="<s:property/>"
										<s:if test="#certificateJibievar == amodel.certificateJibie">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width: 60px;">
							获奖类别
						</td>
						<td>

							<select name="amodel.certificateType" id="certificateType">
								<option value="">
									全部类别
								</option>
								<s:iterator value="C_type" var="certificateTypevar">
									<option value="<s:property/>"
										<s:if test="#certificateTypevar == amodel.certificateType">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width: 60px;">
							获奖等级
							<br />
						</td>
						<td>

							<select name="amodel.certificateClass" id="certificateClass">
								<option value="">
									全部类别
								</option>
								<s:iterator value="C_class" var="certificateClassvar">
									<option value="<s:property/>"
										<s:if test="#certificateClassvar == amodel.certificateClass">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>
				</tbody>

				<tr>
					<td colspan="5">
						<a href="javascript:findContestApply();"
							class="btn btn-primary add">查询</a>&nbsp;&nbsp;
						<a href="#" onclick="exportSubContestTExcel()"
							class="btn btn-primary add">导出科研成果列表</a> &nbsp;&nbsp;
						<span style="color: red;">(先查询，再导出)</span>

					</td>
					<td>
						<a id="add" class="btn btn-primary add"
							href="editToAchievements.action?certificateNo=null"> 添加 </a>
						<!--选择导入的文件 -->
						<a id="attach" href="javascript:void(0);"
							onclick="upFile();return false;" class="btn btn-primary add">导入</a>
					</td>

				</tr>

			</table>
		</form>


		<table  style="white-space: normal;" class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				科研成果列表
			</caption>
			<thead>
				<tr  style="height: 30px;">
					<td>
						#
					</td>
					<td>
						成果编号
					</td>
					<td >
						成果名称
					</td>
					<td>
						完成单位排名
					</td>
					<td>
						获奖级别
					</td>
					<td>
						获奖类别
					</td>
					<td>
						获奖等级
					</td>
					<td>
						获奖时间
					</td>
					<td>
						操作
					</td>

				</tr>
			</thead>
			<tbody>
				<s:if test="achievementslist.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有科研成果信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="achievementslist" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td>
							<s:property value="certificateNo" />
						</td>
						<td title='<s:property value="certificateName" />' style="word-break:break-all;width:300px;">
							
								<s:property value="certificateName" />
							
						</td>
						<td>
							<s:property value="departRank" />
						</td>

						<td>

							<s:property value="certificateJibie" />

						</td>
						<td>
							<s:property value="certificateType" />
						</td>
						<td>
							<s:property value="certificateClass" />
						</td>
						<td>
							<s:property value="certificateDate" />
						</td>

						<td>
							<a class="btn btn-mini btn-primary"
								href="findTeachAchieves.action?certificateNo=<s:property value="certificateNo"/>&trows=<s:property value="rows"/>&tpage=<s:property value="page"/>&rows=10&page=1">
								查看 </a>
							<span class="edit"> <a class="btn btn-mini btn-primary"
								href="editToAchievements.action?certificateNo=<s:property value="certificateNo"/>">
									修改 </a>
							</span>
							<span class="del"> <a class="btn btn-mini btn-primary"
								onclick="return confirm('确认删除吗？');"
								href="deleteAchievements.action?certificateNo=<s:property value="certificateNo"/>">
									删除 </a>
							</span>

						</td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="achievementslist.size() > 0">
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
