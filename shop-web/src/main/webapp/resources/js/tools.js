var fn={
    translate:function(obj,diffx,diffy){
       	obj.style.webkitTransform='translate3d('+diffx+','+diffy+',0) translateZ(0px)';
        obj.style.transform='translate3d('+diffx+','+diffy+',0) translateZ(0px)';
    },
    setTransition:function(obj,time){
        obj.style.transitionDuration=time+'s';
        obj.style.transitionTimingFunction='cubic-bezier(0,0,0.58,1)';
    },
    offsetLeft:function(element){
    	var left=element.offsetLeft;
    	var parent=element.offsetParent;
    	while(parent!=null){
    		left+=parent.offsetLeft;
    		parent=parent.offsetParent;
    	}
    	return left;
    },
    offsetTop:function(element){
    	var top=element.offsetTop;
    	var parent=element.offsetParent;
    	while(parent!=null){
    		top+=parent.offsetTop;
    		parent=parent.offsetParent;
    	}
    	return top;    	
    },
    addEvent:function(element,event_name,event_fn){
        if (element.addEventListener) {
            element.addEventListener(event_name, event_fn, false);
        } else if (element.attachEvent) {
            element.attachEvent('on' + event_name, event_fn);
        } else {
            element['on' + event_name] = event_fn;
        }
    },
    getQueryPar:function(name) {
	   var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
	   var r = window.location.search.substr(1).match(reg);
	   if (r!=null) return (r[2]); return null;
	},
	mobileType:(function(){
		var u = navigator.userAgent, app = navigator.appVersion;
        isAndroid = u.indexOf('Android') > -1 || u.indexOf('Linux') > -1; //android终端或者uc浏览器
        isiOS = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/); //ios终端
        return{
        	isAndroid:isAndroid,
        	isIos:isiOS
        }
	})(),
	goTo:function(title,url) {    
   		if(this.mobileType.isAndroid)
   		{
   			java.goToHtmlUrl(title,url);
   		}else if(this.mobileType.isIos)
   		{ 	     
   			goToHtmlUrl(title,url);   
   		}
   	},
   	requestLogin:function(){
   		if(this.mobileType.isAndroid){
   			java.requestLogin();
   		}else{
   			requestLogin();
   		}
   	}
}