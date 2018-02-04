<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>异步加载数据</title>
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!-- 树组件start -->
<script type="text/javascript" src="<%=path%>/libs/js/tree/ztree/ztree.js"></script>
<link href="<%=path%>/libs/js/tree/ztree/ztree.css" rel="stylesheet" type="text/css"/>
<!-- 树组件end -->

</head>
<body>
  <div class="box1" panelWidth="800">
      
      <fieldset>
	      <legend>1、基本使用</legend>
	      <div class="red">此示例由后台支持</div>
	      <p>可以返回单根树或多根树</p>
	      <div>
			  <ul id="tree-1" class="ztree"></ul>
		  </div>
	  </fieldset>
	  <div class="height_15"></div>
	  
	  <fieldset>
	      <legend>2、事件控制</legend>
	       <div class="red">此示例由后台支持</div>
	      <span>事件日志</span>
          <textarea id="log2" resize="true" readonly="readonly" style="height:170px; width:300px;"></textarea>
          <input type="button" value="清除日志" onclick="$('#log2').val('')"/>
	      <div>
			  <ul id="tree-2" class="ztree"></ul>
		  </div>
	  </fieldset>
	   <div class="height_15"></div>
	  
	   <fieldset>
	      <legend>3、全部展开</legend>
	      <div class="red">此示例由后台支持</div>
	      <p>可以返回单根树或多根树</p>
	      <div>
			 [ <a id="expandAllBtn"  onclick="expandAll()">全部展开</a> ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				[ <a id="asyncAllBtn" onclick="asyncAll()">后台自动全部加载</a> ]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				[ <a id="resetBtn"  onclick="reset()">重置树</a> ]<br/><br/>
				<p class="highlight_red" id="demoMsg"></p>
				
			  <ul id="tree-3" class="ztree"></ul>
		  </div>
	  </fieldset>
	  <div class="height_15"></div>
  
  </div>
 
 <script type="text/javascript">
 
 	//示例1相关
 	  var setting1 = {
			async: {
				enable: true,
				dataType: 'JSON',
				//返回的JSON数据的名字
				dataName: 'treeNodes',
				url: "<%=path%>/getAsyncTree.action",
				autoParam: ["id", "name", "name=reName"],
				otherParam: {
				   "otherParam1": "zTreeAsyncTest1",
				   "otherParam2": "zTreeAsyncTest2"
				},
				//传回的数据格式不是ztree所需要的格式的时候，可以对数据进行转化。正常情况下不需要实现dataFilter
				dataFilter: filter
			}
		};
		
		//示例2相关
		var setting2 = {
			async: {
				enable: true,
				dataType: 'JSON',
				//返回的JSON数据的名字
				dataName: 'treeNodes',
				url: "<%=path%>/getAsyncTree.action",
				autoParam: ["id"]
			},
			callback: {
			    beforeAsync: beforeAsync2,
			    onAsyncError: onAsyncError2,
			    onAsyncSuccess: onAsyncSuccess2
			} 
		};
		
		//示例3相关
		var demoMsg = {
			async:"正在进行异步加载，请等一会儿再点击...",
			expandAllOver: "全部展开完毕",
			asyncAllOver: "后台异步加载完毕",
			asyncAll: "已经异步加载完毕，不再重新加载",
			expandAll: "已经异步加载完毕，使用 expandAll 方法"
		}
		var setting3 = {
			async: {
				enable: true,
				dataType: 'JSON',
				//返回的JSON数据的名字
				dataName: 'treeNodes',
				url: "<%=path%>/getAsyncTree.action",
				autoParam: ["id", "name", "name=reName"]
			},
			callback: {
				beforeAsync: beforeAsync,
				onAsyncSuccess: onAsyncSuccess,
				onAsyncError: onAsyncError
			}
		};

		
		function initComplete(){
			$.fn.zTree.init($("#tree-1"), setting1);
			$.fn.zTree.init($("#tree-2"), setting2);
			$.fn.zTree.init($("#tree-3"), setting3);
		}
		
		 //因为返回的数据格式正确，因此，直接返回。正常使用时是不需要此方法的。
		function filter(treeId, parentNode, childNodes) {
		    return childNodes; 
		}
		
		//示例2相关
		function beforeAsync2(treeId, treeNode){
		    if(undefined != treeNode){
	    		appendToLog2("beforeAsync", treeNode.id, treeNode.name);
	    	}else{
	    	    appendToLog2("beforeAsync", '', 'Root');
	    	}
	    }
	    
	    function onAsyncError2(event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown){
	        if(undefined != treeNode){
	        	appendToLog2("onAsyncError", treeNode.id, treeNode.name);
	        }else{
	    	    appendToLog2("onAsyncError", '', 'Root');
	    	}
	    }
	    
	    function onAsyncSuccess2(event, treeId, treeNode, msg){
	        if(undefined != treeNode){
	        	appendToLog2("onAsyncSuccess", treeNode.id, treeNode.name);
	        }else{
	    	    appendToLog2("onAsyncSuccess", '', 'Root');
	    	}
	    }
    	function appendToLog2(eventName, nodeId, nodeName){
	        $('#log2').val( function(index, val){
	           return val + "【" + eventName + "】 " + nodeId + "  " + nodeName + "\n";
	        });
	    }
	    
	    
	    //示例3相关
	    function beforeAsync() {
			curAsyncCount++;
		}
		
		function onAsyncSuccess(event, treeId, treeNode, msg) {
			curAsyncCount--;
			if (curStatus == "expand") {
				expandNodes(treeNode.children);
			} else if (curStatus == "async") {
				asyncNodes(treeNode.children);
			}

			if (curAsyncCount <= 0) {
				if (curStatus != "init" && curStatus != "") {
					$("#demoMsg").text((curStatus == "expand") ? demoMsg.expandAllOver : demoMsg.asyncAllOver);
					asyncForAll = true;
				}
				curStatus = "";
			}
		}

		function onAsyncError(event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown) {
			curAsyncCount--;

			if (curAsyncCount <= 0) {
				curStatus = "";
				if (treeNode!=null) asyncForAll = true;
			}
		}

		var curStatus = "init", curAsyncCount = 0, asyncForAll = false,
		goAsync = false;
		function expandAll() {
			if (!check()) {
				return;
			}
			var zTree = $.fn.zTree.getZTreeObj("tree-3");
			if (asyncForAll) {
				$("#demoMsg").text(demoMsg.expandAll);
				zTree.expandAll(true);
			} else {
				expandNodes(zTree.getNodes());
				if (!goAsync) {
					$("#demoMsg").text(demoMsg.expandAll);
					curStatus = "";
				}
			}
		}
		function expandNodes(nodes) {
			if (!nodes) return;
			curStatus = "expand";
			var zTree = $.fn.zTree.getZTreeObj("tree-3");
			for (var i=0, l=nodes.length; i<l; i++) {
				zTree.expandNode(nodes[i], true, false, false);
				if (nodes[i].isParent && nodes[i].zAsync) {
					expandNodes(nodes[i].children);
				} else {
					goAsync = true;
				}
			}
		}

		function asyncAll() {
			if (!check()) {
				return;
			}
			var zTree = $.fn.zTree.getZTreeObj("tree-3");
			if (asyncForAll) {
				$("#demoMsg").text(demoMsg.asyncAll);
			} else {
				asyncNodes(zTree.getNodes());
				if (!goAsync) {
					$("#demoMsg").text(demoMsg.asyncAll);
					curStatus = "";
				}
			}
		}
		function asyncNodes(nodes) {
			if (!nodes) return;
			curStatus = "async";
			var zTree = $.fn.zTree.getZTreeObj("tree-3");
			for (var i=0, l=nodes.length; i<l; i++) {
				if (nodes[i].isParent && nodes[i].zAsync) {
					asyncNodes(nodes[i].children);
				} else {
					goAsync = true;
					zTree.reAsyncChildNodes(nodes[i], "refresh", true);
				}
			}
		}

		function reset() {
			if (!check()) {
				return;
			}
			asyncForAll = false;
			goAsync = false;
			$("#demoMsg").text("");
			$.fn.zTree.init($("#tree-3"), setting3);
		}

		function check() {
			if (curAsyncCount > 0) {
				$("#demoMsg").text(demoMsg.async);
				return false;
			}
			return true;
		}
 
 </script>
</body>
</html>