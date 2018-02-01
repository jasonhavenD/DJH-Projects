function getInventory(){
	$("#inventory tbody").html("");
	$.ajax({
		type:'post',
		url:'../Product_getLogInven',
		success:function(data){
			var _tr;
			var list = data.list;
			if(list.length){
				for(var i =0; i<list.length; i++){
					_tr += "<tr><td>"+list[i].productname+"</td>"+
			                "<td>"+list[i].power+list[i].lampholder+list[i].colortemp+list[i].voltage+list[i].luminousflux+list[i].lightefficiency+list[i].colorrendering+list[i].beamangle+list[i].isemc+"</td>"+
			                "<td>"+list[i].inventoryquantity+"</td>"+
			                "<td><a href=\"javaScript:void(0)\"  class=\"templatemo-edit-btn\" data-toggle=\"modal\" data-target=\"#myModal\">修改</a>" +
			                "</td></tr>";
			    }
			    $("#inventory tbody").append(_tr);
			}else{
				$("#inventory").hide();
			}
		}
	})
}