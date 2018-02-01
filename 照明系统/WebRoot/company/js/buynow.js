
//地址
var addressoptions={
    type:"post",
    url:"./Company_getAddress",
    async:true,
    success:function(data){
    var temp=data.addressList;
        for(var i=0;i<temp.length;i++){
            if(temp[i][4]==1){
           
            }
            var _tr = $("<p><input type=\"radio\" onclick=\"isDefault("+temp[i][5]+")\" name=\"default\"/><span>"+temp[i][0]+"  "+temp[i][1]+"  "+temp[i][3]+"   "+temp[i][2]+"</span></p>");
            /*var _tr=$("<tr class=\"address-body\"><td>"+temp[i][0]+"</td><td>"+ temp[i][1]+
                      "</td><td>"+temp[i][3]+ "</td><td>"+temp[i][2]+
                      "</td><td><a href='#' data-toggle=\"modal\" data-target=\"#myModal\" onclick=\"modifydeliver("+temp[i][5]+")\">修改</a>|<button href=\"address.html\" onclick=\"deleteAddress("+temp[i][5]+")\">删除</button></td>  <td class=\"address-status\"><button onclick=\"setAddressDefault("+temp[i][5]+")\" class=\"set-info\" style="+
                      state+">设为默认地址</button></td><td></td></tr>");*/
            $(".buyaddress h5").append(_tr);  
        }       
    },
    dataType:"json",
};
$.ajax(addressoptions);

function isDefault(arg){
    $("#addressid").val(arg);
}
//提交订单
$("#suborder").click(function(){
    var tab = $("#buynow tbody");
    var lastprice=0;
    tab.find("tr").each(function(){
    	var tmp = $(this).find("td:eq(5)").html();
    	lastprice += parseInt(tmp);
    	
    });
    console.log(lastprice);
    $("input[name='orderinfo.lastprice']").val(lastprice);
    var addressid = $("#addressid").val();
    if(addressid == ""){
        alert("请选择地址！");
        return false;
    }       
    $(".buyyes").submit();
});

$("input[name='deliverycycle']").blur(function(){
	var numval = $(this).val();
  		if(isNaN(numval)){
  			$(this).val('');
  			$(this).focus();
  		}else{
  			if(parseInt(numval)>=32767){
  				$(this).val('');
  				$(this).focus();
  			};
  		}
});
/*$.ajax({
    type:'post',
    url:'../Order_getPendPayForClient',
    success:function(data){
        $(".buyyes tbody").html("");
        if(data.orderList == "noLogin"){
            alert("您还未登录，请先登录");
        }else if(data.orderList == "systemError"){
            alert("获取数据失败");
        }else
        {
            var array = new Array();
            array = data.orderList;
            var delivername=data.delivername;
            var str ="";
            
            for(var i =0; i<array.length; i++){
                jieneng = "";
                var picture = array[i][3].split("|");
                    if(array[i][7] != ""){
                        jieneng = "功率"+array[i][6]+"W"+";灯头"+"E"+array[i][7]+";色温"+array[i][8]+"K"+";电压"+array[i][9]+"V";
                    }else{
                        jieneng = "光通量"+array[i][10]+"Lm"+";光效"+array[i][11]+"LM/W"+";显色指数"+array[i][12]+";光束角"+array[i][13]+";是否符合EMC"+array[i][14];
                    }

                if(i == j){
                    str+= " <tr><td><img src='.."+picture[0]+"' alt=''/></td>"+
                            "<td>"+array[i][1]+"</td>"+
                            "<td>"+jieneng+"</td>"+
                            "<td>"+array[i][2]+"</td>"+
                            "<td>"+array[i][4]+"</td>"+
                            "<td>"+array[i][5]+"</td>"+
                            "<td rowspan='"+a[k]+"'><a href=\"javaScript:void(0)\" class='btn btn-info' onclick=\"toBuy("+array[i][0]+")\">立即支付</a>" +
                            "<a href=\"javaScript:void(0)\" class='btn btn-info' onclick=\"cancel("+array[i][0]+")\">取消订单</a>"+
                            "</td></tr>"
                            j = j + a[k];
                            k = k+1;
                }else{
                    str+= " <tr><td><img src='.."+picture[0]+"' alt=''/></td>"+
                            "<td>"+array[i][1]+"</td>"+
                            "<td>"+jieneng+"</td>"+
                            "<td>"+array[i][2]+"</td>"+
                            "<td>"+array[i][4]+"</td>"+
                            "<td>"+array[i][5]+"</td></tr>"
                }
            }
            $(".buyyes tbody").append(str);
        }
    }
})*/