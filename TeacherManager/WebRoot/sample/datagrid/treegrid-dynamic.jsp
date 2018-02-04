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
<div class="box2" panelTitle="表格操作">
<input type="button" value="展开杭州办事处" onclick="expandRow2();"/>
<input type="button" value="折叠杭州办事处" onclick="collapseRow2();"/>
这里通过数据控制初始时全部收缩，自定义图标，并且参数控制点击checkbox不关联子节点。
</div>
	<div class="padding_right5">
		<div id="maingrid"></div>
    </div>
<script type="text/javascript">
	var gridData={"rows":[
		{"id":1,"parentId":0,"name":"南京分公司","iconClass":"icon_star","open":false,"children":[
			{"id":2,"parentId":1,"name":"市场部","iconClass":"icon_list","open":false,"children":[
				{"id":3,"parentId":2,"name":"市场1组","iconClass":"icon_mark","children":null},
				{"id":11,"parentId":2,"name":"市场2组","iconClass":"icon_mark","children":null},
				{"id":12,"parentId":2,"name":"市场3组","iconClass":"icon_mark","children":null}
			]},
			{"id":13,"parentId":1,"name":"财务部","iconClass":"icon_list","children":null},
			{"id":14,"parentId":1,"name":"行政部","iconClass":"icon_list","children":null},
			{"id":15,"parentId":1,"name":"工程部","iconClass":"icon_list","children":null},
			{"id":16,"parentId":1,"name":"技术部","iconClass":"icon_list","children":null},
			{"id":17,"parentId":1,"name":"生产部","iconClass":"icon_list","open":false,"children":[
				{"id":18,"parentId":17,"name":"222","iconClass":"icon_mark","children":null}
			]}
		]},
		{"id":7,"parentId":0,"name":"杭州办事处","iconClass":"icon_star","open":false,"children":[
			{"id":8,"parentId":7,"name":"接待处","iconClass":"icon_list","children":null},
			{"id":9,"parentId":7,"name":"洽谈处","iconClass":"icon_list","children":null}
		]},
		{"id":18,"parentId":0,"name":"郑州办事处","iconClass":"icon_star","open":false,"children":[
			{"id":19,"parentId":18,"name":"接待处","iconClass":"icon_list","children":null},
			{"id":20,"parentId":18,"name":"洽谈处","iconClass":"icon_list","children":null}
		]},
		{"id":21,"parentId":0,"name":"苏州办事处","iconClass":"icon_star","open":false,"children":[
			{"id":22,"parentId":21,"name":"接待处","iconClass":"icon_list","children":null},
			{"id":23,"parentId":21,"name":"洽谈处","iconClass":"icon_list","children":null}
		]},
		{"id":24,"parentId":0,"name":"北京办事处","iconClass":"icon_star","children":null}
	]}
	var g;
	function initComplete(){
	     //usePager: false设置为不分页
		 g = $("#maingrid").quiGrid({
	        columns: [
	        { display: '部门名', name: 'name', id:'deptId', width: 250, align: 'left' },
	        { display: '部门id', name: 'id',width: 250, type: 'int', align: 'left' },
	        { display: '部门parentId', name: 'parentId', width: 250, align: 'left' }
	        ], 
	        height: '100%', width:"100%",checkbox:true,usePager: false,data:gridData,autoCheckChildren:false,tree: { columnId: 'deptId' }
	    });
	}
	function collapseRow2(){
		for (var record in g.records){
			if(g.records[record]['name']=="杭州办事处"){
				g.collapse(g.records[record]);
		    }
		}
	}
	function expandRow2(){
		for (var record in g.records){
			if(g.records[record]['name']=="杭州办事处"){
				g.expand(g.records[record]);
		    }
		}
	}

</script>	
</body>
</html>