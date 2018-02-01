<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>编辑教师进修信息</title>

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

<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/add.js">
</script>

		<!--<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/TnameByTno.js">
</script>
	--></head>

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
function modifyEdit() {

	/*if (document.getElementById("teacher").value.length != 0) {

		if (document.getElementById("year").value.length != 0) {
			if (confirm("是否保存")) {
				document.getElementById("editTeat").submit();
			}
		} else {
			alert("请输入培训年份");
		}

	} else {
		alert("教师信息错误");
	}*/

     var y=document.getElementById("year").value;
	 var reg = new RegExp("^[0-9]*$");  
     var obj = document.getElementById("year");  
     var objc=document.getElementById("trainDate"); 
     var Reg1 = /^(?:19|20)[0-9][0-9].(?:(?:0[1-9])|(?:1[0-2]))$/;
   if (document.getElementById("names").value.length ==0){
	        alert("教师编号选项不能为空");
			document.getElementById("names").focus();
	}
    else if (document.getElementById("trainName").value.length ==0){
	        alert("培训名称选项不能为空");
			document.getElementById("trainName").focus();
	}
	else if(!reg.test(obj.value)){  
        alert("年份选项只能输入4位数字!");  
    } 
   
     else if(y.length!=4){  
        alert("年份选项只能输入4位数字!");  
    } 
    else if(document.getElementById("trainDate").value.length!=0&&!document.getElementById("trainDate").value.match(Reg1)){
            alert("培训开始时间选项格式错误"+document.getElementById("trainDate").value.length);
			document.getElementById("trainDate").focus();
    }
    else if (document.getElementById("trainTime").value.length ==0){
    
	        alert("培训天数选项不能为空");
			document.getElementById("trainTime").focus();
	}
	
    else if (confirm("是否保存")) {
			document.getElementById("editTeat").submit();
	}
}

</script>
	<body onload="init();" style="background-color:#e4dfd9">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>查询获得教师发表科研论文信息
			<b class="tip"></b>编辑教师发表科研论文信息
		</div>

		<form action="editTeat.action" id="editTeat" method="post">


			<table class="table table-striped table-bordered table-condensed">
				<caption class="h_caption">
					教师发表科研论文信息编辑
				</caption>
				<tbody id="mytable">
					<tr>

						<!--<td style="width: 60px;">
							教师编号：
							<font color="red">*</font>
						</td>
						<td width="30%">
							<input type="text" name="teachertraining.teacher.tno" id="tno"
								value='<s:property value="teachertraining.teacher.tno" />'
								onblur="tnochange()" />
							<span id="tnoError"></span>
						</td>
						<td style="width: 60px;">
							教师姓名：
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="teacher" id="teacherName"
								value='<s:property value="teachertraining.teacher.tname"/>'
								readonly="readonly" />
						</td>
						-->
						<td style="width: 60px;">
							教师工号/姓名
							<font color="FF0000">*</font>
						</td>
						<td>
							<div id="abc" style="display: inline; float: left;">
								<input type="text" name="teachertraining.teacher.tno" 
									style="background: transparent;" placeholder="输入教工号或姓名搜索"
									autocomplete="off" id="names" onkeyup="findNames('${userId}')"
									onfocus="findNames('${userId}')"  value='<s:property value="teachertraining.teacher.tno" />'/>
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
							培训名称：<font color="red">*</font>
						</td>
						<td>
						
							<input type="text" name="teachertraining.trainContend"
								value='<s:property value="teachertraining.trainContend"/>' id="trainName" />
						</td>
						<td style="width: 60px;">
							培训类型：<font color="red">*</font>
						</td>
						<td>			
							<select size="1" name="teachertraining.trainType" id="trainType">
							
								<option value="进修"
									<s:if test=' "进修"== teachertraining.trainType'>selected="selected"</s:if>>
									进修
								</option>
								<option value="攻读学位"
									<s:if test=' "攻读学位"== teachertraining.trainType'>selected="selected"</s:if>>
									攻读学位
								</option>
								<option value="交流出访"
									<s:if test=' "交流出访"== teachertraining.trainType'>selected="selected"</s:if>>
									交流出访
								</option>
								<option value="教学能力培训"
									<s:if test=' "教学能力培训" == teachertraining.trainType'>selected="selected"</s:if>>
									教学能力培训
								</option>
								<option value="其他"
									<s:if test=' "其他" == teachertraining.trainType'>selected="selected"</s:if>>
									其他
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							培训年份：<font color="red">*</font>
						</td>
						<td>
							<input type="text" id="year" maxlength="4" name="teachertraining.year"
								value='<s:property value="teachertraining.year" />' />
						</td>
						<td style="width: 60px;">
							培训天数:<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="teachertraining.trainTime"
								value='<s:property value="teachertraining.trainTime"/>' id="trainTime" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>

						</td>
						<td style="width: 60px;">
							境内外培训：
						</td>
						<td>
							<select size="1" name="teachertraining.trainingArea" id="trainingArea">
							
								<option value="境内"
									<s:if test=' "境内" == teachertraining.trainingArea'>selected="selected"</s:if>>
									境内
								</option>
								<option value="境外"
									<s:if test=' "境外" == teachertraining.trainingArea'>selected="selected"</s:if>>
									境外
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							培训开始时间：
						</td>
						<td>
							<input type="text" name="teachertraining.trainDate" id="trainDate"
								value='<s:property value="teachertraining.trainDate"/>' />
							<span style="color:red">(格式：　2012.09)</span>
						</td>
						
						<td>
							获得证书:
						</td>
						<td>
							<!--<input type="text" name="teachertraining.getCertificate"
								value='<s:property value="teachertraining.getCertificate"/>' />
							--><select size="1" name="teachertraining.getCertificate" id="getCertificate">
								<option value="是"
									<s:if test=' "是" == teachertraining.getCertificate'>selected="selected"</s:if>>
									是
								</option>
								<option value="否"
									<s:if test=' "否" == teachertraining.getCertificate'>selected="selected"</s:if>>
									否
								</option>
							</select>
						</td>
						<td style="width: 60px;">
							是否是行业培训:
						</td>
						<td>
							
								<select size="1" name="teachertraining.isIndustryTrain" id="isIndustryTrain">
							
								<option value="是"
									<s:if test=' "是" == teachertraining.isIndustryTrain'>selected="selected"</s:if>>
									是
								</option>
								<option value="否"
									<s:if test=' "否" == teachertraining.isIndustryTrain'>selected="selected"</s:if>>
									否
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							是否是实践能力教学能力培训
						</td>
						<td>
							
								<select size="1" name="teachertraining.isPraticeTeachTraining" id="isPraticeTeachTraining">
								<option value="否"
									<s:if test=' "否" == teachertraining.isPraticeTeachTraining'>selected="selected"</s:if>>
									否
								</option>
								<option value="是"
									<s:if test=' "是" == teachertraining.isPraticeTeachTraining'>selected="selected"</s:if>>
									是
								</option>
								
							</select>
						</td>
						<td style="width: 60px;">
							发证机构:
						</td>
						<td colspan="3">
							<input type="text" name="teachertraining.givenCertificateDepart"
								value='<s:property value="teachertraining.givenCertificateDepart"/>' />
						</td>
					</tr>				
				</tbody>
				<tfoot>
					<tr>
						<td colspan="99">
							<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
							<a class="btn btn-primary add" id="save"
								href="javascript:modifyEdit()">保存</a>&nbsp;&nbsp;
							<span id="patentNumberError"></span>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</body>
</html>
