<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>主持科研项目查询</title>

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
			
			$(document).ready(function(){
			timeManage();
			    $("#mytable tr:even td").css("background","#fff");
			    $("#mytable tr:even td").attr("bg","#fff");
			    $("#mytable tr:odd td").attr("bg","#fff");
			    $("#mytable tr td").hover(function(){
			        $(this).parent().find("td").css("background","#fff")
			        },function(){
			            var bgc = $(this).attr("bg");
			            $(this).parent().find("td").css("background",bgc)
			            });
		   
		    })
		    
		    
		     $(document).ready(function() {
		        // ------------------------------	     
				 $(".college").change(
				 	function(){

				 		$('#major option').remove();
				 		
				 		$.ajax({
				 			type: "POST",
				 			url: 'findByCollegeIdListMajorStu.action',
				 			data: 'collegeId=' + $(this).val(),
				 			success : function(jsonArray) {
				 				
				 				var json = eval("("+jsonArray+")")
		                        var porHtml = "<option value=''>全部专业</option>";
		                        for (var i = 0; i < json.length; i++) {
		                            porHtml += "<option value="+json[i].majorId+" >"+json[i].majorName+"</option>";
		                        }
		                        $("#major").append(porHtml);
		                    },
		                    error : function(XMLHttpRequest, textStatus, errorThrown) {
		                        alert('通信失败:' + errorThrown);
		                    }
				 		});
				 	});
				});
					
			//查询赛项
			function findContestApply(){
				document.getElementById("form1").submit();
			}
			
			//查看赛项详细信息
			function findContestInfo(conId){
				window.location.href = "searchContestInfoToTCO.action?contestId="+conId;
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
	var ptname = ""+'${pmodel.tname}'; 
	var pname = ""+'${pmodel.name}'; 
	var pprojecType = ""+'${pmodel.projecType}'; 
	var pprojecJibie = ""+'${pmodel.projecJibie}'; 
	ptname = encodeURI(ptname); 
 	ptname = encodeURI(ptname);
 	pname = encodeURI(pname); 
 	pname = encodeURI(pname);
 	pprojecType = encodeURI(pprojecType); 
 	pprojecType = encodeURI(pprojecType); 
 	pprojecJibie = encodeURI(pprojecJibie); 
 	pprojecJibie = encodeURI(pprojecJibie);
				window.location.href = "findPres.action?pmodel.id=" + '${pmodel.id}'
				+ "&pmodel.name="+pname 
				+ "&pmodel.tno="+'${pmodel.tno}' 
				+ "&pmodel.tname="+ptname
				+ "&pmodel.departmentId=" + '${pmodel.departmentId}'
				+ "&pmodel.majorId=" + '${pmodel.majorId}'
				+ "&pmodel.year=" + '${pmodel.year}'
				+ "&pmodel.projecType=" + pprojecType
				+ "&pmodel.projecJibie=" + pprojecJibie
				+"&rows=" + rows + "&page=" + page;
			}
			
			function setRows(rows) {
			var ptname = ""+'${pmodel.tname}'; 
	var pname = ""+'${pmodel.name}'; 
	var pprojecType = ""+'${pmodel.projecType}'; 
	var pprojecJibie = ""+'${pmodel.projecJibie}'; 
	ptname = encodeURI(ptname); 
 	ptname = encodeURI(ptname);
 	pname = encodeURI(pname); 
 	pname = encodeURI(pname);
 	pprojecType = encodeURI(pprojecType); 
 	pprojecType = encodeURI(pprojecType); 
 	pprojecJibie = encodeURI(pprojecJibie); 
 	pprojecJibie = encodeURI(pprojecJibie);
				window.location.href = "findPres.action?pmodel.id=" + '${pmodel.id}'
				+ "&pmodel.name="+pname 
				+ "&pmodel.tno="+'${pmodel.tno}' 
				+ "&pmodel.tname="+ptname
				+ "&pmodel.departmentId=" + '${pmodel.departmentId}'
				+ "&pmodel.majorId=" + '${pmodel.majorId}'
				+ "&pmodel.year=" + '${pmodel.year}'
				+ "&pmodel.projecType=" + pprojecType
				+ "&pmodel.projecJibie=" + pprojecJibie
				+ "&rows=" + rows.value+"&page=1";
			}
			
				//导出
			function exportExcel(){
			var ptname = ""+'${pmodel.tname}'; 
	var pname = ""+'${pmodel.name}'; 
	var pprojecType = ""+'${pmodel.projecType}'; 
	var pprojecJibie = ""+'${pmodel.projecJibie}'; 
	ptname = encodeURI(ptname); 
 	ptname = encodeURI(ptname);
 	pname = encodeURI(pname); 
 	pname = encodeURI(pname);
 	pprojecType = encodeURI(pprojecType); 
 	pprojecType = encodeURI(pprojecType); 
 	pprojecJibie = encodeURI(pprojecJibie); 
 	pprojecJibie = encodeURI(pprojecJibie);
				window.location.href = "exportExcel.action?exportName=presidedScientific"
				+ "&presmodel.id=" + '${pmodel.id}'
				+ "&presmodel.name="+pname 
				+ "&presmodel.tno="+'${pmodel.tno}' 
				+ "&presmodel.tname="+ptname
				+ "&presmodel.departmentId=" + '${pmodel.departmentId}'
				+ "&presmodel.majorId=" + '${pmodel.majorId}'
				+ "&presmodel.year=" + '${pmodel.year}'
				+ "&presmodel.projecType=" + pprojecType
				+ "&presmodel.projecJibie=" + pprojecJibie;
			
			}
//导入
//上传附件弹出框
function upFile() {
	document.getElementById("iframe").src = "attachFileList.action?importName=pres";
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
$(document).ready(function() {
	// ------------------------------	
		//角色判断
		var rol = $("#rol").val();
		var totalRows = $("#totalRows").val();
		if (rol == 2||rol == 3||rol == 4||rol == 5) {
			$("#clear").hide();//隐藏清空
		}
		//if ( rol == 3) {
			//$("#attach").hide();//隐藏导入
			//$("#add").hide();//隐藏导入
			//for ( var i = 0; i < totalRows; i++) {
				//$(".edit").hide();
				//$(".del").hide();

			//}
		//}
	});
//参数obj为input file对象
function importExcel() {
	window.location.href = "importExcel.action?importName=presidedScientific&excelFile="+getPath(document.getElementById("excelFile"));
}
		</script>

</head>

	<body style="background-color:#e4dfd9">
		
		<form action="findPres.action?page=1&rows=10" id="form1" name="form1" method="post" enctype="multipart/form-data">
			<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							主持科研项目查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td style="width: 60px;">
							项目编号
						</td>
						<td>
							<input name="pmodel.Id"	type="text" value="<s:property value="pmodel.Id" />"/>
						</td>
						<td style="width: 60px;">
							项目名称
						</td>
						<td>
							<input name="pmodel.Name" type="text"  value="<s:property value="pmodel.Name" />"/>
						</td>
						<td> 
							立项年份
						</td>
						<td>
							<select name="pmodel.year"  id="year">
								<option value="">选择年份</option>
								<s:iterator value="yearList" var="yearvar">
									<option value="<s:property/>"
									<s:if test="#yearvar == pmodel.year">selected="selected"</s:if>>
										<s:property/>
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							教师编号
						</td>
						<td>
							<select  size="1" id="tno"
								name="pmodel.Tno" class="teacher">
								<option value="">选择教师</option>
								<s:iterator value="teacherList" var="teavar">
									<option value="<s:property value='tno'/>"
									<s:if test="#teavar.tno == pmodel.Tno">selected="selected"</s:if>>																	
										<s:property value="tno" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width: 60px;">
							教师名称
						</td>
						<td>
							<select  size="1" id="teacher"
								name="pmodel.Tname" class="teacher">
								<option value="">选择教师</option>
								<s:iterator value="teacherList" var="teavar">
									<option value="<s:property value='tname'/>"
									<s:if test="#teavar.tname == pmodel.Tname">selected="selected"</s:if>>																	
										<s:property value="tname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							所在学院
						</td>
						<td>
							<select  size="1" id="coll"
								name="pmodel.departmentId" class="department" onchange="collchange();">
								<option value="">选择学院</option>
								<s:iterator value="departmentList" var="departmentvar">
									<option value="<s:property value='dno'/>"
									<s:if test="#departmentvar.dno ==pmodel.departmentId"></s:if>>															
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							项目类型
						</td>
						<td>
							<select name="pmodel.ProjecType"  id="projecType">
								<option value="">选择类型</option>
								<s:iterator value="projecTypeList" var="projecTypevar">
									<option value="<s:property/>"
									<s:if test="#projecTypevar == pmodel.ProjecType">selected="selected"</s:if>>
										<s:property/>
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width: 60px;">
							项目级别
						</td>
						<td>
							<select name="pmodel.ProjecJibie"  id="projecJibie">
								<option value="">选择级别</option>
								<s:iterator value="projecJibieList" var="proJivar">
									<option value="<s:property/>"
									<s:if test="#proJivar == pmodel.ProjecJibie">selected="selected"</s:if>>
										<s:property/>
									</option>
								</s:iterator>
							</select>
						</td>
						<td> 
							所在专业 
						</td>
						<td>
							<select  size="1" id="major"
								name="pmodel.majorId" class="major">
								<option value="">选择专业</option>
								<s:iterator value="majorList" var="majorvar">
									<option value="<s:property value='mno'/>"
									<s:if test="#majorvar.mno == pmodel.majorId"></s:if>>															
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
							<a href="#" onclick="exportExcel()"
								class="btn btn-primary add">导出主持科研项目列表</a>
								&nbsp;&nbsp;<span style="color:red;">(先查询，再导出)</span>
						
						</td>
						<td align="center">
						<a id="add" href="editToPres.action?Pno=0"
							style="align right" class="btn btn-primary add" >添加</a>	
						<a id="attach" href="javascript:void(0);"
								onclick="upFile();return false;" class="btn btn-primary add">导入</a>
						<!--清空所有主持科研项目信息 -->
						<span class="del"><a id="clear" href="clearPres.action"
						onclick="return confirm('确认删除所有主持科研项目信息吗？');" class="btn btn-primary add">清空所有主持科研项目信息</a></span>	
						</td>
					</tr>
				</tfoot>
			</table>
		</form>	
		
		<table style="white-space: normal;" class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">科研项目信息查询结果</caption>				
				<thead>
					<tr>
						<td width="3%">
							#
						</td>
						<td width="5%">
							项目编号
						</td>
						<td width="20%">
							项目名称
						</td>
						<td width="5%">
							教师姓名
						</td>
						<td width="6%">
							项目类型
						</td>
						<td width="6%">
							项目级别
						</td>
						<td width="7%">
							所在学院
						</td>
						<td width="7%">
							所在专业
						</td>
						<td width="5%">
							立项年份
						</td>
						<td width="5%">
							参与教师人数
						</td>
						<td width="7%">
							经费（万元）
						</td>
						<td width="10%">
							备注
						</td>
						<td width="6%">
							操作
						</td>
					</tr>
				</thead>
				<tbody>
					<s:if test="presList.size() == 0">
						<tr>
							<td colspan="99" style="text-align: center;">没有查询到主持科研项目信息！</td>
						</tr>
					</s:if>
					<s:iterator value="presList" id="pres" status="L">
						<tr>
							<td>
								<s:property value="#L.index+1"/>	
							</td>
							<td>
								<s:property value="projectNo"/>
							</td>
							<td style="word-break:break-all">
								<s:property value="projectName"/>
							</td>
							<td>
								<s:property value="teacher.tname" />
							</td>
							<td>
								<s:property value="projecType"/>
							</td>
							<td>
								<s:property value="projecJibie"/>
							</td>
							<td>
								<s:property value="teacher.major.department.dname"/>
							</td>
							<td>
								<s:property value="teacher.major.mname"/>
							</td>
							<td>
								<s:property value="year"/>
							</td>
							<td>
								<s:property value="partTeacherNum"/>
							</td>
							<td>
								<s:property value="cost"/>
							</td>
							<td>
								<s:property value="beizhu"/>
							</td>
							<td>	
							<span class="edit">							
								<a class="btn btn-mini btn-primary" href="editToPres.action?Pno=<s:property value="projectNo"/>">
									修改
								</a></span>
								<span class="del">
								<a class="btn btn-mini btn-primary" href="deletePres.action?Pno=<s:property value="projectNo"/>" onclick="return confirm('是否删除')">
									删除
								</a></span>
							</td>
						</tr>
					</s:iterator>
				</tbody>
				<tfoot>
					<s:if test="presList.size() > 0">
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
