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

<!--树组件start -->
<script type="text/javascript" src="<%=path%>/libs/js/tree/ztree/ztree.js"></script>
<link href="<%=path%>/libs/js/tree/ztree/ztree.css" rel="stylesheet" type="text/css"/>
<!--树组件end -->
<script>
		var curMenu = null, zTree_Menu = null;
		var setting = {
			view: {
				showLine: false,
				showIcon: false,
				selectedMulti: false,
				dblClickExpand: false,
				addDiyDom: addDiyDom
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeClick:beforeClick
			}
		};
		
		var zNodes =[
			{ id:1, parentId:0, name:"特11（彩虹城小区-时代庄园北站）",info:[{key:"运营时间",value:"5:20-23:20",colspan:true},{key:"票价",value:"1元"},{key:"是否单一票制",value:"是"},{key:"公司",value:"客五"},{key:"是否无人售票",value:"是"},{key:"线路长度",value:"12.5公里"}]},
			{ id:11, parentId:1, name:"1、彩虹城小区"},
			{ id:12, parentId:1, name:"2、光彩路南口"},
			{ id:13, parentId:1, name:"3、光彩路南口"},
			{ id:14, parentId:1, name:"4、石榴园"},
			{ id:15, parentId:1, name:"5、赵公口桥南"},
			{ id:16, parentId:1, name:"6、彩虹城小区"},
			{ id:17, parentId:1, name:"7、光彩路南口"},
			{ id:18, parentId:1, name:"8、光彩路南口"},
			{ id:19, parentId:1, name:"9、石榴园"},
			{ id:110, parentId:1, name:"10、赵公口桥南"},
			{ id:111, parentId:1, name:"11、彩虹城小区"},
			{ id:112, parentId:1, name:"12、光彩路南口"},
			{ id:113, parentId:1, name:"13、光彩路南口"},
			{ id:114, parentId:1, name:"14、石榴园"},
			{ id:115, parentId:1, name:"15、赵公口桥南"},
			{ id:116, parentId:1, name:"16、彩虹城小区"},
			{ id:117, parentId:1, name:"17、光彩路南口"},
			{ id:118, parentId:1, name:"18、光彩路南口"},
			{ id:119, parentId:1, name:"19、石榴园"},
			{ id:120, parentId:1, name:"20、赵公口桥南"},
			{ id:2, parentId:0, name:"特11（时代庄园北站-彩虹城小区）",info:[{key:"运营时间",value:"5:20-23:20",colspan:"true"},{key:"票价",value:"1元"},{key:"是否单一票制",value:"是"},{key:"公司",value:"客五"},{key:"是否无人售票",value:"是"},{key:"线路长度",value:"12.5公里"}]},
			{ id:21, parentId:2, name:"1、彩虹城小区"},
			{ id:22, parentId:2, name:"2、光彩路南口"},
			{ id:23, parentId:2, name:"3、光彩路南口"},
			{ id:24, parentId:2, name:"4、石榴园"},
			{ id:25, parentId:2, name:"5、赵公口桥南"},
			{ id:26, parentId:2, name:"6、彩虹城小区"},
			{ id:27, parentId:2, name:"7、光彩路南口"},
			{ id:28, parentId:2, name:"8、光彩路南口"},
			{ id:29, parentId:2, name:"9、石榴园"},
			{ id:210, parentId:2, name:"10、赵公口桥南"},
			{ id:211, parentId:2, name:"11、彩虹城小区"},
			{ id:212, parentId:2, name:"12、光彩路南口"},
			{ id:213, parentId:2, name:"13、光彩路南口"},
			{ id:214, parentId:2, name:"14、石榴园"},
			{ id:215, parentId:2, name:"15、赵公口桥南"},
			{ id:216, parentId:2, name:"16、彩虹城小区"},
			{ id:217, parentId:2, name:"17、光彩路南口"},
			{ id:218, parentId:2, name:"18、光彩路南口"},
			{ id:219, parentId:2, name:"19、石榴园"},
			{ id:220, parentId:2, name:"20、赵公口桥南"}
			
		];



		function initComplete(){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			
			zTree_Menu = $.fn.zTree.getZTreeObj("treeDemo");
		}
		
		function beforeClick(treeId, treeNode) {
			//第一级点击项添加选中样式
			if (treeNode.level === 0) {
				//第一级移除选中样式
				$("#"+treeId).find("a").each(function(){
					if($(this).hasClass("cur")){
						$(this).removeClass("cur");
						$(this).next("div").hide();
					}
				})
				
				var a = $("#" + treeNode.tId + "_a");
				a.addClass("cur");
				a.next("div").show();
			
				//单击展开或收缩
				if(treeNode.open){
					zTree_Menu.expandNode(treeNode,false);
					var a = $("#" + treeNode.tId + "_a");
					a.removeClass("cur");
					a.next("div").hide();
				}
				else{
					zTree_Menu.expandAll(false);
					zTree_Menu.expandNode(treeNode);
				}
			}
			else{
				zTree_Menu.expandNode(treeNode);
			}
		}
		
		function addDiyDom(treeId, treeNode) {
		   var aObj = $("#" + treeNode.tId + "_a");
		   if ($("#infoBtn_"+treeNode.id).length>0) return;
			if(treeNode.isParent){
				var infoCon= $('<div class="ztree_custom_info"></div>');
				var ul=$('<ul></ul>');
				$.each(treeNode.info, function(idx, item){
					var li=$('<li></li>');
					li.text(item.key+"："+item.value);
					if(item.colspan){
						if(item.colspan=="true"||item.colspan==true){
							li.width(240);
						}
					}
					else{
						li.width(120);
					}
					ul.append(li);
				})
				ul.append('<div class="clear"></div>');
				infoCon.append(ul);
				aObj.after(infoCon);
			}
		};
		
</script>
<style>
.ztree_custom{
	padding:0!important;
}

.ztree_custom li a.level0 {
	width:248px;
	height: 29px;
	background: white url(<%=path%>/sample/tree/accTabNor.jpg) repeat-x center left;
	text-decoration:none;
	text-align:left;
	padding:0;
	margin:2px 0 5px 0;
	text-indent:10px;
	display:block;
	border-left:solid 1px #a3b0b9;
	border-right:solid 1px #a3b0b9;
}
.ztree_custom li a.level0 span{
	margin-left:4px!important;
}
.ztree_custom li a:hover.level0{
	text-decoration:none;
}
.ztree_custom li a.level0.cur {/*选中样式*/
	background-image: url("<%=path%>/sample/tree/accTabCur.jpg")!important;
	color:white!important;
	background-color:white!important;
}
.ztree_custom li a.level0.cur span{
	color:white!important;
}
.ztree_custom li a.level0 span {
	display: block; 
	color: #03509e; 
	padding-top:3px; 
	font-size:12px; 
	word-spacing: 2px;
}
.ztree_custom li a.level0 span {	
	float:left; 
	margin:3px 0 0 15px; 
	
}
.ztree_custom li span.switch.level0 {
	display:none;
}
.ztree_custom li ul{
	padding-left:0!important;
}
.ztree_custom_info{
	width:240px;
	white-space:normal;
	line-height:200%;
	border:solid 1px #799297;
	background-color:#f2f2f2;
	padding-left:5px!important;
	padding-right:5px!important;
	display:none;
	margin-bottom:5px!important;
}
.ztree_custom_info ul{
	margin:0!important;
	padding:0!important;
}
.ztree_custom_info ul li{
	margin:0!important;
	padding:0!important;
	height:30px;
	float:left;
	overflow:hidden;
	line-height:30px;
}
.ztree li a.curSelectedNode{
	border-top:none!important;
	border-bottom:none!important;
	border-left:solid 1px #3e7fb9!important;
	border-right:solid 1px #3e7fb9!important;
}
</style>
</head>
<body>
<div class="box1" panelWidth="600" panelHeight="600">
使用树组件实现的公交线路查询效果。
	<br/>
		<div>
			<ul id="treeDemo" class="ztree ztree_custom"></ul>
		</div>	
	<br/>
</div>
</body>
</html>