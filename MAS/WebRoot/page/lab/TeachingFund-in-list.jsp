<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>教学经费查询</title>

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
$(document).ready(function() {
	// ------------------------------
		//角色判断
		body style="background-color:#e4dfd9" rol = $("#rol").val();
		var totalRows = $("#totalRows").val();
		if (rol == 4) {
			$("#attach").hide();//隐藏导入
			for ( var i = 0; i < totalRows; i++) {
				$("#edit").hide();
				$("#del").hide();

			}
		}
	});
//查询赛项
function findContestApply() {
	document.getElementById("form1").submit();
}

//上传附件弹出框
function upFile() {
	document.getElementById("iframe").src = "attachFileList.action?importName=teachcost";
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
	window.location.href = "findTeachingcost.action?teamodel.majorId="
			+ '${teamodel.majorId}' + "&teamodel.teachingcosttype.teachCostTypeNo="
			+ '${teamodel.teachingcosttype.teachCostTypeNo}' + "&teamodel.stuNumber="
			+ '${teamodel.stuNumber}' + "&teamodel.cost=" + '${teamodel.cost}'
			+ "&teamodel.useness=" + '${teamodel.useness}' + "&rows=" + rows
			+ "&page=" + page;
}

function setRows(rows) {
	window.location.href = "findTeachingcost.action?teamodel.majorId="
			+ '${teamodel.majorId}' + "&teamodel.teachingcosttype.teachCostTypeNo="
			+ '${teamodel.teachingcosttype.teachCostTypeNo}' + "&teamodel.stuNumber="
			+ '${teamodel.stuNumber}' + "&teamodel.cost=" + '${teamodel.cost}'
			+ "&teamodel.useness=" + '${teamodel.useness}' + "&rows="
			+ rows.value+"&page=1";
}

//导出我的赛项列表
function exportSubContestTExcel() {
	window.location.href = "exportSubContestTExcel.action?exportName=tea"
			+ "&teamodel.majorId=" + '${teamodel.majorId}'
			+ "&teamodel.teachingcosttype.teachCostTypeNo=" + '${teamodel.teachingcosttype.teachCostTypeNo}'
			+ "&teamodel.stuNumber=" + '${teamodel.stuNumber}'
			+ "&teamodel.cost=" + '${teamodel.cost}' + "&teamodel.useness="
			+ '${teamodel.useness}'
}
</script>

	</head>

	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业数据采集
			<b class="tip"></b>查询教学经费
		</div>

		<form action="findTeachingcost.action?page=1&rows=10" id="form1"
			name="form1" method="post" enctype="multipart/form-data">
			<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							教学经费查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td style="width: 60px;">
							使用类型
						</td>
						<td >
							<select size="1" id="col" name="teamodel.teachingcosttype.teachCostTypeNo">
								<option value="">
									全部类型
								</option>
								<s:iterator value="ttList" var="ttvar">
									<option value="<s:property value='teachCostTypeNo'/>"
									<s:if test="#ttvar.teachCostTypeNo == teamodel.teachingcosttype.teachCostTypeNo">selected="selected"</s:if>>
										<s:property value="useType"/>
									</option>
								</s:iterator>
							</select>
						</td>
                       <td>
							年份
						</td>
						<td colspan="3">
							<select name="teamodel.year" id="year">
								<option value="">
									全部年份
								</option>
								<s:iterator value="yearList" var="yearvar">
									<option value="<s:property/>"
										<s:if test="#yearvar == teamodel.year">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>

					</tr>
					<tr>

						<td>
							所在学院
						</td>
						<td>
							<select size="1" id="coll" name="teamodel.departmentId"
								class="department" onchange="collchange();">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList" var="departmentvar">
									<option value="<s:property value='dno'/>"
									<s:if test="#departmentvar.dno ==teamodel.departmentId"></s:if>>
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							所在专业
						</td>
						<td colspan="3">
							<select size="1" name="teamodel.majorId" id="major">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList" var="majorvar">
									<option value="<s:property value='mno'/>"
									<s:if test="#majorvar.mno ==teamodel.majorId"></s:if>>
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
								class="btn btn-primary add">导出教学经费列表</a> &nbsp;&nbsp;
							<span style="color: red;">(先查询，再导出)</span>

						</td>
						<td align="center">
						<span id="add">
							<a href="editToTeachingcost.action?costNumber=0" style=""
								class="btn btn-primary add">添加</a>
							<!--选择导入的文件 -->
							<a id="attach" href="javascript:void(0);"
								onclick="upFile();return false;" class="btn btn-primary add">导入</a>
</span>

						</td>
					</tr>
				</tfoot>
			</table>
		</form>

		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				教学经费查询结果
			</caption>
			<thead>
				<tr>
					<td>
						#
					</td>
					<td>
						学院名称
					</td>
					<td>
						专业名称
					</td>
					<td>
						使用类型
					</td>
					<!--<td>
						学生人数
					</td>
					--><td>
						经费(万元)
					</td>
					<td>
						用途
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
				<s:if test="teaList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有查询赛项信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="teaList" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
                         <td>
							<s:property value="major.department.dname" />
						</td>
						<td>
							<s:property value="major.mname" />
						</td>
						<td>
							<s:property value="teachingcosttype.useType" />
						</td>
						<!--<td>
							<s:property value="stuNumber" />
						</td>
						--><td>
							<s:property value="cost" />
						</td>
						<td>
							<s:property value="useness" />
						</td>
						<td>
							<s:property value="year" />
						</td>
						<td>
						<span class="edit">
							<a class="btn btn-mini btn-primary"
								href="editToTeachingcost.action?costNumber=<s:property value="costNumber"/>">
								修改 </a></span><span class="del">
							<a class="btn btn-mini btn-primary"
								href="deleteTeachingcost.action?costNumber=<s:property value="costNumber"/>"
								onclick="return confirm('是否删除')"> 删除 </a></span>


						</td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="teaList.size() > 0">
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
