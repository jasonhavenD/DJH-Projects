<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>步进器</title>
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!-- 数字步进器start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/stepper.js"></script>
<!-- 数字步进器end -->

</head>
<body>
  <div class="box1" panelWidth="800">
  
  <fieldset>
      <legend>1、基本用法</legend>
      <input id="step1" type="text" class="stepper" value="0"/>
      <input type="button" value="获取值" onclick="getValue()"/>
  </fieldset>
  <div class="height_15"></div>   
  
  <fieldset>
      <legend>2、自定义宽度</legend>
      <input type="text" class="stepper" style="width:50px;" value="100"/>
  </fieldset>
  <div class="height_15"></div>   
  
  <fieldset>
      <legend>3、自定义最小值、最大值和步长</legend>
      <input type="text" class="stepper" min="5" max="10" value="5" step="0.5"/>
  </fieldset>
  <div class="height_15"></div>
  
  	<fieldset>
      <legend>4、禁用/启用</legend>
       <input id="step4" type="text" class="stepper" value="0" disabled="true"/>
       <input type="button" value="启用" onclick="enableSelect()" style="width:105px;"/>
       <input type="button" value="禁用" onclick="disableSelect()" style="width:105px;"/>
  	</fieldset>
  	<div class="height_15"></div>
     
  <fieldset>
      <legend>5、动态添加步进器</legend>
      <button onclick="addStepper()" id="testBtn">点击添加</button><br /><br />
	  
  </fieldset>
  	<div class="height_15"></div>
  
  <fieldset>
      <legend>6、动态改变值</legend>
       <input id="step6" type="text" class="stepper" value="0"/>
     <input type="button" value="改变值为50" onclick="changeValue()"/>
       
  	</fieldset>
  	<div class="height_15"></div>
   <fieldset>
      <legend>7、构建时间选择器</legend>
      <table>
      	<tr>
      		<td>请选择时间：</td>
      		<td><input type="text" class="stepper" style="width:40px;" min="0" max="24" value="19" step="1" id="hour"/></td>
      		<td>时</td>
      		<td><input type="text" class="stepper" style="width:40px;" min="0" max="60" value="51" step="1" id="minite"/></td>
      		<td>分</td>
      		<td><input type="button" value="获取时间" onclick="getTimeValue()"/></td>
      	</tr>
      </table>
  	</fieldset>
  	<div class="height_15"></div>   
  	<fieldset>
      <legend>8、change事件</legend>
      <input id="step8" type="text" class="stepper" value="0"/>
  </fieldset>
  

  </div>


<script type="text/javascript">
   function initComplete(){
   	$("#step8").bind("change",function(e,data){
   		top.Dialog.alert(data.toString())
   	})
   }
   
    //获取步进器的值
    function getValue(){
        top.Dialog.alert($('#step1').val());
    }
    
    //设为不可用
	function disableSelect(){
		$("#step4").attr("disabled",true);
	}
	//设为可用
	function enableSelect(){
	    $("#step4").attr("disabled",false);
	}
    
    //动态添加步进器
    function addStepper(){
        var $stepper = $('<input id="step1" type="text" class="stepper" min="5" max="10" value="5" step="0.5"/>');
		$("#testBtn").after($stepper);
		$stepper.render();
    }
    
    //改变值
    function changeValue(){
    	$("#step6").val(50);
    }
    
    
 	function getTimeValue(){
        top.Dialog.alert("所选时间："+$('#hour').val()+":"+$('#minite').val());
    }
</script>

</body>
</html>