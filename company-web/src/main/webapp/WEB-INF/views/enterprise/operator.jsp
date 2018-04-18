<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />

    <title>云尚运营商专栏, 运营商教学视频, 运营商风采 - 云尚招商网</title>
    <meta name="keywords" content="云尚运营商专栏, 运营商教学视频, 运营商风采, 云尚招商网" />
    <meta name="description" content="云尚招商网是云尚中国健康管理集团旗下云尚的招商加盟平台，为云尚运营商提供视频教学，培训会议等活动会议。云尚打造了一个集健康管理服务、同业联盟O2O、移动支付和积分通兑为一体的综合性健康管理与增值服务平台。云尚服务热线：xxxxxxxx 。">
    <link href="${staticPath}/static/platform/assets/css/jquery.fancybox-1.3.4.css" rel="stylesheet" type="text/css">
    <link href="${staticPath}/static/enterprise/assets/video/video-js.min.css" rel="stylesheet" type="text/css">
    <%@ include file="include/inc_css.jsp"%>

</head>
<body mid="m-operator">
    <%@ include file="include/header.jsp"%>
    <div class="mod-banner" style="background-image: url(${staticPath}/static/enterprise/assets/images/banner-operator.jpg)"></div>
    <div class="mod-block clearfix">
        <div class="cont-width">
            <div class="home-title">
                <h2>教学视频</h2>
                <span>Instructional Videos</span>
            </div>
            <div class="home-case-list video-list row">
				<c:forEach var="obj" items="${objs}" varStatus="status">
					<div class="col-md-3 home-case-item">
	                    <a href="/news/${obj.id}">
	                        <div class="posR">
	                        	<c:choose>
	                        		<c:when test="${obj.img != null && obj.img != ''}"><img src="${obj.img }_204x154" /></c:when>
	                        		<c:otherwise><img src="${staticPath }/static/enterprise/assets/images/pic/p-logo.png"></c:otherwise>
	                        	</c:choose>
	                            <div class="vjs-big-play-button play-button"><span aria-hidden="true"></span></div>
	                        </div>
	                        <div class="title">${obj.title }</div>
	                        <div>
	                           <c:choose>  
								    <c:when test="${fn:length(obj.artDesc) > 50}">  
								        <c:out value="${fn:substring(obj.artDesc, 0, 50)}......" />  
								    </c:when>  
								   <c:otherwise>  
								      <c:out value="${obj.artDesc}" />  
								    </c:otherwise>  
								</c:choose> 
	                        </div>
	                    </a>
	                </div>
				</c:forEach>
            </div>
            <div class="text-center">
                <nav class="text-center">
				 <ul class="pagination">
		       		  ${gotoPageHTML}
		   		 </ul> 
				</nav>
            </div>
        </div>
    </div>

    <div class="mod-block home-news clearfix">
        <div class="cont-width">
            <div class="home-title white-title">
                <h2>加盟流程</h2>
                <span>Joining process</span>
            </div>
            <div class="join-process  bounceIn wow animated" style="visibility: visible; animation-name: bounceIn;"></div>
        </div>
    </div>



    <div class="mod-block operator-list">
        <div class="clearfix">
            <div class="home-title">
                <h2>运营商风采</h2>
                <span>Operators style</span>
            </div>
            <div class="col-md-2 col-xs-4">
                <img src="${staticPath}/static/enterprise/assets/images/operator/p-01.jpg" />
            </div>
            <div class="col-md-2 col-xs-4">
                <img src="${staticPath}/static/enterprise/assets/images/operator/p-02.jpg" />
            </div>
            <div class="col-md-2 col-xs-4">
                <img src="${staticPath}/static/enterprise/assets/images/operator/p-03.jpg" />
            </div>
            <div class="col-md-2 col-xs-4">
                <img src="${staticPath}/static/enterprise/assets/images/operator/p-04.jpg" />
            </div>
            <div class="col-md-2 col-xs-4">
                <img src="${staticPath}/static/enterprise/assets/images/operator/p-05.jpg" />
            </div>
            <div class="col-md-2 col-xs-4">
                <img src="${staticPath}/static/enterprise/assets/images/operator/p-06.jpg" />
            </div>
            <div class="col-md-2 col-xs-4">
                <img src="${staticPath}/static/enterprise/assets/images/operator/p-07.jpg" />
            </div>
            <div class="col-md-2 col-xs-4">
                <img src="${staticPath}/static/enterprise/assets/images/operator/p-08.jpg" />
            </div>
            <div class="col-md-2 col-xs-4">
                <img src="${staticPath}/static/enterprise/assets/images/operator/p-09.jpg" />
            </div>
            <div class="col-md-2 col-xs-4">
                <img src="${staticPath}/static/enterprise/assets/images/operator/p-10.jpg" />
            </div>
            <div class="col-md-2 col-xs-4">
                <img src="${staticPath}/static/enterprise/assets/images/operator/p-11.jpg" />
            </div>
            <div class="col-md-2 col-xs-4">
                <img src="${staticPath}/static/enterprise/assets/images/operator/p-12.jpg" />
            </div>

        </div>
    </div>


    <%@ include file="include/footer.jsp"%>

</body>
</html>