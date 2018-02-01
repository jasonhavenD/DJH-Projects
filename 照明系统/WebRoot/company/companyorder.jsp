<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
  <title>我的订单</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link href="../css/bootstrap.min.css" rel='stylesheet' type='text/css' />
  <link href="css/style.css" rel='stylesheet' type='text/css' />
  <link href="css/aboutperson.css" rel='stylesheet' type='text/css' />
  <script src="../js/jquery-1.11.1.min.js"></script>
  <script src="../js/bootstrap.min.js"></script>
  
</head>
<body onload="panyment()">

  <div class="header">
    <div class="container">
      <div class="header_top">
        <div class="logo">
          <a href="index.html"><img src="images/logo.png" alt=""/></a>
        </div>
        <!--搜索框-->
        <form class="search-form domain-search">

          <div class="three-fifth column first">
            <input type="text" class="text" value="搜索订单信息" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = '';}">               
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
      <div class="h_menu4">
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
      <ul>
        <li>会员中心</li>
        <li><a href="showperson.html"><i class="glyphicon glyphicon-user"></i>个人资料</a></li>
        <li><a href="person.html"><i class="glyphicon glyphicon-user"></i>完善资料</a></li>
        <li><a href="modifypassword.html"><i class="glyphicon glyphicon-pencil"></i>密码安全</a></li>
        <li><a href="paypassword.html"><i class="glyphicon glyphicon-lock"></i>支付密码</a></li>
        <li><a href="companyorder.jsp"   class="active"><i class="glyphicon glyphicon-duplicate"></i>我的订单</a></li>
        <li><a href="favorite.html"><i class="glyphicon glyphicon-heart"></i>我的收藏</a></li>
        <li><a href="wallet.html"><i class="glyphicon glyphicon-yen"></i>我的资金</a></li>
        <li><a href="address.html"><i class="glyphicon glyphicon-home"></i>收货地址</a></li>
      </ul>
    </div>
    <div class="container person-container">
      <ul id="myTab" class="nav nav-tabs">
        
        <li class="active">
          <a href="#forpayment" onclick="panyment()" data-toggle="tab">待付款
          </a>
        </li>
        <li>
          <a href="#fordeliver" onclick="fordeliver()" data-toggle="tab">待发货</a>
        </li>
        <li>
          <a href="#forreceipt" onclick= "forreceipt()" data-toggle="tab">待收货</a>
        </li>
        <li>
          <a href="#forcomment" onclick = "forcomment()"data-toggle="tab">待点评</a>
        </li>
        <li>
          <a href="#forok" onclick = "forok()"data-toggle="tab">已完成</a>
        </li>
        <!-- <li>
          <a href="#reservation" onclick = "reservation()" data-toggle="tab">预订成功订单</a>
        </li> -->
      </ul>
      <form style="display:none" action= "comment.jsp" id="tocomment" method="post">
        <input type="text" name="orderid" style="display:none">
        <input type="text" name="productid" style="display:none">
      </form>
		<form style="display:none" action= "./Order_payment" id="tobuy" method="post">
        <input type="text" name="orderinfo.orderid" style="display:none">
        <input type="text" name="orderinfo.lastprice" style="display:none">
      </form>
      <div id="myTabContent" class="tab-content">
      	
       <!-- <div class="tab-pane fade in active" id="all">
        <div class="table-responsive">
          <table class="table table-hover table-bordered">
            <thead>
              <tr>
                <td>产品名称</td>
                <td>单价</td>
                <td>订购数量</td>
                <td>订购时间</td>
                <td>交货周期</td>
                <td>实付金额</td>
                <td>所属区域物流中心</td>
                <td>操作</td>
                
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>产品名称</td>
                <td>单价</td>
                <td>订购数量</td>
                <td>订购时间</td>
                <td>交货周期</td>
                <td>实付金额</td>
                <td>所属区域物流中心</td>
                <td>订单状态</td>
                <td>操作</td>
                
              </tr>
            </tbody>
          </table>
        </div>
       </div> -->
       <div class="tab-pane fade in active" id="forpayment">
        <table class="table table-bordered">
            <thead>
              <tr>
                <th width="10%">图片</th>
                <th width="15%">产品名称</th>
                <th width="30%">属性</th>
                <th width="10%">单价</th>
                <th width="10%">订购数量</th>
                <th width="10%">实付金额</th><!--
                <th>所属区域物流中心</th>
                --><th width="15%">操作</th>
              </tr>
            </thead>
            <tbody>
             	
            </tbody>
          </table>
       </div>
       
       <div class="tab-pane fade" id="fordeliver">
        <table class="table table-bordered">
            <thead>
              <tr>
                <th width="10%">图片</th>
                <th width="15%">产品名称</th>
                <th width="30%">属性</th>
                <th width="5%">单价</th>
                <th width="5%">数量</th>
                <th width="5%">总价</th>
                <th width="10%">下单时间</th>
                <th width="10%">送货周期</th>
                <th width="10%">操作</th>
              </tr>
            </thead>
            <tbody>
              <!-- <tr>
                <td>产品名称</td>
                <td>单价</td>
                <td>订购数量</td>
                <td>订购时间</td>
                <td>交货周期</td>
                <td>实付金额</td>
                <td>所属区域物流中心</td>
                <td><a href="#" class="btn btn-info">提醒发货</a></td>
                <td><a href="#" class="btn btn-info">删除订单  </a></td>
              </tr> -->
            </tbody>
          </table>
       </div>
       <div class="tab-pane fade" id="forreceipt">
        <table class="table table-bordered">
            <thead>
              <tr>
                <th width="10%">图片</th>
                <th width="15%">产品名称</th>
                <th width="30%">属性</th>
                <th width="5%">单价</th>
                <th width="5%">数量</th>
                <th width="5%">总价</th>
                <th width="10%">物流单号</th>
                <th width="10%">物流公司</th>
                <th width="10%">操作</th>
              </tr>
              
            </thead>
            <tbody>
              <!-- <tr>
                <td>产品名称</td>
                <td>单价</td>
                <td>订购数量</td>
                <td>交货周期</td>
                <td>实付金额</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td><a href="#" class="btn btn-info">确认收货</a></td>
                <td><a href="#" class="btn btn-info">申请退款/退货</a></td>
                <td><a href="#" class="btn btn-info">申请换货</a></td>
              </tr> -->
            </tbody>
          </table>
       </div>
       <div class="tab-pane fade" id="forok">
        <table class="table table-bordered">
            <thead>
              <tr>
                <th width="10%">图片</th>
                <th width="15%">产品名称</th>
                <th width="30%">属性</th>
                <th width="10%">单价</th>
                <th width="5%">数量</th>
                <th width="10%">总价</th>
                <!-- <th width="10%">操作</th> -->
              </tr>
              
            </thead>
            <tbody>
              <!-- <tr>
                <td>产品名称</td>
                <td>单价</td>
                <td>订购数量</td>
                <td>交货周期</td>
                <td>实付金额</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td><a href="#" class="btn btn-info">确认收货</a></td>
                <td><a href="#" class="btn btn-info">申请退款/退货</a></td>
                <td><a href="#" class="btn btn-info">申请换货</a></td>
              </tr> -->
            </tbody>
          </table>
       </div>
       <div class="tab-pane fade" id="forcomment">
        <table class="table table-bordered">
            <thead>
              <tr>
                <th width="10%">图片</th>
                <th width="15%">产品名称</th>
                <th width="30%">属性</th>
                <th width="5%">单价</th>
                <th width="5%">数量</th>
                <th width="5%">总价</th>
                <th width="10%">收货日期</th>
                <th width="10%">物流公司</th>
                <th width="10%">操作</th>
              </tr>
            </thead>
            <tbody>
              
            </tbody>
          </table>
       </div>
       <div class="tab-pane fade"  id="reservation">
        <table class="table table-hover table-bordered">
            <thead>
              <tr>
                <th>产品名称</th>
                <th>订购时间</th>
                <th>订购数量</th>
                <th>单价</th>
                <th>实付金额</th>
                
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>产品名称</td>
                <td>单价</td>
                <td>订购数量</td>
                <td>订购时间</td>               
                <td>金额</td>
                </tr>
            </tbody>
          </table>
       </div>
     </div>
    </div>
  </div>
<script src="js/order.js"></script>
</body>
</html>