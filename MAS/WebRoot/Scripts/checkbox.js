//�ж����е�checkbox��ѡ��״̬
//@id : checkbox��id
function checkedStatus(id) {

	//��ȡcheckbox
	var temp = document.getElementById(id);

	//����checkbox���¼�checkbox��״̬
	setChildCheckBox(temp);

	//����checkbox���ϼ�checkbox��״̬
	setParentCheckBox(temp);
	
}

//��ȡcheckbox���¼�checkbox��Ϣ
//@entity : checkbox��DOM����
function findChildCheckBox(entity) {

	//����¼�checkbox������
	var chkArray = new Array();

	//�ж��Ƿ���input��ǩ
	if (document.getElementsByTagName("input")) {

		//��ȡ���е�input��ǩ
		var inputs = document.getElementsByTagName("input");

		//����input��ǩ����ȡ�¼�checkbox
		for ( var i = 0; i < inputs.length; i++) {
			var ele = inputs[i];

			//�ж�type�ǡ�checkbox��������checkbox��parentId����entity��id
			if (ele.type == "checkbox"
					&& ele.getAttribute("parentId") == entity.id) {
				chkArray.push(ele);
			}
		}
	}
	return chkArray;
}

//��ȡcheckbox��ͬ��checkbox��Ϣ
//@entity : checkbox��DOM����
function findBrotherCheckBox(entity) {

	//���ͬ��checkbox������
	var chkArray = new Array();

	//�ж��Ƿ���input��ǩ
	if (document.getElementsByTagName("input")) {

		//��ȡ���е�input��ǩ
		var inputs = document.getElementsByTagName("input");

		//����input��ǩ����ȡͬ��checkbox
		for ( var i = 0; i < inputs.length; i++) {
			var ele = inputs[i];

			//�ж�type�ǡ�checkbox��������checkbox��parentId����entity��parentId
			if (ele.type == "checkbox"
					&& ele.getAttribute("parentId") == entity
							.getAttribute("parentId")) {
				chkArray.push(ele);
			}
		}
	}
	return chkArray;
}

//��ȡcheckbox���ϼ�checkbox��Ϣ
//@entity : checkbox��DOM����
function findParentCheckBox(entity) {

	//����ϼ�checkbox�Ķ���
	var _element = null;

	//�ж��Ƿ���input��ǩ
	if (document.getElementsByTagName("input")) {

		//��ȡ���е�input��ǩ
		var inputs = document.getElementsByTagName("input");

		//����input��ǩ����ȡ�ϼ�checkbox
		for ( var i = 0; i < inputs.length; i++) {
			var ele = inputs[i];

			//�ж�type�ǡ�checkbox��������checkbox��id����entity��parentId
			if (ele.type == "checkbox"
					&& ele.id == entity.getAttribute("parentId")) {
				_element = ele;
				break;
			}
		}
	}
	return _element;
}

//����checkbox���¼�checkbox��״̬
//@entity : checkbox��DOM����
function setChildCheckBox(entity) {

	//entity��ѡ��״̬
	var status = entity.checked;

	//��ȡentity���¼�checkbox
	var childList = findChildCheckBox(entity);

	//�ж��Ƿ����¼�
	if (childList.length > 0) {

		//�����¼�checkbox��������״̬
		for ( var i = 0; i < childList.length; i++) {
			childList[i].checked = status;

			//����childList[i]���¼�checkbox��״̬
			setChildCheckBox(childList[i]);
		}
	}
}

//����checkbox���ϼ�checkbox��״̬
//@entity : checkbox��DOM����
function setParentCheckBox(entity) {

	//entity���ϼ�checkbox��ѡ��״̬
	var parentChecked = true;

	//��ȡentity���ϼ�checkbox
	var parentCheckBox = findParentCheckBox(entity);

	//�ж��Ƿ����ϼ�
	if (parentCheckBox) {

		//��ȡentity��ͬ��checkbox
		var brotherList = findBrotherCheckBox(entity);

		//�ж��Ƿ���ͬ��
		if (brotherList.length > 0) {

			//����ͬ��checkbox
			for ( var i = 0; i < brotherList.length; i++) {

				//���ͬ����checkbox��δѡ�е�״̬���������ϼ���checkbox��״̬Ϊfalse
				if (brotherList[i].checked == false) {
					parentChecked = false;
					break;
				}
			}
		}

		//�����ϼ�checkbox��ѡ��״̬
		parentCheckBox.checked = parentChecked;

		//����parentCheckbox���ϼ�checkbox��״̬
		setParentCheckBox(parentCheckBox);
	}
}
