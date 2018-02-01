<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>高层次人才查询</title>

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
	
		<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/ajax/TnameByTno.js"></script></head>
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
	var hname = ""+'${hmodel.name}'; 
	var htalentType = ""+'${hmodel.talentType}'; 
	var hrearchField = ""+'${hmodel.rearchField}'; 
	hname = encodeURI(hname); 
 	hname = encodeURI(hname);
 	htalentType = encodeURI(htalentType); 
 	htalentType = encodeURI(htalentType);
 	hrearchField = encodeURI(hrearchField); 
 	hrearchField = encodeURI(hrearchField); 
				window.location.href = "findHigh.action?hmodel.name="+hname 
				+ "&hmodel.id=" + '${hmodel.id}'
				+ "&hmodel.departmentId=" + '${hmodel.departmentId}'
				+ "&hmodel.majorId=" + '${hmodel.majorId}'
				+ "&hmodel.year=" + '${hmodel.year}'
				+ "&hmodel.talentType=" + htalentType
				+ "&hmodel.rearchField=" + hrearchField
					+"&rows=" + rows + "&page=" + page;
			}
			
			function setRows(rows) {
				var hname = ""+'${hmodel.name}'; 
	var htalentType = ""+'${hmodel.talentType}'; 
	var hrearchField = ""+'${hmodel.rearchField}'; 
	hname = encodeURI(hname); 
 	hname = encodeURI(hname);
 	htalentType = encodeURI(htalentType); 
 	htalentType = encodeURI(htalentType);
 	hrearchField = encodeURI(hrearchField); 
 	hrearchField = encodeURI(hrearchField); 
				window.location.href = "findHigh.action?hmodel.name="+hname 
				+ "&hmodel.id=" + '${hmodel.id}'
				+ "&hmodel.departmentId=" + '${hmodel.departmentId}'
				+ "&hmodel.majorId=" + '${hmodel.majorId}'
				+ "&hmodel.year=" + '${hmodel.year}'
				+ "&hmodel.talentType=" + htalentType
				+ "&hmodel.rearchField=" + hrearchField
				+ "&rows=" + rows.value+"&page=1";
			}
			
				//导出
			function exportExcel(){
			var hname = ""+'${hmodel.name}'; 
	var htalentType = ""+'${hmodel.talentType}'; 
	var hrearchField = ""+'${hmodel.rearchField}'; 
	hname = encodeURI(hname); 
 	hname = encodeURI(hname);
 	htalentType = encodeURI(htalentType); 
 	htalentType = encodeURI(htalentType);
 	hrearchField = encodeURI(hrearchField); 
 	hrearchField = encodeURI(hrearchField); 
				window.location.href = "exportExcel.action?exportName=highlevelTalent"
				+ "&hmodel.name="+hname 
				+ "&hmodel.id=" + '${hmodel.id}'
				+ "&hmodel.departmentId=" + '${hmodel.departmentId}'
				+ "&hmodel.majorId=" + '${hmodel.majorId}'
				+ "&hmodel.year=" + '${hmodel.year}'
				+ "&hmodel.talentType=" + htalentType
				+ "&hmodel.rearchField=" + hrearchField;
			
			}
//导入
//上传附件弹出框
function upFile() {
	document.getElementById("iframe").src = "attachFileList.action?importName=high";
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
		if (rol == 2) {
			$("#attach").hide();//隐藏导入
			$("#add").hide();//隐藏导入
			for ( var i = 0; i < totalRows; i++) {
				$(".edit").hide();
				$(".del").hide();

			}
		}
	});
//参数obj为input file对象
function importExcel() {
	window.location.href = "importExcel.action?importName=high&excelFile="+getPath(document.getElementById("excelFile"));
}
		</script>

</head>

	<body style="background-color:#e4dfd9">
		
		<form action="findHigh.action?page=1&rows=10" id="form1" name="form1" method="post" enctype="multipart/form-data">
			<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							高层次人才查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td style="width: 60px;">
							教师编号
						</td>
						<td>
							<input type="text" name="hmodel.Id"
								value='<s:property value="hmodel.Id"/>' />
						</td>
						<td style="width: 60px;">
							教师姓名
						</td>
						<td>
							<input type="text" name="hmodel.Name"
								value='<s:property value="hmodel.Name"/>' />
						</td>
						<td> 
							获得年份
						</td>
						<td>
							<select name="hmodel.year"  id="year">
								<option value="">选择年份</option>
								<s:iterator value="yearList" var="yearvar">
									<option value="<s:property/>"
									<s:if test="#yearvar == hmodel.year">selected="selected"</s:if>>	
										<s:property/>
									</option>
								</s:iterator>
							</select>
						</td>
						
					</tr>
					<tr>
						<td style="width: 60px;">
							人才类型
						</td>
						<td>
							<select name="hmodel.TalentType"  id="talentType">
								<option value="">选择类型</option>
								<s:iterator value="talentTypeList" var="talentvar">
									<option value="<s:property/>"
									<s:if test="#talentvar == hmodel.TalentType">selected="selected"</s:if>>	
										<s:property/>
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width: 60px;">
							研究领域
						</td>
						<td>
							<select name="hmodel.RearchField"  id="rearchField">
								<option value="">选择类型</option>
								<s:iterator value="rearchFieldList" var="rearchvar">
									<option value="<s:property/>"
									<s:if test="#rearchvar == hmodel.RearchField">selected="selected"</s:if>>	
										<s:property/>
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							所在学院
						</td>
						<td>
							<select  size="1" id="coll"
								name="hmodel.departmentId" class="department" onchange="collchange();">
								<option value="">选择学院</option>
								<s:iterator value="departmentList" var="departmentvar">
									<option value="<s:property value='dno'/>"
									<s:if test="#departmentvar.dno == hmodel.departmentId"></s:if>>															
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="4"></td>
						<td> 
							所在专业 
						</td>
						<td>
							<select  size="1" id="major"
								name="hmodel.majorId" class="major">
								<option value="">全部专业</option>
								<s:iterator value="majorList" var="majorvar">
									<option value="<s:property value='mno'/>"
									<s:if test="#majorvar.mno == hmodel.majorId"></s:if>>																
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
								class="btn btn-primary add">导出高层次人才列表</a>
								&nbsp;&nbsp;<span style="color:red;">(先查询，再导出)</span>
						
						</td>
						<td align="center">
						<a id="add" href="editToHigh.action?Hno=0"
							style="align right" class="btn btn-primary add" >添加</a>	
						<a id="attach" href="javascript:void(0);"
								onclick="upFile();return false;" class="btn btn-primary add">导入</a>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>	
		
		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">人才查询结果</caption>				
				<thead>
					<tr>
						<td width="5%">
							#
						</td>
						<td width="12%">
							教师姓名
						</td>
						<td width="20%">
							人才类型
						</td>
						<td width="10%">
							人才级别
						</td>
						<td width="15%">
							研究领域
						</td>
						<td width="12%">
							所在学院
						</td>
						<td width="10%">
							所在专业
						</td>
						<td width="8%">
							获得年份
						</td>
						<td>
							操作
						</td>
					</tr>
				</thead>
				<tbody>
					<s:if test="highList.size() == 0">
						<tr>
							<td colspan="99" style="text-align: center;">没有查询到高层次人才信息！</td>
						</tr>
					</s:if>
					<s:iterator value="highList" id="high" status="L">
						<tr>
							<td>
								<s:property value="#L.index+1"/>	
							</td>
							<td>
								<s:property value="teacher.tname" />
							</td>
							<td>
								<s:property value="talentType"/>
							</td>
							<td>
								<s:property value="talentLevel"/>
							</td>
							<td>
								<s:property value="rearchField"/>
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
							<span class="edit">							
								<a class="btn btn-mini btn-primary" href="editToHigh.action?Hno=<s:property value="hno"/>">
									修改
								</a></span><span class="del">
								<a class="btn btn-mini btn-primary" href="deleteHigh.action?Hno=<s:property value="hno"/>" onclick="return confirm('是否删除')">
									删除
								</a></span>
							</td>
						</tr>
					</s:iterator>
				</tbody>
				<tfoot>
					<s:if test="highList.size() > 0">
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
