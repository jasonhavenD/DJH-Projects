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

function stublur() {//当第一个下拉框的选项发生改变时调用该函数
	
	
	var ptn = document.getElementById("mno").value; //获取第一级菜单的值
	
	sendRequest("../mno_uniqueness?mno=" + ptn); //发送参数到SERVLET
	//值得注意的是URL的servlet地址前面不加“/”并且为小写字母（试验的结论）
}
//发送请求
function sendRequest(url) { //发送函数
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
			var s = xmlDoc.getElementsByTagName("major");//获取XML节点
			var obj = document.getElementById("mnoError");
			var xValue = s[0].childNodes[0].firstChild.nodeValue;
			
			if (xValue == "true") {//如果不为空就置空
				
				obj.innerHTML="该专业代码已存在";
				$('#mno').css('border','1px solid red');
				//document.getElementById("patentNumberError").setAttribute("style","font-size:12px;color:red;");
				documnet.getElementById("mnoError").style.color="red";
			}else{
				if(document.getElementById("mno").value.length==0)
				{
					obj.innerHTML="专业代码不可为空";
					obj.style.color="red";
				}
				else
				{
				obj.innerHTML="该专业代码可用";
				$('#mno').css('border','1px solid green');
				//document.getElementById("patentNumberError").setAttribute("style","font-size:12px;color:green;");
				obj.style.color="green";				}
				
			}
		} else {
			alert("请求异常" + XMLHttpReq.responseText);
		}
}
	}