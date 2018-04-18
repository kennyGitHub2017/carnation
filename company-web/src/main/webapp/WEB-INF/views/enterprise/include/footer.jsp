<%@ page contentType="text/html;charset=UTF-8" %>
<div class="footer">
    <div class="clearfix">
        <a href="${yesPath}/p/about" target="_blank" class="col-xs-3 text-center">关于云尚</a>
        <a href="${yesPath}/p/contact" target="_blank" class="col-xs-3 text-center">联系我们</a>
        <a href="${yesPath}/p/laws" target="_blank" class="col-xs-3 text-center">法律声明</a>
        <a href="${yesPath}/p/privacy" target="_blank" class="col-xs-3 text-center">隐私政策</a>
        <!-- <a href="http://ysysgo.com/p/hr" target="_blank" class="col-xs-3 text-center">诚聘英才</a> -->
        <a href="${yesPath}/e/faq" target="_blank" class="col-xs-3 text-center">帮助中心</a>
        <!-- <a href="http://zs.ysysgo.com" target="_blank" class="col-xs-3 text-center">招商网</a> -->
    </div>
    Copyright 2017  ysysgo.com. <span class="hidden-xs">All Rights. Reserved</span><a target="_blank" href="http://www.miitbeian.gov.cn"> 吉ICP备16005774号-1
</a><br />
    版权所有：吉林云尚保健食品有限公司              服务热线：400-888-2933
<p class="er">	增值电信业务经营许可证  吉B2-20170027</p>
<div class="er img">
<ul>
	<li></li>
	<li></li>
	<li></li>
	<li></li>
</ul>
</div>
</div>


<script src="${staticPath}/static/enterprise/assets/js/jquery-1.8.2.min.js"></script>
<script src="${staticPath}/static/enterprise/assets/js/wow.min.js"></script>
<script src="${staticPath}/static/enterprise/assets/nav/responsive-nav.min.js"></script>

<script>
	var wow = new WOW(
	        {
	            animateClass: 'animated',
	            offset:       100,
	            mobile: false,
	            callback:     function(box) {
	                console.log("WOW: animating <" + box.tagName.toLowerCase() + ">")
	            }
	        }
	);
	
	if(!$.browser.msie || $.browser.version > 8.1) { 
		var navigation = responsiveNav(".nav-collapse");
		wow.init();
	}


    var mid = $("body").attr("mid");
    if (mid) {
        $("#" + mid).addClass("active").parent("li").siblings().find(".active").removeClass("active");
    }
    
    $(function() {
   	  $(window).scroll(function() {
   	    if($(this).scrollTop() != 0) {
   	      $("#toTop").fadeIn(); 
   	    } else {
   	      $("#toTop").fadeOut();
   	    }
   	  });
   	  $("body").append("<div id=\"toTop\" style=\"border:1px solid #444;background:#333;color:#fff;text-align:center;padding:8px 8px 3px 8px;position:fixed;line-height: 1;z-index: 100;bottom:10px;right:10px;cursor:pointer;display:none;font-family:verdana;font-size:22px;border-radius: 5px;opacity: 0.7;\">^</div>");
   	  $("#toTop").click(function() {
   	    $("body,html").animate({scrollTop:0},800);
   	  });
   	});

</script>

<!-- 站长统计 -->
<script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_1255206113'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s11.cnzz.com/z_stat.php%3Fid%3D1255206113' type='text/javascript'%3E%3C/script%3E"));</script>
<!-- 百度统计 -->
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?8b2f2c6656ec077454798a10e8660852";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>