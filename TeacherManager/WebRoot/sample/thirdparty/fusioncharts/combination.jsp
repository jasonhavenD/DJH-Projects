<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>组合图</title>
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!--图表脚本start-->
<script language="JavaScript" src="<%=path%>/libs/thirdparty/fusioncharts/js/FusionCharts.js"></script>
<!--图表脚本end-->
<script>
function initComplete(){
	   
	   var chartPath = "<%=path%>/libs/thirdparty/fusioncharts/swf/";
       var dataUrlPath = "<%=path%>/libs/thirdparty/fusioncharts/data/";

	   var chart1 = new FusionCharts(chartPath + "MSCombi2D.swf", "ChartId", "100%", "300", "0", "0");
	   chart1.setDataURL(dataUrlPath + "Combi2D.xml");	   
	   chart1.render("chartdiv1");
	   
	   var chart2 = new FusionCharts(chartPath + "MSCombiDY2D.swf", "ChartId", "100%", "300", "0", "0");
	   chart2.setDataURL(dataUrlPath + "Combi2DDY.xml");		   
	   chart2.render("chartdiv2");
	   
	   var chart3 = new FusionCharts(chartPath + "MSStackedColumn2DLineDY.swf", "ChartId", "100%", "300", "0", "0");
	   chart3.setDataURL(dataUrlPath + "StCol2DLineDY.xml");   
	   chart3.render("chartdiv3");
}
</script>
</head>
<body>
	<div class="box1" panelWidth="800">
	  <fieldset> 
      <legend>柱+面+曲线(Y单坐标)</legend>
      <p>柱、线、面可以任意组合，也可以不同时出现3种图表。</p>
     	<div id="chartdiv1"> 
	        <div class="flash_install">
				<div class="msg_icon3"></div>
				<div class="flash_install_con" >
				您需要升级Flash播放器，<span class="forIE"><a href="<%=path%>/libs/flash/flash_IE.exe">点击这里</a>安装</span>
				<span class="forFF"><a href="<%=path%>/libs/flash/flash_FF.exe">点击这里</a>进行安装</span><br />安装后请关闭浏览器再重新打开
				</div>
			</div>
		</div>
	   </fieldset>
	   <div class="height_50"></div>
	   
	  <fieldset>
      <legend>柱+面+曲线(双Y坐标)</legend>
     	<div id="chartdiv2"> 
	        <div class="flash_install">
				<div class="msg_icon3"></div>
				<div class="flash_install_con" >
				您需要升级Flash播放器，<span class="forIE"><a href="<%=path%>/libs/flash/flash_IE.exe">点击这里</a>安装</span>
				<span class="forFF"><a href="<%=path%>/libs/flash/flash_FF.exe">点击这里</a>进行安装</span><br />安装后请关闭浏览器再重新打开
				</div>
			</div>
		</div>
	   </fieldset>
	   <div class="height_50"></div>
	   
	  <fieldset> 
      <legend>多列累加柱+曲线(双Y坐标)</legend>
     	<div id="chartdiv3"> 
	        <div class="flash_install">
				<div class="msg_icon3"></div>
				<div class="flash_install_con" >
				您需要升级Flash播放器，<span class="forIE"><a href="<%=path%>/libs/flash/flash_IE.exe">点击这里</a>安装</span>
				<span class="forFF"><a href="<%=path%>/libs/flash/flash_FF.exe">点击这里</a>进行安装</span><br />安装后请关闭浏览器再重新打开
				</div>
			</div>
		</div>
	   </fieldset>
	   
	</div>
</body>
</html>