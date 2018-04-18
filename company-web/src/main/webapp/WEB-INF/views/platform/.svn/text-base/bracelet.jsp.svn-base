<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" id="viewport"
          content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1"/>

    <title>云尚健康手环,云尚健康手环APP,健康设备APP,健康运动神器，健康管理手环  -  云尚</title>
    <meta name="keywords" content="云尚健康手环,云尚健康手环APP,健康设备APP,健康运动神器，健康管理手环"/>
    <meta name="description" content="云尚健康手环是一款云尚健康管理综合服务平台专为健康人士提供健康管理的移动设备，通过手环与云尚APP连接，随时随地查看运动的情况：里程、消耗能量、睡眠质量，实现移动健康管理的目的。云尚服务热线：xxxxxxxx 。">
    
	<%@ include file="include/inc_css.jsp"%>
    <style>
        .bracelet-banner { position: relative; height: 649px;}
        .b-code { float: left; padding-left: 10px; text-align: center; font-size: 12px; line-height: 1.6; width: 110px;}.b-code img { margin-bottom: 6px;}
        .b-code p { font-size: 0.8em;}

        .down-android, .down-ios { display: block; width: 164px; height: 42px; background-image: url("${staticPath}/static/platform/assets/images/app-btn.png");}
        .down-ios { background-position: 0 -44px;}
        .down-btns { float: left; padding: 20px 0 0 20px;}.down-btns a { margin-top: 15px;}
        .b-down { padding-top: 350px; color: #fff;}
        .bar-content { position: relative; overflow: hidden;  margin-bottom: -50px; line-height: 1.8;  background-size: cover; background-position: center bottom;}.bar-content h3 { padding-bottom: 10px;}

        .b-ico-01,.b-ico-02,.b-ico-03 { display: inline-block; margin: 20px 10px 0 0; width: 95px; height: 95px; background-image: url(${staticPath}/static/platform/assets/images/app.jpg); background-position: -184px 0;}
        .b-ico-02 { background-position: -184px -97px;} .b-ico-03 { background-position: -184px -194px;}

        .bg-01 { padding-top: 45px; height: 656px; background-image: url(${staticPath}/static/platform/assets/images/bar-bg-01.jpg);}
        .bg-01 img { margin-left: 120px; max-height: 480px;}
        .bg-01 .text { padding-top: 120px;  color: #fff;}

        .bg-02 { margin-bottom: -125px; height: 530px;}
        .bg-02 .text { padding-top: 170px; }

        .bg-03 { margin-bottom: 0; padding-top: 120px; height: 634px; background-image: url(${staticPath}/static/platform/assets/images/bar-bg-02.jpg);}
        .bg-03 .text { margin-left: -50px; padding-top: 80px;  color: #fff;}

        .bg-04 { height: 530px; margin-bottom: -180px;}
        .bg-04 .text { padding-top: 130px; }

        .bg-05 { margin-bottom: 0; padding-top: 100px; height: 634px; background-image: url(${staticPath}/static/platform/assets/images/bar-bg-03.jpg);}
        .bg-05 .text { margin-left: -120px; padding-top: 140px;  color: #fff;}
        .bg-05 img { max-width: 470px;}

        .bg-06 { margin-bottom: 0;}
        .bg-06 img { width: 60%;}
        .bg-06 .text { padding-top: 130px;}

        .bg-07 { margin-bottom: 0; padding-top: 135px; height: 732px; background-image: url(${staticPath}/static/platform/assets/images/bar-bg-04.jpg);}
        .bg-07 .text { padding-top: 50px;  color: #fff;}

        .b-color-bar { margin-top: 15px; width: 257px; height: 49px; line-height: 49px; background-image: url(${staticPath}/static/platform/assets/images/bar-color-bg.png);}
        .ico-color-gold,.ico-color-black { margin-left: 20px; display: inline-block; width: 19px; height: 17px; background: url(${staticPath}/static/platform/assets/images/app.jpg) -206px -300px; vertical-align: text-bottom;}
        .ico-color-black { background-position: -234px -300px;}

        .b-item { margin-bottom: 10px; padding: 5px 0 0 75px; height: 70px; color: #fff; background-color: #f9af7c; position: relative;font-size: 2rem;}
        .b-item p { font-size: 1rem;}
        .b-item-01,.b-item-02,.b-item-03 { position: absolute; left: 0; top: 0; bottom: 0; width: 70px; background: url("${staticPath}/static/platform/assets/images/app.jpg") no-repeat -282px 0;}
        .b-item-02 { background-position: -290px -120px;} .b-item-03 { background-position: -290px -230px;}
        .b-item-title { color: #fff; padding: 90px 0 20px;}
        .b-item-title p {font-size: 12px;}

        @media screen and (max-width: 40em) {
            .bar-content { font-size: 0.9rem; line-height: 1.6;}
            .bar-content h3 { font-size: 1.8rem;}

            .bar-content img { width: 350px; display: block; margin: 0 auto;}

            .bg-01 .text { position: absolute; top: 20px; padding-top: 0;}
            .bg-01 img { width: auto; height: 350px; margin: 110px auto 0;}

            .bg-02 { margin-bottom: -125px; }
            .bg-02 .text { padding-top: 0px; }

            .bg-03 .text { margin-left: 20px; padding-top: 60px; }

            .bg-04 { height: auto; margin-bottom: -150px;}
            .bg-04 .text { padding-top: 0; padding-bottom: 10px; }
            .bg-04 img { max-width: 80%;}

            .bg-05 .text { padding-top: 0; margin-left: 20px; }

            .bg-06 .text { padding-top: 0;}
            .bg-06 img { max-width: 50%;}

            .bg-07 { padding-top: 145px; height: auto;}
            .bg-07 .text { padding-top: 20px;}

            .b-item-title { padding-left: 20px; padding-top: 140px;}


        }




    </style>

</head>
<body>

<%@ include file="include/header.jsp"%>

<div style="background-image: url(${staticPath}/static/platform/assets/images/banner-bracelet.jpg)" class="mod-banner bracelet-banner">
    <div class="cont-width b-down animated fadeInUp wow">
        <div class="b-code">
            <img src="${staticPath}/static/platform/assets/images/code.jpg" />
            <div>扫描二维码下载</div>
            <p>(自动识别手机系统)</p>
        </div>
        <div class="down-btns">
            <a href="http://www.pgyer.com/Wi36" class="down-ios"></a>
            <a href="http://www.pgyer.com/zMAS" class="down-android"></a>
        </div>
    </div>
</div>

<div class="bg-01 bar-content">
    <div class="cont-width clearfix">
        <div class="col-md-6 animated fadeInLeft wow"> <img src="${staticPath}/static/platform/assets/images/bra-01.png" /></div>
        <div class="col-md-6 text animated fadeInRight wow">
            <h3>运动计步：你的每一步，我都很在意</h3>
            你的每一次行走、慢跑、爬楼梯，周末的户外运动或是日常的室内健身，
            云尚智能手环不会错过你的任何一个动作。一切都将以明确的数据方式
            记录并呈现，让每一天，更健康一点。
        </div>
    </div>
</div>


<div class="bg-02 bar-content">
    <div class="cont-width clearfix">
        <div class="col-md-4 col-md-offset-1 text animated fadeInUp wow">
            <h3>运动距离：<br>记录一整天的里程</h3>
            精准记录每天行走的距离，从清晨到夜晚，
            从上班到下班，帮你设定目标并达到目标，
            今天的你是否超越昨天的自己？
        </div>
        <div class="col-md-6 animated fadeIn wow"> <img src="${staticPath}/static/platform/assets/images/bra-02.jpg" /></div>
    </div>
</div>

<div class="bg-03 bar-content">
    <div class="cont-width clearfix">
        <div class=" col-md-offset-1 col-md-6 animated fadeInLeft wow"> <img src="${staticPath}/static/platform/assets/images/bra-03.png" /></div>
        <div class="col-md-5 text text animated fadeInDown wow">
            <h3>卡路里消耗：燃烧吧热量</h3>
            计算每天的卡路里和热量消耗情况，你的每一次<br>运动都在为健康和塑身做积累。
        </div>
    </div>
</div>

<div class="bg-04 bar-content">
    <div class="cont-width clearfix">
        <div class="col-md-5 col-md-offset-2 text animated fadeInDown wow">
            <h3>睡眠监控：陪伴你的每一个夜晚</h3>
            帮你记录深度睡眠和浅度睡眠时间，通过监测数据改善睡眠质量，让你更加生动地过好每一天。
        </div>
        <div class="col-md-3 animated fadeInUp wow"> <img src="${staticPath}/static/platform/assets/images/bra-04.jpg" /></div>
    </div>
</div>

<div class="bg-05 bar-content">
    <div class="cont-width clearfix">
        <div class="col-md-6 col-md-offset-1 animated fadeInLeft wow"> <img src="${staticPath}/static/platform/assets/images/bra-05.png" /></div>
        <div class="col-md-5 text animated fadeInRight wow">
            <h3>时间显示：蓝牙同步手环与手机</h3>
            分析运动与睡眠数据，为你制定合理有效的健康管理方式。
        </div>
    </div>
</div>

<div class="bg-06 bar-content">
    <div class="cont-width clearfix">
        <div class="col-md-5 col-md-offset-1 text  animated fadeInUp wow">
            <h3>定时提醒：点滴积累养成好习惯</h3>
            设置事件定时提醒，起床、闹钟、喝水、久坐，健康的身体不只是运动，好的习惯也会加分。
            <div>
                <span class="b-ico-01"></span>
                <span class="b-ico-02"></span>
                <span class="b-ico-03"></span>
            </div>

        </div>
        <div class="col-md-4 col-md-offset-2  animated fadeInDown wow"> <img src="${staticPath}/static/platform/assets/images/bra-06.jpg" /></div>
    </div>
</div>


<div class="bg-07 bar-content">
    <div class="cont-width clearfix">
        <div class="col-md-6 col-md-offset-1 animated fadeIn wow"> <img src="${staticPath}/static/platform/assets/images/bra-07.png" /></div>
        <div class="col-md-5 text animated fadeInLeft wow">
            <h3>时尚外观：高科技也能成为时尚单品</h3>
            简洁流畅的时尚设计，轻便精致零束缚，三种颜色可供选择，
            极致黑，优雅银，时尚金，总有一款适合你。
            <div class="b-color-bar">
                <i class="ico-color-gold"></i> 土豪金
                <i class="ico-color-black"></i> 极至黑
            </div>
        </div>
        <div class="col-md-12 b-item-title animated fadeIn wow">
            <h4>你以为只有这些？</h4>
            <p>do you think only these?</p>
        </div>
        <div class="col-md-4 animated fadeInUp wow">
            <div class="b-item">
                <i class="b-item-01"></i>
                IP-X6级防水
                <p>运动流汗或潮湿生活环境下仍可正常使用。</p>
            </div>
        </div>
        <div class="col-md-4 animated fadeInUp wow delay-1">
            <div class="b-item">
                <i class="b-item-03"></i>
                超长待机
                <p>2-3小时充电，超长待机。</p>
            </div>
        </div>
        <div class="col-md-4">
            <div class="b-item animated fadeInUp wow delay-2">
                <i class="b-item-02"></i>
                使用方式简单便捷
                <p>扫码下载APP，完成注册登录即可。</p>
            </div>
        </div>
    </div>
</div>






<%@ include file="include/footer.jsp"%>

</body>
</html>