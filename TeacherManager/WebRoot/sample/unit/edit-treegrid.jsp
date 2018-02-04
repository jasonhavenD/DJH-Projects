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
	<div>为了保证数据完整性，这里表格编辑结果未提交到后台。</div>
	<div class="padding_right5">
		<div id="maingrid"></div>
    </div>
<script type="text/javascript">
	var g;
	function initComplete(){
	     //usePager: false设置为不分页
		 g = $("#maingrid").quiGrid({
	        columns: [
	        { display: '部门名', name: 'name', id:'deptId', width: 250, align: 'left' ,editor: { type: 'text'}},
	        { display: '部门id', name: 'id',width: 250, type: 'int', align: 'left' },
       		{ display: '操作', isAllowHide: false, align: 'left', width:"12%",
					 render: function (rowdata, rowindex, value, column){
					 	if(rowdata.parentId!=-1){
					 	 	return '<div class="padding_top4 padding_left5">'
                                 + '<span class="img_add hand" title="新增子节点" onclick="addNewRow(' + rowdata.userId + ','+rowindex + ')"></span>'
                                 + '<span class="img_btn_up2 hand" title="上移" onclick="goUp(' + rowdata.userId+','+rowindex + ')"></span>'
                                 + '<span class="img_btn_down2 hand" title="下移" onclick="goDown(' + rowdata.userId + ','+rowindex + ')"></span>' 
                                 + '<span class="img_delete hand" title="删除" onclick="onDelete(' + rowdata.userId+','+rowindex + ')"></span>'
                             + '</div>';
					 	}
					 	
					 	else{
					 		return '<div class="padding_top4 padding_left5">'
                                 + '<span class="icon_add hand" title="新增子节点" onclick="addNewRow(' + rowdata.userId + ','+rowindex + ')">新增子节点</span>'
                             + '</div>';
					 	}
	                 }
	            }
	        ], 
	        height: '100%', width:"100%",checkbox:false,usePager: false,url:'<%=path%>/getTreeGrid.action',tree: { columnId: 'deptId' },autoCheckChildren:false,
	        enabledEdit: true,onAfterEdit: onAfterEdit
	    });
	}
	
	function addNewRow(rowid,rowindex){
		  var rowData={
				name:"新增部门",
				id:'',
				parentId:rowid
			}
		var row = g.getRow(rowindex);	
		var child=g.getChildren(row)[0];
		
		g.appendRow(rowData,row,child,true)
		 //在这里做新增处理
		  //$.post("<%=path%>/userdbAction.do?method=saveUser",rowToBO(rowData),function(result){
			  	//if(result.id ==0 || result.id == ''){
			  		//top.Dialog.alert(result.message);
		    	//}
		    	//rowData.id = result.id;
           // },"json");	
	}
	
	
	
	//将row JSON对象转化为bo对象
	function rowToBO(row) {
		var params = '&userinfor.userId='+row.userId+'&userinfor.userName='+row.userName+'&userinfor.userSex='+row.userSex+'&userinfor.userAge='+Math.ceil(row.userAge)+'&userinfor.userDepartment='+row.userDepartment+'&userinfor.userEmployTime='+row.userEmployTime+'&userinfor.userPassword='+row.userPassword+'&userinfor.userEducation='+row.userEducation+'&userinfor.userLoginName='+row.userLoginName;
		return params;
	}
	
	function goUp(userId,rowindex){
		g.up(rowindex);
	}
	
	function goDown(userId,rowindex){
		g.down(rowindex);
	}
	
	//编辑后事件 
        function onAfterEdit(e)
        {
         	//var str="编辑后事件，用于ajax提交处理。列名："+e.column.name+"；行号："+e.rowindex+"；编辑后的值："+e.value+"\n";
		  	//alert("此处用于ajax提交处理。列名："+e.column.name+"，id："+e.record.id+"，编辑后的值："+e.value+"\n")
        }
   //删除	
	function onDelete(rowid,rowidx){
		alert("此处用于删除提交处理。")
	}     
</script>	
</body>
</html>