<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>基本表格模板</title>
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

<!-- 树形下拉框start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/selectTree.js"></script>
<!-- 树形下拉框end -->

<!-- 条件过滤器 start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/filter.js"></script>
<!-- 条件过滤器 end -->
</head>
<body>
	<table width="100%" >
	<tr>
		<!--左侧区域start-->
		<td class="ver01" >
			 <div class="box2"  overflow="auto" showStatus="false" panelTitle="角色管理">
			 	<div id="cusBoxContent1"  style="width:150px;">
			  		<div>
			  		<form>
			  		<table width="100%">
			  			<tr><td>新增角色</td></tr>
			  			<tr><td class="ali02"><input type="text" id="roleName" style="width:120px;"/></td></tr>
			  			<tr><td class="ali02"><input type="button" value="确定" onclick="addTreeNodeHandler()"/>&nbsp;<input type="reset" value="重置"/></td></tr>
			  		</table>
			  		</form>
			  		</div>
			  		<ul id="tree-1" class="ztree"></ul>
			  	</div>
		  	</div>
		</td>
		<!--左侧区域end-->
		
		<!--右侧区域start-->
		<td width="100%" class="ver01" >
			<div class="box2" panelTitle="条件过滤"  showStatus="false">
				<table>
					<tr>
						<td>按部门筛选：</td>
						<td> <div class="selectTree"  id="selectTree1"></div></td>
						
					</tr>
				</table>
			</div>
				<div class="box2" panelTitle="为角色分配成员"  showStatus="false">
					<div id="cusBoxContent2"  >
					<form>
					<table width="100%">
						<tr><td>
						<div class="filter" id="filter1" groupMode="true" data='{"list":[{"name":"部门1","list":[{"key":"员工1","value":"11"},{"key":"员工2","value":"12"},{"key":"员工3","value":"13"},{"key":"员工2","value":"12"},{"key":"员工3","value":"13"}]},{"name":"部门2","list":[{"key":"员工4","value":"21"},{"key":"员工5","value":"22"},{"key":"员工6","value":"23"}]},{"name":"部门3","list":[{"key":"员工1","value":"11"},{"key":"员工2","value":"12"},{"key":"员工3","value":"13"},{"key":"员工2","value":"12"},{"key":"员工3","value":"13"}]},{"name":"部门4","list":[{"key":"员工4","value":"21"},{"key":"员工5","value":"22"},{"key":"员工6","value":"23"}]}]}'></div>
						</td></tr>
						<tr><td class="ali02"><input type="button" value="确定"/>&nbsp;<input type="reset" value="重置" onclick="resetForm()"/></td></tr>
					</table>
					</form>
					</div>
				</div>
			
		</td>
		<!--右侧区域end-->
	</tr>
	</table>
<script type="text/javascript">
	
	
	//选择的树节点
	var selectTreeNode = null;
	//树属性配置
	var selectionSetting = {
		view: {
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
	var nodes1 = [
		{ id:1,  parentId:0, name:"角色列表", open: true,icon:"<%=path%>/libs/icons/list.gif"}
	];
	
	var selectData ={"treeNodes":[
		{ id:1,  parentId:0, name:"中心1", open: true,icon:"<%=path%>/libs/icons/user_group.gif"},
		{ id:11, parentId:1, name:"部门1",icon:"<%=path%>/libs/icons/user_group.gif"},
		{ id:12, parentId:1, name:"部门2",icon:"<%=path%>/libs/icons/user_group.gif"},
		{ id:13, parentId:1, name:"部门3",icon:"<%=path%>/libs/icons/user_group.gif"},
		{ id:2,  parentId:0, name:"中心2", open: true,icon:"<%=path%>/libs/icons/user_group.gif"},
		{ id:21, parentId:2, name:"部门4",icon:"<%=path%>/libs/icons/user_group.gif"},
		{ id:22, parentId:2, name:"部门5",icon:"<%=path%>/libs/icons/user_group.gif"},
		{ id:23, parentId:2, name:"部门6",icon:"<%=path%>/libs/icons/user_group.gif"}
	]};
	function initComplete(){
		//初始化tree
		$.fn.zTree.init($("#tree-1"), selectionSetting, nodes1);
		
		$("#selectTree1").data("data",selectData);
		$("#selectTree1").render();
		
	}
	
	function beforeDrag1(treeId, treeNodes) {
		return false;
	}
	
	//确认是否进入编辑状态
	function beforeEditName1(treeId, treeNode) {
		if(treeNode.id=="1"){
			top.Dialog.alert("根节点不能修改！");
			return false;
		}
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
		if(treeNode.id=="1"){
			top.Dialog.alert("根节点不能删除！");
			return false;
		}
		var zTree = $.fn.zTree.getZTreeObj("tree-1");
		//选中该节点
		zTree.selectNode(treeNode);
		top.Dialog.confirm("确认删除 节点 -- " + treeNode.name + " 吗？",function(){
			zTree.removeNode(treeNode);
			//此处进行ajax后台数据处理
		});
		return false;
	}
	
	//添加树节点
	var newCount = 1;
	function addTreeNodeHandler(){
		var newName=$("#roleName").val();
		if(newName==""){
			top.Dialog.alert("请输入角色名称！");
			return;
		}
		var zTree = $.fn.zTree.getZTreeObj("tree-1");
		var treeNode=zTree.getNodeByParam("id", 1);
		if(treeNode){
			var newNode;
			newNode = zTree.addNodes(treeNode, {id:(100 + newCount), parentId:1, name:newName,icon:"<%=path%>/libs/icons/star.gif"});
		}
		$("#roleName").val("");
	}
	
	
	function resetForm(){
		$("#filter1").render();
	}
	
//高度处理	
function customHeightSet(contentHeight){
		$("#cusBoxContent1").height(contentHeight-55)
		$("#cusBoxContent2").height(contentHeight-140)
	}
</script>	
</body>
</html>