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

<!--ueEditor编辑器start-->
<script>
 window.UEDITOR_HOME_URL = "<%=path%>/libs/thirdparty/ueditor/";
</script>
<script type="text/javascript" charset="utf-8" src="<%=path%>/libs/thirdparty/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=path%>/libs/thirdparty/ueditor/ueditor.all.js"></script>

<!--ueEditor编辑器start-->
</head>
<body>
<div paneltitle="表单标题" class="box2" boxtype="box2"><div id="box_topcenter" class="box_topcenter"><div class="box_topleft"><div class="box_topright"><div class="title"><span>表单标题</span></div><div class="boxSubTitle"></div><div class="clear"></div></div></div></div><div class="box_middlecenter"><div class="box_middleleft"><div class="box_middleright"><div class="boxContent" style="overflow: visible;">
<div class="padding_top5">
	<fieldset>
      	<legend>控件介绍</legend>
      	UEditor是百度web前端团队推出的一款开源富文本编辑器，由于它有着漂亮的外观，良好的用户体验和强大的功能，已经成为国内最受欢迎的编辑器。<br/>
      	框架中使用的editor_all.js简单做了修改，将z-index由999改为400，以免遮住下拉框选项（下拉框的z-index是500）,另外默认宽度由1000px改为了100%<br/>
      	在本框架的source目录下的“常用文档”目录有该控件的完整官方示例。
      </fieldset>
      <div class="height_15"></div>
      
      <fieldset>
      	<legend>示例</legend>
      <table class="tableStyle">
      	<tr>
      		<td width="100">下拉框</td>
      		<td>
      			<select><option>请选择</option><option>选项1</option><option>选项2</option><option>选项3</option><option>选项4</option><option>选项5</option></select>
      		</td>
      	</tr>
      	<tr>
      		<td>编辑器</td>
      		<td>
			     <!--style给定宽度可以影响编辑器的最终宽度-->
			    <script type="text/plain" id="myEditor">
			        <p>这里我可以写一些输入提示</p>
			    </script>
      		</td>
      	</tr>
      </table>
      
     
    <script type="text/javascript">
        // 自定义的编辑器配置项,此处定义的配置项将覆盖editor_config.js中的同名配置
        var editorOption = {
        };
        var editor_a = new baidu.editor.ui.Editor(editorOption);
        editor_a.render( 'myEditor' );
    </script>
      
      
      </fieldset>
      <div class="height_15"></div>
      
</div>
</div></div></div></div><div id="box_bottomcenter" class="box_bottomcenter"><div class="box_bottomleft"><div class="box_bottomright"></div></div></div></div>
     
</body>
</html>