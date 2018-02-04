<%@page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加</title>
<!--框架必需start-->
<script type="text/javascript" src="../../../libs/js/jquery.js"></script>
<script type="text/javascript" src="../../../libs/js/language/cn.js"></script>
<script type="text/javascript" src="../../../libs/js/framework.js"></script>
<link href="../../../libs/css/import_basic.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" type="text/css" id="skin" prePath="../../../" />
<link rel="stylesheet" type="text/css" id="customSkin" />
<!--框架必需end-->

<!-- 日期控件start -->
<script type="text/javascript"
	src="../../../libs/js/form/datePicker/WdatePicker.js"></script>
<!-- 日期控件end -->

<!-- 表单验证start -->
<script src="../../../libs/js/form/validationRule.js"
	type="text/javascript"></script>
<script src="../../../libs/js/form/validation.js" type="text/javascript"></script>
<!-- 表单验证end -->

<!-- 表单异步提交start -->
<script src="../../../libs/js/form/form.js" type="text/javascript"></script>
<!-- 表单异步提交end -->
</head>


<body>
	<form id="scrollContent" style="overflow-x:hidden;" action="#"
		method="post" target="frmright">
		<div class="box1" id="formContent" whiteBg="true">
			<table class="tableStyle" formMode="transparent">
				<tr>
					<td width="200">培训编号：</td>
					<td><input id="trainno" type="text" class="validate[required]" /></td>
				</tr>
				<tr>
					<td width="200">培训名称：</td>
					<td><input id="trainname" type="text"
						class="validate[required]" /><span class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">培训学时：</td>
					<td><input id="period" type="text" class="validate[required]"
						clearable="true" /><span class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">开始时间：</td>
					<td><input id="starttime" type="date"
						class="validate[required]" /><span class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">结束时间：</td>
					<td><input id="endtime" type="date" class="validate[required]" /><span
						class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">截止状态：</td>
					<td><input id="offstatus" type="text" inputMode="numberOnly"
						class="validate[required]" /><span class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">备注：</td>
					<td><textarea id="note" type="text" clearable="true">
						</textarea></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>
<!-- 异步提交start -->
<script type="text/javascript">
	function disableForm() {
		$("#formContent").mask(null, 0, false, "#fff");
	}

	/* 页面加载完成，绑定事件 */
	$(document).ready(function() {
		$(".tableStyle").render();
	});
	function initComplete() {
		var trainno = getQueryString("trainno");
		var trainnos = {
			"trainnos" : trainno
		};
		//初始化数据
		$.ajax({
			type : "post",
			url : "OnlinetrainAction_getOne",
			dataType : "json",//设置需要返回的数据类型
			data : trainnos,
			success : function(data) {
				setUsers(data);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("出错了！");
			}
		});
		$(".box1").render();
		disableForm();
	}

	function getQueryString(name) { //输入参数名称
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); //根据参数格式，正则表达式解析参数
		var r = window.location.search.substr(1).match(reg);
		if (r != null)
			return unescape(r[2]);
		return null; //返回参数值
	}

	function setUsers(data) {
		$("#trainno").attr("value", data.trainno);
		$("#trainname").attr("value", data.trainname);
		$("#period").attr("value", data.period);
		$("#starttime").attr("value", data.starttime);
		$("#endtime").attr("value", data.endtime);
		$("#offstatus").attr("value", data.offstatus);
		$("#note").attr("value", data.note);
	}
</script>
<!-- 异步提交end -->