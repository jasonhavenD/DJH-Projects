//模态框的显隐
$("#detailaddress").click(function(){
    $("#modifybaseinfo").modal('show');
})
$("#dhide").click(function(){
    $("#modifybaseinfo").modal('hide');
})
//初始状态是未申请
$("#unapply").addClass("bgcolor");
//获取会员在company表的state值，判断是 新增还是修改。修改的话，company表的state值=1。
//获取id值，用于修改
var cstate;
var id;
//获取用户名和会员状态
function getName(){
     $("#ordinary").html("");
     $("#applystate").html("");
    $.ajax({
        type:'post',
        async:false,
        url:'../Company_sendName',
        success: function(data){
            if(data){
                id = data.companyid;//获取id
                
                $("#memtype").attr("value",data.membertype);
                type = $("#memtype").val();

                if(type == 4){
                    $("#ordinary").html("普通经销商");
                }
                //认证经销商
                if(type == 3){
                    $("#ordinary").html("认证经销商");
                    $("#ordinaryper").find("a").html("修改认证经销商信息");
                }
            }
        }
    })
    $.ajax({
        type:'post',
        url:'../Company_isExist',
        data:{"companyid":id},
        success:function(data){
            if(data.state == "error"){
                alert("系统错误");
            }else if(data.state.length == 0){
                cstate =0;//不存在
            }else{
                cstate = data.state[0][0];//存在
                if(cstate == 1){
                    $("#applystate").html("未申请");
                }else if(cstate == 6){
                    $("#applystate").html("申请通过");
                }else if(cstate == 2 || cstate == 4){
                    $("#applystate").html("正在审核");
                }else if(cstate == 3 || cstate == 5){
                    $("#applystate").html("申请不通过");
                }
            }
        }
    })
}
//保存地址到详细地址一栏
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
    $("#detailaddress").attr("value",province+city+borough+road);//显示详细地址
    $("#modifybaseinfo").modal('hide');
}
function dhide(){
    $("#modifybaseinfo").modal('hide');
}
//提交个人资料
function confirm(){
    //保存个人资料
    /*经纬度*/
    var lng = $("#lng").val();
    var lat = $("#lat").val();
    //其他信息
    var managername = $("#managername").val();
    var companyname = $("#companyname").val();
    var managerphone = $("#managerphone").val();
    var email = $("#email").val();
    var fixphone = $("#fixphone").val();
    //密码加密
    var paypassword = hex_md5($("#paypassword").val());

    var phonereg = /^1\d{10}$/;
    if(managername == ""){
        alert("请完善必填项~");
        return false;
    }
    if(companyname == ""){
        alert("请完善必填项~");
        return false;
    }
    if(managerphone == ""){
        alert("请完善必填项~");
        return false;
    }else{
        if(!phonereg.test(managerphone)){
            alert("手机格式不正确");
            return false;
        }
    }
    if($("#detailaddress").val() == ""){
        alert("请完善必填项~");
        return false;
    }
    if(paypassword == ""){
        alert("请完善必填项~");
        return false;
    }
   if(lng == "" && lat ==""){
        alert("请在地图上标注位置，出现红色坐标表示已经标记。");
        return false;
    }
    if(id == undefined){
        alert("请重新登陆");
        return false;
    }
    //判断是修改还是新增
    if(cstate){//修改
        $.ajax({
            type:'post',
            //dataType:'json',
            data:{"companyid":id,"managerphone":managerphone,"managername":managername,"companyname":companyname,"province":province,"city":city,
            "district":borough,"detailaddress":road,"longitude":lng,"latitude":lat,
            "email":email,"fixphone":fixphone,"paypassword":paypassword,"state":cstate},
            url:'../Company_updatePersonal',
            success:function(data){
                if(data.state == 'success'){
                    alert("保存成功，可到个人资料查看~");
                    //$(".modifyperson").find("button").hide();
                    $(".modifyperson").find("input").attr("disabled","disabled");
                }else if(data.state == "noLogin"){
                    alert("请重新登陆");
                }else{
                    alert("保存失败");
                }
            }
        })
    }else{//新增
        $.ajax({
            type:'post',
            //dataType:'json',
           data:{"company.managerphone":managerphone,"company.managername":managername,"company.companyname":companyname,"company.province":province,"company.city":city,
            "company.district":borough,"company.detailaddress":road,"company.longitude":lng,"company.latitude":lat,
            "company.email":email,"company.fixphone":fixphone,"company.paypassword":paypassword},
            url:'../Company_changePersonalInfo',
            success:function(data){
                if(data.uploadState == 'success'){
                    alert("保存成功，可到个人资料查看~");
                    //$(".modifyperson").find("button").hide();
                    $(".modifyperson").find("input").attr("disabled","disabled");
                }else if(data.uploadState == "noLogin"){
                    alert("请重新登陆");
                }else{
                    alert("保存失败");
                }
            }
        })
    }
}
//返回状态

//申请成为认证经销商
$("#image").change(function(){
var fileName = $(this).val().toString();
var filenm = fileName.substring(fileName.indexOf(".")+1);
var filesType="png|jpg|gif|jpeg|tag|tiff|bm|svg|pcx|dxf|wmf|emf|lic|fli|flc|eps|tga";
if(!(eval("/" +filesType + "$/i").test(filenm))){
    $("#typeCheckOut").css("display","inline");
    $(this).val('');
    $(this).focus();
}else{
    $("#typeCheckOut").css("display","none");
}
});
function test(){
    alert("执行");
    $.post("../Company_getAuthenticateCompanyList",{"state":1},function(data){
        alert(data.authenticateCompanyList.length);
        var array = new Array(data.authenticateCompanyList.length);
        array = data.authenticateCompanyList;
        var array1 = new Array();
        for(var i = 0; i < array.length; i++){
            array1 = array[i];
            for(var j = 0 ; j < array1.length; j++){
                $(".showpic").append(array1[j]+" ");
            }
            //$("body").append("<br/>");
        }
    });
}
function uploadImage(){
    $('#myform').ajaxSubmit({
        dataType:'json',
        success:function(data){
            $("#myform").append("<img width='400px' height='350px' src='../"+data.imagepath+"'/> ");
        },
        error:function(xhr){
            alert('上传失败');
        }
    });
}
function uploadImage1(){
    $('#myform1').ajaxSubmit({
        dataType:'json',
        success:function(data){
            $("#myform1").append("<img width='400px' height='350px' src='../"+data.imagepath1+"'/> ");
        },
        error:function(xhr){
            alert('上传失败');
        }
    });
}
function uploadImage2(){
    $('#myform2').ajaxSubmit({
        dataType:'json',
        success:function(data){
            $("#myform2").append("<img width='400px' height='350px' src='../"+data.imagepath2+"'/> ");  
            $("#ordinaryper").find("a").html("修改认证经销商信息"); 
        },
        error:function(xhr){
            alert('上传失败');
        }
    });
}

//更改状态
function authenticate(){
    var cid;
     $.ajax({
        type:'post',
        url:'../Company_sendName',
        success: function(data){
            if(data){
                $("#cid").attr("value",data.companyid);
                cid = $("#cid").val();
                //更改状态
                 $.ajax({
                    type:'post',
                    data:{"companyid":cid,"state":"2"},
                    url:'../Company_changeState',
                    success:function(res){
                        if(res.state == "success"){
                            alert("提交审核材料成功，请耐心等候~");
                        }else{
                            alert("提交审核材料失败，请重试！");
                        }
                    }
                })
            }
        }
    })
}
/*修改登陆密码*/
//验证原密码
var oldpassword;
var newpasswd;
var pwdconfirm;
function testOld(){
    var one = $("#oldpassword").val();
    if(one==""){
        //$("#oldpassword").parent().clear();
        $("#oldwarn").text("不能为空");
    }else{
    oldpassword = hex_md5(one);
        $.ajax({
            type:'post',
            data:{"userinfo.password":oldpassword},
            url:'../User_isTruePassword',
            success:function(data){
                if(data.state == "no"){
                    $("#oldwarn").text("密码错误");
                }else{
                    $("#oldwarn").text("");
                }
            }
        })
    }
}
//验证两次
function confirmpwd(){
    var pw = $("#newpasswd").val();
    var confirm = $("#pwdconfirm").val();
    newpasswd = hex_md5(pw);
    pwdconfirm = hex_md5(confirm);
    if(pw == "" || confirm == ""){
        $("#pwdwarn").text("不能为空");
    }else
    {
        if(newpasswd == pwdconfirm){
           $("#pwdwarn").text("");
        }else{
            $("#pwdwarn").text("两次输入不一致");
        }
    }
}
//提交
function modipasswd(){
   /* if(oldpassword == d41d8cd98f00b204e9800998ecf8427e || newpasswd == "" || pwdconfirm == ""){
        return false;
        }else
        {*/
            $.ajax({
                 type:'post',
                 data:{"userinfo.password":pwdconfirm},
                 url:'../User_changePassword',
                 success:function(data){
                     if(data.state == "timeout"){
                         alert("修改密码失败");
                     }else{
                         alert("修改密码成功");
                         window.location.href("showperson.html");
                     }
                 }
         })
   /* }*/
}

