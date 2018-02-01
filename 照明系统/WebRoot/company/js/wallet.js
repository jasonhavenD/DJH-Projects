/*获取资金流水*/
function getRechargeInfo() {
	var walletoption = {
		type : 'post',
		url : "../Wallet_getRechargeInfo",
		async : true,
		success : function(data) {

			var temp = data.walletRechargeList;
			for ( var i = 0; i < temp.length; i++) {

				var _tr = $("<tr><td>" + temp[i][0] + "</td><td>" + temp[i][3]
						+ "</td><td>" + temp[i][2] + "</td><td>" + temp[i][5]
						+ "</td><td>" + 0 + "</td><td>" + 0 + "</td><td>"
						+ temp[i][4] + "</td>");
				// $(#"showtable").append(_tr);
				$("#rechargeinfotable").append(_tr);
			}
		//	alert("success");
		},

		dataType : "json",
		error : function(data) {
			alert("失败了");
		}
	};
	$.ajax(walletoption);
}

/* 获取提现流水 */
function getWithdrawInfo() {
	var walletoption = {
		type : 'post',
		url : "../Wallet_getWithdrawInfo",
		async : true,
		success : function(data) {
			//var temp = date.walletWithdrawList;
			var temp = data.walletWithdrawList;
			for ( var i = 0; i < temp.length; i++) {

				var _tr = $("<tr><td>" + temp[i][0] + "</td><td>" + temp[i][3]
						+ "</td><td>" + temp[i][2] + "</td><td>" + temp[i][5]
						+ "</td><td>" + 0 + "</td><td>" + 0 + "</td><td>"
						+ temp[i][4] + "</td>");
				// $(#"showtable").append(_tr);
				$("#withdrawinfotable").append(_tr);
			}
		},
		dataType : "json",
	};
	$.ajax(walletoption);
}

/* 获取消费流水 */
function getConsumeInfo() {
	var walletoption = {
		type : 'post',
		url : "../Wallet_getConsumeInfo",
		async : true,
		success : function(data) {
			var temp = data.walletConsumeList;
			for ( var i = 0; i < temp.length; i++) {

				var _tr = $("<tr><td>" + temp[i][0] + "</td><td>" + temp[i][3]
						+ "</td><td>" + temp[i][2] + "</td><td>" + temp[i][5]
						+ "</td><td>" + 0 + "</td><td>" + 0 + "</td><td>"
						+ temp[i][4] + "</td>");
				// $(#"showtable").append(_tr);
				$("#consumeinfotable").append(_tr);
			}
		},
		dataType : "json",
	};
	$.ajax(walletoption);
}

/*function getPointInfo(){
	window.location.href="points.html";
	var showid = $("#pointtable")
	var pointinfo={
		type:'post',
		url:"../Company_getPointInfo",
		async:true,
		success:function(data){
			var temp = data.pointList;
			alert(temp);
			for(var i= 0;i<temp.length;i++){
					
					var _tr=$("<tr><td>"+temp[i][0]+"</td><td>"+temp[i][1]+"</td></tr>");
					//$(#"showtable").append(_tr);
					$("#pointtable").append(_tr);
					//alert(_tr);
				}
		//	alert(temp);
		},
		dataType:"json",
	};
	$.ajax(pointinfo);	
}  */

function getPointInfo(){
	
	var showid = $("#pointtable");
	var postpath="../Company_getPointInfo";
	$.post(postpath,{},function(data){
		var list = new Array();
		list = data.pointList;
		var  str="";
		for(var i=0;i<list.length;i++){
			str+="<tr><td>"+list[i][0]+"</td><td>"+list[i][1]+"</td></tr>";
		}
		//alert(str);
		showid.html('');
		showid.append(str);
	});
/*	$.ajax({
		type:'post',
		aysnc:false,
		jsonType:'text',
		url:'../Company_getPointInfo',
		
		success:function(data){
			alert(data.pointList);
			//window.location.href="points.html";
		},
		error:function(data){
			alert("123");
		}
	}) */
	
}

/**
 * 充值
 */
function RechargeIn(){
	
	var rechargeamount = document.getElementById("RechargeIn").value;
//	alert(rechargeamount);
	var rechargeintions={
	url:"../Wallet_RechargeIn",
	type:"post",
	data:{
		"rechargeamount":rechargeamount,
	},
	async:true,
	success:function(data){
		if(data.state=="success"){
			alert("充值成功");
		}
	},
	dataType:"json",
	error:function(data){
		alert("充值失败");
	}
	};
	$.ajax(rechargeintions);
}

function Withdraw(){
	
	var withdrawamount = document.getElementById("RechargeIn").value;
//	alert(rechargeamount);
	var withdrawoption={
	url:"../Wallet_Withdraw",
	type:"post",
	data:{
		"withdrawamount":withdrawamount,
	},
	async:true,
	success:function(data){
		if(data.state=="success"){
			alert("充值成功");
		}
	},
	dataType:"json",
	error:function(data){
		alert("充值失败");
	}
	};
	$.ajax(withdrawoption);
}
