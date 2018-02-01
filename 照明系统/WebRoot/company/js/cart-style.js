
/*window.onload = function () {*/
    if (!document.getElementsByClassName) {
        document.getElementsByClassName = function (cls) {
            var ret = [];
            var els = document.getElementsByTagName('*');
            for (var i = 0, len = els.length; i < len; i++) {

                if (els[i].className.indexOf(cls + ' ') >=0 || els[i].className.indexOf(' ' + cls + ' ') >=0 || els[i].className.indexOf(' ' + cls) >=0) {
                    ret.push(els[i]);
                }
            }
            return ret;
        }
    }

    var table = document.getElementById('cartTable'); // 购物车表格
    var selectInputs = document.getElementsByClassName('check'); // 所有勾选框
    var checkAllInputs = document.getElementsByClassName('check-all') // 全选框
    var tr = table.children[1].rows; //行
    var selectedTotal = document.getElementById('selectedTotal'); //已选商品数目容器
    var priceTotal = document.getElementById('priceTotal'); //总计
   // var deleteAll = document.getElementById('deleteAll'); // 删除全部按钮
    var selectedViewList = document.getElementById('selectedViewList'); //浮层已选商品列表容器
    var selected = document.getElementById('selected'); //已选商品
    var foot = document.getElementById('foot');

    var ids = new Array();
    var counts = new Array();

    // 更新总数和总价格，已选浮层
    function getTotal() {
		var seleted = 0;
		var price = 0;
		var HTMLstr = '';
		for (var i = 0, len = tr.length; i < len; i++) {
			if (tr[i].getElementsByTagName('input')[0].checked) {
				tr[i].className = 'on';
				seleted += parseInt(tr[i].getElementsByTagName('input')[1].value);
				price += parseFloat(tr[i].cells[4].innerHTML);
				HTMLstr += '<div><img src="' + tr[i].getElementsByTagName('img')[0].src + '"><span class="del" index="' + i + '">取消选择</span></div>'
			}
			else {
				tr[i].className = '';
			}
		}
	
		selectedTotal.innerHTML = seleted;
		priceTotal.innerHTML = price.toFixed(2);
		selectedViewList.innerHTML = HTMLstr;
	
		if (seleted == 0) {
			foot.className = 'foot';
		}
	}

    // 计算单行价格
    function getSubtotal(tr) {
        var cells = tr.cells;
        var price = cells[2]; //单价
        var subtotal = cells[4]; //小计td
        var countInput = tr.getElementsByTagName('input')[1]; //数目input
        var span = tr.getElementsByTagName('span')[1]; //-号
        //写入HTML
        subtotal.innerHTML = (parseInt(countInput.value) * parseFloat(price.innerHTML)).toFixed(2);
        //如果数目只有一个，把-号去掉
        if (countInput.value == 1) {
            span.innerHTML = '';
        }else{
            span.innerHTML = '-';
        }
    }

    // 点击选择框
    for(var i = 0; i < selectInputs.length; i++ ){
        selectInputs[i].onclick = function () {
            if (this.className.indexOf('check-all') >= 0) { //如果是全选，则吧所有的选择框选中
                for (var j = 0; j < selectInputs.length; j++) {
                    selectInputs[j].checked = this.checked;
                }
            }
            if (!this.checked) { //只要有一个未勾选，则取消全选框的选中状态
                for (var i = 0; i < checkAllInputs.length; i++) {
                    checkAllInputs[i].checked = false;
                }
            }
            getTotal();//选完更新总计
        }
    }

    // 显示已选商品弹层
    selected.onclick = function () {
        if (selectedTotal.innerHTML != 0) {
            foot.className = (foot.className == 'foot' ? 'foot show' : 'foot');
        }
    }

    //已选商品弹层中的取消选择按钮
    selectedViewList.onclick = function (e) {
        var e = e || window.event;
        var el = e.srcElement;
        if (el.className=='del') {
            var input =  tr[el.getAttribute('index')].getElementsByTagName('input')[0]
            input.checked = false;
            input.onclick();
        }
    }
	$("#cartTable").delegate("tr","click",function(e){ 
		  var e = e || window.event;
            var el = e.target || e.srcElement; //通过事件对象的target属性获取触发元素
            var cls = el.className; //触发元素的class
            var countInout = this.getElementsByTagName('input')[1]; // 数目input
            var value = parseInt(countInout.value); //数目
            var id = $(this).find("p")[0];//所选id
            id = id.innerHTML;
            ids.push(id);
            var countvalue = $(this).find(".count-input");
            countvalue = countvalue.val();
            counts.push(countvalue);
            //通过判断触发元素的class确定用户点击了哪个元素
            switch (cls) {
                case 'add': //点击了加号
                	var cartdetailid = $(this).parent().parent().find("font").html();
                    countInout.value = value + 1;
                	$.ajax({
                        type:"post",
                        url:"../Cart_changeProductCount",
                        data:"?ajax="+Math.random()+"&cartid="+cartdetailid+"&number="+countInout.value,
                        success:function(data)
                        {
                            //alert(data.state);
                        }
                    });
                    getSubtotal(this);
                    break;
                case 'reduce': //点击了减号
                    if (value > 1) {
                    	var cartdetailid = $(this).parent().parent().find("font").html();
                    	countInout.value = value - 1;
                    	$.ajax({
	                        type:"post",
	                        url:"../Cart_changeProductCount",
	                        data:"?ajax="+Math.random()+"&cartid="+cartdetailid+"&number="+countInout.value,
	                        success:function(data)
	                        {
	                           // alert(data.state);
	                        }
                    	});
                        getSubtotal(this);
                    }
                    break;
                case 'delete': //点击了删除
                    var conf = confirm('确定删除此商品吗？');
                    if (conf){
                    	var productid=$(this).parent().parent().find("p").html();
                    	$.post("../Cart_deleteOneProduct",
                    		{
                    		 "productid":productid
                    		},function(data){
                    	//	alert(data.state);
                    	});
                        this.parentNode.removeChild(this);
                    }
                    break;
            }
            getTotal();
	}); 
	//手动更改
	$("#cartTable").delegate(".count input","blur",function(){
            var val = parseInt(this.value);
           // alert(val);
            if (isNaN(val) || val <= 0) {
                val = 1;
            }
            if (this.value != val) {
                this.value = val;
            }
            if(val != NaN)
            {
	            var cartdetailid = $(this).parent().parent().find("font").html();
	            $.ajax({
	                type:"post",
	                url:"../Cart_changeProductCount",
	                data:"?ajax="+Math.random()+"&cartid="+cartdetailid+"&number="+val,
	                success:function(data)
	                {
	                  //alert(data.state);
	                }
	        	});
            }
            getSubtotal(this.parentNode.parentNode); /*更新小计     */         
            getTotal();/* 更新总数  */      
	});
    //为每行元素添加事件
   /* for (var i = 0; i < tr.length; i++) {
        将点击事件绑定到tr元素        tr[i].onclick = function (e) {
            var e = e || window.event;
            var el = e.target || e.srcElement; 通过事件对象的target属性获取触发元素            var cls = el.className; 触发元素的class            var countInout = this.getElementsByTagName('input')[1];  数目input            var value = parseInt(countInout.value); 数目            通过判断触发元素的class确定用户点击了哪个元素            switch (cls) {
                case 'add': 点击了加号                    countInout.value = value + 1;
                    getSubtotal(this);
                    break;
                case 'reduce': 点击了减号                    if (value > 1) {
                        countInout.value = value - 1;
                        getSubtotal(this);
                    }
                    break;
                case 'delete': 点击了删除                    var conf = confirm('确定删除此商品吗？');
                    if (conf) {
                        this.parentNode.removeChild(this);
                    }
                    break;
            }
            getTotal();
        }
         给数目输入框绑定keyup事件        tr[i].getElementsByTagName('input')[1].onkeyup = function () {
            var val = parseInt(this.value);
            if (isNaN(val) || val <= 0) {
                val = 1;
            }
            if (this.value != val) {
                this.value = val;
            }
            getSubtotal(this.parentNode.parentNode); 更新小计            getTotal(); 更新总数        }
    }*/

    // 点击全部删除
  /*  deleteAll.onclick = function () {
        if (selectedTotal.innerHTML != 0) {
            var con = confirm('确定删除所选商品吗？'); 弹出确认框            if (con) {
                for (var i = 0; i < tr.length; i++) {
                     如果被选中，就删除相应的行                    if (tr[i].getElementsByTagName('input')[0].checked) {
                        tr[i].parentNode.removeChild(tr[i]);  删除相应节点                        i--; 回退下标位置                    }
                }
            }
        } else {
            alert('请选择商品！');
        }
        getTotal(); 更新总数    }*/

    // 默认全选
    checkAllInputs[0].checked = false;
    checkAllInputs[0].onclick();
/*}*/

function getProductList(){
    $.post("../Cart_getProductList",{},function(data){
        if(data.list == "NoLogin"){
            alert("您还未登录，请先登录");
        }else if(data.list == "fail"){
            alert("获取数据失败");
        }else if(data.list == "null")
        {
        	$("#cartTable tbody").append("您没有购物车权限");
        }if(data.list.length == 0){
            $("#cartTable tbody").append("购物车没有产品~");
        }else
        {
            var array = new Array();
            var array1 = new Array();
            array = data.list;
            var str="";
            var count ="";
            for(var i = 0; i < array.length; i++){
           	array1 = array[i];
           	var property;
			property = array1[6]+" "+array1[7]+" "+
			array1[8]+" "+array1[9]+" "+array1[10]+" "+
			array1[11]+" "+array1[12]+" "+array1[13]+" "+array1[14]+"EMC";
			$("input[name='property']").val(property);
            if(array1[4] > 1){
            count="<td class='count'><span class='reduce'>-</span><input class='count-input' type='text' value='"+array1[4]+"'/><span class='add'>+</span></td>";
            }else
            {
                count="<td class='count'><span class='reduce'></span><input class='count-input' type='text' value='"+array1[4]+"'/><span class='add'>+</span></td>";
            }  
            sessionStorage.setItem(array1[0],array1[4]);
            local = array1[4];
            var picture = array1[1].split("|");
            str+=" <tr>"+
            "<td class='mycheckbox'><input class='check-one check' type='checkbox'/></td>"+
            "<td class='goods'><font style='display:none' >"+array1[0]+"</font>"+
            "<img src='.."+picture[0]+"' alt=''/><span>"+array1[2]+"</span></td>"+
            "<td class='price'>"+array1[3]+"</td>"+count+
            "<td class='subtotal' >"+array1[3]*local+"</td>"+
            "<td class='operation'><span class='delete'><p style='display:none'>"+array1[5]+"</p>删除</span></td>"+
            "<td class='property' style='display:none'>"+property+"</td>"+
            "</tr>";
        }
        $("#cartTable tbody").append(str);
        //alert(str);
    }
});
}

		$(".closing").click(function(){
			var cart = "[";
		   	i = 0;
		  	var children = $("#cartTable tbody");
		  	var flag =false;
	      	children.find("tr").each(function(){
	    	  i = i + 1;
	    	 // console.log(i);
	    	  var tdarr = $(this);
	          if(tdarr.find("input[type=checkbox]").is(':checked'))
	           {
	        	  flag = true;
	        	  var productid=tdarr.find(".delete p").html();
	        	  //console.log("productid:"+productid);
	        	  var cartdetailid = tdarr.find(".goods font").html();
	        	  var src = tdarr.find(".goods img")[0].src;
	        	  var productname = tdarr.find(".goods span").html();
	        	  var price = tdarr.find(".price").html();
	        	  var subtotal = tdarr.find(".subtotal").html();
	        	  var property = tdarr.find(".property").html();
	        	  var count = tdarr.find(".count input").val();
	        	  var product = "{productpicture:\""+src+"\",productname:\""+productname+"\",property:\""+property+"\",realprice:\""+price+
	        		  "\",num:\""+count+"\",total:\""+subtotal+"\",productid:\""+productid+"\",cartdetailid:\""+cartdetailid+"\"}";	   
	        	  cart +=product+",";
	           }
		  	});
	      	if(!flag){
	      		alert("请选择商品");
	      		return false;
	      	}
	      	cart = cart.substring(0,cart.length-1);
	      	cart += "]";
	      	$("input[name='cart1']").val(cart);
	      	$("#cartform").submit();
			});