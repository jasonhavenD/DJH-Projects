<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
<style>
.table1 td{
	padding:5px 0 5px 0;
}
</style>
</head>
<body>
	
	
<script type="text/javascript">
     //上传组件使用
    var upload;
    var catalogId = "1340271126861_2";
    
     var $form;
     function initComplete(){
		//创建多功能容器
		var $box=$('<div class="box1" panelWidth="600"></div>');
		//要先渲染再添加元素
		$box.render();
		$("body").append($box);
		
		//获取多功能容器内容区域
		var $content=$("body").find(".box1 .boxContent");
		
		//创建表单
		$form=$('<form></form>')
		
		//将表单添加到多功能容器内容区域
		$content.append($form);
		
		//创建表格
		var $table=$('<table class="table1"><tr><td class="ali03" width="150">文本框：</td><td></td></tr>'+
		'<tr><td class="ali03">单选按钮：</td><td></td></tr>'+
		'<tr><td class="ali03">多选按钮：</td><td></td></tr>'+
		'<tr><td class="ali03">单选下拉框：</td><td></td></tr>'+
		'<tr><td class="ali03">树形下拉框：</td><td></td></tr>'+
		'<tr><td class="ali03">自动完成框：</td><td></td></tr>'+
		'<tr><td class="ali03">日期选择框：</td><td></td></tr>'+
		'<tr><td class="ali03">双向选择器：</td><td></td></tr>'+
		'<tr><td class="ali03">树形双选器：</td><td></td></tr>'+
		'<tr><td class="ali03">条件过滤器：</td><td></td></tr>'+
		'<tr><td class="ali03">颜色选择器：</td><td></td></tr>'+
		'<tr><td class="ali03">数字步进器：</td><td></td></tr>'+
		'<tr><td class="ali03">软键盘控件：</td><td></td></tr>'+
		'<tr><td class="ali03">评星级控件：</td><td></td></tr>'+
		'<tr><td class="ali03">异步上传控件：</td><td></td></tr>'+
		'<tr><td class="ali03">文本域：</td><td></td></tr>'+
		'<tr><td class="ali02" colspan="2"></td></tr>'+
		'</table>');
		
		//将表格添加到表单中
		$form.append($table);
		
		//创建文本框并赋值
		var $input=$('<input type="text" class="validate[required]">');
		$input.val("张三");
		
		
		//创建单选按钮并赋值
		var $radio1 =$('<input type="radio" id="radio-1" name="bo.radio" value="男" />');
		var $radiolabel1 =$('<label for="radio-1">男</label>');
		var $radio2 =$('<input type="radio" id="radio-2" name="bo.radio" value="女"/>');
		var $radiolabel2 =$('<label for="radio-2">女</label>');
		$radio2.attr("checked",true);
		
		//创建复选按钮并赋值
		var $check1 =$('<input type="checkbox" id="checkbox-1" name="bo.checkboxs" value="唱歌"/>');
		var $checklabel1 =$('<label for="checkbox-1" >唱歌</label>');
		var $check2 =$('<input type="checkbox" id="checkbox-2" name="bo.checkboxs" value="跳舞" />');
		var $checklabel2 =$('<label for="checkbox-2">跳舞</label>');
		$check2.attr("checked",true);
		
		//创建单选下拉框并赋值
		var $select = $('<select mode="ajax" prompt="请选择省份"></select>');
		var selData={"list":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"}]};
		//赋给data
		$select.data("data",selData);
		$select.attr("selectedValue","2");
		
		
		//创建树形下拉框并赋值
		var $selTree = $('<div class="selectTree"></div>');
		var defaultNodes = {"treeNodes":[
			{ id:1, parentId:0, name:"部门1", open: true},
			{ id:11, parentId:1, name:"员工1"},
			{ id:12, parentId:1, name:"员工2"},
			{ id:13, parentId:1, name:"员工3"},
			{ id:2, parentId:0, name:"部门2", open: true},
			{ id:21, parentId:2, name:"员工4"}
		]};
		$selTree.data("data",defaultNodes); 
		
		//创建自动完成框并赋值
		var $auto = $('<input type="text" class="autoComplete"/>');
		$auto.attr("url","<%=path%>/autoComplateAction.do?method=getListByEmail");
		$auto.attr("params",'{"userAge": "26", "userSex": "1"}');
		$auto.attr("matchName","userName");
		$auto.val("北京");
		
		//创建日期选择框并赋值
		var $date=$('<input type="text" class="date"/>');
		$date.val("2012-07-16");
		 
		
		//创建双向选择器并赋值
		var $lister=$('<div class="lister" listerWidth="120" listerHeight="120" ></div>');
		var listerData={fromList:[{value:"1",key:"员工1"},{value:"2",key:"员工2"},{value:"3",key:"员工3"},{value:"4",key:"员工4"}],"toList":[]};
		$lister.data("data",listerData)
		$lister.attr("selectedValue",'1,2');
		
		
		//创建树形双选器并赋值
		var $listerTree=$('<div class="listerTree" listerWidth="120" listerHeight="180" ></div>');
		var listerTreeData={"toList":[],"fromList":[{"id":"1","parentId":"0","open":"true","name":"部门1","oldParentId":"null","drag":"false"},{"id":"11","parentId":"1","name":"员工1","oldParentId":"1"},{"id":"12","parentId":"1","name":"员工2","oldParentId":"1"},{"id":"13","parentId":"1","name":"员工3","oldParentId":"1"}]}
		$listerTree.data("data",listerTreeData)
		$listerTree.attr("selectedValue",'11,12');
		
		
		//创建条件过滤器并赋值
		var $filter = $('<div class="filter"></div>');
		var filterData= {"list":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"},{"value":"3","key":"员工3"},{"value":"4","key":"员工4"}]};
		$filter.data("data",filterData)
		$filter.attr("selectedValue","2");
		
		
		//创建颜色选择器并赋值
		var $color=$('<input type="text" class="color"/>');
		$color.val("#00ff00");
		
		 
		 //创建数字步进器并赋值    
		 var $stepper = $('<input id="step1" type="text" class="stepper"/>');
        $stepper.val(10);
		
		
		 //创建软键盘控件并赋值    
		var $keypad = $('<input type="text" class="keypad"/>');
		$keypad.val(1234);
		
		
		//创建星级控件并赋值   
		//动态生成星级控件需要设置id
		var $rating = $('<div class="rating" id="rating9"></div>');
		$rating.attr("value",2);
		
		 //创建异步上传控件
        var $fileUpload=$('<span id="uploadBtn"></span><div id="uploadList"></div></div>');
		
		
		//创建文本域并赋值  
		var $ta=$('<textarea class="textarea"></textarea>');
		$ta.html("备注信息");
		
		//创建按钮 
		var $input1=$('<input type="button" value="提交"/>' );
		var $input2=$('<input type="button" value="取消"/>' );
		
		 //提交触发表单验证
        $input1.click(function(){ 
		   var valid = $form.validationEngine({returnIsValid: true});
			if(valid == true){
				top.Dialog.alert("验证通过，表单提交处理");
			}
			else{
				top.Dialog.alert("表单填写不正确，请按要求填写！");
			}
		});
		
		
		//将元素添加到表格中
		$table.find("tr").eq(0).find("td").eq(1).append($input);
		$table.find("tr").eq(1).find("td").eq(1).append($radio1);
		$table.find("tr").eq(1).find("td").eq(1).append($radiolabel1);
		$table.find("tr").eq(1).find("td").eq(1).append($radio2);
		$table.find("tr").eq(1).find("td").eq(1).append($radiolabel2);
		$table.find("tr").eq(2).find("td").eq(1).append($check1);
		$table.find("tr").eq(2).find("td").eq(1).append($checklabel1);
		$table.find("tr").eq(2).find("td").eq(1).append($check2);
		$table.find("tr").eq(2).find("td").eq(1).append($checklabel2);
		$table.find("tr").eq(3).find("td").eq(1).append($select);
		$table.find("tr").eq(4).find("td").eq(1).append($selTree);
		$table.find("tr").eq(5).find("td").eq(1).append($auto);
		$table.find("tr").eq(6).find("td").eq(1).append($date);
		$table.find("tr").eq(7).find("td").eq(1).append($lister);
		$table.find("tr").eq(8).find("td").eq(1).append($listerTree);
		$table.find("tr").eq(9).find("td").eq(1).append($filter);
		$table.find("tr").eq(10).find("td").eq(1).append($color);
		$table.find("tr").eq(11).find("td").eq(1).append($stepper);
		$table.find("tr").eq(12).find("td").eq(1).append($keypad);
		$table.find("tr").eq(13).find("td").eq(1).append($rating);
		$table.find("tr").eq(14).find("td").eq(1).append($fileUpload);
		$table.find("tr").eq(15).find("td").eq(1).append($ta);
		$table.find("tr").eq(16).find("td").eq(0).append($input1);
		$table.find("tr").eq(16).find("td").eq(0).append("&nbsp;");
		$table.find("tr").eq(16).find("td").eq(0).append($input2);
		
		//渲染一律放在最后
		$input.render();
		$select.render(); 
		$selTree.render(); 
		$auto.render(); 
		$date.render();   
        $lister.render(); 
        $listerTree.render(); 
        $filter.render();   
        $color.render(); 
        $stepper.render();
        $keypad.render();
        $rating.render();
        $ta.render();   
        $input1.render();
		$input2.render(); 
       
        //渲染异步上传控件
		var upload;
   		//这里的值取的是已经上传有附件的catalogId
   		var catalogId = "b557f717-753b-42ae-8ca7-e22413f17727";
		
		
		
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
		
		
		//动态添加验证
		$form.validationEngine();
    }

</script>
</body>
</html>