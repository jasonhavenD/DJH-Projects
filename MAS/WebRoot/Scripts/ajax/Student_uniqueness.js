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
function stuTblur() {//当第一个下拉框的选项发生改变时调用该函数
	var stu = document.getElementById("stuNumber").value; //获取第一级菜单的值
	sendRequest("../Student_uniqueness?stuNumber=" + stu); //发送参数到SERVLET
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
			var students = xmlDoc.getElementsByTagName("student");//获取XML节点				
			var obj = document.getElementById("stuNumberError");			
			if((typeof (students[0]))!="undefined"){	//如果不为空则显示教师姓名
				obj.innerHTML="学生信息可用";
				/*$('#tno').css('border','1px solid green');*/
				obj.style.color="green";
				var xValue = students[0].childNodes[0].firstChild.nodeValue;
				
				document.getElementById("stuName").value=xValue;//获取第二级菜单的对象
			}else {	//如果为空则提示错误
				obj.innerHTML="学生信息不存在";
				/*$('#teacher.tno').css('border','1px solid red');*/
				obj.style.color="red";
				document.getElementById("stuName").value=null;
			}
		} else {
			alert("请求异常" + XMLHttpReq.responseText);
		}
}
	}