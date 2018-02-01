<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

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
	window.location.href = "attachFileList.action?attachmentId="
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
				findContestApply();
				$(this).dialog("close");
			}
		}
	});
}
//弹出导入框
function upFil() {
	var filename = $("#filename").val();
	document.getElementById("iframe").src = "../generic/web/viewer.html?file="+filename;

	$('#alert-win').dialog( {
		width : 800,
		height : 850,
		buttons : {
			"关闭" : function() {
				//findContestApply();
				$(this).dialog("close");
			}
		}
	});
}
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

	window.location.href = "findexpertscore.action?expertscoreModel.majorId="
	+'${expertscoreModel.majorId}'
	+ "&expertscoreModel.departmentId=" + '${expertscoreModel.departmentId}'
	+"&rows=" + rows + "&page=" + page;

}

function setRows(rows) {

	window.location.href = "findexpertscore.action?expertscoreModel.majorId="
	+'${expertscoreModel.majorId}'
	+ "&expertscoreModel.departmentId=" + '${expertscoreModel.departmentId}'
	+"&rows=" + rows.value;
}


function modifyEdit() {

                   if (confirm("是否保存")) {
					document.getElementById("form1").submit();
				}

}
</script>


	</head>
	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专家评分
			<b class="tip"></b>修改评分
		</div>

		<form id="form1"  action="saveExpertscore.action">
		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				项目评分
			</caption>
			<thead>
				<tr class="tr_title">

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
					<td >
						评分
					</td>
					<td>
						操作
					</td>
				</tr>
			</thead>
			<tbody>

					<tr>

						<td>
							<s:property value="expertscore.fileinfoAttachment.year" />
						</td>
						<td>
							<s:property value="expertscore.fileinfoAttachment.mas.major.mname" />
						</td>
						<td>
							<s:property value="expertscore.fileinfoAttachment.mas.masCode" />
						</td>
						<td>
							<s:property value="expertscore.fileinfoAttachment.mas.masCode" />
							-
							<s:property
								value="expertscore.fileinfoAttachment.mas.assessingneedtarget.appraisalsystem.indicatorName" />
						</td>
						<s:if test="expertscore.fileinfoAttachment.uploadStatus==1">
							<td>
								<font color="green">已经上传</font>
							</td>
						</s:if>
						<s:else>
							<td>
								<font color="red">未上传</font>
							</td>
						</s:else>
                        <td width="2%">
	                 <input onkeyup="value=value.replace(/[^\d]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"
                        value="<s:property value="expertscore.asseisingValue" />" id="expertscore.asseisingValue"  name="expertscore.asseisingValue" maxlength='3' size="3">
						</td>


					<td style="width: 80px;">
							<span class="attach">
									<a onclick="upFil();return false;" class="btn btn-mini btn-primary attach"  href="javascript:void(0);">查看</a>
									<input type="hidden" id="filename"	value="<s:property value='pdfFileName'/>" />
							</span>
								<a class="btn btn-mini btn-primary attach" href="javascript:modifyEdit()">保存</a>
					</td>
							</tr>

			</tbody>

		</table>
		</form>

		<div id="alert-win" title="文件预览" style="display: none;">
			<iframe style="border: 0; width: 100%; height: 100%;" id="iframe"
				src="">
			</iframe>
		</div>
		<a href="initSearchpert.action" class="btn btn-mini btn-primary" >返回上一页</a>

	</body>
</html>
