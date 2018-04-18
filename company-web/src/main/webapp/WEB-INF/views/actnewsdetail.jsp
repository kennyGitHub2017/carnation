<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head lang="en">
<meta charset="UTF-8">
<meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
<title>${refereeArticle.title } - 云尚</title>
<c:choose> 
<c:when test="${empty refereeArticle.keywords}">  
<meta name="keywords" content="${refereeArticle.title },云尚" />
</c:when> 
<c:otherwise>
<meta name="keywords" content="${refereeArticle.title },云尚" />
</c:otherwise> 
</c:choose>
<c:choose> 
<c:when test="${empty refereeArticle.description}">  
<meta name="description" content="云尚大健康是吉林云尚保健食品有限公司旗下的移动互联网健康管理平台，云尚健康管理综合服务平台主要为用户提供健康管理、健康智能设备、健康专家实时咨询、健康生活资讯、健康自测、健康商城、健康周边服务、健康圈等健康生活服务。云尚打造了一个集健康管理服务、同业联盟O2O、移动支付和积分通兑为一体的综合性健康管理与增值服务平台。云尚服务热线：400-888-2933 。">
</c:when> 
<c:otherwise>
<meta name="description" content="云尚大健康是吉林云尚保健食品有限公司旗下的移动互联网健康管理平台，云尚健康管理综合服务平台主要为用户提供健康管理、健康智能设备、健康专家实时咨询、健康生活资讯、健康自测、健康商城、健康周边服务、健康圈等健康生活服务。云尚打造了一个集健康管理服务、同业联盟O2O、移动支付和积分通兑为一体的综合性健康管理与增值服务平台。云尚服务热线：400-888-2933 。">
</c:otherwise> 
</c:choose>
<%@ include file="platform/include/inc_css.jsp"%>
</head>
<body>
	<%@ include file="platform/include/header.jsp"%>
	<%--
	<div class="mod-banner" style="background-image: url(${staticPath}/static/platform/assets/images/banner-news.jpg)"></div>
	--%>
	<div class="mod-block">
		<div class="cont-width clearfix">
			<div class="content-title col-xs-12">
				<h3>${refereeArticle.title }</h3>
				<p>发布时间： <fmt:formatDate value="${ refereeArticle.addTime }" pattern="yyyy-MM-dd"/> <%--  浏览次数： ${ refereeArticle.rate }次 --%></p>
			</div>
			<div class="content-main col-xs-12">${ refereeArticle.actContent }</div>
			<div class="content-nav col-xs-12">
				<c:if test="${listArticlePrevious!=null}">
					<p>
						<a href="${yesPath}/actnews/${listArticlePrevious.id}">上一篇： ${ listArticlePrevious.title }</a>
					</p>
				</c:if>
				<c:if test="${listArticleNext!=null}">
					<p class="">
						<a href="${yesPath}/actnews/${listArticleNext.id}">下一篇： ${ listArticleNext.title }</a>
					</p>
				</c:if>
			</div>
		</div>
	</div>
	<%@ include file="enterprise/include/footer.jsp"%>
</body>
</html>