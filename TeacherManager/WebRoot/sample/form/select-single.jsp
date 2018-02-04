<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>单选下拉框</title>
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->
</head>
<body>
   <div class="box1" panelWidth="800">
   		 <fieldset> 
			<legend>1、json数据模式（json数据源）</legend>
			使用url属性获取数据：
			 <div class="red">此示例由后台支持</div>
			<select prompt="请选择" url="<%=path%>/form/getUserList.action" id="sel-1-1"></select>
			<br/>
			<input type="button" value="获取选中值" onclick="getSelectedItem()"/>
			<br/>
			<br/>
			使用url属性+参数获取数据：
			 <div class="red">此示例由后台支持</div>
			<select url="<%=path%>/form/getUserList.action" prompt="请选择员工" params='{"userinfor.organization.orgId":"3"}'></select>
			<br/>
			<br/>
			赋值给标签的data属性：<br/>
			<select prompt="请选择员工" data='{"list":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"}]}'></select>
			<br/>注意：使用json格式的字符串时所有节点的属性名与值都必须使用双引号
			<br/>
			<br/>
			动态设置data（本地数据源）<br/>
			<select prompt="请选择员工" id="sel-1-2" keepDefaultStyle="true"></select>
			<br/>
			<br/>
			动态设置data（远程数据源）
			 <div class="red">此示例由后台支持</div>
			<select prompt="请选择员工" id="sel-1-3" keepDefaultStyle="true"></select>
			
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
			<legend>2、本地模式</legend>
			<select>
			    <option value="">请选择功能</option>
			    <option value="0">新增图片</option>
			    <option value="1">维护图片</option>
			    <option value="2">新增新闻</option>
			</select>
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset> 
			<legend>3、禁用/启用</legend>
			<select disabled="true"  id="sel-3"  data='{"list":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"}]}'></select>
			<br/>
			<input type="button" value="启用" onclick="enableSelect()" style="width:105px;"/>
			<input type="button" value="禁用" onclick="disableSelect()" style="width:105px;"/>
			
	  </fieldset>
	  
   	  <fieldset> 
			<legend>4、change事件</legend>
			使用bind方法绑定change事件<br/>
			<select id="sel-4" data='{"list":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"}]}'></select>
			<br/>
			<br/>
			也可以使用标签自带的onchange<br/>
			<select data='{"list":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"}]}' onchange="onchangeHandler(this)"></select>
	  </fieldset>
	  <div class="height_15"></div>
	  
	 
	  <fieldset> 
			<legend>5、使用optgroup进行分组（仅本地模式可以）</legend>
			<select>
				<option>请选择权限</option>
				<optgroup label="首页信息发布">
					<option value="新增图片">新增图片</option>
					<option value="维护图片">维护图片</option>
					<option value="新增新闻">新增新闻</option>
				</optgroup>
				<optgroup label="人员维护">
					 <option value="新增用户">新增用户</option>
			         <option value="用户列表">用户列表</option>
				</optgroup>
			</select>
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset> 
			<legend>6、宽度、高度与方向</legend>
			下拉框默认为120px宽度，当有较长的选项时，下拉框宽度默认不变，而选项容器宽度自适应<br/>
			<select>
			    <option value="">请选择功能</option>
			    <option value="0">我是很长很长很长很长很长很长很长很长的选项</option>
			    <option value="1">维护图片</option>
			    <option value="2">新增新闻</option>
			</select>
			<br/><br/>
			单独设置下拉框宽度，选项容器宽度默认不会小于下拉框宽度<br/>
			<select selWidth="260">
			    <option value="">请选择功能</option>
			    <option value="1">维护图片</option>
			    <option value="2">新增新闻</option>
			</select>
			
			<br/><br/>自定义容器高度：<br/>
			<select boxHeight="100" data='{"list":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"},{"value":"2","key":"员工2"},{"value":"2","key":"员工2"},{"value":"2","key":"员工2"},{"value":"2","key":"员工2"},{"value":"2","key":"员工2"},{"value":"2","key":"员工2"},{"value":"2","key":"员工2"}]}'></select>
			<br/><br/>强制向上展开：<br/>
			<select data='{"list":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"}]}' openDirection="top"></select>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  
	   <fieldset> 
			<legend>7、可编辑</legend>
			<select data='{"list":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"}]}' editable="true" id="sel-7"></select><br/>
			<input type="button" value="获取值" onclick="getEditableValue()"/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset> 
			<legend>8、自定义列数</legend>
			<select colNum="3" colWidth="80"  data='{"list":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"},{"value":"3","key":"员工3"},{"value":"4","key":"员工4"},{"value":"5","key":"员工5"},{"value":"6","key":"员工6"}]}'></select>
			<br/><br/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
			<legend>9、联动</legend>
			 <div class="red">此示例由后台支持</div>
			<table>
				<tr>
					<td>
					<select id="sel-9-1"  url="<%=path%>/form/getDepartment.action?parentid=0" prompt="请选择公司" 
			  		 childId="sel-9-2" childDataPath="<%=path%>/form/getDepartment.action?parentid=" ></select>
					</td>
					<td>
					<select id="sel-9-2"   prompt="请选择部门" childDataPath="<%=path%>/form/getUsers.action?parentid="
			   			childId="sel-9-3"></select>
					</td>
					<td>
					<select id="sel-9-3"   prompt="请选择员工"></select>
					</td>
				</tr>
			</table>
			<br/>
			<br/>
			联动下拉框加载数据完成后的回调函数：
			<table>
				<tr>
					<td>
				<select id="sel-9-4"  url="<%=path%>/form/getDepartment.action?parentid=0" prompt="请选择公司"
				    childId="sel-9-5" childDataPath="<%=path%>/form/getDepartment.action?parentid=" ></select>	
					</td>
					<td>
				<select id="sel-9-5"  prompt="请选择部门" childDataPath="<%=path%>/form/getUsers.action?parentid=" 
					childId="sel-9-6"></select>
					</td>
					<td>
				<select id="sel-9-6"  prompt="请选择员工" ></select>
					</td>
				</tr>
			</table>
			<p>在这里监听第二个下拉框的加载完成事件，来重置第三个下拉框。</p>
			<br/>
			初始时赋值
			<table>
				<tr>
					<td>
					<select id="sel-9-7"  url="<%=path%>/form/getDepartment.action?parentid=0" selectedValue="1" prompt="请选择公司" 
			  		 childId="sel-9-8" childDataPath="<%=path%>/form/getDepartment.action?parentid=" ></select>
					</td>
					<td>
					<select id="sel-9-8"   prompt="请选择部门"  selectedValue="13"></select>
					</td>
				</tr>
			</table>
			<br/><br/><br/>
			省市县三级联动
			<br/>
			数据写在文件中，不读写数据库，减少服务器负担。<br/>
			<table>
				<tr>
					<td>
					<select id="sel-9-9" childId="sel-9-10"  url="<%=path%>/sample/form/area.xml" prompt="请选择省份" dataType="xml" childDataType="xml" dataRoot="province" labelField="name" valueField="name" openDirection="bottom"></select>
					</td>
					<td>
					<select id="sel-9-10" childId="sel-9-11"  prompt="请选择城市" dataType="xml" childDataType="xml" dataRoot="city" labelField="name" valueField="name" openDirection="bottom"></select>
					</td>
					<td>
					<select id="sel-9-11"  prompt="请选择区" dataType="xml" dataRoot="country" labelField="name" valueField="name" openDirection="bottom"></select>
					</td>
				</tr>
			</table>
			<br/>
			初始时赋值<br/>
			<table>
				<tr>
					<td>
					<select id="sel-9-12" childId="sel-9-13"  url="<%=path%>/sample/form/area.xml" prompt="请选择省份" selectedValue="安徽省" dataType="xml" childDataType="xml" dataRoot="province" labelField="name" valueField="name" openDirection="bottom"></select>
					</td>
					<td>
					<select id="sel-9-13" childId="sel-9-14"  prompt="请选择城市" selectedValue="宣城市" dataType="xml" childDataType="xml" dataRoot="city" labelField="name" valueField="name" openDirection="bottom"></select>
					</td>
					<td>
					<select id="sel-9-14"  prompt="请选择区" selectedValue="宣州区" dataType="xml" dataRoot="country" labelField="name" valueField="name" openDirection="bottom"></select>
					</td>
				</tr>
			</table>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  
	  
	   <fieldset> 
			<legend>10、设置初始时选中值</legend>
			json数据模式：<br/>
			使用selectedValue（推荐）：<br/>
			<select data='{"list":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"}]}' selectedValue="2"></select><br/>
			使用selectedIdx：<br/>
			<select data='{"list":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"}]}' prompt="请选择省份" selectedIdx="1"></select>
			<br/>
			同一个组件不要既设置selectedIdx又设置selectedValue
			<br/><br/>本地模式：<br/>
			<select>
				<option value="">请选择功能</option>
			    <option value="1" selected="selected">新增图片</option>
			    <option value="2">维护图片</option>
			    <option value="3">新增新闻</option>
			</select>
	   </fieldset>
	   <div class="height_15"></div>
	  
	  
	  <fieldset> 
			<legend>11、动态生成下拉框</legend>
			 <div class="red">此示例由后台支持</div>
			<input type="button" value="点击生成（使用url）" id="testBtn" onclick="dynamicSelectbox1()" style="width:150px;"/><br/><br/>
			 <div class="red">此示例由后台支持</div>
			<input type="button" value="点击生成（使用data）" id="testBtn2" onclick="dynamicSelectbox2()" style="width:150px;"/><br/><br/>
			<input type="button" value="点击生成本地下拉框" id="testBtn3" onclick="dynamicSelectbox3()" style="width:150px;"/>
	   </fieldset>
	   <div class="height_15"></div>
	   
	 
	   
	   <fieldset> 
			<legend>12、动态修改下拉框</legend>
			json数据模式:<br/>
			<select prompt="请选择" data='{"list":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"}]}' id="sel-12-1"></select>
			<br/><br/><input type="button" value="选中“员工1”" onclick="selectSecondItem1()" style="width:105px;"/>
			<input type="button" value="追加一项" onclick="appendItem1()" style="width:105px;"/>
			<input type="button" value="移除“员工2”" onclick="removeItem1()" style="width:105px;"/>
			
			<br/>
			<br/><br/>
			本地模式:<br/>
			<select   id="sel-12-2">
				<option value="">请选择功能</option>
			    <option value="0">新增图片</option>
			    <option value="1">维护图片</option>
			    <option value="2">新增新闻</option>
			</select>
			<br/><br/><input type="button" value="选中第二项" onclick="selectSecondItem2()" style="width:105px;"/>
			<input type="button" value="追加一项" onclick="appendItem2()" style="width:105px;"/>
			<input type="button" value="移除选中项" onclick="removeItem2()" style="width:105px;"/>
	   </fieldset>
	   <div class="height_15"></div>
	   
	   <fieldset> 
			<legend>13、重置下拉框值</legend>
			<form id="form-14">
				<table class="tableStyle" formMode="transparent" style="width:400px;">
					<tr>
						<td>传统表单元素：</td>
						<td><input type="text"/></td>
					</tr>
					<tr>
						<td>下拉框1：</td>
						<td><select prompt="请选择" data='{"list":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"}]}' ></select></td>
					</tr>
					<tr>
						<td>下拉框2：</td>
						<td><select prompt="请选择" data='{"list":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"}]}' selectedValue="2"></select></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="button" value="提交"/> 
							<input type="button" value="重置" onclick="resetForm()"/>
						</td>
					</tr>
				</table>
			</form>
	   </fieldset>
	   <div class="height_15"></div>
	   
	    <fieldset> 
			<legend>14、不同表单元素横向排列</legend> 
			由于下拉框设置了float:left属性，如果直接将不同的元素横向排列，则会出现如下效果：<br/><br/>
			姓名：
			<input type="text"/>
			性别：
			<select>
			    <option value="">请选择</option>
			</select>
			<input type="button" value="提交"/><br/><br/><br/><br/>
			这时应该使用table来布局，每个元素放在一个td里面。效果如下：<br/><br/>
			<table>
			<tr>
				<td>姓名：</td>
				<td><input type="text"/></td>
				<td>性别：</td>
				<td>
				<select>
				    <option value="">请选择</option>
				</select>
				</td>
				<td><input type="button" value="提交"/></td>
			</tr>
			</table>
	   </fieldset>
	   <div class="height_15"></div>
	   
	   
	   <fieldset>
			<legend>15、获得选中节点自定义属性</legend>
			<select id="sel-16" prompt="请选择" data='{"list":[{"value":"1","key":"员工1","myFlag":"员工1-自定义属性"},{"value":"2","key":"员工2","myFlag":"员工2-自定义属性"}]}' ></select>
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset>
			<legend>16、数据无前缀</legend>
			<select prompt="请选择员工" data='[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"}]'></select>
	  </fieldset>
	  <div class="height_15"></div>
	  
	   
	   
	   
	   <fieldset> 
			<legend>17、浏览器原始下拉框</legend> 
			<select id="sel-15" keepDefaultStyle="true">
			    <option value="">请选择功能</option>
			    <option value="0">新增图片</option>
			    <option value="1">维护图片</option>
			    <option value="2">新增新闻</option>
			</select>
	   </fieldset>
	   <div class="height_15"></div>

	</div>


<script type="text/javascript">
	//动态设置data
	function initComplete(){
		var selData={"list":[{"value":"1","key":"员工1"},{"value":"2","key":"员工2"}]};
		//赋给data
		$("#sel-1-2").data("data",selData)
 		//刷新下拉框
 		 $("#sel-1-2").render(); 
		
		
		//获取json数据
		$.post("<%=path%>/form/getUserList.action",{"userinfor.organization.orgId":"3"},function(result){
			//赋给data
			$("#sel-1-3").data("data",result)
	 		//刷新下拉框
	 		 $("#sel-1-3").render(); 
		},"json");
		
		//绑定change事件
		$("#sel-4").bind("change",function(){
			if(!$(this).attr("relValue")){
		        top.Dialog.alert("没有选择节点");
		    }else{
		        top.Dialog.alert("选中节点文本："+$(this).attr("relText")+"<br/>选中节点值："+$(this).attr("relValue"));
		    }
		})
		
		//"市"下拉框加载数据完成后触发的操作
		$("#sel-9-5").bind("ajaxInit",function(){
	        $("#sel-9-6").render();
		});
		
		$("#sel-9-7").bind("change",function(){
	        $("#sel-9-8").render();
		});
		
		$("#sel-9-10").bind("ajaxInit",function(){
	        $("#sel-9-11").render();
		});
		
		$("#sel-9-13").bind("ajaxInit",function(){
	        $("#sel-9-14").render();
		});
		
		//数据自定义属性
		$("#sel-16").bind("change",function(){
			if(!$(this).attr("relValue")){
		        top.Dialog.alert("没有选择节点");
		    }else{
		        var node=$(this).data("selectedNode");
	            top.Dialog.alert(node.myFlag);
		    }
		})
	}
	
	
	 //获取选中项
	function getSelectedItem(){
		var value = $("#sel-1-1").val();
	    if(value){
	    	value += "（" + $("#sel-1-1").attr("relText") +"）";
	    }else{
	        value = "无";
	    }
		top.Dialog.alert(value);
	}
	
	//设为不可用
	function disableSelect(){
		$("#sel-3").attr("disabled",true);
		$("#sel-3").render();
	}
	//设为可用
	function enableSelect(){
	    $("#sel-3").attr("disabled",false);
		 $("#sel-3").render();
	}
	
    //onchange方法
	function onchangeHandler(obj){
	   top.Dialog.alert("您选择了：" + $(obj).val());
	}
    
    //获取"可编辑"下拉项的值
	function getEditableValue(){
		var text = $("#sel-7").attr("editValue");
		if(!text){
			text = $("#sel-7").attr("prompt");
		}
		top.Dialog.alert(text);
	}
    
 
	//动态生成下拉框
	function dynamicSelectbox1(){
		var $selbox = $('<select  prompt="请选择公司"></select>');
		$selbox.attr("url","<%=path%>/form/getDepartment.action?parentid=0");
		//将下拉框加到按钮的后面
		$("#testBtn").after($selbox);   
		$("#testBtn").after("<br/>"); 
		//渲染下拉框  
		$selbox.render();      
	}
	
	
	//动态生成下拉框
	function dynamicSelectbox2(){
		//获取json数据
		$.post("<%=path%>/form/getDepartment.action",{"parentid":"0"},function(result){
			var $selbox = $('<select  prompt="请选择部门"></select>');
			//赋给data属性
			$selbox.data("data",result);
			//将下拉框加到按钮的后面
			$("#testBtn2").after($selbox);   
			$("#testBtn2").after("<br/>");  
			//渲染下拉框 
			$selbox.render();      
		},"json");
	}
	//动态生成下拉框
	function dynamicSelectbox3(){
		var $selbox = $('<select><option value="0">请选择功能</option><option value="1" selected="selected">新增图片</option><option value="2">维护图片</option></select>');
		$("#testBtn3").after($selbox);   //将下拉框加到按钮的后面
		$("#testBtn3").after("<br/>");  
		$selbox.render();      //渲染下拉框
	}
	
	//json数据模式选择
	function selectSecondItem1(){
	    $("#sel-12-1").setValue("1");
	}
	//json数据模式追加一项
	function appendItem1(){
	   $("#sel-12-1").addItem({key: "新增项", value: "100"});
	   $("#sel-12-1").setValue("100");
	}
	//json数据模式移除选择项
	function removeItem1(){
		$("#sel-12-1").removeItem("2");
		 $("#sel-12-1").setValue("1");
	}
	
	
	//本地模式选择第二项
	function selectSecondItem2(){
	    $("#sel-12-2")[0].selectedIndex = 1;
	    $("#sel-12-2").render();
	}
	//本地模式追加一项
	function appendItem2(){
	    //使用[0]是为了将JQuery对象转化为HTML对象
	    var sel = $("#sel-12-2")[0];
	    var length = sel.options.length;
	    sel.options[length] = new Option("新增项" + length, length);
	    $("#sel-12-2").val(length);
	    $("#sel-12-2").render();
	}
	//本地模式移除选择项
	function removeItem2(){
		var sel = $("#sel-12-2")[0];
		sel.remove(sel.selectedIndex);
		 $("#sel-12-2").render();
	}
	
	
	
	//表单重置
	function resetForm(){
	    $("#form-14")[0].reset();
	    $("#form-14 select").resetValue(); 
	}
	
	


</script>

</body>
</html>