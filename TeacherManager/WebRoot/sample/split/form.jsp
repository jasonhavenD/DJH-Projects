<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>综合表单</title>

<!--分离模式框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css" id="theme" themeColor="blue"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/" splitMode="true" href="<%=path%>/libs/skins/blue/style.css"/>
<link rel="stylesheet" type="text/css" id="customSkin" href="<%=path%>/system/layout/skin/style.css"/>
<!--分离模式框架必需end-->

<!--引入弹窗组件start-->
<script type="text/javascript" src="<%=path%>/libs/js/popup/drag.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/popup/dialog.js"></script>
<!--引入弹窗组件end-->

<!-- 树组件start -->
<script type="text/javascript" src="<%=path%>/libs/js/tree/ztree/ztree.js"></script>
<link type="text/css" rel="stylesheet" href="<%=path%>/libs/js/tree/ztree/ztree.css"></link>
<!-- 树组件end -->

<!-- 树形下拉框start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/selectTree.js"></script>
<!-- 树形下拉框end -->

<!--自动提示框start-->
<script type='text/javascript' src='<%=path%>/libs/js/form/suggestion.js'></script>
<!--自动提示框end-->

<!-- 日期选择框start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/datePicker/WdatePicker.js"></script>
<!-- 日期选择框end -->

<!-- 双向选择器start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/lister.js"></script>
<!-- 双向选择器end -->

<!-- 树形双选器start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/listerTree.js"></script>
<!-- 树形双选器end -->

<!-- 条件过滤器 start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/filter.js"></script>
<!-- 条件过滤器 end -->

<!-- 颜色选择器start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/color.js"></script>
<!-- 颜色选择器start -->

<!-- 数字步进器start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/stepper.js"></script>
<!-- 数字步进器end -->

<!-- 软键盘控件start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/keypad.js"></script>
<!-- 软键盘控件start -->

<!-- 评星级控件start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/rating.js"></script>
<!-- 评星级控件end -->

<!-- 异步上传控件start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/upload/fileUpload.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/form/upload/handlers.js"></script>
<!--异步上传控件end -->

<!-- 表单验证start -->
<script src="<%=path%>/libs/js/form/validationRule.js" type="text/javascript"></script>
<script src="<%=path%>/libs/js/form/validation.js" type="text/javascript"></script>
<!-- 表单验证end -->

</head>
<body>
<div id="scrollContent">	
	<form id="form1"  failAlert="表单填写不正确，请按要求填写！">
	<table class="tableStyle" formMode="line">
		<tr>
			<th colspan="4">表单填写</th>
		</tr>
		<tr>
			<td width="15%">用户名：</td><td><input type="text" class="validate[required,custom[noSpecialCaracters]]" watermark="请输入英文或数字"/><span class="star">*</span></td>
			<td width="15%">姓名：</td><td><input type="text" class="validate[required,custom[chinese],length[0,20]]" watermark="请输入中文"/><span class="star">*</span></td>
		</tr>
		<tr>	
			<td>密码：</td><td><input type="password" id="pwd" class="validate[required,length[6,11],custom[noSpecialCaracters]]"/><span class="star">*</span> </td>
			<td>密码确认：</td><td><input type="password" class="validate[required,confirm[pwd]]"/><span class="star">*</span></td>
		</tr>
		<tr>
			<td>爱好：</td><td>
			<div id="hobby" style="width:120px;"><input type="checkbox" id="checkbox-1" class="validate[minCheckbox[1]] checkbox" name="ck1" value="选项1"/><label for="checkbox-1" class="hand">唱歌</label>
			<input type="checkbox" id="checkbox-2" class="validate[minCheckbox[1]] checkbox" name="ck1" value="选项2" /><label for="checkbox-2" class="hand">跳舞</label> <span class="star">*</span></div>
			</td>
		    <td>性别：</td>
			<td><div style="width:120px;"><input type="radio" class="validate[required] radio" id="radio-1" name="ra" value="radio-1" /><label for="radio-1" class="hand">男</label>
				<input type="radio" id="radio-2" name="ra" class="validate[required] radio" value="radio-2"/><label for="radio-2" class="hand">女</label> <span class="star">*</span></div>
			</td>
		</tr>
		<tr>
			<td>年龄：</td><td><input type="text" watermark="请输入数字" class="validate[required,custom[onlyNumber],length[0,3]]"/><span class="star">*</span></td>
			<td>电子邮件：</td>
			<td>
				<input type="text" class="validate[required,custom[email]]"/><span class="star">*</span>
				
			</td>
		</tr>
		<tr>
			<td>固定电话：</td><td><input type="text" class=" validate[required,custom[telephone]]"/><span class="star">*</span></td>
			<td>英文名：</td><td><input type="text" class="validate[required,custom[onlyLetter]]"/><span class="star">*</span></td>
		</tr>
		
		<tr>
			<td>手机号码：</td><td><input type="text" class=" validate[required,custom[mobilephone]]"/><span class="star">*</span></td>
			<td>邮政编码：</td><td><input type="text" class=" validate[required,custom[zipcode]]"/><span class="star">*</span></td>
		</tr>
		<tr>
			<td>QQ：</td><td><input type="text" class=" validate[required,custom[qq]]"/><span class="star">*</span></td>
			<td>非法字符：</td>
			<td>
			<input type="text" class=" validate[required,custom[illegalLetter]]"/><span class="star">*</span>
			</td>
		</tr>
		<tr>
			<td>IP地址：</td><td><input type="text" class=" validate[required,custom[ip]]"/><span class="star">*</span></td>
			<td>非负整数：</td><td><input type="text" class=" validate[required,custom[onlyNumber]]"/><span class="star">*</span></td>
		</tr>
		<tr>
			<td>正负小数：</td><td><input type="text" class=" validate[required,custom[onlyDecimal]]"/><span class="star">*</span></td>
			<td>正负整数与小数：</td><td><input type="text" class=" validate[required,custom[onlyNumberWide]]"/><span class="star">*</span></td>
		</tr>
		<tr>
			<td>单选下拉框：</td><td><select class="validate[required]" prompt="请选择"  data='{"list":[{"value":"1","key":"北京"},{"value":"2","key":"黑龙江"}]}'></select><span class="star">*</span></td>
			<td>树形单选下拉框：</td><td><div class="selectTree validate[required]" data='{"treeNodes":[{ "id":"1", "parentId":"0", "name":"部门1", "open": "true"},{ "id":"11", "parentId":"1", "name":"员工1"},{ "id":"12", "parentId":"1", "name":"员工2"},{ "id":"13", "parentId":"1", "name":"员工3"},{ "id":"2", "parentId":"0", "name":"部门2", "open": "true"},{ "id":"21", "parentId":"2", "name":"员工4"}]}'></div><span class="star">*</span>	</td>
		</tr>
		<tr>
			<td>多选下拉框：</td><td><div class="selectTree validate[required]" data='{"treeNodes":[{ "id":"1", "parentId":"0", "name":"员工1"},{ "id":"2", "parentId":"0", "name":"员工2"},{ "id":"3", "parentId":"0", "name":"员工3"},{ "id":"4", "parentId":"0", "name":"员工4"}]}' multiMode="true" noGroup="true"></div><span class="star">*</span>	</td>
			<td>树形多选下拉框：</td><td><div class="selectTree validate[required]" data='{"treeNodes":[{"id":"1","parentId":"0","name":"部门1","nocheck":"true","clickExpand":"true","open":"true"},{"id":"11","parentId":"1", "name":"员工1"},{"id":"12","parentId":"1", "name":"员工2"},{"id":"13","parentId":"1", "name":"员工3"},{"id":"2","parentId":"0","name":"部门2","nocheck":"true","clickExpand":"true","open":"true"},{"id":"21","parentId":"2", "name":"员工4"}]}' multiMode="true"></div><span class="star">*</span>	</td>
		</tr>
		<tr>
			<td>数字步进器：</td><td><input id="step1" type="text" class="stepper validate[required]"/><span class="star">*</span>	</td>
			<td>软键盘控件：</td><td><input class="keypad validate[required]" type="text"/><span class="star">*</span></td>
		</tr>
		<tr>
			<td>自动完成框：</td><td> <div class="suggestion validate[required]" id="suggestion1" keepDefaultStyle="true" showList="true"></div><span class="star">*</span>	</td>
			<td>日期选择框：</td><td><input type="text" class="date validate[required,custom[date]]"/><span class="star">*</span></td>
		</tr>
		<tr>
			<td>条件过滤器：</td>
			<td colspan="3">
			<div class="float_left">
				<div class="filter validate[required]" filterWidth="355" data='{"list":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"},{"value":"3","key":"员工3"},{"value":"4","key":"员工4"}]}'></div>
			</div>
			<div class="float_left padding_top5">
				<span class="star float_left">*</span>	
			</div>
			<div class="clear"></div>		
			</td>
		</tr>
		<tr>
			<td>双向选择器：</td>
			<td colspan="3">
			<div class="float_left">
			 <div class="lister validate[required]" listerWidth="140" listerHeight="120" data='{"fromList":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"},{"value":"3","key":"员工3"},{"value":"4","key":"员工4"}],"toList":[]}'></div>
			</div>
			<div class="float_left" style="padding:90px 0 0 0;">
				<span class="star float_left">*</span>	
			</div>
			<div class="clear"></div>		
			</td>
		</tr>
		<tr>
			<td>树形双选器：</td>
			<td colspan="3">
			<div class="float_left">
			<div class="listerTree validate[required]" listerWidth="140" listerHeight="120"  data='{"toList":[],"fromList":[{"id":"1","parentId":"0","open":"true","name":"部门1","oldParentId":"null","drag":"false"},{"id":"11","parentId":"1","name":"员工1","oldParentId":"1"},{"id":"12","parentId":"1","name":"员工2","oldParentId":"1"},{"id":"2","parentId":"0","open":"true","name":"部门2","oldParentId":"null","drag":"false"},{"id":"21","parentId":"2","name":"员工4","oldParentId":"2"}]}'></div>
			</div>
			<div class="float_left" style="padding:80px 0 0 0;">
				<span class="star float_left">*</span>	
			</div>
			<div class="clear"></div>		
			</td>
		</tr>
		<tr>
			<td>文本域：</td>
			<td colspan="3">
			<div class="float_left">
			<textarea class="validate[required]" style="width:350px;"></textarea>
			</div>
			<div class="float_left" style="padding:40px 0 0 0;">
				<span class="star float_left">*</span>	
			</div>
			<div class="clear"></div>		
			</td>
		</tr>
		<tr>
			<td colspan="4">
				<input type="button" value=" 提 交 "  onclick="validateForm('#form1');"/>
				<input type="button" value=" 重 置 "/>
			</td>
		</tr>
	 </table>
	</form>
</div>	

<script type="text/javascript">
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
	$(function(){
		 $("#suggestion1").data("data",listdata);
		 $("#suggestion1").render();
	})
//手动触发验证，被验证的表单元素是containerId容器里的。 可以验证整个表单，也可以验证部分表单。
	function validateForm(containerId){
	    var valid = $(containerId).validationEngine({returnIsValid: true});
		if(valid == true){
			top.Dialog.alert('进行提交处理');
		}else{
		    top.Dialog.alert('表单填写不正确，请按要求填写！');
		} 
	} 	
</script>
</body>
</html>