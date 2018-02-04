<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>右键菜单</title>
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!-- ztree start -->
<script type="text/javascript" src="<%=path%>/libs/js/tree/ztree/ztree.js"></script>
<link href="<%=path%>/libs/js/tree/ztree/ztree.css" rel="stylesheet" type="text/css"/>
<!-- ztree end -->

</head>
<body>
   
   	<div class="b-m-mpanel" style="width: 150px;visibility:hidden;" id="rMenu">
		<div class="b-m-item" id="m_add" onclick="addTreeNode();">
			<img align="middle" src="<%=path%>/libs/images/icons/add.png"/><span>增加节点</span>
		</div>
		<div class="b-m-item" id="m_del" onclick="removeTreeNode();">
			<img align="middle" src="<%=path%>/libs/images/icons/close.png"/><span>删除节点</span>
		</div>
		<div class="b-m-item" id="m_check" onclick="checkTreeNode(true);">
			<img align="middle" src="<%=path%>/libs/images/icons/ico4.gif"/><span>勾选节点</span>
		</div>
		<div class="b-m-item" id="m_unCheck" onclick="checkTreeNode(false);">
			<img align="middle" src="<%=path%>/libs/images/icons/ico4-3.gif"/><span>取消勾选节点</span>
		</div>
		<div class="b-m-item" id="m_reset" onclick="resetTree();">
			<img align="middle" src="<%=path%>/libs/images/icons/ico4-1-1.gif"/><span>恢复</span>
		</div>
	</div>
   
   
   
   <div class="box1" panelWidth="800">
      
      <fieldset>
	      <div>
			  <ul id="tree-1" class="ztree"></ul>
		  </div>
	  </fieldset>
	  
   </div>
 
 <script type="text/javascript">
 	
 	var zTree;
	
	var setting = {
		view: {
			dblClickExpand: false
		},
		check: {
			enable: true
		},
		callback: {
			//响应右键
			onRightClick: OnRightClick
		}
	};
	
	var zNodes = [
		{id:1,  parentId:0, name:"无右键菜单", open:true, noR:true},
		{id:11, parentId:1, name:"无右键菜单", open:true, noR:true},
		{id:12, parentId:1, name:"无右键菜单", open:true, noR:true},
		{id:2,  parentId:0, name:"右键菜单类型1", open:true, menuType:"nonLeafMenu"},
		{id:21, parentId:2, name:"右键菜单类型2", open:true, menuType:"leafMenu"},
		{id:22, parentId:2, name:"右键菜单类型2", open:true, menuType:"leafMenu"}
 	];
 	
 	function initComplete(){
		$.fn.zTree.init($("#tree-1"), setting, zNodes);
		zTree = $.fn.zTree.getZTreeObj("tree-1");
	
		//鼠标移入右键菜单效果
		$("#rMenu >div").hover(function(){
			$(this).addClass("b-m-ifocus");
		},function(){
			$(this).removeClass("b-m-ifocus");
		});
	}
	 
	
	//点击右键处理
	function OnRightClick(event, treeId, treeNode) {
		//在节点之外显示一种菜单
		if (!treeNode && event.target.tagName.toLowerCase() != "button" && $(event.target).parents("a").length == 0) {
			zTree.cancelSelectedNode();
			showRMenu("root", event.clientX, event.clientY);
		//在节点里面显示另一种菜单
		} else if(treeNode && !treeNode.noR) {
			zTree.selectNode(treeNode);
			showRMenu(treeNode.menuType, event.clientX, event.clientY);
		}
	}
	
	 //根据设置弹出不同的右键菜单
	function showRMenu(type, x, y) {
		$("#rMenu ul").show();
		if(type == "root") {//树节点外只保留添加和恢复
			$("#m_add").show();
			$("#m_del").show();
			$("#m_check").show();
			$("#m_unCheck").show();
			$("#m_reset").show();
			
			$("#m_del").hide();
			$("#m_check").hide();
			$("#m_unCheck").hide();
			
		}else if(type == "nonLeafMenu") {//父节点保留添加和删除
			$("#m_add").show();
			$("#m_del").show();
			$("#m_check").show();
			$("#m_unCheck").show();
			$("#m_reset").show();
			
			$("#m_reset").hide();
			$("#m_check").hide();
			$("#m_unCheck").hide();
			$("#m_reset").hide();
		
		}else if(type == "leafMenu") {//子节点保留选择和删除
			$("#m_add").show();
			$("#m_del").show();
			$("#m_check").show();
			$("#m_unCheck").show();
			$("#m_reset").show();
			
			$("#m_add").hide();
			$("#m_reset").hide();
		}
	
		$("#rMenu").css({"top":y+"px", "left":x+"px", "visibility":"visible"});
	
		//点击菜单外时隐藏菜单
		$("body").bind("mousedown", onBodyMouseDown);
	}

	//点击菜单项时隐藏菜单
	function hideRMenu() {
		if ($("#rMenu")) $("#rMenu").css({"visibility": "hidden"});
		$("body").unbind("mousedown", onBodyMouseDown);
	}
	
	//点击菜单外时隐藏菜单
	function onBodyMouseDown(event){
		if (!(event.target.id == "rMenu" || $(event.target).parents("#rMenu").length > 0)) {
			$("#rMenu").css({"visibility" : "hidden"});
		}
	}

	//以下是点击右键菜单的处理函数
	var addCount = 1;
	
	//添加节点
	function addTreeNode() {
		hideRMenu();
		zTree.addNodes(zTree.getSelectedNodes()[0], [{ name:"增加" + (addCount++),menuType:"type2"}]);
	}

	//确认是否删除+删除处理
	function removeTreeNode() {
		hideRMenu();
		var nodes = zTree.getSelectedNodes();
		if (nodes && nodes.length > 0) {
			if (nodes[0].children && nodes[0].children.length > 0) {
				var msg = "要删除的节点是父节点，如果删除将连同子节点一起删掉。\n\n请确认！";
				top.Dialog.confirm(msg, function(){
					zTree.removeNode(nodes[0]);
					//此处进行ajax后台数据处理
				});
			} else {
				top.Dialog.confirm("确认删除 节点 -- " + nodes[0].name + " 吗？",function(){
					zTree.removeNode(nodes[0]);
					//此处进行ajax后台数据处理
				});
			}
		}
	}
	
	
	// 勾选/取消勾选节点
	function checkTreeNode(checked) {
		var nodes = zTree.getSelectedNodes();
		if (nodes && nodes.length>0) {
			zTree.checkNode(nodes[0], checked, true);
		}
		hideRMenu();
	}
	
	//树的状态的重置
	function resetTree() {
		hideRMenu();
		$.fn.zTree.init($("#tree-1"), setting, zNodes);
	}
	
 </script>

</body>
</html>