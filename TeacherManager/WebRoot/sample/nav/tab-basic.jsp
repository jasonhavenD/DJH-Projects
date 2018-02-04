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

<!--基本选项卡start-->
<script type="text/javascript" src="<%=path%>/libs/js/nav/basicTab.js"></script>
<!--基本选项卡end-->
</head>
<body>
 	<div class="box1" panelWidth="850">
 	 
 	
 	
 	 <fieldset> 
     <legend>1、非iframe模式-基本使用</legend>
    <div class="basicTab">
		<div name="选项1" style="width:760px;height:240px;">
			内容1<br />内容1
		</div>
		<div name="选项2" style="width:760px;height:240px;">
			内容2<br />内容2
		</div>
		<div name="选项3" style="width:760px;height:240px;">
			内容3<br />内容3
		</div>
		<div name="选项4" style="width:760px;height:240px;">
			内容4<br />内容4
		</div>
	</div>
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset> 
     <legend>2、非iframe模式-设定初始选中索引</legend>
    <div class="basicTab" selectedIdx="1">
		<div name="选项1" style="width:760px;height:240px;">
			内容1<br />内容1
		</div>
		<div name="选项2" style="width:760px;height:240px;">
			内容2<br />内容2
		</div>
		<div name="选项3" style="width:760px;height:240px;">
			内容3<br />内容3
		</div>
		<div name="选项4" style="width:760px;height:240px;">
			内容4<br />内容4
		</div>
	</div>
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset> 
     <legend>3、非iframe模式-禁止点击并由外部控制索引</legend>
    禁用全部选项卡：
    <div class="basicTab" allItemDisabled="true" id="basicTab-3-1">
		<div name="步骤1" style="width:760px;height:240px;">
			内容1<br />内容1
		</div>
		<div name="步骤2" style="width:760px;height:240px;">
			内容2<br />内容2
		</div>
		<div name="步骤3" style="width:760px;height:240px;">
			内容3<br />内容3
		</div>
		<div name="步骤4" style="width:760px;height:240px;">
			内容4<br />内容4
		</div>
	</div>
	<input type="button" value="改变索引" onclick="changeIdxHandler()"/>
	<br/><br/>
	禁用部分选项卡：
    <div class="basicTab" id="basicTab-3-2">
		<div name="步骤1" style="width:760px;height:240px;">
			内容1<br />内容1
		</div>
		<div name="步骤2" style="width:760px;height:240px;">
			内容2<br />内容2
		</div>
		<div name="步骤3" style="width:760px;height:240px;" itemDisabled="true">
			内容3<br />内容3
		</div>
		<div name="步骤4" style="width:760px;height:240px;" itemDisabled="true">
			内容4<br />内容4
		</div>
	</div>
	<input type="button" value="启用“步骤3”" onclick="enableTabHandler()"/>
	<input type="button" value="禁用“步骤3”" onclick="disableTabHandler()"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
     <legend>4、iframe模式-基本使用</legend>
<div class="basicTab" iframeMode="true" data='{"list":[{"name":"选项1","url":"<%=path%>/sample/nav/tab-basic-content1.jsp"},{"name":"选项2","url":"<%=path%>/sample/nav/tab-basic-content2.jsp"}]}'>
	<div style="width:760px;height:240px;">
		<IFRAME width="100%" height="100%" frameBorder=0 allowTransparency="true" name="iframeChild1" id="iframeChild1"></IFRAME>
	</div>
</div> 
	  </fieldset>
	  <div class="height_15"></div>
	   
	  <fieldset> 
     <legend>5、iframe模式-设定初始选中索引</legend>
		<div class="basicTab" iframeMode="true" selectedIdx="1" data='{"list":[{"name":"选项1","url":"<%=path%>/sample/nav/tab-basic-content1.jsp"},{"name":"选项2","url":"<%=path%>/sample/nav/tab-basic-content2.jsp"}]}'>
			<div style="width:760px;;height:240px;">
				<IFRAME width="100%" height="100%" frameBorder=0 allowTransparency="true" name="iframeChild12 id="iframeChild2"></IFRAME>
			</div>
		</div> 
	  </fieldset>
	  <div class="height_15"></div>
	  
	  
	    <fieldset> 
     <legend>6、iframe模式-禁止点击并由外部控制索引</legend>
   禁用全部选项卡：
		<div class="basicTab" iframeMode="true" id="basicTab-6-1" allItemDisabled="true" data='{"list":[{"name":"步骤1","url":"<%=path%>/sample/nav/tab-basic-content1.jsp"},{"name":"步骤2","url":"<%=path%>/sample/nav/tab-basic-content2.jsp"},{"name":"步骤3","url":"<%=path%>/sample/nav/tab-basic-content3.jsp"}]}'>
			<div style="width:760px;;height:240px;">
				<IFRAME width="100%" height="100%" frameBorder=0 allowTransparency="true" name="iframeChild3" id="iframeChild3"></IFRAME>
			</div>
		</div> 
		<input type="button" value="改变索引" onclick="changeIdxHandler2()"/>
	<br/><br/>
	  禁用部分选项卡：
		<div class="basicTab" iframeMode="true"  id="basicTab-6-2" data='{"list":[{"name":"步骤1","url":"<%=path%>/sample/nav/tab-basic-content1.jsp"},{"name":"步骤2","url":"<%=path%>/sample/nav/tab-basic-content2.jsp"},{"name":"步骤3","url":"<%=path%>/sample/nav/tab-basic-content3.jsp","itemDisabled":"true"}]}'>
			<div style="width:760px;;height:240px;">
				<IFRAME width="100%" height="100%" frameBorder=0 allowTransparency="true" name="iframeChild4" id="iframeChild4"></IFRAME>
			</div>
		</div> 
		<input type="button" value="启用“步骤3”" onclick="enableTabHandler2()"/>
		<input type="button" value="禁用“步骤3”" onclick="disableTabHandler2()"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset> 
     <legend>7、iframe模式-切换标签式出现进度条</legend>
		<div class="basicTab" iframeMode="true" showProgress="true" data='{"list":[{"name":"选项1","url":"<%=path%>/sample/nav/tab-basic-content1.jsp"},{"name":"选项2","url":"<%=path%>/sample/nav/tab-basic-content2.jsp"}]}'>
			<div style="width:760px;;height:240px;">
				<IFRAME width="100%" height="100%" frameBorder=0 allowTransparency="true" name="iframeChild5" id="iframeChild5"></IFRAME>
			</div>
		</div> 
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset> 
     <legend>8、自定义内容区样式</legend>
		<div class="basicTab" iframeMode="true" data='{"list":[{"name":"选项1","url":"<%=path%>/sample/nav/tab-basic-content1.jsp"},{"name":"选项2","url":"<%=path%>/sample/nav/tab-basic-content2.jsp"}]}'>
			<div style="width:98%;border:none;border-top:solid 2px #5ba2fc;">
				<IFRAME width="100%" height="100%" frameBorder=0 allowTransparency="true" name="iframeChild6" id="iframeChild6"></IFRAME>
			</div>
		</div> 
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset> 
     <legend>9、选项卡点击事件</legend>
   	<div class="basicTab" id="tab-9">
		<div name="选项1" style="width:760px;height:240px;">
			内容1<br />内容1
		</div>
		<div name="选项2" style="width:760px;height:240px;">
			内容2<br />内容2
		</div>
	</div>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
     <legend>10、获取当前选中索引</legend>
   	<div class="basicTab" id="tab-10">
		<div name="选项1" style="width:760px;height:240px;">
			内容1<br />内容1
		</div>
		<div name="选项2" style="width:760px;height:240px;">
			内容2<br />内容2
		</div>
	</div>
	<input type="button" value="获取当前索引" onclick="getTabValue()"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  
	  
 	 <fieldset> 
     <legend>11、鼠标移入切换标签</legend>
    <div class="basicTab" hoverMode="true">
		<div name="选项1" style="width:760px;height:240px;">
			内容1<br />内容1
		</div>
		<div name="选项2" style="width:760px;height:240px;">
			内容2<br />内容2
		</div>
		<div name="选项3" style="width:760px;height:240px;">
			内容3<br />内容3
		</div>
		<div name="选项4" style="width:760px;height:240px;">
			内容4<br />内容4
		</div>
	</div>
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset> 
     <legend>12、单内容区域模式</legend>
    <div class="basicTab" id="tab-12" singleContentMode="true" data='{"list":[{"name":"选项1"},{"name":"选项2"},{"name":"选项3"}]}'>
		<div style="width:760px;height:240px;" id="tab-12-content">
			内容1<br />内容1
		</div>
	</div>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
     <legend>13、tab过多左右滚动</legend>
     非iframe模式
    <div class="basicTab" tabScroll="true">
		<div name="标题文字内容1" style="width:780px;height:240px;">
			内容1<br />内容1
		</div>
		<div name="标题文字内容2" style="width:780px;height:240px;">
			内容2<br />内容2
		</div>
		<div name="标题文字内容3" style="width:780px;height:240px;">
			内容3<br />内容3
		</div>
		<div name="标题文字内容4" style="width:780px;height:240px;">
			内容4<br />内容4
		</div>
		<div name="标题文字内容5" style="width:780px;height:240px;">
			内容5<br />内容5
		</div>
		<div name="标题文字内容6" style="width:780px;height:240px;">
			内容6<br />内容6
		</div>
		<div name="标题文字内容7" style="width:780px;height:240px;">
			内容7<br />内容7
		</div>
	</div>
	<br/><br/>
	iframe模式
    <div class="basicTab" iframeMode="true" tabScroll="true" data='{"list":[{"name":"标题文字内容1","url":"<%=path%>/sample/nav/tab-basic-content1.jsp"},{"name":"标题文字内容2","url":"<%=path%>/sample/nav/tab-basic-content2.jsp"},{"name":"标题文字内容3","url":"<%=path%>/sample/nav/tab-basic-content1.jsp"},{"name":"标题文字内容4","url":"<%=path%>/sample/nav/tab-basic-content2.jsp"},{"name":"标题文字内容5","url":"<%=path%>/sample/nav/tab-basic-content1.jsp"},{"name":"标题文字内容6","url":"<%=path%>/sample/nav/tab-basic-content2.jsp"},{"name":"标题文字内容7","url":"<%=path%>/sample/nav/tab-basic-content1.jsp"}]}'>
		<div style="width:780px;;height:240px;">
			<IFRAME width="100%" height="100%" frameBorder=0 allowTransparency="true" name="iframeChild7" id="iframeChild7"></IFRAME>
		</div>
	</div>
	  </fieldset>
	  
	  
	  
	  
	  <div style="height:200px;"></div>
 	</div>
 	
 	
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
		$("#basicTab-3-1").basicTabSetIdx(idx);
	}
	
	//启用
	function enableTabHandler(){
		$("#basicTab-3-2").basicTabSetEnable(2,true);
	}
	//禁用
	function disableTabHandler(){
		$("#basicTab-3-2").basicTabSetEnable(2,false);
	}
	
	var idx2=0;
	function changeIdxHandler2(){
		idx2++
		if(idx2>2){
			idx2=0;
		}
		$("#basicTab-6-1").basicTabSetIdx(idx2);
	}
	//动态禁用或启用
	function enableTabHandler2(){
		$("#basicTab-6-2").basicTabSetEnable(2,true);
	}
	function disableTabHandler2(){
		$("#basicTab-6-2").basicTabSetEnable(2,false);
	}
	
	//获得选中索引
	function getTabValue(){
		alert($("#tab-10").attr("selectedIdx"));
	}
	</script>
</html>