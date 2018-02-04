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
<div class="red">此示例由后台支持</div>
	<div class="padding_right5">
		<div id="maingrid"></div>
    </div>
<script type="text/javascript">
	var g;
	function initComplete(){
	     //usePager: false设置为不分页
		 g = $("#maingrid").quiGrid({
	        columns: [
	        { display: '部门名', name: 'name', id:'deptId', width: 250, align: 'left' },
	        { display: '部门id', name: 'id',width: 250, type: 'int', align: 'left' },
	        { display: '部门parentId', name: 'parentId', width: 250, align: 'left' }
	        ], 
	        height: '100%', width:"100%",checkbox:true,usePager: false,url:'<%=path%>/getTreeGrid.action',tree: { columnId: 'deptId' }
	    });
	}

</script>	
</body>
</html>