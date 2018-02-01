<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
  <title>确认订单</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link href="<%=basePath %>css/bootstrap.min.css" rel='stylesheet' type='text/css' />
  <link href="<%=basePath %>company/css/style.css" rel='stylesheet' type='text/css' />
  <link href="<%=basePath %>company/css/buynow.css" rel='stylesheet' type='text/css' />
  <script src="<%=basePath %>js/jquery-1.11.1.min.js"></script>
  <script src="<%=basePath %>js/bootstrap.min.js" type="text/javascript"></script>
  <script type="text/javascript" src="<%=basePath %>js/md5.js"></script><!-- 加密算法 -->
  <script src="<%=basePath %>admin/js/jquery.params.js" type="text/javascript"></script>
  <style type="text/css">
  .pay{
    height: 650px;
  }
  .pay #money{
    display: inline-block;
    margin: 60px 5px;
    font-size: 20px;
    color: #ff8261;
    font-weight: bold;

  }
  .pay input{
    display: block;
    margin-bottom: 20px;
  }
  #yes{
    float: right;
  }
  .form-control{
    width: 200px;
  }
  #oldwarn{
    color: red;
  }
  #orderid{
    display: none;
  }
  </style>

</head>
<body>
  <div class="header">
    <div class="container">
      <div class="header_top">
        <div class="logo">
          <a href="index.html"><img src="<%=basePath %>company/images/logo.png" alt=""/></a>
        </div>
        
        <div class="cssmenu">
          <ul>
            <li><a href="person.html">会员中心</a></li> 
            <li><a href="cart.jsp">购物车</a></li>
            <li id="showname"><!-- <a href="../html/logorreg.html">登录/注册</a> --></li>
            <li><a  href="javascript:void(0)" id="out">退出</a></li>
          </ul>
          <script type="text/javascript" src="<%=basePath %>company/js/nav.js"></script>
        </div>
        <div class="clearfix"> </div>
      </div>
      <div class="pay">
        实付金额:<span id="money" ><s:property value="orderinfo.lastprice"/></span><span id="orderid"><s:property value="orderinfo.orderid"/></span>
        <p><span>支付密码：</span><span id="oldwarn"></span></P>
        <input id="oldpay" type="password" class="form-control" onblur="testOld()"/>
        <input type="button" class="btn btn-info" value="确认付款" id="yes"/>
        <img src="<%=basePath %>company/images/pay.jpg"/>
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
<script src="<%=basePath %>company/js/pay.js" type="text/javascript"></script>
<body>
</html>
