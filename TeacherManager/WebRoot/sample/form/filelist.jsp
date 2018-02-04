<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>文件列表查看</title>
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
  	<legend>1、只读</legend>
	 <div class="red">此示例由后台支持</div>
	<table class="tableStyle" formMode="transparent">
		<tr>
			<td width="10%">文件列表：</td>
			<td>
				<div id="fileList"></div>
			</td>
		</tr>
	</table>
  </fieldset> 
    <div class="height_15"></div>
    
    <fieldset>
  	<legend>2、可删除并自定义宽度</legend>
	 <div class="red">此示例由后台支持</div>
	<table class="tableStyle" formMode="transparent" id="list2">
		<tr>
			<td width="10%">文件列表：</td>
			<td>
				<div id="fileList2"></div>
			</td>
		</tr>
	</table>
  </fieldset> 

  </div>


<script type="text/javascript">
	var catalogId = '3b7cf33f-d24c-434f-b081-a4f8f2f132be';
	function initComplete(){
		$.fileUpload.addUploadListRead({
			fileListContainer: "fileList",
			listUrl:"<%=path%>/form/listByKind.action",
			catalogId:catalogId,
			kind:"template",
			downloadUrl:"<%=path%>/form/download.action?id="
		});
		
		$.fileUpload.addUploadListRead({
			fileListContainer: "fileList2",
			listUrl:"<%=path%>/form/listByKind.action",
			catalogId:catalogId,
			kind:"template",
			downloadUrl:"<%=path%>/form/download.action?id=",
			deleteUrl:"<%=path%>/form/deleteFile.action?id=",
			fileNameWidth:300
		});
	};
	$(function(){
		//$("#list2").mask("为保证数据的完整性，此示例在演示版中禁用",0,false,"#ffffff");
	})
	
</script>

</body>
</html>