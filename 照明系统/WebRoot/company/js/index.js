
function getData(){
	var membertype = Number.parseInt($("#membertype").val());
	$.post("../Product_getIndexProduct",{

	},function(data){
		var hotlist = data.hotlist;
		var newlist = data.newlist;
		var jianlist = data.jianlist;
		var snaplist = data.snaplist;//限时特价
		var grouplist = data.grouplist;//团购
		var crowdlist = data.crowdlist;//众筹
		var pptlist = data.pptlist;//滑动图片内容
		var length = hotlist.length;
		if(length > 6){
			length = 6;
		}
		
		/**
		 * 
		 */
		 var str="";
		 var picture="";
		 //picture = pptlist[1].productpicture.split("|");
		 var x = [];
		 if(pptlist != null){
			 for(var i = 0 ; i < pptlist.length; i++){
				picture = pptlist[i].productpicture.split("|");
				x.push(picture[0]);
			    /*str+="<li><a href=\"productdetail.jsp?id="+pptlist[i].productid+"\"><img src='.."+picture[0]
			    +"' class=\"img-responsive\" /></a></li>";*/
			    //$("#one img").attr("src",".."+picture[0]);
			 }
			 $("#one a").attr("href","productdetail.jsp?id="+pptlist[0].productid);
			 	$("#two a").attr("href","productdetail.jsp?id="+pptlist[1].productid);
			 	$("#three a").attr("href","productdetail.jsp?id="+pptlist[2].productid);
			 	$("#four a").attr("href","productdetail.jsp?id="+pptlist[3].productid);
			 	$("#five a").attr("href","productdetail.jsp?id="+pptlist[4].productid);
			 	$("#one img").attr("src",".."+x[0]);
			 	$("#two img").attr("src",".."+x[1]);
			 	$("#three img").attr("src",".."+x[2]);
			 	$("#four img").attr("src",".."+x[3]);
			 	$("#five img").attr("src",".."+x[4]);
			 	
			 /*$("#one img").attr("src",".."+picture[0]);
			 $("#one a").attr("href","productdetail.jsp?id="+pptlist[i].productid);*/
			// $(".slides").html('');
			//$(".slides").append(str);
			}
		 str = "";
		 picture = "";
		 for(var i = 0 ; i  < length; i ++){
		 	picture = hotlist[i].productpicture.split("|");
		 	str +=  "<div class=\"box1\">" +
		 	"<div class=\"col-md-2 col-xs-6\">"+
		 	"<ul class=\"service_grid\">"+
		 	"<li class=\"s1\"><img src=\"images/hot.png\"/> </li>"+
		 	"<li class=\"desc\">"+
		 	"<h3>"+hotlist[i].productname+"</h3>"+
		 	"<div class=\"showpics\"><img src='.."+picture[0]+"'/></div>"+
		 	"<div><a href='./productdetail.jsp?id="+hotlist[i].productid+"'>查看详情</a></div></li>"+
		 	"<div class=\"clearfix\"> </div>" +
		 	"</ul>" +
		 	"</div>" +
		 	"</div>";			        
		 }
		 $(".benefit .container").append(str);
		/**
		 * 新品
		 */
		 length = newlist.length;
		 if(length > 6){
		 	length = 6;
		 }
		 str = "";
		 var price = "";
		 for(var i = 0 ; i  < length; i ++){
		 	if(membertype == 2){
				price = newlist[i].logisticsprice;//物流中心
			}else if(membertype == 3 ){
				price = newlist[i].certifiedprice;//认证经销商
			}else if(membertype == 4){
				price = newlist[i].price;//普通经销商
			}
			picture = newlist[i].productpicture.split("|");
			str +=  "<div class=\"col-md-2 col-xs-6\">"+
			"<ul class=\"service_grid2\">"+
			"<li class=\"s2\"><img src=\"images/new.png\"/> </li>"+
			"<li class=\"desc\">"+
			"<h3>"+newlist[i].productname+"</h3>"+
			"<div class=\"showpics\"><img src='.."+picture[0]+"'/></div>"+
			"<h4>￥"+price+"</h4>"+
			"<div><a href=\"./productdetail.jsp?id="+newlist[i].productid+"\">查看详情</a></div></li>"+
			"<div class=\"clearfix\"> </div></ul></div>";			        
		}
		$(".domainnew .container").append(str);
		/**
		 * 推荐
		 */
		 str="";
		 picture="";
		 length = jianlist.length;
		 var jieneng;
		 if(length > 6){
		 	length = 4;
		 }
		 for(var i = 0 ; i  < length; i ++){
		 	picture = jianlist[i].productpicture.split("|");
		 	if(membertype == 2){
				price = jianlist[i].logisticsprice;//物流中心
			}else if(membertype == 3 ){
				price = jianlist[i].certifiedprice;//认证经销商
			}else if(membertype == 4){
				price = jianlist[i].price;//普通经销商
			}
			/*if(jianlist[i].lampholder != ""){//节能灯有灯头 判断显示属性的
				jieneng = "<li>功率"+jianlist[i].power+"</li>"+
				"<li>灯头"+jianlist[i].lampholder+"</li>"+
				"<li>色温"+jianlist[i].colortemp+"</li>"+
				"<li>电压"+jianlist[i].voltage+"</li>";
			}else{
				jieneng = "<li>功率"+jianlist[i].power+"</li>"+
				"<li>光通量"+jianlist[i].luminousflux+"</li>"+
				"<li>光效"+jianlist[i].lightefficiency+"</li>"+
				"<li>显色指数"+jianlist[i].colorrendering+"</li>"+
				"<li>光束角"+jianlist[i].beamangle+"</li>"+
				"<li>是否符合EMC"+jianlist[i].isemc+"</li>";
			}*/
			str +=  "<div class=\"col-md-3 col-xs-6\">"+
			"<div class=\"pricing-table-grid\">"+
			"<h3><br><span class=\"month\">"+jianlist[i].productname+"</span></h3>"+
			"<ul><img class=\"s3\" src=\"images/wow.png\"/><li><a href=\"\"><img  src='.."+picture[i]+"'/></a></li>"+
			"<li><b>价格￥</b>"+price+"</li>"+
			"<a class=\"order-btn\" href=\"./productdetail.jsp?id="+jianlist[i].productid+"\">查看详情</a></div></div>";			        
		}
		$(".price .container").append(str);
		/**
	 	* 众筹
	 	*/
		if(membertype != 4){
			str = "";


			if(crowdlist.length > 0){
				var picture = crowdlist[0].productpicture.split("|");
				str += "<div class='col-md-4'>"+
				"<h4 class='tz-title-4 tzcolor-blue'>"+
				"<p class='tzweight_Bold m_2'><span class='m_1'>抢鲜一步<br></span>众筹预售</p>"+
				"</h4>"+
				"<div class='offer'>"+
				"<img src='.."+picture[0]+"'/>"+
				"<a class='but1 col_1_of_3' href='./product.jsp?active=4'>查看更多</a>"+
				"</div>"+
				"</div>";
			}	
			if(grouplist.length > 0){
				var picture1 = grouplist[0].productpicture.split("|");
				str += "<div class='col-md-4 '>"+
				"<h4 class='tz-title-4 tzcolor-blue'>"+
				"<p class='tzweight_Bold m_2'><span class='m_1'>限量<br></span>团购</p></h4>"+
				"<div class='offer'>"+
				"<img src='.."+picture1[0]+"'/>"+
				"<a style='float:left;margin-left:28%;' class='but1 col_1_of_3' href='./product.jsp?active=5'>查看更多</a>"+
				"</div></div>";
			}
			$(".features .container").append(str);
		}
		if(membertype != 2){
			str = "";
			if(snaplist.length > 0){
				var picture = snaplist[0].productpicture.split("|");
				str += "<div class='col-md-4'>"+
				"<h4 class='tz-title-4 tzcolor-blue'>"+
				"<p class='tzweight_Bold m_2'><span class='m_1'>会员专享<br></span>限时特价</p>"+
				"</h4>"+
				"<div class='offer'>"+
				"<img src='.."+picture[0]+"'/>"+
				"<a style='float:left;margin-left:45%;' class='but1 col_1_of_3' href='./product.jsp?active=3'>查看更多</a>"+
				"</div>"+
				"</div>";
			}	
			$(".features .container").append(str);
		}
	});
	
}