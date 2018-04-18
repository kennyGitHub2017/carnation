<%@ page contentType="text/html;charset=UTF-8" %>
<div class="footer">
    <div class="hidden-xs">
        <a href="#">关于云尚</a>
        <a href="#">联系我们</a>
        <a href="#">法律声明</a>
        <a href="#">隐私政策</a>
        <a href="#">诚聘英才</a>
        <a href="#">帮助中心</a>
        <a href="#">手机版</a>
    </div>
    Copyright © 2015 ysysgo.com. <span class="hidden-xs">All Rights. Reserved</span> 备案号：粤ICP备10048657号 <br />
    版权所有：云尚              招商热线：400-0755-005
</div>


<script src="assets/js/jquery-1.8.2.min.js"></script>
<script src="assets/js/wow.min.js"></script>
<script src="assets/nav/responsive-nav.min.js"></script>

<script>
        var navigation = responsiveNav(".nav-collapse");

        var wow = new WOW(
                {
                    animateClass: 'animated',
                    offset:       100,
                    callback:     function(box) {
                        console.log("WOW: animating <" + box.tagName.toLowerCase() + ">")
                    }
                }
        );
        wow.init();



        var mid = $("body").attr("mid");
        if (mid) {
            $("#" + mid).addClass("active").parent("li").siblings().find(".active").removeClass("active");
        }

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