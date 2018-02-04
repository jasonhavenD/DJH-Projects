<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>单选框</title>
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->
</head>
<body>
   <div class="box1" panelWidth="800">
   
      <fieldset> 
			<legend>1、点击文字进行选中（推荐做法）</legend>
			性别：<input type="radio" id="male-1" name="sex-1" value="男" /><label for="male-1" class="hand">男（Male）</label>
			    <input type="radio" id="female-1" name="sex-1" value="女" /><label for="female-1" class="hand">女（Female）</label>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
			<legend>2、设置初始值</legend>
			年龄：<input type="radio" id="lt25-2" name="age-2" value="小于25" /><label for="lt25-2" class="hand">小于25</label>
			    <input type="radio" id="gt25-2" name="age-2" value="大于等于25" checked="checked"/><label for="gt25-2" class="hand">大于等于25</label>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
			<legend>3、动态选中某项</legend>
			性别：<input type="radio" id="male-3" name="sex-3" value="男" /><label for="male-3" class="hand">男（Male）</label>
			    <input type="radio" id="female-3" name="sex-3" value="女" /><label for="female-3" class="hand">女（Female）</label>
			<input type="button" value="我是女生" onclick="changeItem()"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
			<legend>4、禁用/启用</legend>
			年龄：<input type="radio" id="lt25-4" name="age-4" value="小于25" disabled="disabled"/><label for="lt25-4" class="hand">小于25</label>
			    <input type="radio" id="gt25-4" name="age-4" value="大于等于25" checked="checked" disabled="disabled"/><label for="gt25-4" class="hand">大于等于25</label>
			    <br/>
			     <input type="button" value="启用" onclick="enableSelect()" style="width:105px;"/>
      			<input type="button" value="禁用" onclick="disableSelect()" style="width:105px;"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
			<legend>5、动态生成单选项</legend>
			<input type="button" value="点击生成单选项" id="testBtn"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
			<legend>6、获取选中项</legend>
			性别：<input type="radio" id="male-6" name="sex-6" value="男" checked="checked"/><label for="male-6" class="hand">男（Male）</label>
			    <input type="radio" id="female-6" name="sex-6" value="女" /><label for="female-6" class="hand">女（Female）</label>
			<input type="button" value="获取选中项的值" onclick="getRadioValue()"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset> 
			<legend>7、自定义样式（部分皮肤有效）</legend>
			自定义样式只在支持CSS3的浏览器中生效，例如IE9以上、firefox、chrome，低版本浏览器会显示原生的radio样式。
			<div class="checkboxRender">
			性别：<input type="radio" id="male-7" name="sex-7" value="男" /><label for="male-7" class="hand">男（Male）</label>
			    <input type="radio" id="female-7" name="sex-7" value="女" /><label for="female-7" class="hand">女（Female）</label>
	 		</div>
	  </fieldset>
   
	</div>


<script type="text/javascript">

   

    //改变Radio的值
    function changeItem(){
		$("input:radio[name=sex-3]").eq(1).attr("checked",true);
    }
    
    //生成单选项
    var counter = 10;
    $(function(){
		$("#testBtn").click(function(){
		    var radioStr = "<input type='radio' id='love-" + counter + "' name='hobby' value=" + counter + "/><label class='hand' for='love-" + counter + "'>爱好" + counter + "</label>";
			var $input=$(radioStr);
			$(this).after($input);
			counter++;
		})
	})
	
	//获取选中项的值
	function getRadioValue(){
	    top.Dialog.alert($("input:radio[name=sex-6]").filter("[checked]").val());
	}
	
	 //设为不可用
	function disableSelect(){
		$("#lt25-4").attr("disabled",true);
		$("#gt25-4").attr("disabled",true);
	}
	//设为可用
	function enableSelect(){
	    $("#lt25-4").attr("disabled",false);
		$("#gt25-4").attr("disabled",false);
	}
</script>

</body>
</html>