function timeManage(){
		$.ajax({
			datatype:"json",
			type:"get",
			url:"../testAjax.action",
			success:function(data){
				if(data.status=="fail"){
					$("#attach").hide();//隐藏导入
					$("#add").hide();//隐藏添加
					$(".edit").hide();
					$(".del").hide();
					$(".clear").hide();
				}
			},
			error:function(data){
			}
		})
}

$(document).ready(function() {
		//角色判断
		var rol = $("#rol").val();
		var totalRows = $("#totalRows").val();
		if (rol == 6) {
			$("#attach").hide();//隐藏导入
			$("#add").hide();//隐藏导入
			
			$("#deleteAll").hide();
			$("#deleteThis").hide();
			$(".edit").hide();
			$(".del").hide();

			for ( var i = 0; i < totalRows; i++) {
				$(".edit").hide();
				$(".del").hide();
			}
		}
	});