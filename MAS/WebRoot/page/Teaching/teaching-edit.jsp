<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
		<!-- 日历控件 -->
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/cal.js">
</script>
		<!-- ISBN唯一性判断 -->
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/Tisbn_uniqueness.js">
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
//确认修改教材信息
function modifiTBooks() {
	if (confirm("是否修改教材信息")) {
		document.getElementById("modifiTBooks").submit();
	}
}
function yearTest() {
	var y = document.getElementById("year").value;
	if (y.length != 4) {
		confirm("年份长度只能为4");
		document.getElementById("year").focus();
	}
}
//添加教材信息
function addTBooks() {
	if (document.getElementById("tbname").value.length == 0) {
		confirm("教材名称选项不能为空");
		document.getElementById("tbname").focus();
	} else if (document.getElementById("publisher").value.length == 0) {
		confirm("出版社选项不能为空");
		document.getElementById("publisher").focus();
	} else if (document.getElementById("year").value.length == 0
			|| document.getElementById("year").value.length != 4) {
		confirm("年份选项不能为空或年份格式不正确");
		document.getElementById("year").focus();
	} else if (document.getElementById("publishTime").value.length == 0) {
		confirm("出版时间选项不能为空");
		document.getElementById("publishTime").focus();
	}
	 else if (confirm("是否添加教材信息")) {
		document.getElementById("addTBooks").submit();
	}

}
function checkNumber(e)
{   var regx = /\d$/;
	var tagValue = document.getElementById(e).value;
	if (tagValue!=null && !tagValue.match(regx)) {
			alert("选项数据应为数字");
			document.getElementById(e).focus();
			return false;
	}else {
	return true;
	}
}
</script>
	</head>

	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业数据采集
			<b class="tip"></b>编辑教材基本信息
		</div>
		<form action="tBooks_modifi.action" id="addTBooks" method="post">
			<table class="table table-bordered table-condensed list">
				<caption class="t_caption">
					教材信息编辑
				</caption>
				<thead>
					<tr>
						<td colspan="99">
							教材信息编辑
							<i class="tip-up"></i>
						</td>
					</tr>
				</thead>
				<tbody id="mytable" class="tby">
					<tr>
						<td style="width: 60px;">
							教材名称：
							<font color="FF0000">*</font>
						</td>
						<td>
							<input name="teachBooks.tbname" id="tbname"
								value='<s:property value="teachBooks.tbname" />' type="text" />
						</td>
						<td style="width: 60px;">
							ISBN:
						</td>
						<td>
							<input name="teachBooks.isbn" id="isbn"
								value='<s:property value="teachBooks.isbn" />' type="text" />
							<span id="is">（填写正确规范的10位或13位数字）</span>
						</td>
						<td style="width: 60px;">
							出版社:
							<font color="FF0000">*</font>
						</td>
						<td>
							<input name="teachBooks.publisher" id="publisher"
								value='<s:property value="teachBooks.publisher" />' type="text" />
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							年份：
							<font color="FF0000">*</font>
						</td>
						<td>
							<input name="teachBooks.year" id="year" type="text"
								value='<s:property value="teachBooks.year" />'
								onblur="yearTest();" onkeypress="return Numbers(event)" />
						</td>


						<td style="width: 60px;">
							出版时间:
							<font color="FF0000">*</font>
						</td>
						<td>
							<input name="teachBooks.publishTime" id="publishTime" type="text"
								value='<fmt:formatDate pattern="yyyy-MM-dd" value="${teachBooks.publishTime}"/>'
								onclick="fPopCalendar(event,this,this)" onfocus="this.select()" />
						</td>
						<td style="width: 60px;">
							出版类型:
							<font color="FF0000">*</font>
						</td>
						<td>
							<select name="teachBooks.publishType" id="publishType">
								<option value="">
									请选择
								</option>
								<option value="国家级规划"
									<s:if test=' "国家级规划"== teachBooks.publishType'>selected="selected"</s:if>>
									国家级规划
								</option>
								<option value="行业规划"
									<s:if test=' "行业规划"== teachBooks.publishType'>selected="selected"</s:if>>
									行业规划
								</option>
								<option value="公开出版"
									<s:if test=' "公开出版"== teachBooks.publishType'>selected="selected"</s:if>>
									公开出版
								</option>
								<option value="其它"
									<s:if test=' "其它"== teachBooks.publishType'>selected="selected"</s:if>>
									其它
								</option>
							</select>
						</td>

					</tr>
					<tr>
						<td style="width: 60px;">
							级别:
						</td>
						<td>
							<select name="teachBooks.tbookJibie" id="tbookJibie">
								<option value="">
									请选择
								</option>
								<option value="一级"
									<s:if test=' "一级"== teachBooks.tbookJibie'>selected="selected"</s:if>>
									一级
								</option>
								<option value="二级"
									<s:if test=' "二级"== teachBooks.tbookJibie'>selected="selected"</s:if>>
									二级
								</option>
								<option value="三级"
									<s:if test=' "三级"== teachBooks.tbookJibie'>selected="selected"</s:if>>
									三级
								</option>
								<option value="四级"
									<s:if test=' "四级"== teachBooks.tbookJibie'>selected="selected"</s:if>>
									四级
								</option>
								<option value="其他"
									<s:if test=' "其它"== teachBooks.tbookJibie'>selected="selected"</s:if>>
									其它
								</option>
							</select>
						</td>
						<td>
							优秀教材级别
						</td>
						<td>
							<select name="teachBooks.tbookClass" id="tbookClass">
								<option value="">
									请选择
								</option>
								<option value="国家级"
									<s:if test=' "国家级"== teachBooks.tbookClass'>selected="selected"</s:if>>
									国家级
								</option>
								<option value="省级"
									<s:if test=' "省级"== teachBooks.tbookClass'>selected="selected"</s:if>>
									省级
								</option>
								<option value="校级"
									<s:if test=' "校级"== teachBooks.tbookClass'>selected="selected"</s:if>>
									校级
								</option>
								<option value="其它"
									<s:if test=' "其它"== teachBooks.tbookClass'>selected="selected"</s:if>>
									其它
								</option>
							</select>
						</td>
						<td>
							优秀教材奖项级别
						</td>
						<td>
							<select name="teachBooks.tbookRewardClass" id="tbookRewardClass">
								<option value="">
									请选择
								</option>
								<option value="一等奖"
									<s:if test=' "一等奖"== teachBooks.tbookRewardClass'>selected="selected"</s:if>>
									一等奖
								</option>
								<option value="二等奖"
									<s:if test=' "二等奖"== teachBooks.tbookRewardClass'>selected="selected"</s:if>>
									二等奖
								</option>
								<option value="三等奖"
									<s:if test=' "三等奖"==teachBooks.tbookRewardClass'>selected="selected"</s:if>>
									三等奖
								</option>
								<option valu="优秀奖"
									<s:if test=' "优秀奖"== teachBooks.tbookRewardClass'>selected="selected"</s:if>>
									优秀奖
								</option>
								<option valu="其它"
									<s:if test=' "其它"== teachBooks.tbookRewardClass'>selected="selected"</s:if>>
									其它
								</option>

							</select>
						</td>
					</tr>
					<tr>
						<td>
							完成单位排名:

						</td>
						<td>
							<input type="text" name="teachBooks.fininshDepartRate"
								value='<s:property value="teachBooks.fininshDepartRate"/>'
								id="fininshDepartRate" />
						</td>

						<td>
							字数

						</td>
						<td>
							<input type="text" name="teachBooks.bookWords"
								value='<s:property value="teachBooks.bookWords" />'
								id="bookWords" onkeypress="return Numbers(event)"
								onblur="return checkNumber('bookWords')"/>
						</td>
						<td>
							使用情况

						</td>
						<td>
							<input type="text" name="teachBooks.useState"
								value='<s:property value="teachBooks.useState" />' id="useState" />
						</td>
					</tr>
					<tr>
						<td>
							备注

						</td>
						<td colspan="6">
							<input type="text" name="teachBooks.beizhu" id="beizhu"
								value='<s:property value="teachBooks.beizhu"/>' />
						</td>


						<!--<td>
							标签
						</td>
						<td colspan="3">
							<input type="text" name="teachBooks.tag" id="tag" value='<s:property value="teachBooks.tag" />'/>
						</td>
					-->
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="99">
							<!--<a href="javascript:addTBooks()" class="btn btn-mini btn-primary">添加</a>
							-->
							<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>
							<a href="javascript:addTBooks()" class="btn btn-primary add">保存</a>&nbsp;&nbsp;
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</body>
</html>
