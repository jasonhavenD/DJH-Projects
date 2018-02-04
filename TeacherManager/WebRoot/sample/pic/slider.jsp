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

<!--用于引入flash的脚本start-->
<script type="text/javascript" src="<%=path%>/libs/js/method/swfobject.js"></script>
<!--用于引入flash的脚本end--> 

<script>
function initComplete(){
	var interval_time=4 //图片停顿时间，单位为秒，为0则停止自动切换
	var flawidth=document.getElementById('flashcontent').offsetWidth;
	var flaheight=document.getElementById('flashcontent').offsetHeight;
	var focus_width=flawidth //宽度
	var focus_height=flaheight //高度
	var text_height=0 //标题高度
	var text_align= 'center' //标题文字对齐方式(left、center、right)
	var swf_height = focus_height+text_height //相加之和最好是偶数,否则数字会出现模糊失真的问题
	
	var pics= '<%=path%>/libs/images/demo/demo1.jpg|<%=path%>/libs/images/demo/demo2.jpg|<%=path%>/libs/images/demo/demo3.jpg'//图片地址
	var links='http://www.baidu.com|http://www.sina.com.cn|http://mail.163.com'//相对于图片的链接地址
	var texts='标题1|标题2|标题3'//标题文字
	
	var so = new SWFObject("<%=path%>/libs/flash/slider.swf", "focus", "100%", "100%", "7", "#ffffff");
	so.addParam('wmode','opaque');
	so.addParam('quality','high');
	so.addParam("scale", "noscale" );
	so.addParam("menu", "false" );
	so.addVariable("pics",pics);
	so.addVariable("links",links);
	so.addVariable("texts",texts);
	so.addVariable("textheight",text_height);
	so.addVariable("borderwidth",focus_width);
	so.addVariable("borderheight",focus_height);
	so.addVariable("text_align",text_align);
	so.addVariable("interval_time",interval_time);
	so.addVariable("textheight",text_height);
	so.addVariable("width",focus_width);
	so.addVariable("height",swf_height);
	so.write("flashcontent");
}
</script>
</head>
<body>
 	<div class="box1" panelWidth="438">
 		<div id="flashcontent" style="width:400px;height:200px;"> 	
 			<div class="flash_install">
				<div class="msg_icon3"></div>
				<div class="flash_install_con" >
				您需要升级Flash播放器，<span class="forIE"><a href="<%=path%>/libs/flash/flash_IE.exe">点击这里</a>安装</span>
				<span class="forFF"><a href="<%=path%>/libs/flash/flash_FF.exe">点击这里</a>进行安装</span><br />安装后请关闭浏览器再重新打开
				</div>
			</div>
		</div>
	</div>
</body>
</html>