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



<link href="newpages/assets/css/img-responsive.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="newpages/assets/js/producttype.js"></script>
<script type="text/javascript" src="newpages/assets/js/cart.js"></script>
<script type="text/javascript" src="newpages/assets/js/navbar.js"></script>

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
<body onload="pageLoad()" class="smoothscroll enable-animation">

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
								src="<s:property value='#homeslides.picturepath' />" width="851"
								height="335" alt="">
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

					<div id="spepri" class="options-left">
						<select>
							<option value="pos_asc">全部产品</option>
							<option value="pos_desc">照明</option>
							<option value="name_asc">电工</option>
							<option value="name_desc">水暖</option>
						</select> <a class="btn btn-danger" href="#description"
							onclick="spepri(this)">每月特价</a> <a class="btn btn-danger"
							href="#specs" onclick="spepri(this)">拼单团购</a> <a
							class="btn btn-danger" href="#reviews" onclick="spepri(this)">众筹预售</a>
						<!--a class="btn active fa fa-th" href="shop-4col-left.html"></a><!-- grid -->
						<!--a class="btn fa fa-list" href="shop-1col-left.html"></a><!-- list -->
					</div>

				</div>
				<!-- /LIST OPTIONS -->





				<!-- 商品展示列表 -->
				<!-----------每月特价内容开始----------------------------->
				<ul style="display:block" id="secondProductPictures1"
					class="shop-item-list row list-inline nomargin">

				</ul>

				<!-----------拼单团购内容开始----------------------------->

				<ul id="secondProductPictures2" style="display:none"
					class="shop-item-list row list-inline nomargin">
					<s:iterator value="%{secondProductPictures2}" id="shoplist2">
						<!-- ITEM -->
						<li class="col-lg-3 col-sm-3">

							<div class="shop-item">

								<div class="thumbnail">
									<!-- product image(s) -->
									<a class="shop-item-image"
										href="ProductShowAction?productid=<s:property value='#shoplist2.productId' />">
										<img class="img-responsive"
										src=".<s:property value='#shoplist2.picturepath'/>"
										alt="shop first image" /> <img class="img-responsive"
										src=".<s:property value='#shoplist2.picturepath'/>"
										alt="shop hover image" />
									</a>
									<!-- /product image(s) -->
									<!-- countdown -->
									<div class="shop-item-counter">
										<div class="countdown"
											data-from="<s:property value='#shoplist2.closingday'/>"
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
											<s:property value='#shoplist2.picturetitle' />
										</h2></a>
									<div class="size-13">
										<s:property value='#shoplist2.introduction' />
									</div>
									<!-- rating --
										<div class="shop-item-rating-line">
											<div class="rating rating-4 size-13"><!--rating-0 ... rating-5-></div>
										</div >
										<!-- /rating -->

									<!-- price -->
									<div class="shop-item-price">
										<!--span class="line-through">$98.00</span-->
										<s:property value='#shoplist2.discount' />
									</div>
									<!-- /price -->
								</div>

								<!-- buttons -->
								<div class="shop-item-buttons text-center">
									<button type="input" class="ss"
										onclick="addOneToCart(<s:property value='#shoplist2.productId' />, 1)">
										加入购物车</button>
								</div>
								<!-- /buttons -->
							</div>

						</li>
						<!-- /ITEM -->
					</s:iterator>
				</ul>

				<!-----------众筹预售内容开始----------------------------->
				<ul id="secondProductPictures3" style="display:none"
					class="shop-item-list row list-inline nomargin">
					<s:iterator value="%{secondProductPictures3}" id="shoplist3">
						<!-- ITEM -->
						<li class="col-lg-3 col-sm-3">

							<div class="shop-item">

								<div class="thumbnail">
									<!-- product image(s) -->
									<a class="shop-item-image"
										href="ProductShowAction?productid=<s:property value='#shoplist3.productId' />">
										<img class="img-responsive"
										src=".<s:property value='#shoplist3.picturepath'/>"
										alt="shop first image" /> <img class="img-responsive"
										src=".<s:property value='#shoplist3.picturepath'/>"
										alt="shop hover image" />
									</a>
									<!-- /product image(s) -->
									<!-- countdown -->
									<div class="shop-item-counter">
										<div class="countdown"
											data-from="<s:property value='#shoplist3.closingday'/>"
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
											<s:property value='#shoplist3.picturetitle' />
										</h2></a>
									<div class="size-13">
										<s:property value='#shoplist3.introduction' />
									</div>
									<!-- rating --
										<div class="shop-item-rating-line">
											<div class="rating rating-4 size-13"><!--rating-0 ... rating-5-></div>
										</div >
										<!-- /rating -->

									<!-- price -->
									<div class="shop-item-price">
										<!--span class="line-through">$98.00</span-->
										<s:property value='#shoplist3.discount' />
									</div>
									<!-- /price -->
								</div>

								<!-- buttons -->
								<div class="shop-item-buttons text-center">
									<button type="input" class="ss"
										onclick="addOneToCart(<s:property value='#shoplist3.productId' />, 1)">
										加入购物车</button>
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
						<li><a href="#" onclick="Previous()">&laquo;</a></li>
						<li class="active"><a class="selectpage" href=""
							onclick="selectPage(this)">1</a></li>
						<li><a class="selectpage" href=""
							onclick="selectPage(this)">2</a></li>
						<li><a class="selectpage" href=""
							onclick="selectPage(this)">3</a></li>
						<li><a class="selectpage" href=""
							onclick="selectPage(this)">4</a></li>
						<li><a class="selectpage" href=""
							onclick="selectPage(this)">5</a></li>
						<li><a href="#" onclick="Next()">&raquo;</a></li>
						<li><a onclick="init()">init()</a></li>
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
								class="size-11 text-muted pull-right">(<s:property
										value="listSnapupProduct.size" />)
							</span> 每月特价</a></li>
						<li class="list-group-item"><a href="#"><span
								class="size-11 text-muted pull-right">(<s:property
										value="listGroupProduct.size" />)
							</span> 拼单团购</a></li>
						<li class="list-group-item"><a href="#"><span
								class="size-11 text-muted pull-right">(<s:property
										value="listPresaleProduct.size" />)
							</span> 众筹预售</a></li>
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
												src=".<s:property value='#tpp1.picturepath'/>" width="80"
												height="80" alt="featured item">
											</a>
										</div> <a class="block size-1 margin-bottom-10"
										href="ProductShowAction?productid=<s:property value='#tpp1.productId' />"><s:property
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
												src=".<s:property value='#tpp2.picturepath'/>" width="80"
												height="80" alt="featured item">
											</a>
										</div> <a class="block size-1 margin-bottom-10"
										href="ProductShowAction?productid=<s:property value='#tpp2.productId' />"><s:property
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
								<s:iterator value="%{thirdProductPictures2}" id='tpp3' begin="0"
									end="2">
									<li class="clearfix">
										<!-- item -->
										<div class="thumbnail featured clearfix pull-left">
											<a href="#"> <img
												src=".<s:property value='#tpp3.picturepath'/>" width="80"
												height="80" alt="featured item">
											</a>
										</div> <a class="block size-1 margin-bottom-10"
										href="ProductShowAction?productid=<s:property value='#tpp3.productId' />"><s:property
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

								<s:iterator value="%{thirdProductPictures2}" id='tpp4' begin="3"
									end="5">
									<li class="clearfix">
										<!-- item -->
										<div class="thumbnail featured clearfix pull-left">
											<a href="#"> <img
												src=".<s:property value='#tpp4.picturepath'/>" width="80"
												height="80" alt="featured item">
											</a>
										</div> <a class="block size-1 margin-bottom-10"
										href="ProductShowAction?productid=<s:property value='#tpp4.productId' />"><s:property
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
									<img class="img-responsive" src="newpages/assets/images/demo/shop/banners/off_1.png" width="270" height="350" alt="">
								</a>
								<a href="#">
									<img class="img-responsive" src="newpages/assets/images/demo/shop/banners/off_2.png" width="270" height="350" alt="">
								</a>
							</div>
							<!-- /BANNER ROTATOR -->

				<!-- BANNER ROTATOR --------------------------->
				<div
					class="owl-carousel buttons-autohide controlls-over margin-bottom-10 text-center"
					data-plugin-options='{"singleItem": true,  "transitionStyle":"fadeUp"}'>
					<a href="#"> <img class="img-responsive"
						src="newpages/assets/images/demo/shop/banners/sq_1.png"
						width="270" height="200" alt="">
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
	<script type="text/javascript"
		src="newpages/assets/js/productCataLog.js"></script>

	<script type="text/javascript" src="newpages/assets/js/pagination.js"></script>

</body>
</html>