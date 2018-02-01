

/*获取收藏信息*/
function getCollect(){
	$("#showTable").html("");
	var favoriteoptions={
		    type:"post",
			url:"../Favorites_getCollect",
			async:true,
			success:function(data){
				if(data.collectList == "none"){
					alert("请先完善信息，再添加收藏~");
				}else {
				var temp=data.collectList;
				//alert("success");
				for(var i=0;i<temp.length;i++){
					var membertype=temp[i][7];
					//alert(membertype);
					var str=temp[i][2];
					var addlist=str.split("|");
					var firstadd='/LightSystem'+addlist[0];
					//alert("首个图片地址"+firstadd);
					if(membertype==2){
						var _tr=$("<ul class=\"f-wrapper\"><li class=\"trash\" onclick=\"deleteOne("+temp[i][0]+")\"><i class=\"glyphicon glyphicon-trash\"></i></li><li class=\"f-pic\"><img src="+
						firstadd+"></li><li class=\"f-a\"><a href=\"javascript:void(0)\" onclick=\"buy("+temp[i][8]+","+temp[i][9]+")\">"+temp[i][1]+"</a></li> <li class=\"f-p\"><b>￥</b><span class=\"f-price\">"+
						temp[i][5]+"</span><span class=\"through\">"+temp[i][3]+"</span></li> <li><p  style=\"display:none\">"+temp[i][0]+"</p></li><div class=\"comoptions\"><a href=\"javascript:void(0)\" class=\"add\" onclick=\"addCartF("+temp[i][8]+")\">加入购物车</a><a href=\"javascript:void(0)\" class=\"buy\" onclick=\"buy("+temp[i][8]+","+temp[i][9]+")\">立即购买</a></div></ul>"
						);
						$("#showTable").append(_tr); 
					}
					else if(membertype==3){
						var _tr=$("<ul class=\"f-wrapper\"><li class=\"trash\" onclick=\"deleteOne("+temp[i][0]+")\"><i class=\"glyphicon glyphicon-trash\"></i></li><li class=\"f-pic\"><img src="+
						firstadd+"></li><li class=\"f-a\"><a href=\"javascript:void(0)\" onclick=\"buy("+temp[i][8]+","+temp[i][9]+")\">"+temp[i][1]+"</a></li> <li class=\"f-p\"><b>￥</b><span class=\"f-price\">"+
						temp[i][4]+"</span><span class=\"through\">"+temp[i][3]+"</span></li> <li><p  style=\"display:none\">"+temp[i][0]+"</p></li><div class=\"comoptions\"><a href=\"javascript:void(0)\" class=\"add\" onclick=\"addCartF("+temp[i][8]+")\">加入购物车</a><a href=\"javascript:void(0)\" class=\"buy\" onclick=\"buy("+temp[i][8]+","+temp[i][9]+")\">立即购买</a></div></ul>"
						);
						$("#showTable").append(_tr); 
					}
					else{
						var _tr=$("<ul class=\"f-wrapper\"><li class=\"trash\" onclick=\"deleteOne("+temp[i][0]+")\"><i class=\"glyphicon glyphicon-trash\"></i></li><li class=\"f-pic\"><img src="+
						firstadd+"></li><li class=\"f-a\"><a href=\"javascript:void(0)\" onclick=\"buy("+temp[i][8]+","+temp[i][9]+")\">"+temp[i][1]+"</a></li> <li class=\"f-p\"><b>￥</b><span class=\"f-price\">"+
						temp[i][3]+"</span></li> <li><p  style=\"display:none\">"+temp[i][0]+"</p></li><div class=\"comoptions\"><a href=\"javascript:void(0)\" class=\"add\" onclick=\"addCartF("+temp[i][8]+")\">加入购物车</a><a href=\"javascript:void(0)\" class=\"buy\" onclick=\"buy("+temp[i][8]+","+temp[i][9]+")\">立即购买</a></div></ul>"
						);
					$("#showTable").append(_tr);
					}
					
				}
		
			}
			},
			dataType:"json",
			error:function(data){
			alert("获取信息失败，请重试！");
		    }
	};
	$.ajax(favoriteoptions);
}

/*删除收藏信息 */
function deleteOne(obj){
	//var favoriteid=$(obj).parent().parent().find("p").html();
	var conf = confirm('确定删除吗？');
	if(conf){
		var favoriteid = obj;
		var favoriteoptions={
			type:'post',
			url:"../Favorites_deleteOne",
			data:{
			"favoriteid":favoriteid
			},
			async:true,
			success:function(data){
			if(data.state=="success"){
				alert("恭喜你，删除收藏成功");
				getCollect();
			}else if(data.state == "noLogin"){
				alert("请重新登录");
			}
			},
			dataType:"json",
			error:function(data){
			alert("删除失败了");
			}
			};
			$.ajax(favoriteoptions);
	}
	
}
/*添加收藏信息 */
/*function addOneFavorite(obj){
	var favoriteid;
	alert(favoriteid);
	var favoriteoptions={
	   	  type:'post',
			url:"../Favorites_addOneFavorite",
			data:{
			"favoriteid":favoriteid
			},
			async:true,
			success:function(data){
				if(data.state=="success"){
		    		alert("恭喜你，添加收藏成功");
		    		//window.location.href="../company/address.html";
		    	}
			},
			dataType:"json",
		    error:function(data){
			alert("失败了");
		    }
	   };
	 $.ajax(favoriteoptions);
}*/
/*添加到收藏夹*/
/*$(".collect").click(function(){
	//获取本页商品id
	var productid = $.query.get("id");
	$.ajax({
		type:'post',
		data:{'productid':productid},
		url:'../Favorites_addOneFavorite',
		success:function(data){
			if(data.state == "success"){
				alert("收藏成功！请到收藏夹查看~");
			}else{
				alert("收藏失败！请重试~");
			}
		}
	})
	
})*/
//加入购物车
function addCartF(arg){
	var productid = arg;//产品id
	var number = 1;//默认数量为1
	//var type = $()
	$.ajax({
		type:'post',
		data:{'cart.product.productid': productid,'cart.number':number},
		url:'../Cart_addOneProduct',
		success:function(data){
			if(data.state == "success"){
				alert("添加成功，请到购物车查看~");
			}else if(data.state == "noLogin"){
				alert("请重新登录~");
			}else if(data.state == "paramError"){
				alert("参数错误，请稍后重试~");
			}else{
				alert("添加失败，请稍后重试~");
			}
		}
	})
}
//立即购买,跳转至商品详情页面。真正的购买在 productdetail.js
function buy(arg1,arg2){
	var productid = arg1;
	var type = arg2;
	/*if(type == 1){*/
		window.location.href = "productdetail.jsp?id="+arg1+"";
	/*}*/

}
/*垃圾桶图标动态操作*/

	/*$(".f-wrapper").delegate("mouseover",function(){

	})*/

	$("ul.f-wrapper").delegate("li","mouseover",function(){
		alert("hello");
		$("ul.f-wrapper").find(".trash").show()
	})
	$("ul.f-wrapper").delegate("li","mouseout",function(){
		$("ul.f-wrapper").find(".trash").hide()
	})

	