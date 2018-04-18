<!DOCTYPE html>
<html class="fsvs" lang="en">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1"/>

    <title>云尚运营商APP,云尚运营商版APP,云尚运营商管理APP,云尚运营商版下载,云尚运营商苹果版IOS下载,云尚运营商安卓版Android下载,云尚运营商安卓版Android下载 - 云尚</title>
    <meta name="keywords" content="云尚运营商APP,云尚运营商版APP,云尚运营商管理APP,云尚运营商版下载,云尚运营商苹果版IOS下载,云尚运营商安卓版Android下载,云尚运营商安卓版Android下载" />
    <meta name="description" content="云尚运营商APP是为更好服务运营商，针对运营商需求开发的一款APP。不同等级的运营商可以随时查看个人账户的收支明细，详细统计运营商渠道收益，并能进行会员和商户的轻松管理。实现足不出户，轻松办公。云尚服务热线：400-888-2933 。">
	<link href="${staticPath}/static/platform/assets/css/fsvs.css" rel="stylesheet" type="text/css">
	<%@ include file="include/inc_css.jsp"%>
	<style>
			.slide-content-one-beijing{
		 	background:url(http://shop.ysysgo.com/resources/shop/ysysgo/appDownLoad/images/1-yys.png) center center no-repeat #fff;
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
		
			
		.slide-02 { background:url(http://shop.ysysgo.com/resources/shop/ysysgo/appDownLoad/images/2-yys.png) center center no-repeat; background-size:cover;}
		.slide-03 { background:url(http://shop.ysysgo.com/resources/shop/ysysgo/appDownLoad/images/3-yys.png) center center no-repeat #fff; background-size:cover;}
		.slide-08 { background:url(http://shop.ysysgo.com/resources/shop/ysysgo/appDownLoad/images/4-yys.png) center center no-repeat #fff; background-size:cover;}
		.slide-04 { background:url(http://shop.ysysgo.com/resources/shop/ysysgo/appDownLoad/images/5-yys.png) center center no-repeat #fff; background-size:cover;}
		.slide-06 { background:url(http://shop.ysysgo.com/resources/shop/ysysgo/appDownLoad/images/6-yys.png) center center no-repeat #fff; background-size:cover;}
		
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