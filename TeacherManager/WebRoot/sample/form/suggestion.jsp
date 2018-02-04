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

<!--自动提示框start-->
<script type='text/javascript' src='<%=path%>/libs/js/form/suggestion.js'></script>
<!--自动提示框end-->
</head>
<body>
<div class="box1" panelWidth="800">
	<fieldset>
      	<legend>注意</legend>
      	自动提示框有两种提示模式：<br/>
      	模式1：本地匹配模式，默认就是该模式，或者设置suggestMode="local"。一次性将数据全部加载。当用户输入时，前台从数据suggest属性的字典表中进行检索符合的。<br/>
      	模式2：远程匹配模式，设置suggestMode="remote"。用户输入时，组件将用户输入值作为参数向后台发送请求，后台返回相应的结果。<br/>
      	详细介绍见API手册。
      
      </fieldset>
      <div class="height_15"></div>
      以下为模式1的示例：
  <fieldset>
      <legend>1、通过url获取数据源</legend>
      <div class="red">此示例由后台支持</div>
      <p>提示：输入英文字母测试。</p>
      <div class="suggestion" url="<%=path%>/form/getListOfCity.action" id="sug-1"></div>
       <input type="button" value="获取值" onclick="getValue()" />
     <br/>还可通过url+参数获取数据源，用法同下拉框
  </fieldset>
  <div class="height_15"></div>
   
  <fieldset>
      <legend>2、通过设置data数据获取数据源</legend>
      <div class="suggestion" id="suggestion2" keepDefaultStyle="true"></div>
  </fieldset>
  <div class="height_15"></div>
  
  <fieldset>
      <legend>3、点击显示下拉列表</legend>
      <div class="suggestion" id="suggestion3" url="<%=path%>/form/getListOfCity.action" showList="true"></div>
      <br/>
      设置点击显示下拉列表后，默认会读取全部列表数据。这时组件等同于一个有提示功能的单选下拉框
  </fieldset>
  <div class="height_15"></div>
  
  <fieldset>
      <legend>4、自定义下拉列表数据</legend>
      <div class="suggestion" id="suggestion4"  url="<%=path%>/form/getListOfCity.action" showList="true"></div>
      <br/>
      可以设置点击出现的下拉列表数据，例如当全部列表数据数据量很大时，点击只显示推荐的数据。
  </fieldset>
  <div class="height_15"></div>
  
  <fieldset>
      <legend>5、点击显示多列下拉列表</legend>
      <div class="suggestion" id="suggestion5" keepDefaultStyle="true" showMultiList="true" multiListWidth="300"></div>
      <br/>
      设置点击显示多列下拉列表后，默认会读取全部列表数据。这时组件等同于一个有提示功能的多列单选下拉框。<br/>
      多列下拉列表无分页功能，并且需要设置列表的尺寸
  </fieldset>
  <div class="height_15"></div>
  
   <fieldset>
      <legend>6、多列下拉列表分组</legend>
      <div class="suggestion" id="suggestion6" keepDefaultStyle="true" showMultiList="true" multiListWidth="300" multiListHeight="200"></div>
      <br/>
      可以为组件多列下拉列表设置一个分组的数据，实现下拉列表的分组。
  </fieldset>
  <div class="height_15"></div>
  
  <fieldset>
      <legend>7、自定义尺寸</legend>
      <div class="suggestion" id="suggestion7" url="<%=path%>/form/getListOfCity.action" inputWidth="300" showList="true"></div>
      <br/>下拉列表的尺寸、展开方向等与下拉框组件用法一致。
  </fieldset>
  <div class="height_15"></div>
  
   <fieldset>
      <legend>8、自定义图标</legend>
      <div class="suggestion" id="suggestion8" keepDefaultStyle="true" iconSrc="<%=path%>/libs/images/icons/train.png" showMultiList="true"  multiListWidth="300" multiListHeight="200"></div>
  </fieldset>
  <div class="height_15"></div>
  
  <fieldset>
      <legend>9、禁用/启用</legend>
      <div class="suggestion" id="suggestion9" url="<%=path%>/form/getListOfCity.action" disabled="true" showList="true"></div>
      <br/>
      <input type="button" value="启用" onclick="enableSuggestion()" style="width:105px;"/>
	  <input type="button" value="禁用" onclick="disableSuggestion()" style="width:105px;"/>
  </fieldset>
  <div class="height_15"></div>
	
	 <fieldset>
      <legend>10、设置初始值</legend>
      <div class="suggestion" id="suggestion10" url="<%=path%>/form/getListOfCity.action" showList="true" selectedValue="4"></div>
  </fieldset>
  <div class="height_15"></div>
  
  <fieldset>
      <legend>11、动态创建</legend>
      <input type="button" value="点击生成" id="testBtn" onclick="dynamic()" style="width:150px;"/>
  </fieldset>
   <div class="height_15"></div>
  
   <fieldset>
      <legend>12、自定义验证</legend>
      <div class="suggestion" id="suggestion12" url="<%=path%>/form/getListOfCity.action" showList="true" autoCheck="false"></div>
  </fieldset>
  <div class="height_15"></div>
  
   <fieldset>
      <legend>13、选中事件</legend>
      <div class="suggestion" id="suggestion13" url="<%=path%>/form/getListOfCity.action" showList="true"></div>
  </fieldset>
   <div class="height_15"></div>
  
   <fieldset>
      <legend>14、无前缀数据</legend>
      <div class="suggestion" id="suggestion14" keepDefaultStyle="true" showList="true" showMultiList="true" multiListWidth="300" multiListHeight="200"></div>
  </fieldset>
  <div class="height_50"></div>
  
   以下为模式2的示例。（模式1的自定义尺寸、自定义图标、禁用/启用、动态创建示例对模式2也同样适用）
  <fieldset>
      <legend>1、基本示例，使用url进行检索匹配</legend>
      <div class="red">此示例由后台支持</div>
      <p>提示：输入“红烧肉”，“水煮肉片”，“酸辣汤”，“家常豆腐”，“鱼香茄子”，“干煸豆角”的第一个字测试。</p>
      <div class="suggestion" url="<%=path%>/form/getListByWordKey.action" suggestMode="remote"></div>
       <br/>匹配参数名默认为"q"；
      <br/>还可通过url+params进行匹配，参数用法同下拉框
  </fieldset>
  <div class="height_15"></div>
  
  <fieldset>
      <legend>2、拼音首字母匹配</legend>
      <div class="red">此示例由后台支持</div>
      输入“HS”或“QZ”测试（不区分大小写）。<br/>
      <div class="suggestion" url="<%=path%>/form/getListByCharKey.action" suggestMode="remote"></div>
      <br/>
      匹配列表数据是由后台传递过来的。
  </fieldset>
   <div class="height_15"></div>
   <fieldset>
      <legend>3、限定匹配字数和延迟</legend>
      <div class="red">此示例由后台支持</div>
      输入“HS”或“QZ”测试（不区分大小写）。<br/>
      <div class="suggestion" url="<%=path%>/form/getListByCharKey.action" minChars="2" delay="1000" suggestMode="remote"></div>
      <br/>
       此示例中，输入2个字符后延迟1秒才开始匹配，以免数据量太大引起性能的问题。
  </fieldset>
   <div class="height_15"></div>
   <fieldset>
      <legend>4、结果与输入关联</legend>
      <div class="red">此示例由后台支持</div>
      <div class="suggestion" suggestMode="remote" inputWidth="260" url="<%=path%>/form/getListByEmailKey.action" params='{"userAge": "26", "userSex": "1"}' matchName="userName"></div>
  		<br/>
  		这里根据输入的值返回自定义的结果，实现了一个邮箱提示框。另外还使用params传递了参数，并自定义匹配参数名为"userName"。
  </fieldset>
  <div class="height_15"></div>
  
  <fieldset>
      <legend>5、触发验证事件</legend>
      <div class="red">此示例由后台支持</div>
      输入“HS”或“QZ”测试（不区分大小写）。<br/>
      <div class="suggestion" url="<%=path%>/form/getListByCharKey.action" suggestMode="remote" id="suggestion2-5"></div>
      <br/>
  </fieldset>
   <div class="height_15"></div>
   
    <fieldset>
      <legend>6、触发选中事件</legend>
      <div class="red">此示例由后台支持</div>
      输入“HS”或“QZ”测试（不区分大小写）。<br/>
      <div class="suggestion" url="<%=path%>/form/getListByCharKey.action" suggestMode="remote" id="suggestion2-6"></div>
      <br/>
  </fieldset>
   <div class="height_15"></div>
   
   <fieldset>
      <legend>7、设置初始值</legend>
      <div class="red">此示例由后台支持</div>
      <div class="suggestion" url="<%=path%>/form/getListByWordKey.action"  suggestMode="remote" relValue="3" relText="红烧带鱼"></div>
      <br/>
       需要手动设置relValue和relText
  </fieldset>
   <div class="height_15"></div>
   
    <fieldset>
      <legend>8、个性化样式</legend>
      <div class="red">此示例由后台支持</div>
      仿网易邮箱的邮件查询。点击按钮在新窗口查看<br/>
		<input type="button" value="打开" onclick='openWin()'/> 
  </fieldset>
   <div class="height_15"></div>
<script>
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


var hotdata={"list":[
{value:"1",key:"北京"},
{value:"2",key:"广州"},
{value:"3",key:"深圳"},
{value:"4",key:"上海"}]};	

var tabdata={list:[
	{name:"热门城市",tab:[
		{key:"北京",value:"1"},
		{key:"广州",value:"2"},
		{key:"深圳",value:"3"},
		{key:"上海",value:"4"},
		{key:"成都",value:"6"},
		{key:"杭州",value:"9"},
		{key:"三亚",value:"13"},
		{key:"天津",value:"22"},
		{key:"厦门",value:"17"},
		{key:"西安",value:"18"}
	]},
	{name:"A-F",tab:[
		{key:"北京",value:"1"},
		{key:"长沙",value:"5"},
		{key:"成都",value:"6"}
	]},
	{name:"G-J",tab:[
		{key:"广州",value:"2"},
		{key:"贵阳",value:"7"},
		{key:"海口",value:"8"},
		{key:"杭州",value:"9"}
	]},
	{name:"K-N",tab:[
		{key:"昆明",value:"10"},
		{key:"南昌",value:"11"},
		{key:"南京",value:"12"}
	]},
	{name:"O-T",tab:[
		{key:"深圳",value:"3"},
		{key:"上海",value:"4"},
		{key:"三亚",value:"13"},
		{key:"沈阳",value:"14"},
		{key:"汕头",value:"20"},
		{key:"太原",value:"21"},
		{key:"天津",value:"22"}
	]},
	{name:"U-Z",tab:[
		{key:"温州",value:"15"},
		{key:"武汉",value:"16"},
		{key:"厦门",value:"17"},
		{key:"西安",value:"18"},
		{key:"郑州",value:"19"}
	]}
]}	


var listdata2={"list":[
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


var hotdata2={"list":[
{value:"1",key:"北京"},
{value:"2",key:"广州"},
{value:"3",key:"深圳"},
{value:"4",key:"上海"}]};	

var tabdata2={list:[
	{name:"热门城市",tab:[
		{key:"北京",value:"1"},
		{key:"广州",value:"2"},
		{key:"深圳",value:"3"},
		{key:"上海",value:"4"},
		{key:"成都",value:"6"},
		{key:"杭州",value:"9"},
		{key:"三亚",value:"13"},
		{key:"天津",value:"22"},
		{key:"厦门",value:"17"},
		{key:"西安",value:"18"}
	]},
	{name:"A-F",tab:[
		{key:"北京",value:"1"},
		{key:"长沙",value:"5"},
		{key:"成都",value:"6"}
	]},
	{name:"G-J",tab:[
		{key:"广州",value:"2"},
		{key:"贵阳",value:"7"},
		{key:"海口",value:"8"},
		{key:"杭州",value:"9"}
	]},
	{name:"K-N",tab:[
		{key:"昆明",value:"10"},
		{key:"南昌",value:"11"},
		{key:"南京",value:"12"}
	]},
	{name:"O-T",tab:[
		{key:"深圳",value:"3"},
		{key:"上海",value:"4"},
		{key:"三亚",value:"13"},
		{key:"沈阳",value:"14"},
		{key:"汕头",value:"20"},
		{key:"太原",value:"21"},
		{key:"天津",value:"22"}
	]},
	{name:"U-Z",tab:[
		{key:"温州",value:"15"},
		{key:"武汉",value:"16"},
		{key:"厦门",value:"17"},
		{key:"西安",value:"18"},
		{key:"郑州",value:"19"}
	]}
]}
function initComplete(){
	$("#suggestion2").data("data",listdata);
	$("#suggestion2").render();

	
	$("#suggestion4").data("list",hotdata);
	$("#suggestion4").render();
	
	$("#suggestion5").data("data",listdata);
	$("#suggestion5").render();
	
	$("#suggestion6").data("data",listdata);
	$("#suggestion6").data("tab",tabdata);
	$("#suggestion6").render();
	
	$("#suggestion8").data("data",listdata);
	$("#suggestion8").data("tab",tabdata);
	$("#suggestion8").render();
	
	$("#suggestion12").bind("validate",function(e,value){
		top.Dialog.alert("此处触发验证事件，请用ajax方式将”"+value+"“提交到后台处理。")
	})
	
	$("#suggestion13").bind("listSelect",function(e,obj){
		top.Dialog.alert("选中项文本："+obj.relText+"；选中项值："+obj.relValue);
	})
	
	
	$("#suggestion2-5").bind("validate",function(e,value){
		top.Dialog.alert("此处触发验证事件，请用ajax方式将”"+value+"“提交到后台处理。")
	})
	$("#suggestion2-6").bind("listSelect",function(e,obj){
		top.Dialog.alert("选中项文本："+obj.relText+"；选中项值："+obj.relValue);
	})
	
	
	$("#suggestion14").data("data",listdata2);
	$("#suggestion14").data("tab",tabdata2);
	$("#suggestion14").render();
}
function getValue(){
	top.Dialog.alert("选中文本："+$("#sug-1").attr("relText")+"<br/>选中值："+$("#sug-1").attr("relValue"));
}
function enableSuggestion(){
	$("#suggestion9").attr("disabled",false);
	$("#suggestion9").render();
}
function disableSuggestion(){
	$("#suggestion9").attr("disabled",true);
	$("#suggestion9").render();
}
//动态生成
function dynamic(){
	var $sugg = $('<div type="text" class="suggestion" showList="true"></div>');
	$sugg.attr("url","<%=path%>/form/getListOfCity.action");
	$("#testBtn").after($sugg);   
	$("#testBtn").after($("<br/>"));   
	//渲染
	$sugg.render();
}
function openWin(){
	var diag = new top.Dialog();
	diag.URL = "<%=path%>/sample/form/suggestion-content.jsp";
	diag.show();
	diag.max();
}
</script>
</body>
</html>