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
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!--数据表格start-->
<script src="<%=path%>/libs/js/table/quiGrid.js" type="text/javascript"></script>
<!--数据表格end-->

<!-- 日期选择框start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/datePicker/WdatePicker.js"></script>
<!-- 日期选择框end -->

<!-- 数字步进器start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/stepper.js"></script>
<!-- 数字步进器end -->

<!-- 树组件start -->
<script type="text/javascript" src="<%=path%>/libs/js/tree/ztree/ztree.js"></script>
<link type="text/css" rel="stylesheet" href="<%=path%>/libs/js/tree/ztree/ztree.css"></link>
<!-- 树组件end -->

<!-- 树形下拉框start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/selectTree.js"></script>
<!-- 树形下拉框end -->
</head>
<body>
<div>
<span class="red">提示：可双击某一行或点击某一行的编辑图标来编辑该行。</span>
</div>
	<div class="padding_right5">
		<div id="maingrid"></div>
    </div>
<script type="text/javascript">
      
        var g;
        var sexData={"list":[{"value":"1","key":"男"},{"value":"0","key":"女"}]};
        var educationData={"list":[{"value":"1","key":"大专"},{"value":"2","key":"本科"},{"value":"3","key":"硕士"},{"value":"4","key":"博士"}]};
        var jobNode = {"treeNodes":[
			{ id:1, parentId:0, name:"界面设计"},
			{ id:2, parentId:0, name:"程序开发"},
			{ id:3, parentId:0, name:"市场调研"},
			{ id:4, parentId:0, name:"质量监督"},
			{ id:5, parentId:0, name:"产品测试"}
		]};
        
        var departNode;
		
		
		
		var newrowid=200;
		function initComplete(){
			 $.post("<%=path%>/getDepartmentsTree.action",
					{},
					function(result){
						departNode = result;
						initGrid();
					},"json");
		}
		
		function initGrid(){
			 g = $("#maingrid").quiGrid({
                columns: [ 
	                { display: '姓名', name: 'userName',     align: 'left', width: 120,editor: { type: 'text',maxlength:5,tip:'不超过5个字的中文' }},
	                { display: '用户名', name: 'userLoginName',     align: 'left', width: 120,editor: { type: 'text',tip:'英文或数字' }},
	                { display: '密码', name: 'userPassword',     align: 'left', width: 120,editor: { type: 'text',tip:'6到11位的英文或数字' }},
	                { display: '性别', name: 'userSex',      align: 'left', width: 55,editor: { type: 'select',data:sexData,selWidth:50 },render:function (item){
	                	  for (var i = 0; i < sexData["list"].length; i++)
                        {
                            if (sexData["list"][i]['value'] == item.userSex)
                                return sexData["list"][i]['key']
                        }
                        return item.userSex;
	                }},
	                 { display: '年龄', name: 'userAge', align: 'left', width: 80,type:"int",editor: { type: 'stepper',min:18,tip:'不能小于18岁' } },
	                 { display: '入职时间', name: 'userEmployTime', align: 'left', width: 100,editor: { type: 'date',dateFmt:'yyyy-MM-dd'}},
	               
	                { display: '部门', name: 'userDepartment', align: 'left', width: 150,editor: { type: 'selectTree',data:departNode,selWidth:145 },render:function (item){
	                	  for (var i = 0; i < departNode["treeNodes"].length; i++)
                        {
                            if (departNode["treeNodes"][i]['id'] == item.userDepartment)
                                return departNode["treeNodes"][i]['name']
                        }
                        return "";
	                } },
	                
	                { display: '学历', name: 'userEducation',      align: 'left', width: 55,editor: { type: 'select',data:educationData,selWidth:50 },render:function (item){
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
		                         h += "<a onclick='onDelete(" + rowindex + ")'><span class='icon_delete'>删除</span></a> "; 
		                         h += "<a onclick='onView(" + rowindex + ")'><span class='icon_view'>查看</span></a>"; 
		                        h += "<a onclick='beginEdit(" + rowindex + ")'><span class='icon_edit'>修改</span></a> ";
		                       
		                    }
		                    else
		                    {
		                         h += "<a onclick='onDelete(" + rowindex + ")'><span class='icon_delete'>删除</span></a> ";
		                         h += "<a onclick='onView(" + rowindex + ")'><span class='icon_view'>查看</span></a>"; 
		                        h += "<a onclick='endEdit(" + rowindex + ")'><span class='icon_ok'>提交</span></a> ";
		                        h += "<a onclick='cancelEdit(" + rowindex + ")'><span class='icon_no'>取消</span></a> "; 
		                       
		                    }
		                    return h;
		                }
                }
                ], 
               url: '<%=path%>/getUserdbs.action', sortName: 'userId',rownumbers:true,pageSize:20,dataAction:"server",usePager: true,
                height: "100%", width:"100%",enabledEdit: true,clickToEdit: false,onDblClickRow:function(rowdata, rowindex){
            		g.beginEdit(rowindex);
                },onBeforeEdit: onBeforeEdit, onBeforeSubmitEdit: onBeforeSubmitEdit,onAfterSubmitEdit: onAfterSubmitEdit,
				toolbar: 
					{ 
					items: [
		                { text: '新增', click: addUser, iconClass: 'icon_add' },
		                { line: true },
		                { text: '全部确认修改', click: endAllEdit, iconClass: 'icon_ok' },
		                { line: true },
		                { text: '全部取消修改', click: cancelAllEdit, iconClass: 'icon_no' }
		              
	                ]
                }            
            });
		}
		
		//查看
		function onView(rowidx){
			var row = g.getRow(rowidx)
			top.Dialog.open({
				URL:"<%=path%>/getUserdbDetail.action?userinfor.userId=" + row.userId,
				Title:"查看",Width:500,Height:350});
		}
		//删除
		function onDelete(rowidx){
			top.Dialog.confirm("确定要删除该记录吗？",function(){
			  	//删除记录
			  	var row = g.getRow(rowidx)
			  	$.post("<%=path%>/deleteUserdb.action",
			  			{"ids":row.userId},
			  			function(result){
			  				handleResult(result);
						},"json");
						//刷新表格
						g.loadData();
				});
		}
		
		//编辑
		 function beginEdit(rowid) { 
            g.beginEdit(rowid);
        }
        
        //取消编辑
        function cancelEdit(rowid) { 
            g.cancelEdit(rowid);
        }
        
        //结束编辑
        function endEdit(rowid)
        {
            g.endEdit(rowid);
        }

		
		//新增
		function addUser(){
			  var row = g.getRow(0);
			  var rowData={
					  userName:"新增",
						userLoginName:"guest",
						userPassword:"123456",
						userSex:1,
						userAge:18,
						userId:'',
						userEmployTime:"",
						orgName:"",
						userEducation:""
					}
			  g.addEditRow(rowData, row, true);
			  //在这里做新增处理
			  $.post("<%=path%>/saveUserdb.action",rowToBO(rowData),function(result){
				  	if(result.id ==0 || result.id == ''){
				  		top.Dialog.alert(result.message);
			    	}
			    	g.getRow(0).userId = result.id;
	            },"json");
		}
		
		//将row JSON对象转化为bo对象
		function rowToBO(row) {
			var params = 'userinfor.userId='+row.userId+'&userinfor.userName='+row.userName+'&userinfor.userSex='+row.userSex+'&userinfor.userAge='+Math.ceil(row.userAge)+'&userinfor.userDepartment='+row.userDepartment+'&userinfor.userEmployTime='+row.userEmployTime+'&userinfor.userPassword='+row.userPassword+'&userinfor.userEducation='+row.userEducation+'&userinfor.userLoginName='+row.userLoginName;
			return params;
		}
		
		//删除后的提示
		function handleResult(result){
			if(result.result == 1){
				top.Dialog.alert("删除成功！",null,null,null,1);
				g.loadData();
			}else{
				top.Dialog.alert("删除失败！");
			}
		}
		
		
		//全部确认修改
       function endAllEdit(){
        	g.endEdit();
        }
       
       
       //全部取消修改
        function cancelAllEdit()
        {
            g.cancelEdit();
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
         		 
     		if(e.newdata.userLoginName==""){
     			top.Dialog.alert("用户名不能为空！",null,null,null,2);
     			return false;
     		}
     		else if (!validateInput(e.newdata.userLoginName, "^[0-9a-zA-Z]+$")){
     			top.Dialog.alert("用户名需要是字母或数字！",null,null,null,2);
     			return false;
     		}
         		 
     		if(e.newdata.userPassword==""){
     			top.Dialog.alert("密码不能为空！",null,null,null,2);
     			return false;
     		}
     		else if (e.newdata.userPassword.length<6||e.newdata.userPassword.length>11){
     			top.Dialog.alert("密码需要是6-11位！",null,null,null,2);
     			return false;
     		}
     		else if (!validateInput(e.newdata.userPassword, "^[0-9a-zA-Z]+$")){
     			top.Dialog.alert("密码需要是字母或数字！",null,null,null,2);
     			return false;
     		}
     		 
         	
         	
        }
		
		//编辑后事件 
        function onAfterSubmitEdit(e)
        {
        	//在这里一律作修改处理
			var rowData = e.newdata;
        	rowData.userId = e.record.userId;
        	//ajax方式提交数据到数据库
            $.post("<%=path%>/saveUserdb.action",rowToBO(rowData),function(result){
            	if(result.id ==0 || result.id == ''){
            		top.Dialog.alert(result.message);
		    	}
            },"json");
			//var row =certInfoGrid.getRow(e.rowindex);
			//$.post("${CONTEXT_PATH}/material/certInfo/saveCertInfo.do?",rowToBO(row),function(){},"json");
        }
        
		
</script>		
</body>
</html>