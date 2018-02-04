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

<!--加入收藏start-->
<script type="text/javascript">
function bookmarksite(title, url){
    if (window.sidebar) // firefox
        window.sidebar.addPanel(title, url, "");
    else 
        if (window.opera && window.print) { // opera
            var elem = document.createElement('a');
            elem.setAttribute('href', url);
            elem.setAttribute('title', title);
            elem.setAttribute('rel', 'sidebar');
            elem.click();
        }
        else 
            if (document.all)// ie
                window.external.AddFavorite(url, title);
}
</script>
<!--加入收藏end-->
</head>
<body>
 <div class="box1" panelWidth="800">
 <fieldset>
   <legend>1、设为首页</legend>
	<a href="javascript:void(0)" onClick="this.style.behavior='url(#default#homepage)';this.setHomePage('http://www.abc.com');">点击设为首页</a>
	<br />（firefox无效）
  </fieldset>
  <div class="height_15"></div>
  
  
  <fieldset>
   <legend>2、加入收藏</legend>
	<a href="javascript:bookmarksite('网站名称', 'http://www.abc.com')">点击加入收藏</a>
  </fieldset>
  <div class="height_15"></div>
  
  
  </div>
</body>
</html>