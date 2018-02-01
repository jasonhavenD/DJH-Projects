﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		<title>首 页——厦门光服科技有限公司</title>
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
	</head>

	<body class="smoothscroll enable-animation">

		<!-- SLIDE TOP ----------------------------
		<!-- /SLIDE TOP -->


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
							<!--ul class="dropdown-menu pull-right">
								<li><a tabindex="-1" href="#"><i class="fa fa-history"></i> ORDER HISTORY</a></li>
								<li class="divider"></li>
								<li><a tabindex="-1" href="#"><i class="fa fa-bookmark"></i> MY WISHLIST</a></li>
								<li><a tabindex="-1" href="#"><i class="fa fa-edit"></i> MY REVIEWS</a></li>
								<li><a tabindex="-1" href="#"><i class="fa fa-cog"></i> MY SETTINGS</a></li>
								<li class="divider"></li>
								<li><a tabindex="-1" href="#"><i class="glyphicon glyphicon-off"></i> LOGOUT</a></li>
							</ul-->
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

				<!-- SEARCH HEADER >
				<div class="search-box over-header">
					<!--a id="closeSearch" href="#" class="glyphicon glyphicon-remove"></a>

					<form action="page-search-result-1.html" method="get">
						<input type="text" class="form-control" placeholder="SEARCH" />
					</form>
					
				</div> 
				<!-- /SEARCH HEADER -->


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
						<!-- INLINE SEARCH -->

						<!-- /INLINE SEARCH -->
						<!-- QUICK SHOP CART -->
						<li class="quick-cart">
							<a href="#"> <span
								class="badge badge-aqua btn-xs badge-corner"><s:property
										value='cartItems.size()' />
							</span> <i class="fa fa-shopping-cart"></i> </a>
							<div class="quick-cart-box">
								<h4>
									我的购物车
								</h4>
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
												<span>x<s:property value='#item.count' />
												</span>
												<small>删除</small>
											</h6> </a>

									</s:iterator>
									<!-- /cart item -->

									<!-- cart no items example -->

									<a class="text-center" href="#"> 共<s:property
											value='cartItems.size()' />件商品 &nbsp; 共计:<strong>¥
											<s:property value='sum()' /> </strong> </a>


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

						<!--
									NOTE
									
									For a regular link, remove "dropdown" class from LI tag and "dropdown-toggle" class from the href.
									Direct Link Example: 

									<li>
										<a href="#">HOME</a>
									</li>
								-->
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


			<!-- SLIDER -->
			<section class="padding-top-40">
			<div class="container">

				<!-- OWL SLIDER -->
				<div class="owl-carousel buttons-autohide controlls-over nomargin"
					data-plugin-options='{"items": 1, "autoHeight": false, "navigation": true, "pagination": false, "transitionStyle":"fade", "progressBar":"true"}'>

					<!-- div>
						<a href="#"> <img class="img-responsive"
								src="assets/images/demo/shop/banners/home_slider_2.jpg" alt="">
					</div>
					</a>
					<div>
						<a href="#"> <img class="img-responsive"
								src="assets/images/demo/shop/banners/home_slider_1.jpg" alt="">
						</a>
					</div -->

					<s:iterator value="%{lstHomeslides}" id='homeslides'>
						<div>
							<a href="#"> <img class="img-responsive"
									src="<s:property value='#homeslides.picturepath' />" alt="">
							</a>
						</div>
					</s:iterator>

				</div>
				<!-- /OWL SLIDER -->



				<!-- 产品类别 -->
				<!-- INFO BAR -->
				<div class="row">

					<div class="col-md-4">

						<div class="box-image text-center">
							<a class="image-hover" href="centerPage.action"> <img
									class="img-responsive"
									src="<s:property value='firstProducPictures[0].picturepath' />"
									alt="" /> </a>
							<a class="box-image-title" href="centerPage.action">
								<h2>
									<s:property value="firstProducPictures[0].typename" />
								</h2> </a>
							<p class="font-lato weight-300">
								<s:property value="firstProducPictures[0].propaganda" />
							</p>
						</div>

					</div>

					<div class="col-md-4">

						<div class="box-image text-center">
							<a class="image-hover" href="centerPage.action"> <img
									class="img-responsive"
									src="<s:property value='firstProducPictures[1].picturepath' />"
									alt="" /> </a>
							<a class="box-image-title" href="centerPage.action">
								<h2>
									<s:property value="firstProducPictures[1].typename" />
								</h2> </a>
							<p class="font-lato weight-300">
								<s:property value="firstProducPictures[1].propaganda" />
							</p>
						</div>

					</div>

					<div class="col-md-4">

						<div class="box-image text-center">
							<a class="image-hover" href="centerPage.action"> <img
									class="img-responsive"
									src="<s:property value='firstProducPictures[2].picturepath' />"
									alt="" /> </a>
							<a class="box-image-title" href="centerPage.action">
								<h2>
									<s:property value="firstProducPictures[2].typename" />
								</h2> </a>
							<p class="font-lato weight-300">
								<s:property value="firstProducPictures[2].propaganda" />
							</p>
						</div>

					</div>

				</div>
				<!-- /INFO BAR -->

			</div>

			<!-- /SLIDER -->





			<!-- ------------------------------中间部分开始---------------------------- -->


			<div class="container">

				<div class="row">

					<!-- RIGHT -->
					<div class="col-lg-9 col-md-9 col-sm-9">

						<ul id="myTab" class="nav nav-tabs nav-top-border margin-top-5"
							role="tablist">
							<li role="presentation" class="active">
								<a href="#description" role="tab" data-toggle="tab">每月特价</a>
							</li>
							<li role="presentation">
								<a href="#specs" role="tab" data-toggle="tab">拼单团购</a>
							</li>
							<li role="presentation">
								<a href="#reviews" role="tab" data-toggle="tab">众筹预售</a>
							</li>
						</ul>


						<div class="tab-content padding-top-20">
							<!-- DESCRIPTION -->
							<div role="tabpanel" class="tab-pane fade in active"
								id="description">




								<!-----------每月特价内容开始----------------------------->
								<div class="owl-carousel featured nomargin owl-padding-10"
									data-plugin-options='{"singleItem": false, "items": "4", "stopOnHover":false, "autoPlay":4500, "autoHeight": false, "navigation": true, "pagination": false}'>



									<s:iterator value="%{secondProductPictures1}" id='spp1'>

										<!-- item ------------------------------------------------------------------------------------->
										<div class="shop-item nomargin">
											<div class="thumbnail">
												<!-- product image(s) -->
												<a class="shop-item-image" href="3.html"> <img
														class="img-responsive"
														src="..<s:property value='#spp1.picturepath' />"
														alt="shop first image" /> <img class="img-responsive"
														src="..<s:property value='#spp1.picturepath' />"
														alt="shop hover image" /> < </a>
												<!-- /product image(s) -->
												<!-- countdown -->
												<div class="shop-item-counter">
													<div class="countdown"
														data-from="<s:property value='#spp1.closingday'/>"
														data-labels="年,月,周,天,时,分,秒">
														<!-- Example Date From: December 31, 2018 15:03:26 -->
													</div>
												</div>
												<!-- /countdown -->
												<!-- product more info -->
												<div class="shop-item-info">
													<span class="label label-success">新品</span>
													<span class="label label-danger">热卖</span>
												</div>
												<!-- /product more info -->
											</div>

											<div class="shop-item-summary text-center">
												<a href="4.html"><h2>
														<s:property value='#spp1.picturetitle' />
													</h2> </a>
												<div class="size-13">
													<s:property value='#spp1.introduction' />
												</div>
												<!-- rating --
										<div class="shop-item-rating-line">
											<div class="rating rating-4 size-13"><!--rating-0 ... rating-5-></div>
										</div >
										<!-- /rating -->

												<!-- price -->
												<div class="shop-item-price">
													<!--span class="line-through">$98.00</span-->
													特价：¥
													<s:property value='#spp1.discount' />
												</div>
												<!-- /price -->
											</div>

											<!-- buttons -->
											<div class="shop-item-buttons text-center">
												<a href="4.html" class="btn btn-default"> <i
													class="fa fa-cart-plus"></i>加入购物车 </a>

											</div>
											<!-- /buttons -->
										</div>
										<!-- /item -->

									</s:iterator>

								</div>
							</div>
							<!-----------每月特价内容结束----------------------------->




							<!-----------拼单团购内容开始----------------------------->
							<!-- SPECIFICATIONS -->
							<div role="tabpanel" class="tab-pane fade" id="specs">
								<div class="owl-carousel featured nomargin owl-padding-10"
									data-plugin-options='{"singleItem": false, "items": "4", "stopOnHover":false, "autoPlay":4500, "autoHeight": false, "navigation": true, "pagination": false}'>



									<s:iterator value="%{secondProductPictures2}" id='spp2'>

										<!-- item ------------------------------------------------------------------------------------->
										<div class="shop-item nomargin">

											<div class="thumbnail">
												<!-- product image(s) -->
												<a class="shop-item-image" href="3.html"> <img
														class="img-responsive"
														src="..<s:property value='#spp2.picturepath' />"
														alt="shop first image" /> <img class="img-responsive"
														src="..<s:property value='#spp2.picturepath' />"
														alt="shop hover image" /> </a>
												<!-- /product image(s) -->
												<!-- countdown -->
												<div class="shop-item-counter">
													<div class="countdown"
														data-from="<s:property value='#spp2.closingday' />"
														data-labels="年,月,周,天,时,分,秒">
														<!-- Example Date From: December 31, 2018 15:03:26 -->
													</div>
												</div>
												<!-- /countdown -->
												<!-- product more info -->
												<div class="shop-item-info">
													<span class="label label-success">新品</span>
													<span class="label label-danger">热卖</span>
												</div>
												<!-- /product more info -->
											</div>

											<div class="shop-item-summary text-center">
												<a href="4.html"><h2>
														<s:property value='#spp2.picturetitle' />
													</h2> </a>
												<div class="size-13">
													<s:property value='#spp2.introduction' />
												</div>
												<!-- rating --
										<div class="shop-item-rating-line">
											<div class="rating rating-4 size-13"><!--rating-0 ... rating-5-></div>
										</div >
										<!-- /rating -->

												<!-- price -->
												<div class="shop-item-price">
													<!--span class="line-through">$98.00</span-->
													特价：¥
													<s:property value='#spp2.discount' />
												</div>
												<!-- /price -->
											</div>

											<!-- buttons -->
											<div class="shop-item-buttons text-center">
												<a href="4.html" class="btn btn-default"> <i
													class="fa fa-cart-plus"></i>加入购物车 </a>

											</div>
											<!-- /buttons -->
										</div>
										<!-- /item -->


									</s:iterator>


								</div>
							</div>
							<!-----------拼单团购内容结束----------------------------->



							<!-----------众筹预售内容开始----------------------------->

							<!-- REVIEWS -->
							<div role="tabpanel" class="tab-pane fade" id="reviews">
								<div class="owl-carousel featured nomargin owl-padding-10"
									data-plugin-options='{"singleItem": false, "items": "4", "stopOnHover":false, "autoPlay":4500, "autoHeight": false, "navigation": true, "pagination": false}'>

									<s:iterator value="%{secondProductPictures3}" id='spp3'>

										<div class="shop-item nomargin">

											<div class="thumbnail">
												<!-- product image(s) -->
												<a class="shop-item-image" href="3.html"> <!-- CAROUSEL -->
													<div class="owl-carousel owl-padding-0 nomargin"
														data-plugin-options='{"singleItem": true, "autoPlay": 3000, "navigation": false, "pagination": false, "transitionStyle":"fadeUp"}'>
														<img class="img-responsive"
															src="..<s:property value='#spp3.picturepath'/>" alt="">
														<img class="img-responsive"
															src="..<s:property value='#spp3.picturepath'/>" alt="">
													</div> <!-- /CAROUSEL --> </a>
												<!-- /product image(s) -->

												<!-- countdown -->
												<div class="shop-item-counter">
													<div class="countdown"
														data-from="<s:property value='#spp3.closingday'/>"
														data-labels="年,月,周,天,时,分,秒">
														<!-- Example Date From: December 31, 2018 15:03:26 -->
													</div>
												</div>
												<!-- /countdown -->
											</div>

											<div class="shop-item-summary text-center">
												<a href="4.html"><h2>
														<s:property value='#spp3.picturetitle' />
													</h2> </a>
												<div class="size-13">
													<s:property value='#spp3.introduction' />
												</div>

												<!-- price -->
												<div class="shop-item-price">
													特价：¥
													<s:property value='#spp3.discount' />
												</div>
												<!-- /price -->
											</div>

											<!-- buttons -->
											<div class="shop-item-buttons text-center">
												<a href="4.html" class="btn btn-default"> <i
													class="fa fa-cart-plus"></i>加入购物车 </a>
											</div>
											<!-- /buttons -->
										</div>

									</s:iterator>

									<!-- /item -->
								</div>
								<!-----------众筹预售内容结束----------------------------->

							</div>
						</div>

						<hr class="margin-top-50 margin-bottom-20" />

					</div>
					<!-- /right右侧结束 -->





					<!-- LEFT 左侧开始-->
					<div class="col-lg-3 col-md-3 col-sm-3">

						<div class="margin-bottom-20">

							<!-----------热销推荐内容开始----------------------------->

							<h2 class="owl-featured">
								热销推荐
							</h2>
							<div class="owl-carousel featured"
								data-plugin-options='{"singleItem": true, "stopOnHover":false, "autoPlay":false, "autoHeight": false, "navigation": true, "pagination": false}'>
								<div>
									<!-- SLIDE 1 -->
									<ul class="list-unstyled nomargin nopadding text-left">
										<s:iterator value="%{thirdProductPictures}" id='tpp1'
											begin="0" end="2">
											<li class="clearfix">
												<!-- item -->
												<div class="thumbnail featured clearfix pull-left">
													<a href="3.html"> <img
															src="..<s:property value='#tpp1.picturepath'/>"
															width="80" height="80" alt="featured item"> </a>
												</div>
												<a class="block size-1 margin-bottom-10" href="3.html"><s:property
														value='#tpp1.picturetitle' /> </a>
												<!--div class="rating rating-4 size-13 width-100 text-left">< rating-0 ... rating-5 -></div-->
												<div class="size-12 text-left margin-bottom-8">
													<s:property value='#tpp1.introduction' />
												</div>

												<div class="size-18 text-left">
													¥
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
										<s:iterator value="%{thirdProductPictures}" id='tpp2'
											begin="3" end="5">
											<li class="clearfix">
												<!-- item -->
												<div class="thumbnail featured clearfix pull-left">
													<a href="3.html"> <img
															src="..<s:property value='#tpp2.picturepath'/>"
															width="80" height="80" alt="featured item"> </a>
												</div>
												<a class="block size-1 margin-bottom-10" href="3.html"><s:property
														value='#tpp2.picturetitle' />
												</a>
												<!--div class="rating rating-4 size-13 width-100 text-left">< rating-0 ... rating-5 -></div-->
												<div class="size-12 text-left margin-bottom-8">
													<s:property value='#tpp2.introduction' />
												</div>
												<div class="size-18 text-left">
													¥
													<s:property value='#tpp2.price' />
												</div>
											</li>
											<!-- /item -->
										</s:iterator>
									</ul>
								</div>
								<!-- /SLIDE 2 -->
							</div>
						</div>
						<!-- /FEATURED -->











						<!-- 申请成为经销商 -->

						<!-- BANNER ROTATOR --------------------------->
						<div
							class="owl-carousel buttons-autohide controlls-over margin-bottom-10 text-center"
							data-plugin-options='{"singleItem": true,  "transitionStyle":"fadeUp"}'>
							<a href="#"> <img class="img-responsive"
									src="assets/images/demo/shop/banners/sq_1.png" width="270"
									height="200" alt=""> </a>

						</div>


						<!-- /BANNER ROTATOR -->




						<!-- HTML BLOCK -------------
							<div class="margin-bottom-10">
								<h4>HTML BLOCK</h4>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras non placerat mi. Etiam non tellus eunit.</p>

								<form action="#" role="form" method="post">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-envelope"></i></span>
										<input type="email" name="email" class="form-control" placeholder="Enter your Email" required="required">
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

			<!-- ---------------------/中间部分结束----------------- -->



			<!-- 销售地图 -->

			<!-- BRANDS -->

			<div class="container">
				<!--map-->
				<h2 class="owl-featured noborder">
					<strong>销售地图：</strong><i class="fa fa-truck"></i> 物流中心
				</h2>
				<div id="map2" class="height-10 grayscale"></div>


				<!-- 
	GMAP.JS 
	http://hpneo.github.io/gmaps/
-->


				<script type="text/javascript"
					src="http://api.map.baidu.com/api?v=2.0&ak=A81145b191c68e5055d735777fa746b8"></script>
				<!--百度地图容器-->
				<div
					style="width: 100%; height: 550px; border: #ccc solid 1px; font-size: 12px; align: center;"
					id="map"></div>


				<script type="text/javascript">
	//创建和初始化地图函数：
	function initMap() {
		createMap();//创建地图
		setMapEvent();//设置地图事件
		addMapControl();//向地图添加控件
		addMapOverlay();//向地图添加覆盖物
	}
	function createMap() {
		map = new BMap.Map("map");
		map.centerAndZoom(new BMap.Point(110.192364, 30.683847), 6);
	}
	function setMapEvent() {
		map.enableScrollWheelZoom();
		map.enableKeyboard();
		map.enableDragging();
		map.enableDoubleClickZoom()
	}
	function addClickHandler(target, window) {
		target.addEventListener("click", function() {
			target.openInfoWindow(window);
		});
	}
	function addMapOverlay() {
		var markers = [ {
			content : "",
			title : "厦门光服科技有限公司",
			imageOffset : {
				width : 0,
				height : -21
			},
			position : {
				lat : 24.683847,
				lng : 118.192364
			}
		}, {
			content : "",
			title : "四川物流中心",
			imageOffset : {
				width : -46,
				height : -21
			},
			position : {
				lat : 30.653467,
				lng : 104.103628
			}
		}, {
			content : "",
			title : "山东物流中心",
			imageOffset : {
				width : -46,
				height : -21
			},
			position : {
				lat : 36.677908,
				lng : 117.038078
			}
		}, {
			content : "",
			title : "辽宁物流中心",
			imageOffset : {
				width : -46,
				height : -21
			},
			position : {
				lat : 41.810989,
				lng : 123.449823
			}
		}, {
			content : "",
			title : "湖北物流中心",
			imageOffset : {
				width : -46,
				height : -21
			},
			position : {
				lat : 30.60959,
				lng : 114.456132
			}
		}, {
			content : "",
			title : "西安认证经销商",
			imageOffset : {
				width : -23,
				height : -46
			},
			position : {
				lat : 34.345996,
				lng : 108.949663
			}
		}, {
			content : "",
			title : "长沙认证经销商",
			imageOffset : {
				width : -23,
				height : -46
			},
			position : {
				lat : 28.240968,
				lng : 112.94935
			}
		},

		];
		for ( var index = 0; index < markers.length; index++) {
			var point = new BMap.Point(markers[index].position.lng,
					markers[index].position.lat);
			var marker = new BMap.Marker(
					point,
					{
						icon : new BMap.Icon(
								"http://api.map.baidu.com/lbsapi/createmap/images/icon.png",
								new BMap.Size(20, 25), {
									imageOffset : new BMap.Size(
											markers[index].imageOffset.width,
											markers[index].imageOffset.height)
								})
					});
			var label = new BMap.Label(markers[index].title, {
				offset : new BMap.Size(25, 5)
			});
			var opts = {
				width : 200,
				title : markers[index].title,
				enableMessage : false
			};
			var infoWindow = new BMap.InfoWindow(markers[index].content, opts);
			marker.setLabel(label);
			addClickHandler(marker, infoWindow);
			map.addOverlay(marker);
		}
		;
	}
	//向地图添加控件
	function addMapControl() {
		var scaleControl = new BMap.ScaleControl( {
			anchor : BMAP_ANCHOR_BOTTOM_LEFT
		});
		scaleControl.setUnit(BMAP_UNIT_IMPERIAL);
		map.addControl(scaleControl);
		var navControl = new BMap.NavigationControl( {
			anchor : BMAP_ANCHOR_TOP_LEFT,
			type : BMAP_NAVIGATION_CONTROL_LARGE
		});
		map.addControl(navControl);
		var overviewControl = new BMap.OverviewMapControl( {
			anchor : BMAP_ANCHOR_BOTTOM_RIGHT,
			isOpen : true
		});
		map.addControl(overviewControl);
	}
	var map;
	initMap();
</script>
			</div>


			<!-- BRANDS -->

			<!----------------------------------------------------------中间内容结束，以下是底部内容---------------------------------------------------------------------------------------->

			</section>
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
		<script type="text/javascript">
	var plugin_path = 'assets/plugins/';
</script>
		<script type="text/javascript"
			src="assets/plugins/jquery/jquery-2.1.4.min.js"></script>

		<script type="text/javascript" src="assets/js/scripts.js"></script>

		<!-- STYLESWITCHER - REMOVE 样式
		<script async type="text/javascript" src="assets/plugins/styleswitcher/styleswitcher.js"></script>-->

		<!-- PAGE LEVEL SCRIPTS -->
		<script type="text/javascript" src="assets/js/view/demo.shop.js"></script>
	</body>
</html>