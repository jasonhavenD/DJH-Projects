<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>树的拖放</title>
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
	      <div>
			  <ul id="tree-1" class="ztree"></ul>
		  </div>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset>
	      <legend>2、事件控制</legend>
	      <p>树的拖拽成功后，可以再onDrop回调中进行持久化处理。</p>
	      <span>事件日志</span>
          <textarea id="log2" resize="true" readonly="readonly" style="height:170px; width:300px;"></textarea>
          <input type="button" value="清除日志" onclick="$('#log2').val('')"/>
	      <div>
			  <ul id="tree-2" class="ztree"></ul>
		  </div>
	  </fieldset>
	  <div class="height_15"></div>
	  
  </div>
 
 <script type="text/javascript">
	 
	 var setting1 = {
		edit: {
			enable: true,
			showRemoveBtn: false,
			showRenameBtn: false
		},
		callback:{
		    beforeDrag: beforeDrag1,
		    beforeDrop: beforeDrop1
		}
	};
	
	
	var zNodes1 = [
		{ id:1,   parentId:0, name:"随意拖拽 1", open:true},
		{ id:11,  parentId:1, name:"随意拖拽 1-1"},
		{ id:12,  parentId:1, name:"随意拖拽 1-2", open:true},
		{ id:121, parentId:12, name:"随意拖拽 1-2-1"},
		{ id:122, parentId:12, name:"随意拖拽 1-2-2"},
		{ id:123, parentId:12, name:"随意拖拽 1-2-3"},
		{ id:13,  parentId:1, name:"禁止拖拽 1-3", open:true, drag:false},
		{ id:131, parentId:13, name:"禁止拖拽 1-3-1", drag:false},
		{ id:132, parentId:13, name:"禁止拖拽 1-3-2", drag:false},
		{ id:133, parentId:13, name:"随意拖拽 1-3-3"},
		{ id:2,   parentId:0, name:"随意拖拽 2", open:true},
		{ id:21,  parentId:2, name:"随意拖拽 2-1"},
		{ id:22,  parentId:2, name:"禁止拖拽到我身上 2-2", open:true, drop:false},
		{ id:221, parentId:22, name:"随意拖拽 2-2-1"},
		{ id:222, parentId:22, name:"随意拖拽 2-2-2"},
		{ id:223, parentId:22, name:"随意拖拽 2-2-3"},
		{ id:23,  parentId:2, name:"随意拖拽 2-3"}
	];
	
	
	var setting2 = {
		edit: {
			enable: true,
			showRemoveBtn: false,
			showRenameBtn: false
		},
		callback:{
		    beforeDrag: beforeDrag2,
		    beforeDrop: beforeDrop2,
			beforeDragOpen: beforeDragOpen2,
			onDrag: onDrag2,
			onDrop: onDrop2
		}
	};
	
	
	function initComplete(){
		$.fn.zTree.init($("#tree-1"), setting1, zNodes1);
		$.fn.zTree.init($("#tree-2"), setting2, zNodes1);
	}
	
	//实现树的拖放，这个方法是必须的
	function beforeDrag1(treeId, treeNodes) {
		for (var i = 0, l = treeNodes.length; i < l; i++) {
			if(treeNodes[i].drag === false) {
				return false;
			}
		}
		return true;
	}
	
	//实现树的拖放，这个方法是必须的
	function beforeDrop1(treeId, treeNodes, targetNode, moveType) {
		return targetNode ? targetNode.drop !== false : true;
	}
	
	function beforeDrag2(treeId, treeNodes) {
		for (var i = 0, l = treeNodes.length; i < l; i++) {
			if(treeNodes[i].drag === false) {
				return false;
			}
		}
		for (var i = 0, l = treeNodes.length; i < l; i++) {
			appendToLog2('beforeDrag', treeNodes[i].id, treeNodes[i].name);
		}
		return true;
	}
	
	function beforeDrop2(treeId, treeNodes, targetNode, moveType) {
	    if(targetNode && targetNode.drop !== false){
	        appendToLog2('beforeDrop', targetNode.id, targetNode.name);
	        return true;
	    }
	    return false;
	}
	
	function beforeDragOpen2(treeId, treeNode){
	    appendToLog2('beforeDragOpen', treeNode.id, treeNode.name);
	}
	
	function onDrag2(event, treeId, treeNodes){
	    for (var i = 0, l = treeNodes.length; i < l; i++) {
			appendToLog2('onDrag', treeNodes[i].id, treeNodes[i].name);
		}
	}
	
	function onDrop2(event, treeId, treeNodes, targetNode, moveType, isCopy){
	    if(targetNode){
			appendToLog2('onDrop', targetNode.id, targetNode.name);
		}
	}
	
	//追加日志信息
	function appendToLog2(eventName, nodeId, nodeName){
	    $('#log2').val( function(index, val){
	       return val + "【" + eventName + "】 " + nodeId + "  " + nodeName + "\n";
	    });
	}
 

 </script>

</body>
</html>