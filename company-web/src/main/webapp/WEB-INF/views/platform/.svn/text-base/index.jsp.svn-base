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
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="baidu-site-verification" content="jiubXvllXm" />
    
    <link href="${staticPath}/static/platform/assets/css/flexslider.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="http://g.alicdn.com/de/prismplayer/1.7.6/skins/default/index-min.css" />
  	<%--   <link href="${staticPath}/static/platform/assets/video/video-js.min.css" rel="stylesheet" type="text/css --%>
    <%@ include file="include/inc_css.jsp"%>
</head>
<body mid="m-index">
	
	<%@ include file="include/header.jsp"%>
	<div class="flexslider">
        <ul class="slides home-banner">
<%--         	<li class="bright" style="background-image: url(${staticPath}/static/platform/assets/images/banner05.jpg?v=1)"> --%>
<!--             </li> -->
<%--             <li id="app-code-banner" class="bleft" style="background-image: url(${staticPath}/static/platform/assets/images/banner.jpg)"> --%>
<!--             <a class="btn btn-success visible-xs mob-down" href="http://static.ysysgo.com/static/platform/appDownload.jsp" target="_blank"> <i class="glyphicon glyphicon-save"></i> 立即下载 </a> -->
<!--             </li> -->
			<c:forEach items="${indexSlide }" var="slide">
	            <li class="bleft" style="background-image: url(${slide.adImgPath})">
    	        </li>
			</c:forEach>
<%--             <li class="bleft" style="background-image: url(${staticPath}/static/platform/assets/images/banner03.jpg)"> --%>
<!--             </li> -->
<%--             <li style="background-image: url(${staticPath}/static/platform/assets/images/banner04.jpg)"> --%>
<!--             </li> -->
            
        </ul>
    </div>

    <div class="home-items clearfix">
        <div class="col-md-3 col-xs-6 animated fadeInUp wow">
            <a href="javascript:void(0)">
                <div class="home-item"><span class="pic-01"></span></div>
          健康检测
            </a>
        </div>
        <div class="col-md-3 col-xs-6 animated fadeInUp wow delay-1">
            <a href="javascript:void(0)">
                <div class="home-item"><span class="pic-02"></span></div>
            健康调理
            </a>
        </div>
        <div class="col-md-3 col-xs-6 animated fadeInUp wow delay-2">
            <a href="javascript:void(0)">
                <div class="home-item"><span class="pic-03"></span></div>
          线上线下
            </a>
        </div>
        <div class="col-md-3 col-xs-6 animated fadeInUp wow delay-3">
            <a href="javascript:void(0)">
                <div class="home-item"><span class="pic-04"></span></div>
            合作共赢
            </a>
        </div>
    </div>

    <div class="home-news mod-block clearfix">
        <div class="cont-width">
            <div class="home-title c-fff">
                <h2>公司动态</h2>
                <span>看看我们公司都发生了些什么</span>
            </div>
            <div class="home-news-list row">
            
                
                <c:set var="i" scope="page" value="${0}"/>
                <c:forEach items="${companyDynamic}" var="obj">
					<!-- 这里设置不同的样式 -->
                   <c:if test="${i == 0}">
				       <div class="col-md-3 home-news-item animated fadeInUp wow delay-2">
				    </c:if>
				    <c:if test="${i == 1}">
				       <div class="col-md-3 home-news-item animated fadeInUp wow">
				    </c:if>
				    <c:if test="${i == 2}">
				       <div class="col-md-3 home-news-item animated fadeInUp wow">
				    </c:if>
				     <c:if test="${i == 3}">
				       <div class="col-md-3 home-news-item animated fadeInUp wow delay-2">
        			</c:if>	
	                    <a href="${obj.adUrl}">
	                        <img src="${obj.adImgPath}" />
	                        <div class="title">${obj.adTitle}</div>
	                    </a>
	                	</div>
                	<c:set var="i" scope="page" value="${i+1}"/>
				</c:forEach> 
            </div>
            <div class="text-center">
                <a href="/p/news" class="view-more">查看更多 &gt;&gt;</a>
            </div>
        </div>
    </div>

    <div class="industrytrends mod-block">
        <div class="cont-width industrytrends_width">
            <div class="home-title gray">
                <div class="tit">行业动态</div>
                <span>行业资讯，动态，热点，你想要的都在这里</span>
            </div>
            <div class="industrytrends_list">
                <ul>
                <c:forEach items="${hyEvent}" var="obj">
               		<li>
	                    <a href="/news/${obj.id}">
	                    	<div class="absolute_imgcolor small-hidden"></div>
	                        <img class="industrytrends_list_img"  src="${obj.img}" />
	                        <div class="industrytrends_list_mes">
	                        <span class="list_mes_tit">${obj.title}</span>
	                        <span class="time"><fmt:formatDate value="${obj.addTime}" pattern="yyyy-MM-dd"/></span>
                            <span class="list_mes_tit_mes">${obj.artDesc}…[详细>>]</span>
	                    	</div>
	                    </a>
                    </li>
                </c:forEach>
                </ul>
            </div>
        </div>
    </div>
	
	<div class="home-video_div">
		<div class="ck-slide">
			<ul class="ck-slide-wrapper">
				<li>
					<a class="ck-slide-wrapper_a"  href="javascript:;" ><div class="cont-width video-wrap-width" id="video-box" ><div class="prism-player" id="J_prismPlayer1" style="position: absolute"></div></div></a>
				</li>
				<li style="display:none">
					<a class="ck-slide-wrapper_b" href="javascript:;"  ><div class="cont-width video-wrap-width" id="video-box2" ><div class="prism-player" id="J_prismPlayer2" style="position: absolute"></div></div></a>
				</li>
				<li style="display:none" >
					<a class="ck-slide-wrapper_c" href="javascript:;"  ><div class="cont-width video-wrap-width" id="video-box3" ><div class="prism-player" id="J_prismPlayer3" style="position: absolute"></div></div></a>
				</li>
			</ul>
			<a href="javascript:;" class="ctrl-slide ck-prev">上一张</a> <a href="javascript:;" class="ctrl-slide ck-next">下一张</a>
			<div class="ck-slidebox">
				<div class="slideWrap">
					<ul class="dot-wrap">
						<li class="current"><em>1</em></li>
						<li><em>2</em></li>
						<li><em>3</em></li>
					</ul>
				</div>
			</div>
		</div>
		
		

		
	</div>
	</div>
	
    <div class="home-video" style="display: none;">
    	<div class="cont-width" id="video-box" style="width:1200px;height:407px;cursor: pointer">
	    	
    	</div>   
    </div>

    <div class="mod-block" style="display: none;">
        <div class="cont-width clearfix">
            <div class="home-title gray-title">
                <h2>合作机构</h2>
                <span>众多机构与我们合作你还在等什么</span>
            </div>
            <div class="home-friend">
                <div class="friend-list">
                    <a href="javascript:void(0)"><img src="${staticPath}/static/platform/assets/images/pic/f-logo1.png" alt="瑞士健康中心" /></a>
                    <a href="javascript:void(0)"><img src="${staticPath}/static/platform/assets/images/pic/f-logo2.png" alt="北京中医药大学" /></a>
                    <a href="javascript:void(0)"><img src="${staticPath}/static/platform/assets/images/pic/f-logo3.png" alt="香港城市大学高通基因诊断有限公司" /></a>
                    <a href="javascript:void(0)"><img src="${staticPath}/static/platform/assets/images/pic/f-logo4.png" alt="日本大坪会" /></a>
                    <a href="javascript:void(0)"><img src="${staticPath}/static/platform/assets/images/pic/f-logo5.png" alt="广东正源分子生物有限公司" /></a>
                    <a href="javascript:void(0)" class="spill"><img src="${staticPath}/static/platform/assets/images/pic/f-logo6.png" alt="华大基因" /></a>
                    <a href="javascript:void(0)"><img src="${staticPath}/static/platform/assets/images/pic/f-logo7.png" alt="日本共生医学研究所" /></a>
                    <a href="javascript:void(0)"><img src="${staticPath}/static/platform/assets/images/pic/f-logo8.png" alt="中国老年学学会衰老与抗衰老科学委员会" /></a>
                    <a href="javascript:void(0)"><img src="${staticPath}/static/platform/assets/images/pic/f-logo9.png" alt="中国医师协会抗衰老专业委员会" /></a>
                    <a href="javascript:void(0)"><img src="${staticPath}/static/platform/assets/images/pic/f-logo10.png" alt="美国云尚USANA抗衰老疗养中心" /></a>
                    <a href="javascript:void(0)"><img src="${staticPath}/static/platform/assets/images/pic/f-logo11.png" alt="千博集团" /></a>
                    <a href="javascript:void(0)"><img src="${staticPath}/static/platform/assets/images/pic/f-logo12.png" alt="韩国天主教关东大学国际圣母医院" /></a>
                    <a href="javascript:void(0)"><img src="${staticPath}/static/platform/assets/images/pic/f-logo13.png" alt="SNE" /></a>
                </div>
            </div>

        </div>
    </div>
    
    <div class="mod-block" style="display:none">
        <div class="cont-width clearfix">
            <div class="home-title gray-title">
                <h2>友情链接</h2>
                <div style="text-align: left;"><a href="http://www.kuaidi.com/" target="_blank">快递查询</a></div>
            </div>          
        </div>
    </div>

	<%@ include file="include/footer.jsp"%>
	<%-- <script type="text/javascript" src="${staticPath}/static/platform/assets/video/video.min.js"></script> --%>
	<!-- js -->
	<script src="${staticPath}/static/platform/assets/js/jquery-1.8.3.min.js"></script>
	<script src="${staticPath}/static/platform/assets/js/slide.js?v=0706"></script>
	
	<script>
		$('.ck-slide').ckSlide({
			dir: 'x'
		});
	</script>
	
	<script src="${staticPath}/static/platform/assets/js/flexslider.js"></script>
    <script type="text/javascript">
	    if(navigator.userAgent.indexOf('MSIE')>=0){
	    	document.write("<script type='text/javascript' src='//g.alicdn.com/de/prismplayer/1.7.2/prism-min.js'><\/script>");
	    }else{
	    	document.write("<script type='text/javascript' src='http://g.alicdn.com/de/prismplayer/1.7.6/prism-h5-min.js'><\/script>");
	    } 
 
    </script>
    
    <script>
		$(".ck-slide-wrapper li").click(function(){
			var index=$(".ck-slide-wrapper li").index(this);
			var _player="player"+(index+1);
			$(".prism-player").eq(index).show();
			eval(_player).play();
		});
    </script>
    <script>
    	$(".flexslider").flexslider();
    	var video_w = $(".ck-slide").width();
    	var video_h = $(".ck-slide").height();
    	
        var player = new prismplayer({
            id: 'J_prismPlayer1',
            width: video_w+'px',
            height:video_h+'px',
            autoplay: false,

            prismType:2, //固定参数
            vid : '19eb98ac22aa4ba0803b1c1159e34c2b',
            accId : 'LTAIoQZ87yXpsP1K',
            accSecret : 'KT9kzfwnuKAdWrJUIsi8XiBRp78Kqv',
            apiKey : 'csqkj4fso9ajzgbyhxhnfavlnkh53w6zxm4quzllvresj7hos23ovlvxypz72scu',
            flashApiKey : 'wsc7rtybkwuyzce2okwbafit7jxvenklrj2nnd9udxyev6undeg6d8yquuzuqf6z',
            
            showBarTime: 3000
        });
        var player1=player;
        var player = new prismplayer({
            id: 'J_prismPlayer2',
            width: video_w+'px',
            height:video_h+'px',
            autoplay: false,

            prismType:2, //固定参数
            vid : '0d6b89d545e3487285ee71ef02dfaa0c',
            accId : 'LTAIoQZ87yXpsP1K',
            accSecret : 'KT9kzfwnuKAdWrJUIsi8XiBRp78Kqv',
            apiKey : 'csqkj4fso9ajzgbyhxhnfavlnkh53w6zxm4quzllvresj7hos23ovlvxypz72scu',
            flashApiKey : 'wsc7rtybkwuyzce2okwbafit7jxvenklrj2nnd9udxyev6undeg6d8yquuzuqf6z',
            
            showBarTime: 3000
        });
        var player2=player;
        var player = new prismplayer({
            id: 'J_prismPlayer3',
            width: video_w+'px',
            height:video_h+'px',
            autoplay: false,

            prismType:2, //固定参数
            vid : '62919a8803284a83a95e6f4f3aac00f9',
            accId : 'LTAIoQZ87yXpsP1K',
            accSecret : 'KT9kzfwnuKAdWrJUIsi8XiBRp78Kqv',
            apiKey : 'csqkj4fso9ajzgbyhxhnfavlnkh53w6zxm4quzllvresj7hos23ovlvxypz72scu',
            flashApiKey : 'wsc7rtybkwuyzce2okwbafit7jxvenklrj2nnd9udxyev6undeg6d8yquuzuqf6z',
            
            showBarTime: 3000
        });
        var player3=player;
    
    </script>   
</body>
</html>