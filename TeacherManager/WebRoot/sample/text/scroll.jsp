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

<!--纵向滚动start-->
<script type="text/javascript" src="<%=path%>/libs/js/text/vticker.js"></script>
<!--纵向滚动end-->
<script type="text/javascript">
function initComplete(){
	$('.news-container').vTicker();
	$('.news-container2').vTicker({
		"showItems":1
	});
}
</script>
</head>
<body>
<div class="box1" panelWidth="800">
 <fieldset>
   <legend>1、普通滚动</legend>
   <div style="width:600px;height:30px;line-height:30px;">
		<marquee  direction="right" scrollamount="2" scrolldelay="50">
		滚动文字
		</marquee>
	</div>
  </fieldset>
  <div class="height_15"></div>
  
  
  <fieldset>
   <legend>2、上下滚动</legend>
	<div class="news-container" style="width: 400px;">
		<ul>
			<li>滚动新闻1</li> 
			<li>滚动新闻2</li> 
			<li>滚动新闻3</li> 
			<li>滚动新闻4</li> 
			<li>滚动新闻5</li> 
		</ul>
	</div>
  </fieldset>
  <div class="height_15"></div>
  
  <fieldset>
   <legend>3、自定义可见条数</legend>
   <div class="news-container2" style="width: 400px;">
		<ul>
			<li>滚动新闻1</li> 
			<li>滚动新闻2</li> 
			<li>滚动新闻3</li> 
			<li>滚动新闻4</li> 
			<li>滚动新闻5</li> 
		</ul>
	</div>
  </fieldset>
  <div class="height_15"></div>
  
  </div>
</body>
</html>