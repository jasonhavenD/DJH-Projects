<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>科研成果信息</title>

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
//导出我的赛项列表
function exportAchievementsTExcel() {
	var a = document.getElementById("certificateNo").value;
	window.location.href = "exportSubContestTExcel_1.action?exportName=teacherachievements"
			+ "&comNumber=" + a;

}
//上传附件弹出框
function upFile() {
	document.getElementById("iframe").src = "attachFileList.action?importName=teacherachievements";
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
}

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
		//角色判断
		var rol = $("#rol").val();
		var totalRows = $("#totalRows").val();
		if ( rol == 3) {
			$("#attach").hide();//隐藏导入
			for ( var i = 0; i < totalRows; i++) {
				$("#edit").hide();
				$("#del").hide();

			}
		}
	});
//是否删除科研成果
function deleteAchievements() {
	if (confirm("是否删除")) {
		window.location.href = "deleteTeacherachievements.action?certificateNo="
				+ certificateNo;
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
	window.location.href = "findTeachAchieves.action?rows=" + rows + "&page="
			+ page;
}

function setRows(rows) {
	window.location.href = "findTeachAchieves.action?rows=" + rows.value+"&page=1";
}
function refashChengyuan(){
	document.getElementById("refashChengyuan").submit();
}

</script>

	</head>

	<body onload="init()">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业数据采集
			<b class="tip"></b>查询科研成果信息
			<b class="tip"></b>科研成果详细信息
		</div>

		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				科研成果奖详细信息
			</caption>
			<thead>
				<tr>
					<td colspan="99">
						科研成果奖详细信息
					</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="width: 60px;">
						获奖证书编号
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="achievements.certificateNo" type="text"
							id="certificateNo" disabled="true"
							value='<s:property value="achievements.certificateNo" />' />
					</td>
					<td style="width: 60px;">
						成果名称
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="achievements.certificateName" type="text"
							value='<s:property value="achievements.certificateName" />'
							disabled="true" />
					</td>
					<td>
						获奖时间
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="achievements.certificateDate" disabled="true"
							value='<s:property value="achievements.certificateDate" />'
							type="text" />
					</td>
				</tr>
				<tr>
					<td style="width: 60px;">
						完成单位排名
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="achievements.departRank"
							value='<s:property value="achievements.departRank" />'
							disabled="true" type="text" />
					</td>
					<td style="width: 60px;">
						获奖级别
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="achievements.certificateJibie" disabled="true"
							value='<s:property value="achievements.certificateJibie" />'
							type="text" />
					</td>
					<td style="width: 60px;">
						获奖类别
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="achievements.certificateType" disabled="true"
							value='<s:property value="achievements.certificateType" />'
							type="text" />
					</td>
				</tr>
				<tr>
					<td>
						获奖等级
						<font color="FF0000">*</font>
					</td>
					<td colspan="3">
						<input name="achievements.certificateClass" disabled="true"
							value='<s:property value="achievements.certificateClass" />'
							type="text" />
					</td>

					<td >
						备注

					</td>
					<input type="hidden" id="rol" value="<s:property value="rol"/>" />
					<td >
						<input name="achievements.beizhu"
							value='<s:property value="achievements.beizhu" />' type="text"
							disabled="true" />
					</td>
					<!--<td>
						标签

					</td>
					<td>
						<input name="achievements.tag"
							value='<s:property value="achievements.tag" />' type="text"
							disabled="true" />
					</td>
				--></tr>
				<tr>
				<td >
					<a class="btn btn-primary add" href="findAchievements.action?rows=<s:property value="trows" />&page=<s:property value="tpage" />" >返回上一页</a>&nbsp;&nbsp;

				</td>
				<td colspan="3">
					<a href="#" onclick="exportAchievementsTExcel()"
						class="btn btn-primary add">导出科研成果成员列表</a> &nbsp;&nbsp;
					<span style="color: red;">(先查询，再导出)</span>
					</td>
					<td>
					<a id="add" class="btn btn-primary add"
							href="editToTeacherachievements.action?techArcNo=0"> 添加 </a>
					<!--选择导入的文件 -->
					<a id="attach" href="javascript:void(0);"
						onclick="upFile();return false;" class="btn btn-primary add">导入</a>

				</td>
			</tr>
			</tbody>
		</table>
	
		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				《<s:property value="achievements.certificateName" />》科研成果成员列表
			</caption>
			<thead>
				<tr class="tr_title" style="height: 30px;">
					<td>
						#
					</td>
					<td>
						教师工号
					</td>
					<td>
						教师姓名
					</td>
					<td>
						获奖人排名
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
				<s:if test="teachAchievelist.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有科研成果成员信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="teachAchievelist" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td>
							<s:property value="teacher.tno" />
						</td>
						<td>
							<s:property value="teacher.tname" />
						</td>
						<td>
							<s:property value="teachRank" />
						</td>
						<td>
							<s:property value="beizhu" />
						</td>
						<td>
						<span class="edit">
							<a class="btn btn-mini btn-primary"
								href="editToTeacherachievements.action?techArcNo=<s:property value="techArcNo"/>">
								修改成员信息 </a>
								</span>
								<span class="del">
							<a class="btn btn-mini btn-primary"
								onclick="return confirm('确认删除吗？');"
								href="deleteTeacherachievements.action?techArcNo=<s:property value="techArcNo"/>">
								删除 </a></span>
						</td>
					</tr>
				</s:iterator>

			</tbody>
			<tfoot>
				<s:if test="teachAchievelist.size() > 0">
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
		<form action="findTeachAchieves.action?certificateNo=<s:property value="certificateNo"/>" id="refashChengyuan"></form>
	</body>
</html>
