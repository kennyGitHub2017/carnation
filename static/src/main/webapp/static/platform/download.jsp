<!DOCTYPE html>
<html class="fsvs" lang="en">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1"/>

    <title>云尚平台官网</title>
    <meta name="keywords" content="健康生活"/>
    <meta name="description" content="">
	<link href="assets/css/fsvs.css" rel="stylesheet" type="text/css">
	<%@ include file="include/inc_css.jsp"%>

</head>
<body mid="m-download">

<div id="fsvs-body" class="down-body">
    <div class="slide slide-01 down-header">
        <%@ include file="include/header.jsp"%>
        <div class="slide-content">
            <div class="down-content" _class="animated fadeInRight delay-4">
                <h2>云尚平台</h2>
                <div class="fz-24 pt-10">透视健康大数据</div>
                <div class="down-code">
                    <img src="assets/images/code.jpg" />
                    <p><a href="http://static.ysysgo.com/static/yunesheng.apk" class="btn btn-success">点击下载</a> </p>
                    <p>从今天起，把健康装进口袋</p>
                </div>

            </div>
            <div class="slide-pic-box" _class="animated fadeInLeft delay-3"><img src="assets/images/pic/d-06.jpg" class="main-pic"></div>
        </div>
    </div>
    <div class="slide slide-02 pt-20">
        <div class="slide-content">
            <div class="home-title c-fff" _class="animated fadeInUp delay-4">
                <h2>以抗衰老为核心的健康管理</h2>
                <span>提供水质环境改善的各类建议和产品，如水净化设备等各类产品及本地相关服务门店</span>

            </div>
            <div class="slide-pic-box" _class="animated lightSpeedIn"><img src="assets/images/pic/d-01.jpg" class="main-pic"></div>
        </div>
    </div>
    <div class="slide slide-03">
        <div class="slide-content">
            <div class="slide-03-text01" _class="animated fadeInDown delay-4">
                <h3>空气</h3>
                <span>提供空气环境改善的各类建议和产品、如空气净化设备，水质净化器及本地相关服务门店</span>
            </div>
            <div class="slide-03-text02" _class="animated fadeInUp delay-4">
                <h3>阳光</h3>
                <span>提供光照环境改善的各类建议和产品，如防止紫外线等各类产品</span>
            </div>
            <div class="slide-pic-box" _class="animated bounceIn delay-3"><img src="assets/images/pic/d-02.jpg" class="main-pic"></div>
        </div>
    </div>
    <div class="slide slide-04">
        <div class="slide-content">
            <div class="down-content" _class="animated fadeInUp delay-4">
                <h3>以抗衰老为核心的<br>健康管理</h3>
                <span>提供对应的每日运动任务（参考体检宝），完成任务可获取积分，个人信息管理：个人资料、收货地址、订单查询、密码管理；</span>
            </div>
            <div class="slide-pic-box" _class="animated fadeInDown delay-3"><img src="assets/images/pic/d-03.jpg" class="main-pic"></div>
        </div>
    </div>
    <div class="slide slide-05">
        <div class="slide-content">
            <div class="down-content" _class="animated fadeInRight delay-4">
                <h3>以抗衰老为核心的<br>健康管理</h3>
                <span>提供对应的每日运动任务（参考体检宝），完成任务可获取积分，个人信息管理：个人资料、收货地址、订单查询、密码管理；</span>
            </div>
            <div class="slide-pic-box" _class="animated fadeInLeft delay-3"><img src="assets/images/pic/d-04.jpg" class="main-pic"></div>
        </div>
    </div>
    <div class="slide slide-06">
        <div class="slide-content">
            <div class="down-content" _class="animated fadeInUp delay-4">
                <h3>以抗衰老为核心的<br>健康管理</h3>
                <span>提供对应的每日运动任务（参考体检宝），完成任务可获取积分，个人信息管理：个人资料、收货地址、订单查询、密码管理；</span>
            </div>
            <div class="slide-pic-box" _class="animated fadeInDown delay-3"><img src="assets/images/pic/d-05.jpg" class="main-pic"></div>
        </div>
        <div class="down-footer">
			<%@ include file="include/footer.jsp"%>
        </div>
    </div>

</div>



<script src="assets/js/fsvs.js"></script>


<script>

    jQuery(document).ready(function($){
        var slider = $.fn.fsvs({
            speed               : 1000,
            bodyID              : 'fsvs-body',
            selector            : '> .slide',
            mouseSwipeDisance   : 40,
            beforeSlide: function(i, o) {
                var $this = o.find("[_class]"), $siblings = o.siblings();
                $.each($this, function(i, n) {
                    $(n).addClass($(n).attr("_class"));
                });
                $.each($siblings, function(i, n) {
                    var $that = $(n).find("[_class]");
                    $.each($that, function(s, b) {
                        $(b).removeClass($(b).attr("_class"));
                    });
                });
            }
        });
    });


</script>

</body>
</html>