function getLodop(oOBJECT,oEMBED){
/**************************
  本函数根据浏览器类型决定采用哪个对象作为控件实例：
  IE系列、IE内核系列的浏览器采用oOBJECT，
  其它浏览器(Firefox系列、Chrome系列、Opera系列、Safari系列等)采用oEMBED,
  对于64位浏览器指向64位的安装程序install_lodop64.exe。
**************************/
		var strHtmInstall="<br><span style='font-size:14px;line-height:200%;color:#000000'>打印控件未安装或者!点击这里<a href='"+prePath+"/libs/thirdparty/lodop/install_lodop32.exe' target='_self' style='color:red;'>执行安装</a>,安装后请刷新页面或重新进入。</span>";
        var strHtmUpdate="<br><span style='font-size:14px;line-height:200%;color:#000000'>打印控件需要升级!点击这里<a href='"+prePath+"/libs/thirdparty/lodop/install_lodop32.exe' target='_self' style='color:red;'>执行升级</a>,升级后请重新进入。</span>";
        var strHtm64_Install="<br><span style='font-size:14px;line-height:200%;color:#000000'>打印控件未安装或者!点击这里<a href='"+prePath+"/libs/thirdparty/lodop/install_lodop64.exe' target='_self' style='color:red;'>执行安装</a>,安装后请刷新页面或重新进入。</span>";
        var strHtm64_Update="<br><span style='font-size:14px;line-height:200%;color:#000000'>打印控件需要升级!点击这里<a href='"+prePath+"/libs/thirdparty/lodop/install_lodop64.exe' target='_self' style='color:red;'>执行升级</a>,升级后请重新进入。</span>";
        var strHtmFireFox="<br><br><span style='font-size:14px;line-height:200%;color:#000000'>注意：<br>：如曾安装过Lodop旧版附件npActiveXPLugin,请在【工具】->【附加组件】->【扩展】中先卸它。</font>";
        var LODOP=oEMBED;	
	try{		     
		 var msg;
		 if (window.navigator.userAgent.indexOf("MSIE")>0){
		 	LODOP=oOBJECT;
		 } 
	     if ((LODOP==null)||(typeof(LODOP.VERSION)=="undefined")) {
		 if (navigator.userAgent.indexOf('Firefox')>=0)
  	         msg=strHtmFireFox;
			 if (navigator.userAgent.indexOf('Win64')>=0){
			 	msg=strHtm64_Install;
			 } else {
			 	msg=strHtmInstall;
			 }
		 	 top.Dialog.open({
		      InnerHtml: msg,//这里还可以直接写html代码
		      Title:"安装控件",
			  Width:300,
			  Height:180
		    });
			return null;
	     } else if (LODOP.VERSION<"6.1.4.5") {
			if (navigator.userAgent.indexOf('Win64')>=0){
		            msg=strHtm64_Update;
			} else {
		            msg=strHtmUpdate;
			}
			 top.Dialog.open({
		      InnerHtml: msg,//这里还可以直接写html代码
		      Title:"安装控件",
			  Width:300,
			  Height:180
		    });
			return null;
	     }
		 else{
		 	return LODOP; 
		 }
	}catch(err){
		if (navigator.userAgent.indexOf('Win64')>=0)	
		document.documentElement.innerHTML="Error:"+strHtm64_Install+document.documentElement.innerHTML;else
		document.documentElement.innerHTML="Error:"+strHtmInstall+document.documentElement.innerHTML;
	     return LODOP; 
	}
}
