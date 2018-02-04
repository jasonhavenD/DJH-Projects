<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>单选框</title>
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/" scrollerY="false"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!--布局控件start-->
<script type="text/javascript" src="<%=path%>/libs/js/nav/layout.js"></script>
<!--布局控件end-->

<!--数据表格start-->
<script src="<%=path%>/libs/js/table/quiGrid.js" type="text/javascript"></script>
<!--数据表格end-->
<style>
.l-layout-drophandle-top{
	background-image: url("<%=path%>/libs/images/formEle/spliter_bg_h.jpg");
    background-repeat: repeat-x;
    height: 10px;
}
</style>
<script type="text/javascript">
       //数据表格使用
        var g;
        var g2;
        var sexData={"list":[{"value":"1","key":"男"},{"value":"0","key":"女"}]};
        var educationData={"list":[{"value":"1","key":"专科"},{"value":"2","key":"本科"},{"value":"3","key":"硕士"},{"value":"4","key":"博士"}]};
		function initComplete(){
			
			  $("#layout1").layout({ topHeight: 300 ,onEndResize:function(){
			  	g.resetHeight();
			  	g2.resetHeight();
			  }}); 
			  
			 g = $("#maingrid").quiGrid({
                columns: [ 
	                { display: '姓名', name: 'userName', align: 'center',  width: "30%",isSort:false},
	                { display: '性别', name: 'userSex', align: 'center' , width: "30%",isSort:false,render:function (item){
	                	  for (var i = 0; i < sexData["list"].length; i++)
                        {
                            if (sexData["list"][i]['value'] == item.userSex)
                                return sexData["list"][i]['key']
                        }
                        return item.userSex;
	                }},
	                { display: '学历', name: 'userEducation',  align: 'center' , width: "40%",isSort:false,render:function (item){
	                	  for (var i = 0; i < educationData["list"].length; i++)
                        {
                            if (educationData["list"][i]['value'] == item.userEducation)
                                return educationData["list"][i]['key']
                        }
                        return item.userEducation;
	                }},
		       		{ display: '选择', isAllowHide: false, align: 'left', width:50,isSort:false,
							 render: function (rowdata, rowindex, value, column){
		                 	    return '<div class="padding_top4 padding_left5">'
		                                 + '<span class="img_btn_down2 hand" title="选择" onclick="selectItem(' + rowdata.userId + ','+rowindex + ')"></span>'
		                             + '</div>';
			                 }
			            }
                ], url: '<%=path%>/getUserdbs.action', pageSize: 5, rownumbers:true, checkbox:false,percentWidthMode:true,sortName:"userId",sortOrder:"desc",
                height: '100%', width:'100%',title:"未选择列表",InWindow:false
            });
            g2 = $("#maingrid2").quiGrid({
                columns: [ 
	                { display: '姓名', name: 'userName', align: 'center',  width: "30%",isSort:false},
	                { display: '性别', name: 'userSex', align: 'center' , width: "30%",isSort:false},
	                { display: '学历', name: 'userEducation',  align: 'center' , width: "40%",isSort:false},
	                { display: '反选', isAllowHide: false, align: 'left', width:50,isSort:false,
						 render: function (rowdata, rowindex, value, column){
	                 	    return '<div class="padding_top4 padding_left5">'
	                                 + '<span class="img_btn_up2 hand" title="反选" onclick="deSelectItem(' + rowdata.userId + ','+rowindex + ')"></span>'
	                             + '</div>';
		                 }
		            }
                ], url: '<%=path%>/getUsersOfPager.action?parentId=15',  pageSize: 5, rownumbers:true, checkbox:false,percentWidthMode:true,sortName:"userId",sortOrder:"desc",
                height: '100%', width:'100%',title:"已选择列表"
            });
		}
		function selectItem(rowid,rowindex){
			var rowData=g.getRow(rowindex);
			selectHandler(rowData,rowid)
		}
		function deSelectItem(rowid,rowindex){
			var rowData=g2.getRow(rowindex);
			deSelectHandler(rowData,rowid)
		}
		function selectHandler(rowData,rowid){
			g.deleteRow(rowData);
			$.ajax({ 
			url:"<%=path%>/saveUser.action", 
			type:"POST",
			data:{
				"userinfor.organization.orgId":15,
				"userinfor.userId":rowData.userId,
				"userinfor.userName":rowData.userName,
				"userinfor.userLoginName":rowData.userLoginName,
				"userinfor.userPassword":rowData.userPassword,
				"userinfor.userSex":rowData.userSex,
				"userinfor.userEducation":rowData.userEducation
			},
			error:function(){
			},
			success: function(data){
	        	//页号重置为1
	    		g2.setNewPage(1);
				g2.loadData();
				
				$.post("<%=path%>/deleteUserdb.action",
		  			{"ids":rowid},
		  			function(result){
						//刷新表格
						g.loadData();
					},"json");
		    }
			});
			
			
			
			var $hi = $('<div class="itemMinEffect"></div>');
		   $hi.css({
		   	"width":$("#topCon").width(),
			"height":32,
			"left":0,
			top:currentMouseY-10+"px",
			opacity:0.1
		   }).animate({
		   	width:$("#topCon").width(),
			height:0,
			left:0,
			top:$("body").height()-100+"px",
			opacity:0
		   },200,function(){
		   	$hi.remove(); 
		   })		
			$("body").append($hi);			
		}
        function deSelectHandler(rowData,rowid){
			 g2.deleteRow(rowData);
			 
			var userSex;
			 for (var i = 0; i < sexData["list"].length; i++)
            {
                if (sexData["list"][i]['key'] == rowData.userSex)
                    userSex= sexData["list"][i]['value']
            }
             var userEducation;
             for (var j = 0; j < educationData["list"].length; j++)
            {
                if (educationData["list"][j]['key'] == rowData.userEducation)
                    userEducation= educationData["list"][j]['value']
            }   
			var postData={
				userName:rowData.userName,
				userLoginName:rowData.userLoginName,
				userPassword:rowData.userPassword,
				userSex:userSex,
				userAge:18,
				userId:rowData.userId,
				userEducation:userEducation
			}
			$.post("<%=path%>/saveUserdb.action",rowToBO(postData),function(result){
	        	//页号重置为1
	    		g.setNewPage(1);
		    	g.loadData();
		    	
		    	$.post("<%=path%>/deleteUser.action",
		  			{"ids":rowid},
		  			function(result){
		  				g2.loadData();
					},"json");
            },"json");
            
           
			
					
			var $hi = $('<div class="itemMinEffect"></div>');
		   $hi.css({
		   	"width":$("#centerCon").width(),
			"height":32,
			"left":0,
			top:currentMouseY-10+"px",
			opacity:0.1
		   }).animate({
		   	width:$("#centerCon").width(),
			height:0,
			left:0,
			top:100+"px",
			opacity:0
		   },200,function(){
		   	$hi.remove(); 
		   })		
			$("body").append($hi);			
		}
		
		
		//将row JSON对象转化为bo对象
		function rowToBO(row) {
			var params = '&userinfor.userName='+row.userName+'&userinfor.userSex='+row.userSex+'&userinfor.userAge='+Math.ceil(row.userAge)+'&userinfor.userDepartment='+row.userDepartment+'&userinfor.userAssistance='+row.userAssistance+'&userinfor.userDuty='+row.userDuty+'&userinfor.userEmployTime='+row.userEmployTime+'&userinfor.userPassword='+row.userPassword+'&userinfor.userEducation='+row.userEducation+'&userinfor.userLoginName='+row.userLoginName;
			return params;
		}
		
		function selectAll(){
           var rows = g.getSelectedRows();
           for(var i=0;i<rows.length;i++){
           		selectHandler(rows[i],rows[i].userId);
           }
		}
		function deSelectAll(){
			var rows = g2.getSelectedRows();
           for(var i=0;i<rows.length;i++){
           		deSelectHandler(rows[i],rows[i].userId);
           }
		}
    </script>
</head>
<body>
   <div id="layout1">
        <div position="top" id="topCon" style="padding-right:4px;">
        	<div id="maingrid"></div>
        </div>
        <div position="center" id="centerCon" style="padding-right:8px;padding-top:5px;">
        	<div id="maingrid2"></div>
        </div>
    </div> 
</body>
</html>