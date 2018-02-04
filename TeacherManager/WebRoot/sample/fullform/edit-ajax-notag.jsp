<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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

<!-- 表单异步提交与非标签赋值start -->
<script src="<%=path%>/libs/js/form/form.js" type="text/javascript"></script>
<!-- 表单异步提交与非标签赋值end -->
</head>
<body>
<div class="box1" panelWidth="650">
	 <div class="red">此示例由后台支持</div>
	<form id="myFormId" action="<%=path%>/updateWebformAjax.action" method="post" target="frmright" failAlert="表单填写不正确，请按要求填写！">
	<input type="hidden" name="webForm.id" value="" />
	<table class="tableStyle" formMode="transparent">
		<tr>
			<td width="100">文本框：</td><td><input name="webForm.text" type="text"  class="validate[required]" fillType="textinput"/><span class="star">*</span></td>
			<td>自动完成框：</td><td><input type="text" name="webForm.autoComplete" class="autoComplete" url="<%=path%>/form/getItemListByWord.action" fillType="autoComplete"/></td>
		</tr>
		<tr>
			<td width="100">单选按钮：</td>
			<td><input type="radio" id="radio-1" name="webForm.radio" value="男"  fillType="radio"/><label for="radio-1" class="hand">男</label>
				<input type="radio" id="radio-2" name="webForm.radio" value="女" fillType="radio"/><label for="radio-2" class="hand">女</label>
			</td>
			<td>多选按钮：</td>
			<td><input type="checkbox" id="checkbox-1" name="webForm.checkbox" value="唱歌" fillType="checkbox"/><label for="checkbox-1" class="hand">唱歌</label>
				<input type="checkbox" id="checkbox-2" name="webForm.checkbox" value="跳舞" fillType="checkbox" /><label for="checkbox-2" class="hand">跳舞</label>
			</td>
		</tr>
		<tr>
			<td>单选下拉框：</td>
			<td>
				<select prompt="请选择" name="webForm.dropSelect" colNum="3" colWidth="80" class="validate[required]" url="<%=path%>/form/getUserList.action" fillType="select"></select><span class="star">*</span>
			</td>
			<td>树形下拉框：</td>
			<td>
				<div class="selectTree" name="webForm.dropTree"  url="<%=path%>/getDepartmentsTree.action" fillType="selectTree"></div>
			</td>
			
		</tr>
		<tr>
			<td>多选下拉框：</td>
			<td>
			<div class="selectTree" name="webForm.mutiSelect" url="<%=path%>/form/getDepartmentList.action" multiMode="true" noGroup="true" fillType="selectTree"></div>
			</td>
			<td>树形多选框：</td>
			<td>
				<div class="selectTree" name="webForm.treeMutiSelect"  url="<%=path%>/getDepartmentsTree.action" multiMode="true" fillType="selectTree"></div>
			</td>
			
		</tr>
		
		<tr>
			<td>日期选择框：</td><td><input type="text" name="webForm.datePicker" class="date" fillType="date"/></td>
			<td>颜色选择器：</td>
			<td>
				<input type="text" class="color" name="webForm.colorPicker" fillType="color"/>
			</td>
		</tr>
		<tr>
			<td>软键盘控件：</td>
			<td>
				<input type="text" name="webForm.keypad" class="keypad" fillType="keypad"/>
			</td>
			<td>数字步进器：</td>
			<td>
				<input type="text" class="stepper" name="webForm.stepper" value="0" fillType="stepper"/>
			</td>
		</tr>
		<tr>
			<td>双向选择器：</td>
			<td colspan="3">
				 <div class="lister" selectedValue="" name="webForm.bothwaySelect" listerWidth="160" listerHeight="120" url="<%=path%>/form/getUsersOfDoubleSelect.action" fillType="lister"></div>
			</td>
		</tr>
		<tr>
			<td>树形双选器：</td>
			<td colspan="3">
				 <div class="listerTree" name="webForm.treeBothwaySelect" listerWidth="160" listerHeight="180" url="<%=path%>/form/getTreeLister.action" fillType="listerTree"></div>
			</td>
		</tr>
		<tr>
			<td>条件过滤器：</td>
			<td colspan="3">
				<div class="filter" url="<%=path%>/form/getUserList.action" name="webForm.conditionFilter" fillType="filter"></div>
			</td>
		</tr>
		<tr>
			<td>评星级控件：</td>
			<td colspan="3">
				<div class="rating" name="webForm.raty" fillType="rating"></div>
			</td>
		</tr>
		<tr>
			<td>异步上传控件：</td>
			<td colspan="3">
			    <input type="hidden" name="webForm.asynFile" id="hdn_file"/>
				<span id="uploadBtn"></span>
				<div id="uploadList"></div>
			</td>
		</tr>
		<tr>
			<td>文本域：</td>
			<td colspan="3">
				<textarea name="webForm.textarea" fillType="textarea"></textarea>
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
    var catalogId = "b557f717-753b-42ae-8ca7-e22413f17727";
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
		
		$('#myFormId').ajaxWrite({
			url:'<%=path%>/preEditWebformAjax.action'
		})
		
		
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