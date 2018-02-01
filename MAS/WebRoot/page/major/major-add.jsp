<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>专业详情</title>

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
			src="${pageContext.request.contextPath}/Scripts/ajax/mno_uniqueness.js">
		</script>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/add.js">
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
numcheck = /\d/
return numcheck.test(keychar)
}
function modifyEditMajor() {

	if(document.getElementById("mnoError").innerHTML=="该专业代码可用"){
		if(checkNull('major.mname','mnameError')){
			if (confirm("是否修改")) {
				document.getElementById("addMajor").submit();
			}
		}
		else{
			document.getElementById("mnameError").innerHTML=="该选项不能为空";
			document.getElementById("mnameError").style.color=="red";
			alert("请完善专业信息");
		}
	}else{alert("请完善专业信息");}
}



function checkNull(tagName,tagErrorName){
		var tagValue=document.getElementById(tagName).value;

		if(tagValue.length==0){
			document.getElementById(tagErrorName).innerHTML="该选项不能为空";
			document.getElementById(tagErrorName).style.color="red";
			return false;
		}else{
		    document.getElementById(tagErrorName).innerHTML="已填写";
		    document.getElementById(tagErrorName).style.color="green";
		    return true;
		}
}
</script>



	</head>

	<body style="background-color:#e4dfd9"  onload="init()">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业信息
			<b class="tip"></b>添加专业信息
		</div>


		<form action="addMajor.action" id="addMajor" method="post">
		<table class="table table-bordered table-condensed">
			<caption class="t_caption">专业详细信息</caption>
			<thead>
				<tr>
					<td colspan="99">
						专业详细信息
					</td>
				</tr>
			</thead>
			<tbody id="mytable">
				<tr>
					<td>
						专业代码:<font color="FF0000">*</font>
					</td>
					<td>
						<input type="text" name="major.mno" id="mno" onblur="stublur();" />
						<span id="mnoError"> </span>
					</td>
					<td>
						专业名称:<font color="FF0000">*</font>
					</td>
					<td>
						<input type="text" name="major.mname" id="major.mname" onblur="return checkNull('major.mname','mnameError');"/>
						<span id="mnameError"> </span>
					</td>

				</tr>
				<tr>
					<td style="width: 12%;">
						学院名称:<font color="FF0000">*</font>
					</td>
					<td style="width: 38%;">
					<select size="1" name="major.department.dno" class="department" id="coll" >

								<s:iterator value="departmentList">
									<option value="<s:property value='dno'/>">
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
					</td>
					<td style="width: 12%;">
						学科门类:<font color="FF0000">*</font>
					</td>
					<td style="width: 38%;">
							<select size="1" name="major.disciplinetype.disciplineTypeId" class="disciplinetype" id="disciplinetype" >
								<s:iterator value="disciplinetypeList">
									<option value="<s:property value='disciplineTypeId'/>">
										<s:property value="disciplineTypeName" />
									</option>
								</s:iterator>
							</select>
					</td>
				</tr>
				<tr>
					<td>
						专业类:<font color="FF0000">*</font>
					</td>
					<td>
					<select size="1" name="major.majortype.majorTypeId" class="majortype" id="majortype" >

								<s:iterator value="majortypeList">
									<option value="<s:property value='majorTypeId'/>">
										<s:property value="majorTypeName" />
									</option>
								</s:iterator>
							</select>
					</td>
					<td>
						专业类别:<font color="FF0000">*</font>
					</td>
					<td>
						<select size="1" name="major.majorcategory.majorCategoryId" class="majorcategory" id="majorcategory" >

								<s:iterator value="majorcategoryList">
									<option value="<s:property value='majorCategoryId'/>">
										<s:property value="majorCategoryName" />
									</option>
								</s:iterator>
							</select>
					</td>
				</tr>
				<tr>

					<td>
						专业学生数:
					</td>
					<td colspan="3">
						<input type="text" name="major.majorStudentNum"
								value='<s:property value="major.majorStudentNum" />' />

					</td>
				</tr>
				<tr>
					<td>
						代码版本:
					</td>
					<td>
					<input type="text" name="major.codeVer"
								value='<s:property value="major.codeVer" />' />

					</td>
					<td>
						校内专业代码:
					</td>
					<td>
					<input type="text" name="major.inMno"
								value='<s:property value="major.inMno" />' />
					</td>
				</tr>
				<tr>
					<td>
						校内专业名称:
					</td>
					<td>
					<input type="text" name="major.inmName"
								value='<s:property value="major.inmName" />' />
					</td>
					<td>
						专业英文名称:
					</td>
					<td>
					<input type="text" name="major.menglishName"
								value='<s:property value="major.menglishName" />' />
					</td>
				</tr>
				<tr>
					<td>
						专业方向号:
					</td>
					<td>
					<input type="text" name="major.mdirectId"
								value='<s:property value="major.mdirectId" />' />

					</td>
					<td>
						专业方向名称:
					</td>
					<td>
					<input type="text" name="major.mdirectName"
								value='<s:property value="major.ndurectName" />' />

					</td>
				</tr>
				<tr>
					<td>
						院系内部编号:
					</td>
					<td>
					<input type="text" name="major.innerNo"
								value='<s:property value="major.innerNo" />' />

					</td>
					<td>
						专业带头人工号:
					</td>
					<td>
						<div id="abc" style="display: inline; float: left;">
							<input type="text" name="major.teachernNo"
								style="background: transparent;" placeholder="输入教工号或姓名搜索"
								autocomplete="off" id="names" onkeyup="findNames('${userId}')"
								onfocus="findNames('${userId}')"  value='<s:property value="major.teachernNo" />'/>
							<!-- 自动搜索，用于显示搜索结果 -->
							<div id="popup"
								style="border: 1px solid #c7c7c7; border-top: none; z-index: 1; position: absolute; overflow: auto;">
								<table class="autoSeek" id="complete_table">
									<tbody id="complete_body"></tbody>
								</table>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						招生状态:
					</td>
					<td>
						<select size="1" name="major.enrollmentState" >
								<option value="在招">
									在招
								</option>
								<option value="关闭">
									关闭
								</option>
						</select>
					</td>
					<td>
						学制:
					</td>
					<td>
					<input type="text" name="major.majorLength"
								value='<s:property value="major.majorLength" />' />

					</td>
				</tr>
				<tr>
					<td>
						专业开设年份:<font color="FF0000">*</font>
					</td>
					<td>
					<input type="text" name="major.year" maxlength="4" onkeypress="return Numbers(event)"
								value='<s:property value="major.year" />' />

					</td>
					<td>
						是否是新专业:
					</td>
					<td>
						<select size="1" name="major.majorNew" id="majorNew">
								<option value="是">
									是
								</option>
								<option value="否">
									否
								</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						学时总数:
					</td>
					<td>
					<input type="text" name="major.majorHours"
								value='<s:property value="major.majorHours" />' />

					</td>
					<td>
						必修课学时:
					</td>
					<td>
					<input type="text" name="major.majorCompulsoryHours"
								value='<s:property value="major.majorCompulsoryHours" />' />

					</td>
				</tr>
				<tr>
					<td>
						选修课学时:
					</td>
					<td>
					<input type="text" name="major.majorSelectedHours"
								value='<s:property value="major.majorSelectedHours" />' />

					</td>
					<td>
						课内教学学时:
					</td>
					<td>
					<input type="text" name="major.courseInnerTeachHours"
								value='<s:property value="major.courseInnerTeachHours" />' />

					</td>
				</tr>
				<tr>
					<td>
						实验教学学时:
					</td>
					<td>
					<input type="text" name="major.practiceTeachHours"
								value='<s:property value="major.practiceTeachHours" />' />

					</td>
					<td>
						学分总数:
					</td>
					<td>
					<input type="text" name="major.credit"
								value='<s:property value="major.credit" />' />

					</td>
				</tr>
				<tr>
					<td>
						必修课学分:
					</td>
					<td>
					<input type="text" name="major.compulsoryCredit"
								value='<s:property value="major.compulsoryCredit" />' />

					</td>
					<td>
						选修课学分:
					</td>
					<td>
					<input type="text" name="major.selectedCredit"
								value='<s:property value="major.selectedCredit" />' />

					</td>
				</tr>
				<tr>
					<td>
						集中性实践教学环节学分:
					</td>
					<td>
					<input type="text" name="major.focusParcticeCredit"
								value='<s:property value="major.focusParcticeCredit" />' />

					</td>
					<td>
						课内教学学分:
					</td>
					<td>
					<input type="text" name="major.courseInnerTeachCredit"
								value='<s:property value="major.courseInnerTeachCredit" />' />

					</td>
				</tr>
				<tr>
					<td>
						实验教学学分:
					</td>
					<td>
					<input type="text" name="major.practiceCredit"
								value='<s:property value="major.practiceCredit" />' />

					</td>
					<td>
						课外科技活动学分:
					</td>
					<td>
					<input type="text" name="major.outerScienticActivityCredit"
								value='<s:property value="major.outerScienticActivityCredit" />' />

					</td>
				</tr>

				<tr>
					<td>
						专业特色:
					</td>
					<td colspan="3">
						<textarea name="major.majorFeatures" id="text"
							style="margin: 0;width: 99%;word-break: break-all;border-style: none; border: 0;
							 background-color: transparent;overflow: hidden;resize: none;"
							><s:property value="major.majorFeatures" /></textarea>

					</td>
				</tr>
				<tr>
					<td>
						专业培养目标:
					</td>
					<td colspan="3" rowspan="2">
						<textarea name="major.majorTrainingObjective" id="text"
							style="margin: 0;width: 99%;word-break: break-all;border-style: none; border: 0;
							 background-color: transparent;overflow: hidden;resize: none;"
							><s:property value="major.majorTrainingObjective" /></textarea>

					</td>
				</tr>
			</tbody>
			<tfoot>
					<tr>
						<td colspan="99">
							<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
							<a class="btn btn-primary add" id="save"
								href="javascript:modifyEditMajor()">保存</a>&nbsp;&nbsp;
						</td>
					</tr>
				</tfoot>
		</table>
		</form>
	</body>
</html>
