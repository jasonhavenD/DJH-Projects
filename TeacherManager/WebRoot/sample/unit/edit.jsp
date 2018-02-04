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

<!-- 表单验证start -->
<script src="<%=path%>/libs/js/form/validationRule.js" type="text/javascript"></script>
<script src="<%=path%>/libs/js/form/validation.js" type="text/javascript"></script>
<!-- 表单验证end -->

</head>
<body>
<div class="box2" panelTitle="新增用户" startStatus="close" id="addPanel" startState="close" statusText="点击展开" afterStatusText="点击收缩">
<form id="myFormId">
<table>
<tr>
	<td width="80" class="ali03">用户名：</td>
	<td width="150">
	<input type="text" id="username" name="userinfor.userLoginName" class="validate[required,custom[noSpecialCaracters]]" watermark="请输入英文或数字"/><span class="star">*</span>
	</td>
	<td width="80" class="ali03">密码：</td>
	<td width="150">
	<input type="text" id="pwd" name="userinfor.userPassword" class="validate[required,length[6,11],custom[noSpecialCaracters]]"/><span class="star">*</span>
	</td>
	<td width="80" class="ali03">密码确认：</td>
	<td width="150">
	<input type="text" class="validate[required,confirm[pwd]]"/><span class="star">*</span>
	</td>
</tr>
<tr>
	<td class="ali03">姓名：</td>
	<td>
	<input type="text" name="userinfor.userName" maxlength="5" class="validate[required,custom[chinese]]" id="user"/><span class="star">*</span>
	</td>
	
	<td class="ali03">性别：</td>
	<td>
	<select id="sel-1" name="userinfor.userSex"></select>
	</td>
	<td class="ali03">年龄：</td>
	<td>
	<input type="text" name="userinfor.userAge" class="stepper" value="20" id="age" min="18"/></td>
	</td>
</tr>
<tr>
	<td class="ali03">入职时间：</td>
	<td>
	<input type="text" class="date" name="userinfor.userEmployTime" id="worktime"/>
	</td>
	<td class="ali03">所属部门：</td>
	<td><div class="selectTree" name="userinfor.userDepartment" id="selectTree-1" prompt="请选择" url="<%=path%>/getDepartmentsTree.action"></div>
	</td>
	<td class="ali03">协作部门：</td>
	<td>
	<div class="selectTree" name="userinfor.userAssistance" id="selectTree-2" multiMode="true" prompt="请选择" url="<%=path%>/getDepartmentsTree.action"></div>
	</td>
</tr>
<tr>
	<td class="ali03">学历：</td>
	<td>
	<select id="sel-2" name="userinfor.userEducation"></select>
	</td>
	<td class="ali03">职务：</td>
	<td>
	<div class="selectTree" name="userinfor.userDuty" id="selectTree-3" multiMode="true" noGroup="true"  prompt="请选择"></div>
	</td>
	<td colspan="2" class="ali02"></td>
</tr>
<tr>
	<td colspan="2" class="ali02"><span class="red">提示：点击某单元格来编辑。</span></td>
	<td colspan="4" class="ali01"><button type="button" onclick="addUser()"><span class="icon_add">点击新增</span></button></td>
</tr>
</table>
</form>
</div>
	<div class="padding_right5">
		<div id="maingrid"></div>
    </div>
<script type="text/javascript">
     //设定不可编辑的节点id
	var noeditArray=["1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19"];
	
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
			 
            
            $("#sel-1").data("data",sexData)
    		$("#sel-1").render(); 
    		$("#sel-2").data("data",educationData)
    		$("#sel-2").render(); 
    		
            $("#selectTree-3").data("data",jobNode)
    		$("#selectTree-3").render(); 
    		
    		
            $("#addPanel")
            .bind("stateChange",function(e,state){
				g.resetHeight();
			})
			.bind("click",function(e){
				g.endEdit();
			})
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
                        return item.userDepartment;
	                } },
	                
	               
	                 { display: '协作部门', name: 'userAssistance', align: 'left', width: 200 ,isSort:false,editor: { type: 'selectTree',multiMode:true,data:departNode,selWidth:195 },render:function (item){
	                	   if(!item.userAssistance){
	                		   return "";
	                	   }
	                	   var itemArray=item.userAssistance.split(",");
	                	   var departStr="";
	                	   for (var i = 0; i < itemArray.length; i++){
	                	   		for (var j = 0; j < departNode["treeNodes"].length; j++){
	                	   			if (departNode["treeNodes"][j]['id'] == itemArray[i]){
	                	   				departStr=departStr+departNode["treeNodes"][j]['name']+",";
	                	   				continue;
	                	   			}
	                	   		}
	                	   }
	                	   if (departStr.length > 0 ){
								departStr = departStr.substring(0, departStr.length-1);
							} 
                        	return departStr;
	                } },
	                
	                { display: '学历', name: 'userEducation',      align: 'left', width: 55,editor: { type: 'select',data:educationData,selWidth:50 },render:function (item){
	                	  for (var i = 0; i < educationData["list"].length; i++)
                        {
                            if (educationData["list"][i]['value'] == item.userEducation)
                                return educationData["list"][i]['key']
                        }
                        return item.userEducation;
	                }},
	               
	                { display: '职务', name: 'userDuty', align: 'left', width: 150 ,isSort:false,editor: { type: 'selectTree',multiMode:true,noGroup:true,data:jobNode,selWidth:145 },render:function (item){
	                	   if(!item.userDuty){
	                		   return "";
	                	   }
	                	   var itemArray=item.userDuty.split(",");
	                	   var jobStr="";
	                	   for (var i = 0; i < itemArray.length; i++){
	                	   		for (var j = 0; j < jobNode["treeNodes"].length; j++){
	                	   			if (jobNode["treeNodes"][j]['id'] == itemArray[i]){
	                	   				jobStr=jobStr+jobNode["treeNodes"][j]['name']+",";
	                	   				continue;
	                	   			}
	                	   		}
	                	   }
	                	   if (jobStr.length > 0 ){
								jobStr = jobStr.substring(0, jobStr.length-1);
							} 
                        	return jobStr;
	                } },
	                
	                { display: '操作', isAllowHide: false, align: 'left', width:"60",
						 render: function (rowdata, rowindex, value, column){
	                 	    return '<div class="padding_top4 padding_left5">'
	                                 + '<span class="img_list hand" title="查看" onclick="onView(' + rowdata.userId + ')"></span>'
	                                 + '<span class="img_delete hand" title="删除" onclick="onDelete(' + rowdata.userId+','+rowindex + ')"></span>'
	                             + '</div>';
		                 }
		            }
                ], 
               url: '<%=path%>/getUserdbs.action', sortName: 'userId',rownumbers:true,checkbox:true,pageSize:10,dataAction:"server",usePager: true,
                height: "100%", width:"100%",enabledEdit: true,onBeforeEdit: onBeforeEdit, onBeforeSubmitEdit: onBeforeSubmitEdit,onAfterEdit: onAfterEdit
            });
		}
		
		function addUser(){
			var valid = $('#myFormId').validationEngine({returnIsValid: true});
			if(valid){
			  addUserHandler();
			   
			 }
		}
		
		function addUserHandler(){
			var firstRow = g.getRow(0);
			var rowData={
				userName:$("#user").val(),
				userLoginName:$("#username").val(),
				userPassword:$("#pwd").val(),
				userSex:$("#sel-1").val(),
				userAge:$("#age").val(),
				userId:'',
				userEmployTime:$("#worktime").val(),
				userDepartment:$("#selectTree-1").attr("relvalue"),
				userAssistance:$("#selectTree-2").attr("relvalue"),
				userDuty:$("#selectTree-3").attr("relvalue"),
				userEducation:$("#sel-2").val()
			}
			 g.addRow(rowData, firstRow, true);
            
            //ajax方式提交数据到数据库
            $.post("<%=path%>/saveUserdb.action",rowToBO(rowData),function(result){
            	if(result.id ==0 || result.id == ''){
            		top.Dialog.alert(result.message);
		    	}
		    	g.getRow(0).userId = result.id;
		    	g.loadData();
            },"json");
		}
		
		//将row JSON对象转化为bo对象
		function rowToBO(row) {
			var params = 'userinfor.userName='+row.userName+'&userinfor.userSex='+row.userSex+'&userinfor.userAge='+Math.ceil(row.userAge)+'&userinfor.userDepartment='+row.userDepartment+'&userinfor.userAssistance='+row.userAssistance+'&userinfor.userDuty='+row.userDuty+'&userinfor.userEmployTime='+row.userEmployTime+'&userinfor.userPassword='+row.userPassword+'&userinfor.userEducation='+row.userEducation+'&userinfor.userLoginName='+row.userLoginName;
			return params;
		}

		
		//查看
		function onView(rowid){
			top.Dialog.open({
				URL:"<%=path%>/getUserdbDetail.action?userinfor.userId=" + rowid,
				Title:"查看",Width:500,Height:350});
		}
		//删除	
		function onDelete(rowid,rowidx){
			//if(getPosition(rowid,noeditArray)!=-1){
					//top.Dialog.alert("为保证数据的完整性，由管理员添加的数据无法修改或删除。可以为新添加的数据来修改和删除。");
					//return false;
				//}
			top.Dialog.confirm("确定要删除该记录吗？",function(){
			  	//删除记录
			  	$.post("<%=path%>/deleteUserdb.action",
			  			{"ids":rowid},
			  			function(result){
			  				if(result.result == "1"){
			  					top.Dialog.alert("删除成功！",null,null,null,1);
			  				}else{
			  					top.Dialog.alert("删除失败");
			  				}
							//刷新表格
							g.loadData();
						},"json");
				});
		}
		
	
		
		//编辑前事件 
        function onBeforeEdit(e)
        {
         	var str="编辑前事件，可阻止某些行或列进行编辑。列名："+e.column.name+"；行号："+e.rowindex+"；编辑前的值："+e.value+"\n";
         	//if(e.record.id=="121"){
         	//	top.Dialog.alert("此行不可编辑",null,null,null,2);
         	//	 return false;
         	//}
        }
        //编辑提交前事件 
        function onBeforeSubmitEdit(e){
         	if(e.column.name=="userName"){
         		if(e.value==""){
         			top.Dialog.alert("姓名不能为空！",null,null,null,2);
         			return false;
         		}
         		else if (!validateInput(e.value, "^[\u4e00-\u9fa5]+$")){
         			top.Dialog.alert("姓名需要是中文！",null,null,null,2);
         			return false;
         		}
         		 
         	}
         	if(e.column.name=="userLoginName"){
         		if(e.value==""){
         			top.Dialog.alert("用户名不能为空！",null,null,null,2);
         			return false;
         		}
         		else if (!validateInput(e.value, "^[0-9a-zA-Z]+$")){
         			top.Dialog.alert("用户名需要是字母或数字！",null,null,null,2);
         			return false;
         		}
         		 
         	}
         	if(e.column.name=="userPassword"){
         		if(e.value==""){
         			top.Dialog.alert("密码不能为空！",null,null,null,2);
         			return false;
         		}
         		else if (e.value.length<6||e.value.length>11){
         			top.Dialog.alert("密码需要是6-11位！",null,null,null,2);
         			return false;
         		}
         		else if (!validateInput(e.value, "^[0-9a-zA-Z]+$")){
         			top.Dialog.alert("密码需要是字母或数字！",null,null,null,2);
         			return false;
         		}
         		 
         	}
         	
         	
        }
		
		//编辑后事件 
        function onAfterEdit(e)
        {
         	//var str="编辑后事件，用于ajax提交处理。列名："+e.column.name+"；行号："+e.rowindex+"；编辑后的值："+e.value+"\n";
         	$.post("<%=path%>/modifyUserdbAttributes.action",
		  			{"id":e.record.userId,"key":e.column.name,"value":e.value},
		  			function(result){
		  				
		  			},"json");
        }
        
</script>		
</body>
</html>