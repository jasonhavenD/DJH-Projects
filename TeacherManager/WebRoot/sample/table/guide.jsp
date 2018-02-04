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
</head>
<body>
	<div class="box1" panelWidth="800">
	 <fieldset>
      	<legend>注意</legend>
如果是需要实现数据列表，推荐使用grid表格而不是table表格，本章提供table数据列表示例是为了兼容以前的版本或者应对某些特殊情况。<br/><br/>
新版中设置table的class="tableStyle"默认只会拥有表格的外观。<br/><br/>
只有再添加mode="list"才会渲染列表的功能。以改善表单布局时使用tableStyle造成性能问题。<br/><br/>
大量表单元素或者表单布局较复杂时，建议只设置表格的class="tableStyle"，然后手动为tr设置高度，为td添加class="ali01"或者class="ali02"或者class="ali03"设置对其方式<br/><br/>
只有简单表单布局才建议使用formMode方式布局。
      </fieldset>
      <div class="height_15"></div>
      
       <fieldset>
      	<legend>1、未被渲染的列表-基本示例</legend>
<table class="tableStyle">
	<tr>
		<th>姓名</th><th>性别</th><th>年龄</th>
	</tr>
	<tr>
		<td>张小三</td><td>男</td><td>25</td>
	</tr>
	<tr>
		<td>张小三</td><td>男</td><td>25</td>
	</tr>
	<tr>
		<td>张小三</td><td>男</td><td>25</td>
	</tr>
	<tr>
		<td>张小三</td><td>男</td><td>25</td>
	</tr>
</table>
可用来做布局表单或者简单列表。<br/>
宽度默认100%，如果想自定义宽度，为table设置style，例如style="width:500px;" <br/>
单元格文字过长默认折行,如果想要始终不折行，设置table的class同时为tableStyle tableStyleWordWrap<br/>
列表背景间隔换色和鼠标移入效果可以手动添加代码实现，这样比让框架直接渲染性能更好。见本章的“列表性能优化方案”。<br/>
      </fieldset>
      <div class="height_30"></div>
     
      
      <fieldset>
      	<legend>2、渲染的列表-基本示例</legend>
<table class="tableStyle" mode="list">
	<tr>
		<th>姓名</th><th>性别</th><th>年龄</th>
	</tr>
	<tr>
		<td>张小三</td><td>男</td><td>25</td>
	</tr>
	<tr>
		<td>张小三</td><td>男</td><td>25</td>
	</tr>
	<tr>
		<td>张小三</td><td>男</td><td>25</td>
	</tr>
	<tr>
		<td>张小三</td><td>男</td><td>25</td>
	</tr>
</table>
框架直接对其渲染。默认效果是：表格间隔换色、鼠标移入行变色、点击单行变色。
      </fieldset>
      <div class="height_30"></div>
      
      <fieldset>
      	<legend>3、渲染的列表-多行点击变色</legend>
<table class="tableStyle" mode="list" useMultColor="true">
	<tr>
		<th>姓名</th><th>性别</th><th>年龄</th>
	</tr>
	<tr>
		<td>张小三</td><td>男</td><td>25</td>
	</tr>
	<tr>
		<td>张小三</td><td>男</td><td>25</td>
	</tr>
	<tr>
		<td>张小三</td><td>男</td><td>25</td>
	</tr>
	<tr>
		<td>张小三</td><td>男</td><td>25</td>
	</tr>
</table>
      </fieldset>
      <div class="height_30"></div>
      
      <fieldset>
      	<legend>4、渲染的列表-radio模式</legend>
<table class="tableStyle" mode="list" useRadio="true" id="radioTable">
	<tr>
		<th width="50"></th><th>姓名</th><th>性别</th><th>年龄</th>
	</tr>
	<tr>
		<td class="ali02"><input type="radio" name="radio1" value="1"/></td><td>张小三</td><td>男</td><td>25</td>
	</tr>
	<tr>
		<td class="ali02"><input type="radio" name="radio1" value="2"/></td><td>张小三</td><td>男</td><td>25</td>
	</tr>
	<tr>
		<td class="ali02"><input type="radio" name="radio1" value="3"/></td><td>张小三</td><td>男</td><td>25</td>
	</tr>
	<tr>
		<td class="ali02"><input type="radio" name="radio1" value="4"/></td><td>张小三</td><td>男</td><td>25</td>
	</tr>
</table>
<input type="button" value="获得选中项" onclick="getRadioRow()"/>
      </fieldset>
      <div class="height_30"></div>
      
      <fieldset>
      	<legend>5、渲染的列表-checkbox模式</legend>
<table class="tableStyle" mode="list" useCheckbox="true" id="checkboxTable">
	<tr>
		<th width="50"></th><th>姓名</th><th>性别</th><th>年龄</th>
	</tr>
	<tr>
		<td class="ali02"><input type="checkbox" value="1"/></td><td>张小三</td><td>男</td><td>25</td>
	</tr>
	<tr>
		<td class="ali02"><input type="checkbox" value="2"/></td><td>张小三</td><td>男</td><td>25</td>
	</tr>
	<tr>
		<td class="ali02"><input type="checkbox" value="3"/></td><td>张小三</td><td>男</td><td>25</td>
	</tr>
	<tr>
		<td class="ali02"><input type="checkbox" value="4"/></td><td>张小三</td><td>男</td><td>25</td>
	</tr>
</table>
<input type="button" value="获得选中项" onclick="getCheckBoxRow()"/>
      </fieldset>
      <div class="height_30"></div>
      
      <fieldset>
      	<legend>6、渲染的列表-checkbox模式-点击行选中</legend>
<table class="tableStyle" mode="list" useCheckbox="true" selectRowButtonOnly="false">
	<tr>
		<th width="50"></th><th>姓名</th><th>性别</th><th>年龄</th>
	</tr>
	<tr>
		<td class="ali02"><input type="checkbox"/></td><td>张小三</td><td>男</td><td>25</td>
	</tr>
	<tr>
		<td class="ali02"><input type="checkbox"/></td><td>张小三</td><td>男</td><td>25</td>
	</tr>
	<tr>
		<td class="ali02"><input type="checkbox"/></td><td>张小三</td><td>男</td><td>25</td>
	</tr>
	<tr>
		<td class="ali02"><input type="checkbox"/></td><td>张小三</td><td>男</td><td>25</td>
	</tr>
</table>
      </fieldset>
      <div class="height_30"></div>
      
      <fieldset>
      	<legend>7、渲染的列表-排序模式</legend>
<table class="tableStyle" mode="list" sortMode="true">
	<tr>
		<th><span>姓名</span></th><th><span>性别</span></th><th><span>年龄</span></th>
	</tr>
	<tr>
		<td>张小三</td><td>男</td><td>25</td>
	</tr>
	<tr>
		<td>张小三</td><td>男</td><td>25</td>
	</tr>
	<tr>
		<td>张小三</td><td>男</td><td>25</td>
	</tr>
	<tr>
		<td>张小三</td><td>男</td><td>25</td>
	</tr>
</table>
排序模式表头会有响应鼠标移入效果
      </fieldset>
      <div class="height_30"></div>
      
      <fieldset>
      	<legend>8、渲染的列表-宽度非100%</legend>
<table class="tableStyle" mode="list" thTrueWidth="true">
	<tr>
		<th trueWidth="100">姓名</th><th trueWidth="100">性别</th><th trueWidth="100">年龄</th>
	</tr>
	<tr>
		<td>张小三</td><td>男</td><td>25</td>
	</tr>
	<tr>
		<td>张小三</td><td>男</td><td>25</td>
	</tr>
	<tr>
		<td>张小三</td><td>男</td><td>25</td>
	</tr>
	<tr>
		<td>张小三</td><td>男</td><td>25</td>
	</tr>
</table>
读取每个th设置的trueWidth，让表格的宽度为每个th的trueWidth的总和。可通过此方法让表格出现横向滚动条。
      </fieldset>
      <div class="height_30"></div>
      
      <fieldset>
      	<legend>9、渲染的列表-文字折行</legend>
<table class="tableStyle" mode="list" fixedCellHeight="true">
	<tr>
		<th width="150">姓名</th><th width="150">性别</th><th width="150">年龄</th><th>备注</th>
	</tr>
	<tr>
		<td>张小三</td><td>男</td><td>25</td><td>备注信息备注信息备注信息备注信息备注信息备注信息备注信息备注信息备注信息备注信息备注信息备注信息</td>
	</tr>
	<tr>
		<td>张小三</td><td>男</td><td>25</td><td>备注信息</td>
	</tr>
	<tr>
		<td>张小三</td><td>男</td><td>25</td><td>备注信息</td>
	</tr>
	<tr>
		<td>张小三</td><td>男</td><td>25</td><td>备注信息</td>
	</tr>
</table>
渲染的列表文字默认是不折行的，需要的话设置fixedCellHeight属性为true
      </fieldset>
      <div class="height_30"></div>
      
      <fieldset>
      	<legend>10、表单布局-表格无样式</legend>
<form>
	<table>
		<tr><td class="ali03">用户名：</td><td><input type="text"/></td></tr>
		<tr><td class="ali03">密码：</td><td><input type="password"/></td></tr>	
		<tr><td class="ali03">民族：</td><td><select><option value="1">汉族</option><option value="2">满族</option><option value="3">维吾尔族</option></select></td></tr>
		<tr><td class="ali03">常用地址：</td><td><textarea></textarea></td></tr>
		<tr><td colspan="2" class="ali02"><input type="submit" value="提交"/>&nbsp;<input type="reset" value="重置"/></td></tr>
	</table>
</form>
手写table元素或在可视化工具创建table后，把表单元素一个个放在td里面。并对td设置对齐等样式，最后放在多功能容器中
      </fieldset>
      <div class="height_30"></div>
      
      <fieldset>
      	<legend>11、表单布局-使用未渲染的tableStyle</legend>
<form>
	<table class="tableStyle">
		<tr><th colspan="2">表单标题</th></tr>
		<tr><td class="ali03">用户名：</td><td><input type="text"/></td></tr>
		<tr><td class="ali03">密码：</td><td><input type="password"/></td></tr>	
		<tr><td class="ali03">民族：</td><td><select><option value="1">汉族</option><option value="2">满族</option><option value="3">维吾尔族</option></select></td></tr>
		<tr><td class="ali03">常用地址：</td><td><textarea></textarea></td></tr>
		<tr><td colspan="2" class="ali02"><input type="submit" value="提交"/>&nbsp;<input type="reset" value="重置"/></td></tr>
	</table>
</form>
大量表单元素或者表单布局较复杂时，建议只设置表格的class="tableStyle"，然后手动为tr设置高度，为td添加class="ali01"或者class="ali02"或者class="ali03"设置对其方式
      </fieldset>
      <div class="height_30"></div>
      
      
       <fieldset>
      	<legend>12、formMode表单布局-line模式</legend>
<form>
	<table class="tableStyle" formMode="line">
		<tr><th colspan="2">表单标题</th></tr>
		<tr><td>用户名：</td><td><input type="text"/></td></tr>
		<tr><td>密码：</td><td><input type="password"/></td></tr>	
		<tr><td>民族：</td><td><select><option value="1">汉族</option><option value="2">满族</option><option value="3">维吾尔族</option></select></td></tr>
		<tr><td>常用地址：</td><td><textarea></textarea></td></tr>
		<tr><td colspan="2"><input type="submit" value="提交"/>&nbsp;<input type="reset" value="重置"/></td></tr>
	</table>
</form>
表单布局模式，表格禁用了变色功能，表头居中，奇数列右对齐、偶数列左对齐，行高度变大。<br/>
line表示表格单元格是1像素细线组成
      </fieldset>
      <div class="height_30"></div>
      
      <fieldset>
      	<legend>13、formMode表单布局-transparent模式</legend>
<form>
	<table class="tableStyle" formMode="transparent">
		<tr><td>用户名：</td><td><input type="text"/></td></tr>
		<tr><td>密码：</td><td><input type="password"/></td></tr>	
		<tr><td>民族：</td><td><select><option value="1">汉族</option><option value="2">满族</option><option value="3">维吾尔族</option></select></td></tr>
		<tr><td>常用地址：</td><td><textarea></textarea></td></tr>
		<tr><td colspan="2"><input type="submit" value="提交"/>&nbsp;<input type="reset" value="重置"/></td></tr>
	</table>
</form>
transparent表示无边框和背景色
      </fieldset>
      <div class="height_30"></div>
      
      <fieldset>
      	<legend>14、formMode表单布局-view模式</legend>
<form>
	<table class="tableStyle" formMode="view">
		<tr><th colspan="4">详细信息</th></tr>
		<tr><td>姓名：</td><td>张小三</td><td>性别：</td><td>男</td</tr>
		<tr><td>曾用名：</td><td>张三</td><td>婚姻情况：</td><td>未婚</td</tr>
		<tr><td>籍贯：</td><td>黑龙江</td><td>民族：</td><td>汉族</td></tr>
		<tr><td>职业：</td><td>软件设计师</td><td>学历：</td><td>本科毕业</td></tr>
		<tr><td>邮编：</td><td>100110</td><td>电话：</td><td>010-00000000</td></tr>
		<tr><td>地址：</td><td>北京市海淀区</td><td>爱好：</td><td>唱歌 跳舞</td></tr>
	</table>
</form>
view模式适合放置详细信息。
另外view模式下，td中的文字过长会自动折行.
      </fieldset>
      <div class="height_30"></div>
   </div>


<script type="text/javascript">
function getRadioRow(){
	var msg="";
	msg=$("#radioTable").find("input[type=radio]").filter("[checked]").val();
	top.Dialog.alert(msg);
}
function getCheckBoxRow(){
	var msg="";
	$("#checkboxTable").find("input[type=checkbox]").each(function(){
		if($(this).attr("checked")){
			msg=msg+","+$(this).val()
		}
	})
	if(msg==""){
		msg="无选择"
	}
	top.Dialog.alert(msg);
}
</script>
</body>
</html>