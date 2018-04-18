<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
    <title>云尚客户案例,云尚 运营商案例,云尚招商案例 - 云尚招商网</title>
    <meta name="keywords" content="云尚客户案例,云尚 运营商案例,云尚招商案例,云尚招商网" />
    <meta name="description" content="云尚招商网是云尚中国健康管理集团旗下云尚的招商加盟平台，云尚平台来自全国各地的运营商已加入平台，包括市运营商、区运营商、区域运营商等成功案例。云尚打造了一个集健康管理服务、同业联盟O2O、移动支付和积分通兑为一体的综合性健康管理与增值服务平台。云尚服务热线：xxxxxxxx 。">
    <%@ include file="include/inc_css.jsp"%>
</head>
<body mid="m-case">
    <%@ include file="include/header.jsp"%>
    <div class="mod-banner" style="background-image: url(${staticPath}/static/enterprise/assets/images/banner-case.jpg)"></div>
    <div class="case-warp">
    	<c:forEach items="${custormers}" var="custormer" varStatus="obj">
			<c:if test="${obj.count%2 == '0'}">
			<div class="mod-block case-big-list">
			</c:if>
			<c:if test="${obj.count%2 != '0'}">
			<div class="mod-block mod-block-blue case-big-list">
			</c:if>
            <div class="cont-width clearfix">
                <div class="col-md-4 text-center">
                    <img src="${custormer.img}" class="animated fadeIn wow" />
                </div>
                <div class="col-md-8 animated fadeInRight wow">
                    <h3 class="title" style="margin-top: 100px;">${custormer.title}</h3>
                </div>
            </div>
        </div>
		</c:forEach>
		<c:if test="${!empty custormers}">
<!-- 		<div class="text-center" style="padding: 50px 0;"><a href="/news/more?mark=ZS_CUSTOMER" class="view-more view-more-gray">查看更多 &gt;&gt;</a></div>
 -->		</c:if>
    </div>

    <%@ include file="include/footer.jsp"%>

</body>
</html>