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
</head>
<body>
<div class="box1" panelWidth="800">
	<fieldset>
      	<legend>控件介绍</legend>
      	fusionCharts是国外一款商业图表组件，图表种类丰富，样式美观。支持XML数据和JSON数据。图表方案有flash和javascript两种。<br/>
      	flash方案的效果非常好，适合面向PC机（windows系统）的项目，javascript方案效果不如flash，适合不支持flash的移动设备或linux系统。<br/>
      	在本框架的source目录下的“常用文档”目录有该控件的官方示例和使用帮助。<br/>
      </fieldset>
      <div class="height_15"></div>
      
      <fieldset>
      <legend>JS图表方案的实现</legend>
      	在构建flash图表前加下面的一句话：<br/>
      	 FusionCharts.setCurrentRenderer('javascript');<br/>
      	 其他不变，这样就变成了JS版的图表了。<br/>
      	 注意：框架默认的jquery版本是1.7.2，而JS图表目前只兼容jquery1.4.2，所以使用JS版本图表时要把框架引用的jquery.js改成jquery1.4.2_min.js<br/>
      	 另外，flash版本时柱状图数据属性经常设置useRoundEdges='1'来实现圆角水晶风格以达到美观效果，而在JS图表中圆角风格并不美观，这时最好设置useRoundEdges='0'使用直角。
      </fieldset>
      <div class="height_15"></div>
      
      <fieldset>
      	<legend>常用属性设置</legend>
      	图表的数据是以chart为根节点的XML格式数据，在chart标签上添加属性可以实现自定义的外观配置。常用属性如下：<br />
	<table class="tableStyle">
		<tr>
			<th width="20%">属性名</th><th>说明</th>
		</tr>
		<tr>
			<td>baseFontSize</td><td>字体大小，默认为10，推荐设为12</td>
		</tr>
		<tr>
			<td>baseFontColor</td><td>字体颜色，默认为黑色</td>
		</tr>
		<tr>
			<td>baseFont</td><td>字体名称</td>
		</tr>
		<tr>
			<td>caption</td><td>图表标题</td>
		</tr>
		<tr>
			<td>subcaption</td><td>描述信息</td>
		</tr>
		<tr>
			<td>rotateNames</td><td>x坐标文字的方向，默认为0，水平；1为垂直。中文如果垂直文字会消失（这是因为flash中文在没有绑定中文字体时倾斜就会导致文字消失）</td>
		</tr>
		<tr>
			<td>rotateYAxisName</td><td>y坐标文字的方向,默认为1，垂直。注意如果是中文要设置rotateYAxisName=0才能正常显示，理由同上。</td>
		</tr>
		<tr>
			<td>labelDisplay</td><td>横向坐标值显示方式，可选值WRAP, STAGGER, ROTATE or NONE。其中STAGGER代表label上下交错显示，ROTATE会导致中文消失</td>
		</tr>
		<tr>
			<td>labelStep</td><td>设置每几格显示一个label文本，默认为1。如果横向项目太多可以每两格显示一个label文本</td>
		</tr>
		<tr>
			<td>yAxisMinValue</td><td>Y坐标轴起始值，默认为0</td>
		</tr>
		<tr>
			<td>numberPrefix</td><td>为每个Y坐标轴值的前面加的符号</td>
		</tr>
		<tr>
			<td>numberSuffix</td><td>为每个Y坐标轴值的后面加的符号</td>
		</tr>
		<tr>
			<td>palette</td>
			<td>图表的背景渐变风格，可选值从1-5。<br />
				2D柱状图、2D饼图中；1灰白渐变 2鹅黄色渐变 3浅蓝渐变 4橙黄色渐变 5粉红色渐变<br />
				3D柱状图：1古铜色渐变 2灰白渐变 3褐色渐变 4青色渐变 5橙红渐变<br />
				3D饼图不生效，可设置bgColor实现渐变
			</td>
		</tr>
		<tr>
			<td>xAxisName</td><td>x坐标名称</td>
		</tr>
		<tr>
			<td>yAxisName</td><td>y坐标名称</td>
		</tr>
		<tr>
			<td>showValues</td><td>是否在图表上显示值，默认为1，显示。</td>
		</tr>
		<tr>
			<td>formatNumberScale</td><td>是否格式化数字，默认为1，格式化。例如1000将被格式化1K</td>
		</tr>
		<tr>
			<td>useRoundEdges</td><td>是否采用水晶风格（2D图表有效，3D图表无效），默认为0，不使用。推荐设为1.</td>
		</tr>
		<tr>
			<td>enableSmartLabels</td><td>是否显示指示线（饼图有效），默认为1，显示</td>
		</tr>
		<tr>
			<td>startingAngle</td><td>初始时旋转的角度（饼图有效）</td>
		</tr>
		<tr>
			<td>enableRotation</td><td>是否支持鼠标拖拽旋转（饼图有效），默认为0，不可旋转</td>
		</tr>
		<tr>
			<td>bgColor</td><td>自定义渐变颜色，如bgColor='99CCFF,FFFFFF'蓝白渐变</td>
		</tr>
		<tr>
			<td>bgAlpha</td><td>自定义渐变色透明度，如bgAlpha='40,100'</td>
		</tr>
		<tr>
			<td>bgRatio</td><td>自定义渐变的旋转度，默认bgRatio='0,100'</td>
		</tr>
		<tr>
			<td>bgAngle</td><td>自定义渐变的方向，默认bgAngle='90'，即上下渐变，例如可以设为bgAngle='360'则从左到右渐变</td>
		</tr>
		<tr>
			<td>canvasBorderColor</td><td>边框颜色</td>
		</tr>
		<tr>
			<td>showBorder</td><td>是否显示边框，0为不显示，1为显示</td>
		</tr>
		<tr>
			<td>alternateHGridColor</td><td>背景隔行变色的颜色</td>
		</tr>
		<tr>
			<td>alternateHGridAlpha</td><td>背景隔行变色的透明度</td>
		</tr>
		<tr>
			<td>divLineColor</td><td>背景每行线颜色</td>
		</tr>
		<tr>
			<td>divLineAlpha</td><td>背景每行线透明度</td>
		</tr>
		<tr>
			<td>divLineIsDashed</td><td>背景每行线是否为虚线，为1代表虚线</td>
		</tr>
		<tr>
			<td>lineColor</td><td>曲线图中线的颜色</td>
		</tr>
		<tr>
			<td>lineThickness</td><td>曲线图中线的粗细</td>
		</tr>
		<tr>
			<td>anchorRadius</td><td>曲线图中每个拐点的半径</td>
		</tr>
		<tr>
			<td>chartRightMargin</td><td>图表距背景边框右侧的偏移，除此还有chartLeftMargin、chartTopMargin、chartBottomMargin</td>
		</tr>
		<tr>
			<td>legendBorderAlpha</td><td>图例的边框透明度</td>
		</tr>
		<tr>
			<td>hovercapbg</td><td>提示框的背景色</td>
		</tr>
	</table>
      </fieldset>
      <div class="height_15"></div>
      
      
</div>      
</body>
</html>