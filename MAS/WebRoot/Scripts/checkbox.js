//判断所有的checkbox的选中状态
//@id : checkbox的id
function checkedStatus(id) {

	//获取checkbox
	var temp = document.getElementById(id);

	//设置checkbox的下级checkbox的状态
	setChildCheckBox(temp);

	//设置checkbox的上级checkbox的状态
	setParentCheckBox(temp);
	
}

//获取checkbox的下级checkbox信息
//@entity : checkbox的DOM对象
function findChildCheckBox(entity) {

	//存放下级checkbox的数组
	var chkArray = new Array();

	//判断是否有input标签
	if (document.getElementsByTagName("input")) {

		//获取所有的input标签
		var inputs = document.getElementsByTagName("input");

		//遍历input标签，获取下级checkbox
		for ( var i = 0; i < inputs.length; i++) {
			var ele = inputs[i];

			//判断type是“checkbox”，并且checkbox的parentId等于entity的id
			if (ele.type == "checkbox"
					&& ele.getAttribute("parentId") == entity.id) {
				chkArray.push(ele);
			}
		}
	}
	return chkArray;
}

//获取checkbox的同级checkbox信息
//@entity : checkbox的DOM对象
function findBrotherCheckBox(entity) {

	//存放同级checkbox的数组
	var chkArray = new Array();

	//判断是否有input标签
	if (document.getElementsByTagName("input")) {

		//获取所有的input标签
		var inputs = document.getElementsByTagName("input");

		//遍历input标签，获取同级checkbox
		for ( var i = 0; i < inputs.length; i++) {
			var ele = inputs[i];

			//判断type是“checkbox”，并且checkbox的parentId等于entity的parentId
			if (ele.type == "checkbox"
					&& ele.getAttribute("parentId") == entity
							.getAttribute("parentId")) {
				chkArray.push(ele);
			}
		}
	}
	return chkArray;
}

//获取checkbox的上级checkbox信息
//@entity : checkbox的DOM对象
function findParentCheckBox(entity) {

	//存放上级checkbox的对象
	var _element = null;

	//判断是否有input标签
	if (document.getElementsByTagName("input")) {

		//获取所有的input标签
		var inputs = document.getElementsByTagName("input");

		//遍历input标签，获取上级checkbox
		for ( var i = 0; i < inputs.length; i++) {
			var ele = inputs[i];

			//判断type是“checkbox”，并且checkbox的id等于entity的parentId
			if (ele.type == "checkbox"
					&& ele.id == entity.getAttribute("parentId")) {
				_element = ele;
				break;
			}
		}
	}
	return _element;
}

//设置checkbox的下级checkbox的状态
//@entity : checkbox的DOM对象
function setChildCheckBox(entity) {

	//entity的选中状态
	var status = entity.checked;

	//获取entity的下级checkbox
	var childList = findChildCheckBox(entity);

	//判断是否有下级
	if (childList.length > 0) {

		//遍历下级checkbox，并设置状态
		for ( var i = 0; i < childList.length; i++) {
			childList[i].checked = status;

			//设置childList[i]的下级checkbox的状态
			setChildCheckBox(childList[i]);
		}
	}
}

//设置checkbox的上级checkbox的状态
//@entity : checkbox的DOM对象
function setParentCheckBox(entity) {

	//entity的上级checkbox的选中状态
	var parentChecked = true;

	//获取entity的上级checkbox
	var parentCheckBox = findParentCheckBox(entity);

	//判断是否有上级
	if (parentCheckBox) {

		//获取entity的同级checkbox
		var brotherList = findBrotherCheckBox(entity);

		//判断是否有同级
		if (brotherList.length > 0) {

			//遍历同级checkbox
			for ( var i = 0; i < brotherList.length; i++) {

				//如果同级的checkbox有未选中的状态，则设置上级的checkbox的状态为false
				if (brotherList[i].checked == false) {
					parentChecked = false;
					break;
				}
			}
		}

		//设置上级checkbox的选中状态
		parentCheckBox.checked = parentChecked;

		//设置parentCheckbox的上级checkbox的状态
		setParentCheckBox(parentCheckBox);
	}
}
