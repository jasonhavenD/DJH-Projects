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

<!-- 树形双选器start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/listerTree.js"></script>
<!-- 树形双选器end -->

</head>
<body>
	<table width="100%" >
	<tr>
		<!--左侧区域start-->
		<td class="ver01" >
			 <div class="box2"  overflow="auto" showStatus="false" panelTitle="角色列表">
			 	<div id="cusBoxContent1"  style="width:150px;">
			  		<ul id="tree-1" class="ztree"></ul>
			  	</div>
		  	</div>
		</td>
		<!--左侧区域end-->
		
		<!--右侧区域start-->
		<td width="100%" class="ver01" >
				<div class="box2" panelTitle="为角色分配资源"  showStatus="false">
					<div id="cusBoxContent2"  >
					<form>
					<table width="500">
						<tr><td>
						<div class="listerTree" id="listerTree1" fromTitle="未选资源" toTitle="已选资源" listerHeight="300"></div>
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
	
	var nodes1 = [
		{ id:1,  parentId:0, name:"角色列表", open: true,icon:"<%=path%>/libs/icons/list.gif"},
		{ id:11, parentId:1, name:"公司总经理",icon:"<%=path%>/libs/icons/star.gif"},
		{ id:12, parentId:1, name:"产品经理",icon:"<%=path%>/libs/icons/star.gif"},
		{ id:13, parentId:1, name:"项目经理",icon:"<%=path%>/libs/icons/star.gif"},
		{ id:14, parentId:1, name:"办公室主任",icon:"<%=path%>/libs/icons/star.gif"},
		{ id:15, parentId:1, name:"测试人员",icon:"<%=path%>/libs/icons/star.gif"},
		{ id:16, parentId:1, name:"程序开发人员",icon:"<%=path%>/libs/icons/star.gif"},
		{ id:17, parentId:1, name:"界面设计师",icon:"<%=path%>/libs/icons/star.gif"},
		{ id:18, parentId:1, name:"前台",icon:"<%=path%>/libs/icons/star.gif"}
	];
	
	var selectData ={"fromList":[
		{ id:1,  parentId:0, name:"栏目1", open: true,"oldParentId":"null","drag":"false",icon:"<%=path%>/libs/icons/list.gif"},
		{ id:11, parentId:1, name:"资源1","oldParentId":"1",icon:"<%=path%>/libs/icons/mark.gif"},
		{ id:12, parentId:1, name:"资源2","oldParentId":"1",icon:"<%=path%>/libs/icons/mark.gif"},
		{ id:13, parentId:1, name:"资源3","oldParentId":"1",icon:"<%=path%>/libs/icons/mark.gif"},
		{ id:2,  parentId:0, name:"栏目2", open: true,"oldParentId":"null","drag":"false",icon:"<%=path%>/libs/icons/list.gif"},
		{ id:21, parentId:2, name:"资源4","oldParentId":"2",icon:"<%=path%>/libs/icons/mark.gif"},
		{ id:22, parentId:2, name:"资源5","oldParentId":"2",icon:"<%=path%>/libs/icons/mark.gif"},
		{ id:23, parentId:2, name:"资源6","oldParentId":"2",icon:"<%=path%>/libs/icons/mark.gif"}
	],"toList":[]};
	function initComplete(){
		//初始化tree
		$.fn.zTree.init($("#tree-1"), {}, nodes1);
		
		$("#listerTree1").data("data",selectData);
		$("#listerTree1").render();
	}
	
	function resetForm(){
		$("#listerTree1").render();
	}
	
	
//高度处理	
function customHeightSet(contentHeight){
	$("#cusBoxContent1").height(contentHeight-55)
	$("#cusBoxContent2").height(contentHeight-55)
}
</script>	
</body>
</html>