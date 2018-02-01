<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>学院详情</title>

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
			src="${pageContext.request.contextPath}/Scripts/ajax/dno_uniqueness.js">
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
			if(document.getElementById("dno").value.length == 0){
			alert("学院代码选项不能为空");
			document.getElementById("dno").focus();
			}else if(document.getElementById("dname").value.length == 0){
			alert("学院名称选项不能为空");
			document.getElementById("dname").focus();
			}else if(document.getElementById("fuzeren").value.length == 0){
			alert("学院负责人选项不能为空");
			document.getElementById("fuzeren").focus();
			}		
			else if (confirm("是否修改")) {
					document.getElementById("editDepartment").submit();
				}	
			}
					
		</script>
		
	</head>

	<body onload="init()" style="background-color:#e4dfd9">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>学院信息
			<b class="tip"></b>修改学院信息
		</div>

		
		<form action="editdepartment.action" id="editDepartment" method="post">
		<table class="table table-bordered table-condensed">
			<caption class="t_caption">学院详细信息</caption>
			<thead>
				<tr>
					<td colspan="99">
						学院详细信息
					</td>
				</tr>
			</thead>
			<tbody id="mytable">
				<tr>
					<td>
						学院代码:<font color="FF0000">*</font>
					</td>
					<td>
					<s:if test='department==null'>
							<input name="department.dno" id="dno" onblur="dnoblur();"
								type="text" />
						</s:if>
						<s:else>
						<input name="department.dno" id="dno" readonly="readonly"  
								value='<s:property value="department.dno"/>'
								type="text" />
								</s:else>	
								<span id="dnoError"></span>
					</td>
					<td>
						学院名称:<font color="FF0000">*</font>
					</td>
					<td>
						<input type="text" name="department.dname" id="dname"  value="<s:property value="department.dname" />" />
					</td>
					<td>
						学院负责人:<font color="FF0000">*</font>
					</td>
					<td>
						<input type="text" name="department.fuzeren" id="fuzeren"  value="<s:property value="department.fuzeren" />" />
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
