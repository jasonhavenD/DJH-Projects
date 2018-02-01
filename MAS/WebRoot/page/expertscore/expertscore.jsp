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
	if($("#major").val()=="%"){
		alert("您还没有选择专业！");
	}else{
		document.getElementById("form1").submit();
	}
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
	document.getElementById("iframe").src = "attachFileList.action?importName=attach"
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
		else{
		$("#change").hide();//隐藏修改
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

	window.location.href = "findexpertscorepert.action?expertscoreModel.majorId="
	+'${expertscoreModel.majorId}'
	+ "&expertscoreModel.departmentId=" + '${expertscoreModel.departmentId}'
	+"&rows=" + rows + "&page=" + page;

}

function setRows(rows) {

	window.location.href = "findexpertscorepert.action?expertscoreModel.majorId="
	+'${expertscoreModel.majorId}'
	+ "&expertscoreModel.departmentId=" + '${expertscoreModel.departmentId}'
	+"&rows=" + rows.value;
}
function modifyEditExpertScore() {
		if (confirm("是否修改")) {
			document.getElementById("saveExpertmajor").submit();
		}
}

</script>


	</head>
	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>定性数据处理
			<b class="tip"></b>专家评分情况
		</div>
		<form action="findexpertscorepert.action?page=1&rows=10" id="form1" name="form1"
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
						<td width="10%" id="y">
							年份
						</td>
						<td>
							<select name="expertscoreModel.year" id="year">
								<option value="">
									全部年份
								</option>
								<s:iterator value="yearList" var="yearvar">
									<option value="<s:property/>"
										<s:if test="#yearvar == expertscoreModel.year">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>
						<td id="d">
							所在学院
						</td>
						<td>
							<select size="1" id="coll" name="expertscoreModel.departmentId"
								class="department" onchange="collchange();">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList">
									<option value="<s:property value='dno'/>">
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							所在专业
						</td>
						<td>
							<select size="1" name="expertscoreModel.majorId" id="major">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList">
									<option value="<s:property value='mno'/>">
										<s:property value="mname" />
									</option>
								</s:iterator>
							</select>
						</td>
						</tr>
						<tr>
						<td>
							专家姓名
						</td>
						<td>
							<input type="text" name="expertscoreModel.Name"   />
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
						<td></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td width="10%">
							<a href="javascript:findContestApply();"
							class="btn btn-primary add" >查询</a>
					        <a class="btn btn-primary add" href="editToexpertMajor.action?" id="change">评分</a>
					        <!--<a class="btn btn-primary add" id="saveExpertmajor"
								href="javascript:modifyEditExpertScore()">保存</a>

						--></td>
						<td align="right" colspan="9">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>


     <form>
		<table class="table table-striped table-bordered table-condensed">
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
						评分
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
				<s:iterator value="expertscoreList" status="L">
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
							<s:property value="expert.expertName"/>
						</td>
						<td>
							<s:property value="fileinfoAttachment.mas.masCode" />
						</td>


						<td>
							<!--<s:property value="fileinfoAttachment.mas.masCode" />
							--->
							<s:property
								value="fileinfoAttachment.mas.assessingneedtarget.appraisalsystem.indicatorName" />
						</td>


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
		</form>

		<div id="alert-win" title="附件" style="display: none;">
			<iframe style="border: 0; width: 100%; height: 100%;" id="iframe"
				src="">
			</iframe>
		</div>

	</body>
</html>
