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
function dnochange() {//当第一个下拉框的选项发生改变时调用该函数
	var dno = document.getElementById("dno").value; //获取第一级菜单的值
	sendReq("../ajaxDnoToDname?dno=" + dno); //发送参数到SERVLET
	//值得注意的是URL的servlet地址前面不加“/”并且为小写字母（试验的结论）
}
//发送请求
function sendReq(url) { //发送函数
	createXMLHttpRequest();
	XMLHttpReq.open("GET", url, true);
	XMLHttpReq.onreadystatechange = progessReq;//调用相关的XML接受函数
	XMLHttpReq.send(null);
}
//判断接收请求
function progessReq() {
	if (XMLHttpReq.readyState == 4) {
		if (XMLHttpReq.status == 200) {
			var xmlDoc = XMLHttpReq.responseXML; //获取返回的XML文档
			var s = xmlDoc.getElementsByTagName("depart");//获取XML节点
			var obj = document.getElementById("dnoError");
			var xValue = s[0].childNodes[0].firstChild.nodeValue;
			alert("as"+xValue);
			if(xValue=="true"){	//如果存在该学院则显示学院名称
				obj.innerHTML="该学院信息可用";
				obj.style.color="green";
				document.getElementById("department").value=xValue;//获取第二级菜单的对象
			}else {	//如果为空则提示错误
				obj.innerHTML="学院信息不存在";
				obj.style.color="red";
				obj.value=null;
			}
		} else {
			alert("请求异常" + XMLHttpReq.responseText);
		}
	}
}