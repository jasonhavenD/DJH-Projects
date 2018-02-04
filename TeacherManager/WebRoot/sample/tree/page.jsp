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
<link href="<%=path%>/libs/js/tree/ztree/ztree.css" rel="stylesheet" type="text/css"/>
<!-- 树组件end -->

<!--箭头分页start-->
<script type="text/javascript" src="<%=path%>/libs/js/nav/pageArrow.js"></script>
<!--箭头分页end-->
<SCRIPT type="text/javascript">
		var setting = {
			async: {
				enable: true,
				dataType: 'JSON',
				//返回的JSON数据的名字
				dataName: 'treeNodes',
				url: getUrl
			},
			callback: {
				//beforeExpand: beforeExpand,
				onAsyncSuccess: onAsyncSuccess,
				onAsyncError: onAsyncError
			}
		};

		var zNodes =[
			{id:0,name:"分页测试",isParent:true,open:true},
			{id:1,name:"节点1",parentId:0},
			{id:2,name:"节点2",parentId:0},
			{id:3,name:"节点3",parentId:0},
			{id:4,name:"节点4",parentId:0},
			{id:5,name:"节点5",parentId:0},
			{id:6,name:"节点6",parentId:0},
			{id:7,name:"节点7",parentId:0},
			{id:8,name:"节点8",parentId:0},
			{id:9,name:"节点9",parentId:0},
			{id:10,name:"节点10",parentId:0}
		];
		var curPage = 0;
		function getUrl(treeId, treeNode) {
			//var param = "id="+ treeNode.id +"_"+curPage +"&count="+Number($("#pager").attr("pageSize")),
			//var param="id=11&name=节点11";
			return "<%=path%>/getPagedTree.action?fromIndex="+curPage;
		}
		function goPage() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			var node = zTree.getNodeByParam("id", 0, null);
			zTree.reAsyncChildNodes(node, "refresh");
		}
		function beforeExpand(treeId, treeNode) {
			if (treeNode.page == 0) treeNode.page = 1;
			return !treeNode.isAjaxing;
		}
		function onAsyncSuccess(event, treeId, treeNode, msg) {
		}
		function onAsyncError(event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			alert("异步获取数据出现异常。");
			treeNode.icon = "";
			zTree.updateNode(treeNode);
		}
		
		function initComplete(){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			$("#pager").attr("total",100);
			$("#pager").render();
			$("#pager").bind("pageChange",function(e,idx){
				curPage=idx;
				goPage();
			})
		}
	</SCRIPT>
</head>
<body>
<div class="box1" panelWidth="800">
	<div style="width:200px;height:300px;border:solid 1px #cccccc;overflow-x:hidden;overflow-y:auto;">
	<ul id="treeDemo" class="ztree"></ul>
	</div>
	<div class="pageArrow" keepDefaultStyle="true" id="pager"></div>
</div>
</body>
</html>