/*
 获取消费流水
*/
function getConsumeInfo(){
	var addressoptions={
			type:"post",
			url:"../Wallet_getConsumeInfo",
			async:true,
			success:function(data){
			var temp=data.walletConsumeList;
				for(var i=0;i<temp.length;i++){
					var _tr=$("<tr><td>"+temp[i][0]+"</td><td>"+ temp[i][1]+
							  "</td><td>"+temp[i][2]+ "</td><td>"+temp[i][3]+
							  "</td></tr>"
							  );
					$("#showTable").append(_tr); 
				}
				
				
			},
			dataType:"json",
			error:function(data){
			alert("失败了");
		    }
		};
		$.ajax(addressoptions);
}
function getAllInfo(){
	getOrdinaryInfo();
	getAuthenticateInfo();
}
/**
     * 获取普通会员流水
*/
function getOrdinaryInfo(){
	//alert("getOrdinaryInfo");
	var addressoptions={
			type:"post",
			url:"../Wallet_getOrdinaryInfo",
			async:true,
			success:function(data){
			var temp=data.walletOrdinaryList;
			//alert("success");
				for(var i=0;i<temp.length;i++){
					var _tr=$("<tr><td>"+temp[i][0]+"</td>"+
							"<td>"+temp[i][1]+"</td>"+
							"<td>"+temp[i][2]+"</td>"+
							"<td>"+temp[i][3]+"</td>"+
							"<td>"+temp[i][4]+"</td>"+
							"<td>"+temp[i][5]+"</td>"+
							"<td>"+temp[i][6]+"</td>"+
							"<td><a href=\"\" class=\"templatemo-edit-btn\">修改</a></td><td><a href=\"\" class=\"templatemo-link\">删除</a></td></tr>"
							  );
					$("#showOrdinaryWallet").append(_tr); 
				}
			},
			dataType:"json",
			error:function(data){
			alert("失败了");
		    }
		};
		$.ajax(addressoptions);
}
 /**
     * 获取认证代理商流水
*/
function getAuthenticateInfo(){
	//alert("getAuthenticateInfo");
	var addressoptions={
			type:"post",
			url:"../Wallet_getAuthenticateInfo",
			async:true,
			success:function(data){
			var temp=data.walletAuthenticateList;
			//alert("success");
				for(var i=0;i<temp.length;i++){
					var _tr=$("<tr><td>"+temp[i][0]+"</td>"+
							"<td>"+temp[i][1]+"</td>"+
							"<td>"+temp[i][2]+"</td>"+
							"<td>"+temp[i][3]+"</td>"+
							"<td>"+temp[i][4]+"</td>"+
							"<td>"+temp[i][5]+"</td>"+
							"<td>"+temp[i][6]+"</td>"+
							"<td><a href=\"\" class=\"templatemo-edit-btn\">修改</a></td><td><a href=\"\" class=\"templatemo-link\">删除</a></td></tr>"
							  );
					$("#showAuthenticateWallet").append(_tr); 
				}
			},
			dataType:"json",
			error:function(data){
			alert("失败了");
		    }
		};
		$.ajax(addressoptions);
}
