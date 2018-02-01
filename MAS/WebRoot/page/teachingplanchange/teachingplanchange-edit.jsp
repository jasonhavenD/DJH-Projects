<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>教学计划变更</title>

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
		<!-- 学院级联专业-->
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/MajorByDno.js">
</script>
		<!-- 日历控件 -->
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/cal.js">
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

function modifyEdit() {

	   if (document.getElementById("cname").value.length == 0) {
			alert("变更课程名称选项不能为空");
			document.getElementById("cname").focus();
		} else if (document.getElementById("grade").value.length == 0) {
			alert("年级不能为空");
			document.getElementById("grade").focus();
		} else if (document.getElementById("adjustNature").value.length == 0) {
			alert("调整性质选项不能为空");
			document.getElementById("adjustNature").focus();
		} else if (document.getElementById("coll").value.length == 0) {
			alert("开课学院选项不能为空");
			document.getElementById("coll").focus();
		} else if (document.getElementById("changeMode").value.length == 0) {
			alert("变更日期选项不能为空");
			document.getElementById("changeMode").focus();
		} else if (document.getElementById("year").value.length == 0
				|| document.getElementById("year").value.length != 4) {
			alert("年份选项不能为空或年份格式不正确");
			document.getElementById("year").focus();
		}else if (confirm("是否保存")) {
			document.getElementById("edit").submit();
		}
}
function yearTest(){
	var y=document.getElementById("year").value;
	if(y.length!=4){
		confirm("年份长度只能为4");
		document.getElementById("year").focus();
	}
}

</script>
	</head>

	<body style="background-color:#e4dfd9" onload="init()">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>教学计划变更查询
			<b class="tip"></b>编辑教学计划变更信息
		</div>
		<form action="editTplan.action" id="edit" method="post">
			<table class="table table-bordered table-condensed">
				<caption class="t_caption">
					教学计划变更详细信息
				</caption>
				<thead>
					<tr>
						<td colspan="99">
							教学计划变更详细信息
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td>
							课程名称
							<font color="red">*</font>
						</td>
						<td>
							<select size="1" id="cname" name="tplan.course.cno">
								<option value="">
									--选择--
								</option>
								<s:iterator value="courseList" var="cnamevar">
									<option value="<s:property value='cno'/>"
										<s:if test="#cnamevar.cname == tplan.course.cname">selected="selected"</s:if>>
										<s:property value="cname" />
									</option>
								</s:iterator>
							</select>
							<span id="cnameError"></span>
						</td>
						<td style="width: 12%;">
							年级
							<font color="red">*</font>
						</td>
						<td>
							<input name="tplan.grade" id="grade"
								value='<s:property value="tplan.grade"/>' type="text" id="grade"/>
						</td>
						<td>
							调整性质
							<font color="red">*</font>
						</td>
						<td>
							<select name="tplan.adjustNature" id="adjustNature">
								<option value="0"
									<s:if test=" 0 == tplan.adjustNature">selected="selected"</s:if>>
									优化方案
								</option>
								<option value="1"
									<s:if test="1 == tplan.adjustNature">selected="selected"</s:if>>
									其他
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							所在学院
						</td>
						<td>
							<select name="tplan.major.department.dno" id="coll"
								onchange="collchange();">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList" var="departmentvar">
									<option value="<s:property value="dno"/>"
										<s:if test="#departmentvar.dno == tplan.major.department.dno">selected="selected"</s:if>>
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							所在专业
							<font color="red">*</font>
						</td>
						<td>
							<select size="1" name="tplan.major.mno" id="major">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList" var="majorvar">
									<option value="<s:property value='mno'/>"
										<s:if test="#majorvar.mno == tplan.major.mno">selected="selected"</s:if>>
										<s:property value="mname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width: 12%;">
							变动类型
							<font color="red">*</font>
						</td>
						<td style="width: 12%;">
							<select size="1" id="changeType" name="tplan.changeType">
								<option value="增加课程"
									<s:if test=" '增加课程'== tplan.changeType">selected="selected"</s:if>>
									增加课程
								</option>
								<option value="取消课程"
									<s:if test="'取消课程' == tplan.changeType">selected="selected"</s:if>>
									取消课程
								</option>
								<option value="学分调整"
									<s:if test="'学分调整' == tplan.changeType">selected="selected"</s:if>>
									学分调整
								</option>
								<option value="课程性质变更"
									<s:if test="'课程性质变更' == tplan.changeType">selected="selected"</s:if>>
									课程性质变更
								</option>
								<option value="开课学期调整"
									<s:if test="'开课学期调整' == tplan.changeType">selected="selected"</s:if>>
									开课学期调整
								</option>
								<option value="其他"
									<s:if test="'其他' == tplan.changeType">selected="selected"</s:if>>
									其他
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td style="width: 12%;">
							变更方式
							<font color="red">*</font>
						</td>
						<td>
							<select size="1" id="changeMode" name="tplan.changeMode">
							
								<option value="临时变更"
									<s:if test="'临时变更' == tplan.changeMode">selected="selected"</s:if>>
									临时变更
								</option>
								<option value="永久变更"
									<s:if test="'永久变更' == tplan.changeMode">selected="selected"</s:if>>
									永久变更
								</option>
							</select>
						</td>
						<td style="width: 12%;">
							变更日期
							<font color="red">*</font>
						</td>
						<td>
							<input name="tplan.changeDate" id="changeDate"
								value='<fmt:formatDate pattern="yyyy-MM-dd" value="${tplan.changeDate}"/>'
								type="text" onclick="fPopCalendar(event,this,this)"
								onfocus="this.select()" />
						</td>
						<td style="width: 12%;">
							年份
							<font color="red">*</font>
						</td>
						<td>
							<input name="tplan.year" value='<s:property value="tplan.year"/>' id="year"
								type="text" />
						</td>
					</tr>

					<tr>
						<td>
							变更原因
							
						</td>
						<td colspan="5">
							<textarea name="tplan.changeReason" id="changeReason"
								style="margin: 0; width: 99%; word-break: break-all; border-style: none; border: 0; background-color: transparent; overflow: hidden; resize: none;">
								<s:property value="tplan.changeReason" />
							</textarea>

						</td>
					</tr>
					<tr>
						<td>
							课程性质
							
						</td>
						<td colspan="5">
							<textarea name="tplan.courseNature" id="courseNature"
								style="margin: 0; width: 99%; word-break: break-all; border-style: none; border: 0; background-color: transparent; overflow: hidden; resize: none;">
								<s:property value="tplan.courseNature" />
							</textarea>

						</td>
					</tr>
					<tr>
						<td>
							变更内容
							
						</td>
						<td colspan="5">
							<textarea name="tplan.changeContext" id="changeContext"
								style="margin: 0; width: 99%; height: 80px; word-break: break-all; border-style: none; border: 0; background-color: transparent; overflow: auto; resize: none;">
								<s:property value="tplan.changeContext" />
							</textarea>

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
