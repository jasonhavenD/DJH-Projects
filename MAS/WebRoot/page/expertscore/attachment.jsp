<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>附件上传和下载</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Styles/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Styles/admin-all.css" />
    <link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Styles/other.css" />
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/jquery-1.7.2.js">
		</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/Scripts/jquery-ui-1.8.22.custom.min.js">
		</script>
  <script>
  	function downFile(){
  		window.location.href = "upDown_downloadFile.action?attachmentId=${attachmentId}";
  	}
  	function cover(){
  	if (confirm("是否覆盖原有文件")) {
				document.getElementById("form1").submit();
			}

  	}
  	/*function cover(attachmentId){
  	alert(attachmentId);
				document.getElementById("iframe").src="cover.action?attachmentId="+attachmentId;
                $('#alert-win').dialog({
                    width: 450,
                    height: 240,
                    buttons: { "关闭": function () { $(this).dialog("close"); } }
                });
			}*/

  </script>

  </head>
<body style="background-color:#e4dfd9"   onload="opener.location.reload()">

	<!--<div>
		<form action="upDown_uploadFile.action?attachmentId=${attachmentId}" id="form1" enctype="multipart/form-data" method="post">
        	<s:property value="fia.mas.masCode"/>----
        	<s:property  value="fia.mas.assessingneedtarget.appraisalsystem.indicatorName"/>
         <br /><br />
         <span>上传附件：</span>
         <input type="file" name="attachment" size="10" />
         <s:if test="fia.actualPath!=null">
         <input type="button" value="上传" onclick="cover();" />
         </s:if>
         <s:else>
         <input type="submit" value="上传"  />
         </s:else>
         <input type="reset" value="取消" id="cancel" />
        </form>
    </div>
    --><s:property value="fia.mas.masCode"/>----
   <s:property  value="fia.mas.assessingneedtarget.appraisalsystem.indicatorName"/>
   <s:if test="fia.actualPath != null">
    <div>
    	<span>下载附件：</span>
		<input type="button" onclick="downFile()" value="下载附件"/>&nbsp;&nbsp;
		(已上传过附件)
	</div>
	</s:if>
	<s:else>
	<div>
		未上传附件！
	</div>
	</s:else>

</body>
</html>
