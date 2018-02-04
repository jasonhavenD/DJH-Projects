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

<!--lodop打印控件start-->
<script src="<%=path%>/libs/thirdparty/lodop/LodopFuncs.js" type="text/javascript"></script>
<object  id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width="0" height="0" style="line-height:0px;"> 
       <embed id="LODOP_EM" type="application/x-print-lodop" width="0" height="0" style="line-height:0px;"></embed>
</object>
<!--lodop打印控件end-->

<!--打印的表格样式start-->
<style id="printStyle">
.tablePrint{
 	border-collapse: collapse;
	border: 1px solid #000000;
	width: 100%;
	background-color: White;
}
.tablePrint th{
 	border-left: 1.0pt solid windowtext;
	border-right: 1.0pt solid windowtext;
	border-bottom: 1.0pt solid windowtext;
	word-wrap: normal;
	word-break: keep-all;
	overflow:hidden;
	border-color: #000000;
	height:32px; 
	padding: 0 2px 0 4px;
	background-color:#cccccc;
	color:#000000;
	font-weight: normal;
	line-height:32px; 
}
.tablePrint td{
 	border-left: 1.0pt solid windowtext;
	border-right: 1.0pt solid windowtext;
	border-bottom: 1.0pt solid windowtext;
	border-color: #000000;
	height:30px; 
	padding: 1px 2px 1px 4px;
}
</style>
<!--打印的表格样式end-->

</head>
<body>
<div style="display:none;" id="content"><img src="<%=path%>/sample/thirdparty/lodop/view1.jpg"/></div>
注意：需要连接打印机才能正常测试。如果没有测试条件，可以<a style="color:red" onclick="popWin()">点击这里</a>查看实际效果截图，或者<a href="http://qui-frame.googlecode.com/files/PDFCreator-0_9_9_setup.exe" style="color:red">点击下载</a>并安装虚拟打印机进行测试。
<br/>如果安装了虚拟打印机，还有一个额外的功能，就是能够把要打印的数据直接输出成PDF文件（在打印预览窗口点击打印按钮）。
	<div class="padding_right5">
		<div id="maingrid"></div>
    </div>
	<script type="text/javascript">
        var testData={"form.paginate.pageNo":1,"form.paginate.totalRows":13,"rows":[
      {"deptName":"部门1","sex":"女","remark":"好啊","hobby":["唱歌"],"beginworkDate":"2012-06-13 00:00:00.0","photo":null,"version":null,"id":125,"degree":"硕士结业","age":20,"name":"员工1","deptId":12,"ability":1},
      {"deptName":"部门1","sex":"男","remark":"备注啊","hobby":["唱歌"],"beginworkDate":"2012-06-13 00:00:00.0","photo":null,"version":null,"id":124,"degree":"本科毕业","age":20,"name":"员工2","deptId":11,"ability":2},
      {"deptName":"部门1","sex":"男","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-12 00:00:00.0","photo":null,"version":null,"id":123,"degree":"本科毕业","age":20,"name":"员工3","deptId":9,"ability":2},
      {"deptName":"部门1","sex":"女","remark":"不错啊","hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-12 00:00:00.0","photo":null,"version":null,"id":121,"degree":"硕士肄业","age":20,"name":"员工4","deptId":8,"ability":3},
      {"deptName":"部门1","sex":"男","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-12 00:00:00.0","photo":null,"version":null,"id":120,"degree":"博士肄业","age":20,"name":"员工5","deptId":7,"ability":4},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":119,"degree":"博士肄业","age":20,"name":"员工6","deptId":6,"ability":5},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":118,"degree":"博士肄业","age":20,"name":"员工7","deptId":6,"ability":6},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":117,"degree":"博士肄业","age":20,"name":"员工8","deptId":6,"ability":5},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":116,"degree":"博士肄业","age":20,"name":"员工9","deptId":6,"ability":3},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":115,"degree":"博士肄业","age":20,"name":"员工10","deptId":6,"ability":1},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":114,"degree":"博士肄业","age":20,"name":"员工11","deptId":6,"ability":5},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":113,"degree":"博士肄业","age":20,"name":"员工12","deptId":6,"ability":5},
      {"deptName":"部门1","sex":"男","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-12 00:00:00.0","photo":null,"version":null,"id":123,"degree":"本科毕业","age":20,"name":"员工13","deptId":9,"ability":2},
      {"deptName":"部门1","sex":"女","remark":"不错啊","hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-12 00:00:00.0","photo":null,"version":null,"id":121,"degree":"硕士肄业","age":20,"name":"员工14","deptId":8,"ability":3},
      {"deptName":"部门1","sex":"男","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-12 00:00:00.0","photo":null,"version":null,"id":120,"degree":"博士肄业","age":20,"name":"员工15","deptId":7,"ability":4},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":119,"degree":"博士肄业","age":20,"name":"员工16","deptId":6,"ability":5},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":118,"degree":"博士肄业","age":20,"name":"员工17","deptId":6,"ability":6},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":117,"degree":"博士肄业","age":20,"name":"员工18","deptId":6,"ability":5},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":116,"degree":"博士肄业","age":20,"name":"员工19","deptId":6,"ability":3},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":115,"degree":"博士肄业","age":20,"name":"员工20","deptId":6,"ability":1},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":114,"degree":"博士肄业","age":20,"name":"员工21","deptId":6,"ability":5},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":113,"degree":"博士肄业","age":20,"name":"员工22","deptId":6,"ability":5},
      {"deptName":"部门1","sex":"男","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-12 00:00:00.0","photo":null,"version":null,"id":123,"degree":"本科毕业","age":20,"name":"员工23","deptId":9,"ability":2},
      {"deptName":"部门1","sex":"女","remark":"不错啊","hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-12 00:00:00.0","photo":null,"version":null,"id":121,"degree":"硕士肄业","age":20,"name":"员工24","deptId":8,"ability":3},
      {"deptName":"部门1","sex":"男","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-12 00:00:00.0","photo":null,"version":null,"id":120,"degree":"博士肄业","age":20,"name":"员工25","deptId":7,"ability":4},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":119,"degree":"博士肄业","age":20,"name":"员工26","deptId":6,"ability":5},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":118,"degree":"博士肄业","age":20,"name":"员工27","deptId":6,"ability":6},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":117,"degree":"博士肄业","age":20,"name":"员工28","deptId":6,"ability":5},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":116,"degree":"博士肄业","age":20,"name":"员工29","deptId":6,"ability":3},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":115,"degree":"博士肄业","age":20,"name":"员工30","deptId":6,"ability":1},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":114,"degree":"博士肄业","age":20,"name":"员工31","deptId":6,"ability":5},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":113,"degree":"博士肄业","age":20,"name":"员工32","deptId":6,"ability":5},
      {"deptName":"部门1","sex":"男","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-12 00:00:00.0","photo":null,"version":null,"id":123,"degree":"本科毕业","age":20,"name":"员工33","deptId":9,"ability":2},
      {"deptName":"部门1","sex":"女","remark":"不错啊","hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-12 00:00:00.0","photo":null,"version":null,"id":121,"degree":"硕士肄业","age":20,"name":"员工34","deptId":8,"ability":3},
      {"deptName":"部门1","sex":"男","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-12 00:00:00.0","photo":null,"version":null,"id":120,"degree":"博士肄业","age":20,"name":"员工35","deptId":7,"ability":4},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":119,"degree":"博士肄业","age":20,"name":"员工36","deptId":6,"ability":5},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":118,"degree":"博士肄业","age":20,"name":"员工37","deptId":6,"ability":6},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":117,"degree":"博士肄业","age":20,"name":"员工38","deptId":6,"ability":5},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":116,"degree":"博士肄业","age":20,"name":"员工39","deptId":6,"ability":3},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":115,"degree":"博士肄业","age":20,"name":"员工40","deptId":6,"ability":1},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":114,"degree":"博士肄业","age":20,"name":"员工41","deptId":6,"ability":5},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":113,"degree":"博士肄业","age":20,"name":"员工42","deptId":6,"ability":5},
      {"deptName":"部门1","sex":"男","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-12 00:00:00.0","photo":null,"version":null,"id":123,"degree":"本科毕业","age":20,"name":"员工43","deptId":9,"ability":2},
      {"deptName":"部门1","sex":"女","remark":"不错啊","hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-12 00:00:00.0","photo":null,"version":null,"id":121,"degree":"硕士肄业","age":20,"name":"员工44","deptId":8,"ability":3},
      {"deptName":"部门1","sex":"男","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-12 00:00:00.0","photo":null,"version":null,"id":120,"degree":"博士肄业","age":20,"name":"员工45","deptId":7,"ability":4},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":119,"degree":"博士肄业","age":20,"name":"员工46","deptId":6,"ability":5},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":118,"degree":"博士肄业","age":20,"name":"员工47","deptId":6,"ability":6},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":117,"degree":"博士肄业","age":20,"name":"员工48","deptId":6,"ability":5},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":116,"degree":"博士肄业","age":20,"name":"员工49","deptId":6,"ability":3},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":115,"degree":"博士肄业","age":20,"name":"员工50","deptId":6,"ability":1},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":114,"degree":"博士肄业","age":20,"name":"员工51","deptId":6,"ability":5},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":113,"degree":"博士肄业","age":20,"name":"员工52","deptId":6,"ability":5}
      ]}
       
       //数据表格使用
        var g;
		function initComplete(){
			 g = $("#maingrid").quiGrid({
                columns: [ 
	                { display: '姓名', name: 'name', align: 'center',  width: "30%"},
	                { display: '性别', name: 'sex', align: 'center' , width: "20%"},
	                { display: '部门', name: 'deptName',  align: 'center' , width: "30%"},
	                { display: '学历', name: 'degree',  align: 'center', width: "20%" }
                ], data:testData, pageSize: 20, rownumbers:true, checkbox:true,percentWidthMode:true,selectRowButtonOnly:false,
                height: '100%', width:"100%",toolbar:{
		    	 items:[
		    		  {text: '打印本页数据', click: printHandler,iconClass:'icon_print'},
		    		  { line : true },
		    		  {text: '打印选中数据', click: printHandler2,iconClass:'icon_print'},
		    		  { line : true },
		    		  {text: '打印全部数据', click: printHandler3,iconClass:'icon_print'}
		    		]
		     	}
            });
		}
        function printHandler(){
	        var LODOP=getLodop(document.getElementById('LODOP_OB'),document.getElementById('LODOP_EM')); 
	        if(LODOP){
		        var strBodyStyle="<style>"+document.getElementById("printStyle").innerHTML+"</style>";
		        var tableHtml;
		        var data=g.getData();
		        tableHtml=getTableHtml(data)
				var strBodyHtml=strBodyStyle+"<body>"+tableHtml+"</body>";
		        LODOP.PRINT_INIT("打印本页数据");	
				LODOP.ADD_PRINT_TABLE(15,0,"99%","96%",strBodyHtml);
				LODOP.PREVIEW();
	        }
        }
        function printHandler2(){
	       var rows = g.getSelectedRows();
		   if (rows.length==0) { 
           	   top.Dialog.alert('请至少选择一行'); 
           	   return;
           }
           var LODOP=getLodop(document.getElementById('LODOP_OB'),document.getElementById('LODOP_EM')); 
	        if(LODOP){
		        var strBodyStyle="<style>"+document.getElementById("printStyle").innerHTML+"</style>";
		        var tableHtml;
		        tableHtml=getTableHtml2(rows)
				var strBodyHtml=strBodyStyle+"<body>"+tableHtml+"</body>";
		        LODOP.PRINT_INIT("打印选中数据");	
				LODOP.ADD_PRINT_TABLE(15,0,"99%","96%",strBodyHtml);
				LODOP.PREVIEW();
			}
        }
        function printHandler3(){
	       var LODOP=getLodop(document.getElementById('LODOP_OB'),document.getElementById('LODOP_EM')); 
	        if(LODOP){
		        var strBodyStyle="<style>"+document.getElementById("printStyle").innerHTML+"</style>";
		        var tableHtml;
		        var data=testData["rows"];
		        tableHtml=getTableHtml(data)
				var strBodyHtml=strBodyStyle+"<body>"+tableHtml+"</body>";
		        LODOP.PRINT_INIT("打印全部数据");	
				LODOP.ADD_PRINT_TABLE(15,0,"99%","96%",strBodyHtml);
				LODOP.PREVIEW();
			}
        }
        function getTableHtml(data){
        	var $tableCon=$('<div></div>')
			var $table=$('<table width="100%" class="tablePrint"></table>');
			var $th=$('<thead><th>姓名</th><th>性别</th><th>部门</th><th>学历</th></thead>');
			$table.append($th)
			$.each(data,function(idx,item){
				var $tr=$('<tr></tr>');
				var $td=$('<td>'+item.name+'</td><td>'+item.sex+'</td><td>'+item.deptName+'</td><td>'+item.degree+'</td>');
				$tr.append($td);
				$table.append($tr)
			});
			$tableCon.append($table);
			return $tableCon.html();
        }
        function getTableHtml2(rows){
        	var $tableCon=$('<div></div>')
			var $table=$('<table width="100%" class="tablePrint"></table>');
			var $th=$('<thead><th>姓名</th><th>性别</th><th>部门</th><th>学历</th></thead>');
			$table.append($th)
			for(var i=0;i<rows.length;i++){
				var $tr=$('<tr></tr>');
				var $td=$('<td>'+rows[i].name+'</td><td>'+rows[i].sex+'</td><td>'+rows[i].deptName+'</td><td>'+rows[i].degree+'</td>');
				$tr.append($td);
				$table.append($tr)
			}
			$tableCon.append($table);
			return $tableCon.html();
        }
        
        function popWin(){
        	top.Dialog.open({
		      InnerHtml: $("#content").html(),
		      Title:"效果预览",
		      Width:820,
		      Height:520
		    });
        }
    </script>	
</body>
</html>