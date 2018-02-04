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

<!--父子表start-->
<script type="text/javascript" src="<%=path%>/libs/js/table/detailTable.js"></script>
<!--父子表end-->
</head>
<body>
<div class="box1" panelWidth="800">
	<fieldset> 
		<legend>1、基本使用</legend>
		<p>默认点击图标时，其他打开的自动关闭。</p>
	<table class="detailTable" useColor="false" useHover="false" useClick="false">
		<tr>
			<th width="30">操作</th><th width="100">姓名</th><th width="100">性别</th><th>备注</th>
		</tr>
		<tr>
			<td><span class="img_add2 hand" title="点击展开"></span></td><td>张小三</td><td>男</td><td>备注文字</td>
		</tr>
		<tr>
			<td></td>
			<td colspan="3">
				<table class="tableStyle">
					<tr>
						<th>日期</th><th>栏目1</th><th>栏目2</th><th>栏目3</th><th>栏目4</th>
					</tr>
					<tr>
						<td>2010-9-1</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-2</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-3</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-4</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-5</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
				</table>
			</td>
		</tr>
		
		<tr>
			<td><span class="img_add2 hand" title="点击展开"></span></td><td>张小三</td><td>男</td><td>备注文字</td>
		</tr>
		<tr>
			<td></td>
			<td colspan="3">
				<table class="tableStyle">
					<tr>
						<th>日期</th><th>栏目1</th><th>栏目2</th><th>栏目3</th><th>栏目4</th>
					</tr>
					<tr>
						<td>2010-9-1</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-2</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-3</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-4</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-5</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
				</table>
			</td>
		</tr>
		
		<tr>
			<td><span class="img_add2 hand" title="点击展开"></span></td><td>张小三</td><td>男</td><td>备注文字</td>
		</tr>
		<tr>
			<td></td>
			<td colspan="3">
				<table class="tableStyle">
					<tr>
						<th>日期</th><th>栏目1</th><th>栏目2</th><th>栏目3</th><th>栏目4</th>
					</tr>
					<tr>
						<td>2010-9-1</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-2</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-3</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-4</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-5</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
				</table>
			</td>
		</tr>
		
		<tr>
			<td><span class="img_add2 hand" title="点击展开"></span></td><td>张小三</td><td>男</td><td>备注文字</td>
		</tr>
		<tr>
			<td></td>
			<td colspan="3">
				<table class="tableStyle">
					<tr>
						<th>日期</th><th>栏目1</th><th>栏目2</th><th>栏目3</th><th>栏目4</th>
					</tr>
					<tr>
						<td>2010-9-1</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-2</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-3</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-4</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-5</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  
	  <fieldset> 
			<legend>2、另一种展开方式</legend>
			<p>点击图标时，其他打开的不关闭。</p>
<table class="detailTable" useColor="false" useHover="false" useClick="false" ohterClose="false">
		<tr>
			<th width="30">操作</th><th width="100">姓名</th><th width="100">性别</th><th>备注</th>
		</tr>
		<tr>
			<td><span class="img_add2 hand" title="点击展开"></span></td><td>张小三</td><td>男</td><td>备注文字</td>
		</tr>
		<tr>
			<td></td>
			<td colspan="3">
				<table class="tableStyle">
					<tr>
						<th>日期</th><th>栏目1</th><th>栏目2</th><th>栏目3</th><th>栏目4</th>
					</tr>
					<tr>
						<td>2010-9-1</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-2</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-3</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-4</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-5</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
				</table>
			</td>
		</tr>
		
		<tr>
			<td><span class="img_add2 hand" title="点击展开"></span></td><td>张小三</td><td>男</td><td>备注文字</td>
		</tr>
		<tr>
			<td></td>
			<td colspan="3">
				<table class="tableStyle">
					<tr>
						<th>日期</th><th>栏目1</th><th>栏目2</th><th>栏目3</th><th>栏目4</th>
					</tr>
					<tr>
						<td>2010-9-1</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-2</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-3</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-4</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-5</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
				</table>
			</td>
		</tr>
		
		<tr>
			<td><span class="img_add2 hand" title="点击展开"></span></td><td>张小三</td><td>男</td><td>备注文字</td>
		</tr>
		<tr>
			<td></td>
			<td colspan="3">
				<table class="tableStyle">
					<tr>
						<th>日期</th><th>栏目1</th><th>栏目2</th><th>栏目3</th><th>栏目4</th>
					</tr>
					<tr>
						<td>2010-9-1</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-2</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-3</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-4</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-5</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
				</table>
			</td>
		</tr>
		
		<tr>
			<td><span class="img_add2 hand" title="点击展开"></span></td><td>张小三</td><td>男</td><td>备注文字</td>
		</tr>
		<tr>
			<td></td>
			<td colspan="3">
				<table class="tableStyle">
					<tr>
						<th>日期</th><th>栏目1</th><th>栏目2</th><th>栏目3</th><th>栏目4</th>
					</tr>
					<tr>
						<td>2010-9-1</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-2</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-3</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-4</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-5</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>			
	  </fieldset>
	  <div class="height_15"></div>
	  
	  
	  <fieldset> 
			<legend>3、点击整行触发</legend>
<table class="detailTable" useColor="false" useHover="false" useClick="false" trClick="true">
		<tr>
			<th width="30">操作</th><th width="100">姓名</th><th width="100">性别</th><th>备注</th>
		</tr>
		<tr>
			<td><span class="img_add2 hand" title="点击展开"></span></td><td>张小三</td><td>男</td><td>备注文字</td>
		</tr>
		<tr>
			<td></td>
			<td colspan="3">
				<table class="tableStyle">
					<tr>
						<th>日期</th><th>栏目1</th><th>栏目2</th><th>栏目3</th><th>栏目4</th>
					</tr>
					<tr>
						<td>2010-9-1</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-2</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-3</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-4</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-5</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
				</table>
			</td>
		</tr>
		
		<tr>
			<td><span class="img_add2 hand" title="点击展开"></span></td><td>张小三</td><td>男</td><td>备注文字</td>
		</tr>
		<tr>
			<td></td>
			<td colspan="3">
				<table class="tableStyle">
					<tr>
						<th>日期</th><th>栏目1</th><th>栏目2</th><th>栏目3</th><th>栏目4</th>
					</tr>
					<tr>
						<td>2010-9-1</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-2</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-3</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-4</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
					<tr>
						<td>2010-9-5</td><td>内容1</td><td>内容2</td><td>内容3</td><td>内容4</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>			
	  </fieldset>
	  <div class="height_15"></div>
	  
	  
	  <fieldset> 
			<legend>4、ajax加载子表</legend>
	<table class="detailTable" useColor="false" useHover="false" useClick="false"  ohterClose="false" ajaxMode="true">
		<tr>
			<th width="30">操作</th><th width="100">姓名</th><th width="100">性别</th><th>备注</th>
		</tr>
		<tr>
			<td><span class="img_add2 hand" title="点击展开" url="<%=path%>/sample/table/data/table1.html"></span></td><td>张小三</td><td>男</td><td>备注文字</td>
		</tr>
		<tr>
			<td></td>
			<td colspan="3">
				<table class="tableStyle"></table>
			</td>
		</tr>
		
		<tr>
			<td><span class="img_add2 hand" title="点击展开" url="<%=path%>/sample/table/data/table2.html"></span></td><td>张小三</td><td>男</td><td>备注文字</td>
		</tr>
		<tr>
			<td></td>
			<td colspan="3">
				<table class="tableStyle"></table>
			</td>
		</tr>
		
		<tr>
			<td><span class="img_add2 hand" title="点击展开" url="<%=path%>/sample/table/data/table1.html"></span></td><td>张小三</td><td>男</td><td>备注文字</td>
		</tr>
		<tr>
			<td></td>
			<td colspan="3">
				<table class="tableStyle"></table>
			</td>
		</tr>
		
		<tr>
			<td><span class="img_add2 hand" title="点击展开" url="<%=path%>/sample/table/data/table2.html"></span></td><td>张小三</td><td>男</td><td>备注文字</td>
		</tr>
		<tr>
			<td></td>
			<td colspan="3">
				<table class="tableStyle"></table>
			</td>
		</tr>
	</table>			
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
			<legend>5、点击表格行ajax加载</legend>
			<div class="red">此示例由后台支持</div>
	<table class="detailTable" useColor="false" useHover="false" useClick="false" ajaxMode="true" trClick="true">
		<tr>
			<th width="30">操作</th><th width="100">姓名</th><th width="100">性别</th><th>备注</th>
		</tr> 
		<tr>
			<td><span class="img_add2 hand" title="点击展开" url="<%=path%>/getDetailTable.action?id=1"></span></td><td>张小三</td><td>男</td><td>备注文字</td>
		</tr>
		<tr>
			<td></td>
			<td colspan="3">
				<table class="tableStyle"></table>
			</td>
		</tr>
		
		<tr>
			<td><span class="img_add2 hand" title="点击展开" url="<%=path%>/getDetailTable.action?id=2"></span></td><td>欧阳小三</td><td>女</td><td>备注文字</td>
		</tr>
		<tr>
			<td></td>
			<td colspan="3">
				<table class="tableStyle"></table>
			</td>
		</tr>
		
		<tr>
			<td><span class="img_add2 hand" title="点击展开" url="<%=path%>/getDetailTable.action?id=3"></span></td><td>诸葛小三</td><td>男</td><td>备注文字</td>
		</tr>
		<tr>
			<td></td>
			<td colspan="3">
				<table class="tableStyle"></table>
			</td>
		</tr>
		
		<tr>
			<td><span class="img_add2 hand" title="点击展开" url="<%=path%>/getDetailTable.action?id=4"></span></td><td>上官小三</td><td>女</td><td>备注文字</td>
		</tr>
		<tr>
			<td></td>
			<td colspan="3">
				<table class="tableStyle"></table>
			</td>
		</tr>
	</table>		
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset> 
			<legend>6、动态创建</legend>
			<input type="button" value="点击创建" id="testBtn" onclick="createDetailTable()"/>
	
	  </fieldset>
	  <div class="height_15"></div>
	 

	</div>
	
<script>
	function createDetailTable(){
		var $tableObj=$('<table class="detailTable" useColor="false" useHover="false" useClick="false" ajaxMode="true" trClick="true">'+
			'<tr>'+
				'<th width="30">操作</th><th width="100">姓名</th><th width="100">性别</th><th>备注</th>'+
			'</tr> '+
			'<tr>'+
				'<td><span class="img_add2 hand" title="点击展开" url="<%=path%>/sample/table/data/table1.html"></span></td><td>张小三</td><td>男</td><td>备注文字</td>'+
			'</tr>'+
			'<tr>'+
				'<td></td>'+
				'<td colspan="3">'+
					'<table class="tableStyle"></table>'+
				'</td>'+
			'</tr>'+
			'<tr>'+
				'<td><span class="img_add2 hand" title="点击展开" url="<%=path%>/sample/table/data/table2.html"></span></td><td>张小三</td><td>男</td><td>备注文字</td>'+
			'</tr>'+
			'<tr>'+
				'<td></td>'+
				'<td colspan="3">'+
					'<table class="tableStyle"></table>'+
				'</td>'+
			'</tr>'+
		'</table>');
		$tableObj.render();
		$("#testBtn").after($tableObj);
	}
</script>
</body>
</html>