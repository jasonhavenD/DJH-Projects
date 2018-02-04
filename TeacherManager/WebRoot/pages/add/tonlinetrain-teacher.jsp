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
	<form id="scrollContent" style="overflow-x:hidden;" action="#"
		method="post" target="frmright"
		onkeydown="if(event.keyCode==13)return false">
		<div class="box1" id="formContent" whiteBg="true">
			<table class="tableStyle" formMode="transparent">
				<tr>
					<td width="400">工号：</td>
					<td><input id="tno" type="text" name="addJson.tno"
						class="valitext[required]" /></td>
				</tr>
				<tr>
					<td width="400">培训编号：</td>
					<td><input id="trainno" readonly="readonly" type="text"
						name="addJson.trainno" class="valitext[required]" /></td>
				</tr>
				<tr>
					<td width="400">姓名：</td>
					<td><input id="tname" type="text" readonly="readonly"
						name="addJson.tname" class="valitext[required]" /><span
						class="star">*</span></td>
				</tr>
				<tr>
					<td width="400">性别：</td>
					<td>
					<input type="radio" id="gender-1" name="addJson.gender" value="男" class="hand"  checked />
					<label for="gender-1" class="hand">男</label>
					<input type="radio" id="gender-2" name="addJson.gender" value="女" class="hand" />
					<label for="gender-2" class="hand">女</label>	
					</td>
				</tr>
				<tr>
					<td width="400">工作单位：</td>
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
					<span
						class="star">*</span></td>
				</tr>
				<tr>
					<td width="400">年龄：</td>
					<td><input id="age" type="text" readonly="readonly"
						name="addJson.age" class="valitext[required]" /><span
						class="star">*</span></td>
				</tr>
				<tr>
					<td width="400">学历：</td>
					<td>
					
					<select id="education" name="addJson.education">
  						<option value ="本科" selected="selected">本科</option>
  						<option value ="硕士研究生">硕士研究生</option>
  						<option value ="博士研究生">博士研究生</option>
  					</select>
					</td>
				</tr>
				<tr>
					<td width="400">学位：</td>
					<td>
					<select id="degree" name="addJson.degree">
  						<option value ="学士" selected="selected">学士</option>
  						<option value ="硕士">硕士</option>
  						<option value ="博士">博士</option>
  					</select>
					</td>
				</tr>
				<tr>
					<td width="400">职称：</td>
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
					<td width="400">学时：</td>
					<td><input id="period" type="text" readonly="readonly"
						name="addJson.period" class="valitext[required]" /><span
						class="star">*</span></td>
				</tr>
				<tr>
					<td width="400">审核人：</td>
					<td><input id="auditor" type="text" readonly="readonly"
						name="addJson.auditor" class="valitext[required]" /><span
						class="star">*</span></td>
				</tr>
				<tr>
					<td width="400">审核状态：</td>
					<td>
					<select id="checkstatus"  name="addJson.checkstatus" >
  						<option value ="0" selected="selected">待审核</option>
  						<option value ="1">已审核</option>
  					</select>
					</td>
				</tr>
				<tr>
					<td width="400">备注：</td>
					<td><textarea id="note" type="text" clearable="true"
							readonly="readonly" name="addJson.note"></textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" onclick="mysubmit()"
						value="提交" /><input type="button" value="取消" onclick="closeWin()" /></td>
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
		//绑定事件--teacherinfo
		$("#tno").change(function() {
			var tno = $("#tno").val();
			findByTno(tno);
		});
		$("#tno").keydown(function(e) {
			if (e.keyCode == 13) {
				var tno = $("#tno").val();
				findByTno(tno);
			}
		});
	});

	function findByTno(tno) {
		var tnos = {
			"tnos" : tno
		};
		//初始化数据
		$.ajax({
			type : "post",
			url : "TeacherInfoAction_getOne",
			dataType : "json",//设置需要返回的数据类型
			data : tnos,
			success : function(data) {
				setUsers(data);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("出错了！");
			}
		});
		$(".box1").render();
	}

	function findByTrainno(trainno) {
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
				setTrains(data);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("出错了！");
			}
		});
		$(".box1").render();
	}

	function setUsers(data) {
		$("#tname").val(data.tname);
		$("#gender").val(data.gender);
		$("#tunit").val(data.tunit);
		$("#age").val(data.age);
		$("#rank").val(data.rank);
		$("#education").val(data.education);
		$("#degree").val(data.degree);
	}

	function setTrains(data) {
		$("#period").val(data.period);
		$("#auditor").val(data.auditor);
		$("#checkstatus").val(data.checkstatus);
		$("#note").val(data.note);
	}

	function initComplete() {
		var trainno = getQueryString("trainno");
		$("#trainno").val(trainno);
		findByTrainno(trainno);
	}

	function getQueryString(name) { //输入参数名称
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); //根据参数格式，正则表达式解析参数
		var r = window.location.search.substr(1).match(reg);
		if (r != null)
			return unescape(r[2]);
		return null; //返回参数值
	}
	function closeWin() {
		//关闭窗口
		//top.Dialog.close();
		window.location.href = "../../pages/view/tonlinetrain-teacher.jsp?trainno="
				+ getQueryString("trainno");
	}
	
	function mysubmit() {
		//异步
		var addJson = {
			"addJson.tno" : $("#tno").val(),
			"addJson.trainno" : $("#trainno").val(),
			"addJson.tname" : $("#tname").val(),
			"addJson.gender" : $("#gender").val(),
			"addJson.tunit" : $("#tunit").val(),
			"addJson.age" : $("#age").val(),
			"addJson.rank" : $("#rank").val(),
			"addJson.education" : $("#education").val(),
			"addJson.degree" : $("#degree").val(),
			"addJson.period" : $("#period").val(),
			"addJson.auditor" : $("#auditor").val(),
			"addJson.checkstatus" : $("#checkstatus").val(),
			"addJson.note" : $("#note").val()
		}
		//初始化数据
		$.ajax({
			type : "post",
			url : "TonlinetrainAction_addRow",
			data : addJson,
			success : function(data) {
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
			}
		});
		refresh();
	}
	function refresh(){
		//刷新父窗口
		top.Dialog.alert("成功提交",function(){window.location.href = "../../pages/view/tonlinetrain-teacher.jsp?trainno="
			+ getQueryString("trainno")})
        diag.close();
	}
	
</script>
<!-- 异步提交end -->