var orderid = $("#orderid"); 
orderid = orderid[0].innerHTML;
var productid = $("#productid"); 
productid = productid[0].innerHTML;

$("button").click(function(){
	var val = $("#comment").val();
	val = $.trim(val);
	if(orderid == "" || productid =="" || val ==""){
		return false;
	}else{
		$.ajax({
			type:'post',
			data:{"orderid":orderid,"productid":productid,"content":val},
			url:'../Comment_addComment',
			success:function(data){
				if(data.state == "success"){
					alert("评论成功！祝您生活愉快~");
					window.location.href = "index.jsp";
				}
				else
					alert("评论失败！");
			}
		})
	}
	
	
});
