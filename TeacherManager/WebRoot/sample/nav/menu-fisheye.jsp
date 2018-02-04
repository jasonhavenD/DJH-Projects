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
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/" scrollerY="false"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!--鱼眼菜单start-->
<script type="text/javascript" src="<%=path%>/libs/js/nav/fishEye.js"></script>
<!--鱼眼菜单end-->
</head>
<body >
应用场景见框架的desktop风格。
	<div class="dock" id="mydock">
		<div class="dock_left"></div>
		<div class="dock_center">
			<div id="dock">
				<div class="dock-container">
					<a class="dock-item" href="javascript:;" title="账户管理" keepDefaultStyle="true"><span>账户管理</span><img src="<%=path%>/libs/images/stacks/01.png"></a>
					<a class="dock-item" href="javascript:;" title="电子邮件" keepDefaultStyle="true"><span>电子邮件</span><img src="<%=path%>/libs/images/stacks/02.png"/></a>
					<a class="dock-item" href="javascript:;" title="综合查询" keepDefaultStyle="true"><span>综合查询</span><img src="<%=path%>/libs/images/stacks/03.png"/></a>
					<a class="dock-item" href="javascript:;" title="系统设置" keepDefaultStyle="true"><span>系统设置</span><img src="<%=path%>/libs/images/stacks/04.png"/></a>
				</div>
			</div>
			
		</div>
		<div class="dock_right"></div>
		<div class="clear"></div>
	</div>
<script>
	$(function(){
		//初始化鱼眼菜单
		$('#dock').Fisheye(
			{
				maxWidth: 64,
				items: 'a',
				itemsText: 'span',
				container: '.dock-container',
				itemWidth: 80,
				proximity: 80,
				valign: 'bottom',
				halign : 'center'
			}
		);
		
		
	})
	//当浏览器尺寸变化时重设菜单位置，让菜单始终水平居中
	function customHeightSet(contentHeight){
		$("#mydock").css({
			"left":($("body").width()-700)/2
		})
	}
</script>
</body>
</html>