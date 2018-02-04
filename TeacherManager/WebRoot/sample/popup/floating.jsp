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
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/" scrollerY="false" scrollerX="false"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!--浮动面板start-->
<script type="text/javascript" src="<%=path%>/libs/js/popup/floatPanel.js"></script>
<!--浮动面板end-->

</head>
<body>
		
	
	<div style="padding:80px 0 0 300px;">
		<input type="button" value="更改左侧面板宽度" onclick="changeWidth()"/><br/><br/>
		<input type="button" value="更改左下角面板文字" onclick="changeText()"/><br/><br/>
		<input type="button" value="更改左下角面板高度" onclick="changeHeight()"/><br/><br/>
		<input type="button" value="获取左下角面板状态" onclick="getPanelState()"/><br/><br/>
		<input type="button" value="更改左下角面板状态" onclick="changePanelState()"/><br/><br/>
		<input type="button" value="点击展开左下角面板" onclick="openPanel()"/><br/><br/>
		<input type="button" value="点击关闭左下角面板" onclick="closePanel()"/><br/><br/>
	</div>
<div class="floatPanel">
	  这是第一个面板，<br/>所有参数均采用默认，<br/>效果是宽为400靠上水平居中的窗口，<br/>并且当页面初始时会以动画的方式收回用来提醒用户这里有个浮动面板。
	</div>
	<div class="floatPanel" panelWidth="300" beforeClickText="展开查询面板" afterClickText="收回查询面板" animatefirst="false" direction="tl">
		这是第二个面板，<br/>定义了宽度为300，<br/>水平靠左，<br/>自定义了按钮的文字，<br/>并且当页面初始时不会以动画的方式收回
	</div>
	<div class="floatPanel"panelWidth="300" animatefirst="false" direction="tr" depth="710">
		这是第三个面板，<br/>顶部靠右。<br/>depth设为710大于第四个面板的默认depth<br/>所以第三个面板在第四个之上。
	</div>
	<div class="floatPanel" id="floatPanel-4"  panelWidth="300" panelHeight="240" animatefirst="false" direction="mr" showCloseBtn="true">
		这是第四个面板，<br/>中间靠右。<br/>正常情况第四个面板在第三个面板之后生成的，<br/>则第四个会盖住第三个。<br/>但是由于第三个面板的depth大于第四个，<br/>所以第三个面板在第四个之上。<br/>对于左右展开的面板，最好设置panelHeight，否则文字内容太少，否则按钮高度大于面板高度会不美观。
	</div>
	<div class="floatPanel" panelWidth="260" panelHeight="240"  animatefirst="false" direction="ml" duration="200"  init="show" id="floatPanel-5" beforeClickText="关闭面板" afterClickText="打开面板">
		这是第五个面板，中间靠左。<br/>自定义了面板伸缩的时间为200毫秒<br/>对于左右展开的面板，最好设置panelHeight，否则文字内容太少，否则按钮高度大于面板高度会不美观。
	</div>
	<div class="floatPanel" id="floatPanel-7" animatefirst="false" direction="bc" panelWidth="240" panelHeight="100" beforeClickText="绑定事件" afterClickText="绑定事件">
		这是第七个面板，<br/>下方居中。
	</div>
	<div class="floatPanel" panelWidth="300" beforeClickText="关闭面板" afterClickText="打开面板" animatefirst="false" direction="bl" init="show" id="floatPanel-6" panelHeight="150">
		这是第六个面板，居下靠左。<br/>设置了初始化面板为打开状态<br/>对于这种情况需要自定义beforeClickText和afterClickText<br/>因为默认的文字是相反的。<br/>如果animatefirst为true时初始时会以动画形式展开。
	</div>
	
	<div class="floatPanel" panelWidth="300" panelHeight="150"  direction="br" init="show" beforeClickText="iframe模式" afterClickText="iframe模式" iframe="<%=path%>/sample/popup/floating-content1.jsp"></div>
		
	
<script>
	function initComplete(){
		$("#floatPanel-7").bind("stateChange",function(e,state){
	        alert(state);
	    });
	    $("#floatPanel-4").bind("close",function(e,obj){
	        top.Dialog.confirm("确实要不显示面板吗？",function(){
	        	$(obj).remove();
	        	alert("面板已移除。这时可以自行使用cookie等方式记住关闭状态，不至于刷新后又还原了。")
	        })
	    });
	}
	function changeWidth(){
		$("#floatPanel-5").attr("panelwidth",180);
		$("#floatPanel-5").render();
	}
	
	function changeHeight(){
		$("#floatPanel-6").attr("panelHeight",200);
		$("#floatPanel-6").render();
	}
	
	function changeText(){
		$("#floatPanel-6").attr("beforeClickText","查询结果");
		$("#floatPanel-6").attr("afterClickText","查询结果");
		$("#floatPanel-6").render();
	}
	function getPanelState(){
		alert($("#floatPanel-6").floatPanelGetState());
	}
	function changePanelState(){
		$("#floatPanel-6").floatPanelChangeState();
	}
	function openPanel(){
		$("#floatPanel-6").floatPanelOpen();
	}
	function closePanel(){
		$("#floatPanel-6").floatPanelClose();
	}
</script>
</body>
</html>