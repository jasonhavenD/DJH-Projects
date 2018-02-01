<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
  <title>购物车</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link href="css/cart-style.css" rel='stylesheet' type='text/css' />
  <link href="../css/bootstrap.min.css" rel='stylesheet' type='text/css' />
  <link href="css/style.css" rel='stylesheet' type='text/css' />
  <script src="../js/jquery-1.11.1.min.js"></script>
  <script src="../js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body onload="getProductList()">
  <div class="header">
    <div class="container">
      <div class="header_top">
        <div class="logo">
          <a href="index.html"><img src="images/logo.png" alt=""/></a>
        </div>
        <!--搜索框-->
        <!-- <form class="search-form domain-search">
         
          <div class="three-fifth column first">
            <input type="text" class="text" value="请输入关键字搜索">               
          </div>
          <div class="one-fifth column">
            <input type="submit" value="搜索">
          </div>
          
        </form> -->
        <div class="cssmenu">
          <ul>
            <li><a href="person.html">会员中心</a></li> 
            <li><a href="cart.jsp">购物车</a></li>
            <li id="showname"><!-- <a href="../html/logorreg.html">登录/注册</a> --></li>
            <li><a  href="javascript:void(0)" id="out">退出</a></li>
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
   <div class="">
    <div class="catbox panel panel-default table-responsive" >

     <table id="cartTable">
      <thead>
        <tr>
          <th><label><input class="check-all check" type="checkbox"/>&nbsp;全选</label></th>
          <th>商品</th>
          <th>单价</th>
          <th>数量</th>
          <th>小计</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody>
      	
      <!--   <tr>
          <td class="mycheckbox"><input class="check-one check" type="checkbox"/></td>
          <td class="goods"><img src="images/1.jpg" alt=""/><span>Casio/卡西欧 EX-TR350</span></td>
          <td class="price">20</td>
          <td class="count"><span class="reduce"></span><input class="count-input" type="text" value="1"/><span class="add">+</span></td>
          <td class="subtotal">20</td>
          <td class="operation"><span class="delete">删除</span></td>
        </tr>
        <tr>
          <td class="mycheckbox"><input class="check-one check" type="checkbox"/></td>
          <td class="goods"><img src="images/2.jpg" alt=""/><span>Canon/佳能 PowerShot SX50 HS</span></td>
          <td class="price">30</td>
          <td class="count"><span class="reduce"></span><input class="count-input" type="text" value="12"/><span class="add">+</span></td>
          <td class="subtotal">30</td>
          <td class="operation"><span class="delete">删除</span></td>
        </tr>
      -->
    </tbody>
  </table>
	<form action="./Cart_purchaseProduct" method="post" id="cartform">
      		<input style="display:none" name="cart1" type="text"/>
      	</form>
  <div class="foot" id="foot">
    <label class="fl select-all"><input type="checkbox" class="check-all check"/>&nbsp;全选</label>
    <div class="fr closing">结 算</div>
    <div class="fr total">合计：￥<span id="priceTotal">0.00</span></div>
    <div class="fr selected" id="selected">已选商品<span id="selectedTotal">0</span>件<span class="arrow up">︽</span><span class="arrow down">︾</span></div>
    <div class="selected-view">
      <div id="selectedViewList" class="clearfix">
       <!--  <div><img src="images/1.jpg"><span>取消选择</span></div> -->
      </div>
      <span class="arrow">◆<span>◆</span></span>
    </div>
  </div>

</div>

</div>
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
  <script  src="js/cart-style.js" type="text/javascript"></script>
  </html>