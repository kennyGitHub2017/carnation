	var isAndroid, isiOS;
    (function() {
        var u = navigator.userAgent, app = navigator.appVersion;
        isAndroid = u.indexOf('Android') > -1 || u.indexOf('Linux') > -1; //android终端或者uc浏览器
        isiOS = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/); //ios终端
    }());
    function goTo(title,url) {
   		if(isAndroid)
   		{
   			java.goToHtmlUrl(title,url);
   		}else
   		{
   			goToHtmlUrl(title,url);   
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
						goTo($(this).attr("data-title"),href);
						return false;
					});			 				
				}
			});
		}else{
			//应用外不做处理
			
		}
	});
	
	//微信分享方法
    function shareInfo(title,url,imgUrl,dec) {
   		if(isAndroid)
   		{
   			java.requestShareInfo(title,url,imgUrl,dec);
   		} else
   		{
   			requestShareInfo(ttitle,url,imgUrl,dec);   
   		}
   	}
    
 /***
  * 
  * App内支付方法
  * 
  * 
  * @param paymentType 支付方式
  * @param mainOrderId 订单id
  * @param isUserMoneyPaymet 是否云币支付
  * @param paymetPassword 用户支付密码
  * @param type 类型
  */
function requestPayOrder(paymentType,mainOrderId,isUserMoneyPaymet,paymetPassword,type) {
	
	if (isAndroid) {
		
		java.requestPay(paymentType,mainOrderId,isUserMoneyPaymet,paymetPassword,type);
		
	} else {
		
		requestPay(paymentType,mainOrderId,isUserMoneyPaymet,paymetPassword,type);
	}
}
