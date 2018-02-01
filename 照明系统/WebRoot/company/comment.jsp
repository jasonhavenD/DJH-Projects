<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
  <title>评论</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link href="../css/bootstrap.min.css" rel='stylesheet' type='text/css' /> 
  <link href="css/style.css" rel='stylesheet' type='text/css' />
  <link href="css/aboutperson.css" rel='stylesheet' type='text/css'>
  <link href="css/comment.css" rel='stylesheet' type='text/css'>
  <script src="../js/jquery-1.11.1.min.js"></script>
  <script src="../js/bootstrap.min.js"></script>
  <script src="../admin/js/jquery.params.js" type="text/javascript"></script>

  <script src="./js/comment.js"></script>
</script>

<style type="text/css">
.niming{
  padding-bottom: 10px;
}
.starp{
  height: 30px;
  line-height: 30px;
  margin-bottom: 50px;
}
.comm{
  margin: 0px;
  padding-left: 40px;
  padding-top: 15px;
}
#orderid,#productid{
  display: none;
}
</style>
</head>
<body>

  <div class="header">
    <div class="container">
      <div class="header_top">
        <div class="logo">
          <a href="index.html"><img src="images/logo.png" alt=""/></a>
        </div>
        <!--搜索框-->
        <form class="search-form domain-search">

          <div class="three-fifth column first">
            <input type="text" class="text" value="搜索你想要的产品" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = '';}">               
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
          </ul>
        </div>
        <div class="clearfix"> </div>
      </div>
      <div class="h_menu4"><!-- start h_menu4 -->
        <a class="toggleMenu" href="#">主页</a>
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
  <div class="templatemo-flex-row">
    <!--left-->
    <div class="left-sidebar">
      <nav>
        <ul>
          <li>会员中心</li>
          <li><a href="showperson.html"><i class="glyphicon glyphicon-user"></i>个人资料</a></li>
          <li><a href="person.html"><i class="glyphicon glyphicon-user"></i>完善资料</a></li>
          <li><a href="modifypassword.html"><i class="glyphicon glyphicon-pencil"></i>密码安全</a></li>
          <li><a href="paypassword.html"><i class="glyphicon glyphicon-lock"></i>支付密码</a></li>
          <li><a href="companyorder.jsp"><i class="glyphicon glyphicon-duplicate"></i>我的订单</a></li>
          <li><a href="favorite.html"><i class="glyphicon glyphicon-heart"></i>我的收藏</a></li>
          <li><a href="wallet.html"><i class="glyphicon glyphicon-yen"></i>我的资金</a></li>
          <li><a href="address.html"><i class="glyphicon glyphicon-home"></i>收货地址</a></li>
        </ul>
      </nav>
    </div>
    <span id="orderid"><%= request.getParameter("orderid")%></span>
    <span id="productid"><%= request.getParameter("productid")%></span>
    <div class="comm">
    	
    	<textarea id="comment" class="form-control" rows="10" cols="60" placeholder="写下你的评价吧..."></textarea>
      <div id="star">
       <div class="starp">
         <span>本次购物</span>
         <ul>
          <li><a href="javascript:;">1</a></li>
          <li><a href="javascript:;">2</a></li>
          <li><a href="javascript:;">3</a></li>
          <li><a href="javascript:;">4</a></li>
          <li><a href="javascript:;">5</a></li>
        </ul>
        <span id="fen"></span>
        <p></p><br />
      </div>

    </div>
    <!-- <div class="niming">
      <input type="checkbox"  /> 
      <span >匿名评论</span><br />
    </div> -->
    <button type="button" class="btn btn-info">提交评价</button>


  </div>
</div>


</div>
<script src="./js/comment-ajax.js"></script>
</body>
</html>