<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta charset="utf-8">
			<!-- 
		<link css/bootstrap.min.css">
	<script jquery.min.js"></script>
	<script bootstrap.min.js"></script>
		 -->
	</head>
	<body>
		<form id="dialogForm" action="">
			<input type="hidden" id="idNumber" />
			<!-- 模态框（Modal） -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">
								&times;
							</button>
							<h4 class="modal-title" id="myModalLabel">
								系统提示
							</h4>
						</div>
						<div class="modal-body" id="myModalBody">
							此处为系统提示消息 ！
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">
								取消
							</button>
							<button id="myDialogSubmit" type="submit"  class="btn btn-primary">
								确定
							</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal -->
			</div>
		</form>
	</body>
</html>
