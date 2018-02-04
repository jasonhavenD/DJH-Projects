<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>按钮</title>
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->
</head>
<body>
   <div class="box1" panelWidth="800">
   
   	  <fieldset> 
			<legend>1、各种类型的按钮</legend>
			<input type="button" value="input按钮"/> 
			<input type="reset" value="reset按钮"/> 
			<input type="submit" value="submit按钮"/>
			<button type="button">button标签按钮</button> 
			<input type="button" value="input不可用" disabled="true"/>
			<button type="button" disabled="true">button不可用</button> 
	  </fieldset>
	  <div class="height_15"></div>
	    
	  <fieldset> 
			<legend>2、图标按钮（基于button标签）</legend>
			<button type="button"><span class="icon_save">保存</span></button>
			<button type="button"><span class="icon_delete">删除</span></button>
			<button type="button"><span class="icon_find">查询</span></button>
			<button type="button"><span class="icon_edit">编辑</span></button>
			<button type="button"><span class="icon_ok">提交</span></button>
			<button type="button"><span class="icon_clear">重置</span></button>
			<div class="height_10"></div>
			
			注意：使用button标签时要加上type，否则在IE中会造成某些问题。<br/>
			type的值可以是：submit（点击提交表单）、reset（点击重置表单）、button（点击无默认事件，可加onclick自定义处理）
	   </fieldset> 
	   <div class="height_15"></div>
	  
	   <fieldset> 
			<legend>3、按钮动态生成</legend>
			<input type="button" value="点击生成input按钮" id="testBtn"/><br/><br/>
			<input type="button" value="点击生成button按钮" id="testBtn2"/>
			<div class="height_10"></div>
	   </fieldset>
	   <div class="height_15"></div>
	   
	   <fieldset> 
			<legend>4、自定义样式</legend>
			<input type="button" value="自定义样式" class="button2" /><br/><br/>
			<button type="button" class="button2"><span class="icon_save">保存</span></button>
			<div class="height_10"></div>
	   </fieldset>
	   <div class="height_15"></div>
	   
	   <fieldset> 
			<legend>5、toggle模式</legend>
			toggle模式下按钮按下时会停留一个状态，再按下后取消该状态。<br/>
			两个状态下relValue属性分别是0和1。可以通过在初始时设置relValue实现初始时显示不同的状态。<br/>
			当为按钮设置name后，会自动生成一个同名的hidden，存储该按钮relValue的值。<br/>
			<input type="button" id="t0" value="toggle模式" toggle="true" name="toggle0"/><br/><br/>
			<input type="button" value="获取值" onclick="getValue('t0')"/>
			<br/>
			<br/>
			toggle模式配合自定义样式可以实现很多个性化的东西，例如开关按钮。<br/>
			<input type="button" id="switch1" value="" class="buttonswich" toggle="true" useMinWidth="false" name="toggle1"/><br/>
			<input type="button" value="获取值" onclick="getValue('switch1')"/>
			<br/><br/>
			<br/>
			<input type="button" id="switch2" value="" class="buttonswich2" toggle="true" useMinWidth="false" name="toggle2"  relValue="1" /><br/>
			<input type="button" value="获取值" onclick="getValue('switch2')"/>
			<br/><br/>
			<br/>
			<div class="height_10"></div>
	   </fieldset>
	   <div class="height_15"></div>
	   
	   <fieldset> 
			<legend>6、浏览器原始按钮</legend>
			<input type="button"  keepDefaultStyle="true" value="系统默认"/> 
	   </fieldset>

	</div>


<script type="text/javascript">

    //动态生成按钮
	$(function(){
		$("#testBtn").click(function(){
			var $input=$('<input type="button" value="我是input按钮"/>' );
			$input.render();
			$(this).after($input);
		})
		$("#testBtn2").click(function(){
			var $button=$('<button type="button"><span class="icon_find">查询</span></button>');
			$button.render();
			$(this).after($button);
		})
	})
	function getValue(str){
		top.Dialog.alert($("#"+str).attr("relValue"));
	}
</script>

</body>
</html>