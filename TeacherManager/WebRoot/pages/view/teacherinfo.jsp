<%@page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加</title>
<!--框架必需start-->
<script type="text/javascript" src="../../libs/js/jquery.js"></script>
<script type="text/javascript" src="../../libs/js/language/cn.js"></script>
<script type="text/javascript" src="../../libs/js/framework.js"></script>
<link href="../../libs/css/import_basic.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" type="text/css" id="skin" prePath="../../" />
<link rel="stylesheet" type="text/css" id="customSkin" />
<!--框架必需end-->

<!-- 日期控件start -->
<script type="text/javascript"
	src="../../libs/js/form/datePicker/WdatePicker.js"></script>
<!-- 日期控件end -->

<!-- 表单验证start -->
<script src="../../libs/js/form/validationRule.js"
	type="text/javascript"></script>
<script src="../../libs/js/form/validation.js" type="text/javascript"></script>
<!-- 表单验证end -->

<!-- 表单异步提交start -->
<script src="../../libs/js/form/form.js" type="text/javascript"></script>
<!-- 表单异步提交end -->
</head>


<body>
	<form id="scrollContent" style="overflow-x:hidden;"
		action="#" method="post" target="frmright">
		<div class="box1" id="formContent" whiteBg="true">
			<table class="tableStyle" formMode="transparent">
				<tr>
					<td width="200">工号：</td>
					<td><input type="text" id="tno" name="editJson.tno"
						class="validate[required]" /></td>
				</tr>
				<tr>
					<td width="200">姓名：</td>
					<td><input type="text" id="tname" name="editJson.tname"
						class="validate[required]" /><span class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">类型：</td>
					<td><input type="text" id="type"  name="editJson.type"
						class="validate[required]" /><span class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">密码：</td>
					<td><input type="text"  id="password" name="editJson.password"
						class="validate[required]" /><span class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">手机号码：</td>
					<td><input type="text" id="phone"  name="editJson.phone"
						class="validate[required]" /><span class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">电子邮件：</td>
					<td><input type="text" id="mail"  name="editJson.mail"
						class="validate[required]" /><span class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">工作单位：</td>
					<td><input type="text" id="tunit"  name="editJson.tunit"
						class="validate[required]" /><span class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">性别：</td>
					<td><input type="text"  id="gender" name="editJson.gender"
						class="validate[required]" /><span class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">出生日期：</td>
					<td><input type="date" id="birthday"  name="editJson.birthday"
						inputMode="numberOnly" class="validate[required]" /><span
						class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">学历：</td>
					<td><input type="text"  id="education" name="editJson.education" /></td>
				</tr>
				<tr>
					<td width="200">学位：</td>
					<td><input type="text"  id="degree" name="editJson.degree" /></td>
				</tr>
				<tr>
					<td width="200">职称：</td>
					<td><input type="text"  id="rank" name="editJson.rank" /></td>
				</tr>
				<tr>
					<td width="200">毕业院校：</td>
					<td><input type="text"  id="graduateuniversity" name="editJson.graduateuniversity" /></td>
				</tr>

				<tr>
					<td width="200">状态：</td>
					<td><input type="text" id="loginstatus"  name="editJson.loginstatus" /></td>
				</tr>
				<tr>
					<td width="200">备注：</td>
					<td><textarea id="note" name="editJson.note"></textarea>
					</td>
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
		var tno = getQueryString("tno");
		var tno = {
			"tnos" : tno
		};
		//初始化数据
		$.ajax({
			type : "post",
			url : "TeacherInfoAction_getOne",
			dataType : "json",//设置需要返回的数据类型
			data : tno,
			success : function(data) {
				setUsers(data);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("出错了！");
			}
		});
		$(".box1").render();
	}

	function getQueryString(name) { //输入参数名称
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); //根据参数格式，正则表达式解析参数
		var r = window.location.search.substr(1).match(reg);
		if (r != null)
			return unescape(r[2]);
		return null; //返回参数值
	}
	
	function setUsers(data) {
		$("#tno").val(data.tno);
		$("#tname").val(data.tname);
		$("#type").val(data.type);
		$("#password").val(data.password);
		$("#phone").val(data.phone);
		$("#mail").val(data.mail);
		$("#tunit").val(data.tunit);
		$("#gender").val(data.gender);
		$("#birthday").val(data.birthday);
		$("#education").val(data.education);
		$("#degree").val(data.degree);
		$("#rank").val(data.rank);
		$("#graduateuniversity").val(data.graduateuniversity);
		$("#loginstatus").val(data.loginstatus);
		$("#note").val(data.note);
		disableForm();
	}

	function closeWin() {
		//关闭窗口
		top.Dialog.close();
	}
</script>
<!-- 异步提交end -->