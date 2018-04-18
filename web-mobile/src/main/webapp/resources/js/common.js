$(document).ready(function(){
	setHtmlFontSize();
	        	
});

$(window).resize(function(){
	setHtmlFontSize();
})


function setHtmlFontSize(){
	var screenWidth=window.innerWidth||document.documentElement.clientWidth;
	document.documentElement.style.fontSize = (screenWidth /7.5 ).toFixed(2) + "px";
	if(screenWidth>=750){
		document.documentElement.style.fontSize = "100px";
	}
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
	}else{
		startPos=endPos;
	}
},false);

var isAndroid = window.navigator.appVersion.match(/android/gi);
var isIPhone = window.navigator.appVersion.match(/iphone/gi);
var devicePixelRatio = window.devicePixelRatio;
if (isIPhone) {
    if (devicePixelRatio >= 3) {                
        dpr = 3;
    } else if (devicePixelRatio >= 2){
        dpr = 2;
    } else {
        dpr = 1;
    }
} else {
    dpr = 1;
}
document.documentElement.setAttribute('data-dpr', dpr);  
