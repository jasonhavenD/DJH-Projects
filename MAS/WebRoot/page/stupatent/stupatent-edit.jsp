<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>编辑学生获得专利信息</title>

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
			src="${pageContext.request.contextPath}/Scripts/tip.js">
</script>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/cal.js">
</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/patentNumber_uniqueness.js">
</script>

		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/stunumber.js">
</script>

	<script type="text/javascript">
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
numcheck = /\d/;
return numcheck.test(keychar)
}

function modifyEditStupatent() {

	if (document.getElementById("pateName").value.length ==0){
	        alert("专利名称选项不能为空");
			document.getElementById("pateName").focus();
	}
	else if(document.getElementById("pateType").value.length==0){
        alert("专利类别选项不能为空!");
        document.getElementById("pateType").focus();
    }
    else if(document.getElementById("certiNumber").value.length==0){
        alert("专利编号选项不能为空!");
        document.getElementById("certiNumber").focus();
    }
    else if(document.getElementById("stuName").value.length==0){
        alert("申请人学号选项不能为空!");
        document.getElementById("stuName").focus();
    }
	else if(document.getElementById("year").value.length==0){
        alert("获得年份选项不能为空!");
        document.getElementById("year").focus();
    }
    else if(document.getElementById("year").value.length!=4){
        alert("获得年份年份选项只能为4位数字!");
        document.getElementById("year").focus();
    }
    else if (confirm("是否保存")) {
			document.getElementById("editStupatent").submit();
		}


}

$(document).ready(function() {
	if (pnumber != 0) {
		stublurs();
	}

});
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
</script>

	</head>

	<body style="background-color:#e4dfd9"  onload="init();">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>查询获得专利信息
			<b class="tip"></b>编辑学生获得专利信息
		</div>

		<form action="editStupatent.action" id="editStupatent" method="post">


			<table class="table table-striped table-bordered table-condensed">
				<caption class="t_caption">
					学生获得专利信息编辑
				</caption>
				<thead>
					<tr>
						<td colspan="99">
							学生获得专利信息编辑
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>

						<!--<td>
							存储编号：
							<font color="red">*</font>
						</td>
						<td width="27%">
							<s:if test="stupatent==null">
								<input type="text" name="stupatent.patentNumber"
									onblur="stublur();" id="patentNumber"
									value='<s:property value="stupatent.patentNumber" />' />
							</s:if>
							<s:else>
							<input type="text" name="stupatent.patentNumber"
									 id="patentNumber" readonly="readonly"
									value='<s:property value="stupatent.patentNumber" />' />

							</s:else>
							<span id="patentNumberError"></span>
						</td>
						--><td style="width: 60px;">
							专利名称:
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="stupatent.pateName" id="pateName"
								value='<s:property value="stupatent.pateName" />' />
						</td>
						<td style="width: 60px;">
							专利类别：
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="stupatent.pateType" id="pateType"
								value='<s:property value="stupatent.pateType" />' />
						</td>
						<td style="width: 60px;">
							专利编号：
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="stupatent.patentNumber" id="patentNumber"
								value='<s:property value="stupatent.patentNumber" />' />
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							申请人学号:
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="stupatent.student.stuNumber"
								id="stuNumber" onblur="stublurs();"
								value='<s:property value="stupatent.student.stuNumber" />' />

						</td>
						<td style="width: 60px;">
							申请人姓名：
							<font color="red">*</font>
						</td>
						<td>
							<input readonly="readonly" type="text" id="stuName"  value='<s:property value="stupatent.student.stuName" />'/>

						</td>
						<td style="width: 60px;">
							获得年份
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="stupatent.year" id="year"  maxlength="4" onkeypress="return Numbers(event)"
								value='<s:property value="stupatent.year" />' />
							<span id="yearspan"></span>
						</td>


					</tr>
					<tr>
						<td style="width: 60px;">
							获奖证书编号
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="stupatent.certiNumber" id="certiNumber"
								value='<s:property value="stupatent.certiNumber" />' />
						</td>
						<td>
							授权日期
						</td>
						<td>
							<input type="text" id="date" name="stupatent.authorityDate"
							 value='<fmt:formatDate pattern="yyyy-MM-dd" value="${stupatent.authorityDate}"/>'
								onclick="fPopCalendar(event,this,this);"
								onfocus="this.select();" />
							<span id="birspan"></span>
						</td>
						<td>
							备注
						</td>
						<td>
							<input type="text" name="stupatent.note"
								value='<s:property value="stupatent.note" />' />
						</td>
					</tr>

				</tbody>
				<tfoot>
					<tr>
						<td colspan="99">
							<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
							<a class="btn btn-primary add" id="save"
								href="javascript:modifyEditStupatent()">保存</a>&nbsp;&nbsp;

						</td>



					</tr>
				</tfoot>
			</table>
		</form>
	</body>
</html>
