<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<!--[if IE 8]>			<html class="ie ie8"> <![endif]-->
<!--[if IE 9]>			<html class="ie ie9"> <![endif]-->
<!--[if gt IE 9]><!-->	<html> <!--<![endif]-->
	<head>
		<meta charset="utf-8" />
		<title>资讯文章内容页——厦门光服科技有限公司</title>
		<meta name="keywords" content="HTML5,CSS3,Template" />
		<meta name="description" content="" />

		<!-- mobile settings -->
		<meta name="viewport" content="width=device-width, maximum-scale=1, initial-scale=1, user-scalable=0" />
		<!--[if IE]><meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'><![endif]-->

		<!-- WEB FONTS : use %7C instead of | (pipe) >
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400%7CRaleway:300,400,500,600,700%7CLato:300,400,400italic,600,700" rel="stylesheet" type="text/css" /-->

		<!-- CORE CSS -->
		<link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		
		<!-- THEME CSS -->
		<link href="assets/css/essentials.css" rel="stylesheet" type="text/css" />
		<link href="assets/css/layout.css" rel="stylesheet" type="text/css" />

		<!-- PAGE LEVEL SCRIPTS -->
		<link href="assets/css/header-1.css" rel="stylesheet" type="text/css" />
		<link href="assets/css/layout-shop.css" rel="stylesheet" type="text/css" />
		<link href="assets/css/color_scheme/green.css" rel="stylesheet" type="text/css" id="color_scheme" />
		
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
		data-background="assets/images/boxed_background/1.jpg"
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

					<!-- <h1>公司简介</h1> 不确定这里是不是标题，因为没有公司简介、招商政策等type名-->
                    <h1><s:property value="infomation.title"/></h1>
					<!-- breadcrumbs -->
					<ol class="breadcrumb">
						<li <!-- HOME --> <a href="./HomePage_retreiveAll.action">首 页</a>
								</li>
							<!-- 需要知道该页内容的id号 ,可以默认就是公司简介的id号,这里没有关于我们的页面-->
						<li><a href="InfomationAction_getInfoDetail.action?informationid=">关于我们</a></li>
						<!-- <li class="active">公司简介</li> -->
						<li class="active"><s:property value="infomation.title"/></li>
					</ol><!-- /breadcrumbs -->

				</div>
			</section>
			<!-- /PAGE HEADER -->




			<!-- -->
	
	
	
	
				<div class="container padding-top-40 padding-bottom-40 ">
					<div class="row">

						<!-- RIGHT -->
						
						<div class="col-lg-9 col-md-9 col-sm-9 col-lg-push-3 col-md-push-3 col-sm-push-3">
			

					<div class="text-center margin-top-10 clearfix">
						<h1 class="font-cinzel-decorative size-25 weight-300 nomargin-bottom"><s:property value="infomation.title"/></h1>
						<!--  <h1 class="font-cinzel-decorative size-25 weight-300 nomargin-bottom">公司简介 或其他文章资讯标题</h1>-->
						
						<hr />
					</div>



							<div class="tab-content padding-top-20">
								<div role="tabpanel" class="tab-pane fade in active" id="description">
	     							<div style="text-indent:2em;line-height:2">
	     							<p><s:property value="infomation.informationcontent"/></p>
									<!-- <p>这是公司简介、行业资讯、帮助中心等文章发布系统的内容页面，“关于我们”栏目的公司简介、招商政策、发展远景、联系我们 等是单页内容，栏目分类需可在后台添加、删除、修改。“资源资讯”栏目的资源下载、新闻公告、行业资讯、帮助中心等是列表页内容，栏目分类同样需可在后台添加、删除、修改。</p> -->
									
									<!-- <p><img class="pull-left img-responsive" src="assets/images/demo/content_slider/10-min.jpg" alt="">	</p>	-->
									<p><img class="pull-left img-responsive"
								src="<s:property value='information.attchmentspath' />" alt="">
							</a>						
									<!-- <p>文章资讯内容，支持图文混排</p> -->
									<!-- 此处加了出版日期和出版id和hits -->
									<p><s:property value="information.publishuserid"/>&nbsp;&nbsp;&nbsp;<s:property value="information.publishdatetime"/>
									<s:property value="information.hits"/></p>
									<!--  <p>这是公司简介、行业资讯、帮助中心等文章发布系统的内容页面，“关于我们”栏目的公司简介、招商政策、发展远景、联系我们是单页内容，栏目分类需可在后台添加、删除、修改。“资源资讯”栏目的资源下载、新闻公告、行业资讯、帮助中心是列表页内容，栏目分类同样需可在后台添加、删除、修改。</p>-->
					
	
									
									</div>
								</div>
							</div>

			
			</div>


						<!-- LEFT -->
						<div class="col-lg-3 col-md-3 col-sm-3 col-lg-pull-9 col-md-pull-9 col-sm-pull-9">

							<!-- CATEGORIES -->
							<div class="side-nav margin-bottom-40">
								<div class="side-nav-head">
									<button class="fa fa-bars"></button>
									<h4>关于我们</h4>
								</div>
								<ul class="list-group list-group-bordered list-group-noicon uppercase">
								<!-- 不知道这几页的id号 -->
									<li class="list-group-item "><a  href="InfomationAction_getInfoDetail.action?informationid=">公司简介</a></li>
									<li class="list-group-item "><a  href="InfomationAction_getInfoDetail.action?informationid=">招商政策</a></li>
									<li class="list-group-item "><a  href="InfomationAction_getInfoDetail.action?informationid=">发展愿景</a></li>
									<li class="list-group-item "><a  href="InfomationAction_getInfoDetail.action?informationid=">联系我们</a></li>
								</ul>
							</div>
							
							
							<div class="side-nav margin-bottom-40">
								<div class="side-nav-head">
									<button class="fa fa-bars"></button>
									<h4>资源资讯</h4>
								</div>
                                <!-- 不知道下列几项的type号 -->
								<ul class="list-group list-group-bordered list-group-noicon uppercase">
									<li class="list-group-item "><a  href="InfomationAction_getInfoList.action?type=">资源下载</a></li>
									<li class="list-group-item "><a  href="InfomationAction_getInfoList.action?type=">新闻公告</a></li>
									<li class="list-group-item "><a  href="InfomationAction_getInfoList.action?type=">行业资讯</a></li>
									<li class="list-group-item "><a  href="InfomationAction_getInfoList.action?type=">帮助中心</a></li>
								</ul>
							</div>							
							<!-- /CATEGORIES -->





								<!-- BANNER ROTATOR --------------------------->
							<div class="owl-carousel buttons-autohide controlls-over margin-bottom-10 text-center" data-plugin-options='{"singleItem": true,  "transitionStyle":"fadeUp"}'>
								<a href="#">
									<img class="img-responsive" src="assets/images/demo/shop/banners/sq_1.png" width="270" height="200" alt="">
								</a>

							</div>


							<!-- /BANNER ROTATOR -->
							
							
							<!-- HTML BLOCK -------------------------------
							<div class="margin-bottom-60">
								<h4>HTML BLOCK</h4>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras non placerat mi. Etiam non tellus eunit.</p>

								<form action="#" role="form" method="post">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-envelope"></i></span>
										<input type="email" id="email" name="email" class="form-control required" placeholder="Enter your Email">
										<span class="input-group-btn">
											<button class="btn btn-success" type="submit"><i class="glyphicon glyphicon-send"></i></button>
										</span>
									</div>
								</form>

							</div>
							<!-- /HTML BLOCK -->

						</div>

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
		</div><!-- /PRELOADER -->


		<!-- JAVASCRIPT FILES -->
		<script type="text/javascript">var plugin_path = 'assets/plugins/';</script>
		<script type="text/javascript" src="assets/plugins/jquery/jquery-2.1.4.min.js"></script>

		<script type="text/javascript" src="assets/js/scripts.js"></script>


		<!-- PAGE LEVEL SCRIPTS -->
		<script type="text/javascript" src="assets/js/view/demo.shop.js"></script>
	</body>
</html>