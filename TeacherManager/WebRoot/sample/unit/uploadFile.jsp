<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>导入文件</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
  	<form action='<%=path%>/importData.action' target="frmright"  enctype='multipart/form-data' method='post' id='uplodFileForm'>
  	<input type="hidden" name="type" value="<%=request.getParameter("type") %>"/>
  	<div class="padding_top20 padding_left25">
  	<table>
  		<tr>
  			<td><input type='file' id='userDataFile' name='userDataFile' showInfo="false"/></td>
  			<td>
  			<button type="button" onclick="importHandler()"><span class="icon_xls">导入</span></button>
  			</td>
  		</tr>
  		<tr>
  			<td colspan="2" class="padding_top5">说明：导入的excel需要遵循规定的格式</td>
  		</tr>
  		<tr>
  			<td colspan="2"><a href="<%=path%>/libs/images/demo/info.xls" class="red underline">点击这里</a>下载导入的excel数据模板</td>
  		</tr>
  	</table>
  	</div>
	</form>
	<script>
	function importHandler(){
		if($("#userDataFile").val()==""){
			top.Dialog.alert("请选择Excel文件");
		}
		else{
			$("#uplodFileForm")[0].submit();
		}
	}
	</script>
  </body>
</html>
