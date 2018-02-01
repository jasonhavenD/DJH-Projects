<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>校外实习基地修改</title>

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


		<script type="text/javascript">
			//日历插件
			$(function() {
				$(".datepicker").datepicker();
			})

			//确认修改教学经费
			function modifyContestIdInfoS() {
				var name = document.getElementById("name").value;
				var fund = document.getElementById("fund").value;
				if(name == null || name == ""){
					alert("请输入教学经费编号！");
					return ;
				}

				if (confirm("是否修改教学经费信息")) {
					document.getElementById("contestapplyadd").submit();
				}
			}

		</script>

	</head>

	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业数据采集
			<b class="tip"></b>修改校外实习基地信息
		</div>

		<form action="modifyContestIdInfoOffice.action?csId=<s:property value="contestApplyOffice.contestId"/>&contestId=<s:property value="contestApplyOffice.contestapply.contestId"/>" id="contestapplyadd" method="post">

			<!-- 设置默认编号 -->
			<s:hidden name="contestApply.contestNo" value="SXM"></s:hidden>

			<table class="table table-striped table-bordered table-condensed">
				<caption class="t_caption">校外实习基地</caption>
				<thead>
					<tr>
						<td colspan="99">
							实习基地信息修改
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 60px;">
							基地编号
							<font color="FF0000">*</font>
						</td>
						<td colspan="5">
							<input name="contestApply.contestName" style="width: 99%;" id="name"
								type="text" />
						</td>

					</tr>
					<tr>
						<td style="width: 60px;">
							基地名称
							<font color="FF0000">*</font>
						</td>
						<td>
							<select size="1" id="cLevel"
								name="contestApply.contestlevel.contestLevelId">
								<s:iterator value="contestLevelList">
									<option value="<s:property value='contestLevelId'/>">
										<s:property value="contestLevelName" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width: 60px;">
							基地地址
							<font color="FF0000">*</font>
						</td>
						<td>
							<select size="1" id="cType"
								name="contestApply.contesttype.contestTypeId">
								<s:iterator value="contestTypeList">
									<option value="<s:property value='contestTypeId'/>">
										<s:property value="contestTypeName" />
									</option>
								</s:iterator>
							</select>
						</td>

						<td>
							使用时间
							<font color="FF0000">*</font>
						</td>
						<td >
							<select size="1" id="college"
								name="collegeId">
								<s:iterator value="collegeList">
									<option value="<s:property value='collegeId'/>">
										<s:property value="collegeName" />
									</option>
								</s:iterator>
							</select>
						</td>


					</tr>
					<tr>
						<td>
							每次可接纳学生数
							<font color="FF0000">*</font>
						</td>
						<td>
							<select size="1" id="college"
								name="collegeId">
								<s:iterator value="collegeList">
									<option value="<s:property value='collegeId'/>">
										<s:property value="collegeName" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width: 60px;">
							当年接纳学生数
							<font color="FF0000">*</font>
						</td>
						<td>
							<select size="1" id="college"
								name="collegeId">
								<s:iterator value="collegeList">
									<option value="<s:property value='collegeId'/>">
										<s:property value="collegeName" />
									</option>
								</s:iterator>
							</select>
						</td>


						<td>
							备注

						</td>
						<td >
							<input type="text" name="contestApply.contestFund" id="fund"/>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="99">
							<a href="javascript:modifyContestIdInfoS()"
								class="btn btn-primary add">保存</a>
								<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</body>
</html>
