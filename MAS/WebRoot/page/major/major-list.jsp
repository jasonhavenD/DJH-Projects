<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>专业信息查询</title>

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
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/ajax/MajorByDno.js"></script>
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
	// ------------------------------
		//角色判断
		var rol = $("#rol").val();
		var totalRows = $("#totalRows").val();
		//if (rol == 3) {
			//$("#attach").hide();//隐藏导入
			//$("#add").hide();//隐藏导入
			//for ( var i = 0; i < totalRows; i++) {
				//$(".edit").hide();
				//$(".del").hide();
			//}
		//}
		if(rol==2){
			$("#add").hide();//隐藏导入
		}
	});

//查询赛项
function findContestApply() {
	document.getElementById("form1").submit();
}

//查看赛项详细信息
function findContestInfo(mno) {
	window.location.href = "majorinfo.action?mno=" + mno;
}
//删除专业
function modifyDeleteMajor(mno) {
				if (confirm("是否删除")) {

					window.location.href = "deleteMajor.action?mno=" + mno;
				}
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
	var enrollmentState = "" + '${majormodel.enrollmentState}';
	enrollmentState = encodeURI(enrollmentState);
	enrollmentState = encodeURI(enrollmentState);
	window.location.href = "findMajor.action?majormodel.mno="
			+ '${majormodel.mno}'
			+ "&majormodel.departmentId="
			+ '${majormodel.departmentId}'
			+ "&majormodel.majorId="
			+ '${majormodel.majorId}'
			+ "&majormodel.year="
			+ '${majormodel.year}'
			+ "&majormodel.disciplinetype.disciplineTypeId="
			+ '${majormodel.disciplinetype.disciplineTypeId}'
			+ "&majormodel.majortype.majorTypeId="
			+ '${majormodel.majortype.majorTypeId}'
			+ "&majormodel.majorcategory.majorCategoryId="
			+ '${majormodel.majorcategory.majorCategoryId}'
			+ "&majormodel.enrollmentState="
			+ enrollmentState
			+ "&rows="
			+ rows
			+ "&page=" + page;
}

function setRows(rows) {
	var enrollmentState = "" + '${majormodel.enrollmentState}';
	enrollmentState = encodeURI(enrollmentState);
	enrollmentState = encodeURI(enrollmentState);
	window.location.href = "findMajor.action?majormodel.mno="
			+ '${majormodel.mno}'
			+ "&majormodel.departmentId="
			+ '${majormodel.departmentId}'
			+ "&majormodel.majorId="
			+ '${majormodel.majorId}'
			+ "&majormodel.year="
			+ '${majormodel.year}'
			+ "&majormodel.disciplinetype.disciplineTypeId="
			+ '${majormodel.disciplinetype.disciplineTypeId}'
			+ "&majormodel.majortype.majorTypeId="
			+ '${majormodel.majortype.majorTypeId}'
			+ "&majormodel.majorcategory.majorCategoryId="
			+ '${majormodel.majorcategory.majorCategoryId}'
			+ "&majormodel.enrollmentState="
			+ enrollmentState
			+ "&rows=" + rows.value;
}

//导出我的赛项列表
function exportExcel() {
	var enrollmentState = "" + '${majormodel.enrollmentState}';
	enrollmentState = encodeURI(enrollmentState);
	enrollmentState = encodeURI(enrollmentState);
	window.location.href = "exportExcel.action?exportName=major"
			+ "&majormodel.mno="
			+ '${majormodel.mno}'
			+ "&majormodel.departmentId="
			+ '${majormodel.departmentId}'
			+ "&majormodel.majorId="
			+ '${majormodel.majorId}'
			+ "&majormodel.year="
			+ '${majormodel.year}'
			+ "&majormodel.disciplinetype.disciplineTypeId="
			+ '${majormodel.disciplinetype.disciplineTypeId}'
			+ "&majormodel.majortype.majorTypeId="
			+ '${majormodel.majortype.majorTypeId}'
			+ "&majormodel.majorcategory.majorCategoryId="
			+ '${majormodel.majorcategory.majorCategoryId}'
			+ "&majormodel.enrollmentState="
			+ enrollmentState;
}


</script>

	</head>

	<body style="background-color:#e4dfd9" >

		<form action="findMajor.action?page=1&rows=10" id="form1" name="form1"
			method="post" enctype="multipart/form-data">
			<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							专业信息查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td style="width: 60px;">
							专业代码
						</td>
						<td>
							<input type="text" name="majormodel.mno"
								value='<s:property value="majormodel.mno"/>' />
						</td>
						<td style="width: 60px;">
							学科门类
						</td>
						<td>
							<select size="1" name="majormodel.disciplinetype.disciplineTypeId" class="disciplinetype" id="disciplinetype" >
								<option value="">
									全部门类
								</option>
								<s:iterator value="disciplinetypeList" var="disciplinetypevar">
									<option value="<s:property value='disciplineTypeId'/>"
										<s:if test="#disciplinetypevar.disciplineTypeId == majormodel.disciplinetype.disciplineTypeId">selected="selected"</s:if>>
										<s:property value="disciplineTypeName" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							开设年份
						</td>
						<td>
							<select name="majormodel.year" id="year">
								<option value="">
									全部年份
								</option>
								<s:iterator value="yearList" var="yearvar">
									<option value="<s:property/>"
										<s:if test="#yearvar == majormodel.year">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>

					</tr>
					<tr>
						<td style="width: 60px;">
							专业类
						</td>
						<td>
							<select size="1" name="majormodel.majortype.majorTypeId" class="majortype" id="majortype" >
								<option value="">
									全部类
								</option>
								<s:iterator value="majortypeList" var="majortypevar">
									<option value="<s:property value='majorTypeId'/>"
										<s:if test="#majortypevar.majorTypeId == majormodel.majortype.majorTypeId">selected="selected"</s:if>>
										<s:property value="majorTypeName" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width: 60px;">
							专业类别
						</td>
						<td>
							<select size="1" name="majormodel.majorcategory.majorCategoryId" class="majorcategory" id="majorcategory" >
								<option value="">
									全部类别
								</option>
								<s:iterator value="majorcategoryList" var="majorcategoryvar">
									<option value="<s:property value='majorCategoryId'/>"
										<s:if test="#majorcategoryvar.majorCategoryId == majormodel.majorcategory.majorCategoryId">selected="selected"</s:if>>
										<s:property value="majorCategoryName" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width: 60px;">
							所在学院
						</td>
						<td>
							<select size="1" name="majormodel.departmentId" class="department" id="coll" onchange="collchange();">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList" var="departmentvar">
									<option value="<s:property value='dno'/>"
										<s:if test="#departmentvar.dno == majormodel.departmentId"></s:if>>
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>

					</tr>
					<tr>
					<td>
						招生状态
					</td>
					<td colspan="3">
						<select size="1" name="majormodel.enrollmentState">
							<option value="">
								全部状态
							</option>
							<option value="在招"
								<s:if test='"在招"==majormodel.enrollmentState'>selected="selected"</s:if>>
								在招
							</option>
							<option value="关闭"
								<s:if test='"关闭"==majormodel.enrollmentState'>selected="selected"</s:if>>
								关闭
							</option>
						</select>
					</td>
					<td>
						所在专业
					</td>
					<td>
						<select size="1" name="majormodel.majorId" id="major">
							<option value="">全部专业</option>
							<s:iterator value="majorList" var="majorvar">
								<option value="<s:property value='mno'/>"
									<s:if test="#majorvar.mno == majormodel.majorId"></s:if>>
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
							<a href="#" onclick="exportExcel()" id="attach"
								class="btn btn-primary add">导出专业列表</a> &nbsp;&nbsp;
							<span style="color: red;">(先查询，再导出)</span>

						</td>
						<td align="center">
						<span id="add">
							<a href="addToMajor.action?number=0"
							style="align right" class="btn btn-primary add" >添加</a>


						</td>
					</tr>
				</tfoot>
			</table>
		</form>

		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				专业信息查询结果
			</caption>
			<thead>
				<tr>
					<td>
						#
					</td>

					<td>
						专业编号
					</td>
					<td>
						专业名称
					</td>
					<td>
						学院名称
					</td>
					<td>
						学科门类
					</td>
					<td>
						专业类
					</td>
					<td>
						专业类别
					</td>
					<td>
						专业开设年份
					</td>
					<td>
						招生状态
					</td>
					<td>
						操作
					</td>
				</tr>
			</thead>
			<tbody>
				<s:if test="maList.size() == 0">
						<tr>
							<td colspan="99" style="text-align: center;">没有查询赛项信息！</td>
						</tr>
					</s:if>
					<s:iterator value="maList" status="L">
						<tr>
							<td>
								<s:property value="#L.index+1"/>
							</td>

							<td>
								<s:property value="mno"/>
							</td>

							<td>
								<s:property value="mname"/>
							</td>
							<td>
								<s:property value="department.dname"/>
							</td>
							<td>
								<s:property value="disciplinetype.disciplineTypeName"/>
							</td>
							<td>
								<s:property value="majortype.majorTypeName"/>
							</td>
							<td>
								<s:property value="majorcategory.majorCategoryName"/>
							</td>
							<td>
								<s:property value="year"/>
							</td>
							<td>
								<s:property value="enrollmentState"/>
							</td>
							<td>
								<span class="edit"><a class="btn btn-mini btn-primary" href="initInfo.action?mno=<s:property value="mno"/>">
									查看
								</a></span>
								<span class="del"><a class="btn btn-mini btn-primary" href="deleteMajor.action?mno=<s:property value="mno"/>">删除</a></span>
							</td>
						</tr>
					</s:iterator>

			</tbody>
			<tfoot>
				<s:if test="maList.size() > 0">
					<tr>
						<td colspan="99">
							<s:include value="../common/paging.jsp"></s:include>
						</td>
					</tr>
				</s:if>
			</tfoot>
		</table>
	</body>
</html>
