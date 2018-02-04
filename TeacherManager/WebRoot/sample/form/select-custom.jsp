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

<!-- 组合下拉框start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/selectCustom.js"></script>
<!-- 组合拉框end -->

<!--数据表格start-->
<script src="<%=path%>/libs/js/table/quiGrid.js" type="text/javascript"></script>
<!--数据表格end-->

<!--记忆表格选中处理-示例3start-->
<script type="text/javascript" src="<%=path%>/sample/form/checkMemory1.js"></script>
<!--记忆表格选中处理-示例3end-->

<!--记忆表格选中处理-示例4start-->
<script type="text/javascript" src="<%=path%>/sample/form/checkMemory2.js"></script>
<!--记忆表格选中处理-示例4end-->

<!-- 双向选择器start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/lister.js"></script>
<!-- 双向选择器end -->
 
<!-- 条件过滤器 start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/filter.js"></script>
<!-- 条件过滤器 end -->
</head>
<body>
	<div class="box1" panelWidth="800">
	 <fieldset>
      	<legend>注意</legend>
组合下拉框理论上可以弹出任何控件。<br/>
	默认为单选模式，监听控件选择/点击事件，选中后需要手工赋值，赋值后自动关闭。<br/>
	多选模式（multiMode）下选择后点击空白处关闭，监听此时的关闭事件进行赋值。<br/> 
	其他很多特性继承了树形下拉框，这些示例与“树形下拉框”用法类似：使用隐藏域、禁用/启用、宽度、自定义尺寸（下拉框宽度和高度、文本框宽度），下拉框展开方向，可编辑、动态生成，请参考“树形下拉框”一节。
      </fieldset>
      <div class="height_15"></div>
	
	<fieldset>
     	<legend>1、与单选表格组合</legend>
     	 <div class="red">此示例由后台支持</div>
     	 <div class="selectCustom" boxWidth="500" id="selectCostom1">
			<div id="customContent1" ></div>
		</div>
		<br/><input type="button" value="获取值" onclick="getValue1()"/> 
   	</fieldset>
   	<div class="height_15"></div>
   	
   	<fieldset>
     	<legend>2、与单选表格组合-初始赋值</legend>
     	<div class="red">此示例由后台支持</div>
     	 <div class="selectCustom" boxWidth="500" id="selectCostom2">
			<div id="customContent2" ></div>
		</div>
		<br/><input type="button" value="获取值" onclick="getValue2()"/> 
		<br/>
   	</fieldset>
   	<div class="height_15"></div>
   	
   	<fieldset>
     	<legend>3、与多选表格组合</legend>
     	 <div class="red">此示例由后台支持</div>
     	 <div class="selectCustom" boxWidth="500" multiMode="true" id="selectCostom3">
			<div id="customContent3" ></div>
		</div>
		<br/><input type="button" value="获取值" onclick="getValue3()"/> 
   	</fieldset>
   	<div class="height_15"></div>
   	
   	<fieldset>
     	<legend>4、与多选表格组合-初始赋值</legend>
     	 <div class="red">此示例由后台支持</div>
     	 <div class="selectCustom" boxWidth="500" multiMode="true" id="selectCostom4">
			<div id="customContent4" ></div>
		</div>
		<br/><input type="button" value="获取值" onclick="getValue4()"/> 
   	</fieldset>
   	<div class="height_15"></div>
   	
   	
   	<fieldset>
     	<legend>5、下拉内容为图片</legend>
     	 <div class="selectCustom" boxWidth="380" prompt="请选择一种格式" id="selectCostom5">
			<div id="customContent5" style="padding:0 0 10px 10px;">
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
		<br/><input type="button" value="获取值" onclick="getValue5()"/> 
   	</fieldset>
   	<div class="height_15"></div>
   	
   	<fieldset>
     	<legend>6、与双选器组合</legend>
     	 <div class="red">此示例由后台支持</div>
     	 <div class="selectCustom" boxWidth="500" multiMode="true" id="selectCostom6">
			<div id="customContent6" style="padding:10px 0 10px 10px;">
			<div class="lister" keepDefaultStyle="true" id="lister1" url="<%=path%>/form/getUsersOfDoubleSelect.action"></div>
			</div>
		</div>
		<br/><input type="button" value="获取值" onclick="getValue6()"/> 
   	</fieldset>
   	<div class="height_15"></div>
   	
   	<fieldset>
     	<legend>7、与条件过滤器组合</legend>
     	 <div class="red">此示例由后台支持</div>
     	 <div class="selectCustom" boxWidth="500" multiMode="true" id="selectCostom7">
			<div id="customContent7" style="padding:10px 0 10px 10px;">
			<div class="filter" id="filter1" keepDefaultStyle="true"  groupMode="true" data='{"list":[{"name":"部门1","list":[{"key":"员工1","value":"11","iconClass":"icon_user"},{"key":"员工2","value":"12","iconClass":"icon_user"},{"key":"员工3","value":"13","iconClass":"icon_user_female"},{"key":"员工2","value":"12","iconClass":"icon_user"},{"key":"员工3","value":"13","iconClass":"icon_user"}]},{"name":"部门2","list":[{"key":"员工4","value":"21","iconClass":"icon_user_female"},{"key":"员工5","value":"22","iconClass":"icon_user"},{"key":"员工6","value":"23","iconClass":"icon_user_worker"}]},{"name":"部门3","list":[{"key":"员工1","value":"11","iconClass":"icon_user"},{"key":"员工2","value":"12","iconClass":"icon_user"},{"key":"员工3","value":"13","iconClass":"icon_user"},{"key":"员工2","value":"12","iconClass":"icon_user"},{"key":"员工3","value":"13","iconClass":"icon_user"}]},{"name":"部门4","list":[{"key":"员工4","value":"21","iconClass":"icon_user"},{"key":"员工5","value":"22","iconClass":"icon_user"},{"key":"员工6","value":"23","iconClass":"icon_user"}]}]}' id="filter13"></div>
			<!--
			<div class="filter" keepDefaultStyle="true" id="filter1" url="<%=path%>/form/getUserList.action" multiMode="true"></div>
			-->
			</div>
		</div>
		<br/><input type="button" value="获取值" onclick="getValue7()"/> 
   	</fieldset>
   	<div class="height_15"></div>
   	
	<fieldset>
     	<legend>8、表格即时查询选中</legend>
     	 <div class="red">此示例由后台支持</div>
     	 <div class="selectCustom" boxWidth="500" id="selectCostom8">
			<div>
			<table>
				<tr>
					<td>姓名：</td>
					<td><input type="text" class="textinput" id="searchInput"/></td>
				</tr>
			</table>
			
			</div>
			<div id="customContent8" ></div>
		</div>
		<br/><input type="button" value="获取值" onclick="getValue8()"/> 
   	</fieldset>
   	<div class="height_15"></div>
   	
   	
   		<fieldset>
     	<legend>9、下拉框重置</legend>
     	<form id="form-9">
     	 <div class="selectCustom" boxWidth="500" multiMode="true" id="selectCostom9">
			<div id="customContent9" style="padding:10px 0 10px 10px;">
				<div class="lister" keepDefaultStyle="true" id="lister2" url="<%=path%>/form/getUserList.action"></div>
			</div>
		</div>
		<br/><input type="button" value="获取值" onclick="getValue9()"/> &nbsp;&nbsp;<input type="button" value="重置"  onclick="resetValue9()"/> 
		</form>
   	</fieldset>
   	<div class="height_15"></div>
   	
	</div>
<script type="text/javascript">
       //var testData={"pager.totalRows":19,"sort":"userName","rows":[{"orgName":"财务部","userEducation":"专科","userEmployTime":"2012-09-04","userId":15,"userLoginName":"zhuguan","userName":"财务部主管","userPassword":"123456","userSex":"女"},{"orgName":"南京分公司","userEducation":"专科","userEmployTime":"2012-09-03","userId":2,"userLoginName":"guest","userName":"访客","userPassword":"123456","userSex":"男"},{"orgName":"行政部","userEducation":"专科","userEmployTime":"2012-09-04","userId":16,"userLoginName":"fuzeren","userName":"行政部负责人","userPassword":"123456","userSex":"男"},{"orgName":"市场部","userEducation":"专科","userEmployTime":"2012-09-12","userId":14,"userLoginName":"jingli","userName":"市场部经理","userPassword":"123456","userSex":"男"},{"orgName":"市场1组","userEducation":"本科","userEmployTime":"2012-07-24","userId":1,"userLoginName":"chen","userName":"小陈","userPassword":"123456","userSex":"男"}],"direction":"desc","pager.pageNo":1}
       
        var g1;
        var g2;
        var g3;
        var g4;
        var g5;
		function initComplete(){
			 //示例1相关
			 g1 = $("#customContent1").quiGrid({
                columns: [ 
	                { display: '姓名', name: 'userName', align: 'center',  width: "30%"},
	                { display: '性别', name: 'userSex', align: 'center' , width: "20%"},
	                { display: '部门', name: 'orgName',  align: 'center' , width: "30%"},
	                { display: '学历', name: 'userEducation',  align: 'center', width: "20%" }
                ], url:"<%=path%>/getUsersOfPager.action", pageSize: 5, rownumbers:true, checkbox:false,percentWidthMode:true,
                height: '300', width:"500",showPageInfo:false,onSelectRow:onSelectRowHandler
            });
             $("#selectCostom1").bind("boxOpen",function(){
            	g1.resetHeight();
            	g1.resetWidth();
            })
            
             //示例2相关
			 g2 = $("#customContent2").quiGrid({
                columns: [ 
	                { display: '姓名', name: 'userName', align: 'center',  width: "30%"},
	                { display: '性别', name: 'userSex', align: 'center' , width: "20%"},
	                { display: '部门', name: 'orgName',  align: 'center' , width: "30%"},
	                { display: '学历', name: 'userEducation',  align: 'center', width: "20%" }
                ], url:"<%=path%>/getUsersOfPager.action", pageSize: 5, rownumbers:true, checkbox:false,percentWidthMode:true,
                height: '300', width:"500",showPageInfo:false,onSelectRow:onSelectRowHandler2
            });
             $("#selectCostom2").bind("boxOpen",function(){
            	g2.resetHeight();
            	g2.resetWidth();
            })
             $("#selectCostom2").setValue(16,"部门负责人");
             
            
            
            
            //示例3相关
            g3 = $("#customContent3").quiGrid({
                columns: [ 
	                { display: '姓名', name: 'userName', align: 'center',  width: "30%"},
	                { display: '性别', name: 'userSex', align: 'center' , width: "20%"},
	                { display: '部门', name: 'orgName',  align: 'center' , width: "30%"},
	                { display: '学历', name: 'userEducation',  align: 'center', width: "20%" }
                ], url:"<%=path%>/getUsersOfPager.action", pageSize: 5, rownumbers:true, checkbox:true,percentWidthMode:true,
                height: '300', width:"500",showPageInfo:false,selectRowButtonOnly:false,
                isChecked:checkedHandler,onCheckRow: checkRowHandler, onCheckAllRow: checkAllRowHandler
            });
             $("#selectCostom3").bind("boxOpen",function(){
            	g3.resetHeight();
            	g3.resetWidth();
            })
            $("#selectCostom3").bind("boxClose",function(){
            	$("#selectCostom3").setValue(checkedArray.join(","),checkedTextArray.join(","));
            })
            
            //示例4相关
            g4 = $("#customContent4").quiGrid({
                columns: [ 
	                { display: '姓名', name: 'userName', align: 'center',  width: "30%"},
	                { display: '性别', name: 'userSex', align: 'center' , width: "20%"},
	                { display: '部门', name: 'orgName',  align: 'center' , width: "30%"},
	                { display: '学历', name: 'userEducation',  align: 'center', width: "20%" }
                ], url:"<%=path%>/getUsersOfPager.action", pageSize: 5, rownumbers:true, checkbox:true,percentWidthMode:true,
                height: '300', width:"500",showPageInfo:false,selectRowButtonOnly:false,
                isChecked:checkedHandler2,onCheckRow: checkRowHandler2, onCheckAllRow: checkAllRowHandler2
            });
             $("#selectCostom4").setValue(checkedArray2.join(","),checkedTextArray2.join(","));
             $("#selectCostom4").bind("boxOpen",function(){
            	g4.resetHeight();
            	g4.resetWidth();
            })
            $("#selectCostom4").bind("boxClose",function(){
            	$("#selectCostom4").setValue(checkedArray2.join(","),checkedTextArray2.join(","));
            })
            
            //示例5相关	
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
            
             //示例6相关	
            $("#lister1").render();
            $("#selectCostom6").bind("boxClose",function(){
            	$("#selectCostom6").setValue($("#lister1").attr("relValue"),$("#lister1").attr("relText"));
            })
            
             //示例7相关	
            $("#filter1").render();
            $("#selectCostom7").bind("boxClose",function(){
            	$("#selectCostom7").setValue($("#filter1").attr("relValue"),$("#filter1").attr("relText"));
            })
            
            //示例8相关
			 g5 = $("#customContent8").quiGrid({
                columns: [ 
	                { display: '姓名', name: 'userName', align: 'center',  width: "30%"},
	                { display: '性别', name: 'userSex', align: 'center' , width: "20%"},
	                { display: '部门', name: 'orgName',  align: 'center' , width: "30%"},
	                { display: '学历', name: 'userEducation',  align: 'center', width: "20%" }
                ], url:"<%=path%>/getUsersOfPager.action", pageSize: 5, rownumbers:true, checkbox:false,percentWidthMode:true,
                height: '300', width:"500",showPageInfo:false,onSelectRow:onSelectRowHandler3
            });
             $("#selectCostom8").bind("boxOpen",function(){
            	g5.resetHeight();
            	g5.resetWidth();
            })
            
            $("#searchInput").keyup(function(event){
		        event = window.event || event;
		        var keyCode = event.keyCode || event.which || event.charCode;        
		        if(keyCode != 13 && keyCode != 37 && keyCode != 39 && keyCode !=9 && keyCode !=38 && keyCode !=40 ){
				    //keyCode == 9是tab切换键
		            //每次输入时查询结果
					queryGrid($(this).val()); 
		        }
		    });	
		    
		     //示例9相关	
            $("#lister2").render();
            $("#selectCostom9").bind("boxClose",function(){
            	$("#selectCostom9").setValue($("#lister2").attr("relValue"),$("#lister2").attr("relText"));
            })
		}
		
		//示例1相关
        function onSelectRowHandler(){
        	var row=g1.getSelectedRow();
        	 $("#selectCostom1").setValue(row.userId,row.userName);
        }
        function getValue1(){
        	top.Dialog.alert("选中文本："+$("#selectCostom1").attr("relText")+"<br/>选中id："+$("#selectCostom1").attr("relValue"));
        }
        
        //示例2相关
         function onSelectRowHandler2(){
        	var row=g2.getSelectedRow();
        	 $("#selectCostom2").setValue(row.userId,row.userName);
        }
        function getValue2(){
        	top.Dialog.alert("选中文本："+$("#selectCostom2").attr("relText")+"<br/>选中id："+$("#selectCostom2").attr("relValue"));
        }
        
        //示例3相关
         function getValue3(){
        	top.Dialog.alert("选中文本："+$("#selectCostom3").attr("relText")+"<br/>选中id："+$("#selectCostom3").attr("relValue"));
        }
        
        //示例4相关
         var checkedArray2 = [15,16,11];
        var checkedTextArray2 = ["财务部主管","行政部负责人","小郑"];
         function getValue4(){
        	top.Dialog.alert("选中文本："+$("#selectCostom4").attr("relText")+"<br/>选中id："+$("#selectCostom4").attr("relValue"));
        }
        
        //示例5相关
         function getValue5(){
        	top.Dialog.alert("选中文本："+$("#selectCostom5").attr("relText")+"<br/>选中id："+$("#selectCostom5").attr("relValue"));
        }
        
        //示例6相关
         function getValue6(){
        	top.Dialog.alert("选中文本："+$("#selectCostom6").attr("relText")+"<br/>选中id："+$("#selectCostom6").attr("relValue"));
        }
        
        //示例7相关
         function getValue7(){
        	top.Dialog.alert("选中文本："+$("#selectCostom7").attr("relText")+"<br/>选中id："+$("#selectCostom7").attr("relValue"));
        }
        
        //示例8相关
        function onSelectRowHandler3(){
        	var row=g5.getSelectedRow();
        	 $("#selectCostom8").setValue(row.userId,row.userName);
        }
        function getValue8(){
        	top.Dialog.alert("选中文本："+$("#selectCostom8").attr("relText")+"<br/>选中id："+$("#selectCostom8").attr("relValue"));
        }
        function queryGrid(value){
        	var query=[{name:"userinfor.userName",value:""}];
        	query[0].value=value;
        	g5.setOptions({ params : query});
		    g5.setNewPage(1);
		    g5.loadData();
        }
        
        
        //示例9相关
         function getValue9(){
        	top.Dialog.alert("选中文本："+$("#selectCostom9").attr("relText")+"<br/>选中id："+$("#selectCostom9").attr("relValue"));
        	
        }
        function resetValue9(){
        	$("#selectCostom9").setValue("","请选择");
        	$("#lister2").removeData("data");
        	$("#lister2").resetValue()
        }
    </script>	
</body>
</html>