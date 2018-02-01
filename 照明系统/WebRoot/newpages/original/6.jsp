<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
		<title>团购产品介绍内容详细页——厦门光服科技有限公司</title>
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
						<li><a class="dropdown-toggle no-text-underline" data-toggle="dropdown" href="#"><i class="fa fa-user hidden-xs"></i> 会员中心</a></li>
						<li class="dropdown-toggle no-text-underline"><a href="9.html">登陆</a></li>
						<li class="dropdown-toggle no-text-underline"><a href="8.html">注册</a></li>
					</ul>

					<!-- left -->
					<ul class="top-links list-inline">
						<li class="dropdown-toggle no-text-underline"><a href="#">光服水电  未来无限</a></li>				  					
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
						<button class="btn btn-mobile" data-toggle="collapse" data-target=".nav-main-collapse">
							<i class="fa fa-bars"></i>
						</button>

						<!-- BUTTONS -->
						

						
						<ul class="pull-right nav nav-pills nav-second-main">
						<!-- SEARCH -->
							<li class="search">
								<a href="javascript:;">
									<i class="fa fa-search"></i>
								</a>
								<div class="search-box">
									<form action="page-search-result-1.html" method="get">
										<div class="input-group">
											<input type="text" name="src" placeholder="请输入关键词" class="form-control" />
											<span class="input-group-btn">
												<button class="btn btn-primary" type="submit">搜 索</button>
											</span>
										</div>
									</form>
								</div> 
							</li>
							<!-- /SEARCH -->

							<!-- QUICK SHOP CART -->
							<li class="quick-cart">
								<a href="#">
									<span class="badge badge-aqua btn-xs badge-corner">3</span>
									<i class="fa fa-shopping-cart"></i> 
								</a>
								<div class="quick-cart-box">
									<h4>我的购物车</h4>

									<div class="quick-cart-wrapper">

										<a href="#"><!-- cart item -->
											<img src="assets/images/demo/people/300x300/4-min.jpg" width="45" height="45" alt="" />
											<h6> 照明产品名称标题</h6>
											<h6>¥ 6.50 <span>x2</span>   <small>删除</small></h6>
										</a><!-- /cart item -->

										<a href="#"><!-- cart item -->
											<img src="assets/images/demo/people/300x300/5-min.jpg" width="45" height="45" alt="" />
											<h6> 电工产品名称标题</h6>
											<h6>¥ 12.50 <span>x1</span>   <small>删除</small></h6>
										</a><!-- /cart item -->

										<!-- cart no items example -->
										
										<a class="text-center" href="#">
												共3件商品  &nbsp;   共计:<strong>¥ 25.50</strong>
										</a>
									

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
						<a class="logo pull-left" href="index.html">
							<img src="assets/images/logo_dark.png" alt="" /> 
						</a>
						<a class="logo pull-left" href="#">
                         <img src="assets/images/gf_50px.png" alt="" />	
						 </a>
						<!-- 
							Top Nav 
							
							AVAILABLE CLASSES:
							submenu-dark = dark sub menu
						-->
						<div class="navbar-collapse pull-right nav-main-collapse collapse">
							<nav class="nav-main">

								<ul id="topMain" class="nav nav-pills nav-main">
									<li class="dropdown"><!-- HOME --><a  href="1.html">首  页</a></li>
									<li class="dropdown"><!-- PAGES -->	<a class="dropdown-toggle" href="#">关于我们	</a>
										<ul class="dropdown-menu">
											<li class="dropdown"><a href="#">公司简介</a></li>
											<li class="dropdown"><a href="#">招商政策</a></li>
											<li class="dropdown"><a href="#">发展愿景</a></li>
										</ul>
									</li>
									<li class="dropdown"><!-- FEATURES --><a class="dropdown-toggle" href="2.html">产品中心</a>
										<ul class="dropdown-menu">
											<li class="dropdown"><a class="dropdown-toggle" href="2.html"><i class="et-browser"></i> 照明产品</a>
												<ul class="dropdown-menu">
													<li><a href="2.html">照明产品二级分类</a></li>
													<li><a href="2.html">照明产品二级分类</a></li>
													<li><a href="2.html">照明产品二级分类</a></li>
													<li><a href="2.html">照明产品二级分类</a></li>
													<li><a href="2.html">照明产品二级分类</a></li>
												</ul>
											</li>
											<li class="dropdown"><a class="dropdown-toggle" href="#"><i class="et-hotairballoon"></i> 电工产品</a>
												<ul class="dropdown-menu">
													<li><a href="2.html">电工产品二级分类</a></li>
													<li><a href="2.html">电工产品二级分类</a></li>
													<li><a href="2.html">电工产品二级分类</a></li>
													<li><a href="2.html">电工产品二级分类</a></li>
													<li><a href="2.html">电工产品二级分类</a></li>
												</ul>
											</li>
											<li class="dropdown"><a class="dropdown-toggle" href="#"><i class="et-anchor"></i> 水暖产品</a>
												<ul class="dropdown-menu">
													<li><a href="2.html">水暖产品二级分类</a></li>
													<li><a href="2.html">水暖产品二级分类</a></li>
													<li><a href="2.html">水暖产品二级分类</a></li>
													<li><a href="2.html">水暖产品二级分类</a></li>
												</ul>
											</li>
										</ul>
									</li>

									<li class="dropdown"><!-- BLOG --><a class="dropdown-toggle" href="#">资源资讯</a>
										<ul class="dropdown-menu">
											<li class="dropdown"><a href="#">资源下载</a></li>
											<li class="dropdown"><a href="#">新闻公告</a></li>
											<li class="dropdown"><a href="#">行业资讯</a></li>
											<li class="dropdown"><a href="#">帮助中心</a></li>
										</ul>
									</li>
									<li class="dropdown"><!-- SHOP --><a href="#">联系我们</a></li>

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

					<h1>产品二级分类名称</h1>

					<!-- breadcrumbs -->
					<ol class="breadcrumb">
						<li><a href="1.html">首 页</a></li>
						<li><a href="2.html">产品中心</a></li>
						<li class="active">照明产品</li>
					</ol><!-- /breadcrumbs -->

				</div>
			</section>
			<!-- /PAGE HEADER -->




			<!-- -->
	
				<div class="container padding-top-40 padding-bottom-40 ">
					
					<div class="row">

						<!-- RIGHT -->
						<div class="col-lg-9 col-md-9 col-sm-9 col-lg-push-3 col-md-push-3 col-sm-push-3">

							<div class="row">
							
								<!-- IMAGE -->
								<div class="col-lg-6 col-sm-6">
									
									<div class="thumbnail relative margin-bottom-3">

										<!-- 
											IMAGE ZOOM 
											
											data-mode="mouseover|grab|click|toggle"
										-->
										<figure id="zoom-primary" class="zoom" data-mode="mouseover">
											<!-- 
												zoom buttton
												
												positions available:
													.bottom-right
													.bottom-left
													.top-right
													.top-left
											-->
											<a class="lightbox bottom-right" href=<s:property value="#request.picture[0]"/> data-plugin-options='{"type":"image"}'><i class="glyphicon glyphicon-search"></i></a>

											<!-- 
												image 
												
												Extra: add .image-bw class to force black and white!
											-->
											<img class="img-responsive" src=<s:property value="#request.picture[0]"/> width="1000" height="1500" alt="产品标题名称" />
										</figure>

									</div>

									<!-- Thumbnails (required height:100px) -->
									<div data-for="zoom-primary" class="zoom-more owl-carousel owl-padding-3 featured" data-plugin-options='{"singleItem": false, "autoPlay": false, "navigation": true, "pagination": false}'>
										<a class="thumbnail active" href=<s:property value="#request.picture[0]"/>>
											<img src=<s:property value="#request.picture[0]"/> height="100" alt="" />
										</a>
										<a class="thumbnail" href=<s:property value="#request.picture[1]"/>>
											<img src=<s:property value="#request.picture[1]"/> height="100" alt="" />
										</a>
										<a class="thumbnail" href=<s:property value="#request.picture[2]"/>>
											<img src=<s:property value="#request.picture[2]"/> height="100" alt="" />
										</a>
										<a class="thumbnail" href=<s:property value="#request.picture[3]"/>>
											<img src=<s:property value="#request.picture[3]"/> height="100" alt="" />
										</a>
										<a class="thumbnail" href=<s:property value="#request.picture[4]"/>>
											<img src=<s:property value="#request.picture[4]"/> height="100" alt="" />
										</a>
									</div>
									<!-- /Thumbnails -->

								</div>
								<!-- /IMAGE -->

								<!-- ITEM DESC -->
								<div class="col-lg-6 col-sm-6">

								  <!-- buttons --------------------------是否促销产品可显示在这里，常规产品则不显示-->
									<div class="pull-right">
										<!-- replace data-item-id width the real item ID - used by js/view/demo.shop.js -->
										
										 <a href="#" class="social-icon social-icon-sm social-dropbox" data-toggle="tooltip" data-placement="top" title="此产品已参加团购活动">
	                                        <i class="icon-dropbox"></i>
	                                         <i class="icon-dropbox"></i>
                                         </a>
									</div>
								  <!-- /buttons -->

									<!-- title -->
									<div class="shop-item-price text-danger" ><s:property value="#request.productname"/></div>
									<!-- /title -->

									<!-- price --
									<div class="shop-item-price">
										<span class="line-through nopadding-left">$98.00</span>
										$78.00
									</div>
									<!-- /price -->

									<hr />
                                    
									<div class="clearfix margin-bottom-30">
										<span class="pull-right text-success">
										<s:if test="#request.activity=='限时促销'"><i class="fa fa-check"></i>限时促销</s:if>
										<s:elseif test="#request.activity=='团购'"><i class="fa fa-check"></i>团购</s:elseif>
										<s:elseif test="#request.activity=='众筹预售'"><i class="fa fa-check"></i>众筹预售</s:elseif>
										</span>
										<!--
										<span class="pull-right text-danger"><i class="glyphicon glyphicon-remove"></i> Out of Stock</span>
										-->

										<strong>产品副标题或文字广告宣传词 发光色:<s:property value="#request.colortemp"/> </strong>
									</div>


									<!-- short description -->
									<p>产品型号：<s:property value="#request.productname"/></p>
									<p>规格参数：功率：<s:property value="#request.power"/></p>
									<!-- /short description -->


									<!-- countdown 如果是特价、团购、众筹产品则显示结束时间，常规产品不显示-->
									<div class="text-center">
										<h5>距离活动结束时间</h5>
										<div class="countdown" data-from="January 31, 2017 15:03:26" data-labels="年,月,周,天,时,分,秒"><!-- Example Date From: December 31, 2018 15:03:26 --></div>
									</div>
									<!-- /countdown -->

									<hr />
									
                                     <div class="shop-item-price text-danger">价格：¥ 8.5 元    &times;  <input type="number" value="10" name="qty" maxlength="3" max="999" min="10" />    <a href="4.html"><button type="button" class="btn btn-danger btn-lg"><i class="fa fa-cart-plus"></i>加入购物车</button></a>  </div> 

									<hr />

									<small class="text-muted">
										团购规则举例：最小订购量10个，
										当订购10-50个时，价格是 ¥ 8.50元，
										当订购51-100个时，价格是 ¥ 8.00元，大于100个，价格 ¥ 7.50元

									</small>
（说明：团购规则的最小订购量、订购数量对应的价格都由后台设置。当用户输入订购数量时，对应的价格应能自动变化。只允许认证经销商和物流中心会员参加）
									<hr />


									<!-- Share -->
									<div class="pull-left">
										<div class="bdsharebuttonbox"><a href="#" class="bds_more" data-cmd="more"></a><a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a><a href="#" class="bds_sqq" data-cmd="sqq" title="分享到QQ好友"></a><a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a><a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a><a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a><a href="#" class="bds_renren" data-cmd="renren" title="分享到人人网"></a><a href="#" class="bds_douban" data-cmd="douban" title="分享到豆瓣网"></a></div>
<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"1","bdSize":"24"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script> 


<!-----------------------------

										<a href="#" class="social-icon social-icon-sm social-icon-transparent social-facebook pull-left" data-toggle="tooltip" data-placement="top" title="Facebook">
											<i class="icon-facebook"></i>
											<i class="icon-facebook"></i>
										</a>

										<a href="#" class="social-icon social-icon-sm social-icon-transparent social-twitter pull-left" data-toggle="tooltip" data-placement="top" title="Twitter">
											<i class="icon-twitter"></i>
											<i class="icon-twitter"></i>
										</a>

										<a href="#" class="social-icon social-icon-sm social-icon-transparent social-gplus pull-left" data-toggle="tooltip" data-placement="top" title="Google plus">
											<i class="icon-gplus"></i>
											<i class="icon-gplus"></i>
										</a>

										<a href="#" class="social-icon social-icon-sm social-icon-transparent social-linkedin pull-left" data-toggle="tooltip" data-placement="top" title="Linkedin">
											<i class="icon-linkedin"></i>
											<i class="icon-linkedin"></i>
										</a>
<-------------------->
									</div>
									
				
									<!-- /Share -->


									<!-- rating -----------------------------
									<div class="rating rating-4 size-13 margin-top-10 width-100"><!-- rating-0 ... rating-5 -------------</div>
									<!-- /rating -->									

								</div>
								<!-- /ITEM DESC -->

							</div>



							<ul id="myTab" class="nav nav-tabs nav-top-border margin-top-30" role="tablist">
								<li role="presentation" class="active"><a href="#description" role="tab" data-toggle="tab">产品详情</a></li>
								<!--li role="presentation"><a href="#specs" role="tab" data-toggle="tab">备用选项卡</a></li-->
								<li role="presentation"><a href="#reviews" role="tab" data-toggle="tab">产品评价</a></li>
							</ul>

							<div class="tab-content padding-top-20">
								<!-- DESCRIPTION -->
								<div role="tabpanel" class="tab-pane fade in active" id="description">
										<table class="table table-hover">
											<thead>
												<tr>
													<th>规格参数</th>
													<th></th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>功率</td>
													<td><s:property value="#request.power"/></td>
												</tr>
												<tr>
													<td>色温</td>
													<td><s:property value="#request.colortemp"/></td>
												</tr>
												<tr>
													<td>光通量</td>
													<td><s:property value="#request.luminousflux"/></td>
												</tr>
												<tr>
													<td>尺寸</td>
													<td>123X74cm</td>
												</tr>
												<tr>
													<td>重量</td>
													<td><i class="fa fa-check text-success"></i> YES</td>
												</tr>
												<tr>
													<td>其他参数</td>
													<td><i class="glyphicon glyphicon-remove text-danger"></i> NO</td>
												</tr>
											</tbody>
										</table>
									<div style="text-indent:2em;line-height:2">
									<p>产品图文详细说明描述，产品图文详细说明描述，产品文字详细说明描述产品文字详细说明描述，产品文字详细说明描述产品文字详细说明描述，产品文字详细说明描述产品文字详细说明描述，产品文字详细说明描述产品文字详细说明描述，产品文字详细说明描述产品文字详细说明描述，产品文字详细说明描述产品文字详细说明描述，产品文字详细说明描述.</p>
									<p><img src=<s:property value="#request.picture[0]"/> width="800" height="960" alt="" /></p>
									<p>产品文字详细说明描述，产品文字详细说明描述产品文字详细说明描述，产品文字详细说明描述产品文字详细说明描述，产品文字详细说明描述产品文字详细说明描述，产品文字详细说明描述产品文字详细说明描述，产品文字详细说明描述产品文字详细说明描述，产品文字详细说明描述产品文字详细说明描述，产品文字详细说明描述产品文字详细说明描述，产品文字详细说明描述.</p>
									
									</div>
								</div>
								
								<!-- SPECIFICATIONS ------------------------------------------------------
								<div role="tabpanel" class="tab-pane fade" id="specs">
									<div class="table-responsive">
										<table class="table table-hover">
											<thead>
												<tr>
													<th>Column name</th>
													<th>Column name</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>Size</td>
													<td>2XL</td>
												</tr>
												<tr>
													<td>Color</td>
													<td>Red</td>
												</tr>
												<tr>
													<td>Weight</td>
													<td>132lbs</td>
												</tr>
												<tr>
													<td>Height</td>
													<td>74cm</td>
												</tr>
												<tr>
													<td>Bluetooth</td>
													<td><i class="fa fa-check text-success"></i> YES</td>
												</tr>
												<tr>
													<td>Wi-Fi</td>
													<td><i class="glyphicon glyphicon-remove text-danger"></i> NO</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
								
								<!-- REVIEWS -->
								<div role="tabpanel" class="tab-pane fade" id="reviews">
									<!-- REVIEW ITEM -->
									<div class="block margin-bottom-60">

										<span class="user-avatar"><!-- user-avatar -->
											<img class="pull-left media-object" src="assets/images/avatar2.jpg" width="64" height="64" alt="">
										</span>

										<div class="media-body">
											<h4 class="media-heading size-14">
												会员用户名 &ndash; 
												<span class="text-muted">2016-07-22 14:56</span> &ndash;
												<span class="size-14 text-muted"><!-- stars -->
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star-o"></i>
												</span>
											</h4>
											
											<p>
												评论的内容评论的内容评论的内容评论的内容评论的内容评论的内容评论的内容评论的内容
											</p>
										<h4 class="media-heading size-14">管理员回复</h4>
											<p>
												如果有回复的内容则显示在这里，如果没有回复的内容则不显示
											</p>

										</div>

									</div>
									<!-- /REVIEW ITEM -->

									<!-- REVIEW ITEM -->
									<div class="block margin-bottom-30">

										<span class="user-avatar"><!-- user-avatar -->
											<img class="pull-left media-object" src="assets/images/avatar2.jpg" width="64" height="64" alt="">
										</span>

										<div class="media-body">
											<h4 class="media-heading size-14">
												John Doe &ndash; 
												<span class="text-muted">June 29, 2014 - 11:23</span> &ndash;
												<span class="size-14 text-muted"><!-- stars -->
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star-o"></i>
													<i class="fa fa-star-o"></i>
												</span>
											</h4>
											
											<p>
												评论的内容评论的内容评论的内容评论的内容评论的内容评论的内容评论的内容评论的内容
											</p>

										</div>

									</div>
									<!-- /REVIEW ITEM -->


									<!-- REVIEW FORM 回复表单提交-------------------------------------------------------
									<h4 class="page-header margin-bottom-40">ADD A REVIEW</h4>
									<form method="post" action="#" id="form">
										
										<div class="row margin-bottom-10">
											
											<div class="col-md-6 margin-bottom-10">
												<!-- Name -------------------------------------------------------
												<input type="text" name="name" id="name" class="form-control" placeholder="Name *" maxlength="100" required="">
											</div>
											
											<div class="col-md-6">
												<!-- Email --------------------------------------------------------
												<input type="email" name="email" id="email" class="form-control" placeholder="Email *" maxlength="100" required="">
											</div>
											
										</div>
										
										<!-- Comment --------------------------------------------------------------
										<div class="margin-bottom-30">
											<textarea name="text" id="text" class="form-control" rows="6" placeholder="Comment" maxlength="1000"></textarea>
										</div>

										<!-- Stars -----------------------------------------------------
										<div class="product-star-vote clearfix">

											<label class="radio pull-left">
												<input type="radio" name="product-review-vote" value="1" />
												<i></i> 1 Star
											</label>

											<label class="radio pull-left">
												<input type="radio" name="product-review-vote" value="2" />
												<i></i> 2 Stars
											</label>

											<label class="radio pull-left">
												<input type="radio" name="product-review-vote" value="3" />
												<i></i> 3 Stars
											</label>

											<label class="radio pull-left">
												<input type="radio" name="product-review-vote" value="4" />
												<i></i> 4 Stars
											</label>

											<label class="radio pull-left">
												<input type="radio" name="product-review-vote" value="5" />
												<i></i> 5 Stars
											</label>

										</div>

										<!-- Send Button --------------------------------------------------------
										<button type="submit" class="btn btn-primary"><i class="fa fa-check"></i> Send Review</button>
										
									</form>
									<!-- /REVIEW FORM -->

								</div>
							</div>


							<hr class="margin-top-30 margin-bottom-30" />


							<h2 class="owl-featured"><strong>您可能感兴趣的同类产品：</strong> </h2>
							<div class="owl-carousel featured nomargin owl-padding-10" data-plugin-options='{"singleItem": false, "items": "4", "stopOnHover":false, "autoPlay":4500, "autoHeight": false, "navigation": true, "pagination": false}'>

								<!-- item -->
								<div class="shop-item nomargin">

									<div class="thumbnail">
										<!-- product image(s) -->
										<a class="shop-item-image" href="3.html">
											<!-- CAROUSEL -->
											<div class="owl-carousel owl-padding-0 nomargin" data-plugin-options='{"singleItem": true, "autoPlay": 3000, "navigation": false, "pagination": false, "transitionStyle":"fadeUp"}'>
												<img class="img-responsive" src="assets/images/demo/shop/products/300x360/p5.jpg" alt="">
												<img class="img-responsive" src="assets/images/demo/shop/products/300x360/p1.jpg" alt="">
											</div>
											<!-- /CAROUSEL -->
										</a>
										<!-- /product image(s) -->

									</div>
									
									<div class="shop-item-summary text-center">
										<a href="4.html"><h2>led筒灯3w超薄2.5寸</h2></a>
										<div class="size-13">7.5开孔 8公分嵌入式</div>
										
										<!-- price -->
										<div class="shop-item-price">
											特价：¥ 9.80
										</div>
										<!-- /price -->
									</div>

										<!-- buttons -->
										<div class="shop-item-buttons text-center">
										<a href="4.html" class="btn btn-default"> <i class="fa fa-cart-plus"></i>加入购物车</a>
										</div>
										<!-- /buttons -->
								</div>
								<!-- /item -->

								<!-- item -->
								<div class="shop-item nomargin">

									<div class="thumbnail">
										<!-- product image(s) -->
										<a class="shop-item-image" href="3.html">
											<img class="img-responsive" src="assets/images/demo/shop/products/300x360/p2.jpg" alt="shop first image" />
											<img class="img-responsive" src="assets/images/demo/shop/products/300x360/p12.jpg" alt="shop hover image" />
										</a>
										<!-- /product image(s) -->
										<!-- countdown -->
										<div class="shop-item-counter">
											<div class="countdown" data-from="December 31, 2017 08:22:01" data-labels="年,月,周,天,时,分,秒"><!-- Example Date From: December 31, 2018 15:03:26 --></div>
										</div>
										<!-- /countdown -->
										<!-- product more info -->
										<div class="shop-item-info">
											<span class="label label-success">NEW</span>
											<span class="label label-danger">SALE</span>
										</div>
										<!-- /product more info -->
									</div>
									
									<div class="shop-item-summary text-center">
										<a href="4.html"><h2>4分四通内丝铜水管接头</h2></a>
										<div class="size-13">内螺纹 4分四通水暖接头</div>

										<!-- price -->
										<div class="shop-item-price">
											特价：¥ 6.80
										</div>
										<!-- /price -->
									</div>

										<!-- buttons -->
										<div class="shop-item-buttons text-center">	
										<a href="4.html" class="btn btn-default"> <i class="fa fa-cart-plus"></i>加入购物车</a>
										</div>
										<!-- /buttons -->
								</div>
								<!-- /item -->

								<!-- item -->
								<div class="shop-item nomargin">

									<div class="thumbnail">
										<!-- product image(s) -->
										<a class="shop-item-image" href="3.html">
											<img class="img-responsive" src="assets/images/demo/shop/products/300x360/p8.jpg" alt="shop first image" />
										</a>
										<!-- /product image(s) -->

									</div>
									
									<div class="shop-item-summary text-center">
										<a href="4.html"><h2>F1四开单控开关</h2></a>
										<div class="size-13">86型墙壁开关插座</div>

										<!-- price -->
										<div class="shop-item-price">
											特价：¥ 5.00
										</div>
										<!-- /price -->
									</div>

										<!-- buttons -->
										<div class="shop-item-buttons text-center">	

										<a href="4.html" class="btn btn-default"> <i class="fa fa-cart-plus"></i>加入购物车</a>
										</div>
										<!-- /buttons -->
								</div>
								<!-- /item -->
								
								<!-- item-->
								<div class="shop-item nomargin">

									<div class="thumbnail">
										<!-- product image(s) -->
										<a class="shop-item-image" href="3.html">
											<img class="img-responsive" src="assets/images/demo/shop/products/300x360/p13.jpg" alt="shop first image" />
											<img class="img-responsive" src="assets/images/demo/shop/products/300x360/p14.jpg" alt="shop hover image" />
										</a>
										<!-- /product image(s) -->
										<!-- countdown -->
										<div class="shop-item-counter">
											<div class="countdown" data-from="December 31, 2016 08:22:01" data-labels="年,月,周,天,时,分,秒"><!-- Example Date From: December 31, 2018 15:03:26 --></div>
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
										<a href="4.html"><h2>E27大螺口玉米灯 5W</h2></a>
										<div class="size-13">发光颜色：暖白</div>
										<!-- rating --
										<div class="shop-item-rating-line">
											<div class="rating rating-4 size-13"><!--rating-0 ... rating-5-></div>
										</div >
										<!-- /rating -->

										<!-- price -->
										<div class="shop-item-price">
											<!--span class="line-through">$98.00</span-->
											特价：¥ 3.80
										</div>
										<!-- /price -->
									</div>

										<!-- buttons -->
										<div class="shop-item-buttons text-center">
										<a href="4.html" class="btn btn-default"> <i class="fa fa-cart-plus"></i>加入购物车</a>

										</div>
										<!-- /buttons -->
								</div>
								<!-- /item -->

								<!-- item -->
								<div class="shop-item nomargin">

									<div class="thumbnail">
										<!-- product image(s) -->
										<a class="shop-item-image" href="3.html">
											<!-- CAROUSEL -->
											<div class="owl-carousel owl-padding-0 nomargin" data-plugin-options='{"singleItem": true, "autoPlay": 3000, "navigation": false, "pagination": false, "transitionStyle":"fadeUp"}'>
												<img class="img-responsive" src="assets/images/demo/shop/products/300x360/p5.jpg" alt="">
												<img class="img-responsive" src="assets/images/demo/shop/products/300x360/p1.jpg" alt="">
											</div>
											<!-- /CAROUSEL -->
										</a>
										<!-- /product image(s) -->
									</div>
									
									<div class="shop-item-summary text-center">
										<a href="4.html"><h2>led筒灯3w超薄2.5寸</h2></a>
										<div class="size-13">7.5开孔 8公分嵌入式</div>
										
										<!-- price -->
										<div class="shop-item-price">
											特价：¥ 9.80
										</div>
										<!-- /price -->
									</div>

										<!-- buttons -->
										<div class="shop-item-buttons text-center">
										<a href="4.html" class="btn btn-default"> <i class="fa fa-cart-plus"></i>加入购物车</a>
										</div>
										<!-- /buttons -->
								</div>
								<!-- /item -->								

							</div>

						</div>


						<!-- LEFT -->
						<div class="col-lg-3 col-md-3 col-sm-3 col-lg-pull-9 col-md-pull-9 col-sm-pull-9">

							<!-- CATEGORIES -->
							<div class="side-nav margin-bottom-40">

								<div class="side-nav-head">
									<button class="fa fa-bars"></button>
									<h4>产品分类</h4>
								</div>

								<ul class="list-group list-group-bordered list-group-noicon uppercase">
									<li class="list-group-item "><!--加上active就是默认展开-->
										<a class="dropdown-toggle" href="#">照明产品</a>
										<ul>
											<li><a href="#"><span class="size-11 text-muted pull-right">(123)</span> 照明产品二级分类</a></li>
											<li class="active"><a href="#"><span class="size-11 text-muted pull-right">(331)</span> 照明产品二级分类</a></li>
											<li><a href="#"><span class="size-11 text-muted pull-right">(234)</span> 照明产品二级分类</a></li>
										</ul>
									</li>
									<li class="list-group-item">
										<a class="dropdown-toggle" href="#">电工产品</a>
										<ul>
											<li><a href="#"><span class="size-11 text-muted pull-right">(88)</span> 电工产品二级分类</a></li>
											<li><a href="#"><span class="size-11 text-muted pull-right">(67)</span> 电工产品二级分类</a></li>
											<li><a href="#"><span class="size-11 text-muted pull-right">(32)</span> 电工产品二级分类</a></li>
											<li class="active"><a href="#"><span class="size-11 text-muted pull-right">(78)</span> 电工产品二级分类</a></li>
										</ul>
									</li>
									<li class="list-group-item">
										<a class="dropdown-toggle" href="#">水暖产品</a>
										<ul>
											<li><a href="#"><span class="size-11 text-muted pull-right">(23)</span> 水暖产品二级分类</a></li>
											<li><a href="#"><span class="size-11 text-muted pull-right">(34)</span> 水暖产品二级分类</a></li>
											<li class="active"><a href="#"><span class="size-11 text-muted pull-right">(21)</span> 水暖产品二级分类</a></li>
											<li><a href="#"><span class="size-11 text-muted pull-right">(88)</span> 水暖产品二级分类</a></li>
										</ul>
									</li>

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
									<li class="list-group-item"><a href="#"><span class="size-11 text-muted pull-right">(21)</span> 每月特价</a></li>
									<li class="list-group-item"><a href="#"><span class="size-11 text-muted pull-right">(44)</span> 拼单团购</a></li>
									<li class="list-group-item"><a href="#"><span class="size-11 text-muted pull-right">(2)</span> 众筹预售</a></li>
								</ul>

							</div>
							<!-- BRANDS -->



							<!-- FEATURED 热销推荐开始--------------->
							<div class="margin-bottom-60">

								<h2 class="owl-featured">热销推荐</h2>
								<div class="owl-carousel featured" data-plugin-options='{"singleItem": true, "stopOnHover":false, "autoPlay":false, "autoHeight": false, "navigation": true, "pagination": false}'>
									
									<div><!-- SLIDE 1 -->
										<ul class="list-unstyled nomargin nopadding text-left">
										
											<li class="clearfix"><!-- item -->
												<div class="thumbnail featured clearfix pull-left">
													<a href="#">
														<img src="assets/images/demo/shop/products/100x100/p6.jpg" width="80" height="80" alt="featured item">
													</a>
												</div>
                                                  <a class="block size-1 margin-bottom-10" href="4.html">电工产品名称标题</a>
												  <!--div class="rating rating-4 size-13 width-100 text-left">< rating-0 ... rating-5 -></div-->
												  <div class="size-12 text-left margin-bottom-8">产品简短文字说明</div>
											      <div class="size-18 text-left">¥ 7.50</div>
											</li><!-- /item -->

											<li class="clearfix"><!-- item -->
												<div class="thumbnail featured clearfix pull-left">
													<a href="4.html">
														<img src="assets/images/demo/shop/products/100x100/p10.jpg" width="80" height="80" alt="featured item">
													</a>
												</div>
                                                  <a class="block size-1 margin-bottom-10" href="4.html">E27大螺口玉米灯 5W</a>
												  <!--div class="rating rating-4 size-13 width-100 text-left">< rating-0 ... rating-5 -></div-->
												  <div class="size-12 text-left margin-bottom-8">发光颜色: 暖白</div>
												
												<div class="size-18 text-left">¥ 6.00</div>
											</li><!-- /item -->

											<li class="clearfix"><!-- item -->
												<div class="thumbnail featured clearfix pull-left">
													<a href="#">
														<img src="assets/images/demo/shop/products/100x100/p6.jpg" width="80" height="80" alt="featured item">
													</a>
												</div>
                                                  <a class="block size-1 margin-bottom-10" href="4.html">电工产品名称标题</a>
												  <!--div class="rating rating-4 size-13 width-100 text-left">< rating-0 ... rating-5 -></div-->
												  <div class="size-12 text-left margin-bottom-8">产品简短文字说明</div>
											      <div class="size-18 text-left">¥ 7.50</div>
											</li><!-- /item -->

     										<li class="clearfix"><!-- item -->
												<div class="thumbnail featured clearfix pull-left">
													<a href="#">
														<img src="assets/images/demo/shop/products/100x100/p14.jpg" width="80" height="80" alt="featured item">
													</a>
												</div>
                                                  <a class="block size-1 margin-bottom-10" href="4.html">水暖产品名称标题</a>
												  <!--div class="rating rating-4 size-13 width-100 text-left">< rating-0 ... rating-5 -></div-->
												  <div class="size-12 text-left margin-bottom-8">产品简短文字说明</div>
											      <div class="size-18 text-left">¥ 6.00</div>
											</li><!-- /item -->											

										</ul>
									</div><!-- /SLIDE 1 -->

									<div><!-- SLIDE 2 -->
										<ul class="list-unstyled nomargin nopadding text-left">
											
											<li class="clearfix"><!-- item -->
												<div class="thumbnail featured clearfix pull-left">
													<a href="#">
														<img src="assets/images/demo/shop/products/100x100/p14.jpg" width="80" height="80" alt="featured item">
													</a>
												</div>
                                                  <a class="block size-1 margin-bottom-10" href="4.html">水暖产品名称标题</a>
												  <!--div class="rating rating-4 size-13 width-100 text-left">< rating-0 ... rating-5 -></div-->
												  <div class="size-12 text-left margin-bottom-8">产品简短文字说明</div>
											      <div class="size-18 text-left">¥ 3.00</div>
											</li><!-- /item -->			
											
											<li class="clearfix"><!-- item -->
												<div class="thumbnail featured clearfix pull-left">
													<a href="#">
														<img src="assets/images/demo/shop/products/100x100/p6.jpg" width="80" height="80" alt="featured item">
													</a>
												</div>
                                                  <a class="block size-1 margin-bottom-10" href="4.html">电工产品名称标题</a>
												  <!--div class="rating rating-4 size-13 width-100 text-left">< rating-0 ... rating-5 -></div-->
												  <div class="size-12 text-left margin-bottom-8">产品简短文字说明</div>
											      <div class="size-18 text-left">¥ 7.50</div>
											</li><!-- /item -->

											<li class="clearfix"><!-- item -->
												<div class="thumbnail featured clearfix pull-left">
													<a href="#">
														<img src="assets/images/demo/shop/products/100x100/p14.jpg" width="80" height="80" alt="featured item">
													</a>
												</div>
                                                  <a class="block size-1 margin-bottom-10" href="4.html">照明产品名称标题</a>
												  <!--div class="rating rating-4 size-13 width-100 text-left">< rating-0 ... rating-5 -></div-->
												  <div class="size-12 text-left margin-bottom-8">产品简短文字说明</div>
											      <div class="size-18 text-left">¥ 13.60</div>
											</li><!-- /item -->
											
											<li class="clearfix"><!-- item -->
												<div class="thumbnail featured clearfix pull-left">
													<a href="4.html">
														<img src="assets/images/demo/shop/products/100x100/p10.jpg" width="80" height="80" alt="featured item">
													</a>
												</div>
                                                  <a class="block size-1 margin-bottom-10" href="4.html">E27大螺口玉米灯 5W</a>
												  <!--div class="rating rating-4 size-13 width-100 text-left">< rating-0 ... rating-5 -></div-->
												  <div class="size-12 text-left margin-bottom-8">发光颜色: 暖白</div>
												
												<div class="size-18 text-left">¥ 6.00</div>
											</li><!-- /item -->
										</ul>
									</div><!-- /SLIDE 2 -->

								</div>
							
							</div>
							<!-- /FEATURED 热销推荐结束--------->
							
							
							<!-- FEATURED 新品上市开始---------------->
							<div class="margin-bottom-60">

								<h2 class="owl-featured">新品上市</h2>
								<div class="owl-carousel featured" data-plugin-options='{"singleItem": true, "stopOnHover":false, "autoPlay":false, "autoHeight": false, "navigation": true, "pagination": false}'>
									
									<div><!-- SLIDE 1 -->
										<ul class="list-unstyled nomargin nopadding text-left">
											
											<li class="clearfix"><!-- item -->
												<div class="thumbnail featured clearfix pull-left">
													<a href="#">
														<img src="assets/images/demo/shop/products/100x100/p14.jpg" width="80" height="80" alt="featured item">
													</a>
												</div>
                                                  <a class="block size-1 margin-bottom-10" href="4.html">水暖产品名称标题</a>
												  <!--div class="rating rating-4 size-13 width-100 text-left">< rating-0 ... rating-5 -></div-->
												  <div class="size-12 text-left margin-bottom-8">产品简短文字说明</div>
											      <div class="size-18 text-left">¥ 3.00</div>
											</li><!-- /item -->			
											
											<li class="clearfix"><!-- item -->
												<div class="thumbnail featured clearfix pull-left">
													<a href="4.html">
														<img src="assets/images/demo/shop/products/100x100/p10.jpg" width="80" height="80" alt="featured item">
													</a>
												</div>
                                                  <a class="block size-1 margin-bottom-10" href="4.html">E27大螺口玉米灯 5W</a>
												  <!--div class="rating rating-4 size-13 width-100 text-left">< rating-0 ... rating-5 -></div-->
												  <div class="size-12 text-left margin-bottom-8">发光颜色: 暖白</div>
												
												<div class="size-18 text-left">¥ 6.00</div>
											</li><!-- /item -->

											<li class="clearfix"><!-- item -->
												<div class="thumbnail featured clearfix pull-left">
													<a href="#">
														<img src="assets/images/demo/shop/products/100x100/p6.jpg" width="80" height="80" alt="featured item">
													</a>
												</div>
                                                  <a class="block size-1 margin-bottom-10" href="4.html">电工产品名称标题</a>
												  <!--div class="rating rating-4 size-13 width-100 text-left">< rating-0 ... rating-5 -></div-->
												  <div class="size-12 text-left margin-bottom-8">产品简短文字说明</div>
											      <div class="size-18 text-left">¥ 7.50</div>
											</li><!-- /item -->

     										<li class="clearfix"><!-- item -->
												<div class="thumbnail featured clearfix pull-left">
													<a href="#">
														<img src="assets/images/demo/shop/products/100x100/p14.jpg" width="80" height="80" alt="featured item">
													</a>
												</div>
                                                  <a class="block size-1 margin-bottom-10" href="4.html">水暖产品名称标题</a>
												  <!--div class="rating rating-4 size-13 width-100 text-left">< rating-0 ... rating-5 -></div-->
												  <div class="size-12 text-left margin-bottom-8">产品简短文字说明</div>
											      <div class="size-18 text-left">¥ 6.00</div>
											</li><!-- /item -->											

										</ul>
									</div><!-- /SLIDE 1 -->

									<div><!-- SLIDE 2 -->
										<ul class="list-unstyled nomargin nopadding text-left">
										
											<li class="clearfix"><!-- item -->
												<div class="thumbnail featured clearfix pull-left">
													<a href="#">
														<img src="assets/images/demo/shop/products/100x100/p6.jpg" width="80" height="80" alt="featured item">
													</a>
												</div>
                                                  <a class="block size-1 margin-bottom-10" href="4.html">电工产品名称标题</a>
												  <!--div class="rating rating-4 size-13 width-100 text-left">< rating-0 ... rating-5 -></div-->
												  <div class="size-12 text-left margin-bottom-8">产品简短文字说明</div>
											      <div class="size-18 text-left">¥ 7.50</div>
											</li><!-- /item -->										

											<li class="clearfix"><!-- item -->
												<div class="thumbnail featured clearfix pull-left">
													<a href="#">
														<img src="assets/images/demo/shop/products/100x100/p6.jpg" width="80" height="80" alt="featured item">
													</a>
												</div>
                                                  <a class="block size-1 margin-bottom-10" href="4.html">电工产品名称标题</a>
												  <!--div class="rating rating-4 size-13 width-100 text-left">< rating-0 ... rating-5 -></div-->
												  <div class="size-12 text-left margin-bottom-8">产品简短文字说明</div>
											      <div class="size-18 text-left">¥ 7.50</div>
											</li><!-- /item -->

											<li class="clearfix"><!-- item -->
												<div class="thumbnail featured clearfix pull-left">
													<a href="#">
														<img src="assets/images/demo/shop/products/100x100/p14.jpg" width="80" height="80" alt="featured item">
													</a>
												</div>
                                                  <a class="block size-1 margin-bottom-10" href="4.html">照明产品名称标题</a>
												  <!--div class="rating rating-4 size-13 width-100 text-left">< rating-0 ... rating-5 -></div-->
												  <div class="size-12 text-left margin-bottom-8">产品简短文字说明</div>
											      <div class="size-18 text-left">¥ 13.60</div>
											</li><!-- /item -->
											
											<li class="clearfix"><!-- item -->
												<div class="thumbnail featured clearfix pull-left">
													<a href="#">
														<img src="assets/images/demo/shop/products/100x100/p14.jpg" width="80" height="80" alt="featured item">
													</a>
												</div>
                                                  <a class="block size-1 margin-bottom-10" href="4.html">水暖产品名称标题</a>
												  <!--div class="rating rating-4 size-13 width-100 text-left">< rating-0 ... rating-5 -></div-->
												  <div class="size-12 text-left margin-bottom-8">产品简短文字说明</div>
											      <div class="size-18 text-left">¥ 3.00</div>
											</li><!-- /item -->											

										</ul>
									</div><!-- /SLIDE 2 -->

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
			<footer id="footer">

				<div class="copyright">
				  <div class="container">
						<ul class="pull-right nomargin list-inline mobile-block">
						
	<a href="http://www.miitbeian.gov.cn" target="_blank">闽ICP备16014139号</a>
						</ul>
						
					      厦门光服科技有限公司 &copy;  <a href="#"> 照明 </a>&bull;<a href="#"> 电工 </a>&bull;<a href="#"> 水暖 </a>					</div>
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
		</div><!-- /PRELOADER -->


		<!-- JAVASCRIPT FILES -->
		<script type="text/javascript">var plugin_path = 'assets/plugins/';</script>
		<script type="text/javascript" src="assets/plugins/jquery/jquery-2.1.4.min.js"></script>

		<script type="text/javascript" src="assets/js/scripts.js"></script>


		<!-- PAGE LEVEL SCRIPTS -->
		<script type="text/javascript" src="assets/js/view/demo.shop.js"></script>
	</body>
</html>
