<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>树的编辑</title>
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
  <div class="box1" panelWidth="800">
      
      <fieldset>
	      <legend>1、基本使用</legend>
	      <p>可以返回单根树或多根树</p>
	      <div>
			  <ul id="tree-1" class="ztree"></ul>
		  </div>
	  </fieldset>
	  
  </div>
 
 <script type="text/javascript">
	 var setting1 = {
		view: {
			addHoverDom: addHoverDom,
			removeHoverDom: removeHoverDom,
			selectedMulti: false
		},
		edit: {
			enable: true,
			renameTitle:"修改",
			removeTitle:"删除"
		},
		callback: {
			//不允许拖拽
			beforeDrag: beforeDrag1,
			//修改前确认
			beforeEditName: beforeEditName1,
			//修改完时的处理
			beforeRename: beforeRename1,
			//修改成功后处理
			onRename: onRename1,
			//删除前确认
			beforeRemove: beforeRemove1
		}
	};
	var zNodes1 =[
		{ id:1, parentId:0, name:"父节点 1", open:true},
		{ id:11, parentId:1, name:"叶子节点 1-1"},
		{ id:12, parentId:1, name:"叶子节点 1-2"},
		{ id:13, parentId:1, name:"叶子节点 1-3"},
		{ id:2, parentId:0, name:"父节点 2", open:true},
		{ id:21, parentId:2, name:"叶子节点 2-1"},
		{ id:22, parentId:2, name:"叶子节点 2-2"},
		{ id:23, parentId:2, name:"叶子节点 2-3"},
		{ id:3, parentId:0, name:"父节点 3", open:true},
		{ id:31, parentId:3, name:"叶子节点 3-1"},
		{ id:32, parentId:3, name:"叶子节点 3-2"},
		{ id:33, parentId:3, name:"叶子节点 3-3"}
	];
	
	function initComplete(){
		$.fn.zTree.init($("#tree-1"), setting1, zNodes1);
	}
	
	function beforeDrag1(treeId, treeNodes) {
		return false;
	}
	
	//确认是否进入编辑状态
	function beforeEditName1(treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj("tree-1");
		//选中该节点
		zTree.selectNode(treeNode);
		zTree.editName(treeNode);
		return true;
	}
	
	//修改完时处理 不进行后台数据处理
	function beforeRename1(treeId, treeNode, newName) {
		if (newName.length == 0) {
			top.Dialog.alert("节点名称不能为空.");
			var zTree = $.fn.zTree.getZTreeObj("tree-1");
			setTimeout(function(){zTree.editName(treeNode)}, 10);
			return false;
		}
		return true;
	}
	//修改成功后处理
	function onRename1(event, treeId, treeNode) {
		//此处进行ajax后台数据处理
	}
	
	//确认是否删除+删除处理
	function beforeRemove1(treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj("tree-1");
		//选中该节点
		zTree.selectNode(treeNode);
		top.Dialog.confirm("确认删除 节点 -- " + treeNode.name + " 吗？",function(){
			zTree.removeNode(treeNode);
			//此处进行ajax后台数据处理
		});
		return false;
	}
	
	//添加新增按钮
	var newCount = 1;
	function addHoverDom(treeId, treeNode) {
	    if (treeNode.editNameFlag || $("#addBtn_" + treeNode.id).length > 0) return;
	    
		var sObj = $("#" + treeNode.tId + "_span");
		var addStr = "<span class='zbutton add' id='addBtn_" + treeNode.id + "' title='添加' onfocus='this.blur();'></span>";
		sObj.append(addStr);
		
		var btn = $("#addBtn_" + treeNode.id);
		if (btn){ 
		    btn.bind("click", function(){
				var zTree = $.fn.zTree.getZTreeObj("tree-1");
				var newNode;
				newNode = zTree.addNodes(treeNode, {id:(100 + newCount), parentId:treeNode.id, name:"新增" + (newCount++)});
				if (newNode) {
					zTree.editName(newNode[0]);
				}
				return false;
		   });
		}
	};
	function removeHoverDom(treeId, treeNode) {
		$("#addBtn_" + treeNode.id).unbind().remove();
	};
	
	
 
 </script>

</body>
</html>