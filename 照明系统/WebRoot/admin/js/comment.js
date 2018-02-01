function forcomment(){
    
    $("#zero tbody").html("");
    $.ajax({
        type:'post',
        url:'../Comment_checkComment',
        success:function(data){
            if(data.state == "fail"){
                alert("获取数据失败");
            }else{
                var com = data.state;
                if(com.length == 0){
                    $("#zero table").hide();
                }else
                for(var i = 0;i< com.length; i++){
                
                    var _tr = $("<tr><td>"+com[i].productname+
                                "</td><td>"+com[i].companyname+
                                "</td><td>"+com[i].commentcontent+
                                "</td><td>"+
                                "<i class=\"glyphicon glyphicon-ok-circle\" onclick=\"yes("+com[i].commentid+")\"></i>"+
                                "<i class=\"glyphicon glyphicon-remove-circle\" onclick=\"no("+com[i].commentid+")\"></i>"+
                                "</td></tr>");
                     $("#zero tbody").append(_tr);
                }
                
            }

        }
    })
}
function yes(arg){
    var commentid = arg;
    $.ajax({
        type:'post',
        data:{"state":2,"commentid":commentid},
        url:'../Comment_yesOrNo',
        success:function(data){
            if(data.state == "success"){
                alert("该评论审核通过");
            }else{
                alert("请稍后重试");
            }
        }
    })
}
function no(arg){
    var commentid = arg;
    $.ajax({
        type:'post',
        data:{"state":1,"commentid":commentid},
        url:'../Comment_yesOrNo',
        success:function(data){
            if(data.state == "success"){
                alert("该评论审核不通过");
            }else{
                alert("请稍后重试");
            }
        }
    })
}

function stateTwo(){
    $("#two tbody").html("");
    $.ajax({
        type:'post',
        url:'Comment_stateTwo',
        success:function(data){
            if(data.state == "fail"){
                alert("查询失败");
            }else{
                var com = data.state;
                if(com.length == 0){
                    $("#two table").hide();
                }else
                for(var i = 0;i< com.length; i++){
                
                    var _tr = $("<tr><td>"+com[i].productname+
                                "</td><td>"+com[i].companyname+
                                "</td><td>"+com[i].commentcontent+
                               /* "</td><td>"+
                                "<i class=\"glyphicon glyphicon-ok-circle\" onclick=\"yes("+com[i].commentid+")\"></i>"+
                                "<i class=\"glyphicon glyphicon-remove-circle\" onclick=\"no("+com[i].commentid+")\"></i>"+*/
                                "</td></tr>");
                     $("#two tbody").append(_tr);
                }
            }
        }
    })
}