<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@page import="java.lang.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>专家打分</title>
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
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/MajorByDno.js">
</script>

		<script>

//查询需要评分专业
function findContestApply() {
	document.getElementById("form2").submit();
	//String s = "saveAdvice.action?mno="+mno+"&question="+question+"&advice="+advice;
	alert("已提交！");
	//window.location.href = s;
}
//
function findByContestIdInfo() {

	var a=document.getElementById("form2");
	//var b = a.getElementsByTagName(mno);
	//alert($("#mno").val());
	window.location.href = "findAdvice.action?mno="+$("#mno").val();

}

function collchange() {//当第一个下拉框的选项发生改变时调用该函数
	//var colls = document.getElementById("coll").value; //获取第一级菜单的值
	//findByContestIdInfo();
	//值得注意的是URL的servlet地址前面不加“/”并且为小写字母（试验的结论）
	var a=document.getElementById("form2");
	//var b = a.getElementsByTagName(mno);
	//alert($("#mno").val());
	window.location.href = "findAdvice.action?mno="+$("#mno").val();
}

</script>
<style type="text/css">
.text1{width:1500px; height:800px}
</style>

	</head>
	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专家意见
		</div>

		<form action="saveAdvice.action" id="form2"
			name="form2" method="post" enctype="multipart/form-data">

			<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							专业查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td width="270px">
							所在专业<br/>
							请先选择专业并点击<font color="red">查询</font>后再输入评估意见提交
						</td>
						<td>

							<select size="1" name="mno" id="mno" onchange="collchange();">
								<option value="<s:property value='mno'/>">
										<s:property value="mname" />
									</option>
								<s:iterator value="majorList" var="majorvar">
									<option value="<s:property value='mno'/>"<s:if test="#majorvar.mno == expertscoreModel.majorId">selected="selected"</s:if>>
										<s:property value="mname" />
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="3">
							<a href="javascript:findByContestIdInfo()"
								class="btn btn-primary add">查询</a>
						</td>

					</tr>
				</tfoot>
			</table>

		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				专家评估意见表
			</caption>
            <tr><td>一、 专业建设中存在的问题：</td></tr>
            <tr><td><textarea name="question" style="width:100%;height:210px;" wrap="virtual"><s:property value='question'/></textarea></td></tr>
            <tr><td>二、整改意见和建议</td></tr>
            <tr><td><textarea name="advice" style="width:100%;height:210px;" wrap="virtual"><s:property value='advice'/></textarea></td></tr>

            <tr><td width="10%">
				<a href="javascript:findContestApply();"
						class="btn btn-primary add">提交</a></td>
		    </tr>
         </table>
         </form>
	</body>
</html>
