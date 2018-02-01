<%@ page language="java" import="java.util.*,com.entity.Userinfo"
	pageEncoding="UTF-8"%>
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
<title>购物车页面——厦门光服科技有限公司</title>
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
<script src="./js/jquery-1.11.1.min.js"></script>
<script src="./js/bootstrap.min.js" type="text/javascript"></script>

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
<body onload="productTypes(); getProductList()"
	class="smoothscroll enable-animation"">

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

			<h1>我的购物车</h1>

			<!-- breadcrumbs -->
			<ol class="breadcrumb">
				<li><a href="#">首页</a></li>
				<li><a href="#">会员中心</a></li>
				<li class="active">购物车</li>
			</ol>
			<!-- /breadcrumbs -->

		</div>
	</section>
	<!-- /PAGE HEADER -->


	<!-- CART -->

	<div class="container padding-top-40 padding-bottom-40">


<s:if test="#session.userinfo == null ">
		<!-- EMPTY CART>
		<div class="panel panel-default">
			<div class="panel-body">
				<strong>这是会员中心的常规产品和特价产品购物车页面，登录后显示!</strong><br /> 如果未登录则提示，请点击 <a
					href="./LoginForm">这里登录。</a> 如果您还不是会员，请<a href="./RegisterForm">点击这里注册.</a>
				<br /> 如果登陆后未购物的，购物车没有待结算的产品内容，则提示：您的购物车是空的，请挑选自己喜欢的产品吧，<a
					href="./HomePage_retreiveAll">去购物>>></a>
				。如果购物车有待结算的产品内容，则以上内容不显示，而显示以下购物车的内容.
			</div>
		</div>
		</EMPTY CART -->
		
		<!-- EMPTY CART -->
		<div class="panel panel-default">
			<div class="panel-body" id="informMsg">
				如果您还未登录，请点击这里 <a	href="./LoginForm">登录。</a> 如果您还不是会员，请点击这里 <a href="./RegisterForm">注册。</a>
			</div>
		</div>
		<!-- /EMPTY CART -->
</s:if>
<s:else>
			<!-- CART -->
		<div class="row">

			<!-- LEFT -->
			<div class="col-lg-9 col-sm-8">

				<!-- CART -->
				<form id= "cartContentForm" class="cartContent clearfix" method="post" action="#">

					<!-- cart content -->
					<div id="cartContent">
						<!-- cart header -->
						<div class="item head clearfix">
							<span class="cart_img"></span> <span
								class="product_name size-13 bold">产品清单 <input
								type="checkbox" id="quan" onclick="checkUncheckAll()" />全选
							</span> <span class="remove_item size-13 bold"></span> <span
								class="total_price size-13 bold">价格</span> <span
								class="qty size-13 bold">数量</span>
						</div>
						<!-- 测试 
							<table id="cartTable">
								<tbody>

									<tr>
										<td class="mycheckbox"><input class="check-one check"
											type="checkbox" /></td>
										<td class="goods"><img src="images/1.jpg" alt="" /><span>Casio/卡西欧
												EX-TR350</span></td>
										<td class="price">20</td>
										<td class="count"><span class="reduce"></span><input
											class="count-input" type="text" value="1" /><span class="add">+</span></td>
										<td class="subtotal">20</td>
										<td class="operation"><span class="delete">删除</span></td>
									</tr>
									<tr>
										<td class="mycheckbox"><input class="check-one check"
											type="checkbox" /></td>
										<td class="goods"><img src="images/2.jpg" alt="" /><span>Canon/佳能
												PowerShot SX50 HS</span></td>
										<td class="price">30</td>
										<td class="count"><span class="reduce"></span><input
											class="count-input" type="text" value="12" /><span
											class="add">+</span></td>
										<td class="subtotal">30</td>
										<td class="operation"><span class="delete">删除</span></td>
									</tr>

								</tbody>
							</table>-->
						<!-- /cart header -->


						<!-- cart item -->
						<div id="cartItems">
							<!-- 购物车显示商品位置 -->
						</div>

						<!-- cart item -->
						<div class="item">
							<div class="cart_img pull-left width-100 padding-15 text-left">备注信息：</div>

							<div class="product_name">
								<input required type="text"
									value="非必填项，只能填字母、汉字、数字以及简单的字符，不能提交非法字符，如链接、函数等等。"
									class="form-control" name="contact[subject][required]"
									id="contact:subject">
							</div>
							<div class="product_nums">
								已选商品&nbsp;<span id="cartnumber">0</span>&nbsp;件，合计&nbsp;&yen;&nbsp;&nbsp;<span
									id="cartprice">0.00</span>
							</div>
							<div class="clearfix"></div>
						</div>
						<!-- /cart item -->



						<!-- update cart -->
						<!--  a href="./HomePage_retreiveAll">
							<button
								class="btn btn-success margin-top-20 margin-right-10 pull-right ">
								<i class="fa fa-mail-forward"></i> 继续购物
							</button>
						</a>

						<button
							class="btn btn-danger margin-top-20 margin-right-10 pull-right"
							onclick="return deleteAllCarts()">
							<i class="glyphicon glyphicon-remove"></i> 清空购物车
						</button -->

						<div class="containerShopping" style=" float:right;display:block">
							<a href="./HomePage_retreiveAll"><i
								class="fa fa-mail-forward"></i>继续购物 </a>
						</div>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<div style=" float:right;display:block"> 
							<a href="" onclick="deleteAllCarts()">
								<i class="glyphicon glyphicon-remove"></i>清空购物车
							</a>
						</div> 
						<!-- /update cart -->
						<div class="clearfix"></div>
					</div>
					<!-- /cart content -->

				</form>



				<!-- /CART -->

			</div>


			<!-- RIGHT -->
			<div class="col-lg-3 col-sm-4" id="rightDiv">

				<!-- TOGGLE -->
				<div class="toggle-transparent toggle-bordered-full clearfix">

					<div class="toggle nomargin-top">
						<label>您的积分</label>

						<div class="toggle-content">
							<p>您共有 5635 可用积分，100积分可抵现1元。请输入需要抵扣的积分值</p>

							<form action="#" method="post" class="nomargin">
								<input type="text" id="cart-code" name="cart-code"
									class="form-control text-center margin-bottom-10"
									placeholder="" required="required">
								<button class="btn btn-primary btn-block" type="submit">确认抵扣</button>
							</form>
						</div>
					</div>
					<div class="toggle">
						<label>交货周期</label>

						<div class="toggle-content">
							<p>默认在全款支付成功后1-3天内立即发货，若选择不同的交货周期则可获取不同程度的优惠哦.</p>

							<form action="#" method="post" class="nomargin">
								<label>选择交货周期*</label> <select id="cart-tax-country"
									name="cart-tax-country"
									class="form-control pointer margin-bottom-20">
									<option value="1">立即发货</option>
									<option value="2">10天内发货</option>
									<option value="2">20天内发货</option>
									<option value="2">30天内发货</option>
									<!-- add all here -->
								</select>
							</form>
						</div>
					</div>

					<div class="toggle">
						<label>运输配送</label>

						<div class="toggle-content">
							<p>
								<label class="radio"><input type="radio"
									name="radio-btn" value="1" checked="checked"><i></i>配到默认地址：</label><br>
								收件人:会员姓名<br> 手机：13345678901 <br> 邮编：123456<br>
								地址：四川省成都市某某区很多个字符街道某某路1234号某某大厦1206-635室 特价：¥ 3.80
							<p>
								<label class="radio"> <input type="radio"
									name="radio-btn" value="1"> <i></i>
									我要配送到以下地址：(当未选择此项时，以下表单呈灰色不可填写状态)
								</label> <span class="nomargin"> <label>收件人：<input
										type="text" id="cart-tax-postal" name="cart-tax-postal"
										class="margin-bottom-10" size="13" maxlength="12"></label> <label>手机：<input
										type="text" id="cart-tax-postal" name="cart-tax-postal"
										class="margin-bottom-10" size="15" maxlength="11"></label> <label>邮编：<input
										type="text" id="cart-tax-postal" name="cart-tax-postal"
										class="margin-bottom-10" size="15" maxlength="6"></label> <label>地址：
								</label> <label> <textarea name="textfield" cols="23" rows="3"></textarea>
								</label>
									<button class="btn btn-primary btn-block"
										onclick="myfirsttext()">SUBMIT</button>
								</span>
						</div>
					</div>

				</div>
				<!-- /TOGGLE -->

				<div class="toggle-transparent toggle-bordered-full clearfix">
					<div class="toggle active">
						<div class="toggle-content">

							<span class="clearfix"> <span class="pull-right"
								id="productprice"> 0</span> <strong class="pull-left">产品总价:</strong>
							</span> <span class="clearfix"> <span class="pull-right">
									56.35</span> <span class="pull-left">积分抵扣:</span>
							</span> <span class="clearfix"> <span class="pull-right">4220分</span>
								<span class="pull-left">可获得积分:</span>
							</span> <span class="clearfix"> <span class="pull-right">快递/物流到付</span>
								<span class="pull-left">运费:</span>
							</span>
							<hr />

							<span class="clearfix"> <span class="pull-right size-20"
								id="payprice" min="0"> 0</span> <strong class="pull-left">应付总额:</strong>
							</span>

							<hr />

							<a href="./newpages/OrderPay.jsp"
								class="btn btn-primary btn-lg btn-block size-15"><i
								class="glyphicon glyphicon-ok"></i>确认订单并结算</a>
						</div>
					</div>
				</div>

			</div>

		</div>
		<!-- /CART -->
</s:else>

	</div>
	</section>
	<!-- /CART -->


	<!-- RECOMMENDED -->
	<section>
		<div class="container">

			<h2 class="owl-featured">您可能感兴趣的产品：</h2>
			<div class="owl-carousel featured nomargin owl-padding-10"
				data-plugin-options='{"singleItem": false, "stopOnHover":false, "autoPlay":4000, "autoHeight": false, "navigation": true, "pagination": false}'>


				<!-- item -->
				<div class="shop-item nomargin">

					<div class="thumbnail">
						<!-- product image(s) -->
						<a class="shop-item-image" href="3.html"> <!-- CAROUSEL -->
							<div class="owl-carousel owl-padding-0 nomargin"
								data-plugin-options='{"singleItem": true, "autoPlay": 3000, "navigation": false, "pagination": false, "transitionStyle":"fadeUp"}'>
								<img class="img-responsive"
									src="newpages/assets/images/demo/shop/products/300x360/p5.jpg"
									alt=""> <img class="img-responsive"
									src="newpages/assets/images/demo/shop/products/300x360/p1.jpg"
									alt="">
							</div> <!-- /CAROUSEL -->
						</a>
						<!-- /product image(s) -->

					</div>

					<div class="shop-item-summary text-center">
						<a href="4.html"><h2>led筒灯3w超薄2.5寸</h2></a>
						<div class="size-13">7.5开孔 8公分嵌入式</div>

						<!-- price -->
						<div class="shop-item-price">特价：¥ 9.80</div>
						<!-- /price -->
					</div>

					<!-- buttons -->
					<div class="shop-item-buttons text-center">
						<a href="4.html" class="btn btn-default"> <i
							class="fa fa-cart-plus"></i>加入购物车
						</a>
					</div>
					<!-- /buttons -->
				</div>
				<!-- /item -->

				<!-- item -->
				<div class="shop-item nomargin">

					<div class="thumbnail">
						<!-- product image(s) -->
						<a class="shop-item-image" href="3.html"> <img
							class="img-responsive"
							src="newpages/assets/images/demo/shop/products/300x360/p2.jpg"
							alt="shop first image" /> <img class="img-responsive"
							src="newpages/assets/images/demo/shop/products/300x360/p12.jpg"
							alt="shop hover image" />
						</a>
						<!-- /product image(s) -->
						<!-- countdown -->
						<div class="shop-item-counter">
							<div class="countdown" data-from="December 31, 2017 08:22:01"
								data-labels="年,月,周,天,时,分,秒">
								<!-- Example Date From: December 31, 2018 15:03:26 -->
							</div>
						</div>
						<!-- /countdown -->
						<!-- product more info -->
						<div class="shop-item-info">
							<span class="label label-success">NEW</span> <span
								class="label label-danger">SALE</span>
						</div>
						<!-- /product more info -->
					</div>

					<div class="shop-item-summary text-center">
						<a href="4.html"><h2>4分四通内丝铜水管接头</h2></a>
						<div class="size-13">内螺纹 4分四通水暖接头</div>

						<!-- price -->
						<div class="shop-item-price">特价：¥ 6.80</div>
						<!-- /price -->
					</div>

					<!-- buttons -->
					<div class="shop-item-buttons text-center">
						<a href="4.html" class="btn btn-default"> <i
							class="fa fa-cart-plus"></i>加入购物车
						</a>
					</div>
					<!-- /buttons -->
				</div>
				<!-- /item -->

				<!-- item -->
				<div class="shop-item nomargin">

					<div class="thumbnail">
						<!-- product image(s) -->
						<a class="shop-item-image" href="3.html"> <img
							class="img-responsive"
							src="newpages/assets/images/demo/shop/products/300x360/p8.jpg"
							alt="shop first image" />
						</a>
						<!-- /product image(s) -->

					</div>

					<div class="shop-item-summary text-center">
						<a href="4.html"><h2>F1四开单控开关</h2></a>
						<div class="size-13">86型墙壁开关插座</div>

						<!-- price -->
						<div class="shop-item-price">特价：¥ 5.00</div>
						<!-- /price -->
					</div>

					<!-- buttons -->
					<div class="shop-item-buttons text-center">

						<a href="4.html" class="btn btn-default"> <i
							class="fa fa-cart-plus"></i>加入购物车
						</a>
					</div>
					<!-- /buttons -->
				</div>
				<!-- /item -->

				<!-- item-->
				<div class="shop-item nomargin">

					<div class="thumbnail">
						<!-- product image(s) -->
						<a class="shop-item-image" href="3.html"> <img
							class="img-responsive"
							src="newpages/assets/images/demo/shop/products/300x360/p13.jpg"
							alt="shop first image" /> <img class="img-responsive"
							src="newpages/assets/images/demo/shop/products/300x360/p14.jpg"
							alt="shop hover image" />
						</a>
						<!-- /product image(s) -->
						<!-- countdown -->
						<div class="shop-item-counter">
							<div class="countdown" data-from="December 31, 2016 08:22:01"
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
						</div>
						<!-- /price -->
					</div>

					<!-- buttons -->
					<div class="shop-item-buttons text-center">
						<a href="4.html" class="btn btn-default"> <i
							class="fa fa-cart-plus"></i>加入购物车
						</a>

					</div>
					<!-- /buttons -->
				</div>
				<!-- /item -->

				<!-- item -->
				<div class="shop-item nomargin">

					<div class="thumbnail">
						<!-- product image(s) -->
						<a class="shop-item-image" href="3.html"> <!-- CAROUSEL -->
							<div class="owl-carousel owl-padding-0 nomargin"
								data-plugin-options='{"singleItem": true, "autoPlay": 3000, "navigation": false, "pagination": false, "transitionStyle":"fadeUp"}'>
								<img class="img-responsive"
									src="newpages/assets/images/demo/shop/products/300x360/p5.jpg"
									alt=""> <img class="img-responsive"
									src="newpages/assets/images/demo/shop/products/300x360/p1.jpg"
									alt="">
							</div> <!-- /CAROUSEL -->
						</a>
						<!-- /product image(s) -->
					</div>

					<div class="shop-item-summary text-center">
						<a href="4.html"><h2>led筒灯3w超薄2.5寸</h2></a>
						<div class="size-13">7.5开孔 8公分嵌入式</div>

						<!-- price -->
						<div class="shop-item-price">特价：¥ 9.80</div>
						<!-- /price -->
					</div>

					<!-- buttons -->
					<div class="shop-item-buttons text-center">
						<a href="4.html" class="btn btn-default"> <i
							class="fa fa-cart-plus"></i>加入购物车
						</a>
					</div>
					<!-- /buttons -->
				</div>
				<!-- /item -->


				<!-- item -->
				<div class="shop-item nomargin">

					<div class="thumbnail">
						<!-- product image(s) -->
						<a class="shop-item-image" href="3.html"> <img
							class="img-responsive"
							src="newpages/assets/images/demo/shop/products/300x360/p8.jpg"
							alt="shop first image" />
						</a>
						<!-- /product image(s) -->

					</div>

					<div class="shop-item-summary text-center">
						<a href="4.html"><h2>F1四开单控开关</h2></a>
						<div class="size-13">86型墙壁开关插座</div>

						<!-- price -->
						<div class="shop-item-price">特价：¥ 5.00</div>
						<!-- /price -->
					</div>

					<!-- buttons -->
					<div class="shop-item-buttons text-center">

						<a href="4.html" class="btn btn-default"> <i
							class="fa fa-cart-plus"></i>加入购物车
						</a>
					</div>
					<!-- /buttons -->
				</div>
				<!-- /item -->

			</div>

		</div>
	</section>
	<!-- /RECOMMENDED -->



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
	<script type="text/javascript" src="newpages/assets/js/cart.js"></script>
</body>
</html>
