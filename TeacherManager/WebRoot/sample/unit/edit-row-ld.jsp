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
即时编辑下拉框联动：两种类型：1、不取后台值，而是进行一些计算，改变级联的下拉框；2、需要改变的值是从后台重新取。这里是第1种。<br/>
目前只支持两级联动，但可以使用多个两级联动。为了简化代码，这里表格编辑结果未提交到后台。
</div>
	<div class="padding_right5">
		<div id="maingrid"></div>
    </div>
<script type="text/javascript">
      
        var g;
         var testData={"form.paginate.pageNo":1,"form.paginate.totalRows":13,"rows":[
      {"userDepartment":"2","userGroup":"22","userSex":"1","id":125,"userEducation":"2","userAge":20,"userName":"张三","userType":"1","medical":11},
      {"userDepartment":"3","userGroup":"32","userSex":"1","id":126,"userEducation":"2","userAge":20,"userName":"李四","userType":"2","medical":22}
      ]}
        
        
        
        var sexData={"list":[{"value":"1","key":"男"},{"value":"0","key":"女"}]};
        var educationData={"list":[{"value":"1","key":"大专"},{"value":"2","key":"本科"},{"value":"3","key":"硕士"},{"value":"4","key":"博士"}]};
        
		var depart={"list":[{"value":"1","key":"市场部"},{"value":"2","key":"财务部"},{"value":"3","key":"咨询部"}]};
		var group1={"list":[{"value":"11","key":"市场一组"},{"value":"12","key":"市场二组"},{"value":"13","key":"市场三组"}]};
		var group2={"list":[{"value":"21","key":"财务一组"},{"value":"22","key":"财务二组"},{"value":"23","key":"财务三组"}]};
		var group3={"list":[{"value":"31","key":"咨询一组"},{"value":"32","key":"咨询二组"},{"value":"33","key":"咨询三组"}]};
		
		
		var userTypeData={"list":[{"value":"1","key":"正式员工"},{"value":"2","key":"临时员工"}]};
		var medi1={"list":[{"value":"11","key":"公费医疗"},{"value":"12","key":"自费医疗"},{"value":"13","key":"无医疗保险"}]};
		var medi2={"list":[{"value":"21","key":"自费医疗"},{"value":"22","key":"无医疗保险"}]};
		
		var newrowid=200;
		function initComplete(){
			 
			 initGrid();
		}
		
		function initGrid(){
			 g = $("#maingrid").quiGrid({
                columns: [ 
	                { display: '姓名', name: 'userName',     align: 'left', width: 120,editor: { type: 'text',maxlength:5,tip:'不超过5个字的中文' }},
	                { display: '性别', name: 'userSex',      align: 'left', width: 65,editor: { type: 'select',data:sexData,selWidth:50 },render:function (item){
	                	  for (var i = 0; i < sexData["list"].length; i++)
                        {
                            if (sexData["list"][i]['value'] == item.userSex)
                                return sexData["list"][i]['key']
                        }
                        return item.userSex;
	                }},
	               
	                { display: '部门', name: 'userDepartment',      align: 'left', width: 165,editor: { type: 'select',data:depart,selWidth:150,link:true,relation:"parent" ,linkHandler:linkHandler1 },render:function (item){
	                	  for (var i = 0; i < depart["list"].length; i++)
                        {
                            if (depart["list"][i]['value'] == item.userDepartment)
                                return depart["list"][i]['key']
                        }
                        return "";
	                }},
	                 { display: '小组', name: 'userGroup',  align: 'left', width: 165,editor: { type: 'select',data:group1,selWidth:150,link:true,relation:"child",linkHandler:linkHandler1 },render:function (item){
	                	  var childData=linkHandler1(item.userDepartment);
	                	  if(childData){
	                	  	for (var i = 0; i < childData["list"].length; i++)
	                        {
	                            if (childData["list"][i]['value'] == item.userGroup)
	                                return childData["list"][i]['key']
	                        }
	                	  }
	                	  
                        return "";
	                }},
	               
	                { display: '入职类型', name: 'userType',  align: 'left', width: 165,editor: { type: 'select',data:userTypeData,selWidth:150,link:true,relation:"parent" ,linkHandler:linkHandler2 },render:function (item){
	                	  for (var i = 0; i < userTypeData["list"].length; i++)
                        {
                            if (userTypeData["list"][i]['value'] == item.userType)
                                return userTypeData["list"][i]['key']
                        }
                        return "";
	                }},
	                 { display: '医保情况', name: 'medical',  align: 'left', width: 165,editor: { type: 'select',data:medi1,selWidth:150,link:true,relation:"child",linkHandler:linkHandler2 },render:function (item){
	                	  var childData=linkHandler2(item.userType);
	                	  if(childData){
	                	  	for (var i = 0; i < childData["list"].length; i++)
	                        {
	                            if (childData["list"][i]['value'] == item.medical)
	                                return childData["list"][i]['key']
	                        }
	                	  }
	                	  
                        return "";
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
                data:testData,sortName: 'userId',rownumbers:true,pageSize:10,dataAction:"server",usePager: true,
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
		
		function linkHandler1(value){
			var cData;
			if(value=="1"){
				cData=group1;
			}
			else if(value=="2"){
				cData=group2;
			}
			else if(value=="3"){
				cData=group3;
			}
			return cData;
		}
		
		function linkHandler2(value){
			var cData;
			if(value=="1"){
				cData=medi1;
			}
			else if(value=="2"){
				cData=medi2;
			}
			return cData;
		}
		
		//查看
		function onView(rowidx){
			
		}
		//删除
		function onDelete(rowidx){
			
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
						userSex:1,
						userAge:18,
						userId:'',
						userEducation:"2",
						userDepartment:"",
						userGroup:""
					}
			  g.addEditRow(rowData, row, true);
		}
		
		//将row JSON对象转化为bo对象
		function rowToBO(row) {
			var params = '&userinfor.userId='+row.userId+'&userinfor.userName='+row.userName+'&userinfor.userSex='+row.userSex+'&userinfor.userAge='+Math.ceil(row.userAge)+'&userinfor.userDepartment='+row.userDepartment+'&userinfor.userEmployTime='+row.userEmployTime+'&userinfor.userPassword='+row.userPassword+'&userinfor.userEducation='+row.userEducation+'&userinfor.userLoginName='+row.userLoginName;
			return params;
		}
		
		//删除后的提示
		function handleResult(result){
			if(result == 1){
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
        }
		
		//编辑后事件 
        function onAfterSubmitEdit(e)
        {
        	
        }
        
		
</script>		
</body>
</html>