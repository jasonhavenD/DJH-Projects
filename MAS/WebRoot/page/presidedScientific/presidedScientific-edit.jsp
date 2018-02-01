<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>编辑主持科研项目信息</title>

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
<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/cal.js">
			
</script>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/ajax/uniqueness.js"></script>


	<!--<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/ajax/TnameByTno.js"></script>
	
	--><script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/ajax/PreScient_uniqueness.js"></script>
	<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/add.js">
</script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/ajax/add.js"></script>
<script type="text/javascript">
/*function freshTname(tno){
	var xmlHttpRequest;
	
	if(window.XMLHttpRequest) {
		//FireFow, NetScape, Chrome, Safari等
		
		xmlHttpRequest = new XMLHttpRequest();
	} else if(window.ActiveXObject) { //IE
		try {
			xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(e) {
			xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
	
	if(xmlHttpRequest) {
		xmlHttpRequest.open('POST', "ajaxTnoToTname", true);
		request.onreadystatechange = function(data) {
			
		}
	}
}*/

/*function yearLength(){
	if(document.getElementById("year").value.length != 4){
		alert("请输入4位的年份信息");
	}
}*/
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
	var regx = /^\d+(?:\.\d{0,2})?$/;
     var y=document.getElementById("year").value;
     var projecTime=document.getElementById("projecTime").value;
     var acceptenceDate=document.getElementById("acceptenceDate").value;
    if (document.getElementById("projectNo").value.length ==0){
	        alert("项目编号选项不能为空");
			document.getElementById("projectNo").focus();
	}
	else if (document.getElementById("projectNoError").innerText =="项目编号已存在"){
	        alert("项目编号已存在");
			document.getElementById("proName").focus();
	}
    else if (document.getElementById("proName").value.length ==0){
	        alert("项目名称选项不能为空");
			document.getElementById("proName").focus();
	}
	
	else if(y.length==0){  
        alert("立项年份选项不能为空!"); 
        document.getElementById("year").focus(); 
    } 
    
     else if(y.length!=4){  
        alert("立项年份选项只能输入4位数字!");  
        document.getElementById("year").focus(); 
    } 
	else if (document.getElementById("names").value.length ==0){
	        alert("教师编号选项不能为空");
			document.getElementById("names").focus();
			
	}
    else if (document.getElementById("tution").value.length ==0){
	        alert("经费选项不能为空");
			document.getElementById("tution").focus();
	}else if (!document.getElementById("tution").value.match(regx)){
	        alert("经费选项格式错误");
			document.getElementById("tution").focus();
	}
	else if(projecTime.length==0){  
        alert("立项时间选项不能为空!"); 
        document.getElementById("projecTime").focus(); 
    } 
    
     else if(projecTime.length!=4){  
        alert("立项时间选项只能输入4位数字!");  
        document.getElementById("projecTime").focus(); 
    } 
    else if(acceptenceDate.length==0){  
        alert("验收时间选项不能为空!"); 
        document.getElementById("year").focus(); 
    } 
    
     else if(acceptenceDate.length!=4){  
        alert("验收时间选项只能输入4位数字!");  
        document.getElementById("year").focus(); 
    } 
	else if(projecTime>acceptenceDate){
	      alert("验收时间不能早于立项时间");
		  document.getElementById("acceptenceDate").focus();
	}
    else if (confirm("是否保存")) {
			document.getElementById("editPres").submit();
		}
}

</script>
</head>
	<body onload="init();" style="background-color:#e4dfd9">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>查询主持科研项目信息
			<b class="tip"></b>编辑主持科研项目信息
		</div>

		<form action="editPres.action" id="editPres" method="post">


			<table class="table table-striped table-bordered table-condensed">
				<caption class="t_caption">
					主持科研项目信息编辑
				</caption>
				<tbody id="mytable">
					<tr>
						<td style="width: 60px;">
							项目编号：
							<font color="red">*</font>
						</td>
						<td>
							<s:if test="pres==null">
								<input type="text" name="pres.projectNo" onblur="prescieblur();" id="projectNo"/>
							</s:if>
							<s:else>
								<input name="pres.projectNo" id="projectNo" value='<s:property value="pres.projectNo"/>' readonly="readonly"/>
							</s:else>
							<span id="projectNoError"></span>
						</td>
						<td style="width: 60px;">
							项目名称：
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="pres.projectName" value='<s:property value="pres.projectName"/>' id="proName"/>
						</td>
						<td style="width: 60px;">
							立项年份：
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" id="year" name="pres.year" value='<s:property value="pres.year"/>' onkeypress="return Numbers(event)"/>
						</td>
					</tr>
					<tr>
						<!--<td style="width: 60px;">
							教师编号：
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="pres.teacher.tno" id="tno" value='<s:property value="pres.teacher.tno" />' onblur="tnochange()"/>
							<span id="tnoError" style="width: 15px;text-align:left;display:inline-block;"></span>
						</td>
						<td style="width: 60px;">
							教师姓名：
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="teacherName" id="teacherName" value='<s:property value="pres.teacher.tname"/>' readonly="readonly"/>
						</td>
						-->
						<td style="width: 60px;">
							教师工号/姓名
							<font color="FF0000">*</font>
						</td>
						<td>
							<div id="abc" style="display: inline; float: left;">
								<input type="text" name="pres.teacher.tno" 
									placeholder="输入教工号或姓名搜索"
									autocomplete="off" id="names" onkeyup="findNames('${userId}')"
									onfocus="findNames('${userId}')"  value='<s:property value="pres.teacher.tno" />'/>
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
							参与教师人数：
						</td>
						<td>
							<input type="text"  id="tNum" name="pres.partTeacherNum" onkeypress="return Numbers(event)" value='<s:property value="pres.partTeacherNum"/>'/>
						</td>
						<td style="width: 60px;">
							项目类型：
							<font color="red">*</font>
						</td>
						<td>
							<select id="prot" name="pres.projecType">

								<option value="一般"
								<s:if test='"一般"=pres.projecType' >selected="selected"</s:if>>
									一般
								</option>
								<option value="重点"
								<s:if test='"重点"=pres.projecType' >selected="selected"</s:if>>
									重点
								</option>
								<option value="重点攻关"
								<s:if test='"重点攻关"=pres.projecType' >selected="selected"</s:if>>
									重点攻关
								</option>
								<option value="培育" 
								    <s:if test='"培育"=pres.projecType' >selected="selected"</s:if>>
									培育
								</option>
							</select>
						</td>
						</tr>
					<tr>
						<td style="width: 60px;">
							项目级别：
							<font color="red">*</font>
						</td>
						<td>
							<select id="proj" name="pres.projecJibie">
								<option value="国家级" 
								    <s:if test='"国家级"=pres.projecJibie' >selected="selected"</s:if>>
									国家级
								</option>
								<option value="省部级" 
								    <s:if test='"省部级"=pres.projecJibie' >selected="selected"</s:if>>
									省部级
								</option>
								<option value="其他" 
								    <s:if test='"其他"=pres.projecJibie' >selected="selected"</s:if>>
									其他
								</option>
							</select>
						</td>
						<td style="width: 60px;">
							经费：
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" id="tution" name="pres.cost" value='<s:property value="pres.cost" />' />
							<span style="color:red">(单位：万元，最多小数点后两位)</span>
						</td>
						<td style="width: 60px;">
							立项时间：
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="pres.projecTime" id="projecTime" onclick="return Numbers(event)"  value='<s:property value="pres.projecTime"/>' />
						</td>
						</tr>
					<tr>
						<!-- date类型input在chrome中有日历原生样式，但在其他浏览器中并无样式。。。 -->
						<td style="width: 60px;">
							验收时间：
						</td>
						<td>
							<input type="text" name="pres.acceptenceDate" id="acceptenceDate" onclick="return Numbers(event)" value='<s:property value="pres.acceptenceDate"/>' />
						</td>
						<td style="width: 60px;">
							备注
						</td>
						<td colspan="5">
							<textarea rows="5" cols="99" name="pres.beizhu">${request.pres.beizhu}</textarea>
						</td>
					</tr>

				</tbody>
				<tfoot>
					<tr>
						<td colspan="99" >
							<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
							<a class="btn btn-primary add" id="save" href="javascript:modifyEdit()">保存</a>&nbsp;&nbsp;
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</body>
</html>
