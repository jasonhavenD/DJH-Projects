
    /*var cid;
    $.ajax({
        type:'post',
        async:false,
        url:'../Company_sendName',
        success: function(data){
            if(data){
                $("#username").append(data.userName);
                $("#memtype").attr("value",data.state);
                $("#cid").attr("value",data.companyid);
                cid = $("#cid").val();
                //会员状态的显隐
                var state = $("#memtype").val();
                if(state == 3){//完善资料
                    //$("#infoform").hide();//隐藏表单
                }
                if(state == 1){
                    //$("#ordinaryper").find("a").html("修改认证经销商信息");
                }
            }
        }
    })*/
    //获取经销商信息 展示

    $.ajax({
        type:'post',
        url:'../Company_getCompanyInfo',
        success:function(data){
           if(data.company.length != 0){
                var c = data.company;
                var detail =c[0][3]+c[0][4]+c[0][5]+c[0][6];
               // $("#mnameshow").attr("value",c.managername);
                $("#deddressshow").attr("value",detail);
                $("#cnameshow").attr("value",c[0][0]);
                $("#mnameshow").attr("value",c[0][1]);
                $("#mphoneshow").attr("value",c[0][2]);
                $("#fixphoneshow").attr("value",c[0][8]);
                $("#emailshow").attr("value",c[0][7]);
                $("#codeshow").attr("value",c[0][9]);
                $(".modifyperson").find("input").attr("disabled","disabled");
            }else if(data.company == "noLogin"){
                alert("请重新登录");
            }
        }
    })
