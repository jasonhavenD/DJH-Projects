<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
  <title>主页</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link href="../css/bootstrap.min.css" rel='stylesheet' type='text/css' />
  <link href="css/style.css" rel='stylesheet' type='text/css' />
  <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
  <script src="../js/jquery-1.11.1.min.js"></script>
  <script type="text/javascript" src="./js/index.js"></script>
  <script type="text/javascript" src="./js/productdetail.js"></script>
</head>
<body onload="getData()">

  <div class="header">
    <div class="container">
      <div class="header_top">
        <div class="logo">
          <a href="index.html"><img src="images/logo.png" alt=""/></a>
        </div>
        <!--搜索框-->
        <form class="search-form domain-search">

          <div class="three-fifth column first">
            <input type="text" class="text" placeholder="搜索你想要的产品" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = '';}">               
          </div>
          <div class="one-fifth column">
            <input type="submit" value="搜索">
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
  <div class="banner">
   <div class="container">
    <!-- FlexSlider -->

    <section class="slider">

      <div class="flexslider">
        <ul class="slides">
       
          <li id="one"><a href="productdetail.jsp?id=1"><img src="" class="img-responsive" alt=""/></a>
            
          </li>
          <li id="two"><a href="productdetail.jsp?id=2"><img src="" class="img-responsive" alt=""/></a>
           
          </li>
          <li id="three"><a href="productdetail.jsp?id=3"><img src="" class="img-responsive" alt=""/></a>
            
          </li>
          <li id="four"><a href="productdetail.jsp?id=4"><img src="" class="img-responsive" alt=""/></a>
            
          </li>
          <li id="five"><a href="productdetail.jsp?id=5"><img src="" class="img-responsive" alt=""/></a>
          
        </li>

      </ul>
    </div>
  </section>
  <!-- FlexSlider -->
</div>
</div>

<div class="domain">
  <div class="container">
    <form class="search-form  col-md-9">
      <div class="two-fifth column first">
        <img src="images/search.png" alt=""/>
        <h2><span class="m_1">开始</span>搜索</h2>
      </div>
      <div class="three-fifth column first ">
        <input type="text" class="text" placeholder="搜索你想要的产品" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = '';}" >               
      </div>
      
      <div class="one-fifth column">
        <input type="submit" value="搜索">
      </div>
      <div class="clearfix"> </div>
    </form>
    <div class="col-md-3">
       <!--  <a href="">联系客服</a> -->
    </div>
  </div>
</div>
<div class="benefit">
  <div class="container">
    <h4 class="tz-title-4 tzcolor-blue">
      <p class="tzweight_Bold"><span class="m_1">HOT<br></span><a href="">热门销售</a> <a href="./product.jsp?active=1" style="float:right">更多</a></p>
    </h4>
	
</div><!-- container -->
</div><!-- benefit -->

<div class="domainnew">
  <div class="container">
    <h4 class="tz-title-4 tzcolor-blue">
      <p class="tzweight_Bold"><span class="m_1">NEW<br></span><a href="">新品上市</a><a href="./product.jsp?active=2" style="float:right">更多</a></p>
    </h4>
            
</div><!-- container -->
</div>

<div class="price">
  <div class="container">
    <h4 class="tz-title-4 tzcolor-blue">
      <p class="tzweight_Bold"><span class="m_1">WOW<br></span><a href="">鼎力推荐</a><a href="./product.jsp?active=6" style="float:right">更多</a></p>
     
    </h4>
    
    <div class="clearfix"> </div>               
  </div><!-- container -->
</div><!-- price -->
<!---->
<div class="features">
  <div class="container"></div><!-- container -->
</div>
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
         <dd>地址 : <span>中国 厦门</span></dd>
         <dd>E-mail : <a href="">guangfukeji@163.com</a></dd>
         <dd>电话 :400-2568512 <span></span></dd>
       </dl>
     </address>
   </div>
   <div class="col-md-3 box_2">
    <h4>帮助中心</h4>
    <ul class="footer_social">
      售后常见问题
    </ul>
  </div>
</div>
</div>
<link href="css/slider.css" rel='stylesheet' type='text/css' />
<script defer src="js/slider.js"></script>
<script type="text/javascript">

$(window).load(function(){
  $('.flexslider').flexslider({
    animation: "slide",
    start: function(slider){
      $('body').removeClass('loading');
    }
  });
});
</script>
</body>
</html>


