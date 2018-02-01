<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
  <script src="<%=basePath %>admin/js/jquery.params.js" type="text/javascript"></script>
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
      <div class="buyaddress"><!-- start h_menu4 -->
        <h5>确认收货地址 <a href="address.html">管理收货地址</a></h5>
        
      </div>
      <form action="./Order_createOrder" method="post" class="buyyes">
              <h5>确认订单信息</h5>
              <table id="buynow">
                <thead>
                  <th>图片</th>
                  <th>商品名称</th>
                  <th>属性</th>
                  <th>单价</th>
                  <th>数量</th>
                  <th>合计</th>
                </thead>
                <tbody>
                  <%--<td><img width="50px" height = "60px"  src="..<s:property value='hashmap.productpicture'/>"/></td>
                  <td><s:property value='hashmap.productname'/></td>
                  <td><s:property value='hashmap.property'/></td>
                  <td><s:property value='hashmap.realprice'/></td>
                  <td><s:property value="hashmap.num"/></td>
                  <td><s:property value="hashmap.total"/></td>
                  <td style="display:none"><s:property value="hashmap.productid"/></td>
                --%>
                <s:iterator value="listmap" id="products" status="st0">
                	<tr>
                	<s:iterator value="products" status="st" id="tmp">
                	<s:if test="#st.isFirst()">
                	 	<td><img width="50px" height = "60px"  src="<s:property value='tmp'/>"/></td>
                	</s:if>
                	 <s:elseif test="#st.isLast()">
                	 	 <td style="display:none"><input name="list[<s:property value="#st0.index"/>].product.productid"
                	 	  value="<s:property value="tmp"/>"/>
                	 	  
                	 	  </td>
                	 </s:elseif>
                	 <s:else>
                  	  <td><s:property value="tmp"/>
                  	  
                  	  <s:if test="#st.index==4">
                  	  	<input name="list[<s:property value="#st0.index"/>].quantity" value="<s:property value='tmp'/>" style="display:none">
                  	  </s:if>
                  	  </td>
                	 </s:else>
	                 
                	</s:iterator>
                	</tr>
                </s:iterator>
               
                </tbody>
                
              </table>  
              <!-- 留言 -->
              <div class="words">
                确认收货周期：<input name="orderinfo.deliverycycle" type="text" placeholder="写下收货周期(天数哦)，会有一定额度的折扣哦~"/>
                给商家留言：<input name="orderinfo.comments" type="textarea"/>
                发票抬头:<!-- <input  type="checkbox" style="display:inline;width:20px;"/> -->
                <input type="text" name="orderinfo.invoicetitle" placeholder="为空没有发票"  style="display:inline"/>
              </div>
              <input type="text" name="orderinfo.lastprice" style="display:none">
              <input name="orderinfo.address.addressid" id="addressid" type="text" style="display:none"> 
              <input type="button" id="suborder" value="提交订单"></input>
        </form>
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
      <script type="text/javascript" src="<%=basePath %>company/js/buynow.js"></script>
      <body>
</html>
