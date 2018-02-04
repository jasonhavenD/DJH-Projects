<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>复选框</title>
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
			爱好：<input type="checkbox" id="sing-1" name="hobby-1" value="唱歌" /><label for="sing-1" class="hand">唱歌</label>
			    <input type="checkbox" id="dance-1" name="hobby-1" value="跳舞" /><label for="dance-1" class="hand">跳舞</label>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
			<legend>2、设置初始值</legend>
			爱好：<input type="checkbox" id="sing-2" name="hobby-2" value="唱歌" checked="checked"/><label for="sing-2" class="hand">唱歌</label>
			    <input type="checkbox" id="dance-2" name="hobby-2" value="跳舞" checked="checked"/><label for="dance-2" class="hand">跳舞</label>
			    <input type="checkbox" id="football-2" name="hobby-2" value="足球" /><label for="football-2" class="hand">足球</label>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
			<legend>3、动态选中某项</legend>
			爱好：<input type="checkbox" id="sing-3" name="hobby-3" value="唱歌"/><label for="sing-3" class="hand">唱歌</label>
			    <input type="checkbox" id="dance-3" name="hobby-3" value="跳舞"/><label for="dance-3" class="hand">跳舞</label>
			    <input type="checkbox" id="pingpang-3" name="hobby-3" value="乒乓球" checked="checked"/><label for="pingpang-3" class="hand">乒乓球</label>
			<input type="button" value="我喜欢唱歌跳舞，不喜欢乒乓球" onclick="selectItem()"/>
			<input type="button" value="我都喜欢" onclick="selectAllItem()"/>
			<input type="button" value="我都不喜欢" onclick="clearAllItem()"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
			<legend>4、禁用</legend>
			爱好：<input type="checkbox" id="sing-4" name="hobby-4" value="唱歌" disabled="disabled"/><label for="sing-4" class="hand">唱歌</label>
			    <input type="checkbox" id="dance-4" name="hobby-4" value="跳舞" disabled="disabled"/><label for="dance-4" class="hand">跳舞</label>
			    <input type="checkbox" id="pingpang-4" name="hobby-4" value="乒乓球" checked="checked" disabled="disabled"/><label for="pingpang-4" class="hand">乒乓球</label>
			    <br/>
			     <input type="button" value="启用" onclick="enableSelect()" style="width:105px;"/>
      			<input type="button" value="禁用" onclick="disableSelect()" style="width:105px;"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
			<legend>5、动态生成</legend>
			<input type="button" value="动态生成多选按钮" id="testBtn"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
			<legend>6、获取选中项</legend>
			爱好：<input type="checkbox" id="sing-6" name="hobby-6" value="唱歌"/><label for="sing-6" class="hand">唱歌</label>
			    <input type="checkbox" id="dance-6" name="hobby-6" value="跳舞"/><label for="dance-6" class="hand">跳舞</label>
			    <input type="checkbox" id="pingpang-6" name="hobby-6" value="乒乓球" checked="checked"/><label for="pingpang-6" class="hand">乒乓球</label>
			<input type="button" value="我的爱好是？" onclick="getCheckValue()"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  
	   <fieldset> 
			<legend>7、自定义样式（部分皮肤有效）</legend>
			自定义样式只在支持CSS3的浏览器中生效，例如IE9以上、firefox、chrome，低版本浏览器会显示原生的checkbox样式。
			<div class="checkboxRender">
			爱好：<input type="checkbox" id="sing-7" name="hobby-7" value="唱歌" /><label for="sing-7" class="hand">唱歌</label>
			    <input type="checkbox" id="dance-7" name="hobby-7" value="跳舞" /><label for="dance-7" class="hand">跳舞</label>
			 </div>
	  </fieldset>
	  <div class="height_15"></div>
   
	</div>


<script type="text/javascript">


    //选中唱歌 跳舞
    function selectItem(){
		$("input:checkbox[name=hobby-3]").eq(0).attr("checked",true);
		$("input:checkbox[name=hobby-3]").eq(1).attr("checked",true);
		$("input:checkbox[name=hobby-3]").eq(2).attr("checked",false);
    }
    
    //选中全部
    function selectAllItem(){
        $("input:checkbox[name=hobby-3]").attr("checked",true);
    }
    
    //清空全部选项
    function clearAllItem(){
    	$("input:checkbox[name=hobby-3]").attr("checked",false);
    }
    
    //设为不可用
	function disableSelect(){
		$("#sing-4").attr("disabled",true);
		$("#dance-4").attr("disabled",true);
		$("#pingpang-4").attr("disabled",true);
	}
	//设为可用
	function enableSelect(){
	    $("#sing-4").attr("disabled",false);
		$("#dance-4").attr("disabled",false);
		$("#pingpang-4").attr("disabled",false);
	}
    
    //生成选项
    var counter=0
    $(function(){
		$("#testBtn").click(function(){
		    var checkStr = "<input type='checkbox' id='love-" + counter + "' name='hobby' value=" + counter + "/><label class='hand' for='love-" + counter + "'>爱好" + counter + "</label>";
			var $input=$(checkStr);
			$(this).after($input);
			counter++;
		})
	})
	
	//获取复选框的值
	function getCheckValue(){
	    var msg = "";
		$("input:checkbox[name=hobby-6]").each(function(){
			if($(this).attr("checked")){
				msg += "," + $(this).val();
			}
		})
		if(msg == ""){
			msg = "无"
		}else{
		    msg = msg.substring(1);
		}
		top.Dialog.alert(msg);
	}
</script>

</body>
</html>