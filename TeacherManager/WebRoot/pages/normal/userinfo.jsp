<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>个人信息</title>
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
</head>

<body>
	<div class="box1" panelWidth="650">
		<form method="post">
			<fieldset>
				<legend>用户基本信息</legend>

				<table class="tableStyle" formMode="transparent" footer="normal">
					<tr>
						<td width="15%">工号：</td>
						<td width="35%"><input id="tno" disabled type="text" /></td>
					</tr>
					<tr>
						<td width="15%">姓名：</td>
						<td width="35%"><input id="name" disabled type="text" /></td>
					</tr>
					<tr>
						<td width="15%">性别：</td>
						<td><input type="radio" id="radio-1" name="ra"
							value="radio-1" class="hand" checked /><label for="radio-1"
							class="hand">男</label> <input type="radio" id="radio-2" name="ra"
							value="radio-2" class="hand" /><label for="radio-2" class="hand">女</label></td>
					</tr>
					<tr>
						<td width="15%">工作单位：</td>
						<td width="35%"><input id="tunit" type="text" /></td>
						<tr />
						<tr>
				</table>
			</fieldset>
			<div class="height_15"></div>
			<fieldset>
				<legend>用户详细信息</legend>
				<table class="tableStyle" formMode="transparent" footer="normal">
					<tr>
						<td>出生日期：</td>
						<td><input id="birthday" type="text" class="date" /></td>
					</tr>
					<tr>
						<td>类型：</td>
						<td><input id="type" type="text" /></td>
					</tr>


					<tr>
						<td>职称：</td>
						<td><input id="rank" type="text" /></td>
					</tr>
					<tr>
						<td>学历：</td>
						<td><input id="education" type="text" /></td>
					</tr>
					<tr>
						<td>学位：</td>
						<td><input id="degree" type="text" /></td>

					</tr>
					<tr>
						<td width="15%">毕业学校：</td>
						<td width="35%"><input id="graduateuniversity" type="text" /></td>
					</tr>

				</table>
			</fieldset>
			<div class="height_15"></div>
			<fieldset>
				<legend>用户其他信息</legend>
				<table class="tableStyle" formMode="transparent" footer="normal">
					<tr>
						<td width="15%">电子邮箱：</td>
						<td width="35%"><input id="mail" type="text" /></td>
					</tr>
					<tr>
						<td>手机号码：</td>
						<td><input id="phone" type="text" /></td>
					</tr>
					<tr>
						<td>备注：</td>
						<td><textarea id="note" ></textarea></td>
					</tr>
				</table>
			</fieldset>
			<div class="height_5"></div>
			<div class="padding_top10">
				<table class="tableStyle" formMode="transparent">

				</table>
			</div>
		</form>
	</div>

	</div>
</body>

<script type="text/javascript">
	/* 页面加载完成，绑定事件 */
	$(document).ready(function() {
		showUserInfo();//执行ajax,显示个人信息
	});

	function showUserInfo() {
		$.ajax({
			type : "post",
			url : "TeacherInfoAction_getLoginUser",//需要用来处理ajax请求的action,add为处理的方法名，TeacherInfo为action名
			dataType : "json",//设置需要返回的数据类型
			success : function(data) {//回调
				//设置页面数据
				initData(data);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("出错了！");
			}
		});
	}

	function initData(data) {
		$("#tno").val(data.tno);
		$("#name").val(data.tname);
		var gender = data.gender;
		if (gender == "男") {
			$("#radio-1").attr("checked", "true");
		} else {
			$("#radio-2").attr("checked", "true");
		}
		$("#tunit").val(data.tunit);
		$("#graduateuniversity").val(data.graduateuniversity);
		$("#mail").val(data.mail);
		$("#phone").val(data.phone);
		$("#type").val(data.type);

		$("#rank").val(data.rank);
		$("#education").val(data.education);
		$("#degree").val(data.degree);
		$("#birthday").val(data.birthday);
		$("#note").val(data.note);

	}

</script>
</html>