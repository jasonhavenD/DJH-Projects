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
				<td>
					<input type="text" style="width:300px;" id="selectNode" readOnly="true"/>
					<input type="hidden" id="selectNodeid"/>
				</td>
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
				<input type="button" id="btn_update" value="确定"/>
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
	//设定不可编辑的节点id
	var noeditArray=["1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17"];
	
	 //树的设置
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
		}};
	
	//定义树节点初始数据
	var zNodes1 =[
		{ id:"0", parentId:"-1", name:"组织结构树", open:true,icon:"<%=path%>/libs/icons/home.gif"}
	];
	
	//初始化函数
	function initComplete(){
		//初始化树
		getOrgTreeData();
		
		//监听按钮点击事件
		$("#btn_update").click(function(){
			var orgId = $("#selectNodeid").val();
			var orgName = $("#selectNode").val();
			var orgDesc = $("#nodeDes").val();
			var orgManager = $("#nodePerson").val();
			var orgPhone = $("#nodePhone").val();
			//此处进行ajax后台数据处理
			$.post("<%=path%>/updateOtherInfo.action",
				   {"organization.orgId" : orgId,
				    "organization.orgName" :orgName,
				    "organization.orgDescription" : orgDesc,
				    "organization.orgManager" : orgManager,
				    "organization.orgPhone" : orgPhone},
				   function(result){
				       var organization = result.organization;
					   if(organization != null){
						   var node = getTree().getNodesByParam("id",organization.orgId,null)[0];
						   node.desc = organization.orgDescription;
						   node.manager = organization.orgManager;
						   node.phone = organization.orgPhone;
						   getTree().updateNode(node, false);
						 	//设置表单的值
						   setForm(node.name,node.desc,node.manager,node.phone);
						   top.Dialog.alert("修改节点信息成功！");
					   }else{
						   top.Dialog.alert("修改节点信息失败！");
					   }
				   });
		});
	}
	
	//获取数据初始化树
	function getOrgTreeData(){
		$.ajax({
			type : 'POST',
			url : '<%=path%>/getDepartmentsTree.action',
			data : null,
			success : function(result){
				var nodes = zNodes1.concat(result.treeNodes);
				$.fn.zTree.init($("#tree-1"), setting1, nodes);
			},
			error : function(a){
				top.Dialog.alert("访问服务器端出错！");
			},
			dataType : 'json'
		});
	}
	
	
	//获取树对象
	function getTree(){
		return $.fn.zTree.getZTreeObj("tree-1");
	}
	
	//点击树节点
	function onClick1(event, treeId, treeNode, clickFlag){
    	//设置表单的值
		setForm(treeNode.name,treeNode.desc,treeNode.manager,treeNode.phone);
    	$("#selectNodeid").val(treeNode.id);
    }
	
	//不允许拖拽
	function beforeDrag1(treeId, treeNodes) {
		return false;
	}
	
	//确认是否进入编辑状态
	function beforeEditName1(treeId, treeNode) {
		if(treeNode.id==0){
			top.Dialog.alert("根节点不能修改！");
			return false;
		}
		else if(getPosition(treeNode.id,noeditArray)!=-1){
			//top.Dialog.alert("为保证数据的完整性，由管理员添加的数据无法修改或删除。可以为新添加的数据来修改和删除。");
			//return false;
		}
		var zTree = getTree();
		//选中该节点
		zTree.selectNode(treeNode);
		//设置表单的值
		setForm(treeNode.name,treeNode.desc,treeNode.manager,treeNode.phone);
		zTree.editName(treeNode);
		return true;
	}
	
	//修改完时处理 不进行后台数据处理
	function beforeRename1(treeId, treeNode, newName) {
		if (newName.length == 0) {
			top.Dialog.alert("节点名称不能为空.");
			var zTree = getTree();
			setTimeout(function(){zTree.editName(treeNode)}, 10);
			return false;
		}
		return true;
	}
	//修改成功后处理
	function onRename1(event, treeId, treeNode) {
		if(treeNode.existed){
			updateNode(treeNode);
		}else{
			addNode(treeNode);
		}
	}
	
	//添加节点
	function addNode(treeNode){
		//设置表单的值
		setForm(treeNode.name,"","","");
		//此处进行ajax后台数据处理
		$.post("<%=path%>/insertOrganization.action",		//数据提交的地址
			   {"organization.orgName" : treeNode.name,
				"organization.orgParentid" : treeNode.getParentNode().id},				//提交的数据
			   function(result){									//回调函数
					var org = result.organization;
			   		if(org != null && org.orgId != null && org.orgId != ""){
			   			$("#selectNodeid").val(org.orgId);
			   			treeNode.id = org.orgId;
			   			treeNode.name = org.orgName;
			   			treeNode.existed = true;
			   			getTree().updateNode(treeNode, false);
			   		}else{
			   			getTree().removeNode(treeNode, false);
			   			setForm("","","","");
			   			top.Dialog.alert("创建失败！");
			   		}
			   });												//预期返回的数据类型
	}
	
	
	//修改节点名称
	function updateNode(treeNode){
		//此处进行ajax后台数据处理
		$.post("<%=path%>/updateOrganizationName.action",		//数据提交的地址
			   {"organization.orgId" : treeNode.id,					//提交的数据
				"organization.orgName" : treeNode.name},				
			   function(result){									//回调函数
					var org = result.organization;
			   		if(org != null && org.orgId != null && org.orgId != ""){
			   			treeNode.id = org.orgId;
			   			treeNode.name = org.orgName;
			   			setForm(treeNode.name,treeNode.desc,treeNode.manager,treeNode.phone);
			   			getTree().updateNode(treeNode, false);
			   			top.Dialog.alert("修改成功！");
			   		}else{
			   			setForm("","","","");
			   			top.Dialog.alert("修改失败！");
			   		}
			   });												//预期返回的数据类型
	}
	
	
	//确认是否删除+删除处理
	function beforeRemove1(treeId, treeNode) {
		if(treeNode.id==0){
			top.Dialog.alert("根节点不能删除！");
			return false;
		}
		else if(getPosition(treeNode.id,noeditArray)!=-1){
			//top.Dialog.alert("为保证数据的完整性，由管理员添加的数据无法修改或删除。可以为新添加的数据来修改和删除。");
			//return false;
		}
		var zTree = $.fn.zTree.getZTreeObj("tree-1");
		//选中该节点
		zTree.selectNode(treeNode);
		top.Dialog.confirm("确认删除 节点 -- " + treeNode.name + " 吗？",function(){
			//此处进行ajax后台数据处理
			$.post("<%=path%>/deleteDepartment.action",
				   {"organization.orgId" : treeNode.id},
				   function(result){
					   if(result == '1'){
						   zTree.removeNode(treeNode);
						 	//设置表单的值
							setForm("","","","");
					   }else{
						   top.Dialog.alert("删除节点失败！");
					   }
				   });
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
	
	//设置表单值
	function setForm(val1,val2,val3,val4){
		$("#selectNode").val(val1 == 'null' ? '' : val1);
		$("#nodeDes").val(val2 == 'null' ? '' : val2);
		$("#nodePerson").val(val3 == 'null' ? '' : val3);
		$("#nodePhone").val(val4 == 'null' ? '' : val4);
	}
	
 
 </script>
</body>
</html>