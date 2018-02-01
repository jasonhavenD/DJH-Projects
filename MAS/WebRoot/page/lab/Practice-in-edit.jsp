<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>综合实践环节课程开出率</title>

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

		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/MajorByDno.js">
</script>

		<script type="text/javascript">
//日历插件
$(function() {
	$(".datepicker").datepicker();
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
//确认修改
function modifyEditFulfillinginstance() {
	if(document.getElementById("coll").value.length==0){
        alert("所在学院选项不能为空!");
        document.getElementById("coll").focus();
    }
    else if(document.getElementById("major").value.length==0){
        alert("所在专业选项不能为空!");
        document.getElementById("major").focus();
    }
    else if(document.getElementById("fulType").value.length==0){
        alert("实践类型选项不能为空!");
        document.getElementById("fulType").focus();
    }
    else if(document.getElementById("rateopen").value.length==0){
        alert("实践项目开出率!");
        document.getElementById("rateopen").focus();
    }
    else if(document.getElementById("ratefinish").value.length==0){
        alert("实践项目完成率!");
        document.getElementById("ratefinish").focus();
    }
    else if(document.getElementById("num1").value.length==0){
        alert("计划开出实践数目!");
        document.getElementById("num1").focus();
    }
    else if(document.getElementById("num2").value.length==0){
        alert("实际开出实践项目数!");
        document.getElementById("num2").focus();
    }
    else if(document.getElementById("fnum").value.length==0){
        alert("实践项目完成数!");
        document.getElementById("fnum").focus();
    }
	else if(document.getElementById("year").value.length==0){
        alert("年份选项不能为空!");
        document.getElementById("year").focus();
    }
    else if(document.getElementById("year").value.length!=4){
        alert("年份选项只能为4位数字!");
        document.getElementById("year").focus();
    }

    else if (confirm("是否保存")) {
			document.getElementById("editFulfillinginstance").submit();
		}



}

function divideopen() {
	var as = document.getElementById("num2").value;
	var bs = document.getElementById("num1").value;

	if (parseInt(as) > parseInt(bs)) {
		alert("实开数应小于应开数");
		document.getElementById("num2").value = "";

	} else {
		document.getElementById("rateopen").value = (parseInt(as) / parseInt(bs))
				.toFixed(2);
	}
}

function dividefinish() {
	var as = document.getElementById("fnum").value;
	var bs = document.getElementById("num2").value;

	if (parseInt(as) > parseInt(bs)) {
		alert("完成数应小于实开数");
		document.getElementById("fnum").value = "";
	} else if (parseInt(bs) == 0) {
		document.getElementById("ratefinish").value = 0;
	} else {

		document.getElementById("ratefinish").value = (parseInt(as) / parseInt(bs))
				.toFixed(2);
	}

}
</script>


	</head>

	<body style="background-color:#e4dfd9"  onload="init();">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>综合实践环节课程开出率
			<b class="tip"></b>修改综合实践环节课程开出率信息
		</div>

		<form action="editFulfillinginstance.action"
			id="editFulfillinginstance" method="post">

			<table class="table table-striped table-bordered table-condensed">
				<caption class="t_caption">
					综合实践环节课程开出率情况
				</caption>
				<thead>
					<tr>
						<td colspan="99">
							综合实践环节课程开出率情况
						</td>
					</tr>
				</thead>
				<tbody>

					<tr>

						<!--<td>
								编号
								<font color="red">*</font>
							</td>

							<td>
								<s:if test="fulfillinginstance==null">
									<input name="fulfillinginstance.fulNumber" id="fulNumber"
										value='<s:property value="fulfillinginstance.fulNumber"/>'
										type="text" />
								</s:if>
								<s:else>
								<input  value='<s:property value="fulfillinginstance.fulNumber" />' readonly="readonly"  id="fulNumber">
								</s:else>
							</td>


							-->
						<td>
							所在学院:
							<font color="red">*</font>
						</td>
						<td>
							<select name="fulfillinginstance.major.department.dno" id="coll"
								onchange="collchange();">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList" var="departmentvar">
									<option value="<s:property value="dno"/>"
										<s:if test="#departmentvar.dno == fulfillinginstance.major.department.dno">selected="selected"</s:if>>
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							所在专业:
							<font color="red">*</font>
						</td>
						<td>
							<select size="1" name="fulfillinginstance.major.mno" id="major">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList" var="major">
									<option value="<s:property value="mno"/>"
										<s:if test="#major.mno == fulfillinginstance.major.mno">selected="selected"</s:if>>
										<s:property value="mname" />
									</option>
								</s:iterator>
							</select>
						</td>

						<td style="width: 60px;">
							实践类型
							<font color="red">*</font>
						</td>
						<td>
							<select name="fulfillinginstance.fulType" id="fulType">
								<option value="实习"
									<s:if test=' "实习"==fulfillinginstance.fulType' >selected="selected"</s:if>>
									实习
								</option>
								<option value="毕业设计（论文）"
									<s:if test=' "毕业设计（论文）"==fulfillinginstance.fulType' >selected="selected"</s:if>>
									毕业设计（论文）
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							计划开出实践数目:
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" id="num1" onkeypress="return Numbers(event)"
								name="fulfillinginstance.stuNumber1"
								value='<s:property value="fulfillinginstance.stuNumber1" />' />
						</td>
						<td style="width: 60px;">
							实际开出实践项目数:
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" id="num2" onblur="divideopen()"
								onkeypress="return Numbers(event)"
								name="fulfillinginstance.stuNumber2"
								value='<s:property value="fulfillinginstance.stuNumber2" />' />
						</td>

						<td>
							实践项目完成数:
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" id="fnum" onblur="dividefinish()"
								onkeypress="return Numbers(event)"
								name="fulfillinginstance.endNumber"
								value='<s:property value="fulfillinginstance.endNumber" />' />
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							实践项目开出率:
							<font color="red">*</font>

						</td>
						<td>
							<input id="rateopen" type="text"
								onkeyup="value=value.replace(/[^\d.]/g,'')"
								name="fulfillinginstance.openRate"
								value='<s:property value="fulfillinginstance.openRate" />'
								readonly="readonly" />
							<span style="color: red">（开出率=实际开出数/计划开出数）</span>
						</td>
						<td style="width: 60px;">
							实践项目完成率:
							<font color="red">*</font>
						</td>
						<td colspan="3">
							<input id="ratefinish" type="text"
								onkeyup="value=value.replace(/[^\d.]/g,'')"
								name="fulfillinginstance.finishRate"
								value='<s:property value="fulfillinginstance.finishRate" />'
								readonly="readonly" />

							<span style="color: red">（完成率=完成数/开出数）</span>
						</td>
					</tr>
					<tr>
						<td>
							年份
							<font color="red">*</font>
						</td>
						<td>
							<input name="fulfillinginstance.year" id="year" maxlength="4"
								onkeypress="return Numbers(event)"
								value='<s:property value="fulfillinginstance.year"/>'
								type="text" />


						</td>


						<td>
							备注

						</td>
						<td colspan="3">
							<input type="text" name="fulfillinginstance.note"
								value='<s:property value="fulfillinginstance.note" />' />
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="99">

							<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
							<a href="javascript:modifyEditFulfillinginstance()"
								class="btn btn-primary add">保存</a>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</body>
</html>
