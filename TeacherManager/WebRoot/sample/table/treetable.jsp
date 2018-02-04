<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!--树形表格start-->
<script type="text/javascript" src="<%=path%>/libs//js/table/treeTable.js"></script>
<!--树形表格end-->
</head>
<body>
 <div class="box1" panelWidth="800">
 	<fieldset> 
			<legend>1、基本用法</legend>
<table class="treeTable">
	<tr>
		<th width="250">名称</th>
		<th width="120">大小</th>
		<th>备注</th>
	</tr>
	<tr id="node-1">
		<td><span class="folder">根目录1</span></td>
		<td>--</td>
		<td>备注说明</td>
	</tr>
	<tr id="node-2" class="child-of-node-1">
		<td><span class="folder">二级目录1</span></td>
		<td>--</td>
		<td>备注说明</td>
	</tr>
	<tr id="node-8" class="child-of-node-2">
		<td><span class="file">文件1</span></td>
		<td>52 KB</td>
		<td>备注说明</td>
	</tr>
	<tr id="node-9" class="child-of-node-2">
		<td><span class="file">文件2</span></td>
		<td>4 KB</td>
		<td>备注说明</td>
	</tr>
	<tr id="node-3" class="child-of-node-1">
		<td><span class="file">文件3</span></td>
		<td>4 KB</td>
		<td>备注说明</td>
	</tr>
	<tr id="node-4" class="child-of-node-1">
		<td><span class="folder">二级目录2</span></td>
		<td>--</td>
		<td>备注说明</td>
	</tr>
	<tr id="node-5" class="child-of-node-4">
		<td><span class="file">文件4</span></td>
		<td>56 KB</td>
		<td>备注说明</td>
	</tr>
	<tr id="node-14">
		<td><span class="file">文件5</span></td>
		<td>4 KB</td>
		<td>备注说明</td>
	</tr>
	<tr id="node-11">
		<td><span class="folder">根目录2</span></td>
		<td>--</td>
		<td>备注说明</td>
	</tr>
	<tr id="node-12" class="child-of-node-11">
		<td><span class="file">文件6</span></td>
		<td>4 KB</td>
		<td>备注说明</td>
	</tr>
</table>		
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
			<legend>2、不使用图标</legend>
如果不希望有文件夹和文件的图标，去掉td中的span。
<table class="treeTable">
	<tr>
		<th width="250">名称</th>
		<th width="120">大小</th>
		<th>备注</th>
	</tr>
	<tr id="node-1">
		<td>根目录1</td>
		<td>--</td>
		<td>备注说明</td>
	</tr>
	<tr id="node-2" class="child-of-node-1">
		<td>二级目录1</td>
		<td>--</td>
		<td>备注说明</td>
	</tr>
	<tr id="node-8" class="child-of-node-2">
		<td>文件1</td>
		<td>52 KB</td>
		<td>备注说明</td>
	</tr>
	<tr id="node-9" class="child-of-node-2">
		<td>文件2</td>
		<td>4 KB</td>
		<td>备注说明</td>
	</tr>
</table>			
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
			<legend>3、不可收缩</legend>
为table添加expandable属性可设置是否可展开/闭合。下面的是一个不可收缩的树形表格
<table class="treeTable" expandable="false">
	<tr>
		<th width="250">名称</th>
		<th width="120">大小</th>
		<th>备注</th>
	</tr>
	<tr id="node-1">
		<td><span class="folder">根目录1</span></td>
		<td>--</td>
		<td>备注说明</td>
	</tr>
	<tr id="node-2" class="child-of-node-1">
		<td><span class="folder">二级目录1</span></td>
		<td>--</td>
		<td>备注说明</td>
	</tr>
	<tr id="node-8" class="child-of-node-2">
		<td><span class="file">文件1</span></td>
		<td>52 KB</td>
		<td>备注说明</td>
	</tr>
	<tr id="node-9" class="child-of-node-2">
		<td><span class="file">文件2</span></td>
		<td>4 KB</td>
		<td>备注说明</td>
	</tr>
</table>
另外table如果设置initState="collapsed"	则初始时树形表格处于收缩状态。			
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
			<legend>4、ajax模式</legend>
	<table class="treeTable" ajaxMode="true">
		<tr>
			<th width="250">名称</th>
			<th width="120">大小</th>
			<th>备注</th>
		</tr>
		<tr id="ajaxnode-1" url="<%=path%>/sample/table/data/table3.html">
			<td><span class="folder">根目录1</span></td>
			<td>--</td>
			<td>备注说明</td>
		</tr>
		<tr id="ajaxnode-14">
			<td><span class="file">文件5</span></td>
			<td>4 KB</td>
			<td>备注说明</td>
		</tr>
		<tr id="ajaxnode-11" url="<%=path%>/sample/table/data/table4.html">
			<td><span class="folder">根目录2</span></td>
			<td>--</td>
			<td>备注说明</td>
		</tr>
	</table>			
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
			<legend>5、checkbox模式</legend>
	<table class="treeTable" checkMode="true" id="mytable">
		<tr>
			<th width="250">名称</th>
			<th width="120">大小</th>
			<th>备注</th>
		</tr>
		<tr id="node-1">
			<td><span class="folder">根目录1</span></td>
			<td>--</td>
			<td>备注说明</td>
		</tr>
		<tr id="node-2" class="child-of-node-1">
			<td><span class="folder">二级目录1</span></td>
			<td>--</td>
			<td>备注说明</td>
		</tr>
		<tr id="node-8" class="child-of-node-2">
			<td><span class="file">文件1</span></td>
			<td>52 KB</td>
			<td>备注说明</td>
		</tr>
		<tr id="node-9" class="child-of-node-2">
			<td><span class="file">文件2</span></td>
			<td>4 KB</td>
			<td>备注说明</td>
		</tr>
		<tr id="node-4" class="child-of-node-1">
			<td><span class="folder">二级目录2</span></td>
			<td>--</td>
			<td>备注说明</td>
		</tr>
		<tr id="node-5" class="child-of-node-4">
			<td><span class="file">文件4</span></td>
			<td>56 KB</td>
			<td>备注说明</td>
		</tr>
		<tr id="node-11">
			<td><span class="folder">根目录2</span></td>
			<td>--</td>
			<td>备注说明</td>
		</tr>
		<tr id="node-12" class="child-of-node-11">
			<td><span class="file">文件6</span></td>
			<td>4 KB</td>
			<td>备注说明</td>
		</tr>
	</table>	
	<br/>
	<input type="button" value="查看选中tr的id" onclick="viewCheckIds()"/>			
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
			<legend>6、ajax模式下的check模式</legend>
			<div class="red">此示例由后台支持</div>
	<table class="treeTable" ajaxMode="true" checkMode="true">
		<tr>
			<th width="250">名称</th>
			<th width="120">大小</th>
			<th>备注</th>
		</tr>
		<tr id="ajaxnode-1" url="<%=path%>/getTreeTableData.action?id=1">
			<td><span class="folder">根目录1</span></td>
			<td>--</td>
			<td>备注说明</td>
		</tr>
		<tr id="ajaxnode-2" url="<%=path%>/getTreeTableData.action?id=2">
			<td><span class="folder">根目录2</span></td>
			<td>--</td>
			<td>备注说明</td>
		</tr>
	</table>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  
	   <fieldset> 
			<legend>7、动态创建</legend>
			<input type="button" value="点击创建" id="testBtn" onclick="createTreeTable()"/>
	
	  </fieldset>
	  <div class="height_15"></div>
	  
	  
</div>	
<script>
	function viewCheckIds(){
		var msg="";
		$("#mytable input[type=checkbox]").each(function(){
			if($(this).attr("checked")){
				msg=msg+","+$(this).parents("tr").attr("id")
			}
		})
		if(msg==""){
			msg="无选择"
		}
		top.Dialog.alert(msg);
	}
	
	function createTreeTable(){
		var $tableObj=$('<table class="treeTable" ajaxMode="true">'+
			'<tr>'+
				'<th width="250">名称</th>'+
				'<th width="120">大小</th>'+
				'<th>备注</th>'+
			'</tr>'+
			'<tr id="ajaxnode-1" url="data/table3.html">'+
				'<td><span class="folder">根目录1</span></td>'+
				'<td>--</td>'+
				'<td>备注说明</td>'+
			'</tr>'+
			'<tr id="ajaxnode-11" url="data/table4.html">'+
				'<td><span class="folder">根目录2</span></td>'+
				'<td>--</td>'+
				'<td>备注说明</td>'+
			'</tr>'+
		'</table>');
		$tableObj.render();
		$("#testBtn").after($tableObj);
	}
</script>
</body>
</html>