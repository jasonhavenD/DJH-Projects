<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
	
	
	<div id="wrapper">

		<!-- Top Bar -->
		<div id="topBar" class="dark">
			<div class="container">

				<!-- right -->
				<ul class="top-links list-inline pull-right">
					<li class="text-welcome hidden-xs">Welcome to goofoo, 
						<strong>
							<s:if test="#session.userinfo != null "> 
								<s:property value="#session.userinfo.username" />
							</s:if>
							<s:else>	
								游客
							</s:else>
							!
						</strong>
					</li>
					<s:if test="#session.userinfo != null ">
						<li><a class="dropdown-toggle no-text-underline"
							data-toggle="dropdown" href="#"><i 	class="fa fa-user hidden-xs"></i> 会员中心</a> 
							<!-- ul class="dropdown-menu pull-right">
									<li><a tabindex="-1" href="#"><i class="fa fa-history"></i>我的订单</a></li>
									<li class="divider"></li>
									<li><a tabindex="-1" href="#"><i class="fa fa-bookmark"></i>我的收藏</a></li>
									<li><a tabindex="-1" href="#"><i class="fa fa-edit"></i>我的评价</a></li>
									<li><a tabindex="-1" href="company/person.html"><i class="fa fa-cog"></i>我的设定</a></li>
									<li class="divider"></li>
									<li><a tabindex="-1" href="javascript:void(0)" id="out"><i class="glyphicon glyphicon-off"></i>退出</a></li>
								
								</ul -->
						</li>
					</s:if>
							
					<s:if test="#session.userinfo == null ">
						<li class="dropdown-toggle no-text-underline">
							<a href="./LoginForm">登录</a>
						</li>
						<li class="dropdown-toggle no-text-underline">
							<a href="./RegisterForm">注册</a>
						</li>
					</s:if>
					<s:else>
						<li class="dropdown-toggle no-text-underline">
							<a href="./LoginOffAction">安全退出</a>
						</li>
					</s:else>
					
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
						<!-- INLINE SEARCH -->

						<!-- /INLINE SEARCH -->
						<!-- QUICK SHOP CART -->
						<li class="quick-cart"><a href="#"> <span
								class="badge badge-aqua btn-xs badge-corner"><s:property
										value='cartItems.size()' /> </span> <i class="fa fa-shopping-cart"></i>
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
												<span>x<s:property value='#item.count' />
												</span> <small>删除</small>
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
									<a href="./CartShowAction" class="btn btn-primary btn-xs pull-right">去购物车查看详情</a>
									<!--span class="pull-left"><small>共3件商品    共计:<strong>￥25.50</strong></samll></span-->
								</div>
								<!-- /quick cart footer -->

							</div></li>
						<!-- /QUICK SHOP CART -->

					</ul>
					<!-- /BUTTONS -->

					<!-- Logo -->
					<a class="logo pull-left" href="index.html"> <img
						src="newpages/assets/images/logo_dark.png" alt="" />
					</a> <a class="logo pull-left" href="#"> <img
						src="newpages/assets/images/gf_50px.png" alt="" />
					</a>
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
									<!-- HOME --> <a href="./HomePage_retreiveAll">首 页</a>
								</li>
								<li class="dropdown">
									<!-- PAGES -->
									<a class="dropdown-toggle" href="#">关于我们 </a>
									<ul class="dropdown-menu">
										<li class="dropdown"><a href="./InfoDetail1stAction?typename=公司简介">公司简介</a></li>
										<li class="dropdown"><a href="./InfoDetail1stAction?typename=招商政策">招商政策</a></li>
										<li class="dropdown"><a href="./InfoDetail1stAction?typename=发展愿景">发展愿景</a></li>
									</ul>
								</li>
								<li class="dropdown">
									<!-- FEATURES --> <a class="dropdown-toggle" href="#">产品中心</a>
									<ul class="dropdown-menu" id="type1">
									</ul>
								</li>

								<li class="dropdown">
									<!-- BLOG --> <a class="dropdown-toggle" href="#">资源资讯</a>
									<ul class="dropdown-menu">
										<li class="dropdown"><a href="./InfoListAction?typename=资源下载&pageSize=12">资源下载</a></li>
										<li class="dropdown"><a href="./InfoListAction?typename=新闻公告&pageSize=12">新闻公告</a></li>
										<li class="dropdown"><a href="./InfoListAction?typename=行业资讯&pageSize=12">行业资讯</a></li>
										<li class="dropdown"><a href="./InfoListAction?typename=帮助中心&pageSize=12">帮助中心</a></li>
									</ul>
								</li>
								<li class="dropdown">
									<!-- SHOP --> <a href="./InfoDetail1stAction?typename=联系我们">联系我们</a>
								</li>

							</ul>

						</nav>
					</div>

				</div>
			</header>
			<!-- /Top Nav -->

		</div>
		

