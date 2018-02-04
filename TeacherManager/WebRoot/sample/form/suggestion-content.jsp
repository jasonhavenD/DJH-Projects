<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>自动完成的文本框</title>
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!-- 自动提示框start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/suggestion.js"></script>
<!-- 自动提示框end -->

<style>
.custom_suggestion_main{
	position:relative;
	height:30px;
	width:300px;
}
.custom_suggestion input{
	border-right:none!important;
	background-image:none;
	border-color:#cccccc!important;
	font-size:12px!important;
}
.custom_suggestion .focus{
	background-color:#FFFFE1!important;
	box-shadow:0 0 6px rgba(0, 0, 0, 0.2);
}
.complexAuto_arrow{
	position:absolute;
	left:180px;
	top:2px;
	z-index:5000;
}
.complexAuto_arrow a{
	width:22px;
	height:22px;
	background-image: url(<%=path%>/libs/icons/minArrow.gif);
	background-repeat: no-repeat;
	background-position:50% 50%;
	text-indent:-3000px;
	display:block;
}
.complexAuto_arrow a:hover{
	background-image: url(<%=path%>/libs/icons/minArrowHover.gif);
}
.complexAuto_Btn{
	border:0;
	width:50px;
	height:26px;
	background-image: url(<%=path%>/libs/images/demo/btn1.jpg);
	background-repeat: no-repeat;
	cursor:pointer;
	cursor:hand;
}
.complexAuto_BtnHover{
	background-image: url(<%=path%>/libs/images/demo/btn2.jpg)!important;
}
</style>
</head>
<body>
	<div class="custom_suggestion_main">
 	<table cellspacing="0" cellpadding="0" style="border-style:none;">
 		<tr>
 			<td style="border-style:none;padding:0;margin:0;"><div class="suggestion custom_suggestion" id="suggestion1" prompt="支持邮件全文搜索" suggestMode="remote" inputWidth="200" inputHeight="22" url="<%=path%>/form/getListBySimulate163Key.action"  matchName="userName"></div></td>
 			<td style="border-style:none;padding:0;margin:0;"><input type="button" class="complexAuto_Btn" keepDefaultStyle="true" id="complexAuto_Btn"/></td>
 		</tr>
 	</table>
 	<div  class="complexAuto_arrow"><a onclick="showSearchPanel()">箭头</a></div>
 	</div>
<div id="content" style="display:none;">
  	<img src="<%=path%>/libs/images/demo/3.jpg"/>
 </div>

<script type="text/javascript">
	function initComplete(){
		$("#complexAuto_Btn").hover(function(){
			$(this).addClass("complexAuto_BtnHover");
		},function(){
			$(this).removeClass("complexAuto_BtnHover");
		});
		//文本框处于焦点效果
		$("#suggestion1").find("input[type=text]").focus(function(){
			$(this).addClass("focus");
		});
		//文本框失去焦点效果
		$("#suggestion1").find("input[type=text]").blur(function(){
			$(this).removeClass("focus");
		});
		$("#complexAuto_Btn").click(function(){
			top.Dialog.alert("此处进行搜索"+$("#suggestion1").attr("relText")+"处理。" );
		})
		$("#suggestion1").bind("listSelect",function(e,obj){
			var msg = obj.relText.split(" ")[1];
			$("#suggestion1").find("input[type=text]").val(msg);
			$("#suggestion1").attr("relText",msg);
			top.Dialog.alert("此处进行搜索"+msg+"处理。" );
		})
		
    }
    function showSearchPanel(){
    	top.Dialog.open({InnerHtml: $("#content").html(),Title:"高级搜索",Style:"simple",Modal:false,Width:340,Height:310,Top:60,Left:20});
    }
</script>

</body>
</html>