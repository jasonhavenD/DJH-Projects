<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->


<!--拖拽组件start-->
<script type="text/javascript" src="<%=path%>/libs/js/drag/dragDrop.js"></script>
<!--拖拽组件end-->

<!--布局控件start-->
<script type="text/javascript" src="<%=path%>/libs/js/nav/layout.js"></script>
<!--布局控件end-->
<script type="text/javascript">
	function initComplete(){
		var layout=$("#layout1").layout({ leftWidth: 100,rightWidth:100,allowLeftCollapse:false,allowRightCollapse:false}); 
		
		 
		 $('.iconItem').find("img").each(function(){
		 	$(this)[0].ondragstart=function(){
			 	return false;
			 }
		 })
		 $('.iconItem').find("img").each(function(){
		 	var dragObj=$(this);
		 	var drag = $(this).dragDrop({  revert: true , receive: '#centerContent'});
            drag.bind('StartDrag', function ()
            {
                this.cursor ="url(<%=path%>/libs/images/formEle/cursor_wrong.cur),auto"
            });
            //当进入区域时
            drag.bind('DragEnter', function (receive, source, e)
            {
                var maxNum=$(receive).find("img").length;
                if(maxNum>9){
                	this.cursor ="url(<%=path%>/libs/images/formEle/cursor_wrong.cur),auto"
                }
                else{
                	 this.cursor ="url(<%=path%>/libs/images/formEle/cursor_right.cur),auto"
                }
               
            });
            //在区域移动
            drag.bind('DragOver', function (receive, source, e)
            {
               
               // $(receive).find(".message").html("在区域移动 " + e.pageX + ":" + e.pageY);
            });
            //离开区域
            drag.bind('DragLeave', function (receive, source, e)
            {
                 this.cursor ="url(<%=path%>/libs/images/formEle/cursor_wrong.cur),auto"
            });
            //在区域释放
            drag.bind('Drop', function (receive, source, e)
            {
                 
                 var maxNum=$(receive).find("img").length;
                 if(maxNum<10){
                	 var newObj=$('<img style="position:absolute;"/>')
	                 newObj.attr("src",dragObj.attr("src"));
	                 newObj.css({
	                 	"left":source.offset().left-$(".layout_content").width(),
	                 	"top":source.offset().top
	                 })
	                 $(receive).append(newObj);
	                 source.hide();
	                 if(dragObj.attr("removeable")=="true"){
	                 	dragObj.parent().remove();
	                 }
	                 
	                 newObj[0].ondragstart=function(){
					 	return false;
					 }
                }
            });
		 })
	}
</script>
<style>
.iconItem li{
	width:100px;
	height:80px;
	text-align:center;
}
</style>
</head>
<body>
	<div id="layout1">
        <div  position="left" style="" panelTitle="复制型">
        	<div class="layout_content">
        	<ul class="iconItem">
        		<li><img src="<%=path%>/libs/icons/png_64/01.png"/></li>
        		<li><img src="<%=path%>/libs/icons/png_64/02.png"/></li>
        		<li><img src="<%=path%>/libs/icons/png_64/03.png"/></li>
        		<li><img src="<%=path%>/libs/icons/png_64/04.png"/></li>
        		<li><img src="<%=path%>/libs/icons/png_64/05.png"/></li>
        		<li><img src="<%=path%>/libs/icons/png_64/06.png"/></li>
        	</ul>
        	
			</div>
        </div>
        <div position="center" id="centerContent">
        	提示：此区域设置了最多容纳10个图标。
        	
        </div>
        <div position="right" style="" panelTitle="移动型">
        	<ul class="iconItem">
        		<li><img src="<%=path%>/libs/icons/png_64/07.png" removeable="true"/></li>
        		<li><img src="<%=path%>/libs/icons/png_64/08.png" removeable="true"/></li>
        		<li><img src="<%=path%>/libs/icons/png_64/09.png" removeable="true"/></li>
        		<li><img src="<%=path%>/libs/icons/png_64/10.png" removeable="true"/></li>
        		<li><img src="<%=path%>/libs/icons/png_64/11.png" removeable="true"/></li>
        		<li><img src="<%=path%>/libs/icons/png_64/12.png" removeable="true"/></li>
        	</ul>
        </div>
    </div> 
</body>
</html>