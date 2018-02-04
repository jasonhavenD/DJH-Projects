<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!--数字分页start-->
<script type="text/javascript" src="<%=path%>/libs/js/nav/pageNumber.js"></script>
<!--数字分页end-->
<script>
function openWin(){
	top.Dialog.open({URL:"<%=path%>/sample/layout/layout-box-content2.jsp",MessageTitle:"请参评工程师及高级工程师的同事报名",Title:"详细内容",Width:600,Height:500});
}
</script>
<body>
<div class="box1" whiteBg="true">
	<div class="dbList">
	<ul>
		<li class="listArr"><a href="javascript:openWin()"><span class="textSlice" style="width:380px;">第十三届运动会即将开始，请大家抓紧时间报名</span></a></li>
		<li style="width:100px;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr"><a href="javascript:openWin()"><span class="textSlice" style="width:380px;">《部门质量保证文件》发布</span></a></li>
		<li style="width:100px;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr"><a href="javascript:openWin()"><span class="textSlice" style="width:380px;">请新同事将网站个人信息补充完整</span></a></li>
		<li style="width:100px;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr"><a href="javascript:openWin()"><span class="textSlice" style="width:380px;">关于成立“服务器端软件设计”技术沙龙的通知</span></a></li>
		<li style="width:100px;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr"><a href="javascript:openWin()"><span class="textSlice" style="width:380px;">关于组织“青春展风采 激情促腾飞”主题系列活动工作</span></a></li>
		<li style="width:100px;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr"><a href="javascript:openWin()"><span class="textSlice" style="width:380px;">第十三届运动会即将开始，请大家抓紧时间报名</span></a></li>
		<li style="width:100px;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr"><a href="javascript:openWin()"><span class="textSlice" style="width:380px;">《部门质量保证文件》发布</span></a></li>
		<li style="width:100px;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr"><a href="javascript:openWin()"><span class="textSlice" style="width:380px;">请新同事将网站个人信息补充完整</span></a></li>
		<li style="width:100px;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr"><a href="javascript:openWin()"><span class="textSlice" style="width:380px;">关于成立“服务器端软件设计”技术沙龙的通知</span></a></li>
		<li style="width:100px;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr"><a href="javascript:openWin()"><span class="textSlice" style="width:380px;">关于组织“青春展风采 激情促腾飞”主题系列活动工作</span></a></li>
		<li style="width:100px;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr"><a href="javascript:openWin()"><span class="textSlice" style="width:380px;">第十三届运动会即将开始，请大家抓紧时间报名</span></a></li>
		<li style="width:100px;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	</div>
	
<div style="height:35px;">
	<div class="float_left padding5">
	</div>
	<div class="float_right padding5">
		<div class="pageNumber" total="200" showSelect="false" showInput="false" id="page-7"></div>
	</div>
	<div class="clear"></div>
</div>
<div class="clear"></div>
</div>
</body>
</html>