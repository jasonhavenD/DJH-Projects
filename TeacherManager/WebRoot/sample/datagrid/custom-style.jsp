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
.l-panel{
	border:solid 1px #cccccc;
}
.l-grid-header{
	background-image:url(<%=path%>/libs/images/demo/g-header.jpg);
	border-bottom: 0;
}
.l-grid-hd-cell{
	border-right:0;
	background-image:url(<%=path%>/libs/images/demo/g-header-split.jpg);
	background-position:100% 50%;
	background-repeat:no-repeat;
}
.l-grid-row-cell-inner{
	line-height:65px;
}
.l-panel-bar{
	background:url(<%=path%>/libs/images/demo/trans.png) repeat-x scroll left bottom #eeeeee;
	border-top:solid 1px #cccccc;
}
.l-bar-separator{
	border-left:solid 1px #cccccc;
}
.l-grid-row-cell-con-checkbox{
	padding:20px 0 0 0;
}
.l-grid-row-cell{
	border-right-color:#ffffff;
	border-bottom: 1px dotted #cccccc;
}
.l-grid-row-over .l-grid-row-cell,.l-grid-row-over
{
    background:#f5f5f5;
}
.l-selected .l-grid-row-cell,.l-selected
{
   background:#ffffd5;
	background-image: url(<%=path%>/libs/images/demo/trans.png);
	background-repeat:repeat-x;
}
.l-grid-row-cell-checkbox span,.l-grid-hd-cell-checkbox .l-grid-hd-cell-inner span
{
    display:block; width:16px; height:16px; background:url(<%=path%>/libs/images/icons/checkbox.png) no-repeat;
    background-position:0px 0px;
    cursor:pointer; overflow:hidden; 
	margin:0 auto;
}
.l-checked .l-grid-row-cell-checkbox span,.l-checked  .l-grid-hd-cell-checkbox .l-grid-hd-cell-inner span
{
      background-position:0px 0px;
	  background-image:url(<%=path%>/libs/images/icons/checkbox-checked.png);
}
.l-selected .l-grid-row-cell-checkbox span,.l-selected  .l-grid-hd-cell-checkbox .l-grid-hd-cell-inner span
{
      background-position:0px 0px;
	  background-image:url(<%=path%>/libs/images/icons/checkbox-checked.png);
}

.tdContentStyle1{
	font-size:16px;
	font-weight:bold;
	color:#ea5504;
	background-image:url(<%=path%>/libs/images/icons/hot.jpg);
	background-position:90% 10px;
	background-repeat:no-repeat;
	padding:5px 0 0 10px;
}
.tdContentStyle2{
	font-size:16px;
	font-weight:bold;
	color:#ea5504;
	padding:5px 0 0 10px;
}
.tdContentStyle3{
	padding:15px 0 0 0;
}
.tdContentStyle4{
	text-align:left;
	line-height:150%;
	padding:5px 0 0 10px;
}
</style>
</head>
<body>
	<div class="padding_right5">
		<div id="maingrid"></div>
    </div>
	<script type="text/javascript">
        var testData={"form.paginate.pageNo":1,"form.paginate.totalRows":13,"rows":[
      {"name":"金橙养老7号第1期","hot":1,"date":"10/25-10/28","start":"1万元","duration":"426天","rate":"6.1%","count":">平安网银<br/>>财富"},
      {"name":"金橙养老7号第2期","hot":1,"date":"10/25-10/28","start":"1万元","duration":"358天","rate":"6.1%","count":">平安网银<br/>>财富"},
      {"name":"金橙养老7号第3期","hot":1,"date":"10/25-10/28","start":"10万元","duration":"421天","rate":"6.1%","count":">平安网银<br/>>财富"},
      {"name":"金橙养老7号第4期","hot":0,"date":"10/25-10/28","start":"10万元","duration":"556天","rate":"6.1%","count":">平安网银<br/>>财富"},
      {"name":"金橙养老7号第5期","hot":0,"date":"10/25-10/28","start":"1万元","duration":"147天","rate":"6.1%","count":">平安网银<br/>>财富"},
      {"name":"金橙养老7号第6期","hot":0,"date":"10/25-10/28","start":"15万元","duration":"255天","rate":"6.1%","count":">平安网银<br/>>财富"}
      ]}
       
       //数据表格使用
        var g;
		function initComplete(){
			 g = $("#maingrid").quiGrid({
                columns: [ 
	                { display: '产品名称', name: 'name', align: 'left',  width: 200,
						 render: function (rowdata, rowindex, value, column){
						 	var strhtml;
						 	if(rowdata.hot==1){
						 		strhtml='<div class="tdContentStyle1">' + rowdata.name+ '</div>';
						 	}
						 	else{
						 		strhtml='<div class="tdContentStyle2">' + rowdata.name+ '</div>';
						 	}
	                 	    return strhtml;
		                 }},
	                { display: '认购期', name: 'date', align: 'center' , width: "20%"},
	                { display: '起购金额', name: 'start',  align: 'center' , width: "20%"},
	                { display: '理财期限', name: 'duration',  align: 'center', width: "20%" },
	                { display: '内测年化收益', name: 'rate',  align: 'center', width: "20%" },
	                { display: '可购买账户', name: 'count',  align: 'left', width: "20%",
						 render: function (rowdata, rowindex, value, column){
						 	var strhtml='<div class="tdContentStyle4">' + rowdata.count+ '</div>';
	                 	    return strhtml;
		                 }  },
	                { display: '操作', name: 'count',  align: 'center', width: 100,
						 render: function (rowdata, rowindex, value, column){
						 	var strhtml='<div class="tdContentStyle3"><a><img src="<%=path%>/libs/images/demo/g-button.jpg"/></a></div>';
	                 	    return strhtml;
		                 } }
                ], data:testData, pageSize: 10, rownumbers:false, checkbox:true,percentWidthMode:true,
                height: '100%', width:"100%",alternatingRow:false,rowHeight:65,headerRowHeight:32
                
                
                
            });
		}
        
    </script>	
</body>
</html>