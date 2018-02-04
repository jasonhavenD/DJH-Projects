<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>软键盘</title>
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!-- 软键盘控件start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/keypad.js"></script>
<!-- 软键盘控件end -->

</head>
<body>
  <div class="box1" panelWidth="800">
  
  <fieldset>
      <legend>1、数字键盘</legend>
      <input class="keypad" type="text" id="keypad-1"/>
      <input type="button" value="获取值" onclick="getValue()"/> 
  </fieldset>
  <div class="height_15"></div>  
  
  <fieldset>
      <legend>2、数字位置随机</legend>
      <input class="keypad" type="text" random="true"/>
  </fieldset>
  <div class="height_15"></div>    
  
   <fieldset>
      <legend>3、允许输入</legend>
      <input  type="password" class="keypad"  random="true" allowKeyboard="true" inputMode="numberOnly" maxlength="6"/>
      <p> 这里模拟了密码输入：非明文显示、数字随机、可关闭后用键盘输入、只能输入数字、最多输入6位、大写键开启后输入有提示</p>
      
  </fieldset>
  <div class="height_15"></div>   
  
  <fieldset>
      <legend>4、全键盘</legend>
      <input class="keypad" keypadMode="full" type="text"/>
  </fieldset>
    <div class="height_15"></div>  
    
  
   <fieldset>
      <legend>5、全键盘允许输入</legend>
      <input type="text" class="keypad" keypadMode="full" allowKeyboard="true" />
      
  </fieldset>
  <div class="height_15"></div>   
  
   <fieldset>
      <legend>6、禁用/启用</legend>
      <input class="keypad" type="text" disabled="true" id="keypad-6"/>
      <br/>
		<input type="button" value="启用" onclick="enableSelect()" style="width:105px;"/>
  		<input type="button" value="禁用" onclick="disableSelect()" style="width:105px;"/>
  </fieldset>
  <div class="height_15"></div>   
  
   <fieldset>
      <legend>7、动态创建数字键盘</legend>
      <input type="button" value="点击生成" id="testBtn" onclick="dynamic1()"/>
  </fieldset>
  <div class="height_15"></div>  
  
  <fieldset>
      <legend>8、动态创建全键盘</legend>
      <input type="button" value="点击生成" id="testBtn2" onclick="dynamic2()"/>
  </fieldset>
  <div class="height_15"></div>    

  </div>
<script type="text/javascript">
	//获取值
	function getValue(){
		top.Dialog.alert($("#keypad-1").val());
	}
	
	//设为不可用
	function disableSelect(){
		$("#keypad-6").attr("disabled",true);
	}
	//设为可用
	function enableSelect(){
	    $("#keypad-6").attr("disabled",false);
	}
	
	//动态生成
	function dynamic1(){
		var $keypad = $('<input type="text" class="keypad" random="true"/>');
		$("#testBtn").after($keypad);   
		$("#testBtn").after($("<br/>"));   
		//渲染
		$keypad.render();      
	}
	
	//动态生成
	function dynamic2(){
		var $input = $('<input type="text" class="keypad" keypadMode="full"/>');
		$("#testBtn2").after($input);   
		$("#testBtn2").after($("<br/>"));   
		//渲染
		$input.render();      
	}
</script>
</body>
</html>