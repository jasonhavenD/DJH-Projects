<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>编辑教师发表科研论文信息</title>

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

<script type="text/css" src="${pageContext.request.contextPath}/Scripts/autogrow.textarea.js"></script>
	<!--<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/ajax/TnameByTno.js"></script>
	--><script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/ajax/add.js"></script>
	</head>

<script type="text/javascript">

$(function() {
$("textarea").autogrow();
});
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

function modifyEdit(){

     var y=document.getElementById("year").value; 
    if (document.getElementById("names").value.length ==0){
	        alert("教师编号选项不能为空");
			document.getElementById("names").focus();
	}
    else if (document.getElementById("paperName").value.length ==0){
	        alert("论文名称选项不能为空");
			document.getElementById("paperName").focus();
	}
	else if (document.getElementById("influenceFactors").value.length ==0){
	        alert("影响因子选项不能为空");
			document.getElementById("influenceFactors").focus();
	}
	else if (document.getElementById("periodicalType").value.length ==0){
	        alert("论文类别选项不能为空");
			document.getElementById("periodicalType").focus();
	}
	else if(y.length==0){  
        alert("发表年份选项不能为空!");  
        document.getElementById("year").focus();
    } 
     else if(y.length!=4){  
        alert("发表年份选项只能输入4位数字!");  
        document.getElementById("year").focus();
    } 	
    else if (confirm("是否保存")) {
			document.getElementById("editPap").submit();
		}
}

</script>
	<body onload="init();" style="background-color:#e4dfd9">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>查询获得教师发表科研论文信息
			<b class="tip"></b>编辑教师发表科研论文信息
		</div>

		<form action="editPap.action" id="editPap" method="post">


			<table class="table table-striped table-bordered table-condensed">
				<caption class="h_caption">
					教师发表科研论文信息编辑
				</caption>
				<tbody id="mytable">
					<tr>

						<!--<td style="width: 60px;">
							教师编号
							<font color="red">*</font>
						</td>
						<td width="30%">
							<input type="text" name="publicshedaacademicpapers.teacher.tno" id="tno" value='<s:property value="publicshedaacademicpapers.teacher.tno" />' onblur="tnochange()"/>
							<span id="tnoError"></span>
						</td>
						<td style="width: 60px;">
							教师姓名
						</td>
						<td>
							<input type="text" name="teacherName" id="teacherName" value='<s:property value="publicshedaacademicpapers.teacher.tname"/>' readonly="readonly"/>
						</td>
						-->
						<td style="width: 60px;">
							教师工号/姓名
							<font color="FF0000">*</font>
						</td>
						<td>
							<div id="abc" style="display: inline; float: left;">
								<input type="text" name="publicshedaacademicpapers.teacher.tno" 
									style="background: transparent;" placeholder="输入教工号或姓名搜索"
									autocomplete="off" id="names" onkeyup="findNames('${userId}')"
									onfocus="findNames('${userId}')"  value='<s:property value="publicshedaacademicpapers.teacher.tno" />'/>
								<!-- 自动搜索，用于显示搜索结果 -->
								<div id="popup"
									style="border: 1px solid #c7c7c7; border-top: none; z-index: 1; position: absolute; overflow: auto;">
									<table class="autoSeek" id="complete_table">
										<tbody id="complete_body"></tbody>
									</table>
								</div>
							</div>
						</td>
						<td style="width: 60px;">
							论文名称<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="publicshedaacademicpapers.paperName" value='<s:property value="publicshedaacademicpapers.paperName"/>' id="paperName"/>
						</td>
						<td style="width: 60px;">
							论文类别<font color="red">*</font>
						</td>
						<td>
						
						<select size="1" name="publicshedaacademicpapers.periodicalType" id="periodicalType">
							
								<option value="SCI"
									<s:if test=' "SCI"== publicshedaacademicpapers.periodicalType'>selected="selected"</s:if>>
									SCI
								</option>
								<option value="A类"
									<s:if test=' "A类" == publicshedaacademicpapers.periodicalType'>selected="selected"</s:if>>
									A类
								</option>
								<option value="B类"
									<s:if test=' "B类" == publicshedaacademicpapers.periodicalType'>selected="selected"</s:if>>
									B类
								</option>
								<option value="EI"
									<s:if test=' "EI" == publicshedaacademicpapers.periodicalType'>selected="selected"</s:if>>
									EI
								</option>
								<option value="SSCI"
									<s:if test=' "SSCI" == publicshedaacademicpapers.periodicalType'>selected="selected"</s:if>>
									SSCI
								</option>
							</select>
						
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">影响因子:<font color="red">*</font></td>
					   <td>
							<input type="text" onkeyup="value=value.replace(/[^\d.]/g,'')" id="influenceFactors" name="publicshedaacademicpapers.influenceFactors" value='<s:property value="publicshedaacademicpapers.influenceFactors"/>'/>
						</td>
						
						<td style="width: 60px;">
							发表年份<font color="red">*</font>
						</td>
						<td colspan="3">
							<input type="text" id="year" maxlength="4" onkeypress="return Numbers(event)" name="publicshedaacademicpapers.year" value='<s:property value="publicshedaacademicpapers.year"/>'/>
						</td>
					</tr>
					<tr>
					<td style="width: 60px;">
							发表期刊信息
						</td>
						<td>
						<textarea name="publicshedaacademicpapers.periodicalInfo" id="periodicalInfo"><s:property value="publicshedaacademicpapers.periodicalInfo"/></textarea>
							</td>
					<td style="width: 60px;">
							备注
						</td>
						<td colspan="3">
							<textarea name="publicshedaacademicpapers.beizhu" ><s:property value="publicshedaacademicpapers.beizhu"/></textarea>
							
						</td>
					</tr>
					

				</tbody>
				<tfoot>
					<tr>
						<td colspan="99" >
							<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
							<a class="btn btn-primary add" id="save" href="javascript:modifyEdit()">保存</a>&nbsp;&nbsp;
						<span id="patentNumberError"></span>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</body>
</html>
