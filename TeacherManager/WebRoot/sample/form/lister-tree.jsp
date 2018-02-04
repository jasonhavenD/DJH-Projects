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

<!-- 树组件start -->
<script type="text/javascript" src="<%=path%>/libs/js/tree/ztree/ztree.js"></script>
<link type="text/css" rel="stylesheet" href="<%=path%>/libs/js/tree/ztree/ztree.css"></link>
<!-- 树组件end -->

<!-- 树形双选器start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/listerTree.js"></script>
<!-- 树形双选器end -->
</head>
<body>
  <div class="box1" panelWidth="800">
   
   	<fieldset>
     	<legend>注意</legend>
     	<p>树形双选器中，可以通过点击节点右侧图标或者拖拽节点进行选择</p>
   	</fieldset>
   	  <div class="height_15"></div>
   	  
   	  <fieldset>
     	<legend>1、使用url赋值</legend>
     	    <div class="red">此示例由后台支持</div>
     	    <div class="listerTree" id="listerTree1" url="<%=path%>/form/getTreeLister.action"></div>
   	   		<input type="button" value="获取值" onclick="getValue()"/> 
   	   		<input type="button" value="获取选中项文本" onclick="getText()"/> 
   	   		<input type="button" value="获取选中项数据" onclick="getData()"/> 
   	</fieldset>
   	<div class="height_15"></div>
   	
   	 <fieldset>  
       <legend>2、使用url+参数赋值</legend>
    	 <div class="red">此示例由后台支持</div>
    	<div class="listerTree" id="listerTree1" url="<%=path%>/form/getTreeLister.action"  params='{"orgid":"2"}'></div>
	</fieldset>
     <div class="height_15"></div>
     
      <fieldset>  
       <legend>3、赋值给标签的data属性</legend>
    	 <div class="listerTree" data='{"toList":[],"fromList":[{"id":"1","parentId":"0","open":"true","name":"部门1","oldParentId":"null","drag":"false"},{"id":"11","parentId":"1","name":"员工1","oldParentId":"1"},{"id":"12","parentId":"1","name":"员工2","oldParentId":"1"},{"id":"13","parentId":"1","name":"员工3","oldParentId":"1","drag":"false"},{"id":"2","parentId":"0","open":"true","name":"部门2","oldParentId":"null","drag":"false"},{"id":"21","parentId":"2","name":"员工4","oldParentId":"2"}]}'></div>
		<br/>
		<span class="red">这里通过设置“员工3”节点的drag属性让其不可被选中</span>
	</fieldset>
	<div class="height_15"></div>

	 <fieldset>  
       <legend>4、动态设置data（本地数据源）</legend>
    	 <div class="listerTree" id="listerTree4" keepDefaultStyle="true"></div>
	</fieldset>
	<div class="height_15"></div>
	
	<fieldset>  
       <legend>5、动态设置data（远程数据源）</legend>
    	  <div class="red">此示例由后台支持</div>
    	 <div class="listerTree" id="listerTree5" keepDefaultStyle="true"></div>
	</fieldset>
	<div class="height_15"></div>
	
	
	<fieldset>  
       <legend>6、初始时存在已选值</legend>
       	<p>通过设置数据的toList内容来实现已选值</p>
    	 <div class="listerTree"  data='{"toList":[{"id":"11","parentId":"1","name":"员工1","oldParentId":"1"},{"id":"12","parentId":"1","name":"员工2","oldParentId":"1"}],"fromList":[{"id":"1","parentId":"0","open":"true","name":"部门1","oldParentId":"null","drag":"false"},{"id":"13","parentId":"1","name":"员工3","oldParentId":"1"},{"id":"2","parentId":"0","open":"true","name":"部门2","oldParentId":"null","drag":"false"},{"id":"21","parentId":"2","name":"员工4","oldParentId":"2"}]}'></div>
    	<br/> <p>通过设置selectedValue实现已选值</p>
    	  <div class="listerTree" selectedValue="11,12" data='{"toList":[],"fromList":[{"id":"1","parentId":"0","open":"true","name":"部门1","oldParentId":"null","drag":"false"},{"id":"11","parentId":"1","name":"员工1","oldParentId":"1"},{"id":"12","parentId":"1","name":"员工2","oldParentId":"1"},{"id":"13","parentId":"1","name":"员工3","oldParentId":"1"},{"id":"2","parentId":"0","open":"true","name":"部门2","oldParentId":"null","drag":"false"},{"id":"21","parentId":"2","name":"员工4","oldParentId":"2"}]}'></div>
    	  <br/>使用selectedValue实现了已选值，在操作后再使用render()方法刷新后可以还原为初始值。参见最后一个例子：重置树形双选器。
    	  <br/>通过设置数据的toList内容来实现已选值则不可以还原。
	</fieldset>
	<div class="height_15"></div>
	
	<fieldset>  
       <legend>7、使用隐藏域</legend>
    	<p>如果为组件添加name属性，那么会自动生成一个隐藏域input，用来存储组件当前的value，该input的name与组件name一致。<br/>在提交表单时会用到。</p>
    	 <div class="listerTree" name="listerTree7" data='{"toList":[],"fromList":[{"id":"1","parentId":"0","open":"true","name":"部门1","oldParentId":"null","drag":"false"},{"id":"11","parentId":"1","name":"员工1","oldParentId":"1"},{"id":"12","parentId":"1","name":"员工2","oldParentId":"1"},{"id":"13","parentId":"1","name":"员工3","oldParentId":"1"},{"id":"2","parentId":"0","open":"true","name":"部门2","oldParentId":"null","drag":"false"},{"id":"21","parentId":"2","name":"员工4","oldParentId":"2"}]}'></div>
		<input type="button" value="获取隐藏域选中值" onclick="getHiddenValue()"/>
	</fieldset>
	<div class="height_15"></div>
	
	<fieldset>  
       <legend>8、禁用/启用</legend>
    	 <div class="listerTree" id="listerTree8" disabled="true" data='{"toList":[],"fromList":[{"id":"1","parentId":"0","open":"true","name":"部门1","oldParentId":"null","drag":"false"},{"id":"11","parentId":"1","name":"员工1","oldParentId":"1"},{"id":"12","parentId":"1","name":"员工2","oldParentId":"1"},{"id":"13","parentId":"1","name":"员工3","oldParentId":"1"},{"id":"2","parentId":"0","open":"true","name":"部门2","oldParentId":"null","drag":"false"},{"id":"21","parentId":"2","name":"员工4","oldParentId":"2"}]}'></div>
    	 <br/>
			<input type="button" value="启用" onclick="enableLister()" style="width:120px;"/>
			<input type="button" value="禁用" onclick="disableLister()" style="width:120px;"/>
	</fieldset>
	<div class="height_15"></div>
		
     <fieldset>  
       <legend>9、自定义尺寸</legend>
    	 <div class="listerTree" listerWidth="140" listerHeight="180" data='{"toList":[],"fromList":[{"id":"1","parentId":"0","open":"true","name":"部门1","oldParentId":"null","drag":"false"},{"id":"11","parentId":"1","name":"员工1","oldParentId":"1"},{"id":"12","parentId":"1","name":"员工2","oldParentId":"1"},{"id":"13","parentId":"1","name":"员工3","oldParentId":"1"},{"id":"2","parentId":"0","open":"true","name":"部门2","oldParentId":"null","drag":"false"},{"id":"21","parentId":"2","name":"员工4","oldParentId":"2"}]}'></div>
	</fieldset>
	<div class="height_15"></div>
	
	<fieldset>  
       <legend>10、自定义图标</legend>
  <div class="listerTree" listerWidth="140" listerHeight="100" data='{"toList":[],"fromList":[{"id":"1","parentId":"0","open":"true","name":"部门","oldParentId":"null","icon":"<%=path%>/libs/icons/user_group.gif","drag":"false"},{"id":"11","parentId":"1","name":"小张","oldParentId":"1","icon":"<%=path%>/libs/icons/user_worker.gif"},{"id":"12","parentId":"1","name":"小王","oldParentId":"1","icon":"<%=path%>/libs/icons/user_worker.gif"},{"id":"13","parentId":"1","name":"小李","oldParentId":"1","icon":"<%=path%>/libs/icons/user_worker.gif"}]}'></div>
	</fieldset>
	<div class="height_15"></div>
	
	 <fieldset> 
			<legend>11、动态生成双选器</legend>
			 <div class="red">此示例由后台支持</div>
			<input type="button" value="点击生成（使用url）" id="testBtn" onclick="dynamicLister1()" style="width:150px;"/><br/><br/>
			<input type="button" value="点击生成（使用data）" id="testBtn2" onclick="dynamicLister2()" style="width:150px;"/><br/><br/>
	   </fieldset>
	   <div class="height_15"></div>
	
	  <fieldset>  
       <legend>12、动态改变</legend>
    	  <div class="listerTree" id="listTree12"  data='{"toList":[{"id":"11","parentId":"1","name":"员工1","oldParentId":"1"}],"fromList":[{"id":"1","parentId":"0","open":"true","name":"部门1","oldParentId":"null","drag":"false"},{"id":"12","parentId":"1","name":"员工2","oldParentId":"1"},{"id":"13","parentId":"1","name":"员工3","oldParentId":"1"},{"id":"2","parentId":"0","open":"true","name":"部门2","oldParentId":"null","drag":"false"},{"id":"21","parentId":"2","name":"员工4","oldParentId":"2"}]}'></div>	
			<br/>
			<input type="button" value="选中“员工3”" onclick="selectItems()" style="width:120px;"/>
			<input type="button" value="反选“员工1”" onclick="unSelectItems()" style="width:120px;"/>
			<input type="button" value="设值为“员工3,员工2”"" onclick="setValues()" style="width:120px;"/>
			<br/>
			<br/>
			<input type="button" value="追加一项" onclick="appendItem()" style="width:120px;"/>
			<input type="button" value="移除“员工1”" onclick="removeItem()" style="width:120px;"/>
			<br/>
			<br/>
			<input type="button" value="获取选中项文本" onclick="getText2()"/> 
			
	</fieldset>
	 <div class="height_15"></div>
	 
	 
	<fieldset>
			<legend>13、重置树形双选器</legend>
			<form id="form-13">
				<table class="tableStyle" formMode="transparent" style="width:500px;">
					<tr>
						<td>传统表单元素：</td>
						<td><input type="text"/></td>
					</tr>
					<tr>
						<td>双向选择器1：</td>
						<td> <div class="listerTree" selectedValue="" listerWidth="140" listerHeight="120" fromTitle="" toTitle="" data='{"toList":[],"fromList":[{"id":"1","parentId":"0","open":"true","name":"部门1","oldParentId":"null","drag":"false"},{"id":"11","parentId":"1","name":"员工1","oldParentId":"1"},{"id":"12","parentId":"1","name":"员工2","oldParentId":"1"},{"id":"13","parentId":"1","name":"员工3","oldParentId":"1"},{"id":"2","parentId":"0","open":"true","name":"部门2","oldParentId":"null","drag":"false"},{"id":"21","parentId":"2","name":"员工4","oldParentId":"2"}]}'></div>
					</tr>
					<tr>
						<td>双向选择器2：</td>
						<td><div class="listerTree" selectedValue="11,12" listerWidth="140" listerHeight="120" fromTitle="" toTitle="" data='{"toList":[],"fromList":[{"id":"1","parentId":"0","open":"true","name":"部门1","oldParentId":"null","drag":"false"},{"id":"11","parentId":"1","name":"员工1","oldParentId":"1"},{"id":"12","parentId":"1","name":"员工2","oldParentId":"1"},{"id":"13","parentId":"1","name":"员工3","oldParentId":"1"},{"id":"2","parentId":"0","open":"true","name":"部门2","oldParentId":"null","drag":"false"},{"id":"21","parentId":"2","name":"员工4","oldParentId":"2"}]}'></div></td>
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
       <legend>14、itemClick事件</legend>
    	 <div class="listerTree" id="listerTree14" data='{"toList":[],"fromList":[{"id":"1","parentId":"0","open":"true","name":"部门1","oldParentId":"null","drag":"false"},{"id":"11","parentId":"1","name":"员工1","oldParentId":"1"},{"id":"12","parentId":"1","name":"员工2","oldParentId":"1"},{"id":"13","parentId":"1","name":"员工3","oldParentId":"1"},{"id":"2","parentId":"0","open":"true","name":"部门2","oldParentId":"null","drag":"false"},{"id":"21","parentId":"2","name":"员工4","oldParentId":"2"}]}'></div>
	</fieldset>
	<div class="height_15"></div>
	
	<fieldset>
     	<legend>15、节点异步加载</legend>
     	    <div class="red">此示例由后台支持</div>
     	    <div class="listerTree" asyncMode="true" url="<%=path%>/getAsyncTree.action"></div>
   	</fieldset>
   	<div class="height_15"></div>
   	 
  </div>


<script type="text/javascript">
	//动态设置data
	function initComplete(){
		var selData={"toList":[],"fromList":[{"id":"1","parentId":"0","open":"true","name":"部门1","oldParentId":"null","drag":"false"},{"id":"11","parentId":"1","name":"员工1","oldParentId":"1"},{"id":"12","parentId":"1","name":"员工2","oldParentId":"1"},{"id":"13","parentId":"1","name":"员工3","oldParentId":"1"}]}
		//赋给data属性
		$("#listerTree4").data("data",selData)
		$("#listerTree4").render(); 
		
		//获取json数据
		$.post("<%=path%>/form/getTreeLister.action",{},function(result){
			//赋给data属性
			$("#listerTree5").data("data",result);
			$("#listerTree5").render(); 
	 		
		},"json");
		
		$("#listerTree14").bind("itemClick",function(e){
			alert("触发事件")
		})
	}
	
	//获取值
	function getValue(){
		top.Dialog.alert($("#listerTree1").attr("relValue"));
	}
	//获取选中项文本
	function getText(){
		alert($("#listerTree1").attr("relText"));
	}
	//获取数据
	function getData(){
		alert(JSON.stringify($("#listerTree1").data("selectedNodes")));
	}
	
	function getText2(){
		alert($("#listTree12").attr("relText"));
	}
	//获取隐藏域值
	function getHiddenValue(){
		top.Dialog.alert($("input:hidden[name='listerTree7']").val());
	}
	
	//启用
	function enableLister(){
		$("#listerTree8").attr("disabled",false);
		//刷新双选器
		$("#listerTree8").render(); 
	}
	
	//禁用
	function disableLister(){
		$("#listerTree8").attr("disabled",true);
		//刷新双选器
		$("#listerTree8").render(); 
	}
	
	//动态生成
	function dynamicLister1(){
		var $listerTree=$('<div class="listerTree"></div>');
		$listerTree.attr("url","<%=path%>/form/getTreeLister.action");
		$listerTree.attr("params",'{"orgid":"1"}');
		//将树形双选器加到按钮的后面
		$("#testBtn").after($listerTree);   
		//渲染树形双选器
		$listerTree.render();      
	}
	
	//动态生成
	function dynamicLister2(){
		$.post("<%=path%>/form/getTreeLister.action",{"orgid":"1"},function(result){
			var $listerTree=$('<div class="listerTree"></div>');
			//赋给data属性
			$listerTree.data("data",result)
	 		//将树形双选器加到按钮的后面
			$("#testBtn2").after($listerTree);   
			//渲染树形双选器
			$listerTree.render();  
		},"json");
	}
	
	
	//动态选中
	function selectItems(){
		$("#listTree12").selectValue("13")
	}
	//动态反选
	function unSelectItems(){
		$("#listTree12").unSelectValue("11")
	}
	//动态赋值
	function setValues(){
		$("#listTree12").setValue("12,13")
	}
	
	//添加项
	function appendItem(){
		$("#listTree12").addItem({"id":"22","parentId":"2","name":"员工5","oldParentId":"1"});
	}
	//删除项
	function removeItem(){
		$("#listTree12").removeItem("11");
	}
	
	//表单重置
	function resetForm(){
		 $("#form-13")[0].reset();
		 $("#form-13 .listerTree").resetValue(); 
	}
</script>

</body>
</html>