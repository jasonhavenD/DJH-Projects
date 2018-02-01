<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>创新创业项目成员信息修改</title>

		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/admin-all.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/other.css" />
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/jquery-1.7.2.js">
</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/jquery-ui-1.8.22.custom.min.js">
</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/textarea.js">
</script>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />

		<script type="text/javascript">
//日历插件
$(function() {
	$(".datepicker").datepicker();

	var _this = $('.list').find('thead');
	$('.tby').hide();
	//折叠
	_this.click(function() {
		var i = $(this).find('i');
		if (i.attr('class') == 'tip-down') {
			i.attr('class', 'tip-up')
		} else {
			i.attr('class', 'tip-down')
		}
		$(this).parent().find('tbody').toggle();
	})

})
$(document).ready(function() {
	$("#mytable tr:even td").css("background", "#fff");
	$("#mytable tr:even td").attr("bg", "#fff");
	$("#mytable tr:odd td").attr("bg", "#fff");
	$("#mytable tr td").hover(function() {
		$(this).parent().find("td").css("background", "#fff")
	}, function() {
		var bgc = $(this).attr("bg");
		$(this).parent().find("td").css("background", bgc)
	});

})

function Numbers(e)   
{   
var keynum   
var keychar   
var numcheck   
  
if(window.event) // IE   
{   
keynum = e.keyCode   
}   
else if(e.which) // Netscape/Firefox/Opera   
{   
keynum = e.which   
}   
keychar = String.fromCharCode(keynum)   
numcheck = /\d/   
return numcheck.test(keychar)   
}   

//确认修改成员
function modifiM() {
if (document.getElementById("rank").value.length == 0 || document.getElementById("names").value.length == 0) {
		confirm("*选项不能为空");
	} 
    else{ if (confirm("是否保存")) {
		document.getElementById("modifiM").submit();
	}}
}
</script>
	</head>

	<body style="background-color:#e4dfd9">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业数据采集
			<b class="tip"></b>编辑创新创业项目成员信息
		</div>
		<form action="innovation_modifiM.action" id="modifiM" method="post">
			<table class="table table-striped table-bordered table-condensed">
				<caption class="t_caption">
					创新创业项目编辑
				</caption>
				<thead>
					<tr>
						<td colspan="99">
							创新创业项目编辑
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 60px;">
							创新创业项目名称:
							<font color="FF0000">*</font>
						</td>
						<td>
							<input name="innovationmember.innovationproject.innoName"
								id="innoName"
								disabled="true" type="text"
								value='<s:property value="innovationproject.innoName" />' />
						</td>
						<td style="width: 60px;">
							学生学号/姓名:
							<font color="FF0000">*</font>
						</td>
						<td>
							<div id="abc" style="display: inline; float: left;">
								<input type="text" name="innovationmember.student.stuNumber"  value="<s:property value='innovationmember.student.stuNumber' />"
									style="background: transparent;" placeholder="输入学生号或姓名搜索"
									autocomplete="off" id="names" onkeyup="findNames('${userId}')"
									onfocus="findNames('${userId}')" />
								<!-- 自动搜索，用于显示搜索结果 -->
								<div id="popup"
									style="border: 1px solid #c7c7c7; border-top: none; z-index: 1; position: absolute; overflow: auto;">
									<table class="autoSeek" id="complete_table">
										<tbody id="complete_body"></tbody>
									</table>
								</div>
							</div>			
						</td>					
					</tr>
					<tr>
						<td style="width: 60px;">
							排名
							<font color="FF0000">*</font>
						</td>
						<td colspan="3">
							<input name="innovationmember.rank" id="rank"
								type="text" value='<s:property value="innovationmember.rank" />'
								onkeypress="return Numbers(event)" />
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="99">
							<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>
							<a href="javascript:modifiM()" class="btn btn-primary add">保存</a>&nbsp;&nbsp;
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</body>
<script charset="UTF-8">
var XMLHttpReq;
var completeDiv;
var inputField;
var completeTable;
var completeBody;
//创建XMLHttpRequest对象
function createXMLHttpRequest() {
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
		var o = createXMLHttpRequest();
		var value = inputField.value;
		value = encodeURI(encodeURI(value));
		var url = "autoSearch.action?role=student&userId=" + userId+ "&idname=" + value;
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
		cell.innerHTML = "学号";
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
</script>	
</html>
