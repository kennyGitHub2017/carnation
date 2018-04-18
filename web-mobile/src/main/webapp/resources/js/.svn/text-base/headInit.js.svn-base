(function(){
	var screenWidth=window.innerWidth||document.documentElement.clientWidth;
	if(parseInt(screenWidth)>750) screenWidth=750;
	document.documentElement.style.fontSize = parseInt(screenWidth /7.5 ) + "px";
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
})();
