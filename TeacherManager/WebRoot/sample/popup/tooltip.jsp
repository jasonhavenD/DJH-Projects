<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!-- 表单验证start -->
<script src="<%=path%>/libs/js/form/validationRule.js" type="text/javascript"></script>
<script src="<%=path%>/libs/js/form/validation.js" type="text/javascript"></script>
<!-- 表单验证end -->

<!-- 日期控件start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/datePicker/WdatePicker.js"></script>
<!-- 日期控件end -->
</head>
<style>
.detailFormTable{
	border:0;
}
.detailFormTable td{
	border:0;
	height:32px;
}
</style>

<body>
    <div class="box1" panelWidth="800">
    <span class="red">第一种类型：</span>
     <fieldset> 
     <legend>1、span标签</legend>
		<span title="不超过5字">小尺寸提示</span>
		<div class="height_10"></div>
		<span title="图片过大会撑坏网页结构。">中尺寸提示</span>
		<div class="height_10"></div>
		<span title="图片过大会撑坏网页结构。对于大图可以强制设置width（不要设置height），这样可以对大图片等比例缩小。图片过大会撑坏网页结构。对于大图可以强制设置width（不要设置height），这样可以对大图片等比例缩小。">大尺寸提示</span><br />
		<div class="height_10"></div>
		<span title="图片过大<br/>会<span style='color:red;'>撑坏</span>网页结构。">提示信息含html元素</span>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
     <legend>2、div标签</legend>
		<div title="在div标签加入title属性" style="width:200px;background-color:#eeeeee">这是在div中的内容</div>
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset> 
     <legend>3、a标签</legend>
		<a title="这是一个链接提示">查看</a>
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset> 
     <legend>4、表单元素</legend>
		<input  type="text" title="在这里输入查询条件"/>
		<div class="height_5"></div>
		<textarea title="请限制在200个字内"></textarea>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
     <legend>5、图片</legend>
		<img src="<%=path%>/libs/images/demo/demo1.jpg" title="图片提示信息"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset> 
     <legend>6、动态添加提示</legend>
		<input type="button" id="addTitle" value="点击后鼠标重新移入按钮上" onclick="addTip()"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset> 
     <legend>7、动态更改提示信息</legend>
		<input type="button" id="changeTitle" value="点击后鼠标重新移入按钮上" title="前进"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset> 
     <legend>8、强制让提示消失</legend>
     	未设置时，在IE的效果为：按钮移动，但提示仍然在原来的位置：<br/>
		<input type="button" id="hideTip" value="点击移动" title="提示信息"/><br/>
		设置后效果：按钮移动，提示消失<br/>
		<input type="button" id="hideTip2" value="点击移动" title="提示信息"/>
	  </fieldset>
	  <div class="height_30"></div>
	  
	  <span class="red">第二种类型：</span>
	  <fieldset> 
     <legend>1、外部触发，跟随鼠标</legend>
     	下面的是onfocus事件触发：<br />
		<input type="text" onfocus="$.cursorMessage('注意不能输入特殊字符');"/><br />
		下面的是onchange事件触发：<br />
		<script>
		function selFunc(){
			$.cursorMessage("选择了："+$("#sel").attr("relText"));
		}
		</script>		
		<select  onchange='selFunc()' id="sel">
		    <option value="">请选择功能</option>
		    <option value="1">新增图片</option>
		    <option value="2">维护图片</option>
		    <option value="3">新增新闻</option>
		</select><br />		
		下面的是onkeydown事件触发：<br />
		<textarea onkeydown="$.cursorMessage('填写详细有助于我们更好地服务');"></textarea>
	  </fieldset>
	  <div class="height_30"></div>
	  
	  <span class="red">第三种类型：</span>
	  <fieldset> 
     <legend>1、自动模式（箭头方向向上）</legend>
		<span title="不超过5字" keepDefaultStyle="true" class="qTip">小尺寸提示</span>
		<div class="height_10"></div>
		<span title="图片过大会撑坏网页结构。" keepDefaultStyle="true" class="qTip">中尺寸提示</span>
		<div class="height_10"></div>
		<span keepDefaultStyle="true" class="qTip" title="图片过大会撑坏网页结构。对于大图可以强制设置width（不要设置height），这样可以对大图片等比例缩小。图片过大会撑坏网页结构。对于大图可以强制设置width（不要设置height），这样可以对大图片等比例缩小。">大尺寸提示</span><br />
		<div class="height_10"></div>
		<span keepDefaultStyle="true" class="qTip" title="图片过大<br/>会<span style='color:red;'>撑坏</span>网页结构。">提示信息含html元素</span>
	  </fieldset>
	  <div class="height_15"></div>
    
    <fieldset> 
     <legend>2、自动模式（箭头方向向左）</legend>
		<span title="不超过5字" keepDefaultStyle="true" class="qTip2">小尺寸提示</span>
		<div class="height_10"></div>
		<span title="图片过大会撑坏网页结构。" keepDefaultStyle="true" class="qTip2">中尺寸提示</span>
		<div class="height_10"></div>
		<span keepDefaultStyle="true" class="qTip2" title="图片过大会撑坏网页结构。对于大图可以强制设置width（不要设置height），这样可以对大图片等比例缩小。图片过大会撑坏网页结构。对于大图可以强制设置width（不要设置height），这样可以对大图片等比例缩小。">大尺寸提示</span><br />
		<div class="height_10"></div>
		<span keepDefaultStyle="true" class="qTip2" title="图片过大<br/>会<span style='color:red;'>撑坏</span>网页结构。">提示信息含html元素</span>
	  </fieldset>
	  <div class="height_15"></div>
    
    <fieldset> 
     <legend>3、点击打开</legend>
		<input type="button" value="打开提示" id="qTip3" onclick="showTip('qTip3')"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
     <legend>4、自定义提示框位置</legend>
		<div id="userInfo" style="padding-left:400px;">用户名：admin</div>
		<br/>
		<input type="button" value="打开提示"  onclick="showTip2()"/>
		
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset> 
	  <legend>5、自定义小箭头</legend>
		<div id="userInfo2" style="padding-left:600px;">用户名：admin</div>
		<img src="<%=path%>/libs/images/demo/demo1.jpg" id="picDemo"/><br/>
		<img src="<%=path%>/libs/images/demo/demo1.jpg" id="picDemo2"/>
		<br/><br/><br/><br/>
		<input type="button" value="箭头偏右" onclick="showTip3(0)"/>
		<input type="button" value="箭头偏下" onclick="showTip3(1)"/>
		<input type="button" value="无箭头" onclick="showTip3(2)"/>
		
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
     <legend>6、外部触发关闭</legend>
		<div id="userInfo3" style="padding-left:400px;">用户名：admin</div>
		<br/>
		<input type="button" value="打开提示" onclick="showTip4()"/>
		<input type="button" value="关闭提示" onclick="closeTip4()"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  
	  <fieldset> 
     <legend>7、弹出复杂内容</legend>
		<button type="button" onclick="showTip5()" id="searchBtn">点击查询</button>
	  </fieldset>
	  <div class="height_30"></div>
	  
	   <fieldset> 
     <legend>8、关闭事件</legend>
		<button type="button" onclick="showTip6()" id="closeEventDemo">点击弹出</button>
	  </fieldset>
	  <div class="height_30"></div>
	  
	  <fieldset> 
     <legend>9、非动态生成</legend>
		如果只需要使用提示的样式，而不需要动态创建或者关闭，可以使用html代码。
		<div class="staticTip" style="width: 400px;">温馨提示：记账完成后，您可以到账单明细中查看记录。</div>
	  </fieldset>
	  <div class="height_30"></div>
	  
	   
	  
	   <fieldset> 
     <legend>使用系统默认的title</legend>
     	<img src="<%=path%>/libs/images/demo/demo1.jpg" title="系统默认提示效果" keepDefaultStyle="true"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	</div>

<script>
		$(document).ready(function(){
			$("#changeTitle").toggle(function(){
				$("#changeTitle").attr("title","后退");
				addTooltip($("#changeTitle")[0]);
			},function(){
				$("#changeTitle").attr("title","前进");
				addTooltip($("#changeTitle")[0]);
			})
			
			$("#hideTip").toggle(function(){
				$("#hideTip").animate({
					"marginLeft":"200px"
				})
			},function(){
				$("#hideTip").animate({
					"marginLeft":0
				})
			})
			
			$("#hideTip2").toggle(function(){
				//元素移动
				$("#hideTip2").animate({
					"marginLeft":"200px"
				})
				//强制提示消失一次
				hideTooltip();
			},function(){
				$("#hideTip2").animate({
					"marginLeft":0
				})
				hideTooltip()
			})
		})
		function addTip(){
			$("#addTitle").attr("title","新添加的提示");
			addTooltip($("#addTitle")[0]);
		}

//以下为第三种tip用到		
$(function () {
    $(".qTip").tip();
    $(".qTip2").tip({ auto:true ,arrowDirection:"left"});
});
function showTip(objId){
	$("#"+objId).tip({showCloseBtn:true,content: "图片过大会撑坏网页结构。对于大图可以强制设置width（不要设置height）"});
}
function showTip2(){
	$("#userInfo").tip({showCloseBtn:true,content: "您还未设置昵称，<span class='red'><a>立即设置</a></span>。",distanceX:400});
}
function showTip3(idx){
	if(idx==0){
		$("#userInfo2").tip({showCloseBtn:true,content: "您还未设置昵称，<span class='red'><a>立即设置</a></span>。",distanceX:480,arrowDistanceX:200});
	}	
	else if(idx==1){
		$("#picDemo").tip({showCloseBtn:true,arrowDirection:"left",arrowDistanceY:150,content: "图片过大会撑坏网页结构。对于大图可以强制设置width（不要设置height），这样可以对大图片等比例缩小。图片过大会撑坏网页结构。对于大图可以强制设置width（不要设置height），这样可以对大图片等比例缩小。"});
	}
	else if(idx==2){
		$("#picDemo2").tip({showCloseBtn:true,height:45,showArrow:false,width:400,content: "温馨提示：记账完成后，您可以到账单明细中查看记录。"});
	}
}
var myTip1;
function showTip4(){
		$("#userInfo3").tip({content: "您还未设置昵称，<span class='red'><a>立即设置</a></span>。",distanceX:400});
}
function closeTip4(){
	$("#userInfo3").hideTip();
}
var userEducationData={"list":[{"value":"专科","key":"专科"},{"value":"本科","key":"本科"},{"value":"硕士","key":"硕士"},{"value":"博士","key":"博士"}]};
function showTip5(){
	$("#searchBtn").tip({content: "",showCloseBtn:true,width:400,height:160});
	var tipId=$("#searchBtn").attr("tipId");
	var formContent=$("#"+tipId).find(".qui-tip-con");
	if(formContent.find("form").length==0){
		var $table=$('<form id="form1" method="post" showOnMouseOver="false">'+
			'<table class="detailFormTable" style="width:100%">'+
			'<tr><td width="80" class="ali03">姓名：</td><td><input type="text" id="inputa1" class="validate[required] float_left"/><span class="star float_left">*</span><div class="validation_info"></div><div class="clear"></div></td></tr>'+
			'<tr><td class="ali03">学历：</td><td><select id="inputa2" class="validate[required] float_left" prompt="请选择" ></select><span class="star float_left">*</span><div class="validation_info"></div><div class="clear"></div></td></tr>	'+
			'<tr><td class="ali03">入职时间：</td><td><input type="text" id="inputa3" class="date validate[required] float_left"/><span class="star float_left">*</span><div class="validation_info"></div><div class="clear"></div></td></tr>	'+
			'<tr><td colspan="2" class="ali01"><div style="padding-left:100px;"><input type="button" value="查询" id="inputa4" onclick=validateForm("#form1")>&nbsp;<input type="button" value="取消" id="inputa5" onclick="cancelSearch()"/></div></td></tr>'+
		'</table></form>')
		
		$("#"+tipId).find(".qui-tip-con").append($table);
		$table.find("#inputa1").render();
		$table.find("#inputa2").data("data",userEducationData);
		$table.find("#inputa2").render();
		$table.find("#inputa3").render();
		$table.find("#inputa4").render();
		$table.find("#inputa5").render();
		
		$table.validationEngine({showOnMouseOver:false});
	}
}
function cancelSearch(){
	$("#searchBtn").hideTip();
}
function validateForm(containerId){
    var valid = $(containerId).validationEngine({returnIsValid: true,showOnMouseOver:false});
	if(valid == true){
		top.Dialog.alert('进行提交处理，完成后刷新数据。',function(){
			$("#searchBtn").hideTip();
		});
	}else{
	    //top.Dialog.alert('表单填写不正确，请按要求填写！');
	} 
}		
function showTip6(){
		$("#closeEventDemo").tip({content: "您还未设置昵称，<span class='red'><a>立即设置</a></span>。",showCloseBtn:true,onClose:function(){
			top.Dialog.alert("触发关闭事件");
		}});
}		
</script>
</body>
</html>