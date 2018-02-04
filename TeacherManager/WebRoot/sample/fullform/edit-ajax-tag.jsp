<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>用户信息</title>

<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/" />
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!-- 树组件start -->
<script type="text/javascript" src="<%=path%>/libs/js/tree/ztree/ztree.js"></script>
<link type="text/css" rel="stylesheet" href="<%=path%>/libs/js/tree/ztree/ztree.css"></link>
<!-- 树组件end -->

<!-- 树形下拉框start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/selectTree.js"></script>
<!-- 树形下拉框end -->

<!-- 自动完成框start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/autoComplete.js"></script>
<!-- 自动完成框end -->

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

<!-- 表单异步提交start -->
<script src="<%=path%>/libs/js/form/form.js" type="text/javascript"></script>
<!-- 表单异步提交end -->
</head>
<body>
	<div class="box1" panelWidth="650">
	 <div class="red">此示例由后台支持</div>
	<form id="myFormId" action="<%=path%>/updateWebformAjax.action" method="post" target="frmright">
	<table class="tableStyle"  formMode="transparent">
		<input type="hidden" name="ajax" value="1"/>
		<input type="hidden" name="webForm.id" value="<s:property value="%{webForm.id}"/>" />
		<tr>
			<td width="100">文本框：</td>
			<td><input name="webForm.text" type="text" class="validate[required]" value="<s:property value="%{webForm.text}"/>"/><span class="star">*</span></td>
			<td width="100">自动完成框：</td>
			<td><input type="text" name="webForm.autoComplete" class="autoComplete" url="<%=path%>/form/getItemListByWord.action" value="<s:property value="%{webForm.autoComplete}"/>"/></td>
		</tr>
		<tr>
			<td>单选按钮：</td>
			<td>
				<s:radio list="#{'男':'男','女':'女'}" listKey="key" listValue="value" 
				name="webForm.radio" value="%{webForm.radio}" template="customradiomap.ftl"></s:radio>
			</td>
			<td>多选按钮：</td>
			<td>
				<s:checkboxlist list="#{'唱歌':'唱歌','跳舞':'跳舞'}" listKey="key"
								listValue="value" name="webForm.checkbox" 
								value="%{webForm.checkbox}" template="customcheckboxlist.ftl">
				</s:checkboxlist>
			</td>
		</tr>
		<tr>
			<td>单选下拉框：</td>
			<td>
				<select prompt="请选择" name="webForm.dropSelect" selectedValue="<s:property value="%{webForm.dropSelect}"/>" colNum="3" colWidth="80" class="validate[required]" mode="ajax" url="<%=path%>/form/getUserList.action"></select><span class="star">*</span>
			</td>
			<td>树形下拉框：</td>
			<td>
				<div class="selectTree" name="webForm.dropTree"  selectedValue="<s:property value="%{webForm.dropTree}"/>" url="<%=path%>/getDepartmentsTree.action"></div>
			</td>
		</tr>
		<tr>
			<td>多选下拉框：</td>
			<td>
			<div class="selectTree" name="webForm.mutiSelect"  selectedValue="<s:property value="%{webForm.mutiSelect}"/>" url="<%=path%>/form/getDepartmentList.action" multiMode="true" noGroup="true"></div>
			</td>
			<td>树形多选框：</td>
			<td>
				<div class="selectTree" name="webForm.treeMutiSelect" selectedValue="<s:property value="%{webForm.treeMutiSelect}"/>"  url="<%=path%>/getDepartmentsTree.action" multiMode="true"></div>
			</td>
		</tr>
		<tr>
			<td>日期选择框：</td><td><input type="text" name="webForm.datePicker" class="date" value="<s:property value="%{webForm.datePicker}"/>"/></td>
			<td>颜色选择器：</td>
			<td>
				<input type="text" class="color" name="webForm.colorPicker" value="<s:property value="%{webForm.colorPicker}"/>"/>
			</td>
		</tr>
		<tr>
			<td>软键盘控件：</td>
			<td>
				<input type="text" name="webForm.keypad" class="keypad" value="<s:property value="%{webForm.keypad}"/>"/>
			</td>
			<td>数字步进器：</td>
			<td>
				<input type="text" class="stepper" name="webForm.stepper" value="<s:property value="%{webForm.stepper}"/>"/>
			</td>
		</tr>
		<tr>
			<td>双向选择器：</td>
			<td colspan="3">
				 <div class="lister" name="webForm.bothwaySelect" selectedValue="<s:property value="%{webForm.bothwaySelect}"/>" listerWidth="160" listerHeight="120" url="<%=path%>/form/getUsersOfDoubleSelect.action"></div>
			</td>
		</tr>
		<tr>
			<td>树形双选器：</td>
			<td colspan="3">
				 <div class="listerTree" name="webForm.treeBothwaySelect" listerWidth="160" listerHeight="180" url="<%=path%>/form/getTreeLister.action" selectedValue="<s:property value="%{webForm.treeBothwaySelect}"/>"></div>
			</td>
		</tr>
		<tr>
			<td>条件过滤器：</td>
			<td colspan="3">
				<div class="filter" url="<%=path%>/form/getUserList.action" name="webForm.conditionFilter" selectedValue="<s:property value="%{webForm.conditionFilter}"/>"></div>
			</td>
		</tr>
		<tr>
			<td>评星级控件：</td>
			<td colspan="3">
				<div class="rating" name="webForm.raty" value="<s:property value="%{webForm.raty}"/>"></div>
			</td>
		</tr>
		<tr>
			<td>异步上传控件：</td>
			<td colspan="3">
			    <input type="hidden" name="webForm.asynFile" id="hdn_file"/>
				<span id="uploadBtn"></span>
				<div id="uploadList"></div>
				<div id="uploadDeleteAll" style="display:none;"></div>
			</td>
		</tr>
		<tr>
			<td>文本域：</td>
			<td colspan="3">
				<textarea name="webForm.textarea"><s:property value="%{webForm.textarea}"/></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="4">
				<input type="submit" value=" 提 交 "/>
				<input type="button" value=" 重 置 " onclick="formReset()"/>
			</td>
		</tr>
	</table>
	</form>
	</div>
	

<script type="text/javascript">
    var upload;
    var catalogId = "<s:property value="%{webForm.asynFile}"/>";
    function initComplete(){
		//上传组件初始化
		$("#hdn_file").val(catalogId);
		upload = $.fileUpload.start({
			contextPath: "<%=path%>",
			buttonContainer: "uploadBtn",
			fileListContainer: "uploadList",
			deleteContainer: "uploadDeleteAll",
			moduleId : 'dcm',
			kind : 'template',
			catalogId: catalogId,
			uploadUrl:"/form/upLoadFile.action",
			deleteUrl:"/form/deleteFile?id=",
			deleteAllUrl:"/form/deleteByKind.action",
			listUrl:"/form/listByKind.action",
			fileNameWidth:240,
			editMode:true
		});
		
		 //表单异步提交处理
        $('#myFormId').submit(function(){ 
        	//判断表单的客户端验证时候通过
			var valid = $('#myFormId').validationEngine({returnIsValid: true});
			if(valid){
			   $(this).ajaxSubmit({
			        //表单提交成功后的回调
			        success: function(responseText, statusText, xhr, $form){
			            top.Dialog.alert("保存成功",function(){
			            	window.location.reload();
			            });
			        }
			    }); 
			 }
		    
		    //阻止表单默认提交事件
		    return false; 
		});
		
		$("input:submit").click(function(){
     		var checkbox = "";
     		$("input:checkbox:checked").each(function(){
     			checkbox += $(this).attr("value") + ",";
     		})
     		$("input[name='webForm.checkbox']").attr("value",checkbox);
     	})
    }

	
	//重置处理
	function formReset(){
		//重置表单元素
		$("#myFormId")[0].reset();
		
		//单独处理特殊组件的重置
		 $("#myFormId select").resetValue(); 
		 $("#myFormId .selectTree").resetValue(); 
		 $("#myFormId .lister").resetValue(); 
		 $("#myFormId .listerTree").resetValue(); 
		 $("#myFormId .filter").resetValue(); 
	}
</script>
</body>
</html>