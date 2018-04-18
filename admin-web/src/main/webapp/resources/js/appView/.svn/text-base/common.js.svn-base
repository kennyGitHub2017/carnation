$(document).ready(function(){
	setHtmlFontSize();
	        	
});

$(window).resize(function(){
	setHtmlFontSize();
})


function setHtmlFontSize(){
	var screenWidth=window.innerWidth||document.documentElement.clientWidth;
	document.documentElement.style.fontSize = parseInt(screenWidth /7.5 ) + "px";
}

var startPos,endPos,
isTouchPad = (/hp-tablet/gi).test(navigator.appVersion),
hasTouch = 'ontouchstart' in window && !isTouchPad;

document.addEventListener("touchstart",function(e){
	startPos=hasTouch? e.touches[0].pageY: e.pageY;
},false);

document.addEventListener("touchmove",function(e){
	endPos=hasTouch? e.touches[0].pageY: e.pageY;
	var scrollTop=document.documentElement.scrollTop||document.body.scrollTop;
	if(scrollTop<=0&&(endPos>startPos)){
		e.preventDefault();
	}
},false);
