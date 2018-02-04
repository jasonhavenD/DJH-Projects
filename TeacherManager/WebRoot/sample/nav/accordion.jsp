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

<!--纵向抽屉容器start-->
<script type="text/javascript" src="<%=path%>/libs/js/nav/accordion.js"></script>
<!--纵向抽屉容器end-->
</head>
<body>
	<div class="box1" panelWidth="800">
 	  <fieldset> 
     <legend>基本用法</legend>
     	<div class="accordition"  style="width:300px;">
			<a>第一部分</a>
			<div>
				内容1<br />
				内容1<br />
				内容1<br />
				内容1<br />
				内容1<br />
				内容1<br />
				内容1<br />
				内容1<br />
			</div>
			<a>第二部分</a>
			<div>
				内容2
			</div>
			<a>第三部分</a>
			<div>
				内容3
			</div>
		</div>
	  </fieldset>
 	  <div class="height_15"></div>
 	 
 	 <fieldset> 
     <legend>鼠标移入触发</legend>
     	<div class="accordition" style="width:300px;" hoverMode="true">
			<a>第一部分</a>
			<div>
				内容1<br />
				内容1<br />
				内容1<br />
				内容1<br />
				内容1<br />
				内容1<br />
				内容1<br />
				内容1<br />
			</div>
			<a>第二部分</a>
			<div>
				内容2
			</div>
			<a>第三部分</a>
			<div>
				内容3
			</div>
		</div>
	  </fieldset>
	 
	  
	 
 	 </div>
</body>
</html>