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

<script>
function openWin(){
	top.Dialog.open({URL:"<%=path%>/sample/layout/layout-box-content1.jsp",Title:"文章列表"});
}
function openWin2(){
	top.Dialog.open({URL:"<%=path%>/sample/layout/layout-box-content2.jsp",MessageTitle:"请参评工程师及高级工程师的同事报名",Title:"详细内容",Width:600,Height:500});
}
</script>
<body>
	<table width="100%"  border="0" cellspacing="0" cellpadding="0">
	  <tr>
	    <td colspan="3">
	    	<div class="box2"  panelTitle="最新消息" roller="false" showStatus="false" statusText="更多>>" panelUrl="javascript:openWin()">
				<table width="100%">
					<tr>
						<td class="ver01" width="50%">
	<div class="dbList">
	<ul>
		<li class="listArr" style="width:70%;"><a href="javascript:openWin2()" title="第十三届运动会即将开始，请大家抓紧时间报名"><span class="textSlice" style="width:100%;">第十三届运动会即将开始，请大家抓紧时间报名</span></a></li>
		<li style="width:20%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:70%;"><a href="javascript:openWin2()" title="《部门质量保证文件》发布"><span class="textSlice" style="width:100%;">《部门质量保证文件》发布</span></a></li>
		<li style="width:20%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:70%;"><a href="javascript:openWin2()" title="请新同事将网站个人信息补充完整"><span class="textSlice" style="width:100%;">请新同事将网站个人信息补充完整</span></a></li>
		<li style="width:20%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:70%;"><a href="javascript:openWin2()" title="关于成立服务器端软件设计技术沙龙的通知"><span class="textSlice" style="width:100%;">关于成立“服务器端软件设计”技术沙龙的通知</span></a></li>
		<li style="width:20%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:70%;"><a href="javascript:openWin2()" title="关于组织青春展风采 激情促腾飞主题系列活动工作"><span class="textSlice" style="width:100%;">关于组织“青春展风采 激情促腾飞”主题系列活动工作</span></a></li>
		<li style="width:20%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	</div>
						</td>
						<td class="ver01">
	<div class="dbList">
	<ul>
		<li class="listArr" style="width:70%;"><a href="javascript:openWin2()" title="第十三届运动会即将开始，请大家抓紧时间报名"><span class="textSlice" style="width:100%;">第十三届运动会即将开始，请大家抓紧时间报名</span></a></li>
		<li style="width:20%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:70%;"><a href="javascript:openWin2()" title="《部门质量保证文件》发布"><span class="textSlice" style="width:100%;">《部门质量保证文件》发布</span></a></li>
		<li style="width:20%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:70%;"><a href="javascript:openWin2()" title="请新同事将网站个人信息补充完整"><span class="textSlice" style="width:100%;">请新同事将网站个人信息补充完整</span></a></li>
		<li style="width:20%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:70%;"><a href="javascript:openWin2()" title="关于成立服务器端软件设计技术沙龙的通知"><span class="textSlice" style="width:100%;">关于成立“服务器端软件设计”技术沙龙的通知</span></a></li>
		<li style="width:20%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:70%;"><a href="javascript:openWin2()" title="关于组织青春展风采 激情促腾飞主题系列活动工作"><span class="textSlice" style="width:100%;">关于组织“青春展风采 激情促腾飞”主题系列活动工作</span></a></li>
		<li style="width:20%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	</div>			
						</td>
					</tr>
				</table>
	    	</div>
		</td>
	  </tr>
	  <tr>
	    <td rowspan="3" width="33%" class="ver01">
	    	<div class="box2_custom" boxType="box2" panelHeight="456"  panelTitle="任务模块1" showStatus="true"  panelUrl="javascript:openWin()">
	<div class="dbList">
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="第十三届运动会即将开始，请大家抓紧时间报名"><span class="textSlice" style="width:100%;">第十三届运动会即将开始，请大家抓紧时间报名</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="《部门质量保证文件》发布"><span class="textSlice" style="width:100%;">《部门质量保证文件》发布</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="请新同事将网站个人信息补充完整"><span class="textSlice" style="width:100%;">请新同事将网站个人信息补充完整</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="关于成立服务器端软件设计技术沙龙的通知"><span class="textSlice" style="width:100%;">关于成立“服务器端软件设计”技术沙龙的通知</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="关于组织青春展风采 激情促腾飞主题系列活动工作"><span class="textSlice" style="width:100%;">关于组织“青春展风采 激情促腾飞”主题系列活动工作</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="第十三届运动会即将开始，请大家抓紧时间报名"><span class="textSlice" style="width:100%;">第十三届运动会即将开始，请大家抓紧时间报名</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="《部门质量保证文件》发布"><span class="textSlice" style="width:100%;">《部门质量保证文件》发布</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="请新同事将网站个人信息补充完整"><span class="textSlice" style="width:100%;">请新同事将网站个人信息补充完整</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="关于成立服务器端软件设计技术沙龙的通知"><span class="textSlice" style="width:100%;">关于成立“服务器端软件设计”技术沙龙的通知</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="关于组织青春展风采 激情促腾飞主题系列活动工作"><span class="textSlice" style="width:100%;">关于组织“青春展风采 激情促腾飞”主题系列活动工作</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="第十三届运动会即将开始，请大家抓紧时间报名"><span class="textSlice" style="width:100%;">第十三届运动会即将开始，请大家抓紧时间报名</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="《部门质量保证文件》发布"><span class="textSlice" style="width:100%;">《部门质量保证文件》发布</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="请新同事将网站个人信息补充完整"><span class="textSlice" style="width:100%;">请新同事将网站个人信息补充完整</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="关于成立服务器端软件设计技术沙龙的通知"><span class="textSlice" style="width:100%;">关于成立“服务器端软件设计”技术沙龙的通知</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="关于组织青春展风采 激情促腾飞主题系列活动工作"><span class="textSlice" style="width:100%;">关于组织“青春展风采 激情促腾飞”主题系列活动工作</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	</div>    		
	    	</div>
		</td>
	    <td width="34%" class="ver01">
	    	<div class="box2_custom" boxType="box2" panelHeight="110"  panelTitle="任务模块2" showStatus="true" panelUrl="javascript:openWin()">
	<div class="dbList">
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="第十三届运动会即将开始，请大家抓紧时间报名"><span class="textSlice" style="width:100%;">第十三届运动会即将开始，请大家抓紧时间报名</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="《部门质量保证文件》发布"><span class="textSlice" style="width:100%;">《部门质量保证文件》发布</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="请新同事将网站个人信息补充完整"><span class="textSlice" style="width:100%;">请新同事将网站个人信息补充完整</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="关于成立服务器端软件设计技术沙龙的通知"><span class="textSlice" style="width:100%;">关于成立“服务器端软件设计”技术沙龙的通知</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	</div>
	    	</div>
	    </td>
	    <td rowspan="3" class="ver01">
	    	<div class="box2" panelHeight="456"  panelTitle="工作计划" roller="false" showStatus="false" statusText="更多>>" panelUrl="javascript:openWin()">
	<div class="dbList">
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="第十三届运动会即将开始，请大家抓紧时间报名"><span class="textSlice" style="width:100%;">第十三届运动会即将开始，请大家抓紧时间报名</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="《部门质量保证文件》发布"><span class="textSlice" style="width:100%;">《部门质量保证文件》发布</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="请新同事将网站个人信息补充完整"><span class="textSlice" style="width:100%;">请新同事将网站个人信息补充完整</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="关于成立服务器端软件设计技术沙龙的通知"><span class="textSlice" style="width:100%;">关于成立“服务器端软件设计”技术沙龙的通知</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="关于组织青春展风采 激情促腾飞主题系列活动工作"><span class="textSlice" style="width:100%;">关于组织“青春展风采 激情促腾飞”主题系列活动工作</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="第十三届运动会即将开始，请大家抓紧时间报名"><span class="textSlice" style="width:100%;">第十三届运动会即将开始，请大家抓紧时间报名</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="《部门质量保证文件》发布"><span class="textSlice" style="width:100%;">《部门质量保证文件》发布</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="请新同事将网站个人信息补充完整"><span class="textSlice" style="width:100%;">请新同事将网站个人信息补充完整</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="关于成立服务器端软件设计技术沙龙的通知"><span class="textSlice" style="width:100%;">关于成立“服务器端软件设计”技术沙龙的通知</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="关于组织青春展风采 激情促腾飞主题系列活动工作"><span class="textSlice" style="width:100%;">关于组织“青春展风采 激情促腾飞”主题系列活动工作</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="第十三届运动会即将开始，请大家抓紧时间报名"><span class="textSlice" style="width:100%;">第十三届运动会即将开始，请大家抓紧时间报名</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="《部门质量保证文件》发布"><span class="textSlice" style="width:100%;">《部门质量保证文件》发布</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="请新同事将网站个人信息补充完整"><span class="textSlice" style="width:100%;">请新同事将网站个人信息补充完整</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="关于成立服务器端软件设计技术沙龙的通知"><span class="textSlice" style="width:100%;">关于成立“服务器端软件设计”技术沙龙的通知</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="关于组织青春展风采 激情促腾飞主题系列活动工作"><span class="textSlice" style="width:100%;">关于组织“青春展风采 激情促腾飞”主题系列活动工作</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	    	</div>
	    </td>
	  </tr>
	  <tr>
	    <td>
	    	<div class="box2_custom" boxType="box2" panelHeight="110"  panelTitle="任务模块3" showStatus="true"  panelUrl="javascript:openWin()">
	 <div class="dbList">
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="第十三届运动会即将开始，请大家抓紧时间报名"><span class="textSlice" style="width:100%;">第十三届运动会即将开始，请大家抓紧时间报名</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="《部门质量保证文件》发布"><span class="textSlice" style="width:100%;">《部门质量保证文件》发布</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="请新同事将网站个人信息补充完整"><span class="textSlice" style="width:100%;">请新同事将网站个人信息补充完整</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="关于成立服务器端软件设计技术沙龙的通知"><span class="textSlice" style="width:100%;">关于成立“服务器端软件设计”技术沙龙的通知</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	</div>   		
	    	</div>
		</td>
	  </tr>
	  <tr>
	    <td>
	    	<div class="box2_custom" boxType="box2" panelHeight="110"  panelTitle="任务模块4" showStatus="true" panelUrl="javascript:openWin()">
	  <div class="dbList">
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="第十三届运动会即将开始，请大家抓紧时间报名"><span class="textSlice" style="width:100%;">第十三届运动会即将开始，请大家抓紧时间报名</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="《部门质量保证文件》发布"><span class="textSlice" style="width:100%;">《部门质量保证文件》发布</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="请新同事将网站个人信息补充完整"><span class="textSlice" style="width:100%;">请新同事将网站个人信息补充完整</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	<ul>
		<li class="listArr" style="width:68%;"><a href="javascript:openWin2()" title="关于成立服务器端软件设计技术沙龙的通知"><span class="textSlice" style="width:100%;">关于成立“服务器端软件设计”技术沙龙的通知</span></a></li>
		<li style="width:32%;">2010-09-07</li>
	</ul>
	<div class="clear"></div>
	</div>  		
	    	</div>
	    </td>
	  </tr>
	</table>
</body>
</html>