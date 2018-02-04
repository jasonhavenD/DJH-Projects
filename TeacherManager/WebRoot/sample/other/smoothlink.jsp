<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!--平滑锚点start-->
<script type="text/javascript" src="<%=path%>/libs/js/other/smoothscroll.js"></script>
<!--平滑锚点end-->

<body>
	<a name="top"></a>
<div >
	<ul>
	<li><a href="#p0">RIA概述</a></li>
	<li><a href="#p1">FLex概述</a></li>
	<li><a href="#p2">支持完全自定义皮肤</a></li>
	<li><a href="#p3">与Flash无缝衔接</a></li>
	<li><a href="#p4">强大的数据展示</a></li>
	<li><a href="#p5">丰富的表现力</a></li>
	<li><a href="#p6">破平面限制</a></li>
	<li><a href="#p7">良好数据传递和处理</a></li>
	</ul>
</div>

<div style="width:500px;border:solid 1px #ccc;">
<a name="p0"></a>
<h2>RIA与Flex</h2>
<p>当下非常流行一个名词叫RIA，RIA全称是Rich Internet Application，翻译成中文为丰富互联网应用程序。RIA 是集桌面应用程序的最佳用户界面功能与Web应用程序的普遍采用和快速、低成本布署以及互动多媒体通信的实时快捷于一体的新一代网络应用程序。目前WEB领域和桌面软件领域正逐步向RIA靠拢，预计3、5年后RIA的时代将会完全到来。</p>
<p>现在很多大软件公司纷纷抢占RIA 领域的市场，以至于出现百花争鸣的现象。能够实现RIA的技术有很多种，例如Adobe公司的推出的Flex技术、微软推出的SilverLight技术、Sun被收购前推出的JavaFX，还有我们熟知的AJAX也可以算作一种轻量级的RIA技术。</p>
<P><A href="#top"><span class="font_bold">回顶部</span></A></P>

<a name="p1"></a>
<h2>FLex概述</h2>
<p>Flex通俗的说就是使用编程的手法来开发制作Flash，让Flash实现不再是设计人员的专利。开发出来的Flash既可以作为网页的组成部分用于WEB领域，也可以嵌入到C++、C#桌面程序中以改善界面美观和提高用户体验。</p>
<P><A href="#top"><span class="font_bold">回顶部</span></A></P>

<a name="p2"></a>
<h2>支持完全自定义皮肤</h2>
<p>Flex支持用户完全自定义皮肤，小到按钮，大到整个网页或软件的界面都可以根据需要进行定制。例如你可以把一个按钮做成图 1- 1模样并且不改变按钮的特性，你甚至可以做成当鼠标移入时会有一个箱子打开的动画过程。这在普通的网页中只能通过JAVASCRIPT操作图片来完成，实现起来工作量较大，灵活度也较差。</p>
<P><A href="#top"><span class="font_bold">回顶部</span></A></P>

<a name="p3"></a>
<h2>与Flash无缝衔接</h2>
<p>Flex能够和Flash无缝衔接，可以完成很多JAVASCRIPT无法做到的特殊效果，这对于UI设计师来讲无疑是个福音，可以驰骋自己的想象进行设计。图 1- 2展示了一种效果：点击某个的图标，就会旋转到前面来，突出显示。</p>
<P><A href="#top"><span class="font_bold">回顶部</span></A></P>

<a name="p4"></a>
<h2>强大的数据展示</h2>
<p>Flex自带一套强大的图表组件，可以很容易的创建柱状图、饼状图、折线图等7种类型的图表，可以自定义图表的外观，也可以实现图表与鼠标的交互，你甚至可以实现选择一个表格中的部分数据然后用鼠标拖拽出来就能生成图表。图 1- 3就是一个Flex图表的例子。</p>
<P><A href="#top"><span class="font_bold">回顶部</span></A></P>

<a name="p5"></a>
<h2>丰富的表现力</h2>
<p>Flex是基于组件进行开发的，它本身提供了大量的组件，也允许开发人员基于现有的组件进行二次开发。例如你可以将Flex自身的Panel容器组件进行改造，使其支持最大化、最小化、支持动态改变尺寸等功能。图 1- 4是一个Flex自定容器的效果展示。</p>
<p>你也可以根据需要把进度条设计成图 1- 5图 1- 6样子来改善用户体验，Flex汽车速度表效果的动态进度条实例是Flex开发的模仿汽车速度表效果的进度条效果。</p>
<P><A href="#top"><span class="font_bold">回顶部</span></A></P>

<a name="p6"></a>
<h2>突破平面限制</h2>
<p>使用Flex可以突破传统的平面限制，你可以创造一个具有立体感的应用程序。图 1- 7是一个Flex开发的图片浏览器应用程序。</p>
<p>在Flex可以通过在一定的区域放置很多的层叠面板来增大使用空间丰富界面布局。在图 1- 8中点击后面的面板，它就会移动到前面来，这样不但能够增大使用空间而且能让你的应用更有活力。</p>
<p>图 1- 9显示的是一个模拟了电子杂志的翻页的效果，在每页中可以放置图片、动画、以及其他Flex组件等任何内容。</p>
<P><A href="#top"><span class="font_bold">回顶部</span></A></P>

<a name="p7"></a>
<h2>良好数据传递和处理</h2>
<p>Flex内部有良好的数据处理机制，你可以传递给应用一个XML格式的数据，在Flex中根据数据动态创建元件来实现需要的结果。</p>
<p>图 1- 10是使用Flex动态创建拓扑关系图的应用，关系图的层次和外观取决于外部提供的数据。</p>
<p>图 1- 11是实现了Flex动态创建导航菜单，菜单的层次和外观取决于用户提供的数据。</p>
<P><A href="#top"><span class="font_bold">回顶部</span></A></P>
</div>
</body>
</html>