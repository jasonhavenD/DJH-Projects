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
<style>
.boxgrid{ 
	width: 200px; 
	height: 122px; 
	margin:10px; 
	float:left; 
	background:#161613; 
	border: solid 2px #8399AF; 
	overflow: hidden; 
	position: relative; 
}
</style>
<script>
function initComplete(){
	//初始时无标题
	$('.boxgrid.captionfull').each(function(){
		$(".cover", this).css({
			top:"160px"
		})
	})
	$('.boxgrid.captionfull').hover(function(){
		$(".cover", this).stop().animate({top:'60px'},{queue:false,duration:160});
	}, function() {
		$(".cover", this).stop().animate({top:'160px'},{queue:false,duration:160});
	});
	
	//初始时有标题
	$('.boxgrid.caption').each(function(){
		$(".cover", this).css({
			top:"95px"
		})
	})
	$('.boxgrid.caption').hover(function(){
		$(".cover", this).stop().animate({top:'60px'},{queue:false,duration:160});
	}, function() {
		$(".cover", this).stop().animate({top:'95px'},{queue:false,duration:160});
	});
	
	//图片向右移动
	$('.boxgrid.slideright').hover(function(){
		$(".cover", this).stop().animate({left:'325px'},{queue:false,duration:300});
	}, function() {
		$(".cover", this).stop().animate({left:'0px'},{queue:false,duration:300});
	});
	
	//图片斜向下移动
	$('.boxgrid.thecombo').hover(function(){
		$(".cover", this).stop().animate({top:'260px', left:'325px'},{queue:false,duration:300});
	}, function() {
		$(".cover", this).stop().animate({top:'0px', left:'0px'},{queue:false,duration:300});
	});
	
	//图片向上移动
	$('.boxgrid.slidedown').hover(function(){
		$(".cover", this).stop().animate({top:'-260px'},{queue:false,duration:300});
	}, function() {
		$(".cover", this).stop().animate({top:'0px'},{queue:false,duration:300});
	});
}
</script>
</head>
<body>
	 <div class="box1" panelWidth="800">
      <fieldset>
      	<legend>鼠标移入出现信息</legend>
<div class="boxgrid captionfull">
	<img src="<%=path%>/libs/images/demo/demo1.jpg"/>
	<div class="cover boxcaption">
		<div class="boxgrid_title">图片标题</div>
		<div class="boxgrid_con">这里是图片文字说明部分<br />这里是图片文字说明部分</div>
	</div>		
</div>
<div class="boxgrid captionfull">
	<img src="<%=path%>/libs/images/demo/demo1.jpg"/>
	<div class="cover boxcaption">
		<div class="boxgrid_title">图片标题</div>
		<div class="boxgrid_con">这里是图片文字说明部分<br />这里是图片文字说明部分</div>
	</div>		
</div>
<div class="boxgrid captionfull">
	<img src="<%=path%>/libs/images/demo/demo1.jpg"/>
	<div class="cover boxcaption">
		<div class="boxgrid_title">图片标题</div>
		<div class="boxgrid_con">这里是图片文字说明部分<br />这里是图片文字说明部分</div>
	</div>		
</div>
<div class="clear"></div>
      </fieldset>
       <div class="height_15"></div>
       
      
      <fieldset>
       	<legend>初始时有标题</legend>
<div class="boxgrid caption">
	<img src="<%=path%>/libs/images/demo/demo1.jpg"/>
	<div class="cover boxcaption">
		<div class="boxgrid_title">图片标题</div>
		<div class="boxgrid_con">这里是图片文字说明部分<br />这里是图片文字说明部分</div>
	</div>		
</div>
<div class="boxgrid caption">
	<img src="<%=path%>/libs/images/demo/demo1.jpg"/>
	<div class="cover boxcaption">
		<div class="boxgrid_title">图片标题</div>
		<div class="boxgrid_con">这里是图片文字说明部分<br />这里是图片文字说明部分</div>
	</div>		
</div>
<div class="boxgrid caption">
	<img src="<%=path%>/libs/images/demo/demo1.jpg"/>
	<div class="cover boxcaption">
		<div class="boxgrid_title">图片标题</div>
		<div class="boxgrid_con">这里是图片文字说明部分<br />这里是图片文字说明部分</div>
	</div>		
</div>
<div class="clear"></div>
      </fieldset>
       <div class="height_15"></div>
       
      
      <fieldset>
       	<legend>图片向右移动</legend>
<div class="boxgrid slideright">
	<img class="cover" src="<%=path%>/libs/images/demo/demo1.jpg"/>
	<div class="boxgrid_title">图片标题</div>
	<div class="boxgrid_con">这里是图片文字说明部分<br />这里是图片文字说明部分</div>
</div>
<div class="boxgrid slideright">
	<img class="cover" src="<%=path%>/libs/images/demo/demo1.jpg"/>
	<div class="boxgrid_title">图片标题</div>
	<div class="boxgrid_con">这里是图片文字说明部分<br />这里是图片文字说明部分</div>
</div>
<div class="boxgrid slideright">
	<img class="cover" src="<%=path%>/libs/images/demo/demo1.jpg"/>
	<div class="boxgrid_title">图片标题</div>
	<div class="boxgrid_con">这里是图片文字说明部分<br />这里是图片文字说明部分</div>
</div>
<div class="clear"></div>
      </fieldset>
       <div class="height_15"></div>
       
      
      <fieldset>
       	<legend>图片斜向下移动</legend>
<div class="boxgrid thecombo">
	<img class="cover" src="<%=path%>/libs/images/demo/demo1.jpg"/>
	<div class="boxgrid_title">图片标题</div>
	<div class="boxgrid_con">这里是图片文字说明部分<br />这里是图片文字说明部分</div>
</div>
<div class="boxgrid thecombo">
	<img class="cover" src="<%=path%>/libs/images/demo/demo1.jpg"/>
	<div class="boxgrid_title">图片标题</div>
	<div class="boxgrid_con">这里是图片文字说明部分<br />这里是图片文字说明部分</div>
</div>
<div class="boxgrid thecombo">
	<img class="cover" src="<%=path%>/libs/images/demo/demo1.jpg"/>
	<div class="boxgrid_title">图片标题</div>
	<div class="boxgrid_con">这里是图片文字说明部分<br />这里是图片文字说明部分</div>
</div>
<div class="clear"></div>
      </fieldset>
       <div class="height_15"></div>
       
      
      <fieldset>
       	<legend>图片向上移动</legend>
<div class="boxgrid slidedown">
	<img class="cover" src="<%=path%>/libs/images/demo/demo1.jpg"/>
	<div class="boxgrid_title">图片标题</div>
	<div class="boxgrid_con">这里是图片文字说明部分<br />这里是图片文字说明部分</div>
</div>
<div class="boxgrid slidedown">
	<img class="cover" src="<%=path%>/libs/images/demo/demo1.jpg"/>
	<div class="boxgrid_title">图片标题</div>
	<div class="boxgrid_con">这里是图片文字说明部分<br />这里是图片文字说明部分</div>
</div>
<div class="boxgrid slidedown">
	<img class="cover" src="<%=path%>/libs/images/demo/demo1.jpg"/>
	<div class="boxgrid_title">图片标题</div>
	<div class="boxgrid_con">这里是图片文字说明部分<br />这里是图片文字说明部分</div>
</div>
<div class="clear"></div>
      </fieldset>
       <div class="height_15"></div>
       
       
     </div>
</body>
</html>