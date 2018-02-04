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
	
	var fixObjHeight = 135;
	function initComplete() {
		$("#searchPanel").bind("stateChange", function(e, state) {
			if (state == "hide") {
				fixObjHeight = 110;
			} else if (state == "show") {
				fixObjHeight = 135;
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
	<div class="box2" panelTitle="查询" id="searchPanel">
		<table>
			<tr>
				<td></td>
				<td></td>
				<td><button>
						<span class="icon_find">查询详细信息</span>
					</button></td>
				<td></td>
				<td></td>
				<td><button>
						<span class="icon_delete">取消报名</span>
					</button></td>
				<td></td>
				<td></td>
				<td><button>
						<span class="icon_import" onclick="showSubmitDialog()">上传资料</span>
					</button></td>
			</tr>
			<tr></tr>
		</table>
	</div>
	<div class="box_tool_min padding_top2 padding_bottom2 padding_right5">
		<div class="center">
			<div class="left">
				<div class="right">
					<div class="padding_top5 padding_left10">
						<a href="javascript:;" onclick="addUnit()"><span
							class="icon_add">新增用户</span></a>
						<div class="box_tool_line"></div>
						<a href="javascript:;" onclick="deleteUnit()"><span
							class="icon_delete">批量删除</span></a>
						<div class="box_tool_line"></div>
						<a href="javascript:;" onclick="showImportDialog()"><span
							class="icon_import">导入</span></a>
						<div class="box_tool_line"></div>
						<a href="javascript:;" onclick="exportData(true)"><span
							class="icon_export">导出当前页</span></a>
						<div class="box_tool_line"></div>
						<a href="javascript:;" onclick="exportData(false)"><span
							class="icon_export">导出全部</span></a>
						<div class="clear"></div>
					</div>
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="scrollContent" style="overflow-x:hidden;">
		<table class="tableStyle" id="table" mode="list" useCheckBox="true" sortMode="true">
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
	function delHandler($obj){
		top.Dialog.confirm("确定要删除吗？",function(){
			var trainno={"trainnos":$obj.attr("id")+","};
			delRow(trainno);
		});
	}
	//删除行
	function delRow(trainnos){
		$.ajax({
			type : "post",
			url : "ShorttermtrainAction_delRows",
			data : trainnos,
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
				alert("出错了！");
			}
		});
	}
	
	//弹出修改窗口
	function modiHandler($obj){
		var id=$obj.attr("id");
		top.Dialog.open({URL:"../../pages/edit/shorttermtrain.jsp?id="+id,Title:"修改 ",Width:500,Height:300});
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
			url : "ShorttermtrainAction_findItems",
			dataType : "json",//设置需要返回的数据类型
			data : pager,
			success : function(data) {
				setUsers(data);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown, error) {
				alert("出错了！");
				alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(error.Message);
			}
		});

	}

	function getUser1() {
		$.ajax({
			type : "post",
			url :"ShorttermtrainAction_findItems",
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
		var shorttermtrain = data.rows;
		$("#totalSize").text('总共数据' + pager.totalRows + '条');
		$("#page-1").attr("total", pager.totalRows);
		$("#page-1").render();
		$("#table>tbody").html("");
		$("#table")
				.append(
						'<tr><th width="25" class="ali02 th"><img src="../../libs/icons/checkAllOn.gif" title="全选" class="hand"></th><th>培训编号</th><th>工号</th><th>姓名</th><th>工作单位</th><th>年龄</th><th>职称</th><th>学历</th><th>学位</th><th>主题</th><th>地点</th><th>学时</th><th>起始时间</th><th>结束时间</th><th>备注</th><th>操作</th></tr>');
		$("#table").render();
		var i;
		var trainno, tno, tname, tunit, age, rank, degree, traintopic, trainaddr, period, starttime, endtime, education, note;
		education;


		for (i = 0; i < pager.pageSize; i++) {
			
			if (shorttermtrain[i].trainno != null)
				trainno = shorttermtrain[i].trainno;
			else
				trainno = ' ';
			if (shorttermtrain[i].tno != null)
				tno = shorttermtrain[i].tno;
			else
				tno = ' ';
			if (shorttermtrain[i].tname != null)
				tname = shorttermtrain[i].tname;
			else
				tname = ' ';
			if (shorttermtrain[i].tunit != null)
				tunit = shorttermtrain[i].tunit;
			else
				tunit = ' ';
			if (shorttermtrain[i].age != null)
				age = shorttermtrain[i].age;
			else
				age = ' ';
			if (shorttermtrain[i].rank != null)
				rank = shorttermtrain[i].rank;
			else
				rank = ' ';
			if (shorttermtrain[i].education != null)
				education = shorttermtrain[i].education
			else
				rank = ' ';
			if (shorttermtrain[i].degree != null)
				degree = shorttermtrain[i].degree;
			else 
				degree = ' ';
			if (shorttermtrain[i].traintopic != null)
				traintopic = shorttermtrain[i].traintopic;
			else 
				traintopic = ' ';
			if (shorttermtrain[i].trainaddr != null)
				trainaddr = shorttermtrain[i].trainaddr;
			else 
				trainaddr = ' ';
			if (shorttermtrain[i].period != null)
				period = shorttermtrain[i].period;
			else 
				period = ' ';
			if (shorttermtrain[i].starttime != null)
				starttime = shorttermtrain[i].starttime;
			else 
				starttime = ' ';
			if (shorttermtrain[i].endtime != null)
				endtime = shorttermtrain[i].endtime;
			else 
				endtime = ' ';
			if (shorttermtrain[i].note != null)
				note = shorttermtrain[i].note;
				if(note.length > 6){
					note = note.substring(0,5);
					note = note + "...";
				}
			else
				note = ' ';
			
			//设置rowid
			var rowId=trainno+"-"+tno;
			
			if (i % 2 == 1) {
				$("#table>tbody").append(
						'<tr class="odd"><td><input type="checkbox" id="'+rowId+'"></td><td>' + trainno + '</td><td id="tno">'+ tno + '</td><td>' + tname
								+ '</td><td>' + tunit + '</td><td>'
								+ age + '</td><td>' + rank
								+ '</td><td>'+education+'</td><td>'+degree+'</td><td>'+traintopic+'</td><td>'+trainaddr+'</td><td>'+period+'</td><td>'+starttime+'</td><td>'+endtime+'</td><td>' + note + '</td><td><span id="'+
								rowId+'" onclick="modiHandler($(this))" class="img_edit hand" title="修改"></span> <span onclick="delHandler($(this))" class="img_delete hand" id="'+rowId+'"  title="删除"></span></td></tr>');
			} else {
				$("#table>tbody").append(
						'<tr><td><input type="checkbox" id="'+rowId+'"></td><td>' + trainno + '</td><td>' + tno+ 
							'</td><td>' + tname 
								+ '</td><td>'	+ tunit + '</td><td>' 
								+ age+ '</td><td>' + rank 
								+ '</td><td>'+education+'</td><td>'+degree+'</td><td>'+traintopic+'</td><td>'+trainaddr+'</td><td>'+period+'</td><td>'+starttime+'</td><td>'+endtime+'</td><td>' + note+ '</td><td><span id="'+
									rowId+'" onclick="modiHandler($(this))" class="img_edit hand" title="修改"></span> <span onclick="delHandler($(this))" class="img_delete hand" id="'+rowId+'"  title="删除"></span></td></tr>');
			}
		}
		$("#table").render();
	}
</script>



<%--toolbar操作 --%>
<script>
//新增
function addUnit() {
	top.Dialog.open({
			URL:"../../pages/add/shorttermtrain.jsp",
			Title:"添加",Width:500,Height:300});
}


//批量删除
function deleteUnit() {
	var rows = $("td input:checkbox:checked");
	var rowsLength = rows.length;
	
	if(rowsLength == 0) {
		top.Dialog.alert("请选中要删除的记录!");
	}else{
		top.Dialog.confirm("确定要删除吗？",function(){
			var ids = "";
			$("td input:checkbox:checked").each(function(){
				var value = $(this).attr("id");
				if(value != null && "" != value){
					ids += value + ",";
				}
			});
			var trainnos={
			    "trainnos":ids
			};
			delRow(trainnos);
		});
	}

}

//长传材料
function showSubmitDialog(){
	top.Dialog.open({Title:"提交材料", 
			Message:"请上传材料", 
			URL:"../../pages/upload/upload.jsp",
			Width:180,Height:90});
}


<%--
//导入
function showImportDialog(){
	top.Dialog.open({Title:"导入用户信息", 
			Message:"请上传excel文件", 
			URL:"<%=path%>/sample/unit/uploadFile.jsp?type=2",
			Width:350,Height:130});
}


//导出
function exportData(isPage){
	var pageNo = $("#pageNo").val();
	var pagerSize = $("#pageSize").val();
	var sort = $("#sort").val();
	var direction = $("#direction").val();
	//var parentid = $("#parentId").val();
	var userName = $("#userName").val();
	var url = "<%=path%>/exportData.action";
			if (isPage) {
				url += "?pager.pageSize=" + pagerSize;
				url += "&pager.pageNo=" + pageNo;
				url += "&sort=" + sort;
				url += "&direction=" + direction;
				url += "&isPage=1";
			} else {
				url += "?isPage=0";
			}
			//url += "&parentId=" + parentid;
			url += "&userinfor.userName" + userName;

			window.location = url;
		}
 --%>
</script>