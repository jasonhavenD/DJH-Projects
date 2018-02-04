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
<div class="box4" noTitle="true">
			<div id="cusBoxContent1">
				<div class="subtitle"><div class="subtitle_con">一级栏目1</div></div>
				<ul>
				<li><a href="<%=path%>/sample/layout/nav-single-content1.jsp" target="frmrightChild"><span class="text_slice">二级栏目1</span></a></li>
				<li><a href="<%=path%>/sample/layout/nav-single-content2.jsp" target="frmrightChild"><span class="text_slice">二级栏目2</span></a></li>
				<li><a href="<%=path%>/sample/layout/nav-single-content1.jsp" target="frmrightChild"><span class="text_slice">二级栏目3</span></a></li>
				</ul>
				<div class="subtitle"><div class="subtitle_con">一级栏目2</div></div>
				<ul>
				<li><a href="<%=path%>/sample/layout/nav-single-content2.jsp" target="frmrightChild"><span class="text_slice">二级栏目4</span></a></li>
				<li><a href="<%=path%>/sample/layout/nav-single-content1.jsp" target="frmrightChild"><span class="text_slice">二级栏目5</span></a></li>
				<li><a href="<%=path%>/sample/layout/nav-single-content2.jsp" target="frmrightChild"><span class="text_slice">二级栏目6</span></a></li>
				</ul>
				<div class="subtitle"><div class="subtitle_con">一级栏目3</div></div>
				<ul>
				<li><a href="<%=path%>/sample/layout/nav-single-content1.jsp" target="frmrightChild"><span class="text_slice">二级栏目7</span></a></li>
				<li><a href="<%=path%>/sample/layout/nav-single-content2.jsp" target="frmrightChild"><span class="text_slice">二级栏目8</span></a></li>
				<li><a href="<%=path%>/sample/layout/nav-single-content1.jsp" target="frmrightChild"><span class="text_slice">二级栏目9</span></a></li>
				</ul>
				<div class="subtitle"><div class="subtitle_con">一级栏目3</div></div>
				<ul>
				<li><a href="<%=path%>/sample/layout/nav-single-content1.jsp" target="frmrightChild"><span class="text_slice">二级栏目7</span></a></li>
				<li><a href="<%=path%>/sample/layout/nav-single-content2.jsp" target="frmrightChild"><span class="text_slice">二级栏目8</span></a></li>
				<li><a href="<%=path%>/sample/layout/nav-single-content1.jsp" target="frmrightChild"><span class="text_slice">二级栏目9</span></a></li>
				</ul>
				
			</div>
		</div>
</body>
</html>