Date.prototype.Format = function(fmt)   
{   
  var o = {   
    "M+" : this.getMonth()+1,                 //月份   
    "d+" : this.getDate(),                    //日   
    "h+" : this.getHours(),                   //小时   
    "m+" : this.getMinutes(),                 //分   
    "s+" : this.getSeconds(),                 //秒   
    "q+" : Math.floor((this.getMonth()+3)/3), //季度   
    "S"  : this.getMilliseconds()             //毫秒   
  };   
  if(/(y+)/.test(fmt))   
    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
  for(var k in o)   
    if(new RegExp("("+ k +")").test(fmt))   
  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
  return fmt;   
} 

$(function(){
	
	$(".one-fifth").delegate("input","click",function(){
		var condition = $(this).parent().parent().find(".three-fifth input").val();
		if(!condition){
			$(this).parent().parent().find(".three-fifth input").val('搜索你想要的产品');
			return ;
		}
		var url = "product.jsp?condition="+condition;
		var winobj = window.open(url,"_blank");
		winobj.location.href = url;
	});
	$(".h_menu4 .nav li").click(function (){
		var index = $(".nav li").index(this);
		var url = "productType.jsp?producttype="+index;
		var winobj = window.open(url,"_self");
		winobj.location.href=url;
	});
	//***立即购买
	$("button.btn-danger").click(function(){
		var num = $("#quantityinput").val();
		if(num == 0){
			alert("请选择数量")
		}else{
			$("#buynow").submit();	
		}
})
});//function end


/**
 * 显示在producttype页面的内容
 */
function getProductListByType(){
 	var membertype = Number.parseInt($("#membertype").val());
 	var producttype = $.query.get("producttype");
 	if(!producttype || isNaN(producttype)){
 		producttype = 1;
 	}else if(producttype > 6){
 		producttype = 1;
 	}

 	$.post("../Product_getProductDetailByType",{'typeid':producttype},
 		function (data){
 			var list = data.list;
 			var length = list.length;
		//alert(length);
		var str="";
		var picture="";
		var price ="";
		if(length > 0){
			for(var i = 0; i < length ;i++){
				picture = list[i].productpicture.split("|");
				if(membertype == 2){
				price = list[i].logisticsprice;//物流中心
			}else if(membertype == 3 ){
				price = list[i].certifiedprice;//认证经销商
			}else if(membertype == 4){
				price = list[i].price;//普通经销商
			}
			str += "<div class='col-xs-6 col-sm-3'>"+
			"<div class='productshow'>"+
			"<a href='./productdetail.jsp?id="+list[i].productid+"'><img src='.."+picture[0]+"' class='img-responsive'/></a>"+
			"<span style='text-align:center'><h3>￥"+price+"</h3></span>"+
			"<span style='text-align:center'><h4>功率"+list[i].power+"</h4></span>"+
			"<span ><a href='./productdetail.jsp?id="+list[i].productid+"''>&nbsp;"+list[i].productname+"</a></span>"+
			"</div></div>";
			//console.log(list[i].productid);
		}
		$(".productmain .container").html(str);
	}else{
		$(".productmain .container").html('没有相关产品');
	}
});

}
/**
 * 显示在productdetail页面的内容
 */

function getProduct(){
 	var membertype = Number.parseInt($("#membertype").val());
 	var id = $.query.get("id");
 	//倒计时
	var start;//开始时间
	var end;//结束时间
	var total;//总数量
	var number;//起订数量
 	$.post("../Product_getOneProductdetail",{"productid":id},function(data){
		  //alert(data.list.length);
		var list = data.list;
		/*if(list == "fail"){
			alert("请先完善信息");
		}else{

		}*/
		var picture = list[0].productpicture.split("|");
		$("#preview_img").attr("src",".."+picture[0]);
		var str = "";
		if(picture.length > 5){
			picture.length = 5;
		}
		for(var i = 0 ; i < picture.length; i++){
		//picture = list[i].productpicture.split("|");
		str += "<li><a href=\"javascript:void(0);\">"+
		"<img alt='' src='.."+picture[i]+"' width='60' height='60' />"+
		"</a></li>";
		}
		$("#thumb_list").append(str);
		$(".name h2").text(list[0].productname);
		
		if(list[0].isgroupon == 1){//团购
			start = list[0].grouponstarttime;
			end = list[0].grouponendtime;
			//价格
			if(membertype == 2 ){//物流中心
				$(".name .price").text(list[0].price);
				$(".name .realprice").text(list[0].grouponlogisticsprice);
				$("input[name='realprice']").val(list[0].grouponlogisticsprice);
			}else if(membertype == 3){//认证经销商
				$(".name .price").text(list[0].price);
				$(".name .realprice").text(list[0].grouponcertifiedprice);
				$("input[name='realprice']").val(list[0].grouponcertifiedprice);
			}
			total = list[0].grouponquantity;
			number = list[0].grouponstartquantity;
			$(".startnum").html("起订数量"+number+"个");
			time(start,end);
		}else if(list[0].iscrowdfunding == 1){//众筹预售
			start = list[0].crowfundingstarttime;
			end = list[0].crowfundingendtime;
			//价格
			if(membertype == 2 ){//物流中心
				$(".name .price").text(list[0].price);
				$(".name .realprice").text(list[0].crowfundinglogisticsprice);
				$("input[name='realprice']").val(list[0].crowfundinglogisticsprice);
			}else if(membertype == 3){//认证经销商
				$(".name .price").text(list[0].price);
				$(".name .realprice").text(list[0].crowfundingcertifiedprice);
				$("input[name='realprice']").val(list[0].crowfundingcertifiedprice);
			}
			//数量
			total = list[0].inventoryquantity;
			number = list[0].crowfundingstartquantity;
			$(".startnum").html("起订数量"+number+"个");
			time(start,end);
		}else if(list[0].issnapup == 1){//限时促销/限时抢购
			start = list[0].snapupstarttime;
			end = list[0].snapupendtime;
			//价格
			if(membertype == 4 ){//普通经销商
				/*$(".name .price").text(list[0].price);*/
				$(".name .realprice").text(list[0].snapupprice);
				$("input[name='realprice']").val(list[0].snapupprice);
			}else if(membertype == 3){//认证经销商
				/*$(".name .price").text(list[0].price);*/
				$(".name .realprice").text(list[0].snapupcertifiedprice);
				$("input[name='realprice']").val(list[0].snapupcertifiedprice);
			}
			total = list[0].snapupquantity;
			number = list[0].grouponstartquantity;
			$(".startnum").html("起订数量"+number+"个");
			time(start,end);
		}else{
			$(".startnum").hide();
			//不是活动的价格
			if(membertype == 2 ){
				$(".name .price").text(list[0].price);
				$(".name .realprice").text(list[0].logisticsprice);
				$("input[name='realprice']").val(list[0].logisticsprice);
			}
			else if(membertype == 3){
				$(".name .price").text(list[0].price);
				$(".name .realprice").text(list[0].certifiedprice);
				$("input[name='realprice']").val(list[0].certifiedprice);
			}
			else if(membertype == 4){
				$(".name .realprice").text(list[0].price);
				$("input[name='realprice']").val(list[0].price);
			}
		}
		
		//$(".stageclass").html(start);

		
		$("#power").html("<li>"+list[0].power+"</li>");
		$("#lampholder").html("<li>"+list[0].lampholder+"</li>");
		$("#colortemp").html("<li>"+list[0].colortemp+"</li>");
		$("#voltage").html("<li>"+list[0].voltage+"</li>");
		$("#luminousflux").html("<li>"+list[0].luminousflux+"</li>");
		$("#lightefficiency").html("<li>"+list[0].lightefficiency+"</li>");
		$("#colorrendering").html("<li>"+list[0].colorrendering+"</li>");
		$("#beamangle").html("<li>"+list[0].beamangle+"</li>");
		$("#isemc").html("<li>"+list[0].isemc+"</li>");

		$("#favorite span").html(data.favorite);
		if(membertype == 4){
			$("#inventory span").html("有  <span style='color:red'>完善信息可查看具体物流信息</span>");
		}else{
			$("#inventory span").html(data.inventory);
		}
		
		
		$("input[name='productid'").val(id);
		$("input[name='productpicture']").val('..'+picture[0]);
		$("input[name='productname']").val(list[0].productname);
		var property;
		property = list[0].power+" "+list[0].lampholder+" "+
		list[0].colortemp+" "+list[0].voltage+" "+list[0].luminousflux+" "+
		list[0].lightefficiency+" "+list[0].colorrendering+" "+list[0].beamangle+" "+list[0].isemc+"EMC";
		$("input[name='property']").val(property);
	});
	
}
var s1,e1,n1,distance,timerID;//开始时间 结束时间 现在时间 差距
function time(arg1,arg2){
	//倒计时
	var now = new Date();
	n1 = now.getTime();

	var start1 = new Date(arg1).Format("yyyy-MM-dd hh:mm:ss");
	var end1 = new Date(arg2).Format("yyyy-MM-dd hh:mm:ss");
	start1 = new Date(start1);
	end1 = new Date(end1);
	s1 = start1.getTime();
	e1 = end1.getTime();
	n1 = new Date();
	n1 = n1.getTime();
	distance = start1 - now;//开始时间减去现在时间
	if(now > e1){//活动已经结束
		$(".startnum").hide();
		return false;
	}
	setTimeout("show_time()",1000);
}
function show_time(){
	$("#stageclass").show();
	var timer = document.getElementById("stageclass");
	if(!timer){
	return ;
	}
	timer.innerHTML =distance;

	var time_now,time_distance,str_time;
	var int_day,int_hour,int_minute,int_second;
	var time_now=new Date();
	time_now=time_now.getTime()+distance;
	time_distance=e1-time_now;
	if(time_distance>0)
	{
	int_day=Math.floor(time_distance/86400000)
	time_distance-=int_day*86400000;
	int_hour=Math.floor(time_distance/3600000)
	time_distance-=int_hour*3600000;
	int_minute=Math.floor(time_distance/60000)
	time_distance-=int_minute*60000;
	int_second=Math.floor(time_distance/1000)

	if(int_hour<10)
	int_hour="0"+int_hour;
	if(int_minute<10)
	int_minute="0"+int_minute;
	if(int_second<10)
	int_second="0"+int_second;
	str_time=int_day+"天"+int_hour+"小时"+int_minute+"分钟"+int_second+"秒";
	timer.innerHTML=str_time;
	setTimeout("show_time()",1000);
	}
	else
	{
	timer.innerHTML =timer.innerHTML;
	clearTimeout(timerID)
	}
}

/*$(".btn-danger").click(function(){
	var num = $("#quantityinput").val();
	if(num < 1){
		alert("请选择数量");
	}else
	window.location.href = 'buynow.jsp';
})*/