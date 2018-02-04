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

<!--layout布局控件start-->
<link href="<%=path%>/libs/thirdparty/layout/css/style.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=path%>/libs/thirdparty/layout/js/jquery-ui-1.7.2.custom.min.js"></script>
<script type="text/javascript" src="<%=path%>/libs/thirdparty/layout/js/jquery.layout.js"></script>
<script type="text/javascript" src="<%=path%>/libs/thirdparty/layout/js/layout.js"></script>
<!--layout布局控件end-->
<script>
$(function(){
		$(window).resize(function(){
			var parentTopHeight = $(window.top.document.getElementById("hbox")).outerHeight() + $(window.parent.document.getElementById("rbox_topcenter")).outerHeight();
		    var  parentBottomHeight = $(window.top.document.getElementById("fbox")).outerHeight() + $(window.parent.document.getElementById("rbox_bottomcenter")).outerHeight() + 1;
			var parentMainHeight = window.top.document.documentElement.clientHeight;
			try {
				window.top.document.getElementsByTagName('iframe')['frmright'].style.height = parentMainHeight-parentTopHeight-parentBottomHeight+'px'; 
			}
			catch(e){}
		})
	})
</script>
</head>
<body>
	 <div class="ui-layout-west">
        <div class="header">左侧标题</div>
        <div class="subhead">左侧二级标题</div>
	    <div class="content">
            左侧内容区
        </div>
		<div class="footer">左侧侧页脚</div>
    </div>

    <div class="ui-layout-center">
        <div class="header">中部标题</div>
		 <div class="subhead">中部二级标题</div>
        <div class="content">


使用布局框架的页面不能有id="scrollContent"的div。HTML代码如下：
<br/>
<textarea style="width:100%;height:600px;">
<body>
	 <div class="ui-layout-west">
        <div class="header">左侧标题</div>
        <div class="subhead">左侧二级标题</div>
	    <div class="content">
            左侧内容区
        </div>
		<div class="footer">左侧侧页脚</div>
    </div>

    <div class="ui-layout-center">
        <div class="header">中部标题</div>
		 <div class="subhead">中部二级标题</div>
        <div class="content">
			中部内容
        </div>
		 <div class="footer">中部页脚</div>
    </div>
	
	<div class="ui-layout-east">
        <div class="header">便捷工具箱</div>
        <div class="subhead">右侧二级标题</div>
        <div class="content">
        	右侧内容区
        </div>
        <div class="footer">右侧页脚</div>
    </div>
</body>
</textarea>
<br/>

	可根据需要对各模块进行取舍，例如可以去掉右侧栏、去掉二级标题和页脚等。另外还可以增加上方和下方的面板。<br />

	面板初始化的尺寸等设置需要在layout.js中设置。<br />
	
        </div>
		 <div class="footer">中部页脚</div>
    </div>
	
	<div class="ui-layout-east">
        <div class="header">便捷工具箱</div>
        <div class="subhead">右侧二级标题</div>
        <div class="content">
        	右侧内容区
        </div>
        <div class="footer">右侧页脚</div>
    </div>
</body>
</html>