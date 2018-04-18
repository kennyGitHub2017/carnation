<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />

    <title>诚聘英才,市场营销人才招聘,商务人才招聘,运营人才招聘 - 云尚招商网</title>
    <meta name="keywords" content="诚聘英才,市场营销人才招聘,商务人才招聘,运营人才招聘, 云尚招商网" />
    <meta name="description" content="云尚招商网是云尚中国健康管理集团旗下云尚的招商加盟平台，为云尚运营商提供360度全方位的运营扶持与技术支持。云尚打造了一个集健康管理服务、同业联盟O2O、移动支付和积分通兑为一体的综合性健康管理与增值服务平台。云尚服务热线：xxxxxxxx 。">
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
                location.href = "/e";
            }
        });

    </script>

</body>
</html>