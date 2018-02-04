<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>父子表</title>
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
.stepContainer{
	padding:5px 0 5px 0px;
}
.stepTable{
	border:0;
	margin:0 auto!important;
}
.stepTable td{
	border:0;
}
.setp_icon{
	width:100px;
	text-align:center;
}
.setp_arrow{
	width:100px;
	text-align:center;
}
.setp_text{
	text-align:center;
	font-size:14px;
	font-weight:bold;
}
</style>
</head>
<body>
	<div class="box2" panelTitle="表格操作" id="searchPanel">
		<input type="button" value="关闭“合同名称1”" onclick="collapseDetail('合同名称1');"/>
		<input type="button" value="展开“合同名称1”" onclick="expandDetail('合同名称1');"/>
		<br/>这里用数据控制某行初始时展开子表，通过参数控制点击行展开子表
	</div>
	<div class="padding_right5">
		<div id="maingrid"></div>
    </div>
<script type="text/javascript">
        var grid;
         var testData={"form.paginate.pageNo":1,"form.paginate.totalRows":13,"rows":[
      {"id":1,"name":"合同名称1","beginTime":"2013-10-10","endTime":"2013-10-20","user":"张三","state":"未处理","open":true},
      {"id":2,"name":"合同名称2","beginTime":"2013-10-10","endTime":"2013-10-20","user":"张三","state":"未处理"},
      {"id":3,"name":"合同名称3","beginTime":"2013-10-10","endTime":"2013-10-20","user":"张三","state":"未处理"},
      {"id":4,"name":"合同名称4","beginTime":"2013-10-10","endTime":"2013-10-20","user":"张三","state":"未处理"},
      {"id":5,"name":"合同名称5","beginTime":"2013-10-10","endTime":"2013-10-20","user":"张三","state":"未处理"},
      {"id":6,"name":"合同名称6","beginTime":"2013-10-10","endTime":"2013-10-20","user":"张三","state":"未处理"},
      {"id":7,"name":"合同名称7","beginTime":"2013-10-10","endTime":"2013-10-20","user":"张三","state":"未处理"},
      {"id":8,"name":"合同名称8","beginTime":"2013-10-10","endTime":"2013-10-20","user":"张三","state":"未处理"},
      {"id":9,"name":"合同名称9","beginTime":"2013-10-10","endTime":"2013-10-20","user":"张三","state":"未处理"},
      {"id":10,"name":"合同名称10","beginTime":"2013-10-10","endTime":"2013-10-20","user":"张三","state":"未处理"},
      {"id":11,"name":"合同名称11","beginTime":"2013-10-10","endTime":"2013-10-20","user":"张三","state":"未处理"},
      {"id":12,"name":"合同名称12","beginTime":"2013-10-10","endTime":"2013-10-20","user":"张三","state":"未处理"},
      {"id":13,"name":"合同名称13","beginTime":"2013-10-10","endTime":"2013-10-20","user":"张三","state":"未处理"},
      {"id":14,"name":"合同名称14","beginTime":"2013-10-10","endTime":"2013-10-20","user":"张三","state":"未处理"},
      {"id":15,"name":"合同名称15","beginTime":"2013-10-10","endTime":"2013-10-20","user":"张三","state":"未处理"},
      {"id":16,"name":"合同名称16","beginTime":"2013-10-10","endTime":"2013-10-20","user":"张三","state":"未处理"}
         ]}
        function initComplete(){
        	grid = $("#maingrid").quiGrid({
                columns: [
	                { display: '合同名', name: 'name', align: 'left',width:200},
	                { display: '创建人', name: 'user' ,width:200},
	                { display: '创建时间', name: 'beginTime' ,width:200},
	                { display: '修改时间', name: 'endTime' ,width:200},
	                { display: '状态', name: 'state' ,width:200}
                ],   
				data:testData,width:'100%', height:'100%',detailClickExpand:true,
                detail: { onShowDetail: showEmployees, height: 'auto' },
                onError: function (a, b){
                    //错误事件
                }
            });
        };
        
        //显示所选部门下的员工
        function showEmployees(row, detailPanel,callback){
        			var childGrid = document.createElement('div'); 
                    $(detailPanel).append(childGrid);
                    var str='<div class="stepContainer">'+
								'<table class="stepTable">'+
									'<tr>'+
										'<td class="setp_icon"><a onclick=clickHandler("'+row.name+'")><img src="<%=path%>/libs/images/demo/step1.jpg"/></a></td>'+
										'<td class="setp_arrow"><img src="<%=path%>/libs/images/demo/stepArrow.jpg"/></td>'+
										'<td class="setp_icon"><a onclick=clickHandler("'+row.name+'")><img src="<%=path%>/libs/images/demo/step2.jpg"/></a></td>'+
										'<td class="setp_arrow"><img src="<%=path%>/libs/images/demo/stepArrow.jpg"/></td>'+
										'<td class="setp_icon"><a onclick=clickHandler("'+row.name+'")><img src="<%=path%>/libs/images/demo/step3.jpg"/></a></td>'+
										'<td class="setp_arrow"><img src="<%=path%>/libs/images/demo/stepArrow.jpg"/></td>'+
										'<td class="setp_icon"><a onclick=clickHandler("'+row.name+'")><img src="<%=path%>/libs/images/demo/step4.jpg"/></a></td>'+
									'</tr>'+
									'<tr>'+
										'<td class="setp_text">修改</td>'+
										'<td class="setp_text"></td>'+
										'<td class="setp_text">审批</td>'+
										'<td class="setp_text"></td>'+
										'<td class="setp_text">传阅</td>'+
										'<td class="setp_text"></td>'+
										'<td class="setp_text">发布</td>'+
									'</tr>'+
								'</table>'+
							'</div>'
				
                    $(childGrid).append(str);
                    
        }
        
        function clickHandler(str){
        	top.Dialog.alert("弹出窗口操作“"+str+"”，完成后刷新数据。",function(){
        		testData.rows[0].open=false;
        		//第二个参数表示刷新数据时保持之前展开的子表
        		grid.loadData(null,true);
        	})
        }
        
        function collapseDetail(str){
        	for (var record in grid.records){
				if(grid.records[record]['name']==str){
					grid.collapseDetail(grid.records[record]);
			    }
			}
        }
        
        function expandDetail(str){
        	for (var record in grid.records){
				if(grid.records[record]['name']==str){
					grid.extendDetail(grid.records[record]);
			    }
			}
        }
    </script>		
</body>
</html>