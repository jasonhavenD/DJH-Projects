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

<!--树组件start -->
<script type="text/javascript" src="<%=path%>/libs/js/tree/ztree/ztree.js"></script>
<link href="<%=path%>/libs/js/tree/ztree/ztree.css" rel="stylesheet" type="text/css"/>
<!--树组件end -->

<!--布局控件start-->
<script type="text/javascript" src="<%=path%>/libs/js/nav/layout.js"></script>
<!--布局控件end-->

<!--数据表格start-->
<script src="<%=path%>/libs/js/table/quiGrid.js" type="text/javascript"></script>
<!--数据表格end-->
<style>
.l-layout-center{
    border:none!important;
}
.l-layout-left{
    border-bottom:none!important;
}
.l-layout-drophandle-left{
    width: 10px;
}
</style>
</head>
<body>
	<div id="layout1">
        <div id="leftCon" position="left" style="" panelTitle="组织机构">
        	<div class="orgTreeContainer">
        		<ul id="tree-1" class="ztree"></ul>
        	</div>
        </div>
        <div id="centerCon" position="center" style="">
        	<div class="box2" panelTitle="查询"  showStatus="false">
				<form id="queryForm" method="post">
				<table>
					<tr>
						<td>名称：</td>
						<td><input type="text" /></td>
						<td><button id="search"><span class="icon_find">查询</span></button></td>
						<td><button id="resetButton"><span class="icon_clear">重置</span></button></td>
					</tr>
				</table>
				</form>
				</div>
			<div style="margin: 0;padding: 0 5px 0 0;">
				<div id="maingrid"></div>
			</div>
        </div>
    </div> 
	
	
<script type="text/javascript">
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
		$("#layout1").quiLayout({ leftWidth: 150,onEndResize:function(){
			  	g.resetWidth();
			  }}); 
		
		//本地数据源
		$.fn.zTree.init($("#tree-1"), {}, nodes1);
		
		g = $("#maingrid").quiGrid({
       columns: [ 
	                { display: '姓名', name: 'name',     align: 'left', width: "25%"},
	                { display: '性别', name: 'sex',      align: 'left', width: "25%"},
	                { display: '部门', name: 'deptName', align: 'left', width: "25%", isSort:false},
	                { display: '学历', name: 'degree',   align: 'left', width: "25%" },
                	{ display: '操作', isAllowHide: false, align: 'left', width: 80,
						 //操作列渲染为图标
						 render: function (rowdata, rowindex, value, column){
	                 	    return '<div class="padding_top4 padding_left5">'
	                                 + '<span class="img_view hand" title="查看" onclick="onView(' + rowdata.id + ')"></span>'
	                                 + '<span class="img_edit hand" title="修改" onclick="onEdit(' + rowdata.id + ')"></span>' 
	                                 + '<span class="img_delete hand" title="删除" onclick="onDelete(' + rowdata.id+','+rowindex + ')"></span>'
	                             + '</div>';
		                 }
		            }
         ], 
        data:gridData, pageSize: 10, sortName: 'id',rownumbers:true,checkbox:true,
        height: '100%', width:"100%",percentWidthMode:true,
        //顶部图标按钮栏
		toolbar: 
			{ 
			items: [
                { text: '新增', click: addUser, iconClass: 'icon_add' },
                { line: true },
                { text: '批量删除', click: deleteUser, iconClass: 'icon_delete' },
                { line: true },
                { text: '导入', click: importUser, iconClass: 'icon_import' },
                { line: true },
                { text: '导出当前页', click: exportUser, iconClass: 'icon_export' },
                { line: true },
                { text: '导出所有', click: exportUser2, iconClass: 'icon_export' }
            ]
        }
         });
	}
	//添加
	function addUser() {
		top.Dialog.open({URL:"<%=path%>/sample/layout/user-management-content.jsp",Title:"新增",Width:600,Height:400}); 
	}
	
	//批量删除
	function deleteUser() {
		top.Dialog.alert("向后台发送ajax请求来批量删除。见JAVA版或.NET版演示。");
	}
	
	//导入
	function importUser() {
		top.Dialog.alert("见JAVA版或.NET版演示。");
	}
	//导出
	function exportUser() {
		top.Dialog.alert("见JAVA版或.NET版演示。");
	}
	
	//导出所有
	function exportUser2() {
		top.Dialog.alert("见JAVA版或.NET版演示。");
	}
	
	//查看
	function onView(rowid){
		alert("选择的记录Id是:" + rowid );
		top.Dialog.open({URL:"<%=path%>/sample/layout/user-management-content2.jsp",Title:"查看",Width:500,Height:330}); 
	}
	
	//修改
	function onEdit(rowid){
		top.Dialog.alert("见JAVA版或.NET版演示。");
	}
	
	//删除
	function onDelete(rowid,rowidx){
		top.Dialog.confirm("确定要删除该记录吗？",function(){
		  	top.Dialog.alert("向后台发送ajax请求来删除。见JAVA版或.NET版演示。");
		});
	}
	
function customHeightSet(contentHeight){
		$(".cusBoxContent").height(contentHeight-55)
		$(".orgTreeContainer").height(contentHeight-30);
	}
</script>	
</body>
</html>