
//新增
function add_delivery(){
   var username = $("#id").val();
   var password = $("#password").val();
   if(username == "" || password == ""){
    return false;
   }
    $.ajax({
        type:'post',
        url:'../User_addLogisticsCenter',
        data:{"userinfo.username":username,"userinfo.password":password},
        success:function(data){
            if(data.state == "success"){
                alert("添加成功")
            }else{
                alert("添加失败");
            }
        }
    })
}
//页面初始就加载list
$(function(){
    /*var str = "";
    var obj;
    var arr = [];*/
    $("#station tbody").html("");
    $.ajax({
        type:'post',
        url:'Company_getDelivery',
        success:function(data){
            if(data){
                var d = data.deliveryList;
                for (var i = 0; i < d.length; i++) {
                    var _tr = $("<tr><td>"+d[i][1]+
                                
                                "</td><td>"+d[i][2]+
                                "</td><td>"+d[i][3]+
                                "</td><td>"+d[i][4]+
                                "</td><td>"+d[i][5]+
                               
                                "</td><td>"+"<i class=\"glyphicon glyphicon-trash\" onclick=\"deleteStation("+d[i][0]+")\"></i>"+
                               /* "</td><td>"+paypen[i].startdeliverytime+
                                "</td><td>"+paypen[i].finishidatetime+*/
                                "</td></tr>");
                   $("#station tbody").append(_tr);
                }
            }else{
                $("#station table").hide();
            }
        }
    })
})
function deleteStation(arg){
    var id = arg;
    var  conf = confirm("确定删除吗？删除之后，所属区域查看商品、管理有误");
    // if(conf){
    //     $.ajax({
    //         type:'post',
    //         url:'Company_deleteDelivery',
    //         data:{"id":id},
    //         success:function(data){
    //             var state = data.delivery;
    //             if(state == "null"){
    //                 alert("请稍后再做修改，目前物流中心尚未完善自己的信息！");
    //             }else if(state == "ok"){
    //                 alert("删除成功~");
    //             }
    //         }
    //     })
    // }
}