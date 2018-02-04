<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>日期</title>
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!-- 日期选择框start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/datePicker/WdatePicker.js"></script>
<!-- 日期选择框end -->

</head>
<body>
   <div class="box1" panelWidth="800">
   
   	  <fieldset> 
			<legend>1、基本日期控件</legend>
			<input type="text" class="date"/>
	  </fieldset>
	  <div class="height_15"></div>
	    
	  <fieldset> 
			<legend>2、选择日期+时间</legend>
			<input type="text" class="date" style="width:200px;" dateFmt="yyyy-MM-dd HH:mm:ss"/>
	   </fieldset> 
	   <div class="height_15"></div>
	   
	   <fieldset> 
			<legend>3、只选择时间</legend>
			<input type="text" class="date" dateFmt="HH:mm:ss"/>
	   </fieldset>
	   <div class="height_15"></div>
	   
	   <fieldset> 
			<legend>4、自定义时间格式</legend>
			<input type="text" class="date" style="width:200px;" dateFmt="yyyy年MM月dd日HH时mm分ss秒"/>
	   </fieldset>
	    <div class="height_15"></div>
	    
	    <fieldset> 
			<legend>5、日期控件默认有值</legend>
			<input type="text" class="date" value="2012-07-08"/>
	   </fieldset>
	    <div class="height_15"></div>
	   
	     <fieldset> 
			<legend>6、动态生成日期控件</legend>
			<input type="button" value="点击生成日期控件" id="testBtn" onclick="createDate()"/>
	   </fieldset>
	    <div class="height_15"></div>
	    
	   <fieldset> 
			<legend>7、日期控件动态赋值</legend>
			<input type="text" class="date" id="date-7"/>
			<input type="button" value="点击赋值" onclick="setValue()"/>
	   </fieldset>
	    <div class="height_15"></div>
	    
	     <fieldset> 
			<legend>8、禁用/启用</legend>
			<input type="text" class="date" disabled="true" id="date-8"/>
			<br/>
			<input type="button" value="启用" onclick="enableSelect()" style="width:105px;"/>
      		<input type="button" value="禁用" onclick="disableSelect()" style="width:105px;"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset> 
			<legend>9、双日历</legend>
			<input class="date" type="text" doubleCal="true"/>
	  </fieldset>
	  <div class="height_15"></div>
 
 	  <fieldset> 
			<legend>10、起止日期联动</legend>
			<input type="text" id="beginTime" class="dateIcon"/>
			<input type="text" id="endTime" class="dateIcon"/>
	  </fieldset>
	   <div class="height_15"></div>
	  
 	  <fieldset> 
			<legend>11、平面显示</legend>
			<div id="div1"></div>
	  </fieldset>
	   <div class="height_15"></div>
	   
	  <fieldset> 
			<legend>12、选择今天之前</legend>
			<input class="dateIcon" type="text" onfocus="WdatePicker({skin:themeColor,maxDate:'%y-%M-%d'})"/>
	   </fieldset>
	   <div style="height:300px;"></div>
	</div>
<script type="text/javascript">
	var dateSkin="blue";
	function initComplete(){
		//获取当前主题风格，用于设置日期控件的皮肤
		try {
			dateSkin=themeColor;
		}
		catch(e){}
		
		//自定义点击触发日期控件
		document.getElementById('beginTime').onfocus=function(){
			var endtimeTf=$dp.$('endTime');
			WdatePicker({
				skin:dateSkin,onpicked:function(){endtimeTf.focus();},maxDate:'#F{$dp.$D(\'endTime\')}'
			});
		}
		document.getElementById('endTime').onfocus=function(){
			//这里设置了最大日期为当前日期，如果不需要则把maxDate:'%y-%M-%d'去掉
		WdatePicker({skin:dateSkin,maxDate:'%y-%M-%d',minDate:'#F{$dp.$D(\'beginTime\')}'});
		}
		
		//平面显示
		WdatePicker({skin:dateSkin,eCont:'div1',onpicked:function(dp){alert('你选择的日期是:'+dp.cal.getDateStr())}})
	}
	
	//动态生成
	function createDate(){
			var $date=$('<input type="text" class="date" style="width:140px;" dateFmt="yyyy-MM-dd HH:mm:ss"/>');
			$("#testBtn").after($date);
			$date.render();
	}
	
	 //设为不可用
	function disableSelect(){
		$("#date-8").attr("disabled",true);
	}
	//设为可用
	function enableSelect(){
	    $("#date-8").attr("disabled",false);
	}
	
	//动态赋值
	function setValue(){
		$("#date-7").val("2012-07-08");
	}
</script>
</body>
</html>