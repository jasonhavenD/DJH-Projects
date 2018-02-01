<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>职工信息查询</title>

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
//导入弹出框
function upFile() {
	/*document.getElementById("iframe").src = "attachFileList.action?importName=teacher";*/
	
	document.getElementById("iframe").src = "attachFileList.action?importName=teacher";
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
//日历插件
$(function() {
	$(".datepicker").datepicker();
})

$(document).ready(function() {
timeManage();
	// ------------------------------	
		//角色判断
		var rol = $("#rol").val();
		var totalRows = $("#totalRows").val();
		//if (rol == 3) {
			//$("#attach").hide();//隐藏导入
			//$("#add").hide();//隐藏添加
			//for ( var i = 0; i < totalRows; i++) {
				//$(".edit").hide();
				//$(".del").hide();
			//}
		//}
		if (rol == 2) {
			$("#add").hide();//隐藏导入
			for ( var i = 0; i < totalRows; i++) {
				$(".del").hide();
			}
		}
	});

//查询赛项
function findContestApply() {
	document.getElementById("form1").submit();
}

//查看赛项详细信息
function findContestInfo(conId) {
	window.location.href = "searchContestInfoToTCO.action?contestId=teacher" + conId;
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
	var tname=""+'${teachermodel.tname}';
	tname = encodeURI(tname);
	tname = encodeURI(tname);
	window.location.href = "findTeacher.action?teachermodel.tno="
			+ '${teachermodel.tno}' + "&teachermodel.tname="
			+ tname + "&teachermodel.departmentId="
			+ '${teachermodel.departmentId}' + "&teachermodel.majorId="
			+ '${teachermodel.majorId}'
			+ "&teachermodel.professionaltitle.professionalTitleName="
			+ '${teachermodel.professionaltitle.professionalTitleName}'
			+ "&teachermodel.degree.degreeName="
			+ '${teachermodel.degree.degreeName}'
			+ "&teachermodel.teacherscategory.teachersCategoryName="
			+ '${teachermodel.teacherscategory.teachersCategoryName}'
			+ "&teachermodel.academicdegree.bestDegreeNo="
			+ '${teachermodel.academicdegree.bestDegreeNo}'
			+ "&teachermodel.inServiceState="
			+ '${teachermodel.inServiceState}' + "&rows=" + rows + "&page="
			+ page;
}
function setRows(rows) {
	var tname=""+'${teachermodel.tname}';
	tname = encodeURI(tname);
	tname = encodeURI(tname);
	window.location.href = "findTeacher.action?teachermodel.tno="
			+ '${teachermodel.tno}' + "&teachermodel.tname="
			+ tname + "&teachermodel.departmentId="
			+ '${teachermodel.departmentId}' + "&teachermodel.majorId="
			+ '${teachermodel.majorId}'
			+ "&teachermodel.professionaltitle.professionalTitleName="
			+ '${teachermodel.professionaltitle.professionalTitleName}'
			+ "&teachermodel.degree.degreeName="
			+ '${teachermodel.degree.degreeName}'
			+ "&teachermodel.academicdegree.bestDegreeNo="
			+ '${teachermodel.academicdegree.bestDegreeNo}'
			+ "&teachermodel.inServiceState="
			+ '${teachermodel.inServiceState}' + "&rows=" + rows.value;
}

//导出教师信息
function exportSubContestTExcel() {
 	
 	var tname=""+'${teachermodel.tname}';
 	tname=encodeURI(tname);
	tname = encodeURI(tname);
	window.location.href = "exportSubContestTExcel.action?exportName=teacher"
			+ "&teachermodel.tno=" + '${teachermodel.tno}'
			+ "&teachermodel.tname=" + tname
			+ "&teachermodel.departmentId=" + '${teachermodel.departmentId}'
			+ "&teachermodel.majorId=" + '${teachermodel.majorId}'
			+ "&teachermodel.professionaltitle.professionalTitleName="
			+ '${teachermodel.professionaltitle.professionalTitleName}'
			+ "&teachermodel.degree.degreeName="
			+ '${teachermodel.degree.degreeName}'
			+ "&teachermodel.teacherscategory.teachersCategoryName="
			+ '${teachermodel.teacherscategory.teachersCategoryName}'
			+ "&teachermodel.academicdegree.bestDegreeNo="
			+ '${teachermodel.academicdegree.bestDegreeNo}'
			+ "&teachermodel.inServiceState="
			+ '${teachermodel.inServiceState}';
}
</script>

	</head>

	<body onload="init();"style="background-color:#e4dfd9">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>教师信息
			<b class="tip"></b>查询教师信息
		</div>
		
		<form action="findTeacher.action?page=1&rows=10" id="form1"
			name="form1" method="post" enctype="multipart/form-data">
			<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							职工信息查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">

					<tr>
						<td style="width: 60px;">
							职工编号
						</td>
						<td>
							<input type="text" name="teachermodel.tno"
								value='<s:property value="teachermodel.tno"/>' />
						</td>
						<td style="width: 60px;">
							职工姓名
						</td>
						<td>
							<input type="text" name="teachermodel.tname"
								value='<s:property value="teachermodel.tname"/>' />
						</td>
						
						<td>
							职称
						</td>
						<td>
							<select size="1" name="teachermodel.professionaltitle.professionalTitleNo" >
								<option value="">
									全部职称
								</option>
								<s:iterator value="professionalTitleList" var="professionalvar">
									<option value="<s:property value='professionalTitleNo'/>"
										<s:if test="#professionalvar.professionalTitleNo == teachermodel.professionaltitle.professionalTitleNo">selected="selected"</s:if>>
										<s:property value="professionalTitleName" />
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>
					
					<tr>
						<td style="width: 60px;">
							所在学院
						</td>
						<td>
							<select size="1" name="teachermodel.departmentId" class="department"
								id="coll" onchange="collchange();">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList" var="departmentvar">
									<option value="<s:property value='dno'/>"
										<s:if test="#departmentvar.dno == teachermodel.departmentId"></s:if>>
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
							
						</td>
						<td>
							所在专业
						</td>
						<td>
							<select size="1" name="teachermodel.majorId" id="major">
								<option value="">全部专业</option>
								<s:iterator value="majorList" var="majorvar">
									<option value="<s:property value='mno'/>"
										<s:if test="#majorvar.mno == teachermodel.majorId"></s:if>>																
										<s:property value="mname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>学位</td>
						<td>
						<select size="1" name="teachermodel.academicdegree.bestDegreeNo" >
								<option value="">
									全部学位
								</option>
								<s:iterator value="academicdegreeList" var="academicdegreevar">
									<option value="<s:property value='bestDegreeNo'/>"
										<s:if test="#academicdegreevar.bestDegreeNo == teachermodel.academicdegree.bestDegreeNo">selected="selected"</s:if>>
										<s:property value="bestDegreeName" />
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
								class="btn btn-primary add">导出教师列表</a> &nbsp;&nbsp;
							<span style="color: red;">(先查询，再导出)</span>

						</td>
						<td align="center">
							<span id="add"> <a href="addToTeacher.action?tno=0"
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
				教师信息查询结果
			</caption>
			<thead>
				<tr>
					<td>
						#
					</td>
					<td width="22px">
						职工编号
					</td>
					<td width="30px">
						职工姓名
					</td>
					<td>
						性别
					</td>
					<td>
						所在学院
					</td>
					<td>
						所在部门
					</td>
					<td>
						所在专业
					</td>
					<td>
						职称
					</td>
					<td>
						学历
					</td>
					<td>
						学位
					</td>
					<td>
						师资类别
					</td>
					<td>
						在职状态
					</td>
					<td>
						操作
					</td>
				</tr>
			</thead>
			<tbody>
				<s:if test="teacList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有查询信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="teacList" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td>
							<s:property value="tno" />
						</td>
						<td title='<s:property value="tname"/>'>
							<div class="demo_ellipsis">
								<s:property value="tname" />
							</div>
						</td>
						<td>
							<s:property value="sex" />
						</td>
						<td>
							<s:property value="major.department.dname" />
						</td>
						<td>
							<s:property value="departmentGroup" />
						</td>
						<td title='<s:property value="major.mname"/>'>
							<div class="demo_ellipsis_c">
								<s:property value="major.mname" />
							</div>
						</td>
						<td>
							<s:property value="professionaltitle.professionalTitleName" />
						</td>
						<td>
							<s:property value="degree.DegreeName" />
						</td>
						<td>
							<s:property value="academicdegree.bestDegreeName" />
						</td>
						<td>
							<s:property value="teacherscategory.TeachersCategoryName" />
						</td>
						<td>
							<s:property value="inServiceState" />
						</td>
						<td>
							<span class="edit"> <a class="btn btn-mini btn-primary"
								href="editToTeacher.action?tno=<s:property value="tno"/>">
									编辑 </a> </span>
							<span class="del"> <a class="btn btn-mini btn-primary"
								href="deleteTeacher.action?tno=<s:property value="tno"/>"
								onclick="return confirm('是否删除')"> 删除 </a> </span>
						</td>

					</tr>
				</s:iterator>

			</tbody>
			<tfoot>
				<s:if test="teacList.size() > 0">
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
