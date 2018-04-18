<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />

    <title>诚聘英才,互联网人才招聘,移动互联网人才招聘 - 云尚</title>
    <meta name="keywords" content="诚聘英才,互联网人才招聘,移动互联网人才招聘,云尚" />
    <meta name="description" content="云尚是云尚中国健康管理集团旗下的移动互联网健康管理平台，云尚健康管理综合服务平台主要为用户提供健康管理、健康智能设备、健康专家实时咨询、健康生活资讯、健康自测、健康商城、健康生活圈、健康社区等健康生活服务。云尚打造了一个集健康管理服务、同业联盟O2O、移动支付和积分通兑为一体的综合性健康管理与增值服务平台。云尚服务热线：xxxxxxxx 。">
	<%@ include file="include/inc_css.jsp"%>

    <style>
        #wait { padding: 10% 0;  text-align: center; box-shadow: 0 2px 2px #ccc inset; line-height: 2.5;}
        .footer { position: absolute; bottom: 0; width: 100%;}
    </style>

</head>
<body mid="m-faq">
    <%@ include file="include/header.jsp"%>


    <div id="wait">
        <img src="${staticPath}/static/enterprise/assets/images/wait.png" />

        <div class="pt-10">
            <p>感谢您的关注，我们近期即将上线，云尚关注您一生健康！</p>
            <p id="timer">5秒跳转到首页</p>
        </div>

    </div>

    <%@ include file="include/footer.jsp"%>
    <script>

        // 倒计时
        $.fn.countdown = function(o) {
            var opts = $.extend({
                time: 5000,
                text: "$time秒后重试",
                init: function() {},
                callback: function() {}
            }, o || {});
            this.each(function() {
                var $this = $(this), html = $this.html(), nTime = opts.time/1000, timer;
                $this.attr("disabled", true);
                opts.init.call($this);
                timer = setInterval(function() {
                    nTime--;
                    if (nTime == 0) {
                        $this.removeAttr("disabled").html(html);
                        clearInterval(timer);
                        opts.callback.call($this);
                    } else {
                        $this.html(function() {
                            if (/\$time/.test(opts.text)) {
                                return opts.text.replace("$time", nTime);
                            } else {
                                return nTime + opts.text;
                            }
                        });
                    }
                }, 1000);
            });
        };


        $("#timer").countdown({
            text: "秒跳转到首页",
            callback: function() {
                location.href = "/p";
            }
        });

    </script>

</body>
</html>