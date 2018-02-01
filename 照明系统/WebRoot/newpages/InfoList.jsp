<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<!--[if IE 8]>			<html class="ie ie8"> <![endif]-->
<!--[if IE 9]>			<html class="ie ie9"> <![endif]-->
<!--[if gt IE 9]><!-->
<html>
<!--<![endif]-->
<head>
<meta charset="utf-8" />
<title>资讯文章列表页——厦门光服科技有限公司</title>
<meta name="keywords" content="HTML5,CSS3,Template" />
<meta name="description" content="" />

<!-- mobile settings -->
<meta name="viewport"
	content="width=device-width, maximum-scale=1, initial-scale=1, user-scalable=0" />
<!--[if IE]><meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'><![endif]-->

<!-- WEB FONTS : use %7C instead of | (pipe) >
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400%7CRaleway:300,400,500,600,700%7CLato:300,400,400italic,600,700" rel="stylesheet" type="text/css" /-->

<!-- CORE CSS -->
<link href="newpages/assets/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />

<!-- THEME CSS -->
<link href="newpages/assets/css/essentials.css" rel="stylesheet"
	type="text/css" />
<link href="newpages/assets/css/layout.css" rel="stylesheet"
	type="text/css" />

<!-- PAGE LEVEL SCRIPTS -->
<link href="newpages/assets/css/header-1.css" rel="stylesheet"
	type="text/css" />
<link href="newpages/assets/css/layout-shop.css" rel="stylesheet"
	type="text/css" />
<link href="newpages/assets/css/color_scheme/green.css" rel="stylesheet"
	type="text/css" id="color_scheme" />

<script type="text/javascript" src="newpages/assets/js/producttype.js"></script>

</head>

<!--
		AVAILABLE BODY CLASSES:
		
		smoothscroll 			= create a browser smooth scroll
		enable-animation		= enable WOW animations

		bg-grey					= grey background
		grain-grey				= grey grain background
		grain-blue				= blue grain background
		grain-green				= green grain background
		grain-blue				= blue grain background
		grain-orange			= orange grain background
		grain-yellow			= yellow grain background
		
		boxed 					= boxed layout
		pattern1 ... patern11	= pattern background
		menu-vertical-hide		= hidden, open on click
		
		BACKGROUND IMAGE [together with .boxed class]
		data-background="newpages/assets/images/boxed_background/1.jpg"
	-->
<body onload="productTypes()" class="smoothscroll enable-animation">

	<!-- HEAD -->
	<%@ include file="head.jsp"%>
	<!-- /HEAD -->

	<!----------------------------------------------------------中间内容开始，以上是顶部内容---------------------------------------------------------------------------------------->


	<!-- 
				PAGE HEADER 
				
				CLASSES:
					.page-header-xs	= 20px margins
					.page-header-md	= 50px margins
					.page-header-lg	= 80px margins
					.page-header-xlg= 130px margins
					.dark			= dark page header

					.shadow-before-1 	= shadow 1 header top
					.shadow-after-1 	= shadow 1 header bottom
					.shadow-before-2 	= shadow 2 header top
					.shadow-after-2 	= shadow 2 header bottom
					.shadow-before-3 	= shadow 3 header top
					.shadow-after-3 	= shadow 3 header bottom
			-->
	<section class="page-header page-header-xs">
		<div class="container">

			<h1>
				<s:property value='information.informationtitle' />
			</h1>

			<!-- breadcrumbs -->
			<ol class="breadcrumb">
				<li><a href="1.html">首 页</a></li>
				<li><a href="10.html">资源资讯</a></li>
				<li class="active"><s:property value='%{typename}' /></li>
			</ol>
			<!-- /breadcrumbs -->

		</div>
	</section>
	<!-- /PAGE HEADER -->




	<!-- -->

	<div class="container padding-top-40 padding-bottom-40 ">
		<div class="row">

			<!-- RIGHT -->

			<div
				class="col-lg-9 col-md-9 col-sm-9 col-lg-push-3 col-md-push-3 col-sm-push-3">


				<ul class="list-unstyled">

					<s:iterator value="%{infoList}" id='info'>
						<li
							class="clearfix border-bottom-dotted relative margin-bottom-10">
							<a class="clearfix size-16 block relative padding-10"
							href="./InfoDetailAction?infoid=<s:property value ='#info.informationid' />">
								<span class="pull-right text-black size-12"><s:date
										name='#info.publishdatetime' format="yyyy-MM-dd" /></span> <s:property
									value='#info.informationtitle' />
						</a>
					</s:iterator>

				</ul>

				<ul class="pagination pagination-sm">
					<li><a href="#">&laquo;</a></li>
					<li class="active"><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">&raquo;</a></li>
				</ul>

			</div>

			<!-- LEFT -->
			<%@ include file="infoleftside.jsp"%>
			<!-- /LEFT -->

		</div>

	</div>

	<!-- / -->



	<!----------------------------------------------------------中间内容结束，以下是底部内容---------------------------------------------------------------------------------------->

	<!-- FOOTER -->
	<%@ include file="foot.jsp"%>
	<!-- /FOOTER -->

	</div>
	<!-- /wrapper -->


	<!-- SCROLL TO TOP -->
	<a href="#" id="toTop"></a>


	<!-- PRELOADER -->
	<div id="preloader">
		<div class="inner">
			<span class="loader"></span>
		</div>
	</div>
	<!-- /PRELOADER -->


	<!-- JAVASCRIPT FILES -->
	<script type="text/javascript">
		var plugin_path = 'newpages/assets/plugins/';
	</script>
	<script type="text/javascript"
		src="newpages/assets/plugins/jquery/jquery-2.1.4.min.js"></script>

	<script type="text/javascript" src="newpages/assets/js/scripts.js"></script>


	<!-- PAGE LEVEL SCRIPTS -->
	<script type="text/javascript"
		src="newpages/assets/js/view/demo.shop.js"></script>
</body>
</html>