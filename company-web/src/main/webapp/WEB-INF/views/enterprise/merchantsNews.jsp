<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
    <title>云尚商务动态,云尚 会议动态,云尚招商会,云尚说明会 - 云尚招商网</title>
    <meta name="keywords" content="云尚商务动态,云尚 会议动态,云尚招商会,云尚说明会,云尚招商网" />
    <meta name="description" content="云尚招商网是云尚中国健康管理集团旗下云尚的招商加盟平台，对移动互联网健康产业投资、创业、找项目的人士提供招商会议与及投资服务。云尚打造了一个集健康管理服务、同业联盟O2O、移动支付和积分通兑为一体的综合性健康管理与增值服务平台。云尚服务热线：xxxxxxxx 。">
	<%@ include file="include/inc_css.jsp"%>
</head>
<body mid="m-mNews">
    <%@ include file="include/header.jsp"%>
    <div class="mod-banner" style="background-image: url(${staticPath}/static/enterprise/assets/images/banner-m.jpg)"></div>
    <c:if test="${!empty businesses}">
    <div class="mod-block faq-warp">
        <div class="cont-width clearfix">
            <div class="home-title">
                <h2>会议动态</h2>
                <span>Merchants dynamically</span>
            </div>
            <ul class="merchants-list list">
            	<c:forEach items="${businesses}" var="business" varStatus="obj">
                <li>
                    <div class="mer-pic animated fadeIn wow">
                        <img src="${business.img}" />
                    </div>
                    <div class="mer-main animated fadeInUpBig wow">
                        <div class="mer-title">
                            <div class="name"><div class="title"> ${business.title} </div> <fmt:formatDate value="${business.addTime}" pattern="yyyy-MM-dd"/></div>
                        </div>
                        <div class="mer-digest">
              				${business.artDesc}
                        </div>
                        <div class="mer-cont">
                        </div>
                    </div>
                </li>
                </c:forEach>
            </ul>
        </div>
    </div>
    </c:if>
    <%@ include file="include/footer.jsp"%>
</body>
</html>