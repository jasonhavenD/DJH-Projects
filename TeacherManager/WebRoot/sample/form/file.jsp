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

<!-- 上传文件列表start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/upload/fileUpload.js"></script>
<!-- 上传文件列表end -->
</head>
<body>
  <div class="box1" panelWidth="800">
  
  <fieldset>
  	<legend>1、基本示例</legend>
	<p>当载入文件后，鼠标移入控件上默认会有信息提示显示文件路径。如果不需显示信息提示，设置其showInfo属性为false。</p>
	<table class="tableStyle" formMode="transparent">
		<tr>
			<td width="10%">上传文件：</td>
			<td>
				<input type="file"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="提交"/>
			</td>
		</tr>
	</table>
  </fieldset>
  <div class="height_15"></div>
  
   <fieldset>
  	<legend>2、自定义宽度</legend>
	<table class="tableStyle" formMode="transparent">
		<tr>
			<td width="10%">上传文件：</td>
			<td>
				<input type="file" fileWidth="300"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="提交"/>
			</td>
		</tr>
	</table>
  </fieldset>
  <div class="height_15"></div>
  
 <fieldset>
  	<legend>3、表单重置</legend>
  	<p>当启用了showInfo显示提示文本后，如果点击reset按钮重置表单，上传控件文本框内容被重置，但是提示文本却没有消失。解决办法如下：</p>
	<form id="form-2">
	<table class="tableStyle" formMode="transparent">
		<tr>
			<td width="10%">文本框：</td>
			<td>
				<input type="text"/>
			</td>
		</tr>
		<tr>
			<td width="10%">上传文件：</td>
			<td>
				<input name="fileData[0]" type="file" id="file-3"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="提交"/>
				<input type="button" value="重置" onclick="resetForm('form-2')"/>
			</td>
		</tr>
	</table>
	</form>
  </fieldset>
  <div class="height_15"></div>
  
   <fieldset>
  	<legend>4、综合示例（多文件上传+动态生成）</legend>
  	 <div class="red">此示例由后台支持</div>
	 <form action="<%=path%>/upLoadFile.action?catalogId=3b7cf33f-d24c-434f-b081-a4f8f2f132be" id="form-3" enctype="multipart/form-data" method="post">
	 <input type="hidden" name="isSync" value="1"/> 
	 <table id="mytable">
	  <tr>
			<td>上传附件：</td>
			<td width="200"><input type="file" name="fileData"/></td>
			<td>附件描述：</td>
			<td width="200"><input type="text"/></td>
			<td><input type="button" value="点击新增" onclick="addNewRow()"/></td>
		</tr>
		<tr>
			<td colspan="5" class="ali02">
			<input type="submit" id="batButton" value="提交"/>
			<input type="button" value="重置" onclick="resetForm('form-3')"/>
			</td>
		</tr>
	  </table>
	  </form>
	 <div class="font_bold">上传的文件列表</div>
	  <div id="fileList" class="padding_top10"></div>
	  </fieldset>
	  <div class="height_15"></div>
  
   <fieldset>
  	<legend>5、浏览器原始上传控件</legend>
	 <input type="file" keepDefaultStyle="true"/>
  </fieldset>
  <div class="height_15"></div>
  


  </div>
<script type="text/javascript">
	function initComplete(){
		//初始化文件列表
		var catalogId = '3b7cf33f-d24c-434f-b081-a4f8f2f132be';
		$.fileUpload.addUploadListRead({
			fileListContainer: "fileList",
			listUrl:"<%=path%>/form/listByKind.action",
			catalogId:"dcm",
			kind:"template",
			catalogId: catalogId,
			downloadUrl:"<%=path%>/form/download.action?id=",
			fileNameWidth:300,
			showInfo:false
		});
	};
	
	function addNewRow(){
		//创建上传控件
		var $file=$('<input type="file" name="fileData" />');
		//创建文本框
		var $input=$('<input type="text"/>');
		//创建按钮
		var $delBtn=$('<input type="button" value="删除该行" class="button"/>')
		//创建表格行
		var $tr=$("<tr><td>上传附件：</td><td></td><td>附件描述：</td><td></td><td></td></tr>");
		$tr.find("td").eq(1).append($file);
		$tr.find("td").eq(3).append($input);
		$tr.find("td").eq(4).append($delBtn);
		$("#mytable").find("tr").last().before($tr); 
		
		//渲染
		$file.render();
		$input.render();
		$delBtn.render();
		
		$delBtn.click(function(){
			//将所在的行删除
			$(this).parents("tr").remove()
		})
	}
		
	function resetForm(formId){
			//先手动清空表单
			$("#"+formId)[0].reset();
			//将上传框的title置空
			$("#"+formId).find("input:file").attr("title"," ");
			//让新title生效
			addTooltip($("#"+formId).find("input:file")[0]);
	}
	
	$(function(){
		//$("#mytable").mask("为防止随意上传大文件，此示例在演示版中禁用",0,false,"#ffffff");
	})
</script>
</body>
</html>