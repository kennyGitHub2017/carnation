	var isAndroid, isiOS;
    (function() {
        var u = navigator.userAgent, app = navigator.appVersion;
        isAndroid = u.indexOf('Android') > -1 || u.indexOf('Linux') > -1; //android终端或者uc浏览器
        isiOS = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/); //ios终端
    }());
    function goTo(url) {    
   		if(isAndroid)
   		{
alert("aaa");
   			java.goToHmtlUrl(document.title,url);
   		}else
   		{ 	     
   			goToHtmlUrl(document.title,url);   
   		}
   	}

	function GetQueryPar(name) {
	   var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
	   var r = window.location.search.substr(1).match(reg);
	   if (r!=null) return (r[2]); return null;
	}
	$(document).ready(function(){
		if(GetQueryPar("tag")=="true"){
			//在应用内
			$("a").each(function(){
				var href=$(this).attr("href");
				if(href.indexOf("javascript")>-1){
					//不做处理
				}else{
					$(this).click(function(e){
						goTo(href);
						return false;
					})							
				}
			});
		}else{
			//应用外不做处理
			
		}
	});