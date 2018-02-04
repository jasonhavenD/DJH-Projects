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
	background-image:url(<%=path%>/libs/images/demo/g-header2.jpg);
	border-bottom: 1px solid #cdc9c3;
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
.l-grid-hd-cell-con-checkbox{
	padding-top:10px;
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
.appendRowContent{
	text-align:left;
	color:red;
}
.l-grid-row-cell-appendRow{
	border-bottom: 1px solid #cdc9c3;
	height:30px;
}
.tdContentStyle1{
	font-size:16px;
	font-weight:bold;
	color:#a47039;
}
.tdContentStyle2{
	padding:15px 0 0 0;
}
</style>
</head>
<body>
	附加行中可以放置长文本、比较多的操作按钮等内容。
	<div class="padding_right5">
		<div id="maingrid"></div>
    </div>
	<script type="text/javascript">
        var testData={"form.paginate.pageNo":1,"form.paginate.totalRows":13,"rows":[
      {"bank":"平安银行","card":"平安银行信用卡（8497）","id":125,"billDay":"10日","repayDay":"28日","cash":"￥5,000.00","appendRowHtml":'<div class="appendRowContent">查看账单：<a>2012年12月</a>&nbsp;&nbsp;<a>历史账单</a></div>'},
      {"bank":"平安银行","card":"平安银行信用卡（0496）","id":126,"billDay":"7日","repayDay":"28日","cash":"￥10,000.00","appendRowHtml":'<div class="appendRowContent">查看账单：<a>2012年12月</a>&nbsp;&nbsp;<a>2012年10月</a>&nbsp;&nbsp;<a>2012年9月</a>&nbsp;&nbsp;<a>历史账单</a></div>'},
      {"bank":"招商银行","card":"招商银行信用卡（0544）","id":127,"billDay":"20日","repayDay":"25日","cash":"￥12,000.00","appendRowHtml":'<div class="appendRowContent">查看账单：<a>2012年12月</a>&nbsp;&nbsp;<a>2012年7月</a>&nbsp;&nbsp;<a>历史账单</a></div>'},
      {"bank":"招商银行","card":"招商银行信用卡（6782）","id":128,"billDay":"15日","repayDay":"25日","cash":"￥15,000.00","appendRowHtml":'<div class="appendRowContent">查看账单：<a>2012年12月</a>&nbsp;&nbsp;<a>2012年3月</a>&nbsp;&nbsp;<a>历史账单</a></div>'}
      ]}
       
       //数据表格使用
        var g;
		function initComplete(){
			 g = $("#maingrid").quiGrid({
                columns: [ 
	                { display: '银行', name: 'bank', align: 'center',  width: 200,
						 render: function (rowdata, rowindex, value, column){
						 	var img;
						 	if(rowdata.bank=="平安银行"){
						 		img='<img src="<%=path%>/libs/images/demo/bank1.jpg"/>';
						 	}
						 	else if(rowdata.bank=="招商银行"){
						 		img='<img src="<%=path%>/libs/images/demo/bank2.jpg"/>';
						 	}
	                 	    return '<div class="tdContentStyle2">' + img+ '</div>';
		                 }},
	                { display: '信用卡', name: 'card', align: 'center' , width: "30%",
						 render: function (rowdata, rowindex, value, column){
	                 	    return '<div class="tdContentStyle1">' + rowdata.card+ '</div>';
		                 }
		             },
	                { display: '账单日', name: 'billDay',  align: 'center' , width: "30%"},
	                { display: '还款日', name: 'repayDay',  align: 'center', width: "20%" },
	                { display: '取现额度', name: 'cash',  align: 'center', width: "20%" }
                ], data:testData, pageSize: 10, rownumbers:true, checkbox:true,percentWidthMode:true,
                height: '100%', width:"100%",alternatingRow:false,rowHeight:65,headerRowHeight:36
                
                
            });
		}
        
    </script>	
</body>
</html>