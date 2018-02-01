<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>专业评估系统</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/mainShow/css/templatemo-style.css"> 
    <link href="${pageContext.request.contextPath}/lib/themes/insdep/easyui.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/lib/themes/insdep/easyui_animation.css" rel="stylesheet"
	type="text/css">
	<link href="${pageContext.request.contextPath}/lib/themes/insdep/easyui_plus.css" rel="stylesheet"
	type="text/css">
	<link href="${pageContext.request.contextPath}/lib/themes/insdep/insdep_theme_default.css" rel="stylesheet"
	type="text/css">
	<link href="${pageContext.request.contextPath}/lib/themes/insdep/icon.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/lib/plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Styles/admin-all.css" />

	<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery.insdep-extend.min.js"></script>



<script type="text/javascript">
   function logout(){
	   $.messager.confirm('系统提示','你确定要退出?',function(r){
		    if (r){
		    	window.location.href="user_exit.action"; 
		    }
	   });
   }
</script>
</head>


<body>
	<!--maincontener-->
	<div id="master-layout">
			<div
			data-options="region:'north',border:false,bodyCls:'theme-header-layout'"
			style="width:1920px;height:60px;">
			<div class="theme-navigate">
				<div class="left">
					<a href="#" class="easyui-linkbutton left-control-switch"><i class="fa fa-bars fa-lg"></i></a>
                    <a href="#" class="easyui-menubutton theme-navigate-user-button" data-options="menu:'.theme-navigate-user-panel'">${userInfo.userName}</a>
                    <a class="easyui-linkbutton" href="${pageContext.request.contextPath}/mainShow/mainShow2.html" target="maincontener" >首页</a>
                    <a href="#" class="easyui-menubutton" data-options="menu:'#mm1',hasDownArrow:false">基础数据维护</a>
                    <a href="#" class="easyui-menubutton" data-options="menu:'#mm2',hasDownArrow:false">专业数据采集</a>
                    <a href="#" class="easyui-menubutton" data-options="menu:'#mm3',hasDownArrow:false">评估数据统计</a>
                    <a href="#" class="easyui-menubutton" data-options="menu:'#mm4',hasDownArrow:false">评估管理</a>
                    <a href="#" class="easyui-menubutton" data-options="menu:'#mm5',hasDownArrow:false">定性数据处理</a>
<!--                    <a href="#" class="easyui-menubutton" data-options="menu:'#mm6',hasDownArrow:false">系统管理</a>-->
                    <a href="#" class="easyui-menubutton" data-options="menu:'#mm7',hasDownArrow:false">辅助信息</a>

					<div id="mm1" class="theme-navigate-menu-panel">
						<div><a 
						     href="teacher/teacherInitSearch.action?rol=1" 
						     target="maincontener">教师信息</a></div>
						<div><a
							 href="student/initSearch.action?rol=1"
							 target="maincontener">学生信息</a></div>
						<div><a
							 href="course/courseInitSearch.action?role=1"
							 target="maincontener">课程信息</a></div>
						<div><a
							 href="major/initSearch.action?rol=1"
							 target="maincontener">专业信息</a></div>
						<div><a
							 href="department/initSearch.action?rol=1"
							 target="maincontener">学院信息</a></div>
						<div><a
							 href="trainingvenue/initSearchtra.action?rol=1"
							 target="maincontener">实验室实习场地</a></div>
					</div>

					<div id="mm2" class="theme-navigate-menu-panel">
						<div><a target="maincontener" href="Tplan/initSearch.action?rol=1">教学计划变更</a></div>
						<div><a target="maincontener" href="Majorcourse/initSearch.action?rol=1">专业开课情况</a></div>
						<div><a target="maincontener" href="highleveltalent/highInitSearch.action?rol=1">高层次人才</a></div>
						<div><a target="maincontener" href="achievements/initSearchAchieve.action?rol=1">科研奖励</a></div>
						<div><a target="maincontener" href="presidedScientific/presInitSearch.action?rol=1">主持科研项目</a></div>
						<div><a target="maincontener" href="pap/initSearch.action?rol=1">科研论文</a></div>
						<div><a target="maincontener" href="pep/initSearch.action?rol=1">教改论文</a></div>
						<div><a target="maincontener" href="teat/initSearch.action?rol=1">教师进修培训</a></div>
						<div><span target="maincontener" href="tBooks/tBooks_initSearch.action?rol=1">出版教材</span></div>
						<div><span target="maincontener" href="presidedRevolution/prerInitSearch.action?rol=1">主持教改项目</span></div>
						<div><span target="maincontener" href="teachproject/teachproject_initSearch.action?rol=1">教学质量工程</span></div>
						<div><span target="maincontener" href="teachResultBase/teachResultBase_initSearch.action?rol=1">教学成果奖</span></div>
						<div><span target="maincontener" href="tea/initSearchtea.action?rol=1">教学经费使用情况</span></div>
						<div><span target="maincontener" href="curriculumresource/initSearch.action?rol=1">专业课程资源</span></div>
						<div><span target="maincontener" href="trainingvenueUsing/initSearch.action?rol=1">实验实训场地使用情况</span></div>
						<div><span target="maincontener" href="innovation/innovation_initSearch.action?rol=1">大学生科创情况</span></div>
						<div><span target="maincontener" href="eqe/initSearch.action?rol=1">人文素质教育</span></div>
						<div><span target="maincontener" href="lab/initSearch-Com.action?rol=1">学生国内外交流</span></div>
						<div><span target="maincontener" href="qualitystandard/initSearch.action?rol=1">课程质量标准</span></div>
						<div><span target="maincontener" href="addmissions/initSearch.action?rol=1">招生情况</span></div>
						<div><span target="maincontener" href="employment/initSearch.action?rol=1">就业情况</span></div>
						<div><span target="maincontener" href="competition/initSearchCompetition.action?rol=1">学科竞赛获奖情况</span></div>
						<div><span target="maincontener" href="stupatent/initSearch.action?rol=1">学生获得专利</span></div>
						<div><span target="maincontener" href="Stuthesis/initSearch.action?rol=1">学生发表论文</span></div>
						<div><span target="maincontener" href="Stuthesis/initSearch.action?rol=1">综合实践环节课程开出率</span></div>
						<div><span target="maincontener" href="tui/initSearch-TUsingInfo.action?rol=1">实践教学资源情况</span></div>
						<div><span target="maincontener" href="fia/initSearch.action?rol=1">定型数据上传</span></div>
					</div>

					<div id="mm3" class="theme-navigate-menu-panel">
						<div><a
							 href="teachersummary/summary_TeacherinfosummaryList.action?rol=1"
							 target="maincontener">专业教师基本情况</a></div>
						<div><a
							 href="teachersummary/summary_TeacherresearchsummaryList.action?rol=1"
							 target="maincontener">教学科研情况</a></div>
						<div><a
							 href="teachersummary/summary_StudentculturesummaryList.action?rol=1"
							 target="maincontener">学生培养情况</a></div>
						<div><a
							 href="teachersummary/summary_PracticecoursesummaryList.action?rol=1"
							 target="maincontener">实践教学情况</a></div>
						<div><span target="maincontener" href="prevent.jsp">其他情况统计</span></div>
						<div><a
							 href="teachersummary/summary_initSearch.action?rol=1"
							 target="maincontener">定性指标统计</a></div>
						<div><a target="maincontener" onclick="return confirm('确认更新统计数据吗？');"
										href="teachersummary/summary_summary.action?rol=1">更新统计数据</a></div>
					</div>

					<div id="mm4" class="theme-navigate-menu-panel">
						<div><a target="maincontener" href="Target/initSearch.action?rol=1">评估指标管理</a></div>
						<div><a target="maincontener" href="Aproject/initSearch.action?rol=1">评估项目管理</a></div>
						<div><a target="maincontener" href="Assneed/initSearch.action?rol=1">评估所学指标设置</a></div>
						<div><span target="maincontener" href="fun/funtionArgsInitSearch.action?rol=1">评估计算参数设置</span></div>
						<div><span target="maincontener" onclick="return confirm('确认进行评估分值计算吗？');"
										href="cal/calculateAllTarget.action?rol=1">评估分值计算</span></div>
						<div><span target="maincontener" href="Mas/initSearch.action?rol=1">评估指标分值查询</span></div>
						<div><a target="maincontener" href="cal/outPrint.action?rol=1">评估结果查询与分析</a></div>
						<div><a target="maincontener" href="cal/initSearchScore.action?rol=1">评估结果分类查询</a></div>
						<div><a target="maincontener" href="cal/exportReportPage.action?rol=1">导出数据分析报告</a></div>
					</div>

					<div id="mm5" class="theme-navigate-menu-panel">
						<div><a
							 href="Expertmanage/initSearch.action?rol=1"
							 target="maincontener">专家管理</a></div>
						<div><a
							 href="Expertmajor/addType.action?rol=1"
							 target="maincontener">任务分配</a></div>
						<div><a target="maincontener"
										href="Expertscore/initSearch.action?rol=1">专家评分</a></div>
						<div><a target="maincontener"
										href="Expertadvice/initSearch.action?rol=1">专家建议</a></div>

					</div>
				</div>

					<div id="mm7" class="theme-navigate-menu-panel">
						<div><a target="maincontener"
							 href="Sysuserinfo/modifyUserPassword.action">用户信息修改</a></div>
					</div>

					<div class="theme-navigate-user-panel">
						<dl>
							<dd>
								<img src="${pageContext.request.contextPath}/img/main/manager.jpg" width="86" height="86"> 
								<b class="badge-prompt">${userInfo.userName}</b> 
								<p>
									账号：<i class="text-success">${userInfo.userCode}</i>
								</p>
								<p>
									姓名：<i class="text-success">${userInfo.userName}</i>
								</p>
								<p>
									身份：<i class="text-success">${userInfo.sysrole.roleName}</i>
								</p>
							</dd>
							<dt>
								<a href="Sysuserinfo/modifyUserPassword.action" target="maincontener">修改资料</a> 
								<a class="theme-navigate-user-logout" href="javaScript:logout()">注销</a>
							</dt>
						</dl>
					</div>
				</div>
				<div class="right">
					<a href="#" class="easyui-menubutton theme-navigate-more-button" data-options="menu:'#more',hasDownArrow:false"></a>
					<div id="more" class="theme-navigate-more-panel">
						<div>联系我们</div>
						<div><a href="javaScript:logout()">退出登录</a></div>
					</div>					
				</div>
			</div>

		</div>
		
		

		<!--开始左侧菜单-->
		<div
			data-options="region:'west',border:false,bodyCls:'theme-left-layout'"
			style="width:250px;">


			<!--正常菜单-->
			<div class="theme-left-normal">
				<!--theme-left-switch 如果不需要缩进按钮，删除该对象即可-->
				<div class="left-control-switch theme-left-switch">
					<i class="fa fa-chevron-left fa-lg"></i>
				</div>

				<!--start class="easyui-layout"-->
				<div class="easyui-layout" data-options="border:false,fit:true"
					style="width:240px;height:372px;">
					<!--start region:'north'-->
					<div data-options="region:'north',border:false"
						style="height:100px;">
						<!--start theme-left-user-panel-->
						<div class="theme-left-user-panel">
							<dl>
								<dt>
									<img src="${pageContext.request.contextPath}/img/main/manager.jpg" width="43" height="43">
								</dt>
								<dd>
									<b class="badge-prompt"><font color="#329bfb">账号</font>：${userInfo.userCode} </b>
									<b class="badge-prompt"><font color="#329bfb">姓名</font>：${userInfo.userName} </b>
									<b class="badge-prompt"><font color="#329bfb">身份</font>：${userInfo.sysrole.roleName}</b>
								</dd>

							</dl>
						</div>
						<!--end theme-left-user-panel-->
					</div>
					<!--end region:'north'-->

					<!--start region:'center'-->
					<div data-options="region:'center',border:false">

						<!--start easyui-accordion-->
						<div class="easyui-accordion" data-options="border:false,fit:true"
							style="width:240px;height:272px;">
							<div title="基础数据维护">
								<ul class="easyui-datalist" data-options="border:false,fit:true">
									<li><a
										href="teacher/teacherInitSearch.action?rol=1"
										target="maincontener">1-1 教师信息</a></li>
									<li><a
										href="student/initSearch.action?rol=1"
										target="maincontener">1-2 学生信息</a></li>
									<li><a
										href="course/courseInitSearch.action?rol=1"
										target="maincontener">1-3 课程信息</a></li>
									<li><a
										href="major/initSearch.action?rol=1"
										target="maincontener">1-4 专业信息</a></li>
								</ul>
							</div>
							<div title="专业数据采集">
								<ul class="easyui-datalist" data-options="border:false,fit:true">
									<li><a target="maincontener"
										href="Tplan/initSearch.action?rol=1">2-1 教学计划变更</a></li>
									<li><a target="maincontener"
										href="Majorcourse/initSearch.action?rol=1">2-2 专业开课情况</a></li>
									<li><a target="maincontener"
										href="highleveltalent/highInitSearch.action?rol=1">2-3
										高层次人才</a></li>
									<li><a target="maincontener"
										href="achievements/initSearchAchieve.action?rol=1">2-4
										科研奖励</a></li>
									<li><a target="maincontener"
										href="presidedScientific/presInitSearch.action?rol=1">2-5
										主持科研项目</a></li>
									<li><a target="maincontener"
										href="pap/initSearch.action?rol=1">2-6 科研论文</a></li>
									<li><a target="maincontener"
										href="pep/initSearch.action?rol=1">2-7 教改论文</a></li>
									<li><a target="maincontener"
										href="teat/initSearch.action?rol=1">2-8 教师进修培训</a></li>
									<li><span target="maincontener"
										href="tBooks/tBooks_initSearch.action?rol=1">2-9 出版教材</span></li>
									<li><span target="maincontener"
										href="presidedRevolution/prerInitSearch.action?rol=1">2-10
										主持教改项目</span></li>
									<li><span target="maincontener"
										href="teachproject/teachproject_initSearch.action?rol=1">2-11
										教学质量工程</span></li>
									<li><span target="maincontener"
										href="teachResultBase/teachResultBase_initSearch.action?rol=1">2-12
										教学成果奖</span></li>
									<li><span target="maincontener"
										href="tea/initSearchtea.action?rol=1">2-13 教学经费使用情况</span></li>
									<li><span target="maincontener"
										href="curriculumresource/initSearch.action?rol=1">2-14 专业课程资源</span></li>
									<li><span
										href="trainingvenueUsing/initSearch.action?rol=1"
										target="maincontener">2-15 实验实训场地使用情况</span></li>
									<li><span target="maincontener"
										href="innovation/innovation_initSearch.action?rol=1">2-16
										大学生科创情况</span></li>
									<li><span target="maincontener"
										href="eqe/initSearch.action?rol=1">2-17 人文素质教育</span></li>
									<li><span target="maincontener"
										href="lab/initSearch-Com.action?rol=1">2-18 学生国内外交流</span></li>
									<li><span target="maincontener"
										href="qualitystandard/initSearch.action?rol=1">2-19 课程质量标准</span></li>
									<li><span target="maincontener"
										href="addmissions/initSearch.action?rol=1">2-20 招生情况</span></li>
									<li><span target="maincontener"
										href="employment/initSearch.action?rol=1">2-21 就业情况</span></li>
									<li><span target="maincontener"
										href="competition/initSearchCompetition.action?rol=1">2-22
										学科竞赛获奖情况</span></li>
									<li><span target="maincontener"
										href="stupatent/initSearch.action?rol=1">2-23 学生获得专利</span></li>
									<li><span target="maincontener"
										href="Stuthesis/initSearch.action?rol=1">2-24 学生发表论文</span></li>
									<li><span class="ti" target="maincontener"
										href="ful/initSearchful.action?rol=1">2-25 综合实践环节课程开出率</span></li>
									<li><span class="ti" target="maincontener"
										href="tui/initSearch-TUsingInfo.action?rol=1">2-26
										实践教学资源情况</span></li>
									<li><span target="maincontener"
										href="fia/initSearch.action?rol=1">2-27 定性数据上传</span></li>
								</ul>
							</div>
							<div title="评估数据统计">
								<ul class="easyui-datalist" data-options="border:false,fit:true">
									<li><a target="maincontener"
										href="teachersummary/summary_TeacherinfosummaryList.action?rol=1">3-1
										专业教师基本情况</a></li>
									<li><a target="maincontener"
										href="teachersummary/summary_TeacherresearchsummaryList.action?rol=1">3-2
										教学科研情况</a></li>
									<li><a target="maincontener"
										href="teachersummary/summary_StudentculturesummaryList.action?rol=1">3-3
										学生培养情况</a></li>
									<li><span target="maincontener"
										href="teachersummary/summary_PracticecoursesummaryList.action?rol=1">3-4
										实践教学情况</span></li>
									<li><span target="maincontener"
										href="prevent.jsp">3-5
										其他情况统计</span></li>
									<li><a target="maincontener"
										href="teachersummary/summary_initSearch.action?rol=1">3-6
										定性指标统计</a></li>
									<li><a target="maincontener" onclick="return confirm('确认更新统计数据吗？');"
									href="teachersummary/summary_summary.action?rol=1">3-7
									更新统计数据</a></li>
								</ul>
							</div>
							<div title="评估管理">
								<ul class="easyui-datalist" data-options="border:false,fit:true">

									<li><a target="maincontener"
										href="Target/initSearch.action?rol=1">4-1 评估指标管理</a></li>
									<li><a target="maincontener"
										href="Aproject/initSearch.action?rol=1">4-2 评估项目管理</a></li>
									<li><a target="maincontener"
										href="Assneed/initSearch.action?rol=1">4-3 评估所需指标设置</a></li>
									<li><span target="maincontener"
										href="fun/funtionArgsInitSearch.action?rol=1">4-4 评估计算参数设置</span></li>
									<li><span target="maincontener"  onclick="return confirm('确认进行评估分值计算吗？');"
										href="cal/calculateAllTarget.action?rol=1">4-5 评估分值计算</span></li>
									<li><span target="maincontener"
										href="Mas/initSearch.action?rol=1">4-6 评估指标分值查询</span></li>
									<li><a target="maincontener" href="cal/outPrint.action?rol=1">4-7
										评估结果查询与分析</a></li>
									<li><a target="maincontener" href="cal/initSearchScore.action?rol=1">4-8
										评估结果分类查询</a></li>
									<li><a target="maincontener" href="cal/exportReportPage.action?rol=1">4-9
										导出数据分析报告</a></li>
								</ul>
							</div>
							<div title="定性数据处理">
								<ul class="easyui-datalist" data-options="border:false,fit:true">
									<li><a target="maincontener"
										href="Expertmanage/initSearch.action?rol=1">5-1 专家管理</a></li>
									<li><a target="maincontener"
										href="Expertmajor/addType.action?rol=1">5-2 任务分配</a></li>
									<li><a target="maincontener"
										href="Expertscore/initSearch.action?rol=1">5-3 专家评分</a></li>
									<li><a target="maincontener"
										href="Expertadvice/initSearch.action?rol=1">5-4 专家建议</a></li>
								</ul>
							</div>
							<div title="辅助信息">
								<ul class="easyui-datalist" data-options="border:false,fit:true">
									<li><a target="maincontener"
										href="Sysuserinfo/modifyUserPassword.action">6-1 用户信息修改</a></li>
								</ul>
							</div>

						</div>
						<!--end easyui-accordion-->

					</div>
					<!--end region:'center'-->
				</div>
				<!--end class="easyui-layout"-->

			</div>
			<!--最小化菜单-->
			<div class="theme-left-minimal">
				<ul class="easyui-datalist" data-options="border:false,fit:true">
					<li><p></p></li>
					<li><p></p></li>
					<li><p></p></li>
					<li><p></p></li>
					<li><p></p></li>
					<li><a href="${pageContext.request.contextPath}/mainShow/mainShow2.html" target="maincontener"><i class="fa fa-book fa-2x"></i>
						<p>首页</p></li></a>
					<li><a class="left-control-switch"><i
							class="fa fa-chevron-right fa-2x"></i>
							<p>打开</p></a></li>
				</ul>
			</div>


		</div>
		<!--结束左侧菜单-->

		<div data-options="border:false,region:'center'" id="control"
			style="padding:20px; background:#fff;">
			<iframe src="${pageContext.request.contextPath}/mainShow/mainShow2.html" width="100%" height="100%"
				name="maincontener" style="border: 0";></iframe>
		</div>
		
		<div id="loader-wrapper">           
            <div id="loader"></div>
            <div class="loader-section section-left"></div>
            <div class="loader-section section-right"></div>
        </div>
	</div>

	<script>
		$(function() {

			/*布局部分*/
			$('#master-layout').layout({
				fit : true
			/*布局框架全屏*/
			});

			/*右侧菜单控制部分*/

			var left_control_status = true;
			var left_control_panel = $("#master-layout")
					.layout("panel", 'west');

			$(".left-control-switch").on("click", function() {
				if (left_control_status) {
					left_control_panel.panel('resize', {
						width : 70
					});
					left_control_status = false;
					$(".theme-left-normal").hide();
					$(".theme-left-minimal").show();
				} else {
					left_control_panel.panel('resize', {
						width : 250
					});
					left_control_status = true;
					$(".theme-left-normal").show();
					$(".theme-left-minimal").hide();
				}
				$("#master-layout").layout('resize', {
					width : '100%'
				})
			});

			/*右侧菜单控制结束*/

			$(".theme-navigate-user-modify").on("click", function() {
				$('.theme-navigate-user-panel').menu('hide');
				$.insdep.window({
					id : "personal-set-window",
					href : "user.html",
					title : "修改资料"
				});

			});
			//$.insdep.control("list.html");

			var cc1 = $('#cc1').combo('panel');
			cc1.panel({
				cls : "theme-navigate-combobox-panel"
			});
			var cc2 = $('#cc2').combo('panel');
			cc2.panel({
				cls : "theme-navigate-combobox-panel"
			});

			/*$("#open-layout").on("click",function(){
					var option = {
						"region":"west",
						"split":true,
			            "title":"title",
						"width":180
					};
					$('#master-layout').layout('add', option);

			});*/

		});
		function doSearch(value, name) {
			alert('You input: ' + value + '(' + name + ')');
		}
	</script>
	
	<script src="${pageContext.request.contextPath}/mainShow/js/tether.min.js"></script> 
    <script src="${pageContext.request.contextPath}/mainShow/js/bootstrap.min.js"></script>            
    <script src="${pageContext.request.contextPath}/mainShow/js/hero-slider-main.js"></script>          
    <script src="${pageContext.request.contextPath}/mainShow/js/jquery.magnific-popup.min.js"></script> 
        
        <script>

            function adjustHeightOfPage(pageNo) {

                var offset = 80;
                var pageContentHeight = 0;

                var pageType = $('div[data-page-no="' + pageNo + '"]').data("page-type");

                if( pageType != undefined && pageType == "gallery") {
                    pageContentHeight = $(".cd-hero-slider li:nth-of-type(" + pageNo + ") .tm-img-gallery-container").height();
                }
                else {
                    pageContentHeight = $(".cd-hero-slider li:nth-of-type(" + pageNo + ") .js-tm-page-content").height();
                }

                if($(window).width() >= 992) { offset = 120; }
                else if($(window).width() < 480) { offset = 40; }
               
                var totalPageHeight = 15 + $('.cd-slider-nav').height()
                                        + pageContentHeight + offset
                                        + $('.tm-footer').height();

                if(totalPageHeight > $(window).height()) 
                {
                    $('.cd-hero-slider').addClass('small-screen');
                    $('.cd-hero-slider li:nth-of-type(' + pageNo + ')').css("min-height", totalPageHeight + "px");
                }
                else 
                {
                    $('.cd-hero-slider').removeClass('small-screen');
                    $('.cd-hero-slider li:nth-of-type(' + pageNo + ')').css("min-height", "100%");
                }
            }

            $(window).load(function(){

                adjustHeightOfPage(1); 

                $('#tmNavbar a').click(function(){
                    $('#tmNavbar').collapse('hide');

                    adjustHeightOfPage($(this).data("no"));      
                });

                $( window ).resize(function() {
                    var currentPageNo = $(".cd-hero-slider li.selected .js-tm-page-content").data("page-no");
                    setTimeout(function() {
                        adjustHeightOfPage( currentPageNo );
                    }, 1000);
                    
                });
        
                $('body').addClass('loaded');
                           
            });
        </script> 
	

</body>

</html>

