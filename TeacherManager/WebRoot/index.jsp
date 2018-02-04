<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'index.jsp' starting page</title>
</head>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	/* 页面加载完成，绑定事件 */
	$(document).ready(function() {
		btn();//点击提交，执行ajax
	});

	/* 提交结果，执行ajax */
	function btn() {
		var $btn = $("input.btn");//获取按钮元素
		//给按钮绑定点击事件
		$btn.bind("click", function() {
			//alert("bing()_ok");
			$.ajax({
				type : "post",
				url : "TeacherInfo_add",//需要用来处理ajax请求的action,add为处理的方法名，TeacherInfo为action名
				dataType : "json",//设置需要返回的数据类型
				data : {//设置数据源
					tno : $("input[name=tno]").val(),
					name : $("input[name=name]").val(),
					birthday : $("input[name=birthday]").val(),
					gender : $("input[name=gender]").val(),
					unit : $("input[name=unit]").val(),
					identy : $("input[name=identy]").val(),
					worktime : $("input[name=worktime]").val(),
					rank : $("input[name=rank]").val(),
					education : $("input[name=education]").val(),
					degree : $("input[name=degree]").val(),
					graduateuniversity : $("input[name=graduateuniversity]")
							.val(),
					mail : $("input[name=mail]").val(),
					phone : $("input[name=phone]").val(),
					fixedphone : $("input[name=fixedphone]").val()
				//这里不要加","  不然会报错，而且根本不会提示错误地方
				},
				success : function(data) {//回调
					alert(data.name);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert(XMLHttpRequest.status);
					alert(XMLHttpRequest.readyState);
					alert(textStatus);
					alert(XMLHttpRequest.responseText);
				}
			});
		});
	}
</script>
<body>
	TeacherInfo_add:
	<br /> { "tno": "1234567890", "name": "McLaughlin", "birthday":
	"1981-08-10", "gender": "男", "unit": "unit", "identy": "identity",
	"worktime": "worktime", "rank": "rank", "education": "education",
	"degree": "degree", "graduateuniversity": "xx", "mail": "xx", "phone":
	"xx", "fixedphone": "xx" }
	<hr />
	将json字符串传递到action:
	<br />
	<hr />
	TeacherInfo_update
	<hr />
	TeacherInfo_look
	<hr />
	<hr />
	<hr />
	<form action="#" method="post">
		<label for="tno">tno：</label><input type="text" name="tno" /> <label
			for="name">name：</label><input type="text" name="name" /> <label
			for="birthday">birthday：</label><input type="date" name="birthday" />
		<label for="gender">gender：</label><input type="text" name="gender" />
		<label for="unit">unit：</label><input type="text" name="unit" /> <label
			for="identy">identy：</label><input type="text" name="identy" /> <label
			for="worktime">worktime：</label><input type="date" name="worktime" />
		<label for="rank">rank：</label><input type="text" name="rank" /> <label
			for="education">education：</label><input type="text" name="education" />
		<label for="degree">degree：</label><input type="text" name="degree" />
		<label for="graduateuniversity">graduateuniversity：</label><input
			type="text" name="graduateuniversity" /> <label for="phone">phone：</label><input
			type="text" name="phone" /> <label for="fixedphone">fixedphone：</label><input
			type="text" name="fixedphone" /> <input type="button" class="btn"
			value="提交结果" />
	</form>

</body>
</html>
