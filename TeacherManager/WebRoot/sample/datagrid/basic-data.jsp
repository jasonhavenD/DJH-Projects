<%@page language="java" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>基本表格模板</title>
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/" scrollerY="false"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!--数据表格start-->
<script src="<%=path%>/libs/js/table/quiGrid.js" type="text/javascript"></script>
<!--数据表格end-->

<!--分页start-->
<script type="text/javascript" src="<%=path%>/libs/js/nav/pageNumber.js"></script>
<!--分页end-->

</head>
<body>
	<div class="red">此示例由后台支持</div>
	<div class="padding_right5">
		<div id="maingrid"></div>
    </div>
<div id="pageContent" style="height:35px;"></div>	
<script type="text/javascript">
	  var g_pageNo = 1;
	  var g_pageSize = 10;
      //数据表格使用
        var g;
      	var gridData;
		function initComplete(){
			 g = $("#maingrid").quiGrid({
				 columns: [ 
	                { display: '姓名', name: 'userName',     align: 'left', width: "20%"},
				    { display: '所属部门', name: 'orgName', 	 align: 'left', width: "20%"},
				    { display: '性别', name: 'userSex', align: 'left', width: "20%"},
				    { display: '入职时间', name: 'userEmployTime', 	 align: 'left',  width:"20%"} ,
				    { display: '学历', name: 'userEducation', 	 align: 'left',  width:"20%"}
	              ], 
                data:[],  sortName: 'userId',rownumbers:true,dataAction:'local',checkbox:true,usePager: false,
                height: '100%', width:"100%",heightDiff:-40,percentWidthMode:true,
                onChangeSort : function(){
                	getData(g.options.sortName,g.options.sortOrder,g_pageNo,g_pageSize);
                	return false;
                }
            });
		}
		$(function(){
			g.options.sortName = "userId";
			g.options.sortOrder = "desc";
			getData(g.options.sortName,g.options.sortOrder,g_pageNo,g_pageSize);
		})
		
		function getData(sort,direction,pageNo,pageSize){
			$.post("<%=path%>/getUsersOfPager.action",
					{"sort":sort,
					 "direction":direction,
					 "pager.pageNo":pageNo,
					 "pager.pageSize":pageSize
					},
					function(result){
						gridData = result;
						//刷新表格
						g.loadData(gridData);
						
						var $pager=$('<div class="pageNumber" showSelect="true"></div>');
				 		$pager.attr("total",gridData["pager.totalRows"]);
				        var $pagerCon = $('<div class="float_left padding5">' + "共有" + gridData["pager.totalRows"] + "条记录" + '</div><div class="float_right padding5"></div><div class="clear"></div>');
						$pagerCon.eq(1).append($pager);
						$("#pageContent").append($pagerCon);
						$pager.render();
						$pager.bind("pageChange",function(e,index){
							g_pageNo = index + 1;
							getData2(g.options.sortName,g.options.direction,g_pageNo,g_pageSize);			
						})
						$pager.bind("sizeChange",function(e,num){
							g_pageSize = num;
							getData2(g.options.sortName,g.options.sortOrder,g_pageNo,g_pageSize);
						})
					},"json");
		}
		
		function getData2(sort,direction,pageNo,pageSize){
			$.post("<%=path%>/getUsersOfPager.action",
					{"sort":sort,
					 "direction":direction,
					 "pager.pageNo":pageNo,
					 "pager.pageSize":pageSize
					},
					function(result){
						gridData = result;
						//刷新表格
						g.loadData(gridData);
					},"json");
		}
		
</script>		
</body>
</html>