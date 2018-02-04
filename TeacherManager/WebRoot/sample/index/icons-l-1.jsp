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

<!--修正IE6不支持PNG图start-->
<style>
img {
	behavior:url("<%=path%>/libs/js/method/pngFix/pngbehavior.htc");
}
</style>
<!--修正IE6不支持PNG图end-->

<style>
.icons_style1 img{
	width:80px;
	height:80px;
}
.icons_style1 td{
text-align:center;
}
</style>
</head>
<body>
使用大图标时，直接引入图片。
<div class="icons_style1">
	<table class="tableStyle">
	<tr>
		<th colspan="6">风格一，图标位置：libs/icons/png目录</th>
		
	</tr>
	<tr>
		<td><img src="<%=path%>/libs/icons/png/01.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/02.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/03.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/04.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/05.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/06.png" /></td>
	</tr>
	<tr>
		<td>01.png</td>
		<td>02.png</td>
		<td>03.png</td>
		<td>04.png</td>
		<td>05.png</td>
		<td>06.png</td>
	</tr>
	<tr>
		<td><img src="<%=path%>/libs/icons/png/07.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/08.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/09.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/10.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/11.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/12.png" /></td>
	</tr>
	<tr>
		<td>07.png</td>
		<td>08.png</td>
		<td>09.png</td>
		<td>10.png</td>
		<td>11.png</td>
		<td>12.png</td>
	</tr>
	<tr>
		<td><img src="<%=path%>/libs/icons/png/13.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/14.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/15.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/16.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/17.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/18.png" /></td>
	</tr>
	<tr>
		<td>13.png</td>
		<td>14.png</td>
		<td>15.png</td>
		<td>16.png</td>
		<td>17.png</td>
		<td>18.png</td>
	</tr>
	<tr>
		<td><img src="<%=path%>/libs/icons/png/19.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/20.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/21.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/22.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/23.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/24.png" /></td>
	</tr>
	<tr>
		<td>19.png</td>
		<td>20.png</td>
		<td>21.png</td>
		<td>22.png</td>
		<td>23.png</td>
		<td>24.png</td>
	</tr>
	<tr>
		<td><img src="<%=path%>/libs/icons/png/25.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/26.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/27.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/28.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/29.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/30.png" /></td>
	</tr>
	<tr>
		<td>25.png</td>
		<td>26.png</td>
		<td>27.png</td>
		<td>28.png</td>
		<td>29.png</td>
		<td>30.png</td>
	</tr>
	<tr>
		<td><img src="<%=path%>/libs/icons/png/31.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/32.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/33.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/34.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/35.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/36.png" /></td>
	</tr>
	<tr>
		<td>31.png</td>
		<td>32.png</td>
		<td>33.png</td>
		<td>34.png</td>
		<td>35.png</td>
		<td>36.png</td>
	</tr>
	<tr>
		<td><img src="<%=path%>/libs/icons/png/37.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/38.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/39.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/40.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/41.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/42.png" /></td>
	</tr>
	<tr>
		<td>37.png</td>
		<td>38.png</td>
		<td>39.png</td>
		<td>40.png</td>
		<td>41.png</td>
		<td>42.png</td>
	</tr>
	<tr>
		<td><img src="<%=path%>/libs/icons/png/43.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/44.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/45.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/46.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/47.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/48.png" /></td>
	</tr>
	<tr>
		<td>43.png</td>
		<td>44.png</td>
		<td>45.png</td>
		<td>46.png</td>
		<td>47.png</td>
		<td>48.png</td>
	</tr>
	<tr>
		<td><img src="<%=path%>/libs/icons/png/49.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/50.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/51.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/52.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/53.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/54.png" /></td>
	</tr>
	<tr>
		<td>49.png</td>
		<td>50.png</td>
		<td>51.png</td>
		<td>52.png</td>
		<td>53.png</td>
		<td>54.png</td>
	</tr>
	<tr>
		<td><img src="<%=path%>/libs/icons/png/55.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/56.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/57.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/58.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/59.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/60.png" /></td>
	</tr>
	<tr>
		<td>55.png</td>
		<td>56.png</td>
		<td>57.png</td>
		<td>58.png</td>
		<td>59.png</td>
		<td>60.png</td>
	</tr>
	<tr>
		<td><img src="<%=path%>/libs/icons/png/61.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/62.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/63.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/64.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/65.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/66.png" /></td>
	</tr>
	<tr>
		<td>61.png</td>
		<td>62.png</td>
		<td>63.png</td>
		<td>64.png</td>
		<td>65.png</td>
		<td>66.png</td>
	</tr>
	<tr>
		<td><img src="<%=path%>/libs/icons/png/67.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/68.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/69.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/70.png" /></td>
		<td><img src="<%=path%>/libs/icons/png/71.png" /></td>
		<td></td>
	</tr>
	<tr>
		<td>67.png</td>
		<td>68.png</td>
		<td>69.png</td>
		<td>70.png</td>
		<td>71.png</td>
		<td></td>
	</tr>
	</table>
</div>		
</body>
</html>