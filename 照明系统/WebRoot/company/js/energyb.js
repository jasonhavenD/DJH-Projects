function changeQuantity(){
	var num = $("#quantityinput").val();
	 var productid = $.query.get("id");
	/*if(num>10000){
		alert("数量超过范围！");
		$("#quantityinput").val("1");
		$("#quantityinput").focus();
	}else{*/
		$("input[name ='num']").val = num;
		var price = $("input[name='realprice']").val();
		var total = num*price;
		$("input[name ='total']").val(total);
		$("input[name ='productid']").val(productid);
	/*}*/
}

$('ul.fn-clear ').delegate("img","click",function () {
    var picSrc = $(this).attr('src');
    $('#preview_img').attr('src', picSrc);
});
$('ul.choose ').delegate('li','click',function(){
	$(this).addClass('addcolor');
	$(this).siblings().removeClass('addcolor');
	var text = $(this).html();
	$(this).parent().parent().find("input").val(text);
});
/*添加到收藏夹*/
$(".collect").click(function(){
	//获取本页商品id
	var productid = $.query.get("id");
	
	alert("id: " + id);
	
	/*var companyid = $("#cid").val();*/
	$.ajax({
		type:'post',
		data:{'productid':productid},
		url:'../Favorites_addOneFavorite',
		success:function(data){
			if(data.state == "success"){
				alert("收藏成功！请到收藏夹查看~");
			}else if(data.state == "repeat"){
				alert("该产品已经收藏过了！请到收藏夹查看~");
			}else if(data.state == "none"){
				alert("请完善信息~");
			}else{
				alert("收藏失败！请重试~");
			}
		}
	})
	
})
//从收藏夹加入购物车//在favorite.js

//立即购买
function buy(arg){
	var productid = arg;

}
//在商品详情页 加入购物车
/*加入购物车*/
/*function addCart(){*/
	$(".options .btn-info").click(function(){
	var productid = $.query.get("id");
	var number = $("#quantityinput").val();
	if(number == 0){
		$("#quantityinput").addClass('red_border');
		return false;
	}
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
/*}*/
})