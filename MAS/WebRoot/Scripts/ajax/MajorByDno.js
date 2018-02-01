//创建连接，判断浏览器
var http_request = false;
function createXMLHttpRequest() {
	if (window.XMLHttpRequest) {
		XMLHttpReq = new XMLHttpRequest(); //创建对象对应不同的浏览器
	} else if (window.ActiveXObject) {
		try {
			XMLHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
			}
		}
	}
}
//onchange事件
//保存检查
function collchange() {//当第一个下拉框的选项发生改变时调用该函数
	var colls = document.getElementById("coll").value; //获取第一级菜单的值
	sendRequest("../ajaxtest?coll=" + colls); //发送参数到SERVLET
	//值得注意的是URL的servlet地址前面不加“/”并且为小写字母（试验的结论）
}
//发送请求
function sendRequest(url) { //发送函数
	createXMLHttpRequest();
	XMLHttpReq.open("GET", url, true);
	XMLHttpReq.onreadystatechange = progessRequestwy;//调用相关的XML接受函数
	XMLHttpReq.send(null);
}
//判断接收请求
function progessRequestwy() {
	if (XMLHttpReq.readyState == 4) {
		if (XMLHttpReq.status == 200) {
			var xmlDoc = XMLHttpReq.responseXML; //获取返回的XML文档
			var majors = xmlDoc.getElementsByTagName("major");//获取XML节点
			var obj = document.getElementById("major");//获取第二级菜单的对象
			
			if (obj != null) {//如果不为空就置空
				obj.options.length = 0;
			}
			
			for ( var i = 0; i < majors.length; i++) {//用循环给select中加值
				var xValue = majors[i].childNodes[0].firstChild.nodeValue;
				var xText = majors[i].childNodes[1].firstChild.nodeValue;
				var option = new Option(xValue,xText);
				try {
					obj.add(option);
				} catch (e) {
				}
			}
			if(document.getElementById("coll").value=="")
				{
				var xValue = "全部专业";
				var xText = "";
				var option = new Option(xValue,xText);
				try {
					obj.add(option);
				} catch (e) {
				}		
				}
			
		} else {
			alert("请求异常" + XMLHttpReq.responseText);
		}
	}
}