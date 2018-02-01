/*
 *	www.templatemo.com
 *******************************************************/

/* HTML document is loaded. DOM is ready. 
-----------------------------------------*/
$(document).ready(function(){

	/* Mobile menu */
	$('.mobile-menu-icon').click(function(){
		$('.templatemo-left-nav').slideToggle();				
	});

	/* Close the widget when clicked on close button */
	$('.templatemo-content-widget .fa-times').click(function(){
		$(this).parent().slideUp(function(){
			$(this).hide();
		});
	});
});
/*退出登录*/
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