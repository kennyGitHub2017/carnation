var alertBoxFn=function(title,tips,type,fn){
	if(document.getElementById("alertBox")) return;	
	if(!document.getElementById("alertBoxStyle")){
		var alertBoxStyle = document.createElement("style");
		var str="";
		str+="#model{width: 100%;height: 100%;background: #000;opacity: 0.4;filter:Alpha(opacity=40);position: fixed;left: 0;top: 0;right:0;bottom:0;z-index: 99999;}";
		str+="	#alertBox{background:#ffffff;border:1px solid #eaeaea;width:418px;height:238px;position: fixed;left: 50%;top: 50%;margin: -120px 0 0 -210px;z-index: 100000;font-family: '微软雅黑';color: #4c4c4c;}";
		str+="	#alertBox .tit{height: 48px;line-height: 48px;font-size: 18px;position: relative;text-align: center;border-bottom: solid 1px #f0f0f0;}";
		str+="	#alertBox .tit .close{width: 48px;height: 48px;background: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA4AAAAOBAMAAADtZjDiAAAAJFBMVEUAAACVlZWWlpaVlZWVlZWVlZWVlZWUlJSWlpaVlZWVlZWUlJRNa6MQAAAAC3RSTlMAhnJ5fo1txmnKwNbDHdwAAABVSURBVAjXYyhkAAFPhmwBIMW4iYFpI5CWVmBg0BYAcRmAAiAuEFgLbgKrZd6tAKZZdzuA6ejkLWDuNgZrBxA3gYF5C4gLZHsbMEQ3AGmWzQwrwGrNAR0XD1C5m2TdAAAAAElFTkSuQmCC) no-repeat center;background-size: 14px;position: absolute;top: 0;right: 0;}";
		str+="	#alertBox .content{height: 118px;display: table;width: 100%;}";
		str+="	#alertBox .content .mainc{display: table-cell;vertical-align: middle;padding:0 20px}";
		str+="	#alertBox .content .mainc p{text-align: center;font-size: 18px;line-height: 28px;width: 100%;}";
		str+="	#alertBox .btnc{font-size: 0;text-align: center;}";
		str+="	#alertBox .btnc a{background:#18bf97;border-radius:5px;height:42px;line-height: 42px;font-size: 16px;color: #FFFFFF;display: inline-block;text-decoration: none;letter-spacing: 1px;}";
		str+="	#alertBox .btn_1 a{padding: 0 107px;}";
		str+="	#alertBox .btn_2 a{padding: 0 50px;}";
		str+="	#alertBox .btn_2 .cancel{margin-left: 20px;}";
		alertBoxStyle.type="text/css";
		alertBoxStyle.id="alertBoxStyle";
		alertBoxStyle.appendChild(document.createTextNode(str));
		document.getElementsByTagName("head")[0].appendChild(alertBoxStyle); 
	}
	var model=document.createElement("div");
	model.id="model";
	var alertBox=document.createElement("div");
	alertBox.id="alertBox";
	var innerStr="";
	var tipsArr=tips.split("|");
	
	innerStr+="<div class=\"tit\">";
	innerStr+=title;
	innerStr+="<a href=\"javascript:;\" class=\"close\" id=\"alertBoxClose\"></a>";
	innerStr+="</div>";
	innerStr+="<div class=\"content\">";
	innerStr+="<div class=\"mainc\">";			
	for(var i=0;i<tipsArr.length;i++){
		innerStr+="<p>"+tipsArr[i]+"</p>";
	}
	innerStr+="</div>";
	innerStr+="</div>";
	if(type==1){
		innerStr+="<div class=\"btnc btn_1\">";
		innerStr+="<a href=\"javascript:;\" id=\"alertBoxConfirm\" class=\"confirm\">确定</a>";
	}else if(type==2){
		innerStr+="<div class=\"btnc btn_2\">";
		innerStr+="<a href=\"javascript:;\" id=\"alertBoxConfirm\" class=\"confirm\">确定</a>";
		innerStr+="<a href=\"javascript:;\" id=\"alertBoxCancel\" class=\"cancel\">取消</a>";
	}
	innerStr+="</div>";
	alertBox.innerHTML=innerStr;
	
	
	document.body.appendChild(model);
	document.body.appendChild(alertBox);
	

	var alertBoxConfirm=document.getElementById("alertBoxConfirm");
	var alertBoxClose=document.getElementById("alertBoxClose");
	var alertBoxCancel=document.getElementById("alertBoxCancel");
	
	
	[alertBoxClose,alertBoxCancel].forEach(function(value, index, array){
		if(value){
			value.onclick=function(){
				document.body.removeChild(model);
				document.body.removeChild(alertBox);
			}
		}
	});
	
	alertBoxConfirm.onclick=function(){
		document.body.removeChild(model);
		document.body.removeChild(alertBox);
		if(typeof fn=="function"){
			fn();
		}
	}
	
}