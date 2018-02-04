<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>文件上传</title>
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!-- 异步上传控件start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/upload/fileUpload.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/form/upload/handlers.js"></script>
<!-- 异步上传控件end -->

</head>
<body>
 <div class="box1" panelWidth="800">
  
  <fieldset>
  	<legend>1、用于新增</legend>
  	 <div class="red">此示例由后台支持</div>
		<p>默认文件类型无限制，大小限制1G</p>
	<table class="tableStyle" formMode="transparent" id="upload1">
		<tr>
			<td width="10%">上传文件：</td>
			<td>
				<span id="uploadBtn1"></span>
				<div id="uploadList1"></div>
				<!--下面的全部删除按钮是可选的，可以不加-->
				<div id="uploadDeleteAll1" style="display:none;"></div>
			</td>
		</tr>
	</table>
  </fieldset>
  <div class="height_15"></div>
  
  <fieldset>
  	<legend>2、用于编辑时</legend>
  	 <div class="red">此示例由后台支持</div>
	<table class="tableStyle" formMode="transparent" id="upload2">
		<tr>
			<td width="10%">上传文件：</td>
			<td>
				<span id="uploadBtn2"></span>
				<div id="uploadList2"></div>
			</td>
		</tr>
	</table>
  </fieldset>
  <div class="height_15"></div> 
  
  <fieldset>
  	<legend>3、限制文件类型、大小</legend>
  	 <div class="red">此示例由后台支持</div>
  	<p>在本实例中，仅允许上传图片，且大小不超过100k</p>
	<table class="tableStyle" formMode="transparent" >
		<tr>
			<td width="10%">上传文件：</td>
			<td>
				<span id="uploadBtn3"></span>
				<div id="uploadList3"></div>
			</td>
		</tr>
	</table>
  </fieldset> 
    <div class="height_15"></div>
    
    
    <fieldset>
  	<legend>4、动态生成上传控件</legend>
  	 <div class="red">此示例由后台支持</div>
	<input type="button" value="点击生成上传控件" id="testBtn"/>
  </fieldset>


  </div>


<script type="text/javascript">

	var upload1;
	var catalogId1;
	
	var upload2;
	//这里的值取的是已经上传有附件的catalogId
	var catalogId2 = "3b7cf33f-d24c-434f-b081-a4f8f2f132be";
	
	var upload3;
	var catalogId3;
	function initComplete(){
	   //生成catalogId
	    catalogId1 = $.fileUpload.generateCatalogId("<%=path%>/form/generateCatalogId.action");
		//初始化上传控件
		upload1 = $.fileUpload.start({
			contextPath: "<%=path%>",
			buttonContainer: "uploadBtn1",
			fileListContainer: "uploadList1",
			deleteContainer: "uploadDeleteAll1",
			moduleId : 'dcm',
			kind : 'template',
			catalogId: catalogId1,
			uploadUrl:"/form/upLoadFile.action",
			deleteUrl:"/form/deleteFile?id=",
			deleteAllUrl:"/form/deleteByKind.action",
			fileNameWidth:240
		});
		
		
		 //第二个上传控件
		upload2 = $.fileUpload.start({
			contextPath: "<%=path%>",
			buttonContainer: "uploadBtn2",
			fileListContainer: "uploadList2",
			moduleId : 'dcm',
			kind : 'template',
			catalogId: catalogId2,
			uploadUrl:"/form/upLoadFile.action",
			deleteUrl:"/form/deleteFile.action?id=",
			downloadUrl:"/form/download.action?id=",
			listUrl:"/form/listByKind.action",
			editMode:true
		});
		
		
		 //第三个上传控件
	    catalogId3 = $.fileUpload.generateCatalogId("<%=path%>/form/generateCatalogId.action");
		upload3 = $.fileUpload.start({
			contextPath: "<%=path%>",
			buttonContainer: "uploadBtn3",
			fileListContainer: "uploadList3",
			moduleId : 'images',
			kind : 'images',
			catalogId: catalogId3,
			uploadUrl:"/form/upLoadFile.action",
			deleteUrl:"/form/deleteFile?id=",
			downloadUrl:"/form/download.action?id=",
			fileSize: 100,
			fileTypes: '*.jpg; *.gif; *.png; *.jpeg; *.bmp'
		});
	};
	
	//动态生成上传控件
	$(function(){
		//$("#upload1").mask("为防止随意上传大文件，此示例在演示版中禁用",0,false,"#ffffff");
		//$("#upload2").mask("为防止随意上传大文件，此示例在演示版中禁用",0,false,"#ffffff");
		
		
		$("#testBtn").click(function(){
			var $fileUpload=$('<span id="uploadBtn4"></span><div id="uploadList4"></div></div>');
			$(this).after($fileUpload);
			$(this).after('<br/><br/>');
			var upload4;
   			var catalogId4;
   			 catalogId4 = $.fileUpload.generateCatalogId("<%=path%>/form/generateCatalogId.action");
			upload4 = $.fileUpload.start({
				contextPath: "<%=path%>",
				buttonContainer: "uploadBtn4",
				fileListContainer: "uploadList4",
				moduleId : 'dcm',
				kind : 'template',
				catalogId: catalogId4,
				uploadUrl:"/form/upLoadFile.action",
				deleteUrl:"/form/deleteFile.action?id="
			});
		})
	})


</script>

</body>
</html>