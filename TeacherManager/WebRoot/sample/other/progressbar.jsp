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

<!--进度条start-->
<script type="text/javascript" src="<%=path%>/libs/js/other/progressbar.js"></script>
<!--进度条end-->

<!--引入弹窗组件start-->
<script type="text/javascript" src="<%=path%>/libs/js/popup/drag.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/popup/dialog.js"></script>
<!--引入弹窗组件end-->
</head>
<body>
<div class="box1" panelWidth="800">
 <fieldset>
   <legend>说明</legend>
	如果后台要进行长时间处理，例如数据的导入导出等操作，前台可以使用该进度条。后台通过ajax方法实时发送真实进度情况。
  </fieldset>
  <div class="height_15"></div>
  
   <fieldset>
   <legend>1、固定位置</legend>
	<div id="pb1"></div><span id="pb1-label"></span>
  </fieldset>
  <div class="height_15"></div>
  
   <fieldset>
   <legend>2、模拟进度</legend>
	<div id="pb2"></div><span id="pb2-label"></span>
  </fieldset>
  <div class="height_15"></div>
  
  <fieldset>
   <legend>3、弹出进度窗口，并遮罩操作内容页面</legend>
	<input type="button" value="弹出进度" onclick="popWin()"/>
  </fieldset>
  <div class="height_15"></div>
  
  <fieldset>
   <legend>4、弹出进度窗口，可最小化</legend>
	<input type="button" value="弹出进度" onclick="popWin2()"/>
  </fieldset>
  <div class="height_15"></div>
</div>  

</div>
<!--窗口任务栏区域start-->
<div id="dialogTask" class="dialogTaskBg" style="display:none;"></div>
<!--窗口任务栏区域end-->

<script>
function initComplete(){
	var _progress;
	_progress = $("#pb1").progressCtrl({ skin: '<%=path%>/libs/images/loading/progress.png', width:300} ) ;	
	setTimeout(function(){_progress.progressCtrl(50);}, 300);
	
	var _pbbar_pos = 0;
	var _progress2 ;
	_progress2 = $("#pb2").progressCtrl({ skin: '<%=path%>/libs/images/loading/progress.png', width:300} ) ;	
	interval1= setInterval(function(){
         if (++_pbbar_pos > 100){
         	_pbbar_pos = 0;
         	clearInterval(interval1);
         	return;
         } 
         _progress2.progressCtrl(_pbbar_pos);
        
    }, 300);
}
var diag;
var diag2;
var interval1;
var interval2;
var interval3;
var diagContentId=100;
function popWin(){
    diag = new Dialog();
   diag.Title = "处理进度";
	diag.ID="c1";
	diag.Width=330;
	diag.Height=100;
	diag.ShowCloseButton=false;
	diag.show();
 

    var $container=$(document.getElementById("_Container_c1"));
   var $progress=$('<div class="padding_top20 padding_left10"></div>');
   diagContentId++;
   var $progressCon1=$('<div class="padding_bottom5">正在处理中，请不要关闭或切换其他页面。</div>');
   var $progressCon2=$('<div></div>');
   var $progressCon3=$('<span></span>');
   $progress.append($progressCon1);
   $progress.append($progressCon2);
   $progress.append($progressCon3);
   $progressCon2.attr("id",diagContentId);
   $progressCon3.attr("id", diagContentId+"-label");
   $container.append($progress);
   
    var _pbbar_pos = 0;
	var _progress = $progressCon2.progressCtrl({ skin: '<%=path%>/libs/images/loading/progress.png', width:300});	
	interval2= setInterval(function(){
         if (++_pbbar_pos > 100){
         	_pbbar_pos = 0;
         	clearInterval(interval2);
         	top.Dialog.alert("处理完成！");
         	if(diag){
         		diag.close();
         	}
         	return;
         } 
         _progress.progressCtrl(_pbbar_pos);
        
    }, 100);
}


function popWin2(){
   diag2 = new Dialog();
   diag2.Title = "处理进度";
	diag2.ID="c2";
	diag2.Width=330;
	diag2.Height=100;
	diag2.ShowMinButton=true;
	diag2.MinToTask=true;
	diag2.ShowCloseButton=false;
	diag2.show();
 

    var $container=$(document.getElementById("_Container_c2"));
   var $progress=$('<div class="padding_top20 padding_left10"></div>');
   diagContentId++;
   var $progressCon1=$('<div class="padding_bottom5">正在处理中，可以最小化本窗口并继续操作其他内容。</div>');
   var $progressCon2=$('<div></div>');
   var $progressCon3=$('<span></span>');
   $progress.append($progressCon1);
   $progress.append($progressCon2);
   $progress.append($progressCon3);
   $progressCon2.attr("id",diagContentId);
   $progressCon3.attr("id", diagContentId+"-label");
   $container.append($progress);
   
    var _pbbar_pos = 0;
	var _progress = $progressCon2.progressCtrl({ skin: '<%=path%>/libs/images/loading/progress.png', width:300});	
	interval3= setInterval(function(){
         if (++_pbbar_pos > 100){
         	_pbbar_pos = 0;
         	clearInterval(interval3);
         	top.Dialog.alert("处理完成！");
         	if(diag2){
         		diag2.close();
         	}
         	return;
         } 
         _progress.progressCtrl(_pbbar_pos);
        
    }, 100);
}

</script>
</body>
</html>