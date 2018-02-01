<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>学生发表论文</title>

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
			src="${pageContext.request.contextPath}/Scripts/ajax/Student_uniqueness.js">
</script>
		<script type="text/javascript">
//日历插件
$(function() {
	$(".datepicker").datepicker();

	$('#name').tooltip( {
		title : '姓名'
	});
	$('#sex').tooltip( {
		title : '性别'
	});
	$('#birth').tooltip( {
		title : '出生日期'
	});
	$('#phone').tooltip( {
		title : '电话号码'
	});
	$('#email').tooltip( {
		title : '电子邮件'
	});
	$('#class').tooltip( {
		title : '所在班级'
	});
	$('#academy').tooltip( {
		title : '所在学院'
	});
	$('#major').tooltip( {
		title : '所在专业'
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
numcheck = /\d/;
return numcheck.test(keychar)
}

function modifyEdit() {
	if (document.getElementById("stuNumber").value.length ==0){
	        alert("学号选项不能为空");
			document.getElementById("stuNumber").focus();
	}
    else if(document.getElementById("comName").value.length==0){
        alert("论文名称选项不能为空!");
        document.getElementById("comName").focus();
    }
	else if(document.getElementById("year").value.length==0){
        alert("发表年份选项不能为空!");
        document.getElementById("year").focus();
    }
    else if(document.getElementById("year").value.length!=4){
        alert("发表年份选项只能为4位数字!");
        document.getElementById("year").focus();
    }
   else if(document.getElementById("journal").value.length==0){
        alert("发表期刊选项不能为空!");
        document.getElementById("journal").focus();
    }
    else if(document.getElementById("journalType").value.length==0){
        alert("期刊类型年份选项不能为空!");
        document.getElementById("journalType").focus();
    }
    else if (confirm("是否保存")) {
			document.getElementById("edit").submit();
		}





}

$(document).ready(function() {
	if (thesisNumber == 0) {
	} else {
		stublur();
	}
});
</script>
	</head>

	<body style="background-color:#e4dfd9"  onload="init();">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>查询学生发表论文信息
			<b class="tip"></b>编辑学生发表论文信息
		</div>

		<form action="editStuthesis.action" id="edit" method="post">


			<table class="table table-striped table-bordered table-condensed">
				<caption class="t_caption">
					学生发表论文信息编辑
				</caption>
				<thead>
					<tr>
						<td colspan="99">
							学生发表论文编辑
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td style="width: 60px;">
							学号
							<font color="red">*</font>
						</td>
						<td>

							<input type="text" name="stuthesis.student.stuNumber"
								value='<s:property value="stuthesis.student.stuNumber" />'
								id="stuNumber" onblur="stuTblur();" />
							<span id="stuNumberError"></span>
						</td>
						<td style="width: 60px;">
							姓名
						</td>
						<td>
							<input type="text" name="stuthesis.student.stuName" id="stuName"  readonly="readonly"
							value='<s:property value="stuthesis.student.stuName"/>' />
						</td>
						<td>
							论文名称
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="stuthesis.comName" id="comName"
								value='<s:property value="stuthesis.comName" />' />
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							发表年份
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="stuthesis.year" id="year"  onkeypress="return Numbers(event)"  maxlength="4"
								value='<s:property value="stuthesis.year" />' />
						</td>
						<td style="width: 60px;">
							期刊名称
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="stuthesis.journal" id="journal"
								value='<s:property value="stuthesis.journal" />' />
						</td>
						<td style="width: 60px;">
							期刊类型
							<font color="red">*</font>
						</td>
						<td>
							<select name="stuthesis.journalType" id="journalType">
								<option value="SCI"
									<s:if test="'SCI'==stuthesis.journalType">selected="selected"</s:if>>
								SCI
								</option>
								<option value="EI"
									<s:if test="'EI'==stuthesis.journalType">selected="selected"</s:if>>
									EI
								</option>
								<option value="核心期刊"
									<s:if test="'核心期刊'==stuthesis.journalType">selected="selected"</s:if>>
									核心期刊
								</option>
								<option value="其它"
									<s:if test="'其它'==stuthesis.journalType">selected="selected"</s:if>>
									其它
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							备注
						</td>
						<td colspan="5">
							<input type="text" name="stuthesis.note"
								value='<s:property value="stuthesis.note" />' />
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="99">
							<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
							<a class="btn btn-primary add" href="javascript:modifyEdit()">保存</a>&nbsp;&nbsp;

						</td>

					</tr>
				</tfoot>
			</table>
		</form>
	</body>
</html>
