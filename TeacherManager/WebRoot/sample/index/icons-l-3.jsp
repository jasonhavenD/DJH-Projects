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
	width:64px;
	height:64px;
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
		<th colspan="6">风格三，图标位置：libs/icons/png_64目录</th>
		
	</tr>
	<tr>
		<td><img src="<%=path%>/libs/icons/png_64/01.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/02.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/03.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/04.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/05.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/06.png" /></td>
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
		<td><img src="<%=path%>/libs/icons/png_64/07.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/08.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/09.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/10.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/11.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/12.png" /></td>
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
		<td><img src="<%=path%>/libs/icons/png_64/13.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/14.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/15.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/16.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/17.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/18.png" /></td>
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
		<td><img src="<%=path%>/libs/icons/png_64/19.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/20.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/21.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/22.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/23.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/24.png" /></td>
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
		<td><img src="<%=path%>/libs/icons/png_64/25.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/26.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/27.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/28.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/29.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/30.png" /></td>
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
		<td><img src="<%=path%>/libs/icons/png_64/31.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/32.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/33.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/34.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/35.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/36.png" /></td>
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
		<td><img src="<%=path%>/libs/icons/png_64/37.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/38.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/39.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/40.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/41.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/42.png" /></td>
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
		<td><img src="<%=path%>/libs/icons/png_64/43.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/44.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/45.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/46.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/47.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/48.png" /></td>
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
		<td><img src="<%=path%>/libs/icons/png_64/49.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/50.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/51.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/52.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/53.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/54.png" /></td>
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
		<td><img src="<%=path%>/libs/icons/png_64/55.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/56.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/57.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/58.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/59.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/60.png" /></td>
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
		<td><img src="<%=path%>/libs/icons/png_64/61.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/62.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/63.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/64.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/65.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/66.png" /></td>
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
		<td><img src="<%=path%>/libs/icons/png_64/67.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/68.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/69.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/70.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/71.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/72.png" /></td>
	</tr>
	<tr>
		<td>67.png</td>
		<td>68.png</td>
		<td>69.png</td>
		<td>70.png</td>
		<td>71.png</td>
		<td>72.png</td>
	</tr>
	<tr>
		<td><img src="<%=path%>/libs/icons/png_64/73.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/74.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/75.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/76.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/77.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/78.png" /></td>
	</tr>
	<tr>
		<td>73.png</td>
		<td>74.png</td>
		<td>75.png</td>
		<td>76.png</td>
		<td>77.png</td>
		<td>78.png</td>
	</tr>
	<tr>
		<td><img src="<%=path%>/libs/icons/png_64/79.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/80.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/81.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/82.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/83.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/84.png" /></td>
	</tr>
	<tr>
		<td>79.png</td>
		<td>80.png</td>
		<td>81.png</td>
		<td>82.png</td>
		<td>83.png</td>
		<td>84.png</td>
	</tr>
	<tr>
		<td><img src="<%=path%>/libs/icons/png_64/85.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/86.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/87.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/88.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/89.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/90.png" /></td>
	</tr>
	<tr>
		<td>85.png</td>
		<td>86.png</td>
		<td>87.png</td>
		<td>88.png</td>
		<td>89.png</td>
		<td>90.png</td>
	</tr>
	<tr>
		<td><img src="<%=path%>/libs/icons/png_64/91.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/92.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/93.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/94.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/95.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/96.png" /></td>
	</tr>
	<tr>
		<td>91.png</td>
		<td>92.png</td>
		<td>93.png</td>
		<td>94.png</td>
		<td>95.png</td>
		<td>96.png</td>
	</tr>
	<tr>
		<td><img src="<%=path%>/libs/icons/png_64/97.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/98.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/99.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/100.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/101.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/102.png" /></td>
	</tr>
	<tr>
		<td>97.png</td>
		<td>98.png</td>
		<td>99.png</td>
		<td>100.png</td>
		<td>101.png</td>
		<td>102.png</td>
	</tr>
	<tr>
		<td><img src="<%=path%>/libs/icons/png_64/103.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/104.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/105.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/106.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/107.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/108.png" /></td>
	</tr>
	<tr>
		<td>103.png</td>
		<td>104.png</td>
		<td>105.png</td>
		<td>106.png</td>
		<td>107.png</td>
		<td>108.png</td>
	</tr>
	<tr>
		<td><img src="<%=path%>/libs/icons/png_64/109.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/110.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/111.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/112.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/113.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/114.png" /></td>
	</tr>
	<tr>
		<td>109.png</td>
		<td>110.png</td>
		<td>111.png</td>
		<td>112.png</td>
		<td>113.png</td>
		<td>114.png</td>
	</tr>
	<tr>
		<td><img src="<%=path%>/libs/icons/png_64/115.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/116.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/117.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/118.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/119.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/120.png" /></td>
	</tr>
	<tr>
		<td>115.png</td>
		<td>116.png</td>
		<td>117.png</td>
		<td>118.png</td>
		<td>119.png</td>
		<td>120.png</td>
	</tr>
	<tr>
		<td><img src="<%=path%>/libs/icons/png_64/121.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/122.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/123.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/124.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/125.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/126.png" /></td>
	</tr>
	<tr>
		<td>121.png</td>
		<td>122.png</td>
		<td>123.png</td>
		<td>124.png</td>
		<td>125.png</td>
		<td>126.png</td>
	</tr>
	<tr>
		<td><img src="<%=path%>/libs/icons/png_64/127.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/128.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/129.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/130.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/131.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/132.png" /></td>
	</tr>
	<tr>
		<td>127.png</td>
		<td>128.png</td>
		<td>129.png</td>
		<td>130.png</td>
		<td>131.png</td>
		<td>132.png</td>
	</tr>
	<tr>
		<td><img src="<%=path%>/libs/icons/png_64/133.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/134.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/135.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/136.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/137.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/138.png" /></td>
	</tr>
	<tr>
		<td>133.png</td>
		<td>134.png</td>
		<td>135.png</td>
		<td>136.png</td>
		<td>137.png</td>
		<td>138.png</td>
	</tr>
	<tr>
		<td><img src="<%=path%>/libs/icons/png_64/139.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/140.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/141.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/142.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/143.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/144.png" /></td>
	</tr>
	<tr>
		<td>139.png</td>
		<td>140.png</td>
		<td>141.png</td>
		<td>142.png</td>
		<td>143.png</td>
		<td>144.png</td>
	</tr>
	<tr>
		<td><img src="<%=path%>/libs/icons/png_64/145.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/146.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/147.png" /></td>
		<td><img src="<%=path%>/libs/icons/png_64/148.png" /></td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td>145.png</td>
		<td>146.png</td>
		<td>147.png</td>
		<td>148.png</td>
		<td></td>
		<td></td>
	</tr>
	</table>
</div>		
</body>
</html>