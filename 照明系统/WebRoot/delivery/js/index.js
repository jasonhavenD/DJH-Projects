/*function getPRovince(){
    $.ajax({
        type:'post',
        url:'Company_getProvince',
        success:function(data){
            if(data){
                $("#province").append(data.province);
            }
        }
    })
}*/
$("#out").click(function(){
	$.ajax({
		type:'post',
		url:'../User_exit',
		success:function(data){
			if(data.exit == "success"){
				window.location.href = "login.html";
			}
		}
	})
})