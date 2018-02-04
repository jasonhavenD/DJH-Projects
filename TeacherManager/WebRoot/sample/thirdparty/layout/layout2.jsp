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

<!--动态选项卡start-->
<script type="text/javascript" src="<%=path%>/libs/js/nav/dynamicTab.js"></script>
<!--动态选项卡end-->

<!--layout布局控件start-->
<link href="<%=path%>/libs/thirdparty/layout/css/style.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=path%>/libs/thirdparty/layout/js/jquery-ui-1.7.2.custom.min.js"></script>
<script type="text/javascript" src="<%=path%>/libs/thirdparty/layout/js/jquery.layout.js"></script>
<script type="text/javascript" src="<%=path%>/libs/thirdparty/layout/js/layout.js"></script>
<!--layout布局控件end-->
<script>
 var tab;
 var index=1;
function addTab(id,name,url){
	tab.add( {
		id :id,
		title :name,
		url :url
	});
	index++;
}
$(function(){
	tab= new TabView( {
		containerId :'tab_menu',
		pageid :'page',
		cid :'tab1',
		position :"top"
	});
	tab.add( {
		id :'index0',
		title :"新闻管理",
		url :"<%=path%>/sample/layout/nav-single-content1.jsp",
		isClosed :true
	});
		
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
<style>
	/*简易列表导航*/
.list_menu1{
	width:100%;
	margin:0;
	padding:0;
}
.list_menu1 a dt{
	width: 94%;
	height: 30px;
	line-height:30px;
	margin:5px 0 5px 2%;
	text-indent: 20px;
	border: solid 1px #42a7f7;/*边框颜色*/
	background-color: #dfeafa;/*背景色*/
	display: block;
	background-image: url(<%=path%>/libs/images/icons/star.png);
	background-repeat:no-repeat;
	background-position:2px 50%;
}
.list_menu1 a:hover dt{
	width: 94%;
	height: 30px;
	line-height:30px;
	margin:5px 0 5px 2%;
	text-indent: 20px;
	border: solid 1px #42a7f7;/*边框颜色*/
	background-color: #ebf4fe;/*背景色*/
	display: block;
}
.list_menu1 a:hover{
	text-decoration:none;
	color:black;
}
/*简易列表导航*/
</style>
</head>
<body>
	<div class="ui-layout-west">
        <div class="header">导航菜单</div>
	    <div class="content">
			<div class="list_menu1">
				<a href="javascript:addTab('index0','新闻管理','<%=path%>/sample/layout/nav-single-content1.jsp')"><dt><span>新闻管理</span></dt></a>
				<a href="javascript:addTab('index1','栏目设置','<%=path%>/sample/layout/nav-single-content2.jsp')"><dt><span>栏目设置</span></dt></a>
				<a href="javascript:addTab('index2','专题设置','<%=path%>/sample/layout/nav-single-content1.jsp')"><dt><span>专题设置</span></dt></a>
				<a href="javascript:addTab('index3','语种设置','<%=path%>/sample/layout/nav-single-content2.jsp')"><dt><span>语种设置</span></dt></a>
				<a href="javascript:addTab('index4','用户管理','<%=path%>/sample/layout/nav-single-content1.jsp')"><dt><span>用户管理</span></dt></a>
				<a href="javascript:addTab('index5','角色管理','<%=path%>/sample/layout/nav-single-content2.jsp')"><dt><span>角色管理</span></dt></a>
				<a href="javascript:addTab('index6','系统日志','<%=path%>/sample/layout/nav-single-content1.jsp')"><dt><span>系统日志</span></dt></a>
			</div>
        </div>
    </div>

    <div class="ui-layout-center">
		 <div class="subhead" style="height:30px;">
			<div id="tab_menu"></div>
		</div>
        <div class="content">
			<div id="page" style="width:100%;height:100%;"></div>	
        </div>
		
    </div>
</body>
</html>