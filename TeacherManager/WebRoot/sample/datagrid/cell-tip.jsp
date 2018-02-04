<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>锁定列</title>
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!--数据表格start-->
<script src="<%=path%>/libs/js/table/quiGrid.js" type="text/javascript"></script>
<!--数据表格end-->
</head>
<body>
	<div class="padding_right5">
		<div id="maingrid"></div>
    </div>
	<script type="text/javascript">
        var testData={"form.paginate.pageNo":1,"form.paginate.totalRows":13,"rows":[
      {"deptName":"部门1","sex":"女","remark":"好啊","hobby":"唱歌","beginworkDate":"2012-06-13","photo":null,"version":null,"id":125,"degree":"硕士结业","age":20,"name":"员工1","deptId":12,"ability":1},
      {"deptName":"部门1","sex":"男","remark":"备注啊","hobby":"唱歌","beginworkDate":"2012-06-13","photo":null,"version":null,"id":124,"degree":"本科毕业","age":20,"name":"员工2","deptId":11,"ability":2},
      {"deptName":"部门1","sex":"男","remark":null,"hobby":"唱歌,跳舞","beginworkDate":"2012-06-12","photo":null,"version":null,"id":123,"degree":"本科毕业","age":20,"name":"员工3","deptId":9,"ability":2},
      {"deptName":"部门1","sex":"女","remark":"不错啊","hobby":"唱歌,跳舞","beginworkDate":"2012-06-12","photo":null,"version":null,"id":121,"degree":"硕士肄业","age":20,"name":"员工4","deptId":8,"ability":3},
      {"deptName":"部门1","sex":"男","remark":null,"hobby":"唱歌,跳舞","beginworkDate":"2012-06-12","photo":null,"version":null,"id":120,"degree":"博士肄业","age":20,"name":"员工5","deptId":7,"ability":4},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":"唱歌,跳舞","beginworkDate":"2012-06-05","photo":null,"version":null,"id":119,"degree":"博士肄业","age":20,"name":"员工6","deptId":6,"ability":5},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":"唱歌,跳舞","beginworkDate":"2012-06-05","photo":null,"version":null,"id":118,"degree":"博士肄业","age":20,"name":"员工7","deptId":6,"ability":6},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":"唱歌,跳舞","beginworkDate":"2012-06-05","photo":null,"version":null,"id":117,"degree":"博士肄业","age":20,"name":"员工8","deptId":6,"ability":5},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":"唱歌,跳舞","beginworkDate":"2012-06-05","photo":null,"version":null,"id":116,"degree":"博士肄业","age":20,"name":"员工9","deptId":6,"ability":3},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":"唱歌,跳舞","beginworkDate":"2012-06-05","photo":null,"version":null,"id":115,"degree":"博士肄业","age":20,"name":"员工10","deptId":6,"ability":1},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":"唱歌,跳舞","beginworkDate":"2012-06-05","photo":null,"version":null,"id":114,"degree":"博士肄业","age":20,"name":"员工11","deptId":6,"ability":5},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":"唱歌,跳舞","beginworkDate":"2012-06-05","photo":null,"version":null,"id":113,"degree":"博士肄业","age":20,"name":"员工12","deptId":6,"ability":5}
      ]}
       
       //数据表格使用
        var g;
		function initComplete(){
			 g = $("#maingrid").quiGrid({
                columns: [ 
	                { display: '姓名', name: 'name', align: 'center',  width: 120,render: function (rowdata, rowindex, value, column){
	                		var mainCon=$('<div></div>');
	                		var con=$('<div class="nameContent"></div>');
	                		var nameObj=$('<div style="width:80px;float:left;"></div>');
	                		con.attr("userId",rowdata.id)
	                		
	                		nameObj.text(rowdata.name);
	                		con.append(nameObj);
	                		mainCon.append(con);
	                 	    return mainCon.html();
		                 }},
	                { display: '性别', name: 'sex', align: 'center' , width: "30%"},
	                { display: '部门', name: 'deptName',  align: 'center' , width: "30%"},
	                { display: '入职时间', name: 'beginworkDate',  align: 'center', width: "40%" }
                ], data:testData, pageSize: 10, rownumbers:true, checkbox:true,percentWidthMode:true,
                height: '100%', width:"100%",onAfterShowData:onAfterShowData
                
            });
		}
        function onAfterShowData(data){
        	$("#maingrid").find(".nameContent").each(function(){
        		var lightCon=$('<div style="float:left;"><span class="cell_card"></span></div>');
        		$(this).append(lightCon);
        		$(this).append('<div class="clear"></div>');
        		var cardObj=lightCon.find("span");
        		var userid=$(this).attr("userId");
        		var rowData;
        		for (var record in data.rows){
			        if(data.rows[record]['id']==Number(userid)){
			           rowData=data.rows[record];
			        }
			    }
				var tableStr='<table>'+
								'<tr>'+
									'<td>性别：</td>'+
									'<td>'+rowData.sex+'</td>'+
								'</tr>'+
								'<tr>'+
									'<td>爱好：</td>'+
									'<td>'+rowData.hobby+'</td>'+
								'</tr>'+
								'<tr>'+
									'<td>学历：</td>'+
									'<td>'+rowData.degree+'</td>'+
								'</tr>'+
							'</table>'
        		cardObj.tip({"arrowDirection":"left","auto":true,arrowDistanceY:12,content:tableStr});
        		
        		cardObj.hover(function(){
        			$(this).addClass("cell_card_over");
        		},function(){
        			$(this).removeClass("cell_card_over");
        		})
        	})
        }
    </script>	
</body>
</html>