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

<!--动画方式入场效果start-->
<script type="text/javascript" src="<%=path%>/libs/js/pic/jomino.js"></script>
<!--动画方式入场效果end-->

<!--图片渐显start-->
<script type="text/javascript" src="<%=path%>/libs/js/pic/imgFade.js"></script>
<!--图片渐显end-->
<script>
function initComplete(){
	//动画入场
	$("#list-2 .picItem2").jomino();
	
	//标题特效
	$('.framegrid.nocaption').each(function(){
		$(".framegrid_cover", this).css({
			top:"128px",
			height:"0px"
		})
		$(".framegrid_title", this).hide()
		$(".framegrid_con", this).hide()
	})
	$('.framegrid.nocaption').hover(function(){
		$(".framegrid_cover", this).stop().animate({top:'68px',height:'60px'},{queue:false,duration:160});
		$(".framegrid_title", this).show()
		$(".framegrid_con", this).show()
	}, function() {
		$(".framegrid_cover", this).stop().animate({top:'125px',height:'0px'},{queue:false,duration:160});
		$(".framegrid_title", this).hide()
		$(".framegrid_con", this).hide()
	});
	
	//详情模式列表
	$(".picItem").hover(function(){
		$(this).addClass("picItemOver")
	},function(){
		$(this).removeClass("picItemOver")
	});
}
</script>
</head>
<body>
 <div class="box1" panelWidth="800">
  <fieldset>
   <legend>1、边框效果</legend>
	<div class="picItem2"><img src="<%=path%>/libs/images/demo/demo2.jpg"/></div>
	<div class="picItem2"><img src="<%=path%>/libs/images/demo/demo3.jpg"/></div>
	<div class="picItem2"><img src="<%=path%>/libs/images/demo/demo2.jpg"/></div>
	<div class="picItem2"><img src="<%=path%>/libs/images/demo/demo3.jpg"/></div>
	<div class="picItem2"><img src="<%=path%>/libs/images/demo/demo2.jpg"/></div>
	<div class="picItem2"><img src="<%=path%>/libs/images/demo/demo3.jpg"/></div>
	<div class="clear"></div>
  </fieldset>
  <div class="height_15"></div>
 
 
 
 <fieldset>
   <legend>2、入场特效</legend>
    <div id="list-2">
    <div class="picItem2" style="display:none;"><img src="<%=path%>/libs/images/demo/demo2.jpg"/></div>
	<div class="picItem2" style="display:none;"><img src="<%=path%>/libs/images/demo/demo3.jpg"/></div>
	<div class="picItem2" style="display:none;"><img src="<%=path%>/libs/images/demo/demo2.jpg"/></div>
	<div class="picItem2" style="display:none;"><img src="<%=path%>/libs/images/demo/demo3.jpg"/></div>
	<div class="picItem2" style="display:none;"><img src="<%=path%>/libs/images/demo/demo2.jpg"/></div>
	<div class="picItem2" style="display:none;"><img src="<%=path%>/libs/images/demo/demo3.jpg"/></div>
	<div class="clear"></div>
	</div>
  </fieldset>
  <div class="height_15"></div>
 

  
  <fieldset>
   <legend>3、添加标题特效</legend>
    <div class="framegrid nocaption">
		<div class="picItem3"><img src="<%=path%>/libs/images/demo/demo2.jpg"/></div>	
		<div class="framegrid_cover">
			<div class="framegrid_title">图片标题</div>
			<div class="framegrid_con">这里是图片文字说明部分<br />这里是图片文字说明部分</div>
		</div>	
	</div>
	<div class="framegrid nocaption">
		<div class="picItem3"><img src="<%=path%>/libs/images/demo/demo3.jpg"/></div>	
		<div class="framegrid_cover">
			<div class="framegrid_title">图片标题</div>
			<div class="framegrid_con">这里是图片文字说明部分<br />这里是图片文字说明部分</div>
		</div>
	</div>
	<div class="framegrid nocaption">
		<div class="picItem3"><img src="<%=path%>/libs/images/demo/demo2.jpg"/></div>	
		<div class="framegrid_cover">
			<div class="framegrid_title">图片标题</div>
			<div class="framegrid_con">这里是图片文字说明部分<br />这里是图片文字说明部分</div>
		</div>	
	</div>
	<div class="clear"></div>
  </fieldset>
  <div class="height_15"></div>
  
   <fieldset>
  <legend>4、详情模式列表</legend>
   <div class="picItem">
		<div class="picItem_title">
			该项标题
		</div>
		<div class="details">
			<img src="<%=path%>/libs/images/demo/demo2.jpg"/>
			<div class="picItem_con">该项详细说明<br />该项详细说明</div>
		</div>
	</div>
	
	<div class="picItem">
		<div class="picItem_title">
			该项标题
		</div>
		<div class="details">
			<img src="<%=path%>/libs/images/demo/demo3.jpg"/>
			<div class="picItem_con">该项详细说明<br />该项详细说明</div>
		</div>
	</div>
	
	<div class="picItem">
		<div class="picItem_title">
			该项标题
		</div>
		<div class="details">
			<img src="<%=path%>/libs/images/demo/demo2.jpg"/>
			<div class="picItem_con">该项详细说明<br />该项详细说明</div>
		</div>
	</div>
	
	<div class="picItem">
		<div class="picItem_title">
			该项标题
		</div>
		<div class="details">
			<img src="<%=path%>/libs/images/demo/demo3.jpg"/>
			<div class="picItem_con">该项详细说明<br />该项详细说明</div>
		</div>
	</div>
	
	<div class="clear"></div>
  </fieldset>
  <div class="height_15"></div>
  
   <fieldset>
   <legend>5、渐显特效</legend>
	<div class="picItem2"><img src="<%=path%>/libs/images/demo/demo2.jpg" class="imgFade"/></div>
	<div class="picItem2"><img src="<%=path%>/libs/images/demo/demo3.jpg" class="imgFade"/></div>
	<div class="picItem2"><img src="<%=path%>/libs/images/demo/demo2.jpg" class="imgFade"/></div>
	<div class="picItem2"><img src="<%=path%>/libs/images/demo/demo3.jpg" class="imgFade"/></div>
	<div class="picItem2"><img src="<%=path%>/libs/images/demo/demo2.jpg" class="imgFade"/></div>
	<div class="picItem2"><img src="<%=path%>/libs/images/demo/demo3.jpg" class="imgFade"/></div>
	<div class="clear"></div>
  </fieldset>
  <div class="height_15"></div>
  
  
  
  
  
  </div>
  
</body>
</html>