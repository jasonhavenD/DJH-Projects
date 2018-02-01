var map = new Map();
var propertyid = 0;
function imgChange() {
	$("#file").click();

}
function PImgChange() {
	$("#file1").click();
}
function uploadPImg() {
	$("#uploadTp1").ajaxSubmit({
		success : function(data) {
			portraitpath = data.path;
			$("#productTp").attr("src", portraitpath);
			$("#proimg").val(portraitpath);
			alert($("#proimg").val());
			alert("上传成功");
		}
	});
}
function pass(value) {
	var id = $(value).attr("id");
	$.post("../Producttype_findOneProducttype", {
		"id" : map.get(id).parentproducttypeid
	}, function(data) {

		if (data.ptype != null && data.ptype != "")
			$("input[name='parenttypename']").val(data.ptype);
		else
			$("input[name='parenttypename']").val("-1");
	});

	var path = map.get(id).producttypepicturepath;
	var name = map.get(id).producttypename;

	$("#tp").attr("src", "../" + path);
	$("#producttypeid").val(id);
	if (path == null)
		$("#producttypepicturepath").val("");
	else
		$("#producttypepicturepath").val(path);
	$("#producttypename").val(name);
}
function tijiao() {
	$("#uploadTp").ajaxSubmit({
		success : function(data) {
			portraitpath = data.path;
			$("#tp").attr("src", portraitpath);
			$("#producttypepicturepath").val(portraitpath);
			alert("上传成功");
		}
	});
}

$(document)
		.ready(

				function() {
					$
							.post(
									"../Producttype_findFirstProducttype",
									"",
									function(data) {
										if (data.plist != null) {
											$("#tbody").empty();
											for (var i = 0; i < data.plist.length; i++) {
												map
														.put(
																data.plist[i].producttypeid,
																data.plist[i]);
												$("#tbody")
														.append(
																"<tr name='0' id='"
																		+ data.plist[i].producttypeid
																		+ "'><td>"
																		+ data.plist[i].producttypeid
																		+ "</td><td>"
																		+ data.plist[i].producttypename
																		+ "</td><td><img width='60px' height='40px' src='../"
																		+ data.plist[i].producttypepicturepath
																		+ "'></td><td><button type='button' id='"
																		+ data.plist[i].producttypeid
																		+ "' name='"
																		+ data.plist[i].typecount
																		+ "' onclick='expand(this)' class='btn btn-success btn-xs'><span class='glyphicon glyphicon-plus'></span> 展开</button><button id='"
																		+ data.plist[i].producttypeid
																		+ "' data-target='#change' onclick='pass(this)' data-toggle='modal' type='button' class='btn btn-info btn-xs'><span class='glyphicon glyphicon-pencil'></span> 修改</button><button type='button' id='"
																		+ data.plist[i].producttypeid
																		+ "'+ onclick='removetype(this)' class='btn btn-danger btn-xs'><span class='glyphicon glyphicon-trash'></span> 删除</button></td></tr>");
											}
										}
									});
				});
function shousuo(value) {
	var count = Number($(value).find("span").attr("name").substr(6));
	var Count = count;
	// while(count != 0){

	// }
	for (var i = $($(value).parent()).parent().index() + 2; count > 0; i++, count--) {
		// alert(i);
		$($("#producttype tr")[i]).hide();

	}
	$(value).attr("onclick", "show(this)");
	$(value).html(
			"<span name='length" + Count
					+ "' class='glyphicon glyphicon-plus'></span> 展开");
}
function show(value) {
	var count = Number($(value).find("span").attr("name").substr(6));
	// while(count != 0){
	var Count = count;
	// }
	// alert(count);
	for (var i = $($(value).parent()).parent().index() + 2; count > 0; i++, count--) {
		// alert(i);
		$($("#producttype tr")[i]).show();

	}
	$(value).attr("onclick", "shousuo(this)");
	$(value).html(
			"<span name='length" + Count
					+ "' class='glyphicon glyphicon-minus'></span> 收拢");
}

function expand(value) {
	var id = $(value).attr("id");
	//alert(window.location.href);
	var count = $(value).attr("name");

	$
			.post(
					"../Producttype_findProducttype",
					{
						"id" : id,
						"count" : Number(count) + 1
					},
					function(data) {
						//alert("data: " + data);
						$(value).attr("onclick", "shousuo(this)");
						$(value)
								.html(
										"<span name='length"
												+ data.plist.length
												+ "' class='glyphicon glyphicon-minus'></span> 收拢");

						var str = "";
						while (count != 0) {
							str += "&nbsp;&nbsp;";
							count--;
						}
						for (var i = 0; i < data.plist.length; i++) {
							 //alert(data.plist[i].producttypepicturepath);
							map.put(data.plist[i].producttypeid, data.plist[i]);
							$("#" + id)
									.after(
											"<tr name='0' id='"
													+ data.plist[i].producttypeid
													+ "'><td>"
													+ data.plist[i].producttypeid
													+ "</td><td>"
													+ str
													+ data.plist[i].producttypename
													+ "</td><td>"
													+ str
													+ "<img width='60px' height='40px' src='../"
													+ data.plist[i].producttypepicturepath
													+ "'></td><td><button type='button' id='"
													+ data.plist[i].producttypeid
													+ "' name='"
													+ data.plist[i].typecount
													+ "' onclick='expand(this)' class='btn btn-success btn-xs'><span class='glyphicon glyphicon-plus'></span> 展开</button><button id='"
													+ data.plist[i].producttypeid
													+ "' data-target='#change' onclick='pass(this)' data-toggle='modal' type='button' class='btn btn-info btn-xs'><span class='glyphicon glyphicon-pencil'></span> 修改</button><button id='"
													+ data.plist[i].producttypeid
													+ "'+ onclick='removetype(this)' type='button' class='btn btn-danger btn-xs'><span class='glyphicon glyphicon-trash'></span> 删除</button></td></tr>");
						}
					});
}

function removetype(value) {
	var id = $(value).attr("id");
	window.location.href = "../Producttype_deleteProducttype?id=" + id;
}

var viewModel = {
	product : new u.DataTable({
		meta : {
			productid : {
				type : 'integer'
			},
			producttypename : {
				type : 'string'
			},// 产品类型名字
			productname : {
				type : 'string'
			},
			price : {
				type : 'double'
			},// 普通用户看到的价格
			certifiedprice : {
				type : 'double'
			},// 认证经销商
			logisticsprice : {
				type : 'double'
			},// 物流中心
			inventoryquantity : {
				type : 'string'
			},
			issnapup : {
				type : 'integer'
			},
			isgroupon : {
				type : 'integer'
			},
			iscrowdfunding : {
				type : 'integer'
			}
		}
	}),
	hideTd : ko.observable(false),
	addType : function(protype) {
		if (!protype) {
			$("#protypewarn").html("请输入类型");
		} else {
			$.post('../Product_addProductType', {
				'producttypename' : protype
			}, function(data) {
				if (data.addResult == "success")
					$("#protypewarn").html("添加成功");
				else if (data.addResult == "repeat")
					$("#protypewarn").html("已存在不能重复添加");
				else
					$("#protypewarn").html("添加失败");
			})
			$("#protype").val("");
		}
	},
	addProduct : function() {
		var proname = $("#proname").val().trim();// 产品名称
		if (proname == "") {
			$("#pronamewarn").text("不能为空");
			return false;
		} else {
			$("#pronamewarn").text("");
		}
		var typeshow = $("#typeshow").val();// 类别
		var productpicture = $("#imagename").val().trim();
		if (productpicture == "") {
			$("#filewarn").text("请上传图片");
			return false;
		}
		var price = $("#price").val().trim();
		if (price == "") {
			$("#pricewarn").text("不能为空");
			return false;
		} else {
			$("#pricewarn").text("");
		}

		var certifiedprice = $("#certifiedprice").val().trim();
		if (certifiedprice == "") {
			$("#certifiedpricewarn").text("不能为空");
			return false;
		} else {
			$("#certifiedpricewarn").text("");
		}
		var logisticsprice = $("#logisticsprice").val().trim();
		if (logisticsprice == "") {
			$("#logisticspricewarn").text("不能为空");
			return false;
		} else {
			$("#logisticspricewarn").text("");
		}
		var inventoryquantity = $("#inventoryquantity").val().trim();
		var power = $("#power").val().trim();
		var lampholder = $("#lampholder").val().trim();
		var colortemp = $("#colortemp").val().trim();
		var voltage = $("#voltage").val().trim();
		var luminousflux = $("#luminousflux").val().trim();
		var lightefficiency = $("#lightefficiency").val().trim();
		var colorrendering = $("#colorrendering").val().trim();
		var beamangle = $("#beamangle").val().trim();
		var isemc = $("#isemc").val().trim();
		var sendpoints = $("#sendpoints").val().trim();
		if (sendpoints == "") {
			$("#sendpointswarn").text("不能为空");
			return false;
		} else {
			$("#sendpointswarn").text("");
		}

		var productdiscribe = UE.getEditor('productdiscribe').getContent();
		if (productdiscribe == "") {
			$("#productdiscribewarn").text("不能为空");
			return false;
		} else {
			$("#productdiscribewarn").text("");
		}
		var issale = $("#issale").val().trim();
		var ishot = $("#ishot").val().trim();
		var isnew = $("#isnew").val().trim();
		var isrecommend = $("#isrecommend").val().trim();
		var issnapup = $("#issnapup0").val().trim();
		var isgroupon = $("#isgroupon0").val().trim();
		var iscrowdfunding = $("#iscrowdfunding0").val().trim();

		var snapupstarttime = $("#snapupstarttime").val().trim();
		var snapupendtime = $("#snapupendtime").val().trim();
		var snapupprice = $("#snapupprice").val().trim();
		var snapupcertifiedprice = $("#snapupcertifiedprice").val().trim();
		var snapuplogisticsprice = $("#snapuplogisticsprice").val().trim();
		var snapupquantity = $("#snapupquantity").val().trim();

		var grouponstartquantity = $("#grouponstartquantity").val().trim();
		if (grouponstartquantity == '') {
			grouponstartquantity = $("#grouponstartquantity0").val().trim();
		}
		var grouponstarttime = $("#grouponstarttime").val().trim();
		var grouponendtime = $("#grouponendtime").val().trim();
		var grouponprice = $("#grouponprice").val().trim();
		var grouponcertifiedprice = $("#grouponcertifiedprice").val().trim();
		var grouponlogisticsprice = $("#grouponlogisticsprice").val().trim();
		var grouponquantity = $("#grouponquantity").val().trim();

		var crowfundingstartquantity = $("#crowfundingstartquantity").val()
				.trim();
		var crowfundingdepositrate = $("#crowfundingdepositrate").val().trim();
		var crowfundingstarttime = $("#crowfundingstarttime").val().trim();
		var crowfundingendtime = $("#crowfundingendtime").val().trim();
		var crowfundingprice = $("#crowfundingprice").val().trim();
		var crowfundingcertifiedprice = $("#crowfundingcertifiedprice").val()
				.trim();
		var crowfundinglogisticsprice = $("#crowfundinglogisticsprice").val()
				.trim();
		var crowfundingquantity = $("#crowfundingquantity").val().trim();

		var map = {};

		for (var i = 1; i <= propertyid; i++) {
			var str = "name" + i;
			var str1 = $("#" + str).val();
			var str2 = "value" + i;
			var str3 = $("#" + str2).val();
			alert(str1 + str3);
			map[str1] = str3;
		}
		var mapJson = JSON.stringify(map);

		if (issnapup == 1) {
			if (snapupstarttime == "") {
				$("#snapupstarttimewarn").text("不能为空");
				return false;
			} else {
				$("#snapupstarttimewarn").text("");
			}
			if (snapupendtime == "") {
				$("#snapupendtimewarn").text("不能为空");
				return false;
			} else {
				$("#snapupendtimewarn").text("");
			}
			if (snapupprice == "") {
				$("#snapuppricewarn").text("不能为空");
				return false;
			} else {
				$("#snapuppricewarn").text("");
			}
			if (snapupcertifiedprice == "") {
				$("#snapupcertifiedpricewarn").text("不能为空");
				return false;
			} else {
				$("#snapupcertifiedpricewarn").text("");
			}
			if (snapuplogisticsprice == "") {
				$("#snapuplogisticspricewarn").text("不能为空");
				return false;
			} else {
				$("#snapuplogisticspricewarn").text("");
			}
			if (snapupquantity == "") {
				$("#snapupquantitywarn").text("不能为空");
				return false;
			} else {
				$("#snapupquantitywarn").text("");
			}
			if (grouponstartquantity == "") {
				$("#grouponstartquantity0warn").text("不能为空");
				return false;
			} else {
				$("#grouponstartquantity0warn").text("");
			}
		} else if (isgroupon == 1) {
			if (grouponstarttime == "") {
				$("#grouponstarttimewarn").text("不能为空");
				return false;
			} else {
				$("#grouponstarttimewarn").text("");
			}
			if (grouponendtime == "") {
				$("#grouponendtimewarn").text("不能为空");
				return false;
			} else {
				$("#grouponendtimewarn").text("");
			}
			if (grouponprice == "") {
				$("#grouponpricewarn").text("不能为空");
				return false;
			} else {
				$("#grouponpricewarn").text("");
			}
			if (grouponcertifiedprice == "") {
				$("#grouponcertifiedpricewarn").text("不能为空");
				return false;
			} else {
				$("#grouponcertifiedpricewarn").text("");
			}
			if (grouponlogisticsprice == "") {
				$("#grouponlogisticspricewarn").text("不能为空");
				return false;
			} else {
				$("#grouponlogisticspricewarn").text("");
			}
			if (grouponquantity == "") {
				$("#grouponquantitywarn").text("不能为空");
				return false;
			} else {
				$("#grouponquantitywarn").text("");
			}
			if (grouponstartquantity == "") {
				$("#grouponstartquantitywarn").text("不能为空");
				return false;
			} else {
				$("#grouponstartquantitywarn").text("");
			}
		} else if (iscrowdfunding == 1) {
			if (crowfundingstarttime == "") {
				$("#crowfundingstarttimewarn").text("不能为空");
				return false;
			} else {
				$("#crowfundingstarttimewarn").text("");
			}
			if (crowfundingendtime == "") {
				$("#crowfundingendtimewarn").text("不能为空");
				return false;
			} else {
				$("#crowfundingendtimewarn").text("");
			}
			if (crowfundingprice == "") {
				$("#crowfundingpricewarn").text("不能为空");
				return false;
			} else {
				$("#crowfundingpricewarn").text("");
			}
			if (crowfundingcertifiedprice == "") {
				$("#crowfundingcertifiedpricewarn").text("不能为空");
				return false;
			} else {
				$("#crowfundingcertifiedpricewarn").text("");
			}
			if (crowfundinglogisticsprice == "") {
				$("#crowfundinglogisticspricewarn").text("不能为空");
				return false;
			} else {
				$("#crowfundinglogisticspricewarn").text("");
			}
			if (crowfundingquantity == "") {
				$("#crowfundingquantitywarn").text("不能为空");
				return false;
			} else {
				$("#crowfundingquantitywarn").text("");
			}
			if (crowfundingstartquantity == "") {
				$("#crowfundingstartquantitywarn").text("不能为空");
				return false;
			} else {
				$("#crowfundingstartquantitywarn").text("");
			}
			if (crowfundingdepositrate == "") {
				$("#crowfundingdepositratewarn").text("不能为空");
				return false;
			} else
				$("#crowfundingdepositratewarn").text("");
		}
		var proimg1 = $("#proimg").val();
		var inventoryquantity = $("#inventoryquantity").val().trim();
		// alert(inventoryquantity)
		$.post('../Product_release', {
			"product.productname" : proname,
			"product.producttype.producttypeid" : typeshow,
			"product.price" : price,
			"product.certifiedprice" : certifiedprice,
			"product.logisticsprice" : logisticsprice,
			"product.productpicture" : productpicture,
			"product.inventoryquantity" : inventoryquantity,
			"power" : power,
			"lampholder" : lampholder,
			"colortemp" : colortemp,
			"voltage" : voltage,
			"luminousflux" : luminousflux,
			"lightefficiency" : lightefficiency,
			"colorrendering" : colorrendering,
			"beamangle" : beamangle,
			"isemc" : isemc,
			"product.sendpoints" : sendpoints,
			"product.productdiscribe" : productdiscribe,
			"product.issale" : issale,
			"product.ishot" : ishot,
			"product.isnew" : isnew,
			"product.isrecommend" : isrecommend,
			"product.issnapup" : issnapup,
			"product.isgroupon" : isgroupon,
			"product.iscrowdfunding" : iscrowdfunding,
			"product.snapupstarttime" : snapupstarttime,
			"product.snapupendtime" : snapupendtime,
			"product.snapupprice" : snapupprice,
			"product.snapupcertifiedprice" : snapupcertifiedprice,
			"product.snapuplogisticsprice" : snapuplogisticsprice,
			"product.snapupquantity" : snapupquantity,
			"product.grouponstartquantity" : grouponstartquantity,
			"product.grouponstarttime" : grouponstarttime,
			"product.grouponendtime" : grouponendtime,
			"product.grouponprice" : grouponprice,
			"product.grouponcertifiedprice" : grouponcertifiedprice,
			"product.grouponlogisticsprice" : grouponlogisticsprice,
			"product.grouponquantity" : grouponquantity,
			"product.crowfundingstartquantity" : crowfundingstartquantity,
			"product.crowfundingdepositrate" : crowfundingdepositrate,
			"product.crowfundingstarttime" : crowfundingstarttime,
			"product.crowfundingendtime" : crowfundingendtime,
			"product.crowfundingprice" : crowfundingprice,
			"product.crowfundingcertifiedprice" : crowfundingcertifiedprice,
			"product.crowfundinglogisticsprice" : crowfundinglogisticsprice,
			"product.crowfundingquantity" : crowfundingquantity,
			"proImg" : proimg1,
			"map" : mapJson
		}, function(data) {
			if (data.state == "success") {
				alert("添加成功");
				window.location.reload();
			}
		});
	},
	getProductDetail : function(index, data) {
		viewModel.product.setRowSelect(index);
		var id = viewModel.product.getValue("productid");// 得到id
		var url = "productdetail.html?id=" + id;
		var winobj = window.open(url, "_blank");
		winobj.location.href = url;
	},
	modifyproduct : function(data, index) {
		viewModel.product.setRowSelect(index);
		id = viewModel.product.getValue("productid");
		var url = "modifyproduct.html?id=" + id;
		var winobj = window.open(url, "_blank");
		winobj.location.href = url;
	},
	deleteproduct : function(data, index) {
		viewModel.product.setRowSelect(index);
		var id = viewModel.product.getValue("productid");
		$.post("Product_delete", {
			"productid" : id
		}, function(data) {
			if (data.state == "success") {
				viewModel.product.removeRow(index);
			} else {
				alert("删除失败");
			}
		});
	}
}
app = u.createApp({
	el : 'body',
	model : viewModel
});
viewModel.product.createEmptyRow();
viewModel.product.setRowSelect(0);
$("li").delegate(".type", "click", function() {
	// alert("智信息给");
	var typeid = $(this).find("span").html();
	// alert(typeid);
	$.post("Product_getProductByType", {
		"typeid" : typeid
	}, function(data) {
		var list = data.list;
		var length = list.length;
		for (var i = 0; i < length; i++) {
			if (list[i].issnapup == '1')
				list[i].issnapup = "是";
			else
				list[i].issnapup = '否';

			if (list[i].isgroupon == "1")
				list[i].isgroupon = "是";
			else
				list[i].isgroupon = '否';

			if (list[i].iscrowdfunding == "1")
				list[i].iscrowdfunding = "是";
			else
				list[i].iscrowdfunding = '否';

			if (list[i].inventoryquantity == "1")
				list[i].inventoryquantity = "是";
			else
				list[i].inventoryquantity = '否';
		}
		if (length) {
			viewModel.product.setSimpleData(list);
		} else {
			viewModel.product.setSimpleData(list);
		}
	})
});
$("#protype").focus(function() {
	$("#protypewarn").html("");
});
$
		.post(
				"../Product_getTypeList",
				{},
				function(data) {
					var array = new Array();
					array = data.typelist;
					if (array == 'noLogin') {
						alert("您未登录，请先登录");
						return;
					}
					if (array != 'fail') {
						var type = $("#typeshow");
						var type1 = $("#menu");
						var length = array.length;
						var str = "";
						var str1 = "";
						for (var i = 0; i < length; i++) {
							str += "<option value=" + array[i].producttypeid
									+ " >" + array[i].producttypename
									+ "</option>";
							str1 += "<li><a href='#productenergybulbes'  tabindex='-1' data-toggle='tab' class='type'><span style='display:none'>"
									+ array[i].producttypeid
									+ "</span>"
									+ array[i].producttypename + "</a></li>"
						}
						type.append(str);
						type1.append(str1);
					}
				});
/*
 * $("#image").change(function(){
 * 
 * });
 */
$(".modal .save").click(function() {
	$(".modal").modal('hide');
})
/**
 * 点击取消
 */
$("#cancel").click(function() {
	document.getElementById("form").reset();
	$("input[type=radio]:checked").val("0");
	$("input[type=radio]:checked").attr("checked", false);
})
$("#cancel1").click(function() {
	// alert($("input[type=radio]:checked").val());
	document.getElementById("form1").reset();
	$("input[type=radio]:checked").val("0");
	$("input[type=radio]:checked").attr("checked", false);
})
$("#cancel2").click(function() {
	// alert($("input[type=radio]:checked").val());
	document.getElementById("form2").reset();
	$("input[type=radio]:checked").val("0");
	$("input[type=radio]:checked").attr("checked", false);
})

$("#issnapup0").click(function() {
	$("#isgroupon0").val("0");
	$("#iscrowdfunding0").val("0");
	if ($(this).is(':checked')) {
		$(this).val("1");
	} else
		$(this).val("0");
});
$("#isgroupon0").click(function() {
	$("#issnapup0").val("0");
	$("#iscrowdfunding0").val("0");
	if ($(this).is(':checked')) {
		$(this).val("1");
	} else
		$(this).val("0");
});

$("#iscrowdfunding0").click(function() {
	$("#isgroupon0").val("0");
	$("#issnapup0").val("0");
	if ($(this).is(':checked')) {
		$(this).val("1");
	} else
		$(this).val("0");
});

$("input[type=checkbox]").click(function() {
	var checkbox = $(this).val();
	if ("1" == checkbox) {
		$(this).attr("checked", false);
		$(this).val("0");
	} else {
		$(this).val("1");
	}
});
$(".num").blur(function() {
	var numval = $(this).val();
	if (isNaN(numval)) {
		$(this).val('');
		$(this).focus();
	} else {
		if (parseInt(numval) >= 32767) {
			$(this).val('');
			$(this).focus();
		}
		;
	}
})

// 选择文件成功则提交表单
function uploadImage() {
	// alert("执行");
	var fileName = $("#image").val();
	$("#filewarn").html("");
	$("#productimage").ajaxSubmit(
			{
				dataType : 'json',
				success : function(data) {
					if (data.filenames == "more") {
						$("#filewarn").html("最多上传5张图片");
					} else if (data.filenames == "fomarterror") {
						$("#filewarn").html("图片格式不正确");
					} else if (data.filenames == "fail") {
						$("#filewarn").html("上传失败");
					} else {
						$("#imagename").val(data.filenames);
						var imagename = data.filenames;
						var imageArray = imagename.split("|");
						var arraylength = imageArray.length;
						if (arraylength > 5)
							arraylength = 5;

						for (var i = 0; i < arraylength; i++) {
							$("#morepic").append(
									"<img src='" + imageArray[i]
											+ "' width='60px' height='40px'>");

						}
						alert("上传成功");
					}
				},
				error : function(data) {
					alert("上传失败");
				}
			});
}

function setamount() {
	var a = $("#customproduct").val();
	var type = $("#custom");
	propertyid++;
	var str = "";
	str += "<div id='d"
			+ propertyid
			+ "'>属性名称<input type='text' id='name"
			+ propertyid
			+ "'></input>"
			+ "属性值<input type='text' id='value"
			+ propertyid
			+ "'></input><button type='button' class='btn btn-danger btn-xs' id='"
			+ propertyid
			+ "' onClick='removeProperty(this)''>删除</button></div>";
	type.append(str);
}
function removeProperty(value) {
	$("#d" + value.id).remove();
	propertyid--;
}
function test() {
	// var map={};
	// var custom=$("#customproduct").val();
	//	
	// for(var i=0;i<custom;i++)
	// { var str="name"+i;
	// var str1=$("#"+str).val();
	// var str2="value"+i;
	// var str3=$("#"+str2).val();
	// alert(str1+ str3);
	// map[str1]=str3;
	// }
	// var mapJson=JSON.stringify(map);
	// alert(mapJson);
	var ue = UE.getEditor('productdiscribe');
	alert(ue.getContent());
	// // for(var prop in map){
	// // if(map.hasOwnProperty(prop)){
	// // alert('key is ' + prop +' and value is' + map[prop]);
	// }
	// }
}