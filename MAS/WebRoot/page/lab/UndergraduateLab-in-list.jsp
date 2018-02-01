<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>本科实验实训场地查询</title>

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
function findContestApply() {
	document.getElementById("form1").submit();
}

//查看赛项详细信息
function findContestInfo(conId) {
	window.location.href = "editTrainingvenue.action?traNumer=" + conId;
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
var ttname = "" + '${tramodel.traName}';
	ttname = encodeURI(ttname);
	ttname = encodeURI(ttname);
	var openSemester = "" + '${tramodel.traCharacter}';
	openSemester = encodeURI(openSemester);
	openSemester = encodeURI(openSemester);
	window.location.href = "findTrainingvenue.action?tramodel.traNumer="+ '${tramodel.traNumer}'
			+ "&tramodel.traName="+ ttname
			+ "&tramodel.traCharacter="+ openSemester
			+ "&tramodel.area="+ '${tramodel.area}'
			+ "&tramodel.year=" + '${tramodel.year}'+"&rows=" + rows + "&page=" + page;
}

function setRows(rows) {
var ttname = "" + '${tramodel.traName}';
	ttname = encodeURI(ttname);
	ttname = encodeURI(ttname);
	var openSemester = "" + '${tramodel.traCharacter}';
	openSemester = encodeURI(openSemester);
	openSemester = encodeURI(openSemester);
	window.location.href = "findTrainingvenue.action?tramodel.traNumer="+ '${tramodel.traNumer}'
			+ "&tramodel.traName="+ ttname
			+ "&tramodel.traCharacter="+ openSemester
			+ "&tramodel.area="+ '${tramodel.area}'
			+ "&tramodel.year=" + '${tramodel.year}'+"&rows=" + rows.value+"&page=1";
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
	});

//导出我的赛项列表
function exportSubContestTExcel() {
	var ttname = "" + '${tramodel.traName}';
	  ttname = encodeURI(ttname);
	ttname = encodeURI(ttname);
	var openSemester = "" + '${tramodel.traCharacter}';
	openSemester = encodeURI(openSemester);
	openSemester = encodeURI(openSemester);
	window.location.href = "exportSubContestTExcel1.action?exportName=traingvenue"
			+ "&tramodel.traNumer="+ '${tramodel.traNumer}'
			+ "&tramodel.traName="+ ttname
			+ "&tramodel.traCharacter="+ openSemester
			+ "&tramodel.area="+ '${tramodel.area}'
			+ "&tramodel.year=" + '${tramodel.year}';

}
//上传附件弹出框
function upFile() {
	document.getElementById("iframe").src = "attachFileList.action?importName=traingvenue";
	$('#alert-win').dialog( {
		width : 450,
		height : 240,
		buttons : {
			"关闭" : function() {
				findContestApply();
				$(this).dialog("close");
			}
		}
	});}
</script>

	</head>

	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业数据采集
			<b class="tip"></b>查询本科实验实训场地
		</div>

		<form action="findTrainingvenue.action?page=1&rows=10" id="form1" name="form1"
			method="post" enctype="multipart/form-data">
			<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							本科实验实训场地查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td style="width: 60px;">
							实验室编号
						</td>
						<td>
							<input name="tramodel.traNumer"
								value='<s:property value="tramodel.traNumer"/>' type="text" />
						</td>
						<td style="width: 60px;">
							实验室名称
						</td>
						<td>
							<input name="tramodel.traName"
								value='<s:property value="tramodel.traName"/>' type="text" />
						</td>
						<td>
							年份
						</td>
						<td>
							<select name="tramodel.year" id="year">
								<option value="">
									全部年份
								</option>
								<s:iterator value="yearList" var="yearvar">
									<option value="<s:property/>"
										<s:if test="#yearvar == tramodel.year">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							面积
						</td>
						<td>
							<input name="tramodel.area"
								value='<s:property value="tramodel.area"/>' type="text" />
						</td>
						<td style="width: 60px;">
							类型
						</td>
						<td colspan="3">
							<select name="tramodel.traCharacter" id="traCharacter">
								<option value="">
									全部类型
								</option>
								<s:iterator value="tcList" var="traCharactervar">
									<option value="<s:property/>"
										<s:if test="#traCharactervar == tramodel.traCharacter">selected="selected"</s:if>>
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
								class="btn btn-primary add">导出</a> &nbsp;&nbsp;
							<span style="color: red;">(先查询，再导出)</span>

						</td>
						<td align="center">
							<span id="add"> <a href="editToTrainingvenue.action?traNumer='0'"
								class="btn btn-primary add">添加</a> <a href="#"
								onclick="upFile();return false;"
								class="btn btn-primary add">导入</a> </span>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>

		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				本科实验实训场地查询结果
			</caption>
			<thead>
				<tr>
					<td>
						#
					</td>
					<td>
						实验室编号
					</td>
					<td>
						实验室名称
					</td>
					<td>
						实验室性质
					</td>
					<td>
						面积(m²)
					</td>
					<td>
						最大可容纳的<br/>学生人数
					</td>
					<td>
						实验仪器设备<br/>总价值(万元)
					</td>
					<td>
						1000元以上设备<br/>总价值(万元)
					</td>
					<td>
						实验室开放<br/>使用人数
					</td>
					<td>
						使用年份
					</td>
					<td>
						操作
					</td>
				</tr>
			</thead>
			<tbody>
				<s:if test="trainingvenueList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有查询信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="trainingvenueList" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td>
							<s:property value="traNumer" />
						</td>
						<td>
							<s:property value="traName" />
						</td>
						<td>
							<s:property value="traCharacter" />
						</td>
						<td>
							<s:property value="area" />
						</td>
						<td>
							<s:property value="aptCount" />
						</td>
						<td>
							<s:property value="eaquipAllVal" />
						</td>
						<td>
							<s:property value="equipVal" />
						</td>
						<td>
							<s:property value="useCount" />
						</td>
						<td>
							<s:property value="year" />
						</td>
						<td>
							<!--<a class="btn btn-mini btn-primary"
								href="javascript:findContestInfo('<s:property value="traNumer"/>');">
								查看 </a>-->
							<!--<a class="btn btn-mini btn-primary"
								href="editToE.action?traNumer=<s:property value="traNumer"/>">
								设备 </a>
							--><span class="edit"> <a class="btn btn-mini btn-primary"
								href="editToTrainingvenue.action?traNumer=<s:property value="traNumer"/>">
									修改 </a>
							</span><span class="del"> <a class="btn btn-mini btn-primary"
								href="deleteTrainingvenue.action?traNumer=<s:property value="traNumer"/>"
								onclick="return confirm('是否删除')"> 删除 </a>
							</span>

						</td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="trainingvenueList.size() > 0">
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
