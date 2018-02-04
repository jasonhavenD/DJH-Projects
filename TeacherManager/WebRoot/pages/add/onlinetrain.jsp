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
	<form id="scrollContent" style="overflow-x:hidden;" action="OnlinetrainAction_addRow" method="post" target="frmright">
		<div class="box1"  id="formContent" whiteBg="true">
			<table class="tableStyle" formMode="transparent">
				<tr>
					<td width="200">培训编号：</td>
					<td><input type="text" name="addJson.trainno"   class="validate[required]"/></td>
				</tr>
				<tr>
					<td width="200">培训名称：</td>
					<td><input type="text" name="addJson.trainname"  class="validate[required]"  /><span class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">培训学时：</td>
					<td><input type="text" name="addJson.period"  class="validate[required]"  /><span class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">开始时间：</td>
					<td><input type="date" name="addJson.starttime"  class="validate[required]"  /><span class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">结束时间：</td>
					<td><input type="date" name="addJson.endtime"  class="validate[required]"  /><span class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">截止状态：</td>
					<td>
					
					<select id="offstatus" name="addJson.offstatus"  class="validate[required]" >
  						<option value ="0" selected="selected">进行中</option>
  						<option value ="1">已截止</option>
					</select>
					<span class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">备注：</td>
					<td><input type="text" name="addJson.note"  /></td>
				</tr>
				<tr>
				<td colspan="2"><input  type="submit" value="提交" /> 
				<input type="button"  value="取消" onclick="top.Dialog.close()" /></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>
<!-- 异步提交start -->
<script type="text/javascript">
	function initComplete() {
		//初始化数据
		//表单提交
		//检查合法性
	}
	
	//重置
	function closeWin() {
		//关闭窗口
		top.Dialog.close();
	}
</script>
<!-- 异步提交end -->