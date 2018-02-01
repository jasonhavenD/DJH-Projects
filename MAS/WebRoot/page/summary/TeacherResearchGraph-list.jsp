<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>专业教师科研教研情况统计</title>
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

		$(function(){
						$.ajax({
				type:'POST',
				datatype:"json",
				url:"findSTeacherresearchsummaryCount.action",
				data:{
					major:$("#major").val(),
					coll:$("#coll").val(),
					year:$("#year").val(),
					num:$('#num').val()
				},
				contentType: "application/x-www-form-urlencoded; charset=utf-8",
				success:function(jsonArray){
					var str1=jsonArray.jsonarray;
					browsers = [];
					browsers1 = [];
					for(i=0;i<str1.length;i++){
						browsers.push([str1[i].ResearchPaperNumber1,parseFloat(str1[i].count1.toFixed(4))]);
						browsers.push([str1[i].ResearchPaperNumber2,parseFloat(str1[i].count2.toFixed(4))]);
       					browsers.push([str1[i].ResearchPaperNumber3,parseFloat(str1[i].count3.toFixed(4))]);
       					browsers1.push([str1[i].ResearchPaperCount1,str1[i].sum1]);
						browsers1.push([str1[i].ResearchPaperCount2,str1[i].sum2]);
       					browsers1.push([str1[i].ResearchPaperCount3,str1[i].sum3]);
					}
					//柱状图
						$('#container1').highcharts({
				            chart: {
				                type: 'column'
				            },
				            title: {
				                text: $('#year').val()+'年  '+$('#coll').find("option:selected").text()+$('#major').find("option:selected").text()+$('#num').find("option:selected").text()+'   柱状图'
				            },
				            subtitle: {
				                text: ''
				            },
				            xAxis: {
				                type: 'category',
				                labels: {
				                    rotation: 0,
				                    style: {
				                       fontSize: '13px',
				                        fontFamily: '微软雅黑',
				                        color:'black'
				                    }
				                }
				            },
				            yAxis: {
				                min: 0,
				                title: {
				                    text: $('#num').find("option:selected").text()+'个数 (个)'
				                }
				            },
				            legend: {
				                enabled: false
				            },
				            tooltip: {
				                pointFormat: $('#num').find("option:selected").text()+'个数: <b>{point.y:.0f} 个</b>',
				            },
				            series: [{
				                name: '级别名称',
								data: browsers1,
				               dataLabels: {
				                    enabled: true,
				                    rotation: 0,
				                    color: 'black',
				                    align: 'right',
				                    x: -40,
				                    y: -30,
				                    style: {
				                        fontSize: '14px',
				                        fontFamily: 'Verdana, sans-serif',
				                        color: 'black',
				                        textShadow: '0 0 13px black'
				                    }
				                }
				            }]
				        });


       				console.log(browsers);

       				//饼图
					    $('#container').highcharts({
					        chart: {
					            plotBackgroundColor: null,
					            plotBorderWidth: 1,//null,
					            plotShadow: false
					        },
					        title: {
					            text: $('#year').val()+'年  '+$('#coll').find("option:selected").text()+$('#major').find("option:selected").text()+$('#num').find("option:selected").text()+'   统计饼图'
					        },
					        tooltip: {
					    	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
					        },
					        plotOptions: {
					            pie: {
					                allowPointSelect: true,
					                cursor: 'pointer',
					                dataLabels: {
					                    enabled: true,
					                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
					                    style: {
					                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
					                    }
					                }
					            }
					        },
					        series: [{
					            type: 'pie',
					            name: '',
					            data: browsers

					        }]
					    });//chart


				}
			});


			$('#lalala').click(function(){
			$.ajax({
				type:'POST',
				datatype:"json",
				url:"findSTeacherresearchsummaryCount.action",
				data:{
					major:$("#major").val(),
					coll:$("#coll").val(),
					year:$("#year").val(),
					num:$('#num').val()
				},
				contentType: "application/x-www-form-urlencoded; charset=utf-8",
				success:function(jsonArray){

					var num1=$('#num').val();
					var str1=jsonArray.jsonarray;
					browsers = [];
					browsers1=[];
					if(num1=='6'){
						for(i=0;i<str1.length;i++){
						browsers.push([str1[i].ResearchPaperNumber1,parseFloat(str1[i].count1.toFixed(4))]);
						browsers.push([str1[i].ResearchPaperNumber2,parseFloat(str1[i].count2.toFixed(4))]);
       					browsers.push([str1[i].ResearchPaperNumber3,parseFloat(str1[i].count3.toFixed(4))]);
       					browsers.push([str1[i].ResearchPaperNumber4,parseFloat(str1[i].count4.toFixed(4))]);
						browsers.push([str1[i].ResearchPaperNumber5,parseFloat(str1[i].count5.toFixed(4))]);
       					browsers.push([str1[i].ResearchPaperNumber6,parseFloat(str1[i].count6.toFixed(4))]);
       					browsers.push([str1[i].ResearchPaperNumber7,parseFloat(str1[i].count7.toFixed(4))]);
						browsers.push([str1[i].ResearchPaperNumber8,parseFloat(str1[i].count8.toFixed(4))]);
       					browsers.push([str1[i].ResearchPaperNumber9,parseFloat(str1[i].count9.toFixed(4))]);
       					browsers1.push([str1[i].ResearchPaperCount1,str1[i].sum1]);
						browsers1.push([str1[i].ResearchPaperCount2,str1[i].sum2]);
       					browsers1.push([str1[i].ResearchPaperCount3,str1[i].sum3]);
       					browsers1.push([str1[i].ResearchPaperCount4,str1[i].sum4]);
						browsers1.push([str1[i].ResearchPaperCount5,str1[i].sum5]);
       					browsers1.push([str1[i].ResearchPaperCount6,str1[i].sum6]);
       					browsers1.push([str1[i].ResearchPaperCount7,str1[i].sum7]);
						browsers1.push([str1[i].ResearchPaperCount8,str1[i].sum8]);
       					browsers1.push([str1[i].ResearchPaperCount9,str1[i].sum9]);
       					}
					}
					else if(num1=='7'){
						for(i=0;i<str1.length;i++){
						browsers.push([str1[i].ResearchPaperNumber1,parseFloat(str1[i].count1.toFixed(4))]);
						browsers.push([str1[i].ResearchPaperNumber2,parseFloat(str1[i].count2.toFixed(4))]);
       					browsers.push([str1[i].ResearchPaperNumber3,parseFloat(str1[i].count3.toFixed(4))]);
       					browsers.push([str1[i].ResearchPaperNumber4,parseFloat(str1[i].count4.toFixed(4))]);
						browsers.push([str1[i].ResearchPaperNumber5,parseFloat(str1[i].count5.toFixed(4))]);
       					browsers.push([str1[i].ResearchPaperNumber6,parseFloat(str1[i].count6.toFixed(4))]);
       					browsers.push([str1[i].ResearchPaperNumber7,parseFloat(str1[i].count7.toFixed(4))]);
						browsers.push([str1[i].ResearchPaperNumber8,parseFloat(str1[i].count8.toFixed(4))]);
       					browsers.push([str1[i].ResearchPaperNumber9,parseFloat(str1[i].count9.toFixed(4))]);
       					browsers.push([str1[i].ResearchPaperNumber10,parseFloat(str1[i].count10.toFixed(4))]);
						browsers.push([str1[i].ResearchPaperNumber11,parseFloat(str1[i].count11.toFixed(4))]);
       					browsers.push([str1[i].ResearchPaperNumber12,parseFloat(str1[i].count12.toFixed(4))]);
       					browsers.push([str1[i].ResearchPaperNumber13,parseFloat(str1[i].count13.toFixed(4))]);
						browsers.push([str1[i].ResearchPaperNumber14,parseFloat(str1[i].count14.toFixed(4))]);
       					browsers.push([str1[i].ResearchPaperNumber15,parseFloat(str1[i].count15.toFixed(4))]);
       					browsers.push([str1[i].ResearchPaperNumber16,parseFloat(str1[i].count16.toFixed(4))]);
						browsers.push([str1[i].ResearchPaperNumber17,parseFloat(str1[i].count17.toFixed(4))]);
       					browsers.push([str1[i].ResearchPaperNumber18,parseFloat(str1[i].count18.toFixed(4))]);
       					browsers1.push([str1[i].ResearchPaperCount1,str1[i].sum1]);
						browsers1.push([str1[i].ResearchPaperCount2,str1[i].sum2]);
       					browsers1.push([str1[i].ResearchPaperCount3,str1[i].sum3]);
       					browsers1.push([str1[i].ResearchPaperCount4,str1[i].sum4]);
						browsers1.push([str1[i].ResearchPaperCount5,str1[i].sum5]);
       					browsers1.push([str1[i].ResearchPaperCount6,str1[i].sum6]);
       					browsers1.push([str1[i].ResearchPaperCount7,str1[i].sum7]);
						browsers1.push([str1[i].ResearchPaperCount8,str1[i].sum8]);
       					browsers1.push([str1[i].ResearchPaperCount9,str1[i].sum9]);
       					browsers1.push([str1[i].ResearchPaperCount10,str1[i].sum10]);
						browsers1.push([str1[i].ResearchPaperCount11,str1[i].sum11]);
       					browsers1.push([str1[i].ResearchPaperCount12,str1[i].sum12]);
       					browsers1.push([str1[i].ResearchPaperCount13,str1[i].sum13]);
						browsers1.push([str1[i].ResearchPaperCount14,str1[i].sum14]);
       					browsers1.push([str1[i].ResearchPaperCount15,str1[i].sum15]);
       					browsers1.push([str1[i].ResearchPaperCount16,str1[i].sum16]);
						browsers1.push([str1[i].ResearchPaperCount17,str1[i].sum17]);
       					browsers1.push([str1[i].ResearchPaperCount18,str1[i].sum18]);
       					}
					}
					else{
       				for(i=0;i<str1.length;i++){
						browsers.push([str1[i].ResearchPaperNumber1,parseFloat(str1[i].count1.toFixed(4))]);
						browsers.push([str1[i].ResearchPaperNumber2,parseFloat(str1[i].count2.toFixed(4))]);
       					browsers.push([str1[i].ResearchPaperNumber3,parseFloat(str1[i].count3.toFixed(4))]);
       					browsers1.push([str1[i].ResearchPaperCount1,str1[i].sum1]);
						browsers1.push([str1[i].ResearchPaperCount2,str1[i].sum2]);
       					browsers1.push([str1[i].ResearchPaperCount3,str1[i].sum3]);
					}
					}
       				console.log(browsers);
       				//柱状图
						$('#container1').highcharts({
				            chart: {
				                type: 'column'
				            },
				            title: {
				                text: $('#year').val()+'年  '+$('#coll').find("option:selected").text()+$('#major').find("option:selected").text()+$('#num').find("option:selected").text()+'   柱状图'
				            },
				            subtitle: {
				                text: ''
				            },
				            xAxis: {
				                type: 'category',
				                labels: {
				                    rotation: -30,
				                    style: {
				                       fontSize: '13px',
				                        fontFamily: '微软雅黑',
				                        color:'black'
				                    }
				                }
				            },
				            yAxis: {
				                min: 0,
				                title: {
				                    text: $('#num').find("option:selected").text()+'个数 (个)'
				                }
				            },
				            legend: {
				                enabled: false
				            },
				            tooltip: {
				                pointFormat: $('#num').find("option:selected").text()+'个数: <b>{point.y:.0f} 个</b>',
				            },
				            series: [{
				                name: '级别名称',
								data: browsers1,
				                dataLabels: {
				                    enabled: true,
				                    rotation: 0,
				                    color: 'black',
				                    align: 'right',
				                    x: -10,
				                    y: -30,
				                    style: {
				                        fontSize: '14px',
				                        fontFamily: 'Verdana, sans-serif',
				                        color: 'black',
				                        textShadow: '0 0 13px black'
				                    }
				                }
				            }]
				        });
						//饼图
					    $('#container').highcharts({
					        chart: {
					            plotBackgroundColor: null,
					            plotBorderWidth: 1,//null,
					            plotShadow: false
					        },
					        title: {
					            text: $('#year').val()+'年  '+$('#coll').find("option:selected").text()+$('#major').find("option:selected").text()+$('#num').find("option:selected").text()+'   统计饼图'
					        },
					        tooltip: {
					    	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
					        },
					        plotOptions: {
					            pie: {
					                allowPointSelect: true,
					                cursor: 'pointer',
					                dataLabels: {
					                    enabled: true,
					                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
					                    style: {
					                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
					                    }
					                }
					            }
					        },
					        series: [{
					            type: 'pie',
					            name: '',
					            data: browsers

					        }]
					    });//chart

				}
			});
			});
		});
</script>
	</head>
	<body style="background-color:#e4dfd9" >
	<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/highcharts/highcharts.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/highcharts/modules/exporting.js"></script>
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业数据采集
			<b class="tip"></b>专业教师科研科教信息统计
		</div>
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							专业教师科研科教信息统计查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td>
							统计年份
						</td>
						<td>
							<select name="teacherresearchsummaryModel.year" id="year">
								<option value="">
									全部年份
								</option>
								<s:iterator value="yearList" var="yearvar">
									<option value="<s:property/>"
										<s:if test="#yearvar == teacherresearchsummaryModel.year">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							学院
						</td>
						<td>
							<select size="1" id="coll"
								name="teacherresearchsummaryModel.departmentId"
								class="department" onchange="collchange();">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList" var="dvar">
									<option value="<s:property value='dno'/>"
										<s:if test="#dvar.dno == teacherresearchsummaryModel.departmentId"></s:if>>
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							专业
						</td>
						<td>
							<select size="1" name="teacherresearchsummaryModel.majorId"
								id="major">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList" var="mvar">
									<option value="<s:property value='mno'/>"
										<s:if test="#mvar.mno == teacherresearchsummaryModel.majorId"></s:if>>
										<s:property value="mname" />
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width: 60px; font-size: 15px; vertical-align: middle;">
							选择查看项目
						</td>
						<td style="width: 60px;">
							<select size="1" id="num" name="basemodel.id"
								class="department" onchange="collchange();">
								<option value="1">
									科研论文
								</option>
								<option value="2">
									科研项目
								</option>
								<option value="3">
									教改论文
								</option>
								<option value="4">
									教改项目
								</option>
								<option value="5">
									质量工程
								</option>
								<option value="6">
									教学成果奖
								</option>
								<option value="7">
									科研奖励
								</option>
							</select>
						</td>
						<td style="width: 100px;">
							<a class="btn btn-primary add" id="lalala">查询</a>&nbsp;&nbsp;
						</td>
						<td colspan="9">
							<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="11">
						</td>
					</tr>
				</tfoot>
			</table>

			<br />
<br />
<div id="container" style="min-width: 460px;width: 49%; height: 400px; margin: 0 auto;display: inline;float: left;"></div>
<div id="container1" style="min-width: 460px;width:49%; height: 400px; margin: 0 auto;display: inline;float: left;"></div>
<br />
	</body>
</html>
