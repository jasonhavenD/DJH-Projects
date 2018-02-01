<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>实践教学情况查询</title>

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
			$(document).ready(function() {
	// ------------------------------
		//角色判断
		var rol = $("#rol").val();
		var totalRows = $("#totalRows").val();
		if (rol == 4) {
			$("#attach").hide();//隐藏导入
			$("#add").hide();//隐藏导入
			for ( var i = 0; i < totalRows; i++) {
				$(".edit").hide();
				$(".del").hide();

			}
		}
		if (rol != 1) {
			$("#calculate").hide();//隐藏计算
			$("#addall").hide();//隐藏添加上一年度的 所有数据
		}
	});
			//查看赛项详细信息
			function findContestInfo(conId){
		body style="background-color:#e4dfd9" ndow.location.href = "searchContestInfoToTCO.action?contestId="+conId;
			}
				//上传附件弹出框
function upFile() {
	document.getElementById("iframe").src = "attachFileList.action?importName=pratea";
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
				window.location.href = "findTraininguseinginformation.action?tuimodel.majorId="+'${tuimodel.majorId}'

		         	+"&tuimodel.resourceConstructionNumber="+'${tuimodel.resourceConstructionNumber}'
					+"&tuimodel.experimentalEquipmentMean="+'${tuimodel.experimentalEquipmentMean}'
					+"&tuimodel.laboratorySatisfactionRate="+'${tuimodel.laboratorySatisfactionRate}'
					+"&tuimodel.experimentNumber="+'${tuimodel.experimentNumber}'
					+"&tuimodel.schooBaseNumber="+'${tuimodel.schooBaseNumber}'
					+"&tuimodel.outBaseNumber="+'${tuimodel.outBaseNumber}'
					+"&tuimodel.schooBaseRate="+'${tuimodel.schooBaseRate}'
					+"&tuimodel.outBaseRate="+'${tuimodel.outBaseRate}'
					+"&tuimodel.year="+'${tuimodel.year}'
					+"&rows=" + rows + "&page=" + page;
			}

			function setRows(rows) {
				window.location.href = "findTraininguseinginformation.action?tuimodel.majorId="+'${tuimodel.majorId}'

					+"&tuimodel.resourceConstructionNumber="+'${tuimodel.resourceConstructionNumber}'
					+"&tuimodel.experimentalEquipmentMean="+'${tuimodel.experimentalEquipmentMean}'
					+"&tuimodel.laboratorySatisfactionRate="+'${tuimodel.laboratorySatisfactionRate}'
					+"&tuimodel.experimentNumber="+'${tuimodel.experimentNumber}'
					+"&tuimodel.schooBaseNumber="+'${tuimodel.schooBaseNumber}'
					+"&tuimodel.outBaseNumber="+'${tuimodel.outBaseNumber}'
					+"&tuimodel.schooBaseRate="+'${tuimodel.schooBaseRate}'
					+"&tuimodel.outBaseRate="+'${tuimodel.outBaseRate}'
					+"&tuimodel.year="+'${tuimodel.year}'
					+"&rows=" + rows.value+"&page=1";
			}


				//导出我的赛项列表
			function exportSubContestTExcel(){
				window.location.href = "exportSubContestTExcel.action?exportName=tui"
				   +"&tuimodel.majorId="+'${tuimodel.majorId}'
				   +"&tuimodel.resourceConstructionNumber="+'${tuimodel.resourceConstructionNumber}'
					+"&tuimodel.experimentalEquipmentMean="+'${tuimodel.experimentalEquipmentMean}'
					+"&tuimodel.laboratorySatisfactionRate="+'${tuimodel.laboratorySatisfactionRate}'
					+"&tuimodel.experimentNumber="+'${tuimodel.experimentNumber}'
					+"&tuimodel.schooBaseNumber="+'${tuimodel.schooBaseNumber}'
					+"&tuimodel.outBaseNumber="+'${tuimodel.outBaseNumber}'
					+"&tuimodel.schooBaseRate="+'${tuimodel.schooBaseRate}'
					+"&tuimodel.outBaseRate="+'${tuimodel.outBaseRate}'
					+"&tuimodel.year="+'${tuimodel.year}'

			}
		</script>

	</head>

	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业数据采集
			<b class="tip"></b>实践教学情况查询
		</div>

		<form action="findTraininguseinginformation.action?page=1&rows=10" id="form1" name="form1" method="post" enctype="multipart/form-data">
			<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							实践教学情况查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td>
							所在学院
						</td>
						<td>
							<select size="1" id="coll" name="tuimodel.departmentId"
								onchange="collchange();" class="department">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList" var="dvar">
									<option value="<s:property value='dno'/>"
										<s:if test="#dvar.dno==tuimodel.departmentId"></s:if>>
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							所在专业
						</td>
						<td colspan="3">
							<select size="1" name="tuimodel.majorId" id="major">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList" var="mvar">
									<option value="<s:property value='mno'/>" <s:if test="#mvar.mno==tuimodel.majorId"></s:if>>
										<s:property value="mname" />
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							年份
						</td>
						<td colspan="5">
							<select name="tuimodel.year" id="year">
								<option value="">
									全部年份
								</option>
								<s:iterator value="yearList" var="yearvar">
									<option value="<s:property/>"
										<s:if test="#yearvar == tuimodel.year">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>

					</tr>

				</tbody>


				<tfoot>
					<tr>
						<td colspan="2">
							<a href="javascript:findContestApply();"
								class="btn btn-primary add">查询</a>&nbsp;&nbsp;
							<a href="#" onclick="exportSubContestTExcel()"
								class="btn btn-primary add">导出</a>
								&nbsp;&nbsp;<span style="color:red;">(先查询，再导出)</span>
						</td>
						<td align="center">
						<span id="add">
						<a href="editTotraininguseinginformation.action?praId=0"
							style="align right" class="btn btn-primary add" >添加</a>
						<!--选择导入的文件 -->
							<a id="attach" href="javascript:void(0);"
								onclick="upFile();return false;" class="btn btn-primary add">导入</a>
							</span>
						</td>

						<td>
							<span class="del"><a href="addAll.action" id="addall"
							style="align right" class="btn btn-primary add"  onclick="return confirm('确认删除所有实践教学基本情况信息吗？');">清空</a>
						</td></span>

						<td>
							<span class="del"><a href="calculate.action" id="calculate" onclick="return confirm('确认进行实验设备生均值及实验开放人时数的计算吗？');"
							style="align right" class="btn btn-primary add" >计算</a></span>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>

		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">实践教学基本情况查询结果</caption>
				<thead>
					<tr>
						<td>
							#
						</td>

						<td>
							专业名称
						</td>

						<td>
							共建教学资源数
						</td>
						<td>
							实验设备生均值
						</td>

						<td>
							实验室满足率
						</td>
						<td>
							实验开放人时数

						</td>
						<td>
							校内基地数
						</td>
						<td>
							校外基地数
						</td>
						<td>
							校内基地满足率
						</td>
						<td>
							校外基地满足率
						</td>
						<td>
							 年份

						</td>
						<td>
							操作
						</td>
					</tr>
				</thead>
				<tbody>
					<s:if test="tuiList.size() == 0">
						<tr>
							<td colspan="99" style="text-align: center;">没有查询信息！</td>
						</tr>
					</s:if>
					<s:iterator value="tuiList" status="L">
						<tr>
							<td>
								<s:property value="#L.index+1"/>
							</td>

							<td>
								<s:property value="major.mname"/>
							</td>
							<td>
								<s:property value="resourceConstructionNumber"/>
							</td>

							<td>
								<s:property value="experimentalEquipmentMean"/>
							</td>

							<td>
								<s:property value="laboratorySatisfactionRate"/>
							</td>
							<td>
								<s:property value="experimentNumber"/>
							</td>
							<td>
								<s:property value="schooBaseNumber"/>
							</td>
							<td>
								<s:property value="outBaseNumber"/>
							</td>
							<td>
								<s:property value="schooBaseRate"/>
							</td>
							<td>
								<s:property value="outBaseRate"/>
							</td>
							<td>
								<s:property value="year"/>
							</td>

							<td>		<span class="edit">
								<a class="btn btn-mini btn-primary" href="editTotraininguseinginformation.action?praId=<s:property value="praId"/>">
									修改
								</a>
								</span>
								<span class="del">
								<a class="btn btn-mini btn-primary" href="deleteTraininguseinginformation.action?praId=<s:property value="praId"/>" onclick="return confirm('是否删除')">
									删除
								</a></span>
							</td>
						</tr>
					</s:iterator>
				</tbody>
				<tfoot>
					<s:if test="tuiList.size()> 0">
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
