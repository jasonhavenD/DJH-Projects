//function productTypes() {
//	// alert("???");
//	var product = {
//		type : "post",
//		url : "${pagecontext.request.contextpath}/ProductTypes_getAllL2",
//		data : {},
//		async : true,
//		success : function(data) {
//			for ( var key in data) {
//				// alert(key);
//				var i = 1;
//				$("#type1").append(
//						"<li class='dropdown'><a class='dropdown-toggle' href='#'>"
//								+ "<i class='et-browser'></i>" + key
//								+ "</a><ul id='" + key
//								+ "' class='dropdown-menu'></ul></li>");
//
//				for (var j = 0; j < data[key].length; j++) {
//					// alert("L2: " + data[key][i]);
//					$("#" + key + "").append(
//							"<li><a href='2.html'>" + data[key][j]
//									+ "</a></li>");
//				}
//			}
//		},
//		dataType : "json",
//	};
//
//	$.ajax(product);
//
//	/*
//	 * $.post( "./ProductTypes_getAllL2", {}, function(data) { alert("ajax");
//	 * alert("data: " + data);
//	 * 
//	 * for (var key in data) { alert("L1: " + key);
//	 * 
//	 * //alert("L1: " + data[key]);
//	 * 
//	 * for(var i=0; i<data[key].length; i++){ //alert("L2: " + data[key][i]);
//	 *  }
//	 *  } });
//	 */
//}

function productTypes() {
	//alert("in productTypes of js");
	var product = {
		type : "post",
		url : "${pagecontext.request.contextpath}/ProductTypes_getAllL2New",
		data : {},
		async : true,
		success : function(data) {
			for ( var keyL1 in data) {
				//alert(keyL1);
				var i = 1;
				$("#type1").append(
						"<li class='dropdown'><a class='dropdown-toggle' href='#'>"
								+ "<i class='et-browser'></i>" + keyL1
								+ "</a><ul id='" + keyL1
								+ "' class='dropdown-menu'></ul></li>");
				for ( var keyL2 in data[keyL1]) {
					//alert(keyL2);
					var valueL2 = data[keyL1][keyL2];
					//alert(valueL2);
					$("#" + keyL1 + "").append(
					"<li><a href='" + "ProductCatalog_retreiveAllByProdtypeId.action?producttypeId=" + keyL2 + "'>" + valueL2
							+ "</a></li>");
				}
//				Iterator iterKeyL2 = data[key].keySet().iterator();
//				while(iterKeyL2.hasNext()) {
//					Object keyL2 = iterKeyL2.next();
//					alert(keyL2);
//					var i = 1;
//				}
				
//				for (var j = 0; j < data[key].length; j++) {
//					alert("L2: " + data[key][i].producttypename);
//					$("#" + key + "").append(
//							"<li><a href='2.html'>" + data[key][j].producttypename
//									+ "</a></li>");
//				}
			}
		},
		dataType : "json",
	};

	$.ajax(product);
}