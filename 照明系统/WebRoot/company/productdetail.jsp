<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>商品详情</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<link href="css/energyb.css" rel='stylesheet' type='text/css' />
<link href="css/style.css" rel='stylesheet' type='text/css' />
<script src="../js/jquery-1.11.1.min.js"></script>
<script src="../js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/productdetail.js"></script>
<script src="../admin/js/jquery.params.js" type="text/javascript"></script>

</head>
<!--搜索-->
<body onload="getProduct()">
<div class="header">
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
<div class="container">
	<div class="row">
    <div class="col-md-5">
      <div class="detail-pic">
        <div class="img-wrap">                                
        	<img id="preview_img" src="" height="310" alt="节能灯">
        </div>
        <div class="detail-pic-min">
          <a href="javascript:void(0);" class="detail-pic-prev prev-disabled" id="prev_thumb"></a>
          <div class="detail-pic-ul">
            <ul class="fn-clear"  id="thumb_list">
            </ul>
          </div>
          <a href="javascript:void(0);" class="detail-pic-next next-disabled" id="next_thumb"></a>
        </div>
      </div>
      <div class="clearfix"></div>
      <div class="col-md-12 coll">
        <span class="glyphicon glyphicon-star collect"></span>
        <span class="collection collect">收藏该商品</span>
        <span class="glyphicon glyphicon-share-alt"></span>
        <span class="share">分享</span>
      </div>
    </div>
    <!-- left -->
    <div class="col-md-6">
       <form action="./Product_purchaseProduct" method="post" id="buynow">
        <input style="display: none" name="productid"/>
      <div class="name">
        <h2>一体化筒灯</h2>
        <label>价格  </label>
        <input style="display: none" name="productname"/>
        <input style="display: none" name="productpicture"/>
        
        <p class="price"></p>
        
        <p class="realprice"> </p>
        <!-- 倒计时 -->
        <div id="stageclass">

        </div>
        <!--<h4>备注信息</h4>
      -->
      <input type="text" name="realprice" style="display:none"> 
      </div>
        <div class="manyoptions">
          <span class="p-heading">功率(W)</span>
          <ul class="choose" id="power"></ul>
        </div>
        <div class="manyoptions">
          <span class="p-heading">灯头</span>
          <ul class="choose" id="lampholder"></ul> 
        </div>
        <div class="manyoptions">
          <span class="p-heading">色温(K)</span>
          <ul class="choose" id="colortemp"></ul>    
        </div>
        <div class="manyoptions">
          <span class="p-heading">电压(V)</span>
          <ul class="choose" id="voltage"></ul>   
        </div>
        <div class="manyoptions">
          <span class="p-heading">光效(Lm/W)</span>
          <ul class="choose" id="lightefficiency"></ul> 
        </div>
        <div class="manyoptions">
          <span class="p-heading">显色指数</span>
          <ul class="choose" id="colorrendering"></ul>    
        </div>
        <div class="manyoptions">
          <span class="p-heading">光束角</span>
          <ul class="choose" id="beamangle"></ul>   
        </div>
        
        <div class="manyoptions">
          <span class="p-heading">光通量(Lm)</span>
          <ul class="choose" id="luminousflux"></ul>         
        </div>
        <div class="manyoptions">
          <span class="p-heading">是否符合EMC</span>
          <ul class="choose" id="isemc"></ul>       
        </div>
      
      <div class="num">
        <label>数量</label>
        <input id="quantityinput" name="num" type="number" class="form-control"  min="1" step="1" placeholder="0" value="0" oninput="changeQuantity()"/>
        <label>个</label>
        <label class="startnum"></label>
      </div>
      <input type="text" name="total" style="display:none">  <!-- 总价 -->
      <input type="text" name="property" style="display:none">
      <%--<input type="text" name="productid" style="display:none">
      ---%><!--<div class="elseoptions">
         <label>已销数量</label>
         <span>100<span>件</span></span>
      </div>
      --><div class="elseoptions" id="favorite">
         <label>收藏人气</label>
         <span>1200</span>
      </div>
      <div class="elseoptions" id="inventory">
         <label>库存</label>
         <span>1</span>
      </div>
      </form>
      <div class="options">
        <button type="input" class="btn btn-info">加入购物车<span class="glyphicon glyphicon-shopping-cart"></span></button>
        <button type="input" class="btn btn-danger">立即购买</button>
      </div>
      
      
    </div>
    
    <div class="col-md-12" id="show">
      <!-- Nav tabs -->
      <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">图文详情</a></li>
        <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">累计评论</a></li>
      </ul>

      <!-- Tab panes -->
      <!-- <div class="tab-content">
        <div role="tabpanel" class="tab-pane active" id="home">图文</div>
        <div role="tabpanel" class="tab-pane" id="profile">pl </div>
      </div> -->
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
      售后常见问题
    </ul>
  </div>
</div>
</div>
<script src="js/energyb.js" type="text/javascript"></script>

<body>
</html>