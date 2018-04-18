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
    }
    
}