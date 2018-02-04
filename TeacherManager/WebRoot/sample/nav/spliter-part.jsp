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

<!--分隔条start-->
<script type="text/javascript" src="<%=path%>/libs/js/nav/spliter.js"></script>
<!--分隔条end-->
</head>
<body>
	<div class="box1" panelWidth="800">
 	  <fieldset> 
     <legend>1、关闭上侧-初始时关闭</legend>
     <div style="border:solid 1px #cccccc;width:200px;">
	 	<div style="Width:100%;height:50px;" id="content1">
	 		内容区域1
	 	</div>
	 	<div class="spliter spliterStyleH" beforeClickClass="spliterBottom" afterClickClass="spliterTop"
	 	beforeClickTip="展开" afterClickTip="收缩"  targetId="content1" init="hide"></div>
 		<div style="Width:100%;height:50px;">
	 		内容区域2
	 	</div>
 	</div>
	  </fieldset>
 	  <div class="height_15"></div>
 	 
 	 
 	 
 	  <fieldset> 
	  <legend>2、关闭上侧-初始时打开</legend>
     <div style="border:solid 1px #cccccc;width:200px;">
	 	<div style="Width:100%;height:50px;" id="content2">
	 		内容区域1
	 	</div>
	 	<div class="spliter spliterStyleH" beforeClickClass="spliterTop" afterClickClass="spliterBottom"
	 	beforeClickTip="收缩" afterClickTip="展开"  targetId="content2"></div>
	 	<div style="Width:100%;height:50px;">
	 		内容区域2
	 	</div>
 	</div>	
	  </fieldset>
 	  <div class="height_15"></div>
 	  
 	  
 	  
 	  <fieldset> 
     <legend>3、关闭下侧-初始时关闭</legend>
    <div style="border:solid 1px #cccccc;width:200px;">
	 	<div style="Width:100%;height:50px;">
	 		内容区域2
	 	</div>
	 	<div class="spliter spliterStyleH" beforeClickClass="spliterBottom" afterClickClass="spliterTop"
	 	beforeClickTip="展开" afterClickTip="收缩"  targetId="content3" init="hide"></div>
	 	<div style="Width:100%;height:50px;" id="content3">
	 		内容区域1
	 	</div>
 	</div> 	
	  </fieldset>
 	  <div class="height_15"></div>
 	 
 	 
 	 
 	  <fieldset> 
	  <legend>4、关闭下侧-初始时打开</legend>
     <div style="border:solid 1px #cccccc;width:200px;">
	 	<div style="Width:100%;height:50px;">
	 		内容区域2
	 	</div>
	 	<div class="spliter spliterStyleH" beforeClickClass="spliterTop" afterClickClass="spliterBottom"
	 	beforeClickTip="收缩" afterClickTip="展开"  targetId="content4"></div>
	 	<div style="Width:100%;height:50px;" id="content4">
	 		内容区域1
	 	</div>
 	</div>	
	  </fieldset>
 	  <div class="height_15"></div>
 	  
 	  
 	  <fieldset> 
     <legend>5、关闭左侧-初始时关闭</legend>
 	<table  cellpadding="0" cellspacing="0">
 		<td>
 		<div style="height:150px;width:100px;border:solid 1px #cccccc;border-right:none;" id="content5">
	 		内容区域1
	 	</div>
 		</td>
 		<td style="border-top:solid 1px #cccccc;border-bottom:solid 1px #cccccc;" class="spliter spliterStyleV"  init="hide"
 		beforeClickClass="spliterRight" afterClickClass="spliterLeft" beforeClickTip="展开" afterClickTip="收缩"  targetId="content5"></td>
 		<td>
 		<div style="height:150px;width:100px;border:solid 1px #cccccc;border-left:none;">
	 		内容区域2
	 	</div>
 		</td>
 	</table>	
	  </fieldset>
 	  <div class="height_15"></div>
 	 
 	 
 	 
 	  <fieldset> 
	  <legend>6、关闭左侧-初始时打开</legend>
 	<table  cellpadding="0" cellspacing="0">
 		<td>
 		<div style="height:150px;width:100px;border:solid 1px #cccccc;border-right:none;" id="content6">
	 		内容区域
	 	</div>
 		</td>
 		<td style="border-top:solid 1px #cccccc;border-bottom:solid 1px #cccccc;" class="spliter spliterStyleV" 
 		beforeClickClass="spliterLeft" afterClickClass="spliterRight" beforeClickTip="收缩" afterClickTip="展开"  targetId="content6"></td>
 		<td>
 		<div style="height:150px;width:100px;border:solid 1px #cccccc;border-left:none;">
	 		内容区域2
	 	</div>
 		</td>
 	</table>	
	  </fieldset>
 	  <div class="height_15"></div>
 	  
 	  
 	  <fieldset> 
     <legend>7、关闭右侧-初始时关闭</legend>
 	<table  cellpadding="0" cellspacing="0">
 		<td>
 		<div style="height:150px;width:100px;border:solid 1px #cccccc;border-right:none;">
	 		内容区域1
	 	</div>
 		</td>
 		<td style="border-top:solid 1px #cccccc;border-bottom:solid 1px #cccccc;" class="spliter spliterStyleV" init="hide"
 		beforeClickClass="spliterRight" afterClickClass="spliterLeft" beforeClickTip="展开" afterClickTip="收缩"  targetId="content7"></td>
 		<td>
 		<div style="height:150px;width:100px;border:solid 1px #cccccc;border-left:none;" id="content7">
	 		内容区域2
	 	</div>
 		</td>
 	</table>
	  </fieldset>
 	  <div class="height_15"></div>
 	 
 	 
 	 
 	  <fieldset> 
	  <legend>8、关闭右侧-初始时打开</legend>
 	<table  cellpadding="0" cellspacing="0">
 		<td>
 		<div style="height:150px;width:100px;border:solid 1px #cccccc;border-right:none;">
	 		内容区域
	 	</div>
 		</td>
 		<td style="border-top:solid 1px #cccccc;border-bottom:solid 1px #cccccc;" class="spliter spliterStyleV" 
 		beforeClickClass="spliterLeft" afterClickClass="spliterRight" beforeClickTip="收缩" afterClickTip="展开"  targetId="content8"></td>
 		<td>
 		<div style="height:150px;width:100px;border:solid 1px #cccccc;border-left:none;" id="content8">
	 		内容区域2
	 	</div>
 		</td>
 	</table>	
	  </fieldset>
 	  <div class="height_15"></div>
	  
	  <fieldset> 
	  <legend>9、外部控制</legend>
     <div style="border:solid 1px #cccccc;width:200px;">
	 	<div style="Width:100%;height:50px;" id="content9">
	 		内容区域1
	 	</div>
	 	<div class="spliter spliterStyleH" beforeClickClass="spliterTop" afterClickClass="spliterBottom"
	 	beforeClickTip="收缩" afterClickTip="展开"  targetId="content9" id="spliter-9"></div>
	 	<div style="Width:100%;height:50px;">
	 		内容区域2
	 	</div>
 	</div>	
 	<br/>
 	<input type="button" value="点击切换区域状态" onclick="btnClick1()"/><br/><br/>
	<input type="button" value="得到区域状态" onclick="btnClick2()"/><br/><br/>
	<input type="button" value="点击展开" onclick="btnClick3()"/><br/><br/>
	<input type="button" value="点击收缩" onclick="btnClick4()"/>
	  </fieldset>
 	  <div class="height_15"></div>
	 
	  <fieldset> 
	  <legend>10、动态创建</legend>
	 	<input type="button" value="点击创建" id="testBtn" onclick="createSpliter()"/>
	  </fieldset>
 	  <div class="height_15"></div>
	 
	  <fieldset> 
     <legend>11、事件</legend>
     <div style="border:solid 1px #cccccc;width:200px;">
	 	<div style="Width:100%;height:50px;" id="content11">
	 		内容区域1
	 	</div>
	 	<div id="spliter-11" class="spliter spliterStyleH" beforeClickClass="spliterBottom" afterClickClass="spliterTop"
	 	beforeClickTip="展开" afterClickTip="收缩"  targetId="content11" init="hide"></div>
 		<div style="Width:100%;height:50px;">
	 		内容区域2
	 	</div>
 	</div>
	  </fieldset>
 	  <div class="height_15"></div>
	 
 	 </div>
	 	
<script type="text/javascript">
	function initComplete(){
		$("#spliter-11").bind("stateChange",function(e,state){
	        alert(state);
	    });
	}
	//切换状态
	function btnClick1(){
		$("#spliter-9").spliterChangeState();
	}
	//获取状态
	function btnClick2(){
		alert($("#spliter-9").spliterGetState());
	}
	//展开
	function btnClick3(){
		$("#spliter-9").spliterOpen();
	}
	//收缩
	function btnClick4(){
		$("#spliter-9").spliterClose();
	}
	function createSpliter(){
		var $spliter=$('<div style="border:solid 1px #cccccc;width:200px;">'+
		 	'<div style="Width:100%;height:50px;" id="content10">'+
		 		'内容区域1'+
		 	'</div>'+
		 	'<div class="spliter spliterStyleH" beforeClickClass="spliterTop" afterClickClass="spliterBottom" beforeClickTip="收缩" afterClickTip="展开"  targetId="content10"></div>'+
		 	'<div style="Width:100%;height:50px;">'+
		 		'内容区域2'+
		 	'</div>'+
	 	'</div>');
	 	$("#testBtn").after($spliter);
	 	$spliter.find(".spliter").render();
	}
</script>
</body>
</html>