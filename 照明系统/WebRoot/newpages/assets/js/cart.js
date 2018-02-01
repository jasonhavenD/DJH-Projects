function getProductList() {
	// alert("in getProductList() of cart.js");
	$
			.post(
					// "./CartDetailListAction",
					"./Cart_getProductList",
					{},
					function(data) {
						// alert("ajax");
						// alert("data: " + data);
						var str = "";
						if (data.list == "NoLogin") {
							// alert("您还未登录，请先登录");
							return;
						} else if (data.list == "fail") {
							alert("获取数据失败");
							return;
						} else if (data.list == "null") {
							alert("您没有购物车权限");
							$("#cartItems").append("您没有购物车权限！");
							return;
						}
						if (data.list.length == 0) {
							// alert("购物车没有商品~");
							// document.getElementById("cartContentForm").style.display='none';
							// document.getElementById("rightDiv").style.display='none';
							str = "<br/>您的购物车是空的，请挑选自己喜欢的产品吧，<a href='./HomePage_retreiveAll'>去购物>>>！</a><br/><br/>";
							// $("#cartItems").append(strInformMsg);
							// $('#informMsg').html(strInformMsg);
						} else {
							// alert("loginSuccess and cart not empty");
							document.getElementById("cartContentForm").style.display = '';
							document.getElementById("rightDiv").style.display = '';
							var array = new Array();
							var array1 = new Array();
							array = data.list;
							var count = "";
							// alert("array: " + array.length);
							for (var i = 0; i < array.length; i++) {
								array1 = array[i];
								// alert("array1: " + array1.length);
								var picture = array1[1].split("|");
								var showPicture = picture[0];
								// showPicture = ".." + showPicture;
								showPicture = "." + showPicture;
								// alert(showPicture);
								str += "<div class='item'>";
								str += "<div class='pull-left' style='margin:35px 0px 0px 5px;;'><input type='checkbox' name='box[]' onclick='checkItem()'><font style='display:none' >"
										+ array1[0]
										+ "</font></div><div class='cart_img pull-left width-100 padding-10 text-left'>";
								str += "<img src=" + showPicture
										+ " alt='' width='80'" + " /></div>";
								str += "<a href=ProductShowAction?productid="
										+ array1[5] + " class='product_name'>";
								str += "<span>" + array1[2] + "</span>";
								str += "<small>功率：" + array1[6] + "</small>"
										+ "</a>";
								str += "<a href='#' class='remove_item'><i class='fa fa-times' onclick=\"deleteCart('"
										+ array1[0] + "')\"></i></a>";
								str += "<div class='total_price'>¥ <span>"
										+ array1[3] * array1[4]
										+ "</span></div>";
								str += "<div class='qty'><input type='number' onclick='changeItemNumber()' value="
										+ array1[4]
										+ " name='qty' maxlength='3' max='999' min='1'/>&times; ¥ <span>"
										+ array1[3] + "</span></div>";
								str += "<div class='clearfix'></div></div>";
							}
						}
						$('#cartItems').html(str);
					});
}

/**
 * 删除购物车某条记录
 */
function deleteCart(obj) {
	// alert("in deleteCart(): " + location.href);
	var cartid = obj;
	console.log(cartid);
	$.ajax({
		type : "post",
		url : "./Cart_deleteCart",
		data : "?ajax=" + Math.random() + "&cartid=" + cartid,
		success : function(data1) {
			// alert("in deleteCart() success");
			if (data1.state == "success") {
				console.log("删除购物车成功，请刷新页面查看。");
				getProductList();
			} else if (data1.state == "fail") {
				console.log("删除购物车失败！");
			}
		}
	});
}

/**
 * 清空购物车
 */
function deleteAllCarts() {
	alert("in deleteAllCarts() x: " + location.href);
	$.ajax({
		type : "post",
		url : "./Cart_deleteAllCarts",
		data : "?gi=" + Math.random(),
		success : function(data1) {
			alert("in deleteAllCarts() success y");
			if (data1.state == "success") {
				console.log("清空购物车成功，请刷新页面查看");
				// getProductList();
			} else if (data1.state == "fail") {
				console.log("清空购物车失败！");
			}
			getProductList();
			// var myform = document.forms[0];
			// myform.addEventListener("submit", function(e) {
			// e.preventDefault();
			// });
			// myform.submit();
			// return true;
		}
	});
}

/* 加入购物车 */

/*
 * $(".ss").click(function() { // options .btn-info alert("Add to the cart...");
 * var productid = $("#span_productId").text(); // alert(productid); var number =
 * $("#quantityinput").val(); // alert(number); if (number == 0) {
 * $("#quantityinput").addClass('red_border'); return false; } // var type = $()
 * $.ajax({ type : 'post', data : { 'cart.product.productid' : productid,
 * 'cart.number' : number }, url :
 * '${pageContext.request.contextPath}/Cart_addOneProduct', success :
 * function(data) { if (data.state == "success") { alert("添加成功，请到购物车查看~"); }
 * else if (data.state == "noLogin") { alert("请重新登录~"); } else if (data.state ==
 * "paramError") { alert("参数错误，请稍后重试~"); } else { alert("添加失败，请稍后重试~"); } } }) })
 */

// function addCart(){
function addOneToCart(productid, number) { // number: amount to be added to
	// cart
	// alert("in addOneToCart() of cart.js");
	// var productid = $("#span_productId").text();
	// alert(productid);
	// var number = $("#quantityinput").val();
	// alert(number);
	// if (number == 0) {
	// $("#quantityinput").addClass('red_border');
	// return false;
	// }

	if (number == -1) {
		number = $("#quantityinput").val();
	}

	// var type = $()
	$.ajax({
		type : 'post',
		data : {
			'cart.product.productid' : productid,
			'cart.number' : number
		},
		url : '${pageContext.request.contextPath}/Cart_addOneProduct',
		success : function(data) {
			// alert(data);
			if (data.state == "success") {
				alert("添加成功，请到购物车查看~");
			} else if (data.state == "noLogin") {
				alert("请重新登录~");
			} else if (data.state == "paramError") {
				alert("参数错误，请稍后重试~");
			} else {
				alert("添加失败，请稍后重试~");
			}
		}
	})
}

var totalprice;
var totalnum;
var Dum = 0;
var discount; // 积分抵扣
// var payprice; // 应付总额

function initCart() {
	totalprice = parseInt(document.getElementById("cartprice").innerHTML);
	totalnum = parseInt(document.getElementById("cartnumber").innerHTML);
	Dum = 0;

	// 积分抵扣
	discount = parseInt(document.getElementById("productprice").parentNode.parentNode.childNodes[3].childNodes[1].innerHTML);
	// 应付总额
	// payprice = totalprice - discount;
}

// 改变所选商品的数量
function changeItemNumber() {
	$("#cartItems")
			.delegate(
					".qty input",
					"click",
					function() {
						// alert("in changeItemNumber()");
						initCart();
						var chk = this.parentNode.parentNode.firstChild.firstChild;
						var subtotal = this.parentNode.previousSibling.lastChild.innerHTML; // 当前小计
						var num = parseInt(this.value);
						var cartid = this.parentNode.parentNode.firstChild.lastChild.innerHTML;

						var price = this.parentNode.lastChild.innerHTML;

						this.parentNode.previousElementSibling.lastChild.innerHTML = price
								* num;
						tempsubtotal = price * num;

						if (!(chk.checked)) {
							// console.log(123);
							chk.checked = true;
						}
						if (chk.checked) {
							// Dvalue = totalprice-subtotal;
							totalprice = totalprice - subtotal;
							totalprice = totalprice + tempsubtotal;
							document.getElementById("cartprice").innerHTML = totalprice;
							document.getElementById("productprice").innerHTML = totalprice;
							document.getElementById("payprice").innerHTML = totalprice
									- discount;
							if (totalprice > discount) {
								document.getElementById("payprice").innerHTML = totalprice
										- discount;
							} else {
								document.getElementById("payprice").innerHTML = 0;
							}
							/*
							 * Dnum = totalnum - num; totalnum = totalnum -
							 * Dnum; console.log(totalnum);
							 * document.getElementById("cartnumber").innerHTML=totalnum;
							 */
							$
									.ajax({
										type : "post",
										url : "./Cart_changeProductCount",
										data : "?ajax=" + Math.random()
												+ "&cartid=" + cartid
												+ "&cartnum=" + num
												+ "&productprice=" + price,
										success : function(data) {
											// alert("in change number 2");
											Dum = data.Dnum;
											// console.log(Dum);
											totalnum = totalnum + Dum;
											document
													.getElementById("cartnumber").innerHTML = totalnum;
										}
									});
							// document.getElementById("cartnumber").innerHTML=totalnum;
						}

					});
}

// xuanzho

// 选中商品
function checkItem() {
	$("#cartItems")
			.delegate(
					".pull-left input",
					"click",
					function() {
						// alert("in checkItem()");
						// console.log(this);
						initCart();
						if (this.checked)/* 如果点击了复选框按钮 */{

							var tempprice = parseInt(this.parentNode.nextSibling.nextSibling.nextSibling.nextSibling.lastChild.innerHTML);
							var tempnum = parseInt(this.parentNode.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.firstChild.value);
							totalprice += tempprice;
							totalnum += tempnum;

							document.getElementById("cartprice").innerHTML = totalprice;
							document.getElementById("productprice").innerHTML = totalprice;
							if (totalprice > discount) {
								document.getElementById("payprice").innerHTML = totalprice
										- discount;
							} else {
								document.getElementById("payprice").innerHTML = 0;
							}

							document.getElementById("cartnumber").innerHTML = totalnum;
						} else if (!(this.checked))/* 如果再次点击复选框 */{
							var tempprice = parseInt(this.parentNode.nextSibling.nextSibling.nextSibling.nextSibling.lastChild.innerHTML);
							var tempnum = parseInt(this.parentNode.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.firstChild.value);
							totalprice -= tempprice;
							totalnum -= tempnum;

							document.getElementById("cartprice").innerHTML = totalprice;
							document.getElementById("productprice").innerHTML = totalprice;
							// var productprice =
							// parseInt(document.getElementById("productprice").innerHTML);
							if (totalprice <= discount) {
								document.getElementById("payprice").innerHTML = 0;
							} else {
								document.getElementById("payprice").innerHTML = totalprice
										- discount;
							}
							document.getElementById("cartnumber").innerHTML = totalnum;
						}
					});
}

/*
 * $("#cartItems").delegate(".pull-left input","click",function(){ })
 */

// 选中/不选 所有商品
function checkUncheckAll() {
	alert("in checkUncheckAll()");
	$("#cartContent")
			.delegate(
					".product_name input",
					"click",
					function() {
						initCart();
						// 判断当前全选是 选中，就取消所有选中状态。如果当前不是选中，难么就要选中。
						if ($('#quan').is(':checked') == false) {
							$('.pull-left').find('input')
									.prop('checked', false);
							// 至于总价钱 是否归零。看你了。。因为可能会是，点击，取消，点击，。。你这个全局变量。。。就危险了
							document.getElementById("cartprice").innerHTML = 0;
							document.getElementById("cartnumber").innerHTML = 0;
							document.getElementById("productprice").innerHTML = 0;
							document.getElementById("payprice").innerHTML = 0;
							// var productprice =
							// document.parseInt(getElementById("productprice").innerHTML);
							totalprice = 0;
							totalnum = 0;
						} else {

							var length = $('.total_price').find('span').length;
							$('.pull-left').find('input').prop('checked', true);
							console.log(length);
							for (var i = 0, len = length; i < len; i++) {
								var arr = $('.total_price').find('span').eq(i)
										.html();
								var arr1 = parseInt(arr);
								totalprice += arr1;
								var count = $('.qty').find('input').eq(i).attr(
										"value");
								var count1 = parseInt(count);
								totalnum += count1;
							}
							console.log(totalprice);
							document.getElementById("cartprice").innerHTML = totalprice;
							document.getElementById("cartnumber").innerHTML = totalnum;
							document.getElementById("productprice").innerHTML = totalprice;
							// var productprice =
							// document.parseInt(getElementById("productprice").innerHTML);
							/*
							 * if((productprice>discount){
							 * document.getElementById("payprice").innerHTML=totalprice-discount;
							 * }else{
							 * document.getElementById("payprice").innerHTML=0; }
							 */
							document.getElementById("payprice").innerHTML = totalprice
									- discount;
						}
					});
}
