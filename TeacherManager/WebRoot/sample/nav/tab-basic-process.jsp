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

<!--流程选项卡start-->
<script type="text/javascript" src="<%=path%>/libs/js/nav/basicTabProcess.js"></script>
<!--流程选项卡end-->
</head>
<body style="background-color:#ffffff;">
 	<div class="box1" whiteBg="true">
 	 
 	
 	
 	 <fieldset> 
     <legend>1、非iframe模式-基本使用</legend>
    <div class="basicTabProcess">
		<div name="流程选项1" style="height:200px;" iconClass="process_item1">
			内容1<br />内容1
		</div>
		<div name="流程选项2" style="height:200px;" iconClass="process_item2">
			内容2<br />内容2
		</div>
		<div name="流程选项3" style="height:200px;" iconClass="process_item3">
			内容3<br />内容3
		</div>
		<div name="流程选项4" style="height:200px;" iconClass="process_item4">
			内容4<br />内容4
		</div>
		<div name="流程选项5" style="height:200px;" iconClass="process_item5">
			内容5<br />内容5
		</div>
	</div>
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset> 
     <legend>2、非iframe模式-设定初始选中索引</legend>
     <div class="basicTabProcess" selectedIdx="1">
		<div name="流程选项1" style="height:200px;" iconClass="process_item1">
			内容1<br />内容1
		</div>
		<div name="流程选项2" style="height:200px;" iconClass="process_item2">
			内容2<br />内容2
		</div>
		<div name="流程选项3" style="height:200px;" iconClass="process_item3">
			内容3<br />内容3
		</div>
		<div name="流程选项4" style="height:200px;" iconClass="process_item4">
			内容4<br />内容4
		</div>
	</div>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  
	   <fieldset> 
     <legend>3、非iframe模式-禁止点击并由外部控制索引</legend>
    禁用全部选项卡：
    <div class="basicTabProcess" allItemDisabled="true" id="basicTab-3-1">
		<div name="流程选项1" style="height:200px;" iconClass="process_item1">
			内容1<br />内容1
		</div>
		<div name="流程选项2" style="height:200px;" iconClass="process_item2">
			内容2<br />内容2
		</div>
		<div name="流程选项3" style="height:200px;" iconClass="process_item3">
			内容3<br />内容3
		</div>
		<div name="流程选项4" style="height:200px;" iconClass="process_item4">
			内容4<br />内容4
		</div>
	</div>
	<input type="button" value="改变索引" onclick="changeIdxHandler()"/>
	<br/><br/>
	禁用部分选项卡：
    <div class="basicTabProcess" id="basicTab-3-2">
		<div name="流程选项1" style="height:200px;" iconClass="process_item1">
			内容1<br />内容1
		</div>
		<div name="流程选项2" style="height:200px;" iconClass="process_item2">
			内容2<br />内容2
		</div>
		<div name="流程选项3" style="height:200px;" iconClass="process_item3" itemDisabled="true">
			内容3<br />内容3
		</div>
		<div name="流程选项4" style="height:200px;" iconClass="process_item4" itemDisabled="true">
			内容4<br />内容4
		</div>
	</div>
	<input type="button" value="启用“步骤3”" onclick="enableTabHandler()"/>
	<input type="button" value="禁用“步骤3”" onclick="disableTabHandler()"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
     <legend>4、iframe模式-基本使用</legend>
<div class="basicTabProcess" iframeMode="true" data='{"list":[{"name":"流程选项1","url":"<%=path%>/sample/nav/tab-basic-content1.jsp","iconClass":"process_item1"},{"name":"流程选项2","url":"<%=path%>/sample/nav/tab-basic-content2.jsp","iconClass":"process_item2"}]}'>
	<div style="height:240px;">
		<IFRAME width="100%" height="100%" frameBorder=0 allowTransparency="true" name="iframeChild1" id="iframeChild1"></IFRAME>
	</div>
</div> 
	  </fieldset>
	  <div class="height_15"></div>
	  


	 <fieldset> 
     <legend>5、iframe模式-设定初始选中索引</legend>
		<div class="basicTabProcess" iframeMode="true" selectedIdx="1" data='{"list":[{"name":"选项1","url":"<%=path%>/sample/nav/tab-basic-content1.jsp","iconClass":"process_item1"},{"name":"选项2","url":"<%=path%>/sample/nav/tab-basic-content2.jsp","iconClass":"process_item2"}]}'>
			<div style=";height:240px;">
				<IFRAME width="100%" height="100%" frameBorder=0 allowTransparency="true" name="iframeChild2" id="iframeChild2"></IFRAME>
			</div>
		</div> 
	  </fieldset>
	  <div class="height_15"></div>
	  
	  
	    <fieldset> 
     <legend>6、iframe模式-禁止点击并由外部控制索引</legend>
   禁用全部选项卡：
		<div class="basicTabProcess" iframeMode="true" id="basicTab-6-1" allItemDisabled="true" data='{"list":[{"name":"步骤1","url":"<%=path%>/sample/nav/tab-basic-content1.jsp","iconClass":"process_item1"},{"name":"步骤2","url":"<%=path%>/sample/nav/tab-basic-content2.jsp","iconClass":"process_item2"},{"name":"步骤3","url":"<%=path%>/sample/nav/tab-basic-content3.jsp","iconClass":"process_item3"}]}'>
			<div style=";height:240px;">
				<IFRAME width="100%" height="100%" frameBorder=0 allowTransparency="true" name="iframeChild3" id="iframeChild3"></IFRAME>
			</div>
		</div> 
		<input type="button" value="改变索引" onclick="changeIdxHandler2()"/>
	<br/><br/>
	  禁用部分选项卡：
		<div class="basicTabProcess" iframeMode="true"  id="basicTab-6-2" data='{"list":[{"name":"步骤1","url":"<%=path%>/sample/nav/tab-basic-content1.jsp","iconClass":"process_item1"},{"name":"步骤2","url":"<%=path%>/sample/nav/tab-basic-content2.jsp","iconClass":"process_item2"},{"name":"步骤3","url":"<%=path%>/sample/nav/tab-basic-content3.jsp","itemDisabled":"true","iconClass":"process_item3"}]}'>
			<div style=";height:240px;">
				<IFRAME width="100%" height="100%" frameBorder=0 allowTransparency="true" name="iframeChild4" id="iframeChild4"></IFRAME>
			</div>
		</div> 
		<input type="button" value="启用“步骤3”" onclick="enableTabHandler2()"/>
		<input type="button" value="禁用“步骤3”" onclick="disableTabHandler2()"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset> 
     <legend>7、iframe模式-切换标签式出现进度条</legend>
		<div class="basicTabProcess" iframeMode="true" showProgress="true" data='{"list":[{"name":"选项1","url":"<%=path%>/sample/nav/tab-basic-content1.jsp","iconClass":"process_item1"},{"name":"选项2","url":"<%=path%>/sample/nav/tab-basic-content2.jsp","iconClass":"process_item2"}]}'>
			<div style=";height:240px;">
				<IFRAME width="100%" height="100%" frameBorder=0 allowTransparency="true" name="iframeChild5" id="iframeChild5"></IFRAME>
			</div>
		</div> 
	  </fieldset>
	  <div class="height_15"></div>
	  
	  
	  
	   <fieldset> 
     <legend>8、选项卡点击事件</legend>
   	<div class="basicTabProcess" id="tab-9">
		<div name="选项1" style="height:200px;" iconClass="process_item1">
			内容1<br />内容1
		</div>
		<div name="选项2" style="height:200px;" iconClass="process_item2">
			内容2<br />内容2
		</div>
	</div>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  
	   <fieldset> 
     <legend>9、获取当前选中索引</legend>
   	<div class="basicTabProcess" id="tab-10">
		<div name="选项1" style="height:200px;" iconClass="process_item1">
			内容1<br />内容1
		</div>
		<div name="选项2" style="height:200px;" iconClass="process_item2">
			内容2<br />内容2
		</div>
	</div>
	<input type="button" value="获取当前索引" onclick="getTabValue()"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  
	  
 	 <fieldset> 
     <legend>10、鼠标移入切换标签</legend>
    <div class="basicTabProcess" hoverMode="true">
		<div name="选项1" style="height:200px;" iconClass="process_item1">
			内容1<br />内容1
		</div>
		<div name="选项2" style="height:200px;" iconClass="process_item2">
			内容2<br />内容2
		</div>
		<div name="选项3" style="height:200px;" iconClass="process_item3">
			内容3<br />内容3
		</div>
		<div name="选项4" style="height:200px;" iconClass="process_item4">
			内容4<br />内容4
		</div>
	</div>
	  </fieldset>
	  <div class="height_15"></div>
	 
	<fieldset> 
     <legend>11、单内容区域模式</legend>
    <div class="basicTabProcess" id="tab-12" singleContentMode="true" data='{"list":[{"name":"选项1","iconClass":"process_item1"},{"name":"选项2","iconClass":"process_item2"},{"name":"选项3","iconClass":"process_item3"}]}'>
		<div style="height:200px;" id="tab-12-content">
			内容1<br />内容1
		</div>
	</div>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  
	<fieldset> 
     <legend>12、含有标题</legend>
    <div class="basicTabProcess" tabTitle="信息录入">
		<div name="基础信息" style="height:200px;" iconClass="process_item1">
			内容1<br />内容1
		</div>
		<div name="体貌特征" style="height:200px;" iconClass="process_item2">
			内容2<br />内容2
		</div>
		<div name="交通工具" style="height:200px;" iconClass="process_item3">
			内容3<br />内容3
		</div>
	</div>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
     <legend>13、标题含有图标</legend>
    使用iconClass:
    <div class="basicTabProcess" tabTitle="信息录入" iconClass="icon_edit">
		<div name="基础信息" style="height:200px;" iconClass="process_item1">
			内容1<br />内容1
		</div>
		<div name="体貌特征" style="height:200px;" iconClass="process_item2">
			内容2<br />内容2
		</div>
		<div name="交通工具" style="height:200px;" iconClass="process_item3">
			内容3<br />内容3
		</div>
	</div>
	 使用iconSrc:
    <div class="basicTabProcess" tabTitle="信息录入" iconSrc="<%=path%>/libs/images/icons/setting.png">
		<div name="基础信息" style="height:200px;" iconClass="process_item1">
			内容1<br />内容1
		</div>
		<div name="体貌特征" style="height:200px;" iconClass="process_item2">
			内容2<br />内容2
		</div>
		<div name="交通工具" style="height:200px;" iconClass="process_item3">
			内容3<br />内容3
		</div>
	</div>
	  </fieldset>
	    <div class="height_15"></div>
	   
	
 	</div>
 	 <div class="height_15"></div>
<div style="background-color:white;width:780px;padding:10px;">
 <div class="font_bold">14、与box1合用</div>
    
    <div class="basicTabProcess" tabTitle="信息录入">
		<div name="基础信息" class="box1" panelHeight="200" whiteBg="true" iconClass="process_item1">
				内容1<br />内容1
		</div>
		<div name="体貌特征" class="box1" panelHeight="200" whiteBg="true" iconClass="process_item2">
				内容2<br />内容2
		</div>
		<div name="交通工具" class="box1" panelHeight="200" whiteBg="true" iconClass="process_item3">
				内容3<br />内容3
		</div>
	</div>
</div>	 
 <fieldset> 
     <legend>15、tab过多左右滚动</legend>
     非iframe模式
    <div class="basicTabProcess" tabScroll="true">
		<div name="标题文字1" style="height:200px;" iconClass="process_item1">
			内容1<br />内容1
		</div>
		<div name="标题文字2" style="height:200px;" iconClass="process_item2">
			内容2<br />内容2
		</div>
		<div name="标题文字3" style="height:200px;" iconClass="process_item3">
			内容3<br />内容3
		</div>
		<div name="标题文字4" style="height:200px;" iconClass="process_item4">
			内容4<br />内容4
		</div>
		<div name="标题文字5" style="height:200px;" iconClass="process_item5">
			内容5<br />内容5
		</div>
		<div name="标题文字6" style="height:200px;" iconClass="process_item6">
			内容6<br />内容6
		</div>
		<div name="标题文字7" style="height:200px;" iconClass="process_item7">
			内容7<br />内容7
		</div>
		<div name="标题文字8" style="height:200px;" iconClass="process_item8">
			内容8<br />内容8
		</div>
		<div name="标题文字9" style="height:200px;" iconClass="process_item9">
			内容9<br />内容9
		</div>
	</div>
	<br/><br/>
	iframe模式
    <div class="basicTabProcess" iframeMode="true" tabScroll="true" data='{"list":[{"name":"标题文字1","url":"<%=path%>/sample/nav/tab-basic-content1.jsp","iconClass":"process_item1"},{"name":"标题文字2","url":"<%=path%>/sample/nav/tab-basic-content2.jsp","iconClass":"process_item2"},{"name":"标题文字3","url":"<%=path%>/sample/nav/tab-basic-content1.jsp","iconClass":"process_item3"},{"name":"标题文字4","url":"<%=path%>/sample/nav/tab-basic-content2.jsp","iconClass":"process_item4"},{"name":"标题文字5","url":"<%=path%>/sample/nav/tab-basic-content1.jsp","iconClass":"process_item5"},{"name":"标题文字6","url":"<%=path%>/sample/nav/tab-basic-content1.jsp","iconClass":"process_item6"},{"name":"标题文字7","url":"<%=path%>/sample/nav/tab-basic-content1.jsp","iconClass":"process_item7"},{"name":"标题文字8","url":"<%=path%>/sample/nav/tab-basic-content2.jsp","iconClass":"process_item8"},{"name":"标题文字9","url":"<%=path%>/sample/nav/tab-basic-content1.jsp","iconClass":"process_item9"}]}'>
		<div style=";height:240px;">
			<IFRAME width="100%" height="100%" frameBorder=0 allowTransparency="true" name="iframeChild6" id="iframeChild6"></IFRAME>
		</div>
	</div>
	  </fieldset>
	  <div class="height_15"></div> 
</body>
<script>
	function initComplete(){
		$("#tab-9").bind("actived",function(e,i){
			alert(i);
		})
		
		$("#tab-12").bind("actived",function(e,i){
			if(i==0){
				$("#tab-12-content").html('内容1<br />内容1');
			}
			else if(i==1){
				$("#tab-12-content").html('内容2<br />内容2');
			}
			else if(i==2){
				$("#tab-12-content").html('内容3<br />内容3');
			}
		})
	}
	
	//外部控制索引
	var idx=0;
	function changeIdxHandler(){
		idx++
		if(idx>3){
			idx=0;
		}
		$("#basicTab-3-1").basicTabProcessSetIdx(idx);
	}
	
	//启用
	function enableTabHandler(){
		$("#basicTab-3-2").basicTabProcessSetEnable(2,true);
	}
	//禁用
	function disableTabHandler(){
		$("#basicTab-3-2").basicTabProcessSetEnable(2,false);
	}
	
	var idx2=0;
	function changeIdxHandler2(){
		idx2++
		if(idx2>2){
			idx2=0;
		}
		$("#basicTab-6-1").basicTabProcessSetIdx(idx2);
	}
	//动态禁用或启用
	function enableTabHandler2(){
		$("#basicTab-6-2").basicTabProcessSetEnable(2,true);
	}
	function disableTabHandler2(){
		$("#basicTab-6-2").basicTabProcessSetEnable(2,false);
	}
	//获得选中索引
	function getTabValue(){
		alert($("#tab-10").attr("selectedIdx"));
	}
	</script>
</html>