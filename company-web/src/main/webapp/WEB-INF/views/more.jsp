<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
    <title>云尚招商资讯, 云尚招商动态,互联网健康行业资讯 - 云尚招商网</title>
    <meta name="keywords" content="云尚招商资讯,云尚招商动态,互联网健康行业资讯,云尚招商网" />
    <meta name="description" content="云尚招商网是云尚中国健康管理集团旗下云尚的招商加盟平台，为云尚运营商提供云尚最新资讯，互联网健康行业资讯等最新动态。云尚打造了一个集健康管理服务、同业联盟O2O、移动支付和积分通兑为一体的综合性健康管理与增值服务平台。云尚服务热线：xxxxxxxx 。">
    <%@ include file="enterprise/include/inc_css.jsp"%>
</head>
<body>
    <%@ include file="enterprise/include/header.jsp"%>
    
    <div class="mod-banner" style="background-image: url(${staticPath}/static/enterprise/assets/images/banner-news.jpg)"></div>

    <div class="mod-block clearfix">
        <div class="cont-width">
            <div class="home-title">
                <h2>云尚资讯</h2>
                <span>Informations</span>
            </div>

    		<div class="home-tab-list">
    			<c:forEach items="${objs}" var="news" varStatus="obj">
                <div class="media animated fadeIn wow">
                    <a href="${yesPath}/news/${news.id}">
                        <div class="media-left">
                            <div class="date">
                            	<span> <fmt:formatDate value="${news.addTime}" pattern="dd"/></span> <fmt:formatDate value="${news.addTime}" pattern="yyyy-MM"/>
                            </div>
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading">${news.title}</h4>
                            <p>${news.artDesc}</p>
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
    <%@ include file="enterprise/include/footer.jsp"%>
</body>
</html>