<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>创新创业项目修改</title>
		

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
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/buniqueness.js">
</script>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />


		<script type="text/javascript"><!--
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
function Numbers(e) {
	var keynum
	var keychar
	var numcheck

	if (window.event) // IE   
	{
		keynum = e.keyCode
	} else if (e.which) // Netscape/Firefox/Opera   
	{
		keynum = e.which
	}
	keychar = String.fromCharCode(keynum)
	numcheck = /\d/
	return numcheck.test(keychar)
}

function modifi() {
    var regx= /^\d+(?:\.\d{0,4})?$/;
    var setDate=new Date(document.getElementById("setDate").value).getTime();
     var endDate=new Date(document.getElementById("endDate").value).getTime();
	if (document.getElementById("innoNumber").value.length == 0) {
		confirm("项目编号选项不能为空");
	} else if (document.getElementById("year").value.length == 0) {
		alert("年份不能为空");
		document.getElementById("year").focus();
	} else if (!document.getElementById("year").value.match(regx)||document.getElementById("year").value.length != 4) {
		alert("年份格式错误，必须为四位数字");
		document.getElementById("year").focus();
	}else if (document.getElementById("innoNumberError").innerText == "该编号已存在")
		alert("编号已经存在");
	else if (document.getElementById("innoName").value.length == 0) {
		confirm("创业项目名字选项不能为空");
	} else if (document.getElementById("setDate").value.length == 0) {
		confirm("立项时间选项不能为空");
	}else if (document.getElementById("endDate").value.length == 0) {
		confirm("结题时间选项不能为空");
	}else if(setDate>endDate){
	      alert("结题时间不能早于立项时间");
			document.getElementById("endDate").focus();
	} else if (document.getElementById("cost").value.length == 0) {
		confirm("创业项目费用选项不能为空");
	} else if (!document.getElementById("cost").value.match(regx)) {
		confirm("创业项目费用选项格式错误");
	}  else if (confirm("是否保存信息")) {
		document.getElementById("modifi").submit();
	}
}
--></script>
		<script>
//日历
var gMonths = new Array("一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月",
		"十月", "十一月", "十二月");
var WeekDay = new Array("日", "一", "二", "三", "四", "五", "六");
var strToday = "今天";
var strYear = "年";
var strMonth = "月";
var strDay = "日";
var splitChar = "-";
var startYear = 2000;
var endYear = 2050;
var dayTdHeight = 12;
var dayTdTextSize = 12;
var gcNotCurMonth = "#E0E0E0";
var gcRestDay = "#FF0000";
var gcWorkDay = "#444444";
var gcMouseOver = "#79D0FF";
var gcMouseOut = "#F4F4F4";
var gcToday = "#444444";
var gcTodayMouseOver = "#6699FF";
var gcTodayMouseOut = "#79D0FF";
var gdCtrl = new Object();
var goSelectTag = new Array();
var gdCurDate = new Date();
var giYear = gdCurDate.getFullYear();
var giMonth = gdCurDate.getMonth() + 1;
var giDay = gdCurDate.getDate();
function $() {
	var elements = new Array();
	for ( var i = 0; i < arguments.length; i++) {
		var element = arguments[i];
		if (typeof (arguments[i]) == 'string') {
			element = document.getElementById(arguments[i]);
		}
		if (arguments.length == 1) {
			return element;
		}
		elements.Push(element);
	}
	return elements;
}
Array.prototype.Push = function() {
	var startLength = this.length;
	for ( var i = 0; i < arguments.length; i++) {
		this[startLength + i] = arguments[i];
	}
	return this.length;
}
String.prototype.HexToDec = function() {
	return parseInt(this, 16);
}
String.prototype.cleanBlank = function() {
	return this.isEmpty() ? "" : this.replace(/\s/g, "");
}
function checkColor() {
	var color_tmp = (arguments[0] + "").replace(/\s/g, "").toUpperCase();
	var model_tmp1 = arguments[1].toUpperCase();
	var model_tmp2 = "rgb(" + arguments[1].substring(1, 3).HexToDec() + ","
			+ arguments[1].substring(1, 3).HexToDec() + ","
			+ arguments[1].substring(5).HexToDec() + ")";
	model_tmp2 = model_tmp2.toUpperCase();
	if (color_tmp == model_tmp1 || color_tmp == model_tmp2) {
		return true;
	}
	return false;
}function $V() {
	return $(arguments[0]).value;
}
function fPopCalendar(evt, popCtrl, dateCtrl) {
	evt.cancelBubble = true;
	gdCtrl = dateCtrl;
	fSetYearMon(giYear, giMonth);
	var point = fGetXY(popCtrl);
	with ($("calendardiv").style) {
		left = point.x + "px";
		top = (point.y + popCtrl.offsetHeight + 1)+"px";visibility='visible';zindex='99';position='absolute';}$("calendardiv").focus();} 
function fSetDate(iYear,iMonth,iDay){var iMonthNew=new String(iMonth);var iDayNew=new String(iDay);if(iMonthNew.length<2){iMonthNew="0"+iMonthNew;}if(iDayNew.length<2){iDayNew="0"+iDayNew;}gdCtrl.value=iYear+splitChar+iMonthNew+splitChar+iDayNew;fHideCalendar();} 
function fHideCalendar(){$("calendardiv").style.visibility="hidden";for(var i=0;i<goSelectTag.length;i++){goSelectTag[i].style.visibility="visible";}goSelectTag.length=0;} 
function fSetSelected(){var iOffset=0;var iYear=parseInt($("tbSelYear").value);var iMonth=parseInt($("tbSelMonth").value);var aCell=$("cellText"+arguments[0]);aCell.bgColor=gcMouseOut;with(aCell){var iDay=parseInt(innerHTML);if(checkColor(style.color,gcNotCurMonth)){iOffset=(innerHTML>10)?-1:1;}iMonth+=iOffset;if(iMonth<1){iYear--;iMonth=12;}else if(iMonth>12){iYear++;iMonth=1;}}fSetDate(iYear,iMonth,iDay);} 
function Point(iX,iY){this.x=iX;this.y=iY;} 
function fBuildCal(iYear,iMonth){var aMonth=new Array();for(var i=1;i<7;i++){aMonth[i]=new Array(i);}var dCalDate=new Date(iYear,iMonth-1,1);var iDayOfFirst=dCalDate.getDay();var iDaysInMonth=new Date(iYear,iMonth,0).getDate();var iOffsetLast=new Date(iYear,iMonth-1,0).getDate()-iDayOfFirst+1;var iDate=1;var iNext=1;for(var d=0;d<7;d++){aMonth[1][d]=(d<iDayOfFirst)?(iOffsetLast+d)*(-1):iDate++;}for(var w=2;w<7;w++){for(var d=0;d<7;d++){aMonth[w][d]=(iDate<=iDaysInMonth)?iDate++:(iNext++)*(-1);}}return aMonth;} 
function fDrawCal(iYear,iMonth,iCellHeight,iDateTextSize){var colorTD=" bgcolor='"+gcMouseOut+"' bordercolor='"+gcMouseOut+"'";var styleTD=" valign='middle' align='center' style='height:"+iCellHeight+"px;font-weight:bolder;font-size:"+iDateTextSize+"px;";var dateCal="";dateCal+="<tr>";for(var i=0;i<7;i++){dateCal+="<td"+colorTD+styleTD+"color:#990099'>"+WeekDay[i]+"</td>";}dateCal+="</tr>";for(var w=1;w<7;w++){dateCal+="<tr>";for(var d=0;d<7;d++){var tmpid=w+""+d;dateCal+="<td"+styleTD+"cursor:pointer;' onclick='fSetSelected("+tmpid+")'>";dateCal+="<span id='cellText"+tmpid+"'></span>";dateCal+="</td>";}dateCal+="</tr>";}return dateCal;} 
function fUpdateCal(iYear,iMonth){var myMonth=fBuildCal(iYear,iMonth);var i=0;for(var w=1;w<7;w++){for(var d=0;d<7;d++){with($("cellText"+w+""+d)){parentNode.bgColor=gcMouseOut;parentNode.borderColor=gcMouseOut;parentNode.onmouseover=function(){this.bgColor=gcMouseOver;};parentNode.onmouseout=function(){this.bgColor=gcMouseOut;};if(myMonth[w][d]<0){style.color=gcNotCurMonth;innerHTML=Math.abs(myMonth[w][d]);}else{style.color=((d==0)||(d==6))?gcRestDay:gcWorkDay;innerHTML=myMonth[w][d];if(iYear==giYear && iMonth==giMonth && myMonth[w][d]==giDay){style.color=gcToday;parentNode.bgColor=gcTodayMouseOut;parentNode.onmouseover=function(){this.bgColor=gcTodayMouseOver;};parentNode.onmouseout=function(){this.bgColor=gcTodayMouseOut;};}}}}}} 
function fSetYearMon(iYear,iMon){$("tbSelMonth").options[iMon-1].selected=true;for(var i=0;i<$("tbSelYear").length;i++){if($("tbSelYear").options[i].value==iYear){$("tbSelYear").options[i].selected=true;}}fUpdateCal(iYear,iMon);} 
function fPrevMonth(){var iMon=$("tbSelMonth").value;var iYear=$("tbSelYear").value;if(--iMon<1){iMon=12;iYear--;}fSetYearMon(iYear,iMon);} 
function fNextMonth(){var iMon=$("tbSelMonth").value;var iYear=$("tbSelYear").value;if(++iMon>12){iMon=1;iYear++;}fSetYearMon(iYear,iMon);} 
function fGetXY(aTag){var oTmp=aTag;var pt=new Point(0,0);do{pt.x+=oTmp.offsetLeft;pt.y+=oTmp.offsetTop;oTmp=oTmp.offsetParent;}while(oTmp.tagName.toUpperCase()!="BODY");return pt;} 
function getDateDiv(){var noSelectForIE="";var noSelectForFireFox="";if(document.all){noSelectForIE="onselectstart='return false;'";}else{noSelectForFireFox="-moz-user-select:none;";}var dateDiv="";dateDiv+="<div id='calendardiv' onclick='event.cancelBubble=true' "+noSelectForIE+" style='"+noSelectForFireFox+"position:absolute;z-index:99;visibility:hidden;border:1px solid #999999;'>";dateDiv+="<table border='0' bgcolor='#E0E0E0' cellpadding='1' cellspacing='1' >";dateDiv+="<tr>";dateDiv+="<td><input type='button' id='PrevMonth' value='<' style='height:20px;width:20px;font-weight:bolder;' onclick='fPrevMonth()'>";dateDiv+="</td><td><select id='tbSelYear' style='border:1px solid;' onchange='fUpdateCal($V(\"tbSelYear\"),$V(\"tbSelMonth\"))'>";for(var i=startYear;i<endYear;i++){dateDiv+="<option value='"+i+"'>"+i+strYear+"</option>";}dateDiv+="</select></td><td>";dateDiv+="<select id='tbSelMonth' style='border:1px solid;' onchange='fUpdateCal($V(\"tbSelYear\"),$V(\"tbSelMonth\"))'>";for(var i=0;i<12;i++){dateDiv+="<option value='"+(i+1)+"'>"+gMonths[i]+"</option>";}dateDiv+="</select></td><td>";dateDiv+="<input type='button' id='NextMonth' value='>' style='height:20px;width:20px;font-weight:bolder;' onclick='fNextMonth()'>";dateDiv+="</td>";dateDiv+="</tr><tr>";dateDiv+="<td align='center' colspan='4'>";dateDiv+="<div style='background-color:#cccccc'><table width='100%' border='0' cellpadding='3' cellspacing='1'>";dateDiv+=fDrawCal(giYear,giMonth,dayTdHeight,dayTdTextSize);dateDiv+="</table></div>";dateDiv+="</td>";dateDiv+="</tr><tr><td align='center' colspan='4' nowrap>";dateDiv+="<span style='cursor:pointer;font-weight:bolder;' onclick='fSetDate(giYear,giMonth,giDay)' onmouseover='this.style.color=\""+gcMouseOver+"\"' onmouseout='this.style.color=\"#000000\"'>"+strToday+":"+giYear+strYear+giMonth+strMonth+giDay+strDay+"</span>";dateDiv+="</tr></tr>";dateDiv+="</table></div>";return dateDiv;} 
with(document){onclick=fHideCalendar;write(getDateDiv());} 
</script>
	</head>

	<body style="background-color:#e4dfd9">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业数据采集
			<b class="tip"></b>编辑创新创业项目详细信息
		</div>
		<form action="innovation_modifi.action" id="modifi" method="post">
			<table class="table table-bordered table-condensed list">
				<caption class="t_caption">
					编辑创新创业项目信息
				</caption>
				<thead>
					<tr>
						<td colspan="99">
							编辑创新创业项目信息
							<i class="tip-up"></i>
						</td>
					</tr>
				</thead>
				<tbody id="mytable" class="tby">
					<tr>
						<td style="width: 60px;">
							项目编号:
							<font color="FF0000">*</font>
						</td>
						<td>
								<input name="innovationproject.innoNumber" id="innoNumber" value="<s:property value='innovationproject.innoNumber'/>"
								onblur="innoblur();" type="text" />
							<span id="innoNumberError"></span>
						</td>
						<td style="width: 60px;">
							项目名称:
							<font color="FF0000">*</font>
						</td>
						<td>
							<input name="innovationproject.innoName" id="innoName" value="<s:property value='innovationproject.innoName'/>" 
								type="text" />
							<span id="innoNameError"/>
						</td>
						<td style="width: 60px;">
							立项时间:
							<font color="FF0000">*</font>
						</td>
						<td>
							<input name="innovationproject.setDate" id="setDate" type="text"  value='<fmt:formatDate pattern="yyyy-MM-dd" value="${innovationproject.setDate}" />'
								onclick="fPopCalendar(event,this,this)" onfocus="this.select()" />
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							项目类型:
							<font color="FF0000">*</font>
						</td>
						<td>
							<select name="innovationproject.type">
								
								<option value="创新训练项目"
									<s:if test=' "创新训练项目"==innovationproject.type' >selected="selected"</s:if>>
									创新训练项目
								</option>
								<option value="创业训练项目"
									<s:if test=' "创业训练项目"==innovationproject.type' >selected="selected"</s:if>>
									创业训练项目
								</option>
								<option value="创业实践项目"
									<s:if test=' "创业实践项目"==innovationproject.type' >selected="selected"</s:if>>
									创业实践项目
								</option>
								<option value="其他"
								   <s:if test=' "其他"==innovationproject.type' >selected="selected"</s:if>>
									其他
								</option>
							</select>
						</td>
						<td style="width: 60px;">
							项目级别:
							<font color="FF0000">*</font>
						</td>
						<td>
							<select name="innovationproject.level">
								
								<option value="国家级"
								   <s:if test=' "国家级"==innovationproject.level' >selected="selected"</s:if>>
									国家级
								</option>
								<option value="省级"
									 <s:if test=' "省级"==innovationproject.level' >selected="selected"</s:if>>
									省级
								</option>
								<option value="校重点"
									 <s:if test=' "校重点"==innovationproject.level' >selected="selected"</s:if>>
									校重点
								</option>
								<option value="校一般"
									 <s:if test=' "校一般"==innovationproject.level' >selected="selected"</s:if>>
									校一般
								</option>
								<option value="院重点"
									 <s:if test=' "院重点"==innovationproject.level' >selected="selected"</s:if>>
									院重点
								</option>
								<option value="院一般"
									 <s:if test=' "院一般"==innovationproject.level' >selected="selected"</s:if>>
									院一般
								</option>
								<option value="个人"
									<s:if test=' "个人"==innovationproject.level' >selected="selected"</s:if>>
									个人
								</option>
								<option value="其他"
								   <s:if test=' "其他"==innovationproject.level' >selected="selected"</s:if>>
									其他
								</option>
							</select>
						</td>
						<td style="width: 60px;">
							结题时间:
							<font color="FF0000">*</font>
						</td>
						<td>
							<input name="innovationproject.endDate" id="endDate"
								value='<fmt:formatDate pattern="yyyy-MM-dd" value="${innovationproject.endDate}" />'
								type="text" onclick="fPopCalendar(event,this,this)"
								 />
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							项目经费:
							<font color="FF0000">*</font>
						</td>
						<td>
							<input name="innovationproject.cost" id="cost"
								value='<s:property value="innovationproject.cost" />'
								type="text" />
						</td>
						
						<td>
							备注
						</td>
						<td>
							<input name="innovationproject.note"
								value='<s:property value="innovationproject.note" />'
								type="text" />
						</td>
						<td>
							立项年份
							<font color="FF0000">*</font>
						</td>
						<td>
							<input name="innovationproject.year" id="year"  onkeypress="return Numbers(event)"
								value='<s:property value="innovationproject.year" />'
								type="text" />
						</td>
					</tr>
					<tr>
					<td>
							验收结论
					</td>
						<td colspan="99">
							<input name="innovationproject.assessment" id="assessment"
								value='<s:property value="innovationproject.assessment" />'
								type="text" />
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="99">
							<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
							<a href="javascript:modifi()" class="btn btn-primary add">保存</a>
							

						</td>
					</tr>
				</tfoot>
			</table>
		</form>
		</body>
</html>
