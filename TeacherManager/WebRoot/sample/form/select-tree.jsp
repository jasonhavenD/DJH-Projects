<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>树下拉框</title>
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
     	<legend>1、使用url赋值</legend>
     	  <div class="red">此示例由后台支持</div>
     	 <div class="selectTree" url="<%=path%>/getDepartmentsTree.action" id="selectTree1"></div>
   	   		<br/><input type="button" value="获取值" onclick="getValue()"/> 
   	   		
   	   		
   	</fieldset>
   	<div class="height_15"></div>
	
	<fieldset>  
       <legend>2、使用url+参数赋值</legend>
    	 <div class="red">此示例由后台支持</div>
    	<div class="selectTree" url="<%=path%>/getDepartmentsTree.action" params='{"organization.orgId":"1"}'></div>
	</fieldset>
     <div class="height_15"></div>
	 
	 <fieldset>  
       <legend>3、赋值给标签的data属性</legend>
	   <p>注意：使用json格式的字符串时所有节点的属性名与值都必须使用双引号</p>
	   <div class="selectTree" data='{"treeNodes":[{ "id":"1", "parentId":"0", "name":"部门1", "open": "true"},{ "id":"11", "parentId":"1", "name":"员工1"},{ "id":"12", "parentId":"1", "name":"员工2"},{ "id":"13", "parentId":"1", "name":"员工3"},{ "id":"2", "parentId":"0", "name":"部门2", "open": "true"},{ "id":"21", "parentId":"2", "name":"员工4"}]}'></div>
	</fieldset>
	<div class="height_15"></div>
	
	<fieldset>  
       <legend>4、动态设置data</legend>
    	 使用本地数据：<br/>
		 <div class="selectTree" id="selectTree4-1" keepDefaultStyle="true"></div>
       	<br/>
       	<br/>
       	使用远程数据：
       	 <div class="red">此示例由后台支持</div>
		 <div class="selectTree" id="selectTree4-2" keepDefaultStyle="true"></div>
	</fieldset>
	<div class="height_15"></div>
	
	<fieldset>
			<legend>5、使用隐藏域</legend>
			<p>如果为组件添加name属性，那么会自动生成一个隐藏域input，用来存储组件当前的value，该input的name与组件name一致。<br/>在提交表单时会用到。</p>
			 <div class="selectTree" name="selectTree5" data='{"treeNodes":[{ "id":"1", "parentId":"0", "name":"部门1", "open": "true"},{ "id":"11", "parentId":"1", "name":"员工1"},{ "id":"12", "parentId":"1", "name":"员工2"},{ "id":"13", "parentId":"1", "name":"员工3"},{ "id":"2", "parentId":"0", "name":"部门2", "open": "true"},{ "id":"21", "parentId":"2", "name":"员工4"}]}'></div>
			<br/><input type="button" value="获取隐藏域选中值" onclick="getHiddenValue()"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  
	   <fieldset>
			<legend>6、change事件</legend>
			使用bind方法绑定change事件<br/>
			<div class="selectTree" id="selectTree6" data='{"treeNodes":[{ "id":"1", "parentId":"0", "name":"部门1", "open": "true"},{ "id":"11", "parentId":"1", "name":"员工1"},{ "id":"12", "parentId":"1", "name":"员工2"},{ "id":"13", "parentId":"1", "name":"员工3"},{ "id":"2", "parentId":"0", "name":"部门2", "open": "true"},{ "id":"21", "parentId":"2", "name":"员工4"}]}'></div>
	  </fieldset>
	  <div class="height_15"></div>
	
	 <fieldset>
			<legend>7、设置某些节点不可选择</legend>
			<p>设置父节点不可选时，点击父节点会自动展开子节点。<br/>
			除父节点外，子节点也可设置不可选。</p>
			<div class="selectTree"  data='{"treeNodes":[{ "id":"1", "parentId":"0", "name":"部门1","clickExpand":"true"},{ "id":"11", "parentId":"1", "name":"员工1"},{ "id":"12", "parentId":"1", "name":"员工2"},{ "id":"13", "parentId":"1", "name":"员工3"},{ "id":"2", "parentId":"0", "name":"部门2","clickExpand":"true"},{ "id":"21", "parentId":"2", "name":"员工4(不可选)","clickExpand":"true"}]}'></div>
			
	  </fieldset>
	  <div class="height_15"></div>
	
	<fieldset>  
       <legend>8、禁用/启用</legend>
	   <div class="selectTree" id="selectTree8" disabled="true" data='{"treeNodes":[{ "id":"1", "parentId":"0", "name":"部门1", "open": "true"},{ "id":"11", "parentId":"1", "name":"员工1"},{ "id":"12", "parentId":"1", "name":"员工2"},{ "id":"13", "parentId":"1", "name":"员工3"},{ "id":"2", "parentId":"0", "name":"部门2", "open": "true"},{ "id":"21", "parentId":"2", "name":"员工4"}]}'></div>
	   <br/>
	   <input type="button" value="启用" onclick="enableSelectTree()"/>
		<input type="button" value="禁用" onclick="disableSelectTree()"/>
	</fieldset>
	<div class="height_15"></div>
	
	<fieldset>
			<legend>9、自定义图标</legend>
			<div class="selectTree" id="selectTree9" keepDefaultStyle="true"></div>
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset>
			<legend>10、宽度、高度与方向</legend>
			下拉框默认为120px宽度，当有较长的选项时，下拉框宽度默认不变，而选项容器宽度自适应<br/>
			<div class="selectTree" data='{"treeNodes":[{ "id":"1", "parentId":"0", "name":"部门1", "open": "false"},{ "id":"11", "parentId":"1", "name":"很长的选项很长的选项"},{ "id":"12", "parentId":"1", "name":"员工2"},{ "id":"13", "parentId":"1", "name":"员工3"},{ "id":"2", "parentId":"0", "name":"部门2", "open": "true"},{ "id":"21", "parentId":"2", "name":"员工4"}]}'></div>
			<br/><br/>
			单独设置下拉框宽度，选项容器宽度默认不会小于下拉框宽度<br/>
			<div class="selectTree" selWidth="250" data='{"treeNodes":[{ "id":"1", "parentId":"0", "name":"部门1", "open": "true"},{ "id":"11", "parentId":"1", "name":"很长的选项很长的选项"},{ "id":"12", "parentId":"1", "name":"员工2"},{ "id":"13", "parentId":"1", "name":"员工3"},{ "id":"2", "parentId":"0", "name":"部门2", "open": "true"},{ "id":"21", "parentId":"2", "name":"员工4"}]}'></div>
			<br/><br/>
			自定义容器高度<br/>
			<div class="selectTree"  boxHeight="100"   data='{"treeNodes":[{ "id":"1", "parentId":"0", "name":"部门1", "open": "true"},{ "id":"11", "parentId":"1", "name":"很长的选项很长的选项"},{ "id":"12", "parentId":"1", "name":"员工2"},{ "id":"13", "parentId":"1", "name":"员工3"},{ "id":"2", "parentId":"0", "name":"部门2", "open": "true"},{ "id":"21", "parentId":"2", "name":"员工4"}]}'></div>
			<br/><br/>
			强制向上展开<br/>
			<div class="selectTree" openDirection="top" data='{"treeNodes":[{ "id":"1", "parentId":"0", "name":"部门1", "open": "true"},{ "id":"11", "parentId":"1", "name":"很长的选项很长的选项"},{ "id":"12", "parentId":"1", "name":"员工2"},{ "id":"13", "parentId":"1", "name":"员工3"},{ "id":"2", "parentId":"0", "name":"部门2", "open": "true"},{ "id":"21", "parentId":"2", "name":"员工4"}]}'></div>
			
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset>
			<legend>11、可编辑树形下拉框</legend>
			<div class="selectTree" id="selectTree11" editable="true" data='{"treeNodes":[{ "id":"1", "parentId":"0", "name":"部门1", "open": "true"},{ "id":"11", "parentId":"1", "name":"员工1"},{ "id":"12", "parentId":"1", "name":"员工2"},{ "id":"13", "parentId":"1", "name":"员工3"},{ "id":"2", "parentId":"0", "name":"部门2", "open": "true"},{ "id":"21", "parentId":"2", "name":"员工4"}]}'></div>
			<br/><input type="button" value="获取值" onclick="getEditSelectValue()"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset>
			<legend>12、设置初始值</legend>
			<div class="selectTree" id="selectTree12" selectedValue="13" data='{"treeNodes":[{ "id":"1", "parentId":"0", "name":"部门1", "open": "true"},{ "id":"11", "parentId":"1", "name":"员工1"},{ "id":"12", "parentId":"1", "name":"员工2"},{ "id":"13", "parentId":"1", "name":"员工3"},{ "id":"2", "parentId":"0", "name":"部门2", "open": "true"},{ "id":"21", "parentId":"2", "name":"员工4"}]}'></div>
			<br/><input type="button" value="获取值" onclick="getSelectValue()"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset>
			<legend>13、多选下拉框与多选树形下拉框</legend>
			<p>在此框架中，多选下拉框是树形下拉框的一种使用模式，详情见“多选下拉框”。</p>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset>
			<legend>14、动态生成树形下拉框</legend>
			 <div class="red">此示例由后台支持</div>
			<input type="button" value="点击生成(使用url)" style="width:120px;" id="testBtn" onclick="dynamicSelTreebox1()"/><br/><br/>
			<input type="button" value="点击生成(使用data)" style="width:120px;" id="testBtn2" onclick="dynamicSelTreebox2()"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset>
			<legend>15、动态修改树形下拉框</legend>
			<div class="selectTree" id="selectTree15" data='{"treeNodes":[{ "id":"1", "parentId":"0", "name":"部门1", "open": "true"},{ "id":"11", "parentId":"1", "name":"员工1"},{ "id":"12", "parentId":"1", "name":"员工2"},{ "id":"13", "parentId":"1", "name":"员工3"},{ "id":"2", "parentId":"0", "name":"部门2", "open": "true"},{ "id":"21", "parentId":"2", "name":"员工4"}]}'></div>
			<br/><br/><input type="button" value="选中“员工1”" onclick="selectSecondItem()" style="width:105px;"/>
			<input type="button" value="追加一项" onclick="appendItem()" style="width:105px;"/>
			<input type="button" value="移除“员工2”" onclick="removeItem()" style="width:105px;"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset>
			<legend>16、节点集成动态操作（自定义的树形下拉框）</legend>
			<div id="customSelectTree"  keepDefaultStyle="true" selWidth="200" data='{"treeNodes":[{ "id":"1", "parentId":"0", "name":"部门1", "open": "true"},{ "id":"11", "parentId":"1", "name":"员工1"},{ "id":"12", "parentId":"1", "name":"员工2"},{ "id":"13", "parentId":"1", "name":"员工3"},{ "id":"2", "parentId":"0", "name":"部门2", "open": "true"},{ "id":"21", "parentId":"2", "name":"员工4"}]}'></div>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  
	   <fieldset>
			<legend>17、重置树形下拉框</legend>
			<form id="form-17">
				<table class="tableStyle" formMode="transparent" style="width:400px;">
					<tr>
						<td>传统表单元素：</td>
						<td><input type="text"/></td>
					</tr>
					<tr>
						<td>树形下拉框1：</td>
						<td><div class="selectTree" data='{"treeNodes":[{ "id":"1", "parentId":"0", "name":"部门1", "open": "true"},{ "id":"11", "parentId":"1", "name":"员工1"},{ "id":"12", "parentId":"1", "name":"员工2"},{ "id":"13", "parentId":"1", "name":"员工3"},{ "id":"2", "parentId":"0", "name":"部门2", "open": "true"},{ "id":"21", "parentId":"2", "name":"员工4"}]}'></div></td>
					</tr>
					<tr>
						<td>树形下拉框2：</td>
						<td><div class="selectTree" selectedValue="21" data='{"treeNodes":[{ "id":"1", "parentId":"0", "name":"部门1", "open": "true"},{ "id":"11", "parentId":"1", "name":"员工1"},{ "id":"12", "parentId":"1", "name":"员工2"},{ "id":"13", "parentId":"1", "name":"员工3"},{ "id":"2", "parentId":"0", "name":"部门2", "open": "true"},{ "id":"21", "parentId":"2", "name":"员工4"}]}'></div></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="button" value="提交"/> 
							<input type="button" value="重置" onclick="resetForm()"/>
						</td>
					</tr>
				</table>
			</form>
			
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset>
			<legend>18、获得选中节点自定义属性</legend>
			<div class="selectTree" id="selectTree18"  data='{"treeNodes":[{ "id":"1", "parentId":"0", "name":"部门1", "open": "true","myFlag":"部门1-自定义属性"},{ "id":"11", "parentId":"1", "name":"员工1","myFlag":"员工1-自定义属性"},{ "id":"12", "parentId":"1", "name":"员工2","myFlag":"员工2-自定义属性"},{ "id":"13", "parentId":"1", "name":"员工3","myFlag":"员工3-自定义属性"},{ "id":"2", "parentId":"0", "name":"部门2", "open": "true","myFlag":"部门2-自定义属性"},{ "id":"21", "parentId":"2", "name":"员工4","myFlag":"员工4-自定义属性"}]}'></div>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset>
     	<legend>19、节点异步加载</legend>
     	    <div class="red">此示例由后台支持</div>
     	    <div class="selectTree" asyncMode="true" url="<%=path%>/getAsyncTree.action"></div>
   	</fieldset>
   	<div class="height_15"></div>
   	
   	 <fieldset>
			<legend>20、数据无前缀</legend>
			<div class="selectTree" data='[{ "id":"1", "parentId":"0", "name":"部门1", "open": "true"},{ "id":"11", "parentId":"1", "name":"员工1"},{ "id":"12", "parentId":"1", "name":"员工2"},{ "id":"13", "parentId":"1", "name":"员工3"},{ "id":"2", "parentId":"0", "name":"部门2", "open": "true"},{ "id":"21", "parentId":"2", "name":"员工4"}]'></div>
	  </fieldset>
	  <div class="height_15"></div>
	  

	</div>


<script type="text/javascript">
	/*构建树节点数据*/
	var defaultNodes = {"treeNodes":[
		{ id:1, parentId:0, name:"部门1", open: true},
		{ id:11, parentId:1, name:"员工1"},
		{ id:12, parentId:1, name:"员工2"},
		{ id:13, parentId:1, name:"员工3"},
		{ id:2, parentId:0, name:"部门2", open: true},
		{ id:21, parentId:2, name:"员工4"}
	]};
	
	var iconNodes = {"treeNodes":[
		{ id:1, parentId:0, name:"部门1",clickExpand:true,icon:"<%=path%>/libs/icons/user_group.gif"},
		{ id:11, parentId:1, name:"员工1",icon:"<%=path%>/libs/icons/user.gif"},
		{ id:12, parentId:1, name:"员工2",icon:"<%=path%>/libs/icons/user_female.gif"},
		{ id:13, parentId:1, name:"员工3",icon:"<%=path%>/libs/icons/user_worker.gif"},
		{ id:2, parentId:0, name:"部门2",clickExpand:true,icon:"<%=path%>/libs/icons/user_group.gif"},
		{ id:21, parentId:2, name:"员工4",icon:"<%=path%>/libs/icons/user.gif"}
	]};
	
	
	function initComplete(){
		//赋给data属性
		$("#selectTree4-1").data("data",defaultNodes); 
		$("#selectTree4-1").render();
		
		
		//获取远程数据
		$.post("<%=path%>/getDepartmentsTree.action",{},function(result){
				//赋给data属性
				$("#selectTree4-2").data("data",result); 
				//刷新树形下拉框
				$("#selectTree4-2").render();
			},"json");
		
		
		//绑定change事件
		$("#selectTree6").bind("change",function(){
			if(!$(this).attr("relValue")){
		        top.Dialog.alert("没有选择节点");
		    }else{
		        top.Dialog.alert("选中节点文本："+$(this).attr("relText")+"<br/>选中节点值："+$(this).attr("relValue"));
		    }
		})	
			
			
		//赋给data属性
		$("#selectTree9").data("data",iconNodes);  
		$("#selectTree9").render();
		
		
		//渲染自定义下拉框
		$("#customSelectTree").selectTreeRender(setting17);
		
		//数据自定义属性
		$("#selectTree18").bind("change",function(){
	        if(!$(this).attr("relValue")){
	            top.Dialog.alert("没有选择节点");
	        }else{
	            var node=$(this).data("selectedNode");
	            top.Dialog.alert(node.myFlag);
	        }
    	})  
		
	}
	//获取值
	function getValue(){
		top.Dialog.alert("选中节点文本："+$("#selectTree1").attr("relText")+"<br/>选中节点id："+$("#selectTree1").attr("relValue"));
	}
	
	//获取隐藏域值
	function getHiddenValue(){
		top.Dialog.alert($("input:hidden[name='selectTree5']").val());
	}
	
	
	//禁用
    function disableSelectTree(){
        $("#selectTree8").attr("disabled",true);
		$("#selectTree8").render(); 
    }
    
    //启用
    function enableSelectTree(){
        $("#selectTree8").attr("disabled",false);
		$("#selectTree8").render(); 
    }
	
	 //通过editValue属性获取下拉树的文本值，包括编辑的文本 及 选中的文本
    function getEditSelectValue(){
        top.Dialog.alert($("#selectTree11").attr("editValue"));
    }
	
	 //获取选择值
    function getSelectValue(){
		top.Dialog.alert("选中节点文本："+$("#selectTree12").attr("relText")+"<br/>选中节点id："+$("#selectTree12").attr("relValue"));
	}
	
	//动态生成树形下拉框（使用url）
	function dynamicSelTreebox1(){
		//获取远程数据
			var $selTree = $('<div class="selectTree"></div>');
			//设置url属性
			$selTree.attr("url","<%=path%>/getDepartmentsTree.action"); 
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
			var $selTree = $('<div class="selectTree"></div>');
			//赋给data属性
			$selTree.data("data",result); 
			//将下拉框加到按钮的后面
			$("#testBtn2").after($selTree);   
			$("#testBtn2").after("<br/>"); 
			//渲染树形下拉框 
			$selTree.render(); 
		},"json");
	}
	
	//动态选中项
	function selectSecondItem(){
	    $("#selectTree15").setValue("11"); 
	}
	//追加一项
	function appendItem(){
	   $("#selectTree15").addItem({id:100, parentId:2, name:"员工5"});
	    $("#selectTree15").setValue("100"); 
	}
	//移除项
	function removeItem(){
		$("#selectTree15").removeItem("12");
	}
	
	//表单重置
	function resetForm(){
		 $("#form-17")[0].reset();
		 $("#form-17 .selectTree").resetValue(); 
	}
	
	
	/*以下为示例16所用到*/
	//自定义树形下拉框的设置
	var setting17 = {
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
		data: {
			simpleData: {
				enable: true
			}
		},
		callback: {
			onClick: zTreeSelectItemClick,
			//不允许拖拽
			beforeDrag: beforeDrag,
			//修改完时的处理
			beforeRename: beforeRename,
			//修改成功后处理
			onRename: onRename,
			onRemove:onRemove
		}
	};
	
	//不允许拖拽
	function beforeDrag(treeId, treeNodes) {
		return false;
	}
	//修改完时的处理
	function beforeRename(treeId, treeNode, newName) {
		if (newName.length == 0) {
			alert("节点名称不能为空.");
			var treeContainer=$("#customSelectTree ul[class=ztree]");
			var zTree = $.fn.zTree.getZTreeObj(treeContainer.attr("id"));
			setTimeout(function(){
			    zTree.editName(treeNode)
			}, 10);
			return false;
		}
		return true;
	}
	
	//修改成功后处理
	function onRename(e, treeId, treeNode) {
		//此处进行ajax后台数据处理
	}
	
	//删除处理
	function onRemove(treeId, treeNode) {
		//ajax处理
	}
	
	//添加新增按钮
	var newCount = 1;
	
	function addHoverDom(treeId, treeNode){
		var sObj = $("#" + treeNode.tId + "_span");
		if (treeNode.editNameFlag || $("#addBtn_" + treeNode.id).length > 0) return;
		var addStr = "<span class='zbutton add' id='addBtn_" + treeNode.id + "' title='添加' onfocus='this.blur();'></span>";
		sObj.append(addStr);
		var btn = $("#addBtn_" + treeNode.id);
		if (btn){
			btn.bind("click", function(){
				var treeContainer=$("#customSelectTree ul[class=ztree]");
				var zTree = $.fn.zTree.getZTreeObj(treeContainer.attr("id"));
				var newNode = zTree.addNodes(treeNode, {
				    id: 100 + newCount, 
				    parentId: treeNode.id, 
				    name:"新增" + newCount++
				 });
				//ajax处理
				if (newNode) {
					zTree.editName(newNode[0]);
				}
				return false;
			});
		} 
	}
	
	function removeHoverDom(treeId, treeNode) {
		$("#addBtn_"+treeNode.id).unbind().remove();
	};
	
</script>

</body>
</html>