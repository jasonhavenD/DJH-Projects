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
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/" scrollerX="false"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!--数据表格start-->
<script src="<%=path%>/libs/js/table/quiGrid.js" type="text/javascript"></script>
<!--数据表格end-->

</head>
<body>
	<div id="maingrid">
    </div>

<script type="text/javascript">
        //定义本地数据
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
        //数据表格使用
        var g;
		function initComplete(){
			 g = $("#maingrid").quiGrid({
                columns: [ 
	                { display: '姓名', name: 'name',     align: 'left', width: "30%"},
	                { display: '性别', name: 'sex',      align: 'left', width: "20%"},
	                { display: '部门', name: 'deptName', align: 'left', width: "20%", isSort:false},
	                { display: '学历', name: 'degree',   align: 'left', width: "30%" }
                ], 
                //pageSize默认为10，可以不配置
               data:gridData, pageSize: 5, sortName: 'id',rownumbers:true,checkbox:true,
                height: '300', width:"100%"
            });
            
		}
		
		//新增
		function addUser(){
		  
		} 
		
		//修改
		function editUser(){
		    var rows = g.getSelectedRows();
		    if(rows.length == 0){
				 top.Dialog.alert("请选择要修改的记录");
			 }else if(rows.length > 1){
				 top.Dialog.alert("不能同时修改多个记录");
			 }else{
				 
		    }	
		}
		
		//删除
		function deleteUser(){
		    var rows = g.getSelectedRows();
		    if (rows.length==0){
				top.Dialog.alert("请选择要删除的行");
			} else {
			 	top.Dialog.confirm("确定要删除记录吗？",function(){
				  	
				});
			 }
		}
		
		//导出
		function exportUser(){
		    top.Dialog.alert("导出处理，待实现。。。" );
		}
		
        //获取选中行的id 格式为 id=1&id=2
        function getSelectId(grid){
            var selectedRows = grid.getSelectedRows();
            var ids = "";
		    for (i = 0; i < selectedRows.length; i++) {
				ids += "&id="+selectedRows[i].id;
			}
			ids = ids.substring(1, ids.length); // 获取所有id
			return ids;
	    }
        
        
        //刷新表格 表单提交的回调
        function afterFormSubmit(){
            g.loadData();
        }
 
	$(document).ready(function() { 
		//查询
		$('#search').click(function(e) { 
		    e.preventDefault();
		    var query = $("#queryForm").formToArray(); 
		    g.setOptions({ parms: query});
		    //页号重置为1
		    g.setNewPage(1);
		    g.loadData();//加载数据
		});
		//重置
		$('#resetButton').click(function(e) { 
		    e.preventDefault();
		    //重置查询表单 对于像树形下拉框之类的非标准表单元素要手动重置 可参考“综合表单”中的“重置”。
		   $("#queryForm")[0].reset();
		   $('#search').click();
		});
	});
	 
</script>	
</body>
</html>