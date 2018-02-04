<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>带复选框的树</title>
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!-- ztree start -->
<script type="text/javascript" src="<%=path%>/libs/js/tree/ztree/ztree.js"></script>
<link href="<%=path%>/libs/js/tree/ztree/ztree.css" rel="stylesheet" type="text/css"/>
<!-- ztree end -->

</head>
<body>
  <div class="box1" panelWidth="800">
      
      <fieldset>
	      <legend>1、基本使用</legend>
	      <div>
			  <ul id="tree-1" class="ztree"></ul>
		  </div>
		  <input type="button" value="获取选择结果" onclick="getSelectValue();"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset>
	      <legend>2、父子关联</legend>
	      <p>改变下面的选项，可以改变树节点选择时的关联行为。</p>
	      <p>父子关联关系：</p>
			被勾选时：<input type="checkbox" id="py" class="checkbox first" checked="checked" onclick="setCheck();"/><span>关联父</span> 
			<input type="checkbox" id="sy" class="checkbox first" checked="checked" onclick="setCheck();"/><span>关联子</span><br/> 
			取消勾选时：<input type="checkbox" id="pn" class="checkbox first" checked="checked" onclick="setCheck();"/><span>关联父</span> 
			<input type="checkbox" id="sn" class="checkbox first" checked="checked" onclick="setCheck();"/><span>关联子</span><br/> 
			<input id="code" type="text" readonly="readonly" style="width:400px;"/>
	      <div>
			  <ul id="tree-2" class="ztree"></ul>
		  </div>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset>
	      <legend>3、事件控制</legend>
	      <span>事件日志</span>
          <textarea id="log3" resize="true" readonly="readonly" style="height:170px; width:300px;"></textarea>
          <input type="button" value="清除日志" onclick="$('#log3').val('')"/>
          <input type="button" value="勾选'员工3'" onclick="checkNode();"/>
          <input type="button" value="取消勾选'员工3'" onclick="disCheckNode();"/>
	      <div>
			  <ul id="tree-3" class="ztree"></ul>
		  </div>
	  </fieldset>
	  
  
  </div>
 
 <script type="text/javascript">
	 
	var setting1 = {
		check: {
			enable: true
		}
	};
	
	var zNodes1 = [
		{ id:1,  parentId:0, name:"部门1", open: true, checked: true},
		{ id:11, parentId:1, name:"员工1"},
		{ id:12, parentId:1, name:"员工2"},
		{ id:13, parentId:1, name:"员工3", checked:true},
		{ id:2,  parentId:0, name:"部门2", open: true},
		{ id:21, parentId:2, name:"员工4(没有复选框)", nocheck: true},
		{ id:22, parentId:2, name:"员工5"},
		{ id:23, parentId:2, name:"员工6"},
		{ id:24, parentId:2, name:"员工7(有复选框，但不可选)", chkDisabled: true}
	];
	
	
	var setting2 = {
		check: {
			enable: true,
			chkboxType: { "Y" : "ps", "N" : "ps" }
		}
	};
	
	var setting3 = {
		check: {
			enable: true
		},
		callback: {
			beforeCheck: beforeCheck3,
			onCheck: onCheck3
		}
	};
	
	function initComplete(){
		$.fn.zTree.init($("#tree-1"), setting1, zNodes1);
		$.fn.zTree.init($("#tree-2"), setting2, zNodes1);
		$.fn.zTree.init($("#tree-3"), setting3, zNodes1);
		//显示“父子关联关系”用的 实际项目中不用
	    setCheck();
	}
	
	//选择结果
	function getSelectValue(){
	
		//获取zTree对象
		var zTree = $.fn.zTree.getZTreeObj("tree-1");
		//得到选中的数据集
		var checkedNodes = zTree.getCheckedNodes(true);
		//得到未选中的数据集
		var checkedNodes2 = zTree.getCheckedNodes(false);
		
		var msg = "";
		var msg2 = "";
		
		for(var i = 0; i < checkedNodes.length; i++){
			msg += "," + checkedNodes[i].id;
		}
		if(msg == ""){
			msg = "无选择";
		}else{
		    msg = msg.substring(1);
		}
		
		for(var j = 0; j < checkedNodes2.length; j++){
			msg2 = msg2 + "," + checkedNodes2[j].id;
		}
		if(msg2 == ""){
			msg2 = "无选择";
		}else{
		    msg2 = msg2.substring(1);
		}
		
		top.Dialog.alert("已选中:<br/>"+msg+"<br/>未选中：<br/>"+msg2);
	}

	
	function beforeCheck3(treeId, treeNode) {
	    appendToLog3("beforeCheck", treeNode.id, treeNode.name);
	}
	
	function onCheck3(event, treeId, treeNode) {
	    appendToLog3("onCheck", treeNode.id, treeNode.name);
	}	
	
	//追加日志信息
	function appendToLog3(eventName, nodeId, nodeName){
	    $('#log3').val( function(index, val){
	       return val + "【" + eventName + "】 " + nodeId + "  " + nodeName + "\n";
	    });
	}
    
    
	//勾选
	function checkNode(){
	    var zTree = $.fn.zTree.getZTreeObj("tree-3");
	    var node = zTree.getNodeByParam('id', '13');
	    //4个参数：① 节点 ② 勾选true/取消勾选false ③checkTypeFlag设置父子关联true/设置父子不关联false ④是否回调，调用回调函数true，否则false  
	    zTree.checkNode(node, true, true, true);
	}
	
	
	//取消勾选
	function disCheckNode(){
		var zTree = $.fn.zTree.getZTreeObj("tree-3");
	    var node = zTree.getNodeByParam('id', '13');
	    zTree.checkNode(node, false, true, true);
	}
	
	
	//------------------------ 父子关联 代码显示 ----------------------------//
	var code;
		
	function setCheck() {
		var zTree = $.fn.zTree.getZTreeObj("tree-2"),
		py = $("#py").attr("checked")? "p":"",
		sy = $("#sy").attr("checked")? "s":"",
		pn = $("#pn").attr("checked")? "p":"",
		sn = $("#sn").attr("checked")? "s":"",
		type = { "Y":py + sy, "N":pn + sn};
		zTree.setting.check.chkboxType = type;
		$("#code").val('setting.check.chkboxType = { "Y" : "' + type.Y + '", "N" : "' + type.N + '" }');
	}
	
		

 </script>

</body>
</html>