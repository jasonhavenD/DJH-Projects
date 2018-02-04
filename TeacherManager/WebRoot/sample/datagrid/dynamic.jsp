<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>表格的动态操作</title>
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
	<div class="box2" panelTitle="表格操作" id="searchPanel">
	    提示：此例中的表格操作仅在前台对数据进行了操作，没有真正地对数据库进行增删。<br/>
	
	
		<input type="button" value="获取当前选中行的值" onclick="getSelectData();"/>
		<input type="button" value="获得第一行的值" onclick="getRowData(0);"/>
		<input type="button" value="获得id为123的行的值" onclick="getRowData2(123);"/>
		<input type="button" value="获取整个表格的值" onclick="getGridData();"/>
		<input type="button" value="删除选中行" onclick="deleteRow();"/>
		<input type="button" value="插入首行" onclick="insertFirstRow();"/>
		<input type="button" value="追加尾行" onclick="appendLastRow();"/>
		<input type="button" value="在选中行前插入行" onclick="insertBeforeRow();"/>
		<input type="button" value="在选中行后追加行" onclick="insertAfter();"/>
		<input type="button" value="上移行" onclick="upRow();"/>
		<input type="button" value="下移行" onclick="downRow();"/>
		<br />
		（还可双击查看效果）
	</div>

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
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":119,"degree":"博士肄业","age":20,"name":"员工7","deptId":6,"ability":6},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":119,"degree":"博士肄业","age":20,"name":"员工8","deptId":6,"ability":5},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":119,"degree":"博士肄业","age":20,"name":"员工9","deptId":6,"ability":3},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":119,"degree":"博士肄业","age":20,"name":"员工10","deptId":6,"ability":1},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":119,"degree":"博士肄业","age":20,"name":"员工11","deptId":6,"ability":5},
      {"deptName":"部门2","sex":"女","remark":null,"hobby":["唱歌","跳舞"],"beginworkDate":"2012-06-05 00:00:00.0","photo":null,"version":null,"id":119,"degree":"博士肄业","age":20,"name":"员工12","deptId":6,"ability":5}
      ]}
       
       
       //数据表格初始化
        var g;
		function initComplete(){
			 g = $("#maingrid").quiGrid({
                columns: [ 
                { display: '姓名', name: 'name', align: 'left' , width: "30%"},
                { display: '性别', name: 'sex', width: 100, align: 'left' , width: "20%"},
                { display: '部门', name: 'deptName',  align: 'left' , width: "20%"},
                { display: '学历', name: 'degree', align: 'left', width: "20%" }
                ], data:testData, usePager: false, sortName: 'id', checkbox:true,percentWidthMode:true,
                 height: '100%', width:"100%", 
                onDblClickRow : function (rowdata, rowid, rowobj){
                    top.Dialog.alert('选择的是:' + rowdata.name);
                } 
            });
            
            $("#searchPanel").bind("stateChange",function(e,state){
				g.resetHeight();
			});
		}
		
		//获取当前选中行的值
		function getSelectData(){
		   var row = g.getSelectedRow();
		   if (!row) { 
           	   top.Dialog.alert('请选择一行'); 
           	   return;
           }
           alert(JSON.stringify(row));
		}
		
		//获取整个表格的值
		function getGridData(){
          	alert(JSON.stringify(g.getData()));
		}
		
		//删除选中行
		function deleteRow(){
		    //选中一行或多行
		    var rows = g.getSelectedRows();
		    if (rows.length == 0) {
           	   top.Dialog.alert('请至少选择一行'); 
           	   return;
           }
		    for(var index in rows){
		        g.deleteRow(rows[index]);
		    }
		}
		
		//插入首行
		function insertFirstRow(){
		    
			var rowdata = {
                name: "新元素",
                sex: "女",
                deptName: "部门",
                degree: "学历"
            };
		    //添加数据
		    var p = g.options;
            g.currentData[p.root].unshift(rowdata);
            g.loadData();
		}
		
		//追加尾行
		function appendLastRow(){
			var rowdata = {
                name: "新元素",
                sex: "女",
                deptName: "部门",
                degree: "学历"
            };
            g.add(rowdata);
		}
		
		//在选中行前插入行 
		function insertBeforeRow(){
		    insertRow(g.getSelectedRow(), true);
		}
		
		
		//在选中行后追加行
		function insertAfter(){
		    insertRow(g.getSelectedRow(), false);
		}
		
		//插入行
		function insertRow(row, isBefore){
		    //选中单行
		    if (!row) { 
           		top.Dialog.alert('请选择一行'); 
            	return;
            }
			var rowdata = {
                name: "新元素",
                sex: "女",
                deptName: "部门",
                degree: "学历"
            };
            // 参数：1、新增行的数据  2、参照行  3、在参照行之前true还是之后false插入新行 
            // 4、树形结构中，新增行的父行(树形表格有用) 如 var selectRowParnet = g.getParent(row);
            g.add(rowdata, row, isBefore, null);
		}
		
		
		//上移行
		function upRow(){
		    //选中一行或多行
			var rows = g.getSelectedRows();
		    if (rows.length == 0) {
           	   top.Dialog.alert('请至少选择一行'); 
           	   return;
           }
		   for(var index in rows){
		        g.up(rows[index]);
		   }
		}
		
		
		//下移行
		function downRow(){
		    //选中一行或多行
			var rows = g.getSelectedRows();
		    if (rows.length == 0) {
           	   top.Dialog.alert('请至少选择一行'); 
           	   return;
           }
		   for(var index in rows){
		        g.down(rows[index]);
		   }
		}
		
		function getRowData(idx){
			var row=g.getRow(0);
			alert(JSON.stringify(row));
		}
		function getRowData2(rowid){
			for (var record in g.records){
				if(g.records[record]['id']==rowid){
					alert(JSON.stringify(g.records[record]));
				}
			}
		}
    </script>		
</body>
</html>