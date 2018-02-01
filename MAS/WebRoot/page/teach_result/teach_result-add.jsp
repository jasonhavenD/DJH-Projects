<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>教学成果信息添加</title>
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
			src="${pageContext.request.contextPath}/Scripts/ajax/truniqueness.js">
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


function Numbers(e)
{
var keynum
var keychar
var numcheck

if(window.event) // IE
{
keynum = e.keyCode
}
else if(e.which) // Netscape/Firefox/Opera
{
keynum = e.which
}
keychar = String.fromCharCode(keynum)
numcheck = /\d/
return numcheck.test(keychar)
}

//添加
function add() {
    var regx=/\d/;
	if (document.getElementById("tresultName").value.length == 0){
		document.getElementById("tresultNameError").innerText="教学成果信息不能为空";
		document.getElementById("tresultName").focus();
	}else if(document.getElementById("year").value.length == 0){
		document.getElementById("yearError").innerText="年份信息不能为空";
		document.getElementById("year").focus();
	}else if(document.getElementById("year").value.length !=4||!document.getElementById("year").value.match(regx)){

		alert("年份信息格式不正确");
		document.getElementById("year").focus();
	}else if (confirm("是否添加")) {
		document.getElementById("add").submit();
	}
}
function checkNull(tagName, tagErrorName) {
	var tagValue = document.getElementById(tagName).value;

	if (tagValue.length == 0) {
		document.getElementById(tagErrorName).innerHTML = "该选项不能为空";
		document.getElementById(tagErrorName).style.color = "red";
		return false;
	} else {
		document.getElementById(tagErrorName).innerHTML = "已填写";
		document.getElementById(tagErrorName).style.color = "green";
		return true;
	}
}

</script>
	</head>

	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业数据采集
			<b class="tip"></b>教学成果奖项信息添加
		</div>
		<form action="teachResultBase_modifi.action" id="add" method="post">
			<table class="table table-bordered table-condensed list">
				<caption class="t_caption">
					添加教学成果奖信息
				</caption>
				<tbody>
					<tr>
						<td style="width: 60px;">
							奖励项目名称
							<font color="FF0000">*</font>
						</td>
						<td>
							<input name="teachresultbaseinfo.tresultName" id="tresultName" onblur="return checkNull('tresultName','tresultNameError')"
							type="text" />
							<span id="tresultNameError" style="color:red"></span>
						</td>
						<td style="width: 60px;">
							获奖级别
							<font color="FF0000">*</font>
						</td>
						<td>
							<select size="1" name="teachresultbaseinfo.tresultJibie" id="tresultJibie">
								<option value="国家级">
									国家级
								</option>
								<option value="省级">
									省级
								</option>
								<option value="校级">
									校级
								</option>
								<option value="院级">
									院级
								</option>
								<option value="其他">
									其他
								</option>
							</select>
						</td>
						<td style="width: 60px;">
							获奖等级
							<font color="FF0000">*</font>
						</td>
						<td>
							<select size="1" name="teachresultbaseinfo.tresultClass" id="tresultClass">
								<option value="一等奖">
									一等奖
								</option>
								<option value="二等奖">
									二等奖
								</option>
								<option value="二等奖">
									三等奖
								</option>
								<option value="优秀奖">
									优秀奖
								</option>
								<option value="其他">
									其他
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							获奖年份
							<font color="FF0000">*</font>
						</td>
						<td>
							<input type="text" name="teachresultbaseinfo.year" id="year"
							  onkeypress="return Numbers(event)"/>
							<span id="yearError" style="color:red">（为四位数字）</span>
						</td>
						<td>
							证书编号
						</td>
						<td colspan="3">
							<input type="text" name="teachresultbaseinfo.approvalNumber" id="approvalNumber" onblur="return checkNull('approvalNumber','approvalNumberError')"/>
							<span id="approvalNumberError" style="color:red"/>
						</td>
					</tr>
					<tr>

						<td>
							授予单位:

						</td>
						<td colspan="6">
							<textarea name="teachresultbaseinfo.rewardDepart" id="rewardDepart"
								style="margin: 0; width: 99%; word-break: break-all; border-style: none; border: 0; overflow: hidden; resize: none;"></textarea>
						</td>

					</tr>
					<tr>
						<td>
							备注

						</td>
						<td colspan="6">
							<textarea name="teachresultbaseinfo.beizhu" id="text"
								style="margin: 0; width: 99%; word-break: break-all; border-style: none; border: 0; overflow: hidden; resize: none;"></textarea>
						</td>
					</tr>

				</tbody>
				<tfoot>
					<tr>
						<td colspan="99">
							<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>
							<a href="javascript:add()" class="btn btn-primary add">保存</a>
							<span id="tresultBaseNoError"></span>&nbsp;&nbsp;
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</body>
</html>
