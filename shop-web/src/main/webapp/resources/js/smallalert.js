
var smallalert=(function(){
	var _alertTimeId=null;
	function _alert(text){
		if(!document.getElementById("js-notifications")){
			var ele_alert=document.createElement("div");
			ele_alert.className="js-notifications notifications";
			ele_alert.id="js-notifications";
			document.body.appendChild(ele_alert);
			
			var style = document.createElement("style");
			var str="";		
			str+=".notifications {position: fixed;z-index: 10000;top: -48px;left: 50%;margin-left: -225px;transition:all 0.2s ease-in-out;-webkit-transition: all 0.2s ease-in-out;}";
			str+=".notifications>div {width: 400px;position: relative;text-align: center;z-index: 10001;margin: 5px 0px;}";
			str+=".fade.in {opacity: 1;}";
			str+=".notifications .alert {padding: 10px 35px 10px 15px;color: #fff;font-size: 14px;border-radius: 2px;-webkit-box-shadow: 0 1px 3px rgba(0,0,0,0.4);box-shadow: 0 1px 3px rgba(0,0,0,0.4);text-shadow: none;}";
			str+=".notifications .alert-error {background: #ff4343;border: 1px solid #e23333;}";
			style.type="text/css";
			style.appendChild(document.createTextNode(str));
			document.getElementsByTagName("head")[0].appendChild(style);		
		}
		var alert_dom=document.getElementById("js-notifications");
		alert_dom.innerHTML="<div class=\"alert in fade alert-error\">"+text+"</div>";
		setTimeout(function(){
			alert_dom.style.top="35px";
		},1);
		if(_alertTimeId){
			clearTimeout(_alertTimeId);
		}
		_alertTimeId=setTimeout(function(){
			alert_dom.style.cssText="";
			_alertTimeId=null;
		},2000);	
	}
	return _alert;
})()


