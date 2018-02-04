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
$(function(){
	//自定义菜单1
	$(".popupMenu_custom_demo1").each(function(){
	$(this).hover(function(){
		$(this).find(".popupMenu_custom1").show();
		$(this).find(".popupMenu_custom1_delete").show();
	},function(){
		$(this).find(".popupMenu_custom1").hide();
		$(this).find(".popupMenu_custom1_delete").hide();
	})
	})
	
	//自定义菜单2
	$("#select2").change(function(){
		$(this).parents(".popupMenu_custom2_con").hide();
		var objSel1 = document.getElementById("select1"); 
		var objSel2 = document.getElementById("select2"); 
		$("#link_text").text(objSel1.options[objSel1.selectedIndex].text+objSel2.options[objSel2.selectedIndex].text);
	});
})
</script>
<style>
/*自定义菜单1*/
.popupMenu_custom_demo1{
	position:relative;
	width:560px;
	
}
.popupMenu_custom1{
	position:absolute;
	top:10px;
	right:32px;
	width:18px;
	display:none;
}
.popupMenu_custom1_link a{
	background-image: url(<%=path%>/libs/images/demo/dropmenu-button.png);
	background-repeat: no-repeat;
	width:18px;
	height:18x;
	display:block;
	text-indent:-1000px;
}
.popupMenu_custom1_link a:hover{
	background-image: url(<%=path%>/libs/images/demo/dropmenu-button2.png);
}
.popupMenu_custom1_delete{
	position:absolute;
	top:10px;
	right:10px;
	display:none;
}
.popupMenu_custom1_delete a{
	background-image: url(<%=path%>/libs/images/demo/close-button.png);
	background-repeat: no-repeat;
	width:18px;
	height:18x;
	display:block;
	text-indent:-1000px;
}
.popupMenu_custom1_delete a:hover{
	background-image: url(<%=path%>/libs/images/demo/close-button2.png);
}
.popupMenu_custom1_con{
	right:0px!important;
}
/*自定义菜单1*/

/*自定义菜单2*/
.popupMenu_custom2_link_text{
	background-image: url(<%=path%>/libs/images/demo/arrow.jpg);
	background-repeat: no-repeat;
	background-position:100% 0%;
	padding:0 0 0 5px;
	height:23px;
	line-height:23px;
	border:solid 1px #cccccc;
	width:100px!important;
}
.popupMenu_custom2_con{
	border:solid 1px #cccccc;
	background-color:white;
	padding:6px;
}
.popupMenu_custom2_con select{
	width:150px;
}
/*自定义菜单2*/
</style>
</head>
<body>
 <div class="box1" panelWidth="800">
	<fieldset> 
     <legend>1、白色背景模式</legend>
     	菜单链接默认宽度为50像素，菜单项默认100像素。
 <div class="popupMenu">
	<div class="popupMenu_link">
		<a href="javascript:;">选择</a>
	</div>
	<div class="popupMenu_con white_con">
		<a href="javascript:;"><span>状态</span></a>
		<a href="javascript:;"><span>相册</span></a>
		<a href="javascript:;"><span>分享</span></a>
		<a href="javascript:;"><span>日志</span></a>
	</div>
</div>
	</fieldset>
	<div style="height:100px;"></div>
	
	<fieldset> 
     <legend>2、自定义尺寸</legend>
     	可通过style自定义宽度。通过class添加边框和箭头。
	     <div class="popupMenu" style="width:92px;">
			<div class="popupMenu_link arrow border white_bg">
				<a href="javascript:;">全部操作</a>
			</div>
			<div class="popupMenu_con white_con" style="width:90px;">
				<a href="javascript:;"><span>查看</span></a>
				<a href="javascript:;"><span>修改</span></a>
				<a href="javascript:;"><span>删除</span></a>
				<a href="javascript:;"><span>保存</span></a>
			</div>
		</div>
	</fieldset>
	<div style="height:100px;"></div>
	
	<fieldset> 
     <legend>3、图片背景模式</legend>
	     <div class="popupMenu">
			<div class="popupMenu_link">
				<a href="javascript:;">选择</a>
			</div>
			<div class="popupMenu_con pic_con">
				<a href="javascript:;"><span>状态</span></a>
				<a href="javascript:;"><span>相册</span></a>
				<a href="javascript:;"><span>分享</span></a>
				<a href="javascript:;"><span>日志</span></a>
			</div>
		</div>
	</fieldset>
	<div style="height:100px;"></div>
	
	
	<fieldset> 
     <legend>4、图标模式</legend>
	     <div class="popupMenu">
			<div class="popupMenu_link">
				<a href="javascript:;">操作</a>
			</div>
			<div class="popupMenu_con icon_con">
				<a href="javascript:;"><span class="icon_add">新增</span></a>
				<a href="javascript:;"><span class="icon_edit">修改</span></a></a>
				<a href="javascript:;"><span class="icon_delete">删除</span></a></a>
				<a href="javascript:;"><span class="icon_view">查看</span></a></a>
			</div>
		</div>
	</fieldset>
	<div style="height:100px;"></div>
	
	
	<fieldset> 
     <legend>5、多列模式</legend>
	     <div class="popupMenu">
			<div class="popupMenu_link">
				<a href="javascript:;">操作</a>
			</div>
			<div class="popupMenu_con multi_con">
				<div class="column">
					<h3>分类1</h3>
					<ul>
					<li><a href="javascript:;">选项1</a></li>
					<li><a href="javascript:;">选项2</a></li>
					<li><a href="javascript:;">选项3</a></li>
					<li><a href="javascript:;">选项4</a></li>
					</ul>
				</div>
				
				<div class="column">
					<h3>分类2</h3>
					<ul>
					<li><a href="javascript:;">选项1</a></li>
					<li><a href="javascript:;">选项2</a></li>
					<li><a href="javascript:;">选项3</a></li>
					<li><a href="javascript:;">选项4</a></li>
					</ul>
				</div>
				<div class="column">
					<h3>分类3</h3>
					<ul>
					<li><a href="javascript:;">选项1</a></li>
					<li><a href="javascript:;">选项2</a></li>
					<li><a href="javascript:;">选项3</a></li>
					<li><a href="javascript:;">选项4</a></li>
					</ul>
				</div>
				<div class="clear"></div>
				<div class="column">
					<h3>分类4</h3>
					<ul>
					<li><a href="javascript:;">选项1</a></li>
					<li><a href="javascript:;">选项2</a></li>
					<li><a href="javascript:;">选项3</a></li>
					<li><a href="javascript:;">选项4</a></li>
					</ul>
				</div>
				<div class="column">
					<h3>分类5</h3>
					<ul>
					<li><a href="javascript:;">选项1</a></li>
					<li><a href="javascript:;">选项2</a></li>
					<li><a href="javascript:;">选项3</a></li>
					<li><a href="javascript:;">选项4</a></li>
					</ul>
				</div>
				<div class="column">
					<h3>分类6</h3>
					<ul>
					<li><a href="javascript:;">选项1</a></li>
					<li><a href="javascript:;">选项2</a></li>
					<li><a href="javascript:;">选项3</a></li>
					<li><a href="javascript:;">选项4</a></li>
					</ul>
				</div>
			</div>
		</div>
	</fieldset>
	<div style="height:350px;"></div>
	
	
	<fieldset> 
     <legend>6、自定义菜单示例（仿人人网）</legend>
	 	<div class="popupMenu_custom_demo1">
		 	<img src="<%=path%>/libs/images/demo/1.jpg"/>
		 	<div class="popupMenu popupMenu_custom1">
				<div class="popupMenu_link popupMenu_custom1_link">
					<a href="javascript:;">选择</a>
				</div>
				<div class="popupMenu_con white_con popupMenu_custom1_con">
					<a href="javascript:;"><span>关注XXX</span></a>
					<a href="javascript:;"><span>忽略XXX</span></a>
				</div>
			</div>
			<div class="popupMenu_custom1_delete"><a href="javascript:;">删除</a></div>
		 	</div>
		 	
		 	<div class="popupMenu_custom_demo1">
		 	<img src="<%=path%>/libs/images/demo/2.jpg"/>
		 	<div class="popupMenu popupMenu_custom1">
				<div class="popupMenu_link popupMenu_custom1_link">
					<a href="javascript:;">选择</a>
				</div>
				<div class="popupMenu_con white_con popupMenu_custom1_con">
					<a href="javascript:;"><span>关注XXX</span></a>
					<a href="javascript:;"><span>忽略XXX</span></a>
				</div>
			</div>
			<div class="popupMenu_custom1_delete"><a href="javascript:;">删除</a></div>
	 	</div>
	     
	</fieldset>
	<div class="height_50"></div>
	
	<fieldset> 
     <legend>7、自定义菜单示例（仿京东网）</legend>
 		<div class="popupMenu">
			<div class="popupMenu_link popupMenu_custom2_link">
				<div class="popupMenu_custom2_link_text" id="link_text">请选择城市</div>
			</div>
			<div class="popupMenu_con popupMenu_custom2_con">
				<table>
				<tr>
					<td>
					<select id="select1" keepDefaultStyle="true" size="10"><option value="">--请选择--</option><option value="1">北京</option><option value="2">上海</option><option value="3">天津</option><option value="4">重庆</option><option value="5">河北</option><option value="6">山西</option><option value="7">河南</option><option value="8">辽宁</option><option value="9">吉林</option><option value="10">黑龙江</option><option value="11">内蒙古</option><option value="12">江苏</option><option value="13">山东</option><option value="14">安徽</option><option value="15">浙江</option><option value="16">福建</option><option value="17">湖北</option><option value="18">湖南</option><option value="19">广东</option><option value="20">广西</option><option value="21">江西</option><option value="22">四川</option><option value="23">海南</option><option value="24">贵州</option><option value="25">云南</option><option value="26">西藏</option><option value="27">陕西</option><option value="28">甘肃</option><option value="29">青海</option><option value="30">宁夏</option><option value="31">新疆</option><option value="32">台湾</option><option value="42">香港</option><option value="43">澳门</option><option value="84">钓鱼岛</option></select>
					</td>
					<td>
					<select id="select2" keepDefaultStyle="true" size="10"><option value="">--请选择--</option><option title="朝阳区" value="72">朝阳区</option><option title="海淀区" value="2800">海淀区</option><option title="西城区" value="2801">西城区</option><option title="东城区" value="2802">东城区</option><option title="崇文区" value="2803">崇文区</option><option title="宣武区" value="2804">宣武区</option><option title="丰台区" value="2805">丰台区</option><option title="石景山区" value="2806">石景山区</option><option title="门头沟" value="2807">门头沟</option><option title="房山区" value="2808">房山区</option><option title="通州区" value="2809">通州区</option><option title="大兴区" value="2810">大兴区</option><option title="顺义区" value="2812">顺义区</option><option title="怀柔区" value="2814">怀柔区</option><option title="密云区" value="2816">密云区</option><option title="昌平区" value="2901">昌平区</option><option title="平谷区" value="2953">平谷区</option><option title="延庆县" value="3065">延庆县</option></select>
					</td>
				</tr>
				</table>
			</div>
		</div>
		<p>这里选择框的联动请自行实现。</p>
	</fieldset>
	<div style="height:200px;"></div>
		
	
	<fieldset> 
     <legend>8、动态添加</legend>
     <input type="button" value="点击生成" id="testBtn" onclick="createMenu()"/>
	
	</fieldset>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	</div>
	
<script>
		function createMenu(){
			var $menu=$('<div class="popupMenu" style="width:20px;">'+
				'<div class="popupMenu_link"><span class="img_add hand"></span><br />'+
					'<div class="popupMenu_con white_con">'+
					'<a href="javascript:;"><span>状态</span></a>'+
					'<a href="javascript:;"><span>相册</span></a>'+
				'</div></div>')
			$("#testBtn").after($menu);
			$menu.render();
		}
	</script>

</body>

</html>