<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>评估结果查询信息</title>

<style type="text/css">
.words-split {
	vertical-align: middle;
}
.lbl-input {
	display: inline-block;
	width: 120px;
	height: 26px;
	line-height: 26px;
	min-height: 26px;
	text-indent: 1em;
	border: 1px solid #ddd;
	border-radius: 5px;
	color:#fff;
	vertical-align: middle;
}
.words-split a {
	display: inline-block;
	padding:0 20px 0 8px;
	position: relative;
	margin:0 4px;
}
.words-split a em {
	display:none;
	width: 16px;
	height: 100%;
	position: absolute;
	background: #f60;
	right: 0;
	top: 0;
}
.words-split a em:after {
	content: "-";
	color: #fff;
	font: bold 20px 'Microsoft Yahei';
}
.words-split a:hover em {
	display: block;
}
a.words-split-add {
	display: inline-block;
	font: bold 20px 'Microsoft Yahei';
	color: #2cac93
}
.fm-button {
	display: inline-block;
	text-align: center;
	color: #fff;
	height: 28px;
	line-height: 28px;
	font-size: 14px;
	padding: 0 1em;
	border-radius: 3px;
	opacity: .9;
	filter: alpha(opacity=90);
	background:#2cac93;
}
</style>

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
$(function() {
    $.ajax({
        type: 'POST',
        datatype: "json",
        url: "showAssessingResult.action",
        data: {
            target: $("#target").val()
        },
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        success: function(json) {
            var jsonArray = json.jsonArray;
            var a1 = jsonArray[0];
            var a2 = jsonArray[1];
            //柱狀圖
            $('#container').highcharts({
                chart: {
                    type: 'bar'
                },
                title: {
                    text: '一级指标 平均分   柱状图'
                },
                subtitle: {
                    text: ''
                },
                xAxis: {
                    categories: a1,
                    labels: {
                        style: {
                            fontSize: '14px',
                            fontFamily: '微软雅黑',
                            color: 'black'
                        }
                    }
                },
                yAxis: {
                    min: 0,
                    title: {
                        text: '分数(分)'
                    },

                },
                legend: {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'top',
                    x: -40,
                    y: 100,
                    floating: false,
                    borderWidth: 1,
                    backgroundColor: ('#FFFFFF'),
                    shadow: true,
                    reversed: true
                },
                tooltip: {
                    pointFormat: '分数: <b>{point.y:.1f} 分</b>',
                },
                series: [{
                    name: '平均分',
                    data: a2,
                    dataLabels: {
                        enabled: true,
                        color: 'black',
                        align: 'right',
                        x: 50,
                        y: 0,
                        style: {
                            fontSize: '14px',
                            fontFamily: 'Verdana, sans-serif',
                            color: 'black'
                            //textShadow: '0 0 13px black'
                        }
                    }
                }]
            });

        }
    });
});
function c() {
//获取已选择的专业编号
var objarr = $(".mno");
var arr = new Array();
for(var i=0;i<objarr.length;i++)
{
	arr[i]=objarr[i].value;
}
//获取已选择的专业名称
var jsobj = $(".mname");
var mName = new Array();
mName[0] = '平均分';
for(var i=0;i<jsobj.length;i++){
	mName[i+1] = jsobj[i].value;
}
    if ($("#target").val() == '1') {
        $("#container").height(200*(mName.length+1));
    };
    if ($("#target").val() == '2') {
        $("#container").height(600*(mName.length+1));
    };
    if ($("#target").val() == '3') {
        $("#container").height(1600*(mName.length+1));
    };
//ajax不能直接传输数组，需要转换为字符串
arraydata = arr.join(",");

    $.ajax({
        type: 'POST',
        datatype: "json",
        url: "showAssessingResult.action",
        data: {
            target : $("#target").val(),
            mno1 : arraydata
        },
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        success: function(json) {
            var jsonArray = json.jsonArray;
            var target = jsonArray[0];
            var s = new Array();
            var dataLabels = {
				                    enabled: true,
				                    color: 'black',
				                    align: 'right',
				                    x: 50,
				                    y: 0,
				                    style: {
				                        fontSize: '14px',
				                        fontFamily: 'Verdana, sans-serif',
				                        color: 'black'
				                       // textShadow: '0 0 13px black'
				                    }
				                }
            for(var i=1;i<jsonArray.length;i++){
            	s.push({"name": mName[i-1], "data": jsonArray[i],"dataLabels":dataLabels});
            }
            //柱狀圖
            $('#container').highcharts({
                chart: {
                    type: 'bar'
                },
                title: {
                    text: $("#target").find("option:selected").text() + '得分柱状图'
                },
                subtitle: {
                    text: ''
                },
                xAxis: {
                    categories: target,
                    labels: {
                        //rotation: -50,
                        style: {
                            fontSize: '14px',
                            fontFamily: '微软雅黑',
                            color: 'black'
                        }
                    }
                },
                yAxis: {
                    min: 0,
                    title: {
                        text: '分数(分)'
                    },

                },
                legend: {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'top',
                    x: -40,
                    y: 100,
                    floating: false,
                    borderWidth: 1,
                    backgroundColor: ('#FFFFFF'),
                    shadow: true,
                    reversed: true
                },
                tooltip: {
                    pointFormat: ' {series.name}: <b>{point.y:.1f} 分</b>',
                },
                series: s
            });
        }
    });
    console.log(this)
}
</script>
<script type="text/javascript">
		function majorselect(){//将选择的专业放入文本框
			var mname = $("#major").find("option:selected").text();
			var mno = $("#major").val();
			var mname1 = mname.replace(/\s+/g,"");
			var insertMName = '<input class="mname" type="hidden" value="'+mname1+'"/>';
			var insertMno = '<input class="mno" type="hidden" value="'+mno+'"/>';
			holder = $('<span class="words-split">'),
			holder.append( $(insertMName+insertMno+'<a href="javascript:void(0)" class="fm-button">'+mname+'<em> </em></a></span>'));
	        $("#location").before(holder);
	        holder.on('click','a>em',function(){	//刪除
	        	$(this).parent().parent().remove();
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
			<b class="tip"></b>评估结果分析
		</div>
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99" style="height:30px; font-size: 15px; vertical-align: middle;">
							评估结果分析
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
					<td style="width:10px; text-align:center;">
							所在学院
					</td>
					<td style="width:20px;">
							<select size="1" id="coll" name="basemodel.departmentId"
								class="department" onchange="collchange();">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList">
									<option value="<s:property value='dno'/>">
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
					</td>
					<td style="width:10px; text-align:center;">
							所在专业
					</td>


					<td  style="width:10px;">
							<select size="1" id="major" onchange="majorselect();">
								<option value="">
									平均分
								</option>
								<s:iterator value="majorList">
									<option value="<s:property value='mno'/>">
										<s:property value="mname" />
									</option>
								</s:iterator>
							</select>
					</td>
					<td style="width: 60px; font-size: 15px; vertical-align: middle;">
							指标级别
					</td>
					<td style="width: 60px;">
							<select size="1" id="target" name="basemodel.id"
								class="department" >
								<option value="1">
									一级指标
								</option>
								<option value="2">
									二级指标
								</option>
								<option value="3">
									三级指标
								</option>
							</select>
					</td>
					<td style="width: 100px;">
							<a class="btn btn-primary add" id="search" onclick="javascript:c();">查询</a>&nbsp;&nbsp;
					</td>
					</tr>
					<tr>

					<td colspan="99" style="height:30px; font-size: 20px; vertical-align: middle;">
					专业对比：
					<span class="words-split">
						<a href="javascript:void(0)" class="fm-button" id="test"> 平均分<em> </em>
						</a>
					</span>
					<span id="location"></span>
					</td>
					</tr>

				</tbody>
				<tfoot>
					<tr>
						<td colspan="9">
							<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
						</td>
					</tr>
				</tfoot>
			</table>
<br />
<br />
<div id="container" style="min-width: 600px; height: 400px; margin: 0 auto;border: 1px solid #e0e0e0;"></div>
<br />
	</body>

</html>
