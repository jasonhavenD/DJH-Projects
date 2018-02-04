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
		action="TeacherInfoAction_addRow" method="post" target="frmright">
		<div class="box1" id="formContent" whiteBg="true">
			<table class="tableStyle" formMode="transparent">
				<tr>
					<td width="200">工号：</td>
					<td><input type="text" id="tno" name="addJson.tno"
						class="validate[required]" /></td>
				</tr>
				<tr>
					<td width="200">姓名：</td>
					<td><input type="text" id="tname" name="addJson.tname"
						class="validate[required]" /><span class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">类型：</td>
					<td>
					<select id="type"  name="addJson.type" class="validate[required]" >
  						<option value ="普通用户" selected="selected">普通用户</option>
  						<option value ="管理员">管理员</option>
					</select>
					<span class="star">*</span> 
					</td>
				</tr>
				<tr>
					<td width="200">密码：</td>
					<td><input type="text"  id="password" name="addJson.password"
						class="validate[required]" /><span class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">手机号码：</td>
					<td><input type="text" id="phone"  name="addJson.phone"
						class="validate[required]" /><span class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">电子邮件：</td>
					<td><input type="text" id="mail"  name="addJson.mail"
						class="validate[required]" /><span class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">工作单位：</td>
					<td>
					
					<select id="tunit"  name="addJson.tunit" class="validate[required]" >
  						<option value ="园艺学院" selected="selected">园艺学院</option>
  						<option value ="动物医学院">动物医学院</option>
  						<option value ="风景园林艺术学院">风景园林艺术学院</option>
  						<option value ="水利与建筑工程学院(水利水电科学研究院）">水利与建筑工程学院(水利水电科学研究院）</option>
  						<option value ="农学院(农业科学院）">农学院(农业科学院）</option>
  						<option value ="植物保护学院">植物保护学院</option>
  						<option value ="动物医学院">动物医学院</option>
  						<option value ="林学院（林业科学研究院）">林学院（林业科学研究院）</option>
  						<option value ="资源环境学院">资源环境学院</option>
  						<option value ="机械与电子工程学院">机械与电子工程学院</option>
  						<option value ="信息工程学院">信息工程学院</option>
  						<option value ="食品科学与工程学院">食品科学与工程学院</option>
  						<option value ="葡萄酒学院">葡萄酒学院</option>
  						<option value ="生命科学学院">生命科学学院</option>
  						<option value ="理学院">理学院</option>
  						<option value ="化学与药学院">化学与药学院</option>
  						<option value ="经济管理学院">经济管理学院</option>
  						<option value ="人文社会发展学院">人文社会发展学院</option>
  						<option value ="马克思主义学院">马克思主义学院</option>
  						<option value ="外语系">外语系</option>
  						<option value ="创新实验学院">创新实验学院</option>
  						<option value ="国际学院">国际学院</option>
  						<option value ="体育部成人教育(继续教育)学院">体育部成人教育(继续教育)学院</option>
  						<option value ="水土保持研究所">水土保持研究所</option>
					</select>
						
					<span class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">性别：</td>
					<td>
					<input type="radio" id="gender-1" name="addJson.gender" value="男" class="hand"  checked />
					<label for="gender-1" class="hand">男</label>
					<input type="radio" id="gender-2" name="addJson.gender" value="女" class="hand" />
					<label for="gender-2" class="hand">女</label>
					
					</td>
				</tr>
				<tr>
					<td width="200">出生日期：</td>
					<td><input type="date" id="birthday"  name="addJson.birthday"
						inputMode="numberOnly" class="validate[required]" /><span
						class="star">*</span></td>
				</tr>
				<tr>
					<td width="200">学历：</td>
					<td>
					
					<select id="education" name="addJson.education">
  						<option value ="本科" selected="selected">本科</option>
  						<option value ="硕士研究生">硕士研究生</option>
  						<option value ="博士研究生">博士研究生</option>
  					</select>
					</td>
				</tr>
				<tr>
					<td width="200">学位：</td>
					<td>
					<select id="degree" name="addJson.degree">
  						<option value ="学士" selected="selected">学士</option>
  						<option value ="硕士">硕士</option>
  						<option value ="博士">博士</option>
  					</select>
					</td>
				</tr>
				<tr>
					<td width="200">职称：</td>
					<td>
					<select id="rank" name="addJson.rank" >
  						<option value ="辅导员" selected="selected">辅导员</option>
  						<option value ="助教">助教</option>
  						<option value ="讲师">讲师</option>
  						<option value ="副教授">副教授</option>
  						<option value ="教授">教授</option>
  					</select>					
					<!-- <input type="text"  id="rank" name="addJson.rank" /> -->
					</td>
				</tr>
				<tr>
					<td width="200">毕业院校：</td>
					<td><input type="text"  id="graduateuniversity" name="addJson.graduateuniversity" /></td>
				</tr>

				<tr>
					<td width="200">状态：</td>
					<td><input type="text" id="loginstatus"  name="addJson.loginstatus" readonly="readonly" /></td>
				</tr>
				<tr>
					<td width="200">备注：</td>
					<td><textarea id="note" name="addJson.note"></textarea>
					</td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="提交" /> <input
						type="button" value="取消" onclick="top.Dialog.close()" /></td>
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