function isIE(){ //ie? 
if (window.navigator.userAgent.toLowerCase().indexOf("msie")>=1) 
return true; 
else 
return false; 
} 
if(!isIE()){ //firefox innerText define 
HTMLElement.prototype.__defineGetter__( "innerText", 
function(){ 
var anyString = ""; 
var childS = this.childNodes; 
for(var i=0; i<childS.length; i++) { 
if(childS[i].nodeType==1) 
anyString += childS[i].tagName=="BR" ? '\n' : childS[i].textContent; 
else if(childS[i].nodeType==3) 
anyString += childS[i].nodeValue; 
} 
return anyString; 
} 
); 
HTMLElement.prototype.__defineSetter__( "innerText", 
function(sText){ 
this.textContent=sText; 
} 
); 
} 
