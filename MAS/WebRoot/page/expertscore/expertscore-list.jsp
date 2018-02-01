<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@page import="java.lang.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>专家打分</title>
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

		<script>

//查询需要评分专业
function findContestApply() {
	document.getElementById("form1").submit();
}
//查看评分信息
function findByContestIdInfo(attachmentId) {
	//alert(conId);
	window.location.href = "attachFileList.action?attachmentId=" + attachmentId;
}

//上传附件弹出框
function upFile(attachmentId) {
	document.getElementById("iframe").src = "attachFileList.action?attachmentId="
			+ attachmentId;
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

//弹出预览框
$(function(){
$('.searchFileName').click(function(){
	var filename = $(this).parent().find('.filename').val();
	document.getElementById("iframe").src = "../generic/web/viewer.html?file="
			+ encodeURIComponent(filename);

	$('#alert-win').dialog( {
		width : 800,
		height : 800,
		buttons : {
			"关闭" : function() {
				//findContestApply();
		$(this).dialog("close");
	}
	}
	});

})
})
function saveExpertScore() {
	var epertscoreId = $("#epertscoreId").val();
	var asseisingValue = $("#asseisingValue").val();

	window.location.href = "saveExpertscore.action?epertscoreId="
			+ epertscoreId + "&asseisingValue=" + asseisingValue;

}
$(function() {
	$('.save').click(
		function() {
		var id = $(this).parent().find('.epertscoreId').val();
		var value = $(this).parent().parent().find('.asseisingValue-td .asseisingValue').val();
		//alert(value);
		var value2 = $(this).parent().parent().find('.asseisingValue2');
		if(value<=0 || value>100){
			confirm("评分区间为(0,100]!");
		}else{
			$.ajax( {
				type : "post",
				url : "ajaxsaveExpertscore.action",
				datatype : "json",
				data : {
						epertscoreId : id,
						asseisingValue : value
						},
				success : function(data) {
						value2.html(value);
				}
			})
		}
	}
	)
})
$(document).ready(function() {
	// ------------------------------
		//角色判断
		var rol = $("#rol").val();
		var totalRows = $("#totalRows").val();
		if (rol == 5) {
			$("#year").hide();//隐藏年份
			$("#coll").hide();//隐藏学院
			$("#y").hide();//隐藏年份
			$("#d").hide();//隐藏学院

		}
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
	var isScore = "" + '${expertscoreModel.isScore}';
	isScore = encodeURI(isScore);
	isScore = encodeURI(isScore);
	var indicatorName = "" + '${expertscoreModel.indicatorName}';
	indicatorName = encodeURI(indicatorName);
	indicatorName = encodeURI(indicatorName);
	window.location.href = "findexpertscore.action?expertscoreModel.majorId="
			+ '${expertscoreModel.majorId}' + "&expertscoreModel.departmentId="
			+ '${expertscoreModel.departmentId}'
			+ "&expertscoreModel.isScore="+isScore
			+ "&expertscoreModel.indicatorName="+indicatorName
			+ "&rows=" + rows
			+ "&page="+ page;

}

function setRows(rows) {
	var isScore = "" + '${expertscoreModel.isScore}';
	isScore = encodeURI(isScore);
	isScore = encodeURI(isScore);
	var indicatorName = "" + '${expertscoreModel.indicatorName}';
	indicatorName = encodeURI(indicatorName);
	indicatorName = encodeURI(indicatorName);
	window.location.href = "findexpertscore.action?expertscoreModel.majorId="
			+ '${expertscoreModel.majorId}' + "&expertscoreModel.departmentId="
			+ '${expertscoreModel.departmentId}'
			+ "&expertscoreModel.isScore="+isScore
			+ "&expertscoreModel.indicatorName="+indicatorName
			+ "&rows=" + rows.value;
}
</script>


	</head>
	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业评分
			<b class="tip"></b>评分查看
		</div>
		<form action="expfindexpertscore.action?page=1&rows=10" id="form1"
			name="form1" method="post" enctype="multipart/form-data">

			<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							专家评分查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td>
							所在专业
						</td>
						<td>
							<select size="1" name="expertscoreModel.majorId" id="major">
								<option value="">选择专业</option>
								<s:iterator value="majorList" var="majorvar">
									<option value="<s:property value='mno'/>"
									<s:if test="#majorvar.mno == expertscoreModel.majorId">selected="selected"</s:if>>
										<s:property value="mname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							指标名称
						</td>
						<td>
							<input name="expertscoreModel.indicatorName" type="text" value='<s:property value="expertscoreModel.indicatorName"/>' />
						</td>
						<td>
							是否已评分
						</td>
						<td>
							<select size="1" name="expertscoreModel.isScore" id="isScore">
								<option value="">
									--选择--
								</option>
								<option value="是"
									<s:if test="'是'==expertscoreModel.isScore">selected="selected"</s:if>>
									是
								</option>
								<option value="否"
									<s:if test="'否'==expertscoreModel.isScore">selected="selected"</s:if>>
									否
								</option>
							</select>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td width="10%">
							<a href="javascript:findContestApply();"
								class="btn btn-primary add">查询</a>
						</td>
						<td align="right" colspan="5">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				各专业附件列表
			</caption>
			<thead>
				<tr class="tr_title">
					<td width="30px">
						#
					</td>
					<td width="60px">
						年份
					</td>
					<td>
						专业
					</td>
					<td>
						专家
					</td>
					<td>
						专业评估编号
					</td>
					<td>
						指标名称
					</td>
					<td>
						上传否
					</td>
					<td>
						查看
					</td>
					<td width="30px">
						评分
					</td>
					<td width="20px">
						操作
					</td>
					<td>
						得分
					</td>
				</tr>
			</thead>
			<tbody>
				<s:if test="expertscoreList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有附件信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="expertscoreList" id="expertscore" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td>
							<s:property value="fileinfoAttachment.year" />
						</td>
						<td>
							<s:property value="fileinfoAttachment.mas.major.mname" />
						</td>
						<td>
							<s:property value="expert.expertName" />
						</td>
						<td>
							<s:property value="fileinfoAttachment.mas.masCode" />
						</td>
						<td>
							<!--
							<a
								href="../generic/web/viewer.html?file=<s:property value="fileinfoAttachment.actualPath.toString().substring(fileinfoAttachment.actualPath.toString().indexOf('/MAS/'),fileinfoAttachment.actualPath.toString().lastIndexOf('.'))"/>.pdf"
								target="_blank"> </a>

							<s:property value="fileinfoAttachment.mas.masCode" />
							--->
							<s:property
								value="fileinfoAttachment.mas.assessingneedtarget.appraisalsystem.indicatorName" />
						</td>
						<!-- 增加超链接读取pdf -->
						<s:if test="fileinfoAttachment.uploadStatus==1">
							<td>
								<font color="green">已经上传</font>
							</td>
						</s:if>
						<s:else>
							<td>
								<font color="red">未上传</font>
							</td>
						</s:else>

						<td>
							<a class="btn btn-mini btn-primary attach searchFileName">查看</a>
							<input type="hidden" class="filename"
								value="<s:property value="fileinfoAttachment.actualPath.toString().substring(fileinfoAttachment.actualPath.toString().indexOf('/MAS/'),fileinfoAttachment.actualPath.toString().lastIndexOf('.'))"/>.pdf" />
						</td>
						<s:if test="fileinfoAttachment.uploadStatus==1">
							<td class="asseisingValue-td">
								<input class="asseisingValue"
									style="width: 60px; text-align: center"
									onkeyup="value=value.replace(/[^\d\.]/g,'') "
									onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d\.]/g,''))"
									id="expertscore.asseisingValue"
									name="expertscore.asseisingValue" maxlength='5' size="3" />
								<!--<span class="attach"> <a class="btn btn-mini btn-primary"
									href="editToexpertscore.action?epertscoreId=<s:property value='epertscoreId'/>">评分</a>
							-->
							</td>
						</s:if>
						<s:else>
							<td style="width: 60px;">
								<input style="width: 60px;" readonly="readonly" />
								<!--<span class="attach">
								<a class="btn btn-mini btn-primary">禁评</a>
								</span>
							-->
							</td>
						</s:else>
						<td style="width: 60px;">
							<a class="save" href="javascript:void(0);"><span class="btn btn-mini btn-primary attach">保存</span> </a>
							<input type="hidden" class="epertscoreId"
								value="<s:property value='epertscoreId'/>" />
							<!--<a class="btn btn-mini btn-primary attach"
								href="saveExpertscore.action?epertscoreId=<s:property value='epertscoreId'/>">保存</a>
						-->
						</td>
						<td width="8%" class="asseisingValue2">
							<s:property value="asseisingValue" />
						</td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="expertscoreList.size() > 0">
					<tr>
						<td colspan="99">
							<s:include value="../common/paging.jsp"></s:include>
						</td>
					</tr>
				</s:if>
			</tfoot>

		</table>


		<div id="alert-win" title="附件预览" style="display: none;">
			<iframe style="border: 0; width: 100%; height: 100%;" id="iframe"
				src="">
			</iframe>
		</div>


	</body>
</html>
