<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->


<!-- 日期选择框start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/datePicker/WdatePicker.js"></script>
<!-- 日期选择框end -->


<!--多视图切换start-->
<script type='text/javascript' src="<%=path%>/libs/js/other/scrollTo.js"></script>
<script type='text/javascript' src="<%=path%>/libs/js/other/localscroll.js"></script>
<script>
function initComplete(){
	$(".nav_single_h li").click(function(){
		$(".nav_single_h li").removeClass("current");
		$(this).addClass("current");
	})
	
	$.localScroll.defaults.axis = 'xy';
	$.localScroll.hash({
		target: '#content',
		queue:true,
		duration:1500
	});
	$.localScroll({
		target: '#content', 
		queue:true,
		duration:500,
		hash:true,
		onBefore:function( e, anchor, $target ){
		},
		onAfter:function( anchor, settings ){
		}
	});
}
function customHeightSet(contentHeight,contentWidth){
		$("#content").height(contentHeight-50)
		$(".con").width(contentWidth)
		$(".con").height(contentHeight-50)
	}
</script>
<style>
#content{
	overflow:hidden;
	background-color:white;
	position:relative;
	width:100%;
}
.section{
	width:99999px;
	position:relative;
}
.section .con{
	float:left;
	position:relative;
	overflow-y:auto;
}

</style>
<!--多视图切换end-->
<body>
	<div class="nav_single_h">
		<ul>
			<li class="current"><a href="#section1">项目1</a></li>
			<li><a href="#section2">项目2</a></li>
			<li><a href="#section3">项目3</a></li>
			<li><a href="#section4">项目4</a></li>
			<li><a href="#section5">项目5</a></li>
			<div class="clear"></div>
		</ul>
	</div>
	
	
	
	
	<div id="content">
		<div class="section">
			
			<div class="con" id="section1">
	<div class="groupTitle"><span>选项内容1</span></div>
	<table class="tableStyle" mode="list">
		<tr>
			<th>姓名</th>
			<th>性别</th>
			<th>年龄</th>
			<th>工作</th>
			<th>联系方式</th>
			<th>住址</th>
			<th>婚姻状况</th>
			<th>备注</th>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
		</tr>
		<tr class="odd">
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
		</tr>
		<tr class="odd">
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
		</tr>
		<tr class="odd">
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
		</tr>
		<tr class="odd">
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
		</tr>
	</table>
			
			</div>
			
			
			<div class="con" id="section2">
	<div class="groupTitle"><span>选项内容2</span></div>
	<table class="tableStyle" formMode="transparent" footer="normal">
			<tr>
				<td width="15%">姓名：</td><td width="35%"><input type="text"/></td>
				<td width="15%">性别：</td>
				<td><select><option value="1">男</option><option value="2">女</option></select>
				</td>
			</tr>
			<tr>
				<td>生日：</td>
				<td><input type="text" class="date"/></td>
				<td>婚姻：</td>
				<td><select><option value="1">已婚</option><option value="2">未婚</option></select>
				</td>
			</tr>
			<tr>
				<td width="15%">籍贯：</td>
				<td width="35%">
					<select><option>北京市</option><option>天津市</option><option>黑龙江省</option></select>
				</td>
				<td width="15%">民族：</td>
				<td>
					<select><option value="1">汉族</option><option value="2">满族</option><option value="3">维吾尔族</option></select>
				</td>
			</tr>
			<tr>
				<td>学历：</td>
				<td>
				<select><option>博士</option><option>本科</option><option>大专</option><option>其它</option></select>				
				</td>
				<td>权限：</td>
				<td>
				<select><option value="1">新增图片</option><option value="2">维护图片</option><option value="3">新增新闻</option></select>
				</td>
			</tr>
		</table>			
			</div>
			
			
			<div class="con" id="section3">
	<div class="groupTitle"><span>选项内容3</span></div>
	<table class="tableStyle" formMode="transparent" footer="normal">
			<tr>
				<td width="15%">姓名：</td><td width="35%"><input type="text"/></td>
				<td width="15%">性别：</td>
				<td><select><option value="1">男</option><option value="2">女</option></select>
				</td>
			</tr>
			<tr>
				<td>生日：</td>
				<td><input type="text" class="date"/></td>
				<td>婚姻：</td>
				<td><select><option value="1">已婚</option><option value="2">未婚</option></select>
				</td>
			</tr>
			<tr>
				<td width="15%">籍贯：</td>
				<td width="35%">
					<select><option>北京市</option><option>天津市</option><option>黑龙江省</option></select>
				</td>
				<td width="15%">民族：</td>
				<td>
					<select><option value="1">汉族</option><option value="2">满族</option><option value="3">维吾尔族</option></select>
				</td>
			</tr>
			<tr>
				<td>学历：</td>
				<td>
				<select><option>博士</option><option>本科</option><option>大专</option><option>其它</option></select>				
				</td>
				<td>权限：</td>
				<td>
				<select><option value="1">新增图片</option><option value="2">维护图片</option><option value="3">新增新闻</option></select>
				</td>
			</tr>
		</table>			
			</div>
			
			
			<div class="con" id="section4">
	<div class="groupTitle"><span>选项内容4</span></div>
			<table class="tableStyle" mode="list">
		<tr>
			<th>姓名</th>
			<th>性别</th>
			<th>年龄</th>
			<th>工作</th>
			<th>联系方式</th>
			<th>住址</th>
			<th>婚姻状况</th>
			<th>备注</th>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
		</tr>
		<tr class="odd">
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
		</tr>
		<tr class="odd">
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
		</tr>
		<tr class="odd">
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
		</tr>
		<tr class="odd">
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				软件设计师
			</td>
			<td>15012546548</td>
			<td>
				家庭地址描述
			</td>
			<td>未婚</td>
			<td>备注信息</td>
		</tr>
	</table>		
			</div>
			
			
			<div class="con" id="section5">
	<div class="groupTitle"><span>选项内容5</span></div>
	<table class="tableStyle" formMode="transparent" footer="normal">
			<tr>
				<td width="15%">姓名：</td><td width="35%"><input type="text"/></td>
				<td width="15%">性别：</td>
				<td><select><option value="1">男</option><option value="2">女</option></select>
				</td>
			</tr>
			<tr>
				<td>生日：</td>
				<td><input type="text" class="date"/></td>
				<td>婚姻：</td>
				<td><select><option value="1">已婚</option><option value="2">未婚</option></select>
				</td>
			</tr>
			<tr>
				<td width="15%">籍贯：</td>
				<td width="35%">
					<select><option>北京市</option><option>天津市</option><option>黑龙江省</option></select>
				</td>
				<td width="15%">民族：</td>
				<td>
					<select><option value="1">汉族</option><option value="2">满族</option><option value="3">维吾尔族</option></select>
				</td>
			</tr>
			<tr>
				<td>学历：</td>
				<td>
				<select><option>博士</option><option>本科</option><option>大专</option><option>其它</option></select>				
				</td>
				<td>权限：</td>
				<td>
				<select><option value="1">新增图片</option><option value="2">维护图片</option><option value="3">新增新闻</option></select>
				</td>
			</tr>
		</table>		
			</div>
			
			
			
		</div>
	</div>


			
</body>
</html>