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

<!-- 日期选择框start -->
<script type="text/javascript" src="<%=path%>/libs/js/form/datePicker/WdatePicker.js"></script>
<!-- 日期选择框end -->

<!--平滑锚点start-->
<script type="text/javascript" src="<%=path%>/libs/js/other/smoothscroll.js"></script>
<!--平滑锚点end-->

<!--去除虚线链接start-->
<style>
a {
	behavior:url(<%=path%>/libs/js/method/focus.htc)
}
</style>
<!--去除虚线链接end-->
<script>
function initComplete(){
		var minNav=$('<div class="singleNavMin singleNavMinPositionFix"></div>');
		var length=6;
		for(var i=0;i<length;i++){
			var item=$('<div><span><a></a></span></div>');
			if(i==0){
				item.addClass("current");
			}
			var itemA=item.find("a");
			itemA.attr("href","#p"+(i+1));
			itemA.text("选项"+(i+1));
			minNav.append(item);
			var itemSpan=item.find("span");
			itemSpan.click(function(){
				minNav.find(">div").removeClass("current");
				$(this).parent("div").addClass("current");
			});
			itemSpan.hover(function(){
				$(this).animate({
					paddingLeft:'15px'
				},'fast');
			},function(){
				$(this).animate({
					paddingLeft:'5px'
				});
			});
		}
		$("body").append(minNav);
}		
</script>
</head>
<body>
		<div class="singleNavMinRight">
		<a name="p1"></a>
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
	
	<div style="height:30px;"></div>
	<a name="p2"></a>
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
		
		<div style="height:30px;"></div>
	<a name="p3"></a>	
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
		
		
		<div style="height:30px;"></div>
		<a name="p4"></a>
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
	
	<div style="height:30px;"></div>
	<a name="p5"></a>
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
		
		<div style="height:30px;"></div>
	<a name="p6"></a>
	<div class="groupTitle"><span>选项内容6</span></div>
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
		
		<div style="height:1000px;"></div>
</body>
</html>