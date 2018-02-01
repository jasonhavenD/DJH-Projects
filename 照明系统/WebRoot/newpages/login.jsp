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
		<link href="newpages/assets/plugins/bootstrap/css/bootstrap.min.css"
			rel="stylesheet" type="text/css" />

		<!-- THEME CSS -->
		<link href="newpages/assets/css/essentials.css" rel="stylesheet"
			type="text/css" />
		<link href="newpages/assets/css/layout.css" rel="stylesheet" type="text/css" />

		<!-- PAGE LEVEL SCRIPTS -->
		<link href="newpages/assets/css/header-1.css" rel="stylesheet" type="text/css" />
		<link href="newpages/assets/css/layout-shop.css" rel="stylesheet"
			type="text/css" />
		<link href="newpages/assets/css/color_scheme/green.css" rel="stylesheet"
			type="text/css" id="color_scheme" />
		<!--script type="text/javascript" src="../js/logorreg.js"></script-->
		<!-- 加密算法 -->
		<script type="text/javascript" src="../js/md5.js"></script>
		
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



			<!-- -->
			<section style="background:url('newpages/assets/images/demo/wall2.jpg')">

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
								<form action="LoginAction.action" method="post"
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
											<input type="radio" name="state" value="2" checked="checked">
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
											<input name="username" id="username" value="www">
											<span class="tooltip tooltip-top-right">请输入您的用户名</span>
										</label>

										<label class="label margin-top-20">
											密码：
										</label>
										<label class="input">
											<i class="ico-append fa fa-lock"></i>
											<input type="password" name="password" id="password" value="123">
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
														src="./IdentifyingCode_getPictureCode" class="pin">
													<a href="javascript:;"
														onclick="document.getElementById('imageCode').src = './IdentifyingCode_getPictureCode?' + new Date();">看不清楚？换一张</a>
												</label>
											</div>
										</div>



									</fieldset>

									<footer class="celarfix">
									<button type="submit"
										class="btn btn-primary noradius pull-right"
										onclick="User_login()">
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
									<a href="javascript:;" class="social-icon social-twitter"
										data-toggle="tooltip" data-placement="top" title="QQ" 
										onclick="$.post('./QQvalidate',{},function(data){window.location.href=data.url;});"> 
										<i class="icon-twitter"></i> <i class="icon-twitter"></i> </a>
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
		<script type="text/javascript" src="newpages/assets/js/view/demo.shop.js"></script>
		<script type="text/javascript" src="../js/logorreg.js"></script>
		<!-- script type="text/javascript" src="newpages/assets/js/thirdlogin.js"></script -->
	</body>
</html>
