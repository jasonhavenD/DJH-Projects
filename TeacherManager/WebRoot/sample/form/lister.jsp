<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>左右选</title>
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!-- 双向选择器start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/lister.js"></script>
<!-- 双向选择器end -->
</head>
<body>
   <div class="box1" panelWidth="800">
     <fieldset>  
       <legend>1、使用url赋值</legend>
    	 <div class="red">此示例由后台支持</div>
    	<div class="lister" id="lister1" url="<%=path%>/form/getUsersOfDoubleSelect.action"></div>
    	  <input type="button" value="获取值" onclick="getValue()"/> 
    	  <input type="button" value="获取选中项文本" onclick="getText()"/> 
    	  <input type="button" value="获取选中项数据" onclick="getData()"/> 
	</fieldset>
	<div class="height_15"></div>
	
	 <fieldset>  
       <legend>2、使用url+参数赋值</legend>
    	  <div class="red">此示例由后台支持</div>
    	  <div class="lister" url="<%=path%>/form/getUsersOfDoubleSelect.action" params='{"userinfor.organization.orgId":"3"}'></div>
	</fieldset>
     <div class="height_15"></div>
     
     <fieldset>  
       <legend>3、赋值给标签的data属性</legend>
    	 <div class="lister" data='{"fromList":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"},{"value":"3","key":"员工3"},{"value":"4","key":"员工4"}],"toList":[]}'></div>
	</fieldset>
	<div class="height_15"></div>
	
	 <fieldset>  
       <legend>4、动态设置data（本地数据源）</legend>
    	 <div class="lister"  id="lister4" keepDefaultStyle="true"></div>
	</fieldset>
	<div class="height_15"></div>
	
	 <fieldset>  
       <legend>5、动态设置data（远程数据源）</legend>
    	 <div class="red">此示例由后台支持</div>
    	 <div class="lister"  id="lister5" keepDefaultStyle="true"></div>
	</fieldset>
	<div class="height_15"></div>
	
	<fieldset>  
       <legend>6、初始时存在已选值</legend>
       	<p>通过设置数据的toList内容来实现已选值</p>
    	 <div class="lister"  data='{"fromList":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"}],"toList":[{"value":"3","key":"员工3"},{"value":"4","key":"员工4"}]}'></div>
    	 <br/> <br/>
    	 <p>通过设置selectedValue实现已选值</p>
    	  <div class="lister" selectedValue="1,2" data='{"fromList":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"},{"value":"3","key":"员工3"},{"value":"4","key":"员工4"}],"toList":[]}'></div>
    	  <br/>使用selectedValue实现了已选值，在操作后再使用render()方法刷新后可以还原为初始值。参见最后一个例子：重置双选器。
    	  <br/>通过设置数据的toList内容来实现已选值则不可以还原。
    	  <br/><br/>另外 如果希望表单重置时已选值清空，需要设置selectedValue=""
	</fieldset>
	<div class="height_15"></div>
	
	<fieldset>  
       <legend>7、使用隐藏域</legend>
    	<p>如果为组件添加name属性，那么会自动生成一个隐藏域input，用来存储组件当前的value，该input的name与组件name一致。<br/>在提交表单时会用到。</p>
    	 <div class="lister" name="lister7" data='{"fromList":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"},{"value":"3","key":"员工3"},{"value":"4","key":"员工4"}],"toList":[]}'></div>
		<input type="button" value="获取隐藏域选中值" onclick="getHiddenValue()"/>
	</fieldset>
	<div class="height_15"></div>
	
	<fieldset>  
       <legend>8、禁用/启用</legend>
    	 <div class="lister" disabled="true" id="lister8" data='{"fromList":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"},{"value":"3","key":"员工3"},{"value":"4","key":"员工4"}],"toList":[]}'></div>
    	 <br/>
			<input type="button" value="启用" onclick="enableLister()" style="width:120px;"/>
			<input type="button" value="禁用" onclick="disableLister()" style="width:120px;"/>
	</fieldset>
	<div class="height_15"></div>
		
     <fieldset>  
       <legend>9、自定义尺寸</legend>
    	 <div class="lister" listerWidth="120" listerHeight="120" data='{"fromList":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"},{"value":"3","key":"员工3"},{"value":"4","key":"员工4"}],"toList":[]}'></div>
	</fieldset>
	<div class="height_15"></div>
	
	 <fieldset> 
			<legend>10、动态生成双选器</legend>
			 <div class="red">此示例由后台支持</div>
			<input type="button" value="点击生成（使用url）" id="testBtn" onclick="dynamicLister1()" style="width:150px;"/><br/><br/>
			<input type="button" value="点击生成（使用data）" id="testBtn2" onclick="dynamicLister2()" style="width:150px;"/><br/><br/>
	   </fieldset>
	   <div class="height_15"></div>
	
	  <fieldset>  
       <legend>11、动态改变值</legend>
    	 <div class="lister" id="lister11"  data='{"fromList":[{"value":"2","key":"员工2"},{"value":"3","key":"员工3"},{"value":"4","key":"员工4"}],"toList":[{"value":"1","key":"员工1"}]}'></div>
			<br/>
			<input type="button" value="选中“员工2,员工3”" onclick="selectItems()" style="width:120px;"/>
			<input type="button" value="反选“员工1”" onclick="unSelectItems()" style="width:120px;"/>
			<input type="button" value="设值为“员工1,员工4”"" onclick="setValues()" style="width:120px;"/>
			<br/>
			
			<br/>
			<br/>
			<input type="button" value="追加一项到左侧" onclick="appendItem()" style="width:120px;"/>
			<input type="button" value="从左侧移除“员工2”" onclick="removeItem()" style="width:120px;"/>
	</fieldset>
	<div class="height_15"></div>
	
	<fieldset>
			<legend>12、重置双选器</legend>
			<form id="form-12">
				<table class="tableStyle" formMode="transparent" style="width:500px;">
					<tr>
						<td>传统表单元素：</td>
						<td><input type="text"/></td>
					</tr>
					<tr>
						<td>双向选择器1：</td>
						<td><div class="lister" selectedValue="" listerWidth="120" listerHeight="120" fromTitle="" toTitle="" data='{"fromList":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"},{"value":"3","key":"员工3"},{"value":"4","key":"员工4"}],"toList":[]}'></div></td>
					</tr>
					<tr>
						<td>双向选择器2：</td>
						<td><div class="lister"  selectedValue="1,2" listerWidth="120" listerHeight="120" fromTitle="" toTitle="" data='{"fromList":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"},{"value":"3","key":"员工3"},{"value":"4","key":"员工4"}],"toList":[]}'></div></td>
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
       <legend>13、itemClick事件</legend>
    	 <div class="lister" id="lister-13" data='{"fromList":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"},{"value":"3","key":"员工3"},{"value":"4","key":"员工4"}],"toList":[]}'></div>
	</fieldset>
	<div class="height_15"></div>
	
	<fieldset>  
       <legend>14、设置最大可选条数</legend>
    	 <div class="lister" maxSelection="3" data='{"fromList":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"},{"value":"3","key":"员工3"},{"value":"4","key":"员工4"}],"toList":[]}'></div>
	</fieldset>
</div>
<script>
	function initComplete(){
		var selData={fromList:[{value:"1",key:"员工1"},{value:"2",key:"员工2"},{value:"3",key:"员工3"},{value:"4",key:"员工4"}],"toList":[]};
		$("#lister4").data("data",selData)
		$("#lister4").render(); 
		
		//获取json数据
		$.post("<%=path%>/form/getUsersOfDoubleSelect.action",{"userinfor.organization.orgId":"3"},function(result){
			//赋给data属性
			$("#lister5").data("data",result)
	 		//刷新下拉框
			$("#lister5").render(); 
		},"json");
		
		$("#lister-13").bind("itemClick",function(e){
			alert("触发事件")
		})
	}
	//获取值
	function getValue(){
		top.Dialog.alert($("#lister1").attr("relValue"));
	}
	
	//获取文本
	function getText(){
		top.Dialog.alert($("#lister1").attr("relText"));
	}
	
	//获取数据
	function getData(){
		alert(JSON.stringify($("#lister1").data("selectedNodes")));
	}

	//获取隐藏域值
	function getHiddenValue(){
		top.Dialog.alert($("input:hidden[name='lister7']").val());
	}
	
	//动态禁用/启用
	function disableLister(){
		$("#lister8").attr("disabled",true);
		//刷新双选器
		$("#lister8").render(); 
	}
	function enableLister(){
		$("#lister8").attr("disabled",false);
		//刷新双选器
		$("#lister8").render(); 
	}
	
	//动态生成双选器
	function dynamicLister1(){
		var $lister=$('<div class="lister"></div>');
		$lister.attr("url","<%=path%>/form/getUsersOfDoubleSelect.action");
		$lister.attr("params",'{"userinfor.organization.orgId":"3"}');
		//将双向选择器加到按钮的后面
		$("#testBtn").after($lister);   
		//渲染双向选择器  
		$lister.render();      
	}
	function dynamicLister2(){
		$.post("<%=path%>/form/getUsersOfDoubleSelect.action",{"userinfor.organization.orgId":"3"},function(result){
			var $lister=$('<div class="lister"></div>');
			//赋给data属性
			$lister.data("data",result)
	 		//将双向选择器加到按钮的后面
			$("#testBtn2").after($lister);   
			//渲染双向选择器  
			$lister.render();  
		},"json");
	}
	
	//动态选中
	function selectItems(){
		$("#lister11").selectValue("2,3")
	}
	//动态反选
	function unSelectItems(){
		$("#lister11").unSelectValue("1")
	}
	//动态赋值
	function setValues(){
		$("#lister11").setValue("1,4")
	}
	
	//添加项
	function appendItem(){
		$("#lister11").addItem({key: "员工5", value: "100"});
	}
	//删除项
	function removeItem(){
		$("#lister11").removeItem("2");
	}
	
	//表单重置
	function resetForm(){
		 $("#form-12")[0].reset();
		 $("#form-12 .lister").resetValue(); 
	}
	
</script>
</body>
</html>