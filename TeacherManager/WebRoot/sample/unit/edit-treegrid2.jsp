<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>树形表格</title>
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

<!-- 表单验证start -->
<script src="<%=path%>/libs/js/form/validationRule.js" type="text/javascript"></script>
<script src="<%=path%>/libs/js/form/validation.js" type="text/javascript"></script>
<!-- 表单验证end -->

<!-- 日期控件start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/datePicker/WdatePicker.js"></script>
<!-- 日期控件end -->
</head>
<body>
	<div>与上例的区别在于新增节点的方式。为了保证数据完整性，这里表格编辑结果未提交到后台。</div>
	<div class="padding_right5">
		<div id="maingrid"></div>
    </div>
<script type="text/javascript">
	var g;
	function initComplete(){
	     //usePager: false设置为不分页
		 g = $("#maingrid").quiGrid({
	        columns: [
	        { display: '部门名', name: 'name', id:'deptId', width: 250, align: 'left' ,editor: { type: 'text'}},
	        { display: '部门id', name: 'id',width: 250, type: 'int', align: 'left' },
       		{ display: '操作', isAllowHide: false, align: 'left', width:"12%",
					 render: function (rowdata, rowindex, value, column){
					 	if(rowdata.parentId!=-1){
					 	 	return '<div class="padding_top4 padding_left5">'
                                 + '<span class="img_add hand" title="新增子节点" onclick="showTip(this,' + rowdata.id + ','+rowindex + ')"></span>'
                                 + '<span class="img_btn_up2 hand" title="上移" onclick="goUp(' + rowdata.id+','+rowindex + ')"></span>'
                                 + '<span class="img_btn_down2 hand" title="下移" onclick="goDown(' + rowdata.id + ','+rowindex + ')"></span>' 
                                 + '<span class="img_delete hand" title="删除" onclick="onDelete(' + rowdata.id+','+rowindex + ')"></span>'
                             + '</div>';
					 	}
					 	
					 	else{
					 		return '<div class="padding_top4 padding_left5">'
                                 + '<span class="icon_add hand" title="新增子节点" onclick="addNewRow(' + rowdata.id + ','+rowindex + ')">新增子节点</span>'
                             + '</div>';
					 	}
	                 }
	            }
	        ], 
	        height: '100%', width:"100%",checkbox:false,usePager: false,url:'<%=path%>/getTreeGrid.action',tree: { columnId: 'deptId' },autoCheckChildren:false,
	        enabledEdit: true,onAfterEdit: onAfterEdit
	    });
	}
	
	function addNewRow(rowid,rowindex){
		  var rowData={
				name:$("#inputa1").val(),
				id:'1',
				parentId:rowid
			}
		var row = g.getRow(rowindex);	
		var child=g.getChildren(row)[0];
		
		g.appendRow(rowData,row,child,true)
		 //在这里做新增处理
		  //$.post("<%=path%>/userdbAction.do?method=saveUser",rowToBO(rowData),function(result){
			  	//if(result.id ==0 || result.id == ''){
			  		//top.Dialog.alert(result.message);
		    	//}
		    	//rowData.id = result.id;
           // },"json");	
	}
	
	
	
	//将row JSON对象转化为bo对象
	function rowToBO(row) {
		var params = '&userinfor.userId='+row.userId+'&userinfor.userName='+row.userName+'&userinfor.userSex='+row.userSex+'&userinfor.userAge='+Math.ceil(row.userAge)+'&userinfor.userDepartment='+row.userDepartment+'&userinfor.userEmployTime='+row.userEmployTime+'&userinfor.userPassword='+row.userPassword+'&userinfor.userEducation='+row.userEducation+'&userinfor.userLoginName='+row.userLoginName;
		return params;
	}
	
	function goUp(userId,rowindex){
		g.up(rowindex);
	}
	
	function goDown(userId,rowindex){
		g.down(rowindex);
	}
	
	//编辑后事件 
        function onAfterEdit(e)
        {
         	//var str="编辑后事件，用于ajax提交处理。列名："+e.column.name+"；行号："+e.rowindex+"；编辑后的值："+e.value+"\n";
		  	//alert("此处用于ajax提交处理。列名："+e.column.name+"，id："+e.record.id+"，编辑后的值："+e.value+"\n")
        }
   //删除	
	function onDelete(rowid,rowidx){
		alert("此处用于删除提交处理。")
	}     
var currentObj;
var currentRowid;
var currentRowindex;
function showTip(obj,rowid,rowindex){
	$(obj).tip({content: "",showCloseBtn:true,width:400,height:160,arrowDistanceX:5});
	var tipId=$(obj).attr("tipId");
	var formContent=$("#"+tipId).find(".qui-tip-con");
	currentObj=$(obj);
	currentRowid=rowid;
	currentRowindex=rowindex;
	if(formContent.find("form").length==0){
		var $table=$('<form id="form1" method="post" showOnMouseOver="false">'+
			'<table class="detailFormTable" style="width:100%">'+
			'<tr><td width="80" class="ali03">名称：</td><td><input type="text" id="inputa1" class="validate[required] float_left"/><span class="star float_left">*</span><div class="validation_info"></div><div class="clear"></div></td></tr>'+
			'<tr><td class="ali03">责任人：</td><td><input type="text" id="inputa2" class="validate[required] float_left"/><span class="star float_left">*</span><div class="validation_info"></div><div class="clear"></div></td></tr>	'+
			'<tr><td class="ali03">成立时间：</td><td><input type="text" id="inputa3" class="date validate[required] float_left"/><span class="star float_left">*</span><div class="validation_info"></div><div class="clear"></div></td></tr>	'+
			'<tr><td colspan="2" class="ali01"><div style="padding-left:100px;"><input type="button" value="点击新增" id="inputa4" onclick=\'validateForm("#form1")\'/>&nbsp;<input type="button" value="取消新增" id="inputa5" onclick="cancelSearch()"/></div></td></tr>'+
		'</table></form>')
		
		$("#"+tipId).find(".qui-tip-con").append($table);
		$table.find("#inputa1").render();
		$table.find("#inputa2").render();
		$table.find("#inputa3").render();
		$table.find("#inputa4").render();
		$table.find("#inputa5").render();
		
		$table.validationEngine({showOnMouseOver:false});
	}
}
function cancelSearch(){
	currentObj.hideTip();
}
function validateForm(containerId){
    var valid = $(containerId).validationEngine({returnIsValid: true,showOnMouseOver:false});
	if(valid == true){
		addNewRow(currentRowid,currentRowindex);
		currentObj.hideTip();
	}else{
	   // top.Dialog.alert('表单填写不正确，请按要求填写！');
	} 
}
</script>	
</body>
</html>