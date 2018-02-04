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

<!--自动提示框start-->
<script type='text/javascript' src='<%=path%>/libs/js/form/suggestion.js'></script>
<!--自动提示框end-->

<!-- 组合下拉框start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/selectCustom.js"></script>
<!-- 组合拉框end -->
 
<!-- 条件过滤器 start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/filter.js"></script>
<!-- 条件过滤器 end -->

<!-- 双向选择器start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/lister.js"></script>
<!-- 双向选择器end -->

<!-- 树组件start -->
<script type="text/javascript" src="<%=path%>/libs/js/tree/ztree/ztree.js"></script>
<link type="text/css" rel="stylesheet" href="<%=path%>/libs/js/tree/ztree/ztree.css"></link>
<!-- 树组件end -->

<!-- 树形双选器start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/listerTree.js"></script>
<!-- 树形双选器end -->
</head>
<body>
	<div class="intro">
	这里展示了自动提示框作为编辑器，过滤器、双选器、表格等与组合下拉框构造成编辑器。为简化代码，编辑结果并未提交到后台。
	</div>
	<div class="padding_right5">
		<div id="maingrid"></div>
    </div>
<script type="text/javascript">
	
        var g;
       
		var gridEditorColumns=[ 
	                { display: '姓名', name: 'userName', align: 'center',  width: "30%"},
	                { display: '性别', name: 'userSex', align: 'center' , width: "20%"},
	                { display: '部门', name: 'orgName',  align: 'center' , width: "30%"},
	                { display: '学历', name: 'userEducation',  align: 'center', width: "20%" }
                ]
       var gridEditorColumns2=[ 
	                { display: '姓名', name: 'userName', align: 'center',  width: 150},
	                { display: '性别', name: 'userSex', align: 'center' , width: 80}
                ]         
          var gridTreeEditorColumns=[
	        { display: '部门名', name: 'name', id:'deptId', width: 150, align: 'left' },
	        { display: '部门id', name: 'id',width: 80, type: 'int', align: 'left' }
	        ]  
		
		
		var filterData={"list":[
			{"name":"部门1","list":[
				{"key":"员工1","value":"1","iconClass":"icon_user"},
				{"key":"员工2","value":"2","iconClass":"icon_user"},
				{"key":"员工3","value":"3","iconClass":"icon_user_female"},
				{"key":"员工4","value":"4","iconClass":"icon_user"},
				{"key":"员工5","value":"5","iconClass":"icon_user"}]},
			{"name":"部门2","list":[
				{"key":"员工6","value":"6","iconClass":"icon_user_female"},
				{"key":"员工7","value":"7","iconClass":"icon_user"},
				{"key":"员工8","value":"8","iconClass":"icon_user_worker"}]},
			{"name":"部门3","list":[
				{"key":"员工9","value":"9","iconClass":"icon_user"},
				{"key":"员工10","value":"10","iconClass":"icon_user"},
				{"key":"员工11","value":"11","iconClass":"icon_user"},
				{"key":"员工12","value":"12","iconClass":"icon_user"},
				{"key":"员工13","value":"13","iconClass":"icon_user"}]},
			{"name":"部门4","list":[
				{"key":"员工14","value":"14","iconClass":"icon_user"},
				{"key":"员工15","value":"15","iconClass":"icon_user"},
				{"key":"员工16","value":"16","iconClass":"icon_user"}]}]}
		
		    
         var gridTreeEditorData={"rows":[
			{"id":1,"parentId":0,"name":"南京分公司","iconClass":"icon_star","open":false,"children":[
				{"id":2,"parentId":1,"name":"市场部","iconClass":"icon_list","open":false,"children":[
					{"id":3,"parentId":2,"name":"市场1组","iconClass":"icon_mark","children":null},
					{"id":11,"parentId":2,"name":"市场2组","iconClass":"icon_mark","children":null},
					{"id":12,"parentId":2,"name":"市场3组","iconClass":"icon_mark","children":null}
				]},
				{"id":13,"parentId":1,"name":"财务部","iconClass":"icon_list","children":null},
				{"id":14,"parentId":1,"name":"行政部","iconClass":"icon_list","children":null},
				{"id":15,"parentId":1,"name":"工程部","iconClass":"icon_list","children":null},
				{"id":16,"parentId":1,"name":"技术部","iconClass":"icon_list","children":null},
				{"id":17,"parentId":1,"name":"生产部","iconClass":"icon_list","children":null}
			]},
			{"id":7,"parentId":0,"name":"杭州办事处","iconClass":"icon_star","open":false,"children":[
				{"id":8,"parentId":7,"name":"接待处","iconClass":"icon_list","children":null},
				{"id":9,"parentId":7,"name":"洽谈处","iconClass":"icon_list","children":null}
			]},
			{"id":18,"parentId":0,"name":"郑州办事处","iconClass":"icon_star","open":false,"children":[
				{"id":19,"parentId":18,"name":"接待处","iconClass":"icon_list","children":null},
				{"id":20,"parentId":18,"name":"洽谈处","iconClass":"icon_list","children":null}
			]},
			{"id":21,"parentId":0,"name":"苏州办事处","iconClass":"icon_star","open":false,"children":[
				{"id":22,"parentId":21,"name":"接待处","iconClass":"icon_list","children":null},
				{"id":23,"parentId":21,"name":"洽谈处","iconClass":"icon_list","children":null}
			]},
			{"id":24,"parentId":0,"name":"北京办事处","iconClass":"icon_star","children":null}
		]}  
		
		var listerData={fromList:[{value:"1",key:"员工1"},{value:"2",key:"员工2"},{value:"3",key:"员工3"},{value:"4",key:"员工4"}],"toList":[]}; 
		var listerDataFormat=[];
		
		var listerTreeData={"toList":[],"fromList":[
			{"id":"1","parentId":"0","open":"true","name":"部门1","oldParentId":"null","drag":"false"},
			{"id":"11","parentId":"1","name":"员工1","oldParentId":"1"},
			{"id":"12","parentId":"1","name":"员工2","oldParentId":"1"},
			{"id":"13","parentId":"1","name":"员工3","oldParentId":"1"},
			{"id":"2","parentId":"0","open":"true","name":"部门2","oldParentId":"null","drag":"false"},
			{"id":"21","parentId":"2","name":"员工4","oldParentId":"2"}
		]}
		var listerTreeDataFormat=[];
		
		 
        var listdata={"list":[
{value:"1",key:"北京",suggest:"北京|beijing|bj"},
{value:"2",key:"广州",suggest:"广州|guangzhou|gz"},
{value:"3",key:"深圳",suggest:"深圳|shenzhen|sz"},
{value:"4",key:"上海",suggest:"上海|shanghai|sh"},
{value:"5",key:"长沙",suggest:"长沙|changsha|cs"},
{value:"6",key:"成都",suggest:"成都|chengdu|cd"},
{value:"7",key:"贵阳",suggest:"贵阳|guiyang|gy"},
{value:"8",key:"海口",suggest:"海口|haikou|hk"},
{value:"9",key:"杭州",suggest:"杭州|hangzhou|hz"},
{value:"10",key:"昆明",suggest:"昆明|kunming|km"},
{value:"11",key:"南昌",suggest:"南昌|nanchang|nc"},
{value:"12",key:"南京",suggest:"南京|nanjing|nj"},
{value:"13",key:"三亚",suggest:"三亚|sanya|sy"},
{value:"14",key:"沈阳",suggest:"沈阳|shenyang|sy"},
{value:"15",key:"温州",suggest:"温州|wenzhou|wz"},
{value:"16",key:"武汉",suggest:"武汉|wuhan|wh"},
{value:"17",key:"厦门",suggest:"厦门|xiamen|xm"},
{value:"18",key:"西安",suggest:"西安|xian|xa"},
{value:"19",key:"郑州",suggest:"郑州|zhenghou|zz"},
{value:"20",key:"汕头",suggest:"汕头|shantou|st"},
{value:"21",key:"太原",suggest:"太原|taiyuan|ty"},
{value:"22",key:"天津",suggest:"天津|tianjin|tj"}]};    
                
		var gridEditorData;
		var gridTreeEditorDataFarmat=[];
		function initComplete(){
			 $(".intro").bind("click",function(e){
				g.endEdit();
			})
			
			 $.post("<%=path%>/getUsersOfPager.action",
					{},
					function(result){
						gridEditorData = result;
						initGrid();
					},"json");
			
			gridTreeEditorDataFarmat=formatTreeData(gridTreeEditorData["rows"]);	 
			
			for (var rowparm in listerData["fromList"])
            {
                var item = listerData["fromList"][rowparm];
                if (!item) continue;
                listerDataFormat.push(item);
            }
            
            for (var rowparm2 in listerTreeData["fromList"])
            {
                var item2 = listerTreeData["fromList"][rowparm2];
                if (!item2) continue;
                listerTreeDataFormat.push(item2);
            }
			
		}
		
		var newData=[];
		function formatTreeData(data){
			for (var rowparm in data)
            {
                var item = data[rowparm];
                if (!item) continue;
                newData.push(item);
                if(item["children"]){
                	formatTreeData(item["children"]);
                }
                
            }
            return newData;
		}
		
		function initGrid(){
			 g = $("#maingrid").quiGrid({
                columns: [ 
	                 { display: '姓名', name: 'userName',   align: 'left', width: 80,editor: { type: 'text',maxlength:5,tip:'不超过5个字的中文' }},
	                 
	               { display: '组合下拉框-过滤器', name: 'child',  showTitle:true,    align: 'left', width: 155,editor: { type: 'selectCustom',boxWidth:500,selWidth:150,multiMode:true,data:filterData,child:{type:'filter',multiMode:true,groupMode:true}},render:function (item){
	                	if(!item.child){
	                		   return "";
	                	   }
	                	   var itemArray=item.child.split(",");
	                	   var childStr="";
	                	   for (var i = 0; i < itemArray.length; i++){
	                	   		for (var j = 0; j < filterData["list"].length; j++){
	                	   			for (var k = 0; k < filterData["list"][j]["list"].length; k++){
		                	   			var item= filterData["list"][j]["list"][k];
		                	   			if (item['value'] == itemArray[i]){
		                	   				childStr=childStr+item['key']+",";
		                	   				continue;
		                	   			}
	                	   			}
	                	   		}
	                	   }
	                	   if (childStr.length > 0 ){
								childStr = childStr.substring(0, childStr.length-1);
							} 
                        	return childStr;
	                }},
	                 { display: '组合下拉框-表格多选', name: 'child2',  showTitle:true,  align: 'left', width: 155,editor: 
	                 { type: 'selectCustom',boxWidth:500,selWidth:150,multiMode:true,data:gridEditorData,child:
	                 	{type:'grid',columns:gridEditorColumns,pageSize:5,rownumbers:true,checkbox:true,percentWidthMode:true,height:300,width:500,valueField:"userId",labelField:"userName",
	                 	showPageInfo:false,selectRowButtonOnly:false,isChecked:checkedHandlerEditor,onCheckRow: checkRowHandlerEditor, onCheckAllRow: checkAllRowHandlerEditor}},
	                 render:function (item){
	                	if(!item.child2){
	                		   return "";
	                	   }
	                	   var itemArray=item.child2.split(",");
	                	   var childStr="";
	                	   for (var i = 0; i < itemArray.length; i++){
	                	   		for (var j = 0; j < gridEditorData["rows"].length; j++){
	                	   			if (gridEditorData["rows"][j]['userId'] == itemArray[i]){
	                	   				childStr=childStr+gridEditorData["rows"][j]['userName']+",";
	                	   				continue;
	                	   			}
	                	   		}
	                	   }
	                	   if (childStr.length > 0 ){
								childStr = childStr.substring(0, childStr.length-1);
							} 
                        	return childStr;
	                	  
	                }},
	                
	                { display: '组合下拉框-树表格多选', name: 'child3',  showTitle:true,  align: 'left', width: 155,editor: 
	                 { type: 'selectCustom',boxWidth:300,selWidth:150,multiMode:true,data:gridTreeEditorData,child:
	                 	{type:'grid',columns:gridTreeEditorColumns,checkbox:true,rownumbers:false,usePager:false,width:300,valueField:"id",labelField:"name",
	                 	autoCheckChildren:false,selectRowButtonOnly:false,tree:{ columnId: 'deptId' },isChecked:checkedHandlerEditor,onCheckRow: checkRowHandlerEditor, onCheckAllRow: checkAllRowHandlerEditor}},
	                 render:function (item){
	                	if(!item.child3){
	                		   return "";
	                	   }
	                	   var itemArray=item.child3.split(",");
	                	   var childStr="";
	                	   for (var i = 0; i < itemArray.length; i++){
	                	   		for (var j = 0; j < gridTreeEditorDataFarmat.length; j++){
	                	   			if (gridTreeEditorDataFarmat[j]['id'] == itemArray[i]){
	                	   				childStr=childStr+gridTreeEditorDataFarmat[j]['name']+",";
	                	   				continue;
	                	   			}
	                	   		}
	                	   }
	                	   if (childStr.length > 0 ){
								childStr = childStr.substring(0, childStr.length-1);
							} 
                        	return childStr;
	                	  
	                }},
	                
	                  { display: '组合下拉框-表格单选', name: 'child4',  align: 'left', width: 155,editor: 
	                 { type: 'selectCustom',boxWidth:280,selWidth:150,data:gridEditorData,child:
	                 	{type:'grid',columns:gridEditorColumns2,pageSize:5,rownumbers:true,checkbox:false,percentWidthMode:true,height:300,width:280,valueField:"userId",labelField:"userName",
	                 	showPageInfo:false,selectRowButtonOnly:false}},
	                 render:function (item){
	                	if(!item.child4){
	                		   return "";
	                	   }
	                	   var itemArray=item.child4.split(",");
	                	   var childStr="";
	                	   for (var i = 0; i < itemArray.length; i++){
	                	   		for (var j = 0; j < gridEditorData["rows"].length; j++){
	                	   			if (gridEditorData["rows"][j]['userId'] == itemArray[i]){
	                	   				childStr=childStr+gridEditorData["rows"][j]['userName']+",";
	                	   				continue;
	                	   			}
	                	   		}
	                	   }
	                	   if (childStr.length > 0 ){
								childStr = childStr.substring(0, childStr.length-1);
							} 
                        	return childStr;
	                	  
	                }},
	                
	                { display: '组合下拉框-树表格单选', name: 'child5',  align: 'left', width: 155,editor: 
	                 { type: 'selectCustom',boxWidth:300,selWidth:150,data:gridTreeEditorData,child:
	                 	{type:'grid',columns:gridTreeEditorColumns,pageSize:5,rownumbers:true,checkbox:false,percentWidthMode:true,height:300,valueField:"id",labelField:"name",
	                 	showPageInfo:false,selectRowButtonOnly:false,tree:{ columnId: 'deptId' }}},
	                 render:function (item){
	                	if(!item.child5){
	                		   return "";
	                	   }
	                	   var itemArray=item.child5.split(",");
	                	   var childStr="";
	                	   for (var i = 0; i < itemArray.length; i++){
	                	   		for (var j = 0; j < gridTreeEditorDataFarmat.length; j++){
	                	   			if (gridTreeEditorDataFarmat[j]['id'] == itemArray[i]){
	                	   				childStr=childStr+gridTreeEditorDataFarmat[j]['name']+",";
	                	   				continue;
	                	   			}
	                	   		}
	                	   }
	                	   if (childStr.length > 0 ){
								childStr = childStr.substring(0, childStr.length-1);
							} 
                        	return childStr;
	                	  
	                }},
	                
	                { display: '组合下拉框-双向选择器', name: 'child6', showTitle:true,  align: 'left', width: 155,editor: 
	                 { type: 'selectCustom',boxWidth:280,selWidth:150,multiMode:true, data:listerData,child:
	                 	{type:'lister',listerWidth:105,listerHeight:120}},
	                 render:function (item){
	                	if(!item.child6){
	                		   return "";
	                	   }
	                	   var itemArray=item.child6.split(",");
	                	   var childStr="";
	                	   for (var i = 0; i < itemArray.length; i++){
	                	   		for (var j = 0; j < listerDataFormat.length; j++){
	                	   			if (listerDataFormat[j]['value'] == itemArray[i]){
	                	   				childStr=childStr+listerDataFormat[j]['key']+",";
	                	   				continue;
	                	   			}
	                	   		}
	                	   }
	                	   if (childStr.length > 0 ){
								childStr = childStr.substring(0, childStr.length-1);
							} 
                        	return childStr;
	                	  
	                }},
	                
	                { display: '组合下拉框-树形双选器', name: 'child7', showTitle:true,  align: 'left', width: 155,editor: 
	                 { type: 'selectCustom',boxWidth:310,selWidth:150,multiMode:true, data:listerTreeData,child:
	                 	{type:'listerTree',listerWidth:120,listerHeight:120}},
	                 render:function (item){
	                	if(!item.child7){
	                		   return "";
	                	   }
	                	  //  alert(JSON.stringify(listerTreeDataFormat))
	                	   var itemArray=item.child7.split(",");
	                	   var childStr="";
	                	   for (var i = 0; i < itemArray.length; i++){
	                	   		for (var j = 0; j <listerTreeDataFormat.length; j++){
	                	   			if (listerTreeDataFormat[j]['id'] == itemArray[i]){
	                	   				childStr=childStr+listerTreeDataFormat[j]['name']+",";
	                	   				continue;
	                	   			}
	                	   		}
	                	   }
	                	   if (childStr.length > 0 ){
								childStr = childStr.substring(0, childStr.length-1);
							} 
                        	return childStr;
	                	  
	                }},
	                
	                { display: '自动提示框', name: 'city',      align: 'left', width: 155,editor: { type: 'suggestion',data:listdata,inputWidth:150,showList:true },render:function (item){
	                	  for (var i = 0; i < listdata["list"].length; i++)
                        {
                            if (listdata["list"][i]['value'] == item.city)
                                return listdata["list"][i]['key']
                        }
                        return item.city;
	                }}
                ], 
               url: '<%=path%>/getUserdbs.action', sortName: 'userId',rownumbers:true,checkbox:true,pageSize:10,dataAction:"server",usePager: true,
                height: "100%", width:"100%",enabledEdit: true,onBeforeEdit: onBeforeEdit, onBeforeSubmitEdit: onBeforeSubmitEdit,onAfterEdit: onAfterEdit
            });
		}
		
		

		
		//查看
		function onView(rowid){
		}
		//删除	
		function onDelete(rowid,rowidx){
		}
		
	
		
		//编辑前事件 
        function onBeforeEdit(e)
        {
         	var str="编辑前事件，可阻止某些行或列进行编辑。列名："+e.column.name+"；行号："+e.rowindex+"；编辑前的值："+e.value+"\n";
        }
        //编辑提交前事件 
        function onBeforeSubmitEdit(e){
         	
         	
        }
		
		//编辑后事件 
        function onAfterEdit(e)
        {
         	//var str="编辑后事件，用于ajax提交处理。列名："+e.column.name+"；行号："+e.rowindex+"；编辑后的值："+e.value+"\n";
        }
        
</script>		
</body>
</html>