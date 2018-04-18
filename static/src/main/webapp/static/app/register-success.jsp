<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />

    <title>注册成功</title>

    <%@ include file="include/inc_css.jsp"%>

</head>
<body>

    <div class="reg-wrap">
        <h1 class="text-center"><img src="assets/images/logo.png"></h1>

        <p class="page-ico"><img src="assets/images/success.jpg" /></p>
        <div class="reg-success">
            <div class="c-blue">恭喜您，已成为云尚会员！</div>
            <div>系统将 <span class="c-blue" id="timeNum">3秒</span> 后自动跳转到下载页面！</div>
        </div>
        <a href="http://static.ysysgo.com/static/platform/appDownload.jsp" class="btn btn-blue btn-block">立即下载</a>


        <p class="text-center reg-copyright">
            版权所有：云尚<br>
            服务热线：xxxxxxxx
        </p>


    </div>



    <!--<div class="fixed-bottom-bar double-btn-bar pt-10">-->
        <!--<button class="btn btn-blue">附近医院</button>-->
        <!--<button class="btn btn-blue">咨询专家</button>-->
    <!--</div>-->

    <script src="assets/js/jquery-2.1.4.min.js"></script>
    <script src="assets/js/jquery-validate.min.js"></script>

    <script>
        var time=3;
        setInterval(function() {
            time--
            if (time == 0) {
                location.href = "http://static.ysysgo.com/static/platform/appDownload.jsp";
            }
            $("#timeNum").html(time + "秒");
        },1000);
    </script>

</body>
</html>