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
<div style="width:800px;">
<fieldset style="border-color:#999999;">
    <legend>1、基本示例：</legend>
	<div class="box2" panelWidth="300" panelTitle="控制面板">
		内容区域<br />内容区域<br />内容区域<br />
		内容区域<br />内容区域<br />内容区域<br />
	</div>
</fieldset>
<div class="height_15"></div>

<fieldset style="border-color:#999999;">
    <legend>2、自定义图标：</legend>
	<div class="box2" panelWidth="300" panelTitle="与图标库关联" iconClass="icon_list">
		内容区域<br />内容区域<br />内容区域<br />
		内容区域<br />内容区域<br />内容区域<br />
	</div>
	<div class="box2" panelWidth="300" panelTitle="读取外部图标文件" iconSrc="<%=path%>/libs/images/icons/setting.png">
		内容区域<br />内容区域<br />内容区域<br />
		内容区域<br />内容区域<br />内容区域<br />
	</div>
	<div class="box2" panelWidth="300" panelTitle="无图标">
		内容区域<br />内容区域<br />内容区域<br />
		内容区域<br />内容区域<br />内容区域<br />
	</div>
</fieldset>
<div class="height_15"></div>

<fieldset style="border-color:#999999;">
    <legend>3、副标题：</legend>
	<div class="box2" panelWidth="300" panelTitle="任务列表" panelSubTitle="【您有15条任务未完成】" panelSubTitleColor="#ff0000">
		内容区域<br />内容区域<br />内容区域<br />
		内容区域<br />内容区域<br />内容区域<br />
	</div>
</fieldset>
<div class="height_15"></div>

<fieldset style="border-color:#999999;">
    <legend>4、自定义状态文字：</legend>
	<div class="box2" panelWidth="400" panelTitle="控制面板" statusText="关闭设置"  afterStatusText="打开设置">
		内容区域<br />内容区域<br />内容区域<br />
		内容区域<br />内容区域<br />内容区域<br />
	</div>	
	<div class="box2" panelWidth="400" panelTitle="不显示状态文字" showStatus="false">
		内容区域<br />内容区域<br />内容区域<br />
		内容区域<br />内容区域<br />内容区域<br />
	</div>	
</fieldset>
<div class="height_15"></div>
 
<fieldset style="border-color:#999999;">
    <legend>5、初始时容器收缩：</legend>
	<div class="box2" panelWidth="400" panelTitle="控制面板" statusText="打开设置" startState="close" afterStatusText="关闭设置">
		内容区域<br />内容区域<br />内容区域<br />
		内容区域<br />内容区域<br />内容区域<br />
	</div>	
</fieldset>
<div class="height_15"></div>

<fieldset style="border-color:#999999;">
    <legend>6、自定义右上角点击事件：</legend>
    <div class="box2" panelWidth="400" panelTitle="链接示例" statusType="link" statusText="更多>>" panelUrl="http://www.baidu.com" panelTarget="_blank">
		内容区域<br />内容区域<br />内容区域<br />
		内容区域<br />内容区域<br />内容区域<br />
	</div>
	<div class="box2" panelWidth="400" panelTitle="调用javascript方法" statusType="link" statusText="更多>>" panelUrl="javascript:openWin()">
		内容区域<br />内容区域<br />内容区域<br />
		内容区域<br />内容区域<br />内容区域<br />
	</div>
	<div class="box2" panelWidth="400" panelTitle="无任何事件" statusType="none" statusText="任务完成数：20">
		内容区域<br />内容区域<br />内容区域<br />
		内容区域<br />内容区域<br />内容区域<br />
	</div>
</fieldset>
<div class="height_15"></div>

<fieldset style="border-color:#999999;">
    <legend>7、动态创建：</legend>
	<input type="button"  value="点击创建" onclick="createBox()" id="testBtn"/>
</fieldset>
<div class="height_15"></div>		

<fieldset style="border-color:#999999;">
    <legend>8、动态修改属性：</legend>
	<div class="box2" panelWidth="300" panelHeight="200"  panelTitle="控制面板" id="box6">这里修改了标题，宽度和高度属性</div>
	<input type="button" value="点击修改" onclick="changeBox()"/>
</fieldset>
<div class="height_15"></div>	

<fieldset style="border-color:#999999;">
    <legend>9、面板状态改变事件：</legend>
	<div class="box2" panelWidth="300" panelTitle="控制面板" id="box-6">
		内容区域<br />内容区域<br />内容区域<br />
		内容区域<br />内容区域<br />内容区域<br />
	</div>
</fieldset>
<div class="height_15"></div>

<fieldset style="border-color:#999999;">
    <legend>10、外部操作：</legend>
	<input type="button" value="获取面板状态" onclick="getBoxState()"/><br/><br/>
	<input type="button" value="更改面板状态" onclick="changeBoxState()"/><br/><br/>
	<input type="button" value="点击展开面板" onclick="openBox()"/><br/><br/>
	<input type="button" value="点击关面板" onclick="closeBox()"/><br/><br/>
	<div class="box2" panelWidth="300" panelTitle="控制面板" id="box-7">
		内容区域<br />内容区域<br />内容区域<br />
		内容区域<br />内容区域<br />内容区域<br />
	</div>
</fieldset>
<div class="height_15"></div>	

<fieldset style="border-color:#999999;">
    <legend>11、自定义风格：</legend>
	<div class="box2_custom" boxType="box2" panelWidth="300" panelTitle="信息列表" iconClass="icon_list">
		内容区域<br />内容区域<br />内容区域<br />
		内容区域<br />内容区域<br />内容区域<br />
	</div>
	<div class="box2_custom" boxType="box2" panelWidth="300" panelTitle="&nbsp;通知公告" iconSrc="<%=path%>/libs/images/icons/alert.png" statusType="link"  statusText="更多>>" panelUrl="javascript:openWin()">
		内容区域<br />内容区域<br />内容区域<br />
		内容区域<br />内容区域<br />内容区域<br />
	</div>
	<div class="box2_custom" boxType="box2" panelWidth="300" panelTitle="无图标"  showStatus="false">
		内容区域<br />内容区域<br />内容区域<br />
		内容区域<br />内容区域<br />内容区域<br />
	</div>
</fieldset>
<div class="height_50"></div>
</div>	

	<script>
		$(function(){
			$("#box-6").bind("stateChange",function(e,state){
				alert(state);
			});
		})
		
		function openWin(){
			alert("这是自定义事件，可以弹个窗口什么的")
		}
		function createBox(){
			var $box=$('<div class="box2" panelWidth="300" panelHeight="150"  panelTitle="控制面板">内容部分</div>');
			$("#testBtn").after($box);
			$box.render();
		}
		function changeBox(){
			$("#box6").attr("panelTitle","新标题");
			$("#box6").attr("panelWidth",400);
			$("#box6").attr("panelHeight",300);
			$("#box6").render();
		}
		function getBoxState(){
			alert($("#box-7").box2GetState());
		}
		function changeBoxState(){
			$("#box-7").box2ChangeState();
		}
		function openBox(){
			$("#box-7").box2Open();
		}
		function closeBox(){
			$("#box-7").box2Close();
		}
	</script>
</body>
</html>