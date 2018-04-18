var tipsbox=function(title,fn){
	if(document.getElementById("tips")) return;	
	if(document.getElementById("tipsboxStyle")){
		
	}else{
		var tipsboxStyle = document.createElement("style");
		var str="";
		str+="#model{width: 100%;height: 100%;background: rgba(0,0,0,0.4);position: fixed;left: 0;top: 0;z-index: 99999;}";
	    str+="#tips{position: fixed;left: 50%;top: 50%;-webkit-transform: translate(-50%,-50%);-moz-transform: translate(-50%,-50%);-ms-transform: translate(-50%,-50%);transform: translate3d(-50%,-50%,0);background: #f2f2f2;border-radius: 0.24rem;width: 5.4rem;height: 2.08rem;font-size: 16px;z-index: 100000;}";
	    str+="#tips .title{height: 1.2rem;line-height: 1.2rem;color: #030303;text-align: center;border-bottom: solid 1px #dedede;}";			
	    str+="#tips a{color: #19bf96;display: block;line-height: 0.88rem;text-align: center;text-decoration: none;border-radius: 0 0 0.24rem 0.24rem;}";
	    str+="#tips a:active{background: #ebebeb;}";  
		tipsboxStyle.type="text/css";
		tipsboxStyle.id="tipsboxStyle";
		tipsboxStyle.appendChild(document.createTextNode(str));
		document.getElementsByTagName("head")[0].appendChild(tipsboxStyle); 
	}
	var model=document.createElement("div");
	model.id="model";
	var tips=document.createElement("div");
	tips.id="tips";
	tips.innerHTML="<div class=\"title\">"+title+"</div><a href=\"javascript:;\" id=\"tipsok\">好的</a>";
	document.body.appendChild(model);
	document.body.appendChild(tips);
	
	var model=document.getElementById("model"),
	tips=document.getElementById("tips");
	[model,tips].forEach(function(value, index, array){
		value.addEventListener("touchmove",function(e){
			e.preventDefault();
		},false);
	});
	
	var tipsok=document.getElementById("tipsok");
	tipsok.onclick=function(){
		document.body.removeChild(model);
		document.body.removeChild(tips);
		if(typeof fn=="function"){
			fn();
		}
	}
	model.onclick=function(){
		document.body.removeChild(model);
		document.body.removeChild(tips);
	}
}