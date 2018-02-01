<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

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
<title>产品中心——厦门光服科技有限公司</title>
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
<link href="assets/css/essentials.css" rel="stylesheet" type="text/css" />
<link href="assets/css/layout.css" rel="stylesheet" type="text/css" />

<!-- PAGE LEVEL SCRIPTS -->
<link href="assets/css/header-1.css" rel="stylesheet" type="text/css" />
<link href="assets/css/layout-shop.css" rel="stylesheet" type="text/css" />
<link href="assets/css/color_scheme/green.css" rel="stylesheet"
	type="text/css" id="color_scheme" />
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
					<li class="text-welcome hidden-xs">Welcome to goofoo, <strong>会员姓名</strong></li>
					<li><a class="dropdown-toggle no-text-underline"
						data-toggle="dropdown" href="#"><i
							class="fa fa-user hidden-xs"></i> 会员中心</a></li>
					<li class="dropdown-toggle no-text-underline"><a href="./loginForm.actio">登陆</a></li>
					<li class="dropdown-toggle no-text-underline"><a href="./registerForm.actio">注册</a></li>
				</ul>

				<!-- left -->
				<ul class="top-links list-inline">
					<li class="dropdown-toggle no-text-underline"><a href="#">光服水电
							未来无限</a></li>
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
						<li class="search"><a href="javascript:;"> <i
								class="fa fa-search"></i>
						</a>
							<div class="search-box">
								<form action="page-search-result-1.html" method="get">
									<div class="input-group">
										<input type="text" name="src" placeholder="请输入关键词"
											class="form-control" /> <span class="input-group-btn">
											<button class="btn btn-primary" type="submit">搜 索</button>
										</span>
									</div>
								</form>
							</div></li>
						<!-- /SEARCH -->



						<!-- QUICK SHOP CART -->
						<li class="quick-cart"><a href="#"> <span
								class="badge badge-aqua btn-xs badge-corner"><s:property
										value='cartItems.size()' /></span> <i class="fa fa-shopping-cart"></i>
						</a>
							<div class="quick-cart-box">
								<h4>我的购物车</h4>

								<div class="quick-cart-wrapper">


									<!-- /cart item -->
									<s:iterator value="%{cartItems}" id="item">
										<!-- item -->
										<a href="#"> <!-- cart item --> <img
											src="<s:property value='#item.picturepath' />" width="45"
											height="45" alt="" />
											<h6>
												<s:property value='#item.picturetitle' />
											</h6>
											<h6>
												¥
												<s:property value='#item.price' />
												<span>x<s:property value='#item.count' /></span> <small>删除</small>
											</h6>
										</a>

									</s:iterator>

									<!-- /cart item -->

									<!-- cart no items example -->

									<a class="text-center" href="#"> 共<s:property
											value='cartItems.size()' />件商品 &nbsp; 共计:<strong>¥
											<s:property value='sum()' />
									</strong>
									</a>


								</div>

								<!-- quick cart footer -->
								<div class="quick-cart-footer clearfix">
									<a href="4.html" class="btn btn-primary btn-xs pull-right">去购物车查看详情</a>
									<!--span class="pull-left"><small>共3件商品    共计:<strong>￥25.50</strong></samll></span-->
								</div>
								<!-- /quick cart footer -->

							</div></li>
						<!-- /QUICK SHOP CART -->




					</ul>
					<!-- /BUTTONS -->

					<!-- Logo -->
					<a class="logo pull-left" href="index.html"> <img
						src="assets/images/logo_dark.png" alt="" />
					</a> <a class="logo pull-left" href="#"> <img
						src="assets/images/gf_50px.png" alt="" />
					</a>
					<!-- 
							Top Nav 
							
							AVAILABLE CLASSES:
							submenu-dark = dark sub menu
						-->
					<div class="navbar-collapse pull-right nav-main-collapse collapse">
						<nav class="nav-main">

							<ul id="topMain" class="nav nav-pills nav-main">
								<li class="dropdown">
									<!-- HOME --> <a href="./homePage.action">首 页</a>
								</li>
								<li class="dropdown">
									<!-- PAGES --> <a class="dropdown-toggle" href="#">关于我们 </a>
									<ul class="dropdown-menu">
										<li class="dropdown"><a href="#">公司简介</a></li>
										<li class="dropdown"><a href="#">招商政策</a></li>
										<li class="dropdown"><a href="#">发展愿景</a></li>
									</ul>
								</li>
								<li class="dropdown">
									<!-- FEATURES --> <a class="dropdown-toggle" href="2.html">产品中心</a>
									<ul class="dropdown-menu">
										<s:iterator value="lstProducttypesL1" id='producttypesL1'>
											<li class="dropdown"><a class="dropdown-toggle" href="#"><i
													class="et-browser"></i> <s:property
														value="#producttypesL1.producttypename" /> <s:property
														value="#producttypesL1.producttypeid" /> <s:property
														value="hmIdL1AndProducttypesL2.value.size" /> <s:property
														value="hmIdL1AndProducttypesL2.get(#producttypesL1.producttypeid).size" /></a>
												<ul class="dropdown-menu">
													<s:iterator
														value="hmIdL1AndProducttypesL2.get(#producttypesL1.producttypeid)"
														id='entryValue'>
														<li><a href="2.html"><s:property
																	value="#entryValue.producttypename" /></a></li>
													</s:iterator>
												</ul></li>
										</s:iterator>
									</ul>
								</li>

								<li class="dropdown">
									<!-- BLOG --> <a class="dropdown-toggle" href="#">资源资讯</a>
									<ul class="dropdown-menu">
										<li class="dropdown"><a href="#">资源下载</a></li>
										<li class="dropdown"><a href="#">新闻公告</a></li>
										<li class="dropdown"><a href="#">行业资讯</a></li>
										<li class="dropdown"><a href="#">帮助中心</a></li>
									</ul>
								</li>
								<li class="dropdown">
									<!-- SHOP --> <a href="#">联系我们</a>
								</li>

							</ul>

						</nav>
					</div>

				</div>
			</header>
			<!-- /Top Nav -->

		</div>

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

				<h1>产品中心</h1>

				<!-- breadcrumbs -->
				<ol class="breadcrumb">
					<li><a href="1.html">首 页</a></li>
					<li><a href="2.html">产品中心</a></li>
					<li class="active">全部产品</li>
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


					<!-- CAROUSEL -->
					<div
						class="owl-carousel buttons-autohide controlls-over margin-bottom-20 radius-4"
						data-plugin-options='{"singleItem": true, "autoPlay": 6000, "navigation": true, "pagination": true, "transitionStyle":"fade"}'>

						<s:iterator value="%{lstHomeslides}" id='homeslides'>
							<!-- item -->
							<div>
								<div class="caption-slider-default">
									<div class="display-table">
										<div class="display-table-cell vertical-align-middle">
											<div class="caption-container text-left">
												<h2>这是产品中心广告宣传图片</h2>
												<p>
													可以进行替换<br /> 文字可单独设置
												</p>
											</div>
										</div>
									</div>
								</div>

								<img class="img-responsive radius-4"
									src="<s:property value='#homeslides.picturepath' />"
									width="851" height="335" alt="">
							</div>
							<!-- /item -->
						</s:iterator>
					</div>
					<!-- /CAROUSEL -->


					<!-- LIST OPTIONS -->
					<div class="clearfix shop-list-options margin-bottom-20">

						<ul class="pagination nomargin pull-right">
							<li><a href="#">&laquo;</a></li>
							<li class="active"><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">&raquo;</a></li>
						</ul>

						<div class="options-left">
							<select>
								<option value="pos_asc">全部产品</option>
								<option value="pos_desc">照明</option>
								<option value="name_asc">电工</option>
								<option value="name_desc">水暖</option>

							</select> <a class="btn btn-danger" href="shop-1col-left.html">特价</a> <a
								class="btn btn-danger" href="shop-1col-left.html">团购</a> <a
								class="btn btn-danger" href="shop-1col-left.html">众筹</a>
							<!--a class="btn active fa fa-th" href="shop-4col-left.html"></a><!-- grid -->
							<!--a class="btn fa fa-list" href="shop-1col-left.html"></a><!-- list -->
						</div>

					</div>
					<!-- /LIST OPTIONS -->





					<!-- 商品展示列表 -->
					<ul class="shop-item-list row list-inline nomargin">
						<s:iterator value="%{secondProductPictures1}" id="shoplist">
							<!-- ITEM -->
							<li class="col-lg-3 col-sm-3">

								<div class="shop-item">

									<div class="thumbnail">
										<!-- product image(s) -->
										<a class="shop-item-image" href="3.html"> <img
											class="img-responsive"
											src="..<s:property value='#shoplist.picturepath'/>"
											alt="shop first image" /> <img class="img-responsive"
											src="..<s:property value='#shoplist.picturepath'/>"
											alt="shop hover image" />
										</a>
										<!-- /product image(s) -->
										<!-- countdown -->
										<div class="shop-item-counter">
											<div class="countdown"
												data-from="<s:property value='#shoplist.closingday'/>"
												data-labels="年,月,周,天,时,分,秒">
												<!-- Example Date From: December 31, 2018 15:03:26 -->
											</div>
										</div>
										<!-- /countdown -->
										<!-- product more info -->
										<div class="shop-item-info">
											<span class="label label-success">新品</span> <span
												class="label label-danger">热卖</span>
										</div>
										<!-- /product more info -->
									</div>

									<div class="shop-item-summary text-center">
										<a href="4.html"><h2>
												<s:property value='#shoplist.picturetitle' />
											</h2></a>
										<div class="size-13">
											<s:property value='#shoplist.introduction' />
										</div>
										<!-- rating --
										<div class="shop-item-rating-line">
											<div class="rating rating-4 size-13"><!--rating-0 ... rating-5-></div>
										</div >
										<!-- /rating -->

										<!-- price -->
										<div class="shop-item-price">
											<!--span class="line-through">$98.00</span-->
											<s:property value='#shoplist.discount' />
										</div>
										<!-- /price -->
									</div>

									<!-- buttons -->
									<div class="shop-item-buttons text-center">
										<a class="btn btn-default" href="4.html"><i
											class="fa fa-cart-plus"></i> 加入购物车</a>
									</div>
									<!-- /buttons -->
								</div>

							</li>
							<!-- /ITEM -->
						</s:iterator>
					</ul>

					<hr />



					<!-- Pagination Default -->
					<div class="text-center">
						<ul class="pagination">
							<li><a href="#">&laquo;</a></li>
							<li class="active"><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">&raquo;</a></li>
						</ul>
					</div>
					<!-- /Pagination Default -->

				</div>






				<!-- LEFT -->
				<div
					class="col-lg-3 col-md-3 col-sm-3 col-lg-pull-9 col-md-pull-9 col-sm-pull-9">

					<!-- CATEGORIES -->
					<div class="side-nav margin-bottom-40">

						<div class="side-nav-head">
							<button class="fa fa-bars"></button>
							<h4>产品分类</h4>
						</div>

						<ul
							class="list-group list-group-bordered list-group-noicon uppercase">
							<s:iterator value="lstProducttypesL1" id='producttypesL1'>
								<li class="list-group-item ">
									<!--加上active就是默认展开--> <a class="dropdown-toggle" href="#"><s:property
											value="#producttypesL1.producttypename" /> </a>
									<ul>
										<s:iterator
											value="hmIdL1AndProducttypesL2.get(#producttypesL1.producttypeid)"
											id='entryValue'>
											<li><a href="#"><span
													class="size-11 text-muted pull-right">(123)</span> <s:property
														value="#entryValue.producttypename" /></a></li>
										</s:iterator>
									</ul>
								</li>
							</s:iterator>
						</ul>

					</div>
					<!-- /CATEGORIES -->

					<!-- SIZE --
							<div class="margin-bottom-60">
								<h4>SIZE</h4>

								<a class="tag" href="#">
									<span class="txt">S</span>
								</a>
								<a class="tag" href="#">
									<span class="txt bold">M</span>
								</a>
								<a class="tag" href="#">
									<span class="txt">L</span>
								</a>
								<a class="tag" href="#">
									<span class="txt">XL</span>
								</a>
								<a class="tag" href="#">
									<span class="txt">2XL</span>
								</a>
								<a class="tag" href="#">
									<span class="txt">3XL</span>
								</a>
								
								<hr />

								<div class="clearfix size-12">
									<a class="pull-right glyphicon glyphicon-remove" href="#"></a>
									SELECTED SIZE: <strong>M</strong>
								</div>
							</div>
							<!-- /SIZE -->


					<!-- COLOR --
							<div class="margin-bottom-60">
								<h4>COLOR</h4>
								
								<a class="tag shop-color" href="#" style="background-color:#000000"></a>
								<a class="tag shop-color" href="#" style="background-color:#FFFFFF"></a>
								<a class="tag shop-color" href="#" style="background-color:#C0C0C0"></a>
								<a class="tag shop-color" href="#" style="background-color:#0000E0"></a>
								<a class="tag shop-color" href="#" style="background-color:#800080"></a>
								<a class="tag shop-color" href="#" style="background-color:#FF0000"></a>
								<a class="tag shop-color" href="#" style="background-color:#FF0080"></a>
								<a class="tag shop-color" href="#" style="background-color:#FF6600"></a>
								<a class="tag shop-color" href="#" style="background-color:#E0DCC8"></a>
								<a class="tag shop-color" href="#" style="background-color:#F0E68C"></a>
								<a class="tag shop-color" href="#" style="background-color:#FFFFD0"></a>
								<a class="tag shop-color" href="#" style="background-color:#4B0082"></a>
								<a class="tag shop-color" href="#" style="background-color:#666666"></a>
								<a class="tag shop-color" href="#" style="background-color:#00FF00"></a>
								<a class="tag shop-color" href="#" style="background-color:#36454F"></a>
								<a class="tag shop-color" href="#" style="background-color:#F4A460"></a>
								<a class="tag shop-color" href="#" style="background-color:#0088CC"></a>
								<a class="tag shop-color" href="#" style="background-color:#B38B6D"></a>

								<hr />

								<div class="clearfix size-12">
									<a class="pull-right glyphicon glyphicon-remove" href="#"></a>
									SELECTED COLOR: <strong>Red</strong>
								</div>
							</div>
							<!-- /COLOR -->


					<!-- BRANDS -->
					<div class="side-nav margin-bottom-60">

						<div class="side-nav-head">
							<button class="fa fa-bars"></button>
							<h4>促销活动</h4>
						</div>

						<ul class="list-group list-unstyled">
							<li class="list-group-item"><a href="#"><span
									class="size-11 text-muted pull-right">(21)</span> 每月特价</a></li>
							<li class="list-group-item"><a href="#"><span
									class="size-11 text-muted pull-right">(44)</span> 拼单团购</a></li>
							<li class="list-group-item"><a href="#"><span
									class="size-11 text-muted pull-right">(2)</span> 众筹预售</a></li>
						</ul>

					</div>
					<!-- BRANDS -->















					<!-- FEATURED 热销推荐开始--------------->
					<div class="margin-bottom-60">

						<h2 class="owl-featured">热销推荐</h2>
						<div class="owl-carousel featured"
							data-plugin-options='{"singleItem": true, "stopOnHover":false, "autoPlay":false, "autoHeight": false, "navigation": true, "pagination": false}'>

							<div>
								<!-- SLIDE 1 -->
								<ul class="list-unstyled nomargin nopadding text-left">
									<s:iterator value="%{thirdProductPictures}" id='tpp1' begin="0"
										end="2">
										<li class="clearfix">
											<!-- item -->
											<div class="thumbnail featured clearfix pull-left">
												<a href="#"> <img
													src="..<s:property value='#tpp1.picturepath'/>" width="80"
													height="80" alt="featured item">
												</a>
											</div> <a class="block size-1 margin-bottom-10" href="3.html"><s:property
													value='#tpp1.picturetitle' /> </a> <!--div class="rating rating-4 size-13 width-100 text-left">< rating-0 ... rating-5 -></div-->
											<div class="size-12 text-left margin-bottom-8">
												<s:property value='#tpp1.introduction' />
											</div>

											<div class="size-18 text-left">
												<s:property value='#tpp1.price' />
											</div>
										</li>
									</s:iterator>

								</ul>
							</div>
							<!-- /SLIDE 1 -->

							<div>
								<!-- SLIDE 2 -->
								<ul class="list-unstyled nomargin nopadding text-left">

									<s:iterator value="%{thirdProductPictures}" id='tpp2' begin="3"
										end="5">
										<li class="clearfix">
											<!-- item -->
											<div class="thumbnail featured clearfix pull-left">
												<a href="#"> <img
													src="..<s:property value='#tpp2.picturepath'/>" width="80"
													height="80" alt="featured item">
												</a>
											</div> <a class="block size-1 margin-bottom-10" href="3.html"><s:property
													value='#tpp2.picturetitle' /> </a> <!--div class="rating rating-4 size-13 width-100 text-left">< rating-0 ... rating-5 -></div-->
											<div class="size-12 text-left margin-bottom-8">
												<s:property value='#tpp2.introduction' />
											</div>

											<div class="size-18 text-left">
												<s:property value='#tpp2.price' />
											</div>
										</li>
									</s:iterator>
								</ul>
							</div>
							<!-- /SLIDE 2 -->

						</div>

					</div>
					<!-- /FEATURED 热销推荐结束--------->







					<!-- FEATURED 新品上市开始---------------->
					<div class="margin-bottom-60">

						<h2 class="owl-featured">新品上市</h2>
						<div class="owl-carousel featured"
							data-plugin-options='{"singleItem": true, "stopOnHover":false, "autoPlay":false, "autoHeight": false, "navigation": true, "pagination": false}'>

							<div>
								<!-- SLIDE 1 -->
								<ul class="list-unstyled nomargin nopadding text-left">
									<s:iterator value="%{thirdProductPictures2}" id='tpp3'
										begin="0" end="2">
										<li class="clearfix">
											<!-- item -->
											<div class="thumbnail featured clearfix pull-left">
												<a href="#"> <img
													src="..<s:property value='#tpp3.picturepath'/>" width="80"
													height="80" alt="featured item">
												</a>
											</div> <a class="block size-1 margin-bottom-10" href="3.html"><s:property
													value='#tpp3.picturetitle' /> </a> <!--div class="rating rating-4 size-13 width-100 text-left">< rating-0 ... rating-5 -></div-->
											<div class="size-12 text-left margin-bottom-8">
												<s:property value='#tpp3.introduction' />
											</div>

											<div class="size-18 text-left">
												<s:property value='#tpp3.price' />
											</div>
										</li>
									</s:iterator>

								</ul>
							</div>
							<!-- /SLIDE 1 -->

							<div>
								<!-- SLIDE 2 -->
								<ul class="list-unstyled nomargin nopadding text-left">

									<s:iterator value="%{thirdProductPictures2}" id='tpp4'
										begin="3" end="5">
										<li class="clearfix">
											<!-- item -->
											<div class="thumbnail featured clearfix pull-left">
												<a href="#"> <img
													src="..<s:property value='#tpp4.picturepath'/>" width="80"
													height="80" alt="featured item">
												</a>
											</div> <a class="block size-1 margin-bottom-10" href="3.html"><s:property
													value='#tpp4.picturetitle' /> </a> <!--div class="rating rating-4 size-13 width-100 text-left">< rating-0 ... rating-5 -></div-->
											<div class="size-12 text-left margin-bottom-8">
												<s:property value='#tpp4.introduction' />
											</div>

											<div class="size-18 text-left">
												<s:property value='#tpp4.price' />
											</div>
										</li>
									</s:iterator>

								</ul>
							</div>
							<!-- /SLIDE 2 -->

						</div>

					</div>
					<!-- /FEATURED 新品上市结束-------->

					<!-- BANNER ROTATOR ---------------------------
							<div class="owl-carousel buttons-autohide controlls-over margin-bottom-60 text-center" data-plugin-options='{"singleItem": true, "autoPlay": 4000, "navigation": true, "pagination": false, "transitionStyle":"goDown"}'>
								<a href="#">
									<img class="img-responsive" src="assets/images/demo/shop/banners/off_1.png" width="270" height="350" alt="">
								</a>
								<a href="#">
									<img class="img-responsive" src="assets/images/demo/shop/banners/off_2.png" width="270" height="350" alt="">
								</a>
							</div>
							<!-- /BANNER ROTATOR -->

					<!-- BANNER ROTATOR --------------------------->
					<div
						class="owl-carousel buttons-autohide controlls-over margin-bottom-10 text-center"
						data-plugin-options='{"singleItem": true,  "transitionStyle":"fadeUp"}'>
						<a href="#"> <img class="img-responsive"
							src="assets/images/demo/shop/banners/sq_1.png" width="270"
							height="200" alt="">
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
		<footer id="footer">

			<div class="copyright">
				<div class="container">
					<ul class="pull-right nomargin list-inline mobile-block">

						<a href="http://www.miitbeian.gov.cn" target="_blank">闽ICP备16014139号</a>
					</ul>

					厦门光服科技有限公司 &copy; <a href="#"> 照明 </a>&bull;<a href="#"> 电工 </a>&bull;<a
						href="#"> 水暖 </a>
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
	<script type="text/javascript">
		var plugin_path = 'assets/plugins/';
	</script>
	<script type="text/javascript"
		src="assets/plugins/jquery/jquery-2.1.4.min.js"></script>

	<script type="text/javascript" src="assets/js/scripts.js"></script>


	<!-- PAGE LEVEL SCRIPTS -->
	<script type="text/javascript" src="assets/js/view/demo.shop.js"></script>
</body>
</html>