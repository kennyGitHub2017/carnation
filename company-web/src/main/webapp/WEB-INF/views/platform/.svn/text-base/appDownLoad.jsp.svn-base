<!DOCTYPE html>
<html class="fsvs" lang="en">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1"/>

    <title>云尚APP,云尚大健康APP,云尚APP下载,云尚APP手机版下载,云尚苹果版IOS下载,云尚安卓版Android下载,云尚购物APP下载,健康管理APP,云尚健康商城APP,云尚健康一体机APP,云尚健康手环APP</title>
    <meta name="keywords" content="云尚APP,云尚大健康APP,云尚APP下载,云尚APP手机版下载,云尚苹果版IOS下载,云尚安卓版Android下载,云尚购物APP下载,健康管理APP,云尚健康商城APP,云尚健康一体机APP,云尚健康手环APP"/>
    <meta name="description" content="云尚大健康APP是一款立足预防医学，以引导健康生活方式、慢性疾病风险预防为主要宗旨，以私人医生式的健康管理服务为核心的应用系统。云尚服务热线：400-888-2933 。">
    <link href="${staticPath}/static/platform/assets/css/fsvs.css" rel="stylesheet" type="text/css">
	<%@ include file="include/inc_css.jsp"%>

	<style>
		 .slide-content-one-beijing{
		 	background:url(http://shop.ysysgo.com/resources/shop/ysysgo/appDownLoad/images/banner1-1-22.png) center center no-repeat #fff;
		   background-size:cover;
		    width: 100%;
		    height: 100%;
		    overflow: hidden;
		    -webkit-backface-visibility: hidden;
		    -webkit-perspective: 1000;
		    position: relative;
		    bottom:0px;
		    background-position-y:-180px;
		    }
		
			.slide-02 { background:url(http://shop.ysysgo.com/resources/shop/ysysgo/appDownLoad/images/twolan.png) center center no-repeat; background-size:cover;}
			.slide-03 { background:url(http://shop.ysysgo.com/resources/shop/ysysgo/appDownLoad/images/banner1-3.png) center center no-repeat #fff; background-size:cover;}
			.slide-08 { background:url(http://shop.ysysgo.com/resources/shop/ysysgo/appDownLoad/images/banner1-4.png) center center no-repeat #fff; background-size:cover;}
			.slide-04 { background:url(http://shop.ysysgo.com/resources/shop/ysysgo/appDownLoad/images/banner1-5.png) center center no-repeat #fff; background-size:cover;}
			.slide-05 { background:url(http://shop.ysysgo.com/resources/shop/ysysgo/appDownLoad/images/banner1-6.png) center center no-repeat #fff; background-size:cover;}
			.slide-09 {background:url(http://shop.ysysgo.com/resources/shop/ysysgo/appDownLoad/images/banner1-7.png) center center no-repeat #fff; background-size:cover;}
			.slide-06 { background:url(http://shop.ysysgo.com/resources/shop/ysysgo/appDownLoad/images/banner1-8.png) center center no-repeat #fff; background-size:cover;}
		</style>
</head>
<body mid="m-app">
<div id="fsvs-body" class="down-body">
    <div class="slide app-slide-01">
        <%@ include file="include/header.jsp"%>
       
        <div class="slide-content-one-beijing"></div>
    </div>
    
    <div id="slide-2" class="slide slide-02 pt-20">
    </div>
    <div id="slide-3" class="slide slide-03">
    </div>

    <div id="slide-4" class="slide slide-08">
    </div>

    <div id="slide-5" class="slide slide-04">
    </div>
    <div id="slide-6" class="slide slide-05">
    </div>

    <div id="slide-7" class="slide slide-09">
    </div>

    <div id="slide-8" class="slide slide-06">
        
        <div class="down-footer">
            <%@ include file="include/footer.jsp"%>
        </div>
    </div>

</div>



<script src="${staticPath}/static/platform/assets/js/fsvs.js"></script>


<script>
	jQuery("#appdownload_li a").addClass("active");	

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