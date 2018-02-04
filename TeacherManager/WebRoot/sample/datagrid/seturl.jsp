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

<!--数据表格start-->
<script src="<%=path%>/libs/js/table/quiGrid.js" type="text/javascript"></script>
<!--数据表格end-->
</head>
<body>
<div class="box1">
 <button type="button" style="width:200px;" onclick='loaddataHandler()'>点击设置url</button>
 </div>
	<div class="padding_right5">
		<div id="maingrid"></div>
    </div>
	<script type="text/javascript">
        
       
       //数据表格使用
        var g;
		function initComplete(){
			 g = $("#maingrid").quiGrid({
               columns:[
			{ display: '姓名', name: 'userName',     align: 'left', width: "18%"},
		    { display: '所属部门', name: 'orgName', 	 align: 'left', width: "20%"},
		    { display: '性别', name: 'userSex', align: 'left', width: "10%"},
		    { display: '入职时间', name: 'userEmployTime', 	 align: 'left',  width:"20%"} ,
		    { display: '学历', name: 'userEducation', 	 align: 'left',  width:"20%"} 
		  ],
	  sortName: 'userId',rownumbers:true,checkbox:true,url:'',
    height: '100%', width:"100%",pageSize:5,percentWidthMode:true
            });
		}
        function loaddataHandler(){
			g.setOptions({url:'<%=path%>/getUsersOfPager.action'})
			g.loadData();
		}
    </script>	
</body>
</html>