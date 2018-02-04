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

</head>
<body>
 <div class="box1" panelWidth="800">
   
   <fieldset>
       <legend>1、导航模式</legend>
	   <form method="post" action="" class="stepForm" stepFormTitle="true">
		<div id="step1-1" class="stepForm" stepFormTitle="表单步骤一">
			<table class="tableStyle" formMode="transparent">
				（第一部分表单内容）
				<tr>
					<td colspan="2">
						<input type="button" value="下一步" selfTarget="step1-1" nextTarget="step1-2"/>
					</td>
				</tr>
			</table>
		</div>
		
		<div id="step1-2" class="stepForm" stepFormTitle="表单步骤二">
			<table class="tableStyle" formMode="transparent">
				（第二部分表单内容）
				<tr>
					<td colspan="2">
						<input type="button" value="上一步" selfTarget="step1-2" prevTarget="step1-1"/>
						<input type="button" value="下一步" selfTarget="step1-2" nextTarget="step1-3"/>
					</td>
				</tr>
			</table>
		</div>
		
		<div id="step1-3" class="stepForm" stepFormTitle="表单步骤三">
			<table class="tableStyle" formMode="transparent">
				（第三部分表单内容）
				<tr>
					<td colspan="2">
						<input type="button" value="上一步" selfTarget="step1-3" prevTarget="step1-2"/>
						<input type="button" value="下一步" selfTarget="step1-3" nextTarget="step1-4"/>
					</td>
				</tr>
			</table>
		</div>
		
		<div id="step1-4" class="stepForm" stepFormTitle="表单步骤四">
			<table class="tableStyle" formMode="transparent">
				（第四部分表单内容）
				<tr>
					<td colspan="2">
						<input type="button" value="上一步" selfTarget="step1-4" prevTarget="step1-3"/>
						<input type="submit" value=" 提 交 "/>
					</td>
				</tr>
			</table>
		</div>
	 </form>
   </fieldset>
  <div class="height_15"></div>
  
  <fieldset>
      <legend>2、无导航模式</legend>
      <p>因每页中只能有1个拆分的表单，因此，以下的表单会放在弹出窗口中显示。</p>
      <input type="button" value="点击查看表单" onclick="showNoTitleForm();"/>
  </fieldset>
  <div class="height_15"></div>
  
  <fieldset>
      <legend>3、自定义初始时的步骤</legend>
      <p>form的currentStepNum属性设置表单出现时的步骤。如currentStepNum="1"则初始时在第二步。</p>
      <input type="button" value="点击查看表单" onclick="showFormWithStep();"/>
  </fieldset>
  <div class="height_15"></div>
  
  <fieldset>
      <legend>4、带验证的表单</legend>
      <input type="button" value="点击查看表单" onclick="showFormWithValidation();"/>
  </fieldset>
  
 </div>


<script type="text/javascript">
    
    //显示“无导航式”表单
    function showNoTitleForm(){
        var url = "<%=path%>/sample/fullform/step-content1.jsp";
        top.Dialog.open({
           Message: "这是无验证、无导航按钮的表单拆分演示",
           Height: 250,
           Width: 420,
           URL: url,
           Title: "表单拆分"
       });
    }
    
    //指定了初始步骤的
    function showFormWithStep(){
        var url = "<%=path%>/sample/fullform/step-content2.jsp";
        top.Dialog.open({
           Message: "这是有导航的表单拆分演示",
           Height: 250,
           Width: 420,
           URL: url,
           Title: "表单拆分"
       });
    }
    
    //有验证的
    function showFormWithValidation(){
    	var url = "<%=path%>/sample/fullform/step-content3.jsp";
        top.Dialog.open({
           Message: "这是有验证的表单拆分演示",
           Height: 250,
           Width: 420,
           URL: url,
           Title: "表单拆分"
       });
    }
    
</script>

</body>
</html>