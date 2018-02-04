<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>锁定列</title>
<!--框架必需start-->
<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/language/cn.js"></script>
<script type="text/javascript" src="<%=path%>/libs/js/framework.js"></script>
<link href="<%=path%>/libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=path%>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!--数据表格start-->
<script src="<%=path%>/libs/js/table/quiGrid.js" type="text/javascript"></script>
<!--数据表格end-->
</head>
<body>
	<div class="padding_right5">
		<div id="maingrid"></div>
    </div>
	<script type="text/javascript">
        var testData={"form.paginate.pageNo":1,"form.paginate.totalRows":13,"rows":[
      {"num":26.215486,"longNum":"1245541","price":"2000","beginworkDate":"2012-06-12"},
      {"num":26.256486,"longNum":"1345541","price":"2000","beginworkDate":"2012-06-12"},
      {"num":27.212486,"longNum":"1255541","price":"2000","beginworkDate":"2012-06-12"},
      {"num":28.217486,"longNum":"5045541","price":"2000","beginworkDate":"2012-06-12"},
      {"num":20.212486,"longNum":"3445541","price":"2000","beginworkDate":"2012-06-12"},
      {"num":22.215486,"longNum":"1245541","price":"2000","beginworkDate":"2012-06-05"},
      {"num":21.211486,"longNum":"1245541","price":"2000","beginworkDate":"2012-06-05"},
      {"num":20.215486,"longNum":"1245541","price":"2000","beginworkDate":"2012-06-05"},
      {"num":25.214486,"longNum":"1245541","price":"2000","beginworkDate":"2012-06-05"},
      {"num":24.215486,"longNum":"1245541","price":"2000","beginworkDate":"2012-06-05"},
      {"num":23.216486,"longNum":"1245541","price":"2000","beginworkDate":"2012-06-05"},
      {"num":28.212486,"longNum":"1245541","price":"2000","beginworkDate":"2012-06-05"}
      ]}
       
       //数据表格使用
        var g;
		function initComplete(){
			 g = $("#maingrid").quiGrid({
                columns: [ 
                    //frozen:true 将该列冻结，在左侧显示
	                { display: '日期格式化', name: 'beginworkDate', align: 'center' , width: "20%",type:"date"},
	                { display: '金额格式化', name: 'price',  align: 'center' , width: "30%",type:"currency"},
	                { display: '小数四舍五入', name: 'num',  align: 'center', width: "20%",type:"point"  },
	                { display: '长数字处理', name: 'longNum',  align: 'center', width: "30%",type:"longNumber" }
                ], data:testData, pageSize: 10, rownumbers:true, checkbox:true,percentWidthMode:true,
                height: '100%', width:"100%"
            });
		}
		$.quiDefaults.Grid.formatters['date'] = function (value, column) {
			var arr=value.split("-");
			return arr[0]+"年"+arr[1]+"月"+arr[2]+"日";
		}
		$.quiDefaults.Grid.formatters['currency'] = function (value, column) {
			return "￥"+value;
		}
		$.quiDefaults.Grid.formatters['point'] = function (value, column) {
			return formatRound(value,3)
		}
		$.quiDefaults.Grid.formatters['longNumber'] = function (value, column) {
			return value/10000+"万";
		}
		//四舍五入算法,dp代表保留小数点位数
        function formatRound(num,dp){
        	return Math.round( num * Math.pow(10,dp) ) / Math.pow(10,dp);
        }
    </script>	
</body>
</html>