<%@ page contentType="text/html;charset=UTF-8" %>
<link href="${staticPath}/static/platform/assets/bootstrap/css/bootstrap.min.css?v=1" rel="stylesheet" type="text/css">
<link href="${staticPath}/static/platform/assets/nav/responsive-nav.css?v=1" rel="stylesheet" type="text/css">
<link href="${staticPath}/static/platform/assets/nav/styles.css?v=20160101" rel="stylesheet" type="text/css">
<link href="${staticPath}/static/platform/assets/css/animation.css" rel="stylesheet" type="text/css">
<link href="${staticPath}/static/platform/assets/css/style.css" rel="stylesheet" type="text/css">
<link rel="shortcut icon" href="${staticPath}/static/favicon.ico"/>
<!--[if lt IE 9]>
  <link href="${staticPath}/static/platform/assets/css/ie.css?v=1" rel="stylesheet" type="text/css">
<![endif]-->

<style>
@media screen and (max-width: 640px) {
	body{min-width:320px;}
    .small-hidden{display:none;}
    .nav-collapse li.small-hidden{display:none;}
    .footer a{float:initial;margin:0 4px;}
    .home-items{overflow:hidden;}
    .home-news-list{padding-left:0;}
    .home-news-item{margin:auto; margin-bottom:16px;}
    .cont-width.industrytrends_width{width:auto;}
    .mod-block{padding:30px 0;}
    .industrytrends .industrytrends_list ul li{float:none;width:auto;margin-bottom:20px;height:auto; }
	.industrytrends .industrytrends_list ul li .industrytrends_list_img{width:30%;height:100px;}
	.industrytrends .industrytrends_list ul li .industrytrends_list_mes{width:70%; box-sizing: border-box;margin: 0; padding: 0 10px;}
    .home-video_div{padding-bottom:30px;}
    .ck-slide {width:320px; height: 190px;}
    .ck-slide ul.ck-slide-wrapper li{ width:320px;height:190px;}
    .ck-slide ul.ck-slide-wrapper li a{width:320px;height:190px; background-size: 320px 160px;}
    .top{background:none;}
    .top .main{width:100%;height:150px;background-size:100% 150px;}
    .centerContainer{width:100%;}
    .centerContainer .titleWrap .title span{font-size:22px;width:248px;left:0;}
    .centerContainer .titleWrap .title:before{width:218px;}
    .centerContainer .titleWrap .title:after{width:198px;}
    .company-news_list ul li{margin-bottom:20px;}
    .company-news_list ul li .company-news_list_mes{width:100%;}
    .company-news_list ul li:nth-child(odd) .company-news_list_mes .list_article{margin:0;width:100%; padding:15px;max-height:166px;}
    .company-news_list ul li:nth-child(odd) .company-news_list_mes .dynamic{display:none;}
    .company-news_list ul li:nth-child(even) .company-news_list_mes .dynamic{display:none;}
    .company-news_list ul li:nth-child(odd) .company-news_list_mes .goto{margin-left:10px;}
    .company-news_list ul li:nth-child(even) .company-news_list_mes .number{left:27px;}
    .company-news_list ul li:nth-child(even) .company-news_list_mes .tit{margin-left:0;text-indent:110px;}
    .company-news_list ul li:nth-child(even) .company-news_list_mes .time{margin-left:0;text-indent:112px;}
    .company-news_list ul li:nth-child(even) .company-news_list_mes .list_article{margin:0;width:100%;padding:15px;max-height:166px;}
	.born .tab_btn{margin:20px 0;width:100%;}
	.born .tab_btn ul{width:100%;}
	.born .tab_btn ul li{margin:auto;float:none;}
	.money .img_fenbu{background-size:100%; margin:0;height:230px;}
	.newsContainer .allNews{float:none;margin:0;width:100%;}
	.allNews ul{height:156px;}
	.income{margin:15px;}
	.support{margin:15px;}
	.lixian .lixian_img{width:100%;}
	.support .support_img{ margin:15px;}
	.support .content{width:100%;}
	.join .info .basic{margin:20px 0 0 30px;}
	a#join_submit{margin:15px 20%;}
	.join .message{ margin: 20px 0 0 30px;}
	.join .message textarea{width:80%;}

}
@media screen and (min-width: 640px)  {
	.large-hidden{display:none;}
	.video-wrap-width{ width: 1200px !important;height: 673px; cursor: pointer;}
    .nav-collapse li.large-hidden{display:none;}
    
}
</style>