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
<body>
<div class="box2" panelTitle="新增">
	<table class="tableStyle" formMode="transparent">
		<tr>
			<td>属性1:</td>
			<td><input type="text" id="input1"/></td>
			<td>属性2：</td>
			<td><input type="text" id="input2"/></td>
			<td>属性3:</td>
			<td><input type="text" id="input3"/></td>
			<td>属性4：</td>
			<td><input type="text" id="input4"/></td>
		</tr>
		<tr>
			<td colspan="8">
				<input type="submit" value=" 添 加 " onclick="addHandler()"/>
				<input type="reset" value=" 重 置 "/>
			</td>
		</tr>
	</table>
</div>	
<table class="tableStyle" useClick="false" mode="list" id="list">
		<tr>
			<th width="10%">属性1</th>
			<th width="10%">属性2</th>
			<th>属性3</th>
			<th width="10%">属性4</th>
			<th width="15%">排序</th>
			<th width="25%">操作</th>
		</tr>
		<tr>
			<td>11111</td>
			<td>男</td>
			<td>天津市和平区aaa</td>
			<td>已婚</td>
			<td><span class="img_btn_up hand" title="向上一行"></span></td>
			<td><span class="img_edit hand" title="修改"></span> <span class="img_delete hand"  title="删除"></span></td>
		</tr>
		<tr>
			<td>22222</td>
			<td>女</td>
			<td>天津市和平区bbbb</td>
			<td>未婚</td>
			<td><span class="img_btn_up hand" title="向上一行"></span></td>
			<td><span class="img_edit hand" title="修改"></span> <span class="img_delete hand"  title="删除"></span></td>
		</tr>
		<tr>
			<td>33333</td>
			<td>男</td>
			<td>天津市和平区ccccc</td>
			<td>未婚</td>
			<td><span class="img_btn_up hand" title="向上一行"></span></td>
			<td><span class="img_edit hand" title="修改"></span> <span class="img_delete hand"  title="删除"></span></td>
		</tr>
		<tr>
			<td>444444</td>
			<td>女</td>
			<td>天津市和平区dddddd</td>
			<td>已婚</td>
			<td><span class="img_btn_up hand" title="向上一行"></span></td>
			<td><span class="img_edit hand" title="修改"></span> <span class="img_delete hand"  title="删除"></span></td>
		</tr>
	</table>	
	<br/>
	<br/>
	<br/>
	<input type="button" value="创建新表格(列表)" onclick="addNewTable()" id="testBtn"/>
	<br/>
	<br/>
	<br/>
	<input type="button" value="创建新表格(表单布局)" onclick="addNewTable2()" id="testBtn2"/>
	<br/>
	<br/>
	<br/>
这里展示了表格的动态新增、修改、删除、排序操作。
<script>
	var tdText0;
	var tdText1;
	var tdText2;
	var tdText3;
	var $currentTr;
	$(function(){
		$(".img_btn_up").click(function(){
			upHandler($(this))
		})
		$(".img_delete").click(function(){
			delHandler($(this))
		})
		$(".img_edit").click(function(){
			modiHandler($(this))
		})
	})
	//删除行
	function delHandler($obj){
		$currentTr=$obj.parents("tr");
		top.Dialog.confirm("确定要删除吗？",function(){
			$currentTr.remove();
		});
	}
	//向上移动行
	function upHandler($obj){
		var val1=$obj.parents("tr").find("td").eq(0).html();
		var val2=$obj.parents("tr").find("td").eq(1).html();
		var val3=$obj.parents("tr").find("td").eq(2).html();
		var val4=$obj.parents("tr").find("td").eq(3).html();
		$currentTr=$obj.parents("tr");
		var idx=$("#list tr").index($currentTr);
		if(idx==1){
			return;
		}
		$currentTr.remove();
		var $tr=addNewRowHandler(val1,val2,val3,val4)
		$("#list tr").eq(idx-1).before($tr);
		hideTooltip()
		enableTooltips()
	}
	//弹出修改窗口
	function modiHandler($obj){
		top.Dialog.open({URL:"<%=path%>/sample/table/dynamic-content1.jsp",Title:"修改 ",Width:500,Height:240});
		tdText0=$obj.parents("tr").find("td").eq(0).html();
		tdText1=$obj.parents("tr").find("td").eq(1).html();
		tdText2=$obj.parents("tr").find("td").eq(2).html();
		tdText3=$obj.parents("tr").find("td").eq(3).html();
		$currentTr=$obj.parents("tr");
	}
	//修改赋值
	function refreshRow(val0,val1,val2,val3){
		$currentTr.find("td").eq(0).html(val0);
		$currentTr.find("td").eq(1).html(val1);
		$currentTr.find("td").eq(2).html(val2);
		$currentTr.find("td").eq(3).html(val3);
	}
	
	//添加行
	function addHandler(){
		var val1=$("#input1").val();
		var val2=$("#input2").val();
		var val3=$("#input3").val();
		var val4=$("#input4").val();
		var $tr=addNewRowHandler(val1,val2,val3,val4)
		$("#list").append($tr); 
		//重新渲染表格
		$("#list").render();
	}
	
	//添加行处理
	function addNewRowHandler(val1,val2,val3,val4){
		var $tr=$("<tr><td>"+val1+"</td><td>"+val2+"</td><td>"+val3+"</td><td>"+val4+"</td><td><span class='img_btn_up hand' title='向上一行'></span></td><td><span class='img_edit hand' title='修改'></span> <span class='img_delete hand' title='删除'></span></td></tr>");
		var $modiBtn=$tr.find(".img_edit");
		var $delBtn=$tr.find(".img_delete");
		var $upBtn=$tr.find(".img_btn_up");
		$delBtn.click(function(){
			delHandler($(this))
		})
		$upBtn.click(function(){
			upHandler($(this))
		})
		$modiBtn.click(function(){
			modiHandler($(this))
		})
		enableTooltips()
		return $tr;
	}
	
	//创建新表格
	function addNewTable(){
		var $table=$("<table class='tableStyle' mode='list'><tr><th width='30'></th><th>姓名</th><th>性别</th><th>年龄</th></tr><tr><td><input type='checkbox'/></td><td>张小四</td><td>女</td><td>24</td></tr><tr><td><input type='checkbox'/></td><td>张小四</td><td>女</td><td>24</td></tr></table>");
		$("#testBtn").after($table); 
		$table.render();
	}
	
	function addNewTable2(){
		var $table=$('<table class="tableStyle" formMode="line" style="width:500px;">'+
		'<tr><th colspan="2">使用formMode</th></tr>'+
		'<tr><td>用户名：</td><td><input type="text" id="inputa1"/></td></tr>'+
		'<tr><td>密码：</td><td><input type="password" id="inputa2"/></td></tr>	'+
		'<tr><td>常用地址：</td><td><textarea id="inputa3"></textarea></td></tr>'+
		'<tr><td colspan="2"><input type="submit" value="提交" id="inputa4"/>&nbsp;<input type="reset" value="重置" id="inputa5"/></td></tr>'+
	'</table>')
		$("#testBtn2").after($table); 
		$table.render();
		$("#inputa1").render();
		$("#inputa2").render();
		$("#inputa3").render();
		$("#inputa4").render();
		$("#inputa5").render();
	}
</script>
</body>
</html>