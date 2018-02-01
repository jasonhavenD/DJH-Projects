//验证原来的支付密码
function testOld(){
	var oldpay = hex_md5($("#oldpay").val());
	if(oldpay == ""){
		$("#oldpay").attr("placeholder","原旧密码不能为空");
		return false;
	}else{
		$.ajax({
			type:'post',
			//data:{"paypassword":oldpay},
			 url:'../Company_getCompanyInfo',
			success:function(data){
				 if(data.company.length != 0){
                 var c = data.company;
                 if(c[0][10] == oldpay){

                 }else{
                 	$("#oldpay").val("");
                 	$("#oldpay").attr("placeholder","密码错误");
                 }
				}
			}
		})
	}
}

//验证密码两次输入是否正确
function confirm(){
	var newpay = hex_md5($("#newpay").val());
	var connewpay = hex_md5($("#connewpay").val());
	if(newpay == ""){
		$("#newpay").attr("placeholder","两次密码输入不一致");
		return false;
	}if(connewpay == ""){
		$("#connewpay").attr("placeholder","两次密码输入不一致");
		return false;
	}else if(newpay != connewpay){
		$("#connewpay").val("");
		$("#connewpay").attr("placeholder","两次密码输入不一致");
		return false;
	}
}
//修改支付密码
function updatePay(){
	var newpay = hex_md5($("#newpay").val());
	var connewpay = hex_md5($("#connewpay").val());
	if(newpay != connewpay){
		$("#connewpay").attr("placeholder","两次密码输入不一致");
		return false;
	}else{
		$.ajax({
			type:'post',
			data:{"paypassword":connewpay},
			url:'../User_updatePaypsw',
			success:function(data){
				if(data.state == "success"){
					alert("修改成功");
					window.location.href="showperson.html";
				}else{
					alert("修改失败");
				}
			}
		})
	}

}