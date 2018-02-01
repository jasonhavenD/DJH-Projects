<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>科研成果修改</title>
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
			src="${pageContext.request.contextPath}/Scripts/ajax/TA_uniqueness.js">
</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/textarea.js">
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
function yearTest(){
	var y=document.getElementById("certificateDate").value;
	if(y.length!=4){
		confirm("年份长度只能为4");
		document.getElementById("certificateDate").focus();
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
//添加
function modifyAchieveIdInfoS() {
	
	if (document.getElementById("certificateNoError").innerText== "该编号已存在"||document.getElementById("certificateNoError").innerText== "科研成果编号不能为空"
	||document.getElementById("certificateNoError").innerText==" "||document.getElementById("certificateNo").value.length==0) {
		alert("科研成果编号错误");
		document.getElementById("certificateNo").focus();
	} else if (document.getElementById("certificateName").value.length == 0) {
		alert("成果名称选项不能为空");
		document.getElementById("certificateName").focus();
	}else if (document.getElementById("certificateDate").value.length == 0) {
		alert("获奖年份选项不能为空");
		document.getElementById("certificateDate").focus();
	} else if (document.getElementById("certificateDate").value.length != 4) {
		alert("获奖年份选项只能为4位数");
		document.getElementById("certificateDate").focus();
	}else if (confirm("是否保存科研成果信息")) {
		document.getElementById("editAchievements").submit();
	}
}

</script>
	</head>
	<body style="background-color:#e4dfd9">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业数据采集
			<b class="tip"></b>编辑科研成果信息
		</div>
		<form action="editAchievements.action" id="editAchievements"
			method="post">
			<table class="table table-striped table-bordered table-condensed">
				<caption class="t_caption">
					科研成果编辑
				</caption>
				<thead>
					<tr>
						<td colspan="99">
							科研成果编辑
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 60px;">
							科研成果编号：<span style="color: red;">&nbsp;&nbsp;*</span>
						</td>
						<td>
							<s:if test='achievements==null'>
								<input name="achievements.certificateNo" type="text" onblur="cerblur();" id="certificateNo" />
							</s:if>
							<s:else>
								<input name="achievements.certificateNo" type="text" disabled="true" id="certificateNo"
									value='<s:property value="achievements.certificateNo" />' />
							</s:else>
							<span id="certificateNoError"></span>
						</td>
						<td style="width: 60px;">
							成果名称：<span style="color: red;">&nbsp;&nbsp;*</span>
						</td>
						<td>
							<input name="achievements.certificateName" type="text" id="certificateName"
								value='<s:property value="achievements.certificateName" />' />
						</td>
						<td style="width: 60px;">
							完成单位排名:
							
						</td>
						<td>
							<input name="achievements.departRank" id="departRank"
								value='<s:property value="achievements.departRank" />'
								onkeypress="return Numbers(event)" 
								type="text" />
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							获奖级别:
							<span style="color: red;">&nbsp;&nbsp;*</span>
						</td>
						<td>
							<select name="achievements.certificateJibie">
								<option value="国家级"
									<s:if test='"国家级"==achievements.certificateJibie'>selected="selected"</s:if>>
									国家级
								</option>
								<option value="省级"
									<s:if test='"省级"==achievements.certificateJibie'>selected="selected"</s:if>>
									省级
								</option>
								<option value="校级"
									<s:if test='"校级"==achievements.certificateJibie'>selected="selected"</s:if>>
									校级
								</option>
								<option value="院级"
									<s:if test='"院级"==achievements.certificateJibie'>selected="selected"</s:if>>
									院级
								</option>
								<option value="其他"
									<s:if test='"其他"==achievements.certificateJibie'>selected="selected"</s:if>>
									其他
								</option>
							</select>
						</td>
						<td style="width: 60px;">
							获奖类别:
							<span style="color: red;">&nbsp;&nbsp;*</span>
						</td>
						<td>
							<select name="achievements.certificateType">
								<option value="科技进步奖"
									<s:if test='"科技进步奖"==achievements.certificateType'>selected="selected"</s:if>>
									科技进步奖
								</option>
								<option  value="自然科学奖"
									<s:if test='"自然科学奖"==achievements.certificateType'>selected="selected"</s:if>>
									自然科学奖
								</option>
								<option value="科技发明奖"
									<s:if test='"科技发明奖"==achievements.certificateType'>selected="selected"</s:if>>
									科技发明奖
								</option>
								<option value="科技成果奖"
									<s:if test='"科技成果奖"==achievements.certificateType'>selected="selected"</s:if>>
									科技成果奖
								</option>
								<option value="其他"
									<s:if test='"其他"==achievements.certificateType'>selected="selected"</s:if>>
									其他
								</option>
							</select>
						</td>
						<td>
							获奖等级:<span style="color: red;">&nbsp;&nbsp;*</span>
						</td>
						<td>
							<select name="achievements.certificateClass">
								<option value="一等奖"
									<s:if test='"一等奖"==achievements.certificateClass'>selected="selected"</s:if>>
									一等奖
								</option>
								<option value="二等奖"
									<s:if test='"二等奖"==achievements.certificateClass'>selected="selected"</s:if>>
									二等奖
								</option>
								<option value="三等奖"
									<s:if test='"三等奖"==achievements.certificateClass'>selected="selected"</s:if>>
									三等奖
								</option>
								<option value="优秀奖"
									<s:if test='"优秀奖"==achievements.certificateClass'>selected="selected"</s:if>>
									优秀奖
								</option>
								<option value="其他"
									<s:if test='"其他"==achievements.certificateClass'>selected="selected"</s:if>>
									其他
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							获奖年份:<span style="color: red;">&nbsp;&nbsp;*</span>
						</td>
						<td>
							<input name="achievements.certificateDate" id="certificateDate"
								value='<s:property value="achievements.certificateDate" />'
								type="text"  onkeypress="return Numbers(event)"  />
						</td>
						<td>
							备注
						</td>
						<td>
							<input name="achievements.beizhu"
								value='<s:property value="achievements.beizhu" />' type="text" />
						</td>
						<td>
							&nbsp;
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="99">
						<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
							<a href="javascript:modifyAchieveIdInfoS()"
								class="btn btn-primary add">保存</a>
							
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</body>
</html>
