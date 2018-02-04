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

<!--自动提示框start-->
<script type='text/javascript' src='<%=path%>/libs/js/form/suggestion.js'></script>
<!--自动提示框end-->

<!-- 日期选择框start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/datePicker/WdatePicker.js"></script>
<!-- 日期选择框end -->

</head>
<style>
.img_pencel2{
    background-image: url(<%=path%>/libs/images/icons/edit.png);
    background-repeat: no-repeat;
    background-position:0% 0%;
    width: 20px;
    height: 20px;
    display:inline-block;
    
}
</style>
<body>
	<fieldset >
	<legend>功能点：</legend>
	1、当点击某一单元格后开始编辑后，就可以使用上下左右箭头切换编辑单元格。<br/>
	2、如果行不够可以批量添加行，也可在某行点击右键可以动态插入或删除一行。可以动态修改列名，可索引定位。<br/>
	3、出现滚动条时，在当前可视的最后行按下箭头，表格会自动向下滚动。同理，如果上面仍有行，可视第一行按上箭头，会向上滚动。<br/>
     （ 为简化代码，编辑结果并未提交到后台。批量删除、导入、导入和即时编辑提交等功能的实现见其他示例。）
      </fieldset>
	
	
	<div class="padding_right5">
		<div style="height:1px;overflow:hidden;" id="tipParent"></div>
		<div style="height:1px;overflow:hidden;" id="tipParent2"></div>
		<div id="maingrid"></div>
    </div>
<script type="text/javascript">
	
        var g;
        var menu;
        var currentRow;
        var rowSettingData={"list":[{"value":"0","key":"行尾"},{"value":"1","key":"行首"}]};
       
		 var testData={"form.paginate.pageNo":1,"form.paginate.totalRows":1000,"rows":[
		 	{"A":"小张","B":"","C":"","D":"","E":"","F":"","G":""},
		 	{"A":"小李","B":"","C":"","D":"","E":"","F":"","G":""},
		 	{"A":"","B":"","C":"","D":"","E":"","F":"","G":""},
		 	{"A":"","B":"","C":"","D":"","E":"","F":"","G":""},
		 	{"A":"","B":"","C":"","D":"","E":"","F":"","G":""},
		 	{"A":"","B":"","C":"","D":"","E":"","F":"","G":""},
		 	{"A":"","B":"","C":"","D":"","E":"","F":"","G":""},
		 	{"A":"小赵","B":"","C":"","D":"","E":"","F":"","G":""},
		 	{"A":"","B":"","C":"","D":"","E":"","F":"","G":""},
		 	{"A":"","B":"","C":"","D":"","E":"","F":"","G":""},
		 	{"A":"","B":"","C":"","D":"","E":"","F":"","G":""},
		 	{"A":"","B":"","C":"","D":"","E":"","F":"","G":""},
		 	{"A":"","B":"","C":"","D":"","E":"","F":"","G":""},
		 	{"A":"","B":"","C":"","D":"","E":"","F":"","G":""},
		 	{"A":"","B":"","C":"","D":"","E":"","F":"","G":""},
		 	{"A":"","B":"","C":"","D":"","E":"","F":"","G":""},
		 	{"A":"","B":"","C":"","D":"","E":"","F":"","G":""},
		 	{"A":"","B":"","C":"","D":"","E":"","F":"","G":""},
		 	{"A":"","B":"","C":"","D":"","E":"","F":"","G":""},
		 	{"A":"","B":"","C":"","D":"","E":"","F":"","G":""}
		 ]}
		 
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
		 
		
		
		var newrowid=200;
		function initComplete(){
			//$("#rowSettingSelect").data("data",rowSettingData);
			//$("#rowSettingSelect").render();
			
			 menu = $.rightClickMenu({ width: 120, items:
	            [
	            { text: '向前插入行', click: itemclick, iconClass: 'icon_btn_up2',menuId:0 },
	            { line: true },
	            { text: '向后插入行', click: itemclick, iconClass: 'icon_btn_down2',menuId:1 },
	            { line: true },
	            { text: '删除本行', click: itemclick, iconClass: 'icon_delete',menuId:2  }
	            ]
	         }); 
			 initGrid();
    		
            $("fieldset").bind("click",function(e){
				g.endEdit();
			})
			
			$(".headerChangeBtn").bind("click",function(){
				var pencelBtn=$(this);
				var headerText=pencelBtn.parent().prev().text();
				var tip=pencelBtn.tip({content: '列标题：<input type="text" value="'+headerText+'" class="textinput" style="width:120px;"/> <input type="button" value="确定" class="button"/>',showCloseBtn:true,width:250,distanceX:-20});
				var tipId=pencelBtn.attr("tipId");
				$("#"+tipId).find(".button").click(function(){
					var newText=$(this).prev().val();
					pencelBtn.parent().prev().text(newText);
					tip.remove();
				})
			})
		}
		
		function initGrid(){
			 g = $("#maingrid").quiGrid({
                columns: [ 
	                { name: 'A', align: 'left', width: 120,editor: { type: 'text'},isSort:false,headerRender:function(column){
	                	return '<span style="float:left;padding-left:20px;">A</span><div style="float:right;padding-right:10px;width:20px;"><span class="img_pencel2 hand headerChangeBtn"></span></div><div class="clear"></div>'
	                }},
	                { name: 'B', align: 'left', width: 120,editor: { type: 'text'},isSort:false,headerRender:function(column){
	                	return '<span style="float:left;padding-left:20px;">B</span><div style="float:right;padding-right:10px;width:20px;"><span class="img_pencel2 hand headerChangeBtn"></span></div><div class="clear"></div>'
	                }},
	                { name: 'C', align: 'left', width: 120,editor: { type: 'text'},isSort:false,headerRender:function(column){
	                	return '<span style="float:left;padding-left:20px;">C</span><div style="float:right;padding-right:10px;width:20px;"><span class="img_pencel2 hand headerChangeBtn"></span></div><div class="clear"></div>'
	                }},
	                { name: 'D', align: 'left', width: 120,editor: { type: 'text'},isSort:false,headerRender:function(column){
	                	return '<span style="float:left;padding-left:20px;">D</span><div style="float:right;padding-right:10px;width:20px;"><span class="img_pencel2 hand headerChangeBtn"></span></div><div class="clear"></div>'
	                }},
	                { name: 'E', align: 'left', width: 120,editor: { type: 'text'},isSort:false,headerRender:function(column){
	                	return '<span style="float:left;padding-left:20px;">E</span><div style="float:right;padding-right:10px;width:20px;"><span class="img_pencel2 hand headerChangeBtn"></span></div><div class="clear"></div>'
	                }},
	                 {  name: 'F',      align: 'left', width: 155,isSort:false,editor: { type: 'suggestion',data:listdata,inputWidth:150,showList:true },render:function (item){
	                	  for (var i = 0; i < listdata["list"].length; i++)
                        {
                            if (listdata["list"][i]['value'] == item.F)
                                return listdata["list"][i]['key']
                        }
                        return item.F;
	                },headerRender:function(column){
	                	return '<span style="float:left;padding-left:20px;">F</span><div style="float:right;padding-right:10px;width:20px;"><span class="img_pencel2 hand headerChangeBtn"></span></div><div class="clear"></div>'
	                }},
	                 {  name: 'G', align: 'left', width: 150,isSort:false,editor: { type: 'date',dateFmt:'yyyy-MM-dd'},headerRender:function(column){
	                	return '<span style="float:left;padding-left:20px;">G</span><div style="float:right;padding-right:10px;width:20px;"><span class="img_pencel2 hand headerChangeBtn"></span></div><div class="clear"></div>'
	                }}
	               
                ], 
                data:testData,sortName: 'A',rownumbers:true,checkbox:true,pageSize:1000,dataAction:"server",usePager: true,
                height: "100%", width:"100%",enabledEdit: true,onBeforeEdit: onBeforeEdit, onBeforeSubmitEdit: onBeforeSubmitEdit,
                onAfterEdit: onAfterEdit, whenRClickToSelect:false,excelMode:true,usePager:false,onDelete:onDelete,
                onContextmenu : function (parm,e)
                {
                    currentRow = parm.data;
                    menu.show({ top: e.pageY, left: e.pageX });
                    return false;
                },
    
			     toolbar:{
			    	 items:[
			    		  {text: '批量新增', click: addRows, iconClass: 'icon_add'},
			    		  { line : true },
			    		  {text: '批量删除', iconClass: 'icon_delete'},
			    		  { line : true },
			    		  {text: '导入', iconClass: 'icon_import'},
			    		  { line : true },
			    		  {text: '导出', iconClass: 'icon_reply'},
			    		  { line : true },
			    		  {text: '索引定位', click: findRow, iconClass: 'icon_find'}
			    		  
			    		]
			     	} 
            });
		}
		
		function addRows(){
			$("#tipParent").tip({content: "",showCloseBtn:true,width:300,height:60,distanceY:20,distanceX:30});
			var tipId=$("#tipParent").attr("tipId");
			var formContent=$("#"+tipId).find(".qui-tip-con");
			if(formContent.find("#addRowSetting").length==0){
				var $table=$('<div id="addRowSetting"><table><tr><td>插入</td><td><input type="text" style="width:60px" value="1" id="rowSettingInput" inputMode="numberOnly"/></td><td>行，到</td><td><select id="rowSettingSelect" selWidth="70"></select></td><td><input  id="rowSettingSure" type="button" value="确定" onclick="addRowsHandler()"/></td></tr></table></div>')
				$("#"+tipId).find(".qui-tip-con").append($table);
				$table.find("#rowSettingInput").render();
				$table.find("#rowSettingSelect").data("data",rowSettingData);
				$table.find("#rowSettingSelect").render();
				$table.find("#rowSettingSure").render();
			}	
		
		}
		function cancelAddRows(){
			$("#tipParent").hideTip();
		}
		function addRowsHandler(){
			var inputValue=$("#rowSettingInput").val();
			if(inputValue>20){
				top.Dialog.alert("批量新增一次不能超过20条");
				return;
			}
			var selValue=$("#rowSettingSelect").attr("relValue");
			var firstRow = g.getRow(0);
			for(var i=0;i<inputValue;i++){
				var rowData={
					A:"",
					B:"",
					C:"",
					D:"",
					E:"",
					F:"",
					G:""
				}
				if(selValue==0){
				 	g.addRow(rowData);
				}
				else{
					g.addRow(rowData, firstRow, true);
				}
			}
			$("#tipParent").hideTip();
		}
		 function itemclick(item, i)
        {
            var rowData={
					A:"",
					B:"",
					C:"",
					D:"",
					E:"",
					F:"",
					G:""
				}
            if(item.menuId==0){
            	g.addRow(rowData, currentRow, true);
            }
            else if(item.menuId==1){
            	g.addRow(rowData, currentRow, false);
            }
            else if(item.menuId==2){
            	g.deleteRow(currentRow);
            }
        }
		
		
		function addUser(){
			var valid = $('#myFormId').validationEngine({returnIsValid: true});
			if(valid){
			  addUserHandler();
			   
			 }
		}	
			
		function onDelete(rowindex){
			var rowData=g.getRow(rowindex);
			//alert(JSON.stringify(rowData));
			g.deleteRow(rowData);
			
		}	
			
		function findRow(){
			$("#tipParent2").tip({content: "",showCloseBtn:true,width:350,height:60,distanceY:20,distanceX:430});
			var tipId=$("#tipParent2").attr("tipId");
			var formContent=$("#"+tipId).find(".qui-tip-con");
			if(formContent.find("#findRowSetting").length==0){
				var $table=$('<div id="findRowSetting"><table><tr><td>查找第一列包含关键字：</td><td><input type="text" style="width:120px" value="小赵" id="rowFindInput"/></td><td><input  id="rowFindSure" type="button" value="确定" onclick="findRowHandler()"/></td></tr></table></div>')
				$("#"+tipId).find(".qui-tip-con").append($table);
				$table.find("#rowFindInput").render();
				$table.find("#rowFindSure").render();
				$table.find("#rowFindInput").bind("enter",function(){
					findRowHandler()
				})
			}	
		}	
		
		function findRowHandler(){
			var inputValue=$("#rowFindInput").val();
			for (var record in g.records){
				if(g.records[record]['A']==inputValue){
					var targetRow=g.records[record];
					g.select(targetRow);
					var rowPosition=g.records[record]['rowPosition'];
					g.setScroller(rowPosition,null,true);
			    }
			}
			
			$("#tipParent2").hideTip();
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
         	
         	
         	
        }
		
		//编辑后事件 
        function onAfterEdit(e)
        {
         	//var str="编辑后事件，用于ajax提交处理。列名："+e.column.name+"；行号："+e.rowindex+"；编辑后的值："+e.value+"\n";
         	
        }
        
       
</script>		
</body>
</html>