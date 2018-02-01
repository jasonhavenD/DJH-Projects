<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>评估所需指标思维导图</title>
        
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/admin-all.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/other.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/jsmind.css" />
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/jquery-1.7.2.js">
		</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/jsmind.js">
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

<style type="text/css">
        #jsmind_container{
            width:100%;
            height:100%;
            border:solid 1px #ccc;
            /*background:#f4f4f4;*/
            background:#f4f4f4;
        }
</style>
<script type="text/javascript">
	var jm = null;
	function selectchange(){
		var num = $("#target").val();
		num++;
		jm.expand_to_depth(num);
	} 	
   $(function(){
   		var options = {
            container:'jsmind_container',
            editable:false,
            theme:'asbestos'
        	};
   		$.ajax({
        type: 'POST',
        datatype: "json",
        url: "showTargetMind.action",
        data: {
            //target: $("#target").val()
        },
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        success: function(json) {
        	//alert(json.jsonId);
        	var jsonId = json.jsonId;
        	var jsonPId = json.jsonPId;
        	var jsonName = json.jsonName;
        	var data = [];
        	data.push({"id":'0', "isroot":true, "topic":"专业评估"});
        	for(var i=0;i<jsonId.length;i++){
        		data.push({"id":jsonId[i], "parentid":jsonPId[i], "topic":jsonName[i]});
        	}
        	var mind = {
            "meta":{
                "name":"demo",
                "author":"hizzgdev@163.com",
                "version":"0.2",
            },
            "format":"node_array",
            "data":data
        	}; 
        	jm = jsMind.show(options);       	
        	jm.show(mind)
        	jm.expand_to_depth(1);
        }
        });
   });

</script>
</head>
	<body style="background-color:#e4dfd9">
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/highcharts/highcharts.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/highcharts/modules/exporting.js"></script>
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>评估管理
			<b class="tip"></b>评估所需指标设置
			<b class="tip"></b>评估所需指标思维导图
		</div>
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99" style="height:30px; font-size: 15px; vertical-align: middle;">
							评估所需指标思维导图
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 60px;">
							展开指标
						</td>
						<td>
							<select size="1" id="target" onchange="selectchange();" class="department" >
								<option value="0">
									展开一级指标
								</option>
								<option value="1">
									展开二级指标
								</option>
								<option value="2">
									展开三级指标
								</option>
								<option value="3">
									展开所有指标
								</option>								
							</select>
							<a class="btn btn-primary add" id="search" onclick="javascript:selectchange();">确定</a>
						</td>
						
					</tr>
				</tbody>
				<tfoot>
				<td colspan="9">
							<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
						</td>
				</tfoot>
			</table>
	<div id="jsmind_container"></div>
</body>

</html>
