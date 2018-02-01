$(".btn-hehe").click(function() {
		alert("111");
		alert("222");
		alert("333");
		alert("444");
		//var productid = $.query.get("id");
		
		var productid = $.query.get("productid");
		
		alert("555");
		
		alert("productid: " + productid);
		
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
	})