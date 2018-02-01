function spepri(obj){
	       	alert($(obj).text());
	       	if("每月特价" == $(obj).text()){
	       		document.getElementById("secondProductPictures1").style.display="block";
	       		document.getElementById("secondProductPictures2").style.display="none";
	       		document.getElementById("secondProductPictures3").style.display="none";
	       	}else if("拼单团购" == $(obj).text()){
	       		document.getElementById("secondProductPictures1").style.display="none";
	       		document.getElementById("secondProductPictures2").style.display="block";
	       		document.getElementById("secondProductPictures3").style.display="none";
	       	}else{
	       		document.getElementById("secondProductPictures1").style.display="none";
	       		document.getElementById("secondProductPictures2").style.display="none";
	       		document.getElementById("secondProductPictures3").style.display="block";
	       	}
	}