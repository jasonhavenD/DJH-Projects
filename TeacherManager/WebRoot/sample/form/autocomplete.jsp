<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>自动完成的文本框</title>
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!-- 自动完成框start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/autoComplete.js"></script>
<!-- 自动完成框end -->

</head>
<body>
 
  <div class="box1" panelWidth="800">
  <fieldset>
      <legend>1、通过url获取数据源</legend>
      <div class="red">此示例由后台支持</div>
      <p>提示：输入“红烧肉”，“水煮肉片”，“酸辣汤”，“家常豆腐”，“鱼香茄子”，“干煸豆角”的第一个字测试。</p>
      <input type="text" class="autoComplete" url="<%=path%>/autoComplateAction.do?method=getListByWord"/>
       <p>匹配参数名默认为"q"；获取的JSON数据的数据名默认为"list"，可使用dataRoot属性改变</p>
  </fieldset>
  <div class="height_15"></div>
  
  <fieldset>
      <legend>2、通过url+参数获取数据源</legend>
       <div class="red">此示例由后台支持</div>
      <p>输入邮箱地址。</p>
      <input type="text" class="autoComplete" url="<%=path%>/autoComplateAction.do?method=getListByEmail" params='{"userAge": "26", "userSex": "1"}' matchName="userName"/>
       <p>这里除了传递了参数，还自定义匹配参数名为"userName"。然后根据输入的值返回自定义的结果，实现了一个邮箱提示框。</p>
  </fieldset>
  <div class="height_15"></div>
  
   <fieldset>
      <legend>3、使用data(本地数据)</legend>
      <p>可分别输入”红烧肉“，“牛肉汤”，“酸梅汤”第一个字测试。</p>
       <input type="text" id="input-3" class="autoComplete"/>
  </fieldset>
  <div class="height_15"></div>
  
   <fieldset>
      <legend>4、限定匹配字数和现实条数</legend>
       <div class="red">此示例由后台支持</div>
      <p>输入“HS”或“QZ”测试（不区分大小写）。</p>
      <input type="text" class="autoComplete" url="<%=path%>/autoComplateAction.do?method=getListByChar" minChars="2" limit="50"/>
      <p>此示例中，输入2个字符后才开始匹配，且最多显示50条结果。以免数据量太大引起渲染的问题。</p>
  </fieldset>
  <div class="height_15"></div>
  
  <fieldset>
      <legend>5、通过拼音首字母获取匹配列表</legend>
       <div class="red">此示例由后台支持</div>
      <p>可分别输入”S“，“HS”，“SL”，“SZ”测试（不区分大小写）。</p>
      <input type="text" class="autoComplete" url="<%=path%>/autoComplateAction.do?method=getListByChar" />
  </fieldset>
   <div class="height_15"></div>
   
   <fieldset>
      <legend>6、自定义尺寸</legend>
       <div class="red">此示例由后台支持</div>
    	<p>输入邮箱地址。</p>
      <input type="text" class="autoComplete" url="<%=path%>/autoComplateAction.do?method=getListByEmail" matchName="userName" inputWidth="250" boxWidth="250"/>
  </fieldset>
  <div class="height_15"></div>
  
  <fieldset>
      <legend>7、多列提示</legend>
       <div class="red">此示例由后台支持</div>
      <p>输入“红”测试。</p>
      <input type="text" class="autoComplete" url="<%=path%>/autoComplateAction.do?method=getListByMutiCols" boxWidth="250" colMulti="true" colIdx="0"/>
       <p>设置多列并指定点击后选中的是哪一列的数据</p>
  </fieldset>
  <div class="height_15"></div>
  
  <fieldset>
      <legend>8、禁用/启用</legend>
       <div class="red">此示例由后台支持</div>
      <p>可分别输入”S“，“HS”，“SL”，“SZ”测试（不区分大小写）。</p>
       <input type="text" class="autoComplete" url="<%=path%>/autoComplateAction.do?method=getListByChar" disabled="true"  id="input-8"/>
       <input type="button" value="启用" onclick="enable()" style="width:105px;"/>
      <input type="button" value="禁用" onclick="disable()" style="width:105px;"/>
      
		
  </fieldset>
  <div class="height_15"></div>
  
   <fieldset>
      <legend>9、动态创建</legend>
       <div class="red">此示例由后台支持</div>
       <input type="button" value="点击生成" id="testBtn" onclick="dynamic()" style="width:150px;"/>
  </fieldset>
  
   <fieldset>
      <legend>10、手动渲染</legend>
       <div class="red">此示例由后台支持</div>
      <p>可分别输入”S“，“BJ”，“SH”，“SZ”测试（不区分大小写）。</p>
       <input type="text" id="input-10" class="autoCompleteIcon"/> <label id="label0"></label>
        <p>手动渲染可以监听事件。<br/>
        可监听的事件有：onBeforeListLoad（开始请求后台数据时触发）、onListLoaded（数据列表生成后触发）、onItemSelected（选择条目时触发）</p>
  </fieldset>
  <div class="height_15"></div>
  
  
 <fieldset>
      <legend>11、综合示例</legend>
       <div class="red">此示例由后台支持</div>
      	
      仿网易邮箱的邮件查询。点击按钮在新窗口查看<br/>
		<input type="button" value="打开" onclick='top.Dialog.open({URL:"<%=path%>/sample/form/autocomplete-content.jsp",Title:"示例",Width:"100",Height:"100"});'/> 
  </fieldset>
  <div class="height_15"></div>
  
  
  
  </div>

<script type="text/javascript">
	
	function initComplete(){
		//动态设置data
		var myData={"list" : ["红烧肉","红烧排骨","红烧鸡翅","汉堡","牛肉汤","牛肉酱","牛肉炖土豆","牛奶炖蛋","酸奶蛋糕","酸梅汤"]};
		$('#input-3').data("data",myData);
		$('#input-3').render();
	
		//手动渲染
		$('#input-10').AutoComplete({
			url: '<%=path%>/autoComplateAction.do?method=getListByChar',
			onBeforeListLoad: function(){
			   top.Dialog.alert("请求数据...<br/>对于重复的请求，会使用缓存中的查询结果，不再去服务器查询。"); 
			},
			onItemSelected: function(item){
				top.Dialog.alert("选择了：" + item.text());
			},
			onListLoaded: function(list){
				$("#label0").html("符合项的个数：" + list.find('li').size());
		    }
		});
    }
   
    
	//设为不可用
	function disable(){
		$("#input-8").attr("disabled",true);
	}
	//设为可用
	function enable(){
	    $("#input-8").attr("disabled",false);
	}
	
	//动态生成
	function dynamic(){
		var $auto = $('<input type="text" class="autoComplete"/>');
		$auto.attr("url","<%=path%>/autoComplateAction.do?method=getListByChar");
		$("#testBtn").after($auto);   
		$("#testBtn").after($("<br/>"));   
		//渲染
		$auto.render();      
	}

    
</script>

</body>
</html>