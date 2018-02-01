<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>学院信息查询</title>

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
	var ttname = "" + '${departmentmodel.name}';
	ttname = encodeURI(ttname);
	ttname = encodeURI(ttname);
	window.location.href = "finddepartment.action?departmentmodel.departmentId="
			+ '${departmentmodel.departmentId}'
			+ "&departmentmodel.name="
			+ ttname	
			+ "&rows="
			+ rows
			+ "&page=" + page;
}

function setRows(rows) {
var ttname = "" + '${departmentmodel.name}';
	ttname = encodeURI(ttname);
	ttname = encodeURI(ttname);
	window.location.href = "finddepartment.action?departmentmodel.departmentId="
			+ '${departmentmodel.departmentId}'
			+ "&departmentmodel.name="
			+ ttname			
			+ "&rows=" + rows.value+"&page=1";
}

//导出我的赛项列表
function exportExcel() {
var ttname = "" + '${departmentmodel.name}';
	ttname = encodeURI(ttname);
	ttname = encodeURI(ttname);
	window.location.href = "exportExcel.action?exportName=department"
			+ "&departmentmodel.departmentId="
			+ '${departmentmodel.departmentId}'
			+ "&departmentmodel.name="
			+ ttname;
}


</script>

	</head>

	<body style="background-color:#e4dfd9"> 

		<form action="finddepartment.action?page=1&rows=10" id="form1" name="form1"
			method="post" enctype="multipart/form-data">
			<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							学院信息查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td style="width: 60px;">
							学院代码
						</td>
						<td>
							<input type="text" name="departmentmodel.departmentId"  value='<s:property value="departmentmodel.departmentId"/>'/>
						</td>
						<td style="width: 60px;">
							学院名称
						</td>
						<td>
							<input type="text" name="departmentmodel.name"   value='<s:property value="departmentmodel.name"/>' />
						</td>
					</tr>

				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<a href="javascript:findContestApply();"
								class="btn btn-primary add">查询</a>&nbsp;&nbsp;
							<a href="#" onclick="exportExcel()" id="attach"
								class="btn btn-primary add">导出学院列表</a> &nbsp;&nbsp;
							<span style="color: red;">(先查询，再导出)</span>

						</td>
						<td align="center" colspan="3">
						<span id="add">
							<a href="editTodepartment.action?dno=0"
							style="align right" class="btn btn-primary add" >添加</a>
							

						</td>
					</tr>
				</tfoot>
			</table>
		</form>

		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				学院信息查询结果
			</caption>
			<thead>
				<tr>
					<td>
						#
					</td>
     				<td>
						学院代码
					</td>		
					<td>
						学院名称
					</td>
					<td>
						学院负责人
					</td>					
					<td>
						操作
					</td>
				</tr>
			</thead>
			<tbody>
				<s:if test="departmentList.size() == 0">
						<tr>
							<td colspan="99" style="text-align: center;">没有查询赛项信息！</td>
						</tr>
					</s:if>
					<s:iterator value="departmentList" status="L">
						<tr>
							<td>
								<s:property value="#L.index+1"/>	
							</td>
							
							<td>
								<s:property value="dno"/>
							</td>
							
							<td>
								<s:property value="dname"/>
							</td>
							<td>
								<s:property value="fuzeren"/>
							</td>
							<td>								
								<span class="edit"><a class="btn btn-mini btn-primary" href="editTodepartment.action?dno=<s:property value="dno"/>">
									修改
								</a></span>
								<span class="del"><a class="btn btn-mini btn-primary" href="deletedepartment.action?dno=<s:property value="dno"/>" onclick="return confirm('是否删除')">删除</a>
								</span>
							</td>
						</tr>
					</s:iterator>

			</tbody>
			<tfoot>
				<s:if test="departmentList.size() > 0">
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
