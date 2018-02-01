Date.prototype.Format = function(fmt)   
{   
  var o = {   
    "M+" : this.getMonth()+1,                 //月份   
    "d+" : this.getDate(),                    //日   
    "h+" : this.getHours(),                   //小时   
    "m+" : this.getMinutes(),                 //分   
    "s+" : this.getSeconds(),                 //秒   
    "q+" : Math.floor((this.getMonth()+3)/3), //季度   
    "S"  : this.getMilliseconds()             //毫秒   
  };   
  if(/(y+)/.test(fmt))   
    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
  for(var k in o)   
    if(new RegExp("("+ k +")").test(fmt))   
  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
  return fmt;   
}  
/**
 * 待付款
 */
 var a1 = [];
function panyment(){
	var postpath = "../Order_getPendPayForClient";
	//var showid = $("#forpayment tbody");
	$("#forpayment tbody").html('');
	$.post(postpath,{},function(data){
		if(data.orderList.length == 0){
			$("#forpayment table").hide();
		}else if(data.orderList == "systemError"){
			alert("获取数据失败");
		}else
		{    $("#forpayment tbody").html("");
			var array = new Array();
			array = data.orderList;
			var delivername=data.delivername;
            var id =""
            var size = 0;
            a1 = [];
           //订单id 产品名称 （普通价格 认证价格） 产品图片 订单详情数量  订单总价 5
           //功率W E灯头 色温K 电压V  10 光通量Lm 光效LM/W 显色指数 光束角 是否符合emc
			for(var i = 0; i < array.length; i++){
                if(id == array[i][0]){
                    size++;
                }else{
                	a1.push(size);
                	size=1;
                    id = array[i][0];
                }
                if(i == array.length-1 && size>1){
                	a1.push(size);
                }
            }
			a1.splice(0,1);
			var str="";
			var j = 0;
			var k = 0;
			var m =1;
			var jieneng = "";
			//var qita = "";
			for(var i =0; i<array.length; i++){
				jieneng = "";
				var picture = array[i][3].split("|");
				var pretotal = array[i][2]*array[i][4];
				/*if(array[i][6] == ""){//配件没有功率 其他灯都有功率
					jieneng = "";
				}else{*/
					if(array[i][7] != ""){//节能灯有灯头 判断显示属性的
						jieneng = "功率:"+array[i][6]+";灯头:"+array[i][7]+";色温:"+array[i][8]+";电压:"+array[i][9];
					}else{
						jieneng = "光通量:"+array[i][10]+";光效:"+array[i][11]+";显色指数:"+array[i][12]+";光束角:"+array[i][13]+";是否符合EMC:"+array[i][14];
					}
				/*}*/
				if(i == j){
					str+= " <tr><td><img src='.."+picture[0]+"' alt=''/></td>"+
			                "<td>"+array[i][1]+"</td>"+
			                "<td>"+jieneng+"</td>"+
			                "<td>"+array[i][2]+"</td>"+
			                "<td>"+array[i][4]+"</td>"+
			                /* "<td>"+pretotal+"</td>"+*/
			                "<td rowspan='"+a1[k]+"'>"+array[i][5]+"</td>"+//实付金额
			                "<td style=\"display:none\">"+array[i][15]+"</td>"+
			                "<td rowspan='"+a1[k]+"'><a href=\"javaScript:void(0)\" class='btn btn-info' onclick=\"toBuy("+array[i][0]+","+j+","+array[i][5]+")\">立即支付</a>" +
			                "<a href=\"javaScript:void(0)\" class='btn btn-info' onclick=\"cancel("+array[i][0]+")\">取消订单</a>"+
			                "</td></tr>";
			                j = j + a1[k];
							k = k+1;
				}else{
					str+= " <tr><td><img src='.."+picture[0]+"' alt=''/></td>"+
			                "<td>"+array[i][1]+"</td>"+
			                "<td>"+jieneng+"</td>"+
			                "<td>"+array[i][2]+"</td>"+
			                "<td>"+array[i][4]+"</td>"+
			                /* "<td>"+pretotal+"</td>"+*/
			                /*"<td>"+array[i][5]+"</td>"+*/
			                "<td style=\"display:none\">"+array[i][15]+"</td>"+
			                "</tr>"
				}
			}
			$("#forpayment tbody").append(str);
			//alert();
		}
	});
}
function toBuy(arg1,arg2,arg3){//arg2表示从上一个合并单元格处开始读 本行的条数//arg3表示这个订单里面的条数
	
	//arg2表示从arg2+1处开始读 arg3条记录
    //window.location.href = "buynow.html";
   /* var tab = $("#forpayment table");
    var table = tab[0];
    var rows = table.rows;
    var colum = rows[0].cells.length;
    var string ="";
    var strArray = new Array();
    for(var i=0; i<arg3; i++){
    	string = arg1+","+rows[arg2+1].cells[6].innerHTML+","+rows[arg2+1].cells[4].innerHTML+","+0;
    	strArray[i] = string;
    	arg2 ++;
    }*/
    /*$.post('./Order_addOrder',{'param',strArray},function(data){

    })*/
    //var newstr = string.substring(0,string.length-1);
	$("input[name='orderinfo.orderid']").val(arg1);
	$("input[name='orderinfo.lastprice']").val(arg3);
	$("#tobuy").submit();
}
function cancel(arg){
	var id = arg;
	var conf = confirm('确定取消该订单吗？');
	if(conf){
		$.ajax({
			type:'post',
			data:{"orderid":id},
			url:'../Order_cancelOneOrder',
			success:function(data){
				if(data.state == "success"){
					panyment();
				}
			}
		})
	}
}
/**
 * 待发货
 */
function fordeliver(){
	var postpath = "../Order_getPendDeliveryForClient";
	$("#fordeliver tbody").html('');
	$.post(postpath,{},function(data){
		if(data.orderList.length == 0){
			$("#fordeliver table").hide();
		}else if(data.orderList == "systemError"){
			alert("获取数据失败");
		}else
		{    $("#forpayment tbody").html("");
			var array = new Array();
			array = data.orderList;
			var delivername=data.delivername;
            var id =""
            var size =0;
            var a = [];
           //订单id 产品名称 （普通价格 认证价格） 产品图片 订单详情数量  订单总价 5
           //功率W E灯头 色温K 电压V  10 光通量Lm 光效LM/W 显色指数 光束角 是否符合emc
			for(var i = 0; i < array.length; i++){
                if(id == array[i][0]){
                    size++;
                }else{
                	a.push(size);
                	size=1;
                    id = array[i][0];
                }
                if(i == array.length-1 && size>1){
                	a.push(size);
                }
            }
			a.splice(0,1);
			var str="";
			var j = 0;
			var k = 0;
			var m =1;
			var jieneng = "";
			//var qita = "";
			for(var i =0; i<array.length; i++){
				jieneng = "";
				var picture = array[i][3].split("|");
				if(array[i][7] != ""){//节能灯有灯头 判断显示属性的
					jieneng = "功率:"+array[i][6]+";灯头:"+array[i][7]+";色温:"+array[i][8]+";电压:"+array[i][9];
				}else{
					jieneng = "光通量:"+array[i][10]+";光效:"+array[i][11]+";显色指数:"+array[i][12]+";光束角:"+array[i][13]+";是否符合EMC:"+array[i][14];
				}
				array[i][15] = new Date(array[i][15]).Format("yyyy-MM-dd");
				if(i == j){
					str+= " <tr><td><img src='.."+picture[0]+"' alt=''/></td>"+
			                "<td>"+array[i][1]+"</td>"+
			                "<td>"+jieneng+"</td>"+
			                "<td>"+array[i][2]+"</td>"+
			                "<td>"+array[i][4]+"</td>"+
			                "<td rowspan='"+a[k]+"'>"+array[i][5]+"</td>"+
			                "<td rowspan='"+a[k]+"'>"+array[i][15]+"</td>"+
			                "<td rowspan='"+a[k]+"'>"+array[i][16]+"</td>"+
			                "<td rowspan='"+a[k]+"'><a href=\"javaScript:void(0)\" class='btn btn-info' onclick=\"toWarn("+array[i][0]+")\">提醒发货</a>" +
			                "<a href=\"javaScript:void(0)\" class='btn btn-info' onclick=\"refund("+array[i][0]+")\">申请退货</a>"+
			                "</td></tr>"
			                j = j + a[k];
							k = k+1;
				}else{
					str+= " <tr><td><img src='.."+picture[0]+"' alt=''/></td>"+
			                "<td>"+array[i][1]+"</td>"+
			                "<td>"+jieneng+"</td>"+
			                "<td>"+array[i][2]+"</td>"+
			                "<td>"+array[i][4]+"</td>"+
			               /* "<td>"+array[i][5]+"</td>"+
			                "<td>"+array[i][15]+"</td>"+
			                "<td>"+array[i][16]+"</td>"+*/
			                "</tr>"
				}
			}
			$("#fordeliver tbody").append(str);
		}
	});
}
function toWarn(arg){

}
function refund(arg){

}
/**
 * 待收货
 */
function forreceipt(){
	var postpath = "../Order_getPendTakeDeliveryForClient";
	$("#forreceipt tbody").html('');
	$.post(postpath,{},function(data){
		if(data.orderList.length == 0){
			$("#forreceipt table").hide();
		}else if(data.orderList == "systemError"){
			alert("获取数据失败");
		}else
		{    $("#forreceipt tbody").html("");
			var array = new Array();
			array = data.orderList;
			var delivername=data.delivername;
            var id =""
            var size =0;
            var a = [];
           //订单id 产品名称 （普通价格 认证价格） 产品图片 订单详情数量  订单总价 5
           //功率W E灯头 色温K 电压V  10 光通量Lm 光效LM/W 显色指数 光束角 是否符合emc
			for(var i = 0; i < array.length; i++){
                if(id == array[i][0]){
                    size++;
                }else{
                	a.push(size);
                	size=1;
                    id = array[i][0];
                }
                if(i == array.length-1 && size>1){
                	a.push(size);
                }
            }
			a.splice(0,1);
			var str="";
			var j = 0;
			var k = 0;
			var m =1;
			var jieneng = "";
			//var qita = "";
			for(var i =0; i<array.length; i++){
				jieneng = "";
				var picture = array[i][3].split("|");
				if(array[i][7] != ""){//节能灯有灯头 判断显示属性的
					jieneng = "功率:"+array[i][6]+";灯头:"+array[i][7]+";色温:"+array[i][8]+";电压:"+array[i][9];
				}else{
					jieneng = "光通量:"+array[i][10]+";光效:"+array[i][11]+";显色指数:"+array[i][12]+";光束角:"+array[i][13]+";是否符合EMC:"+array[i][14];
				}
				//array[i][15] = new Date(array[i][15]).Format("yyyy-MM-dd");
				if(i == j){
					str+= " <tr><td><img src='.."+picture[0]+"' alt=''/></td>"+
			                "<td>"+array[i][1]+"</td>"+
			                "<td>"+jieneng+"</td>"+
			                "<td>"+array[i][2]+"</td>"+
			                "<td>"+array[i][4]+"</td>"+
			                "<td rowspan='"+a[k]+"'>"+array[i][5]+"</td>"+
			                "<td rowspan='"+a[k]+"'>"+array[i][15]+"</td>"+
			                "<td rowspan='"+a[k]+"'>"+array[i][16]+"</td>"+
			                "<td rowspan='"+a[k]+"'><a href=\"javaScript:void(0)\" class='btn btn-info' onclick=\"YesBuy("+array[i][0]+")\">确认收货</a>" +
			                "<a href=\"javaScript:void(0)\" class='btn btn-info' onclick=\"NoBuy("+array[i][0]+")\">退/换货</a>"+
			                "</td></tr>"
			                j = j + a[k];
							k = k+1;
				}else{
					str+= " <tr><td><img src='.."+picture[0]+"' alt=''/></td>"+
			                "<td>"+array[i][1]+"</td>"+
			                "<td>"+jieneng+"</td>"+
			                "<td>"+array[i][2]+"</td>"+
			                "<td>"+array[i][4]+"</td>"+
			               /* "<td>"+array[i][5]+"</td>"+*/
			               /* "<td>"+array[i][15]+"</td>"+
			                "<td>"+array[i][16]+"</td>"+*/
			                "</tr>"
				}
			}
			$("#forreceipt tbody").append(str);
			//alert();
		}
	});
}

function YesBuy(arg){
	var orderid = arg;
	var conf = confirm('确定收货吗？');
	if(conf){
		$.ajax({
			type:'post',
			data:{"orderid":orderid},
			url:'../Order_affirmTakeDelivery',
			success:function(data){
				if(data.state == "success"){
					alert("确认收货成功");
					forreceipt();
				}else if(data.state == "numError"){
					alert("确认收货失败");
				}else{
					alert("系统错误");
				}
			}
		})
	}
	
}
function NoBuy(arg){

}
/**
 * 待评价
 */
function forcomment(){
	var postpath = "../Order_getPendCommentForClient";
	$("#forcomment tbody").html('');
	$.post(postpath,{},function(data){
		if(data.orderList.length == 0){
			$("#forcomment table").hide();
		}else if(data.orderList == "systemError"){
			alert("获取数据失败");
		}else
		{    $("#forpayment tbody").html("");
			var array = new Array();
			array = data.orderList;
			var delivername=data.delivername;
			var str="";
            var id =""
            var size =0;
            var a = [];
           //订单id 产品名称 （普通价格 认证价格） 产品图片 订单详情数量  订单总价 5
           //功率W E灯头 色温K 电压V  10 光通量Lm 光效LM/W 显色指数 光束角 是否符合emc
			for(var i = 0; i < array.length; i++){
                if(id == array[i][0]){
                    size++;
                }else{
                	a.push(size);
                	size=1;
                    id = array[i][0];
                }
                if(i == array.length-1 && size>1){
                	a.push(size);
                }
            }
			a.splice(0,1);
			var str="";
			var j = 0;
			var k = 0;
			var m =1;
			var jieneng = "";
			//var qita = "";
			for(var i =0; i<array.length; i++){
				jieneng = "";
				var picture = array[i][3].split("|");
				if(array[i][7] != ""){//节能灯有灯头 判断显示属性的
					jieneng = "功率:"+array[i][6]+";灯头:"+array[i][7]+";色温:"+array[i][8]+";电压:"+array[i][9];
				}else{
					jieneng = "光通量:"+array[i][10]+";光效:"+array[i][11]+";显色指数:"+array[i][12]+";光束角:"+array[i][13]+";是否符合EMC:"+array[i][14];
				}
				array[i][15] = new Date(array[i][15]).Format("yyyy-MM-dd");
				if(i == j){
					str+= " <tr><td><img src='.."+picture[0]+"' alt=''/></td>"+
			                "<td>"+array[i][1]+"</td>"+
			                "<td>"+jieneng+"</td>"+
			                "<td>"+array[i][2]+"</td>"+
			                "<td>"+array[i][4]+"</td>"+
			                "<td rowspan='"+a[k]+"'>"+array[i][5]+"</td>"+
			                "<td rowspan='"+a[k]+"'>"+array[i][15]+"</td>"+
			                "<td rowspan='"+a[k]+"'>"+array[i][16]+"</td>"+
			                "<td><a href=\"javaScript:void(0)\" class='btn btn-info' onclick=\"toComment("+array[i][0]+","+array[i][17]+")\">点评</a>" +
			                "</td></tr>"
			                j = j + a[k];
							k = k+1;
				}else{
					str+= " <tr><td><img src='.."+picture[0]+"' alt=''/></td>"+
			                "<td>"+array[i][1]+"</td>"+
			                "<td>"+jieneng+"</td>"+
			                "<td>"+array[i][2]+"</td>"+
			                "<td>"+array[i][4]+"</td>"+
			               /* "<td>"+array[i][5]+"</td>"+
			                "<td>"+array[i][15]+"</td>"+
			                "<td>"+array[i][16]+"</td>"+*/
			                "<td><a href=\"javaScript:void(0)\" class='btn btn-info' onclick=\"toComment("+array[i][0]+")\">点评</a>" +
			                "</tr>"
				}
			}
			$("#forcomment tbody").append(str);
		}
	});
	
}
//评价
function toComment(arg1,arg2){
	var orderid= arg1;
	var productid = arg2;
	$("input[name='orderid']").val(arg1);
	$("input[name='productid']").val(arg2);
	$("#tocomment").submit();
}
//已完成
function forok(){
	var postpath = "../Order_getBookSuccessForClient";
	$("#forok tbody").html('');
	$.post(postpath,{},function(data){
		if(data.orderList.length == 0){
			$("#forok table").hide();
		}else if(data.orderList == "systemError"){
			alert("获取数据失败");
		}else
		{    $("#forreceipt tbody").html("");
			var array = new Array();
			array = data.orderList;
			var delivername=data.delivername;
            var id =""
            var size =0;
            var a = [];
           //订单id 产品名称 （普通价格 认证价格） 产品图片 订单详情数量  订单总价 5
           //功率W E灯头 色温K 电压V  10 光通量Lm 光效LM/W 显色指数 光束角 是否符合emc
			for(var i = 0; i < array.length; i++){
                if(id == array[i][0]){
                    size++;
                }else{
                	a.push(size);
                	size=1;
                    id = array[i][0];
                }
                if(i == array.length-1 && size>1){
                	a.push(size);
                }
            }
			a.splice(0,1);
			var str="";
			var j = 0;
			var k = 0;
			var m =1;
			var jieneng = "";
			//var qita = "";
			for(var i =0; i<array.length; i++){
				jieneng = "";
				var picture = array[i][3].split("|");
				if(array[i][7] != ""){//节能灯有灯头 判断显示属性的
					jieneng = "功率:"+array[i][6]+";灯头:"+array[i][7]+";色温:"+array[i][8]+";电压:"+array[i][9];
				}else{
					jieneng = "光通量:"+array[i][10]+";光效:"+array[i][11]+";显色指数:"+array[i][12]+";光束角:"+array[i][13]+";是否符合EMC:"+array[i][14];
				}
				//array[i][15] = new Date(array[i][15]).Format("yyyy-MM-dd");
				if(i == j){
					str+= " <tr><td><img src='.."+picture[0]+"' alt=''/></td>"+
			                "<td>"+array[i][1]+"</td>"+
			                "<td>"+jieneng+"</td>"+
			                "<td>"+array[i][2]+"</td>"+
			                "<td>"+array[i][4]+"</td>"+
			                "<td>"+array[i][5]+"</td>"+
			                
			                "</tr>"
			                j = j + a[k];
							k = k+1;
				}else{
					str+= " <tr><td><img src='.."+picture[0]+"' alt=''/></td>"+
			                "<td>"+array[i][1]+"</td>"+
			                "<td>"+jieneng+"</td>"+
			                "<td>"+array[i][2]+"</td>"+
			                "<td>"+array[i][4]+"</td>"+
			                "<td>"+array[i][5]+"</td>"+
			                
			                "</tr>"
				}
			}
			$("#forok tbody").append(str);
			//alert();
		}
	});
}
/**
 * 预订成功
 */
function reservation(){
	var postpath = "../Order_getBookSuccessForClient";
	//alert("click");
	var showid = $("#reservation tbody");
	$.post(postpath,{},function(data){
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
			for(var i = 0; i < array.length; i++){
					str += " <tr><td>"+array[i].productname+"</td>"+
                "<td>"+array[i].paydatetime+"</td>"+
                "<td>"+array[i].quantity+"</td>"+
                "<td>"+array[i].certifiedprice+"</td>"+
                "<td>"+array[i].lastprice+"</td>"+
                "</td>"
                "</tr>";
			}
			showid.html('');
			showid.append(str);
			//alert();
		}
	});
}