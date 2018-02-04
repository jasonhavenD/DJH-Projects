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
</head>
<body>
<div class="content">
点击右键测试
</div>
<script type="text/javascript">
    var menu;
    $(function() {
        menu = $.rightClickMenu({ width: 120, items:
	            [
	            { text: '增加', click: itemclick, iconClass: 'icon_add' },
	            { text: '修改', click: itemclick, iconClass: 'icon_edit' },
	            { text: '删除', click: itemclick, iconClass: 'icon_delete',disabled: true  },
	            { line: true },
	            { text: '查看', click: itemclick , iconClass: 'icon_view', children:
		            [
		            { text: '弹窗查看', click: itemclick },
		            { text: '导出文件', children: [{ text: 'Excel', click: itemclick }, { text: 'Word'}]
		            }
		            ] }
	            ]
	         }); 
	   $("body").bind("contextmenu", function (e)
	            {
					menu.show({ top: e.pageY, left: e.pageX });
	                return false;
	            });
    });
    function itemclick(item, i)
        {
            top.Dialog.alert("菜单项："+item.text);
        }
     function customHeightSet(contentHeight){
     	$(".content").height(contentHeight);
     }   
        
</script>
</body>
</html>