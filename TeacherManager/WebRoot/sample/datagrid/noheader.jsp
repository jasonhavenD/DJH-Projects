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
<style>
.l-grid-row-cell-inner{
	line-height:40px;
	padding:0 0 0 10px;
}
</style>
</head>
<body>
	<div class="padding_right5 padding_top5">
		<div id="maingrid"></div>
    </div>
	<script type="text/javascript">
        var testData={"form.paginate.pageNo":1,"form.paginate.totalRows":13,"rows":[
      {"A":"姓名：","B":"张小三","C":"性别：","D":"男"},
      {"A":"年龄：","B":30,"C":"婚姻：","D":"未婚"},
      {"A":"爱好：","B":"唱歌","C":"职业：","D":"工程师"},
      {"A":"部门：","B":"开发部","C":"入职时间：","D":"2013-10-10"},
      {"A":"姓名：","B":"张小三","C":"性别：","D":"男"},
      {"A":"年龄：","B":30,"C":"婚姻：","D":"未婚"},
      {"A":"爱好：","B":"唱歌","C":"职业：","D":"工程师"},
      {"A":"部门：","B":"开发部","C":"入职时间：","D":"2013-10-10"},
      {"A":"姓名：","B":"张小三","C":"性别：","D":"男"},
      {"A":"年龄：","B":30,"C":"婚姻：","D":"未婚"},
      {"A":"爱好：","B":"唱歌","C":"职业：","D":"工程师"},
      {"A":"部门：","B":"开发部","C":"入职时间：","D":"2013-10-10"}
     
      ]}
       
       //数据表格使用
        var g;
		function initComplete(){
			 g = $("#maingrid").quiGrid({
                columns: [ 
	                { display: 'A', name: 'A', align: 'right',  width: 150},
	                { display: 'B', name: 'B', align: 'left' , width: 200},
	                { display: 'C', name: 'C',  align: 'right' , width: 150},
	                { display: 'D', name: 'D',  align: 'left', width:200 }
                ], data:testData, pageSize: 10, rownumbers:false, checkbox:false,showHeader:false,usePager:false,alternatingRow:false,rowHeight:40,
                height: '100%', width:"100%",mouseoverRowCssClass:null,selectRowButtonOnly:true
            });
		}
    </script>	
</body>
</html>