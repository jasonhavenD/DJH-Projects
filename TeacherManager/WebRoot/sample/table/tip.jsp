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
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/" scrollerY="false"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!--数字分页start-->
<script type="text/javascript" src="<%=path%>/libs/js/nav/pageNumber.js"></script>
<!--数字分页end-->
</head>
<script>
function initComplete(){
	$(".cell_card").each(function(){
				var tableStr='<table>'+
								'<tr>'+
									'<td>性别：</td>'+
									'<td>男</td>'+
								'</tr>'+
								'<tr>'+
									'<td>爱好：</td>'+
									'<td>唱歌</td>'+
								'</tr>'+
								'<tr>'+
									'<td>学历：</td>'+
									'<td>本科</td>'+
								'</tr>'+
							'</table>'
        		$(this).tip({"arrowDirection":"left","auto":true,arrowDistanceY:12,content:tableStr});
        		
        		$(this).hover(function(){
        			$(this).addClass("cell_card_over");
        		},function(){
        			$(this).removeClass("cell_card_over");
        		})
        	})
}

var fixObjHeight=40;
function customHeightSet(contentHeight,contentWidth){
	var windowWidth=document.documentElement.clientWidth;
	$("#scrollContent").height(contentHeight-fixObjHeight);
	$("#scrollContent").width(contentWidth-4);
}
</script>
<body>
<div id="scrollContent">
	<table class="tableStyle" mode="list">
		<tr>
			<th width="20%">姓名</th>
			<th width="20%">工作</th>
			<th width="20%">联系方式</th>
			<th width="20%">住址</th>
			<th width="20%">操作</th>
		</tr>
		<tr>
			<td>
			<div style="width:80px;float:left;padding:4px 0 0 2px;">张小三</div>
			<div style="float:left;"><span class="cell_card"></span></div>
			<div class="clear"></div>
			</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>
			<div style="width:80px;float:left;padding:4px 0 0 2px;">张小三</div>
			<div style="float:left;"><span class="cell_card"></span></div>
			<div class="clear"></div>
			</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>
			<div style="width:80px;float:left;padding:4px 0 0 2px;">张小三</div>
			<div style="float:left;"><span class="cell_card"></span></div>
			<div class="clear"></div>
			</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>
			<div style="width:80px;float:left;padding:4px 0 0 2px;">张小三</div>
			<div style="float:left;"><span class="cell_card"></span></div>
			<div class="clear"></div>
			</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>
			<div style="width:80px;float:left;padding:4px 0 0 2px;">张小三</div>
			<div style="float:left;"><span class="cell_card"></span></div>
			<div class="clear"></div>
			</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>
			<div style="width:80px;float:left;padding:4px 0 0 2px;">张小三</div>
			<div style="float:left;"><span class="cell_card"></span></div>
			<div class="clear"></div>
			</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>
			<div style="width:80px;float:left;padding:4px 0 0 2px;">张小三</div>
			<div style="float:left;"><span class="cell_card"></span></div>
			<div class="clear"></div>
			</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>
			<div style="width:80px;float:left;padding:4px 0 0 2px;">张小三</div>
			<div style="float:left;"><span class="cell_card"></span></div>
			<div class="clear"></div>
			</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>
			<div style="width:80px;float:left;padding:4px 0 0 2px;">张小三</div>
			<div style="float:left;"><span class="cell_card"></span></div>
			<div class="clear"></div>
			</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>
			<div style="width:80px;float:left;padding:4px 0 0 2px;">张小三</div>
			<div style="float:left;"><span class="cell_card"></span></div>
			<div class="clear"></div>
			</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>
			<div style="width:80px;float:left;padding:4px 0 0 2px;">张小三</div>
			<div style="float:left;"><span class="cell_card"></span></div>
			<div class="clear"></div>
			</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>
			<div style="width:80px;float:left;padding:4px 0 0 2px;">张小三</div>
			<div style="float:left;"><span class="cell_card"></span></div>
			<div class="clear"></div>
			</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>
			<div style="width:80px;float:left;padding:4px 0 0 2px;">张小三</div>
			<div style="float:left;"><span class="cell_card"></span></div>
			<div class="clear"></div>
			</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>
			<div style="width:80px;float:left;padding:4px 0 0 2px;">张小三</div>
			<div style="float:left;"><span class="cell_card"></span></div>
			<div class="clear"></div>
			</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>
			<div style="width:80px;float:left;padding:4px 0 0 2px;">张小三</div>
			<div style="float:left;"><span class="cell_card"></span></div>
			<div class="clear"></div>
			</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		
		
	</table>
</div>


<div style="height:35px;">
	<div class="float_left padding5">
	</div>
	<div class="float_right padding5">
		<div class="pageNumber" total="200" showSelect="true" showInput="true" id="page-7"></div>
	</div>
	<div class="clear"></div>
</div>
</body>
</html>