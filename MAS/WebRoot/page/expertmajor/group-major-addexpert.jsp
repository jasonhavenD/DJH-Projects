<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>添加专家入组</title>

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
		<script type="text/javascript">
		//日历插件
		$(function() {
			$(".datepicker").datepicker();
		})

		$(document).ready(function() {
			$("#mytable tr:even td").css("background", "#fff");
			$("#mytable tr:even td").attr("bg", "#fff");
			$("#mytable tr:odd td").attr("bg", "#fff");
			$("#mytable tr td").hover(function() {
				$(this).parent().find("td").css("background", "#fff")
			}, function() {
				var bgc = $(this).attr("bg");
				$(this).parent().find("td").css("background", bgc)
			});
		})
		$(function() {
			$('.addgroupexpert').click(
								function() {
									var id = $(this).parent().find('.expertid').val();
									var value = $(this).parent().find(
											'#addspan').html();
									var value2 = $(this).parent().find(
									'#addspan');
									var value3 = $('#expertgrouplisttd');
									$.ajax( {
										type : "post",
										url : "addExpertToGroup.action",
										datatype : "json",
										data : {
											expertid : id,
											addValue : value
										},
										success : function(data) {
											value2.html(data.addValue);
											value3.html(data.expertname);
										}
									})
								}
			)
		})
		//查询
		function findContestApply() {
			document.getElementById("form1").submit();
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
			var name = ""+'${basemodel.name}';
			name = encodeURI(name);
			name = encodeURI(name);
			window.location.href = "groupFindExpert.action?rows=" + rows
			+ "&page=" + page
			+ "&basemodel.id=" + '${basemodel.id}'
			+ "&basemodel.name=" + name;
		}

		function setRows(rows) {
			var name = ""+'${basemodel.name}';
			name = encodeURI(name);
			name = encodeURI(name);
			window.location.href = "groupFindExpert.action?rows=" + rows.value
			+ "&basemodel.id=" + '${basemodel.id}'
			+ "&basemodel.name=" + name;
		}

		function messageSure(){
			var expert =$("#expertgrouplisttd").html();
			if(expert==""){
				alert("专家组不能为空");
				return false;
			}else{
				confirm("确认将专家组("+expert+") 分配给专业组("+'${groupmname}'+")吗？");
			}

		}
</script>
	</head>
	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专家列表
			<b class="tip"></b>分配专家
		</div>
		<form action="groupFindExpert.action?page=1&rows=10" id="form1" name="form1"
			method="post" enctype="multipart/form-data">
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							专家信息查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td>
							专家编号
						</td>
						<td>
							<input name="basemodel.Id" value="<s:property value='basemodel.Id' />" type="text"/>
						</td>
						<td>
							专家名
						</td>
						<td>
							<input name="basemodel.Name" value="<s:property value='basemodel.Name' />" type="text"/>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="6">
							<a href="javascript:findContestApply();"
								class="btn btn-primary add">查询</a>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				专家列表
			</caption>
			<thead>
				<tr>
					<td>
						#
					</td>
					<td>
						专家编号
					</td>
					<td>
						专家名
					</td>
					<td>
						操作
					</td>
				</tr>
			</thead>
			<tbody>
				<s:if test="expertmajorList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="expertmajorList" id="expertmajor" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td>
							<s:property value="Id" />
						</td>
						<td>
							<s:property value="Name" />
						</td>
						<td>
							<s:if test="0==year">
								<a class="addgroupexpert" href="javascript:void(0);">
									<span class="btn btn-mini btn-primary attach" id="addspan">添加到专家组</span> </a>
							</s:if>
							<s:if test="1==year">
								<a class="addgroupexpert" href="javascript:void(0);">
									<span class="btn btn-mini btn-primary attach" id="addspan">从专家组移除</span> </a>
							</s:if>
							<input type="hidden" class="expertid"
									value="<s:property value='Id'/>" />
						</td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="expertmajorList.size()> 0">
					<tr>
						<td colspan="99">
							<s:include value="../common/paging.jsp"></s:include>
						</td>
					</tr>
				</s:if>
				<tr>
					<td colspan="3">
						<a class="btn btn-primary add" href="groupfind.action?rows=<s:property value="trows" />&page=<s:property value="tpage" />">返回到专业组选择</a>&nbsp;&nbsp;
					</td>
					<td colspan="99">
						<a href="groupMajorToExpert.action"
							onclick="return messageSure();"
							class="btn btn-primary add">完成分配</a>
					</td>
				</tr>
			</tfoot>
		</table>
		<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							专家组
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td  colspan="99">
						<font color="green"><span id="expertgrouplisttd"><s:property value="expertname"/></span></font>
						</td>
					</tr>
				</tbody>
			</table>
	</body>
</html>
