<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>竞赛项目查询</title>

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
				 			url: 'findMajorByDno.action',
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
				window.location.href = "searchContestToTCO.action?findContestModel.contestNo="+'${findContestModel.contestNo}'
					+"&findContestModel.contestName="+'${findContestModel.contestName}'
					+"&findContestModel.contestInclude="+'${findContestModel.contestInclude}'
					+"&findContestModel.contestLevelId="+'${findContestModel.contestLevelId}'
					+"&findContestModel.contestTypeId="+'${findContestModel.contestTypeId}'
					+"&findContestModel.tcollegeId="+'${findContestModel.tcollegeId}'
					+"&findContestModel.teacherId="+'${findContestModel.teacherId}'
					+"&findContestModel.teacherName="+'${findContestModel.teacherName}'
					+"&findContestModel.year="+'${findContestModel.year}'
					+"&findContestModel.scollegeId="+'${findContestModel.scollegeId}'
					+"&findContestModel.smajorId="+'${findContestModel.smajorId}'
					+"&findContestModel.sgrade="+'${findContestModel.sgrade}'
					+"&findContestModel.contestStatusId="+'${findContestModel.contestStatusId}'
					+"&rows=" + rows + "&page=" + page;
			}

			function setRows(rows) {
				window.location.href = "searchContestToTCO.action?findContestModel.contestNo="+'${findContestModel.contestNo}'
					+"&findContestModel.contestName="+'${findContestModel.contestName}'
					+"&findContestModel.contestInclude="+'${findContestModel.contestInclude}'
					+"&findContestModel.contestLevelId="+'${findContestModel.contestLevelId}'
					+"&findContestModel.contestTypeId="+'${findContestModel.contestTypeId}'
					+"&findContestModel.tcollegeId="+'${findContestModel.tcollegeId}'
					+"&findContestModel.teacherId="+'${findContestModel.teacherId}'
					+"&findContestModel.teacherName="+'${findContestModel.teacherName}'
					+"&findContestModel.year="+'${findContestModel.year}'
					+"&findContestModel.scollegeId="+'${findContestModel.scollegeId}'
					+"&findContestModel.smajorId="+'${findContestModel.smajorId}'
					+"&findContestModel.sgrade="+'${findContestModel.sgrade}'
					+"&findContestModel.contestStatusId="+'${findContestModel.contestStatusId}'
					+"&rows=" + rows.value;
			}


				//导出我的赛项列表
			function exportSubContestTExcel(){
				window.location.href = "exportSubContestTExcel.action?exportName=contestFindListImport"
					+"&findContestModel.contestNo="+'${findContestModel.contestNo}'
					+"&findContestModel.contestName="+'${findContestModel.contestName}'
					+"&findContestModel.contestInclude="+'${findContestModel.contestInclude}'
					+"&findContestModel.contestLevelId="+'${findContestModel.contestLevelId}'
					+"&findContestModel.contestTypeId="+'${findContestModel.contestTypeId}'
					+"&findContestModel.tcollegeId="+'${findContestModel.tcollegeId}'
					+"&findContestModel.teacherId="+'${findContestModel.teacherId}'
					+"&findContestModel.teacherName="+'${findContestModel.teacherName}'
					+"&findContestModel.year="+'${findContestModel.year}'
					+"&findContestModel.scollegeId="+'${findContestModel.scollegeId}'
					+"&findContestModel.smajorId="+'${findContestModel.smajorId}'
					+"&findContestModel.sgrade="+'${findContestModel.sgrade}'
					+"&findContestModel.contestStatusId="+'${findContestModel.contestStatusId}';
			}
		</script>

	</head>

	<body style="background-color:#e4dfd9" >

		<form action="searchContestToTCO.action" id="form1" name="form1" method="post" enctype="multipart/form-data">

			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							竞赛项目查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td style="width: 60px;">
							教师编号
						</td>
						<td>
							<input name="findContestModel.contestNo" value='<s:property value="findContestModel.contestNo"/>'
								type="text" />
						</td>
						<td style="width: 60px;">
							培训名称
						</td>
						<td>
							<input name="findContestModel.contestName" value='<s:property value="findContestModel.contestName"/>'
								type="text" />
						</td>
						<td>
							培训年份
						</td>
						<td>
							<select name="findContestModel.year"  id="year">
								<option value="">全部年份</option>
								<s:iterator value="yearList" var="yearvar">
									<option value="<s:property/>"
										<s:if test="#yearvar == findContestModel.year">selected="selected"</s:if>
									><s:property/></option>
								</s:iterator>
							</select>
						</td>

					</tr>
					<tr>
						<td style="width: 60px;">
							培训类型
						</td>
						<td>
							<select size="1" id="cLevel"
								name="findContestModel.contestLevelId">
								<option value="">全部类型</option>
								<s:iterator value="contestLevelList">
									<option value="<s:property value='contestLevelId'/>"
										<s:if test="contestLevelId == findContestModel.contestLevelId">selected="selected"</s:if>
									>
										<s:property value="contestLevelName" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width: 60px;">

						</td>
						<td>

						</td>
						<td>
						所在学院
						</td>
						<td>
							<select  size="1" id="coll"
								name="findContestModel.tcollegeId">
								<option value="">全部学院</option>
								<s:iterator value="collegeList">
									<option value="<s:property value='collegeId'/>"
										<s:if test="collegeId == findContestModel.tcollegeId">selected="selected"</s:if>
									>
										<s:property value="collegeName" />
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							行业培训
						</td>
						<td>
							<select>
								<option>全部</option>
								<option>是</option>
								<option>否</option>
							</select>
						</td>
						<td style="width: 60px;">
							实践教学培训
						</td>
						<td>
							<select>
								<option>全部</option>
								<option>是</option>
								<option>否</option>
							</select>
						</td>
						<td>
							所在专业
						</td>
						<td>
							<select  size="1" id="coll"
								name="findContestModel.tcollegeId">
								<option value="">全部学院</option>
								<s:iterator value="collegeList">
									<option value="<s:property value='collegeId'/>"
										<s:if test="collegeId == findContestModel.tcollegeId">selected="selected"</s:if>
									>
										<s:property value="collegeName" />
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

						</td>
						<td align="center">
						<a href="teacher_training-add.jsp"
							style="align right" class="btn btn-primary add" >添加</a>

						</td>
					</tr>
				</tfoot>
			</table>
		</form>

		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">进修培训查询结果</caption>
				<thead>
					<tr>
						<td>
							#
						</td>
						<td>
							教师编号
						</td>
						<td>
							教师姓名
						</td>
						<td>
							培训名称
						</td>
						<td>
							培训类型
						</td>
						<td>
							培训年份
						</td>
						<td>
							是否行业培训
						</td>
						<td>
							是否实践教学能力培训
						</td>
						<td>
							操作
						</td>
					</tr>
				</thead>
				<tbody>
					<s:if test="contestApplyList.size() == 0">
						<tr>
							<td colspan="99" style="text-align: center;">没有查询赛项信息！</td>
						</tr>
					</s:if>

				</tbody>
				<tfoot>
					<s:if test="contestApplyList.size() > 0">
					<tr>
						<td colspan="99">
							<s:include value="../common/paging.jsp"></s:include>
						</td>
					</tr>
					</s:if>
				</tfoot>
			</table>

	</body>
</html>
