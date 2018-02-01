<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>专业评估结果分类查询</title>

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
			src="${pageContext.request.contextPath}/Scripts/ajax/MajorByDno.js">
</script>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
		<script type="text/javascript"><!--
//日历插件
$(function() {
	$(".datepicker").datepicker();
})

$(document).ready(function() {
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
//查看统计图
function findScoreCountList(){
	window.location.href="initClassifyGraph.action"
}
function categorychange(){
	 $.ajax({
        type: 'POST',
        datatype: "json",
        url: "majorClassCascade.action",
        data: {
            mc: $("#category").val()
        },
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        success: function(json) {
        	var jaName = json.jaName;
        	var jaMno = json.jaMno;
        	var optionstring = '';
        	for(var i=0;i<jaName.length;i++){
        		optionstring +=  "<option value=\"" + jaMno[i]+ "\" >" + jaName[i] + "</option>";
        	}
        	$("#major").html("<option value=''>全部专业</option> "+optionstring);
        }
        });


}
//多条件查询
function findContestApply() {
	var category = document.getElementById("category").value;
	var majorId = document.getElementById("major").value;
	var pName = document.getElementById("pName").value;
	pName = encodeURI(pName);
	pName = encodeURI(pName);
	var order = document.getElementById("order").value;
	window.location.href = "classifyFindScore.action?rows=10"+"&page=1"+"&basemodel.departmentId="
			+ category + "&basemodel.majorId="+ majorId+"&basemodel.name=" + pName+"&basemodel.id="+order;
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
	var tname = "" + '${basemodel.name}';
	tname = encodeURI(tname);
	tname = encodeURI(tname);
	window.location.href = "classifyFindScore.action?rows=" + rows
			+ "&page=" + page+"&basemodel.name=" + tname
			+"&basemodel.id="+'${basemodel.id}';
}

function setRows(rows) {
	var tname = "" + '${basemodel.name}';
	tname = encodeURI(tname);
	tname = encodeURI(tname);
	window.location.href = "classifyFindScore.action?basemodel.name=" + tname+ "&basemodel.departmentId="
			+ '${basemodel.departmentId}' + "&basemodel.majorId="
			+ '${basemodel.majorId}' + "&rows="
			+ rows.value;
}
//导出
function exportSubContestTExcel() {
var tname = "" + '${basemodel.name}';
	tname = encodeURI(tname);
	tname = encodeURI(tname);
	var tid = "" + '${basemodel.id}';
	tid = encodeURI(tid);
	tid = encodeURI(tid);
	window.location.href = "exportSubContestTExcel.action?exportName=mascore&basemodel.name=" + tname+ "&basemodel.departmentId="
			+ '${basemodel.departmentId}' + "&basemodel.majorId="
			+ '${basemodel.majorId}' ;
}
</script>

	</head>

	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>评估管理
			<b class="tip"></b>评估结果分类查询
		</div>

		<form action="classifyFindScore.action?page=1&rows=10" id="form1"
			name="form1" method="post" enctype="multipart/form-data">
<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />

			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="9">
							评估结果分类查询信息
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width:10px; text-align:center;">
							专业类别
						</td>
						<td style="width:20px;">
							<select size="1" id="category" name="basemodel.departmentId"
								class="department" onchange="categorychange();">
								<option value="">
									全部类别
								</option>
								<s:iterator value="majorClassList">
									<option value="<s:property value='classcode'/>">
										<s:property value="classname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width:10px; text-align:center;">
							所在专业
						</td>
						<td  style="width:10px;">
							<select size="1" name="basemodel.majorId" id="major">
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
						<td style="width:10px;">
							开启评估项目名称
						</td>
						<td style="width:10px;">
							<select size="1" name="basemodel.Name" id="pName">
								<s:iterator value="projectList">
									<option value="<s:property value='masprojectName'/>">
										<s:property value="masprojectName" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width: 10px; text-align:center;">
							选择排序项
						</td>
						<td style="width: 10px;">
							<select size="1" id="order" name="basemodel.Id"
								class="department">
								<option value="9">
									总分
								</option>
								<option value="1">
									1.专业设置
								</option>
								<option value="2">
									2.培养模式
								</option>
								<option value="3">
									3.师资队伍
								</option>
								<option value="4">
									4.教学资源
								</option>
								<option value="5">
									5.培养过程
								</option>
								<option value="6">
									6.教学质量保证
								</option>
								<option value="7">
									7.学生发展
								</option>
								<option value="8">
									8.专业特色
								</option>
							</select>
						</tr>
					</tr>
				</tbody>
				<tfoot>
					<tr>
					<td style="height:30px; font-size: 15px; text-align: center;">
							<a href="javascript:findContestApply();"
								class="btn btn-primary add">查询</a>&nbsp;&nbsp;
					</td>
					<td style="height:30px; font-size: 15px; text-align: center;">
							<a href="javascript:findScoreCountList();"
								class="btn btn-primary add">查看统计图</a>&nbsp;&nbsp;
					</td>
					<td colspan="6"></td>
					</tr>
				</tfoot>
			</table>
		</form>

		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				评估结果分类查询列表
			</caption>
			<thead>
				<tr>
					<td>
						#
					</td>
					<td>
						评估项目
					</td>
					<td>
						专业
					</td>
					<td>
						1.专业设置
					</td>
					<td>
						2.培养模式
					</td>
					<td>
						3.师资队伍
					</td>
					<td>
						4.教学资源
					</td>
					<td>
						5.培养过程
					</td>
					<td>
						6.教学质量保证
					</td>
					<td>
						7.学生发展
					</td>
					<td>
						8.专业特色
					</td>
					<td>
						总和
					</td>
					<td>
						总和分类排名
					</td>
				</tr>
			</thead>
			<tbody>
				<s:if test="scoreList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有查询到相关信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="scoreList" id="target" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td>
							<s:property value="masprojectName" />
						</td>
						<td>
							<s:property value="mname" />
						</td>
						<td>
							<s:property value="firstTarget" />
						</td>
						<td>
							<s:property value="secondTarget" />
						</td>
						<td>
							<s:property value="thirdTarget" />
						</td>
						<td>
							<s:property value="fouthTarget" />
						</td>
						<td>
							<s:property value="fifthTarget" />
						</td>
						<td>
							<s:property value="sixthTarget" />
						</td>
						<td>
							<s:property value="seventhTarget" />
						</td>
						<td>
							<s:property value="eightTarget" />
						</td>
						<td>
							<s:property value="totalScore" />
						</td>
						<td>
							<s:property value="totalTargetRankingByClass" />
						</td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="scoreList.size() > 0">
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
