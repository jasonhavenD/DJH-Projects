<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>指标F值基本信息</title>

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
			src="${pageContext.request.contextPath}/Scripts/observer.js">
</script>


		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />


		<script type="text/javascript">
			//日历插件
			$(function() {
				$(".datepicker").datepicker();
			})

			$(document).ready(function(){
			    $("#mytable tr:even td").css("background","#fff");
			    $("#mytable tr:even td").attr("bg","#fff");
			    $("#mytable tr:odd td").attr("bg","#fff");
			    $("#mytable tr td").hover(function(){
			        $(this).parent().find("td").css("background","#fff")
			        },function(){
			            var bgc = $(this).attr("bg");
			            $(this).parent().find("td").css("background",bgc)
			            });

			    var rol = $("#rol").val();
				if (rol == 6) {
				$("#attach").hide();//隐藏导入
				$("#add").hide();//隐藏导入
				for ( var i = 0; i < totalRows; i++) {
				$(".edit").hide();
				$(".del").hide();
				$("add").hide();
				}
		}

		    })



			//查询赛项
			function findContestApply(){
				document.getElementById("form1").submit();
			}

			//查看赛项详细信息
			function findContestInfo(id){
				window.location.href = "getFvalueById.action?id="+id;
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
				window.location.href = "getFvalueByName.action?fName="+'${fName}'
					+ "&rows=" + rows + "&page=" + page;
			}

			function setRows(rows) {
				window.location.href = "getFvalueByName.action?fName="+'${fName}'
					+ "&rows=" + rows.value;
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
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>F值基本信息
			<b class="tip"></b>查询F基本信息
		</div>

		<form action="getFvalueByName.action?page=1&rows=10" id="form1" name="form1" method="post" enctype="multipart/form-data">

			<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							F值信息查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<!--<td style="width: 60px;">
							F值编号
						</td>
						<td>
							<input name="id" type="text" />
						</td>
						--><td style="width: 60px;">
							F值名称
						</td>
						<td>
							<input name="fName" type="text" />
						</td>
						</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="5">
							<a href="javascript:findContestApply();"
								class="btn btn-primary add">查询F值信息</a>&nbsp;&nbsp;
							<a href="editToFuntionargs.action?id=0" id = "add"
								class="btn btn-primary add">添加F值信息</a>

						</td>
						<!--<td align="center">
						<a href="editToFuntionargs.action?id=0"
							style="align right" class="btn btn-primary add" >添加</a>
						<a href="#" onclick="exportSubContestTExcel()"
							style="align right" class="btn btn-primary add" >导入</a>

						</td>
					--></tr>
				</tfoot>
			</table>
		</form>

		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">F值基本信息查询结果</caption>
				<thead>
					<tr>
						<td>
							#
						</td>
						<td>
							编号
						</td>
						<td>
							名称
						</td>
						<td>
							F值
						</td>
						<td>
							说明
						</td>
						<td>
							操作
						</td>
					</tr>
				</thead>
				<tbody>
					<s:if test="funvalueList.size() == 0">
						<tr>
							<td colspan="99" style="text-align: center;">没有查询到信息！</td>
						</tr>
					</s:if>
					<s:iterator value="funvalueList" id="funtionargs" status="L">
						<tr>
							<td>
								<s:property value="#L.index+1"/>
							</td>
							<td>
								<s:property value="id" />
							</td>
							<td>
								<s:property value="funName" />
							</td>
							<td>
								<s:property value="funValue" />
							</td>
							<td>
								<s:property value="funExplation"/>
							</td>
							<td>

							<span class="edit"> <a class="btn btn-mini btn-primary" href="editToFuntionargs.action?id=<s:property value="id"/>">
									修改
								</a> </span>

							<span class="edit"> <a class="btn btn-mini btn-primary" href="deleteFuntionargs.action?id=<s:property value="id"/>">
									删除
								</a> </span>

							<!--
								<a class="btn btn-mini btn-primary" href="editToFuntionargs.action?id=<s:property value="id"/>">
									修改
								</a>
								<a class="btn btn-mini btn-primary" href="deleteFuntionargs.action?id=<s:property value="id"/>">
									删除
								</a>
								 -->
							</td>
						</tr>
					</s:iterator>
				</tbody>
				<tfoot>
					<s:if test="funvalueList.size() > 0">
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
