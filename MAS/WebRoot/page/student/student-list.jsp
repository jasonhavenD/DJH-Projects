<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>学生</title>

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
		<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/ajax/MajorByDno.js"></script>
<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/timeManage.js">
</script>
		<script type="text/javascript">
			//日历插件
			$(function() {
				$(".datepicker").datepicker();
			})
			
		//导入弹出框
			function upFile() {
				document.getElementById("iframe").src = "attachFileList.action?importName=stud";
				
				$('#alert-win').dialog( {
					width : 450,
					height : 240,
					buttons : {
						"关闭" : function() {
							findContestApply();
							$(this).dialog("close");
						}
					}
				});
			}		
			//查询
			function findContestApply(){
				document.getElementById("form1").submit();
			}
			function findContestInfo(stuNumber){
				window.location.href = "editToStudent.action?stuNumber="+stuNumber;
			}	
			function jump(op) {
				if ("first" == op) {
					page = 1;
				} else if ("up" == op) {
					page = parseInt(page) - 1;
				} else if ("down" == op) {
					page = parseInt(page) + 1;
				} else if ("last" == op) {
					page = totalPage;
				} else {
					var jumpPage = parseInt(document.getElementById("jumpPage").value);
					if (jumpPage <= totalPage && jumpPage > 0)
						page = jumpPage;
					else
						alert("超出页码范围");
				}
				var name = ""+'${studentmodel.name}'; 
				name = encodeURI(name); 
				name = encodeURI(name); 
				var isRoll = ""+'${studentmodel.isRoll}'; 
				isRoll = encodeURI(isRoll); 
				isRoll = encodeURI(isRoll); 
				var isInSchool = ""+'${studentmodel.isInSchool}'; 
				isInSchool = encodeURI(isInSchool); 
				isInSchool = encodeURI(isInSchool); 
				window.location.href = "findStudent.action?studentmodel.id="+'${studentmodel.id}'
					+"&studentmodel.name="+name
					+"&studentmodel.majorId="+'${studentmodel.majorId}'
					+"&studentmodel.departmentId="+'${studentmodel.departmentId}'
					+"&studentmodel.year="+'${studentmodel.year}'
					+"&studentmodel.national.nationNnumber="+'${studentmodel.national.nationNnumber}'
					+"&studentmodel.isRoll="+isRoll
					+"&studentmodel.isInSchool="+isInSchool
					+"&rows=" + rows + "&page=" + page;
			}
			
			function setRows(rows) {
			var name = ""+'${studentmodel.name}'; 
				name = encodeURI(name); 
				name = encodeURI(name); 
				var isRoll = ""+'${studentmodel.isRoll}'; 
				isRoll = encodeURI(isRoll); 
				isRoll = encodeURI(isRoll); 
				var isInSchool = ""+'${studentmodel.isInSchool}'; 
				isInSchool = encodeURI(isInSchool); 
				isInSchool = encodeURI(isInSchool); 
				window.location.href = "findStudent.action?studentmodel.id="+'${studentmodel.id}'
					+"&studentmodel.name="+name
					+"&studentmodel.majorId="+'${studentmodel.majorId}'
					+"&studentmodel.departmentId="+'${studentmodel.departmentId}'
					+"&studentmodel.year="+'${studentmodel.year}'
					+"&studentmodel.isRoll="+isRoll
					+"&studentmodel.isInSchool="+isInSchool
					+"&studentmodel.national.nationNnumber="+'${studentmodel.national.nationNnumber}'
					+"&rows=" + rows.value;
			}
			
			
				//导出我的赛项列表
			function exportSubContestTExcel(){
				var name = ""+'${studentmodel.name}'; 
				name = encodeURI(name); 
				name = encodeURI(name); 
				var isRoll = ""+'${studentmodel.isRoll}'; 
				isRoll = encodeURI(isRoll); 
				isRoll = encodeURI(isRoll); 
				var isInSchool = ""+'${studentmodel.isInSchool}'; 
				isInSchool = encodeURI(isInSchool); 
				isInSchool = encodeURI(isInSchool); 
				window.location.href = "exportSubContestTExcel.action?exportName=stud"
					+"&studentmodel.id="+'${studentmodel.id}'
					+"&studentmodel.name="+name
					+"&studentmodel.majorId="+'${studentmodel.majorId}'
					+"&studentmodel.departmentId="+'${studentmodel.departmentId}'
					+"&studentmodel.year="+'${studentmodel.year}'
					+"&studentmodel.national.nationNnumber="+'${studentmodel.national.nationNnumber}'
					+"&studentmodel.isRoll="+isRoll
					+"&studentmodel.isInSchool="+isInSchool;
			}
			$(document).ready(function() {
			timeManage();
	// ------------------------------	
		//角色判断
		var rol = $("#rol").val();
		var totalRows = $("#totalRows").val();
		//if (rol == 3) {
			//$("#attach").hide();//隐藏导入
			//$("#add").hide();//添加
			//for ( var i = 0; i < 10; i++) {
				//$(".edit").hide();
				//$(".del").hide();
			//}
		//}
		if (rol == 2) {
			$("#add").hide();//添加
			for ( var i = 0; i < 10; i++) {
				$(".del").hide();
			}
		}
	});
			
		</script>

	</head>

	<body style="background-color:#e4dfd9">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>学生信息
			<b class="tip"></b>查询学生信息
		</div>
		
		<form action="findStudent.action?page=1&rows=10" id="form1" name="form1" method="post" enctype="multipart/form-data">
			
			<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							学生信息查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td style="width: 60px;">
							学号
						</td>
						<td>
							<input name="studentmodel.Id" value='<s:property value="studentmodel.Id"/>'
								type="text" />
						</td>
						<td style="width: 60px;">
							学生姓名
						</td>
						<td>
							<input name="studentmodel.Name" value='<s:property value="studentmodel.Name"/>'
								type="text" />
						</td>
						<td>
							入学年份
						</td>
						<td>
							<select name="studentmodel.year"  id="year">
								<option value="">全部年份</option>
								<s:iterator value="yearList" var="yearvar">
									<option value="<s:property/>"
										<s:if test="#yearvar == studentmodel.year">selected="selected"</s:if>>
										<s:property/>
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							民族
						</td>
						<td>
							<select size="1" name="studentmodel.national.nationNnumber" id="nation">
								<option value="">全部民族</option>
								<s:iterator value="nationalList" var="nationalvar">
									<option value="<s:property value='nationNnumber'/>"
										<s:if test="#nationalvar.nationNnumber == studentmodel.national.nationNnumber">selected="selected"</s:if>>																
										<s:property value="nationName" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							年级
						</td>
						<td>
							<select name="studentmodel.grade"  id="grade">
								<option value="">全部年级</option>
								<s:iterator value="gradeList" var="gradevar">
									<option value="<s:property/>"
										<s:if test="#gradevar == studentmodel.grade">selected="selected"</s:if>
									><s:property/></option>
								</s:iterator>
							</select>
						</td>
						<td>
						所在学院
						</td>
						<td>
							<select  size="1" id="coll"
								name="studentmodel.departmentId" class="department" onchange="collchange();">
								<option value="">全部学院</option>
								<s:iterator value="departmentList" var="departmentvar">
									<option value="<s:property value='dno'/>"
										<s:if test="#departmentvar.dno == studentmodel.departmentId"></s:if>>
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							是否有学籍
						</td>
						<td>
							<select size="1" name="studentmodel.isRoll" id="isRoll">
								<option value="">全部选项</option>
								<option value="有学籍"
									<s:if test="'有学籍'==studentmodel.isRoll">selected="selected"</s:if>>
									有学籍
								</option>
								<option value="无学籍"
									<s:if test="'无学籍'==studentmodel.isRoll">selected="selected"</s:if>>
									无学籍
								</option>
							</select>
						</td>
						<td>
							是否在校
						</td>
						<td>
							<select size="1" name="studentmodel.isInSchool" id="isInSchool">
								<option value="">全部选项</option>
								<option value="在校"
									<s:if test="'在校'==studentmodel.isInSchool">selected="selected"</s:if>>
									在校
								</option>
								<option value="不在校"
									<s:if test="'不在校'==studentmodel.isInSchool">selected="selected"</s:if>>
									不在校
								</option>
							</select>
						</td>
						<td>
							所在专业
						</td>
						<td>
							<select size="1" name="studentmodel.majorId" id="major">
								<option value="">全部专业</option>
								<s:iterator value="majorList" var="majorvar">
									<option value="<s:property value='mno'/>"
										<s:if test="#majorvar.mno == studentmodel.majorId"></s:if>>																
										<s:property value="mname" />
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>
					

				</tbody>
				<tfoot>
					<tr>
						<td colspan="5">
							<a href="javascript:findContestApply();"
								class="btn btn-primary add">查询</a>&nbsp;&nbsp;
							<a href="#" onclick="exportSubContestTExcel()"
								class="btn btn-primary add">导出学生信息列表</a>
								&nbsp;&nbsp;<span style="color:red;">(先查询，再导出)</span>
						
						</td>
						<td align="center">
						<span id="add">
						<a href="addToStudent.action?number=0"
							style="align right" class="btn btn-primary add" >添加</a>							
							</span>
						<!--选择导入的文件 --> <a
								id="attach" href="javascript:void(0);"
								onclick="upFile();return false;" class="btn btn-primary add">导入</a>
							
						</td>
					</tr>
				</tfoot>
			</table>
		</form>	
		
		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">学生信息查询结果</caption>				
				<thead>
					<tr>
						<td>
							#
						</td>
						
						<td>
							学号
						</td>
						<td>
							学生姓名
						</td>
						<td>
							性别
						</td>
						<td>
							民族
						</td>
						<td>
							专业
						</td>
						
						<td>
							出生日期
						</td>
						<td>
							年级
						</td>
						<td>
							班级
						</td>
						<td>
							入学年份
						</td>
						<td>
							毕业日期
						</td>
						<td>
							学制
						</td>
						<td>
							是否有学籍
						</td>
						<td>
							是否在校
						</td>
						<td>
							当前学生状态
						</td>
						
						<td>
							操作
						</td>
					</tr>
				</thead>
				<tbody>
					<s:if test="studentList.size() == 0">
						<tr>
							<td colspan="99" style="text-align: center;">没有查询到学生信息！</td>
						</tr>
					</s:if>
					<s:iterator value="studentList" id="student" status="L">
						<tr>
							<td>
								<s:property value="#L.index+1"/>	
							</td>
							<td>
								<s:property value="stuNumber" />
							</td>
							<td width="11%">
								<s:property value="stuName" />
							</td>
							<td>
								<s:property value="sex"/>
							</td>
							<td width="5%">
								<s:property value="national.nationName" />
							</td>
							<td width="11%">
								<s:property value="major.mname"/>
							</td>

							<td>
								
								<s:date name="birth" format="yyyy-MM-dd" />
							</td>
							<td>
								<s:property value="grade" />
								
							</td>
							<td>
								<s:property value="class_"/>
								
							</td>
							<td>
								<s:property value="year"/>
							</td>
							<td>
								
								<s:date name="graduationDate" format="yyyy-MM-dd" />
							</td>
							<td>
								<s:property value="eductionalSystme"/>
							</td>
							<td>
								<s:property value="isRoll"/>
							</td>
							<td>
								<s:property value="isInSchool"/>
							</td>
							<td>
								<s:property value="status"/>
							</td>
							
							<td>	<span class="edit">							
								<a class="btn btn-mini btn-primary" href="editToStudent.action?stuNumber=<s:property value="stuNumber"/>">
									修改
								</a></span>
								<span class="del">
								<a class="btn btn-mini btn-primary" onclick="return confirm('是否删除')" href="deleteStudent.action?stuNumber=<s:property value="stuNumber"/>">
									删除
								</a></span>
							</td>
						</tr>
					</s:iterator>
				</tbody>
				<tfoot>
					<s:if test="studentList.size() > 0">
					
					<tr>
						<td colspan="99">
							<s:include value="../common/paging.jsp"></s:include>
						</td>
					</tr>
					</s:if>
				</tfoot>
			</table>
		<div id="alert-win" title="附件" style="display: none;">
			<iframe style="border: 0; width: 100%; height: 100%;" id="iframe"
				src="">
			</iframe>
		</div>
	</body>
</html>
