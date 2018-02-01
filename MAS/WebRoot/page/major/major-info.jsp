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
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/timeManage.js">
</script>

		<script type="text/javascript">


			$(document).ready(function(){
			timeManage();
			    $("#mytable tr:even td").css("background","#fff");
			    $("#mytable tr:even td").attr("bg","#fff");
			    $("#mytable tr:odd td").attr("bg","#fff");
			    $("#mytable tr td").hover(function(){
			        $(this).parent().find("td").css("background","#fff")
			        },function(){
			            var bgc = $(this).attr("bg");
			            $(this).parent().find("td").css("background",bgc)
			            });

			     var sumCount = 0;
				var els =document.getElementsByName("fd");
					for (var i = 0, j = els.length; i < j; i++){
					sumCount += parseFloat(els[i].value);
				}
				document.getElementById("fdap").innerHTML = sumCount;
				var fund = '<s:property value="major.contestFund" />';
				if(sumCount != fund){
					document.getElementById("fdre").innerHTML = "(与预算经费不符)";
				}else{
					document.getElementById("fdre").innerHTML = "(与预算经费相符)";
				}


		    })


			function downloadFile(conId){
				window.location.href = "upDown_downloadFile.action?contestId="+conId;
			}

			//经费预算信息
			function contestFund(cId){
				window.location.href = "fundInfoDisplay.action?contestId="+cId;
			}


		</script>



	</head>

	<body style="background-color:#e4dfd9"  onload="init()">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业信息
			<b class="tip"></b>专业详细信息
		</div>



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
						<input type="text" name="major.mno" id="mno" readonly="readonly" value="<s:property value="major.mno" />" />
					</td>
					<td>
						专业名称:<font color="FF0000">*</font>
					</td>
					<td>
						<input type="text" name="major.mname" id="major.mname" readonly="readonly" value='<s:property value="major.mname" />'/>
					</td>

				</tr>
				<tr>
					<td style="width: 12%;">
						学院名称:<font color="FF0000">*</font>
					</td>
					<td style="width: 38%;">
						<input type="text" name="major.department.dname" id="dname" readonly="readonly" value='<s:property value="major.department.dname" />'/>
					</td>
					<td style="width: 12%;">
						学科门类:<font color="FF0000">*</font>
					</td>
					<td style="width: 38%;">
						<input type="text" name="major.disciplinetype.disciplineTypeName" id="disciplineTypeName" readonly="readonly" value='<s:property value="major.disciplinetype.disciplineTypeName" />'/>
					</td>
				</tr>
				<tr>
					<td>
						专业类:<font color="FF0000">*</font>
					</td>
					<td>
						<input type="text" name="major.majortype.majorTypeName" id="majorTypeName" readonly="readonly" value='<s:property value="major.majortype.majorTypeName" />'/>
					</td>
					<td>
						专业类别:<font color="FF0000">*</font>
					</td>
					<td>
						<input type="text" name="major.majortype.majorTypeName" id="majorTypeName" readonly="readonly" value='<s:property value="major.majortype.majorTypeName" />'/>
					</td>
				</tr>
				<tr>
					<td>
						专业学生数:
					</td>
					<td >
						<input type="text" name="major.majorStudentNum" readonly="readonly"
								value='<s:property value="major.majorStudentNum" />' />

					</td>
					<td>
						代码版本:
					</td>
					<td>
					<input type="text" name="major.codeVer" readonly="readonly"
								value='<s:property value="major.codeVer" />' />

					</td>
				</tr>
				<tr>
					<td>
						校内专业代码:
					</td>
					<td>
					<input type="text" name="major.inMno" readonly="readonly"
								value='<s:property value="major.inMno" />' />
					</td>
					<td>
						校内专业名称:
					</td>
					<td>
					<input type="text" name="major.inmName" readonly="readonly"
								value='<s:property value="major.inmName" />' />
					</td>
				</tr>
				<tr>
					<td>
						院系内部编号:
					</td>
					<td>
					<input type="text" name="major.innerNo" readonly="readonly"
								value='<s:property value="major.innerNo" />' />

					</td>
					<td>
						专业英文名称:
					</td>
					<td>
					<input type="text" name="major.menglishName" readonly="readonly"
								value='<s:property value="major.menglishName" />' />
					</td>
				</tr>
				<tr>
					<td>
						专业方向号:
					</td>
					<td>
					<input type="text" name="major.mdirectId" readonly="readonly"
								value='<s:property value="major.mdirectId" />' />
					</td>
					<td>
						专业方向名称:
					</td>
					<td>
					<input type="text" name="major.mdirectName" readonly="readonly"
								value='<s:property value="major.ndurectName" />' />

					</td>
				</tr>
				<tr>
					<td>
						专业带头人姓名:
					</td>
					<td>
					<input type="text" name="majorleadername" readonly="readonly"
								value='<s:property value="majorleadername" />' />

					</td>
					<td>
						专业带头人工号:
					</td>
					<td>
					<input type="text" name="major.teachernNo" readonly="readonly"
								value='<s:property value="major.teachernNo" />' />

					</td>
				</tr>
				<tr>
					<td>
						招生状态:
					</td>
					<td>

						<input type="text" name="major.enrollmentState" readonly="readonly"
								value='<s:property value="major.enrollmentState" />' />
					</td>
					<td>
						学制:
					</td>
					<td>
					<input type="text" name="major.majorLength"  readonly="readonly"
								value='<s:property value="major.majorLength" />' />

					</td>
				</tr>
				<tr>
					<td>
						专业开设年份:<font color="FF0000">*</font>
					</td>
					<td>
					<input type="text" name="major.year" maxlength="4"  readonly="readonly"
								value='<s:property value="major.year" />' />

					</td>
					<td>
						是否是新专业:
					</td>
					<td>
						<input type="text" name="major.majorNew" maxlength="4"  readonly="readonly"
								value='<s:property value="major.majorNew" />' />
					</td>
				</tr>
				<tr>
					<td>
						学时总数:
					</td>
					<td>
					<input type="text" name="major.majorHours" readonly="readonly"
								value='<s:property value="major.majorHours" />' />

					</td>
					<td>
						必修课学时:
					</td>
					<td>
					<input type="text" name="major.majorCompulsoryHours" readonly="readonly"
								value='<s:property value="major.majorCompulsoryHours" />' />

					</td>
				</tr>
				<tr>
					<td>
						选修课学时:
					</td>
					<td>
					<input type="text" name="major.majorSelectedHours" readonly="readonly"
								value='<s:property value="major.majorSelectedHours" />' />

					</td>
					<td>
						课内教学学时:
					</td>
					<td>
					<input type="text" name="major.courseInnerTeachHours" readonly="readonly"
								value='<s:property value="major.courseInnerTeachHours" />' />

					</td>
				</tr>
				<tr>
					<td>
						实验教学学时:
					</td>
					<td>
					<input type="text" name="major.practiceTeachHours" readonly="readonly"
								value='<s:property value="major.practiceTeachHours" />' />

					</td>
					<td>
						学分总数:
					</td>
					<td>
					<input type="text" name="major.credit" readonly="readonly"
								value='<s:property value="major.credit" />' />

					</td>
				</tr>
				<tr>
					<td>
						必修课学分:
					</td>
					<td>
					<input type="text" name="major.compulsoryCredit" readonly="readonly"
								value='<s:property value="major.compulsoryCredit" />' />

					</td>
					<td>
						选修课学分:
					</td>
					<td>
					<input type="text" name="major.selectedCredit" readonly="readonly"
								value='<s:property value="major.selectedCredit" />' />

					</td>
				</tr>
				<tr>
					<td>
						集中性实践教学环节学分:
					</td>
					<td>
					<input type="text" name="major.focusParcticeCredit" readonly="readonly"
								value='<s:property value="major.focusParcticeCredit" />' />

					</td>
					<td>
						课内教学学分:
					</td>
					<td>
					<input type="text" name="major.courseInnerTeachCredit" readonly="readonly"
								value='<s:property value="major.courseInnerTeachCredit" />' />

					</td>
				</tr>
				<tr>
					<td>
						实验教学学分:
					</td>
					<td>
					<input type="text" name="major.practiceCredit" readonly="readonly"
								value='<s:property value="major.practiceCredit" />' />

					</td>
					<td>
						课外科技活动学分:
					</td>
					<td>
					<input type="text" name="major.outerScienticActivityCredit" readonly="readonly"
								value='<s:property value="major.outerScienticActivityCredit" />' />

					</td>
				</tr>

				<tr>
					<td>
						专业特色:
					</td>
					<td colspan="3">
						<textarea name="major.majorFeatures" id="text" readonly="readonly"
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
						<textarea name="major.majorTrainingObjective" id="text" readonly="readonly"
							style="margin: 0;width: 99%;word-break: break-all;border-style: none; border: 0;
							 background-color: transparent;overflow: hidden;resize: none;"
							><s:property value="major.majorTrainingObjective" /></textarea>

					</td>
				</tr>
			</tbody>


			</tbody>
			<tfoot>
				<tr>
					<td colspan="99">
						<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
						<a class="btn btn-primary add" href="editToMajor.action?mno=<s:property value="mno"/>">修改</a>&nbsp;&nbsp;

					</td>
				</tr>
			</tfoot>
		</table>

	</body>
</html>
