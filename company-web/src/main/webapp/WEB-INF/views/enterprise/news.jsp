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
    <%@ include file="include/inc_css.jsp"%>
</head>
<body>
    <%@ include file="/WEB-INF/views/platform/include/header.jsp"%>
    <div class="mod-banner" style="background-image: url(${staticPath}/static/enterprise/assets/images/banner-news.jpg)"></div>
	<!-- 招商资讯 -->
	<div id="div_events">
	${events}
	</div>
	<!-- 行业资讯 -->
	<div id="div_hyevents">
	${hyevents}
	</div>
    <%@ include file="include/footer.jsp"%>
</body>
</html>
<script>
	function ajaxPage(url, i, obj){
  		$.ajax({  
	         type:'get',      
	         url:url+i,  
	         cache:false,  
	         success:function(data){
	         	if('' != data){
	         		$('#event_news').remove();
	         		$('#div_events').html(data);
	         	}
	         }  
	     }); 		
	}

	function gotoHYEventsFunc(id){
  		$.ajax({  
	         type:'get',      
	         url:'/e/news/hyevent?id='+id,  
	         cache:false,  
	         success:function(data){
	         	if('' != data){
	         		$('#hyevent_news').remove();
	         		$('#div_hyevents').html(data);
	         	}
	         }  
	     }); 		
	}	
</script>