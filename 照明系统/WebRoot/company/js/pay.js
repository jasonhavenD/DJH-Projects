var orderid = $("#orderid"); 
//var lastprice = $("#money"); 
orderid = orderid[0].innerHTML;

var flag;
function testOld(){
    var one = $("#oldpay").val();
    if(one == ""){
        //$("#oldpassword").parent().clear();
        $("#oldwarn").text("不能为空");
    }else{
        $("#oldwarn").text("");
        var oldpay = hex_md5(one);
        $.ajax({
            type:'post',

            url:'../Company_getCompanyInfo',
            success:function(data){
                if(data.company.length != 0){
                 var c = data.company;
                 if(c[0][10] == oldpay){
                    $("#oldwarn").text("验证通过");
                    flag = true;
                }else{
                    $("#oldwarn").text("验证密码不通过");
                    flag = false;
                }
            }
        }
    })

    }
}
$("#yes").click(function(){
     var conf = confirm('确定该订单吗？');
    if(flag && conf){
        $.ajax({
            type:'post',
            url:'../Order_pay',
            data:{"orderid":orderid},
            success:function(data){
               if(data.state == "success"){
                  alert("付款成功~谨防上当受骗");
                  window.location.href = "index.jsp";
              }else{
                  alert("付款失败，请稍后重试~");
              }
          }
      })
    }
	
})