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

</head>
<body>
<div class="red">此示例由后台支持</div>
	<div class="padding_right5">
		<div id="maingrid"></div>
    </div>
<script type="text/javascript">
        var grid;
        function initComplete(){
        	grid = $("#maingrid").quiGrid({
                columns: [
	                { display: 'ID', name: 'orgId', align: 'left',width:"10%"},
	                { display: '部门名称', name: 'orgName' ,width:"20%"},
	                { display: '部门描述', name: 'orgDescription' ,width:"20%"},
	                { display: '负责人', name: 'orgManager' ,width:"10%"},
	                { display: '联系电话', name: 'orgPhone',width:"20%" },
	                { display: '部门父ID', name: 'parentId' ,width:"20%"}
                ],   
                //isScroll:false表示不出现滚动条，高度自适应。 frozen:false表示列宽不固定，可通过拖拽进行调整。
				 frozen:false,url: '<%=path%>/getGridData.action',width:'100%',height:'100%', detailClickExpand:true,checkbox:true,rownumbers:true,percentWidthMode:true,
                detail: { onShowDetail: showEmployees, height: 'auto' },
                onError: function (a, b){
                    //错误事件
                }
            });
        };
        
        //显示所选部门下的员工
        function showEmployees(row, detailPanel,callback){
        	$.post('<%=path%>/getUsersOfPager.action',{parentId:row.orgId},function(result){
        		if(result.rows.length > 0){
        			var childGrid = document.createElement('div'); 
                    $(detailPanel).append(childGrid);
                    $(childGrid).css('margin',10).quiGrid({
                         columns: [
        					{ display: '姓名', name: 'userName',     align: 'left'},
        					{ display: '所属部门', name: 'orgName', 	 align: 'left'},
        					{ display: '性别', name: 'userSex', align: 'left'},
        					{ display: '入职时间', name: 'userEmployTime', 	 align: 'left'} ,
        					{ display: '学历', name: 'userEducation', 	 align: 'left'} 
                         ], 
                         isScroll: false,width: '95%', columnWidth: 120,
                         //url: '<%=path%>/userAction.do?method=getUsers&parentId=' + row.orgId,
                         data: result,
                         //onAfterShowData可以自定义回调
                         onAfterShowData: callback, pageSize: 5
                    });  
        		}
        	})
        }
    </script>		
</body>
</html>