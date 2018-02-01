// 对Date的扩展，将 Date 转化为指定格式的String   
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，   
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)   
// 例子：   
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423   
// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18   
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
//查看详情（待付款 代收货）
function checkdetail(arg){
    var orderid = arg;
    $("#forpenpay tbody").html("");
    $.ajax({
            type:'post',
            data:{"orderid":orderid},
            url:'../Order_getOrderdetail',
            success:function(data){
                if(data.orderList == "noLogin"){
                    alert("您还未登录，请先登录");
                }else if(data.orderList == "systemError"){
                    alert("获取数据失败");
                }else{
                    var paypen = data.orderList;
                    if(paypen.length == 0){
                        alert("查无信息~");
                    }else{
                        $("#forpenpay").modal('show');
                        //viewModel.penoderdetail.setSimpleData(paypen);
                        for(var i = 0;i< paypen.length; i++){
                            //paypen[i].saletype = paypen[i].saletype ==0?"无":(paypen[i].saletype ==1?"限时促销":(paypen[i].saletype ==2?"团购":"众筹预售"));
                           //处理返回值的特殊情况。针对可能出现的空值以及日期
                            if(paypen[i].createdatetime ==null){
                                paypen[i].createdatetime = "";
                            }else{
                                paypen[i].createdatetime = new Date(paypen[i].createdatetime).Format("yyyy-MM-dd");
                            }
                            if(paypen[i].paydatetime ==null){
                                paypen[i].paydatetime = "";
                            }else{
                                paypen[i].paydatetime = new Date(paypen[i].paydatetime).Format("yyyy-MM-dd");
                            }
                            if(paypen[i].startdeliverytime ==null){
                                paypen[i].startdeliverytime = "";
                            }else{
                                paypen[i].startdeliverytime = new Date(paypen[i].startdeliverytime).Format("yyyy-MM-dd");
                            }
                            if(paypen[i].finishidatetime ==null){
                                paypen[i].finishidatetime = "";
                            }else{
                                paypen[i].finishidatetime = new Date(paypen[i].finishidatetime).Format("yyyy-MM-dd");
                            }

                            if(paypen[i].invoicetitle == null){
                                paypen[i].invoicetitle ="";
                            }
                            if(paypen[i].delivercycle == null){
                                paypen[i].delivercycle ="";
                            }
                            if(paypen[i].comments == null){
                                paypen[i].comments ="";
                            }
                            var _tr = $("<tr><td>"+paypen[i].productname+
                                        "</td><td>"+paypen[i].price+
                                        "</td><td>"+paypen[i].quantity+
                                       /* "</td><td>"+paypen[i].saletype+*/
                                        "</td><td>"+paypen[i].invoicetitle+
                                        "</td><td>"+paypen[i].createdatetime+
                                        "</td><td>"+paypen[i].paydatetime+
                                        "</td><td>"+paypen[i].delivercycle+
                                        "</td><td>"+paypen[i].comments+
                                       /* "</td><td>"+paypen[i].startdeliverytime+
                                        "</td><td>"+paypen[i].finishidatetime+*/
                                        "</td></tr>");
                             $("#forpenpay tbody").append(_tr);
                        }
                    }
                }
            }
        })
}
//查看详情 其他情况
function checkmore(arg){
     var orderid = arg;
    $("#twomodal tbody").html("");
    $.ajax({
            type:'post',
            data:{"orderid":orderid},
            url:'../Order_getOrderdetail',
            success:function(data){
                if(data.orderList == "noLogin"){
                    alert("您还未登录，请先登录");
                }else if(data.orderList == "systemError"){
                    alert("获取数据失败");
                }else{
                    var paypen = data.orderList;
                    if(paypen.length == 0){
                        alert("查无信息~");
                    }else{
                        $("#twomodal").modal('show');
                        //viewModel.penoderdetail.setSimpleData(paypen);
                        for(var i = 0;i< paypen.length; i++){
                            paypen[i].saletype = paypen[i].saletype ==0?"无":(paypen[i].saletype ==1?"限时促销":(paypen[i].saletype ==2?"团购":"众筹预售"));
                           //处理返回值的特殊情况。针对可能出现的空值以及日期
                            if(paypen[i].createdatetime ==null){
                                paypen[i].createdatetime = "";
                            }else{
                                paypen[i].createdatetime = new Date(paypen[i].createdatetime).Format("yyyy-MM-dd");
                            }
                            if(paypen[i].paydatetime ==null){
                                paypen[i].paydatetime = "";
                            }else{
                                paypen[i].paydatetime = new Date(paypen[i].paydatetime).Format("yyyy-MM-dd");
                            }
                            if(paypen[i].startdeliverytime ==null){
                                paypen[i].startdeliverytime = "";
                            }else{
                                paypen[i].startdeliverytime = new Date(paypen[i].startdeliverytime).Format("yyyy-MM-dd");
                            }
                            if(paypen[i].finishidatetime ==null){
                                paypen[i].finishidatetime = "";
                            }else{
                                paypen[i].finishidatetime = new Date(paypen[i].finishidatetime).Format("yyyy-MM-dd");
                            }

                            if(paypen[i].invoicetitle == null){
                                paypen[i].invoicetitle ="";
                            }
                            if(paypen[i].delivercycle == null){
                                paypen[i].delivercycle ="";
                            }
                            if(paypen[i].comments == null){
                                paypen[i].comments ="";
                            }
                            var _tr = $("<tr><td>"+paypen[i].productname+
                                        "</td><td>"+paypen[i].price+
                                        "</td><td>"+paypen[i].quantity+
                                        "</td><td>"+paypen[i].saletype+
                                        "</td><td>"+paypen[i].invoicetitle+
                                        "</td><td>"+paypen[i].createdatetime+
                                        "</td><td>"+paypen[i].paydatetime+
                                        "</td><td>"+paypen[i].delivercycle+
                                        "</td><td>"+paypen[i].comments+
                                        "</td><td>"+paypen[i].startdeliverytime+
                                        "</td><td>"+paypen[i].finishidatetime+
                                        "</td></tr>");
                             $("#twomodal tbody").append(_tr);
                        }
                    }
                }
            }
        })
}
//在待发货处给物流中心完善物流信息
function delivery(arg){
    
    var orderid = arg;
    $("#delivery").modal('show');
   
    $('#form1')[0].reset();//清空form表单
    $("#save").click(function(){
        var deliveryid = $('#deliveryid').val();
        var deliverycompany = $('#deliverycompany').val();
        var fadate = $('#fadate').val();
        if(deliveryid == '' || deliverycompany == ''|| fadate == ''){
            alert("请填写全部信息！");
            return false;
        }else{
            $.ajax({
                type:'post',
                data:{"orderinfo.orderid":orderid,"orderinfo.deliveryid":deliveryid,"orderinfo.deliverycompany":deliverycompany,"orderinfo.startdeliverytime":fadate},
                url:'../Order_deliver',
                success:function(data){
                    $("#delivery").modal('hide');
                    if(data.state == "success"){
                        alert("该订单操作发货成功");
                    }else if(data.state == "noLogin"){
                        alert("请重新登录");
                    }else{
                        alert("保存失败");
                    }
                   
                }
            })
        }
    })
}
/**
 * 待付款
 */
 function penpay(){
    $("#orderone tbody").html("");
    $.ajax({
        type:'post',
        data:{orderstate:1},
        url:'../Order_getPendPay',
        success:function(data){
            if(data.orderList == "noLogin"){
                alert("您还未登录，请先登录");
            }else if(data.orderList == "systemError"){
                alert("获取数据失败");
            }else{
                var paypen = data.orderList;
                if(paypen.length == 0){
                    //alert("查无信息~");
                    $("#orderone table").hide();
                }else
                for(var i = 0;i< paypen.length; i++){
                    var _tr = $("<tr><td>"+paypen[i].companyname+
                                "</td><td>"+paypen[i].managername+
                                "</td><td>"+paypen[i].managerphone+
                                "</td><td>"+paypen[i].lastprice+
                                "</td><td>"+"<i class=\"glyphicon glyphicon-eye-open\" onclick=\"checkdetail("+paypen[i].orderid+")\"></i>"+
                                "</td></tr>");
                     $("#orderone tbody").append(_tr);
                }
                
            }

        }
    })
}
/**
 * 待发货
 */
 function fordeliver(){
    $("#ordertwo tbody").html("");
    $.ajax({
        type:'post',
        data:{orderstate:2},
        url:'../Order_getPendPay',
        success:function(data){
            if(data.orderList == "noLogin"){
                alert("您还未登录，请先登录");
            }else if(data.orderList == "systemError"){
                alert("获取数据失败");
            }else{
                var paypen = data.orderList;
                if(paypen.length == 0){
                    $("#ordertwo table").hide();
                    //alert("查无信息~");
                }else
                for(var i = 0;i< paypen.length; i++){
                    //处理空字符串
                    if(paypen[i].usedpoints == null){
                        paypen[i].usedpoints ="";
                    }
                    if(paypen[i].usedwalletamount == null){
                        paypen[i].usedwalletamount = "";
                    }
                    if(paypen[i].usedthirdpayment == null){
                        paypen[i].usedthirdpayment = "";
                    }
                    var _tr = $("<tr><td>"+paypen[i].companyname+
                                "</td><td>"+paypen[i].managername+
                                /*"</td><td>"+paypen[i].managerphone+*/
                                "</td><td>"+paypen[i].usedpoints+
                                "</td><td>"+paypen[i].usedwalletamount+
                                "</td><td>"+paypen[i].usedthirdpayment+
                                "</td><td>"+paypen[i].consigneeaddress+
                                "</td><td>"+paypen[i].consigneename+
                                "</td><td>"+paypen[i].consigneephone+
                                "</td><td>"+paypen[i].lastprice+
                                "</td><td>"+
                               /*"<i class=\"glyphicon glyphicon-edit\" onclick=\"delivery("+paypen[i].orderid+")\"></i>"+*/
                                "<i class=\"glyphicon glyphicon-eye-open\" onclick=\"checkdetail("+paypen[i].orderid+")\"></i>"+
                                "</td></tr>");
                     $("#ordertwo tbody").append(_tr);
                }
                
            }

        }
    })
}
/**
 * 代收货
 */
 function forreceipt(){
    $("#orderthree tbody").html("");
    $.ajax({
        type:'post',
        data:{orderstate:3},
        url:'../Order_getPendPay',
        success:function(data){
            if(data.orderList == "noLogin"){
                alert("您还未登录，请先登录");
            }else if(data.orderList == "systemError"){
                alert("获取数据失败");
            }else{
                var paypen = data.orderList;
                if(paypen.length == 0){
                    //alert("查无信息~");
                    $("#orderthree table").hide();
                }else
                for(var i = 0;i< paypen.length; i++){
                    //处理空字符串
                    if(paypen[i].usedpoints == null){
                        paypen[i].usedpoints ="";
                    }
                    if(paypen[i].usedwalletamount == null){
                        paypen[i].usedwalletamount = "";
                    }
                    if(paypen[i].usedthirdpayment == null){
                        paypen[i].usedthirdpayment = "";
                    }
                    var _tr = $("<tr><td>"+paypen[i].companyname+
                                "</td><td>"+paypen[i].managername+
                               /* "</td><td>"+paypen[i].managerphone+*/
                                "</td><td>"+paypen[i].usedpoints+
                                "</td><td>"+paypen[i].usedwalletamount+
                                "</td><td>"+paypen[i].usedthirdpayment+
                               /* "</td><td>"+paypen[i].consigneeaddress+*/
                                "</td><td>"+paypen[i].consigneename+
                                "</td><td>"+paypen[i].consigneephone+
                                "</td><td>"+paypen[i].deliveryid+
                                "</td><td>"+paypen[i].deliverycompany+
                                "</td><td>"+paypen[i].lastprice+
                                "</td><td>"+
                                "<i class=\"glyphicon glyphicon-eye-open\" onclick=\"checkmore("+paypen[i].orderid+")\"></i>"+
                                "</td></tr>");
                     $("#orderthree tbody").append(_tr);
                }
                
            }

        }
    })
}
/**
 * 待评价
 */
 function forcomment(){
    
    $("#orderfour tbody").html("");
    $.ajax({
        type:'post',
        data:{orderstate:4},
        url:'../Order_getPendPay',
        success:function(data){
            if(data.orderList == "noLogin"){
                alert("您还未登录，请先登录");
            }else if(data.orderList == "systemError"){
                alert("获取数据失败");
            }else{
                var paypen = data.orderList;
                if(paypen.length == 0){
                    //alert("查无信息~");
                    $("#orderfour table").hide();
                }else
                for(var i = 0;i< paypen.length; i++){
                    //处理空字符串
                    if(paypen[i].usedpoints == null){
                        paypen[i].usedpoints ="";
                    }
                    if(paypen[i].usedwalletamount == null){
                        paypen[i].usedwalletamount = "";
                    }
                    if(paypen[i].usedthirdpayment == null){
                        paypen[i].usedthirdpayment = "";
                    }
                    var _tr = $("<tr><td>"+paypen[i].companyname+
                                "</td><td>"+paypen[i].managername+
                                /*"</td><td>"+paypen[i].managerphone+*/
                                "</td><td>"+paypen[i].usedpoints+
                                "</td><td>"+paypen[i].usedwalletamount+
                                "</td><td>"+paypen[i].usedthirdpayment+
                                /*"</td><td>"+paypen[i].consigneeaddress+*/
                                "</td><td>"+paypen[i].consigneename+
                                "</td><td>"+paypen[i].consigneephone+
                                "</td><td>"+paypen[i].deliveryid+
                                "</td><td>"+paypen[i].deliverycompany+
                                "</td><td>"+paypen[i].lastprice+
                                "</td><td>"+
                                "<i class=\"glyphicon glyphicon-eye-open\" onclick=\"checkmore("+paypen[i].orderid+")\"></i>"+
                                "</td></tr>");
                     $("#orderfour tbody").append(_tr);
                }
                
            }

        }
    })
}
//已完成
function finish(){
    $("#orderfive tbody").html("");
    $.ajax({
        type:'post',
        data:{orderstate:6},
        url:'../Order_getPendPay',
        success:function(data){
            if(data.orderList == "noLogin"){
                alert("您还未登录，请先登录");
            }else if(data.orderList == "systemError"){
                alert("获取数据失败");
            }else{
                var paypen = data.orderList;
                if(paypen.length == 0){
                    //alert("查无信息~");
                    $("#orderfive table").hide();
                }else
                for(var i = 0;i< paypen.length; i++){
                    //处理空字符串
                    if(paypen[i].usedpoints == null){
                        paypen[i].usedpoints ="";
                    }
                    if(paypen[i].usedwalletamount == null){
                        paypen[i].usedwalletamount = "";
                    }
                    if(paypen[i].usedthirdpayment == null){
                        paypen[i].usedthirdpayment = "";
                    }
                    var _tr = $("<tr><td>"+paypen[i].companyname+
                                "</td><td>"+paypen[i].managername+
                               /* "</td><td>"+paypen[i].managerphone+*/
                                "</td><td>"+paypen[i].usedpoints+
                                "</td><td>"+paypen[i].usedwalletamount+
                                "</td><td>"+paypen[i].usedthirdpayment+
                                /*"</td><td>"+paypen[i].consigneeaddress+*/
                                "</td><td>"+paypen[i].consigneename+
                                "</td><td>"+paypen[i].consigneephone+
                                "</td><td>"+paypen[i].deliveryid+
                                "</td><td>"+paypen[i].deliverycompany+
                                "</td><td>"+paypen[i].lastprice+
                                "</td><td>"+
                                "<i class=\"glyphicon glyphicon-eye-open\" onclick=\"checkmore("+paypen[i].orderid+")\"></i>"+
                                "</td></tr>");
                     $("#orderfive tbody").append(_tr);
                }
                
            }

        }
    })
}
function wuliu(){
     $("#ordersix tbody").html("");
    $.ajax({
        type:'post',
        data:{orderstate:0},
        url:'../Order_getPendPay',
        success:function(data){
            if(data.orderList == "noLogin"){
                alert("您还未登录，请先登录");
            }else if(data.orderList == "systemError"){
                alert("获取数据失败");
            }else{
                var paypen = data.orderList;
                if(paypen.length == 0){
                    $("#ordersix table").hide();
                    //alert("查无信息~");
                }else
                for(var i = 0;i< paypen.length; i++){
                    //处理空字符串
                    if(paypen[i].usedpoints == null){
                        paypen[i].usedpoints ="";
                    }
                    if(paypen[i].usedwalletamount == null){
                        paypen[i].usedwalletamount = "";
                    }
                    if(paypen[i].usedthirdpayment == null){
                        paypen[i].usedthirdpayment = "";
                    }
                    var _tr = $("<tr><td>"+paypen[i].companyname+
                                "</td><td>"+paypen[i].managername+
                                /*"</td><td>"+paypen[i].managerphone+*/
                                "</td><td>"+paypen[i].usedpoints+
                                "</td><td>"+paypen[i].usedwalletamount+
                                "</td><td>"+paypen[i].usedthirdpayment+
                                "</td><td>"+paypen[i].consigneeaddress+
                                "</td><td>"+paypen[i].consigneename+
                                "</td><td>"+paypen[i].consigneephone+
                                "</td><td>"+paypen[i].lastprice+
                                "</td><td>"+
                               "<i class=\"glyphicon glyphicon-edit\" onclick=\"delivery("+paypen[i].orderid+")\"></i>"+
                                "<i class=\"glyphicon glyphicon-eye-open\" onclick=\"checkdetail("+paypen[i].orderid+")\"></i>"+
                                "</td></tr>");
                     $("#ordersix tbody").append(_tr);
                }
                
            }

        }
    })
}
