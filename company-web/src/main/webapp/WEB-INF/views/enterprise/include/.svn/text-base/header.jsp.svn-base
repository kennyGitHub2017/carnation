<%@page import="com.sinco.dal.utils.SpringContextHolder"%>
<%@page import="com.sinco.carnation.sys.service.SysConfigService"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="vc.thinker.b2b2c.core.security.support.SecurityUserHolder" %>
<%@ page import="vc.thinker.b2b2c.core.security.support.SecurityUserHolder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!--[if lt IE 9]>
  <script src="http://apps.bdimg.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
  <script src="http://apps.bdimg.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<%
request.setAttribute("userDetails", SecurityUserHolder.getCurrentUserDetails());
SysConfigService configService=SpringContextHolder.getBean(SysConfigService.class);
request.setAttribute("config", configService.getSysConfig());
%>
<script type="text/javascript">
	$(function (){
		var login=$("#a_login");
		var loginHref=login.attr("href");
		loginHref=loginHref+"="+window.location.href;
		login.attr("href",loginHref);
	});
</script>
	<div class="topNav">
        <div class="cont-width">
            <div class="col-md-6 hidden-xs">
                <a href="javascript:void(0);">云尚招商平台</a></div>
            <div class="text-right pr-15">
            <c:choose>
            	<c:when test="${!empty userDetails}">
            		<span>${fn:substring(userDetails.customer.nickname,0,12) }您好,欢迎来到${fn:substring(config.websiteName,0,30) }！ [<a href="${config.address}/b2b2c_logout.htm">退出商城</a>]</span> | 
            	</c:when>
            	<c:otherwise>
	           		<a href="${config.address}/user/login.htm?url" id="a_login"> 登录 </a> |
	                <a href="${config.address}/register.htm"> 注册 </a> |
            	</c:otherwise>
            </c:choose>
                <a href="javascript:void(0)" class="weixin-tips"> 微信 <div><img src="${staticPath}/static/enterprise/assets/images/wx-code.png"></div></a> |
                <a target="_blank" href="http://www.weibo.com/jgyys/"> 微博 </a>
            </div>
        </div>
    </div>

<div class="header cont-width">
    <h1 class="logo"><a href="javascript:void(0);"><img src="${staticPath}/static/enterprise/assets/images/logo.png" /> </a> </h1>
    <div class="head-cont">
        <div class="h-tel hidden-xs">
            招商热线：<span>400-888-2933</span>
        </div>
    </div>

</div>

<div class="menu-wrap">
    <div class="cont-width clearfix">
        <nav class="nav-collapse">
            <ul class="menu">
                <li><a href="${zsPath}/index" id="m-index">首页</a></li>
                <li><a href="${yesPath}/p/index" target="_blank">了解云尚</a></li>
                <li><a href="${zsPath}/operator" id="m-operator">运营商专栏</a></li>
                <li><a href="${zsPath}/news" id="m-news">招商资讯 </a></li>
                <li><a href="${zsPath}/merchantsNews" id="m-mNews">商务动态 </a></li>
                <li><a href="${zsPath}/case" id="m-case">客户案例</a></li>
                <li><a href="${zsPath}/join" id="m-join">申请加盟</a></li>
                <li><a href="${zsPath}/faq" id="m-faq">常见问题 </a></li>
                <li><a href="${zsPath}/contact" id="m-contact">联系我们 </a></li>
                <li><a href="${zsPath}/app" id="m-app">APP下载</a></li>
            </ul>
        </nav>
    </div>
</div>

<div class="pop-wrap hidden-xs">
    <a href="javascript:void(0)">
        <span class="pop-code"></span>
        <i class="ico-code"></i>
        招商微信
        <div class="code-tips"><img src="${staticPath}/static/enterprise/assets/images/wx-zs.jpg"/></div>
    </a>
    <a href="javascript:void(0)">
        <span class="pop-code"></span>
        <i class="ico-code"></i>
        App下载
        <div class="code-tips"><img src="${staticPath}/static/enterprise/assets/images/ys-down-qrcode.png"/></div>
    </a>
    <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=3273124108&site=qq&menu=yes">
        <i class="ico-qq"></i>
        QQ咨询
    </a>
</div>