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

<!-- 日期选择框start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/datePicker/WdatePicker.js"></script>
<!-- 日期选择框end -->
</head>
<body>
<div>为保证数据完整，这里新增和编辑后不存入数据库</div>
	<div class="padding_right5">
		<div id="maingrid"></div>
    </div>
<script type="text/javascript">
        var g;
        var gridArray=[];
        var sexData={"list":[{"value":"男","key":"男"},{"value":"女","key":"女"}]};
        var educationData={"list":[{"value":"专科","key":"专科"},{"value":"本科","key":"本科"},{"value":"硕士","key":"硕士"},{"value":"博士","key":"博士"}]};
        var jobNode = {"treeNodes":[
			{ id:1, parentId:0, name:"界面设计"},
			{ id:2, parentId:0, name:"程序开发"},
			{ id:3, parentId:0, name:"市场调研"},
			{ id:4, parentId:0, name:"质量监督"},
			{ id:5, parentId:0, name:"产品测试"}
		]};
        
        var departNode;
        
        function initComplete(){
        	g = $("#maingrid").quiGrid({
                columns: [
	                { display: 'ID', name: 'orgId', align: 'left',width:50},
	                { display: '部门名称', name: 'orgName' ,width:120},
	                { display: '部门描述', name: 'orgDescription' ,width:120},
	                { display: '负责人', name: 'orgManager' ,width:120},
	                { display: '联系电话', name: 'orgPhone',width:120 },
	                { display: '部门父ID', name: 'parentId' ,width:320}
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
        					{ display: '姓名', name: 'userName',     align: 'left',editor: { type: 'text',maxlength:5,tip:'不超过5个字的中文' }},
        					{ display: '性别', name: 'userSex', align: 'left',editor: { type: 'select',data:sexData,selWidth:100 },render:function (item){
			                	  for (var i = 0; i < sexData["list"].length; i++)
		                        {
		                            if (sexData["list"][i]['value'] == item.userSex)
		                                return sexData["list"][i]['key']
		                        }
		                        return item.userSex;
			                }},
        					{ display: '入职时间', name: 'userEmployTime', 	 align: 'left',editor: { type: 'date',dateFmt:'yyyy-MM-dd'}},
        					{ display: '学历', name: 'userEducation', 	 align: 'left',editor: { type: 'select',data:educationData,selWidth:100 },render:function (item){
			                	  for (var i = 0; i < educationData["list"].length; i++)
		                        {
		                            if (educationData["list"][i]['value'] == item.userEducation)
		                                return educationData["list"][i]['key']
		                        }
		                        return item.userEducation;
			                }}, 
			                
	                
				                { display: '操作', isSort: false, width: 200, render: function (rowdata, rowindex, value)
					                {
					                    var h = "";
					                    if (!rowdata._editing)
					                    {
					                         h += "<a onclick='onView(" + rowdata.userId + ")'><span class='icon_view'>查看</span></a>"; 
					                        h += "<a onclick='beginEdit(" + rowindex + ","+row.orgId+")'><span class='icon_edit'>修改</span></a> ";
					                       
					                    }
					                    else
					                    {
					                         h += "<a onclick='onView(" + rowdata.userId + ")'><span class='icon_view'>查看</span></a>"; 
					                        h += "<a onclick='endEdit(" + rowindex + ","+row.orgId+")'><span class='icon_ok'>提交</span></a> ";
					                        h += "<a onclick='cancelEdit(" + rowindex + ","+row.orgId+")'><span class='icon_no'>取消</span></a> "; 
					                       
					                    }
					                    return h;
					                }
			                }
                         ], 
                         isScroll: false,width: '95%', columnWidth: 120,
                         url: '<%=path%>/getUsersOfPager.action?parentId=' + row.orgId,
                         pageSize: 10,enabledEdit: true,clickToEdit: false,onDblClickRow:function(rowdata, rowindex){
		            		childGrid.beginEdit(rowindex);
		                },onBeforeEdit: onBeforeEdit, onBeforeSubmitEdit: onBeforeSubmitEdit,onAfterSubmitEdit: onAfterSubmitEdit,
						toolbar: 
							{ 
							items: [
				                { text: '新增', click: function(){addUser(row.orgId)}, iconClass: 'icon_add' },
				                { line: true },
				                { text: '全部确认修改', click:function(){endAllEdit(row.orgId)}, iconClass: 'icon_ok' },
				                { line: true },
				                { text: '全部取消修改', click: function(){cancelAllEdit(row.orgId)}, iconClass: 'icon_no' }
				              
			                ]
		                }            
                    });  
        	 var obj={};
            obj.id=row.orgId;
            obj.grid=childGrid;
            gridArray.push(obj);
	
        }
        
        //查看
		function onView(rowid){
			top.Dialog.open({
			URL:"<%=path%>/getUserDetail.action?userinfor.userId=" + rowid,
			Title:"查看",Width:550,Height:400});
		}
		
		
		//编辑
		 function beginEdit(rowid,gridId) { 
            var childGrid;
	    	$.each(gridArray,function(idx,item){
				if(item.id==gridId){
					childGrid=item.grid;
				}
			})
			if(childGrid){
				childGrid.beginEdit(rowid);
			}
            
        }
        
        //取消编辑
        function cancelEdit(rowid,gridId) { 
            $.each(gridArray,function(idx,item){
				if(item.id==gridId){
					childGrid=item.grid;
				}
			})
			if(childGrid){
				childGrid.cancelEdit(rowid);
			}
            
        }
        
        //结束编辑
        function endEdit(rowid,gridId)
        {
            $.each(gridArray,function(idx,item){
				if(item.id==gridId){
					childGrid=item.grid;
				}
			})
			if(childGrid){
				childGrid.endEdit(rowid);
			}
            
        }

		
		//新增
		function addUser(gridId){
			var childGrid;
	    	$.each(gridArray,function(idx,item){
				if(item.id==gridId){
					childGrid=item.grid;
				}
			})
			if(childGrid){
				 var row = childGrid.getRow(0);
				  var rowData={
						  userName:"新增",
							userSex:"男",
							userId:'',
							userEmployTime:"",
							userEducation:"本科"
						}
				  childGrid.addEditRow(rowData, row, true);
				  //在这里做新增处理
				  //$.post("<%=path%>/userdbAction.do?method=saveUser",rowToBO(rowData),function(result){
					  	//if(result.id ==0 || result.id == ''){
					  		//top.Dialog.alert(result.message);
				    	//}
				    	//childGrid.getRow(0).userId = result.id;
		           // },"json");
			}
		}
		
		//将row JSON对象转化为bo对象
		function rowToBO(row) {
			var params = '&userinfor.userId='+row.userId+'&userinfor.userName='+row.userName+'&userinfor.userSex='+row.userSex+'&userinfor.userAge='+Math.ceil(row.userAge)+'&userinfor.userDepartment='+row.userDepartment+'&userinfor.userEmployTime='+row.userEmployTime+'&userinfor.userPassword='+row.userPassword+'&userinfor.userEducation='+row.userEducation+'&userinfor.userLoginName='+row.userLoginName;
			return params;
		}
		
		
		
		//全部确认修改
       function endAllEdit(gridId){
        	var childGrid;
	    	$.each(gridArray,function(idx,item){
				if(item.id==gridId){
					childGrid=item.grid;
				}
			})
			if(childGrid){
				childGrid.endEdit();
			}
        	
        }
       
       
       //全部取消修改
        function cancelAllEdit(gridId)
        {
            var childGrid;
	    	$.each(gridArray,function(idx,item){
				if(item.id==gridId){
					childGrid=item.grid;
				}
			})
			if(childGrid){
				childGrid.cancelEdit();
			}
            
        }
        

		//编辑前事件 
        function onBeforeEdit(e)
        {
         	var str="编辑前事件，可阻止某些行或列进行编辑。列名："+e.column.name+"；行号："+e.rowindex+"；编辑前的值："+e.value+"\n";
         	//if(e.record.id=="121"){
         		//top.Dialog.alert("此行不可编辑",null,null,null,2);
         		// return false;
         	//}
        }
        
        
        //编辑提交前事件 
        function onBeforeSubmitEdit(e){
     		if(e.newdata.userName==""){
     			top.Dialog.alert("姓名不能为空！",null,null,null,2);
     			return false;
     		}
     		else if (!validateInput(e.newdata.userName, "^[\u4e00-\u9fa5]+$")){
     			top.Dialog.alert("姓名需要是中文！",null,null,null,2);
     			return false;
     		}
         		 
     		
     		 
         	
         	
        }
		
		//编辑后事件 
        function onAfterSubmitEdit(e)
        {
        	
        }
    </script>		
</body>
</html>