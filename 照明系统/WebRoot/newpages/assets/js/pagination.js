var pageSize = 10;// 每一页显示的商品数量
var totalCount = 5;// 总页数
var countPage = 5;// 页面显示的页码数目,长度
var pageIndex = 1;// 当前页码
var pagemin = 1;// 最小页数
var pagemax = 5;// 最大页数

function init() {
	$
			.post(
					"ProductCatalog_retreiveActivityProductsByPage.action?producttypeId=19",
					{
						"page.pageSize" : pageSize,
						"page.pageIndex" : 1,
						"page.totalCount" : totalCount,
						"type" : 0
					}, function(data) {
						alert("init()");
						pagedex = 1;
						if (data == null || data == "") {
							alert("data==null");
							return;
						}
						totalPage = data.totalPage;
						if (totalCount > countPage)
							pagemax = countPage;
						else
							pagemax = totalCount;
						pageInfo(data);
					});
}

function pageInfo(data) {
	alert("pageInfo()");
	var spp1 = $(data.secondProductPictures1);
	var spp2 = $(data.secondProductPictures2);
	var spp3 = $(data.secondProductPictures3);
	var productid;// 产品id
	var picturetitle;// 产品名称标题
	var introduction;// 产品介绍
	var picturepath;
	var discount;// 特价,double类型
	var closingday;// 距离结束日
	var htmlStr = "";
	var i;
	for (i = 0; i < spp1.length; i++) {
		var map = spp1[i];
		productid = map.productId;
		picturetitle = map.picturetitle;
		introduction = map.introduction;
		picturepath = map.picturepath;
		discount = parseFloat(map.discount);
		closingday = map.closingday;
		htmlStr += "<li class=\"col-lg-3 col-sm-3\">"
				+ "\n<div class=\"shop-item\">\n<div class=\"thumbnail\">\n<!-- product image(s) -->\n"
				+ "<a class=\"shop-item-image\" href=\"ProductShowAction?productid="
				+ productid
				+ "\">\n"
				+ "<img class=\"img-responsive\" src=\"."
				+ picturepath
				+ "\" alt=\"shop first image\" />\n"
				+ "<img class=\"img-responsive\" 	src=\"."
				+ picturepath
				+ "\" alt=\"shop hover image\" />\n</a>\n<!-- /product image(s) -->\n"
				+ "<!-- countdown -->\n<div class=\"shop-item-counter\">\n"
				+ "<div class=\"countdown\" data-from=\""
				+ closingday
				+ "\" data-labels=\"年,月,周,天,时,分,秒\">\n"
				+ "<!-- Example Date From: December 31, 2018 15:03:26 -->\n"
				+ "</div>\n</div>\n<!-- /countdown -->\n"
				+ "<!-- product more info -->\n<div class=\"shop-item-info\">\n"
				+ "<span class=\"label label-success\">新品</span>\n<span	class=\"label label-danger\">热卖</span>\n"
				+ "</div>\n<!-- /product more info -->\n</div>\n"
				+ "<div class=\"shop-item-summary text-center\">\n"
				+ "<a href=\"ProductShowAction?productid="
				+ productid
				+ "\"><h2>"
				+ picturetitle
				+ "</h2></a>\n"
				+ "<div class=\"size-13\">"
				+ introduction
				+ "</div>\n"
				+ "<!-- price -->\n<div class=\"shop-item-price\">"
				+ discount
				+ "</div>\n<!-- /price -->\n</div>\n"
				+ "<!-- buttons -->\n<div class=\"shop-item-buttons text-center\">\n"
				+ "<button type=\"input\" class=\"ss\" onclick=\"addOneToCart("
				+ productid
				+ ", 1)\">加入购物车</button>\n"
				+ "</div>\n<!-- /buttons -->\n</div>\n</li>\n";
	}
	for (i = 0; i < spp2.length; i++) {
		var map = spp2[i];
		productid = map.productId;
		picturetitle = map.picturetitle;
		introduction = map.introduction;
		picturepath = map.picturepath;
		discount = parseFloat(map.discount);
		closingday = map.closingday;
		htmlStr += "<li class=\"col-lg-3 col-sm-3\">"
				+ "\n<div class=\"shop-item\">\n<div class=\"thumbnail\">\n<!-- product image(s) -->\n"
				+ "<a class=\"shop-item-image\" href=\"ProductShowAction?productid="
				+ productid
				+ "\">\n"
				+ "<img class=\"img-responsive\" src=\"."
				+ picturepath
				+ "\" alt=\"shop first image\" />\n"
				+ "<img class=\"img-responsive\" 	src=\"."
				+ picturepath
				+ "\" alt=\"shop hover image\" />\n</a>\n<!-- /product image(s) -->\n"
				+ "<!-- countdown -->\n<div class=\"shop-item-counter\">\n"
				+ "<div class=\"countdown\" data-from=\""
				+ closingday
				+ "\" data-labels=\"年,月,周,天,时,分,秒\">\n"
				+ "<!-- Example Date From: December 31, 2018 15:03:26 -->\n"
				+ "</div>\n</div>\n<!-- /countdown -->\n"
				+ "<!-- product more info -->\n<div class=\"shop-item-info\">\n"
				+ "<span class=\"label label-success\">新品</span>\n<span	class=\"label label-danger\">热卖</span>\n"
				+ "</div>\n<!-- /product more info -->\n</div>\n"
				+ "<div class=\"shop-item-summary text-center\">\n"
				+ "<a href=\"ProductShowAction?productid="
				+ productid
				+ "\"><h2>"
				+ picturetitle
				+ "</h2></a>\n"
				+ "<div class=\"size-13\">"
				+ introduction
				+ "</div>\n"
				+ "<!-- price -->\n<div class=\"shop-item-price\">"
				+ discount
				+ "</div>\n<!-- /price -->\n</div>\n"
				+ "<!-- buttons -->\n<div class=\"shop-item-buttons text-center\">\n"
				+ "<button type=\"input\" class=\"ss\" onclick=\"addOneToCart("
				+ productid
				+ ", 1)\">加入购物车</button>\n"
				+ "</div>\n<!-- /buttons -->\n</div>\n</li>\n";
	}
	for (i = 0; i < spp3.length; i++) {
		var map = spp3[i];
		productid = map.productId;
		picturetitle = map.picturetitle;
		introduction = map.introduction;
		picturepath = map.picturepath;
		discount = parseFloat(map.discount);
		closingday = map.closingday;
		htmlStr += "<li class=\"col-lg-3 col-sm-3\">"
				+ "\n<div class=\"shop-item\">\n<div class=\"thumbnail\">\n<!-- product image(s) -->\n"
				+ "<a class=\"shop-item-image\" href=\"ProductShowAction?productid="
				+ productid
				+ "\">\n"
				+ "<img class=\"img-responsive\" src=\"."
				+ picturepath
				+ "\" alt=\"shop first image\" />\n"
				+ "<img class=\"img-responsive\" 	src=\"."
				+ picturepath
				+ "\" alt=\"shop hover image\" />\n</a>\n<!-- /product image(s) -->\n"
				+ "<!-- countdown -->\n<div class=\"shop-item-counter\">\n"
				+ "<div class=\"countdown\" data-from=\""
				+ closingday
				+ "\" data-labels=\"年,月,周,天,时,分,秒\">\n"
				+ "<!-- Example Date From: December 31, 2018 15:03:26 -->\n"
				+ "</div>\n</div>\n<!-- /countdown -->\n"
				+ "<!-- product more info -->\n<div class=\"shop-item-info\">\n"
				+ "<span class=\"label label-success\">新品</span>\n<span	class=\"label label-danger\">热卖</span>\n"
				+ "</div>\n<!-- /product more info -->\n</div>\n"
				+ "<div class=\"shop-item-summary text-center\">\n"
				+ "<a href=\"ProductShowAction?productid="
				+ productid
				+ "\"><h2>"
				+ picturetitle
				+ "</h2></a>\n"
				+ "<div class=\"size-13\">"
				+ introduction
				+ "</div>\n"
				+ "<!-- price -->\n<div class=\"shop-item-price\">"
				+ discount
				+ "</div>\n<!-- /price -->\n</div>\n"
				+ "<!-- buttons -->\n<div class=\"shop-item-buttons text-center\">\n"
				+ "<button type=\"input\" class=\"ss\" onclick=\"addOneToCart("
				+ productid
				+ ", 1)\">加入购物车</button>\n"
				+ "</div>\n<!-- /buttons -->\n</div>\n</li>\n";
	}
	document.getElementById("secondProductPictures1").innerHTML = htmlStr; // 添加到ul
}

function selectPage(element) {
	alert("selectPage()");
	var id = Number(element.innerHTML);
	alert(id);
	choosePage(id);
}

function Next() {
	alert("Next");
	pageIndex++;
	if (pageIndex <= totalCount) {
		alert("111");
		if (pageIndex == pagemax) {
			alert("222");
			pagemin = pageIndex - 2;
			pagemax = Number(pageIndex) + 2;
			if (pagemin <= 0) {
				alert("333");
				pagemin = 1;
				if (pagemin + countPage - 1 < totalCount) {
					alert("444");
					pagemax = pagemin + countPage - 1;
				} else
					pagemax = totalCount;
			}
			if (pagemax > totalCount) {
				alert("555");
				pagemax = totalCount;
				if (pagemax - countPage + 1 <= 0)
					pagemin = 1;
				else
					pagemin = pagemax - countPage + 1;
			}
		}
		$
				.post(
						"ProductCatalog_retreiveActivityProductsByPage.action?producttypeId=19",
						{
							"page.pageSize" : pageSize,
							"page.pageIndex" : pageIndex,
							"page.totalCount" : totalCount,
							"type" : 0
						}, function(data) {
							alert("pageSize=" + pageSize + "pageIndex"
									+ pageIndex + "totalCount=" + totalCount);
							if (data == null || data == "") {
								alert("data==null");
								return;
							}
							totalPage = data.totalPage;
							if (totalCount > countPage)
								pagemax = countPage;
							else
								pagemax = totalCount;
							pageInfo(data);
						});
	} else {
		alert("else" + "pageIndex=" + pageIndex);
		pageIndex--;
	}
}

function Previous() {
	alert("Previous");
	pageIndex--;
	if (pageIndex > 0) {
		alert("11");
		pagemin = pageIndex - 2;
		pagemax = Number(pageIndex) + 2;
		if (pagemin <= 0) {
			alert("22");
			pagemin = 1;
			if (pagemin + countPage - 1 < totalCount)
				pagemax = pagemin + countPage - 1;
			else
				pagemax = totalCount;
		}
		if (pagemax > totalCount) {
			alert("33");
			pagemax = totalCount;
			if (pagemax - countPage + 1 <= 0)
				pagemin = 1;
			else
				pagemin = pagemax - countPage + 1;
		}
		$
				.post(
						"ProductCatalog_retreiveActivityProductsByPage.action?producttypeId=19",
						{
							"page.pageSize" : pageSize,
							"page.pageIndex" : pageIndex,
							"type" : 0
						}, function(data) {
							alert("pageSize=" + pageSize + "pageIndex"
									+ pageIndex + "totalCount=" + totalCount);
							if (data == null || data == "") {
								alert("data==null");
								return;
							}
							totalPage = data.totalPage;
							if (totalCount > countPage)
								pagemax = countPage;
							else
								pagemax = totalCount;
							pageInfo(data);
						});
	} else {
		alert("else" + "pageIndex=" + pageIndex);
		pageIndex++;
	}
}

function choosePage(source) {
	alert("choosePage");
	if ($($("#" + source).parent()).attr("class") != "active") {
		pageIndex = source;
		if (pageIndex >= pagemax || pageIndex <= pagemin) {
			pagemin = pageIndex - 2;
			pagemax = Number(pageIndex) + 2;
			if (pagemin <= 0) {
				pagemin = 1;
				if (pagemin + countPage - 1 < totalCount)
					pagemax = pagemin + countPage - 1;
				else
					pagemax = totalCount;

			}
			if (pagemax > totalCount) {
				pagemax = totalCount;
				if (pagemax - countPage + 1 <= 0)
					pagemin = 1;
				else
					pagemin = pagemax - countPage + 1;
			}
		}
		$
				.post(
						"ProductCatalog_retreiveActivityProductsByPage.action?producttypeId=19",
						{
							"page.pageSize" : pageSize,
							"page.pageIndex" : pageIndex,
							"page.totalCount" : totalCount,
							"type" : 0
						}, function(data) {
							alert("pageSize=" + pageSize + "pageIndex"
									+ pageIndex + "totalCount=" + totalCount);
							if (data == null || data == "") {
								alert("data==null");
								return;
							}
							totalPage = data.totalPage;
							if (totalCount > countPage)
								pagemax = countPage;
							else
								pagemax = totalCount;
							pageInfo(data);
						});
	}

}

function Last() {
	alert("Last");
	choosePage(totalCount);
}
