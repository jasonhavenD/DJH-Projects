<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>编辑主持教改项目信息</title>

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
			src="${pageContext.request.contextPath}/Scripts/tip.js">
</script>
		<!-- 日历控件 -->
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/cal.js">
</script>
		<!--<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/TnameByTno.js">
</script>

		-->
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/PreRevolut_uniqueness.js">
</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/add.js"></script>
		<script type="text/javascript">
//日历插件
$(function() {
	$(".datepicker").datepicker();
})

function checkNumber(tagName, tagErrorName) {
	var regx = /\d/;
	var tagValue = document.getElementById(tagName).value;

	if (!tagValue.match(regx)) {
		document.getElementById(tagErrorName).innerHTML = "格式错误";
		document.getElementById(tagErrorName).style.color = "red";
		return false;
	} else {
		document.getElementById(tagErrorName).innerHTML = "格式正确";
		document.getElementById(tagErrorName).style.color = "green";
		return true;
	}
}
function modifyEdit() {
	var regx = /\d/;
	var rprojecTime=new Date(document.getElementById("rprojecTime").value).getTime();
     var racceptenceDate=new Date(document.getElementById("racceptenceDate").value).getTime();
	if (document.getElementById("rprojectNo").value.length ==0) {
		alert("项目编号不可为空");
		document.getElementById("rprojectNo").focus();
		document.getElementById("rprojectNoError").innerHTML = "项目编号不可为空";
		document.getElementById("rprojectNoError").style.color="red";
	}/*else if (document.getElementById("rprojectNoError").innerHTML == "项目编号已存在") {
		alert("项目编号已存在");
		document.getElementById("rprojectNo").focus();
		document.getElementById("rprojectNoError").innerHTML = "项目编号已存在";
	}*/else if (document.getElementById("rprojectName").value.length==0) {
		alert("项目名称不能为空");
		document.getElementById("rprojectName").focus();
		document.getElementById("rprojectNameError").innerHTML = "项目名称不能为空";
	}else if (document.getElementById("year").value.length==0) {
	document.getElementById("year").focus();
		document.getElementById("yearError").value = "立项年份不能为空";
	}else if (!document.getElementById("year").value.match(regx)||document.getElementById("year").value.length != 4) {
		alert("立项年份格式不正确");
		document.getElementById("year").focus();
		document.getElementById("yearError").value = "立项年份格式不正确";
	}else if (document.getElementById("names").value.length==0) {
		alert("主持教师编号不能为空");
		document.getElementById("names").focus();
	}/*else if (document.getElementById("tnoError").innerHTML=="教师信息不存在") {
		alert("教师信息不存在");
		document.getElementById("tno").focus();
		document.getElementById("tnoError").innerHTML = "教师信息不存在";
	}*/else if(document.getElementById("rprojecTime").value.length==0){
		alert("立项时间不能为空");
		document.getElementById("rprojecTime").focus();
		document.getElementById("rprojecTimeError").innerHTML = "立项时间不能为空";
	}else if(document.getElementById("racceptenceDate").value.length==0){
		alert("验收时间不能为空");
		document.getElementById("racceptenceDate").focus();
		document.getElementById("racceptenceDateError").innerHTML = "验收时间不能为空";
	}
	else if(rprojecTime>racceptenceDate){
	      alert("验收时间不能早于立项时间");
			document.getElementById("racceptenceDate").focus();
	}
	else if (confirm("是否保存")) {
		document.getElementById("editPrer").submit();
	}
}

</script>
	</head>
	<body style="background-color:#e4dfd9"  onload="init();">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>查询主持教改项目信息
			<b class="tip"></b>编辑主持教改项目信息
		</div>

		<form action="editPrer.action" id="editPrer" method="post">


			<table class="table table-striped table-bordered table-condensed">
				<caption class="h_caption">
					主持教改项目信息编辑
				</caption>
				<tbody id="mytable">
					<tr>
						<td style="width: 60px;">
							项目编号
							<font color="red">*</font>
						</td>
						<td>
							<s:if test='prer==null'>
								<input type="text" name="prer.rprojectNo" onblur="stublur()"
									id="rprojectNo" />
								<span id="rprojectNoError" style="color: red"></span>
							</s:if>
							<s:else>
								<input type="text" name="prer.rprojectNo"
									value='<s:property value="prer.rprojectNo"/>' id="rprojectNo"
									readonly="readonly" />
							</s:else>

						</td>
						<td style="width: 60px;">
							项目名称
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="prer.rprojectName" id="rprojectName"
								value='<s:property value="prer.rprojectName"/>' />
							<span id="rprojectNameError" style="color: red"></span>
						</td>
						<td style="width: 60px;">
							立项年份
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" id="year" name="prer.year"
								value='<s:property value="prer.year"/>' />
							<span id="yearError" style="color: red">（年份为四位数字）</span>
						</td>
					</tr>
					<tr>
						<!--<td style="width: 60px;">
							教师编号
							<font color="red">*</font>
						</td>
						<td>
							<s:if test='prer==null'>
								<input type="text" name="prer.teacher.tno" id="tno"
									onblur="tnochange()" />
								<span id="tnoError"></span>
							</s:if>
							<s:else>
								<input type="text" name="prer.teacher.tno" id="tno"
									value='<s:property value="prer.teacher.tno" />'
									readonly="readonly" />
							</s:else>

						</td>
						<td style="width: 60px;">
							教师姓名
						</td>
						<td>
							<input type="text" name="teacher" id="teacherName"
								value='<s:property value="prer.teacher.tname"/>'
								readonly="readonly" />
						</td>
						-->
						<td style="width: 60px;">
							教师工号/姓名
							<font color="FF0000">*</font>
						</td>
						<td>
							<div id="abc" style="display: inline; float: left;">
								<input type="text" name="prer.teacher.tno"
									style="background: transparent;" placeholder="输入教工号或姓名搜索"
									autocomplete="off" id="names" onkeyup="findNames('${userId}')"
									onfocus="findNames('${userId}')"
									value='<s:property value="prer.teacher.tno" />' />
								<!-- 自动搜索，用于显示搜索结果 -->
								<div id="popup"
									style="border: 1px solid #c7c7c7; border-top: none; z-index: 1; position: absolute; overflow: auto;">
									<table class="autoSeek" id="complete_table">
										<tbody id="complete_body"></tbody>
									</table>
								</div>
							</div>
						</td>
						<td style="width: 60px;">
							参与教师人数
						</td>
						<td>
							<input type="text" name="prer.rpartTeacherNum"
								id="rpartTeacherNum"
								onblur="return checkNumber('rpartTeacherNum','rpartTeacherNumError')"
								value='<s:property value="prer.rpartTeacherNum"/>' />
							<span id="rpartTeacherNumError"></span>
						</td>
						<td style="width: 60px;">
							经费
						</td>
						<td>
							<input type="text" name="prer.rcost" id="rcost"
								onblur="return checkNumber('rcost','rcostError')"
								value='<s:property value="prer.rcost" />' />
							<span style="color: red" id="rcostError">(单位：万元)</span>
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							项目类型
							<font color="red">*</font>
						</td>
						<td>
							<select id="prot" name="prer.rprojecType">
								<option value="一般项目"
								 <s:if test='"一般项目"==prer.rprojecType'>selected="selected"</s:if>>
									一般项目
								</option>
								<option value="重点攻关项目"
									<s:if test='"重点攻关项目"==prer.rprojecType'>selected="selected"</s:if>>
									重点攻关项目
								</option>
								<option value="重点项目"
									<s:if test='"重点项目"==prer.rprojecType'>selected="selected"</s:if>>
									重点项目
								</option>
								<option value="培育项目"
									<s:if test='"培育项目"==prer.rprojecType'>selected="selected"</s:if>>
									培育项目
								</option>
								<option value="专项项目"
									<s:if test='"专项项目"==prer.rprojecType'>selected="selected"</s:if>>
									专项项目
								</option>
								<option value="其他"
									<s:if test='"其他"==prer.rprojecType'>selected="selected"</s:if>>
									其他
								</option>
							</select>
						</td>
						<td style="width: 60px;">
							项目级别
							<font color="red">*</font>
						</td>
						<td colspan="3">
							<select id="proj" name="prer.rprojecJibie">

								<option value="校级"
									<s:if test='"校级"==prer.rprojecJibie'>selected="selected"</s:if>>
									校级
								</option>
								<option value="省级"
									<s:if test='"省级"==prer.rprojecJibie'>selected="selected"</s:if>>
									省级
								</option>
								<option value="国家级"
									<s:if test='"国家级"==prer.rprojecJibie'>selected="selected"</s:if>>
									国家级
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							立项时间:
							<font color="red">*</font>
						</td>
						<td>
							<input name="prer.rprojecTime" id="rprojecTime"
								value='<fmt:formatDate pattern="yyyy-MM-dd" value="${prer.rprojecTime}"/>'
								type="text" onclick="fPopCalendar(event,this,this)"
								onfocus="this.select()" />
							<span id="rprojecTimeError" style="color: red"></span>
						</td>

						<td style="width: 60px;">
							验收时间:
							<font color="red">*</font>
						</td>
						<td colspan="3">
							<input name="prer.racceptenceDate" id="racceptenceDate"
								value='<fmt:formatDate pattern="yyyy-MM-dd" value="${prer.racceptenceDate}"/>'
								type="text" onclick=fPopCalendar(event,this, this);onfocus="this.select()" />
							<span id="racceptenceDateError" style="color: red"></span>
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							备注
						</td>
						<td colspan="5">
							<textarea rows="5" cols="99" name="prer.beizhu">${request.prer.beizhu}</textarea>
						</td>
					</tr>

				</tbody>
				<tfoot>
					<tr>
						<td colspan="99">
							<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
							<a class="btn btn-primary add" id="save"
								href="javascript:modifyEdit()">保存</a>&nbsp;&nbsp;
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</body>
</html>
