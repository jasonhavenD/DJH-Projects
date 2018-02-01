<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>编辑教师发表教改论文信息</title>

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

<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/ajax/add.js"></script>

	<!--<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/ajax/TnameByTno.js"></script>--></head>

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

function modifyEdit(){
    
    if (document.getElementById("names").value.length ==0){
	        alert("教师编号选项不能为空");
			document.getElementById("names").focus();
	}
   else if (document.getElementById("paperName").value.length ==0){
	        alert("论文名称选项不能为空");
			document.getElementById("paperName").focus();
	}
	else if(document.getElementById("year").value.length==0){  
        alert("发表年份选项不能为空!"); 
        document.getElementById("year").focus(); 
    } 
    
     else if(document.getElementById("year").value.length!=4){  
        alert("发表年份选项只能输入4位数字!");  
        document.getElementById("year").focus(); 
    } 
	
    else if (confirm("是否保存")) {
			document.getElementById("editPep").submit();
		}
	
}
</script>
	<body onload="init();" style="background-color:#e4dfd9">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>查询获得教师发表教改论文信息
			<b class="tip"></b>编辑教师发表教改论文信息
		</div>

		<form action="editPep.action" id="editPep" method="post">


			<table class="table table-striped table-bordered table-condensed">
				<caption class="h_caption">
					教师发表教改论文信息编辑
				</caption>
				<tbody id="mytable">
					<tr>

						<!--<td style="width: 60px;">
							教师编号:
							<font color="red">*</font>
						</td>
						<td width="30%">
							<input type="text" name="publicshedarevolutionpapers.teacher.tno" id="tno" value='<s:property value="publicshedarevolutionpapers.teacher.tno" />' onblur="tnochange()"/>
							<span id="tnoError"></span>
						</td>
						<td style="width: 60px;">
							教师姓名:<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="teacherName" id="teacherName" value='<s:property value="publicshedarevolutionpapers.teacher.tname"/>' readonly="readonly"/>
						</td>
						-->
						<td style="width: 60px;">
							教师工号/姓名
							<font color="FF0000">*</font>
						</td>
						<td>
							<div id="abc" style="display: inline; float: left;">
								<input type="text" name="publicshedarevolutionpapers.teacher.tno" 
									style="background: transparent;" placeholder="输入教工号或姓名搜索"
									autocomplete="off" id="names" onkeyup="findNames('${userId}')"
									onfocus="findNames('${userId}')"  value='<s:property value="publicshedarevolutionpapers.teacher.tno" />'/>
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
							论文名称:<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="publicshedarevolutionpapers.revoPaperName" value='<s:property value="publicshedarevolutionpapers.revoPaperName"/>' id="paperName"/>
						</td>
					</tr>
					<tr>
						
						<td style="width: 60px;">
							论文类别:<font color="red">*</font>
						</td>
						<td>
							<select size="1" name="publicshedarevolutionpapers.periodicalType" id="periodicalType">
							<option value="">
									--选择--
								</option>
								
								<option value="A类"
									<s:if test=' "A类" == publicshedarevolutionpapers.periodicalType'>selected="selected"</s:if>>
									A类
								</option>
								<option value="B类"
									<s:if test=' "B类" == publicshedarevolutionpapers.periodicalType'>selected="selected"</s:if>>
									B类
								</option>
								<option value="公开发表"
									<s:if test=' "公开发表"== publicshedarevolutionpapers.periodicalType'>selected="selected"</s:if>>
									公开发表
								</option>
							</select>
						</td>
						<td style="width: 60px;">
							发表年份:<font color="red">*</font>
						</td>
						<td>
							<input type="text" id="year" maxlength="4" onkeypress="return Numbers(event)"  name="publicshedarevolutionpapers.year" value='<s:property value="publicshedarevolutionpapers.year"/>'/>
						</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
					<td style="width: 60px;">
							发表期刊信息:
						</td>
						<td>
						<textarea name="publicshedarevolutionpapers.revoPeriodicalInfo"  id="revoPeriodicalInfo"><s:property value="publicshedarevolutionpapers.revoPeriodicalInfo"/></textarea>
						</td>
					<td style="width: 60px;">
							备注
						</td>
						<td>
						<textarea name="publicshedarevolutionpapers.beizhu" ><s:property value="publicshedarevolutionpapers.beizhu"/></textarea>						
						</td>
						<td></td>
						<td></td>
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
