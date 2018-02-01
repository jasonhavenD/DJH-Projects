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
		<title>用户登录页面——厦门光服科技有限公司</title>
		<meta name="keywords" content="HTML5,CSS3,Template" />
		<meta name="description" content="" />

		<!-- mobile settings -->
		<meta name="viewport"
			content="width=device-width, maximum-scale=1, initial-scale=1, user-scalable=0" />
		<!--[if IE]><meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'><![endif]-->

		<!-- WEB FONTS : use %7C instead of | (pipe) >
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400%7CRaleway:300,400,500,600,700%7CLato:300,400,400italic,600,700" rel="stylesheet" type="text/css" /-->

		<!-- CORE CSS -->
		<link href="assets/plugins/bootstrap/css/bootstrap.min.css"
			rel="stylesheet" type="text/css" />

		<!-- THEME CSS -->
		<link href="assets/css/essentials.css" rel="stylesheet"
			type="text/css" />
		<link href="assets/css/layout.css" rel="stylesheet" type="text/css" />

		<!-- PAGE LEVEL SCRIPTS -->
		<link href="assets/css/header-1.css" rel="stylesheet" type="text/css" />
		<link href="assets/css/layout-shop.css" rel="stylesheet"
			type="text/css" />
		<link href="assets/css/color_scheme/green.css" rel="stylesheet"
			type="text/css" id="color_scheme" />
		<!--script type="text/javascript" src="../js/logorreg.js"></script-->
		<script type="text/javascript" src="../js/md5.js"></script>
		<!-- 加密算法 -->
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
	<body class="smoothscroll enable-animation">


		<!-- wrapper -->
		<div id="wrapper">

			<!-- Top Bar -->
			<div id="topBar" class="dark">
				<div class="container">

					<!-- right -->
					<ul class="top-links list-inline pull-right">
						<li class="text-welcome hidden-xs">
							Welcome to goofoo,
							<strong>会员姓名</strong>
						</li>
						<li>
							<a class="dropdown-toggle no-text-underline"
								data-toggle="dropdown" href="#"><i
								class="fa fa-user hidden-xs"></i> 会员中心</a>
						</li>
						<li class="dropdown-toggle no-text-underline">
							<a href="./loginForm.action">登录</a>
						</li>
						<li class="dropdown-toggle no-text-underline">
							<a href="./registerForm.action">注册</a>
						</li>
					</ul>

					<!-- left -->
					<ul class="top-links list-inline">
						<li class="dropdown-toggle no-text-underline">
							<a href="#">光服水电 未来无限</a>
						</li>
					</ul>
				</div>
			</div>
			<!-- /Top Bar -->

			<!-- 
				AVAILABLE HEADER CLASSES

				Default nav height: 96px
				.header-md 		= 70px nav height
				.header-sm 		= 60px nav height

				.noborder 		= remove bottom border (only with transparent use)
				.transparent	= transparent header
				.translucent	= translucent header
				.sticky			= sticky header
				.static			= static header
				.dark			= dark header
				.bottom			= header on bottom
				
				shadow-before-1 = shadow 1 header top
				shadow-after-1 	= shadow 1 header bottom
				shadow-before-2 = shadow 2 header top
				shadow-after-2 	= shadow 2 header bottom
				shadow-before-3 = shadow 3 header top
				shadow-after-3 	= shadow 3 header bottom

				.clearfix		= required for mobile menu, do not remove!

				Example Usage:  class="clearfix sticky header-sm transparent noborder"
			-->
			<div id="header" class="sticky shadow-after-3 clearfix">

				<!-- TOP NAV -->
				<header id="topNav">
				<div class="container">

					<!-- Mobile Menu Button -->
					<button class="btn btn-mobile" data-toggle="collapse"
						data-target=".nav-main-collapse">
						<i class="fa fa-bars"></i>
					</button>

					<!-- BUTTONS -->



					<ul class="pull-right nav nav-pills nav-second-main">
						<!-- SEARCH -->
						<li class="search">
							<a href="javascript:;"> <i class="fa fa-search"></i> </a>
							<div class="search-box">
								<form action="page-search-result-1.html" method="get">
									<div class="input-group">
										<input type="text" name="src" placeholder="请输入关键词"
											class="form-control" />
										<span class="input-group-btn">
											<button class="btn btn-primary" type="submit">
												搜 索
											</button> </span>
									</div>
								</form>
							</div>
						</li>
						<!-- /SEARCH -->

						<!-- QUICK SHOP CART -->
						<li class="quick-cart">
							<a href="#"> <span
								class="badge badge-aqua btn-xs badge-corner">3</span> <i
								class="fa fa-shopping-cart"></i> </a>
							<div class="quick-cart-box">
								<h4>
									我的购物车
								</h4>

								<div class="quick-cart-wrapper">

									<a href="#">
										<!-- cart item --> <img
											src="assets/images/demo/people/300x300/4-min.jpg" width="45"
											height="45" alt="" />
										<h6>
											照明产品名称标题
										</h6>
										<h6>
											¥ 6.50
											<span>x2</span>
											<small>删除</small>
										</h6> </a>
									<!-- /cart item -->

									<a href="#">
										<!-- cart item --> <img
											src="assets/images/demo/people/300x300/5-min.jpg" width="45"
											height="45" alt="" />
										<h6>
											电工产品名称标题
										</h6>
										<h6>
											¥ 12.50
											<span>x1</span>
											<small>删除</small>
										</h6> </a>
									<!-- /cart item -->

									<!-- cart no items example -->

									<a class="text-center" href="#"> 共3件商品 &nbsp; 共计:<strong>¥
											25.50</strong> </a>


								</div>

								<!-- quick cart footer -->
								<div class="quick-cart-footer clearfix">
									<a href="4.html" class="btn btn-primary btn-xs pull-right">去购物车查看详情</a>
									<!--span class="pull-left"><small>共3件商品    共计:<strong>￥25.50</strong></samll></span-->
								</div>
								<!-- /quick cart footer -->

							</div>
						</li>
						<!-- /QUICK SHOP CART -->

					</ul>
					<!-- /BUTTONS -->

					<!-- Logo -->
					<a class="logo pull-left" href="index.html"> <img
							src="assets/images/logo_dark.png" alt="" /> </a>
					<a class="logo pull-left" href="#"> <img
							src="assets/images/gf_50px.png" alt="" /> </a>
					<!-- 
							Top Nav 
							
							AVAILABLE CLASSES:
							submenu-dark = dark sub menu
						-->
					<div class="navbar-collapse pull-right nav-main-collapse collapse">
						<nav class="nav-main">

						<ul id="topMain" class="nav nav-pills nav-main">
							<li class="dropdown">
								<!-- HOME -->
								<a href="./homePage.action">首 页</a>
							</li>
							<li class="dropdown">
								<!-- PAGES -->
								<a class="dropdown-toggle" href="#">关于我们 </a>
								<ul class="dropdown-menu">
									<li class="dropdown">
										<a href="#">公司简介</a>
									</li>
									<li class="dropdown">
										<a href="#">招商政策</a>
									</li>
									<li class="dropdown">
										<a href="#">发展愿景</a>
									</li>
								</ul>
							</li>
							<li class="dropdown">
								<!-- FEATURES -->
								<a class="dropdown-toggle" href="2.html">产品中心</a>
								<ul class="dropdown-menu">

									<s:iterator value="lstProducttypesL1" id='producttypesL1'>
										<li class="dropdown">
											<a class="dropdown-toggle" href="#"><i class="et-browser"></i>
												<s:property value="#producttypesL1.producttypename" /> <s:property
													value="#producttypesL1.producttypeid" /> <s:property
													value="hmIdL1AndProducttypesL2.value.size" /> <s:property
													value="hmIdL1AndProducttypesL2.get(#producttypesL1.producttypeid).size" />
											</a>
											<ul class="dropdown-menu">
												<s:iterator
													value="hmIdL1AndProducttypesL2.get(#producttypesL1.producttypeid)"
													id='entryValue'>
													<li>
														<a href="2.html"><s:property
																value="#entryValue.producttypename" />
														</a>
													</li>
												</s:iterator>
											</ul>
										</li>
									</s:iterator>
								</ul>
							</li>

							<li class="dropdown">
								<!-- BLOG -->
								<a class="dropdown-toggle" href="#">资源资讯</a>
								<ul class="dropdown-menu">
									<li class="dropdown">
										<a href="#">资源下载</a>
									</li>
									<li class="dropdown">
										<a href="#">新闻公告</a>
									</li>
									<li class="dropdown">
										<a href="#">行业资讯</a>
									</li>
									<li class="dropdown">
										<a href="#">帮助中心</a>
									</li>
								</ul>
							</li>
							<li class="dropdown">
								<!-- SHOP -->
								<a href="#">联系我们</a>
							</li>

						</ul>

						</nav>
					</div>

				</div>
				</header>
				<!-- /Top Nav -->

			</div>

			<!----------------------------------------------------------中间内容开始，以上是顶部内容---------------------------------------------------------------------------------------->



			<!-- -->
			<section style="background:url('assets/images/demo/wall2.jpg')">

			<div class="display-table">
				<div class="display-table-cell vertical-align-middle">

					<div class="container">

						<div class="row">

							<div class="col-md-6 col-md-offset-3">

								<!-- ALERT -->
								<!--
									<div class="alert alert-mini alert-danger margin-bottom-30">
										<strong>Oh snap!</strong> Login Incorrect!
									</div>
									-->
								<!-- /ALERT -->

								<!-- login form -->
								<form action="loginAction.action" method="post"
									class="sky-form boxed">
									<header>
									<i class="fa fa-users"></i> 会员登录
									</header>

									<fieldset class="nomargin">
										<label class="radio">
											<input type="radio" name="state" value="1">
											<i></i>我是普通会员
										</label>
										<label class="radio">
											<input type="radio" name="state" value="2">
											<i></i>我是认证经销商
										</label>
										<label class="radio">
											<input type="radio" name="state" value="3">
											<i></i>我是物流中心
										</label>
										<div align="right">
											没有账号？
											<a href="./registerForm.action">点击这里注册</a>
										</div>
										<label class="label margin-top-20">
											用户名：
										</label>
										<label class="input">
											<i class="ico-append fa fa-envelope"></i>
											<input name="username" id="username">
											<span class="tooltip tooltip-top-right">请输入您的用户名</span>
										</label>

										<label class="label margin-top-20">
											密码：
										</label>
										<label class="input">
											<i class="ico-append fa fa-lock"></i>
											<input type="password" name="password" id="password">
											<b class="tooltip tooltip-top-right">请输入密码</b>
										</label>


										<label class="label margin-top-20">
											验证码：
										</label>
										<label id="passwordwarn"></label>
										<label class="input">
											<i class="ico-append fa fa-lock"></i>
											<input type="password" id="validatecode"
												onblur="validatePicture()">
											<b class="tooltip tooltip-top-right">请输入以下随机验证码</b>
										</label>

										<div class="row">
											<div class="col col-md-9">
												<label class="input">
													<img alt="验证码" id="imageCode"
														src="../IdentifyingCode_getPictureCode" class="pin">
													<a href="javascript:;"
														onclick=
	document.getElementById('imageCode').src = '../IdentifyingCode_getPictureCode?' + new Date();
>看不清楚？换一张</a>
												</label>
											</div>
										</div>



									</fieldset>

									<footer class="celarfix">
									<button type="submit"
										class="btn btn-primary noradius pull-right"
										onclick=
	User_login();
>
										<i class="fa fa-check"></i> 登 录
									</button>
									<div class="login-forgot-password pull-left">
										<a href="page-password.html">忘记密码？</a>
									</div>
									</footer>
								</form>
								<!-- /login form -->

								<div class="margin-bottom-20 text-center">
									&ndash; 使用以下合作网站账号快捷登录 &ndash;
								</div>
								<div class="socials margin-top10 text-center">
									<!-- more buttons: ui-buttons.html -->
									<a href="#" class="social-icon social-facebook"
										data-toggle="tooltip" data-placement="top" title="淘宝/支付宝">
										<i class="icon-facebook"></i> <i class="icon-facebook"></i> </a>
									<a href="#" class="social-icon social-twitter"
										data-toggle="tooltip" data-placement="top" title="QQ"> <i
										class="icon-twitter"></i> <i class="icon-twitter"></i> </a>
									<a href="#" class="social-icon social-google"
										data-toggle="tooltip" data-placement="top" title="微信"> <i
										class="icon-google-plus"></i> <i class="icon-google-plus"></i>
									</a>
									<a href="#" class="social-icon social-google"
										data-toggle="tooltip" data-placement="top" title="新浪微博"> <i
										class="icon-google-plus"></i> <i class="icon-google-plus"></i>
									</a>

								</div>

							</div>

							<!--div class="col-xs-12 col-md-7 col-sm-7 col-lg-8 col-lg-pull-4 col-md-pull-5 col-sm-pull-5">


									<h2 class="size-20 text-center-xs">关于光服科技</h2>

									<p>公司简介、宣传语或广告词</p>
									<p>公司简介、宣传语或广告词</p>

									<ul class="list-unstyled login-features">
										<li>
											<i class="glyphicon glyphicon-road"></i> <strong>用户名</strong> 就是您的会员账号，请牢记您的用户名.
										</li>
										<li>
											<i class="glyphicon glyphicon-cog"></i> <strong>注册成功后</strong> 会员账号不能修改、删除.
										</li>
										<li>
											<i class="glyphicon glyphicon-tint"></i> <strong>会员手机号</strong>是唯一的 . 
										</li>
										<li>
											<i class="glyphicon glyphicon-screenshot"></i> <strong>Nam libero</strong> tempore, cum soluta nobis.
										</li>
										<li>
											<i class="glyphicon glyphicon-fire"></i> <strong>还没有账号？</strong> 请点击这里 <button type="button" class="btn btn-primary btn-sm"> 注 册 </button>.
										</li>
									</ul>

								</div-->

						</div>

					</div>

				</div>
			</div>

			</section>
			<!-- -->



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


			<!-- /PAGE HEADER -->








			<!----------------------------------------------------------中间内容结束，以下是底部内容---------------------------------------------------------------------------------------->
			<!-- FOOTER -->
			<footer id="footer">

			<div class="copyright">
				<div class="container">
					<ul class="pull-right nomargin list-inline mobile-block">

						<a href="http://www.miitbeian.gov.cn" target="_blank">闽ICP备16014139号</a>
					</ul>

					厦门光服科技有限公司 &copy;
					<a href="#"> 照明 </a>&bull;
					<a href="#"> 电工 </a>&bull;
					<a href="#"> 水暖 </a>
				</div>
			</div>

			</footer>
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
		<script type="text/javascript">var plugin_path = 'assets/plugins/';</script>
		<script type="text/javascript"
			src="assets/plugins/jquery/jquery-2.1.4.min.js"></script>

		<script type="text/javascript" src="assets/js/scripts.js"></script>


		<!-- PAGE LEVEL SCRIPTS -->
		<script type="text/javascript" src="assets/js/view/demo.shop.js"></script>
		<script type="text/javascript" src="../js/logorreg.js"></script>
	</body>
</html>
