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
  <table class="detailTable" useColor="false" useHover="false" useClick="false" trClick="true">
	<tr>
		<th width="30">操作</th><th>消息标题</th>
	</tr>
	<tr>
		<td><span class="img_add2 hand" title="点击展开"></span></td><td>FlashPlayer垃圾回收机制</td>
	</tr>
	<tr>
		<td></td>
		<td>
			<table class="tableStyle" useHover="false" useClick="false">
				<tr>
					<td>
					垃圾收集器简称GC（ Garbage Collector ），是一段自动执行的逻辑，Flash Player的通过GC自动管理内存使用，回收程序中无用的对象来释放内存	
					</td>
				</tr>
			</table>
		</td>
	</tr>
	
	<tr>
		<td><span class="img_add2 hand" title="点击展开"></span></td><td>垃圾收集器不支持自动收集垃圾</td>
	</tr>
	<tr>
		<td></td>
		<td>
			<table class="tableStyle" useHover="false" useClick="false">
				<tr>
					<td>
					引入这些新控件带来一个副作用：垃圾收集器不再支持自动为你收集垃圾。Flash Player有两种方法来查找非活动对象并移除它们：引用计数法和标识清除法
					</td>
				</tr>
			</table>
		</td>
	</tr>
	
	<tr>
		<td><span class="img_add2 hand" title="点击展开"></span></td><td>垃圾回收并不是一直在运行的</td>
	</tr>
	<tr>
		<td></td>
		<td>
			<table class="tableStyle" useHover="false" useClick="false">
				<tr>
					<td>
					由于FlashPlayer 遍历你的整个对象结构，该过程对CPU占用太多。FlashPlayer 9 通过调整迭代标识-清除缩减对CPU的占用。该过程跨越几个阶段不再是一次完成，变成偶尔运行。
					</td>
				</tr>
			</table>
		</td>
	</tr>
	
	<tr>
		<td><span class="img_add2 hand" title="点击展开"></span></td><td>有了GC，为什么还会内存泄漏</td>
	</tr>
	<tr>
		<td></td>
		<td>
			<table class="tableStyle" useHover="false" useClick="false">
				<tr>
					<td>
					GC 的触发不是根据程序的清除指令来执行，而是根据内存分配情况来执行的。内存空间越紧俏， GC 才工作越勤快。 GC 只管标记，而且内存释放是异步执行的。整个过程极不透明；
					</td>
				</tr>
			</table>
		</td>
	</tr>
	
	<tr>
		<td><span class="img_add2 hand" title="点击展开"></span></td><td>FlashPlayer垃圾回收机制</td>
	</tr>
	<tr>
		<td></td>
		<td>
			<table class="tableStyle" useHover="false" useClick="false">
				<tr>
					<td>
					垃圾收集器简称GC（ Garbage Collector ），是一段自动执行的逻辑，Flash Player的通过GC自动管理内存使用，回收程序中无用的对象来释放内存	
					</td>
				</tr>
			</table>
		</td>
	</tr>
	
	<tr>
		<td><span class="img_add2 hand" title="点击展开"></span></td><td>垃圾收集器不支持自动收集垃圾</td>
	</tr>
	<tr>
		<td></td>
		<td>
			<table class="tableStyle" useHover="false" useClick="false">
				<tr>
					<td>
					引入这些新控件带来一个副作用：垃圾收集器不再支持自动为你收集垃圾。Flash Player有两种方法来查找非活动对象并移除它们：引用计数法和标识清除法
					</td>
				</tr>
			</table>
		</td>
	</tr>
	
	<tr>
		<td><span class="img_add2 hand" title="点击展开"></span></td><td>垃圾回收并不是一直在运行的</td>
	</tr>
	<tr>
		<td></td>
		<td>
			<table class="tableStyle" useHover="false" useClick="false">
				<tr>
					<td>
					由于FlashPlayer 遍历你的整个对象结构，该过程对CPU占用太多。FlashPlayer 9 通过调整迭代标识-清除缩减对CPU的占用。该过程跨越几个阶段不再是一次完成，变成偶尔运行。
					</td>
				</tr>
			</table>
		</td>
	</tr>
	
	<tr>
		<td><span class="img_add2 hand" title="点击展开"></span></td><td>有了GC，为什么还会内存泄漏</td>
	</tr>
	<tr>
		<td></td>
		<td>
			<table class="tableStyle" useHover="false" useClick="false">
				<tr>
					<td>
					GC 的触发不是根据程序的清除指令来执行，而是根据内存分配情况来执行的。内存空间越紧俏， GC 才工作越勤快。 GC 只管标记，而且内存释放是异步执行的。整个过程极不透明；
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>	
</body>
</html>