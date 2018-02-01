
var ww = document.body.clientWidth;

$(document).ready(function() {

	$(".nav li a").each(function() {
		if ($(this).next().length > 0) {
			$(this).addClass("parent");
		};
	})
	
	$(".toggleMenu").click(function(e) {
		e.preventDefault();
		$(this).toggleClass("active");
		$(".nav").toggle();
	});
	adjustMenu();
	/*一加载就显示 姓名*/
	$.ajax({
        type:'post',
        async:false,
        url:'../Company_sendName',
        success: function(data){
            if(data.state == "noLogin"){
                $("#showname").append("<a href=\"../html/logorreg.html\">登录/注册</a>");
            	alert("请重新登录~");
                window.location.href = "logorreg.html";
            }else{
                id = data.companyid;//获取id
                if(id){
                    $("#showname").append("<a href=\"javascript:void(0)\">您好~"+data.userName+"</a>");
                }
                $("#membertype").attr("value",data.membertype);
            }
        }
    })
})

$(window).bind('resize orientationchange', function() {
	ww = document.body.clientWidth;
	adjustMenu();
});

var adjustMenu = function() {
	if (ww < 800) {
		$(".toggleMenu").css("display", "inline-block");
		if (!$(".toggleMenu").hasClass("active")) {
			$(".nav").hide();
		} else {
			$(".nav").show();
		}
		$(".nav li").unbind('mouseenter mouseleave');
		$(".nav li a.parent").unbind('click').bind('click', function(e) {
			// must be attached to anchor element to prevent bubbling
			e.preventDefault();
			$(this).parent("li").toggleClass("hover");
		});
	} 
	else if (ww >= 800) {
		$(".toggleMenu").css("display", "none");
		$(".nav").show();
		$(".nav li").removeClass("hover");
		$(".nav li a").unbind('click');
		$(".nav li").unbind('mouseenter mouseleave').bind('mouseenter mouseleave', function() {
		 	// must be attached to li so that mouseleave is not triggered when hover over submenu
		 	$(this).toggleClass('hover');
		});
	}
}
/*退出登录*/
$("#out").click(function(){
    $.ajax({
        type:'post',
        url:'../User_exit',
        success:function(data){
            if(data.exit == "success"){
                window.location.href = "logorreg.html";
            }
        }
    })
})
/*显示姓名*/
