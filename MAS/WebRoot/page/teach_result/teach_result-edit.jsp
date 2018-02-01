<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>教材信息修改</title>
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
//修改
function modifi() {
	if (confirm("是否修改")) {
		document.getElementById("modifi").submit();
	}
}
function yearTest(){
	var y=document.getElementById("year").value;
	if(y.length!=4){
		confirm("年份长度只能为4");
		document.getElementById("year").focus();
	}
}
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

function modifi() {
    var regx=/\d/;
	if (document.getElementById("tresultName").value.length == 0){
		alert("教学成果名称信息不能为空");
		document.getElementById("tresultName").focus();
	}else if(document.getElementById("year").value.length == 0){
		alert("年份信息不能为空");
		document.getElementById("year").focus();
	}else if(document.getElementById("year").value.length !=4||!document.getElementById("year").value.match(regx)){

		alert("年份信息格式不正确");
		document.getElementById("year").focus();
	}else if (confirm("是否保存")) {
		document.getElementById("modifi").submit();
	}
}
</script>
	</head>

	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业数据采集
			<b class="tip"></b>教学成果奖项信息修改
		</div>
		<form action="teachResultBase_modifi.action" id="modifi" method="post">

			<table class="table table-striped table-bordered table-condensed">
				<caption class="t_caption">
					教学成果奖信息修改
				</caption>
				<thead>
					<tr>
						<td colspan="99">
							教学成果奖信息修改
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 60px;">
							奖励项目名称:
							<span style="color: red;">&nbsp;&nbsp;*</span>
						</td>
						<td>
							<input name="teachresultbaseinfo.tresultName" id="tresultName"
								value='<s:property value="teachresultbaseinfo.tresultName" />'
								type="text" />
						</td>
						<td style="width: 60px;">
							获奖级别:
							<span style="color: red;">&nbsp;&nbsp;*</span>
						</td>
						<td>
							<select name="teachresultbaseinfo.tresultJibie" id="tresultJibie">

								<option value="国家级"
									<s:if test=' "国家级"==teachresultbaseinfo.tresultJibie'>selected="selected"</s:if>>
									国家级
								</option>
								<option value="省级"
									<s:if test=' "校级"==teachresultbaseinfo.tresultJibie'>selected="selected"</s:if>>
									校级
								</option>
								<option value="校级"
									<s:if test=' "省级"==teachresultbaseinfo.tresultJibie'>selected="selected"</s:if>>
									省级
								</option>
								<option value="院级"
									<s:if test='"院级"==teachresultbaseinfo.tresultJibie'>selected="selected"</s:if>>
									院级
								</option>
								<option value="个人"
									<s:if test=' "个人"==teachresultbaseinfo.tresultJibie'>selected="selected"</s:if>>
									个人
								</option>
								<option value="其他"
									<s:if test='"其他"==teachresultbaseinfo.tresultJibie'>selected="selected"</s:if>>
									其他
								</option>
							</select>
						</td>
						<td style="width: 60px;">
							获奖等级:
							<span style="color: red;">&nbsp;&nbsp;*</span>
						</td>
						<td>
							<select name="teachresultbaseinfo.tresultClass">

								<option value="一等奖"
									<s:if test='"一等奖"==teachresultbaseinfo.tresultClass'>selected="selected"</s:if>>
									一等奖
								</option>
								<option value="二等奖"
									<s:if test='"二等奖"==teachresultbaseinfo.tresultClass'>selected="selected"</s:if>>
									二等奖
								</option>
								<option value="三等奖"
									<s:if test='"三等奖"==teachresultbaseinfo.tresultClass'>selected="selected"</s:if>>
									三等奖
								</option>
								<option value="优秀奖"
									<s:if test='"优秀奖"==teachresultbaseinfo.tresultClass'>selected="selected"</s:if>>
									优秀奖
								</option>
								<option value="其他"
									<s:if test='"其他"==teachresultbaseinfo.tresultClass'>selected="selected"</s:if>>
									其他
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							获奖年份:
							<span style="color: red;">&nbsp;&nbsp;*</span>
						</td>
						<td>
							<input type="text" name="teachresultbaseinfo.year"
								value='<s:property value="teachresultbaseinfo.year" />'
								id="year" onblur="yearTest();"
								onkeypress="return Numbers(event)" />
						</td>
						<td>
							证书编号:
						</td>
						<td colspan="3">
							<input type="text" name="teachresultbaseinfo.approvalNumber"
								id="approvalNumber"
								value='<s:property value="teachresultbaseinfo.approvalNumber" />' />
						</td>
					</tr>
					<tr>
						<td>
							授予单位
						</td>
						<td colspan="6">
							<textarea name="teachresultbaseinfo.rewardDepart"
								style="margin: 0; width: 99%; word-break: break-all; border-style: none; border: 0; background-color: transparent; overflow: hidden; resize: none;">
								<s:property value="teachresultbaseinfo.rewardDepart" />
							</textarea>
						</td>

					</tr>
					<tr>
						<td>
							备注

						</td>
						<td colspan="6">
							<textarea name="teachresultbaseinfo.beizhu"
								style="margin: 0; width: 99%; word-break: break-all; border-style: none; border: 0; background-color: transparent; overflow: hidden; resize: none;">
								<s:property value="teachresultbaseinfo.beizhu" />
							</textarea>
						</td>
					</tr>


				</tbody>
				<tfoot>
					<tr>
						<td colspan="99">
        					<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>
							<a href="javascript:modifi()" class="btn btn-primary add">保存</a>&nbsp;&nbsp;

						</td>
					</tr>
				</tfoot>
			</table>

		</form>


	</body>
</html>
