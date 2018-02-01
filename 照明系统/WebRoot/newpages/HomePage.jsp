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
<link href="newpages/assets/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />

<!-- THEME CSS -->
<link href="newpages/assets/css/essentials.css" rel="stylesheet" type="text/css" />
<link href="newpages/assets/css/layout.css" rel="stylesheet" type="text/css" />

<!-- PAGE LEVEL SCRIPTS -->
<link href="newpages/assets/css/header-1.css" rel="stylesheet" type="text/css" />
<link href="newpages/assets/css/layout-shop.css" rel="stylesheet" type="text/css" />
<link href="newpages/assets/css/color_scheme/green.css" rel="stylesheet"
	type="text/css" id="color_scheme" />


<link href="newpages/assets/css/img-responsive.css" rel="stylesheet"
	type="text/css" />

<script type="text/javascript" src="newpages/assets/js/producttype.js"></script>
<script type="text/javascript" src="newpages/assets/js/cart.js"></script>
<script type="text/javascript" src="newpages/assets/js/map-baidu.js"></script>

</head>

<body onload="productTypes()" class="smoothscroll enable-animation">

	<!-- HEAD -->
	<%@ include file="head.jsp"%>
	<!-- /HEAD -->

	<!----------------------------------------------------------中间内容开始，以上是顶部内容---------------------------------------------------------------------------------------->


	<!-- SLIDER -->
	<section class="padding-top-40">
		<div class="container">

			<!-- OWL SLIDER -->
			<div class="owl-carousel buttons-autohide controlls-over nomargin"
				data-plugin-options='{"items": 1, "autoHeight": false, "navigation": true, "pagination": false, "transitionStyle":"fade", "progressBar":"true"}'>

				<div>
						<a href="#"> <img class="img-responsive"
								src="newpages/assets/images/demo/shop/banners/home_slider_2.jpg" alt="">
						</a>
					</div>
					
					<div>
						<a href="#"> <img class="img-responsive"
								src="newpages/assets/images/demo/shop/banners/home_slider_1.jpg" alt="">
						</a>
					</div>

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
						<a class="image-hover"
							href="ProductCatalog_retreiveAllByProdtypeId?producttypeId=<s:property value='firstProducPictures[0].producttypeId' />">
							<img class="img-responsive"
							src="<s:property value='firstProducPictures[0].picturepath' />"
							alt="" />
						</a> <a class="box-image-title"
							href="ProductCatalog_retreiveAllByProdtypeId?producttypeId=<s:property value='firstProducPictures[0].producttypeId' />">
							<h2>
								<s:property value="firstProducPictures[0].typename" />
							</h2>
						</a>
						<p class="font-lato weight-300">
							<s:property value="firstProducPictures[0].propaganda" />
						</p>
					</div>

				</div>

				<div class="col-md-4">

					<div class="box-image text-center">
						<a class="image-hover"
							href="ProductCatalog_retreiveAllByProdtypeId?producttypeId=<s:property value='firstProducPictures[1].producttypeId' />">
							<img class="img-responsive"
							src="<s:property value='firstProducPictures[1].picturepath' />"
							alt="" />
						</a> <a class="box-image-title"
							href="ProductCatalog_retreiveAllByProdtypeId?producttypeId=<s:property value='firstProducPictures[1].producttypeId' />">
							<h2>
								<s:property value="firstProducPictures[1].typename" />
							</h2>
						</a>
						<p class="font-lato weight-300">
							<s:property value="firstProducPictures[1].propaganda" />
						</p>
					</div>

				</div>

				<div class="col-md-4">

					<div class="box-image text-center">
						<a class="image-hover"
							href="ProductCatalog_retreiveAllByProdtypeId?producttypeId=<s:property value='firstProducPictures[2].producttypeId' />">
							<img class="img-responsive"
							src="<s:property value='firstProducPictures[2].picturepath' />"
							alt="" />
						</a> <a class="box-image-title"
							href="ProductCatalog_retreiveAllByProdtypeId?producttypeId=<s:property value='firstProducPictures[2].producttypeId' />">
							<h2>
								<s:property value="firstProducPictures[2].typename" />
							</h2>
						</a>
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
						<li role="presentation" class="active"><a href="#description"
							role="tab" data-toggle="tab">每月特价</a></li>
						<li role="presentation"><a href="#specs" role="tab"
							data-toggle="tab">拼单团购</a></li>
						<li role="presentation"><a href="#reviews" role="tab"
							data-toggle="tab">众筹预售</a></li>
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
											<a class="shop-item-image"
												href="ProductShowAction?productid=<s:property value='#spp1.productId' />">
												<img class="img-responsive"
												src=".<s:property value='#spp1.picturepath' />"
												alt="shop first image" /> <img class="img-responsive"
												src=".<s:property value='#spp1.picturepath' />"
												alt="shop hover image" />
											</a>
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
												<span class="label label-success">新品</span> <span
													class="label label-danger">热卖</span>
											</div>
											<!-- /product more info -->
										</div>

										<div class="shop-item-summary text-center">
											<a
												href="ProductShowAction?productid=<s:property value='#spp1.productId' />"><h2>
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
											<button type="input" class="ss" onclick="addOneToCart(<s:property
												value='#spp1.productId' />, 1)">
												加入购物车
											</button>
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
											<a class="shop-item-image"
												href="ProductShowAction?productid=<s:property value='#spp2.productId' />">
												<img class="img-responsive"
												src=".<s:property value='#spp2.picturepath' />"
												alt="shop first image" /> <img class="img-responsive"
												src=".<s:property value='#spp2.picturepath' />"
												alt="shop hover image" />
											</a>
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
												<span class="label label-success">新品</span> <span
													class="label label-danger">热卖</span>
											</div>
											<!-- /product more info -->
										</div>

										<div class="shop-item-summary text-center">
											<a
												href="ProductShowAction?productid=<s:property value='#spp2.productId' />"><h2>
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
											<a
												href="ProductShowAction?productid=<s:property value='#spp2.productId' />"
												class="btn btn-default"> <i class="fa fa-cart-plus"></i>加入购物车
											</a>

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
											<a class="shop-item-image"
												href="ProductShowAction?productid=<s:property value='#spp3.productId' />">
												<!-- CAROUSEL -->
												<div class="owl-carousel owl-padding-0 nomargin"
													data-plugin-options='{"singleItem": true, "autoPlay": 3000, "navigation": false, "pagination": false, "transitionStyle":"fadeUp"}'>
													<img class="img-responsive"
														src=".<s:property value='#spp3.picturepath'/>" alt="">
													<img class="img-responsive"
														src=".<s:property value='#spp3.picturepath'/>" alt="">
												</div> <!-- /CAROUSEL -->
											</a>
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
											<a
												href="ProductShowAction?productid=<s:property value='#spp3.productId' />"><h2>
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
											<a
												href="ProductShowAction?productid=<s:property value='#spp3.productId' />"
												class="btn btn-default"> <i class="fa fa-cart-plus"></i>加入购物车
											</a>
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
												<a
													href="ProductShowAction?productid=<s:property value='#tpp1.productId' />">
													<img src=".<s:property value='#tpp1.picturepath'/>"
													width="80" height="80" alt="featured item">
												</a>
											</div> <a class="block size-1 margin-bottom-10"
											href="ProductShowAction?productid=<s:property value='#tpp1.productId' />"><s:property
													value='#tpp1.picturetitle' /> </a> <!--div class="rating rating-4 size-13 width-100 text-left">< rating-0 ... rating-5 -></div-->
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
									<s:iterator value="%{thirdProductPictures}" id='tpp2' begin="3"
										end="5">
										<li class="clearfix">
											<!-- item -->
											<div class="thumbnail featured clearfix pull-left">
												<a
													href="ProductShowAction?productid=<s:property value='#tpp2.productId' />">
													<img src=".<s:property value='#tpp2.picturepath'/>"
													width="80" height="80" alt="featured item">
												</a>
											</div> <a class="block size-1 margin-bottom-10"
											href="ProductShowAction?productid=<s:property value='#tpp2.productId' />"><s:property
													value='#tpp2.picturetitle' /> </a> <!--div class="rating rating-4 size-13 width-100 text-left">< rating-0 ... rating-5 -></div-->
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
							src="newpages/assets/images/demo/shop/banners/sq_1.png" width="270"
							height="200" alt="">
						</a>

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

			<!-- GMAP.JS http://hpneo.github.io/gmaps/ -->

			<script type="text/javascript"
				src="http://api.map.baidu.com/api?v=2.0&ak=A81145b191c68e5055d735777fa746b8"></script>
			<!--百度地图容器-->
			<div
				style="width: 100%; height: 550px; border: #ccc solid 1px; font-size: 12px; align: center;"
				id="map">
			</div>


			<script type="text/javascript">
				
				//create Baidu map
				var map;
				initMap();
				
			</script>
		</div>


		<!-- BRANDS -->
	</section>

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

	<!-- STYLESWITCHER - REMOVE 样式
		<script async type="text/javascript" src="newpages/assets/plugins/styleswitcher/styleswitcher.js"></script>-->

	<!-- PAGE LEVEL SCRIPTS -->
	<script type="text/javascript" src="newpages/assets/js/view/demo.shop.js"></script>

</body>
</html>