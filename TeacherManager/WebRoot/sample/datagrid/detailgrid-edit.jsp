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
这里实现了新增时默认读取父表对应行的部门名称，新增、修改和删除时只刷新当前展开的子表。
	<div class="padding_right5">
		<div id="maingrid"></div>
    </div>
<script type="text/javascript">
        //设定不可编辑的节点id
    var noeditArray = ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19"];
		
       
        var grid;
        var gridArray=[];
        function initComplete(){
        	grid = $("#maingrid").quiGrid({
                columns: [
	                { display: 'ID', name: 'orgId', align: 'left',width:50},
	                { display: '部门名称', name: 'orgName' ,width:200},
	                { display: '部门描述', name: 'orgDescription' ,width:200},
	                { display: '负责人', name: 'orgManager' ,width:200},
	                { display: '联系电话', name: 'orgPhone',width:200 },
	                { display: '部门父ID', name: 'parentId' ,width:100}
                ],   
                //isScroll:false表示不出现滚动条，高度自适应。 frozen:false表示列宽不固定，可通过拖拽进行调整。
				 frozen:false,url: '<%=path%>/getGridData.action',width:'100%',height:'100%', 
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
                    var childGrid=$(childGrid).css('margin',10).quiGrid({
                         columns: [
        					{ display: '姓名', name: 'userName',     align: 'left'},
        					{ display: '所属部门', name: 'orgName', 	 align: 'left'},
        					{ display: '性别', name: 'userSex', align: 'left'},
        					{ display: '入职时间', name: 'userEmployTime', 	 align: 'left'} ,
        					{ display: '学历', name: 'userEducation', 	 align: 'left'}  ,
           					{ display: '操作', isAllowHide: false, align: 'left',
						 render: function (rowdata, rowindex, value, column){
	                 	    
	                 	    return '<div class="padding_top4 padding_left5">'
	                                 + '<span class="img_list hand" title="查看" onclick="onView(' + rowdata.userId + ')"></span>'
	                                 + '<span class="img_edit hand" title="修改" onclick="onEdit(' + rowdata.userId + ','+row.orgId+')"></span>' 
	                                 + '<span class="img_delete hand" title="删除" onclick="onDelete(' + rowdata.userId+','+rowindex + ','+row.orgId+')"></span>'
	                             + '</div>';
		                 }
		            }
                         ], 
                         sortName: 'userId',width: '95%', columnWidth: 120,height:230,
                         url: '<%=path%>/getUsersOfPager.action?parentId=' + row.orgId,
                         pageSize: 5,
                          toolbar:{
				        	 items:[
				        		  {text: '新增', click: function(){addUnit(row.orgId)},    iconClass: 'icon_add'},
				        		  { line : true },
				        		  {text: '批量删除', iconClass: 'icon_delete'},
				        		  { line : true },
				        		  {text: '导入',  iconClass: 'icon_import'},
				        		  { line : true },
				        		  {text: '导出当前页', iconClass: 'icon_export'},
				        		  { line : true },
				        		  {text: '导出全部',  iconClass: 'icon_export'}
				        		]
				         	}
                    });  
                    var obj={};
                    obj.id=row.orgId;
                    obj.grid=childGrid;
                    gridArray.push(obj);
        }
        
       //新增
	function addUnit(orgid) {
		top.Dialog.open({
				URL:"<%=path%>/sample/datagrid/user-management-content-detailGrid.jsp?orgid=" + orgid+"&gridId="+orgid,
				Title:"添加",Width:500,Height:350});
	}
	//查看
	function onView(rowid){
		top.Dialog.open({
			URL:"<%=path%>/getUserDetail.action?userinfor.userId=" + rowid,
			Title:"查看",Width:500,Height:350});
	}
	//修改	
	function onEdit(rowid,gridId){
		if (getPosition(rowid, noeditArray) != -1) {
            top.Dialog.alert("为保证数据的完整性，由管理员添加的数据无法修改或删除。可以为新添加的数据来修改和删除。");
            return false;
        }
		top.Dialog.open({
			URL:"<%=path%>/sample/datagrid/user-management-contentAjax-detailGrid.jsp?userId=" + rowid+"&gridId="+gridId,
			Title:"修改",Width:500,Height:350});
	}
	//删除	
	function onDelete(rowid,rowidx,gridId){
		if (getPosition(rowid, noeditArray) != -1) {
            top.Dialog.alert("为保证数据的完整性，由管理员添加的数据无法修改或删除。可以为新添加的数据来修改和删除。");
            return false;
        }
		top.Dialog.confirm("确定要删除该记录吗？",function(){
		  	//删除记录
		  	$.post("<%=path%>/deleteUser.action",
		  			{"ids":rowid},
		  			function(result){
		  				handleResult(result.status,gridId);
					},"json");
			});
	}
	//删除后的提示
	function handleResult(result,gridId){
		if(result == 1){
			top.Dialog.alert("删除成功！",null,null,null,1);
			 //只刷新当前子表
			var childGrid;
	    	$.each(gridArray,function(idx,item){
				if(item.id==gridId){
					childGrid=item.grid;
				}
			})
			childGrid.loadData();
		}else{
			top.Dialog.alert("删除失败！");
		}
	}
	
	
 //只刷新当前子表
    function refreshChild(isUpdate,gridId){
    	var childGrid;
    	$.each(gridArray,function(idx,item){
			if(item.id==gridId){
				childGrid=item.grid;
			}
		})
		if(childGrid){
			if(!isUpdate){
	    		//重置排序
	        	childGrid.options.sortName='userId';
	        	childGrid.options.sortOrder="desc";
	        	//页号重置为1
	    		childGrid.setNewPage(1);
	    	}
	    	
	    	childGrid.loadData();
		}
    }
	
    </script>		
</body>
</html>