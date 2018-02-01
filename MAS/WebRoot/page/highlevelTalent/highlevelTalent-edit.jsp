<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>编辑高层次人才信息</title>

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
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/ajax/uniqueness.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/ajax/add.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/ajax/MajorByDno.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/ajax/TnameByTno.js"></script></head>
    
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

function modify(){
	
	if (document.getElementById("names").value.length ==0){
	        alert("教师编号选项不能为空"); 
			document.getElementById("names").focus();
	}
	else if(document.getElementById("year").value.length ==0){  
        alert("年份选项不能为空!");  
        document.getElementById("year").focus();
    }else if(document.getElementById("year").value.length!=4){  
        alert("年份选项只能输入4位数字!");
         document.getElementById("year").focus();  
    } 
    else if(confirm("是否保存")) {
			document.getElementById("editHigh").submit();
	}

}


</script>
	<body onload="init();" style="background-color:#e4dfd9">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>查询高层次人才信息
			<b class="tip"></b>编辑高层次人才信息
		</div>

		<form action="editHigh.action" id="editHigh" method="post">


			<table class="table table-striped table-bordered table-condensed">
				<caption class="t_caption">
					高层次人才信息
				</caption>
				<thead>
					<tr>
						<td colspan="99">
							编辑高层次人才信息
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>

						<!--<td style="width: 60px;">
							教师编号:
							<font color="red">*</font>
						</td>
						<td>
							<s:if test='high==null'>
								<input type="text" name="high.teacher.tno" id="tno" value='<s:property value="high.teacher.tno" />' onblur="tnochange()"/>
							</s:if>
							<s:else>
								<input type="text" name="high.teacher.tno" id="tno" value='<s:property value="high.teacher.tno" />' readonly="readonly" />
							</s:else>
							
							<span id="tnoError" style="width: 15px;text-align:left;display:inline-block;"></span>
						</td>
						<td style="width: 60px;">
							教师姓名:
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" name="teacher" id="teacherName" value='<s:property value="high.teacher.tname"/>' readonly="readonly"/>
						</td>
						-->
						<td style="width: 60px;">
							教师工号/姓名
							<font color="FF0000">*</font>
						</td>
						<td>
							<div id="abc" style="display: inline; float: left;">
								<input type="text" name="high.teacher.tno" 
									style="background: transparent;" placeholder="输入教工号或姓名搜索"
									autocomplete="off" id="names" onkeyup="findNames('${userId}')"
									onfocus="findNames('${userId}')"  value='<s:property value="high.teacher.tno" />'/>
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
							人才类型:
							<font color="red">*</font>
						</td>
						<td>
							<select name="high.TalentType"  id="talentType">
								<s:iterator value="talentTypeList" var="talentType">
									<option value="<s:property value='talentType'/>"
										<s:if test="#talentType == high.TalentType">selected="selected"</s:if>>
										<s:property value='talentType'/>
									</option>
									
								</s:iterator>
							</select>
						</td>
						<td style="width: 60px;">
							人才级别:
							<font color="red">*</font>
						</td>
						<td>
							<!--<input type="text" name="high.talentLevel" value='<s:property value="high.talentLevel"/>'/>
							--><select name="high.talentLevel"  id="high.talentLevel">
									<option value="国家级"
										<s:if test='"国家级"== high.talentLevel'>selected="selected"</s:if>>
										国家级
									</option>
									<option value="省级"
										<s:if test='"省级"== high.talentLevel'>selected="selected"</s:if>>
										省级
									</option>
									<option value="校级"
										<s:if test='"校级"== high.talentLevel'>selected="selected"</s:if>>
										校级
									</option>
							</select>
						</td>
						</tr>
						<!--<td style="width: 60px;">
							所在学院:
							<font color="red">*</font>
						</td>
						<td>
							<select name="high.teacher.major.department.departmentId"  id="coll" onchange="collchange();">
								<s:iterator value="departmentList" var="department">
									<option value="<s:property value='dno'/>" disabled="disabled"
										<s:if test="#department.dname == high.teacher.major.department.dname">selected="selected"</s:if>>
										<s:property value='dname'/>
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width: 60px;">
							所在专业:
							<font color="red">*</font>
						</td>
						<td>
							<select name="high.teacher.major.mname"  id="major">
								<s:iterator value="majorList" var="major">
									<option value="<s:property value='mno'/>" disabled="disabled"
										<s:if test="#major.mname == high.teacher.major.mname">selected="selected"</s:if>>
										<s:property value='mname'/>
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>
					<tr>-->
					<tr>
						<td style="width: 60px;">
							获得年份:
							<font color="red">*</font>
						</td>
						<td>
							<input type="text" id="year" name="high.year"  onkeypress="return Numbers(event)" value='<s:property value="high.year"/>'/>
						</td>
						<td style="width: 60px;">
							研究领域
						</td>
						<td>
							<input type="text" name="high.rearchField" value='<s:property value="high.rearchField" />'/>
						</td>					
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="99" >
							<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
							<a class="btn btn-primary add" id="save" href="javascript:modify()">保存</a>&nbsp;&nbsp;
						<span id="patentNumberError"></span>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</body>
</html>
