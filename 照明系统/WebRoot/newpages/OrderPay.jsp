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
		<title>订单支付页面——厦门光服科技有限公司</title>
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

					<h1>支付结算</h1>

					<!-- breadcrumbs -->
					<ol class="breadcrumb">
						<li><a href="#">首页</a></li>
						<li><a href="#">会员中心</a></li>
						<li class="active">支付结算</li>
					</ol>
					<!-- /breadcrumbs -->

				</div>
			</section>
			<!-- /PAGE HEADER -->




			<!-- CART -->

				<div class="container padding-top-40 padding-bottom-40">

				
					<!-- EMPTY CART -->
					<div class="panel panel-default">
						<div class="panel-body ">
							订单提交成功，请您尽快付款！<strong> 订单号：201608101436001012012302012 </strong><br />
							
                                     请您在提交订单后24小时内完成支付，否则订单会自动取消。 光服科技提供在线支付保障，请您放心购买。<br />
									 <div class="shop-item-price text-danger pull-right">应付金额：¥ 4136.65 元</div>
						</div>
						
					</div>
					<!-- /EMPTY CART -->

     <div class="toggle toggle-transparent-body">
	 
	 
	     <div class="toggle">
		     <label>产品订购清单.</label>
		             <div class="toggle-content">
									<!-- CART -->
							<form class="cartContent clearfix" method="post" action="#">

								<!-- cart content -->
								<div id="cartContent">


									<!-- cart item -->
									<div class="item">
										<div class="cart_img pull-left width-100 padding-10 text-left"><img src="assets/images/demo/shop/products/100x100/p1.jpg" alt="" width="80" /></div>
										<a href="3.html" class="product_name">
											<span>产品名称标题产品名称标题产品名称标题</span>
											<small>参数属性1：5W 参数属性2：暖白</small>
											<small>参数属性2：暖白</small>
										</a>
										<div class="total_price"><span>订购数量：20</span></div>
										<div class="clearfix"></div>
									</div>
									<!-- /cart item -->

									<!-- cart item -->
									<div class="item">
										<div class="cart_img pull-left width-100 padding-10 text-left"><img src="assets/images/demo/shop/products/100x100/p2.jpg" alt="" width="80" /></div>
										<a href="3.html" class="product_name">
											<span>产品名称标题产品名称标题产品名称标题</span>
											<small>参数属性1：5W 参数属性2：暖白</small>
											<small>参数属性2：暖白</small>
										</a>
										<div class="total_price"><span>订购数量：100</span></div>
										<div class="clearfix"></div>
									</div>
									<!-- /cart item -->

									<!-- cart item -->
									<div class="item">
										<div class="cart_img pull-left width-100 padding-10 text-left"><img src="assets/images/demo/shop/products/100x100/p1.jpg" alt="" width="80" /></div>
										<a href="3.html" class="product_name">
											<span>产品名称标题产品名称标题产品名称标题</span>
											<small>参数属性1：5W 参数属性2：暖白</small>
											<small>参数属性2：暖白</small>
										</a>
										<div class="total_price"><span>订购数量：200</span></div>
										<div class="clearfix"></div>
									</div>
									<!-- /cart item -->
								</div>
								<!-- /cart content -->

							</form>
							<!-- /CART -->
		</div>
	</div>

	<div class="toggle">
		<label>配送运输信息.</label>
		<div class="toggle-content">
			<p> <strong>收件人：</strong>会员姓名<br> 
			    <strong>手机：</strong>13312345678 <br> 
			    <strong>收件地址：</strong>四川省成都市某某区很多个字符街道某某路1234号某某大厦1206-635室<br />
				<strong>配送周期：</strong>支付成功后 立即发货！<br />
				<strong>备注信息：</strong>会员下订单时的备注信息，有则显示无则留空.</p>
		</div>
	</div>

	<div class="toggle active">
		<label>选择支付方式</label>
		<div class="toggle-content">


<div class="row">

	<div class="col-md-3 col-sm-3">
		<div class="price-clean">                                
			<h4>
			<img class="img-responsive"  src="assets/images/alipay.png">
			</h4>
			<h5> 因为信任 所以简单 </h5>
			<hr />
			<p>		<label class="radio"><input type="radio" name="radio-btn" value="1" checked="checked"><i></i>使用支付宝支付</label></p>			
		</div>
	</div>

	<div class="col-md-3 col-sm-3">
		<div class="price-clean">                                
			<h4>
			<img class="img-responsive"  src="assets/images/unionpay.png">
			</h4>
			<h5> 安全的网上支付平台 </h5>
			<hr />
			<p>		<label class="radio"><input type="radio" name="radio-btn" value="2"><i></i>使用网银在线支付</label></p>	
		</div>
	</div>

	<div class="col-md-3 col-sm-3">
		<div class="price-clean">                                
			<h4>
			
				<img class="img-responsive" src="assets/images/weixin.png" alt="" />
			</h4>
			<h5> 更方便  更快捷 </h5>	
			<hr />
			<p>		<label class="radio"><input type="radio" name="radio-btn" value="3"><i></i>使用微信支付</label></p>					
		</div>
	</div>
	
	<div class="col-md-3 col-sm-3">
		<div class="price-clean">                                
			<h4>
			<img class="img-responsive"  src="assets/images/yue.png">
			</h4>
			<h5> 您的账户余额 ¥ 255.00 元</h5>		
			<hr />
				<p>		<label class="radio"><input type="radio" name="radio-btn" value="4">
				<i></i>余额不足，请<a href="#">充值</a>后付款！（说明：如果余额大于本次订单金额，则这里显示“使用余额支付”。如果余额小于本次订单金额，则显示“余额不足，请充值后付款”，且不能点选此项。）</label>
				</p>						
		</div>
	</div>	

</div>



<div class="callout alert alert-default margin-top-30 margin-bottom-10">

	<div class="row">

		<div class="col-md-8 col-sm-8"><!-- left text -->
			<p><strong>应付金额：¥ 4136.65 元</strong></p>
		</div><!-- /left text -->

		
		<div class="col-md-4 col-sm-4 text-right"><!-- right btn -->
			<a href="OnlinePayment_alipay?out_trade_no=test12345678&subject=123&total_fee=0.01&body=123" rel="nofollow" target="_blank" class="btn btn-danger btn-lg">确认支付</a>
		</div><!-- /right btn -->

	</div>

</div>
<!------------------------------------支付结束-------------------------------------------------------------->

		</div>
	</div>

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
		</div><!-- /PRELOADER -->


		<!-- JAVASCRIPT FILES -->
		<script type="text/javascript">var plugin_path = 'assets/plugins/';</script>
		<script type="text/javascript" src="assets/plugins/jquery/jquery-2.1.4.min.js"></script>

		<script type="text/javascript" src="assets/js/scripts.js"></script>


		<!-- PAGE LEVEL SCRIPTS -->
		<script type="text/javascript" src="assets/js/view/demo.shop.js"></script>
	</body>
</html>