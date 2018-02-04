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
  <div class="box2" panelTitle="含文字图标索引">
	<table class="tableStyle" useHover="false" useColor="false" useClick="false">
	<tr>
		<th colspan="10">文件系统</th>
	</tr>
	<tr>
		<td><span class="icon_bmp">bmp</span></td>
		<td><span class="icon_cd">cd</span></td>
		<td><span class="icon_cd_driver">cd-driver</span></td>
		<td><span class="icon_disk">磁盘</span></td>
		<td><span class="icon_doc">doc</span></td>
		<td><span class="icon_docx">docx</span></td>
		<td><span class="icon_exe">exe</span></td>
		<td><span class="icon_tool">工具</span></td>
		<td><span class="icon_floppy">floppy</span></td>
		<td><span class="icon_folder">folder</span></td>
	</tr>
	<tr>
		<td>icon_bmp</td>
		<td>icon_cd</td>
		<td>icon_cd_driver</td>
		<td>icon_disk</td>
		<td>icon_doc</td>
		<td>icon_docx</td>
		<td>icon_exe</td>
		<td>icon_tool</td>
		<td>icon_floppy</td>
		<td>icon_folder</td>
	</tr>
	<tr>
		<td><span class="icon_folder_doc">folder-doc</span></td>
		<td><span class="icon_folder_img">folder-img</span></td>
		<td><span class="icon_folder_user">folder-user</span></td>
		<td><span class="icon_folder_open">folder-open</span></td>
		<td><span class="icon_gif">gif</span></td>
		<td><span class="icon_html">html</span></td>
		<td><span class="icon_jpg">jpg</span></td>
		<td><span class="icon_network">网络邻居</span></td>
		<td><span class="icon_pc">电脑</span></td>
		<td><span class="icon_pdf">pdf</span></td>
	</tr>
	<tr>
		<td>icon_folder_doc</td>
		<td>icon_folder_img</td>
		<td>icon_folder_user</td>
		<td>icon_folder_open</td>
		<td>icon_gif</td>
		<td>icon_html</td>
		<td>icon_jpg</td>
		<td>icon_network</td>
		<td>icon_pc</td>
		<td>icon_pdf</td>
	</tr>
	<tr>
		<td><span class="icon_png">png</span></td>
		<td><span class="icon_ppt">ppt</span></td>
		<td><span class="icon_qq">qq</span></td>
		<td><span class="icon_rar">rar</span></td>
		<td><span class="icon_recycle">回收站</span></td>
		<td><span class="icon_reg">注册表</span></td>
		<td><span class="icon_swf">swf</span></td>
		<td><span class="icon_ttf">ttf</span></td>
		<td><span class="icon_txt">txt</span></td>
		<td><span class="icon_xls">xls</span></td>
	</tr>
	<tr>
		<td>icon_png</td>
		<td>icon_ppt</td>
		<td>icon_qq</td>
		<td>icon_rar</td>
		<td>icon_recycle</td>
		<td>icon_reg</td>
		<td>icon_swf</td>
		<td>icon_ttf</td>
		<td>icon_txt</td>
		<td>icon_xls</td>
	</tr>
	<tr>
		<td><span class="icon_mdb">mdb</span></td>
		<td><span class="icon_asp">asp</span></td>
		<td><span class="icon_aspx">aspx</span></td>
		<td><span class="icon_avi">avi</span></td>
		<td><span class="icon_code">code</span></td>
		<td><span class="icon_fla">fla</span></td>
		<td><span class="icon_flv">flv</span></td>
		<td><span class="icon_js">js</span></td>
		<td><span class="icon_jsp">jsp</span></td>
		<td><span class="icon_mov">mov</span></td>
	</tr>
	<tr>
		<td>icon_mdb</td>
		<td>icon_asp</td>
		<td>icon_aspx</td>
		<td>icon_avi</td>
		<td>icon_code</td>
		<td>icon_fla</td>
		<td>icon_flv</td>
		<td>icon_js</td>
		<td>icon_jsp</td>
		<td>icon_mov</td>
	</tr>
	<tr>
		<td><span class="icon_mp3">mp3</span></td>
		<td><span class="icon_mp4">mp4</span></td>
		<td><span class="icon_php">php</span></td>
		<td><span class="icon_rm">rm</span></td>
		<td><span class="icon_unknown">unknown</span></td>
		<td><span class="icon_wmp">wmp</span></td>
		<td><span class="icon_wmv">wmv</span></td>
		<td><span class="icon_zip">zip</span></td>
		<td><span class="icon_office">office</span></td>
		<td><span class="icon_chart">chart</span></td>
	</tr>
	<tr>
		<td>icon_mp3</td>
		<td>icon_mp4</td>
		<td>icon_php</td>
		<td>icon_rm</td>
		<td>icon_unknown</td>
		<td>icon_wmp</td>
		<td>icon_wmv</td>
		<td>icon_zip</td>
		<td>icon_office</td>
		<td>chart</td>
	</tr>
	<tr>
		<th colspan="10">页面</th>
	</tr>
	<tr>
		<td><span class="icon_home">首页</span></td>
		<td><span class="icon_exit">退出</span></td>
		<td><span class="icon_email">email</span></td>
		<td><span class="icon_help">帮助</span></td>
		<td><span class="icon_history">历史</span></td>
		<td><span class="icon_contact">联系</span></td>
		<td><span class="icon_warn">警告</span></td>
		<td><span class="icon_about">关于</span></td>
		<td><span class="icon_fullscreen">全屏</span></td>
		<td><span class="icon_actualscreen">退出全屏</span></td>
	</tr>
	<tr>
		<td>icon_home</td>
		<td>icon_exit</td>
		<td>icon_email</td>
		<td>icon_help</td>
		<td>icon_history</td>
		<td>icon_contact</td>
		<td>icon_warn</td>
		<td>icon_about</td>
		<td>icon_fullscreen</td>
		<td>icon_actualscreen</td>
	</tr>
	<tr>
		<th colspan="10">形状</th>
	</tr>
	<tr>
		<td><span class="icon_rectangle">矩形</span></td>
		<td><span class="icon_point">点</span></td>
		<td><span class="icon_line">线</span></td>
		<td><span class="icon_triangle">三角形</span></td>
		<td><span class="icon_polygon">多边形</span></td>
		<td><span class="icon_ellipse">椭圆</span></td>
		<td><span class="icon_curve">曲线</span></td>
		<td><span class="icon_starshape">星形</span></td>
		<td><span class="icon_circle">圆</span></td>
		<td><span class="icon_layers">图层</span></td>
	</tr>
	<tr>
		<td>icon_rectangle</td>
		<td>icon_point</td>
		<td>icon_line</td>
		<td>icon_triangle</td>
		<td>icon_polygon</td>
		<td>icon_ellipse</td>
		<td>icon_curve</td>
		<td>icon_starshape</td>
		<td>icon_circle</td>
		<td>icon_layers</td>
	</tr>
	<tr>
		<th colspan="10">操作</th>
	</tr>
	<tr>
		<td><span class="icon_add">新增</span></td>
		<td><span class="icon_attention">注意</span></td>
		<td><span class="icon_cut">剪切</span></td>
		<td><span class="icon_delete">删除</span></td>
		<td><span class="icon_edit">编辑</span></td>
		<td><span class="icon_find">查找/精确查询</span></td>
		<td><span class="icon_find2">查找/模糊查询</span></td>
		<td><span class="icon_no">取消</span></td>
		<td><span class="icon_ok">确定</span></td>
		<td><span class="icon_mouse">鼠标</span></td>
	</tr>
	<tr>
		<td>icon_add</td>
		<td>icon_attention</td>
		<td>icon_cut</td>
		<td>icon_delete</td>
		<td>icon_edit</td>
		<td>icon_find</td>
		<td>icon_find2</td>
		<td>icon_no</td>
		<td>icon_ok</td>
		<td>icon_mouse</td>
	</tr>
	<tr>
		<td><span class="icon_poll">投票</span></td>
		<td><span class="icon_print">打印</span></td>
		<td><span class="icon_refresh">刷新</span></td>
		<td><span class="icon_reload">重新加载</span></td>
		<td><span class="icon_remove">移除</span></td>
		<td><span class="icon_reply">回复</span></td>
		<td><span class="icon_save">保存</span></td>
		<td><span class="icon_view">查看</span></td>
		<td><span class="icon_light">说明</span></td>
		<td><span class="icon_lightOn">说明</span></td>
	</tr>
	<tr>
		<td>icon_poll</td>
		<td>icon_print</td>
		<td>icon_refresh</td>
		<td>icon_reload</td>
		<td>icon_remove</td>
		<td>icon_reply</td>
		<td>icon_save</td>
		<td>icon_view</td>
		<td>icon_light</td>
		<td>icon_lightOn</td>
	</tr>
	<tr>
		<td><span class="icon_mark">书签</span></td>
		<td><span class="icon_star">收藏</span></td>
		<td><span class="icon_lock">锁住</span></td>
		<td><span class="icon_measure">测量</span></td>
		<td><span class="icon_rule">测量2</span></td>
		<td><span class="icon_clear">清除</span></td>
		<td><span class="icon_zoomin">放大</span></td>
		<td><span class="icon_zoomout">缩小</span></td>
		<td><span class="icon_export">导出</span></td>
		<td><span class="icon_import">导入</span></td>
	</tr>
	<tr>
		<td>icon_mark</td>
		<td>icon_star</td>
		<td>icon_lock</td>
		<td>icon_measure</td>
		<td>icon_rule</td>
		<td>icon_clear</td>
		<td>icon_zoomin</td>
		<td>icon_zoomout</td>
		<td>icon_export</td>
		<td>icon_import</td>
	</tr>
	<tr>
		<th colspan="10">箭头</th>
	</tr>
	<tr>
		<td><span class="icon_expand">展开</span></td>
		<td><span class="icon_collapse">收回</span></td>
		<td><span class="icon_btn_left">左</span></td>
		<td><span class="icon_btn_right">右</span></td>
		<td><span class="icon_btn_up">上</span></td>
		<td><span class="icon_btn_down">下</span></td>
		<td><span class="icon_page_first">第一页</span></td>
		<td><span class="icon_page_last">最后一页</span></td>
		<td><span class="icon_page_next">下一页</span></td>
		<td><span class="icon_page_prev">上一页</span></td>
	</tr>
	<tr>
		<td>icon_expand</td>
		<td>icon_collapse</td>
		<td>icon_btn_left</td>
		<td>icon_btn_right</td>
		<td>icon_btn_up</td>
		<td>icon_btn_down</td>
		<td>icon_page_first</td>
		<td>icon_page_last</td>
		<td>icon_page_next</td>
		<td>icon_page_prev</td>
	</tr>
	<tr>
		<td><span class="icon_arr1">箭头1</span></td>
		<td><span class="icon_remove2">收回</span></td>
		<td><span class="icon_add2">展开</span></td>
		<td><span class="icon_pause">暂停</span></td>
		<td><span class="icon_stop">停止</span></td>
		<td><span class="icon_page_next_db">末页</span></td>
		<td><span class="icon_page_prev_db">首页</span></td>
		<td><span class="icon_back">后退</span></td>
		<td><span class="icon_btn_up2">上</span></td>
		<td><span class="icon_btn_down2">下</span></td>
	</tr>
	<tr>
		<td>icon_arr1</td>
		<td>icon_remove2</td>
		<td>icon_add2</td>
		<td>icon_pause</td>
		<td>icon_stop</td>
		<td>icon_page_next_db</td>
		<td>icon_page_prev_db</td>
		<td>icon_back</td>
		<td>icon_btn_up2</td>
		<td>icon_btn_down2</td>
	</tr>
	
	<tr>
		<th colspan="10">其他</th>
	</tr>
	<tr>
		<td><span class="icon_img">图片</span></td>
		<td><span class="icon_bubble">泡</span></td>
		<td><span class="icon_cart">购物车</span></td>
		<td><span class="icon_finger">拇指</span></td>
		<td><span class="icon_globe">地球</span></td>
		<td><span class="icon_guard">盾牌</span></td>
		<td><span class="icon_list">列表</span></td>
		<td><span class="icon_item">项目</span></td>
		<td><span class="icon_page">项目2</span></td>
		<td><span class="icon_jing">精</span></td>
	</tr>
	<tr>
		<td>icon_img</td>
		<td>icon_bubble</td>
		<td>icon_cart</td>
		<td>icon_finger</td>
		<td>icon_globe</td>
		<td>icon_guard</td>
		<td>icon_list</td>
		<td>icon_item</td>
		<td>icon_page</td>
		<td>icon_jing</td>
	</tr>
	<tr>
		<td><span class="icon_key">钥匙</span></td>
		<td><span class="icon_loading">加载中</span></td>
		<td><span class="icon_pencil">铅笔</span></td>
		<td><span class="icon_user">用户</span></td>
		<td><span class="icon_user_female">女用户</span></td>
		<td><span class="icon_user_group">用户组</span></td>
		<td><span class="icon_user_off">离线用户</span></td>
		<td><span class="icon_user_worker">工人</span></td>
		<td><span class="icon_video">视频</span></td>
		<td><span class="icon_flag">旗子</span></td>
	</tr>
	<tr>
		<td>icon_key</td>
		<td>icon_loading</td>
		<td>icon_pencil</td>
		<td>icon_user</td>
		<td>icon_user_female</td>
		<td>icon_user_group</td>
		<td>icon_user_off</td>
		<td>icon_user_worker</td>
		<td>icon_video</td>
		<td>icon_flag</td>
	</tr>
	</table>
	</div>
	
		
	<div class="box2" panelTitle="不含文字图标索引">		
	<table class="tableStyle" useHover="false"  useColor="false" useClick="false">
	<tr>
		<th colspan="10">文件系统</th>
	</tr>
	<tr>
		<td>
		<span title="bmp" class="img_bmp"></span></td>
		<td><span title="cd" class="img_cd"></span></td>
		<td><span title="cd-driver" class="img_cd_driver"></span></td>
		<td><span title="磁盘" class="img_disk"></span></td>
		<td><span title="doc" class="img_doc"></span></td>
		<td><span title="docx" class="img_docx"></span></td>
		<td><span title="exe" class="img_exe"></span></td>
		<td><span title="工具" class="img_tool"></span></td>
		<td><span title="floppy" class="img_floppy"></span></td>
		<td><span title="folder" class="img_folder"></span></td>
	</tr>
	<tr>
		<td>img_bmp</td>
		<td>img_cd</td>
		<td>img_cd_driver</td>
		<td>img_disk</td>
		<td>img_doc</td>
		<td>img_docx</td>
		<td>img_exe</td>
		<td>img_tool</td>
		<td>img_floppy</td>
		<td>img_folder</td>
	</tr>
	<tr>
		<td><span title="folder-doc" class="img_folder_doc"></span></td>
		<td><span title="folder-img" class="img_folder_img"></span></td>
		<td><span title="folder-user" class="img_folder_user"></span></td>
		<td><span title="folder-open" class="img_folder_open"></span></td>
		<td><span title="gif" class="img_gif"></span></td>
		<td><span title="html" class="img_html"></span></td>
		<td><span title="jpg" class="img_jpg"></span></td>
		<td><span title="网络邻居" class="img_network"></span></td>
		<td><span title="电脑" class="img_pc"></span></td>
		<td><span title="pdf" class="img_pdf"></span></td>
	</tr>
	<tr>
		<td>img_folder_doc</td>
		<td>img_folder_img</td>
		<td>img_folder_user</td>
		<td>img_folder_open</td>
		<td>img_gif</td>
		<td>img_html</td>
		<td>img_jpg</td>
		<td>img_network</td>
		<td>img_pc</td>
		<td>img_pdf</td>
	</tr>
	<tr>
		<td><span title="png" class="img_png"></span></td>
		<td><span title="ppt" class="img_ppt"></span></td>
		<td><span title="qq" class="img_qq"></span></td>
		<td><span title="rar" class="img_rar"></span></td>
		<td><span title="回收站" class="img_recycle"></span></td>
		<td><span title="注册表" class="img_reg"></span></td>
		<td><span title="swf" class="img_swf"></span></td>
		<td><span title="ttf" class="img_ttf"></span></td>
		<td><span title="txt" class="img_txt"></span></td>
		<td><span title="xls" class="img_xls"></span></td>
	</tr>
	<tr>
		<td>img_png</td>
		<td>img_ppt</td>
		<td>img_qq</td>
		<td>img_rar</td>
		<td>img_recycle</td>
		<td>img_reg</td>
		<td>img_swf</td>
		<td>img_ttf</td>
		<td>img_txt</td>
		<td>img_xls</td>
	</tr>
	<tr>
		<td><span title="mdb" class="img_mdb"></span></td>
		<td><span title="asp" class="img_asp"></span></td>
		<td><span title="aspx" class="img_aspx"></span></td>
		<td><span title="avi" class="img_avi"></span></td>
		<td><span title="code" class="img_code"></span></td>
		<td><span title="fla" class="img_fla"></span></td>
		<td><span title="flv" class="img_flv"></span></td>
		<td><span title="js" class="img_js"></span></td>
		<td><span title="jsp" class="img_jsp"></span></td>
		<td><span title="mov" class="img_mov"></span></td>
	</tr>
	<tr>
		<td>img_mdb</td>
		<td>img_asp</td>
		<td>img_aspx</td>
		<td>img_avi</td>
		<td>img_code</td>
		<td>img_fla</td>
		<td>img_flv</td>
		<td>img_js</td>
		<td>img_jsp</td>
		<td>img_mov</td>
	</tr>
	<tr>
		<td><span title="mp3" class="img_mp3"></span></td>
		<td><span title="mp4" class="img_mp4"></span></td>
		<td><span title="php" class="img_php"></span></td>
		<td><span title="rm" class="img_rm"></span></td>
		<td><span title="unknown" class="img_unknown"></span></td>
		<td><span title="wmp" class="img_wmp"></span></td>
		<td><span title="wmv" class="img_wmv"></span></td>
		<td><span title="zip" class="img_zip"></span></td>
		<td><span title="office" class="img_office"></span></td>
		<td><span title="chart" class="img_chart"></span></td>
	</tr>
	<tr>
		<td>img_mp3</td>
		<td>img_mp4</td>
		<td>img_php</td>
		<td>img_rm</td>
		<td>img_unknown</td>
		<td>img_wmp</td>
		<td>img_wmv</td>
		<td>img_zip</td>
		<td>img_office</td>
		<td>img_chart</td>
	</tr>
	<tr>
		<th colspan="10">页面</th>
	</tr>
	<tr>
		<td><span title="首页" class="img_home"></span></td>
		<td><span title="退出" class="img_exit"></span></td>
		<td><span title="email" class="img_email"></span></td>
		<td><span title="帮助" class="img_help"></span></td>
		<td><span title="历史" class="img_history"></span></td>
		<td><span title="联系" class="img_contact"></span></td>
		<td><span title="警告" class="img_warn"></span></td>
		<td><span title="关于" class="img_about"></span></td>
		<td><span title="全屏" class="img_fullscreen"></span></td>
		<td><span title="退出全屏" class="img_actualscreen"></span></td>
	</tr>
	<tr>
		<td>img_home</td>
		<td>img_exit</td>
		<td>img_email</td>
		<td>img_help</td>
		<td>img_history</td>
		<td>img_contact</td>
		<td>img_warn</td>
		<td>img_about</td>
		<td>img_fullscreen</td>
		<td>img_actualscreen</td>
	</tr>
	<tr>
		<th colspan="10">形状</th>
	</tr>
	<tr>
		<td><span title="矩形" class="img_rectangle"></span></td>
		<td><span title="点" class="img_point"></span></td>
		<td><span title="线" class="img_line"></span></td>
		<td><span title="三角形" class="img_triangle"></span></td>
		<td><span title="多边形" class="img_polygon"></span></td>
		<td><span title="椭圆" class="img_ellipse"></span></td>
		<td><span title="曲线" class="img_curve"></span></td>
		<td><span title="星形" class="img_starshape"></span></td>
		<td><span title="圆" class="img_circle"></span></td>
		<td><span title="图层" class="img_layers"></span></td>
	</tr>
	<tr>
		<td>img_rectangle</td>
		<td>img_point</td>
		<td>img_line</td>
		<td>img_triangle</td>
		<td>img_polygon</td>
		<td>img_ellipse</td>
		<td>img_curve</td>
		<td>img_starshape</td>
		<td>img_circle</td>
		<td>img_layers</td>
	</tr>
	<tr>
		<th colspan="10">操作</th>
	</tr>
	<tr>
		<td><span title="新增" class="img_add"></span></td>
		<td><span title="注意" class="img_attention"></span></td>
		<td><span title="剪切" class="img_cut"></span></td>
		<td><span title="删除" class="img_delete"></span></td>
		<td><span title="编辑" class="img_edit"></span></td>
		<td><span title="查找/精确查询" class="img_find"></span></td>
		<td><span title="查找/模糊查询" class="img_find2"></span></td>
		<td><span title="取消" class="img_no"></span></td>
		<td><span title="确定" class="img_ok"></span></td>
		<td><span title="鼠标" class="img_mouse"></span></td>
	</tr>
	<tr>
		<td>img_add</td>
		<td>img_attention</td>
		<td>img_cut</td>
		<td>img_delete</td>
		<td>img_edit</td>
		<td>img_find</td>
		<td>img_find2</td>
		<td>img_no</td>
		<td>img_ok</td>
		<td>img_mouse</td>
	</tr>
	<tr>
		<td><span title="投票" class="img_poll"></span></td>
		<td><span title="打印" class="img_print"></span></td>
		<td><span title="刷新" class="img_refresh"></span></td>
		<td><span title="重新加载" class="img_reload"></span></td>
		<td><span title="移除" class="img_remove"></span></td>
		<td><span title="回复" class="img_reply"></span></td>
		<td><span title="保存" class="img_save"></span></td>
		<td><span title="查看" class="img_view"></span></td>
		<td><span title="放置说明文字" class="img_light"></span></td>
		<td><span title="放置说明文字" class="img_lightOn"></span></td>
	</tr>
	<tr>
		<td>img_poll</td>
		<td>img_print</td>
		<td>img_refresh</td>
		<td>img_reload</td>
		<td>img_remove</td>
		<td>img_reply</td>
		<td>img_save</td>
		<td>img_view</td>
		<td>img_light</td>
		<td>img_lightOn</td>
	</tr>
	<tr>
		<td colspan="10">
			<span class="font_bold red">img_light有一个独特之处是鼠标移入则变成灯泡点亮状态，适合作为解释说明的图标</span>
		</td>
	</tr>
	<tr>
		<td><span title="书签" class="img_mark"></span></td>
		<td><span title="收藏" class="img_star"></span></td>
		<td><span title="锁住" class="img_lock"></span></td>
		<td><span title="测量" class="img_measure"></span></td>
		<td><span title="测量2" class="img_rule"></span></td>
		<td><span title="清除" class="img_clear"></span></td>
		<td><span title="放大" class="img_zoomin"></span></td>
		<td><span title="缩小" class="img_zoomout"></span></td>
		<td><span title="导出" class="img_export"></span></td>
		<td><span title="导入" class="img_import"></span></td>
	</tr>
	<tr>
		<td>img_mark</td>
		<td>img_star</td>
		<td>img_lock</td>
		<td>img_measure</td>
		<td>img_rule</td>
		<td>img_clear</td>
		<td>img_zoomin</td>
		<td>img_zoomout</td>
		<td>img_export</td>
		<td>img_import</td>
	</tr>
	<tr>
		<th colspan="10">箭头</th>
	</tr>
	<tr>
		<td><span title="展开" class="img_expand"></span></td>
		<td><span title="收回" class="img_collapse"></span></td>
		<td><span title="左" class="img_btn_left"></span></td>
		<td><span title="右" class="img_btn_right"></span></td>
		<td><span title="上" class="img_btn_up"></span></td>
		<td><span title="下" class="img_btn_down"></span></td>
		<td><span title="第一页" class="img_page_first"></span></td>
		<td><span title="最后一页" class="img_page_last"></span></td>
		<td><span title="下一页" class="img_page_next"></span></td>
		<td><span title="上一页" class="img_page_prev"></span></td>
	</tr>
	<tr>
		<td>img_expand</td>
		<td>img_collapse</td>
		<td>img_btn_left</td>
		<td>img_btn_right</td>
		<td>img_btn_up</td>
		<td>img_btn_down</td>
		<td>img_page_first</td>
		<td>img_page_last</td>
		<td>img_page_next</td>
		<td>img_page_prev</td>
	</tr>
	<tr>
		<td><span title="箭头1" class="img_arr1"></span></td>
		<td><span title="收回" class="img_remove2"></span></td>
		<td><span title="展开" class="img_add2"></span></td>
		<td><span title="暂停" class="img_pause"></span></td>
		<td><span title="停止" class="img_stop"></span></td>
		<td><span title="末页" class="img_page_next_db"></span></td>
		<td><span title="首页" class="img_page_prev_db"></span></td>
		<td><span title="后退" class="img_back"></span></td>
		<td><span title="上" class="img_btn_up2"></span></td>
		<td><span title="下" class="img_btn_down2"></span></td>
	</tr>
	<tr>
		<td>img_arr1</td>
		<td>img_remove2</td>
		<td>img_add2</td>
		<td>img_pause</td>
		<td>img_stop</td>
		<td>img_page_next_db</td>
		<td>img_page_prev_db</td>
		<td>img_back</td>
		<td>img_btn_up2</td>
		<td>img_btn_down2</td>
	</tr>
	<tr>
		<th colspan="10">其他</th>
	</tr>
	<tr>
		<td><span title="图片" class="img_img"></span></td>
		<td><span title="泡" class="img_bubble"></span></td>
		<td><span title="购物车" class="img_cart"></span></td>
		<td><span title="拇指" class="img_finger"></span></td>
		<td><span title="地球" class="img_globe"></span></td>
		<td><span title="盾牌" class="img_guard"></span></td>
		<td><span title="列表" class="img_list"></span></td>
		<td><span title="项目" class="img_item"></span></td>
		<td><span title="项目2" class="img_page"></span></td>
		<td><span title="精" class="img_jing"></span></td>
	</tr>
	<tr>
		<td>img_img</td>
		<td>img_bubble</td>
		<td>img_cart</td>
		<td>img_finger</td>
		<td>img_globe</td>
		<td>img_guard</td>
		<td>img_list</td>
		<td>img_item</td>
		<td>img_page</td>
		<td>img_jing</td>
	</tr>
	<tr>
		<td><span title="钥匙" class="img_key"></span></td>
		<td><span title="加载中" class="img_loading"></span></td>
		<td><span title="铅笔" class="img_pencil"></span></td>
		<td><span title="用户" class="img_user"></span></td>
		<td><span title="女用户" class="img_user_female"></span></td>
		<td><span title="用户组" class="img_user_group"></span></td>
		<td><span title="离线用户" class="img_user_off"></span></td>
		<td><span title="工人" class="img_user_worker"></span></td>
		<td><span title="视频" class="img_video"></span></td>
		<td><span title="旗子" class="img_flag"></span></td>
	</tr>
	<tr>
		<td>img_key</td>
		<td>img_loading</td>
		<td>img_pencil</td>
		<td>img_user</td>
		<td>img_user_female</td>
		<td>img_user_group</td>
		<td>img_user_off</td>
		<td>img_user_worker</td>
		<td>img_video</td>
		<td>img_flag</td>
	</tr>
	</table>
	</div>	
		
	<div class="box2" panelTitle="操作提示图标索引">	
	<table class="tableStyle"  useHover="false"  useColor="false" useClick="false">
		<tbody>
		<tr>
			<td><div class="msg_icon1"></div></td>
			<td><div class="msg_icon2"></div></td>
		</tr>
		<tr>
			<td>msg_icon1</td>
			<td>msg_icon2</td>
		</tr>
		<tr>
			<td><div class="msg_icon3"></div></td>
			<td><div class="msg_icon4"><span>标题可修改</span></div></td>
		</tr>
		<tr>
			<td>msg_icon3</td>
			<td>msg_icon4</td>
		</tr>
		</tbody>
	</table>
	</div>
	
</body>
</html>