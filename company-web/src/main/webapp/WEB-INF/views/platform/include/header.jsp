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
<!--[if lt IE 9]>
  <script src="http://apps.bdimg.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
  <script src="http://apps.bdimg.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<script type="text/javascript">
	$(function (){
		var thisMid = $("body").attr("mid");
		 $("#menu").find("a").each(function(i,n){
		     var obj = $(n)
		     if(thisMid==obj.attr('id')){
		    	 obj.css("color","grey");
		     }
		  });
		var login=$("#a_login");
		var loginHref=login.attr("href");
		loginHref=loginHref+"="+window.location.href;
		login.attr("href",loginHref);
		
		$("#appdownload_li").hover(function() {
			$(".download_dropdown").show();
        }, function() {
        	$(".download_dropdown").hide()
        });
		$(".download_dropdown").hover(function() {
			$(".download_dropdown").show();
        }, function() {
        	$(".download_dropdown").hide()
        });
		
	});
	
</script>
<div class="topnew small-hidden" id="top" style="">
	<div class="main">
		<div class="right">
			<ul>

				<li><a href="http://shop.ysysgo.com/user/login.htm">登录</a> <b>|</b>
				</li>

				<li><a href="http://shop.ysysgo.com/register.htm" class="red">免费注册</a>
					<b>|</b></li>
				<li><a href="http://shop.ysysgo.com/buyer/order.htm">我的订单</a> <b>|</b>
				</li>
				<li><a href="http://shop.ysysgo.com/buyer/index.htm">用户中心</a> <b>|</b>
					<s></s>
					<ul>
						<li><a href="http://shop.ysysgo.com/buyer/foot_point.htm">最近浏览</a></li>
						<li><a href="http://shop.ysysgo.com/buyer/favorite_goods.htm">我的收藏</a></li>
						<li><a href="http://shop.ysysgo.com/goods_cart1.htm">我的购物车</a></li>
						<li><a href="http://shop.ysysgo.com/buyer/predeposit.htm">我的云币</a></li>
						<li><a href="http://shop.ysysgo.com/buyer/coupon.htm">我的优惠券</a></li>
					</ul></li>

				<li><a href="http://shop.ysysgo.com/buyer/index.htm">登录后台</a> <b>|</b>
					<s></s>
					<ul>
						<li><a href="http://yys.ysysgo.com/login.htm">运营商登录</a></li>
						<li><a href="http://shop.ysysgo.com/user/supplierLogin.htm">供应商登录</a></li>
						<li><a href="http://shop.ysysgo.com/user/merchantLogin.htm">商户登录</a></li>
					</ul></li>
				<li>
					<a href="http://shop.ysysgo.com/seller/ruzhu_pingtai.htm">我要入驻</a>
					<b>|</b>
				</li>
				<li><a href="http://shop.ysysgo.com/doc_online.htm">客户服务</a> <b>|</b>
					<s></s>
					<ul>
						<li><a href="http://shop.ysysgo.com/article_9.htm">联系客服</a></li>
						<li><a href="http://shop.ysysgo.com/article_4.htm">常见问题</a></li>
					</ul></li>
			</ul>
		</div>
		<div class="left">
			<a href="${yesPath}" class="">云尚首页</a>
			<a href="http://shop.ysysgo.com" class="index">云尚商城</a> 
			<a href="http://www.yunshangworld.com" target="_blank" class="index">云尚官网</a>
		</div>
	</div>
</div>

<div class="header">	
	<div class="cont-width">
	    <h1 class="logo"><a href="/"><img src="${staticPath}/static/platform/assets/images/logo.png" /> </a> </h1>
	    <div class="head-cont">
	        <div class="h-tel hidden-xs">
                服务热线：<span>400-888-2933</span>
	        </div>
	        <div class="nav-collapse">
	            <ul class="menu" id="menu">
	                <li><a href="${yesPath}" id="m-index">首页</a></li>
	                <li class="small-hidden"><a href="http://shop.ysysgo.com/" id="m-shop" target="_blank">健康商城</a></li>
	                <li class="large-hidden"><a href="http://mobile.ysysgo.com/" id="m-shop2" target="_blank">健康商城</a></li>
	                <li><a href="http://shop.ysysgo.com/group/index.htm" id="m-o2o" target="_blank">周边商户</a></li>
	                <li><a href="http://shop.ysysgo.com/integral/index.htm" id="" target="_blank">积分商城</a></li>
	                <li><a href="${yesPath}/investmentact" id="m-investmentact">加盟云尚</a></li>
	                <li><a href="${yesPath}/p/news" id="m-news">公司动态</a></li>
	                <li><a href="${yesPath}/p/industrytrends" id="m-industrytrends">行业动态</a></li>
	                <li class="large-hidden"><a href="http://www.yunshangworld.com" >云尚官网</a></li>
	                <li><a href="${yesPath}/p/about" id="m-about">关于云尚 </a></li>
	                <li id="appdownload_li">
	                	<a  href="${yesPath}/p/appDownLoad">APP下载</a>
	                </li>
	                
	            </ul>
	        </div>
	    </div>
	</div>
</div>
<div class="app_download_div">
	<div class="download_dropdown curr">
		<%-- 
		<img src="${staticPath}/static/platform/assets/images/arraw_top.png" style="position:absolute;left:95px;top:-11px" />
		 --%>
		<ul>
			<li><a href="${yesPath}/p/appDownLoad">云尚App下载</a></li>
			<li><a href="${yesPath}/p/shdappDownLoad">商户App下载</a></li>
			<li><a href="${yesPath}/p/yysappDownLoad">运营商App下载</a></li>
		</ul>
	</div>
</div>