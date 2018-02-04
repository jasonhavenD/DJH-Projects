<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"
	scrollerY="false" />
<link rel="stylesheet" type="text/css" id="customSkin" />
<!--框架必需end-->

<!-- 日期选择框start -->
<script type="text/javascript"
	src="<%=path%>/libs/js/form/datePicker/WdatePicker.js"></script>
<!-- 日期选择框end -->

<!--数字分页start-->
<script type="text/javascript" src="<%=path%>/libs/js/nav/pageNumber.js"></script>
<!--数字分页end-->
</head>
<body>
	<div class="box2" panelTitle="功能面板" id="searchPanel">
		<table>
			<tr>
				<td>姓名：</td>
				<td><input id="query_userName"
					value="<s:property value="%{userinfor.userName}"/>" type="text" /><input
					type="text" style="width:2px;display:none;" /></td>
				<td><button type="button" onclick="searchHandler()">
						<span class="icon_find">查询</span>
					</button></td>
				<td><button type="button" onclick="resetSearch()">
						<span class="icon_reload">重置</span>
					</button></td>
				<td><div class="red">此示例由后台支持</div></td>
			</tr>
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
		<form action="<%=path%>/getUsersBasic.action" method="post"
			id="usersForm">
			<input type="hidden" value="<s:property value="%{direction}"/>"
				name="direction" id="direction" /> <input type="hidden"
				value="<s:property value="%{sort}"/>" name="sort" id="sort" /> <input
				type="hidden" value="<s:property value="%{pager.pageNo}"/>"
				name="pager.pageNo" id="pageNo" /> <input type="hidden"
				value="<s:property value="%{pager.pageSize}"/>"
				name="pager.pageSize" id="pageSize" /> <input type="hidden"
				value="<s:property value="%{userinfor.userName}"/>"
				name="userinfor.userName" id="userName" />

			<table class="tableStyle" mode="list" useCheckBox="true"
				sortMode="true">
				<tr>
					<th width="25"></th>
					<th width="100"><span onclick="sortHandler('userName')"
						id="span_userName">姓名</span></th>
					<th width="100"><span onclick="sortHandler('userLoginName')"
						id="span_userLoginName">登陆名</span></th>
					<th><span onclick="sortHandler('orgName')" id="span_orgName">所属部门</span></th>
					<th width="80"><span onclick="sortHandler('userSex')"
						id="span_userSex">性别</span></th>
					<th width="100"><span onclick="sortHandler('userEmployTime')"
						id="span_userEmployTime">入职时间</span></th>
					<th width="60"><span onclick="sortHandler('userEducation')"
						id="span_userEducation">学历</span></th>
					<th width="80"></th>
				</tr>
				<s:if test="%{users != null}">
					<s:iterator value="%{users}" id="user" status="count">
						<tr>
							<td><input type="checkbox"
								userid="<s:property value="#user.userId"/>" /></td>
							<td><s:property value="#user.userName" /></td>
							<td><s:property value="#user.userLoginName" /></td>
							<td><s:property value="#user.organization.orgName" /></td>
							<td><s:if test="%{#user.userSex == null}"></s:if> <s:else>
									<s:if test='%{#user.userSex == 1}'>男</s:if>
									<s:else>女</s:else>
								</s:else></td>
							<td><s:date name="#user.userEmployTime" format="yyyy-MM-dd" />
							</td>
							<td><s:if test='%{#user.userEducation == "1"}'>大专</s:if> <s:elseif
									test='%{#user.userEducation == "2"}'>本科</s:elseif> <s:elseif
									test='%{#user.userEducation == "3"}'>硕士</s:elseif> <s:else>博士</s:else>
							</td>
							<td><span class="img_view hand" title="查看"
								onclick="onView('<s:property value="#user.userId"/>')"></span> <span
								class="img_edit hand" title="修改"
								onclick="onEdit('<s:property value="#user.userId"/>')"></span> <span
								class="img_delete hand" title="删除"
								onclick="onDelete('<s:property value="#user.userId"/>')"></span>
							</td>
						</tr>
					</s:iterator>
				</s:if>
			</table>
		</form>
	</div>
	<div style="height:35px;">
		<div class="float_left padding5">数据共${pager.totalRows}条</div>
		<div class="float_right padding5">
			<div class="pageNumber"
				total="<s:property value="%{pager.totalRows}"/>"
				pageSize="<s:property value="%{pager.pageSize}"/>"
				page="<s:property value="%{pager.pageNo-1}"/>" showSelect="true"
				showInput="true" id="pageContent"></div>
		</div>
		<div class="clear"></div>
	</div>
	<script type="text/javascript">
var pageNo = 1;
var pageSize = 20;
var totalRows = 0;
//设定不可编辑的节点id
var noeditArray=["1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19"];
var fixObjHeight=140;
function initComplete(){
	//当提交表单刷新本页面时关闭弹窗
	top.Dialog.close();
	
	var $pager = $("#pageContent");
	$pager.bind("pageChange",function(e,index){
		
		pageNo = index + 1;
		$("#pageNo").val(pageNo);
		$("#pageSize").val(Number($pager.attr("pageSize")));
		postData();
	});
	
	$pager.bind("sizeChange",function(e,num){
		pageSize = num;
		$("#pageSize").val(pageSize);
		postData();
	});
	
	changeSortStyle();
	
	//监听查询框的回车事件
	 $("#query_userName").keydown(function(event){
	 	if(event.keyCode==13){
			searchHandler();
		}
	 })
	 
	 $("#searchPanel").bind("stateChange",function(e,state){
		if(state=="hide"){
			fixObjHeight=120;
		}
		else if(state=="show"){
			fixObjHeight=165;
		}
		triggerCustomHeightSet();
	});
}


//初始化排序样式
function changeSortStyle(){
	var sortName = $("#sort").val();
	var direction = $("#direction").val();
	var th_span = $("#span_" + sortName);
	th_span.removeClass("sort_off");
	if("asc" == direction){
		th_span.addClass("sort_up");
	}else{
		th_span.addClass("sort_down");
	}
}

//排序	
function sortHandler(sortName){
	var currentSort = $("#sort").val();
	var currentDirection = $("#direction").val();
	if(sortName == currentSort){
		if(currentDirection == "asc"){
			$("#direction").val("desc");
		}else{
			$("#direction").val("asc")
		}
	}else{
		$("#sort").val(sortName);
		$("#direction").val("asc");
	}
	postData();
}

//新增
function addUnit() {
	top.Dialog.open({
			URL:"<%=path%>/sample/unit/user-management-content.jsp",
			Title:"添加",Width:500,Height:350});
}

//查看
function onView(rowid){
	top.Dialog.open({
		URL:"<%=path%>/getUserDetail.action?userinfor.userId=" + rowid,
		Title:"查看",Width:500,Height:350});
}

//修改
function onEdit(rowid){
	if(getPosition(rowid,noeditArray)!=-1){
			top.Dialog.alert("为保证数据的完整性，由管理员添加的数据无法修改或删除。可以为新添加的数据来修改和删除。");
			return false;
		}
	top.Dialog.open({
		URL:"<%=path%>/preUpdateUser.action?userinfor.userId=" + rowid,
		Title:"修改",Width:500,Height:350});
}

//删除
function onDelete(rowid){
	if(getPosition(rowid,noeditArray)!=-1){
			//top.Dialog.alert("为保证数据的完整性，由管理员添加的数据无法修改或删除。可以为新添加的数据来修改和删除。");
			//return false;
		}
	top.Dialog.confirm("确定要删除该记录吗？",function(){
	  	//删除记录
	  	$.post("<%=path%>/deleteUser.action",
	  			{"ids":rowid},
	  			function(result){
	  				handleResult(result.status);
				},"json");
		});
}

//批量删除
function deleteUnit() {
	//top.Dialog.alert("为保证数据的完整性，演示版中禁用了批量删除。");

	var rows = $("td input:checkbox:checked");
	var rowsLength = rows.length;
	
	if(rowsLength == 0) {
		top.Dialog.alert("请选中要删除的记录!");
	}else{
		top.Dialog.confirm("确定要删除吗？",function(){
		$.post("<%=path%>/deleteUser.action",
			getSelectId(),
			function(result){
				handleResult(result.status);
			},
			"json");
		});
	}

}

//获取批量选中的行id
function getSelectId() {
	var ids = "";
	$("td input:checkbox:checked").each(function(){
		var value = $(this).attr("userid");
		if(value != null && "" != value){
			ids += value + ",";
		}
	})
	return {"ids":ids};
}

//删除记录后的处理
function handleResult(result){
	if(result == "1"){
		top.Dialog.alert("删除成功！");
		refresh(true);
	}else{
		top.Dialog.alert("删除失败！");
	}
}

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
	var url = "<%=path%>
		/exportData.action";
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

		//查询
		function searchHandler() {
			$("#userName").val($("#query_userName").val());
			postData();
		}

		//重置查询
		function resetSearch() {
			$("#query_userName").val("")
			$("#userName").val("");
			postData();
		}

		//提交表单
		function postData() {
			var myform = document.getElementById("usersForm");
			myform.submit();
		}

		//重新提交数据
		function refresh(isUpdate) {
			if (!isUpdate) {
				//重置排序
				$("#sort").val("userId");
				$("#direction").val("desc");
				//页号重置为1
				$("#pageNo").val("1");
			}
			postData();
		}

		function customHeightSet(contentHeight) {
			$("#scrollContent").height(contentHeight - fixObjHeight);
		}
	</script>
</body>
</html>