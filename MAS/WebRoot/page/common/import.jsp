<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>导入</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Styles/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Styles/admin-all.css" />
    <link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/other.css" />
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/jquery-1.7.2.js">
		</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/jquery-ui-1.8.22.custom.min.js">
		</script>
 <script type="text/javascript">
 function importfile(){
 var p=document.getElementById("attachment").value; 
if(p=="")
 {
 	alert("请先选择文件");
 }
 else
 {
 document.getElementById("form1").submit();
 
 }
 }
 
 
 </script>
  
  </head>
<body  onload="opener.location.reload()">
	
	<div>
		<form action="upDown_uploadFile.action?importName=<s:property value="importName"/>" id="form1" enctype="multipart/form-data" method="post">
        	
         <br /><br />
         <span>导入文件</span>
         <input type="file" id="attachment" name="attachment" size="10" />
         
         <input type="button" value="导入" onclick="importfile();" />
        
         <input type="reset" value="取消" id="cancel" />
        </form>
    </div>
	
</body>
</html>
