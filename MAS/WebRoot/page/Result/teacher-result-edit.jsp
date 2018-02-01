<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>教师成果信息修改</title>

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
			src="${pageContext.request.contextPath}/Scripts/ajax/add.js">
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

function modifyTeacherachievements() {
var regs=/\d/;
	if (document.getElementById("names").value.length == 0) {
		alert("教师姓名不能为空");
		document.getElementById("anames").focus();
	}else if (document.getElementById("ateachRank").value.length == 0) {
		alert("排名选项不能为空");
		document.getElementById("ateachRank").focus();
	}else if (!document.getElementById("ateachRank").value.match(regs)) {
		alert("排名选项数据非法，应为数字");
		document.getElementById("ateachRank").focus();
	} 
	else if (confirm("是否保存")) {
		document.getElementById("modifiTeacherachievements").submit();
	}
}
</script>

	</head>

	<body style="background-color:#e4dfd9">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业数据采集
			<b class="tip"></b>查询科研成果信息
			<b class="tip"></b>科研成果详细信息
			<b class="tip"></b>修改科研成果成员信息
		</div>

		<form action="modifiTeacherachievements.action"
			id="modifiTeacherachievements" method="post">
			<table class="table table-striped table-bordered table-condensed">
				<caption class="t_caption">
					编辑科研成果成员
				</caption>
				<thead>
					<tr>
						<td colspan="99">
							科研成果成员
							
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 60px;">
							成果名称
							<font color="FF0000">*</font>
						</td>
						<td>
							<input type="text"
								name="teacherachievements.achievements.certificateName"
								value='<s:property value="achievements.certificateName" />'
								disabled="true" />
						</td>
						<td style="width: 60px;">
							教师工号/姓名
							<font color="FF0000">*</font>
						</td>
						<td>
							<div id="abc" style="display: inline; float: left;">
								<input type="text" name="teacherachievements.teacher.tno" 
									style="background: transparent;" placeholder="输入教工号或姓名搜索"
									autocomplete="off" id="names" onkeyup="findNames('${userId}')"
									onfocus="findNames('${userId}')"  value='<s:property value="teacherachievements.teacher.tno" />'/>
								<!-- 自动搜索，用于显示搜索结果 -->
								<div id="popup"
									style="border: 1px solid #c7c7c7; border-top: none; z-index: 1; position: absolute; overflow: auto;">
									<table class="autoSeek" id="complete_table">
										<tbody id="complete_body"></tbody>
									</table>
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							获奖人排名
							<font color="FF0000">*</font>
						</td>
						<td>
							<input type="text" name="teacherachievements.teachRank" id="ateachRank"
								value='<s:property value="teacherachievements.teachRank" />'
								onkeypress="return Numbers(event)" />
						</td>
						<td style="width: 60px;">
							备注
						</td>
						<td>
							<input type="text" name="teacherachievements.beizhu"
								value='<s:property value="teacherachievements.beizhu" />' />
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="99">
							<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
							<a href="javascript:modifyTeacherachievements()"
								class="btn btn-primary add">保存</a>
							
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</body>
	<script charset="UTF-8">
var XMLHttpReq;
var completeDiv;
var inputField;
var completeTable;
var completeBody;
//创建XMLHttpRequest对象
function createXMLHttpRequest() {
	var o;
	if (window.XMLHttpRequest) { //Mozilla 浏览器   
		o = new XMLHttpRequest();
	} else if (window.ActiveXObject) { // IE浏览器   
		try {
			o = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				o = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
			}
		}
	}
	return o;
}
</script>
</html>
