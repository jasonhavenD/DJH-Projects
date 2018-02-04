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
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/" scrollerY="false"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!--树组件start -->
<script type="text/javascript" src="<%=path%>/libs/js/tree/ztree/ztree.js"></script>
<link href="<%=path%>/libs/js/tree/ztree/ztree.css" rel="stylesheet" type="text/css"/>
<!--树组件end -->

<!--动态选项卡start-->
<script type="text/javascript" src="<%=path%>/libs/js/nav/dynamicTab.js"></script>
<!--动态选项卡end-->
</head>
<body>
<table width="100%">
		<tr>
			<td class="ver01">
				<div class="box2" overflow="auto" showStatus="false" panelTitle="导航菜单">
					<div class="cusBoxContent" style="width:150px;">
						<ul id="tree1" class="ztree"></ul>
					</div>
				</div>
			</td>
			<td width="100%" class="ver01">
				<div id="tab_menu"></div>
				<div class="box1">
					<div id="page" style="width:100%;"></div>
				</div>
			</td>
		</tr>
	</table>
<script>
	var setting = {
	data: {
		simpleData: {
			enable: true
		}
	},
	callback: {
		onClick: treeOnClick
	}
};

var nodes1 = [
		{ id:1,  parentId:0, name:"中心1", open: true,icon:"<%=path%>/libs/icons/user_group.gif"},
		{ id:11, parentId:1, name:"部门1人员列表",icon:"<%=path%>/libs/icons/user_group.gif",pageUrl:"<%=path%>/sample/layout/layout-htab-content2.jsp"},
		{ id:12, parentId:1, name:"部门2人员列表",icon:"<%=path%>/libs/icons/user_group.gif",pageUrl:"<%=path%>/sample/layout/layout-htab-content2.jsp"},
		{ id:13, parentId:1, name:"部门3人员列表",icon:"<%=path%>/libs/icons/user_group.gif",pageUrl:"<%=path%>/sample/layout/layout-htab-content2.jsp"},
		{ id:2,  parentId:0, name:"中心2", open: true,icon:"<%=path%>/libs/icons/user_group.gif"},
		{ id:21, parentId:2, name:"部门4人员列表",icon:"<%=path%>/libs/icons/user_group.gif",pageUrl:"<%=path%>/sample/layout/layout-htab-content2.jsp"},
		{ id:22, parentId:2, name:"部门5人员列表",icon:"<%=path%>/libs/icons/user_group.gif",pageUrl:"<%=path%>/sample/layout/layout-htab-content2.jsp"},
		{ id:23, parentId:2, name:"部门6人员列表",icon:"<%=path%>/libs/icons/user_group.gif",pageUrl:"<%=path%>/sample/layout/layout-htab-content2.jsp"},
		{ id:24, parentId:2, name:"部门7人员列表",icon:"<%=path%>/libs/icons/user_group.gif",pageUrl:"<%=path%>/sample/layout/layout-htab-content2.jsp"},
		{ id:25, parentId:2, name:"部门8人员列表",icon:"<%=path%>/libs/icons/user_group.gif",pageUrl:"<%=path%>/sample/layout/layout-htab-content2.jsp"},
		{ id:26, parentId:2, name:"部门9人员列表",icon:"<%=path%>/libs/icons/user_group.gif",pageUrl:"<%=path%>/sample/layout/layout-htab-content2.jsp"},
		{ id:27, parentId:2, name:"部门10人员列表",icon:"<%=path%>/libs/icons/user_group.gif",pageUrl:"<%=path%>/sample/layout/layout-htab-content2.jsp"}
	];
 var tab;
function initComplete(){
	$.fn.zTree.init($("#tree1"), setting, nodes1);
	
	 tab = new TabView( {
		containerId :'tab_menu',
		pageid :'page',
		cid :'tab1',
		position :"top"
	});
	tab.add( {
		id :'tab1_index1',
		title :"表单填写",
		url :"<%=path%>/sample/layout/layout-htab-content1.jsp",
		isClosed :false
	});
}
function treeOnClick(e,treeId, treeNode) {
	if(treeNode.pageUrl!=null){
		showProgressBar();
		//调用方法弹出tab
		tabAddHandler(treeNode.id,treeNode.name,treeNode.pageUrl)
	}
}
function tabAddHandler(mid,mtitle,murl){
		tab.add( {
		id :mid,
		title :mtitle,
		url :murl,
		isClosed :true
	});
	tab.activate(mid)
}
	

function customHeightSet(contentHeight){
	$(".cusBoxContent").height(contentHeight-50)
	$("#page").height(contentHeight-50);
}
</script>
</body>
</html>