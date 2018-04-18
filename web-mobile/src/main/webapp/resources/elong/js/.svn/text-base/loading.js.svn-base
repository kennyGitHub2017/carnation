var loadingShow=function(){
	if(document.getElementById("loading3")){
		document.getElementById("model_loading").style.display="block";
		document.getElementById("loading3").style.display="block";
		return;
	}
	if(!document.getElementById("loading3Style")){
		var loading3Style = document.createElement("style");
		var str="";
		str+=".model_loading{position: fixed;left: 0;top: 0;right: 0;bottom: 0;background: rgba(0,0,0,0.3);z-index: 100000;}";
	    str+="	.loading3{position: fixed;left: 50%;top: 50%;transform: translate(-50%,-50%);-webkit-transform: translate(-50%,-50%);z-index: 100001;}";
	    str+="	.spinner {margin: 100px auto;width: 60px; height: 60px;position: relative;}		 ";
		str+="	.container1 > div, .container2 > div, .container3 > div {width: 16px;height: 16px;background-color: #33b1ff; border-radius: 100%;position: absolute;-webkit-animation: bouncedelay 1.2s infinite ease-in-out; animation: bouncedelay 1.2s infinite ease-in-out; -webkit-animation-fill-mode: both; animation-fill-mode: both;}";		 
		str+="	.spinner .spinner-container { position: absolute; width: 100%; height: 100%;}";		 
		str+="	.container2 {-webkit-transform: rotateZ(45deg);transform: rotateZ(45deg);}";		 
		str+="	.container3 {-webkit-transform: rotateZ(90deg);transform: rotateZ(90deg);}";		 
		str+="	.circle1 { top: 0; left: 0; }";
		str+="	.circle2 { top: 0; right: 0; }";
		str+="	.circle3 { right: 0; bottom: 0; }";
		str+="	.circle4 { left: 0; bottom: 0; }";		 
		str+="	.container2 .circle1 {-webkit-animation-delay: -1.1s;animation-delay: -1.1s;}";		 
		str+="	.container3 .circle1 {-webkit-animation-delay: -1.0s;animation-delay: -1.0s;}	";	 
		str+="	.container1 .circle2 {-webkit-animation-delay: -0.9s;animation-delay: -0.9s;}";		 
		str+="	.container2 .circle2 {-webkit-animation-delay: -0.8s;animation-delay: -0.8s;}";		 
		str+="	.container3 .circle2 {-webkit-animation-delay: -0.7s;animation-delay: -0.7s;}";		 
		str+="	.container1 .circle3 {-webkit-animation-delay: -0.6s;animation-delay: -0.6s;}";		 
		str+="	.container2 .circle3 {-webkit-animation-delay: -0.5s;animation-delay: -0.5s;}";		 
		str+="	.container3 .circle3 {-webkit-animation-delay: -0.4s;animation-delay: -0.4s;}";		 
		str+="	.container1 .circle4 {-webkit-animation-delay: -0.3s;animation-delay: -0.3s;}";		 
		str+="	.container2 .circle4 {-webkit-animation-delay: -0.2s;animation-delay: -0.2s;}";		 
		str+="	.container3 .circle4 {-webkit-animation-delay: -0.1s;animation-delay: -0.1s;}";		 
		str+="	@-webkit-keyframes bouncedelay { 0%, 80%, 100% { -webkit-transform: scale(0.0) } 40% { -webkit-transform: scale(1.0) }}";		 
		str+="	@keyframes bouncedelay {0%, 80%, 100% {transform: scale(0.0);-webkit-transform: scale(0.0);} 40% { transform: scale(1.0);-webkit-transform: scale(1.0);}}"
		loading3Style.type="text/css";
		loading3Style.id="loading3Style";
		loading3Style.appendChild(document.createTextNode(str));
		document.getElementsByTagName("head")[0].appendChild(loading3Style); 
	}
	var model_loading=document.createElement("div");
	model_loading.id="model_loading";
	model_loading.className="model_loading";
	var loading3=document.createElement("div");
	loading3.id="loading3";
	loading3.className="loading3";
	var innerStr="";
	innerStr+="<div class=\"spinner\">";
	innerStr+="  <div class=\"spinner-container container1\"><div class=\"circle1\"></div><div class=\"circle2\"></div><div class=\"circle3\"></div><div class=\"circle4\"></div></div>";
	innerStr+="  <div class=\"spinner-container container2\"><div class=\"circle1\"></div><div class=\"circle2\"></div><div class=\"circle3\"></div><div class=\"circle4\"></div></div>";
	innerStr+="  <div class=\"spinner-container container3\"><div class=\"circle1\"></div><div class=\"circle2\"></div><div class=\"circle3\"></div><div class=\"circle4\"></div></div>";
	innerStr+="</div>";    
	loading3.innerHTML=innerStr;
	
	document.body.appendChild(model_loading);
	document.body.appendChild(loading3);
}
var loadingHide=function(){
	document.getElementById("model_loading").style.display="none";
	document.getElementById("loading3").style.display="none";
}