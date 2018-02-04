<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>树的基本使用</title>
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!--树组件start -->
<script type="text/javascript" src="<%=path%>/libs/js/tree/ztree/ztree.js"></script>
<link href="<%=path%>/libs/js/tree/ztree/ztree.css" rel="stylesheet" type="text/css"/>
<!--树组件end -->

</head>
<body>
  <div class="box1" panelWidth="800">
     
      <fieldset>
          <legend>注意</legend>
          <p>树默认是双击展开/折叠的。<br/>
          树节点是本身按需创建的，不展开不创建。所以一次获取所有数据的话速度也是很快的。<br/>
          在框架中的树组件与原版在树的默认配置方面不太一致，例如：simpleData的配置默认为启用，pIdKey键的值为parentId，title键的值为title，并且为异步加载添加了dataName属性。使用时请注意这一点。<br/>
         使用时可以参考本框架的API手册中的参数表，也可参看官方的示例和手册。 <br/>
          在本框架的source目录下的“常用文档”目录有该控件的官方示例和使用手册。
          </p>
      </fieldset>
      <div class="height_15"></div>
      
      <fieldset>
          <legend>1、基本使用(本地数据源)</legend>
          <div>
			  <ul id="tree-1" class="ztree"></ul>
		  </div>
      </fieldset>
      <div class="height_15"></div>
      
      <fieldset>
          <legend>2、远程数据源（JSON）</legend>
          <div class="red">此示例由后台支持</div>
          <div>
			  <ul id="tree-2" class="ztree"></ul>
		  </div>
      </fieldset>
      <div class="height_15"></div>
      
      <fieldset>
          <legend>3、点击节点时的动作</legend>
          <div>
			  <ul id="tree-3" class="ztree"></ul>
		  </div>
      </fieldset>
      <div class="height_15"></div>
      
      <fieldset>
          <legend>4、自定义节点提示信息</legend>
          <div>
			  <ul id="tree-4" class="ztree"></ul>
		  </div>
      </fieldset>
      <div class="height_15"></div>
      
      <fieldset>
          <legend>5、自定义图标</legend>
          <div>
			  <ul id="tree-5" class="ztree"></ul>
		  </div>
      </fieldset>
      <div class="height_15"></div>
      
      <fieldset>
          <legend>6、自定义展开/收缩图标</legend>
          <div>
			  <ul id="tree-6" class="ztree"></ul>
		  </div>
      </fieldset>
      <div class="height_15"></div>
      
      <fieldset>
          <legend>7、设置节点文字样式</legend>
          <div>
			  <ul id="tree-7" class="ztree"></ul>
		  </div>
      </fieldset>
      <div class="height_15"></div>
      
      <fieldset>
          <legend>8、不显示连线</legend>
          <div>
			  <ul id="tree-8" class="ztree"></ul>
		  </div>
      </fieldset>
      <div class="height_15"></div>
      
      <fieldset>
          <legend>9、不显示节点图标</legend>
          <div>
			  <ul id="tree-9" class="ztree"></ul>
		  </div>
      </fieldset>
      <div class="height_15"></div>
      
      
      <fieldset>
          <legend>10、单击打开树节点</legend>
          <div>
			  <ul id="tree-10" class="ztree"></ul>
		  </div>
      </fieldset>
      <div class="height_15"></div>
      
      <fieldset>
          <legend>11、事件控制</legend>
          <span>事件日志</span>
          <textarea id="log11" resize="true" readonly="readonly" style="height:170px; width:300px;"></textarea>
          <input type="button" value="清除日志" onclick="$('#log11').val('')"/>
          <div>
			  <ul id="tree-11" class="ztree"></ul>
		  </div>
      </fieldset>
      <div class="height_15"></div>
      
      <fieldset>
          <legend>12、根据参数查找节点</legend>
          <div>
			  <ul id="tree-12" class="ztree"></ul>
		  </div>
		  <p>精确查询 getNodeByParam / getNodesByParam：<br />
		    <input type="button" value="选择id=11(员工1)" onclick="getNodeByParam('id', '11')"/>
		  	<input type="button" value="选择id=21(员工4)" onclick="getNodeByParam('id', '21')"/>
		  </p>
		  <p>模糊查询 getNodesByParamFuzzy ：<br />
		    <input type="button" value="name含有‘员工’的" onclick="getNodesByParamFuzzy('name', '员工')"/>
		    <input type="button" value="name含有‘部门’的" onclick="getNodesByParamFuzzy('name', '部门')"/>
		  </p>
      </fieldset>
  
  </div>

<script type="text/javascript">

	var nodes1 = [
		{ id:1,  parentId:0, name:"部门1(默认为折叠)"},
		{ id:11, parentId:1, name:"员工1"},
		{ id:12, parentId:1, name:"员工2"},
		{ id:13, parentId:1, name:"员工3"},
		{ id:2,  parentId:0, name:"部门2(设置为展开)", open: true},
		{ id:21, parentId:2, name:"员工4"},
		{ id:22, parentId:2, name:"员工5"},
		{ id:23, parentId:2, name:"员工6"},
		{ id:24, parentId:0, name:"部门3(强制显示为父节点样子)", isParent:true}
	];
	
	 var nodes3 = [
		{ id:1,  parentId:0, name:"部门1", open: true},
		{ id:11, parentId:1, name:"员工1(新窗口打开链接)",url:"http://www.baidu.net",target:"_blank"},
		{ id:12, parentId:1, name:"员工2(调用JS方法)",click:"clickNode();"},
		{ id:13, parentId:1, name:"员工3(本页打开链接)",url:"http://www.baidu.net",target:"frmright"},
		{ id:2,  parentId:0, name:"部门2", open: true},
		{ id:21, parentId:2, name:"员工4"},
		{ id:22, parentId:2, name:"员工5"},
		{ id:23, parentId:2, name:"员工6"}
	];
	
	
	var nodes4 = [
		{ id:1,  parentId:0, name:"部门1", open: true},
		{ id:11, parentId:1, name:"员工1",title:"表现优秀员工"},
		{ id:12, parentId:1, name:"员工2",title:"表现一般员工"},
		{ id:13, parentId:1, name:"员工3",title:"表现很差员工"},
		{ id:2,  parentId:0, name:"部门2", open: true},
		{ id:11, parentId:2, name:"员工4",title:"表现优秀员工"},
		{ id:12, parentId:2, name:"员工5",title:"表现一般员工"},
		{ id:13, parentId:2, name:"员工6",title:"表现很差员工"}
	];
	
	var nodes5 = [
		{ id:1, parentId:0, name:"部门1", open: true,icon:"<%=path%>/libs/icons/user_group.gif"},
		{ id:11, parentId:1, name:"男员工",icon:"<%=path%>/libs/icons/user.gif"},
		{ id:12, parentId:1, name:"女员工",icon:"<%=path%>/libs/icons/user_female.gif"},
		{ id:13, parentId:1, name:"外勤员工",icon:"<%=path%>/libs/icons/user_worker.gif"},
		{ id:2, parentId:0, name:"部门2", open: true,icon:"<%=path%>/libs/icons/user_group.gif"},
		{ id:21, parentId:2, name:"离线员工",icon:"<%=path%>/libs/icons/user_off.gif"}
	];
	
	var nodes6 = [
		{ id:1,  parentId:0, name:"部门1",iconOpen:"<%=path%>/libs/icons/folderopen.gif",iconClose:"<%=path%>/libs/icons/folderclosed.gif"},
		{ id:11, parentId:1, name:"员工1",icon:"<%=path%>/libs/icons/leaf.gif"},
		{ id:12, parentId:1, name:"员工2",icon:"<%=path%>/libs/icons/leaf.gif"},
		{ id:13, parentId:1, name:"员工3",icon:"<%=path%>/libs/icons/leaf.gif"},
		{ id:2,  parentId:0, name:"部门2",iconOpen:"<%=path%>/libs/icons/folderopen.gif",iconClose:"<%=path%>/libs/icons/folderclosed.gif"},
		{ id:21, parentId:2, name:"员工4",icon:"<%=path%>/libs/icons/leaf.gif"},
		{ id:22, parentId:2, name:"员工5",icon:"<%=path%>/libs/icons/leaf.gif"},
		{ id:23, parentId:2, name:"员工6",icon:"<%=path%>/libs/icons/leaf.gif"}
	];
	
	var setting7 = {
		view: {
			fontCss: getNodeFont,
			nameIsHTML: true
		}
	};
	
	var nodes7 = [
		{ name:"粗体字", font:{'font-weight':'bold'} },
		{ name:"斜体字", font:{'font-style':'italic'}},
		{ name:"有背景的字", font:{'background-color':'black', 'color':'white'}},
		{ name:"红色字", font:{'color':'red'}},
		{ name:"蓝色字", font:{'color':'blue'}},
		{ name:"<span style='color:blue;margin-right:0px;'>view</span>.<span style='color:red;margin-right:0px;'>nameIsHTML</span>"},
		{ name:"默认样式"}
	];
	
	function getNodeFont(treeId, node) {
		return node.font ? node.font : {};
	}
	
	var setting8 = {
		view: {
			showLine: false
		}
	};
	
	var setting9 = {
		view: {
			showIcon: false
		}
	};
	
	var setting10 = {
		view: {
			dblClickExpand: false
		},
		callback: {
			onClick: onNodeClick10
		}
	};	
	
	var nodes10 = [
		{ id:1,  parentId:0, name:"部门1"},
		{ id:11, parentId:1, name:"员工1"},
		{ id:12, parentId:1, name:"员工2"},
		{ id:13, parentId:1, name:"员工3"},
		{ id:2,  parentId:0, name:"部门2"},
		{ id:21, parentId:2, name:"员工4"},
		{ id:22, parentId:2, name:"员工5"},
		{ id:23, parentId:2, name:"员工6"}
	];
	
	var setting11 = {
	    callback: {
			beforeClick: beforeClick11,
			beforeRightClick: beforeRightClick11,
			beforeMouseDown: beforeMouseDown11,
			beforeMouseUp: beforeMouseUp11,
			beforeExpand: beforeExpand11,
			beforeCollapse: beforeCollapse11,
			onNodeCreated: onNodeCreated11,
			onClick: onClick11,
			onRightClick: onRightClick11,
			onMouseDown: onMouseDown11,
			onMouseUp: onMouseUp11,
			onExpand: onExpand11,
			onCollapse: onCollapse11
		}
	};
	
	
	var setting12 = {
	    view: {
	        //此目的是为了将查询出的树节点高亮显示 实际项目中可以不用
			fontCss: getFontCss12
		}
	}
	
    function initComplete(){
        //本地数据源
		$.fn.zTree.init($("#tree-1"), {}, nodes1);
		
		//远程JSON数据源
		$.post("<%=path%>/getDepartmentsTree.action", {}, function(result){
			//此处返回的是treeNodes
			$.fn.zTree.init($("#tree-2"), {}, result.treeNodes);
		}, "json");
		
		$.fn.zTree.init($("#tree-3"), {}, nodes3);
		
		//节点提示信息
		$.fn.zTree.init($("#tree-4"), {}, nodes4);
		
		//自定义图标
		$.fn.zTree.init($("#tree-5"), {}, nodes5);
		
		//自定义展开/收缩图标
		$.fn.zTree.init($("#tree-6"), {}, nodes6);
		
		//节点文字样式
		$.fn.zTree.init($("#tree-7"), setting7, nodes7);
		
		//不显示连线
		$.fn.zTree.init($("#tree-8"), setting8, nodes5);
		
		//不显示图标
		$.fn.zTree.init($("#tree-9"), setting9, nodes5);
		
		//单击展开
		$.fn.zTree.init($("#tree-10"), setting10, nodes10);
		
		//事件控制
		$.fn.zTree.init($("#tree-11"), setting11, nodes10);
		
		//模糊查找
		$.fn.zTree.init($("#tree-12"), setting12, nodes10);
    }
    
    //点击节点触发函数
    function clickNode(){
        top.Dialog.alert('我被点击了...');
    }
    
    //单击展开节点
    function onNodeClick10(event, treeId, treeNode){
	    var zTree = $.fn.zTree.getZTreeObj("tree-10");
		zTree.expandNode(treeNode);
    }  
    
	function beforeClick11(treeId, treeNode, clickFlag){
	    appendToLog11("beforeClick", treeNode.id, treeNode.name);
	}
	
	function beforeRightClick11(treeId, treeNode){
	    appendToLog11("beforeRightClick", treeNode.id, treeNode.name);
	}
	
	//当鼠标没点击在节点上时(如，单击＋号展开节点)，treeNode为空
	function beforeMouseDown11(treeId, treeNode){
	    if(null != treeNode){
			appendToLog11("beforeMouseDown", treeNode.id, treeNode.name);
		}else{
		    appendToLog11("beforeMouseDown", '', '');
		}
	}
	
	//当鼠标没点击在节点上时(如，单击＋号展开节点)，treeNode为空
	function beforeMouseUp11(treeId, treeNode){
	    if(null != treeNode){
			appendToLog11("beforeMouseUp", treeNode.id, treeNode.name);
		}else{
		    appendToLog11("beforeMouseUp", '', '');
		}
	}
	
	function beforeExpand11(treeId, treeNode){
	    appendToLog11("beforeExpand", treeNode.id, treeNode.name);
	}
	
	function beforeCollapse11(treeId, treeNode){
	    appendToLog11("beforeCollapse", treeNode.id, treeNode.name);
	}
	
	function onNodeCreated11(event, treeId, treeNode){
		appendToLog11("onNodeCreated", treeNode.id, treeNode.name);
	}
	
	function onClick11(event, treeId, treeNode, clickFlag){
		appendToLog11("onClick", treeNode.id, treeNode.name);
	}
	
	function onRightClick11(event, treeId, treeNode){
		appendToLog11("onRightClick", treeNode.id, treeNode.name);
	}
	
	//当鼠标没点击在节点上时，treeNode为空
	function onMouseDown11(event, treeId, treeNode){
	    if(null != treeNode){
			appendToLog11("onMouseDown", treeNode.id, treeNode.name);
		}else{
		    appendToLog11("onMouseDown", '', '');
		}
	}
	
	//当鼠标没点击在节点上时(如，单击＋号展开节点)，treeNode为空
	function onMouseUp11(event, treeId, treeNode){
	    if(null != treeNode){
		     appendToLog11("onMouseUp", treeNode.id, treeNode.name);
		}else{
		     appendToLog11("onMouseDown", '', '');
		}
	}
	
	function onExpand11(event, treeId, treeNode){
		appendToLog11("onExpand", treeNode.id, treeNode.name);
	}
	
	function onCollapse11(event, treeId, treeNode){
		appendToLog11("onCollapse", treeNode.id, treeNode.name);
	}
	
	//追加日志信息
	function appendToLog11(eventName, nodeId, nodeName){
	    $('#log11').val( function(index, val){
	       return val + "【" + eventName + "】 " + nodeId + "  " + nodeName + "\n";
	    });
	}   
    
	//模糊查找样式
	function getFontCss12(treeId, node){
	    return (!!node.highlight) ? {color:"#A60000", "font-weight":"bold"} : {color:"#333", "font-weight":"normal"};
	} 
    
    //根据某一条件查找节点 精确查询
    function getNodeByParam(key, value, parentNode){
        var zTree = $.fn.zTree.getZTreeObj("tree-12");
        var node = zTree.getNodeByParam(key, value, parentNode);
        zTree.selectNode(node);
    }
    
    //根据某一条件查找节点 模糊查询
    function getNodesByParamFuzzy(key, value, parentNode){
        var zTree = $.fn.zTree.getZTreeObj("tree-12");
        var nodes = zTree.getNodesByParamFuzzy(key, value, parentNode);  
        //取消之前的高亮显示
        highlightNodes(zTree, zTree.highlightNodeList, false);
        //高亮显示
        highlightNodes(zTree, nodes, true);
        zTree.highlightNodeList = nodes;
        //选中第一个
        if(null != nodes && nodes.length > 0){
            zTree.selectNode(nodes[0]);
        }
    }
    
    //高亮显示
    function highlightNodes(zTree, nodes, highlight) {
        if(null == nodes)  return;
		for( var i = 0, l = nodes.length; i < l; i++) {
			nodes[i].highlight = highlight;
			zTree.updateNode(nodes[i]);
		}
	}
			  
    
</script>

</body>
</html>