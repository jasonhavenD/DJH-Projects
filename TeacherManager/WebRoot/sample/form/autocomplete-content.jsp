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

<!-- 自动完成框start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/autoComplete.js"></script>
<!-- 自动完成框end -->

<style>
.complexAuto_input{
	height:18px;
	border:solid 1px #ffffff;
	background-color:transparent;
	padding-left:5px;
}
.complexAuto_search a{
	width:25px;
	height:25px;
	background-image: url(<%=path%>/libs/icons/minArrow.gif);
	background-repeat: no-repeat;
	background-position:50% 50%;
	text-indent:-3000px;
	display:block;
}
.complexAuto_search a:hover{
	background-image: url(<%=path%>/libs/icons/minArrowHover.gif);
}
.complexAuto_search{
	border:solid 1px;
	border-color:#999999 #C9C9C9 #B5B5B5 #B5B5B5;
	background-color:#ffffff;
	margin-right:-1px;
	position:relative;
}
.complexAuto_search_focus{
	background-color:#FFFFE1!important;
	box-shadow:0 0 6px rgba(0, 0, 0, 0.2);
}
.complexAuto_mark{
	color:#cccccc;
	position:absolute;
	cursor:text;
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
<div class="height_10"></div>
 	<table cellspacing="0" cellpadding="0" style="border-style:none;" id="complexAuto">
      		<tr>
      		<td class="ali01" style="border-style:none;padding:0;margin:0;">
	      		<div class="complexAuto_search">
		      	<label class="complexAuto_mark" id="complexAuto_mark">&nbsp;支持邮件全文搜索</label>
		      	<table cellspacing="0" cellpadding="0" style="border-style:none;">
		      		<tr>
		      		<td class="ali01" style="border-style:none;padding:0;margin:0;"><input type="text" class="complexAuto_input" keepDefaultStyle="true" id="input-11"/></td>
		      		<td class="ali01" style="border-style:none;padding:0;margin:0;"><a class="complexAuto_arrow" onclick="showSearchPanel()">箭头</a></td>
		      		</tr>
		      	</table>
		      	</div>
      		</td>
      		<td class="ali01" style="border-style:none;padding:0;margin:0;"><input type="button" class="complexAuto_Btn" id="complexAuto_Btn"/></td>
      		</tr>
      	</table>
<div id="content" style="display:none;">
  	<img src="<%=path%>/libs/images/demo/3.jpg"/>
 </div>

<script type="text/javascript">
	function initComplete(){
		//综合示例
		//手动渲染自动完成框
		$('#input-11').AutoComplete({
			url: '<%=path%>/autoComplateAction.do?method=getListBySimulate163',
			matchName:"userName",
			inputWidth:200,
			boxWidth:230,
			onItemSelected: function(item){
				var msg = item.text();
				var value = msg.split(" ")[1];
				$('#input-11').val(value);
				top.Dialog.alert("此处进行搜索处理。" );
			}
		});
		//文本框处于焦点效果
		$("#input-11").focus(function(){
			$(this).parents(".complexAuto_search").addClass("complexAuto_search_focus");
			$("#complexAuto_mark").hide();
		});
		//文本框失去焦点效果
		$("#input-11").blur(function(){
			$(this).parents(".complexAuto_search").removeClass("complexAuto_search_focus");
			if($("#input-11").val()==""){
				$("#complexAuto_mark").show();
			}
			else{
				$("#complexAuto_mark").hide();
			}
		});
		//按钮移入移出效果
		$("#complexAuto_Btn").hover(function(){
			$(this).addClass("complexAuto_BtnHover");
		},function(){
			$(this).removeClass("complexAuto_BtnHover");
		});
		//水印点击隐藏
		$("#complexAuto_mark").click(function(){
			$("#input-11").focus();
		})
    }
    function showSearchPanel(){
    	top.Dialog.open({InnerHtml: $("#content").html(),Title:"高级搜索",Style:"simple",Modal:false,Width:340,Height:310,Top:70,Left:20});
    }
</script>

</body>
</html>