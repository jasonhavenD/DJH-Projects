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
		<table class="tableStyle" id="table" mode="list" useCheckBox="true"  sortMode="true">
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
	function onView($obj){
		var tno=$obj.attr("id");
		top.Dialog.open({URL:"../../pages/view/teacherinfo.jsp?tno="+tno,Title:"查看详情",Width:540,Height:560});
	}

	//删除行
	function delHandler($obj){
		top.Dialog.confirm("确定要删除吗？",function(){
			var tno=$obj.attr("id")+",";
			var tno = {"tnos" : tno};			
			delRow(tno);
		});
	}
	//删除行
	function delRow(tno){
		$.ajax({
			type : "post",
			url : "TeacherInfoAction_delRows",
			data : tno,
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
		var tno=$obj.attr("id");
		top.Dialog.open({URL:"../../pages/edit/teacherinfo.jsp?tno="+tno,Title:"修改 ",Width:540,Height:620});
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
			url : "TeacherInfoAction_getUsersOfPager",
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
			url : "TeacherInfoAction_getUser",
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
		var teacherinfos = data.rows;
		$("#totalSize").text('总共数据' + pager.totalRows + '条');
		$("#page-1").attr("total", pager.totalRows);
		$("#page-1").render();
		$("#table>tbody").html("");
		$("#table")
				.append(
						'<tr><th width="25" class="ali02 th"><img src="../../libs/icons/checkAllOn.gif" title="全选" class="hand"></th><th>工号</th><th>姓名</th><th>类型</th><th>密码</th><th>手机号码</th><th>电子邮件</th><th>工作单位</th><th>性别</th><th>出生日期</th><th>学历</th><th>学位</th><th>职称</th><th>毕业院校</th><th>状态</th><th>备注</th><th>操作</th></tr>');
		$("#table").render();
		var i;
		var tno,tname,type,password,phone,mail,tunit,gender,birthday,education,degree,rank,graduateuniversity,loginstatus,note;

		for (i = 0; i < pager.pageSize; i++) {
			
			if (teacherinfos[i].tno != null)
				tno = teacherinfos[i].tno;
			else
				tno = ' ';
			
			if (teacherinfos[i].tname != null) {
				tname = teacherinfos[i].tname;
			} else
				tname = ' ';
			
			if (teacherinfos[i].type != null)
				type = teacherinfos[i].type;
			else
				type = ' ';

			if (teacherinfos[i].password != null)
				password = teacherinfos[i].password;
			else
				password = ' ';
			
			if (teacherinfos[i].phone != null)
				phone = teacherinfos[i].phone;
			else
				phone = ' ';
			
			if (teacherinfos[i].mail != null)
				mail = teacherinfos[i].mail;
			else
				mail = ' ';
			
			if (teacherinfos[i].tunit != null)
				tunit = teacherinfos[i].tunit;
			else
				tunit = ' ';
			if (teacherinfos[i].gender != null)
				gender = teacherinfos[i].gender;
			else
				gender = ' ';
			if (teacherinfos[i].birthday != null)
				birthday = teacherinfos[i].birthday;
			else
				birthday = ' ';
			if (teacherinfos[i].education != null)
				education = teacherinfos[i].education;
			else
				education = ' ';
			if (teacherinfos[i].degree != null)
				degree = teacherinfos[i].degree;
			else
				degree = ' ';
			
			if (teacherinfos[i].rank != null)
				rank = teacherinfos[i].rank;
			else
				rank = ' ';
			if (teacherinfos[i].graduateuniversity != null)
				graduateuniversity = teacherinfos[i].graduateuniversity;
			else
				graduateuniversity = ' ';
			if (teacherinfos[i].loginstatus != null)
				loginstatus = teacherinfos[i].loginstatus;
			else
				loginstatus = ' ';
			if (teacherinfos[i].note != null){
				note = teacherinfos[i].note;
				if (note.length > 6) {
					note = note.substring(0, 5);
					note=note+"...";
				}
			}
			else
				note = ' ';
			
			//设置rowid
			var rowId=tno;
			//是否在线
			if(loginstatus=="在线"||loginstatus==1){
				loginstatus="在线";			
			}else{
				loginstatus="离线";
			}
			
			if (i % 2 == 1) {
				$("#table>tbody").append('<tr class="odd"><td><input type="checkbox" id="'+rowId+'" /></td><td>'+ tno + '</td><td>'+ tname + '</td><td>'+ type + '</td><td>'+ password + '</td><td>'+ phone + '</td><td>'+ mail + '</td><td>'+ tunit + '</td><td>'+ gender + '</td><td>'+ birthday + '</td><td>'+ education + '</td><td>'+ degree + '</td><td>'+ rank + '</td><td>'+ graduateuniversity + '</td><td>'+ loginstatus + '</td><td>'+ note + '</td><td><span id="'+rowId+'" class="img_view hand" onclick="onView($(this))" title="查看"></span><span id="'+rowId+'" onclick="modiHandler($(this))" class="img_edit hand" title="修改"></span> <span onclick="delHandler($(this))" class="img_delete hand" id="'+rowId+'"  title="删除"></span></td></tr>');
			} else {
				$("#table>tbody").append(
						'<tr><td><input type="checkbox" id="'+rowId+'" /></td><td>'+ tno + '</td><td>'+ tname + '</td><td>'+ type + '</td><td>'+ password + '</td><td>'+ phone + '</td><td>'+ mail + '</td><td>'+ tunit + '</td><td>'+ gender + '</td><td>'+ birthday + '</td><td>'+ education + '</td><td>'+ degree + '</td><td>'+ rank + '</td><td>'+ graduateuniversity + '</td><td>'+ loginstatus + '</td><td>'+ note + '</td><td><span id="'+rowId+'" class="img_view hand" onclick="onView($(this))" title="查看"></span><span id="'+rowId+'" onclick="modiHandler($(this))" class="img_edit hand" title="修改"></span> <span onclick="delHandler($(this))" class="img_delete hand" id="'+rowId+'"  title="删除"></span></td></tr>');
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
			URL:"../../pages/add/teacherinfo.jsp",
			Title:"添加",Width:500,Height:530});
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
			var tnos={
			    "tnos":ids
			};
			delRow(tnos);
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


</script>