//创建和初始化地图函数：
function initMap() {
	createMap();//创建地图
	setMapEvent();//设置地图事件
	addMapControl();//向地图添加控件
	addMapOverlay();//向地图添加覆盖物
}
function createMap() {
	map = new BMap.Map("map");
	map.centerAndZoom(new BMap.Point(110.192364, 30.683847), 6);
}
function setMapEvent() {
	map.enableScrollWheelZoom();
	map.enableKeyboard();
	map.enableDragging();
	map.enableDoubleClickZoom()
}
function addClickHandler(target, window) {
	target.addEventListener("click", function() {
		target.openInfoWindow(window);
	});
}
function addMapOverlay() {
	var markers = [ {
		content : "",
		title : "厦门光服科技有限公司",
		imageOffset : {
			width : 0,
			height : -21
		},
		position : {
			lat : 24.683847,
			lng : 118.192364
		}
	}, {
		content : "",
		title : "四川物流中心",
		imageOffset : {
			width : -46,
			height : -21
		},
		position : {
			lat : 30.653467,
			lng : 104.103628
		}
	}, {
		content : "",
		title : "山东物流中心",
		imageOffset : {
			width : -46,
			height : -21
		},
		position : {
			lat : 36.677908,
			lng : 117.038078
		}
	}, {
		content : "",
		title : "辽宁物流中心",
		imageOffset : {
			width : -46,
			height : -21
		},
		position : {
			lat : 41.810989,
			lng : 123.449823
		}
	}, {
		content : "",
		title : "湖北物流中心",
		imageOffset : {
			width : -46,
			height : -21
		},
		position : {
			lat : 30.60959,
			lng : 114.456132
		}
	}, {
		content : "",
		title : "西安认证经销商",
		imageOffset : {
			width : -23,
			height : -46
		},
		position : {
			lat : 34.345996,
			lng : 108.949663
		}
	}, {
		content : "",
		title : "长沙认证经销商",
		imageOffset : {
			width : -23,
			height : -46
		},
		position : {
			lat : 28.240968,
			lng : 112.94935
		}
	},

	];
	for (var index = 0; index < markers.length; index++) {
		var point = new BMap.Point(markers[index].position.lng,
				markers[index].position.lat);
		var marker = new BMap.Marker(
				point,
				{
					icon : new BMap.Icon(
							"http://api.map.baidu.com/lbsapi/createmap/images/icon.png",
							new BMap.Size(20, 25), {
								imageOffset : new BMap.Size(
										markers[index].imageOffset.width,
										markers[index].imageOffset.height)
							})
				});
		var label = new BMap.Label(markers[index].title, {
			offset : new BMap.Size(25, 5)
		});
		var opts = {
			width : 200,
			title : markers[index].title,
			enableMessage : false
		};
		var infoWindow = new BMap.InfoWindow(markers[index].content, opts);
		marker.setLabel(label);
		addClickHandler(marker, infoWindow);
		map.addOverlay(marker);
	}
	;
}
//向地图添加控件
function addMapControl() {
	var scaleControl = new BMap.ScaleControl({
		anchor : BMAP_ANCHOR_BOTTOM_LEFT
	});
	scaleControl.setUnit(BMAP_UNIT_IMPERIAL);
	map.addControl(scaleControl);
	var navControl = new BMap.NavigationControl({
		anchor : BMAP_ANCHOR_TOP_LEFT,
		type : BMAP_NAVIGATION_CONTROL_LARGE
	});
	map.addControl(navControl);
	var overviewControl = new BMap.OverviewMapControl({
		anchor : BMAP_ANCHOR_BOTTOM_RIGHT,
		isOpen : true
	});
	map.addControl(overviewControl);
}