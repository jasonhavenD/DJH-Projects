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

<!--图片弹窗start-->
<script type="text/javascript" src="<%=path%>/libs/thirdparty/highslide/highslide-with-gallery.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path%>/libs/thirdparty/highslide/highslide.css" />
<!--图片弹窗end-->

<script>
function initComplete(){
	//动画入场
	$("#list .picItem3").hide();
	$("#list .picItem3").jomino();
	
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
	
	
	//图片弹窗
	hs.graphicsDir = '<%=path%>/libs/thirdparty/highslide/graphics/';
	hs.align = 'center';
	hs.transitions = ['expand', 'crossfade'];
	hs.outlineType = 'rounded-white';
	hs.fadeInOut = true;
	
	hs.addSlideshow({
		interval: 5000,
		repeat: false,
		useControls: true,
		fixedControls: 'fit',
		overlayOptions: {
			opacity: .75,
			position: 'bottom center',
			hideOnMouseOut: true
		}
	});	
	
}
</script>
</head>
<body>
<div class="box1" panelWidth="800">
	<div id="list">
	  <div class="framegrid nocaption">
		<a href="<%=path%>/libs/images/demo/demo4.jpg" class="highslide" onclick="return hs.expand(this)">
		<div class="picItem3"><img src="<%=path%>/libs/images/demo/demo1.jpg"/></div>	
		<div class="framegrid_cover">
			<div class="framegrid_title">图片标题</div>
			<div class="framegrid_con">这里是图片文字说明部分<br />这里是图片文字说明部分</div>
		</div>	
		</a>
	</div>
	<div class="framegrid nocaption">
		<a href="<%=path%>/libs/images/demo/demo2.jpg" class="highslide" onclick="return hs.expand(this)">
		<div class="picItem3"><img src="<%=path%>/libs/images/demo/demo2.jpg"/></div>	
		<div class="framegrid_cover">
			<div class="framegrid_title">图片标题</div>
			<div class="framegrid_con">这里是图片文字说明部分<br />这里是图片文字说明部分</div>
		</div>
		</a>
	</div>
	<div class="framegrid nocaption">
		<a href="<%=path%>/libs/images/demo/demo3.jpg" class="highslide" onclick="return hs.expand(this)">
		<div class="picItem3"><img src="<%=path%>/libs/images/demo/demo3.jpg"/></div>	
		<div class="framegrid_cover">
			<div class="framegrid_title">图片标题</div>
			<div class="framegrid_con">这里是图片文字说明部分<br />这里是图片文字说明部分</div>
		</div>	
		</a>
	</div>
	 <div class="framegrid nocaption">
		<a href="<%=path%>/libs/images/demo/demo4.jpg" class="highslide" onclick="return hs.expand(this)">
		<div class="picItem3"><img src="<%=path%>/libs/images/demo/demo1.jpg"/></div>	
		<div class="framegrid_cover">
			<div class="framegrid_title">图片标题</div>
			<div class="framegrid_con">这里是图片文字说明部分<br />这里是图片文字说明部分</div>
		</div>	
		</a>
	</div>
	<div class="framegrid nocaption">
		<a href="<%=path%>/libs/images/demo/demo2.jpg" class="highslide" onclick="return hs.expand(this)">
		<div class="picItem3"><img src="<%=path%>/libs/images/demo/demo2.jpg"/></div>	
		<div class="framegrid_cover">
			<div class="framegrid_title">图片标题</div>
			<div class="framegrid_con">这里是图片文字说明部分<br />这里是图片文字说明部分</div>
		</div>
		</a>
	</div>
	<div class="framegrid nocaption">
		<a href="<%=path%>/libs/images/demo/demo3.jpg" class="highslide" onclick="return hs.expand(this)">
		<div class="picItem3"><img src="<%=path%>/libs/images/demo/demo3.jpg"/></div>	
		<div class="framegrid_cover">
			<div class="framegrid_title">图片标题</div>
			<div class="framegrid_con">这里是图片文字说明部分<br />这里是图片文字说明部分</div>
		</div>	
		</a>
	</div>
	 <div class="framegrid nocaption">
		<a href="<%=path%>/libs/images/demo/demo4.jpg" class="highslide" onclick="return hs.expand(this)">
		<div class="picItem3"><img src="<%=path%>/libs/images/demo/demo1.jpg"/></div>	
		<div class="framegrid_cover">
			<div class="framegrid_title">图片标题</div>
			<div class="framegrid_con">这里是图片文字说明部分<br />这里是图片文字说明部分</div>
		</div>	
		</a>
	</div>
	<div class="framegrid nocaption">
		<a href="<%=path%>/libs/images/demo/demo2.jpg" class="highslide" onclick="return hs.expand(this)">
		<div class="picItem3"><img src="<%=path%>/libs/images/demo/demo2.jpg"/></div>	
		<div class="framegrid_cover">
			<div class="framegrid_title">图片标题</div>
			<div class="framegrid_con">这里是图片文字说明部分<br />这里是图片文字说明部分</div>
		</div>
		</a>
	</div>
	<div class="framegrid nocaption">
		<a href="<%=path%>/libs/images/demo/demo3.jpg" class="highslide" onclick="return hs.expand(this)">
		<div class="picItem3"><img src="<%=path%>/libs/images/demo/demo3.jpg"/></div>	
		<div class="framegrid_cover">
			<div class="framegrid_title">图片标题</div>
			<div class="framegrid_con">这里是图片文字说明部分<br />这里是图片文字说明部分</div>
		</div>	
		</a>
	</div>
	 <div class="framegrid nocaption">
		<a href="<%=path%>/libs/images/demo/demo4.jpg" class="highslide" onclick="return hs.expand(this)">
		<div class="picItem3"><img src="<%=path%>/libs/images/demo/demo1.jpg"/></div>	
		<div class="framegrid_cover">
			<div class="framegrid_title">图片标题</div>
			<div class="framegrid_con">这里是图片文字说明部分<br />这里是图片文字说明部分</div>
		</div>	
		</a>
	</div>
	<div class="framegrid nocaption">
		<a href="<%=path%>/libs/images/demo/demo2.jpg" class="highslide" onclick="return hs.expand(this)">
		<div class="picItem3"><img src="<%=path%>/libs/images/demo/demo2.jpg"/></div>	
		<div class="framegrid_cover">
			<div class="framegrid_title">图片标题</div>
			<div class="framegrid_con">这里是图片文字说明部分<br />这里是图片文字说明部分</div>
		</div>
		</a>
	</div>
	<div class="framegrid nocaption">
		<a href="<%=path%>/libs/images/demo/demo3.jpg" class="highslide" onclick="return hs.expand(this)">
		<div class="picItem3"><img src="<%=path%>/libs/images/demo/demo3.jpg"/></div>	
		<div class="framegrid_cover">
			<div class="framegrid_title">图片标题</div>
			<div class="framegrid_con">这里是图片文字说明部分<br />这里是图片文字说明部分</div>
		</div>	
		</a>
	</div>
	<div class="clear"></div>
	</div>
</div>
</body>
</html>