<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>导出数据分析评估报告</title>

		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/admin-all.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/other.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/jsmind.css" />
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/jquery-1.7.2.js">
		</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/jsmind.js">
		</script>
		<style type="text/css">
			${demo.css}
		</style>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/jquery-ui-1.8.22.custom.min.js">
</script>
<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/MajorByDno.js">
</script>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
		<script type="text/javascript">
</script>
<style>
	/*分页*/
	.pagination{
		margin-top: -4px;
		margin-bottom: -16px;

	}
	.pagination ul {
		display: inline;
		margin: 0;
		padding:0;
	}
	.pagination ul li {
	  	display: inline;
	}
	.pagination ul li a, .pagination ul li span {
		float: left;
		padding: 2px 12px;
		line-height: 20px;
		text-decoration: none;
		border-top:none;
		border-bottom:none;
		border-left:none;
		margin-bottom: -4px;
	}
	.pagination ul li a:hover{
		color: red;
	}
</style>
<script type="text/javascript">
	function exportReport(){
		window.location.href = "exportReport.action";
	}
	function exportReportWorld(){
	var mno = $("#major").val();
		window.location.href = "exportReportWorld.action?mno="+mno;
	}
	function findReport(){
		window.location.href = "exportReportPage.action?mno="+$("#major").val();
	}
	$(function(){

	});
</script>
</head>
	<body style="background-color:#e4dfd9" >
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/highcharts/highcharts.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/highcharts/modules/exporting.js"></script>
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>评估管理
			<b class="tip"></b>导出数据分析报告
		</div>
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99" style="height:30px; font-size: 15px; vertical-align: middle;">
							导出数据分析报告
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
					<td style="width:10px;">
						所在学院
					</td>
					<td style="width:10px;">
						<select size="1" id="coll" name="cmodel.departmentId" onchange="collchange();">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList" var="departmentvar">
									<option value="<s:property value='dno'/>"
										<s:if test="#departmentvar.dno == cmodel.departmentId">selected="selected"</s:if>>
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width:10px;">
							所在专业
						</td>
						<td  style="width:10px;">
							<select size="1" name="basemodel.majorId" id="major">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList">
									<option value="<s:property value='mno'/>">
										<s:property value="mname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
						<a class="btn btn-primary add" id="search" onclick="javascript:findReport();">查询</a>
						</td>

						<td>
						<a class="btn btn-primary add" id="search" onclick="javascript:exportReport();">导出</a>
						</td>
						<td>
						<a class="btn btn-primary add" id="search" onclick="javascript:exportReportWorld();">导出数据分析报告</a>
						</td>

					</tr>

				</tbody>
			</table>
	<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				专业评估报告信息列表
			</caption>
			<thead>
				<tr>
					<td>
						#
					</td>
					<td>
						专业名称
					</td>
					<td>
						指标名称
					</td>
					<td>
						指标权重
					</td>
					<td>
						指标性质
					</td>
					<td>
						最高分
					</td>
					<td>
						最低分
					</td>
					<td>
						平均分
					</td>
					<td>
						本专业得分
					</td>
					<td>
						总和排名
					</td>
					<td>
						分类排名
					</td>
				</tr>
			</thead>
			<tbody>
				<s:if test="findList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有查询到相关信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="findList" id="target" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td>
							<s:property value="mname" />
						</td>
						<td>
							<s:property value="indicatorName" />
						</td>
						<td>
							<s:property value="indicatorWeight" />
						</td>
						<td>
							<s:property value="indicatorType" />
						</td>
						<td>
							<s:property value="max" />
						</td>
						<td>
							<s:property value="min" />
						</td>
						<td>
							<s:property value="avg" />
						</td>
						<td>
							<s:property value="score" />
						</td>
						<td>
							<s:property value="ranking" />
						</td>
						<td>
							<s:property value="classifyRanking" />
						</td>

					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="findList.size() > 0">
					<tr>
						<td colspan="99">
							<div class="pagination">
	<ul>
		<li class="disabled" >
			<a style="color: black;padding-left: 5px;">每页显示条数：
				<select id="select_plan_rows_id" onchange="setRows(this)" name="rows" style="margin-top: -3px;padding: 0px;height: 22px;width: 80px;border:1px solid #bac7d2;">
					<option value="1" >1</option>
					<option value="2" >2</option>
					<option value="5" >5</option>
					<option value="10">10</option>
					<option value="20" >20</option>
					<option value="30" >30</option>
					<option value="40" >40</option>
					<option value="50" >50</option>
					<option value="100" selected="selected">100</option>
				</select>
			</a>
		</li>
		<li class="disabled">
			<a style="color: black;">共&nbsp;94&nbsp;条记录</a>
		</li>
		<li class="disabled">
			<a style="color: black;">当前显示：&nbsp;1/1&nbsp;页</a>
		</li>

		<li id="pageOp1" class="first-child">
			<a id="href1" href="javascript:jump('first')">首页</a>
		</li>
		<li id="pageOp2">
			<a id="href2" href="javascript:jump('up')">上一页</a>
		</li>
		<li id="pageOp3">
			<a id="href3" href="javascript:jump('down')">下一页</a>
		</li>
		<li id="pageOp4" class="last-child">
			<a id="href4" href="javascript:jump('last')">尾页</a>
		</li>
		<li class="active">
			<span style="color:black;">跳转到
			<input id="jumpPage" name="page" style="margin-top: -3px; width: 40px; height: 16px;ime-mode:disabled;border:1px solid #95CACA;"
				onkeydown="if(event.keyCode==13) event.keyCode=9" onKeyPress="if ((event.keyCode<48 || event.keyCode>57))
				event.returnValue=false" />
			页</span>
		</li>
		<li>
			<a href="javascript:jump('jump')">跳转</a>
		</li>
	</ul>
</div>
						</td>
					</tr>
				</s:if>
			</tfoot>
		</table>
</body>

</html>
