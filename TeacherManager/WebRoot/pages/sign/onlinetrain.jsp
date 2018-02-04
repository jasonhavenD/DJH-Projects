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
	//关闭弹窗
	top.Dialog.close();

	var fixObjHeight = 125;
	function initComplete() {
		$("#searchPanel").bind("stateChange", function(e, state) {
			if (state == "hide") {
				fixObjHeight = 110;
			} else if (state == "show") {
				fixObjHeight = 125;
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
							<a href="javascript:;"><span class="icon_import"
								onclick="showSubmitDialog()">上传资料</span></a>
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
	//查看
	function onView($obj) {
		var trainno = $obj.attr("id");
		top.Dialog.open({
			URL : "../../pages/sign/view/onlinetrain.jsp?trainno=" + trainno,
			Title : "查看详情 ",
			Width : 540,
			Height : 320
		});
	}

	//取消
	function cancel($obj) {
		var trainno = $obj.attr("id");
		//只需要在线培训的id即可报名
		var trainnos = trainno;
		$.ajax({
			type : "post",
			url : "OnlinetrainAction_cancel",
			data : {
				"trainnos" : trainnos
			},
			success : function(data) {
				top.Dialog.alert("取消报名成功！|报名结果", function() {
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
				});
			},
			error : function(XMLHttpRequest, textStatus, errorThrown, error) {
				alert("出错了！");
			}
		});

		$("#table").render();
	}

	//弹出报名窗口
	function enroll($obj) {
		var trainno = $obj.attr("id");
		//只需要在线培训的id即可报名
		var trainnos = trainno;
		$.ajax({
			type : "post",
			url : "OnlinetrainAction_enroll",
			data : {
				"trainnos" : trainnos
			},
			success : function(data) {
				top.Dialog.alert("报名成功！|报名结果", function() {
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
				});
			},
			error : function(XMLHttpRequest, textStatus, errorThrown, error) {
				alert("出错了！");
			}
		});
		$("#table").render();
	}
</script>


<%--表格显示 --%>
<script>
	/* 页面加载完成，绑定事件 */
	$(document).ready(function() {
		getUser1();//不传递pager，采用后台数据控制
	});

	/*绑定翻页事件*/
	$(function() {
		$("#page-1").bind("pageChange", function(e, index) {
			var totalRows = 1; // 总行数,需要从后台得到
			var pageSize = $("#page-1").attr("pageSize"); // 每页显示的行数
			var pageNo = index; // 当前页号
			var totalPages = 1; // 总页数,需要从后台得到
			var startRow = 1; // 当前页在数据库中的起始行
			var pager = {
				"pager.totalRows" : totalRows,
				"pager.pageSize" : pageSize,
				"pager.pageNo" : index,
				"pager.totalPages" : totalPages,
				"pager.startRow" : startRow
			};
			getUsersOfPager1(pager);
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
				"pager.startRow" : startRow
			};
			getUsersOfPager1(pager);
		})

	})

	function getUsersOfPager1(pager) {
		$.ajax({
			type : "post",
			url : "OnlinetrainAction_getUsersOfPager",
			dataType : "json",//设置需要返回的数据类型
			data : pager,
			success : function(data) {
				setUsers(data);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown, error) {
				alert("出错了！");
			}
		});

	}

	function getUser1() {
		$.ajax({
			type : "post",
			url : "OnlinetrainAction_getUser",
			dataType : "json",//设置需要返回的数据类型
			success : function(data) {
				setUsers(data);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("出错了！");
			}
		});
	}

	function setUsers(data) {
		var pager = data.pager;
		var onlinetrains = data.rows;
		var enrollFlags = data.enrollFlags;
		$("#totalSize").text('总共数据' + pager.totalRows + '条');
		$("#page-1").attr("total", pager.totalRows);
		$("#page-1").render();
		$("#table>tbody").html("");
		$("#table")
				.append(
						'<tr><th width="25" class="ali02 th"><img src="../../libs/icons/checkAllOn.gif" title="全选" class="hand"></th><th>培训编号</th><th>培训名称</th><th>培训学时</th><th>开始时间</th><th>结束时间</th><th>截止状态</th><th>备注</th><th>操作</th></tr>');
		$("#table").render();
		var i;
		var trainno, trainname, period, starttime, endtime, offstatus, note;

		for (i = 0; i < pager.pageSize; i++) {

			if (onlinetrains[i].trainno != null)
				trainno = onlinetrains[i].trainno;
			else
				trainno = ' ';
			if (onlinetrains[i].trainname != null) {
				trainname = onlinetrains[i].trainname;
			} else
				trainname = ' ';
			if (onlinetrains[i].period != null)
				period = onlinetrains[i].period;
			else
				period = ' ';

			if (onlinetrains[i].starttime != null)
				starttime = onlinetrains[i].starttime;
			else
				starttime = ' ';
			if (onlinetrains[i].endtime != null)
				endtime = onlinetrains[i].endtime;
			else
				endtime = ' ';
			if (onlinetrains[i].offstatus != null)
				offstatus = onlinetrains[i].offstatus;
			else
				offstatus = ' ';
			if (onlinetrains[i].note != null) {
				note = onlinetrains[i].note;
				if (note.length > 6) {
					note = note.substring(0, 5);
					note=note+"...";
				}
			} else
				note = ' ';

			//设置rowid
			var rowId = trainno;

			//根据是否已经报名设置显示
			var process = '<span id="'
					+ rowId
					+ '" onclick="enroll($(this))" class="img_add hand" title="报名"></span>';
			if (i < enrollFlags.length && enrollFlags[i] == true) {
				process = '<span id="'
						+ rowId
						+ '" onclick="cancel($(this))" class="img_delete hand" title="取消报名"></span>';
			}
			if (i % 2 == 1) {
				$("#table>tbody")
						.append(
								'<tr class="odd"><td><input type="checkbox" id="'+rowId+'"></td><td>'
										+ rowId
										+ '</td><td>'
										+ trainname
										+ '</td><td>'
										+ period
										+ '</td><td>'
										+ starttime
										+ '</td><td>'
										+ endtime
										+ '</td><td>'
										+ offstatus
										+ '</td><td>'
										+ note
										+ '</td><td><span id="'
										+ rowId
										+ '" class="img_view hand" onclick="onView($(this))" title="查看"></span>'
										+ process + '</td></tr>');
			} else {
				$("#table>tbody")
						.append(
								'<tr><td><input type="checkbox" id="'+rowId+'"></td><td>'
										+ rowId
										+ '</td><td>'
										+ trainname
										+ '</td><td>'
										+ period
										+ '</td><td>'
										+ starttime
										+ '</td><td>'
										+ endtime
										+ '</td><td>'
										+ offstatus
										+ '</td><td>'
										+ note
										+ '</td><td><span id="'
										+ rowId
										+ '" class="img_view hand" onclick="onView($(this))" title="查看"></span>'
										+ process + '</td></tr>');
			}
		}
		$("#table").render();
	}
</script>

<%--toolbar操作 --%>
<script>
	//传材料
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