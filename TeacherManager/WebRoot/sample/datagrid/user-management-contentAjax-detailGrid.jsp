<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改</title>
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!-- 日期控件start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/datePicker/WdatePicker.js"></script>
<!-- 日期控件end -->

<!-- 树组件start -->
<script type="text/javascript" src="<%=path%>/libs/js/tree/ztree/ztree.js"></script>
<link type="text/css" rel="stylesheet" href="<%=path%>/libs/js/tree/ztree/ztree.css"></link>
<!-- 树组件end -->

<!-- 树形下拉框start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/selectTree.js"></script>
<!-- 树形下拉框end -->

<!-- 表单验证start -->
<script src="<%=path%>/libs/js/form/validationRule.js" type="text/javascript"></script>
<script src="<%=path%>/libs/js/form/validation.js" type="text/javascript"></script>
<!-- 表单验证end -->

<!-- 表单异步提交start -->
<script src="<%=path%>/libs/js/form/form.js" type="text/javascript"></script>
<!-- 表单异步提交end -->

</head>
<body>
	<form id="myFormId" action="<%=path%>/saveUser.action" method="post" target="frmright">
	<div class="box1" id="formContent" whiteBg="true">
	<table class="tableStyle" formMode="transparent">
		<input type="hidden" name="userinfor.userId" value="<%=request.getParameter("userId")%>"/>
		<input type="hidden" id="isupdate" name="isupdate" value="1"/>
		<tr>
			<td width="150">用户名：</td>
			<td>
				<input type="text" value="" id="displayUserLoginName" disabled="disabled" fillType="textinput"/>
				<input type="hidden" name="userinfor.userLoginName" value=""/>
			</td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="text" name="userinfor.userPassword" value="" id="pwd" class="validate[required,length[6,11],custom[noSpecialCaracters]]" fillType="textinput"/><span class="star">*</span> </td>
		</tr>
		<tr>
			<td>密码确认：</td>
			<td><input type="text" id="pwdchk" class="validate[required,confirm[pwd]]" value="" fillType="textinput"/><span class="star">*</span></td>
		</tr>
		<tr>
			<td width="150">姓名：</td>
			<td><input type="text" name="userinfor.userName" value="" class="validate[required,custom[chinese],length[0,20]]" fillType="textinput"/><span class="star">*</span></td>
		</tr>
		<tr>
			<td>所属部门：</td>
			<td><div class="selectTree validate[required]"  disabled="true" selectedValue="" name="userinfor.organization.orgId" id="department" url="<%=path%>/getDepartmentsTree.action" fillType="selectTree"></div><span class="star">*</span>	</td>
		</tr>
		<tr>
			<td>性别：</td>
			<td>
				<input type="radio" id="radio-1" name="userinfor.userSex" value="1" fillType="radio"/><label for="radio-1" class="hand">男</label>
				<input type="radio" id="radio-2" name="userinfor.userSex" value="0" fillType="radio"/><label for="radio-2" class="hand">女</label>
			</td>
		</tr>
		<tr>
			<td>入职时间：</td>
			<td><input  type="text" name="userinfor.userEmployTime" value="" class="date" fillType="date"/></td>
		</tr>
		<tr>
			<td>学历：</td>
			<td><select name="userinfor.userEducation"  data='{"list":[{"value":"1","key":"大专"},{"value":"2","key":"本科"},{"value":"3","key":"硕士"},{"value":"4","key":"博士"}]}' fillType="select"></select></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="提交"/>
				<input type="button" value="取消" onclick="top.Dialog.close()"/>
			</td>
		</tr>
	</table>
	</div>
	</form>
<!-- 异步提交start -->
<script type="text/javascript">
function initComplete(){
    //表单提交
    $('#myFormId').submit(function(){ 
	    //判断表单的客户端验证是否通过
			var valid = $('#myFormId').validationEngine({returnIsValid: true});
			if(valid){
			   $(this).ajaxSubmit({
			        //表单提交成功后的回调
			        success: function(responseText, statusText, xhr, $form){
			            top.Dialog.alert(responseText.message,function(){
			            	closeWin();
			            })
			        }
			    }); 
			 }
		    
		    //阻止表单默认提交事件
		    return false; 
	});
   	$.post("<%=path%>/preUpdateUserAjax.action",{"userinfor.userId":"<%=request.getParameter("userId")%>"},
			function(result){
		   		$("#displayUserLoginName").val(result.userinfor.userLoginName);
		   		$("#pwdchk").val(result.userinfor.userPassword);
				$('#myFormId').ajaxWrite({data:result});
				$("#isupdate").val("1");
			},"json");
}



/**
 * 重置
 */
function closeWin(){
	//刷新数据
	top.frmright.refreshChild(true,<%=request.getParameter("gridId")%>);
	//关闭窗口
	top.Dialog.close();
}
</script>
<!-- 异步提交end -->	
</body>
</html>