<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>星级评价</title>
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!--评星级控件start-->
<script type="text/javascript" src="<%=path%>/libs/js/form/rating.js"></script>
<!--评星级控件end-->

<body>
   <div class="box1" panelWidth="800">
   	<fieldset>
   		<legend>1、基本用法</legend>
   		 <div class="rating"></div>
   	</fieldset>
   	<div class="height_15"></div>
   	
   	<fieldset>
   		<legend>2、只读并在初始时赋值</legend>
   		 <div class="rating" readOnly="true" value="2"></div>
   	</fieldset>
   	<div class="height_15"></div>
   	
   	<fieldset>
   		<legend>3、使用隐藏域</legend>
   		<p>如果为组件添加name属性，那么会自动生成一个隐藏域input，用来存储组件当前的value，该input的name与组件name一致。<br/>在提交表单时会用到。</p>
   		<div class="rating" name="bo.raty"></div>
   		<input type="button" value="获取隐藏域选中值" onclick="getHiddenValue()"/>
   	</fieldset>
   	<div class="height_15"></div>
   	
   	 <fieldset>
   		<legend>4、自定义个数</legend>
   		<div class="rating" number="10"></div>
   	</fieldset>
   	<div class="height_15"></div>
   	
   	<fieldset>
   		<legend>5、自定义图标和提示语</legend>
   		<div class="rating" tip="a,,null,d,5" starOn="medal-on.gif" starOff="medal-off.gif"></div>
   	</fieldset>
   	<div class="height_15"></div>
   	
   	
   	<fieldset>
   		<legend>6、使用取消按钮</legend>
   		<div class="rating" showCancel="true"></div>
   	</fieldset>
   	<div class="height_15"></div>
   	
   	
   	<fieldset>
   		<legend>7、手动渲染(处理点击事件)</legend>
   		手动渲染可以使用事件。
   		<div id="rating7"></div>
   	</fieldset>
   	<div class="height_15"></div>
   	
   	<fieldset>
   		<legend>8、手动渲染自定义取消按钮</legend>
   		手动渲染还做更加个性化的设置。如自定义取消按钮。
   		<div id="rating8"></div>
   	</fieldset>
   	<div class="height_15"></div>
   	
   	<fieldset>
   		<legend>9、动态创建</legend>
   		<input type="button" value="点击生成" id="testBtn" onclick="dynamic()"/>
   	</fieldset>
   	<div class="height_15"></div>
   	
   	<fieldset>
   		<legend>10、动态赋值</legend>
   		<div class="rating" id="rating10"></div>
   		<input type="button" value="点击赋值" onclick="setValue()"/>
   	</fieldset>
  
  </div>
<script type="text/javascript">
	function initComplete() {
		//手动渲染
		$('div#rating7').Rating({
			onClick: function(score) {
				top.Dialog.alert('分数: ' + score);
			}
		});

		//手动渲染
	   $('div#rating8').Rating({
			cancelHint: '取消',
			cancelPlace: 'right',
			showCancel: true,
			onClick: function(score) {
				top.Dialog.alert('分数: ' + score);
			}
		});

	}
		
	//获取隐藏域值
	function getHiddenValue(){
		top.Dialog.alert($("input:hidden[name='bo.raty']").val());
	}
	
	//动态生成
	function dynamic(){
		//动态生成星级控件需要设置id
		var $rating = $('<div class="rating" id="rating9"></div>');
		$("#testBtn").after($rating);   
		$("#testBtn").after($("<br/>"));   
		//渲染
		$rating.render();      
	}
	
	//动态赋值
	function setValue(){
		$("#rating10").attr("value",3);
		$("#rating10").render();
	}
		
</script>
</body>
</html>