<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>树形表格</title>
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
	var gridData={"rows":[
		{"value":1,"key":"南京分公司","isParent":true,"open":false},
		{"value":7,"key":"杭州办事处","isParent":true,"open":false}
	]}
	var g;
	function initComplete(){
	     //usePager: false设置为不分页
		 g = $("#maingrid").quiGrid({
	        columns: [
	        { display: '部门名', name: 'key', id:'deptId', width: 250, align: 'left'},
	        { display: '部门id', name: 'value',width: 250, type: 'int', align: 'left' }
	        ], 
	        height: '100%', width:"100%",checkbox:true,usePager: false,data:gridData,autoCheckChildren:true,tree: { columnId: 'deptId' },treeAjax:true,
	        treeChildDataPath:"<%=path%>/form/getDepartment.action?parentid=",treeAutoParam:"value",treeDataFilter:filterHandler
	    });
	}
	//本例使用的是下拉框示例使用的数据，格式不符合要求，所以使用了treeDataFilter重新处理数据，正常是不用的
	function filterHandler(childData){
		var newData=[];
		$.each(childData["list"],function(idx,item){
			if(item.key=="市场部"){
				item.isParent=true;
				item.open=false;
			}
			if(item.key=="财务部"||item.key=="工程部"||item.key=="市场1组"){
				item.checked=true;
			}
			newData.push(item);
		});
		return newData;
	}
	
</script>	
</body>
</html>