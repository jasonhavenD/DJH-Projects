<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>父子表</title>
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!-- 日期控件start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/datePicker/WdatePicker.js"></script>
<!-- 日期控件end -->

<!--数据表格start-->
<script src="<%=path%>/libs/js/table/quiGrid.js" type="text/javascript"></script>
<!--数据表格end-->


<!-- 表单验证start -->
<script src="<%=path%>/libs/js/form/validationRule.js" type="text/javascript"></script>
<script src="<%=path%>/libs/js/form/validation.js" type="text/javascript"></script>
<!-- 表单验证end -->

<style>
.detailFormContainer{
	padding:5px 0 5px 10px;
	text-align:left;
	width:800px;
}
.detailFormTable{
	border:0;
}
.detailFormTable td{
	border:0;
	height:35px;
}
.detailFormTitle{
	height:30px;
	line-height:30px;
	font-size:16px;
	font-weight:bold;
	background-image: url(<%=path%>/libs/images/formEle/groupTitle.jpg);
	background-repeat: no-repeat;
	background-position:0% 100%;
	padding:0 0 0 5px;
	
}

</style>
</head>
<body>
	展开时动态添加表单的方式，比上例的“展开编辑器”的优势在于：可以自定义表单的布局，并且可以与框架的验证组件结合使用。
	<div class="padding_right5">
		<div id="maingrid"></div>
    </div>
<script type="text/javascript">
		var userEducationData={"list":[{"value":"专科","key":"专科"},{"value":"本科","key":"本科"},{"value":"硕士","key":"硕士"},{"value":"博士","key":"博士"}]};
		var sexData={"list":[{"value":"男","key":"男"},{"value":"女","key":"女"}]};
        var grid;
        function initComplete(){
        	grid = $("#maingrid").quiGrid({
			columns:[
				{ display: '姓名', name: 'userName',     align: 'left', width: "20%"},
			    { display: '所属部门', name: 'orgName', 	 align: 'left', width: "20%"},
			    { display: '性别', name: 'userSex', align: 'left', width: "20%"},
			    { display: '入职时间', name: 'userEmployTime', 	 align: 'left',  width:"20%"} ,
			    { display: '学历', name: 'userEducation', 	 align: 'left',  width:"20%"} 
			  ],
			 url: '<%=path%>/getUsersOfPager.action',width:'100%', height:'100%',
                detail: { onShowDetail: showEmployees, height: 'auto' },
                onError: function (a, b){
                    //错误事件
                }
            });
        };
        
        //显示所选部门下的员工
        function showEmployees(row, detailPanel,callback){
        			var childGrid = document.createElement('div'); 
                    $(detailPanel).append(childGrid);
                   $(childGrid).addClass("detailFormContainer");
					var $table=$('<div class="detailFormTitle">本行编辑</div> <form id=form_'+row.userId+' method="post" action="" failAlert="表单填写不正确，请按要求填写！" showOnMouseOver="false">'+
					'<table class="detailFormTable" style="width:100%">'+
					'<tr><td width="100" class="ali03">姓名：</td><td><input type="text" id="inputa1" class="validate[required] float_left"/><span class="star float_left">*</span><div class="validation_info"></div><div class="clear"></div></td></tr>'+
					'<tr><td class="ali03">所属部门：</td><td><input type="text" id="inputa2" class="validate[required] float_left" /><span class="star float_left">*</span><div class="validation_info"></div><div class="clear"></div></td></tr>	'+
					'<tr><td class="ali03">性别：</td><td><select id="inputa3" class="validate[required] float_left" prompt="请选择" ></select><span class="star float_left">*</span><div class="validation_info"></div><div class="clear"></div></td></tr>	'+
					'<tr><td class="ali03">入职时间：</td><td><input type="text" id="inputa4" class="date validate[required] float_left"/><span class="star float_left">*</span><div class="validation_info"></div><div class="clear"></div></td></tr>	'+
					'<tr><td class="ali03">学历：</td><td><select id="inputa5" class="validate[required] float_left" prompt="请选择" ></select><span class="star float_left">*</span><div class="validation_info"></div><div class="clear"></div></td></tr>'+
					'<tr><td colspan="2" class="ali01"><div style="padding-left:100px;"><input type="button" value="提交" id="inputa6" onclick=validateForm("#form_'+row.userId+'")>&nbsp;<input type="reset" value="重置" id="inputa7"/></div></td></tr>'+
				'</table></form>')
	
				$(childGrid).append($table);
				$table.find("#inputa1").val(row.userName);
				$table.find("#inputa1").render();
				$table.find("#inputa2").val(row.orgName);
				$table.find("#inputa2").render();
				$table.find("#inputa3").data("data",sexData);
				$table.find("#inputa3").attr("selectedValue",row.userSex);
				$table.find("#inputa3").render();
				$table.find("#inputa4").val(row.userEmployTime);
				$table.find("#inputa4").render();
				$table.find("#inputa5").data("data",userEducationData);
				$table.find("#inputa5").attr("selectedValue",row.userEducation);
				$table.find("#inputa5").render();
				$table.find("#inputa6").render();
				$table.find("#inputa7").render();
				
				$table.validationEngine({showOnMouseOver:false});		
        }
        
        function validateForm(containerId){
		    var valid = $(containerId).validationEngine({returnIsValid: true,showOnMouseOver:false});
			if(valid == true){
				top.Dialog.alert('进行提交处理，完成后刷新数据。',function(){
					grid.loadData();
				});
			}else{
			    top.Dialog.alert('表单填写不正确，请按要求填写！');
			} 
		}
        
        function clickHandler(str){
        	top.Dialog.alert("弹出窗口操作“"+str+"”，完成后刷新数据。",function(){
        		testData.rows[0].open=false;
        		//第二个参数表示刷新数据时保持之前展开的子表
        		grid.loadData(null,true);
        	})
        }
        
    </script>		
</body>
</html>