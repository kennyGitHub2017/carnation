<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" id="viewport"
          content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no"/>

    <title>云尚App下载</title>
    <meta name="keywords" content="健康生活"/>
    <meta name="description" content="">
    <script src="../app/assets/js/base64.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		function is_weixin(){
			var ua = navigator.userAgent.toLowerCase();
			if(ua.match(/MicroMessenger/i)=="micromessenger") {
				return true;
		 	} else {
				return false;
			}
		}
		function getUrlPar(name) {
			   var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
			   var r = window.location.search.substr(1).match(reg);
			   if (r!=null) return (r[2]); return null;
		}
		function wxlogin(){
			if(is_weixin()&&getUrlPar('isflag')==null&&getUrlPar('invitationCode')!=null){
				var url=Base64.encode(location.href);
				var invitationCode=getUrlPar('invitationCode');
				if(parseInt(invitationCode)==NaN) return;
				var mobilePath="";
				if(location.href.indexOf("ysysgo.cn")>-1){
					mobilePath="http://mobile.ysysgo.cn";
				}else{
					mobilePath="http://mobile.ysysgo.com";
				}
				location.href=mobilePath+"/user/loginUrl.htm?url='"+url+"'&invitationCode="+invitationCode;
			}
		}
		wxlogin();
		
	</script>
	<script>
	    var u = navigator.userAgent, app = navigator.appVersion;
	    if (!!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/)) {
	        location.href = "http://a.app.qq.com/o/simple.jsp?pkgname=com.yunshang.ysysgo";  //ios
	      //  location.href="http://pre.im/ysdjk";
	      //  location.href="http://static.ysysgo.com/carnation-static/static/platform/iosGuid.html";
	    } else {
	        location.href = "https://www.pgyer.com/939F";
	    }
	</script>

</head>
<body>
</body>
</html>