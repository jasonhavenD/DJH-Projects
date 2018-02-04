<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>表单拆分</title>

<!-- 框架必需start -->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!-- 框架必需end -->

<!-- 表单拆分 start -->
<script src="<%=path%>/libs/js/form/stepForm.js" type="text/javascript"></script>
<!-- 表单拆分 end -->

<!-- 表单验证start -->
<script src="<%=path%>/libs/js/form/validationRule.js" type="text/javascript"></script>
<script src="<%=path%>/libs/js/form/validation.js" type="text/javascript"></script>
<!-- 表单验证end -->

<body>
 
 <div class="padding_top20">
   <form method="post" action="" class="stepForm" stepFormTitle="true">
	    <div id="step1" class="stepForm" stepFormTitle="表单步骤一">
		    <table class="tableStyle" formMode="transparent">
				<tr>
					<td width="100">用户名：</td><td><input id="user" type="text" class="validate[required,custom[noSpecialCaracters]]"/><span class="star">*</span></td>
				</tr>
				<tr>
					<td>籍贯：</td>
					<td>
						<select class="validate[required]">
						  	<option value="">请选择籍贯</option>
						    <option>北京市</option>
						    <option>天津市</option>
						    <option>河北省</option>
						 </select> <span class="star">*</span>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="下一步" selfTarget="step1" nextTarget="step2"/>
					</td>
				</tr>
			</table>
		</div>
		<div id="step2" class="stepForm" stepFormTitle="表单步骤二">
			<table class="tableStyle" formMode="transparent">
				<tr>
					<td width="100">选择权限：</td>
					<td>
						<select id="select1" class="validate[required]">
							<option value="">请选择</option>
							<option value="1">新增图片</option>
						    <option value="2">维护图片</option>
						    <option value="3">新增新闻</option>
						    <option value="4">发起投票活动</option>
						</select> <span class="star">*</span>
					</td>
				</tr>
				<tr>
					<td>性别：</td>
					<td>
						<div direction="inline" style="width:120px;">
						    <label for="radio-1">男</label><input type="radio" class="validate[required] radio" id="radio-1" name="ra" value="radio-1" />
					        <label for="radio-2">女</label><input type="radio" id="radio-2" name="ra" class="validate[required] radio" value="radio-2"/> <span class="star">*</span>
					    </div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="上一步" selfTarget="step2" prevTarget="step1" />
						<input type="button" value="下一步" selfTarget="step2" nextTarget="step3" />
					</td>
				</tr>
		    </table>
	  </div>
	  <div id="step3" class="stepForm" stepFormTitle="表单步骤三">
		<table class="tableStyle" formMode="transparent">
			<tr>
				<td width="100">年龄：</td><td><input type="text" class="validate[required,custom[onlyNumber],length[0,3]]"/><span class="star">*</span></td>
			</tr>
			<tr>
				<td>籍贯：</td>
				<td>
					<select class="validate[required]">
					  	<option value="">请选择籍贯</option>
					    <option>北京市</option>
					    <option>天津市</option>
					 </select>
					  <span class="star">*</span>
				</td>
			</tr>
			<tr>
				<td>爱好：</td>
				<td>
					<div direction="inline" style="width:120px;">
						<label for="checkbox-1" >唱歌</label><input type="checkbox" id="checkbox-1" class="validate[minCheckbox[1]] checkbox" name="ck1" value="选项1"/>
						<label for="checkbox-2">跳舞</label> <input type="checkbox" id="checkbox-2" class="validate[minCheckbox[1]] checkbox" name="ck1" value="选项2" /><span class="star">*</span>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="上一步" selfTarget="step3" prevTarget="step2"/>
					<input type="button" value="下一步" selfTarget="step3" nextTarget="step4" />
				</td>
			</tr>
		</table>
	  </div>
	
	  <div id="step4" class="stepForm" stepFormTitle="表单步骤四">
		<table class="tableStyle" formMode="transparent">
			<tr>
				<td width="100">年龄：</td><td><input type="text" class="validate[required,custom[onlyNumber],length[0,3]]"/><span class="star">*</span></td>
			</tr>
			<tr>
				<td>籍贯：</td>
				<td>
					<select class="validate[required]">
					  	<option value="">请选择籍贯</option>
					    <option>北京市</option>
					    <option>天津市</option>
					 </select><span class="star">*</span>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="上一步" selfTarget="step4" prevTarget="step3"/>
					<input type="submit" value=" 提 交 "/>
				</td>
			</tr>
		</table>
	  </div>
	</form>	
	
  </div>
</body>
</html>