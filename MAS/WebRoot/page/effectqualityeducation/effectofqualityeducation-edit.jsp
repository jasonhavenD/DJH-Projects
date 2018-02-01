<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>编辑人文科学素质教育效果信息</title>

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
function modifyEditEqe() {
	if (document.getElementById("major").value.length==0) {
		alert("请选择专业");
		document.getElementById("major").focus();
	}else if(document.getElementById("year").value.length == 0) {
		alert("请输入年份");
		document.getElementById("year").focus();
	}else if(document.getElementById("cupCount").value.length == 0) {
		alert("请输入挑战杯参与人数");
		document.getElementById("cupCount").focus();
	}else if(document.getElementById("majorCount").value.length == 0) {
		alert("专业总人数");
		document.getElementById("majorCount").focus();
	}else if(document.getElementById("hostReportCount").value.length == 0) {
		alert("请输入报告会举办次数");
		document.getElementById("hostReportCount").focus();
	}else if(document.getElementById("partiCount").value.length == 0) {
		alert("请输入报告会参与人数");
		document.getElementById("partiCount").focus();
	}else if(document.getElementById("otherProject").value.length == 0) {
		alert("请输入其他教育类项目数:");
		document.getElementById("otherProject").focus();
	}else if(confirm("是否保存")) {
				document.getElementById("editEqe").submit();
	} 
}
</script>

	</head>

	<body onload="init();" style="background-color:#e4dfd9">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>查询人文科学素质教育效果信息
			<b class="tip"></b>编辑人文科学素质教育效果信息
		</div>

		<form action="editEqe.action" id="editEqe" method="post">


			<table class="table table-striped table-bordered table-condensed">
				<caption class="t_caption">
					人文科学素质教育效果信息编辑
				</caption>
				<thead>
					<tr>
						<td colspan="99">
							人文科学素质教育效果信息编辑
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>

						<td style="width: 60px;">
							专业名称
							<font color="red">*</font>
						</td>
						<td>

							<s:if test="effectofqualityeducation==null">

								<select size="1" name="effectofqualityeducation.major.mno"
									id="major">
									<option value="">
										全部专业
									</option>
									<s:iterator value="majorList">
										<option value="<s:property value='mno'/>">
											<s:property value="mname" />
										</option>
									</s:iterator>
								</select>
							</s:if>
							<s:else>

								<input type="text" id="major" readonly="readonly" id="major"
									value='<s:property  value="effectofqualityeducation.major.mname" />' />
							</s:else>
						</td>
						<td>
							年份
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="effectofqualityeducation.year" id="year"
								maxlength="4" onkeypress="return Numbers(event)"
								value='<s:property value="effectofqualityeducation.year" />' />
							<span id="yearspan"></span>
						</td>


						<td style="width: 60px;">
							挑战杯参与人数:
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" maxlength="3" name="effectofqualityeducation.cupCount" id="cupCount" onkeypress="return Numbers(event)"
								value='<s:property value="effectofqualityeducation.cupCount" />' />
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							专业总人数:
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" maxlength="3" name="effectofqualityeducation.majorCount" id="majorCount" onkeypress="return Numbers(event)"
								value='<s:property value="effectofqualityeducation.majorCount" />' />
						</td>
						<td style="width: 60px;">
							报告会举办次数:
							<font color="red">*</font>
						</td>
						<td>
						  						
						   	<input type="text" maxlength="3"
								name="effectofqualityeducation.hostReportCount" id="hostReportCount"  onkeypress="return Numbers(event)"
								value='<s:property value="effectofqualityeducation.hostReportCount" />' />
							
						</td>

						<td style="width: 60px;">
							报告会参与次数:<font color="red">*</font>
						</td>
						<td>
							<input type="text" maxlength="3" name="effectofqualityeducation.partiCount" id="partiCount" onkeypress="return Numbers(event)"
								value='<s:property value="effectofqualityeducation.partiCount" />' />
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							其他教育类项目数:<font color="red">*</font>
						</td>
						<td>
							<input type="text" maxlength="3" name="effectofqualityeducation.otherProject" id="otherProject" onkeypress="return Numbers(event)"
								value='<s:property value="effectofqualityeducation.otherProject" />' />
						</td>
						<td style="width: 60px;">
							备注
						</td>
						<td colspan="3">
							<input type="text" name="effectofqualityeducation.note"
								value='<s:property value="effectofqualityeducation.note" />' />
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="99">
							<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
							<a class="btn btn-primary add" id="save"
								href="javascript:modifyEditEqe()">保存</a>&nbsp;&nbsp;

						</td>

					</tr>
				</tfoot>
			</table>
		</form>
	</body>
</html>
