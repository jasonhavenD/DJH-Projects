<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>教学质量工程添加</title>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/admin-all.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/other.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
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
			src="${pageContext.request.contextPath}/Scripts/ajax/tpuniqueness.js">
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
	function modify() {
	var regx=/\d/;
		if (document.getElementById("tprojectNo").value.length == 0) {
			alert("教学质量工程编号选项不能为空");
			document.getElementById("tprojectNo").focus();
		} else if (document.getElementById("tprojectNoError").innerText == "该编号已存在") {
			alert("编号已经存在");
			document.getElementById("tprojectNo").focus();
		} else if (document.getElementById("tprojectName").value.length == 0) {
			alert("工程名称不能为空");
			document.getElementById("tprojectName").focus();

		} else if (document.getElementById("year").value.length == 0) {
			alert("年份选项不能为空");
			document.getElementById("year").focus();
		}else if(document.getElementById("year").value.length != 4||!document.getElementById("year").value.match(regx)){
			alert("年份格式不正确");
			document.getElementById("year").focus();
		}else if (confirm("是否添加")) {
			document.getElementById("add").submit();
		}
	}
</script>
	</head>
	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业数据采集
			<b class="tip"></b>添加教学质量工程信息
		</div>
		<form action="teachproject_modifi.action" id="add" method="post">
			<table class="table table-bordered table-condensed list">
				<caption class="t_caption">
					添加教学质量工程信息
				</caption>
				<thead>
					<tr>
						<td colspan="99">
							添加教学质量工程信息
							<i class="tip-up"></i>
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 60px;">
							质量工程编号：
							<font color="FF0000">*</font>
						</td>
						<td>
							<input name="teachproject.tprojectNo" id="tprojectNo" type="text"  onblur="tpblur()"/>
							<span id="tprojectNoError"></span>
						</td>
						<td style="width: 60px;">
							质量工程名称:
							<font color="FF0000">*</font>
						</td>
						<td>
							<input name="teachproject.tprojectName" id="tprojectName" type="text" />
							<span id="tprojectNameError" style="color:red"></span>
						</td>
						<td style="width: 60px;">
							质量工程级别:
							<font color="FF0000">*</font>
						</td>
						<td>
							<select name="teachproject.tprojecJibie">

								<option value="国家级">
									国家级
								</option>
								<option value="省级">
									省级
								</option>
								<option value="校级">
									校级
								</option>
								<option value="其他">
									其它
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							质量工程类型:
							<font color="FF0000">*</font>
						</td>
						<td>
							<select name="teachproject.tprojecType">
								<option value="专业综合改革试点">
									专业综合改革试点
								</option>
								<option value="精品资源共享课">
									精品资源共享课
								</option>
								<option value="精品视频公开课">
									精品视频公开课
								</option>
								<option value="教学团队">
									教学团队
								</option>
								<option value="教学名师">
									教学名师
								</option>
								<option value="人才培训模式创新实验区">
									人才培训模式创新实验区
								</option>
								<option value="实验教学示范中心">
									实验教学示范中心
								</option>
								<option value="其它">
									其它
								</option>
							</select>
						</td>
						<td style="width: 60px;">
							获批年份:
							<font color="FF0000">*</font>
						</td>
						<td>
							<input type="text" name="teachproject.year" id="year" onkeypress="return Numbers(event)"/>
							<span style="color:red;">(年份为四位数字)</span>
						</td>
						<td>
							批准文号:
						</td>
						<td>
							<input type="text" id="approvalNumber" name="teachproject.approvalNumber" />
						</td>
					</tr>
					<tr>
						<td>
							备注
						</td>
						<td colspan="5">
							<input type="text" name="teachproject.beizhu"/>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="99">
							<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
							<a href="javascript:modify()" class="btn btn-primary add">保存</a>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</body>
</html>
