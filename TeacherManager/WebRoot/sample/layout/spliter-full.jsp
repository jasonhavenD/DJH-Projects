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

<!--布局控件start-->
<script type="text/javascript" src="<%=path%>/libs/js/nav/layout.js"></script>
<!--布局控件end-->
<script type="text/javascript">
	function initComplete(){
		var layout=$("#layout1").layout({ leftWidth: 200,rightWidth:150,bottomHeight:150,onEndResize:function(){
			  	triggerCustomHeightSet();
			  }}); 
		layout.setRightCollapse(true);
	}
	function customHeightSet(contentHeight){
		$(".layout_content").height(contentHeight-30-$("#bottomCon").height())
	}
</script>
</head>
<body>
	<div id="layout1">
        <div position="left" style="" panelTitle="组织机构">
        	<div class="layout_content">
        	这是左侧区域<br/>内容过多时出现纵向滚动条<br/>
        	这是左侧区域<br/>内容过多时出现纵向滚动条<br/>
        	这是左侧区域<br/>内容过多时出现纵向滚动条<br/>
        	这是左侧区域<br/>内容过多时出现纵向滚动条<br/>
        	这是左侧区域<br/>内容过多时出现纵向滚动条<br/>
        	这是左侧区域<br/>内容过多时出现纵向滚动条<br/>
        	这是左侧区域<br/>内容过多时出现纵向滚动条<br/>
        	这是左侧区域<br/>内容过多时出现纵向滚动条<br/>
        	这是左侧区域<br/>内容过多时出现纵向滚动条<br/>
        	这是左侧区域<br/>内容过多时出现纵向滚动条<br/>
        	这是左侧区域<br/>内容过多时出现纵向滚动条<br/>
        	这是左侧区域<br/>内容过多时出现纵向滚动条<br/>
        	这是左侧区域<br/>内容过多时出现纵向滚动条<br/>
        	这是左侧区域<br/>内容过多时出现纵向滚动条<br/>
        	这是左侧区域<br/>内容过多时出现纵向滚动条<br/>
        	这是左侧区域<br/>内容过多时出现纵向滚动条<br/>
        	这是左侧区域<br/>内容过多时出现纵向滚动条<br/>
        	这是左侧区域<br/>内容过多时出现纵向滚动条<br/>
        	这是左侧区域<br/>内容过多时出现纵向滚动条<br/>
        	这是左侧区域<br/>内容过多时出现纵向滚动条<br/>
			</div>
        </div>
        <div position="center" style="">
        	这是中间区域
        </div>
        <div position="right" style="" panelTitle="便捷工具">
        	这是右侧区域
        </div>
        <div position="bottom" id="bottomCon" style="" panelTitle="对比数据">
        	下部区域
        </div>
    </div> 
</body>
</html>