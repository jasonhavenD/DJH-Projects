<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>教师发表教改论文</title>

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

	//导入弹出框
function upFile() {
	document.getElementById("iframe").src = "attachFileList.action?importName=pep";
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
	window.location.href = "editToPap.action?paperNo=" + paperNo;
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
	var pname = ""+'${pepmodel.name}'; 
	var pprojecType = ""+'${pepmodel.periodicalType}'; 
	
 	pname = encodeURI(pname); 
 	pname = encodeURI(pname);
 	pprojecType = encodeURI(pprojecType); 
 	pprojecType = encodeURI(pprojecType); 
	window.location.href = "findPep.action?pepmodel.id=" + '${pepmodel.id}'
			+ "&pepmodel.name=" + pname
			+ "&pepmodel.departmentId=" + '${pepmodel.departmentId}'
			+ "&pepmodel.year=" + '${pepmodel.year}' + "&pepmodel.majorId="
			+ '${pepmodel.majorId}' + "&pepmodel.revoPaperName="
			+ '${pepmodel.revoPaperName}' + "&pepmodel.revoPeriodicalInfo="
			+ '${pepmodel.revoPeriodicalInfo}' + "&pepmodel.periodicalType="
			+ pprojecType + "&pepmodel.beizhu="
			+ '${pepmodel.beizhu}' + "&rows=" + rows + "&page=" + page;

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
		if (rol != 3) {
			$("#attachPep").hide();//隐藏清空
		}
	});
function setRows(rows) {
	var pname = ""+'${pepmodel.name}'; 
	var pprojecType = ""+'${pepmodel.periodicalType}'; 
	
 	pname = encodeURI(pname); 
 	pname = encodeURI(pname);
 	pprojecType = encodeURI(pprojecType); 
 	pprojecType = encodeURI(pprojecType); 
	window.location.href = "findPep.action?pepmodel.id=" + '${pepmodel.id}'
			+ "&pepmodel.name=" + pname
			+ "&pepmodel.departmentId=" + '${pepmodel.departmentId}'
			+ "&pepmodel.year=" + '${pepmodel.year}' + "&pepmodel.majorId="
			+ '${pepmodel.majorId}' + "&pepmodel.revoPaperName="
			+ '${pepmodel.revoPaperName}' + "&pepmodel.revoPeriodicalInfo="
			+ '${pepmodel.revoPeriodicalInfo}' + "&pepmodel.periodicalType="
			+ pprojecType + "&pepmodel.beizhu="
			+ '${pepmodel.beizhu}' + "&rows=" + rows.value+"&page=1";
}

//导出我的赛项列表
function exportSubContestTExcel() {
	var pname = ""+'${pepmodel.name}'; 
	var pprojecType = ""+'${pepmodel.periodicalType}'; 
	
 	pname = encodeURI(pname); 
 	pname = encodeURI(pname);
 	pprojecType = encodeURI(pprojecType); 
 	pprojecType = encodeURI(pprojecType); 
	window.location.href = "exportSubContestTExcel.action?exportName=pep"
			+ "&pepmodel.id=" + '${pepmodel.id}' + "&pepmodel.name="
			+ pname + "&pepmodel.departmentId="
			+ '${pepmodel.departmentId}' + "&pepmodel.year="
			+ '${pepmodel.year}' + "&pepmodel.majorId=" + '${pepmodel.majorId}'
			+ "&pepmodel.revoPaperName=" + '${pepmodel.revoPaperName}'
			+ "&pepmodel.revoPeriodicalInfo="
			+ '${pepmodel.revoPeriodicalInfo}' + "&pepmodel.periodicalType="
			+ pprojecType + "&pepmodel.beizhu="
			+ '${pepmodel.beizhu}'
}
</script>

	</head>

	<body style="background-color:#e4dfd9">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>教师发表教改论文
			<b class="tip"></b>查询教师发表教改论文信息
		</div>

		<form action="findPep.action?page=1&rows=10" id="form1" name="form1"
			method="post" enctype="multipart/form-data">

			<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							教师发表教改论文信息查询
						</td>
					</tr>
				</thead>
								<tbody id="mytable">
					<tr>

						<td style="width: 60px;">
							论文名称
						</td>
						<td>
							<input name="pepmodel.revoPaperName"
								value='<s:property value="pepmodel.revoPaperName"/>' type="text" />
						</td>
						<td style="width: 60px;">
							论文类别
						</td>
						<td>
							
						<select size="1" name="pepmodel.periodicalType" id="periodicalType">
							<option value="">
									全部类型
								</option>
								
								<option value="A类"
								<s:if test=' "A类" == pepmodel.periodicalType'>selected="selected"</s:if>>
									A类
								</option>
								<option value="B类"
								<s:if test=' "B类" == pepmodel.periodicalType'>selected="selected"</s:if>>
									
									B类
								</option>
								<option value="公开发表"
								<s:if test=' "公开发表" == pepmodel.periodicalType'>selected="selected"</s:if>>
									
									公开发表
								</option>
							</select>

						</td>

						<td style="width: 70px;">
							年份
						</td>
						<td>
							<select name="pepmodel.year" id="year">
								<option value="">
									全部年份
								</option>
								<s:iterator value="yearList" var="yearvar">
									<option value="<s:property/>"
										<s:if test="#yearvar == pepmodel.year">selected="selected"</s:if>>
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
							<select size="1" id="coll" name="pepmodel.departmentId"
								class="department" onchange="collchange();">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList" var="departmentvar">
									<option value="<s:property value='dno'/>"
									<s:if test="#departmentvar.dno ==pepmodel.departmentId"></s:if>>
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							所在专业
						</td>
						<td colspan="3">
							<select size="1" name="pepmodel.majorId" id="major">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList" var="majorvar">
									<option value="<s:property value='mno'/>"
									<s:if test="#majorvar.mno == pepmodel.majorId"></s:if>>
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
								class="btn btn-primary add">导出教师发表教改论文信息列表</a> &nbsp;&nbsp;
							<span style="color: red;">(先查询，再导出)</span>

						</td>
						<td align="right" colspan="2">
							<span id="add"> <a href="editToPep.action?revoPaperNo=0"
								style="" class="btn btn-primary add">添加</a> 
								</span>
								<!--选择导入的文件 --> <a
								id="attach" href="javascript:void(0);"
								onclick="upFile();return false;" class="btn btn-primary add">导入</a> 
								<!--清空所有教改论文信息查询结果 -->
								<a id="attachPep" href="clearPep.action"
								onclick="return confirm('确认删除所有教改论文信息查询结果吗？');" class="btn btn-primary add">清空所有教改论文信息查询结果</a>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>

		<table style="white-space: normal;" class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				教师发表教改论文信息查询结果
			</caption>
			<thead>
				<tr>
					<td>
						#
					</td>
					<td>
						论文名称
					</td>
					<td>
						论文类别
					</td>
					<td>
						学院名称
					</td>
					<td>
						专业名称
					</td>
					<td>
						教师名称
					</td>
					<td>
						发表年份
					</td>
					<td>
						发表期刊信息
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
				<s:if test="pepList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有查询到信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="pepList" id="publicshedarevolutionpapers"
					status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td>
							<s:property value="revoPaperName" />
						</td>
						<td>
							<s:property value="periodicalType" />
						</td>
						<td>
							<s:property value="teacher.major.department.dname" />
						</td>
						<td>
							<s:property value="teacher.major.mname" />
						</td>
						<td>
							<s:property value="teacher.tname" />
						</td>
						
						<td>
							<s:property value="year" />
						</td>
						<td>
							<s:property value="revoPeriodicalInfo" />
						</td>
						<td>
							<s:property value="beizhu" />

						</td>


						<td>
							<span class="edit"> <a class="btn btn-mini btn-primary"
								href="editToPep.action?revoPaperNo=<s:property value="revoPaperNo"/>">
									修改 </a> </span>
							<span class="del"> <a class="btn btn-mini btn-primary"
								href="deletePep.action?revoPaperNo=<s:property value="revoPaperNo"/>"
								onclick="return confirm('是否删除')"> 删除 </a> </span>
						</td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="pepList.size() > 0">
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
