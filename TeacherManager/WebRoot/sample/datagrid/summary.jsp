<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>数据汇总</title>
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

	<div id="maingrid" style="margin: 0; padding: 0"></div>
<script type="text/javascript">
		var testData={"rows":[
		{"math":10,"name":"小1","english":10,"chinese":10},
		{"math":10,"name":"小2","english":10,"chinese":20},
		{"math":30,"name":"小3","english":30,"chinese":30},
		{"math":40,"name":"小4","english":40,"chinese":40},
		{"math":50,"name":"小5","english":50,"chinese":50},
		{"math":60,"name":"小6","english":60,"chinese":60},
		{"math":70,"name":"小7","english":70,"chinese":70}]};
        //数据表格使用
        var g;
		function initComplete(){
			 g = $("#maingrid").quiGrid({
                columns: [ 
                	{ display: '姓名', name: 'name', align: 'center',  width: "15%"},
                	{ display: '语文', name: 'chinese', align: 'center',  width: "15%", totalSummary: {render:function(obj){return '总数：'+obj.sum}}},
	                { display: '数学', name: 'math',    align: 'center' , width: "15%", totalSummary: {render:function(obj){return '最大值：'+obj.max}}},
	                { display: '英语', name: 'english', align: 'center' , width: "15%", totalSummary: {render:function(obj){return '平均值：'+obj.avg}}}
                ], 
                data:testData, usePager: false, sortName: 'id',rownumbers:true,height: '100%', width:"100%"
            });
		}
    </script>		
</body>
