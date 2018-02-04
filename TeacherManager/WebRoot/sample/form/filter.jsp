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

<!-- 条件过滤器 start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/filter.js"></script>
<!-- 条件过滤器 end -->


</head>
<body>
	<div class="box1" panelWidth="800">
	<fieldset>
     	<legend>1、使用url赋值</legend>
     	   <div class="red">此示例由后台支持</div>
     	   <div class="filter" url="<%=path%>/form/getUserList.action" id="filter1"></div>
   	   		<input type="button" value="获取值" onclick="getValue()"/> 
   	</fieldset>
   	<div class="height_15"></div>
	
	<fieldset>  
       <legend>2、使用url+参数赋值</legend>
    	 <div class="red">此示例由后台支持</div>
    	<div class="filter"  url="<%=path%>/form/getUserList.action"  params='{"userinfor.organization.orgId":"2"}'></div>
	</fieldset>
     <div class="height_15"></div>
	 
	 <fieldset>  
       <legend>3、赋值给标签的data属性</legend>
	   <p>注意：使用json格式的字符串时所有节点的属性名与值都必须使用双引号</p>
	   <div class="filter"  data='{"list":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"},{"value":"3","key":"员工3"},{"value":"4","key":"员工4"}]}'></div>
	</fieldset>
	<div class="height_15"></div>
	
	<fieldset>  
       <legend>4、动态设置data</legend>
    	 使用本地数据：<br/>
		 <div class="filter" id="filter4-1" keepDefaultStyle="true"></div>
       	<br/>
       	<br/>
       	使用远程数据：
       	 <div class="red">此示例由后台支持</div>
		  <div class="filter" id="filter4-2" keepDefaultStyle="true"></div>
	</fieldset>
	<div class="height_15"></div>
	
	 <fieldset>
			<legend>5、可多选</legend>
			<div class="filter" multiMode="true" id="filter5"  data='{"list":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"},{"value":"3","key":"员工3"},{"value":"4","key":"员工4"}]}'></div>
   	   		<input type="button" value="获取值" onclick="getValue2()"/> 
	  </fieldset>
	  <div class="height_15"></div>
	
	<fieldset>
			<legend>6、使用隐藏域</legend>
			<p>如果为组件添加name属性，那么会自动生成一个隐藏域input，用来存储组件当前的value，该input的name与组件name一致。<br/>在提交表单时会用到。</p>
			 <div class="filter" name="filter6"  data='{"list":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"},{"value":"3","key":"员工3"},{"value":"4","key":"员工4"}]}'></div>
			<input type="button" value="获取隐藏域选中值" onclick="getHiddenValue()"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset>
			<legend>7、自定义项目尺寸</legend>
			<div class="filter" multiMode="true" itemWidth="200" itemHeight="30"  data='{"list":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"},{"value":"3","key":"员工3"},{"value":"4","key":"员工4"}]}'></div>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset>
			<legend>8、文字截取与显示提示</legend>
			<div class="filter" multiMode="true" showTip="true" data='{"list":[{"value":"1","key":"员工员工员工员工员工员工员工员工员工1"},{"value":"2","key":"员工2"},{"value":"3","key":"员工3"},{"value":"4","key":"员工4"}]}'></div>
			<br/>
			<br/>
			<div class="filter" multiMode="true" showInfo="true" data='{"list":[{"value":"1","key":"员工员工员工员工员工员工员工员工员工1"},{"value":"2","key":"员工2"},{"value":"3","key":"员工3"},{"value":"4","key":"员工4"}]}'></div>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset>
			<legend>9、禁用/启用</legend>
			 <div class="filter" disabled="true" filterWidth="400" id="filter9"  data='{"list":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"},{"value":"3","key":"员工3"},{"value":"4","key":"员工4"}]}'></div>
			  <input type="button" value="启用" onclick="enableFilter()"/>
			<input type="button" value="禁用" onclick="disableFilter()"/>
			<br/>
			这里还可以自定义总宽度。
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset>
			<legend>10、设置初始值</legend>
			<div class="filter" multiMode="true" selectedValue="1,2,3"  data='{"list":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"},{"value":"3","key":"员工3"},{"value":"4","key":"员工4"}]}'></div>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset>
			<legend>11、动态生成</legend>
			 <div class="red">此示例由后台支持</div>
			<input type="button" value="点击生成（使用url）" id="testBtn" onclick="dynamicFilter1()" style="width:150px;"/><br/><br/>
			<input type="button" value="点击生成（使用data）" id="testBtn2" onclick="dynamicFilter2()" style="width:150px;"/><br/><br/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset>
			<legend>12、动态选中</legend>
			<div class="filter" multiMode="true" id="filter12"  data='{"list":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"},{"value":"3","key":"员工3"},{"value":"4","key":"员工4"}]}'></div>
			<input type="button" value="选中前两项" id="testBtn" onclick="setValue()" style="width:150px;"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset>
			<legend>13、综合示例</legend>
			<table class="filterTable">
				<tr>
					<td width="80" class="left">品牌</td>
					<td class="right"><div class="filter" multiMode="true" id="filter13-1" data='{"list":[{"value":"1","key":"夏普"},{"value":"2","key":"索尼"},{"value":"3","key":"三星"},{"value":"4","key":"海信"},{"value":"5","key":"TCL"},{"value":"6","key":"创维"},{"value":"7","key":"松下"},{"value":"8","key":"飞利浦"},{"value":"9","key":"康佳"},{"value":"10","key":"长虹"},{"value":"11","key":"清华同方"}]}'></div></td>
				</tr>
				<tr>
					<td  class="left">品类</td>
					<td class="right"><div class="filter"  id="filter13-2" data='{"list":[{"value":"1","key":"LED背光电视"},{"value":"2","key":"LCD背光电视"},{"value":"3","key":"等离子电视"}]}'></div></td>
				</tr>
				<tr>
					<td class="left">功能</td>
					<td class="right"><div class="filter"  id="filter13-3" data='{"list":[{"value":"1","key":"3D电视"},{"value":"2","key":"非3D电视"},{"value":"3","key":"智能电视"},{"value":"4","key":"非智能电视"},{"value":"5","key":"网络电视"},{"value":"6","key":"非网络电视"}]}'></div></td>
				</tr>
				<tr>
					<td class="left">价格</td>
					<td class="right"><div class="filter" id="filter13-4" data='{"list":[{"value":"1","key":"1-1999"},{"value":"2","key":"2000-3999"},{"value":"3","key":"4000-5999"},{"value":"4","key":"6000-9999"},{"value":"5","key":"10000-14999"},{"value":"6","key":"15000-24999"},{"value":"7","key":"25000以上"}]}'></div></td>
				</tr>
				<tr>
					<td colspan="2" class="ali02 padding5">
					<input type="button" value="提交" onclick="submitForm()"/>
					<input type="button" value="重置" onclick="resetForm()"/>
					</td>
				</tr>
			</table>
	  </fieldset>
	  <div class="height_15"></div>
	
	<fieldset>
			<legend>14、可分组的条件过滤器</legend>
			<p>可分组的条件过滤器与上例的区别是使用一个组件和一个数据源即可实现分组的功能。不过无法灵活控制哪个组是单选哪个组是多选</p>
			<div class="filter" groupMode="true" data='{"list":[{"name":"部门1","list":[{"key":"员工1","value":"11"},{"key":"员工2","value":"12"},{"key":"员工3","value":"13"},{"key":"员工2","value":"12"},{"key":"员工3","value":"13"}]},{"name":"部门2","list":[{"key":"员工4","value":"21"},{"key":"员工5","value":"22"},{"key":"员工6","value":"23"}]},{"name":"部门3","list":[{"key":"员工1","value":"11"},{"key":"员工2","value":"12"},{"key":"员工3","value":"13"},{"key":"员工2","value":"12"},{"key":"员工3","value":"13"}]},{"name":"部门4","list":[{"key":"员工4","value":"21"},{"key":"员工5","value":"22"},{"key":"员工6","value":"23"}]}]}' id="filter13"></div>
			
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset>
			<legend>15、添加图标</legend>
			<div class="filter" multiMode="true" id="filter5"  data='{"list":[{"value":"1","key":"员工1","iconClass":"icon_user"},{"value":"2","key":"员工2","iconClass":"icon_user_worker"},{"value":"3","key":"员工3","iconClass":"icon_user_female"},{"value":"4","key":"其他","iconSrc":"<%=path%>/libs/images/icons/setting.png"}]}'></div>
	  </fieldset>
	  <div class="height_15"></div>
	   
	
	  <fieldset>
			<legend>16、无前缀数据</legend>
			<div class="filter" multiMode="true" id="filter5"  data='[{"value":"1","key":"员工1","iconClass":"icon_user"},{"value":"2","key":"员工2","iconClass":"icon_user_worker"},{"value":"3","key":"员工3","iconClass":"icon_user_female"},{"value":"4","key":"其他","iconSrc":"<%=path%>/libs/images/icons/setting.png"}]'></div>
	  </fieldset>
	  <div class="height_15"></div>
	   
	</div>
<script>
	//动态设置data
	function initComplete(){
		var selData= {"list":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"},{"value":"3","key":"员工3"},{"value":"4","key":"员工4"}]};
		//赋给data属性
		$("#filter4-1").data("data",selData)
		$("#filter4-1").render(); 
		
		//获取json数据
		$.post("<%=path%>/form/getUserList.action",{"userinfor.organization.orgId":"1"},function(result){
			//赋给data属性
			$("#filter4-2").data("data",selData)
	 		//刷新
	 		 $("#filter4-2").render(); 
		},"json");
	}
	
	//获取值
	function getValue(){
		top.Dialog.alert("选中文本："+$("#filter1").attr("relText")+"<br/>选中id："+$("#filter1").attr("relValue"));
	}
	
	//获取值
	function getValue2(){
		top.Dialog.alert("选中文本："+$("#filter5").attr("relText")+"<br/>选中id："+$("#filter5").attr("relValue"));
	}
	
	//获取隐藏域值
	function getHiddenValue(){
		top.Dialog.alert($("input:hidden[name='filter6']").val());
	}
	
	//禁用
    function disableFilter(){
        $("#filter9").attr("disabled",true);
		$("#filter9").render(); 
    }
    
    //启用
    function enableFilter(){
        $("#filter9").attr("disabled",false);
		$("#filter9").render(); 
    }
    
 //动态生成
	function dynamicFilter1(){
		var $filter = $('<div class="filter"></div>');
		$filter.attr("url","<%=path%>/form/getUserList.action");
		//加到按钮的后面
		$("#testBtn").after($filter);   
		$("#testBtn").after("<br/>"); 
		//渲染 
		$filter.render();        
	}
	
	//动态生成
	function dynamicFilter2(){
		//获取json数据
		$.post("<%=path%>/form/getUserList.action",{"userinfor.organization.orgId":"2"},function(result){
			var $filter = $('<div  class="filter"></div>');
			//赋给data属性
			$filter.data("data",result);
			//加到按钮的后面
			$("#testBtn2").after($filter);   
			$("#testBtn2").after("<br/>");  
			//渲染
			$filter.render();      
		},"json");
	}
	
	//动态选中
	function setValue(){
		$("#filter12").setValue("1,2");
	}
	
	//提交
	function submitForm(){
		top.Dialog.alert("品牌："+$("#filter12-1").attr("relText")+"("+$("#filter13-1").attr("relValue")+")<br/>品类："+$("#filter13-2").attr("relText")+"("+$("#filter13-2").attr("relValue")+")<br/>功能："+$("#filter13-3").attr("relText")+"("+$("#filter13-3").attr("relValue")+")<br/>价格："+$("#filter13-4").attr("relText")+"("+$("#filter13-4").attr("relValue")+")");
	}
	
	//重置表单
	function resetForm(){
		$(".filterTable .filter").resetValue();  
	}
</script>
</body>
</html>