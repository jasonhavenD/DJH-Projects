<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>教学成果奖查询</title>

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
function findTeRebasein() {
	document.getElementById("findTeRebasein").submit();
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
	var Name = "" + '${teachReBaseModel.tresultName}';
	var tresultJibie = "" + '${teachReBaseModel.tresultJibie}';
	var tresultClass = "" + '${teachReBaseModel.tresultClass}';
	var rewardDepart = "" + '${teachReBaseModel.rewardDepart}';

	Name = encodeURI(Name);
	Name = encodeURI(Name);
	tresultJibie = encodeURI(tresultJibie);
	tresultJibie = encodeURI(tresultJibie);
	tresultClass = encodeURI(tresultClass);
	tresultClass = encodeURI(tresultClass);
	window.location.href = "teachResultBase_find.action?teachReBaseModel.tresultName="
			+ Name
			+ "&teachReBaseModel.tresultJibie="
			+ tresultJibie
			+ "&teachReBaseModel.tresultClass="
			+ tresultClass
			+ "&teachReBaseModel.year="
			+ '${teachReBaseModel.year}'
			+ "&teachReBaseModel.majorId="
			+ '${teachReBaseModel.majorId}'
			+ "&teachReBaseModel.departmentId="
			+ '${teachReBaseModel.departmentId}'
			+"&rows=" + rows
			+ "&page=" + page;
}

function setRows(rows) {
var Name = "" + '${teachReBaseModel.tresultName}';
	var tresultJibie = "" + '${teachReBaseModel.tresultJibie}';
	var tresultClass = "" + '${teachReBaseModel.tresultClass}';
	var rewardDepart = "" + '${teachReBaseModel.rewardDepart}';

	Name = encodeURI(Name);
	Name = encodeURI(Name);
	tresultJibie = encodeURI(tresultJibie);
	tresultJibie = encodeURI(tresultJibie);
	tresultClass = encodeURI(tresultClass);
	tresultClass = encodeURI(tresultClass);
	window.location.href = "teachResultBase_find.action?teachReBaseModel.tresultName="
			+ Name
			+ "&teachReBaseModel.tresultJibie="
			+ tresultJibie
			+ "&teachReBaseModel.tresultClass="
			+ tresultClass
			+ "&teachReBaseModel.year="
			+ '${teachReBaseModel.year}'
			+ "&teachReBaseModel.majorId="
			+ '${teachReBaseModel.majorId}'
			+ "&teachReBaseModel.departmentId="
			+ '${teachReBaseModel.departmentId}'
			+"&rows=" + rows.value+"&page=1";
}
//导出我的赛项列表
function exportSubContestTExcel() {
	var Name = "" + '${teachReBaseModel.tresultName}';
	var tresultJibie = "" + '${teachReBaseModel.tresultJibie}';
	var tresultClass = "" + '${teachReBaseModel.tresultClass}';
	var rewardDepart = "" + '${teachReBaseModel.rewardDepart}';

	Name = encodeURI(Name);
	Name = encodeURI(Name);
	tresultJibie = encodeURI(tresultJibie);
	tresultJibie = encodeURI(tresultJibie);
	tresultClass = encodeURI(tresultClass);
	tresultClass = encodeURI(tresultClass);
	rewardDepart = encodeURI(rewardDepart);
	rewardDepart = encodeURI(rewardDepart);
	window.location.href = "exportSubContestTExcel.action?exportName=teachresultbaseinfo"
			+ "&teachReBaseModel.tresultBaseNo="
			+ '${teachReBaseModel.tresultBaseNo}'
			+ "&teachReBaseModel.tresultName="
			+ Name
			+ "&teachReBaseModel.tresultJibie="
			+ tresultJibie
			+ "&teachReBaseModel.tresultClass="
			+ tresultClass
			+ "&teachReBaseModel.year="
			+ '${teachReBaseModel.year}'
			+ "&teachReBaseModel.approvalNumber="
			+ '${teachReBaseModel.approvalNumber}'
			+ "&teachReBaseModel.rewardDepart="
			+ rewardDepart
			+ "&teachReBaseModel.beizhu="
			+ '${teachReBaseModel.beizhu}'
			+ "&teachReBaseModel.tag=" + '${teachReBaseModel.tag}';
}
//上传附件弹出框
function upFile() {
	document.getElementById("iframe").src = "attachFileList.action?importName=teachresultbaseinfo";
	$('#alert-win').dialog( {
		width : 450,
		height : 240,
		buttons : {
			"关闭" : function() {
				findTeRebasein();
				$(this).dialog("close");
			}
		}
	});
}
//上传附件弹出框
function upFileB(){
	document.getElementById("iframe").src="attachFileList.action?importName=teachresult";
             $('#alert-win').dialog({
                 width: 450,
                 height: 240,
                 buttons: { "关闭": function () {
          		findTeRebasein();
                 $(this).dialog("close");} }
             });
}
</script>
	</head>
	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业数据采集
			<b class="tip"></b>查询教学成果奖信息
		</div>

		<form action="teachResultBase_find.action?page=1&rows=10"
			id="findTeRebasein" method="post" enctype="multipart/form-data">
			<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							教学成果奖信息查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td style="width: 60px;">
							奖励项目名称
						</td>
						<td>
							<input name="teachReBaseModel.tresultName" type="text"
								value='<s:property value="teachReBaseModel.tresultName"/>'
								type="text" />
						</td>
						<td>
							获奖年份
						</td>
						<td>
							<select name="teachReBaseModel.year" id="year">
								<option value="">
									全部年份
								</option>
								<s:iterator value="yearList" var="yearvar">
									<option value="<s:property/>"
										<s:if test="#yearvar == teachReBaseModel.year">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							学院
						</td>
						<td>
							<select size="1" name="teachReBaseModel.departmentId" id="coll"
								onchange="collchange();" class="department">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList" var="departmentvar">
									<option value="<s:property value='dno'/>"
									<s:if test="#departmentvar.dno ==teachReBaseModel.departmentId"></s:if>>
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							获奖等级
						</td>
						<td>
							<select name="teachReBaseModel.tresultClass" id="tresultClass">
								<option value="">
									全部级别
								</option>
								<s:iterator value="tresultClassList" var="tresultClassvar">
									<option value="<s:property/>"
										<s:if test="#tresultClassvar == teachReBaseModel.tresultClass">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width: 60px;">
							获奖级别
						</td>
						<td>
							<select name="teachReBaseModel.tresultJibie" id="tresultJibie">
								<option value="">
									全部级别
								</option>
								<s:iterator value="tresultJibieList" var="tresultJibievar">
									<option value="<s:property/>"
										<s:if test="#tresultJibievar == teachReBaseModel.tresultJibie">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width: 60px;">
							专业
						</td>
						<td>
							<select size="1" name="teachReBaseModel.majorId" id="major">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList" var="majorvar">
									<option value="<s:property value='mno'/>"
									<s:if test="#majorvar.mno == teachReBaseModel.majorId"></s:if>>
										<s:property value="mname" />
									</option>
								</s:iterator>
							</select>
						</td>
						</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="4">
							<a href="javascript:findTeRebasein();"
								class="btn btn-primary add">查询</a>&nbsp;&nbsp;
							<a href="#" onclick="exportSubContestTExcel()"
								class="btn btn-primary add">导出教学成果列表</a> &nbsp;&nbsp;
							<span style="color: red;">(先查询，再导出)</span>

						</td>
						<td colspan="2">
							<a id="add" class="btn btn-primary add"
								href="teachResultBase_add.action?tresultBaseNo=0"> 添加 </a>
							<!--选择导入的文件 -->
							<a id="attach" href="javascript:void(0);"
								onclick="upFile();return false;" class="btn btn-primary add">导入教学成果奖</a>
							<!--选择导入的文件 -->
							<span class="del"><a id="attachall" href="javascript:void(0);"
							onclick="upFileB();return false;" class="btn btn-primary add">导入所有教学成果奖成员</a></span>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>


		<table style="white-space: normal;" class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				教学成果奖信息列表
			</caption>
			<thead>
				<tr class="tr_title" style="height: 30px;">
					<td>
						#
					</td>
					<td>
						奖励项目名称
					</td>
					<td>
						获奖级别
					</td>
					<td>
						获奖等级
					</td>
					<td>
						获奖年份
					</td>
					<td>
						授予单位
					</td>
					<td>
						操作
					</td>

				</tr>
			</thead>
			<tbody>
				<s:if test="TeachresultbaseinfoList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有教师成果奖信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="TeachresultbaseinfoList" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td>
							<s:property value="tresultName" />
						</td>
						<td>
							<s:property value="tresultJibie" />
						</td>
						<td>
							<s:property value="tresultClass" />
						</td>
						<td>
							<s:property value="year" />
						</td>
						<td>
							<s:property value="rewardDepart" />
						</td>
						<td>
							<a class="btn btn-mini btn-primary"
								href="teachResultBase_initSee.action?tresultBaseNo=<s:property value="tresultBaseNo"/>&trows=<s:property value="rows"/>&tpage=<s:property value="page"/>&rows=10&page=1">
								查看 </a>
							<span class="edit"> <a class="btn btn-mini btn-primary"
								href="teachResultBase_edit.action?tresultBaseNo=<s:property value="tresultBaseNo"/>">
									修改 </a> </span>
							<span class="del"> <a class="btn btn-mini btn-primary"
								onclick="return confirm('确认删除   <s:property value="tresultName"/> 吗？');"
								href="teachResultBase_delete.action?tresultBaseNo=<s:property value="tresultBaseNo"/>">
									删除 </a> </span>
						</td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="TeachresultbaseinfoList.size() > 0">
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
			<tr>
				<!--<td colspan="99">
					<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
				</td>
			-->
			</tr>
		</tfoot>
	</body>
</html>
