<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
    <title>云尚帮助中心,云尚常见问题,云尚商城帮助中心,如何入驻云尚商户,如何入驻云尚供应商- 云尚</title>
    <meta name="keywords" content="云尚帮助中心,云尚常见问题,云尚商城帮助中心,如何入驻云尚商户,如何入驻云尚供应商,云尚" />
    <meta name="description" content="云尚大健康是吉林云尚保健食品有限公司旗下的移动互联网健康管理平台，云尚健康管理综合服务平台主要为用户提供健康管理、健康智能设备、健康专家实时咨询、健康生活资讯、健康自测、健康商城、健康周边服务、健康圈等健康生活服务。云尚打造了一个集健康管理服务、同业联盟O2O、移动支付和积分通兑为一体的综合性健康管理与增值服务平台。云尚服务热线：400-888-2933 。">
	<%@ include file="include/inc_css.jsp"%>
	<%@ include file="/WEB-INF/views/platform/include/inc_css.jsp"%>
</head>
<body mid="m-faq">
    <%-- <%@ include file="include/header.jsp"%> --%>
    <%@ include file="/WEB-INF/views/platform/include/header.jsp"%>
    <div class="mod-banner" style="background-image: url(${staticPath}/static/enterprise/assets/images/banner-faq.jpg)"></div>
    <div class="mod-block faq-warp">
        <div class="cont-width clearfix">
            <div class="home-title">
                <h2>常见问题</h2>
                <span>Frequently Asked Questions</span>
            </div>
            <ul class="faq-list">
            	<c:forEach var="obj" items="${objs}" varStatus="status">
	            	<li class="animated fadeIn wow">
	                    <h4 class="title"><span class="ico-q">Q</span>${obj.title}</h4>
	                    <div class="cont"><span class="ico-a">A</span>
	                    	${obj.content}
	                    </div>
	                </li>
            	</c:forEach>
            </ul>
        </div>
    </div>
 	<div class="text-center">
        <nav class="text-center">
		 <ul class="pagination">
       		  ${gotoPageHTML}
   		 </ul> 
		</nav>
    </div>
    <%@ include file="include/footer.jsp"%>
</body>
</html>