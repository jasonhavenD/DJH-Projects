<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!--树组件start -->
<script type="text/javascript" src="<%=path%>/libs/js/tree/ztree/ztree.js"></script>
<link href="<%=path%>/libs/js/tree/ztree/ztree.css" rel="stylesheet" type="text/css"/>
<!--树组件end -->

<!--数据表格start-->
<script src="<%=path%>/libs/js/table/quiGrid.js" type="text/javascript"></script>
<!--数据表格end-->
</head>
<body>
<table width="100%">
	<tr>
	<td class="ver01">
<div class="box1" whiteBg="true" panelWidth="180" panelHeight="328">	
	 <div>
		  <ul id="tree-1" class="ztree"></ul>
	 </div>
</div>
	</td>
	<td class="ver01">
<div class="box1" whiteBg="true">	
	<div id="maingrid" style="overflow:hidden;">
    </div>
 </div>   
	</td>
	</tr>
</table>
<script>
var nodes1 = [
		{ id:1,  parentId:0, name:"中心1", open: true,icon:"<%=path%>/libs/icons/user_group.gif"},
		{ id:11, parentId:1, name:"部门1",icon:"<%=path%>/libs/icons/user_group.gif"},
		{ id:12, parentId:1, name:"部门2",icon:"<%=path%>/libs/icons/user_group.gif"},
		{ id:13, parentId:1, name:"部门3",icon:"<%=path%>/libs/icons/user_group.gif"},
		{ id:2,  parentId:0, name:"中心2", open: true,icon:"<%=path%>/libs/icons/user_group.gif"},
		{ id:21, parentId:2, name:"部门4",icon:"<%=path%>/libs/icons/user_group.gif"},
		{ id:22, parentId:2, name:"部门5",icon:"<%=path%>/libs/icons/user_group.gif"},
		{ id:23, parentId:2, name:"部门6",icon:"<%=path%>/libs/icons/user_group.gif"}
	];
	
	//数据表格使用
       var gridData={"form.paginate.pageNo":1,"form.paginate.totalRows":13,"rows":[
      {"deptName":"部门1","sex":"女","remark":"好啊","hobby":["唱歌"],"beginworkDate":"2012-06-13 00:00:00.0","photo":null,"version":null,"id":125,"degree":"硕士结业","age":20,"name":"员工1","deptId":12,"ability":5},
      {"deptName":"部门1","sex":"男","remark":"备注啊","hobby":["唱歌"],"beginworkDate":"2012-06-13 00:00:00.0","photo":null,"version":null,"id":124,"degree":"本科毕业","age":20,"name":"员工2","deptId":11,"ability":5},
      {"deptName":"部门1","sex":"男","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-12 00:00:00.0","photo":null,"version":null,"id":123,"degree":"本科毕业","age":20,"name":"员工3","deptId":9,"ability":5},
      {"deptName":"部门1","sex":"女","remark":"不错啊","hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-12 00:00:00.0","photo":null,"version":null,"id":121,"degree":"硕士肄业","age":20,"name":"员工4","deptId":8,"ability":5},
      {"deptName":"部门1","sex":"男","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-12 00:00:00.0","photo":null,"version":null,"id":120,"degree":"博士肄业","age":20,"name":"员工5","deptId":7,"ability":5},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":119,"degree":"博士肄业","age":20,"name":"员工6","deptId":6,"ability":5},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":119,"degree":"博士肄业","age":20,"name":"员工7","deptId":6,"ability":5},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":119,"degree":"博士肄业","age":20,"name":"员工8","deptId":6,"ability":5},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":119,"degree":"博士肄业","age":20,"name":"员工9","deptId":6,"ability":5},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":119,"degree":"博士肄业","age":20,"name":"员工10","deptId":6,"ability":5},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":119,"degree":"博士肄业","age":20,"name":"员工11","deptId":6,"ability":5},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":119,"degree":"博士肄业","age":20,"name":"员工12","deptId":6,"ability":5}
      ]}
        var g;
 function initComplete(){
        //本地数据源
		$.fn.zTree.init($("#tree-1"), {}, nodes1);
		
		g = $("#maingrid").quiGrid({
        columns: [ 
            { display: '姓名', name: 'name', align: 'left', width: "80"},
            { display: '性别', name: 'sex', align: 'left', width: "50"},
            { display: '部门', name: 'deptName', align: 'left', width: "100", isSort:false},
            { display: '学历', name: 'degree',   align: 'left', width: "100" }
        ], 
        //pageSize默认为10，可以不配置
        data:gridData, pageSize: 10, sortName: 'id',rownumbers:true,total:35,
        height: '335', width:"365"
          });
    }
    function selectUser(){
    	 var row = g.getSelectedRow();
	   if (!row) { 
       	   top.Dialog.alert('请选择用户'); 
       }
       else{
       	top.frmright.document.getElementById("userName").value=row.name;
       	top.Dialog.close();
       }
    }
 </script>   
</body>
</html>