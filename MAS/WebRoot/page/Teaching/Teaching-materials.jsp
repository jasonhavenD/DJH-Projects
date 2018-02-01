<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>教材基本查询</title>
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
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/MajorByDno.js">
</script>
<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/ajax/timeManage.js">
</script>
		<script type="text/javascript">
//日历插件
$(function() {
	$(".datepicker").datepicker();
})

$(document).ready(function() {
timeManage();
	$("#mytable tr:even td").css("background", "#fff");
	$("#mytable tr:even td").attr("bg", "#fff");
	$("#mytable tr:odd td").attr("bg", "#fff");
	$("#mytable tr td").hover(function() {
		$(this).parent().find("td").css("background", "#fff")
	}, function() {
		var bgc = $(this).attr("bg");
		$(this).parent().find("td").css("background", bgc)
	});
})

$(document).ready(function() {
	// ------------------------------
		$(".college").change(
				function() {
					$('#major option').remove();
					$.ajax( {
						type : "POST",
						url : 'tBooks_findMajorByDno.action',
						data : 'collegeId=' + $(this).val(),
						success : function(jsonArray) {

							var json = eval("(" + jsonArray + ")")
							var porHtml = "<option value=''>全部专业</option>";
							for ( var i = 0; i < json.length; i++) {
								porHtml += "<option value=" + json[i].majorId
										+ " >" + json[i].majorName
										+ "</option>";
							}
							$("#major").append(porHtml);
						},
						error : function(XMLHttpRequest, textStatus,
								errorThrown) {
							alert('通信失败:' + errorThrown);
						}
					});
				});
	});

$(document).ready(function() {
	//角色判断
		var rol = $("#rol").val();
		var totalRows = $("#totalRows").val();
		if (rol == 2) {
			$("#attach").hide();//隐藏导入
			$("#add").hide();//隐藏导入
			for ( var i = 0; i < totalRows; i++) {

				$(".edit").hide();
				$(".del").hide();
			}

		}
	});
//查询教材信息
function findContestApply() {
	document.getElementById("form1").submit();
}
function jump(op) {
	if ("first" == op) {
		page = 1;
	} else if ("up" == op) {
		page = parseInt(page) - 1;
	} else if ("down" == op) {
		page = parseInt(page) + 1;
	} else if ("last" == op) {
		page = totalPage;
	} else {
		var jumpPage = parseInt(document.getElementById("jumpPage").value);
		if (jumpPage <= totalPage && jumpPage > 0)
			page = jumpPage;
		else
			alert("超出页码范围");
	}
	var Name = "" + '${teachBooksModel.name}';
	var publisher = "" + '${teachBooksModel.publisher}';
	var tbookClass = "" + '${teachBooksModel.tbookClass}';
	var tbookJibie = "" + '${teachBooksModel.tbookJibie}';
	var tbookRewardClass = "" + '${teachBooksModel.tbookRewardClass}';
	Name = encodeURI(Name);
	Name = encodeURI(Name);
	publisher = encodeURI(publisher);
	publisher = encodeURI(publisher);
	tbookClass = encodeURI(tbookClass);
	tbookClass = encodeURI(tbookClass);
	tbookJibie = encodeURI(tbookJibie);
	tbookJibie = encodeURI(tbookJibie);
	tbookRewardClass = encodeURI(tbookRewardClass);
	tbookRewardClass = encodeURI(tbookRewardClass);
	window.location.href = "tBooks_find.action?teachBooksModel.name="
			+ Name
			+ "&teachBooksModel.isbn="
			+ '${teachBooksModel.isbn}'
			+ "&teachBooksModel.publisher="
			+ publisher
			+ "&teachBooksModel.year="
			+ '${teachBooksModel.year}'
			+ "&teachBooksModel.tbookJibie="
			+ tbookJibie
			+ "&teachBooksModel.tbookClass="
			+ tbookClass
			+ "&teachBooksModel.tbookRewardClass="
			+ tbookRewardClass
			+"&teachBooksModel.departmentId"+"$teachBooksModel.departmentId"
			+"&teachBooksModel.majorId"+"$teachBooksModel.majorId"
			+"&rows=" + rows + "&page=" + page;
}

function setRows(rows) {
var Name = "" + '${teachBooksModel.name}';
	var publisher = "" + '${teachBooksModel.publisher}';
	var tbookClass = "" + '${teachBooksModel.tbookClass}';
	var tbookJibie = "" + '${teachBooksModel.tbookJibie}';
	var tbookRewardClass = "" + '${teachBooksModel.tbookRewardClass}';

	Name = encodeURI(Name);
	Name = encodeURI(Name);
	publisher = encodeURI(publisher);
	publisher = encodeURI(publisher);
	tbookClass = encodeURI(tbookClass);
	tbookClass = encodeURI(tbookClass);
	tbookJibie = encodeURI(tbookJibie);
	tbookJibie = encodeURI(tbookJibie);
	tbookRewardClass = encodeURI(tbookRewardClass);
	tbookRewardClass = encodeURI(tbookRewardClass);
	window.location.href = "tBooks_find.action?teachBooksModel.name="
			+ Name
			+ "&teachBooksModel.isbn="
			+ '${teachBooksModel.isbn}'
			+ "&teachBooksModel.publisher="
			+ publisher
			+ "&teachBooksModel.year="
			+ '${teachBooksModel.year}'
			+ "&teachBooksModel.tbookJibie="
			+ tbookJibie
			+ "&teachBooksModel.tbookClass="
			+ tbookClass
			+ "&teachBooksModel.tbookRewardClass="
			+ tbookRewardClass
			+"&teachBooksModel.departmentId"+"$teachBooksModel.departmentId"
			+"&teachBooksModel.majorId"+"$teachBooksModel.majorId"
			+"&rows=" + rows.value+"&page=1";
}

//导出我的赛项列表
function exportSubContestTExcel() {
	var Name = "" + '${teachBooksModel.name}';
	var publisher = "" + '${teachBooksModel.publisher}';
	var tbookClass = "" + '${teachBooksModel.tbookClass}';
	var tbookJibie = "" + '${teachBooksModel.tbookJibie}';
	var tbookRewardClass = "" + '${teachBooksModel.tbookRewardClass}';

	Name = encodeURI(Name);
	Name = encodeURI(Name);
	publisher = encodeURI(publisher);
	publisher = encodeURI(publisher);
	tbookClass = encodeURI(tbookClass);
	tbookClass = encodeURI(tbookClass);
	tbookJibie = encodeURI(tbookJibie);
	tbookJibie = encodeURI(tbookJibie);
	tbookRewardClass = encodeURI(tbookRewardClass);
	tbookRewardClass = encodeURI(tbookRewardClass);
	window.location.href = "exportSubContestTExcel.action?exportName=teachbooks"
			+ "&teachBooksModel.tbno="
			+ '${teachBooksModel.tbno}'
			+ "&teachBooksModel.name="
			+ Name
			+ "&teachBooksModel.isbn="
			+ '${teachBooksModel.isbn}'
			+ "&teachBooksModel.publisher="
			+ publisher
			+ "&teachBooksModel.year="
			+ '${teachBooksModel.year}'
			+ "&teachBooksModel.publishTime="
			+ '${teachBooksModel.publishTime}'
			+ "&teachBooksModel.publishType="
			+ '${teachBooksModel.publishType}'
			+ "&teachBooksModel.tbookJibie="
			+ tbookJibie
			+ "&teachBooksModel.tbookClass="
			+ tbookClass
			+ "&teachBooksModel.tbookRewardClass="
			+ tbookRewardClass
			+ "&teachBooksModel.bookWords="
			+ '${teachBooksModel.bookWords}'
			+ "&teachBooksModel.useState="
			+ '${teachBooksModel.useState}'
			+ "&teachBooksModel.fininshDepartRate="
			+ '${teachBooksModel.fininshDepartRate}'
			+ "&teachBooksModel.beizhu="
			+ '${teachBooksModel.beizhu}'
			+ "&teachBooksModel.tag="
			+ '${teachBooksModel.tag}';
}

//上传附件弹出框
function upFile() {
	document.getElementById("iframe").src = "attachFileList.action?importName=teachbooks";
	$('#alert-win').dialog( {
		width : 450,
		height : 240,
		buttons : {
			"关闭" : function() {
				findContestApply();
				$(this).dialog("close");
			}
		}
	});
}
function upFileTB(){
	document.getElementById("iframe").src="attachFileList.action?importName=teachbook";
    $('#alert-win').dialog({
        width: 450,
        height: 240,
        buttons: { "关闭": function () {
 		findContestApply();
        $(this).dialog("close");} }
    });
}
</script>
	</head>
	<body style="background-color:#e4dfd9" >
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>专业数据采集
			<b class="tip"></b>查询教材信息
		</div>

		<form action="tBooks_find.action?page=1&rows=10" id="form1"
			name="form1" method="post" enctype="multipart/form-data">
			<input type="hidden" id="rol" value="<s:property value="rol"/>" />
			<input type="hidden" id="totalRows"
				value="<s:property value="totalRows"/>" />
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="99">
							教材信息查询
						</td>
					</tr>
				</thead>
				<tbody id="mytable">
					<tr>
						<td style="width: 60px;">
							教材名称
						</td>
						<td>
							<input name="teachBooksModel.Name"
								value='<s:property value="teachBooksModel.Name"/>' type="text" />
						</td>

						<td style="width: 60px;">
							级别
						</td>
						<td>
							<select name="teachBooksModel.tbookJibie" id="tbookJibie">
								<option value="">
									全部级别
								</option>
								<s:iterator value="tbookJibieList" var="tbookJibievar">
									<option value="<s:property/>"
										<s:if test="#tbookJibievar == teachBooksModel.tbookJibie">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							年份
						</td>
						<td>
							<select name="teachBooksModel.year" id="year">
								<option value="">
									全部年份
								</option>
								<s:iterator value="yearList" var="yearvar">
									<option value="<s:property/>"
										<s:if test="#yearvar == teachBooksModel.year">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>

					</tr>
					<tr>
						<td style="width: 60px;">
							ISBN
						</td>
						<td>
							<input name="teachBooksModel.isbn"
								value='<s:property value="teachBooksModel.isbn"/>' type="text" />
						</td>
						<td style="width: 60px;">
							优秀教材级别
						</td>
						<td>
							<select name="teachBooksModel.tbookClass" id="tbookClass">
								<option value="">
									全部级别
								</option>
								<s:iterator value="tbookClassList" var="tbookClassvar">
									<option value="<s:property/>"
										<s:if test="#tbookClassvar == teachBooksModel.tbookClass">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							学院
						</td>
						<td>
							<select size="1" id="coll" name="teachBooksModel.departmentId"
								onchange="collchange();" class="department">
								<option value="">
									全部学院
								</option>
								<s:iterator value="departmentList" var="departmentvar">
									<option value="<s:property value='dno'/>"
									<s:if test="#departmentvar.dno ==teachBooksModel.departmentId"></s:if>>
										<s:property value="dname" />
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>
					<tr>
						<td style="width: 60px;">
							出版社
						</td>
						<td>
							<input name="teachBooksModel.publisher"
								value='<s:property value="teachBooksModel.publisher"/>'
								type="text" />
						</td>
						<td style="width: 60px;">
							优秀教材奖项级别
						</td>
						<td>
							<select name="teachBooksModel.tbookRewardClass"
								id="tbookRewardClass">
								<option value="">
									全部级别
								</option>
								<s:iterator value="tbookRewardClassList"
									var="tbookRewardClassvar">
									<option value="<s:property/>"
										<s:if test="#tbookRewardClassvar == teachBooksModel.tbookRewardClass">selected="selected"</s:if>>
										<s:property />
									</option>
								</s:iterator>
							</select>
						</td>
						<td style="width: 60px;">
							专业
						</td>
						<td>
							<select size="1" name="teachBooksModel.majorId" id="major">
								<option value="">
									全部专业
								</option>
								<s:iterator value="majorList" var="majorvar">
									<option value="<s:property value='mno'/>"
									<s:if test="#majorvar.mno == teachBooksModell.majorId"></s:if>>
										<s:property value="mname" />
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>

				</tbody>
				<tfoot>
					<tr>
						<td colspan="5">
							<a href="javascript:findContestApply();" class="btn btn-primary add">查询</a>&nbsp;&nbsp;
							<a href="#" onclick="exportSubContestTExcel()"
								class="btn btn-primary add">导出教材信息列表</a> &nbsp;&nbsp;
							<span style="color: red;">(先查询，再导出)</span>
						</td>
						<td>
							<a id="add" class="btn btn-primary add"
								href="tBooks_edit.action?tbno=<s:property value='0'/>"> 添加 </a>
							<!--选择导入的文件 -->
							<a id="attach" href="javascript:void(0);"
								onclick="upFile();return false;" class="btn btn-primary add">导入教材信息</a>
							<span class="del"><a id="attachall" href="javascript:void(0);"
								onclick="upFileTB();return false;" class="btn btn-primary add">导入所有教材作者信息</a></span>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>


		<table class="table table-striped table-bordered table-condensed">
			<caption class="t_caption">
				教材信息列表
			</caption>
			<thead>
				<tr class="tr_title" style="height: 30px;">
					<td>
						#
					</td>
					<td>
						教材名称
					</td>
					<td>
						ISBN
					</td>
					<td>
						出版社
					</td>
					<td>
						年份
					</td>
					<td>
						出版时间
					</td>
					<td>
						出版类型
					</td>
					<td>
						级别
					</td>
					<td>
						优秀教材级别
					</td>
					<td>
						优秀教材奖项级别
					</td>
					<td>
						字数
					</td>
					<td>
						使用情况
					</td>
					<td>
						完成单位排名
					</td>
					<!--<td>
						备注
					</td>
					<td>
						标签
					</td>
					--><td>
						操作
					</td>

				</tr>
			</thead>
			<tbody>
				<s:if test="teachBooksList.size() == 0">
					<tr>
						<td colspan="99" style="text-align: center;">
							没有教材信息！
						</td>
					</tr>
				</s:if>
				<s:iterator value="teachBooksList" status="L">
					<tr>
						<td>
							<s:property value="#L.index+1" />
						</td>
						<td>
							<s:property value="tbname" />
						</td>
						<td>
							<s:property value="isbn" />
						</td>
						<td>
							<s:property value="publisher" />
						</td>
						<td>
							<s:property value="year" />
						</td>
						<td>
							<!--<s:property value="publishTime" />
							--><s:date name="publishTime" format="yyyy-MM-dd" />
						</td>
						<td>
							<s:property value="publishType" />
						</td>

						<td>
							<s:property value="tbookJibie" />
						</td>
						<td>
							<s:property value="tbookClass" />
						</td>
						<td>
							<s:property value="tbookRewardClass" />
						</td>
						<td>
							<s:property value="bookWords" />
						</td>
						<td>
							<s:property value="useState" />
						</td>
						<td>
							<s:property value="fininshDepartRate" />
						</td>
						<!--<td>
							<s:property value="beizhu" />
						</td>
						<td>
							<s:property value="tag" />
						</td>
						--><td>
							<a class="btn btn-mini btn-primary"
								href="tBooks_initSee.action?tbno=<s:property value="tbno"/>&trows=<s:property value="rows"/>&tpage=<s:property value="page"/>">
								查看 </a>
							<span class="edit"> <a class="btn btn-mini btn-primary"
								href="tBooks_edit.action?tbno=<s:property value="tbno"/>">
									修改 </a>
							</span>
							<span class="del"> <a class="btn btn-mini btn-primary"
								onclick="return confirm('确认删除吗？');"
								href="tBooks_delete.action?tbno=<s:property value="tbno"/>">
									删除 </a>
							</span>
						</td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<s:if test="teachBooksList.size() > 0">
					<tr>
						<td colspan="99">
							<s:include value="../common/paging.jsp"></s:include>
						</td>
					</tr>
				</s:if>
			</tfoot>
		</table>
		<div id="alert-win" title="附件" style="display: none;">
			<iframe style="border: 0; width: 100%; height: 100%;" id="iframe"
				src="">
			</iframe>
		</div>
		<!--<tfoot>
			<tr>
				<td colspan="99">
					<a class="btn btn-primary add" href="javascript:history.back(-1)">返回上一页</a>&nbsp;&nbsp;
				</td>
			</tr>
		</tfoot>
	--></body>
</html>
