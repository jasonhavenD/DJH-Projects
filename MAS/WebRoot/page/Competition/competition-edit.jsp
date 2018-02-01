<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>编辑竞赛获奖信息</title>

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
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/inuniqueness.js">
</script>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
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
function yearTest() {
	var y = document.getElementById("year").value;
	if (y.length != 4) {
		confirm("年份长度只能为4");
		document.getElementById("year").focus();
	}
}
function Numbers(e) {
	var keynum
	var keychar
	var numcheck

	if (window.event) // IE   
	{
		keynum = e.keyCode
	} else if (e.which) // Netscape/Firefox/Opera   
	{
		keynum = e.which
	}
	keychar = String.fromCharCode(keynum)
	numcheck = /\d/
	return numcheck.test(keychar)
}
//添加
function addCompetition() {
	if (document.getElementById("comNumberError").innerText == "该编号已存在")
		alert("编号已经存在");
	else if (document.getElementById("comName").value.length == 0) {
		confirm("竞赛名称选项不能为空");
	} else if (document.getElementById("comType").value.length == 0) {
		confirm("获奖类型选项不能为空");
	} else if (document.getElementById("comRank").value.length == 0) {
		confirm("获奖等级选项不能为空");
	} else if (document.getElementById("year").value.length == 0
			&& document.getElementById("year").value.length != 4) {
		confirm("年份选项不能为空或者年份格式错误");
	} else if (confirm("是否添加")) {
		document.getElementById("addCompetition").submit();
	}
}

//修改赛项信息conId(S)
function modifyCompetition() {
	 if (document.getElementById("comName").value.length == 0) {
		confirm("竞赛名称选项不能为空");
		document.getElementById("comName").focus();
	} else if (document.getElementById("year").value.length == 0) {
		confirm("年份选项不能为空");
		document.getElementById("year").focus();
	} else if (confirm("是否添加")) {
		document.getElementById("modifyCompetition").submit();
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
	window.location.href = "contestApplyOfficeList.action?rows=" + rows
			+ "&page=" + page;
}

function setRows(rows) {
	window.location.href = "contestApplyOfficeList.action?rows=" + rows.value;
}
</script>
	</head>
	<body style="background-color:#e4dfd9">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业数据采集
			<b class="tip"></b>编辑竞赛获奖信息
		</div>
		<!--<form action="addCompetition.action" id="addCompetition" method="post">
			<table class="table table-bordered table-condensed list">
				<caption class="t_caption">
					添加竞赛获奖信息
				</caption>
				<thead>
					<tr>
						<td colspan="99">
							添加竞赛获奖信息
							<i class="tip-up"></i>
						</td>
					</tr>
				</thead>
				<tbody id="mytable" class="tby">
					<tr>
						<td style="width: 60px;">
							竞赛编号
							<font color="FF0000">*</font>
						</td>
						<td>
							<input name="competition.comNumber" id="comNumber"
								onblur="stublur();" type="text" />
						</td>
						<td style="width: 60px;">
							竞赛名称
							<font color="FF0000">*</font>
						</td>
						<td>
							<input name="competition.comName" id="comName" type="text" />
						</td>
						<td style="width: 60px;">
							获奖类别
							<font color="FF0000">*</font>
						</td>
						<td>
							<select name="competition.comType" id="comType">
								<option>
									国家级
								</option>
								<option>
									省级
								</option>
								<option>
									校级
								</option>
								<option>
									院级
								</option>
								<option>
									其他
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							获奖等级
							<font color="FF0000">*</font>
						</td>
						<td>
							<select name="competition.comRank" id="comRank">
								<option>
									一等奖
								</option>
								<option>
									二等奖
								</option>
								<option>
									三等奖
								</option>
								<option>
									优秀奖
								</option>
							</select>
						</td>
						<td style="width: 60px;">
							年份
							<font color="FF0000">*</font>
						</td>
						<td>
							<input name="competition.year" id="year" type="text"
								onblur="yearTest();" onkeypress="return Numbers(event)" />

						</td>
						<td style="width: 60px;">
							备注

						</td>
						<td colspan="4">
							<input name="competition.note" id="note" type="text" />
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="99">
							<a href="javascript:addCompetition()"
								class="btn btn-mini btn-primary">添加</a>
							<span id="comNumberError"></span>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>

		--><form action="editCompetition.action" id="modifyCompetition"
			method="post">
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							编辑竞赛获奖信息
						</td>
					</tr>


				</thead>
				<tbody id="mytable">
					<tr>
						<!--<td style="width: 60px;">
							竞赛编号:<font color="FF0000">*</font>
						</td>
						<td>
							<s:if test='competition==null'>
								<input name="competition.comNumber" id="comNumber"  type="text" />
							</s:if>
							<s:else>
								<input name="competition.comNumber" id="comNumber"
								value='<s:property value="competition.comNumber"/>' type="text" readonly="readonly" />
							</s:else>
							<span id="comNumberError"></span>
						</td>
						--><td style="width: 60px;">
							竞赛名称:<font color="FF0000">*</font>
						</td>
						<td>
							<input name="competition.comName" id="comName"
								value='<s:property value="competition.comName"/>' type="text" />
						</td>
						<td>
							获奖级别:<font color="FF0000">*</font>
						</td>
						<td>
							<!-- <input name="competition.comType" id="competition.comType"  
							value='<s:property value="competition.comType"/>' type="text" /> -->
							<select name="competition.comType" id="comType">
								<option value="国家级"
									<s:if test='"国家级"==competition.comType'>selected="selected"</s:if>>
									国家级
								</option>
								<option value="省级"
									<s:if test='"省级"==competition.comType'>selected="selected"</s:if>>
									省级
								</option>
								<option value="校级"
									<s:if test='"校级"==competition.comType'>selected="selected"</s:if>>
									校级
								</option>
								<option value="院级"
									<s:if test='"院级"==competition.comType'>selected="selected"</s:if>>
									院级
								</option>
								<option value="其他"
									<s:if test='"其他"==competition.comType'>selected="selected"</s:if>>
									其他
								</option>
							</select>
						</td>

					</tr>
					<tr>
						<td style="width: 60px;">
							获奖等级:<font color="FF0000">*</font>
						</td>
						<td>
							<select name="competition.comRank" >
								<option value="一等奖"
									<s:if test='"一等奖"==competition.comRank'>selected="selected"</s:if>>
									一等奖
								</option>
								<option value="二等奖"
									<s:if test='"二等奖"==competition.comRank'>selected="selected"</s:if>>
									二等奖
								</option>
								<option value="三等奖"
									<s:if test='"三等奖"==competition.comRank'>selected="selected"</s:if>>
									三等奖
								</option>
								<option value="优秀奖"
									<s:if test='"优秀奖"==competition.comRank'>selected="selected"</s:if>>
									优秀奖
								</option>
								<option value="其他"
									<s:if test='"其他"==competition.comRank'>selected="selected"</s:if>>
									其他
								</option>
							</select>
						</td>
						<td style="width: 60px;">
							年份:<font color="FF0000">*</font>
						</td>
						<td>
							<input name="competition.year" 	id="year"  onkeypress="return Numbers(event)" maxlength="4" 
							value='<s:property value="competition.year"/>' type="text" />
						</td>
						
					</tr>
					<tr>
						<td style="width: 60px;">
							备注
						</td>
						<td colspan="4">
							<input name="competition.note"
								value='<s:property value="competition.note"/>' type="text" />
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="99">
							
							<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
							<a href="javascript:modifyCompetition()"
								class="btn btn-primary add">保存</a>

						</td>
					</tr>
				</tfoot>
			</table>
		</form>



	</body>
</html>
