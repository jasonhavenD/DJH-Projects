
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
//onblur事件
function isbnblur() {
	
	var ptn = document.getElementById("isbn").value; //获取第一级菜单的值
	
	//前台值已接收
	sendRequests("../Tisbn_uniqueness?isbn=" + ptn); //发送参数到SERVLET 
	//值得注意的是URL的servlet地址前面不加“/”并且为小写字母（试验的结论）
}
//发送请求
function sendRequests(url) { //发送函数
	createXMLHttpRequest();
	XMLHttpReq.open("GET", url, true);
	XMLHttpReq.onreadystatechange = progessRequest;//调用相关的XML接受函数
	XMLHttpReq.send(null);
}

//判断接收请求
function progessRequest() {
	if (XMLHttpReq.readyState == 4) {
		if (XMLHttpReq.status == 200) {
			var xmlDoc = XMLHttpReq.responseXML; //获取返回的XML文档
			var s = xmlDoc.getElementsByTagName("teachBook");//获取XML节点
			var obj = document.getElementById("is");
			var xValue = s[0].childNodes[0].firstChild.nodeValue;
			var xText = s[0].childNodes[1].firstChild.nodeValue;		
			if (xValue == "true") {//如果不为空就置空
				obj.style.color="red";
				obj.innerHTML="该书号已存在";
				document.getElementById("isbn").focus();
				
				//document.getElementById("patentNumberError").setAttribute("style","font-size:12px;color:red;");
				
			}else{
				
				if(document.getElementById("isbn").value.length==0)
				{
					obj.style.color="red";
					obj.innerHTML="书号不可为空";
					document.getElementById("isbn").focus();
					
				}
				else if(xText == "true")
				{
					obj.style.color="green";
				obj.innerHTML="该书号可用";			
				}else{
					obj.style.color="red";
					obj.innerHTML="请输入规范格式";	
					document.getElementById("isbn").focus();
				}
				
			}
		} else {
			alert("请求异常" + XMLHttpReq.responseText);
		}
}
	}