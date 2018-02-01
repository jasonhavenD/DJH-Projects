<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>编辑功能信息</title>

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
		<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/ajax/FunctionToPcode.js">
</script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/ajax/funModelCode_uniqueness.js">
</script>
		<script type="text/javascript">
function modifyEdit() {
	if(document.getElementById("secondp").value=="" || document.getElementById("funModleName").value=="" ||document.getElementById("funModleCode").value=="" ||document.getElementById("state").value==""){
		confirm("*选项不能为空");
	}else{
		if (confirm("是否修改")) {
			document.getElementById("edit").submit();
		}
	}
}
$(document).ready(
		function() {

			$(".college").change(
					function() {
						$('#major option').remove();

						$.ajax( {
							type : "POST",
							url : 'findByCollegeIdListMajor.action',
							data : 'collegeId=' + $(this).val(),
							success : function(jsonArray) {

								var json = eval("(" + jsonArray + ")")
								var porHtml = "";
								for ( var i = 0; i < json.length; i++) {
									porHtml += "<option value="
											+ json[i].majorId + " >"
											+ json[i].majorName + "</option>";
								}
								$("#major").append(porHtml);
							},
							error : function(XMLHttpRequest, textStatus,
									errorThrown) {
								alert('通信失败:' + errorThrown);
							}
						});
					});
		});

</script>
</head>

	<body style="background-color:#e4dfd9"  onload="init();">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>查询功能信息
			<b class="tip"></b>编辑功能信息
		</div>

		<form action="editSysFunmodle.action"
			id="edit" method="post">


			<table class="table table-striped table-bordered table-condensed">
				<caption class="t_caption">
					功能信息编辑
				</caption>
				<thead>
					<tr>
						<td colspan="99">
							功能信息编辑
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td>
							一级目录名称
						</td>
						<td>
							<select id="firstp" onchange="firstpchange();" >
								<option value="">
									--全部一级目录--
								</option>
								<s:iterator value="firstpList">
									<option value="<s:property value="funModleCode"/>">
										<s:property value="funModleName" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							二级目录名称
							<font color="red">*</font>
						</td>
						<td>
							<select id="secondp" name="func.funParentCode">
								<option value="">
									--全部二级目录--
								</option>
								<s:iterator value="secondpList" var="function">
									<option value="<s:property value="funModleCode"/>"
										<s:if test="#function.funModleCode == func.funParentCode">selected="selected"</s:if>>
										<s:property value="funModleName" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							功能名称
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="func.funModleName" id="funModleName"
									value='<s:property value="func.funModleName" />' />
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							功能编号
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="func.funModleCode" id="funModleCode"
								value='<s:property value="func.funModleCode" />'  onblur="onblurCode();"
								<s:if test="funModleCode != 0">readonly="readonly"</s:if>
								/>
						</td>
						<td>
							状态
							<font color="red">*</font>
						</td>
						<td colspan="3">
							<select name="func.state" id="state">
								<option value="1"
									<s:if test="1==func.state">selected="selected"</s:if>>
									可以分配于角色
								</option>
								<option value="0"
									<s:if test="0==func.state">selected="selected"</s:if>>
									不可以分配于角色
								</option>
							</select>
						</td>
					</tr>

				</tbody>
				<tfoot>
					<tr>
						<td colspan="99">
							<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
							<a class="btn btn-primary add" href="javascript:modifyEdit()">保存</a>&nbsp;&nbsp;
							<span id="funModleCodeError"></span>
						</td>

					</tr>
				</tfoot>
			</table>
		</form>
	</body>
</html>
