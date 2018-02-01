function setDialog(content, action,idNumber) {
	alert(action);
	$("#dialogForm").attr("action", action);
	document.getElementById("myModalBody").innerHTML = content;
	$("#idNumber").attr("value",idNumber);
	alert($("#dialogForm").attr('action'));
	alert($("#idNumber").attr('value'));
}