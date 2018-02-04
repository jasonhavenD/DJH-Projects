<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
<!--框架必需start-->
<script type="text/javascript" src="../../libs/js/jquery.js"></script>
<script type="text/javascript" src="../../libs/js/language/cn.js"></script>
<script type="text/javascript" src="../../libs/js/framework.js"></script>
<link href="../../libs/css/import_basic.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" type="text/css" id="skin" prePath="../../"
	scrollerY="false" />
<link rel="stylesheet" type="text/css" id="customSkin" />
<!--框架必需end-->

<!-- 日期选择框start -->
<script type="text/javascript"
	src="../../libs/js/form/ Picker/W Picker.js"></script>
<!-- 日期选择框end -->

<!--数字分页start-->
<script type="text/javascript" src="../../libs/js/nav/pageNumber.js"></script>
<!--数字分页end-->

<!-- 异步上传控件start -->
<script type="text/javascript"
	src="../../libs/js/form/upload/fileUpload.js"></script>
<script type="text/javascript"
	src="../../libs/js/form/upload/handlers.js"></script>
<!-- 异步上传控件end -->


<%--框架初始化 --%>
<script>
	var fixObjHeight = 105;
	function initComplete() {
		$("#searchPanel").bind("stateChange", function(e, state) {
			if (state == "hide") {
				fixObjHeight = 110;
			} else if (state == "show") {
				fixObjHeight = 105;
			}
			triggerCustomHeightSet();
		});
	}
	function customHeightSet(contentHeight) {
		$("#scrollContent").height(contentHeight - fixObjHeight);
	}
</script>

</head>
<body>
	<div class="box2" panelTitle="操作" id="searchPanel">
		<div class="box_tool_min padding_top2 padding_bottom2 padding_right5">
			<div class="center">
				<div class="left">
					<div class="right">
						<div class="padding_top5 padding_left10">
							<a href="javascript:;" onclick="addUnit()"><span
								class="icon_add">添加教师</span></a>
							<div class="box_tool_line"></div>
							<a href="javascript:;" onclick="deleteUnit()"><span
								class="icon_delete">批量删除</span></a>
							<div class="box_tool_line"></div>
							<a href="javascript:;" onclick="showImportDialog()"><span
								class="icon_import">导入教师</span></a>
							<div class="box_tool_line"></div>
							<a href="javascript:;" onclick="exportData(true)"><span
								class="icon_export">导出当前页</span></a>
							<div class="box_tool_line"></div>
							<a href="javascript:;" onclick="exportData(false)"><span
								class="icon_export">导出全部</span></a> <a href="javascript:;"><span
								class="icon_import" onclick="showSubmitDialog()">上传资料</span></a>
						</div>
					</div>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>


	<div id="scrollContent" style="overflow-x:hidden;">
		<table class="tableStyle" id="table" mode="list" useCheckBox="true"
			sortMode="true">
			<hiden id="condition"></hiden>
			<tbody></tbody>
		</table>
	</div>


	<div style="height:35px;">
		<div class="float_left padding5" id="totalSize"></div>
		<div class="float_right padding5">
			<div id="page-1" class="pageNumber" total="100" pageSize="10"
				showSelect="true" prevText="上一页" nextText="下一页" showInput="false"
				selectData='{"list":[{"key":5,"value":5},{"key":10,"value":10},{"key":20,"value":20},{"key":50,"value":50},{"key":100,"value":100}]}'></div>
		</div>
		<div class="clear"></div>
	</div>

</body>
</html>


<%--表单操作 --%>
<script>
	//删除行
	function delHandler($obj) {
		top.Dialog.confirm("确定要删除吗？", function() {
			var rowId = {
				"rowIds" : $obj.attr("id") + ","
			};
			delRow(rowId);
			refresh();
		});
	}
	//删除行
	function delRow(rowId) {
		$.ajax({
			type : "post",
			url : "TonlinetrainAction_delRows",
			data : rowId,
			success : function(data) {
				var totalRows = 1; // 总行数,需要从后台得到
				var pageSize = $("#page-1").attr("pageSize"); // 每页显示的行数
				var pageNo = $("#page-1").attr("page"); // 当前页号
				var totalPages = 1; // 总页数,需要从后台得到
				var startRow = 1; // 当前页在数据库中的起始行
				var pager = {
					"pager.totalRows" : totalRows,
					"pager.pageSize" : pageSize,
					"pager.pageNo" : pageNo,
					"pager.totalPages" : totalPages,
					"pager.startRow" : startRow
				};
				getUsersOfPager1(pager);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
			}
		});
	}

	//弹出修改窗口
	function modiHandler($obj) {
		var id = $obj.attr("id");
		/*
		top.Dialog.open({
			URL : "../../pages/edit/tonlinetrain-teacher.jsp?id=" + id,Title : "修改 ",Width : 540,Height : 540});
		*/
		window.location.href = "../../pages/edit/tonlinetrain-teacher.jsp?id="+id+"&trainno="+$("#condition").val();
	}
</script>


<script>
	function refresh() {
		location.reload();
	}

	function getQueryString(name) { //输入参数名称
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); //根据参数格式，正则表达式解析参数
		var r = window.location.search.substr(1).match(reg);
		if (r != null)
			return unescape(r[2]);
		return null; //返回参数值
	}

	/* 页面加载完成，绑定事件 */
	$(document).ready(function() {
		//设置hiden属性
		var trainno = getQueryString("trainno");
		$("#condition").val(trainno);
		getUser1(trainno);//不传递pager，采用后台数据控制
		$("#table").render();
	});

	/*绑定翻页事件*/
	$(function() {
		$("#page-1").bind("pageChange", function(e, index) {
			var totalRows = 1; // 总行数,需要从后台得到
			var pageSize = $("#page-1").attr("pageSize"); // 每页显示的行数
			var pageNo = index; // 当前页号
			var totalPages = 1; // 总页数,需要从后台得到
			var startRow = 1; // 当前页在数据库中的起始行
			var data = {
				"pager.totalRows" : totalRows,
				"pager.pageSize" : pageSize,
				"pager.pageNo" : index,
				"pager.totalPages" : totalPages,
				"pager.startRow" : startRow,
				"trainno" : $("#condition").val()
			};
			getUsersOfPager1(data);
		})
	})

	/*绑定修改每页数目事件*/
	$(function() {
		$("#page-1").bind("sizeChange", function(e, num) {
			var totalRows = 1; // 总行数,需要从后台得到
			var pageSize = $("#page-1").attr("pageSize"); // 每页显示的行数
			var pageNo = $("#page-1").attr("page"); // 当前页号
			var totalPages = 1; // 总页数,需要从后台得到
			var startRow = 1; // 当前页在数据库中的起始行
			var pager = {
				"pager.totalRows" : totalRows,
				"pager.pageSize" : pageSize,
				"pager.pageNo" : pageNo,
				"pager.totalPages" : totalPages,
				"pager.startRow" : startRow,
				"trainno" : $("#condition").val()
			};
			getUsersOfPager1(pager);
		})

	})

	function getUsersOfPager1(data) {
		$.ajax({
			type : "post",
			url : "TonlinetrainAction_getUsersOfPager2",
			dataType : "json",//设置需要返回的数据类型
			data : data,
			success : function(data) {
				setUsers(data);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown, error) {
			}
		});
		$("#table").render();
	}

	function getUser1(trainno) {
		var trainno = {
			"trainno" : trainno
		}
		$.ajax({
			type : "post",
			url : "TonlinetrainAction_getUser2",
			dataType : "json",//设置需要返回的数据类型
			data : trainno,
			success : function(data) {
				setUsers(data);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
			}
		});
		$("#table").render();
	}

	function setUsers(data) {
		var pager = data.pager;
		var tonlinetrain = data.rows;
		$("#totalSize").text('总共数据' + pager.totalRows + '条');
		$("#page-1").attr("total", pager.totalRows);
		$("#page-1").render();
		$("#table>tbody").html("");
		$("#table")
				.append(
						'<tr><th width="25" class="ali02 th"><img src="../../libs/icons/checkAllOff.gif" title="全选" class="hand"></th><th>工号</th><th>培训编号</th><th>姓名</th><th>性别</th><th>工作单位</th><th>年龄</th><th>职称</th><th>学历</th><th>学位</th><th>学时</th><th>审核人</th><th>审核状态</th><th>备注</th><th>操作</th></tr>');
		$("#table").render();

		var i;

		var tno, trainno, tname, gender, tunit, age, rank, education, degree, period, auditor, checkstatus, note;

		for (i = 0; i < pager.pageSize; i++) {
			if (tonlinetrain[i].tno != null)
				tno = tonlinetrain[i].tno;
			else
				tno = ' ';
			if (tonlinetrain[i].trainno != null)
				trainno = tonlinetrain[i].trainno;
			else
				trainno = ' ';
			if (tonlinetrain[i].tname != null) {
				tname = tonlinetrain[i].tname;
			} else
				tname = ' ';

			if (tonlinetrain[i].gender != null)
				gender = tonlinetrain[i].gender;
			else
				gender = ' ';
			if (tonlinetrain[i].tunit != null)
				tunit = tonlinetrain[i].tunit;
			else
				tunit = ' ';

			if (tonlinetrain[i].age != null)
				age = tonlinetrain[i].age;
			else
				age = ' ';
			if (tonlinetrain[i].rank != null)
				rank = tonlinetrain[i].rank;
			else
				rank = ' ';

			if (tonlinetrain[i].education != null)
				education = tonlinetrain[i].education;
			else
				education = ' ';

			if (tonlinetrain[i].degree != null)
				degree = tonlinetrain[i].degree;
			else
				degree = ' ';

			if (tonlinetrain[i].period != null)
				period = tonlinetrain[i].period;
			else
				period = ' ';

			if (tonlinetrain[i].auditor != null)
				auditor = tonlinetrain[i].auditor;
			else
				auditor = ' ';

			if (tonlinetrain[i].checkstatus != null)
				checkstatus = tonlinetrain[i].checkstatus;
			else
				checkstatus = ' ';

			if (tonlinetrain[i].note != null){
				note = tonlinetrain[i].note;
				if (note.length > 6) {
					note = note.substring(0, 5);
					note=note+"...";
				}
			}
			else
				note = ' ';

			//设置rowid
			var rowId = tno + "-" + trainno;

			if (i % 2 == 1) {
				$("#table>tbody")
						.append(
								'<tr class="odd"><td><input type="checkbox" id="'+rowId+'"></td><td>'
										+ tno
										+ '</td><td>'
										+ trainno
										+ '</td><td>'
										+ tname
										+ '</td><td>'
										+ gender
										+ '</td><td>'
										+ tunit
										+ '</td><td>'
										+ age
										+ '</td><td>'
										+ rank
										+ '</td><td>'
										+ education
										+ '</td><td>'
										+ degree
										+ '</td><td>'
										+ period
										+ '</td><td>'
										+ auditor
										+ '</td><td>'
										+ checkstatus
										+ '</td><td>'
										+ note
										+ '</td><td><span id="'
										+ rowId
										+ '" onclick="modiHandler($(this))" class="img_edit hand" title="修改"></span> <span onclick="delHandler($(this))" class="img_delete hand" id="'
										+ rowId
										+ '"  title="删除"></span></td></tr>');
			} else {
				$("#table>tbody")
						.append(
								'<tr><td><input type="checkbox" id="'+rowId+'"></td><td>'
										+ tno
										+ '</td><td>'
										+ trainno
										+ '</td><td>'
										+ tname
										+ '</td><td>'
										+ gender
										+ '</td><td>'
										+ tunit
										+ '</td><td>'
										+ age
										+ '</td><td>'
										+ rank
										+ '</td><td>'
										+ education
										+ '</td><td>'
										+ degree
										+ '</td><td>'
										+ period
										+ '</td><td>'
										+ auditor
										+ '</td><td>'
										+ checkstatus
										+ '</td><td>'
										+ note
										+ '</td><td><span id="'
										+ rowId
										+ '" onclick="modiHandler($(this))" class="img_edit hand" title="修改"></span> <span onclick="delHandler($(this))" class="img_delete hand" id="'
										+ rowId
										+ '"  title="删除"></span></td></tr>');
			}
		}
		$("#table").render();
	}
</script>


<%--toolbar操作 --%>
<script>
	//新增
	function addUnit() {
		/*
		top.Dialog.open({
			URL : "../../pages/add/tonlinetrain-teacher.jsp?trainno="+$("#condition").val(),
			Title : "添加",
			Width : 500,
			Height : 540
		});
		*/
		window.location.href = "../../pages/add/tonlinetrain-teacher.jsp?trainno="+$("#condition").val();
	}

	//批量删除
	function deleteUnit() {
		var rows = $("td input:checkbox:checked");
		var rowsLength = rows.length;

		if (rowsLength == 0) {
			top.Dialog.alert("请选中要删除的记录!");
		} else {
			top.Dialog.confirm("确定要删除吗？", function() {
				var ids = "";
				$("td input:checkbox:checked").each(function() {
					var value = $(this).attr("id");
					if (value != null && "" != value) {
						ids += value + ",";
					}
				});
				var rowIds = {
					"rowIds" : ids
				};
				delRow(rowIds);
				refresh();
			});
		}

	}

	//长传材料
	function showSubmitDialog() {
		top.Dialog.open({
			Title : "提交材料",
			Message : "请上传材料",
			URL : "../../pages/upload/upload.jsp",
			Width : 180,
			Height : 90
		});
	}

	
</script>