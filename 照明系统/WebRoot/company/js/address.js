/*获取收货地址*/
function getAddress(){
	var addressoptions={
			type:"post",
			url:"../Company_getAddress",
			async:true,
			success:function(data){
			var temp=data.addressList;
				for(var i=0;i<temp.length;i++){
					
					var state;
					if(temp[i][4]==1)
					state = "display:none"
					else
					state="display:inline"
					var _tr=$("<tr class=\"address-body\"><td>"+temp[i][0]+"</td><td>"+ temp[i][1]+
							  "</td><td>"+temp[i][3]+ "</td><td>"+temp[i][2]+
							  "</td><td><a href='#' data-toggle=\"modal\" data-target=\"#myModal\" onclick=\"modifydeliver("+temp[i][5]+")\">修改</a>|<button href=\"address.html\" onclick=\"deleteAddress("+temp[i][5]+")\">删除</button></td>  <td class=\"address-status\"><button onclick=\"setAddressDefault("+temp[i][5]+")\" class=\"set-info\" style="+
							  state+">设为默认地址</button></td><td></td></tr>");
					$("#showTable").append(_tr); 
					
					
				}
				
			},
			dataType:"json",
		};
		$.ajax(addressoptions);
}
/*新增地址信息*/
function addAddress(){
			var inputaddress=$("#inputaddress").val();
			var inputpostcode=$("#inputpostcode").val();
			var inputname=$("#inputname").val();
			var inputphone=$("#inputphone").val();
			var inputisdefault;
			var temp=$("#isdefault");
			//alert(temp[0].checked);
			if(temp[0].checked==true)
			inputisdefault=1;
			else
			inputisdefault=0;
			//inputisdefault=0;
			
		var addressoptions={
			type:"post",
			url:"../Address_addAddress",
			data:{
			"addressinfo.consigneename":inputname,
			"addressinfo.consigneeaddress":inputaddress,
			"addressinfo.consigneephone":inputphone,
			"addressinfo.zipcode":inputpostcode,
			"addressinfo.isdefault":inputisdefault
			},
			async:true,
			success:function(data){
				if(data.state=="success"){
		    		alert("恭喜你，添加地址成功");
		    		window.location.href="../company/address.html";
		    	}
			},
			dataType:"json",
		    error:function(data){
			alert("失败了");
		    }
			
		};
		$.ajax(addressoptions);
		
}
/*删除地址信息*/
function deleteAddress(obj){
	var addressid = obj;
	   var addressoptions={
	   	  type:'post',
			url:"../Address_deleteAddress",
			data:{
			"addressinfo.addressid":addressid
			},
			async:true,
			success:function(data){
				if(data.state=="success"){
		    		alert("恭喜你，删除地址成功");
		    		window.location.href="../company/address.html";
		    	}
			},
			dataType:"json",
		    error:function(data){
			alert("失败了");
		    }
	   };
	   $.ajax(addressoptions);
	   

}
/*设置地址信息为默认*/
function setAddressDefault(obj){
	var addressid=obj;
	//alert(addressid);
	var addressoptions={
	   	  type:'post',
			url:"../Address_setAddressDefault",
			data:{
			"addressinfo.addressid":addressid
			},
			async:true,
			success:function(data){
				if(data.state=="success"){
		    		alert("恭喜你，设置地址成功");
		    		window.location.href="../company/address.html";
		    	}
			},
			dataType:"json",
		    error:function(data){
			alert("失败了");
		    }
	   };
	   $.ajax(addressoptions);
	
		
}
/*编辑地址信息*/
function editAddress(obj){
	//var addressid="6";
	var addressid=$("#modifyid").val();
	 
	var modifyaddress=$("#modifyaddress").val();
	var modifypostcode=$("#modifypostcode").val();
	var modifyname=$("#modifyname").val();
	var modifyphone=$("#modifyphone").val();
	//var modifydefault=$("#modifydefault");
	
	var addressoptions={
	   	  type:'post',
			url:"../Address_editAddress",
			data:{
			"addressinfo.addressid":addressid,
		"addressinfo.consigneename":modifyname,
		"addressinfo.consigneeaddress":modifyaddress,
		"addressinfo.consigneephone":modifyphone,
		"addressinfo.zipcode":modifypostcode
			},
			async:true,
			success:function(data){
				if(data.state=="success"){
		    		alert("恭喜你，修改地址成功");
		    		window.location.href="../company/address.html";
		    	}
			},
			dataType:"json",
		    error:function(data){
			alert("失败了");
		    }
	   };
	   $.ajax(addressoptions);
	  
	
}
function modifydeliver(obj){
	var addressid=obj;
	$("#modifyid").val(addressid);
}

