var id;

function getId () {
  //获取登录的id
  $.ajax({
    type:'post',
    url:'../Company_sendName',
    success: function(data){
      if(data){
        id =data.companyid;
        if(id == ""){
          window.location.href = "login.html";
        }else
        {
          
        }
      }
    }
  })

}
//获取地图信息
$("#modalshow").click(function(){
  $("#delivermap").modal('show');
})
//隐藏地图
function dhide(){
  $("#delivermap").modal('hide');
}
var province;
var city;
var borough;
var road;
function saveAddress(){
  /*省市县街道*/
    province = $("#province").val();//省
    city = $("#city").val();
    borough = $("#borough").val();
    road = $("#detailId").val();
    $("#address").attr("value",province+city+borough+road);//显示详细地址
    $("#modalshow").attr("value",province);
    $("#delivermap").modal('hide');
  }

function conprovince(){
  if(id == undefined){
    alert("请先登录，否则不能完善省份");
    return false;
  }
  province = $("#province").val();
  address = $("#address").val();
  var companyname = $("#cname").val();
  var managername = $("#mname").val();
  var managerphone = $("#mphone").val();
  var lng = $("#lng").val();
  var lat = $("#lat").val();
 //md5加密
 var paypsw = hex_md5($("#paypsw").val());
 var conpaypsw = hex_md5($("#conpaypsw").val());

 //手机格式验证
 var phonereg = /^1\d{10}$/;
 if(province == "" || companyname == "" || address == "" || managername == "" || managerphone == "" || conpaypsw == ""){
  alert("请完善全部信息");
  return false;
  }
  if(lng == "" || lat == ""){
    alert("请在地图处标注位置");
    return false;
  }
  if(!phonereg.test(managerphone)){
    alert("手机号格式不正确");
    return false;
  }
  if(paypsw != conpaypsw){
    alert("两次密码输入不一致");
    return false;
  }
  else{ 
    $.ajax({
      type:'post',
      data:{"companyid":id,"companyname":companyname,"detailaddress":address,"province":province,"city":city,
      "district":borough,"detailaddress":road,"longitude":lng,"latitude":lat,"managername":managername,"managerphone":managerphone,
      "paypassword":conpaypsw},
      url:'../Company_setDeProVince',
      success:function(data){
        if(data){
          if(data.state == "success"){
            alert("恭喜，完善省份成功 ~");
            window.location.href="./index.html";  
          }else{
            alert("完善省份失败，请重试");
          }
        }
      }
    })
  }
}