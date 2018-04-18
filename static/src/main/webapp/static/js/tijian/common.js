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
