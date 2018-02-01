<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>编辑实验实训场地使用情况</title>

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
			src="${pageContext.request.contextPath}/Scripts/ajax/add.js">
</script>
<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/MajorByDno.js">
</script>
		<!--<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/TnameByTno.js">
</script>
	--></head>

	<script type="text/javascript"><!--
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
function modifyEdit() {

     var y=document.getElementById("year").value;
	 var reg = new RegExp("^[0-9]*$");
     var obj = document.getElementById("year");

   if (document.getElementById("traName").value.length ==0){
	        alert("实验室名称选项不能为空");
			document.getElementById("traName").focus();
	}
    else if (document.getElementById("major").value.length ==0){
	        alert("专业选项不能为空");
			document.getElementById("major").focus();
	}
    else if (document.getElementById("courseCount").value.length ==0){
	        alert("课程数选项不能为空");
			document.getElementById("courseCount").focus();
	} else if (document.getElementById("thHcount").value.length ==0){
	        alert("实验实训教学人时数选项不能为空");
			document.getElementById("thHcount").focus();
	} else if (document.getElementById("thPcount").value.length ==0){
	        alert("实验实训教学人次数不能为空");
			document.getElementById("thPcount").focus();
	}else if(!reg.test(obj.value)){
        alert("年份选项只能输入4位数字!");
    }
     else if(y.length!=4){
        alert("年份选项只能输入4位数字!");
    }
    else if (confirm("是否保存")) {
			document.getElementById("editTeat").submit();
		}
}

--></script>
	<body style="background-color:#e4dfd9"  onload="init();">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>查询实验实训场地使用情况
			<b class="tip"></b>编辑实验实训场地使用情况
		</div>

		<form action="editTrainingvenueuse.action" id="editTeat" method="post">


			<table class="table table-striped table-bordered table-condensed">
				<caption class="h_caption">
					实验实训场地使用情况编辑
				</caption>
				<thead>
					<tr>
						<td colspan="99">
							实验实训场地使用情况编辑
							<i class="tip-up"></i>
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
				<tr>
					<td>
						实验室名称：
						<font color="red">*</font>
					</td>
					<td>
						<s:if test='trainingvenueuse==null'>
							<select size="1" id="traName" name="trainingvenueuse.trainingvenue.traNumer">
								<option value="">
									--请选择--
								</option>
								<s:iterator value="trainingvenueList" var="traNumervar">

									<option value="<s:property value='traNumer'/>"
										<s:if test="#traNumervar.traNumer == trainingvenueuse.trainingvenue.traNumer">selected="selected"</s:if>>
										<s:property value="traName" />
									</option>
								</s:iterator>
							</select>
						</s:if>
						<s:else>
							<input name="trainingvenueuse.trainingvenue.traName" readonly="readonly" id="traName"
								value='<s:property value="trainingvenueuse.trainingvenue.traName"/>' type="text"
								 />
						</s:else>
					</td>
					<td>
						所在学院：
						<font color="red">*</font>
					</td>
					<td>
						<select name="trainingvenueuse.major.department.dno" id="coll"
							onchange="collchange();">
							<option value="">
								全部学院
							</option>
							<s:iterator value="departmentList" var="departmentvar">
								<option value="<s:property value="dno"/>"
									<s:if test="#departmentvar.dno == trainingvenueuse.major.department.dno">selected="selected"</s:if>>
									<s:property value="dname" />
								</option>
							</s:iterator>
						</select>
					</td>
					<td>
						所在专业：
						<font color="red">*</font>
					</td>
					<td>
						<select size="1" name="trainingvenueuse.major.mno" id="major">
							<option value="">
								全部专业
							</option>
							<s:iterator value="majorList" var="majorvar">
								<option value="<s:property value='mno'/>"
									<s:if test="#majorvar.mno == trainingvenueuse.major.mno">selected="selected"</s:if>>
									<s:property value="mname" />
								</option>
							</s:iterator>
						</select>
					</td>
					</tr>
					<tr>
					<td>
						课程数
						<font color="red">*</font>
					</td>
					<td>
						<input name="trainingvenueuse.courseCount"
							onkeypress="return Numbers(event)"
							value='<s:property value="trainingvenueuse.courseCount"/>' type="text"
							id="courseCount" />
					</td>
					<td style="width: 12%;">
						专业实验教学人次数
						<font color="red">*</font>
					</td>
					<td>
						<input name="trainingvenueuse.thPcount"
							onkeypress="return Numbers(event)"
							value='<s:property value="trainingvenueuse.thPcount"/>' type="text"
							id="thPcount" />
					</td>
					<td style="width: 12%;">
						专业实验教学人时数：
						<font color="red">*</font>
					</td>
					<td>
						<input type="text" name="trainingvenueuse.thHcount" id="thHcount"
							value='<s:property value="trainingvenueuse.thHcount"/>'/>
					</td>
					</tr>
					<tr>
					<td style="width: 12%;">
						使用年份
						<font color="red">*</font>
					</td>
					<td colspan="6">
						<input name="trainingvenueuse.year" onkeypress="return Numbers(event)"
							value='<s:property value="trainingvenueuse.year"/>' type="text" id="year" />
					</td>
				</tr>
			</tbody>
				<tfoot>
					<tr>
						<td colspan="99">
							<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
							<a class="btn btn-primary add" id="save"
								href="javascript:modifyEdit()">保存</a>&nbsp;&nbsp;
							<span id="patentNumberError"></span>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</body>
</html>
