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
</head>
<body>
	 <fieldset style="width:815px;">
	<legend>注意</legend>
左右排列的表格双选器适合列数较少的情况；上下排列的表格双选器适合行数较少的情况。<br/>
如果有必要，可以在表格上方加上查询条件，这样筛选更加方便。<br/>
按照本例的做法，也可以实现树形的表格双选器。<br/> 
      </fieldset>
      <div class="height_15"></div>
     
     <div class="red">此示例由后台支持</div> 
	<div class="box1" panelWidth="835">
		<table>
			<tr>
				<td id="leftCon"><div id="maingrid"></div></td>
				<td>
					<input type="button" value="选择选中行>>" onclick="selectAll()"/>
					<div class="height_15"></div>
					<input type="button" value="<<返回选中行" onclick="deSelectAll()"/>
				</td>
				<td id="rightCon"><div id="maingrid2"></div></td>
			</tr>
		</table>
    </div>
   
    
	<script type="text/javascript">
      
       //数据表格使用
        var g;
        var g2;
        var sexData={"list":[{"value":"1","key":"男"},{"value":"0","key":"女"}]};
        var educationData={"list":[{"value":"1","key":"专科"},{"value":"2","key":"本科"},{"value":"3","key":"硕士"},{"value":"4","key":"博士"}]};
		function initComplete(){
			 g = $("#maingrid").quiGrid({
                columns: [ 
	                { display: '姓名', name: 'userName', align: 'center',  width: "60%",isSort:false},
	                { display: '性别', name: 'userSex', align: 'center' , width: "40%",isSort:false,render:function (item){
	                	  for (var i = 0; i < sexData["list"].length; i++)
                        {
                            if (sexData["list"][i]['value'] == item.userSex)
                                return sexData["list"][i]['key']
                        }
                        return item.userSex;
	                }},
		       		{ display: '选择', isAllowHide: false, align: 'left', width:50,isSort:false,
							 render: function (rowdata, rowindex, value, column){
		                 	    return '<div class="padding_top4 padding_left5">'
		                                 + '<span class="img_btn_right hand" title="选择" onclick="selectItem(' + rowdata.userId + ','+rowindex + ')"></span>'
		                             + '</div>';
			                 }
			            }
                ], url: '<%=path%>/getUserdbs.action', pageSize: 10, rownumbers:true, checkbox:true,percentWidthMode:true,sortName:"userId",sortOrder:"desc",
                height: '420', width:"350",showPageInfo:false,showPageSize:false,title:"未选择列表"
            });
            
            g2 = $("#maingrid2").quiGrid({
                columns: [ 
	                { display: '反选', isAllowHide: false, align: 'left', width:50,isSort:false,
						 render: function (rowdata, rowindex, value, column){
	                 	    return '<div class="padding_top4 padding_left5">'
	                                 + '<span class="img_btn_left hand" title="反选" onclick="deSelectItem(' + rowdata.userId + ','+rowindex + ')"></span>'
	                             + '</div>';
		                 }
		            },
	                { display: '姓名', name: 'userName', align: 'center',  width: "60%",isSort:false},
	                { display: '性别', name: 'userSex', align: 'center' , width: "40%",isSort:false}
                ], url: '<%=path%>/getUsersOfPager.action?parentId=15',  pageSize: 10, rownumbers:true, checkbox:true,percentWidthMode:true,sortName:"userId",sortOrder:"desc",
                height: '420', width:"350",showPageInfo:false,showPageSize:false,title:"已选择列表"
            });
		}
		function selectItem(rowid,rowindex){
			var rowData=g.getRow(rowindex);
			selectHandler(rowData,rowid,rowindex)
		}
		function deSelectItem(rowid,rowindex){
			var rowData=g2.getRow(rowindex);
			deSelectHandler(rowData,rowid)
		}
		function selectHandler(rowData,rowid){
			//alert(rowData.userName)
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
		   	"width":$("#leftCon").width(),
			"height":32,
			"left":currentMouseX-$("#leftCon").width()+"px",
			top:currentMouseY-10+"px",
			opacity:0.1
		   }).animate({
		   	width:$("#leftCon").width(),
			height:0,
			left:currentMouseX+100+$("#leftCon").width()+"px",
			top:currentMouseY-10+"px",
			opacity:0
		   },200,function(){
		   	$hi.remove(); 
		   })		
			$("body").append($hi);				
		}
        function deSelectHandler(rowData,rowid){
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
            
            g2.deleteRow(rowData);
			
					
			var $hi = $('<div class="itemMinEffect"></div>');
		   $hi.css({
		   	"width":$("#rightCon").width(),
			"height":32,
			"left":currentMouseX+"px",
			top:currentMouseY-10+"px",
			opacity:0.1
		   }).animate({
		   	width:$("#leftCon").width(),
			height:0,
			left:currentMouseX-100-$("#leftCon").width()+"px",
			top:currentMouseY-10+"px",
			opacity:0
		   },200,function(){
		   	$hi.remove(); 
		   })		
			$("body").append($hi);		
		}
		
		
		//将row JSON对象转化为bo对象
		function rowToBO(row) {
			var params = 'userinfor.userName='+row.userName+'&userinfor.userSex='+row.userSex+'&userinfor.userAge='+Math.ceil(row.userAge)+'&userinfor.userDepartment='+row.userDepartment+'&userinfor.userAssistance='+row.userAssistance+'&userinfor.userDuty='+row.userDuty+'&userinfor.userEmployTime='+row.userEmployTime+'&userinfor.userPassword='+row.userPassword+'&userinfor.userEducation='+row.userEducation+'&userinfor.userLoginName='+row.userLoginName;
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
</body>
</html>