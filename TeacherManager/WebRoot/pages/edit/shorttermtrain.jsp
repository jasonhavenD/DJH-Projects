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
	src="../../libs/js/form/textPicker/WtextPicker.js"></script>
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
		action="ShorttermtrainAction_editShorttermtrain" method="post" target="frmright">
		<div class="box1" id="formContent" whiteBg="true">
			<table class="tableStyle" formMode="transparent">
				<tr>
					<td width="200">培训编号：</td>
					<td><input id="trainno" type="text" name="shorttermtrainJson.trainno"
						class="valitext[required]" /></td>
				</tr>
				<tr>
					<td width="200">工号：</td>
					<td><input id="tno" type="text" name="shorttermtrainJson.tno"
						class="valitext[required]" /></td>
				</tr>

				<tr>
					<td width="200">姓名：</td>
					<td><input id="tname" type="text" name="shorttermtrainJson.tname"
						class="valitext[required]" /><span class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">工作单位：</td>
					<td><input id="tunit" type="text" name="shorttermtrainJson.tunit"
						class="valitext[required]" /><span class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">年龄：</td>
					<td><input id="age" type="text" name="shorttermtrainJson.age"
						class="valitext[required]" /><span class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">职称：</td>
					<td><input id="rank" type="text" name="shorttermtrainJson.rank"
						class="valitext[required]" /><span class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">学历：</td>
					<td><input id="education" type="text" name="shorttermtrainJson.education" 
						class="valitext[required]" /><span class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">学位：</td>
					<td><input id="degree" type="text" name="shorttermtrainJson.degree"
						class="valitext[required]" /><span class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">主题：</td>
					<td><input id="traintopic" type="text" name="shorttermtrainJson.traintopic"
						class="valitext[required]" /><span class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">地点：</td>
					<td><input id=trainaddr type="text" name="shorttermtrainJson.trainaddr"
						class="valitext[required]" /><span class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">学时：</td>
					<td><input id="period" type="text" name="shorttermtrainJson.period"
						class="valitext[required]" /><span class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">开始时间：</td>
					<td><input id="starttime" type="date" name="shorttermtrainJson.starttime"
						class="valitext[required]" /><span class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">结束时间：</td>
					<td><input id="endtime" type="date" name="shorttermtrainJson.endtime" 
					class="valitext[required]" /><span class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">备注：</td>
					<td><input id="note" type="text" clearable="true" name="shorttermtrainJson.note" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="提交" /> <input
						type="button" value="取消" onclick="closeWin()" /></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>
<!-- 异步提交start -->
<script type="text/javascript">
	/* 页面加载完成，绑定事件 */
	$(document).ready(function() {
		$(".tableStyle").render();
	});
	function initComplete() {
		//异步
		var rowIds = getQueryString("id");
		var rowIds = {
			"trainnos" : rowIds
		};
		//初始化数据
		$.ajax({
			type : "post",
			url : "ShorttermtrainAction_findById",
			dataType : "json",//设置需要返回的数据类型
			data : rowIds,
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
		$("#trainno").val(data.trainno);
		$("#tname").val(data.tname);
		$("#gender").val(data.gender);
		$("#tunit").val(data.tunit);
		$("#age").val(data.age);
		$("#rank").val(data.rank);
		$("#education").val(data.education);
		$("#degree").val(data.degree);
		$("#traintopic").val(data.traintopic);
		$("#trainaddr").val(data.trainaddr);
		$("#period").val(data.period);
		$("#starttime").val(data.starttime);
		$("#endtime").val(data.endtime);
		$("#note").val(data.note);
	}

	function closeWin() {
		//关闭窗口
		top.Dialog.close();
	}
</script>
<!-- 异步提交end -->