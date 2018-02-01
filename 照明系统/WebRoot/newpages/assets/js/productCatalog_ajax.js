var pageSize = 10;//每一页显示的商品数量
var totalCount = 0;//总页数
var countPage = 5;//页面显示的页码数目,长度
var pageIndex;//当前页码
var pagemin = 1;//最小页数
var pagemax = 1;//最大页数

function init() {
	$.post("ProductCatalog_retreiveActivityProductsByPage.action?producttypeId=19", {
		"page.pageSize" : pageSize,
		"page.pageIndex" : 1,
		"page.totalCount":totalCount,
		"type" : 0
	}, function(data) {
		alert("init()");
		alert("data: " + data );
		alert("data.totalPage: " + data.totalPage);
		pageIndex = 1;
//		if (data.result == "success") {
//			totalPage = data.totalPage;
//			for (var i = 0; i < data.list.length; i++) {
//				var timestr = (data.list[i].nlasttime).substr(0, 10);
//				$(".news").append(
//						"<li><a href='cqdetail.html?cqid="
//								+ data.list[i].newsid + "'>"
//								+ data.list[i].newstitle + "（" + timestr + "）"
//								+ "</a></li>");
//			}
//		}
		if (totalCount > countPage)
			pagemax = countPage;
		else
			pagemax = totalCount;

		pageInfo();
	});

}
function pageInfo() {
	alert("pageInfo()");
	// $(".pagination")
	// .append(
	// "<li><a href='javascript:void(0)' aria-label='Previous'
	// onclick='Previous()'> <spanaria-hidden='true'>上一页</span></a></li>");
	// if (pagemin > 1) {
	// $(".pagination").append("<li><a>...</a></li>");
	// }
	//
	// for (var i = pagemin; i <= pagemax; i++) {
	// if (i == pageIndex) {
	// $(".pagination")
	// .append(
	// "<li class='active'><a href='javascript:void(0)'
	// onclick='choosePage(this.id)' id="
	// + i + ">" + i + "</a></li>");
	// } else {
	// $(".pagination").append(
	// "<li><a href='javascript:void(0)' onclick='choosePage(this.id)' id="
	// + i + ">" + i + "</a></li>");
	// }
	// }
	// if (pagemax < totalPage)
	// $(".pagination").append("<li><a>...</a></li>");
	// $(".pagination")
	// .append(
	// "<li><select id='selectpage' onchange='selectPage()'></select></li>");
	// for (var i = 0; i < totalPage; i++) {
	// $("#selectpage").append("<option>" + (i + 1) + "</option>");
	// $("#selectpage").val(pageIndex);
	// }
	// $(".pagination")
	// .append(
	// "<li><a href='javascript:void(0)' aria-label='Next' onclick='Next()'>
	// <spanaria-hidden='true'>下一页</span></a></li>");
	// $(".pagination").append(
	// "<li><a href='javascript:void(0)' onclick='Last()'>尾页</a></li>");
	// $(".pagination").append(
	// "<li>总共" + totalPage + "页&nbsp;&nbsp;&nbsp;&nbsp;当前第</li><li>"
	// + pageIndex + "页</li><li><a href='#'>返回顶部</a></li>");

}
function selectPage() {
	alert("selectPage()");
	var id = $("#selectpage").val();
	choosePage(id);
}
function Next() {
	alert("Next");
	pageIndex++;
	if (pageIndex <= totalCount) {
		if (pageIndex == pagemax) {
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
		$(".pagination").empty();
		$.post("../News_init", {
			"page.pageSize" : pageSize,
			"page.pageIndex" : pageIndex,
			"page.totalCount":totalCount,
			"type" : 1
		}, function(data) {
			$(".news").empty();
			if (data.result == "success") {
				totalCount = data.totalPage;
				for (var i = 0; i < data.list.length; i++) {
					var timestr = (data.list[i].nlasttime).substr(0, 10);
					$(".news").append(
							"<li><a href='cqdetail.html?cqid="
									+ data.list[i].newsid + "'>"
									+ data.list[i].newstitle + "（" + timestr
									+ "）" + "</a></li>");
				}
			}
			pageInfo();
		});
	} else {
		pageIndex--;
	}
}
function Previous() {
	alert("Previous");
	pageIndex--;
	if (pageIndex > 0) {
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
		$(".pagination").empty();
		$.post("../News_init", {
			"page.pageSize" : pageSize,
			"page.pageIndex" : pageIndex,
			"type" : 0
		}, function(data) {
			$(".news").empty();
			if (data.result == "success") {
				totalCount = data.totalPage;
				for (var i = 0; i < data.list.length; i++) {
					var timestr = (data.list[i].nlasttime).substr(0, 10);
					$(".news").append(
							"<li><a href='cqdetail.html?cqid="
									+ data.list[i].newsid + "'>"
									+ data.list[i].newstitle + "（" + timestr
									+ "）" + "</a></li>");
				}
			}
			pageInfo();
		});
	} else {
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
		$(".pagination").empty();
		$.post("../News_init", {
			"page.pageSize" : pageSize,
			"page.pageIndex" : pageIndex,
			"page.totalCount":totalCount,
			"type" : 0
		}, function(data) {
			$(".news").empty();
			if (data.result == "success") {
				totalCount = data.totalPage;
				for (var i = 0; i < data.list.length; i++) {
					var timestr = (data.list[i].nlasttime).substr(0, 10);
					$(".news").append(
							"<li><a href='cqdetail.html?cqid="
									+ data.list[i].newsid + "'>"
									+ data.list[i].newstitle + "（" + timestr
									+ "）" + "</a></li>");
				}
			}
			pageInfo();
		});
	}
}
function Last() {
	alert("Last");
	choosePage(totalCount);
}