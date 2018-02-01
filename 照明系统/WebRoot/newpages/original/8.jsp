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
		<title>会员注册页面——厦门光服科技有限公司</title>
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
		<script type="text/javascript" src="../js/logorreg.js"></script>
		<script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
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

							<div
								class="col-xs-12 col-sm-5 col-md-5 col-lg-4 col-md-push-7 col-lg-push-8 col-sm-push-7">

								<!-- ALERT -->
								<!--
									<div class="alert alert-mini alert-danger margin-bottom-30">
										<strong>Oh snap!</strong> Login Incorrect!
									</div>
									-->
								<!-- /ALERT -->

								<!-- register form -->
								<form class="nomargin sky-form boxed"
									action="registerAction.action" method="post">
									<header>
									<i class="fa fa-users"></i> 会员注册
									</header>

									<fieldset class="nomargin">
										<label class="input">
											<i class="ico-append fa fa-envelope"></i>
											<input type="text" placeholder="用户名" name="username"
												id="usernamephone" onblur="validatePhoneName()">
											<b class="tooltip tooltip-bottom-right">请设置您的用户名</b>

										</label>

										<label class="input">
											<i class="ico-append fa fa-envelope"></i>
											<input type="text" placeholder="手机号码" name="phone" id="phone"
												onblur="validatePhone()">
											<b class="tooltip tooltip-bottom-right">请输入您的手机号码</b>

										</label>


										<div class="row">
											<div class="col-md-6">
												<label class="input">
													<input type="text" placeholder="输入短信验证码" id="pinphone"
														onblur="confirmPhoneCode()">
												</label>
											</div>
											<div class="col col-md-6">
												<label class="input">
													<button type="button" class="btn btn-primary"
														onclick="getCodeByPhone()">
														获取短信验证码
													</button>
												</label>
											</div>
										</div>

										<label class="input">
											<i class="ico-append fa fa-lock"></i>
											<input type="password" placeholder="密码" name="password"
												id="passwordphone" onblur="validatePhonePassword()">
											<b class="tooltip tooltip-bottom-right">设置会员登录密码</b>
										</label>

										<label class="input">
											<i class="ico-append fa fa-lock"></i>
											<input type="password" placeholder="确认密码"
												name="repeatpassword" id="passwordphone_confirm"
												onblur="confirmPhonePassword()">
											<b class="tooltip tooltip-bottom-right">确认密码</b>
										</label>



										<!--label class="input">
												<i class="ico-append fa fa-lock"></i>
												<input type="password" placeholder="邮箱">
												<b class="tooltip tooltip-bottom-right">邮箱</b>
											</label-->


										<div class="row">
											<div class="col-md-6">
												<label class="input">
													<input type="text" placeholder="输入随机验证码"
														name="RegisterValidate" id="validatecode"
														onblur="validatePicture()">
												</label>
											</div>
											<div class="col col-md-6">
												<label class="input">
													<img alt="验证码" id="imageCode"
														src="../IdentifyingCode_getPictureCode" class="pin">
													<a href="javascript:;"
														onclick=
	document.getElementById('imageCode').src = '../IdentifyingCode_getPictureCode?' + new Date();
>看不清楚？换一张</a>
												</label>
											</div>
											<label id="passwordwarn"></label>
										</div>

										<div class="margin-top-20">
											<label class="checkbox nomargin">
												<input class="checked-agree" type="checkbox" name="checkbox">
												<i></i>我已阅读并认可
												<a href="#" data-toggle="modal" data-target="#termsModal">用户注册协议</a>
											</label>

										</div>
									</fieldset>

									<div class="row margin-bottom-20">
										<div class="col-md-12">
											<button type="submit" class="btn btn-primary">
												<i class="fa fa-check" onlick="phoneRegister()"></i> 立 即 注 册
											</button>
										</div>
									</div>

								</form>
								<!-- /register form -->

							</div>

							<div
								class="col-xs-12 col-md-7 col-sm-7 col-lg-8 col-lg-pull-4 col-md-pull-5 col-sm-pull-5">


								<h2 class="size-20 text-center-xs">
									关于光服科技
								</h2>

								<p>
									公司简介、宣传语或广告词
								</p>
								<p>
									公司简介、宣传语或广告词
								</p>

								<ul class="list-unstyled login-features">
									<li>
										<i class="glyphicon glyphicon-road"></i>
										<strong>用户名</strong> 就是您的会员账号，请牢记您的用户名.
									</li>
									<li>
										<i class="glyphicon glyphicon-cog"></i>
										<strong>注册成功后</strong> 会员账号不能修改、删除.
									</li>
									<li>
										<i class="glyphicon glyphicon-tint"></i>
										<strong>会员手机号</strong>是唯一的 .
									</li>
									<li>
										<i class="glyphicon glyphicon-screenshot"></i>
										<strong>Nam libero</strong> tempore, cum soluta nobis.
									</li>
									<li>
										<i class="glyphicon glyphicon-fire"></i>
										<strong>已有账号</strong> 请点击这里
										<a href="./loginForm.action"><button type="button"
												class="btn btn-primary btn-sm">
												登 录
											</button>
										</a>.
									</li>
								</ul>

							</div>

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
			<section class="page-header page-header-xs">
			<div class="container">

				<!-- breadcrumbs -->
				<ol class="breadcrumb breadcrumb-inverse">
					<li></li>
					<li class="active"></li>
				</ol>
				<!-- /breadcrumbs -->

			</div>
			</section>
			<!-- /PAGE HEADER -->




			<!-- MODAL -->
			<div class="modal fade" id="termsModal" tabindex="-1" role="dialog"
				aria-labelledby="myModal" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">
								&times;
							</button>
							<h4 class="modal-title" id="myModal">
								用户协议
							</h4>
						</div>

						<div class="modal-body modal-short">
							<h4>
								<b>用户协议</b>
							</h4>
							<p>
								These terms and conditions govern your use of this website; by
								using this website, you accept these terms and conditions in
								full. If you disagree with these terms and conditions or any
								part of these terms and conditions, you must not use this
								website.
							</p>
							<p>
								[You must be at least [18] years of age to use this website. By
								using this website [and by agreeing to these terms and
								conditions] you warrant and represent that you are at least [18]
								years of age.]
							</p>


							<h4>
								<strong>用户协议</strong>
							</h4>
							<p>
								Unless otherwise stated, [NAME] and/or its licensors own the
								intellectual property rights in the website and material on the
								website. Subject to the license below, all these intellectual
								property rights are reserved.
							</p>
							<p>
								You may view, download for caching purposes only, and print
								pages [or [OTHER CONTENT]] from the website for your own
								personal use, subject to the restrictions set out below and
								elsewhere in these terms and conditions.
							</p>
							<p>
								You must not:
							</p>
							<ul>
								<li>
									republish material from this website (including republication
									on another website);
								</li>
								<li>
									sell, rent or sub-license material from the website;
								</li>
								<li>
									show any material from the website in public;
								</li>
								<li>
									reproduce, duplicate, copy or otherwise exploit material on
									this website for a commercial purpose;]
								</li>
								<li>
									[edit or otherwise modify any material on the website; or]
								</li>
								<li>
									[redistribute material from this website [except for content
									specifically and expressly made available for redistribution].]
								</li>
							</ul>
							<p>
								[Where content is specifically made available for
								redistribution, it may only be redistributed [within your
								organisation].]
							</p>

							<h4>
								<strong>Acceptable use</strong>
							</h4>
							<p>
								You must not use this website in any way that causes, or may
								cause, damage to the website or impairment of the availability
								or accessibility of the website; or in any way which is
								unlawful, illegal, fraudulent or harmful, or in connection with
								any unlawful, illegal, fraudulent or harmful purpose or
								activity.
							</p>
							<p>
								You must not use this website to copy, store, host, transmit,
								send, use, publish or distribute any material which consists of
								(or is linked to) any spyware, computer virus, Trojan horse,
								worm, keystroke logger, rootkit or other malicious computer
								software.
							</p>
							<p>
								You must not conduct any systematic or automated data collection
								activities (including without limitation scraping, data mining,
								data extraction and data harvesting) on or in relation to this
								website without [NAME'S] express written consent.
							</p>
							<p>
								[You must not use this website to transmit or send unsolicited
								commercial communications.]
							</p>
							<p>
								[You must not use this website for any purposes related to
								marketing without [NAME'S] express written consent.]
							</p>

							<h4>
								<strong>Restricted access</strong>
							</h4>
							<p>
								[Access to certain areas of this website is restricted.] [NAME]
								reserves the right to restrict access to [other] areas of this
								website, or indeed this entire website, at [NAME'S] discretion.
							</p>
							<p>
								If [NAME] provides you with a user ID and password to enable you
								to access restricted areas of this website or other content or
								services, you must ensure that the user ID and password are kept
								confidential.
							</p>
							<p>
								[[NAME] may disable your user ID and password in [NAME'S] sole
								discretion without notice or explanation.]
							</p>

							<h4>
								<strong>User content</strong>
							</h4>
							<p>
								In these terms and conditions, "your user content" means
								material (including without limitation text, images, audio
								material, video material and audio-visual material) that you
								submit to this website, for whatever purpose.
							</p>
							<p>
								You grant to [NAME] a worldwide, irrevocable, non-exclusive,
								royalty-free license to use, reproduce, adapt, publish,
								translate and distribute your user content in any existing or
								future media. You also grant to [NAME] the right to sub-license
								these rights, and the right to bring an action for infringement
								of these rights.
							</p>
							<p>
								Your user content must not be illegal or unlawful, must not
								infringe any third party's legal rights, and must not be capable
								of giving rise to legal action whether against you or [NAME] or
								a third party (in each case under any applicable law).
							</p>
							<p>
								You must not submit any user content to the website that is or
								has ever been the subject of any threatened or actual legal
								proceedings or other similar complaint.
							</p>
							<p>
								[NAME] reserves the right to edit or remove any material
								submitted to this website, or stored on [NAME'S] servers, or
								hosted or published upon this website.
							</p>
							<p>
								[Notwithstanding [NAME'S] rights under these terms and
								conditions in relation to user content, [NAME] does not
								undertake to monitor the submission of such content to, or the
								publication of such content on, this website.]
							</p>

							<h4>
								<strong>No warranties</strong>
							</h4>
							<p>
								This website is provided "as is" without any representations or
								warranties, express or implied. [NAME] makes no representations
								or warranties in relation to this website or the information and
								materials provided on this website.
							</p>
							<p>
								Without prejudice to the generality of the foregoing paragraph,
								[NAME] does not warrant that:
							</p>
							<ul>
								<li>
									this website will be constantly available, or available at all;
									or
								</li>
								<li>
									the information on this website is complete, true, accurate or
									non-misleading.
								</li>
							</ul>
							<p>
								Nothing on this website constitutes, or is meant to constitute,
								advice of any kind. [If you require advice in relation to any
								[legal, financial or medical] matter you should consult an
								appropriate professional.]
							</p>

							<h4>
								<strong>Limitations of liability</strong>
							</h4>
							<p>
								[NAME] will not be liable to you (whether under the law of
								contact, the law of torts or otherwise) in relation to the
								contents of, or use of, or otherwise in connection with, this
								website:
							</p>
							<ul>
								<li>
									[to the extent that the website is provided free-of-charge, for
									any direct loss;]
								</li>
								<li>
									for any indirect, special or consequential loss; or
								</li>
								<li>
									for any business losses, loss of revenue, income, profits or
									anticipated savings, loss of contracts or business
									relationships, loss of reputation or goodwill, or loss or
									corruption of information or data.
								</li>
							</ul>
							<p>
								These limitations of liability apply even if [NAME] has been
								expressly advised of the potential loss.
							</p>

							<h4>
								<strong>Exceptions</strong>
							</h4>
							<p>
								Nothing in this website disclaimer will exclude or limit any
								warranty implied by law that it would be unlawful to exclude or
								limit; and nothing in this website disclaimer will exclude or
								limit [NAME'S] liability in respect of any:
							</p>
							<ul>
								<li>
									death or personal injury caused by [NAME'S] negligence;
								</li>
								<li>
									fraud or fraudulent misrepresentation on the part of [NAME]; or
								</li>
								<li>
									matter which it would be illegal or unlawful for [NAME] to
									exclude or limit, or to attempt or purport to exclude or limit,
									its liability.
								</li>
							</ul>

							<h4>
								<strong>Reasonableness</strong>
							</h4>
							<p>
								By using this website, you agree that the exclusions and
								limitations of liability set out in this website disclaimer are
								reasonable.
							</p>
							<p>
								If you do not think they are reasonable, you must not use this
								website.
							</p>

							<h4>
								<strong>Other parties</strong>
							</h4>
							<p>
								[You accept that, as a limited liability entity, [NAME] has an
								interest in limiting the personal liability of its officers and
								employees. You agree that you will not bring any claim
								personally against [NAME'S] officers or employees in respect of
								any losses you suffer in connection with the website.]
							</p>
							<p>
								[Without prejudice to the foregoing paragraph,] you agree that
								the limitations of warranties and liability set out in this
								website disclaimer will protect [NAME'S] officers, employees,
								agents, subsidiaries, successors, assigns and sub-contractors as
								well as [NAME].
							</p>

							<h4>
								<strong>Unenforceable provisions</strong>
							</h4>
							<p>
								If any provision of this website disclaimer is, or is found to
								be, unenforceable under applicable law, that will not affect the
								enforceability of the other provisions of this website
								disclaimer.
							</p>

							<h4>
								<strong>Indemnity</strong>
							</h4>
							<p>
								You hereby indemnify [NAME] and undertake to keep [NAME]
								indemnified against any losses, damages, costs, liabilities and
								expenses (including without limitation legal expenses and any
								amounts paid by [NAME] to a third party in settlement of a claim
								or dispute on the advice of [NAME'S] legal advisers) incurred or
								suffered by [NAME] arising out of any breach by you of any
								provision of these terms and conditions[, or arising out of any
								claim that you have breached any provision of these terms and
								conditions].
							</p>

							<h4>
								<strong>Breaches of these terms and conditions</strong>
							</h4>
							<p>
								Without prejudice to [NAME'S] other rights under these terms and
								conditions, if you breach these terms and conditions in any way,
								[NAME] may take such action as [NAME] deems appropriate to deal
								with the breach, including suspending your access to the
								website, prohibiting you from accessing the website, blocking
								computers using your IP address from accessing the website,
								contacting your internet service provider to request that they
								block your access to the website and/or bringing court
								proceedings against you.
							</p>

							<h4>
								<strong>Variation</strong>
							</h4>
							<p>
								[NAME] may revise these terms and conditions from time-to-time.
								Revised terms and conditions will apply to the use of this
								website from the date of the publication of the revised terms
								and conditions on this website. Please check this page regularly
								to ensure you are familiar with the current version.
							</p>

							<h4>
								<strong>Assignment</strong>
							</h4>
							<p>
								[NAME] may transfer, sub-contract or otherwise deal with
								[NAME'S] rights and/or obligations under these terms and
								conditions without notifying you or obtaining your consent.
							</p>
							<p>
								You may not transfer, sub-contract or otherwise deal with your
								rights and/or obligations under these terms and conditions.
							</p>

							<h4>
								<strong>Severability</strong>
							</h4>
							<p>
								If a provision of these terms and conditions is determined by
								any court or other competent authority to be unlawful and/or
								unenforceable, the other provisions will continue in effect. If
								any unlawful and/or unenforceable provision would be lawful or
								enforceable if part of it were deleted, that part will be deemed
								to be deleted, and the rest of the provision will continue in
								effect.
							</p>

							<h4>
								<strong>Entire agreement</strong>
							</h4>
							<p>
								These terms and conditions [, together with [DOCUMENTS],]
								constitute the entire agreement between you and [NAME] in
								relation to your use of this website, and supersede all previous
								agreements in respect of your use of this website.
							</p>

							<h4>
								<strong>Law and jurisdiction</strong>
							</h4>
							<p>
								These terms and conditions will be governed by and construed in
								accordance with [GOVERNING LAW], and any disputes relating to
								these terms and conditions will be subject to the
								[non-]exclusive jurisdiction of the courts of [JURISDICTION].
							</p>

							<h4>
								<strong>About these website terms and conditions</strong>
							</h4>
							<p>
								We created these website terms and conditions with the help of a
								free website terms and conditions form developed by
								Contractology and available at
								<a href="#">www.yourwebsite.com</a>. Contractology supply a wide
								variety of commercial legal documents, such as
								<a href="#">template data protection statements</a>.
							</p>

							<h4>
								<strong>Registrations and authorisations</strong>
							</h4>
							<p>
								[[NAME] is registered with [TRADE REGISTER]. You can find the
								online version of the register at [URL]. [NAME'S] registration
								number is [NUMBER].]
							</p>
							<p>
								[[NAME] is subject to [AUTHORISATION SCHEME], which is
								supervised by [SUPERVISORY AUTHORITY].]
							</p>
							<p>
								[[NAME] is registered with [PROFESSIONAL BODY]. [NAME'S]
								professional title is [TITLE] and it has been granted in
								[JURISDICTION]. [NAME] is subject to the [RULES] which can be
								found at [URL].]
							</p>
							<p>
								[[NAME] subscribes to the following code[s] of conduct: [CODE(S)
								OF CONDUCT]. [These codes/this code] can be consulted
								electronically at [URL(S)].
							</p>
							<p>
								[[NAME'S] [TAX] number is [NUMBER].]]
							</p>

							<h4>
								<strong>[NAME'S] details</strong>
							</h4>
							<p>
								The full name of [NAME] is [FULL NAME].
							</p>
							<p>
								[[NAME] is registered in [JURISDICTION] under registration
								number [NUMBER].]
							</p>
							<p>
								[NAME'S] [registered] address is [ADDRESS].
							</p>
							<p>
								You can contact [NAME] by email to [EMAIL].
							</p>


							<p class="margin-top30">
								<strong>By using this WEBSITE TERMS AND CONDITIONS
									template document, you agree to the <a href="#">terms and
										conditions</a> set out on <a href="#">yourdomain.com</a>. You must
									retain the credit set out in the section headed "ABOUT THESE
									WEBSITE TERMS AND CONDITIONS". Subject to the licensing
									restrictions, you should edit the document, adapting it to the
									requirements of your jurisdiction, your business and your
									website. If you are not a lawyer, we recommend that you take
									professional legal advice in relation to the editing and use of
									the template.</strong>
							</p>


						</div>

						<div class="modal-footer">

							<button type="button" class="btn btn-primary"
								data-dismiss="modal" id="terms-agree">
								<i class="fa fa-check"></i> 已阅读并同意
							</button>

							<a href="page-print-terms.html" target="_blank" rel="nofollow"
								class="btn btn-danger pull-left"><i class="fa fa-print"></i><span
								class="hidden-xs"> 打印</span>
							</a>
						</div>

					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /MODAL -->






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
	</body>
</html>
