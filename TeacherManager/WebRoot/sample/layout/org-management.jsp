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

<!--树组件start -->
<script type="text/javascript" src="<%=path%>/libs/js/tree/ztree/ztree.js"></script>
<link href="<%=path%>/libs/js/tree/ztree/ztree.css" rel="stylesheet" type="text/css"/>
<!--树组件end -->


</head>
<body>
<div class="box1" panelWidth="800">
		<table class="tableStyle" formMode="line">
			<tr>
				<td>选中节点：</td>
				<td><input type="text" style="width:300px;" id="selectNode" readOnly="true"/></td>
			</tr>
			<tr>
				<td>描述：</td>
				<td><input type="text" style="width:300px;" id="nodeDes"/></td>
			</tr>
			<tr>
				<td>负责人：</td>
				<td><input type="text" style="width:300px;" id="nodePerson"/></td>
			</tr>
			<tr>
				<td>电话：</td>
				<td><input type="text" style="width:300px;" id="nodePhone"/></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="button" value="确定"/>
				<input type="button" value="取消"/>
				</td>
			</tr>
		</table>
	</div>
	
  <div class="box1" panelWidth="800">
	      <div>
			  <ul id="tree-1" class="ztree"></ul>
		  </div>
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
			onClick: onClick1,
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
		{ id:1, parentId:0, name:"某某公司",icon:"<%=path%>/libs/icons/home.gif"}
	];
	
	function initComplete(){
		$.fn.zTree.init($("#tree-1"), setting1, zNodes1);
	}
	
	//点击
	function onClick1(event, treeId, treeNode, clickFlag){
    	//设置表单的值
    	setForm(treeNode.name,"","","");
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
		//设置表单的值
		setForm(treeNode.name,"","","");
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
		//设置表单的值
		setForm(treeNode.name,"","","");
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
				newNode = zTree.addNodes(treeNode, {id:(100 + newCount), parentId:treeNode.id, name:"新增" + (newCount++),icon:"<%=path%>/libs/icons/user_group.gif"});
				if (newNode) {
					zTree.editName(newNode[0]);
					//设置表单的值
					setForm(newNode[0].name,"","","");
				}
				return false;
		   });
		}
	};
	function removeHoverDom(treeId, treeNode) {
		$("#addBtn_" + treeNode.id).unbind().remove();
	};
	
	
	function setForm(val1,val2,val3,val4){
		$("#selectNode").val(val1);
		$("#nodeDes").val(val2);
		$("#nodePerson").val(val3);
		$("#nodePhone").val(val4);
	}
 
 </script>

</body>
</html>