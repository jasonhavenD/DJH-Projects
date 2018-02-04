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
	1、手写table元素或在可视化工具创建table后，把表单元素一个个放在td里面。并对td设置对齐等样式，最后放在多功能容器中。如：
<div class="box1" panelWidth="500">
<form>
	<table class="formTable">
		<tr><td class="ali03">用户名：</td><td><input type="text"/></td></tr>
		<tr><td class="ali03">密码：</td><td><input type="password"/></td></tr>	
		<tr><td class="ali03">民族：</td><td><select><option value="1">汉族</option><option value="2">满族</option><option value="3">维吾尔族</option></select></td></tr>
		<tr><td class="ali03">常用地址：</td><td><textarea></textarea></td></tr>
		<tr><td colspan="2" class="ali02"><input type="submit" value="提交"/>&nbsp;<input type="reset" value="重置"/></td></tr>
	</table>
</form>
</div>
<br/>
2、使用容器2的效果：
<div class="box2" panelWidth="500" panelTitle="表单布局示例">
<form class="formTable">
	<table>
		<tr><td class="ali03">用户名：</td><td><input type="text"/></td></tr>
		<tr><td class="ali03">密码：</td><td><input type="password"/></td></tr>	
		<tr><td class="ali03">民族：</td><td><select><option value="1">汉族</option><option value="2">满族</option><option value="3">维吾尔族</option></select></td></tr>
		<tr><td class="ali03">常用地址：</td><td><textarea></textarea></td></tr>
		<tr><td colspan="2" class="ali02"><input type="submit" value="提交"/>&nbsp;<input type="reset" value="重置"/></td></tr>
	</table>
</form>
</div>
<br/>
3、表单禁用：使用mask方法
<div class="box1" panelWidth="500">
<form id="form1">
	<table class="formTable">
		<tr><td class="ali03">用户名：</td><td><input type="text"/></td></tr>
		<tr><td class="ali03">密码：</td><td><input type="password"/></td></tr>	
		<tr><td class="ali03">民族：</td><td><select><option value="1">汉族</option><option value="2">满族</option><option value="3">维吾尔族</option></select></td></tr>
		<tr><td class="ali03">常用地址：</td><td><textarea></textarea></td></tr>
		<tr><td colspan="2" class="ali02"><input type="button" value="提交"/>&nbsp;<input type="reset" value="重置"/></td></tr>
	</table>
</form>
</div>
<input type="button" value="启用" onclick="enableForm()" style="width:105px;"/>
<input type="button" value="禁用" onclick="disableForm()" style="width:105px;"/>
<br/><br/><br/>
框架集成了三种默认的table布局方式，用于传统的表单布局。这样就不需要每个td都设置样式了。<br/>
4、formMode模式为line：<br/>
<div class="box1" panelWidth="500">
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
</div>

5、formMode模式为transparent：<br/>
<div class="box2" panelWidth="500" panelTitle="表单标题">
<form>
	<table class="tableStyle" formMode="transparent">
		<tr><td>用户名：</td><td><input type="text"/></td></tr>
		<tr><td>密码：</td><td><input type="password"/></td></tr>	
		<tr><td>民族：</td><td><select><option value="1">汉族</option><option value="2">满族</option><option value="3">维吾尔族</option></select></td></tr>
		<tr><td>常用地址：</td><td><textarea></textarea></td></tr>
		<tr><td colspan="2"><input type="submit" value="提交"/>&nbsp;<input type="reset" value="重置"/></td></tr>
	</table>
</form>
</div>

6、formMode模式为view，适合放置详细信息：<br/>
<div class="box1" panelWidth="500">
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
</div>
<br/><br/>

6、双列布局<br/>
<div class="box2" panelWidth="650" panelTitle="formMode用于双列布局">
<form>
	<table class="tableStyle" formMode="transparent">
		<tr><td>姓名：</td><td><input type="text"/></td><td>曾用名：</td><td><input type="text"/></td></tr>
		<tr><td>密码：</td><td><input type="password"/></td><td>邮编：</td><td><input type="text"/></td></tr>	
		<tr>
			<td>民族：</td><td><select><option value="1">汉族</option><option value="2">满族</option><option value="3">维吾尔族</option></select></td>
			<td>籍贯：</td><td><select><option value="1">北京</option><option value="2">天津</option><option value="3">黑龙江</option></select></td>
		</tr>
		<tr><td>常用地址：</td><td colspan="3"><textarea style="width:400px;"></textarea></td></tr>
		<tr><td colspan="4"><input type="submit" value="提交"/>&nbsp;<input type="reset" value="重置"/></td></tr>
	</table>
</form>
</div>
<br/><br/>
7、使用fieldset和表格的formMode来布局表单<br/>
<div class="box1" panelWidth="650">
	<fieldset> 
		<legend>用户基本信息</legend> 
		<table class="tableStyle" formMode="transparent" footer="normal">
			<tr>
				<td width="15%">姓名：</td><td width="35%"><input type="text"/></td>
				<td width="15%">性别：</td>
				<td><input type="radio" id="radio-1" name="ra" value="radio-1" class="hand"/><label for="radio-1" class="hand">男</label>
					<input type="radio" id="radio-2" name="ra" value="radio-2" class="hand"/><label for="radio-2" class="hand">女</label>
				</td>
			</tr>
			<tr>
				<td>曾用名：</td>
				<td><input type="text"/></td>
				<td>婚姻：</td>
				<td><input type="radio" id="radio-3" name="ra2" value="radio-3" class="hand"/><label for="radio-3" class="hand">已婚</label>
					<input type="radio" id="radio-4" name="ra2" value="radio-4" class="hand"/><label for="radio-4" class="hand">未婚</label>
				</td>
			</tr>
		</table>
	</fieldset> 
	<div class="height_15"></div>
	<fieldset> 
		<legend>用户详细信息</legend> 
		<table class="tableStyle" formMode="transparent" footer="normal">
			<tr>
				<td width="15%">籍贯：</td>
				<td width="35%">
					<select><option>北京市</option><option>天津市</option><option>黑龙江省</option></select>
				</td>
				<td width="15%">民族：</td>
				<td>
					<select><option value="1">汉族</option><option value="2">满族</option><option value="3">维吾尔族</option></select>
				</td>
			</tr>
			<tr>
				<td>学历：</td>
				<td>
				<select><option>博士</option><option>本科</option><option>大专</option><option>其它</option></select>				
				</td>
				<td>权限：</td>
				<td>
				<select><option value="1">新增图片</option><option value="2">维护图片</option><option value="3">新增新闻</option></select>
				</td>
			</tr>
		</table>
	</fieldset> 
	<div class="height_15"></div>
	<fieldset> 
		<legend>用户其他信息</legend> 
		<table class="tableStyle" formMode="transparent" footer="normal">
			<tr>
				<td width="15%">邮政编码：</td><td width="35%"><input type="text"/></td>
				<td width="15%">上传附件：</td><td><input type="file"/></td>
			</tr>
			<tr>
				<td>固定电话：</td><td><input type="text"/></td>
				
				<td>上传文档：</td><td><input type="file"/></td>
			</tr>
			<tr>
				<td>备注：</td>
				<td colspan="3">
					<textarea style="width:400px;"></textarea>
				</td>
			</tr>
		</table>
	</fieldset>
	<div class="height_5"></div>
	<div class="padding_top10">
		<table class="tableStyle" formMode="transparent">
			<tr>
				<td colspan="4">
					<input type="submit" value="提交"/>
					<input type="reset" value="重置"/>
				</td>
			</tr>
		</table>
	</div> 
	</div>
<br/><br/>
8、使用groupTitle来布局表单<br/>
<div class="box1" panelWidth="650">
<div class="groupTitle"><span>用户基本信息</span></div>
	<table class="tableStyle" formMode="transparent" footer="normal">
		<tr>
			<td width="15%">姓名：</td><td width="35%"><input type="text"/></td>
			<td width="15%">性别：</td>
			<td><input type="radio" id="radio-1" name="ra" value="radio-1" class="hand"/><label for="radio-1" class="hand">男</label>
				<input type="radio" id="radio-2" name="ra" value="radio-2" class="hand"/><label for="radio-2" class="hand">女</label>
			</td>
		</tr>
		<tr>
			<td>曾用名：</td>
			<td><input type="text"/></td>
			<td>婚姻：</td>
			<td><input type="radio" id="radio-3" name="ra2" value="radio-3" class="hand"/><label for="radio-3" class="hand">已婚</label>
				<input type="radio" id="radio-4" name="ra2" value="radio-4" class="hand"/><label for="radio-4" class="hand">未婚</label>
			</td>
		</tr>
	</table>
<div class="height_15"></div>
<div class="groupTitle"><span>用户详细信息</span></div>
	<table class="tableStyle" formMode="transparent" footer="normal">
		<tr>
			<td width="15%">籍贯：</td>
			<td width="35%">
				<select><option>北京市</option><option>天津市</option><option>黑龙江省</option></select>
			</td>
			<td width="15%">民族：</td>
			<td>
				<select><option value="1">汉族</option><option value="2">满族</option><option value="3">维吾尔族</option></select>
			</td>
		</tr>
		<tr>
			<td>学历：</td>
			<td>
			<select><option>博士</option><option>本科</option><option>大专</option><option>其它</option></select>				
			</td>
			<td>权限：</td>
			<td>
			<select><option value="1">新增图片</option><option value="2">维护图片</option><option value="3">新增新闻</option></select>
			</td>
		</tr>
	</table>
<div class="height_15"></div>
	<div class="groupTitle"><span>用户其他信息</span></div>
	<table class="tableStyle" formMode="transparent" footer="normal">
		<tr>
			<td width="15%">邮政编码：</td><td width="35%"><input type="text"/></td>
			<td width="15%">上传附件：</td><td><input type="file"/></td>
		</tr>
		<tr>
			<td>固定电话：</td><td><input type="text"/></td>
			
			<td>上传文档：</td><td><input type="file"/></td>
		</tr>
		<tr>
			<td>备注：</td>
			<td colspan="3">
				<textarea style="width:400px;"></textarea>
			</td>
		</tr>
	</table>
<div class="height_5"></div>
<div class="padding_top10">
	<table class="tableStyle" formMode="transparent">
		<tr>
			<td colspan="4">
				<input type="submit" value="提交"/>
				<input type="reset" value="重置"/>
			</td>
		</tr>
	</table>
</div> 
</div>

<script>
function initComplete(){
	 //设为不可用
	$("#form1").mask("当前不可用",500,false,"#ffffff");
}
 //设为不可用
function disableForm(){
	$("#form1").mask("当前不可用",0,false,"#ffffff");
}
//设为可用
function enableForm(){
    $("#form1").unmask();
}
</script>
</body>
</html>