<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
    <title>云尚,云尚大健康,云尚APP,云尚直销,云尚上市,云尚健康管理平台,云尚健康商城,云尚健康调理中心,云尚运营中心,云尚健康一体机,吉林云尚</title>
    <meta name="keywords" content="云尚,云尚大健康,云尚APP,云尚健康管理平台,云尚健康商城,云尚调理中心,云尚运营中心,云尚健康一体机,云尚互联网健康管理平台,吉林云尚" />
    <meta name="description" content="云尚大健康是吉林云尚保健食品有限公司旗下的移动互联网健康管理平台，云尚健康管理综合服务平台主要为用户提供健康管理、健康智能设备、健康专家实时咨询、健康生活资讯、健康自测、健康商城、健康周边服务、健康圈等健康生活服务。云尚打造了一个集健康管理服务、同业联盟O2O、移动支付和积分通兑为一体的综合性健康管理与增值服务平台。云尚服务热线：400-888-2933 。">
    <meta name="baidu-site-verification" content="Hn0TAzlT22" />
	<link href="${staticPath}/static/enterprise/assets/css/flexslider.css" rel="stylesheet" type="text/css">
    <%@ include file="include/inc_css.jsp"%>
</head>
<body mid="m-index">
    <%@ include file="include/header.jsp"%>
    <div class="flexslider">
        <ul class="slides">
        	<c:forEach items="${indexSlide}" var="slide">
	            <li style="background-image: url(${slide.adImgPath})"></li>
			</c:forEach>
        </ul>
    </div>
    <div class="home-tabs mod-block clearfix">
        <div class="cont-width">
            <div class="home-title">
                <h2>
                    <a href="javascript:;" tab="newsArticles" class="active">招商动态</a>  |
                    <a href="javascript:;" tab="newsVideos">招商视频</a>
                </h2>
                <span>Investment promotion</span>
            </div>
            <div id="newsTabs">
	            <div id="newsArticles">
		            <c:choose> 
						<c:when test="${!empty indexEvent}">   
					    	<div class="col-md-6">
				            	<a href="${indexEvent.adUrl}" class="home-tab-banner">
				                    <img src="${indexEvent.adImgPath}" width="489" height="333"/>
				                    <p>${indexEvent.adTitle}</p>
				                </a>
				            </div>
					  	</c:when> 
					  	<c:otherwise>   
							<div class="col-md-6">
				            	<a href="javascript:void(0);" class="home-tab-banner">
				                    <img src="http://static.ysysgo.com/static/enterprise/assets/images/pic/p-01.jpg" width="489" height="333"/>
				                    <p>默认图片，请上传推荐图片</p>
				                </a>
				            </div>
					  	</c:otherwise> 
					</c:choose> 
		            <div class="col-md-6 home-tab-list">
		            	<c:forEach items="${events}" var="event">
		                <div class="media animated fadeInDown">
		                    <a href="${yesPath}/news/${event.id}">
		                        <div class="media-left">
		                            <div class="date">
		                            <span><fmt:formatDate value="${event.addTime}" pattern="dd"/></span><fmt:formatDate value="${event.addTime}" pattern="yyyy-MM"/>
		                            </div>
		                        </div>
		                        <div class="media-body">
		                            <h4 class="media-heading">${event.title}</h4>
		                            <p>
		                            <c:choose>  
									    <c:when test="${fn:length(event.artDesc) > 50}">  
									        <c:out value="${fn:substring(event.artDesc, 0, 50)}......" />  
									    </c:when>  
									   <c:otherwise>  
									      <c:out value="${event.artDesc}" />  
									    </c:otherwise>  
									</c:choose> 
		                            </p>
		                        </div>
		                    </a>
		                </div>
		                </c:forEach>
		            </div>
		            <c:if test="${!empty events}">
		            <div class="text-center">
		                <a href="${yesPath}/news/more?mark=ZS_EVENT" class="view-more view-more-gray">查看更多 &gt;&gt;</a>
		            </div>
		            </c:if>
	            </div>
	            <div id="newsVideos" class="hidden">
		            <c:choose> 
						<c:when test="${!empty indexVideo}">   
					    	<div class="col-md-6">
				            	<a href="${indexVideo.adUrl}" class="home-tab-banner">
				                    <img src="${indexVideo.adImgPath}" width="489" height="333"/>
				                    <p>${indexVideo.adTitle}</p>
				                </a>
				            </div>
					  	</c:when> 
					  	<c:otherwise>   
							<div class="col-md-6">
				            	<a href="javascript:void(0);" class="home-tab-banner">
				                    <img src="http://static.ysysgo.com/static/enterprise/assets/images/pic/p-01.jpg" width="489" height="333"/>
				                    <p>默认图片，请上传推荐图片</p>
				                </a>
				            </div>
					  	</c:otherwise> 
					</c:choose> 
		            <div class="col-md-6 home-tab-list">
		            	<c:forEach items="${videos}" var="video">
		                <div class="media animated fadeInUp">
		                    <a href="${yesPath}/news/${video.id}">
		                        <div class="media-left">
		                            <div class="date">
		                            <span><fmt:formatDate value="${video.addTime}" pattern="dd"/></span><fmt:formatDate value="${video.addTime}" pattern="yyyy-MM"/>
		                            </div>
		                        </div>
		                        <div class="media-body">
		                            <h4 class="media-heading">${video.title}</h4>
		                            <p>
		                            <c:choose>  
									    <c:when test="${fn:length(video.artDesc) > 50}">  
									        <c:out value="${fn:substring(video.artDesc, 0, 50)}......" />  
									    </c:when>  
									   <c:otherwise>  
									      <c:out value="${video.artDesc}" />  
									    </c:otherwise>  
									</c:choose> 
		                            </p>
		                        </div>
		                    </a>
		                </div>
		                </c:forEach>
		            </div>
		            <c:if test="${!empty videos}">
		            <div class="text-center">
		                <a href="${yesPath}/news/more?mark=ZS_VIDEO" class="view-more view-more-gray">查看更多 &gt;&gt;</a>
		            </div>
		            </c:if>
	            </div>
            </div>
        </div>
    </div>
    <div class="home-news mod-block clearfix">
        <div class="cont-width">
            <div class="home-title white-title">
                <h2>行业动态</h2>
                <span>industry dynamics</span>
            </div>
            <div class="home-news-list row">
            	<c:forEach items="${hyevents}" var="hyevent">
                <div class="col-md-6 home-news-item animated fadeIn wow">
                    <a href="${yesPath}/news/${hyevent.id}">
                        <img src="${hyevent.img}" width="140" height="96"/>
                        <div class="title">${hyevent.title}</div>
                        <span class="date">[<fmt:formatDate value="${hyevent.addTime}" pattern="yyyy-MM-dd"/>]</span>
                        <div class="cont">
                        <c:choose>  
						    <c:when test="${fn:length(hyevent.artDesc) > 30}">  
						        <c:out value="${fn:substring(hyevent.artDesc, 0, 30)}......" />  
						    </c:when>  
						   <c:otherwise>  
						      <c:out value="${hyevent.artDesc}" />  
						    </c:otherwise>  
						</c:choose> 
                        </div>
                    </a>
                </div>
                </c:forEach>
            </div>
            <c:if test="empty hyevents">
            <div class="text-center">
                <a href="${yesPath}/news/more?mark=ZS_HY_EVENT" class="view-more">查看更多 &gt;&gt;</a>
            </div>
            </c:if>
        </div>
    </div>
    <div class="mod-block clearfix">
        <div class="cont-width">
            <div class="home-title">
                <h2>客户案例</h2>
                <span>Customer Case</span>
            </div>
            <div class="home-case-list row">
            	<c:forEach items="${customers}" var="customer">
                <div class="col-md-3 home-case-item animated fadeInUp wow delay-2">
                    <a href="${yesPath}/news/${customer.id}">
                        <img src="${customer.img}" width="212" height="160"/>
                        <div class="title">${customer.title}</div>
                        <div></div>
                    </a>
                </div>
                </c:forEach>
            </div>
            <c:if test="empty customers">
            <div class="text-center">
                <a href="${yesPath}/news/more?mark=ZS_CUSTOMER" class="view-more">查看更多 &gt;&gt;</a>
            </div>
            </c:if>
        </div>
    </div>
    <%@ include file="include/footer.jsp"%>
	<script src="${staticPath}/static/enterprise/assets/js/flexslider.js"></script>
    <script>
    	$(".flexslider").flexslider();
    	$("a[tab]").click(function() {
    		if ($(this).hasClass("active")) return;
    		$(this).addClass("active").siblings().removeClass("active");
    		$("#" + $(this).attr("tab")).removeClass("hidden").siblings().addClass("hidden");
    	});
    </script>
</body>
</html>