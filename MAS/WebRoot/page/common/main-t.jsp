<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>


		<title>首页</title>

		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/admin-all.css" />
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/jquery-1.7.2.js">
</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/jquery-ui-1.8.22.custom.min.js">
</script>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />

		<link href="${pageContext.request.contextPath}/Styles/main/main.css"
			rel="stylesheet" type="text/css" />

	</head>

	<body>
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>首页
		</div>


		<div
			style="margin-bottom: 10px; margin-top: 10px; font-size: 14px; font-weight: bold;">
			<img src="../../img/main/person.png" alt="user"
				style="margin: 2px; padding-right: 5px; width: 24px; height: 24px;"></img>
			${userInfo.userName},${userInfo.sysrole.roleName},您好！欢迎使用专业评估管理系统
		</div>

		<div style="margin-bottom: 10px; margin-top: 5px;">
			<span style="font-size: 14px; font-weight: bold;"> <img
					src="../../img/main/dp.png"
					style="margin: 2px; padding-right: 5px; width: 24px; height: 24px;"></img>专业评估管理系统使用指南</span>
			<br />
			<span style="font-size: 14px; margin-left: 40px;"><img
					src="../../img/main/flag_blue.png"></img>基础数据维护</span>
			<ul>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">教师信息管理</span>&nbsp;&nbsp;(维护教师基本信息)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">学生信息管理</span>&nbsp;&nbsp;(维护学生基本信息)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">课程信息</span>&nbsp;&nbsp;(维护课程基本信息)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">专业信息</span>&nbsp;&nbsp;(维护专业基本信息)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">学院信息</span>&nbsp;&nbsp;(维护学院基本信息)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">编码表</span>&nbsp;&nbsp;(浏览编码信息表)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">实验室实习场地</span>&nbsp;&nbsp;(实验室实习场地管理)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">校外基地</span>&nbsp;&nbsp;(校外基地使用情况)
				</li>

			</ul>
			<span style="font-size: 14px; margin-left: 40px;"><img
					src="../../img/main/flag_blue.png"></img>专业数据采集</span>
			<ul>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">教学计划变更</span>&nbsp;&nbsp;(添加、修改教学计划变更情况数据)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">专业开课情况</span>&nbsp;&nbsp;(添加、修改每年专业开课数据)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">高层次人才</span>&nbsp;&nbsp;(浏览、修改高层次人才数据)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">学术论文</span>&nbsp;&nbsp;(上报科研发表学术论文数据)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">科研奖励</span>&nbsp;&nbsp;(上报科研成果奖励数据)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">主持科研项目</span>&nbsp;&nbsp;(上报主持科研发项目数据)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">教改论文</span>&nbsp;&nbsp;(浏览、修改教改论文数据)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">出版教材</span>&nbsp;&nbsp;(浏览、修改出版教材情况数据)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">主持教改项目</span>&nbsp;&nbsp;(浏览、修改主持教改项目数据)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">教学质量工程</span>&nbsp;&nbsp;(浏览、修改教学质量工程数据)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">教学成果奖</span>&nbsp;&nbsp;(浏览、修改教学成果奖数据)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">教学经费使用情况</span>&nbsp;&nbsp;(上报教学经费使用情况统计数据)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">专业课程建设</span>&nbsp;&nbsp;(上报专业建设情况统计数据)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">实验实习场地使用</span>&nbsp;&nbsp;(上报实验实习场地使用情况统计数据)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">校外基地使用</span>&nbsp;&nbsp;(上报校外基地使用情况统计数据)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">大学生科创情况</span>&nbsp;&nbsp;(上报大学生科创情况统计数据)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">实践教学情况</span>&nbsp;&nbsp;(上报实践教学情况统计数据)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">人文素质教育</span>&nbsp;&nbsp;(上报人文素质教育情况统计数据)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">学生国内交流</span>&nbsp;&nbsp;(上报学生国内交流情况统计数据)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">课程质量标准</span>&nbsp;&nbsp;(上报专业课程质量标准情况统计数据)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">招生情况</span>&nbsp;&nbsp;(浏览招生情况信息)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">就业情况</span>&nbsp;&nbsp;(浏览就业情况信息)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">学科竞赛获奖情况</span>&nbsp;&nbsp;(上报专业课程质量标准情况统计数据)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">学生获得专利</span>&nbsp;&nbsp;(上报专业课程质量标准情况统计数据)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">学生发表论文</span>&nbsp;&nbsp;(上报专业课程质量标准情况统计数据)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">定性数据上传</span>&nbsp;&nbsp;(上报定性指标材料文件)
				</li>

			</ul>
			<span style="font-size: 14px; margin-left: 40px;"><img
					src="../../img/main/flag_blue.png"></img>评估管理</span>
			<ul>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">评估项目管理</span>&nbsp;&nbsp;(对参与评估的项目进行管理)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">评估指标设置</span>&nbsp;&nbsp;(对各项评估指标进行管理)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">评估计算</span>&nbsp;&nbsp;
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">评估结果</span>&nbsp;&nbsp;(对各项评估项目具体评估结果进行查询)
				</li>
			</ul>
			<span style="font-size: 14px; margin-left: 40px;"><img
					src="../../img/main/flag_blue.png"></img>定性数据处理</span>
			<ul>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">专家管理</span>&nbsp;&nbsp;(对校内专家数据管理))
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">任务分配</span>&nbsp;&nbsp;(对专家进行专业分配)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">专家评分</span>&nbsp;&nbsp;(对专家在专业建设水平，存在主要问题、解决思路及措施等指标基础上进行评分)
				</li>
			</ul>
			<span style="font-size: 14px; margin-left: 40px;"><img
					src="../../img/main/flag_blue.png"></img>系统管理</span>
			<ul>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">用户管理</span>&nbsp;&nbsp;(完成对所有具有登录本测评系统权限的用户信息管理)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">角色管理</span>&nbsp;&nbsp;(完成对所有具有登录本测评系统权限的用户权限管理)
				</li>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">数据备份</span>&nbsp;&nbsp;
				</li>
			</ul>
			<span style="font-size: 14px; margin-left: 40px;"><img
					src="../../img/main/flag_blue.png"></img>辅助信息</span>
			<ul>
				<li>
					<img src="../../img/main/ulist.png"></img>
					<span style="font-weight: bold;">用户信息修改</span>&nbsp;&nbsp;(修改用户密码)
				</li>
			</ul>
		</div>
		<div
			style="margin-bottom: 10px; margin-top: 10px; font-size: 14px; font-weight: bold;">
			<img src="../../img/main/t05.png"
				style="width: 24px; height: 24px; margin: 2px; padding-right: 5px;"></img>
			密码修改
		</div>

	</body>
</html>
