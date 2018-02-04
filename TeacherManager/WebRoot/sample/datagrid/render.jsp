<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>对表格的行、列进行渲染</title>
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

<!--示例柱状条样式start-->
<style type="text/css">
    .abilitybar {
	    height:20px; 
	    margin : 2px 0;
	}
	.abilitybar .bar { 
	    background-color:#6CAF00; 
	    height:20px; 
	    float: left;
	}
</style>
<!--示例柱状条样式end-->

</head>
<body>
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
        
         //数据表格使用
        var g;
		function initComplete(){
			 g = $("#maingrid").quiGrid({
                columns: [ 
                	{ display: '姓名', name: 'name',    align: 'left', width: 100},
	                { display: '性别', name: 'sex',     align: 'left' , width: 60, 
	                   render : function(rowdata, rowindex, value, column){
	                       return "女" == value ? "<font color=red>" + value + "</font>" : value;
	                   }},
	                { name: 'deptName',align: 'left' , width: 100, isSort:false,headerRender:function(column){
	                	return '<div class="padding_left10"><span class="icon_lightOn hand">部门</span></div>'
	                }},
	                { display: '学历', name: 'degree',  align: 'left',  width: 100 },
	                { display: '能力', name: 'ability', align: 'left',  width: 150, render: renderAbilityBar},
	                { display: '渲染的链接', align: 'left',  width: 150, render: function(){
	                    return "<a href='http://www.baidu.com' target='_blank'>百度</a>";
	                }},
                	{ display: '操作', isAllowHide: false, align: 'left', width: 80,
						 render: function (rowdata, rowindex, value, column){
	                 	    return '<div class="padding_top4 padding_left5">'
	                                 + '<span class="img_list hand" title="查看" onclick="onView(' + rowdata.id + ')"></span>'
	                                 + '<span class="img_edit hand" title="修改" onclick="onEdit(' + rowdata.id + ')"></span>' 
	                                 + '<span class="img_delete hand" title="删除" onclick="onDelete(' + rowdata.id+','+rowindex + ')"></span>'
	                             + '</div>';
		                 }
		            }
                ], 
                //如果在rowAttrRender中更改行的背景色的话，要将alternatingRow设置为false，以免自己设的背景色与奇偶行的颜色设置冲突。
                alternatingRow: false,
                //行渲染 实质是对该行的tr标签进行属性的设置
                rowAttrRender: function(rowdata, rowid){
                    return "男" == rowdata.sex ? "style=\"background-color:#76c3f9;\"" : '';
                },
                data:testData, sortName: 'id',rownumbers:true,checkbox:true,
                height: '100%', width:"100%"
            });
		}
		
		//渲染能力条
		function renderAbilityBar(rowdata, rowindex, value, column){
		   return "<div class='abilitybar'><div class='bar' style='width:" + value * 20 + "px;'></div> " + value + "级</div>";
		}
		
        
		function onView(rowid){
			alert("选择的记录Id是:" + rowid );
		}
		
		function onEdit(rowid){
			alert("选择的记录Id是:" + rowid );
			for (var record in g.records){
				if(g.records[record]['id']==rowid){
					alert(JSON.stringify(g.records[record]));
				}
			}
		}
		
		function onDelete(rowid,rowidx){
			alert("删除的记录Id是:" + rowid );
		}
    </script>		
</body>
</html>