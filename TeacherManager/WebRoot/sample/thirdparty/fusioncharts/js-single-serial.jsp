<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>单序列图表</title>

<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery1.4.2_min.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!--图表脚本start-->
<script language="JavaScript" src="<%=path%>/libs/thirdparty/fusioncharts/js/FusionCharts.js"></script>
<!--图表脚本end-->

<script type="text/javascript">
function initComplete(){
       FusionCharts.setCurrentRenderer('javascript');
       
       var chartPath = "<%=path%>/libs/thirdparty/fusioncharts/swf/";
       var dataUrlPath = "<%=path%>/libs/thirdparty/fusioncharts/data/";
	  
	   var chart1 = new FusionCharts(chartPath + "Column2D.swf", "chart1", "740", "300", "0", "0");
	   chart1.setDataURL(dataUrlPath + "JS_Column2D.xml");	   
	   chart1.render("chartdiv1");
	   
	   var chart2 = new FusionCharts(chartPath + "Pie2D.swf", "chart2", "100%", "300", "0", "0");
	   chart2.setDataURL(dataUrlPath + "Pie2D.xml");	
	   chart2.render("chartdiv2");
	   
	   var chart3 = new FusionCharts(chartPath + "Line.swf", "chart3", "100%", "300", "0", "0");
	   chart3.setDataURL(dataUrlPath + "Line2D.xml");		   
	   chart3.render("chartdiv3");
	   
	   var chart4 = new FusionCharts(chartPath + "Bar2D.swf", "chart4", "100%", "300", "0", "0");
	   chart4.setDataURL(dataUrlPath + "JS_Bar2D.xml");
	   chart4.render("chartdiv4");
	   
	   var chart5 = new FusionCharts(chartPath + "Area2D.swf", "chart5", "100%", "300", "0", "0");
	   chart5.setDataURL(dataUrlPath + "Area2D.xml");
	   chart5.render("chartdiv5");
	   
	   var chart6 = new FusionCharts(chartPath + "Doughnut2D.swf", "chart6", "100%", "300", "0", "0");
	   chart6.setDataURL(dataUrlPath + "Doughnut2D.xml");
	   chart6.render("chartdiv6");
};

</script>
</head>
<body>
	<div class="box1" panelWidth="800">
	  <fieldset> 
      <legend>柱状图</legend>
      <p>此图表中，设置了X轴名称、Y轴名称信息。</p>
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
      <legend>饼状图</legend>
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
      <legend>曲线图</legend>
        <p>此图表中，设置了副标题、数据后缀信息。</p>
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
	   <div class="height_50"></div>
	   
	    <fieldset> 
      <legend>条形图</legend>
     	<div id="chartdiv4"> 
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
      <legend>面状图</legend>
     	<div id="chartdiv5"> 
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
      <legend>环形图</legend>
     	<div id="chartdiv6"> 
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