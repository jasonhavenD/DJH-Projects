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
			//确认是否能修改
			function modifyContestInfoList(mno) {
				var s = '<s:property value="major.status.statusId"/>';
				//能修改的状态是“暂存”(1)和“返回修改”(4)
				if ((1 == s || 4 == s) && confirm("是否修改")) {
					window.location.href = "editToMajor.action?mno="
							+ mno;
				} else {
					alert("已提交，不能修改");
					window.location.href = "#";
				}

			}

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

		<table class="table table-bordered" style="margin-top: 0;margin-bottom: 0;">
		<thead>
		<tr style="background-color: #FFF;"><td>
				<a href="javascript:contestFund('<s:property value="major.contestId"/>')"
					style="margin-bottom: -5px;margin-top: -5px;"
					class="btn btn-primary add">导出</a>
		</td></tr></thead>
		</table>

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
						专业代码
					</td>
					<td colspan="3">
						<s:property value="major.mno" />
					</td>
				</tr>
				<tr>
					<td style="width: 12%;">
						学院名称
					</td>
					<td style="width: 38%;">
						<s:property value="major.department.dname" />
					</td>
					<td style="width: 12%;">
						学科门类
					</td>
					<td style="width: 38%;">
						<s:property value="major.disciplinetype.disciplinetypeName" />
					</td>
				</tr>
				<tr>
					<td>
						专业类
					</td>
					<td>
						<s:property value="major.majortype.majortypeName" />
					</td>
					<td>
						专业类别
					</td>
					<td>
						<s:property value="major.majorcategory.majorcategoryName" />
					</td>
				</tr>
				<tr>
					<td>
						专业名称
					</td>
					<td>
						<s:property value="major.mname" />
					</td>
					<td>
						专业学生数
					</td>
					<td>
						<s:property value="major.majorStudentNum" />
					</td>
				</tr>
				<tr>
					<td>
						代码版本
					</td>
					<td>
						<s:property value="major.codeVer" />

					</td>
					<td>
						校内专业代码
					</td>
					<td>
						<s:property value="major.inMno" />
					</td>
				</tr>
				<tr>
					<td>
						校内专业名称
					</td>
					<td>
						<s:property value="major.inmName" />
					</td>
					<td>
						专业英文名称
					</td>
					<td>
						<s:property value="major.menglishName" />
					</td>
				</tr>
				<tr>
					<td>
						专业方向号
					</td>
					<td>
						<s:property value="major.mdirectId" />

					</td>
					<td>
						专业方向名称
					</td>
					<td>
						<s:property value="major.ndurectName" />

					</td>
				</tr>
				<tr>
					<td>
						院系内部编号
					</td>
					<td>
						<s:property value="major.innerNo" />

					</td>
					<td>
						专业带头人工号
					</td>
					<td>
						<s:property value="major.teachernNo" />

					</td>
				</tr>
				<tr>
					<td>
						招生状态
					</td>
					<td>
						<s:property value="major.enrollmentState" />

					</td>
					<td>
						学制
					</td>
					<td>
						<s:property value="major.majorLength" />

					</td>
				</tr>
				<tr>
					<td>
						专业开设年份
					</td>
					<td>
						<s:property value="major.year" />

					</td>
					<td>
						是否是新专业
					</td>
					<td>
						<s:property value="major.majorNew" />

					</td>
				</tr>
				<tr>
					<td>
						学时总数
					</td>
					<td>
						<s:property value="major.majorHours" />

					</td>
					<td>
						必修课学时
					</td>
					<td>
						<s:property value="major.majorCompulsoryHours" />

					</td>
				</tr>
				<tr>
					<td>
						选修课学时
					</td>
					<td>
						<s:property value="major.majorSelectedHours" />

					</td>
					<td>
						课内教学学时
					</td>
					<td>
						<s:property value="major.courseInnerTeachHours" />

					</td>
				</tr>
				<tr>
					<td>
						实验教学学时
					</td>
					<td>
						<s:property value="major.practiceTeachHours" />

					</td>
					<td>
						学分总数
					</td>
					<td>
						<s:property value="major.credit" />

					</td>
				</tr>
				<tr>
					<td>
						必修课学分
					</td>
					<td>
						<s:property value="major.compulsoryCredit" />

					</td>
					<td>
						选修课学分
					</td>
					<td>
						<s:property value="major.selectedCredit" />

					</td>
				</tr>
				<tr>
					<td>
						集中性实践教学环节学分
					</td>
					<td>
						<s:property value="major.focusParcticeCredit" />

					</td>
					<td>
						课内教学学分
					</td>
					<td>
						<s:property value="major.courseInnerTeachCredit" />

					</td>
				</tr>
				<tr>
					<td>
						实验教学学分
					</td>
					<td>
						<s:property value="major.practiceCredit" />

					</td>
					<td>
						课外科技活动学分
					</td>
					<td>
						<s:property value="major.outerScienticActivityCredit" />

					</td>
				</tr>

				<tr>
					<td>
						专业特色
					</td>
					<td colspan="3">
						<textarea name="major.majorFeatures" id="text"
							style="margin: 0;width: 99%;word-break: break-all;border-style: none; border: 0;
							 background-color: transparent;overflow: hidden;resize: none;"
							readonly="readonly"><s:property value="major.majorFeatures" /></textarea>

					</td>
				</tr>
				<tr>
					<td>
						专业培养目标
					</td>
					<td colspan="3">
						<textarea name="major.majorTrainingObjective" id="text"
							style="margin: 0;width: 99%;word-break: break-all;border-style: none; border: 0;
							 background-color: transparent;overflow: hidden;resize: none;"
							readonly="readonly"><s:property value="major.majorTrainingObjective" /></textarea>

					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="99">
						<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;

						<a class="btn btn-primary add"
							href="javascript:modifyContestInfoList(<s:property value="major.mno"/>)">修改</a>&nbsp;&nbsp;

					</td>
				</tr>
			</tfoot>
		</table>

	</body>
</html>
