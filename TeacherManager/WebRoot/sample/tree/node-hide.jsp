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

<!--树组件start -->
<script type="text/javascript" src="<%=path%>/libs/js/tree/ztree/ztree.js"></script>
<link href="<%=path%>/libs/js/tree/ztree/ztree.css" rel="stylesheet" type="text/css"/>
<!--树组件end -->

<!--树组件插件start -->
<script type="text/javascript" src="<%=path%>/libs/js/tree/ztree/exhide.js"></script>
<!--树组件插件end -->
<SCRIPT type="text/javascript">
		var zNodes =[
			{ id:1, parentId:0, name:"父节点1", title:"", open:true},
			{ id:11, parentId:1, name:"父节点11", title:"", open:true},
			{ id:111, parentId:11, name:"叶子节点111", title:"", isHidden:true},
			{ id:112, parentId:11, name:"叶子节点112", title:""},
			{ id:113, parentId:11, name:"叶子节点113", title:""},
			{ id:12, parentId:1, name:"父节点12", title:"", isHidden:true, open:true},
			{ id:121, parentId:12, name:"叶子节点121", title:""},
			{ id:122, parentId:12, name:"叶子节点122", title:"", isHidden:true},
			{ id:123, parentId:12, name:"叶子节点123", title:""},
			{ id:2, parentId:0, name:"父节点2", title:"", open:true},
			{ id:21, parentId:2, name:"父节点21", title:"", isHidden:true, open:true},
			{ id:211, parentId:21, name:"叶子节点211", title:""},
			{ id:212, parentId:21, name:"叶子节点212", title:""},
			{ id:213, parentId:21, name:"叶子节点213", title:""},
			{ id:22, parentId:2, name:"父节点22", title:"", open:true},
			{ id:221, parentId:22, name:"叶子节点221", title:""},
			{ id:222, parentId:22, name:"叶子节点222", title:""},
			{ id:223, parentId:22, name:"叶子节点223", title:""}
		];
		function initComplete(){
			$.fn.zTree.init($("#treeDemo"), {}, zNodes);
			$("#hideNodesBtn").bind("click", {type:"rename"}, hideNodes);
			$("#showNodesBtn").bind("click", {type:"icon"}, showNodes);
			setTitle();
			count();
		}
		
		function setTitle(node) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			var nodes = node ? [node]:zTree.transformToArray(zTree.getNodes());
			for (var i=0, l=nodes.length; i<l; i++) {
				var n = nodes[i];
				n.title = "[" + n.id + "] isFirstNode = " + n.isFirstNode + ", isLastNode = " + n.isLastNode;
				zTree.updateNode(n);
			}
		}
		function count() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			hiddenCount = zTree.getNodesByParam("isHidden", true).length;
			$("#hiddenCount").text(hiddenCount);
		}
		function showNodes() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			nodes = zTree.getNodesByParam("isHidden", true);
			zTree.showNodes(nodes);
			setTitle();
			count();
		}
		function hideNodes() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			nodes = zTree.getSelectedNodes();
			if (nodes.length == 0) {
				alert("请至少选择一个节点");
				return;
			}
			zTree.hideNodes(nodes);
			setTitle();
			count();
		}
		
		

	</SCRIPT>
</head>
<body>
	 <div class="box1" panelWidth="800">
     
      <fieldset>
          <legend>注意</legend>
          使用此功能，需要引入exhide插件，无需设置任何参数<br/>
          初始化时，设置数据的isHidden属性为true，可以让节点隐藏<br/>
          隐藏节点操作，会影响 isFirstNode 和 isLastNode 属性，但是对于 getPreNode() 和 getNextNode() 方法无影响<br/>
      </fieldset>
      <div class="height_15"></div>
      
      <fieldset>
          <legend>基本示例</legend>
         <ul id="treeDemo" class="ztree"></ul>
         isHidden = true 的节点共 <span id="hiddenCount" class="red"></span> 个<br/>
         <input type="button" value="隐藏选中的节点" id="hideNodesBtn"/>
         <input type="button" value="显示全部被隐藏的节点" id="showNodesBtn"/>
      <div class="height_15"></div>
      
    </div>
</body>
</html>