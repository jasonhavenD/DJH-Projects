<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>错误页面</title>

		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/admin-all.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/other.css" />
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/jquery-1.7.2.js">
</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/jquery-ui-1.8.22.custom.min.js">
</script>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />

	<style>
		*{margin:0;padding:0}
		body{font-family:"微软雅黑";background:#DAD9D7}
		img{border:none}
		a *{cursor:pointer}
		ul,li{list-style:none}
		table{table-layout:fixed;}
		table tr td{word-break:break-all; word-wrap:break-word;}
		
		a{text-decoration:none;outline:none}
		a:hover{text-decoration:underline}
		.cf:after{content: ".";display: block;height: 0;font-size: 0;clear:both;visibility: hidden;}
		.cf{zoom: 1;clear:both}
		.bg{width:100%;background:url("../img/404.jpg") no-repeat center top #DAD9D7;position:absolute;top:0;left:0;height:600px;overflow:hidden}
		.cont{margin:0 auto;width:500px;line-height:20px;}
		.c1{height:360px;text-align:center}
		.c1 .img1{margin-top:180px}
		.c1 .img2{margin-top:165px}
		.cont h2{text-align:center;color:#555;font-size:18px;font-weight:normal;height:35px}
		#bf{position:absolute;top:269px;left:0;width:100%}
		.bf1{margin:0 auto;width:99px;padding-left:32px}
		.bd{height:600px;overflow:hidden}
		#box{position:absolute;top:165px;left:0;width:100%;text-align:center}
		.bf1{margin:0 auto;width:99px;padding-left:32px}
	</style>
</head>
	<body>
		<div class="bg">
			<div class="cont">
				<div class="c1"><img src="../img/404.png" class="img1" /></div>
				<h2>您访问的页面出错，错误为：<s:property value="err"/></h2>	
			</div>
		</div>
	</body>
</html>
