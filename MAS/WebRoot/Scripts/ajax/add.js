var XMLHttpReq;
var completeDiv;
var inputField;
var completeTable;
var completeBody;
//创建XMLHttpRequest对象
function createXMLHttpRequest1() {
	var o;
	if (window.XMLHttpRequest) { //Mozilla 浏览器   
		o = new XMLHttpRequest();
	} else if (window.ActiveXObject) { // IE浏览器   
		try {
			o = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				o = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
			}
		}
	}
	return o;
}
function findNames(userId) {
	inputField = document.getElementById("names");
	completeTable = document.getElementById("complete_table");
	completeDiv = document.getElementById("popup");
	completeBody = document.getElementById("complete_body");
	if (inputField.value.length > 0) {
		var o = createXMLHttpRequest1();		
		var value = inputField.value;
		value = encodeURI(encodeURI(value));
		var url = "autoSearch.action?role=teacher&userId=" + userId
				+ "&idname=" + value;
		//此处escape函数可以去掉，escape是采用ISO Latin字符集对指定的字符串进行编码。 
		o.open("GET", url, true);
		o.onreadystatechange = function() {			
			if (o.readyState == 4) { // 判断对象状态  
				if (o.status == 200) { // 信息已经成功返回，开始处理信息 
					setNames(o.responseXML.getElementsByTagName("ids"),
							o.responseXML.getElementsByTagName("names"));
				} else { //页面不正常  
					window.alert("您所请求的页面有异常。");
				}
			}
		};//指定响应函数   
		o.send(null); // 发送请求   
	} else {
		clearNames();
	}
}

// 处理返回匹配信息函数  
function processMatchResponse() {
	if (XMLHttpReq.readyState == 4) { // 判断对象状态  
		if (XMLHttpReq.status == 200) { // 信息已经成功返回，开始处理信息   
			alert("XMLHttpReq.responseText"); //输出看是否有乱码===============  
			setNames(XMLHttpReq.responseXML.getElementsByTagName("res"));
		} else { //页面不正常
			window.alert("您所请求的页面有异常。");
		}
	}
}
var size;
//生成与输入内容匹配行  
function setNames(ids, names) {
	clearNames();
	size = ids.length;
	setOffsets();
	var row, cell, cell2;
	if (size >= 0) {
		row = document.createElement("tr");
		cell = document.createElement("th");
		cell2 = document.createElement("th");
		var width = inputField.offsetWidth;
		if (width < 180) {
			cell.setAttribute("width", "90px");
			cell2.setAttribute("width", "90px");
		} else {
			cell.setAttribute("width", width / 2 - 2 + "px");
			cell2.setAttribute("width", width / 2 - 2 + "px");
		}
		cell.innerHTML = "教工号";
		cell2.innerHTML = "姓名";
		row.appendChild(cell);
		row.appendChild(cell2);
		completeBody.appendChild(row);
		if (size == 0) {
			row = document.createElement("tr");
			cell = document.createElement("td");
			row.onmouseover = function() {
				this.style.cursor = 'default';
			};
			cell.innerHTML = "没有搜索结果~";
			cell.setAttribute("colspan", '2');
			cell.style.color = "red";
			row.appendChild(cell);
			completeBody.appendChild(row);
		}
	}
	for ( var i = 0; i < size; i++) {
		var nextNode = ids[i].firstChild.data;
		var nextNode2 = names[i].firstChild.data;
		row = document.createElement("tr");
		cell = document.createElement("td");
		cell2 = document.createElement("td");
		row.onmouseover = function() {
			this.style.cursor = 'default';
		};
		row.onclick = function() {
			completeField(this);
		};
		nextNode = nextNode.replace("$1",
				"<span style='display:inline;color:red;'>").replace("$2",
				"</span>");
		nextNode2 = nextNode2.replace("$1",
				"<span style='display:inline;color:red;'>").replace("$2",
				"</span>");
		cell.innerHTML = nextNode;
		cell2.innerHTML = nextNode2;
		row.appendChild(cell);
		row.appendChild(cell2);
		completeBody.appendChild(row);
	}
}

//设置显示位置
function setOffsets() {
	gettable(inputField);
}
//取绝对位置  
function getAbsPosition(obj) {
	var r = {
		left : obj.offsetLeft,
		top : obj.offsetTop
	};
	r.left = obj.offsetLeft;
	r.top = obj.offsetTop;
	if (obj.offsetParent) {
		var tmp = getAbsPosition(obj.offsetParent);
		r.left += tmp.left;
		r.top += tmp.top;
	}
	return r;
}
//为提示定位  
function gettable(inputField) {
	var pos = getAbsPosition(inputField);
	pos.top += inputField.offsetHeight;
	completeDiv.style.top = pos.top + "px";

	var width = inputField.offsetWidth;
	if (width < 180)
		completeDiv.style.left = (pos.left - (180 - width) / 2) + "px";
	else
		completeDiv.style.left = pos.left + "px";
	if (size > 10)
		completeDiv.style.height = "231px";
	else
		completeDiv.style.height = ((size + 1) * 24) + 1 + "px";
	if (size == 0)
		completeDiv.style.height = "24px";
	if (size >= 0) {
		completeDiv.style.visibility = '';
	}
}

//计算显示位置  
function calculateOffset(field, attr) {
	var offset = 0;
	while (field) {
		offset += field[attr];
		fieldfield = field.offsetParent;
	}
	return offset;
}

//填写输入框  
function completeField(row) {
	inputField.value = row.firstChild.innerText;
	clearNames();
}

//清除自动完成行  
function clearNames() {
	var ind = completeBody.childNodes.length;
	for ( var i = ind - 1; i >= 0; i--) {
		completeBody.removeChild(completeBody.childNodes[i]);
	}
	completeDiv.style.visibility = 'hidden';
}

function showPname(obj, pname, flag) {
	var tip = obj.childNodes[3];
	var pos = getAbsPosition(obj);
	if (flag) {
		if (obj.childNodes[1].scrollWidth > obj.childNodes[1].offsetWidth) {
			tip.style.display = 'block';
			tip.style.top = pos.top - tip.offsetHeight + "px";
		}
	} else {
		tip.style.display = 'none';
	}
}