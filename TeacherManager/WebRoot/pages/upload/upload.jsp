<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
<!--框架必需start-->
<script type="text/javascript" src="../../libs/js/jquery.js"></script>
<script type="text/javascript" src="../../libs/js/language/cn.js"></script>
<script type="text/javascript" src="../../libs/js/framework.js"></script>
<link href="../../libs/css/import_basic.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" type="text/css" id="skin" prePath="../../"
	scrollerY="false" />
<link rel="stylesheet" type="text/css" id="customSkin" />
<!--框架必需end-->

<!-- 日期选择框start -->
<script type="text/javascript"
	src="../../libs/js/form/ Picker/W Picker.js"></script>
<!-- 日期选择框end -->

<!--数字分页start-->
<script type="text/javascript" src="../../libs/js/nav/pageNumber.js"></script>
<!--数字分页end-->

<!-- 异步上传控件start -->
<script type="text/javascript"
	src="../../libs/js/form/upload/fileUpload.js"></script>
<script type="text/javascript"
	src="../../libs/js/form/upload/handlers.js"></script>
<!-- 异步上传控件end -->

<%--框架初始化 --%>
<script>
	var fixObjHeight = 135;
	function initComplete() {
		$("#searchPanel").bind("stateChange", function(e, state) {
			if (state == "hide") {
				fixObjHeight = 110;
			} else if (state == "show") {
				fixObjHeight = 135;
			}
			triggerCustomHeightSet();
		});
	}
	function customHeightSet(contentHeight) {
		$("#scrollContent").height(contentHeight - fixObjHeight);
	}
</script>

</head>
<body>
	<form action="UpDownFileAction_uploadFile" name="form1" method="post"
		enctype="multipart/form-data">
		<input type="file" name="formFile">
		<span style="color:red">（doc，pdf，xls）</span>
		<br/>
			<button>
				<span class="icon_import" onclick="submit()">上传资料</span>
			</button>
	</form>

	<%-- <a href="UpDownFileAction_downloadFile?downLoadFile=aaa.txt">aaa.txt</a>
	<br/>
	<a href="UpDownFileAction_downloadFile?downLoadFile=测试.txt">测试.txt</a>
	<br/>
	<a href="UpDownFileAction_downloadFile?downLoadFile=bbb.docx" >bbb.docx</a>
	--%>
</body>
</html>
<script type="text/javascript">
	function submit() {
		$(".form1").submit(); //提交
	}
</script>
