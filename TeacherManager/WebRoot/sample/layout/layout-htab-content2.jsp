<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>基本表格模板</title>
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/" scrollerY="false"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!--数据表格start-->
<script src="<%=path%>/libs/js/table/quiGrid.js" type="text/javascript"></script>
<!--数据表格end-->
</head>
<body style="background-color:#ffffff;">
	<div class="box2" panelTitle="查询用户"  id="searchPanel">
		<form action="<%=path%>/fullform/listUsers.do" id="queryForm" method="post">
		<table>
			<tr>
				<td>性别:</td>
				<td><select name="form.sex">
					<option value="">请选择</option>
					<option value="男">男</option>
					<option value="女">女</option>
				</select></td>
				<td>姓名：</td>
				<td><input type="text" name="form.name" /></td>
				<td><button id="search"><span class="icon_find">查询</span></button></td>
				<td><button id="resetButton"><span class="icon_reload">全部</span></button></td>
			</tr>
		</table>
		</form>
	</div>

<div style="padding-right: 4px;">
	<div id="maingrid">
    </div>
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
       
        var g;
		function initComplete(){
			 g = $("#maingrid").quiGrid({
               columns:[
			{ display: '姓名', name: 'name', align: 'center',  width: "30%"},
	                { display: '性别', name: 'sex', align: 'center' , width: "20%"},
	                { display: '部门', name: 'deptName',  align: 'center' , width: "30%"},
	                { display: '学历', name: 'degree',  align: 'center', width: "20%" }
		  ],
                //pageSize默认为10，可以不配置
                  data:testData, pageSize: 5, sortName: 'id',rownumbers:true,checkbox:true,
                height: '100%', width:"100%",
				  
				toolbar: 
					{ 
					items: [
		                { text: '新增', click: addUser, iconClass: 'icon_add' },
		                { line: true },
		                { text: '修改', click: editUser, iconClass: 'icon_edit' },
		                { line: true },
		                { text: '删除', click: deleteUser, iconClass: 'icon_delete' },
		                { line: true },
		                { text: '导出', click: exportUser, iconClass: 'icon_xls' }
	                ]
                }
            });
            
             $("#searchPanel").bind("stateChange",function(e,state){
				g.resetHeight();
			});
            
		}
		
		//新增
		function addUser(){
		  
		} 
		
		//修改
		function editUser(){
		 
		}
		
		//删除
		function deleteUser(){
		   
		}
		
		//导出
		function exportUser(){
		   
		}
		
        //获取选中行的id 格式为 id=1&id=2
        function getSelectId(grid){
           
	    }
        
      
 
	 
</script>	
</body>
</html>