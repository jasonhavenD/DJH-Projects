//实现查看详情 将值放入
var str= "";
var obj ;
var arr = [];
//根据状态值查看会员基本信息，查看申请、通过、未通过
function changeState(arg){
    //清空
    str="";
    arr=[];
    $("#certified tbody").html("");
    $("#checkyes tbody").html("");
    $("#checkno tbody").html("");
    $.ajax({
        type:'post',
        data:{"state":arg},
        url:'../Company_getAuthenticateCompanyList',
        success:function(data){
            var c =data.authenticateCompanyList;
            if(c.length){
                for(var i=0;i<c.length;i++){
                    for(var j=0;j< c[0].length;j++){
                    //去除null
                        if(c[i][j] == null){
                            c[i][j] = "";
                        }
                    }
                    var _tr = $("<tr><td>"+c[i][1]+
                        "</td><td>"+c[i][2]+
                        "</td><td>"+c[i][3]+
                        "</td><td>"+c[i][4]+c[i][5]+c[i][6]+c[i][7]+
                       /* "</td><td>"+c[i][9]+
                        "</td><td>"+c[i][10]+
                        "</td><td>"+c[i][11]+
                        "</td><td>"+c[i][12]+*/
                              /*  "</td><td>"+"/LightSystem"+c[i][13]+
                                "</td><td>"+"/LightSystem"+c[i][14]+
                                "</td><td>"+"/LightSystem"+c[i][15]+*/
                                "</td><td>"+"<i class=\"glyphicon glyphicon-check\" onclick=\"checkdetail("+c[i][0]+")\"></i>"+"<i class=\"glyphicon glyphicon-trash\" onclick=\"deletecerti("+c[i][0]+")\"></i>"+
                                "</td></tr>");
                    var tr_check = $("<tr><td>"+c[i][1]+
                        "</td><td>"+c[i][2]+
                        "</td><td>"+c[i][3]+
                        "</td><td>"+c[i][4]+c[i][5]+c[i][6]+c[i][7]+
                       /* "</td><td>"+c[i][9]+
                        "</td><td>"+c[i][10]+
                        "</td><td>"+c[i][11]+
                        "</td><td>"+c[i][12]+*/
                              /*  "</td><td>"+"/LightSystem"+c[i][13]+
                                "</td><td>"+"/LightSystem"+c[i][14]+
                                "</td><td>"+"/LightSystem"+c[i][15]+*/
                                "</td><td>"+"<i class=\"glyphicon glyphicon-check\" onclick=\"checkdetail("+c[i][0]+")\"></i>"+
                                "</td><td>"+"<i class=\"glyphicon glyphicon-ok-circle\" onclick=\"yes("+c[i][0]+")\"></i>"+"<i class=\"glyphicon glyphicon-remove-circle\" onclick=\"no("+c[i][0]+")\"></i>"+
                                "</td></tr>");

                    if(arg == 2 ){//申请
                        $("#certified tbody").append(tr_check);
                    }
                    if(arg == 4){//通过查看
                        $("#checkyes tbody").append(_tr);
                    }
                    if(arg == 3){//不通过查看
                        $("#checkno tbody").append(tr_check);
                    }
                    str = "\{"+"\'"+"companyid"+"\'"+"\:"+c[i][0]+"\,"+
                    "\'"+"companyname"+"\'"+"\:"+"\'"+c[i][1]+"\'"+"\,"+
                    "\'"+"managername"+"\'"+"\:"+"\'"+c[i][2]+"\'"+"\,"+
                    "\'"+"managerphone"+"\'"+"\:"+"\'"+c[i][3]+"\'"+"\,"+
                    "\'"+"detail"+"\'"+"\:"+"\'"+c[i][4]+c[i][5]+c[i][6]+c[i][7]+"\'"+"\,"+
                    "\'"+"email"+"\'"+"\:"+"\'"+c[i][8]+"\'"+"\,"+
                    "\'"+"fixphone"+"\'"+"\:"+"\'"+c[i][9]+"\'"+"\,"+
                    "\'"+"birthday"+"\'"+"\:"+"\'"+c[i][10]+"\'"+"\,"+
                    "\'"+"zipcode"+"\'"+"\:"+"\'"+c[i][11]+"\'"+"\,"+
                    "\'"+"cardpic"+"\'"+"\:"+"\'"+"/LightSystem"+c[i][12]+"\'"+"\,"+
                    "\'"+"licensepic"+"\'"+"\:"+"\'"+"/LightSystem"+c[i][13]+"\'"+"\,"+
                    "\'"+"cpic"+"\'"+"\:"+"\'"+"/LightSystem"+c[i][14]+"\'"+"\,"+
                    "\}";
                    obj = eval('('+str+')');
                    arr.push(obj);
                }
                
            }else{
                //alert("查无信息~");
                if(arg == 2 ){//申请
                        $("#certified table").hide();
                    }
                    if(arg == 4){//通过查看
                        $("#checkyes table").hide();
                    }
                    if(arg == 3){//不通过查看
                        $("#checkno table").hide();
                    }
            }
        }

    })
}
//查看审核申请
function certifiedfn(){
    changeState(2);
}
//查看申请通过的经销商
function certifiedyes(){
    changeState(4);
}
//查看申请未通过的经销商
function certifiedno(){
    changeState(3);
}
//三个模态框的关闭
$("#idclose").click(function(){
    $("#idcard").modal('hide');
})
$("#licclose").click(function(){
    $("#licensepicture").modal('hide');
})
$("#picclose").click(function(){
    $("#picture").modal('hide');
}) 
//审核经销商
function yes(arg){
    var id = arg;//得到id
    $.ajax({
        type:'post',
        data:{"companyid": id,"state": "4"},
        url:'../Company_changeState',
        success:function(data){
            if(data.state == "success"){
                alert("审核通过,该会员已经成为认证经销商");
            }else if(data.state =="fail"){
                alert("审核失败");
            }else{
                alert("系统错误");
            }
        }

    })
}
function no(arg){
    var id = arg;//得到id
    $.ajax({
        type:'post',
        data:{"companyid": id,"state": "3"},
        url:'../Company_changeState',
        success:function(data){
            if(data.state == "success"){
                alert("审核未通过");
            }else if(data.state =="fail"){
                alert("审核失败");
            }else{
                alert("系统错误");
            }
        }

    })
}
/*普通经销商信息获取*/
function getcinfo(){
    $("#companyinfo tbody").html("");
    $.ajax({
        type:'post',
        /*dataType:'json',*/
        url:'../Company_getNormalByPro',
        success:function(data){
            var c =data.Normal;
            if(c.length){
                for(var i=0;i<c.length;i++){
                    for(var j=0;j< c[0].length;j++){
                    //去除null
                        if(c[i][j] == null){
                            c[i][j] = "";
                        }
                    }
                    var _tr = $("<tr><td>"+c[i][0]+
                        "</td><td>"+c[i][2]+
                        "</td><td>"+c[i][3]+
                        "</td><td>"+c[i][4]+
                        "</td><td>"+c[i][5]+c[i][6]+c[i][7]+c[i][8]+
                        "</td><td>"+c[i][9]+
                        "</td><td>"+c[i][10]+
                      /*  "</td><td>"+c[i][11]+
                        "</td><td>"+c[i][12]+*///信息太多，这两个暂不在页面上显示
                        "</td><td>"+"<i class=\"glyphicon glyphicon-trash\" onclick=\"deleteinfo("+c[i][1]+")\"></i>"+
                        "</td></tr>");
                    $("#companyinfo tbody").append(_tr);
                }

            }else{
                 $("#companyinfo table").hide();
            }
        }
    })
}
//删除
function deleteinfo(arg){
   var id = arg;
}
//获得认证经销商信息
function getCertified(){
    //清空别的影响
    str="";
    arr=[];
    $("#companycertifiedinfo tbody").html("");
    $.ajax({
        type:'post',
        dataType:'json',
        url:'../Company_getCertifiedByPro',
        success:function(data){
            var c =data.Certified;
            if(c.length){
                for(var i=0;i<c.length;i++){
                    for(var j=0;j< c[0].length;j++){
                        //去除null
                        if(c[i][j] == null){
                            c[i][j] = "";
                        }
                    }
                    var _tr = $("<tr><td>"+c[i][0]+
                        "</td><td>"+c[i][2]+
                        "</td><td>"+c[i][3]+
                        "</td><td>"+c[i][4]+
                        "</td><td>"+c[i][5]+c[i][6]+c[i][7]+c[i][8]+
                        "</td><td>"+c[i][9]+
                        "</td><td>"+c[i][10]+
                       /* "</td><td>"+c[i][11]+
                        "</td><td>"+c[i][12]+*/
                              /*  "</td><td>"+"/LightSystem"+c[i][13]+
                                "</td><td>"+"/LightSystem"+c[i][14]+
                                "</td><td>"+"/LightSystem"+c[i][15]+*/
                                "</td><td>"+"<i class=\"glyphicon glyphicon-check\" onclick=\"checkdetail("+c[i][1]+")\"></i>"+"<i class=\"glyphicon glyphicon-trash\" onclick=\"deletecerti("+c[i][1]+")\"></i>"+
                                "</td></tr>");
                    //实现查看，把这些信息放到数组对象中
                    str = "\{"+
                    "\'"+"username"+"\'"+"\:"+"\'"+c[i][0]+"\'"+"\,"+
                    "\'"+"companyid"+"\'"+"\:"+"\'"+c[i][1]+"\'"+"\,"+
                    "\'"+"companyname"+"\'"+"\:"+"\'"+c[i][2]+"\'"+"\,"+
                    "\'"+"managername"+"\'"+"\:"+"\'"+c[i][3]+"\'"+"\,"+
                    "\'"+"managerphone"+"\'"+"\:"+"\'"+c[i][4]+"\'"+"\,"+
                    "\'"+"detail"+"\'"+"\:"+"\'"+c[i][5]+c[i][6]+c[i][7]+c[i][8]+"\'"+"\,"+
                    "\'"+"email"+"\'"+"\:"+"\'"+c[i][9]+"\'"+"\,"+
                    "\'"+"fixphone"+"\'"+"\:"+"\'"+c[i][10]+"\'"+"\,"+
                    "\'"+"birthday"+"\'"+"\:"+"\'"+c[i][11]+"\'"+"\,"+
                    "\'"+"zipcode"+"\'"+"\:"+"\'"+c[i][12]+"\'"+"\,"+
                    "\'"+"cardpic"+"\'"+"\:"+"\'"+"/LightSystem"+c[i][13]+"\'"+"\,"+
                    "\'"+"licensepic"+"\'"+"\:"+"\'"+"/LightSystem"+c[i][14]+"\'"+"\,"+
                    "\'"+"cpic"+"\'"+"\:"+"\'"+"/LightSystem"+c[i][15]+"\'"+"\,"+
                    "\}";
                    obj = eval('('+str+')');
                    arr.push(obj);
                    $("#companycertifiedinfo tbody").append(_tr);
                }
            }else{
                //alert("查无信息~");
                $("#companycertifiedinfo table").append(_tr);
            }
        }
    })
}
//查看详情
function checkdetail(arg){
    $("#lookcompany").modal('show');
    var id =arg;
    for(var i = 0;i<arr.length;i++){
        if(id == arr[i].companyid){
            $("#managername").attr("value",arr[i].managername);
            $("#managerphone").attr("value",arr[i].managerphone);
            $("#companyname").attr("value",arr[i].companyname);
            $("#detaileaddress").attr("value",arr[i].detail);
            $("#email").attr("value",arr[i].email);
            $("#fixphone").attr("value",arr[i].fixphone);
            $("#zipcode").attr("value",arr[i].zipcode);
            $("#birthday").attr("value",arr[i].birthday);
            $("#sfz").attr("src",arr[i].cardpic);
            $("#yyzz").attr("src",arr[i].licensepic);
            $("#mtzp").attr("src",arr[i].cpic);
            $("#sfzbig").attr("src",arr[i].cardpic);
            $("#yyzzbig").attr("src",arr[i].licensepic);
            $("#mtzpbig").attr("src",arr[i].cpic);

        }
    }

}
//删除认证经销商
function deletecerti(arg){
    var id = arg;
}
