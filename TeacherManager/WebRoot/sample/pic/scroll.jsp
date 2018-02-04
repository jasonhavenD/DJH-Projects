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

<!--图片滚动start-->
<script type="text/javascript" src="<%=path%>/libs/js/pic/imgScroll.js"></script>
<!--图片滚动end-->
<script>
	function initComplete(){
		//基本使用
		new Marquee("marqueediv1",2,1,750,120,20,0,0)
		
		//加速滚动
		var marquee2=new Marquee("marqueediv2");
		marquee2.Direction="left";
		marquee2.Step=1;
		marquee2.Width=750;
		marquee2.Height=120;
		marquee2.Timer=20;
		marquee2.ScrollStep=-1;//此句禁止鼠标控制
		marquee2.Start();
		left.onmousedown=function(){
		marquee2.Step=marquee2.BakStep+2;
		marquee2.Direction=2;
		}
		left.onmouseup=function(){
		marquee2.Step=marquee2.BakStep;
		}
		right.onmousedown=function(){
		marquee2.Step=marquee2.BakStep+2;
		marquee2.Direction=3;
		}
		right.onmouseup=function(){
		marquee2.Step=marquee2.BakStep;
		}
		
		//表格间歇滚动
		new Marquee("marqueeTable",0,1,500,270,20,4000,1000,30)
		//通过调节最后一个参数设定每次滚动的高度
	}
</script>
</head>
<body>
 	<div class="box1" panelWidth="800">
 	
 	<fieldset>
   <legend>1、基本使用</legend>
<div id="marqueediv1">
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
   </fieldset>
  <div class="height_15"></div>
 	
<fieldset>
   <legend>2、加速滚动</legend>
<div id="marqueediv2">
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
<input type="button" value="向左加速" id="left"/>
<input type="button" value="向右加速" id="right"/>
   </fieldset>
  <div class="height_15"></div>


<fieldset>
   <legend>3、表格间歇滚动</legend>
<div style="width:500px;">
<table class="tableStyle noBottomLine"  cellspacing="0" cellpadding="0">
 <thead>
 <tr>
 <th width="120">任务分类</th>
 <th width="80">未签收</th>
 <th width="80">未部署</th>
 <th width="140">未签阅反馈信息</th>
 <th width="80">未上报</th>
 </tr>									
 </thead>
 </table>
</div>
<div id="marqueeTable" style="border-bottom:solid 1px #cccccc;">
<table class="tableStyle"  cellspacing="0" cellpadding="0">
 <tbody>
 <tr class="tr_bg1" style="height:30px;">
 <td class="td02_2" width="120">任务1</td>
 <td class="td02_2" width="80">188条</td>
 <td class="td02_2" width="80">188条</td>
 <td class="td02_2" width="140">188条</td>
 <td class="td02_2" width="80">188条</td>
 </tr>	
  <tr class="tr_bg3" style="height:30px;">
 <td class="td02_2">任务2</td>
 <td class="td02_2">188条</td>
 <td class="td02_2">188条</td>
 <td class="td02_2">188条</td>
 <td class="td02_2">188条</td>
 </tr>	
  <tr class="tr_bg1" style="height:30px;">
 <td class="td02_2">任务3</td>
 <td class="td02_2">188条</td>
 <td class="td02_2">188条</td>
 <td class="td02_2">188条</td>
 <td class="td02_2">188条</td>
 </tr>	
  <tr class="tr_bg3" style="height:30px;">
 <td class="td02_2">任务4</td>
 <td class="td02_2">188条</td>
 <td class="td02_2">188条</td>
 <td class="td02_2">188条</td>
 <td class="td02_2">188条</td>
 </tr>
  <tr class="tr_bg1" style="height:30px;">
 <td class="td02_2">任务5</td>
 <td class="td02_2">188条</td>
 <td class="td02_2">188条</td>
 <td class="td02_2">188条</td>
 <td class="td02_2">188条</td>
 </tr>	
  <tr class="tr_bg3" style="height:30px;">
 <td class="td02_2">任务6</td>
 <td class="td02_2">188条</td>
 <td class="td02_2">188条</td>
 <td class="td02_2">188条</td>
 <td class="td02_2">188条</td>
 </tr>
  <tr class="tr_bg1" style="height:30px;">
 <td class="td02_2">任务7</td>
 <td class="td02_2">188条</td>
 <td class="td02_2">188条</td>
 <td class="td02_2">188条</td>
 <td class="td02_2">188条</td>
 </tr>	
  <tr class="tr_bg3" style="height:30px;">
 <td class="td02_2">任务8</td>
 <td class="td02_2">188条</td>
 <td class="td02_2">188条</td>
 <td class="td02_2">188条</td>
 <td class="td02_2">188条</td>
 </tr>
  <tr class="tr_bg1" style="height:30px;">
 <td class="td02_2">任务9</td>
 <td class="td02_2">188条</td>
 <td class="td02_2">188条</td>
 <td class="td02_2">188条</td>
 <td class="td02_2">188条</td>
 </tr>	
  <tr class="tr_bg3" style="height:30px;">
 <td class="td02_2">任务10</td>
 <td class="td02_2">188条</td>
 <td class="td02_2">188条</td>
 <td class="td02_2">188条</td>
 <td class="td02_2">188条</td>
 </tr>
  </tbody>
  </table>
  </div>
   </fieldset>



 	
 	</div>
</body>
</html>