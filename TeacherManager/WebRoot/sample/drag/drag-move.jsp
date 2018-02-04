<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!--拖拽组件start-->
<script type="text/javascript" src="<%=path%>/libs/js/drag/dragDrop.js"></script>
<!--拖拽组件end-->

 

<script type="text/javascript">
	var maxIndex=1;
	function initComplete(){
		 $('#myBox1').dragDrop({ proxy: false });
		 
		 var header=$('#myBox2').find(".box_topcenter");
		 $('#myBox2').dragDrop({ proxy: false ,handler:header });
		 
		 $('#myBox3').dragDrop();
		 $('#myBox4').dragDrop({ proxy: 'clone' });
		 
		 $(".box2_custom").bind("mousedown",function(){
		 	$(this).css("zIndex",maxIndex);
		 	maxIndex++;
		 })
		
	}
</script>
<body>
	<div class="box2_custom" boxType="box2" panelWidth="300" panelHeight="200" panelTitle="按住整体拖拽"  id="myBox1" style="top: 0px;position: absolute;-moz-user-select:none;"></div>
	<div class="box2_custom" boxType="box2" panelWidth="300" panelHeight="200" panelTitle="按住头部拖拽"  id="myBox2" style="left:350px;top: 0px;position: absolute;-moz-user-select:none;"></div>
  	<div class="box2_custom" boxType="box2" panelWidth="300" panelHeight="200" panelTitle="使用拖拽代理"  id="myBox3" style="top: 250px;position: absolute;-moz-user-select:none;"></div>
	<div class="box2_custom" boxType="box2" panelWidth="300" panelHeight="200" panelTitle="使用克隆代理"  id="myBox4" style="left:350px;top: 250px;position: absolute;-moz-user-select:none;"></div>
</body>
</html>