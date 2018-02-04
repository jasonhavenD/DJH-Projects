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
  <div class="box2" panelTitle="控制基本布局、宽高、颜色、字号、缩进等（basic.css）">	
		<table class="tableStyle">
			<tr><th colspan="2">浮动</th></tr>
			<tr><td>float_left</td><td>向左浮动</td></tr>
			<tr><td>float_right</td><td>向右浮动</td></tr>
			<tr><td>clear</td><td>清除浮动（设置了浮动后最后要清除浮动，否则后面的元素也会受到浮动影响）</td></tr>
			<tr><th colspan="2">对齐</th></tr>
			<tr><td>ali01</td><td>水平靠左</td></tr>
			<tr><td>ali02</td><td>水平居中</td></tr>
			<tr><td>center</td><td>水平居中(FireFox下有些情况ali02无法实现居中，这时用center)</td></tr>
			<tr><td>ali03</td><td>水平靠右</td></tr>
			<tr><td>ver01</td><td>垂直靠上</td></tr>
			<tr><td>ver02</td><td>垂直居中</td></tr>
			<tr><td>ver03</td><td>垂直靠下</td></tr>
			<tr><th colspan="2">宽、高与间距（这里的命名原则：英文后面直接加数字代表百分比，英文后加下划线再加数字代表像素值）</th></tr>
			<tr><td>width100</td><td>宽度100%</td></tr>
			<tr><td>height100</td><td>高度100%</td></tr>
			<tr><td>minHeight_100</td><td>最小高度为100px</td></tr>
			<tr><td>minHeight_150</td><td>最小高度为150px</td></tr>
			<tr><td>minHeight_200</td><td>最小高度为200px</td></tr>
			<tr><td><span class="text_slice">height_0、height_1到height_50</span></td><td>元素高度，从0px,1px到10px,15px,20px到50px(10以后每个间隔5px)。用法见下面：</td></tr>
			<tr><td colspan="2">
				可以用来设置两个垂直排列的元素的垂直间距（代替br）
效果：<br />
<input type="button" value=" 确 定 "/><div class="height_10"></div>
<input type="button" value=" 取 消 "/>
				</td></tr>	
			<tr><td><span class="text_slice">spacer_0、spacer_1到spacer_50</span></td><td>元素间距，从0px,1px到10px,15px,20px到50px(10以后每个间隔5px)。用法见下面：</td></tr>
			<tr><td colspan="2">
				可以用来设置两个水平排列的元素的间距（代替空格）
效果：<br />
<input type="button" value=" 确 定 " style="float:left"/><div class="spacer_10"></div>
<input type="button" value=" 取 消 " style="float:left"/><div class="clear"></div>
				</td></tr>	
			<tr><th colspan="2">行高</th></tr>
			<tr><td>lineHeight100</td><td>行高100%</td></tr>
			<tr><td>lineHeight150</td><td>行高150%</td></tr>
			<tr><td>lineHeight200</td><td>行高200%</td></tr>
			<tr><th colspan="2">边框</th></tr>
			<tr><td>border_gray</td><td>灰色1像素边框</td></tr>
			<tr><td>border_red</td><td>红色1像素边框</td></tr>
			<tr><td>border_blue</td><td>蓝色1像素边框</td></tr>
			<tr><td>border_green</td><td>绿色1像素边框</td></tr>
			<tr><td>border_black</td><td>黑色1像素边框</td></tr>
			<tr><td>border_white</td><td>白色1像素边框</td></tr>
			<tr><th colspan="2">背景颜色</th></tr>
			<tr><td>white_bg</td><td>白色背景</td></tr>
			<tr><td>trans_bg</td><td>背景透明</td></tr>
			<tr><th colspan="2">字符间距</th></tr>
			<tr><td><span class="text_slice">letter_space0、letter_space1到letter_space5</span></td><td>字符间距为0em到5em，1em为一个12像素字的宽度</td></tr>
			<tr><th colspan="2">文字颜色（设为链接后也不会变色）</th></tr>
			<tr><td>black</td><td>文字颜色为黑色</td></tr>
			<tr><td>white</td><td>文字颜色为白色</td></tr>
			<tr><td>red</td><td>文字颜色为红色</td></tr>
			<tr><td>blue</td><td>文字颜色为蓝色</td></tr>
			<tr><th colspan="2">字体大小（这里的字体大小命名原则：英文后加下划线再加数字代表像素值）</th></tr>
			<tr><td>font_12</td><td>字体大小为12px</td></tr>
			<tr><td>font_13</td><td>字体大小为13px</td></tr>
			<tr><td>font_14</td><td>字体大小为14px</td></tr>
			<tr><td>font_16</td><td>字体大小为16px</td></tr>
			<tr><td>font_18</td><td>字体大小为18px</td></tr>
			<tr><td>font_20</td><td>字体大小为20px</td></tr>
			<tr><td>font_25</td><td>字体大小为25px</td></tr>
			<tr><th colspan="2">字体粗细</th></tr>
			<tr><td>font_normal</td><td>文字强制不加粗</td></tr>
			<tr><td>font_bold</td><td>文字加粗</td></tr>
			<tr><td>font_specal</td><td>白色微软雅黑字体，并有阴影特效。注意IE浏览器需要为文字容器加宽度才有效</td></tr>
			<tr><th colspan="2">文字缩进</th></tr>
			<tr><td><span class="text_slice">font_ind0、font_ind1到font_ind50</span></td><td>文字缩进，从0px,1px到10px,15px,20px到50px(10以后每个间隔5px)</td></tr>
			<tr><th colspan="2">其他</th></tr>
			<tr><td>text_slice</td><td>截取文字出省略号，使用方法参考“文本>>文本单行截取”相关内容</td></tr>
			<tr><td>text_break</td><td>强制文字折行，使用方法参考“API必备知识>>文字折行处理”相关内容</td></tr>
			<tr><td>text_singleLine</td><td>强制文字不换行</td></tr>
			<tr><td>imgFix</td><td>大图修正</td></tr>
			<tr><td>hand</td><td>强制鼠标显示为手型</td></tr>
			<tr><td>underLine</td><td>文字有下划线</td></tr>
			<tr><td>groupTitle</td><td>div设置该样式并且嵌套span，标题样式</td></tr>
			<tr><td>formTable</td><td>table设置该样式，设置了每一行元素上下的间距，用于自定义表单布局</td></tr>
		</table>
	</div>
	
	<div class="box2" panelTitle="控制定位（position.css）">
		<table class="tableStyle">
			<tr><th colspan="2">padding定位（在可能的情况下尽量用padding定位而不用margin定位）</th></tr>
			<tr><td><span class="text_slice">padding0、padding1到padding50</span></td><td>设置该容器的子内容距该容器的偏移距离，从上、右、下、左4个方向作同样的偏移。从0px,1px到10px,15px,20px到50px(10以后每个间隔5px)</td></tr>
			<tr><td><span class="text_slice">padding_top0、padding_top1到padding_top50</span></td><td>设置该容器的内容距该容器的上方偏移距离。从0px,1px到10px,15px,20px到50px(10以后每个间隔5px)</td></tr>
			<tr><td><span class="text_slice">padding_right0、padding_right1到padding_right50</span></td><td>设置该容器的内容距该容器的右方偏移距离。从0px,1px到10px,15px,20px到50px(10以后每个间隔5px)</td></tr>
			<tr><td><span class="text_slice">padding_bottom0、padding_bottom1到padding_bottom50</span></td><td>设置该容器的内容距该容器的下方偏移距离。从0px,1px到10px,15px,20px到50px(10以后每个间隔5px)</td></tr>
			<tr><td><span class="text_slice">padding_left0、padding_left1到padding_left50</span></td><td>设置该容器的内容距该容器的左方偏移距离。从0px,1px到10px,15px,20px到50px(10以后每个间隔5px)</td></tr>
			<tr><th colspan="2">margin定位</th></tr>
			<tr><td><span class="text_slice">margin0、margin1到margin50</span></td><td>设置该容器距父容器的偏移距离，从上、右、下、左4个方向作同样的偏移。从0px,1px到10px,15px,20px到50px(10以后每个间隔5px)</td></tr>
			<tr><td><span class="text_slice">margin_top0、margin_top1到margin_top50</span></td><td>设置该容器距父容器上方的偏移距离。从0px,1px到10px,15px,20px到50px(10以后每个间隔5px)</td></tr>
			<tr><td><span class="text_slice">margin_right0、margin_right1到margin_right50</span></td><td>设置该容器距父容器右方的偏移距离。从0px,1px到10px,15px,20px到50px(10以后每个间隔5px)</td></tr>
			<tr><td><span class="text_slice">margin_bottom0、margin_bottom1到margin_bottom50</span></td><td>设置该容器距父容器下方的偏移距离。从0px,1px到10px,15px,20px到50px(10以后每个间隔5px)</td></tr>
			<tr><td><span class="text_slice">margin_left0、margin_left1到margin_left50</span></td><td>设置该容器距父容器左方的偏移距离。从0px,1px到10px,15px,20px到50px(10以后每个间隔5px)</td></tr>
		</table>
	</div>
</body>
</html>