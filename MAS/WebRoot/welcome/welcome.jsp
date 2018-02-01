<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<title>欢迎使用专业评估系统</title>
		<link
			href="${pageContext.request.contextPath}/welcome/css/bootstrap.css"
			rel='stylesheet' type='text/css' />
		<link href="${pageContext.request.contextPath}/welcome/css/style.css"
			rel='stylesheet' type='text/css' />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript">
addEventListener("load", function() {
	setTimeout(hideURLbar, 0);
}, false);
function hideURLbar() {
	window.scrollTo(0, 1);
}</script>
		<script
			src="${pageContext.request.contextPath}/welcome/js/jquery-1.11.0.min.js">
</script>
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/welcome/css/flexslider.css"
			type="text/css" media="screen" />
		<script
			src="${pageContext.request.contextPath}/welcome/js/modernizr.js">
</script>
		<!--Start-smoth-scrolling-->
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/welcome/js/move-top.js">
</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/welcome/js/easing.js">
</script>
    <script type="text/javascript">
setTimeout("window.location.href='user_init.action'", 1500);
</script>
		<link href="css/animate.css" rel="stylesheet" type="text/css"
			media="all">
		<script src="js/wow.min.js">
</script>
		<script>
new WOW().init();
</script>
		<!--animated-css-->
	</head>
	<body>
		<div height="800px"class="container">
			<script>
$("span.menu").click(function() {
	$("ul.navig").slideToggle("slow", function() {
		// Animation complete.
		});
});
</script>
			<div class="clearfix">
			</div>
		</div>

		<div class="banner">
			<div class="slider">
				<section class="slider">
				
				</section>
				<script>
window.jQuery
		|| document
				.write('<script src="js/libs/jquery-1.7.min.js">\x3C/script>')</script>
				<!--FlexSlider-->
				<script defer src="js/jquery.flexslider.js">
</script>
				<script type="text/javascript">
$(function() {
	SyntaxHighlighter.all();
});
$(window).load(function() {
	$('.flexslider').flexslider( {
		animation : "slide",
		start : function(slider) {
			$('body').removeClass('loading');
		}
	});
});
</script>
			</div>
		</div>

		<div class="footer" style="height: 140%">
			<div class="container">
				<div class="footer-text">
					<span> &copy 2017 西北农林科技大学 <a
						href="http://www.nwsuaf.edu.cn/" target="_blank" title="西北农林科技大学">西北农林科技大学</a>
					</span>
				</div>
			</div>
			<a href="#home" id="toTop" class="scroll" style="display: block;">
				<span id="toTopHover" style="opacity: 1;"> </span> </a>
		</div>
	</body>
</html>