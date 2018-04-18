var tips=function(title){
	if (document.getElementById("smalltips")) return;
	if(document.getElementById("tipsStyle")){		
	}else{
		var tipsStyle = document.createElement("style");
		var str="";
		str+=".smalltips {background-color: #4f4e4b;opacity: 0;filter: alpha(opacity=00);position:fixed;left:50%;bottom:0px;color:#fff;padding:10px 20px;border-radius:4px;font-size:14px;}";
        str+=".smalltips .content{display:inline-block;margin:0 auto}";
		tipsStyle.type="text/css";
		tipsStyle.id="tipsStyle";
		tipsStyle.appendChild(document.createTextNode(str));
		document.getElementsByTagName("head")[0].appendChild(tipsStyle); 
	}
	var tips=document.createElement("div");
	tips.id="smalltips";
	tips.className="smalltips";
	tips.innerHTML=title;
	document.body.appendChild(tips);
    $("#smalltips").css("z-index","999999999").css("margin-left",-$("#smalltips").innerWidth() / 2).animate({
        opacity:0.9,
        bottom: 80
    }, 500, 'easeOutBack', tipsend).css({ filter: "Alpha(Opacity=90)" });
    function tipsend() {
	    setTimeout(function () {
	        $("#smalltips").remove();
	    }, 2500);                
	}
}

