<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>本科实验实训场地情况</title>

		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/admin-all.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/other.css" />
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/jquery-1.7.2.js">
		</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/jquery-ui-1.8.22.custom.min.js">
		</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/textarea.js">
		</script>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />


		<script type="text/javascript">
			//日历插件
			$(function() {
				$(".datepicker").datepicker();
			})

			//确认修改赛项
			function modifyEditFulfillinginstance() {
	if (confirm("是否修改")) {
		document.getElementById("editFulfillinginstance").submit();
	}
}

		</script>

		 <script type="text/javascript">
	function divideopen(){
          var as = document.getElementById("num2").value;
          var bs = document.getElementById("num1").value;

          if(parseInt(as)>parseInt(bs))
          {
              alert("实开数应小于应开数");
              document.getElementById("num2").value="";

          }else{
          document.getElementById("rateopen").value = (parseInt(as)/parseInt(bs)).toFixed(2);  }
	}
	</script>


	</head>

	<body style="background-color:#e4dfd9"  onload="init();">
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业数据采集
			<b class="tip"></b>实验设备
		</div>

		<form action="editE.action" id="editE" method="post">


		    <table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">本科实验实训场地查询结果</caption>
				<thead>
					<tr>
						<td>
							#
						</td>
						<td>
							设备编号
						</td>

						<td>
							设备名称
						</td>
						<td>
							设备单价
						</td>
						<td>设备数量</td>
						<td>总价</td>
						<td>购置年份</td>
						<td>使用状态</td>

						<td>
							操作
						</td>
					</tr>
				</thead>
				<tbody>
					<s:if test="equipmentList.size() == 0">
						<tr>
							<td colspan="99" style="text-align: center;">没有查询赛项信息！</td>
						</tr>
					</s:if>
					<s:iterator value="equipmentList" status="L">
						<tr>
							<td>
								<s:property value="#L.index+1"/>
							</td>
							<td>
								<s:property value="equipNumber"/>
							</td>

							<td>
								<s:property value="equipName"/>
							</td>


							<td>
								<s:property value="ervValue"/>
							</td>
							<td>
								<s:property value="count"/>
							</td>
							<td>
								<s:property value="allValue"/>
							</td>
							<td>
								<s:property value="useingStatus"/>
							</td>

							<td>
								<s:property value="year"/>
							</td>


							<td>

								<a class="btn btn-mini btn-primary" href="editToTrainingvenue.action?traNumer=<s:property value="traNumer"/>">
									修改
								</a>
								<a class="btn btn-mini btn-primary" href="deleteTrainingvenue.action?traNumer=<s:property value="traNumer"/>" onclick="return confirm('是否删除')">
									删除
								</a>

							</td>
						</tr>
					</s:iterator>
				</tbody>
				<tfoot>
					<s:if test="equipmentList.size() > 0">
					<tr>

						<td><a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;		</td>
					</tr>
					</s:if>
				</tfoot>
			</table>









			</table>
		</form>
	</body>
</html>
