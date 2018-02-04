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

<!--图片滚动可控start-->
<script type="text/javascript" src="<%=path%>/libs/js/pic/switchable.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/pic/switchable.effect.js"></script>
<!--图片滚动可控end-->

<script type="text/javascript">
function initComplete(){
	//基本使用
	$("#trigger0").switchable("#panel0 > div > img", {
		triggerType: "click", /* 触发方式*/
		effect: "scroll", /* 滚动效果，也可是fade*/
		steps: 3, /* 每次滚动个数*/
		visible: 3, /* 可见个数*/
		circular: true /* 是否循环*/
	})
	var api0 = $("#trigger0").switchable();
	$("#next0").click(function(){
		api0.next();
	});
	$("#prev0").click(function(){
		api0.prev();
	});


	//自动播放并添加控制按钮 
	window.api = $("#trigger1").switchable("#panel1 > div > img", {
		triggerType: "click",
		effect: "scroll",
		steps: 3,
		visible: 3,
		circular: true
	}).autoplay({ api: true });
	
	$("#next1").click(function(){
		api.next();
	});
	$("#prev1").click(function(){
		api.prev();
	});
	
	
	//末尾不返回
	$("#trigger2").switchable("#panel2 > div > img", {
		triggerType: "click",
		effect: "scroll",
		steps: 3,
		visible: 3
	}).carousel();
	
	var api2 = $("#trigger2").switchable();
	$("#next2").click(function(){
		api2.next();
	});
	$("#prev2").click(function(){
		api2.prev();
	});
	
	//鼠标滚轮控制
	$("#trigger3").switchable("#panel3 > div > img", {
		triggerType: "click",
		effect: "scroll",
		steps: 3,
		visible: 3
	}).mousewheel().carousel();
	
	var api3 = $("#trigger3").switchable();
	$("#next3").click(function(){
		api3.next();
	});
	$("#prev3").click(function(){
		api3.prev();
	});
	
	//自定义显示个数
	$("#trigger4").switchable("#panel4 > div > img", {
		triggerType: "click",
		effect: "scroll",
		steps: 4,
		visible: 4
	}).carousel();
	var api4 = $("#trigger4").switchable();
	$("#next4").click(function(){
		api4.next();
	});
	$("#prev4").click(function(){
		api4.prev();
	});
	
	//自动播放
	 $("#trigger5").switchable("#panel5 > div > img", {
		triggerType: "click",
		effect: "scroll",
		steps: 3,
		visible: 3,
		circular: true
	}).autoplay({ api: true });
	
	
};
</script>
</head>
<body>
<div class="box1" panelWidth="800">
<fieldset>
   <legend>1、基本用法</legend>
	<div class="trigger-bar">
		<a href="javascript:void(0);" title="下翻" id="next0" class="next"></a>
		<a href="javascript:void(0);" title="上翻" id="prev0" class="prev"></a>
		<div id="trigger0" class="scrollable-trigger"></div>
	</div>
	<div id="panel0" class="scrollable-panel">
		<div class="clearfix">
			<img src="<%=path%>/libs/images/demo/demo2.jpg" />
			<img src="<%=path%>/libs/images/demo/demo3.jpg" />
			<img src="<%=path%>/libs/images/demo/demo2.jpg" />
			<img src="<%=path%>/libs/images/demo/demo3.jpg" />
			<img src="<%=path%>/libs/images/demo/demo2.jpg" />
			<img src="<%=path%>/libs/images/demo/demo3.jpg" />
			<img src="<%=path%>/libs/images/demo/demo2.jpg" />
			<img src="<%=path%>/libs/images/demo/demo3.jpg" />
			<img src="<%=path%>/libs/images/demo/demo2.jpg" />
		</div>
	</div>
</fieldset>
  <div class="height_15"></div>	
	
<fieldset>
   <legend>2、自动播放并添加控制按钮</legend>	
	<div class="trigger-bar">
		<a href="javascript:void(0);" title="下翻" id="next1" class="next"></a>
		<a href="javascript:void(0);" title="上翻" id="prev1" class="prev"></a>
		<div id="trigger1" class="scrollable-trigger"></div>
	</div>
	<div id="panel1" class="scrollable-panel">
		<div class="clearfix">
			<img src="<%=path%>/libs/images/demo/demo2.jpg" />
			<img src="<%=path%>/libs/images/demo/demo3.jpg" />
			<img src="<%=path%>/libs/images/demo/demo2.jpg" />
			<img src="<%=path%>/libs/images/demo/demo3.jpg" />
			<img src="<%=path%>/libs/images/demo/demo2.jpg" />
			<img src="<%=path%>/libs/images/demo/demo3.jpg" />
			<img src="<%=path%>/libs/images/demo/demo2.jpg" />
			<img src="<%=path%>/libs/images/demo/demo3.jpg" />
			<img src="<%=path%>/libs/images/demo/demo2.jpg" />
		</div>
	</div>
	<div class="ctrl" style="width:437px;">
		<input type="button" keepDefaultStyle="true" class="play" onClick="api.play();" title="播放"/>
		<input type="button" keepDefaultStyle="true" class="pause" onClick="api.pause();" title="暂停"/>
		<input type="button" keepDefaultStyle="true" class="stop" onClick="api.stop();" title="停止"/>
	</div>
</fieldset>
  <div class="height_15"></div>

<fieldset>
   <legend>3、末尾不返回</legend>
	<div class="trigger-bar">
		<a href="javascript:void(0);" title="下翻" id="next2" class="next"></a>
		<a href="javascript:void(0);" title="上翻" id="prev2" class="prev"></a>
		<div id="trigger2" class="scrollable-trigger"></div>
	</div>
	
	<div id="panel2" class="scrollable-panel">
		<div class="clearfix">
			<img src="<%=path%>/libs/images/demo/demo2.jpg" />
			<img src="<%=path%>/libs/images/demo/demo3.jpg" />
			<img src="<%=path%>/libs/images/demo/demo2.jpg" />
			<img src="<%=path%>/libs/images/demo/demo3.jpg" />
			<img src="<%=path%>/libs/images/demo/demo2.jpg" />
			<img src="<%=path%>/libs/images/demo/demo3.jpg" />
			<img src="<%=path%>/libs/images/demo/demo2.jpg" />
			<img src="<%=path%>/libs/images/demo/demo3.jpg" />
			<img src="<%=path%>/libs/images/demo/demo2.jpg" />
		</div>
	</div>
</fieldset>
  <div class="height_15"></div>

<fieldset>
   <legend>4、鼠标滚轮控制</legend>	
	<div class="trigger-bar">
		<a href="javascript:void(0);" title="下翻" id="next3" class="next"></a>
		<a href="javascript:void(0);" title="上翻" id="prev3" class="prev"></a>
		<div id="trigger3" class="scrollable-trigger"></div>
	</div>
	
	<div id="panel3" class="scrollable-panel">
		<div class="clearfix">
			<img src="<%=path%>/libs/images/demo/demo2.jpg" />
			<img src="<%=path%>/libs/images/demo/demo3.jpg" />
			<img src="<%=path%>/libs/images/demo/demo2.jpg" />
			<img src="<%=path%>/libs/images/demo/demo3.jpg" />
			<img src="<%=path%>/libs/images/demo/demo2.jpg" />
			<img src="<%=path%>/libs/images/demo/demo3.jpg" />
			<img src="<%=path%>/libs/images/demo/demo2.jpg" />
			<img src="<%=path%>/libs/images/demo/demo3.jpg" />
			<img src="<%=path%>/libs/images/demo/demo2.jpg" />
		</div>
	</div>
</fieldset>
  <div class="height_15"></div>	

<fieldset>
   <legend>5、自定义宽高和显示个数</legend>	
	<div class="trigger-bar" style="width:750px;">
		<a href="javascript:void(0);" title="下翻" id="next4" class="next"></a>
		<a href="javascript:void(0);" title="上翻" id="prev4" class="prev"></a>
		<div id="trigger4" class="scrollable-trigger"></div>
	</div>
	
	<div id="panel4" class="scrollable-panel" style="width:750px;height:110px;">
		<div class="clearfix">
			<img src="<%=path%>/libs/images/demo/demo2.jpg" style="width:200px;height:110px;"/>
			<img src="<%=path%>/libs/images/demo/demo3.jpg" style="width:200px;height:110px;"/>
			<img src="<%=path%>/libs/images/demo/demo2.jpg" style="width:200px;height:110px;"/>
			<img src="<%=path%>/libs/images/demo/demo3.jpg" style="width:200px;height:110px;"/>
			<img src="<%=path%>/libs/images/demo/demo2.jpg" style="width:200px;height:110px;"/>
			<img src="<%=path%>/libs/images/demo/demo3.jpg" style="width:200px;height:110px;"/>
			<img src="<%=path%>/libs/images/demo/demo2.jpg" style="width:200px;height:110px;"/>
			<img src="<%=path%>/libs/images/demo/demo3.jpg" style="width:200px;height:110px;"/>
		</div>
	</div>
</fieldset>

<fieldset>
   <legend>6、自动播放</legend>	
	<div class="trigger-bar" style="display:none;height:0px;overflow:hidden;">
		<div id="trigger5" class="scrollable-trigger"></div>
	</div>
	<div id="panel5" class="scrollable-panel" style="width:750px;height:110px;">
		<div class="clearfix">
			<img src="<%=path%>/libs/images/demo/demo2.jpg" style="width:200px;height:110px;"/>
			<img src="<%=path%>/libs/images/demo/demo3.jpg" style="width:200px;height:110px;"/>
			<img src="<%=path%>/libs/images/demo/demo2.jpg" style="width:200px;height:110px;"/>
			<img src="<%=path%>/libs/images/demo/demo3.jpg" style="width:200px;height:110px;"/>
			<img src="<%=path%>/libs/images/demo/demo2.jpg" style="width:200px;height:110px;"/>
			<img src="<%=path%>/libs/images/demo/demo3.jpg" style="width:200px;height:110px;"/>
			<img src="<%=path%>/libs/images/demo/demo2.jpg" style="width:200px;height:110px;"/>
			<img src="<%=path%>/libs/images/demo/demo3.jpg" style="width:200px;height:110px;"/>
		</div>
	</div>
</fieldset>

</div>
</body>
</html>