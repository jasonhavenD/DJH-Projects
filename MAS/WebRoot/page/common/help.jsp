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
        <style type="text/css">
          p{ line-height:30px;}
        </style>
	</head>

	<body>
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>评分说明
		</div>


		<div style="margin-bottom: 10px; margin-top: 10px; font-size: 16px; font-weight: bold; ">
			<img src="${pageContext.request.contextPath}/img/main/person.png" alt="user"
				style="margin: 2px; padding-right: 5px; width: 24px; height: 24px;"></img>
			${userInfo.userName}${userInfo.sysrole.roleName}教授,您好！欢迎使用西北农林科技大学专业评估管理系统
		</div>
       <br/>
		<div style="width:1500px ;margin-bottom: 10px; margin-top: 5px;margin-left:30px;">
			<center><span style="font-size: 22px; font-weight: bold;">专业评估专家须知</span></center>
			<br />
			

			<ul style="font-size: 16px; margin-left:30px;"><!--  font-weight:600 -->
			<p>尊敬的专家：</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;您好！</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;感谢您参与学校2016年度本科专业评估工作。</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;专业评估指标体系由8个一级指标、24个二级指标、80个观测点组成。观测点中的定量数据由系统自动计算，现邀请您对指定专业的定性数据进行综合评比、打分。</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;评估之前，请您仔细阅读以下操作说明：</p>
				<li>
					<p>1.登录西北农林科技大学专业评估管理系统，网址：http://219.245.196.48/MAS/</p>
				</li>
				<li>
					<p>2.依次输入用户名（本人工号）、密码（初始密码为123456）、类型（按右侧下拉菜单选择“专家”）和验证码，点击“登录”按钮进入评估系统。</p>
				</li>
				<li>
					<p>3.点击左侧“辅助信息”下的 “用户信息修改”，及时修改用户密码。</p>
				</li>
				<li>
					<p>4.点击左侧“定性数据处理”下的“专家评分”，在右侧界面中即可看到您所评估专业的所有定性数据列表。</p>
				</li>
				<li>
					<p>5.在“所在专业”右侧的下拉菜单中，我们已为您分配了待评估专业，请您逐个选择，点击“查询”，即显示该专业22个定性数据观测点列表；</p>
				</li>
				<li>
					<p>6.点击每一个观测点右侧的“查看”按钮，可在线预览到该观测点的文字描述材料，评阅后在“评分”栏中输入分值，点击保存即可。如需修改分值，重新在“评分”栏中输入分值，点击保存即可。请各位专家以客观公正、严肃认真的态度对每个专业、每个观测点予以客观的分数。</p>
			<p>分值说明：采用百分制评分，设三个分值段，优秀：90-100分；良好：80-89分；一般：70-79分。</p>
				</li>
				<li>
					<p>7.完成所有专业、所有观测点评分后，在界面右上角“是否已评分”下拉菜单中选择“否”（如下图所示），可检查遗漏未评分的观测点，完成评分即可。</p>
					<img src="${pageContext.request.contextPath}/img/main/help.png"></img>
				</li>
				<li>
					<p>8.点击左侧“定性数据处理”栏选择“专家建议”，点击“所在专业”右侧的下拉菜单，选择需要评估的专业，并点击“查询”，出现专家评估意见表，填写该专业存在的问题及整改意见和建议，最后点击“提交”按钮进行保存。</p>
				</li>
				
				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;评估过程中如有问题请致电87092488咨询（联系人：张永）。</p>
				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请于11月25日前完成评分及意见填写。感谢您对学校本科专业评估工作的支持！</p>
				<p align="right" style="margin-right:30px">教务处</p>
			</ul>		
		
		</div>

	</body>
</html>
