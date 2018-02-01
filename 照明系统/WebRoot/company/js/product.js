$(function(){
	//alert("ddd");
	$(".one-fifth").delegate("input","click",function(){
		var condition = $(this).parent().parent().find(".three-fifth input").val();
		if(!condition){
			$(this).parent().parent().find(".three-fifth input").val('搜索你想要的产品');
			return ;
		}
		var url = "product.jsp?condition="+condition;
		var winobj = window.open(url,"_self");
		winobj.location.href = url;
//		$.post("../Product_searchProduct",{
//		"active":condition
//	},function(data){
//		var list = data.morelist;
//		var length = list.length;
//		//alert(length);
//		var str="";
//		var picture="";
//	    var price ="";
//		if(length > 0){
//			for(var i = 0; i < length ;i++){
//			picture = list[i].productpicture.split("|");
//			if(membertype == 2){
//				price = list[i].logisticsprice;//物流中心
//			}else if(membertype == 3 ){
//				price = list[i].certifiedprice;//认证经销商
//			}else if(membertype == 4){
//				price = list[i].price;//普通经销商
//			}
//			str += "<div class='col-xs-6 col-sm-3'>"+
//			"<div class='productshow'>"+
//				"<a href='./producttubelamps.html?id="+list[i].productid+"'><img src='.."+picture[0]+"' class='img-responsive'/></a>"+
//				"<span style='text-align:center'><h3>￥"+price+"</h3></span>"+
//				"<span style='text-align:center'><h4>功率"+list[i].power+"</h4></span>"+
//				"<span ><a href='./producttubelamps.html?id="+list[i].productid+"''>&nbsp;"+list[i].productname+"</a></span>"+
//			"</div></div>";
//		    console.log();
//			}
//			$(".productmain .container").html(str);
//		}
//			$(".productmain .container").html('没有相关产品');
//	});
	});
});//---function 结束
//搜索
function getList(){
	var membertype = Number.parseInt($("#membertype").val());
	var condition = $.query.get("condition");
	var active = $.query.get("active");
	var url = "../Product_getMoreShow";
	if(active == 1){
		active = 'hot';
	}else if(active == 2){
		active = 'new';
	}else if(active == 3){
		active = 'snapup';
	}else if(active == 4){
		active = 'crowd';
	}else if(active == 5){
		active = 'group';
	}else if(active == 6){
		active = 'jian';
	}
	else if(condition)
	{
		url="../Product_searchProduct";
		active = condition;
	}else 
	{
		return ;
	}
	$.post(url,{
		"active":active
	},function(data){
		var list = data.morelist;
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
		    console.log(list[i].productid);
			}
			$(".productmain .container").html(str);
		}else{
			$(".productmain .container").html('没有相关产品');
			}
	})
}
function getListByType(){
	var membertype = Number.parseInt($("#membertype").val());

	var condition = $.query.get("condition");
	var active = $.query.get("active");
	var url = "../Product_getMoreShow";
	if(active == 1){
		active = 'hot';
	}else if(active == 2){
		active = 'new';
	}else if(active == 3){
		active = 'snapup';
	}else if(active == 4){
		active = 'crowd';
	}else if(active == 5){
		active = 'group';
	}else if(active == 6){
		active = 'jian';
	}
	else if(condition)
	{
		url="../Product_searchProduct";
		active = condition;
	}else 
	{
		return ;
	}
	$.post(url,{
		"active":active
	},function(data){
		var list = data.morelist;
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
		    console.log(list[i].productid);
			}
			$(".productmain .container").html(str);
		}else{
			$(".productmain .container").html('没有相关产品');
			}
	})
}
