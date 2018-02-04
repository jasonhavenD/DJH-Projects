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


<!--树组件与弹窗组件（这里引入只为“非iframe弹窗（复杂内容）”示例需要） -->
<script type="text/javascript" src="<%=path%>/libs/js/tree/ztree/ztree.js"></script>
<link href="<%=path%>/libs/js/tree/ztree/ztree.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=path%>/libs/js/popup/drag.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/popup/dialog.js"></script>
<!--树组件与弹窗组件（这里引入只为“非iframe弹窗（复杂内容）”示例需要） -->
</head>
<body>
  <div style="display:none" id="content">这是指定容器的内容。</div>
  <div class="box1" panelWidth="800">
  	 <fieldset> 
     <legend>1、提示</legend>
		<input type="button" value="提示信息" onclick='top.Dialog.alert("这里是提示信息|标题",function(){alert("点击确定后的处理")});'/>
		<input type="button" value="提示自动关闭" onclick='top.Dialog.alert("这里是提示信息",null,null,null,2)'/>
		<input type="button" value="询问信息" onclick='top.Dialog.confirm("这里是询问信息",function(){top.Dialog.alert("点击了确定")},function(){top.Dialog.alert("点击了取消")});'/> 
	  
	  </fieldset>
	  <div class="height_15"></div>
	 
	  <fieldset> 
     <legend>2、基本功能</legend>
     	弹出窗口参数见文档。
     	<div class="height_10"></div>
		<input type="button" value="普通窗口" onclick='top.Dialog.open({URL:"<%=path%>/sample/popup/window-content1.jsp",Title:"普通窗口"});'/> 
		<input type="button" value="自定义宽高 " onclick='top.Dialog.open({URL:"<%=path%>/sample/popup/window-content1.jsp",Title:"自定义宽高 ",Width:800,Height:600});'/> 
		<input type="button" value="带说明栏的窗口" onclick='top.Dialog.open({MessageTitle:"这是标题",Message:"这是标题说明文字",Title:"带说明栏窗口",URL:"<%=path%>/sample/popup/window-content1.jsp"});'/> 
		<input type="button" value="无遮罩窗口" onclick='top.Dialog.open({URL:"<%=path%>/sample/popup/window-content1.jsp",Title:"无遮罩窗口",Modal:false});'/>
		<input type="button" value="最大化与最小化" onclick='top.Dialog.open({URL:"<%=path%>/sample/popup/window-content1.jsp",Title:"最大化与最小化",ShowMaxButton:true,ShowMinButton:true});'/>
		<div class="height_5"></div>
		<input type="button" value="初始时最大化" onclick='open11()'/> 
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
     <legend>3、额外功能</legend>
     	<input type="button" value="非iframe弹窗（简单内容）" onclick="openHtml();"/>
     	<input type="button" value="非iframe弹窗（复杂内容）" onclick="openComplex();"/>
     	<input type="button" value="指定弹出位置" onclick='top.Dialog.open({URL:"<%=path%>/sample/popup/window-content1.jsp",Top:"100%",Left:"100%",Modal:false,Width:240,Height:120,Title:"指定弹出位置"});'/> 
	  	<input type="button" value="自动关闭" onclick='top.Dialog.open({InnerHtml:"5秒后自动关闭",AutoClose:5,Title:"自动关闭"});'/> 
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset> 
     <legend>4、事件与方法</legend>
     	<input type="button" value="确定、取消、最大化、最小化、关闭事件" onclick='open1()'/>
     	<input type="button" value="更改按钮" onclick="open3()"/> 
     	<input type="button" value="创建新按钮" onclick="open4()"/> 
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset> 
     <legend>5、父页面刷新</legend>
     	方法1：
     	<div class="height_5"></div>
     	<input type="button" value="提交表单并刷新父页" onclick="open5()"/> 
     	<div class="height_5"></div>
此方法适合表单同步提交（页面跳转）的情况。
<div class="height_20"></div>
	方法2：使用按钮栏：<input type="button" value="手动关闭窗口并刷新页面1" onclick="open6()"/> 
<div class="height_20"></div>	
	方法3：不用按钮栏：<input type="button" value="手动关闭窗口并刷新页面2" onclick='top.Dialog.open({URL:"<%=path%>/sample/popup/window-content3.jsp",Title:"父窗口刷新"});'/> 
	<div class="height_5"></div>
	方法2和方法3适合表单异步提交或者无需表单提交的情况。
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
     <legend>6、手动关闭窗口</legend>
方法1：使用按钮栏
<div class="height_5"></div>
<input type="button" value="手动关闭窗口方法1" onclick="open7()"/> 	
<div class="height_20"></div>
方法2：不使用按钮栏
<div class="height_5"></div>
<input type="button" value="手动关闭窗口方法2" onclick='top.Dialog.open({URL:"<%=path%>/sample/popup/window-content4.jsp",Title:"手动关闭窗口方法2"});'/>
<div class="height_20"></div>
方法3：参见上面的“父页面刷新”的方法1。
<div class="height_20"></div>	
方法4：适合关闭特定的窗口。例如：	
<div class="height_5"></div>
<input type="button" value="打开第二个窗口关闭前一个窗口" onclick="open10()"/> 
	  </fieldset>
	  <div class="height_15"></div>
	  
	    <fieldset> 
     <legend>7、传值</legend>
<input type="button" value="本页面获取窗口页的值" onclick="open8()"/> <br/> <br/>
<input type="button" value="本页面调用窗口页方法" onclick="open9()"/> <br/> <br/>
<input type="button" value="窗口将值传给本页" onclick='top.Dialog.open({URL:"<%=path%>/sample/popup/window-content9.jsp",Title:"窗口将值传给页面"});'/> <span id="span1">窗口的值将传到这里</span> <br/> <br/>
<input type="button" value="窗口之间进行传值" onclick='top.Dialog.open({URL:"<%=path%>/sample/popup/window-content5.jsp",ID:"a1",Width:400,Height:300,Title:"第一个窗口"});'/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	   <fieldset> 
	   <legend>8、改变窗口样式</legend>
<input type="button" value="简洁风格" onclick='top.Dialog.open({URL:"<%=path%>/sample/popup/window-content1.jsp",Title:"简洁风格",Style:"simple",Modal:false,Width:350,Height:220});'/> <br/><br/>
<input type="button" value="简洁提示" onclick='top.Dialog.open({URL:"<%=path%>/sample/popup/window-content1.jsp",Title:"简洁提示",Style:"simpleTip",Modal:false,Width:350,Height:220});'/> <br/><br/>
<input type="button" value="阴影提示" onclick='top.Dialog.open({URL:"<%=path%>/sample/popup/window-content1.jsp",Title:"阴影提示",Style:"shadowTip",Modal:false,Width:330,Height:150,Top:"85%",Left:140});'/>（阴影提示窗口宽度至少要设为330） <br/><br/>
完全自定义外观：<br/>
<input type="button" value="仿百度贴吧新特性介绍" onclick="open12()"/> <br/>
	  </fieldset>
	  <div class="height_15"></div>
	  
    
	   <fieldset> 
	   <legend>9、任务栏管理</legend>
<input type="button" value="窗口1" onclick='top.Dialog.open({URL:"<%=path%>/sample/popup/window-content1.jsp",ID:"window1",Title:"窗口1",ShowMaxButton:true,ShowMinButton:true,MinToTask:true});'/>
<input type="button" value="窗口2" onclick='top.Dialog.open({URL:"<%=path%>/sample/popup/window-content1.jsp",ID:"window2",Title:"窗口2",ShowMaxButton:true,ShowMinButton:true,MinToTask:true});'/>
<input type="button" value="窗口3" onclick='top.Dialog.open({URL:"<%=path%>/sample/popup/window-content1.jsp",ID:"window3",Title:"窗口标题文字非常之长窗口文字非常之长",ShowMaxButton:true,ShowMinButton:true,MinToTask:true});'/>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset> 
	   <legend>10、自定义图标</legend>
<input type="button" value="与图标库结合" onclick='top.Dialog.open({URL:"<%=path%>/sample/popup/window-content1.jsp",Title:"与图标库结合",IconClass:"icon_list",Modal:false});'/>
<input type="button" value="自定义图标路径" onclick='top.Dialog.open({URL:"<%=path%>/sample/popup/window-content1.jsp",Title:"自定义图标路径",IconSrc:"<%=path%>/libs/images/icons/setting.png",Modal:false});'/>
<input type="button" value="无图标" onclick='top.Dialog.open({URL:"<%=path%>/sample/popup/window-content1.jsp",Title:"无图标",IconClass:"",Modal:false});'/>
	  </fieldset>
	  <div class="height_15"></div>
  </div>	
		



<script type="text/javascript">
	$(function(){
		top.Dialog.close()
	})
	function handler1(){
		top.Dialog.alert("点击了确定")
	}
	function open1(){
		var diag = new top.Dialog();
		diag.Title = "按钮点击事件";
		diag.ShowMaxButton=true;
		diag.ShowMinButton=true;
		diag.OKEvent = function(){
			alert("点击了确定")
			diag.close();
			};
		diag.CancelEvent = function(){
			alert("点击了取消");
			diag.close();
			};
		diag.MaxEvent = function(){
			alert("点击了最大化");
			};	
		diag.MinEvent = function(){
			alert("点击了最小化");
			};	
		diag.DecreaseEvent = function(){
			alert("点击了还原");
			};	
		diag.URL = "<%=path%>/sample/popup/window-content1.jsp";
		diag.ShowButtonRow=true;
		diag.show();
	}
	function open3(){
		var diag = new top.Dialog();
		diag.Title = "更改按钮";
		diag.URL = "<%=path%>/sample/popup/window-content1.jsp";
		diag.ShowButtonRow=true;
		diag.OkButtonText=" 提 交 ";
		diag.show();
	}
	function open4(){
		var diag = new top.Dialog();
		diag.Title = "创建其它按钮";
		diag.URL = "<%=path%>/sample/popup/window-content1.jsp";
		diag.show();
		diag.addButton("next"," 按 钮 ",function(){
			top.Dialog.alert("点击了创建的按钮")
		})
	}
	function open5(){
		var diag = new top.Dialog();
		diag.Title = "提交表单并刷新父页";
		diag.URL = "<%=path%>/sample/popup/window-content2.jsp";
		diag.show();
	}
	function open6(){
		var diag = new top.Dialog();
		diag.Title = "手动关闭窗口并刷新页面";
		diag.URL = "javascript:void(document.write('点击确定按钮'))";
		diag.ShowButtonRow=true;
		diag.OkButtonText=" 确 定 ";
		diag.OKEvent = function(){
			top.Dialog.alert("成功提交",function(){window.location.reload()})
			diag.close();
		};
		diag.show();
	}
	function open7(){
		var diag = new top.Dialog();
		diag.Title = "手动关闭窗口";
		diag.URL = "<%=path%>/sample/popup/window-content1.jsp";
		diag.ShowButtonRow=true;
		diag.ShowOkButton=false;
		diag.CancelButtonText=" 关 闭 ";
		diag.show();
	}
	
	function open8(){
		var diag = new top.Dialog();
		diag.Title = "得到输入值";
		diag.URL = "<%=path%>/sample/popup/window-content8.jsp";
		diag.OKEvent = function(){
			var inputValue = diag.innerFrame.contentWindow.document.getElementById('a').value;
			top.Dialog.alert(inputValue)
			diag.close();
			};
		diag.show();
	}
	
	function open9(){
		var diag = new top.Dialog();
		diag.Title = "调用窗口页方法";
		diag.URL = "<%=path%>/sample/popup/window-content10.jsp";
		diag.OKEvent = function(){
			var inputValue = diag.innerFrame.contentWindow.mytest();
			diag.close();
			};
		diag.show();
	}
	
	var firstDialog;
	function open10(){
		firstDialog = new top.Dialog();
		firstDialog.Title = "打开第二个窗口关闭本窗口";
		firstDialog.URL = "<%=path%>/sample/popup/window-content11.jsp";
		firstDialog.show();
	}
	function closeFirstDialog(){
		firstDialog.close();
	}
	
	function open11(){
		var diag = new top.Dialog();
		diag.Title = "初始时最大化";
		diag.URL = "<%=path%>/sample/popup/window-content1.jsp";
		diag.ShowMaxButton=true;
		diag.ShowMinButton=true;
		diag.show();
		diag.max();
	}
	
	function open12(){
		//打开窗口
		var diag = new Dialog();
		diag.Style="custom";
		diag.InnerHtml= "";
		diag.ID="c2";
		diag.Width=386;
		diag.Height=193;
		diag.show();
		
		
		//构建自定义内容
		var $content=$('<div style="position:relative;"><img src="<%=path%>/libs/images/demo/popup1.png"/></div>');
		var $next=$('<img src="<%=path%>/libs/images/icons/click.gif" class="hand" style="width:100px;height:30px;position:absolute;top:140px;left:120px;"/>');
		var $close=$('<img src="<%=path%>/libs/images/icons/click.gif" class="hand" style="width:30px;height:30px;position:absolute;top:0px;left:280px;"/>');
		$content.prepend($next);
		$content.prepend($close);
		//内容添加到窗口
		var $container=$(document.getElementById("_Container_c2"));
		$container.append($content);
		
		//点击关闭
		$close.click(function(){
			diag.close();
		});
		//点击下一步
		$next.click(function(){
			//关闭当前
			diag.close();
			
			//打开新窗口
			var diag2 = new Dialog();
			diag2.Style="custom";
			diag2.InnerHtml= "";
			diag2.ID="c3";
			diag2.Width=467;
			diag2.Height=399;
			diag2.show();
			
			//构建自定义内容
			var $content2=$('<div style="position:relative;"><img src="<%=path%>/libs/images/demo/popup2.png"/></div>');
			var $next2=$('<img src="<%=path%>/libs/images/icons/click.gif" class="hand" style="width:100px;height:30px;position:absolute;top:355px;left:130px;"/>');
			var $close2=$('<img src="<%=path%>/libs/images/icons/click.gif" class="hand" style="width:30px;height:30px;position:absolute;top:218px;left:310px;"/>');
			$content2.prepend($next2);
			$content2.prepend($close2);
			
			//内容添加到新窗口
			var $container2=$(document.getElementById("_Container_c3"));
			$container2.append($content2);
			
			//点击关闭
			$close2.click(function(){
				diag2.close();
			});
			$next2.click(function(){
				diag2.close();
			});
		});
	}
	
	function openHtml(){
		top.Dialog.open({
		  InnerHtml: $("#content").html(),//这里还可以直接写html代码
		  Title:"普通窗口"
		});
	}
	var nodes1 = [
		{ id:1,  parentId:0, name:"中国(默认展开)", open: true},
		{ id:11, parentId:1, name:"北京"},
		{ id:12, parentId:1, name:"南京"},
		{ id:13, parentId:1, name:"湖北"},
		{ id:2,  parentId:0, name:"美国(折叠)"},
		{ id:21, parentId:2, name:"纽约"},
		{ id:22, parentId:2, name:"波士顿"},
		{ id:23, parentId:2, name:"芝加哥"}
	];
	var setting1 = {
		callback: {
			onClick: onNodeClick1
		}
	};	
	 function onNodeClick1(event, treeId, treeNode){
	   alert(treeNode.name)
    }  
	function openComplex(){
		Dialog.open({
		  InnerHtml: "",
		  Title:"普通窗口",
		  ID:"c1",
		  Width:240,
		  Height:300
		});
		var $container=$(document.getElementById("_Container_c1"));
		var $tree=$(' <ul id="tree-1" class="ztree"></ul>');
		$.fn.zTree.init($tree, setting1, nodes1);
		$container.append($tree)
	}
</script>
</body>
</html>