<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>多层表头</title>
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
	<div id="maingrid" style="margin: 0; padding: 0">
    </div>
<script type="text/javascript">
		 var testData={"form.paginate.pageNo":1,"form.paginate.totalRows":13,"rows":[
      {"deptName":"部门1","sex":"女","remark":"好啊","hobby":["唱歌"],"beginworkDate":"2012-06-13 00:00:00.0","photo":null,"version":null,"id":125,"degree":"硕士结业","age":20,"name":"员工1","deptId":12,"ability":1},
      {"deptName":"部门1","sex":"男","remark":"备注啊","hobby":["唱歌"],"beginworkDate":"2012-06-13 00:00:00.0","photo":null,"version":null,"id":124,"degree":"本科毕业","age":20,"name":"员工2","deptId":11,"ability":2},
      {"deptName":"部门1","sex":"男","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-12 00:00:00.0","photo":null,"version":null,"id":123,"degree":"本科毕业","age":20,"name":"员工3","deptId":9,"ability":2},
      {"deptName":"部门1","sex":"女","remark":"不错啊","hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-12 00:00:00.0","photo":null,"version":null,"id":121,"degree":"硕士肄业","age":20,"name":"员工4","deptId":8,"ability":3},
      {"deptName":"部门1","sex":"男","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-12 00:00:00.0","photo":null,"version":null,"id":120,"degree":"博士肄业","age":20,"name":"员工5","deptId":7,"ability":4},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":119,"degree":"博士肄业","age":20,"name":"员工6","deptId":6,"ability":5},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":119,"degree":"博士肄业","age":20,"name":"员工7","deptId":6,"ability":6},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":119,"degree":"博士肄业","age":20,"name":"员工8","deptId":6,"ability":5},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":119,"degree":"博士肄业","age":20,"name":"员工9","deptId":6,"ability":3},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":119,"degree":"博士肄业","age":20,"name":"员工10","deptId":6,"ability":1},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":119,"degree":"博士肄业","age":20,"name":"员工11","deptId":6,"ability":5},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":119,"degree":"博士肄业","age":20,"name":"员工12","deptId":6,"ability":5}
      ]}
       

       //数据表格
        var g;
		var myCols = [{ 
		    display: '第二级表头1', 
		    columns: [{ 
		        display: '第三级表头1', name: 'name', minWidth: 60,width:140  } ,
			  { display: '第三级表头2', name: 'sex', minWidth: 60,width:140  }]
            },{ 
            display: '第二级表头2', name: 'beginworkDate', width: 200, align: 'left' 
        }];
        
		function initComplete(){
			 g = $("#maingrid").quiGrid({
                columns: [ 
	                { display: '第一级表头1', columns: myCols, width: "320"},
	                { display: '第一级表头2', name: 'deptName', width: 100, align: 'left' ,  isSort:false},
	                { display: '第一级表头3', name: 'degree', width: 200, align: 'left'  }
                ], 
                data:testData, 
                pageSize: 5, sortName: 'id',rownumbers:true,checkbox:true,
                height: '100%', width:"100%",multihead:true
            });
		}

          
    </script>		
</body>
</html>