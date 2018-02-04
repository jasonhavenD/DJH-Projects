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
	这里禁用了批量删除按钮，并隐藏了导入按钮。实际开发中，通过权限机制来控制输出相关的属性值即可。
	<div class="padding_right5">
		<div id="maingrid"></div>
    </div>
    <br/>这里控制工具栏靠右排列。
	<div class="padding_right5">
		<div id="maingrid2"></div>
    </div>
    <br/>这里控制工具栏左右都有按钮。
    <div class="padding_right5">
		<div id="maingrid3"></div>
    </div>
	<script type="text/javascript">
        var testData={"form.paginate.pageNo":1,"form.paginate.totalRows":13,"rows":[
      {"deptName":"部门1","sex":"女","remark":"好啊","hobby":["唱歌"],"beginworkDate":"2012-06-13 00:00:00.0","photo":null,"version":null,"id":125,"degree":"硕士结业","age":20,"name":"员工1","deptId":12,"ability":1},
      {"deptName":"部门1","sex":"男","remark":"备注啊","hobby":["唱歌"],"beginworkDate":"2012-06-13 00:00:00.0","photo":null,"version":null,"id":124,"degree":"本科毕业","age":20,"name":"员工2","deptId":11,"ability":2},
      {"deptName":"部门1","sex":"男","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-12 00:00:00.0","photo":null,"version":null,"id":123,"degree":"本科毕业","age":20,"name":"员工3","deptId":9,"ability":2},
      {"deptName":"部门1","sex":"女","remark":"不错啊","hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-12 00:00:00.0","photo":null,"version":null,"id":121,"degree":"硕士肄业","age":20,"name":"员工4","deptId":8,"ability":3},
      {"deptName":"部门1","sex":"男","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-12 00:00:00.0","photo":null,"version":null,"id":120,"degree":"博士肄业","age":20,"name":"员工5","deptId":7,"ability":4},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":119,"degree":"博士肄业","age":20,"name":"员工6","deptId":6,"ability":5},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":118,"degree":"博士肄业","age":20,"name":"员工7","deptId":6,"ability":6},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":117,"degree":"博士肄业","age":20,"name":"员工8","deptId":6,"ability":5},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":116,"degree":"博士肄业","age":20,"name":"员工9","deptId":6,"ability":3},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":115,"degree":"博士肄业","age":20,"name":"员工10","deptId":6,"ability":1},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":114,"degree":"博士肄业","age":20,"name":"员工11","deptId":6,"ability":5},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":113,"degree":"博士肄业","age":20,"name":"员工12","deptId":6,"ability":5}
      ]}
       
       //数据表格使用
        var g;
		function initComplete(){
			 g = $("#maingrid").quiGrid({
                columns: [ 
	                { display: '姓名', name: 'name', align: 'center',  width: "30%"},
	                { display: '性别', name: 'sex', align: 'center' , width: "20%"},
	                { display: '部门', name: 'deptName',  align: 'center' , width: "30%"},
	                { display: '学历', name: 'degree',  align: 'center', width: "20%" }
                ], data:testData, pageSize: 5, rownumbers:true, checkbox:true,percentWidthMode:true,
                height: 'auto', width:"100%",
			     toolbar:{
			    	 items:[
			    		  {text: '新增', click: addUnit,    iconClass: 'icon_add'},
			    		  { line : true },
			    		  {text: '批量删除', click: deleteUnit, iconClass: 'icon_delete',disabled:true},
			    		  { line : true },
			    		  {text: '导入', click: showImportDialog, iconClass: 'icon_import',visible:false},
			    		  { line : true,visible:false },
			    		  {text: '导出当前页', click: exportPageData, iconClass: 'icon_export'},
			    		  { line : true },
			    		  {text: '导出全部', click: exportTotalData, iconClass: 'icon_export'}
			    		  
			    		]
			     	}
            });
            
            $("#maingrid2").quiGrid({
                columns: [ 
	                { display: '姓名', name: 'name', align: 'center',  width: "30%"},
	                { display: '性别', name: 'sex', align: 'center' , width: "20%"},
	                { display: '部门', name: 'deptName',  align: 'center' , width: "30%"},
	                { display: '学历', name: 'degree',  align: 'center', width: "20%" }
                ], data:testData, pageSize: 5, rownumbers:true, checkbox:true,percentWidthMode:true,
                height: 'auto', width:"100%",
			     toolbar:{
			    	 items:[
			    		  {text: '新增', click: addUnit,    iconClass: 'icon_add'},
			    		  { line : true },
			    		  {text: '批量删除', click: deleteUnit, iconClass: 'icon_delete'},
			    		  { line : true },
			    		  {text: '导入', click: showImportDialog, iconClass: 'icon_import'},
			    		  { line : true},
			    		  {text: '导出当前页', click: exportPageData, iconClass: 'icon_export'},
			    		  { line : true },
			    		  {text: '导出全部', click: exportTotalData, iconClass: 'icon_export'}
			    		  
			    		],position:"right"
			     	}
            });
            
             $("#maingrid3").quiGrid({
                columns: [ 
	                { display: '姓名', name: 'name', align: 'center',  width: "30%"},
	                { display: '性别', name: 'sex', align: 'center' , width: "20%"},
	                { display: '部门', name: 'deptName',  align: 'center' , width: "30%"},
	                { display: '学历', name: 'degree',  align: 'center', width: "20%" }
                ], data:testData, pageSize: 5, rownumbers:true, checkbox:true,percentWidthMode:true,
                height: 'auto', width:"100%",
			     toolbar:{
			    	 items:[
			    		  {text: '新增', click: addUnit,    iconClass: 'icon_add'},
			    		  { line : true },
			    		  {text: '批量删除', click: deleteUnit, iconClass: 'icon_delete'},
			    		  { line : true},
			    		  {text: '导出当前页', click: exportPageData, iconClass: 'icon_export'},
			    		  { line : true },
			    		  {text: '导出全部', click: exportTotalData, iconClass: 'icon_export'},
			    		  
			    		  {text: '查询', click: exportTotalData, iconClass: 'icon_find',position:"right"},
			    		   { line : true ,position:"right"},
			    		   {text: '导入', click: showImportDialog, iconClass: 'icon_import',position:"right"}
			    		  
			    		]
			     	}
            });
		}
		function addUnit(){
			top.Dialog.alert("新增");
		}
        function deleteUnit(){
			top.Dialog.alert("批量删除");
		}
		function showImportDialog(){
			top.Dialog.alert("导入");
		}
		function exportPageData(){
			top.Dialog.alert("导出当前页");
		}
		function exportTotalData(){
			top.Dialog.alert("导出全部");
		}
    </script>	
</body>
</html>