<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>表单验证</title>

<!-- 框架必需start -->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!-- 框架必需end -->

<!-- 树组件start -->
<script type="text/javascript" src="<%=path%>/libs/js/tree/ztree/ztree.js"></script>
<link type="text/css" rel="stylesheet" href="<%=path%>/libs/js/tree/ztree/ztree.css"></link>
<!-- 树组件end -->

<!-- 树形下拉框start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/selectTree.js"></script>
<!-- 树形下拉框end -->

<!-- 日期控件start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/datePicker/WdatePicker.js"></script>
<!-- 日期控件end -->

<!-- 条件过滤器 start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/filter.js"></script>
<!-- 条件过滤器 end -->

<!-- 数字步进器start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/stepper.js"></script>
<!-- 数字步进器end -->

<!-- 软键盘控件start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/keypad.js"></script>
<!-- 软键盘控件end -->

<!-- 双向选择器start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/lister.js"></script>
<!-- 双向选择器end -->

<!--自动提示框start-->
<script type='text/javascript' src='<%=path%>/libs/js/form/suggestion.js'></script>
<!--自动提示框end-->

<!-- 树形双选器start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/listerTree.js"></script>
<!-- 树形双选器end -->

<!-- 组合下拉框start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/selectCustom.js"></script>
<!-- 组合拉框end -->

<!-- 表单验证start -->
<script src="<%=path%>/libs/js/form/validationRule.js" type="text/javascript"></script>
<script src="<%=path%>/libs/js/form/validation.js" type="text/javascript"></script>
<!-- 表单验证end -->


</head>
<body>
 <div class="box1">
    <fieldset>
      <legend>1、基本使用</legend>
   <form id="form1" method="post" action="" failAlert="表单填写不正确，请按要求填写！">
	  <table class="tableStyle" formMode="line" style="width:1060px;">
		<tr>
			<th colspan="4">表单填写</th>
		</tr>
		<tr>
			<td width="150">用户名：</td><td width="300"><input type="text" class="validate[required,custom[noSpecialCaracters]]" watermark="请输入英文或数字"/><span class="star">*</span></td>
			<td width="150">姓名：</td><td width="300"><input type="text" class="validate[required,custom[chinese],length[0,20]]"/><span class="star">*</span></td>
		</tr>
		<tr>	
			<td>密码：</td><td><input type="password" id="pwd" class="validate[required,length[6,11],custom[noSpecialCaracters]]"/><span class="star">*</span> </td>
			<td>密码确认：</td><td><input type="password" class="validate[required,confirm[pwd]]"/><span class="star">*</span></td>
		</tr>
		<tr>
			<td>爱好：</td><td>
			<div id="hobby" style="width:135px;" class="checkboxRender"><input type="checkbox" id="checkbox-1" class="validate[minCheckbox[1]] checkbox" name="ck1" value="选项1"/><label for="checkbox-1" class="hand">唱歌</label>
			<input type="checkbox" id="checkbox-2" class="validate[minCheckbox[1]] checkbox" name="ck1" value="选项2" /><label for="checkbox-2" class="hand">跳舞</label> <span class="star">*</span></div>
			</td>
		    <td>性别：</td>
			<td><div style="width:135px;" class="checkboxRender"><input type="radio" class="validate[required] radio" id="radio-1" name="ra" value="radio-1" /><label for="radio-1" class="hand">男</label>
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
			<td>自动提示框：</td><td> <div class="suggestion validate[required]" id="suggestion1" keepDefaultStyle="true" showList="true"></div><span class="star">*</span>	</td>
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
			<td>组合下拉框：</td>
			<td colspan="3">
			<div class="selectCustom validate[required]" boxWidth="380" prompt="请选择一种格式" id="selectCostom5">
			<div id="customContent5" style="font-size:12px;padding:0 0 10px 10px;">
				<div class="navIconSmall" id="MP3">
					<img src="<%=path%>/libs/icons/png/16.png"/><br />
					MP3格式
				</div>
				<div class="navIconSmall" id="WMA">
					<img src="<%=path%>/libs/icons/png/21.png"/><br />
					WMA格式
				</div>
				<div class="navIconSmall" id="AVI">
					<img src="<%=path%>/libs/icons/png/25.png"/><br />
					AVI格式
				</div>
				<div class="navIconSmall" id="WAVE">
					<img src="<%=path%>/libs/icons/png/24.png"/><br />
					WAVE格式
				</div>
				<div class="navIconSmall" id="MIDI">
					<img src="<%=path%>/libs/icons/png/30.png"/><br />
					MIDI格式
				</div>
				<div class="navIconSmall" id="MPEG">
					<img src="<%=path%>/libs/icons/png/29.png"/><br />
					MPEG格式
				</div>
				<div class="navIconSmall" id="TIF">
					<img src="<%=path%>/libs/icons/png/22.png"/><br />
					TIF格式
				</div>
				<div class="navIconSmall" id="PNG">
					<img src="<%=path%>/libs/icons/png/23.png"/><br />
					PNG格式
				</div>
				<div class="navIconSmall" id="JPEG">
					<img src="<%=path%>/libs/icons/png/33.png"/><br />
					JPEG格式
				</div>
				<div class="navIconSmall" id="TGA">
					<img src="<%=path%>/libs/icons/png/15.png" width="60" height="60"/><br />
					TGA格式
				</div>
				<div class="navIconSmall" id="GIF">
					<img src="<%=path%>/libs/icons/png/33.png"/><br />
					GIF格式
				</div>
				<div class="navIconSmall" id="BMP">
					<img src="<%=path%>/libs/icons/png/37.png"/><br />
					BMP格式
				</div>
				<div class="clear"></div>			
			</div>
		</div>
				<span class="star">*</span>	
			</td>
			<tr>
			<td>同步上传控件：</td>
			<td colspan="3">
			<div class="float_left">
			<input type="file"   showInfo="false"  class="validate[required,custom[onlyImage]]"/>
			</div>
			<div class="float_left" style="padding:5px 0 0 0;">
				<span class="star float_left">*</span>	(可验证文件格式)
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
 </fieldset>
  <div class="height_15"></div>
  
  <fieldset>
      <legend>2、手动触发验证</legend>
      <p>点击按钮后，对上面的表单手动触发一次验证。</p>
      <input type="button" value="点击验证“爱好”复选框" onclick="validateForm('#hobby');"/>
      <input type="button" value="点击验证上面的表单" onclick="validateForm('#form1');"/>
      <p>
      手动验证多用于异步提交表单的情况。在提交表单前手动验证，如果验证通过再调用函数进行表单的异步提交。详见：表单异步提交内容
      </p>
  </fieldset>
  <div class="height_15"></div>
  
   <fieldset>
      <legend>3、ajax验证</legend>
        <div class="red">此示例由后台支持</div>
        可输入已存在用户名进行测试，例如：guest、an、kong、yang等<br/>
       <form id="form3" method="post" action="" failAlert="验证未通过！">
       		<table style="width:400px;" class="tableStyle" formMode="transparent">
       		<tr>
				<td width="100">用户名：</td><td><input type="text" class="validate[required,custom[noSpecialCaracters],ajax[<%=path%>/validateUserName.action|* 用户名已存在!]]"/><span class="star">*</span></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" onclick="ajaxHander()" value="提交"/></td></td>
			</tr>
       		 </table>
       </form>
  </fieldset>
  <div class="height_15"></div>
  
  <fieldset>
      <legend>4、为动态创建的表单添加验证</legend>
      <input type="button" value="创建新表单" onclick="addNewForm()" id="testBtn"/>
  </fieldset>
  <div class="height_15"></div>
  
  <fieldset>
      <legend>5、为元素动态添加并触发验证</legend>
      此例为复选框选中后，电子邮件必填；不选中则为非必填项。<br/>
      <form id="form4" method="post" action="" failAlert="请将表单填写完整！">
		<table class="tableStyle" formMode="line" style="width:800px;">
			<tr>
				<th colspan="2">表单填写</th>
			</tr>
			<tr>
				<td width="200">用户名：</td>
				<td><input type="text" class="validate[required,custom[noSpecialCaracters]]"/><span class="star">*</span></td>
			</tr>
			<tr>
				<td>是否愿意留下邮箱：</td><td><input type="checkbox" id="myCheck" onclick="emailChange();"/></td>
			</tr>
			<tr>
				<td>电子邮件：</td><td id="emailContainer"><input type="text" id="emailInput" class="validate[custom[email]]"/><span id="emailTip" class="star"></span></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value=" 提 交 "/>
					<input type="reset" value=" 重 置 "/>
				</td>
			</tr>
		</table>
	</form>	
  </fieldset>
   <div class="height_15"></div>
   
   <fieldset>
      <legend>6、设置不允许输入的内容</legend>
     此例中，不允许输入admin<br/>
      <form id="form4" method="post" action="" >
		<table class="tableStyle" formMode="line" style="width:800px;">
			<tr>
				<th colspan="2">表单填写</th>
			</tr>
			<tr>
				<td width="200">用户名：</td>
				<td><input type="text" class="validate[required,exemptString[admin|不允许输入admin]]"/><span class="star">*</span></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value=" 提 交 "/>
					<input type="reset" value=" 重 置 "/>
				</td>
			</tr>
		</table>
	</form>	
	可对一个文本框可同时设置多个不允许输入的内容。
  </fieldset>
   <div class="height_15"></div>
   
   <fieldset>
      <legend>7、页面添加验证函数</legend>
     此例中，不允许输入小于50的数字<br/>
      <form id="form4" method="post" action="" >
		<table class="tableStyle" formMode="line" style="width:800px;">
			<tr>
				<th colspan="2">表单填写</th>
			</tr>
			<tr>
				<td width="200">金额：</td>
				<td><input type="text" class="validate[required,custom[onlyNumber],functionCall[func1|* 金额不能小于50]]" id="input1"/><span class="star">*</span></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value=" 提 交 "/>
					<input type="reset" value=" 重 置 "/>
				</td>
			</tr>
		</table>
	</form>	
	此方式有两个特点：<br/>
	1、在页面中添加规则函数，这样可以在不改变规则文件validationRule.js的前提下添加个性化的验证。<br/>
	2、可以不用正则表达式，而是通过一些规则计算来判断是否符合要求。不符合规则的话让该函数返回true即可。<br/>
  </fieldset>
  
 
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
		 
		 $(".navIconSmall").each(function(){
            	$(this).hover(function(){
					$(this).addClass("navIconSmall_hover");
				},function(){
					$(this).removeClass("navIconSmall_hover");
				})
				$(this).click(function(){
					$(".navIconSmall").removeClass("navIconSmall_current");
	            	$(this).addClass("navIconSmall_current");
	            	$("#selectCostom5").setValue($(this).attr("id"),$(this).text().trim());
				})
            })
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
	
	function addNewForm(){
		var $table=$(' <form id="form2" method="post" action="" failAlert="表单填写不正确，请按要求填写！">'+
		'<table class="tableStyle" formMode="line" style="width:500px;">'+
		'<tr><th colspan="2">动态添加验证功能</th></tr>'+
		'<tr><td>用户名：</td><td><input type="text" id="inputa1" class="validate[required,custom[noSpecialCaracters]]" /><span class="star">*</span></td></tr>'+
		'<tr><td>密码：</td><td><input type="password" id="inputa2" class="validate[required,length[6,11],custom[noSpecialCaracters]]"/><span class="star">*</span></td></tr>	'+
		'<tr><td>籍贯：</td><td><select id="inputa3" class="validate[required]" prompt="请选择"></select><span class="star">*</span></td></tr>'+
		'<tr><td colspan="2"><input type="submit" value="提交" id="inputa4"/>&nbsp;<input type="reset" value="重置" id="inputa5"/></td></tr>'+
	'</table></form>')
		$("#testBtn").after($table); 
		$table.find("table").render();
		$table.find("#inputa1").render();
		$table.find("#inputa2").render();
		$table.find("#inputa3").data("data",{"list":[{"value":"1","key":"北京"},{"value":"2","key":"黑龙江"}]});
		$table.find("#inputa3").render();
		$table.find("#inputa4").render();
		$table.find("#inputa5").render();
		
		$table.validationEngine();
	}
	
	//"是否愿意留下邮箱"值变化
	function emailChange(){
	    var checked = $('#myCheck').attr('checked');
	    if(checked){
	        $("#emailInput").addClass("validate[required]");
	        $("#emailTip").html("*");
	    }else{
	        $("#emailInput").removeClass("validate[required]");
	        $("#emailTip").html("");
	    }
	    //调用校验方法，使文本框显示的样式及提示正确
	    $("#emailContainer").validationEngine({returnIsValid: true});
	}
	
	function ajaxHander(){
		var valid = $("#form3").validationEngine({returnIsValid: true});
		if(valid){
			top.Dialog.alert("验证通过，此处是提交表单的处理!");
		}
	}
	
	function func1(){
		if(Number($("#input1").val())<50){
		return true;
		}
		return false;
	}

</script>

</body>
</html>