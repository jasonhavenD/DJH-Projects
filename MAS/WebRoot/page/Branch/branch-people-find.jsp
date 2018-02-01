<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>创新创业项目详细信息</title>

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
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/textarea.js">
</script>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/timeManage.js">
</script>

		<script type="text/javascript">
//日历插件
$(function() {
	$(".datepicker").datepicker();

	var _this = $('.list').find('thead');
	$('.tby').hide();
	//折叠
	_this.click(function() {
		var i = $(this).find('i');
		if (i.attr('class') == 'tip-down') {
			i.attr('class', 'tip-up')
		} else {
			i.attr('class', 'tip-down')
		}
		$(this).parent().find('tbody').toggle();
	})

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
	window.location.href = "innovation_see.action?rows=" + rows + "&page="
			+ page;
}

function setRows(rows) {
	window.location.href = "innovation_see.action?rows=" + rows.value+"&page=1";
}
//导出
function exportSubContestTExcel1() {
	var a = document.getElementById("innoNumber").value;
	window.location.href = "exportSubContestTExcel1.action?exportName=innovationmember"
			+ "&comNumber="+a;
	alert(comNumber);
}
//上传附件弹出框
function upFile() {
	document.getElementById("iframe").src = "attachFileList.action?importName=innovationmember";
	$('#alert-win').dialog( {
		width : 450,
		height : 240,
		buttons : {
			"关闭" : function() {
				refashChengyuan();
				$(this).dialog("close");
			}
		}
	});
	$(document).ready(function() {
		// ------------------------------	
			//角色判断
			var rol = $("#rol").val();
			var totalRows = $("#totalRows").val();
			if (rol == 4) {
				$("#attach").hide();//隐藏导入
				for ( var i = 0; i < totalRows; i++) {
					$("#edit").hide();
					$("#del").hide();

				}
			}
		});
}
function refashChengyuan(){
	document.getElementById("refashChengyuan").submit();
}
//查询
function findContestApply() {
	document.getElementById("form1").submit();
}
</script>

	</head>

	<body onload="init()"style="background-color:#e4dfd9">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业数据采集
			<b class="tip"></b>创新创业项目详细信息
		</div>
		<input type="hidden" id="rol" value="<s:property value="rol"/>" />
		<input type="hidden" id="totalRows"
			value="<s:property value="totalRows"/>" />
		<table class="table table-striped table-bordered table-condensed">
			<thead>
				<tr>
					<td colspan="99">
						创新创业项目详细信息
					</td>
				</tr>
			</thead>
			<tbody id="mytable">
				<tr>
					<td style="width: 60px;">
						项目编号:
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="innovationproject.innoNumber" disabled="true"
							id="innoNumber"
							value='<s:property value="innovationproject.innoNumber"/>'
							type="text" />
					</td>
					<td style="width: 60px;">
						项目名称:
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="innovationproject.innoName" disabled="true" id="innoName"
							value='<s:property value="innovationproject.innoName"/>'
							type="text" />
					</td>
					<td>
						立项时间:
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="innovationproject.setDate" disabled="true" id="setDate"
							value='<fmt:formatDate pattern="yyyy-MM-dd" value="${innovationproject.setDate}" />'
							type="text" />
					</td>

				</tr>
				<tr>
					<td style="width: 60px;">
						项目级别:
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="innovationproject.level" disabled="true"
							value='<s:property value="innovationproject.level"/>' type="text" />
					</td>

					<td style="width: 60px;">
						项目类型:
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="innovationproject.type" disabled="true"
							value='<s:property value="innovationproject.type"/>' type="text" />
					</td>
					<td style="width: 60px;">
						结题时间:
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="innovationproject.endDate" disabled="true" id="endDate"
							value='<fmt:formatDate pattern="yyyy-MM-dd" value="${innovationproject.endDate}" />'
							type="text" />
					</td>

				</tr>
				<tr>

					<td style="width: 60px;">
						项目经费:
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="innovationproject.cost" disabled="true" id="cost"
							value='<s:property value="innovationproject.cost"/>' type="text" />
						<span style="color:red">单位：万元（最多保留小数点后四位）</span>
					</td>
					<td>
						验收结论
					</td>
					<td>
						<input name="innovationproject.assessment" disabled="true"
							value='<s:property value="innovationproject.assessment"/>'
							type="text" />
					</td>
					<td>
						备注
					</td>
					<td>
						<input name="innovationproject.note" disabled="true"
							value='<s:property value="innovationproject.note"/>' type="text" />
					</td>
				</tr>
			</tbody>
<tfoot>
			<tr>
				<td>
					<a class="btn btn-primary add" href="innovation_find.action?rows=<s:property value="trows" />&page=<s:property value="tpage" />">返回上一页</a>&nbsp;&nbsp;

				</td>
				<td>
					<a href="#" onclick="exportSubContestTExcel1()"
						class="btn btn-primary add">导出科创成员列表</a> &nbsp;&nbsp;
					</td>
				<td colspan="4">
					<!--选择导入的文件 -->
					<a id = "add" class="btn btn-primary add"
								href="innovation_editM.action?innoMemNumber=0">
								添加成员信息 </a>
					<a id="attach" href="javascript:void(0);"
						onclick="upFile();return false;" class="btn btn-primary add">导入当前科创成员信息</a>
						<!--清空所有成员信息 -->
					<a id="deleteAll" href="clearM.action?innoNumber=<s:property value="innoNumber"/>"
						onclick="return confirm('确认删除所有成员信息吗？');" class="btn btn-primary add">清空所有成员</a>			
					<!--清空当前页成员信息 -->
					<a id="deleteThis" href="clearListM.action"
						onclick="return confirm('确认删除当前页成员信息吗？');" class="btn btn-primary add">清空当前页成员</a>			
				</td>
			</tr>
		</tfoot>
		</table>
		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				创新创业项目成员列表
			</caption>
			<thead>
				<tr class="tr_title" style="height: 30px;">
					<td>
						#
					</td>
					<td>
						学号
					</td>
					<td>
						姓名
					</td>
					<td>
						项目名称
					</td>
					<td>
						成员排名
					</td>
					<td>
						操作
					</td>

				</tr>
			</thead>
			<tbody>
				<s:if test="innovationmemberList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有成员信息！
							
						</td>
					</tr>
				</s:if>
				<s:iterator value="innovationmemberList" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td>
							<s:property value="student.stuNumber" />
						</td>
						<td>
							<s:property value="student.stuName" />
						</td>
						<td>
							<s:property value="innovationproject.innoName" />
						</td>
						<td>
							<s:property value="rank" />
						</td>
						<td>
							<span class="edit"> <a class="btn btn-mini btn-primary"
								href="innovation_editM.action?innoMemNumber=<s:property value="innoMemNumber"/>">
									修改成员信息 </a>
							</span>
							<span class="del"> <a class="btn btn-mini btn-primary"
								onclick="return confirm('确认删除吗？');"
								href="innovation_deleteM.action?innoMemNumber=<s:property value="innoMemNumber"/>">
									删除 </a>
							</span>

						</td>
					</tr>
				</s:iterator>

			</tbody>
			<tfoot>
				<s:if test="innovationmemberList.size() > 0">
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
<form action="innovation_initSee.action?innoNumber=<s:property value="innoNumber"/> " id="refashChengyuan"/>
	</body>
</html>
