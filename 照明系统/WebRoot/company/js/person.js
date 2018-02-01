/*favorite*/

/*address*/
$(function(){
	$(".table-hover tr").hover(function(){
		$(this).find("span").show(100);
	},function(){
		$(this).find("span").hide(100);
	})
})