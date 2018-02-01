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
  <script type="text/javascript" src="./js/productdetail.js"></script>
  <script type="text/javascript" src="../admin/js/jquery.params.js"></script>
<script type="text/javascript">
	  	
	  </script>
</head>
<!-- 通过产品类型获取列表 -->
<body onload="getProductListByType()">
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
         <li><a href="index.jsp">主页</a></li>
         <li><a href="javascript:void(0)" >节能灯</a></li>
         <li><a href="javascript:void(0)" >球泡灯</a></li>
         <li><a href="javascript:void(0)" >一体化筒灯</a></li>
         <li><a href="javascript:void(0)" >天花射灯</a></li>
         <li><a href="javascript:void(0)" >吸顶灯</a></li>
         <li><a href="javascript:void(0)" >配件</a></li>
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
         <dd>地址 : <span>中国 厦门</span></dd>
         <dd>E-mail : <a href="">guangfukeji@163.com</a></dd>
         <dd>电话 :400-2568512 <span></span></dd>
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
<script type="text/javascript">
	
	var producttype = $.query.get("producttype");
	  	if(!producttype || isNaN(producttype)){
	  		producttype = 1;
	  	}else if(producttype > 6){
	  		producttype = 1;
	  	}
	$("ul.nav li").eq(producttype).find("a").addClass("active");
</script>
<body>
  </html>