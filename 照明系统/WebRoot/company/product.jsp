<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
  <title>产品展示</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

  <link href="../css/bootstrap.min.css" rel='stylesheet' type='text/css' />
  <link href="css/style.css" rel='stylesheet' type='text/css' />
  <link href="css/aboutperson.css" rel='stylesheet' type='text/css'>
  <script type="text/javascript" src="../js/jquery.min.js"></script>
  <script type="text/javascript" src="./js/product.js"></script>
  <script type="text/javascript" src="../admin/js/jquery.params.js"></script>
  
</head>
<!-- 显示搜索结果和首页“更多”跳转页面 -->
<body onload="getList()">
  <div class="header" >
    <div class="container">
      <div class="header_top">
        <div class="logo">
          <a href="index.html"><img src="images/logo.png" alt=""/></a>
        </div>
        <!--搜索框-->
        <form class="search-form domain-search">
         
          <div class="three-fifth column first">
            <input type="text" class="text" placeholder="搜索你想要的产品" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = '';}" >               
          </div>
          <div class="one-fifth column">
            <input type="button" value="搜索">
          </div>
          
        </form>
        <div class="cssmenu">
          <ul>
            <li><a href="person.html">会员中心</a></li> 
            <li><a href="cart.jsp">购物车</a></li>
            <li id="showname"><!-- <a href="../html/logorreg.html">登录/注册</a> --></li>
            <li><a  href="javascript:void(0)" id="out">退出</a></li> 
            <input id="membertype" type="hidden"/>
            
          </ul>
        </div>
        <div class="clearfix"> </div>
      </div>
      <div class="h_menu4"><!-- start h_menu4 -->
        <a class="toggleMenu" href="#">Menu</a>
        <ul class="nav">
         <li class="active" ><a href="index.jsp">主页</a></li>
	        <li><a href="productType.jsp?producttype=1" >节能灯</a></li>
	        <li><a href="productType.jsp?producttype=2">球泡灯</a></li>
	        <li><a href="productType.jsp?producttype=3">一体化筒灯</a></li>
	        <li><a href="productType.jsp?producttype=4">天花射灯</a></li>
	        <li><a href="productType.jsp?producttype=5">吸顶灯</a></li>
	        <li><a href="productType.jsp?producttype=6">配件</a></li>
         
       </ul>
       <script type="text/javascript" src="js/nav.js"></script>
     </div><!-- end h_menu4 -->
   </div>
 </div>
 <div class="productmain">
   <div class="container">
		<!-- <div class="col-xs-6 col-sm-3">
			<div class="productshow">
				<a href="#"><img src="images/test.png" class="img-responsive"/></a>
				<span><h4>￥</h4><h3>59.00</h3></span>
				<span><a href="#">HS节能灯</a></span>
			</div>
		</div>
  		<div class="col-xs-6 col-sm-3">
  			<div class="productshow">
				<a href="#"><img src="images/test.png" class="img-responsive"/></a>
				<span><h4>￥</h4><h3>59.00</h3></span>
				<span><a href="#">HS节能灯</a></span>
			</div>
  		</div>
  
  		<div class="col-xs-6 col-sm-3">
  			<div class="productshow">
				<a href="#"><img src="images/test.png" class="img-responsive"/></a>
				<span><h4>￥</h4><h3>59.00</h3></span>
				<span><a href="#">HS节能灯</a></span>
			</div>
  		</div>
  		<div class="col-xs-6 col-sm-3">
  			<div class="productshow">
				<a href="#"><img src="images/test.png" class="img-responsive"/></a>
				<span><h4>￥</h4><h3>59.00</h3></span>
				<span><a href="#">HS节能灯</a></span>
			</div>
  		</div>
  		<div class="col-xs-6 col-sm-3">
  			<div class="productshow">
				<a href="#"><img src="images/test.png" class="img-responsive"/></a>
				<span><h4>￥</h4><h3>59.00</h3></span>
				<span><a href="#">HS节能灯</a></span>
			</div>
  		</div>
  		<div class="col-xs-6 col-sm-3">
  			<div class="productshow">
				<a href="#"><img src="images/test.png" class="img-responsive"/></a>
				<span><h4>￥</h4><h3>59.00</h3></span>
				<span><a href="#">HS节能灯</a></span>
			</div>
  		</div>
  
  		<div class="col-xs-6 col-sm-3">
  			<div class="productshow">
				<a href="#"><img src="images/test.png" class="img-responsive"/></a>
				<span><h4>￥</h4><h3>59.00</h3></span>
				<span><a href="#">HS节能灯</a></span>
			</div>
  		</div>
  		<div class="col-xs-6 col-sm-3">
  			<div class="productshow">
				<a href="#"><img src="images/test.png" class="img-responsive"/></a>
				<span><h4>￥</h4><h3>59.00</h3></span>
				<span><a href="#">HS节能灯</a></span>
			</div>
  		</div>
  		<div class="col-xs-6 col-sm-3">
  			<div class="productshow">
				<a href="#"><img src="images/test.png" class="img-responsive"/></a>
				<span><h4>￥</h4><h3>59.00</h3></span>
				<span><a href="#">HS节能灯</a></span>
			</div>
  		</div>
  		<div class="col-xs-6 col-sm-3">
  			<div class="productshow">
				<a href="#"><img src="images/test.png" class="img-responsive"/></a>
				<span><h4>￥</h4><h3>59.00</h3></span>
				<span><a href="#">HS节能灯</a></span>
			</div>
  		</div>
  
  		<div class="col-xs-6 col-sm-3">
  			<div class="productshow">
				<a href="#"><img src="images/test.png" class="img-responsive"/></a>
				<span><h4>￥</h4><h3>59.00</h3></span>
				<span><a href="#">HS节能灯</a></span>
			</div>
  		</div>
  		<div class="col-xs-6 col-sm-3">
  			<div class="productshow">
				<a href="#"><img src="images/test.png" class="img-responsive"/></a>
				<span><h4>￥</h4><h3>59.00</h3></span>
				<span><a href="#">HS节能灯</a></span>
			</div> -->
    </div>
  </div>
</div>
<!-- 分页 -->
<!-- <div class="domain row text-center">
	<ul class="pagination">
    <li><a href="#">&laquo;</a></li>
    <li class="active"><a href="#">1</a></li>
    <li class="#"><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li><a href="#">&raquo;</a></li>
  </ul>
</div> -->
<div class="footer">
  <div class="container">
    <div class="col-md-3 box_1">
      
    </div>
    <div class="col-md-3 box_2">
      <h4>关于产品</h4>
      <ul class="list_2">
        <li><a href="#">节能灯</a></li>
        <li><a href="#">球泡灯</a></li>
        <li><a href="#">一体化筒灯</a></li>
        <li><a href="#">天花射灯</a></li>
        <li><a href="#">配件</a></li>
      </ul>
      
      <div class="clearfix"> </div>
    </div>
    <div class="col-md-3 box_2">
      <h4>联系我们</h4>
      <address class="address">
        <dl>
         <dt></dt>
         <dd>Address : <span>3598 But I must explain to you how all this mistaken</span></dd>
         <dd>E-mail : <a href="mailto@example.com">info(at)hosting.com</a></dd>
         <dd>Call : <span> +1 800 547 5478</span></dd>
       </dl>
     </address>
   </div>
   <div class="col-md-3 box_2">
    <h4>帮助中心</h4>
    <ul class="footer_social">
      
    </ul>
  </div>
</div>
</div>
<body>
  </html>