<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />

    <title>云尚平台官网</title>
    <meta name="keywords" content="健康生活" />
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link href="assets/css/flexslider.css" rel="stylesheet" type="text/css">
    <link href="assets/video/video-js.min.css" rel="stylesheet" type="text/css">
    <%@ include file="include/inc_css.jsp"%>
</head>
<body mid="m-index">
	
	<%@ include file="include/header.jsp"%>
	<div class="flexslider">
        <ul class="slides">
            <li style="background-image: url(assets/images/banner.jpg)">
            </li>
            <li style="background-image: url(assets/images/banner02.jpg)">
            </li>
            <li style="background-image: url(assets/images/banner03.jpg)">
            </li>
            <li style="background-image: url(assets/images/banner04.jpg)">
            </li>
        </ul>
    </div>

    <div class="home-items clearfix">
        <div class="col-md-3 animated fadeInUp wow">
            <a href="javascript:void(0)" class="active">
                <div class="home-item"><span class="pic-01"></span></div>
            健康管理
            </a>
        </div>
        <div class="col-md-3 animated fadeInUp wow delay-1">
            <a href="javascript:void(0)">
                <div class="home-item"><span class="pic-02"></span></div>
            同业联盟O2O
            </a>
        </div>
        <div class="col-md-3 animated fadeInUp wow delay-2">
            <a href="javascript:void(0)">
                <div class="home-item"><span class="pic-03"></span></div>
            移动支付
            </a>
        </div>
        <div class="col-md-3 animated fadeInUp wow delay-3">
            <a href="javascript:void(0)">
                <div class="home-item"><span class="pic-04"></span></div>
            积分通兑
            </a>
        </div>
    </div>

    <div class="home-news mod-block clearfix">
        <div class="cont-width">
            <div class="home-title c-fff">
                <h2>公司动态</h2>
                <span>看看我们公司都发生了些什么</span>
            </div>
            <div class="home-news-list row">
                <div class="col-md-3 home-news-item animated slideInLeft wow delay-2">
                    <a href="#">
                        <img src="assets/images/pic/p-01.jpg" />
                        <div class="title">健康管理与医院的区别</div>
                        <div>大多数人对于健康的关注，通常是在生病了，需要去看医生......</div>
                    </a>
                </div>
                <div class="col-md-3 home-news-item animated slideInLeft wow">
                    <a href="#">
                        <img src="assets/images/pic/p-02.jpg" />
                        <div class="title">健康管理与医院的区别</div>
                        <div>大多数人对于健康的关注，通常是在生病了，需要去看医生......</div>
                    </a>
                </div>
                <div class="col-md-3 home-news-item animated slideInRight wow">
                    <a href="#">
                        <img src="assets/images/pic/p-03.jpg" />
                        <div class="title">健康管理与医院的区别</div>
                        <div>大多数人对于健康的关注，通常是在生病了，需要去看医生......</div>
                    </a>
                </div>
                <div class="col-md-3 home-news-item animated slideInRight wow delay-2">
                    <a href="#">
                        <img src="assets/images/pic/p-04.jpg" />
                        <div class="title">健康管理与医院的区别</div>
                        <div>大多数人对于健康的关注，通常是在生病了，需要去看医生......</div>
                    </a>
                </div>
            </div>
            <div class="text-center">
                <a href="#" class="view-more">查看更多 &gt;&gt;</a>
            </div>
        </div>
    </div>

    <div class="mod-block">
        <div class="cont-width clearfix">
            <div class="home-title gray-title">
                <h2>云尚集团旗下企业</h2>
                <span>看看我们公司集团旗下企业</span>
            </div>
            <div class="sub-company">
                <div class="col-md-6 sub-company-item animated bounceInDown wow">
                    <a href="#">
                        <div class="pic">
                            <img src="assets/images/pic/p-05.jpg">
                            <div class="over-cont">针对微整形出现的各类问题推送对应的服务内容（云尚美肤项目或其他商户）</div>
                        </div>
                        <div class="title">云尚中国国际抗衰老研究中心</div>
                    </a>
                </div>

                <div class="col-md-6 sub-company-item animated bounceInDown wow">
                    <a href="#">
                        <div class="pic">
                            <img src="assets/images/pic/p-06.jpg">
                            <div class="over-cont">针对微整形出现的各类问题推送对应的服务内容（云尚美肤项目或其他商户）</div>
                        </div>
                        <div class="title">云尚抗衰老生物科技研究院</div>
                    </a>
                </div>

                <div class="col-md-6 sub-company-item animated bounceInUp wow">
                    <a href="#">
                        <div class="pic">
                            <img src="assets/images/pic/p-07.jpg">
                            <div class="over-cont">针对微整形出现的各类问题推送对应的服务内容（云尚美肤项目或其他商户）</div>
                        </div>
                        <div class="title">云尚中国国际抗衰老中心</div>
                    </a>
                </div>

                <div class="col-md-6 sub-company-item animated bounceInUp wow">
                    <a href="#">
                        <div class="pic">
                            <img src="assets/images/pic/p-08.jpg">
                            <div class="over-cont">针对微整形出现的各类问题推送对应的服务内容（云尚美肤项目或其他商户）</div>
                        </div>
                        <div class="title">深圳市云尚抗衰老生物科技股份有限公司</div>
                    </a>
                </div>

            </div>
        </div>
    </div>

    <div class="home-video">
    	<div class="cont-width" id="video-box">
	    	<video id="MY_VIDEO_1" class="video-js vjs-default-skin" controls
			 preload="auto" height="407" poster="assets/images/o.png"
			 data-setup="{}">
			 <source src="assets/video/oceans.mp4" type='video/mp4'>
			 <source src="assets/video/oceans.webm" type='video/webm'>
			 <p class="vjs-no-js">To view this video please enable JavaScript, and consider upgrading to a web browser that <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a></p>
			</video>
    	</div>   
    </div>

    <div class="mod-block">
        <div class="cont-width clearfix">
            <div class="home-title gray-title">
                <h2>合作机构</h2>
                <span>众多机构与我们合作你还在等什么</span>
            </div>
            <div class="home-friend">
                <div class="friend-list">
                    <a href="javascript:void(0)"><img src="assets/images/pic/f-logo1.png" alt="瑞士健康中心" /></a>
                    <a href="javascript:void(0)"><img src="assets/images/pic/f-logo2.png" alt="北京中医药大学" /></a>
                    <a href="javascript:void(0)"><img src="assets/images/pic/f-logo3.png" alt="香港城市大学高通基因诊断有限公司" /></a>
                    <a href="javascript:void(0)"><img src="assets/images/pic/f-logo4.png" alt="日本大坪会" /></a>
                    <a href="javascript:void(0)"><img src="assets/images/pic/f-logo5.png" alt="广东正源分子生物有限公司" /></a>
                    <a href="javascript:void(0)" class="spill"><img src="assets/images/pic/f-logo6.png" alt="华大基因" /></a>
                    <a href="javascript:void(0)"><img src="assets/images/pic/f-logo7.png" alt="日本共生医学研究所" /></a>
                    <a href="javascript:void(0)"><img src="assets/images/pic/f-logo8.png" alt="中国老年学学会衰老与抗衰老科学委员会" /></a>
                    <a href="javascript:void(0)"><img src="assets/images/pic/f-logo9.png" alt="中国医师协会抗衰老专业委员会" /></a>
                    <a href="javascript:void(0)"><img src="assets/images/pic/f-logo10.png" alt="美国云尚USANA抗衰老疗养中心" /></a>
                    <a href="javascript:void(0)"><img src="assets/images/pic/f-logo11.png" alt="千博集团" /></a>
                    <a href="javascript:void(0)"><img src="assets/images/pic/f-logo12.png" alt="韩国天主教关东大学国际圣母医院" /></a>
                    <a href="javascript:void(0)"><img src="assets/images/pic/f-logo13.png" alt="SNE" /></a>
                </div>
            </div>

        </div>
    </div>

	<%@ include file="include/footer.jsp"%>

	<script type="text/javascript" src="assets/video/video.min.js"></script>
	<script src="assets/js/flexslider.js"></script>
    <script>
    	$(".flexslider").flexslider();

    	var myPlayer = videojs("MY_VIDEO_1"), $box = $("#video-box");
    	
    	myPlayer.width($box.width());
//
//        $("#video-box,.home-video").click(function() {
//            myPlayer.requestFullscreen();
//        });
//
    </script>
</body>
</html>