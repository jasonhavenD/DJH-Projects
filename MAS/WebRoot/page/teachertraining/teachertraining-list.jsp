<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>教师进修培训</title>

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
		if (rol == 4) {
			$("#attach").hide();//隐藏导入
			$("#add").hide();//隐藏导入
			for ( var i = 0; i < totalRows; i++) {
				$(".edit").hide();
				$(".del").hide();

			}
		}
	});

//导入弹出框
function upFile() {
	document.getElementById("iframe").src = "attachFileList.action?importName=teat";
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

//查询赛项
function findContestApply() {
	document.getElementById("form1").submit();
}

//查看赛项详细信息
function findContestInfo(effNumber) {
	window.location.href = "editToTeat.action?teacherTrainingNo="
			+ teacherTrainingNo;
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
	var trainContend = "" + '${teatmodel.trainContend}';
	trainContend = encodeURI(trainContend);
	trainContend = encodeURI(trainContend);
	window.location.href = "findTeat.action?teatmodel.id=" + '${teatmodel.id}'
			+ "&teatmodel.name=" + '${teatmodel.name}'
			+ "&teatmodel.departmentId=" + '${teatmodel.departmentId}'
			+ "&teatmodel.year=" + '${teatmodel.year}' + "&teatmodel.majorId="
			+ '${teatmodel.majorId}' + "&teatmodel.tname="
			+ '${teatmodel.tname}' + "&teatmodel.trainContend=" + trainContend
			+ "&teatmodel.trainType=" + '${teatmodel.trainType}'
			+ "&teatmodel.trainingArea=" + '${teatmodel.trainingArea}'
			+ "&teatmodel.trainDate=" + '${teatmodel.trainDate}'
			+ "&teatmodel.trainTime=" + '${teatmodel.trainTime}'
			+ "&teatmodel.getCertificate=" + '${teatmodel.getCertificate}'
			+ "&teatmodel.givenCertificateDepart="
			+ '${teatmodel.givenCertificateDepart}'
			+ "&teatmodel.isIndustryTrain=" + '${teatmodel.isIndustryTrain}'
			+ "&teatmodel.isPraticeTeachTraining="
			+ '${teatmodel.isPraticeTeachTraining}' + "&rows=" + rows
			+ "&page=" + page;
}

function setRows(rows) {
	var trainContend = "" + '${teatmodel.trainContend}';
	trainContend = encodeURI(trainContend);
	trainContend = encodeURI(trainContend);
	 
	window.location.href = "findTeat.action?teatmodel.id=" + '${teatmodel.id}'
			+ "&teatmodel.name=" + '${teatmodel.name}'
			+ "&teatmodel.departmentId=" + '${teatmodel.departmentId}'
			+ "&teatmodel.year=" + '${teatmodel.year}' + "&teatmodel.majorId="
			+ '${teatmodel.majorId}' + "&teatmodel.tname="
			+ '${teatmodel.tname}' + "&teatmodel.trainContend=" + trainContend
			+ "&teatmodel.trainType=" + '${teatmodel.trainType}'
			+ "&teatmodel.trainingArea=" + '${teatmodel.trainingArea}'
			+ "&teatmodel.trainDate=" + '${teatmodel.trainDate}'
			+ "&teatmodel.trainTime=" + '${teatmodel.trainTime}'
			+ "&teatmodel.getCertificate=" + '${teatmodel.getCertificate}'
			+ "&teatmodel.givenCertificateDepart="
			+ '${teatmodel.givenCertificateDepart}'
			+ "&teatmodel.isIndustryTrain=" + '${teatmodel.isIndustryTrain}'
			+ "&teatmodel.isPraticeTeachTraining="
			+ '${teatmodel.isPraticeTeachTraining}' + "&rows=" + rows.value+"&page=1";
}

//导出
function exportSubContestTExcel() {
	var trainContend = "" + '${teatmodel.trainContend}';
	trainContend = encodeURI(trainContend);
	trainContend = encodeURI(trainContend);
	var pname = ""+'${teatmodel.name}'; 
	var pprojecType = ""+'${teatmodel.trainType}'; 
	
 	pname = encodeURI(pname); 
 	pname = encodeURI(pname);
 	pprojecType = encodeURI(pprojecType); 
 	pprojecType = encodeURI(pprojecType);
	window.location.href = "exportSubContestTExcel.action?exportName=teat"
			+ "&teatmodel.id="
			+ '${teatmodel.id}'
			+ "&teatmodel.name="
			+ pname
			+ "&teatmodel.departmentId="
			+ '${teatmodel.departmentId}'
			+ "&teatmodel.year="
			+ '${teatmodel.year}'
			+ "&teatmodel.majorId="
			+ '${teatmodel.majorId}'
			+ "&teatmodel.tname="
			+ '${teatmodel.tname}'
			+ "&teatmodel.trainContend="
			+ trainContend
			+ "&teatmodel.trainType="
			+ pprojecType
			+ "&teatmodel.trainingArea="
			+ '${teatmodel.trainingArea}'
			+ "&teatmodel.trainDate="
			+ '${teatmodel.trainDate}'
			+ "&teatmodel.trainTime="
			+ '${teatmodel.trainTime}'
			+ "&teatmodel.getCertificate="
			+ '${teatmodel.getCertificate}'
			+ "&teatmodel.givenCertificateDepart="
			+ '${teatmodel.givenCertificateDepart}'
			+ "&teatmodel.isIndustryTrain="
			+ '${teatmodel.isIndustryTrain}'
			+ "&teatmodel.isPraticeTeachTraining="
			+ '${teatmodel.isPraticeTeachTraining}'
}
</script>

	</head>

	<body style="background-color:#e4dfd9">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>教师进修培训
			<b class="tip"></b>查询教师进修培训信息
		</div>

		<form action="findTeat.action?page=1&rows=10" id="form1" name="form1"
			method="post" enctype="multipart/form-data">

			<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							教师进修培训信息查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td style="width: 60px;">
							培训名称
						</td>
						<td>
							<input name="teatmodel.trainContend"
								value='<s:property value="teatmodel.trainContend"/>' type="text" />
						</td>
						<td style="width: 60px;">
							培训类型
						</td>
						<td>

							<!--<select name="teatmodel.trainType" id="trainType">
								<option value="">
									全部类型
								</option>
								<s:iterator value="traintypeList" var="traintypevar">
									<option value="<s:property/>"
										<s:if test="#traintypevar == teatmodel.trainType">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						-->
						<select size="1" name="teatmodel.trainType" id="trainType">
							    <option value="">
					
									全部类型
								</option>
								<option value="进修"
								<s:if test=' "进修"== teatmodel.trainType'>selected="selected"</s:if>>
									
									进修
								</option>
								<option value="攻读学位"
								<s:if test=' "攻读学位"== teatmodel.trainType'>selected="selected"</s:if>>
									
									攻读学位
								</option>
								<option value="交流出访"
								<s:if test=' "交流出访"== teatmodel.trainType'>selected="selected"</s:if>>
									
									交流出访
								</option>
								<option value="教学能力培训"
								<s:if test=' "教学能力培训"== teatmodel.trainType'>selected="selected"</s:if>>
									
									教学能力培训
								</option>
								
							</select>
						</td>

						<td>
							年份
						</td>
						<td>
							<select name="teatmodel.year" id="year">
								<option value="">
									全部年份
								</option>
								<s:iterator value="yearList" var="yearvar">
									<option value="<s:property/>"
										<s:if test="#yearvar == teatmodel.year">selected="selected"</s:if>>
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
							<select size="1" id="coll" name="teatmodel.departmentId"
								class="department" onchange="collchange();">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList" var="departmentvar">
									<option value="<s:property value='dno'/>"
									<s:if test="#departmentvar.dno ==teatmodel.departmentId">selected="selected"</s:if>>
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							所在专业
						</td>
						<td colspan="3">
							<select size="1" name="teatmodel.majorId" id="major">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList" var="majorvar">
									<option value="<s:property value='mno'/>"
									<s:if test="#majorvar.mno == teatmodel.majorId">selected="selected"</s:if>>
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
								class="btn btn-primary add">导出教师进修培训信息列表</a> &nbsp;&nbsp;
							<span style="color: red;">(先查询，再导出)</span>

						</td>
						<td align="right" colspan="2">
							<span id="add"> <a id="add"
								href="editToTeat.action?teacherTrainingNo=0" style=""
								class="btn btn-primary add">添加</a> 
							</span>
							<!--选择导入的文件 --> <a
								id="attach" href="javascript:void(0);"
								onclick="upFile();return false;" class="btn btn-primary add">导入</a>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>

		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				教师进修培训信息查询结果
			</caption>
			<thead>
				<tr>
					<td width="3%">
						#
					</td>
					<td width="10%">
						教师名称
					</td>
					<td width="6%">
						培训类型
					</td>
					<td width="8%">
						培训名称
					</td>
					<td width="4%">
						培训年份
					</td>
					<td>
						境内外培训
					</td>
					<td>
						培训开始时间
					</td>
					<td>
						培训天数
					</td>
					<td>
						获得证书
					</td>
					<td width="9%">
						发证机构
					</td>
					<td width="5%">
						是否行业培训
					</td>
					<td width="5%">
						是否实践
						</br>
						教学能力培训
					</td>

					<td>
						操作
					</td>
				</tr>
			</thead>
			<tbody>
				<s:if test="teatList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有查询到信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="teatList" id="teachertraining" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>

						<td>
							<s:property value="teacher.tname" />
						</td>
						<td>
							<s:property value="trainType" />
						</td>
						<td>
							<s:property value="trainContend" />
						</td>
						<td>
							<s:property value="year" />
						</td>
						<td>
							<s:property value="trainingArea" />
						</td>
						<td>
							<s:property value="trainDate" />
						</td>
						<td>
							<s:property value="trainTime" />
						</td>
						<td>
							<s:property value="getCertificate" />
						</td>
						<td>
							<s:property value="givenCertificateDepart" />
						</td>
						<td>
							<s:property value="isIndustryTrain" />
						</td>
						<td>
							<s:property value="isPraticeTeachTraining" />
						</td>

						<td>

							<span class="edit"><a class="btn btn-mini btn-primary"
								href="editToTeat.action?teacherTrainingNo=<s:property value="teacherTrainingNo"/>">
								修改 </a></span>
							<span class="del"><a class="btn btn-mini btn-primary" onclick="return confirm('是否删除')"
								href="deleteTeat.action?teacherTrainingNo=<s:property value="teacherTrainingNo"/>">
								删除 </a></span>
						</td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="teatList.size() > 0">
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
