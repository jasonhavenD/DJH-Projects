<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!-- 树组件start -->
<script type="text/javascript" src="<%=path%>/libs/js/tree/ztree/ztree.js"></script>
<link type="text/css" rel="stylesheet" href="<%=path%>/libs/js/tree/ztree/ztree.css"></link>
<!-- 树组件end -->

<!-- 树形双选器start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/listerTree.js"></script>
<!-- 树形双选器end -->

<!-- 树形下拉框start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/selectTree.js"></script>
<!-- 树形下拉框end -->
</head>
<body>
 <div class="box1" panelWidth="800">
 <table class="tableStyle" formMode="line">
 	<tr>
 		<td>选择用户1：</td>
 		<td><input type="text" onclick="showPersonList()" readOnly="true" id="userName"/> &nbsp; &nbsp; （用户数量大时使用这种方式）</td>
 	</tr>
 	<tr>
 		<td>选择用户2：</td>
 		<td><div class="selectTree" id="selectTree1"></div>&nbsp; &nbsp; &nbsp; （用户数量小时使用这种方式）</td>
 	</tr>
 	<tr>
 		<td>分配权限：</td>
 		<td><div class="listerTree" id="listerTree1" listerHeight="300"></div></td>
 	</tr>
 	<tr>
		<td colspan="2">
		<input type="button" value="确定"/>
		<input type="button" value="取消"/>
		</td>
	</tr>
 </table>
 </div>
<script>
	var selectData ={"fromList":[
		{ id:1,  parentId:0, name:"栏目1", open: true,"oldParentId":"null","drag":"false",icon:"<%=path%>/libs/icons/list.gif"},
		{ id:11, parentId:1, name:"资源1","oldParentId":"1",icon:"<%=path%>/libs/icons/mark.gif"},
		{ id:12, parentId:1, name:"资源2","oldParentId":"1",icon:"<%=path%>/libs/icons/mark.gif"},
		{ id:13, parentId:1, name:"资源3","oldParentId":"1",icon:"<%=path%>/libs/icons/mark.gif"},
		{ id:2,  parentId:0, name:"栏目2", open: true,"oldParentId":"null","drag":"false",icon:"<%=path%>/libs/icons/list.gif"},
		{ id:21, parentId:2, name:"资源4","oldParentId":"2",icon:"<%=path%>/libs/icons/mark.gif"},
		{ id:22, parentId:2, name:"资源5","oldParentId":"2",icon:"<%=path%>/libs/icons/mark.gif"},
		{ id:23, parentId:2, name:"资源6","oldParentId":"2",icon:"<%=path%>/libs/icons/mark.gif"}
	],"toList":[]};
	var userData ={"treeNodes":[
		{ id:1,  parentId:0, name:"部门1", open: true,icon:"<%=path%>/libs/icons/user_group.gif"},
		{ id:11, parentId:1, name:"员工1",icon:"<%=path%>/libs/icons/user.gif"},
		{ id:12, parentId:1, name:"员工2",icon:"<%=path%>/libs/icons/user.gif"},
		{ id:13, parentId:1, name:"员工3",icon:"<%=path%>/libs/icons/user.gif"},
		{ id:2,  parentId:0, name:"部门2", open: true,icon:"<%=path%>/libs/icons/user_group.gif"},
		{ id:21, parentId:2, name:"员工4",icon:"<%=path%>/libs/icons/user.gif"},
		{ id:22, parentId:2, name:"员工5",icon:"<%=path%>/libs/icons/user.gif"},
		{ id:23, parentId:2, name:"员工6",icon:"<%=path%>/libs/icons/user.gif"}
	]};
	function initComplete(){
		$("#selectTree1").data("data",userData);
		$("#selectTree1").render();
		
		$("#listerTree1").data("data",selectData);
		$("#listerTree1").render();
		
	}
	function showPersonList(){
		var diag = new top.Dialog();
		diag.Title = "选择用户";
		diag.ID="a1",
		diag.OKEvent = function(){
			top.document.getElementById("_DialogFrame_a1").contentWindow.selectUser();
		};
		diag.CancelEvent = function(){
			diag.close();
			};
		diag.URL = "<%=path%>/sample/layout/user-assignment-content.jsp";
		diag.Width=610;
		diag.ShowButtonRow=true;
		diag.show();
	}
</script>
</body>
</html>