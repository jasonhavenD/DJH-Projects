<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>招生情况</title>

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
//上传附件弹出框
function upFile() {
	document.getElementById("iframe").src = "attachFileList.action?importName=adm";
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
//查询
function findContestApply() {
	document.getElementById("form1").submit();
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
	window.location.href = "find.action?admmodel.id=" + '${admmodel.id}'
			+ "&admmodel.name=" + '${admmodel.name}' + "&admmodel.majorId="
			+ '${admmodel.majorId}' + "&admmodel.departmentId="
			+ '${admmodel.departmentId}' + "&admmodel.year="
			+ '${admmodel.year}' + "&admmodel.littleexpectCount="
			+ '${admmodel.littleexpectCount}' + "&admmodel.bigexpectCount="
			+ '${admmodel.bigexpectCount}' + "&admmodel.littleaddmCount="
			+ '${admmodel.littleaddmCount}' + "&admmodel.bigaddmCount="
			+ '${admmodel.bigaddmCount}' + "&admmodel.littleentranceEverage="
			+ '${admmodel.littleentranceEverage}'
			+ "&admmodel.bigentranceEverage="
			+ '${admmodel.bigentranceEverage}'

			+ "&rows=" + rows + "&page=" + page;
}

function setRows(rows) {
	window.location.href = "find.action?admmodel.id=" + '${admmodel.id}'
			+ "&admmodel.name=" + '${admmodel.name}' + "&admmodel.majorId="
			+ '${admmodel.majorId}' + "&admmodel.departmentId="
			+ '${admmodel.departmentId}' + "&admmodel.year="
			+ '${admmodel.year}' + "&admmodel.littleexpectCount="
			+ '${admmodel.littleexpectCount}' + "&admmodel.bigexpectCount="
			+ '${admmodel.bigexpectCount}' + "&admmodel.littleaddmCount="
			+ '${admmodel.littleaddmCount}' + "&admmodel.bigaddmCount="
			+ '${admmodel.bigaddmCount}' + "&admmodel.littleentranceEverage="
			+ '${admmodel.littleentranceEverage}'
			+ "&admmodel.bigentranceEverage="
			+ '${admmodel.bigentranceEverage}'

			+ "&rows=" + rows.value+"&page=1";
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

//导出
function exportSubContestTExcel() {
	window.location.href = "exportSubContestTExcel.action?exportName=adm"
			+ "&admmodel.id=" + '${admmodel.id}' + "&admmodel.name="
			+ '${admmodel.name}' + "&admmodel.majorId=" + '${admmodel.majorId}'
			+ "&admmodel.departmentId=" + '${admmodel.departmentId}'
			+ "&admmodel.year=" + '${admmodel.year}'
			+ "&admmodel.littleexpectCount=" + '${admmodel.littleexpectCount}'
			+ "&admmodel.bigexpectCount=" + '${admmodel.bigexpectCount}'
			+ "&admmodel.littleaddmCount=" + '${admmodel.littleaddmCount}'
			+ "&admmodel.bigaddmCount=" + '${admmodel.bigaddmCount}'
			+ "&admmodel.littleentranceEverage="
			+ '${admmodel.littleentranceEverage}'
			+ "&admmodel.bigentranceEverage="
			+ '${admmodel.bigentranceEverage}';
}
</script>

	</head>

	<body style="background-color:#e4dfd9">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>招生情况
			<b class="tip"></b>查询招生情况信息
		</div>
		<form action="find.action?page=1&rows=10" id="form1" name="form1"
			method="post" enctype="multipart/form-data">

			<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							招生情况信息查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td>
							年份
						</td>
						<td>
							<select name="admmodel.year" id="year">
								<option value="">
									全部年份
								</option>
								<s:iterator value="yearList" var="yearvar">
									<option value="<s:property/>"
										<s:if test="#yearvar==admmodel.year">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							所在学院
						</td>
						<td>
							<select size="1" id="coll" name="admmodel.departmentId"
								class="department" onchange="collchange();">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList" var="dvar">
									<option value="<s:property value='dno'/>"
										<s:if test="#dvar.dno==admmodel.departmentId"></s:if>>
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							所在专业
						</td>
						<td>
							<select size="1" name="admmodel.majorId" id="major">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList" var="mvar">
									<option value="<s:property value='mno'/>"
										<s:if test="#mvar.mno==admmodel.majorId"></s:if>>
										<s:property value="mname" />
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							计划人数
							<font color="red">（区间查询）</font>
						</td>
						<td>
							<input name="admmodel.littleexpectCount" type="text"
								style="width: 30px;"
								value="<s:property value='admmodel.littleexpectCount'/>" />
							~
							<input name="admmodel.bigexpectCount" type="text"
								style="width: 30px;"
								value="<s:property value='admmodel.bigexpectCount'/>" />
							<font color="red">（人）</font>
						</td>
						<td>
							招生人数
							<font color="red">（区间查询）</font>
						</td>
						<td>
							<input name="admmodel.littleaddmCount" type="text"
								style="width: 30px;"
								value="<s:property value='admmodel.littleaddmCount'/>" />
							~
							<input name="admmodel.bigaddmCount" type="text"
								style="width: 30px;"
								value="<s:property value='admmodel.bigaddmCount'/>" />
							<font color="red">（人）</font>
						</td>
						<td>
							入学平均分
							<font color="red">（区间查询）</font>
						</td>
						<td>
							<input name="admmodel.littleentranceEverage" type="text"
								style="width: 30px;"
								value="<s:property value='admmodel.littleentranceEverage'/>" />
							~
							<input name="admmodel.bigentranceEverage" type="text"
								style="width: 30px;"
								value="<s:property value='admmodel.bigentranceEverage'/>" />
							<font color="red">（分）</font>
						</td>
					</tr>
				</tbody>

				<tfoot>
					<tr>
						<td colspan="5">
							<a href="javascript:findContestApply();"
								class="btn btn-primary add">查询</a>&nbsp;&nbsp;
							<a href="#" onclick="exportSubContestTExcel()"
								class="btn btn-primary add">导出招生情况信息列表</a> &nbsp;&nbsp;
							<span style="color: red;">(先查询，再导出)</span>

						</td>
						<td align="center">
							<span id="add"> <a
								href="editToAddmissions.action?addmNumber=0" style=""
								class="btn btn-primary add">添加</a> <!--选择导入的文件 --> <a
								id="attach" href="javascript:void(0);"
								onclick="upFile();return false;" class="btn btn-primary add">导入</a>
							</span>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>

		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				招生情况信息查询结果
			</caption>
			<thead>
				<tr>
					<td>
						#
					</td>
					<td>
						编号
					</td>
					<td>
						专业名称
					</td>
					<td>
						计划人数
					</td>
					<td>
						招生人数
					</td>
					<td>
						专业第一志愿率
					</td>
					<td>
						入学平均分
					</td>
					<td>
						专业报考热门度
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
				<s:if test="admList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有查询到相关招生情况信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="admList" id="adm" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td>
							<s:property value="addmNumber" />
						</td>
						<td>
							<s:property value="major.mname" />
						</td>
						<td>
							<s:property value="expectCount" />
						</td>
						<td>
							<s:property value="addmCount" />
						</td>
						<td>
							<s:property value="firstChoice" />
						</td>
						<td>
							<s:property value="entranceEverage" />

						</td>
						<td>
							<s:property value="hotDeggree" />
						</td>
						<td>
							<s:property value="addmYear" />

						</td>
						<td>
							<s:property value="note" />
						</td>
						<td>
							<span class="edit"> <a class="btn btn-mini btn-primary"
								href="editToAddmissions.action?addmNumber=<s:property value="addmNumber"/>">
									修改 </a> </span><span class="del"> <a
								class="btn btn-mini btn-primary"
								href="deleteAddmissions.action?addmNumber=<s:property value="addmNumber"/>"
								onclick="return confirm('是否删除')"> 删除 </a> </span>
						</td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="admList.size() > 0">
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
