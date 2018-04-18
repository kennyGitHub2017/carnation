<!DOCTYPE html>
<html class="fsvs" lang="en">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1"/>

    <title>云尚商户APP,云尚商户版APP,云尚商户管理APP,云尚商户版下载,云尚商户苹果版IOS下载,云尚商户安卓版Android下载,云尚商户安卓版Android下载- 云尚</title>
    <meta name="keywords" content="云尚商户APP,云尚商户版APP,云尚商户管理APP,云尚商户版下载,云尚商户苹果版IOS下载,云尚商户安卓版Android下载,云尚商户安卓版Android下载" />
    <meta name="description" content="云尚商户APP是基于云尚大健康，为商户量身打造的专属商户服务的APP，为商户提供便捷、高效的店铺和订单管理服务。准确查看绑定会员的消费返佣，一键实现了轻松管理，轻松结算，轻松查看，轻松提现等功能。 云尚服务热线：400-888-2933 。">
	<link href="${staticPath}/static/platform/assets/css/fsvs.css" rel="stylesheet" type="text/css">
	<%@ include file="include/inc_css.jsp"%>

	<style>
		.slide-content-one-beijing{
	 	background:url(http://shop.ysysgo.com/resources/shop/ysysgo/appDownLoad/images/1-shd.png) center center no-repeat #fff;
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
	
		
		.slide-02 { background:url(http://shop.ysysgo.com/resources/shop/ysysgo/appDownLoad/images/2-shd.png) center center no-repeat; background-size:cover;}
		.slide-03 { background:url(http://shop.ysysgo.com/resources/shop/ysysgo/appDownLoad/images/3-shd.png) center center no-repeat #fff; background-size:cover;}
		.slide-08 { background:url(http://shop.ysysgo.com/resources/shop/ysysgo/appDownLoad/images/4-shd.png) center center no-repeat #fff; background-size:cover;}
		.slide-06 { background:url(http://shop.ysysgo.com/resources/shop/ysysgo/appDownLoad/images/5-shd.png) center center no-repeat #fff; background-size:cover;}
	
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