<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
  <link href="../css/bootstrap.min.css" rel='stylesheet' type='text/css' />
  <link href="css/style.css" rel='stylesheet' type='text/css' />
  <link href="css/buynow.css" rel='stylesheet' type='text/css' />
  <script src="../js/jquery-1.11.1.min.js"></script>
  <script src="../js/bootstrap.min.js" type="text/javascript"></script>
  <script src="../admin/js/jquery.params.js" type="text/javascript"></script>
</head>
<body>
  <div class="header">
    <div class="container">
      <div class="header_top">
        <div class="logo">
          <a href="index.html"><img src="images/logo.png" alt=""/></a>
        </div>
        
        <div class="cssmenu">
          <ul>
            <li><a href="person.html">会员中心</a></li> 
            <li><a href="cart.jsp">购物车</a></li>
            <li id="showname"><!-- <a href="../html/logorreg.html">登录/注册</a> --></li>
            <li><a  href="javascript:void(0)" id="out">退出</a></li>
          </ul>
          <script type="text/javascript" src="js/nav.js"></script>
        </div>
        <div class="clearfix"> </div>
      </div>
      <div class="buyaddress"><!-- start h_menu4 -->
        <h5>确认收货地址 <a href="address.html">管理收货地址</a></h5>
        
      </div><!-- end h_menu4 -->
			<%--<%!String price= new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8"); %>
			<% num= request.getParameter("num") %>
			<% total= request.getParameter(price*num) %>
            --%><div class="buyyes">
              <h5>确认订单信息</h5>
              <table>
                <thead>
                  <th>图片</th>
                  <th>商品名称</th>
                  <th>属性</th>
                  <th>单价</th>
                  <th>数量</th>
                  <th>合计</th>
                </thead>
                <tbody>
                  <td><img width="50px" height = "60px"  src="..<%=request.getParameter("input_img") %>"/></td>
                  <td><%= request.getParameter("name")%></td>
                  <td><%= request.getParameter("property")%></td>
                  <td><%= request.getParameter("realprice") %></td>
                  <td><%= request.getParameter("num1") %></td>
                  <td><%= request.getParameter("total") %></td>
                </tbody>
              </table>  
              <!-- 留言 -->
              <div class="words">
                确认收货周期：<input id="deliverycycle" type="text" placeholder="写下收货周期(天数哦)，会有一定额度的折扣哦~"/>
                给商家留言：<input id="comments" type="textarea"/>
                是否索要发票:<!-- <input  type="checkbox" style="display:inline;width:20px;"/> --><input type="text" id="invoicetitle" placeholder="集体发票还是个人发票"  style="display:inline"/>
              </div>

              <button id="suborder">提交订单</button>
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
      <script type="text/javascript" src="js/buynow.js"></script>
      <body>
</html>
