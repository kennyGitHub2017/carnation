var tipsbox=function(title,fn){
	if(document.getElementById("tips")) return;	
	if(document.getElementById("tipsboxStyle")){
		
	}else{
		var tipsboxStyle = document.createElement("style");
		var str="";
		str+="#model{width: 100%;height: 100%;background: rgba(0,0,0,0.4);position: fixed;left: 0;top: 0;z-index: 99999;}";
	    str+="#tips{position: fixed;left: 50%;top: 50%;-webkit-transform: translate(-50%,-50%);-moz-transform: translate(-50%,-50%);-ms-transform: translate(-50%,-50%);transform: translate3d(-50%,-50%,0);background:rgba(246,246,246,0.90);border-radius: 0.24rem;width: 5.4rem;height: 3.6rem;font-size: 16px;z-index: 100000;}";
	    str+="#tips .title{height: 2.76rem;color: #000;text-align: center;font-size:16px;padding:0 0.4rem;display:flex;align-items:center;line-height:24px;border-bottom:solid 1px #e0b3ae;box-sizing: border-box;padding-top: 0.6rem;}";			
	    str+="#tips a{color: #007AFF;font-size:18px;display: block;line-height: 0.84rem;text-align: center;text-decoration: none;border-radius: 0 0 0.24rem 0.24rem;float:left;box-sizing:border-box;width:50%;border-radius: initial;}";
	    str+="#tipsClose{border-right:solid 1px #e0b3ae}";
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
	tips.innerHTML="<div class=\"title\">"+title+"</div><a href=\"javascript:;\" id=\"tipsClose\">不允许</a><a href=\"javascript:;\" id=\"tipsFn\">马上补救</a>";
	document.body.appendChild(model);
	document.body.appendChild(tips);
	
	var model=document.getElementById("model"),
	tips=document.getElementById("tips");
	[model,tips].forEach(function(value, index, array){
		value.addEventListener("touchmove",function(e){
			e.preventDefault();
		},false);
	});
	
	var tipsClose=document.getElementById("tipsClose");
	tipsClose.onclick=function(){
		document.body.removeChild(model);
		document.body.removeChild(tips);
	}
	var tipsFn=document.getElementById("tipsFn");
	tipsFn.onclick=function(){
		fn.call(this);
		document.body.removeChild(model);
		document.body.removeChild(tips);
	}
}