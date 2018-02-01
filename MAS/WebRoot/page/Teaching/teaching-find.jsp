<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>教材信息</title>

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
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />

<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/timeManage.js">
</script>
		<script type="text/javascript">
//日历插件
$(function() {
	$(".datepicker").datepicker();

	var _this = $('.list').find('thead');
	$('.tby').hide();
	//折叠
	_this.click(function() {
		var i = $(this).find('i');
		if (i.attr('class') == 'tip-down') {
			i.attr('class', 'tip-up')
		} else {
			i.attr('class', 'tip-down')
		}
		$(this).parent().find('tbody').toggle();
	})

})

$(document).ready(function() {
timeManage();
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
$(document).ready(function() {
	// ------------------------------
		//角色判断
		var rol = $("#rol").val();
		var totalRows = $("#totalRows").val();
		if (rol == 6) {
			$("#attach").hide();
			$("#add").hide();
			$("#deleteAll").hide();
			$("#deleteThis").hide();
			$(".edit").hide();
			$(".del").hide();
			for ( var i = 0; i < totalRows; i++) {
				$(".edit").hide();
				$(".del").hide();
			}

		}
	});
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
	window.location.href = "tBooks_see.action?rows=" + rows + "&page=" + page;
}

function setRows(rows) {
	window.location.href = "tBooks_see.action?rows=" + rows.value+"&page=1";
}
//导出
function exportSubContestTExcel() {
	//var a = document.getElementById("teachBooks.tbno").value;

	window.location.href = "exportSubContestTExcel1.action?exportName=teachbook"
			+ "&insNumber=" + document.getElementById("teachBooks.tbno").value;
	//alert(insNumber);
}
function refashChengyuan(){
	document.getElementById("refashChengyuan").submit();
}
//上传附件弹出框
			function upFile(){
				document.getElementById("iframe").src="attachFileList.action?importName=teachbook";
                $('#alert-win').dialog({
                    width: 450,
                    height: 240,
                    buttons: { "关闭": function () {
             		refashChengyuan();
                    $(this).dialog("close");} }
                });
			}
</script>

	</head>

	<body style="background-color:#e4dfd9"  onload="init()">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业数据采集
			<b class="tip"></b>查询教材信息
			<b class="tip"></b>教材基本信息
		</div>
		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				教材基本信息
			</caption>
			<thead>
				<tr>
					<td colspan="99">
						教材信息查看
					</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="width: 60px;">
						教材编号
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="teachBooks.tbno" type="text" id="teachBooks.tbno"
							disabled="true" value='<s:property value="teachBooks.tbno" />' />
					</td>
					<td style="width: 60px;">
						教材名称
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="teachBooks.tbname" id="tbname" type="text"
							disabled="true" value='<s:property value="teachBooks.tbname" />' />
					</td>
					<td style="width: 60px;">
						ISBN
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="teachBooks.isbn" id="isbn" type="text"
							disabled="true" value='<s:property value="teachBooks.isbn" />' />
					</td>
					<td style="width: 60px;">
						出版社
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="teachBooks.publisher" id="publisher" type="text"
							disabled="true"
							value='<s:property value="teachBooks.publisher" />' />
					</td>

				</tr>
				<tr>
					<td style="width: 60px;">
						年份
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="teachBooks.year" id="year" type="text"
							disabled="true" value='<s:property value="teachBooks.year"/>' />
					</td>
					<td style="width: 60px;">
						出版时间
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="teachBooks.publishTime" id="publishTime" type="text"
							disabled="true"
							value='<fmt:formatDate pattern="yyyy-MM-dd" value="${teachBooks.publishTime}"/>'/>
					</td>
					<td style="width: 60px;">
						出版类型
						<font color="FF0000">*</font>
					</td>
					<td>
						<input name="teachBooks.publishType" id="publishType" type="text"
							disabled="true"
							value='<s:property value="teachBooks.publishType" />' />
					</td>
					<td style="width: 60px;">
						级别
					</td>
					<td>
						<input name="teachBooks.tbookJibie" id="tbookJibie" type="text"
							disabled="true"
							value='<s:property value="teachBooks.tbookJibie"/>' />
					</td>
				</tr>
				<tr>
					<td>
						优秀教材级别
					</td>
					<td>
						<input name="teachBooks.tbookClass" id="tbookClass" type="text"
							disabled="true"
							value='<s:property value="teachBooks.tbookClass" />' />
					</td>
					<td>
						优秀教材奖项级别
					</td>
					<td>
						<input name="teachBooks.tbookRewardClass" id="tbookRewardClass"
							disabled="true" type="text"
							value='<s:property value="teachBooks.tbookRewardClass"/>' />
					</td>
					<td>
						字数
					</td>
					<td>
						<input type="text" name="teachBooks.bookWords" disabled="true"
							id="bookWords"
							value='<s:property value="teachBooks.bookWords" />' />
					</td>
					<td>
						使用情况
					</td>
					<td>
						<input type="text" name="teachBooks.useState" disabled="true"
							id="useState" value='<s:property value="teachBooks.useState" />' />
					</td>
				</tr>
				<tr>

					<td>
						完成单位排名
					</td>
					<td>
						<input type="text" name="teachBooks.fininshDepartRate"
							disabled="true" id="fininshDepartRate"
							value='<s:property value="teachBooks.fininshDepartRate" />' />
					</td>
					<td>
						备注

					</td>
					<td colspan="6">
						<input type="text" name="teachBooks.beizhu" id="beizhu"
							disabled="true" value='<s:property value="teachBooks.beizhu"/>' />
					</td>
					<!--<td>
						标签
					</td>
					<td>
						<input type="text" name="teachBooks.tag" id="tag" disabled="true"
							value='<s:property value="teachBooks.tag" />' />
					</td>
					<td>
						&nbsp;
					</td>
					<td>
						&nbsp;
					</td>
				--></tr>
				<tr>
				<td>
					<a class="btn btn-primary add" href="tBooks_find.action?rows=<s:property value="trows" />&page=<s:property value="tpage" />" >返回上一页</a>&nbsp;&nbsp;

				</td>
				<input type="hidden" id="rol" value="<s:property value="rol"/>" />
				<td colspan="5">
					<a href="#" onclick="exportSubContestTExcel()"
						class="btn btn-primary add">导出教材成员列表</a>
				</td>
				<td>
					<a id = "add" class="btn btn-primary add"
								href="tBooks_editTB.action?tbZno=0">
								添加  </a>
					<!--选择导入的文件 -->
					<a  id="attach" href="javascript:void(0);"
					onclick="upFile();return false;"
					class="btn btn-primary add">导入当前教材作者信息</a>
				</td>
				<td >
					<!--清空所有教材作者信息 -->
					<a id="deleteAll" href="clearTB.action?tbno=<s:property value="tbno"/>"
						onclick="return confirm('确认删除所有教材作者信息吗？');" class="btn btn-primary add">清空所有教材作者</a>
					<!--清空当前页教材作者信息 -->
					<a id="deleteThis" href="clearListTB.action"
						onclick="return confirm('确认删除当前页教材作者信息吗？');" class="btn btn-primary add">清空当前页教材作者</a>
				</td>
			</tr>
			</tbody>

		</table>

		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				教材作者列表
			</caption>
			<thead>
				<tr class="tr_title" style="height: 30px;">
					<td>
						#
					</td>
                    <td>
						教师工号
					</td>
					<td>
						教师姓名
					</td>
					<td>
						教材名称
					</td>
					<td>
						作者角色
					</td>
					<td>
						作者排名
					</td>

					<td>
						操作
					</td>
				</tr>
			</thead>
			<tbody>
				<s:if test="teachBookList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有教材作者信息！
							<!--<a id="add" class="btn btn-mini btn-primary"
								href="tBooks_edit1.action?tbno=<s:property value="tbno"/>">
								添加成员信息 </a>
							-->
						</td>
					</tr>
				</s:if>
				<s:iterator value="teachBookList" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td>
							<s:property value="teacher.tno" />
						</td>
						<td>
							<s:property value="teacher.tname" />
						</td>
						<td>
							<s:property value="teachingbooks.tbname" />
						</td>
						<td>
							<s:property value="authorJuese" />
						</td>
						<td>
							<s:property value="authorRank" />
						</td>
						<td>
						<span class="edit">
							<a class="btn btn-mini btn-primary"
								href="tBooks_editTB.action?tbZno=<s:property value="tbZno"/>">
								修改 </a>
						</span>
						<span class="del">
							<a class="btn btn-mini btn-primary"
								onclick="return confirm('确认删除 吗？');"
								href="tBooks_deleteTB.action?tbZno=<s:property value="tbZno"/>">
								删除 </a>
						</span>
						</td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="teachBookList.size() > 0">
					<tr>
						<td colspan="99">
							<s:include value="../common/paging.jsp"></s:include>
						</td>
					</tr>
				</s:if>
			</tfoot>
		</table>
		<tfoot>

		</tfoot>
		<div id="alert-win" title="附件" style="display: none;">
			<iframe style="border: 0; width: 100%; height: 100%;" id="iframe"
				src="">
			</iframe>
		</div>
	<form action="tBooks_initSee.action?tbno=<s:property value="tbno"/>" id="refashChengyuan">
	</body>
</html>
