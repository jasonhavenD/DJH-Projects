$(function(){
	

var observe;
if (window.attachEvent) {
    observe = function (element, event, handler) {
        element.attachEvent('on'+event, handler);
    };
}
else {
    observe = function (element, event, handler) {
        element.addEventListener(event, handler, false);
    };
}
function init () {
    var text = document.getElementById('text');
    
    function resize () {
        text.style.height = '200px';
        text.style.height = text.scrollHeight+'px';

    }
    /* 0-timeout to get the already changed text */
    function delayedResize () {
        window.setTimeout(resize, 0);
    }
    observe(text, 'change',  resize);
    observe(text, 'cut',     delayedResize);
    observe(text, 'paste',   delayedResize);
    observe(text, 'drop',    delayedResize);
    observe(text, 'keydown', delayedResize);
    /*text.focus();
    text.select();*/
    resize();
    
    //�Զ�����
    document.body.onclick = function(e) {
        if (!e) {
            e = window.event;
        }
        else {
            e.srcElement = e.target;
        }
        var target = e.srcElement;
        var tag = false;
        for(var i = 0;i < 10; i++){
        	if("abc" == target.id){
        		tag = true;
        		break;
        	}
        	target = target.parentNode;
        	if(target == null)
        		break;
        }
        if(!tag){
        	clearNames();
        }
    };
}
});