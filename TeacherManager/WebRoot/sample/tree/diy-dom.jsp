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

<style>
.infoBtn{
	background-image: url(<%=path%>/sample/tree/list.gif)!important;
	background-repeat:no-repeat;
	background-position:0% 100%;
	width:20px!important;
	height:16px;
	display:inline-block;
}
.layerBtn{
	background-image: url(<%=path%>/sample/tree/layers.gif)!important;
	background-repeat:no-repeat;
	background-position:0% 100%;
	width:20px!important;
	height:16px;
	cursor:default!important;
	display:inline-block;
}
.globeBtn{
	background-image: url(<%=path%>/sample/tree/find.gif)!important;
	background-repeat:no-repeat;
	background-position:100% 0%!important;
	width:20px!important;
	height:16px;
	display:inline-block;
}
.arrowBtn{
	background-image: url(<%=path%>/sample/tree/chart.gif)!important;
	background-repeat:no-repeat;
	background-position:100% 0%!important;
	width:20px!important;
	height:16px;
	display:inline-block;
}
.diydom{
	width:300px;
}
.diydom li span{
	display:inline-block!important;
	float:left;
}
.diydomCon{
	width:200px;
	height:300px;
	border:solid 1px #cccccc;
	overflow:auto;
	background-color:#ffffff;
}
.hoverWidth{
	width:80px;
	overflow:hidden;
}
</style>
</head>
<body>
<div class="box1" panelWidth="600" panelHeight="600">
	隐藏了自带的图标，使用addDiyDom为树节点前添加图标，来实现可点击。<br/>
	使用addHoverDom实现鼠标移入后出现图标，并且可点击。<br/>
	<div class="diydomCon">
		  <ul id="tree-1" class="ztree diydom"></ul>
	  </div>
</div>
<script type="text/javascript">
	var curMenu = null, zTree_Menu = null;
    var nodes1 = [
		{ id:1,  parentId:0, name:"图层1",open:"true"},
		{ id:11, parentId:1, name:"元素1"},
		{ id:12, parentId:1, name:"元素2"},
		{ id:13, parentId:1, name:"元素名称很长元素名称很长"},
		{ id:2,  parentId:0, name:"图层2"},
		{ id:21, parentId:2, name:"元素4"},
		{ id:22, parentId:2, name:"元素5"},
		{ id:23, parentId:2, name:"元素6"}
	];
	 var setting1 = {
		view: {
			addDiyDom: addDiyDom,
			addHoverDom: addHoverDom,
			removeHoverDom:removeHoverDom,
			selectedMulti: false,
			showIcon:false,
			showLine: false
		},
		callback: {
			onClick: onNodeClick
		}
	};
	
	
	//点击节点时对level0的节点进行样式切换
	 function initComplete(){
        //本地数据源
		$.fn.zTree.init($("#tree-1"), setting1, nodes1);
    }
    
    function addDiyDom(treeId, treeNode) {
	   var aObj = $("#" + treeNode.tId + "_a");
	   aObj.addClass("addWidth");
	   if ($("#infoBtn_"+treeNode.id).length>0) return;
		var editStr 
		if(treeNode.isParent){
			editStr= "<span  class='layerBtn' id='parentBtn_" + treeNode.id
			+ "' onfocus='this.blur();'></span>";
		}
		else{
			editStr= "<span class='infoBtn' id='infoBtn_" + treeNode.id
			+ "' title='查看信息' onfocus='this.blur();'></span>";
			
		}
		aObj.prepend(editStr);
	var btn = $("#infoBtn_"+treeNode.id);
	if (btn) {
		btn.bind("click", function(){
			alert("查看信息：" + treeNode.name);
		});
	}
	
	};
	function addHoverDom(treeId, treeNode) {
	    if (treeNode.isParent||$("#globeBtn_" + treeNode.id).length > 0) return;
	    
		var sObj = $("#" + treeNode.tId + "_span");
		if(sObj.width()>80){
			sObj.addClass("hoverWidth");
		}
		var addStr = "<span  class='globeBtn' id='globeBtn_" + treeNode.id + "' title='周边查找' onfocus='this.blur();'></span>";
		sObj.after(addStr);
		
		var addStr2 = "<span class='arrowBtn' id='arrowBtn_" + treeNode.id + "' title='信息统计' onfocus='this.blur();'></span>";
		sObj.after(addStr2);
		
		var btn = $("#globeBtn_" + treeNode.id);
		if (btn){ 
		    btn.bind("click", function(){
				alert("周边查找：" + treeNode.name);
		   });
		}
		
		var btn2 = $("#arrowBtn_" + treeNode.id);
		if (btn2){ 
		    btn2.bind("click", function(){
				alert("信息统计：" + treeNode.name);
		   });
		}
	};
	function removeHoverDom(treeId, treeNode) {
		$("#globeBtn_" + treeNode.id).unbind().remove();
		$("#arrowBtn_" + treeNode.id).unbind().remove();
		var sObj = $("#" + treeNode.tId + "_span");
		sObj.removeClass("hoverWidth");
	};
	 function onNodeClick(event, treeId, treeNode){
	    var zTree = $.fn.zTree.getZTreeObj("tree-1");
		zTree.expandNode(treeNode);
    }  
	
</script>
</div>
</body>
</html>