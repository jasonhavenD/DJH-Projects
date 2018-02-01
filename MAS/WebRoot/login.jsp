
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<script language="javascript">
//防止页面后退
history.pushState(null, null, document.URL);
window.addEventListener('popstate', function() {
	history.pushState(null, null, document.URL);
});
</script>

<!DOCTYPE>
<html>
	<head>
		<meta charset="UTF-8">
		<title>专业水平评估系统</title>
		<link href="Styles/bootstrap.min.css" rel="stylesheet">
		<link href="Styles/login/style.css" rel="stylesheet">

		<script type="text/javascript" src="Styles/login/jquery.min.js">
</script>
		<script type="text/javascript" src="Styles/login/bootstrap.min.js">
</script>
		<script type="text/javascript" src="Styles/login/validation.js">
</script>
		<script type="text/javascript" src="Styles/login/form.js">
</script>
		<script type="text/javascript" src="Styles/login/utils.js">
</script>


		<style type="text/css">
select,textarea,input[type="text"],input[type="password"],input[type="datetime"],input[type="datetime-local"],input[type="date"],input[type="month"],input[type="time"],input[type="week"],input[type="number"],input[type="email"],input[type="url"],input[type="search"],input[type="tel"],input[type="color"],.uneditable-input
	{
	display: inline-block;
	height: 30px;
	padding: 4px 6px;
	margin-bottom: 10px;
	font-size: 14px;
	line-height: 20px;
	color: #555;
	vertical-align: middle;
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	border-radius: 4px;
}

a {
	color: #333;
	text-decoration: none;
}

a:hover {
	color: #CC3300;
	text-decoration: underline;
}
</style>

		<script type="text/javascript">
$(function() {
	$('#clouds').pan( {
		fps : 20,
		speed : 0.7,
		dir : 'right',
		depth : 10
	});
})

function reloadcode(obj, base) {
	var rand = new Date().getTime();
	obj.src = base + "randomCode.action?abc=" + rand;
}
function reloadcode2(base) {
	var rand = new Date().getTime();
	$("#imgCode").attr("src", base + "randomCode.action?abc=" + rand);
}
</script>

	</head>
	<body>

		<div id="header" class="header_login">
			<img src="Styles/login/login-bg2.png" alt="logo" />
		</div>

		<div class="content content_login">
			<form class="form-horizontal form_login" id="signupForm"
				method="post" action="user_login.action">

				<div class="control-group control_login">
					<label class="control-label" for="inputUser">
						<span class="icon-user"></span>
					</label>
					<div class="controls">
						<!-- 				  -->
						<input type="text" id="inputUser" name="sysuserinfo.userCode"
							placeholder="学号" required="required" pattern="[0-9]{10}" value="">
					</div>
				</div>
				<div class="control-group control_login">
					<label class="control-label" for="inputPassword">
						<span class="icon-password"></span>
					</label>

					<div class="controls">
						<input type="password" id="inputPassword"
							name="sysuserinfo.password" required="required" placeholder="密码">
					</div>
				</div>
				<div class="control-group control_login">
					<label class="control-label" for="inputUser">
						<span class="icon-user"></span>
					</label>
					<div class="controls">
						<select name="sysuserinfo.sysrole.roleCode">
							<s:if test="sysroles==null||sysroles.size() == 0">
								<option value="1">
									系统管理员
								</option>
								<option value="2">
									专业负责人
								</option>
								<option value="3">
									学院负责人
								</option>
								<option value="4">
									教务处负责人
								</option>
								<option value="5">
									专家
								</option>
							</s:if>
							<s:iterator value="sysroles" id="sysrole">
								<option value="<s:property value='roleCode'/>">
									<s:property value="roleName" />
								</option>
							</s:iterator>
						</select>
					</div>
				</div>

				<div class="control-group control_login">
					<label class="control-label" for="inputCode">
						<span class="icon-key"></span>
					</label>

					<div class="controls">
						<input type="text" id="inputCode" name="chknumber"
							class="key_input" required="required" placeholder="验证码"
							maxlength="5">
						<img id="imgCode" title="看不清楚请点击这里"
							src="<%=basePath%>randomCode.action"
							onclick="reloadcode(this,'<%=basePath%>')" alt="验证码"
							class="generatecode" />
						<a href="#" onclick="reloadcode2('<%=basePath%>')"
							style="color: #fff;" class="generatecode">验证码看不清？</a>
					</div>
					<div class="notice_code">
						<label id="inputCode-error" style="display: none;" class="error"
							for="inputCode">
							请输入验证码
						</label>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<button type="submit" class="login_btn">
							登录
						</button>
						<a href="#modal" alt="忘记密码"
							style="color: #fff; margin-left: 20px;" data-toggle="modal">忘记密码？</a>
						<span style="color: red"><s:property value="message" /> </span>
						<span style="color: red">&nbsp;&nbsp;${sessionScope.message}</span>
					</div>
				</div>
			</form>
		</div>
		<span></span>
		<br />

		<div class="footer_login">
			<p style="font-size: 15px">
				<span style="margin: 0 20px 0 0; color: black">2017
					西北农林科技大学教务处</span>
				<a style="hover: red" href="http://www.nwsuaf.edu.cn/"
					target="_blank" title="西北农林科技大学">西北农林科技大学</a>
			</p>
		</div>

		<!-- 发送邮件弹窗 -->
		<div id="modal" class="modal hide fade" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">
					×
				</button>
				<h3 id="myModalLabel">
					找回密码
				</h3>
			</div>
			<div class="modal-body">
				<div class="form-horizontal">
					<div class="content">
						<div class="control-group alert"
							style="margin-left: 15px; width: 450px;">
							<strong>温馨提示：</strong> 系统将您的原密码发送至您预留的邮箱中
							<span style="color: red">（请确保您已经设置预留邮箱）</span>请输入您的账户名。
						</div>
						<div class="control-group">
							<label class="control-label" for="f_username">
								<span class="icon-user"></span>
							</label>

							<div class="controls">
								<input type="text" id="f_username" name="f_username"
									placeholder="用户名" value="">
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button id="closeBtn" class="btn" data-dismiss="modal"
					aria-hidden="true">
					关闭
				</button>
				<button id="sendForgetMail" onclick="sendMail()"
					class="btn btn-success">
					发送邮件
				</button>
			</div>
		</div>
	</body>
</html>
<script type="text/javascript">
function sendMail() {

	if (!$("#f_username").val()) {
		alert("请输入账户名");
	}
	$
			.post(
					"mailSendMail.action",
					{
						username : $("#f_username").val()
					},
					function(data) {
						if (data == true) {
							$("#modal .modal-body").empty();
							$("#modal .modal-header").empty();
							$("#modal .modal-header")
									.append(
											'<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button><h3 id="myModalLabel">发送结果</h3>');
							$("#modal .modal-body")
									.append(
											'<div class="control-group alert" style="margin-left: 15px; width: 450px;"><strong>温馨提示：</strong> 邮件发送成功！</div>');
							$('#sendForgetMail').hide();
						} else {
							$("#modal .modal-body").empty();
							$("#modal .modal-header").empty();
							$("#modal .modal-header")
									.append(
											'<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button><h3 id="myModalLabel">发送结果</h3>');
							$("#modal .modal-body")
									.append(
											'<div class="control-group alert" style="margin-left: 15px; width: 450px;"><strong>温馨提示：</strong> 邮件发送失败，确保用户名输入正确并且已经设置邮箱，请重新尝试！<br/>(<span style="color:red">管理员邮箱：cn_edu_nwsuaf_mas@163.com</span>)</div>');
							$('#sendForgetMail').hide();
						}

					});

}
</script>
