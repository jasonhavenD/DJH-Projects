<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>编辑F值基本信息</title>

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

		<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/ajax/Course_uniqueness.js"></script>

		<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/ajax/DnameByDno.js"></script>

<script type="text/javascript">

function modifyEdit(){
			var a=document.getElementById("funtionargs.funValue").value;
			var b=parseFloat(a).toString();
			if( a== ""){

					alert("请输入内容");
			} else if(a.length!=b.length||parseFloat(a)=="NaN"){
				    alert("F值应为数值型");
			}else {
				if(confirm("是否保存")){
					document.getElementById("editFuntion").submit();
				}
			}
}
</script>
</head>

	<body style="background-color:#e4dfd9"  onload="init();">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>查询F值信息信息
			<b class="tip"></b>编辑F值信息信息
		</div>

		<form action="editFuntionargs.action" id="editFuntion" method="post">


			<table class="table table-striped table-bordered table-condensed">
				<caption class="h_caption">
					F值信息编辑
				</caption>
				<thead>
					<tr>
						<td colspan="99">
							F值信息编辑
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td style="width: 60px;">
							F值名称
						</td>
						<td>
							<input type="text" id="funtionargs.funName" name="funtionargs.funName" value='<s:property value="funtionargs.funName"/>'/>
						</td>
						<td style="width: 60px;">
							F值Value
						</td>
						<td>
							<input type="text" id="funtionargs.funValue" name="funtionargs.funValue" value='<s:property value="funtionargs.funValue"/>'/>
							<span style="color: red;">(应填写数值类型数据)</span>
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							F值说明
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="funtionargs.funExplation" id="funtionargs.funExplation" value='<s:property value="funtionargs.funExplation" />' onblur="dnochange()"/>
							<span id="dnoError" style="width: 15px;text-align:left;display:inline-block;"></span>
						</td>

					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="99">
							<a class="btn btn-primary add"
							href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
						<a class="btn btn-primary add"
							href="javascript:modifyEdit()">保存</a>&nbsp;&nbsp;

						</td>

					</tr>
				</tfoot>
			</table>
		</form>
	</body>
</html>
