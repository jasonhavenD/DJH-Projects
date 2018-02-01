/*手机注册时用户名是否为空和唯一性的验证*/
function validatePhoneName() {
	var usernamephone = $("#usernamephone").val();
	// var ureg = /([\u4e00-\u9fa5a-zA-Z]+[0-9]*)/;
	var ureg = /^(?![0-9])[a-zA-Z0-9_\u4e00-\u9fa5]{3,12}$/;
	// var ureg = /^[\u4E00-\u9FA5A-Za-z0-9]{3,12}$/;
	if (usernamephone == "") {
		$('#phonewarn').text("用户名不能为空");
	} else {
		if (!ureg.test(usernamephone)) {
			$('#phonewarn').text("请输入3-12位用户名，且不能以数字开头");
		} else {
			$.post("../User_validateUsername", {
				"username" : usernamephone
			}, function(data) {

				if (data.usernameState == "true") {
					$('#phonewarn').text("");
				} else {
					$("#phonewarn").text("用户名已经被使用，换一个吧~");
				}
			});
		}
	}

}
/* 验证手机是否为空和唯一性 */
function validatePhone() {
	var phonereg = /^1\d{10}$/;
	var phone = $("#phone").val();
	if (phone == '') {
		$("#pwarn").text("手机号不能为空");
	} else {
		if (!phonereg.test(phone)) {
			$("#pwarn").text("手机号格式不正确");
		} else {
			$.post("../User_validatePhone", {
				"phone" : phone
			}, function(data) {
				if (data.phoneState == "true") {
					$("#pwarn").text("");
				} else {
					$("#pwarn").text("手机号已经被注册了，换一个吧");
				}
			});

		}

	}
}
/* 验证密码是否为空 */
function validatePhonePassword() {
	var p = $("#passwordphone").val();
	var passwordphone = hex_md5(p);
	if (passwordphone == '') {
		$("#pwarnpassword").text("密码不能为空");
		return false;
	} else {
		if (passwordphone.length < 6) {
			$("#pwarnpassword").text("密码不能少于6位");
			return false;
		} else {
			$("#pwarnpassword").text("");
		}
	}
}
/* 验证两次密码是否一致 */
function confirmPhonePassword() {
	var pphone = $("#passwordphone").val();
	var pphone_confirm = $("#passwordphone_confirm").val();
	var passwordphone = hex_md5(pphone);
	var passwordphone_confirm = hex_md5(pphone_confirm);
	if (passwordphone_confirm == '') {
		$("#ppasswordwarn").text("请确认密码");
		return false;
	} else {
		if (passwordphone == passwordphone_confirm) {
			$("#ppasswordwarn").text("");
			return true;
		} else {
			$("#ppasswordwarn").text("密码两次输入不一样");
			return false;
		}
	}
}
/* 发送验证码/已存在的手机不发送 */
function getCodeByPhone() {
	var phone = $("#phone").val();
	if (phone != '') {
		$.post("../IdentifyingCode _getCodeByPhone", {
			"phone" : phone
		});
	}
}
/* 验证手机验证码是否一致//待定 */
function confirmPhoneCode() {
	var pinphone = $("#pinphone").val();
	if (pinphone == '') {
		$("#epinmail").text("手机验证码不能为空");
	} else {
		$.post("../IdentifyingCode_validateCode", {
			"validate" : pinphone
		});
	}
}
/* 手机注册提交验证(验证) */
function phoneRegister() {
	var flag2;
	var usernamephone = $("#usernamephone").val();
	var phone = $("#phone").val();
	var pphone = $("#passwordphone").val();
	var passwordphone = hex_md5(pphone);
	var pphone_confirm = $("#passwordphone_confirm").val();
	var passwordphone_confirm = hex_md5();
	var pinphone = $("#pinphone").val(pphone_confirm);
	if (usernamephone == '' || phone == '' || passwordphone == ''
			|| passwordphone_confirm == '' || pinphone == '') {
		alert("有空值");
		return false;
	}
	// 用户名验证
	if (usernamephone != '') {
		var options2 = {
			type : 'post',
			url : "../User_validateUsername",
			data : {
				"username" : usernamephone
			},
			async : false,
			success : function(data) {
				if (data.usernameState == "true") {
					$("#phonewarn").text("");
					flag2 = true;
				} else {
					flag2 = false;// 当已经注册过。仍然是true，不能修改flag2;
			$("#phonewarn").text("用户名已经被使用，换一个吧~");

		}
	},
	dataType : "json",
	error : function(data) {
		window.location.href = "logerror.html";
	}
		};
		$.ajax(options2);
		if (!flag2) {
			return false;
		}
	}
	// 手机号验证
	if (phone != '') {
		options2 = {
			type : 'post',
			url : "../User_ validatePhone",
			data : {
				"phone" : phone
			},
			async : false,
			success : function(data) {
				if (data.phoneState == "true") {
					$("#pwarn").text("");
					flag2 = true;
				} else {
					flag2 = false;// 当已经注册过。仍然是true，不能修改flag2;
			$("#pwarn").text("用户名已经被使用，换一个吧~");

		}
	},
	dataType : "json",
	error : function(data) {
		window.location.href = "logerror.html";
	}
		};
		$.ajax(options2);
		if (!flag2) {
			return false;
		}
	}
	// 两次密码验证
	if (usernamephone != '' && passwordphone_confirm != '') {
		if (!confirmPhonePassword) {
			return false;
		}
	}
	// 验证码验证
	if (pinphone != '') {

	}
	/*
	 * $.post("User_registerByEmail", {"userinfo.username":usernamephone,
	 * "userinfo.email":phone, "userinfo.password":passwordphone },
	 * function(data){ alert("手机提交状态"+data.registerState);
	 * if(data.registerState=="success"){ window.location.hash="tologin" ; } } );
	 */

}
/* 邮箱注册 */
/* 邮箱注册时用户名是否为空和唯一性的验证 */
function validateEmailName() {
	var usernameemail = $("#usernameemail").val();
	var ureg = /^(?![0-9])[a-zA-Z0-9_\u4e00-\u9fa5]{3,12}$/;
	if (usernameemail == "") {
		$('#emailwarn').text("用户名不能为空");
	} else {
		if (!ureg.test(usernameemail)) {
			$('#emailwarn').text("请输入3-12位用户名，且不能以数字开头");
		} else {
			$.post("../User_ validateUsername", {
				"username" : usernameemail
			}, function(data) {
				// if(data){}
					if (data.usernameState == "true") {
						$('#emailwarn').text("");
					} else {
						$("#emailwarn").text("用户名已经被使用，换一个吧~");
					}
				});
		}
	}
}
/* 验证邮箱是否为空和唯一性和已有邮箱不发送验证码 */
function validateEmail() {
	var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
	var email = $("#email").val();
	if (email == "") {
		$("#ewarn").text("邮箱不能为空");
	} else {
		if (!reg.test(email)) {
			$("#ewarn").text("邮箱格式不正确");
		} else {
			$.post("../User_validateEmail", {
				"email" : email
			}, function(data) {
				if (data.emailState == "true") {
					$("#ewarn").text("");
				} else {
					$("#ewarn").text("邮箱已经被注册了，换一个吧");
				}
			});

		}

	}
}
/* 验证密码是否为空 */
function validateEmailPassword() {
	var pemail = $("#passwordemail").val();
	var passwordemail = hex_md5(pemail);
	if (passwordemail == "") {
		$("#ewarnpassword").text("密码不能为空");
		return false;
	} else {
		if (passwordemail.length < 6) {
			$("#ewarnpassword").text("密码不能少于6位");
			return false;
		} else {
			$("#ewarnpassword").text("");
		}
	}
}
/* 验证两次密码是否一致 */
function confirmEmailPassword() {
	var pemail = $("#passwordemail").val();
	var pemail_confirm = $("#passwordemail_confirm").val();
	var passwordemail = hex_md5(pemail);
	var passwordemail_confirm = hex_md5(pemail_confirm);
	if (passwordemail_confirm == "") {
		$("#epasswordwarn").text("请确认填写");
		return false;
	} else if (passwordemail == passwordemail_confirm) {
		$("#epasswordwarn").text("");
		return true;
	} else {
		$("#epasswordwarn").text("密码两次输入不一样");
		return false;
	}
}
/* 发送验证码/已存在的邮箱不发送 */
function getCodeByEmail() {
	var email = $("#email").val();
	if (email != "") {
		$.post("../IdentifyingCode_getCodeByEmail", {
			"email" : email
		});
	}
}

/* 验证邮箱验证码是否一致 */
var flag;
function confirmEmailCode() {
	var pinemail = $("#pinemail").val();
	if (pinemail == "") {
		$("#pinemailwarn").text("验证码不能为空");
		flag = false;
	} else {
		$.post("../IdentifyingCode_validateCode", {
			"validate" : pinemail
		}, function(data) {
			if (data.validateState == "true") {
				$("#pinemailwarn").text("");
				flag = true;
			} else if (data.validateState == "false") {
				$("#pinemailwarn").text("验证码不正确");
				flag = false;
			} else if (data.validateState == "noVerificationCode") {
				$("#pinemailwarn").text("没有获取验证码");
				flag = false;
			} else {
				$("#pinemailwarn").text("验证码超时");
				flag = false;
			}
		});
	}
}
/* 邮箱注册提交验证(验证) */
function emailRegister() {
	var flag1;
	var usernameemail = $("#usernameemail").val();
	var email = $("#email").val();
	var pemail = $("#passwordemail").val();
	var passwordemail = hex_md5(pemail);
	var pemail_confirm = $("#passwordemail_confirm").val();
	var passwordemail_confirm = hex_md5(pemail_confirm);
	var pinemail = $("#pinemail").val();
	if (usernameemail == '' || email == '' || passwordemail == ''
			|| passwordemail_confirm == '' || pinemail == '') {
		return false;
	}
	if (usernameemail != '') {
		var options = {
			type : 'post',
			url : "../User_validateUsername",
			data : {
				"username" : usernameemail
			},
			async : false,
			success : function(data) {
				if (data.usernameState == "true") {
					$("#emailwarn").text("");
					flag1 = true;
				} else {
					flag1 = false;// 当已经注册过。仍然是true，不能修改flag2;
			$("#emailwarn").text("用户名已经被使用，换一个吧~");

		}
	},
	dataType : "json",
	error : function(data) {
		window.location.href = "logerror.html";
	}
		};
		$.ajax(options);
		if (!flag1) {
			return false;
		}
	}
	if (email != '') {
		options = {
			type : 'post',
			url : "../User_validateEmail",
			data : {
				"email" : email
			},
			async : false,
			success : function(data) {
				if (data.emailState == "true") {
					$("#ewarn").text("");
					flag1 = true;
				} else {
					flag1 = false;// 当已经注册过。仍然是true，不能修改flag2;
			$("#ewarn").text("邮箱已经被注册了，换一个吧");

		}
	},
	dataType : "json",
	error : function(data) {
		window.location.href = "logerror.html";
	}
		};
		$.ajax(options);
		if (!flag1) {
			return false;
		}

	}
	if (passwordemail != '' && passwordemail_confirm != '') {
		if (!confirmEmailPassword()) {
			return false;
		}
	}
	if (pinemail != '') {
		if (!flag) {
			return false;
		}
	}
	options = {
		type : 'post',
		url : "../User_registerByEmail",
		data : {
			"userinfo.username" : usernameemail,
			"userinfo.email" : email,
			"userinfo.password" : passwordemail
		},
		async : false,
		success : function(data) {
			if (data.registerState == "success") {
				alert("恭喜你，注册成功！请登录吧~");
				window.location.hash = "#tologin";
			} else {
				return false;
			}
		},
		dataType : "json",
		error : function(data) {
			window.location.href = "logerror.html";
		}
	};
	$.ajax(options);
}
/* 登录 */
/* 验证用户名是否存在 */
function isUsername() {
	var username = $("#username").val();
	if (username == '') {
		$("#usernamewarn").text("用户名不能为空");
	} else {
		$("#usernamewarn").text("");
	}
}
/* 验证验证码 */
var picflag;
function validatePicture() {
	var validatecode = $("#validatecode").val();
	if (validatecode == '') {
		$("#passwordwarn").text("验证码不能为空");
		picflag = false;
	} else {
		$.post("IdentifyingCode_validatePicture", {
			"validate" : validatecode
		}, function(data) {
			if (data.validateState == "true") {
				$("#passwordwarn").text("");
				picflag = true;
			} else if (data.validateState == "fail") {
				$("#passwordwarn").text("验证码错误");
				picflag = false;
			} else if (data.validateState == "none") {
				$("#passwordwarn").text("验证码正在生成");
				picflag = false;
			}
		});
	}
}
/* 会员登录 */
function User_login() {
	var username = $("#username").val();
	var pword = $("#password").val();
	alert("username: " + username);
	alert(location.href.substring(0, location.href.lastIndexOf('/')));
	var password = hex_md5(pword);
	var validatecode = $("#validatecode").val();
	if (username != '' && password != '' && validatecode != '' && picflag) {
		alert("It's in!!!");
		var loginoptions = {
			type : 'post',
			url : "../User_login",
			data : {
				"userinfo.username" : username,
				"userinfo.phone" : username,
				"userinfo.email" : username,
				"userinfo.password" : password
			},
			async : true,
			success : function(data) {
				if (data.loginState == "success") {
					window.location.href = "../company/index.jsp";
				} else {
					$("#passwordwarn").text("用户名或密码错误");
				}
			},

			dataType : "json",
			error : function(data) {
				window.location.href = "../company/logerror.html";
			}
		};
		$.ajax(loginoptions);
	}
}
