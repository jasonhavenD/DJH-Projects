<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>定性数据上传</title>
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
		<script>

//查询
function findContestApply() {
	document.getElementById("form1").submit();
}
//查看信息
function findByContestIdInfo(attachmentId) {
	//alert(conId);
	window.location.href = "findByContestIdInfo.action?attachmentId="
			+ attachmentId;
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
				find();
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
				find();
		$(this).dialog("close");
	}
	}
	});

})
})
$(document).ready(function() {
timeManage();
	// ------------------------------	
		//角色判断
		var rol = $("#rol").val();
		var totalRows = $("#totalRows").val();
		//if (rol == 3) {

		//for ( var i = 0; i < totalRows; i++) {
		//$(".attach").hide();//隐藏上传
		//}

		//}
		$("#tablelist tr td a").bind("click",function(){
			$(this).parent().parent().css('background-color',"#90d7ec");
		});
});

function find() {
	window.location.href = "findFia.action?fiamodel.majorId="
			+ '${fiamodel.majorId}' + "&fiamodel.year=" + '${fiamodel.year}'
			+ "&fiamodel.departmentId=" + '${fiamodel.departmentId}' + "&rows="
			+ rows + "&page=" + page;
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

	window.location.href = "findFia.action?fiamodel.majorId="
			+ '${fiamodel.majorId}' + "&fiamodel.year=" + '${fiamodel.year}'
			+ "&fiamodel.departmentId=" + '${fiamodel.departmentId}' 
			+ "&fiamodel.uploadStatus=" + '${fiamodel.uploadStatus}'
			+ "&rows="+ rows 
			+ "&page=" + page;

}

function setRows(rows) {
	window.location.href = "findFia.action?fiamodel.majorId="
			+ '${fiamodel.majorId}' + "&fiamodel.year=" + '${fiamodel.year}'
			+ "&fiamodel.departmentId=" + '${fiamodel.departmentId}' 
			+ "&fiamodel.uploadStatus=" + '${fiamodel.uploadStatus}'
			+ "&rows="
			+ rows.value;
}
</script>
	</head>
	<body>
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业数据采集
			<b class="tip"></b>定性数据上传
		</div>
		<form action="findFia.action?page=1&rows=10" id="form1" name="form1"
			method="post" enctype="multipart/form-data">

			<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							附件表查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td width="10%">
							年份
						</td>
						<td>
							<select name="fiamodel.year" id="year">
								<option value="">
									全部年份
								</option>
								<s:iterator value="yearList" var="yearvar">
									<option value="<s:property/>"
										<s:if test="#yearvar == fiamodel.year">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							所在学院
						</td>
						<td>
							<select size="1" id="coll" name="fiamodel.departmentId"
								class="department" onchange="collchange();">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList" var="devar">
									<option value="<s:property value='dno'/>"
										<s:if test="#devar.dno==fiamodel.departmentId"></s:if>>
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							所在专业
						</td>
						<td>
							<select size="1" name="fiamodel.majorId" id="major">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList" var="mvar">
									<option value="<s:property value='mno'/>"
										<s:if test="#mvar.mno==fiamodel.majorId"></s:if>>
										<s:property value="mname" />
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							是否未上传
						</td>
						<td colspan="5">
							<select size="1" name="fiamodel.uploadStatus" id="uploadStatus">
								<option value="">
									--选择--
								</option>
								<option value="1"
									<s:if test="1==fiamodel.uploadStatus">selected="selected"</s:if>>
									是
								</option>
								<option value="0"
									<s:if test="0==fiamodel.uploadStatus">selected="selected"</s:if>>
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

		<table class="table table-striped table-bordered table-condensed" id="tablelist">
			<caption class="t_caption">
				各专业附件列表
			</caption>
			<thead>
				<tr class="tr_title">
					<td>
						#
					</td>
					<td>
						年份
					</td>
					<td>
						专业
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
						操作
					</td>
					<td>
						查看
					</td>
				</tr>
			</thead>
			<tbody>
				<s:if test="fiaList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有附件信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="fiaList" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td>
							<s:property value="year" />
						</td>
						<td>
							<s:property value="mas.major.mname" />
						</td>
						<td>
							<s:property value="mas.masCode" />
						</td>

						<td>
							<s:property value="mas.masCode" />
							-
							<s:property
								value="mas.assessingneedtarget.appraisalsystem.indicatorName" />
						</td>
						<s:if test="uploadStatus==1">
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
							<span class="edit"><a id="attach"
								href="javascript:void(0);"
								onclick="upFile('<s:property value="attachmentId" />');return false;"
								class="btn btn-mini btn-primary attach">附件</a></span>
						</td>
						<td>
							<a class="btn btn-mini btn-primary attach searchFileName" ">查看</a>
							<input type="hidden" class="filename"
								value="<s:property value="actualPath.toString().substring(actualPath.toString().indexOf('/MAS/'),actualPath.toString().lastIndexOf('.'))"/>.pdf" />
						</td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="fiaList.size() > 0">
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
