<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>评估结果分类查询</title>

		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/admin-all.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/other.css" />
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/jquery-1.7.2.js">
		</script>
		<style type="text/css">
			${demo.css}
		</style>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/jquery-ui-1.8.22.custom.min.js">
</script>
<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/MajorByDno.js">
</script>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
		<script type="text/javascript">
</script>

<script type="text/javascript">
		$(function(){
				$.ajax({
				type:'POST',
				datatype:"json",
				url:"findGraphData.action",
				data:{
					pName:'',
					order:'9',
					mc:''
				},
				contentType: "application/x-www-form-urlencoded; charset=utf-8",
				success:function(json){
					var b1 = json.jMname;
					var b2 = json.jScore;
					var avg = json.average.toFixed(2);
					var max = json.max.toFixed(2);
					var min = json.min.toFixed(2);
					var tempVal = (min-20)/10;
					var initVal = (parseInt(tempVal)+1)*10;
					var b3 = [];
					var count = b1.length;
					for(var i=0;i<b2.length;i++){
						b3.push(parseFloat(b2[i].toFixed(2))) ;
					}
					$('#container').highcharts({
				        	chart: {
				                type: 'column'
				            },
				            title: {
				                text:'全校'+count+'个专业   评估得分  总分   柱状图'
				            },
				            subtitle: {
				                text: ''
				            },
				            xAxis: {
				                categories: b1,
				                labels: {
				                    rotation: -50,
				                    style: {
				                        fontSize: '13px',
				                        fontFamily: '微软雅黑',
				                        color:'black'
				                    }
				                }
				            },
				            yAxis: {
				                min:initVal,
				                title: {
				                    text: '分数(分)'
				                },
				                plotLines:[{
        							color:'blue',           		//线的颜色，定义为红色
       	 							dashStyle:'solid',     		//默认值，这里定义为实线dash,dot,solid
        							value: avg,               	//定义在那个值上显示标示线，这里是在x轴上刻度为3的值处垂直化一条线
        							width:2,                	//标示线的宽度，2px
        							    label:{
        							        style: {
        							            fontSize: '12px',                        // 标签全局样式
        										color: "blue",
        										fontWeight: 'normal'
    										},
        							    	rotation: 0 ,
        									text:'平均分:<br/>'+avg,     		//标签的内容
        									align:'left',          //标签的水平位置，水平居左,默认是水平居中center
        									x:-70,					//标签相对于被定位的位置水平偏移的像素，重新定位，水平居左10px
        									y:0
    									}
    							},
    							{
        							color:'green',           		//线的颜色，定义为红色
       	 							dashStyle:'solid',     		//默认值，这里定义为实线dash,dot,solid
        							value: max,               	//定义在那个值上显示标示线，这里是在x轴上刻度为3的值处垂直化一条线
        							width:2,                	//标示线的宽度，2px
        							    label:{
        							        style: {
        							            fontSize: '12px',                        // 标签全局样式
        										color: "green",
        										fontWeight: 'normal'
    										},
        							    	rotation: -90 ,
        									text:max,     		//标签的内容
        									align:'left',          //标签的水平位置，水平居左,默认是水平居中center
        									x:0,					//标签相对于被定位的位置水平偏移的像素，重新定位，水平居左10px
        									y:0
    									}
    							},
    							{
        							color:'red',           		//线的颜色，定义为红色
       	 							dashStyle:'solid',     		//默认值，这里定义为实线dash,dot,solid
        							value: min,               	//定义在那个值上显示标示线，这里是在x轴上刻度为3的值处垂直化一条线
        							width:2,                	//标示线的宽度，2px
        							    label:{
        							        style: {
        							            fontSize: '12px',                        // 标签全局样式
        										color: "red",
        										fontWeight: 'normal'
    										},
        							    	rotation: -90,
        									text:min,     		//标签的内容
        									align:'left',          //标签的水平位置，水平居左,默认是水平居中center
        									x:0,					//标签相对于被定位的位置水平偏移的像素，重新定位，水平居左10px
        									y:35
    									}
    							}
    							]
				            },
				            legend: {
				                enabled: false
				            },
				            tooltip: {
				                pointFormat: '分数: <b>{point.y:.1f} 分</b>',
				            },
				            series: [{
				                name: '专业',
								data: b3,
				                dataLabels: {
				                    enabled: true,
				                    rotation: -90,
				                    color: 'black',
				                    align: 'right',
				                    x: 3,
				                    y: -45,
				                    style: {
				                        fontSize: '14px',
				                        fontFamily: 'Verdana, sans-serif',
				                        color: 'black'
				                    }
				                }
				            }]
				    });
				}
				});
		});
		function search(){
			$.ajax({
				type:'POST',
				datatype:"json",
				url:"findGraphData.action",
				data:{
					pName:$("#pName").val(),
					order:$("#order").val(),
					mc:$("#category").val()
				},
				contentType: "application/x-www-form-urlencoded; charset=utf-8",
				success:function(json){
					var b1 = json.jMname;
					var b2 = json.jScore;
					var avg = json.average.toFixed(2);
					var max = json.max.toFixed(2);
					var min = json.min.toFixed(2);
					var tempVal = (min-20)/10;
					var initVal = (parseInt(tempVal)+1)*10;
					var b3 = [];
					for(var i=0;i<b2.length;i++){
						b3.push(parseFloat(b2[i].toFixed(2))) ;
					}
					var count  = b1.length;
					$('#container').highcharts({
				        	chart: {
				                type: 'column'
				            },
				            title: {
				                text:$("#category").find("option:selected").text()+count+'个专业  ——'+$("#order").find("option:selected").text()+'——柱状图'
				            },
				            subtitle: {
				                text: ''
				            },
				            xAxis: {
				                categories: b1,
				                labels: {
				                    rotation: -50,
				                    style: {
				                        fontSize: '13px',
				                        fontFamily: '微软雅黑',
				                        color:'black'
				                    }
				                }
				            },
				            yAxis: {
				                min:initVal,
				                title: {
				                    text: '分数(分)'
				                },
				                plotLines:[{
        							color:'blue',           		//线的颜色，定义为红色
       	 							dashStyle:'solid',     		//默认值，这里定义为实线dash,dot,solid
        							value: avg,               	//定义在那个值上显示标示线，这里是在x轴上刻度为3的值处垂直化一条线
        							width:2,                	//标示线的宽度，2px
        							    label:{
        							        style: {
        							            fontSize: '12px',                        // 标签全局样式
        										color: "blue",
        										fontWeight: 'normal'
    										},
        							    	rotation: 0 ,
        									text:'平均分:<br/>'+avg,     		//标签的内容
        									align:'left',          //标签的水平位置，水平居左,默认是水平居中center
        									x:-70,					//标签相对于被定位的位置水平偏移的像素，重新定位，水平居左10px
        									y:0
    									}
    							},
    							{
        							color:'green',           		//线的颜色，定义为红色
       	 							dashStyle:'solid',     		//默认值，这里定义为实线dash,dot,solid
        							value: max,               	//定义在那个值上显示标示线，这里是在x轴上刻度为3的值处垂直化一条线
        							width:2,                	//标示线的宽度，2px
        							    label:{
        							        style: {
        							            fontSize: '12px',                        // 标签全局样式
        										color: "green",
        										fontWeight: 'normal'
    										},
        							    	rotation: -90 ,
        									text:max,     		//标签的内容
        									align:'left',          //标签的水平位置，水平居左,默认是水平居中center
        									x:0,					//标签相对于被定位的位置水平偏移的像素，重新定位，水平居左10px
        									y:0
    									}
    							},
    							{
        							color:'red',           		//线的颜色，定义为红色
       	 							dashStyle:'solid',     		//默认值，这里定义为实线dash,dot,solid
        							value: min,               	//定义在那个值上显示标示线，这里是在x轴上刻度为3的值处垂直化一条线
        							width:2,                	//标示线的宽度，2px
        							    label:{
        							        style: {
        							            fontSize: '12px',                        // 标签全局样式
        										color: "red",
        										fontWeight: 'normal'
    										},
        							    	rotation: -90 ,
        									text:min,     		//标签的内容
        									align:'left',          //标签的水平位置，水平居左,默认是水平居中center
        									x:0,					//标签相对于被定位的位置水平偏移的像素，重新定位，水平居左10px
        									y:35
    									}
    							}
    							]
				            },
				            legend: {
				                enabled: false
				            },
				            tooltip: {
				                pointFormat: '分数: <b>{point.y:.1f} 分</b>',
				            },
				            series: [{
				                name: '专业',
								data: b3,
				                dataLabels: {
				                    enabled: true,
				                    rotation: -90,
				                    color: 'black',
				                    align: 'right',
				                    x: 3,
				                    y: -45,
				                    style: {
				                        fontSize: '14px',
				                        fontFamily: 'Verdana, sans-serif',
				                        color: 'black'
				                    }
				                }
				            }]
				    });
				}
				});
		}
</script>
</head>
<body style="background-color:#e4dfd9" >
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/highcharts/highcharts.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/highcharts/modules/exporting.js"></script>
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>评估管理
			<b class="tip"></b>评估结果分类查询
		</div>
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99" style="height:30px; font-size: 15px; vertical-align: middle;">
							评估结果分类查询柱状图
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
					<td style="width:10px; text-align:center;">
							专业类别
						</td>
						<td style="width:20px;">
							<select size="1" id="category" name="basemodel.departmentId"
								class="department" onchange="categorychange();">
								<option value="">
									全部类别
								</option>
								<s:iterator value="majorClassList">
									<option value="<s:property value='classcode'/>">
										<s:property value="classname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width:10px;">
							开启评估项目名称
						</td>
						<td style="width:10px;">
							<select size="1" name="basemodel.Name" id="pName">
								<s:iterator value="projectList">
									<option value="<s:property value='masprojectName'/>">
										<s:property value="masprojectName" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width: 60px; font-size: 15px; vertical-align: middle;">
							选择查看评估项分值
						</td>
						<td style="width: 60px;">
							<select size="1" id="order" name="basemodel.id"
								class="department" onchange="collchange();">
								<option value="9">
									9.总分
								</option>
								<option value="1">
									1.专业设置
								</option>
								<option value="2">
									2.培养模式
								</option>
								<option value="3">
									3.师资队伍
								</option>
								<option value="4">
									4.教学资源
								</option>
								<option value="5">
									5.培养过程
								</option>
								<option value="6">
									6.教学质量保证
								</option>
								<option value="7">
									7.学生发展
								</option>
								<option value="8">
									8.专业特色
								</option>

							</select>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td style="width: 100px;">
							<a class="btn btn-primary add" id="search" href="javascript:search()">查询</a>&nbsp;&nbsp;
						</td>
						<td colspan="9">
							<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
						</td>
					</tr>
				</tfoot>
			</table>
<br />
<br />
<div id="container" style="min-width: 500px; height: 500px; margin: 0 auto;border: 1px solid #e0e0e0;"></div>
<br />
	</body>

</html>
