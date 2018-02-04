<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>多选下拉框</title>
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
<link type="text/css" rel="stylesheet" href="<%=path%>/libs/js/tree/ztree/ztree.css"></link>
<!-- 树组件end -->

<!-- 树形下拉框start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/selectTree.js"></script>
<!-- 树形下拉框end -->

</head>
<body>
   <div class="box1" panelWidth="800">
      
      <fieldset>
      	<legend>注意</legend>
多选下拉框实际是树形下拉框的衍伸，属性直接继承树形下拉框。	这些示例与“树形下拉框”用法类似：<br/>
       使用隐藏域，close事件， 禁用/启用，自定义图标，自定义节点展开/收缩时的图标，自定义尺寸（下拉框宽度和高度、文本框宽度），下拉框展开方向，可编辑，节点集成动态操作，表单重置。	请参考“树形下拉框”一节。<br/>
       
       
      </fieldset>
      <div class="height_15"></div>
      
     <fieldset>
     	<legend>1、基本多选下拉框(本地数据)</legend>
     	 <p>使用本地数据时，除了可以添加数据到组件标签的data属性中，还可以使用本地数据动态设置data。参见：“树形下拉框”</p>
     	  <div class="selectTree" id="selectTree1" multiMode="true" noGroup="true" data='{"treeNodes":[{ "id":"1", "parentId":"0", "name":"员工1"},{ "id":"2", "parentId":"0", "name":"员工2"},{ "id":"3", "parentId":"0", "name":"员工3"},{ "id":"4", "parentId":"0", "name":"员工4"}]}'></div>
   	   		<br/><input type="button" value="获取值" onclick="getValue()"/> 
   	</fieldset>
   	<div class="height_15"></div>
	
	<fieldset>
     	<legend>2、基本多选下拉框(远程数据)</legend>
     	 <div class="red">此示例由后台支持</div>
     	<p>使用远程数据时，除了使用url，还可以使用url+参数，ajax请求然后动态设置data。参见：“树形下拉框”</p>
     	<div class="selectTree" url="<%=path%>/form/getDepartmentList.action" multiMode="true" noGroup="true"></div>
		 
   	</fieldset>
   	<div class="height_15"></div>
	
	<fieldset>
     	<legend>3、树形多选下拉框(父节点不可选)</legend>
     	   <p>这里设置数据的父节点不可选，并且设置点击父节点展开子节点</p>
     	  <div class="selectTree" id="selectTree3" multiMode="true" keepDefaultStyle="true"></div>
       <br/>另外此处采用动态设置data方式获取数据。
   	</fieldset>
   	<div class="height_15"></div>
	
	<fieldset>
     	<legend>4、树形多选下拉框(父节点作为单独的一项可选)</legend>
     	   <div class="red">此示例由后台支持</div>
     	  <p>	这里设置数据的父节点可选，并且不展开子节点。这样点击就会选中该节点，子节点与父节点无关。</p>
     	  <div class="selectTree" url="<%=path%>/getDepartmentsTree.action" multiMode="true"></div>
       <br/>另外此处采用url方式获取数据。
   	</fieldset>
   	<div class="height_15"></div>
	
	<fieldset>
       <legend>5、树形多选下拉框(点击父节点全选)</legend>
       	 <p>设置点击展开子节点，然后设置组件可全选属性。这样点击会展开并全选子节点。</p>
       	 此示例全选后保留父节点的值。<br/>
       	 <div class="selectTree" id="selectTree5-1" multiMode="true" allSelectable="true" keepDefaultStyle="true"></div>
       		<br/><br/>
       		此示例全选后不保留父节点的值。<br/>
       	 <div class="selectTree" id="selectTree5-2" multiMode="true" allSelectable="true" exceptParent="true" keepDefaultStyle="true"></div>	
      </fieldset>
      <div class="height_15"></div>
	  
	   <fieldset>
			<legend>6、设置初始值</legend>
			<div class="selectTree" id="selectTree6" multiMode="true" selectedValue="11,12,21" data='{"treeNodes":[{"id":"1","parentId":"0","name":"部门部门部门部门部门部门部门部门1","nocheck":"true","clickExpand":"true","open":"true"},{"id":"11","parentId":"1", "name":"员工1"},{"id":"12","parentId":"1", "name":"员工2"},{"id":"13","parentId":"1", "name":"员工3"},{"id":"2","parentId":"0","name":"部门2","nocheck":"true","clickExpand":"true","open":"true"},{"id":"21","parentId":"2", "name":"员工4"}]}'></div>
			<br/><input type="button" value="获取值" onclick="getSelectValue()"/>
	  </fieldset>
	  <div class="height_15"></div> 
	  
	  <fieldset>
			<legend>7、动态生成树形下拉框</legend>
			 <div class="red">此示例由后台支持</div>
			<input type="button" value="点击生成(使用url)" style="width:120px;" id="testBtn" onclick="dynamicSelTreebox1()"/><br/><br/>
			<input type="button" value="点击生成(使用data)" style="width:120px;" id="testBtn2" onclick="dynamicSelTreebox2()"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset>
			<legend>8、动态修改树形下拉框</legend>
			<div class="selectTree" id="selectTree8" multiMode="true" data='{"treeNodes":[{"id":"1","parentId":"0","name":"部门1","nocheck":"true","clickExpand":"true","open":"true"},{"id":"11","parentId":"1", "name":"员工1"},{"id":"12","parentId":"1", "name":"员工2"},{"id":"13","parentId":"1", "name":"员工3"},{"id":"2","parentId":"0","name":"部门2","nocheck":"true","clickExpand":"true","open":"true"},{"id":"21","parentId":"2", "name":"员工4"}]}'></div>
			<br/><br/><input type="button" value="选中“员工1，员工4”" onclick="selectItem()" style="width:120px;"/>
			<input type="button" value="追加一项" onclick="appendItem()" style="width:120px;"/>
			<input type="button" value="移除“员工2”" onclick="removeItem()" style="width:120px;"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  
		<fieldset>
			<legend>9、获得选中节点自定义属性</legend>
			<div class="selectTree" id="selectTree9"  multiMode="true"  data='{"treeNodes":[{ "id":"1", "parentId":"0", "name":"部门1", "open": "true","myFlag":"部门1-自定义属性"},{ "id":"11", "parentId":"1", "name":"员工1","myFlag":"员工1-自定义属性"},{ "id":"12", "parentId":"1", "name":"员工2","myFlag":"员工2-自定义属性"},{ "id":"13", "parentId":"1", "name":"员工3","myFlag":"员工3-自定义属性"},{ "id":"2", "parentId":"0", "name":"部门2", "open": "true","myFlag":"部门2-自定义属性"},{ "id":"21", "parentId":"2", "name":"员工4","myFlag":"员工4-自定义属性"}]}'></div>
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset>
     	<legend>10、节点异步加载</legend>
     	    <div class="red">此示例由后台支持</div>
     	    <div class="selectTree" asyncMode="true" url="<%=path%>/getAsyncTree.action" multiMode="true"></div>
   	</fieldset>
   	<div class="height_15"></div>
	</div>


<script type="text/javascript">
	var zNodes2 ={"treeNodes":[
		{ id:1,  parentId:0, name:"部门1", nocheck:true, clickExpand:true},
		{ id:11, parentId:1, name:"员工1"},
		{ id:12, parentId:1, name:"员工2"},
		{ id:13, parentId:1, name:"员工3"},
		{ id:2,  parentId:0, name:"部门2",  nocheck:true, clickExpand:true},
		{ id:21, parentId:2, name:"员工4"}
	]};
	
	var zNodes3 ={"treeNodes":[
		{ id:1,  parentId:0, name:"部门1", clickExpand:true},
		{ id:11, parentId:1, name:"员工1"},
		{ id:12, parentId:1, name:"员工2"},
		{ id:13, parentId:1, name:"员工3"},
		{ id:2,  parentId:0, name:"部门2", clickExpand:true},
		{ id:21, parentId:2, name:"员工4"}
	]};
	
	
	function initComplete(){
		//赋给data
		$("#selectTree3").data("data",zNodes2); 
		$("#selectTree3").render();
		
		//赋给data
		$("#selectTree5-1").data("data",zNodes3); 
		$("#selectTree5-1").render();
		
		$("#selectTree5-2").data("data",zNodes3); 
		$("#selectTree5-2").render();
		
		//数据自定义属性
		$("#selectTree9").bind("change",function(){
	        if(!$(this).attr("relValue")){
	            top.Dialog.alert("没有选择节点");
	        }else{
	            var nodes=$(this).data("selectedNodes");
	            var values=[];
	            for(var i=0;i<nodes.length;i++){
	            	values.push(nodes[i].myFlag);
	            }
	            top.Dialog.alert(values.join(","))
	        }
    	})  
	}
	//获取值
	function getValue(){
		top.Dialog.alert("选中节点文本："+$("#selectTree1").attr("relText")+"<br/>选中节点id："+$("#selectTree1").attr("relValue"));
	}
	
	 //获取选择值
    function getSelectValue(){
		top.Dialog.alert("选中节点文本："+$("#selectTree6").attr("relText")+"<br/>选中节点id："+$("#selectTree6").attr("relValue"));
	}
	
	//动态生成树形下拉框（使用url）
function dynamicSelTreebox1(){
	//获取远程数据
		var $selTree = $('<div class="selectTree" multiMode="true"></div>');
		//设置url属性
		$selTree.attr("url","<%=path%>/getDepartmentsTree.action"); 
		//设置选中项
		$selTree.attr("selectedValue","11,12,23"); 
		//将下拉框加到按钮的后面
		$("#testBtn").after($selTree);   
		$("#testBtn").after("<br/>"); 
		//渲染树形下拉框 
		$selTree.render(); 
}
	
	//动态生成树形下拉框（使用data）
	function dynamicSelTreebox2(){
		//获取远程数据
		$.post("<%=path%>/getDepartmentsTree.action",{},function(result){
			var $selTree = $('<div class="selectTree" multiMode="true"></div>');
			//赋给data属性
			$selTree.attr("data",JSON.stringify(result)); 
			//设置选中项
			$selTree.attr("selectedValue","11,12,23"); 
			//将下拉框加到按钮的后面
			$("#testBtn2").after($selTree);   
			$("#testBtn2").after("<br/>"); 
			//渲染树形下拉框 
			$selTree.render(); 
		},"json");
	}
	
	//动态选中项
	function selectItem(){
	    $("#selectTree8").setValue("11,21"); 
	}
	//追加一项
	function appendItem(){
	   $("#selectTree8").addItem({id:100, parentId:2, name:"员工5"});
	}
	//移除项
	function removeItem(){
		$("#selectTree8").removeItem("12");
	}
</script>

</body>
</html>