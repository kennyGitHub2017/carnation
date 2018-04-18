<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>云尚集团</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <meta name="format-detection" content="email=no">
    <meta name="keywords" content="云尚集团旗下有云尚中国、云尚、云尚会、云尚研究院,云尚俱乐部。">
    <meta name="description" content="云尚集团旗下有云尚中国、云尚、云尚会、云尚研究院,云尚俱乐部。">
    <link rel="shortcut icon" href="http://www.jgksl.com/favicon.ico" type="image/x-icon" /> 
    <link rel="stylesheet" href="${staticPath}/static/jgGroup/css/base.min.css" type="text/css">
    <link rel="stylesheet" href="${staticPath}/static/jgGroup/css/main.css" type="text/css">
</head>
<body>
    <div class="mtop">
            <img src="${staticPath}/static/jgGroup/images/logo.png" class="logo">
            <span class="domain">WWW.JG16.CN</span>
    </div>
    <section class="section">
        <a  href="http://m.jgksl.com" target="_blank">
            <img src="${staticPath}/static/jgGroup/images/mp1.jpg">
            <p class="tit ch">云尚中国</p>
            <p class="tit en">JG·CHINA</p>
            <img src="${staticPath}/static/jgGroup/images/mline.png" class="mline">
            <p class="des">云尚中国建立以抗衰老为核心的健康管理中心，与国内外多家科研院所、著名实验室建立了战略合作关系</p>
        </a>
    </section>
    <section class="section">
        <a  href="http://www.ysysgo.com" target="_blank">
            <img src="${staticPath}/static/jgGroup/images/mp2.jpg">
            <p class="tit ch">云尚</p>
            <p class="tit en">JG·YUNESHENG</p>
            <img src="${staticPath}/static/jgGroup/images/mline.png" class="mline">
            <p class="des">云尚平台是集健康管理服务、异业联盟O2O、移动支付和积分通兑为一体的综合性健康管理与增值服务平台</p>
        </a>
    </section>
    <section class="section">
        <a  href="http://www.jgvip.cn" target="_blank">
            <img src="${staticPath}/static/jgGroup/images/mp3.jpg">
            <p class="tit ch">云尚会</p>
            <p class="tit en">JG·MEMBERSHIP</p>
            <img src="${staticPath}/static/jgGroup/images/mline.png" class="mline">
            <p class="des">云尚中国建立以抗衰老为核心的健康管理中心，与国内外多家科研院所、著名实验室建立了战略合作关系</p>
        </a>
    </section>
    <section class="section">
        <a  href="http://www.jgksl.com" target="_blank">
            <img src="${staticPath}/static/jgGroup/images/mp4.jpg">
            <p class="tit ch">云尚研究院</p>
            <p class="tit en">JG·INSTITUTE</p>
            <img src="${staticPath}/static/jgGroup/images/mline.png" class="mline">
            <p class="des">为了掌握、超越国外抗衰老研究的最新进展与动向，云尚和国内外院校可养机构成立了研究院</p>
        </a>
    </section>
    <section class="section">
        <a  href="http://www.jgclub.cn" target="_blank">
            <img src="${staticPath}/static/jgGroup/images/mp5.jpg">
            <p class="tit ch">俱乐部</p>
            <p class="tit en">JG·CLUB</p>
            <img src="${staticPath}/static/jgGroup/images/mline.png" class="mline">
            <p class="des">云尚中国为经销商伙伴提供的交流平台，旨在增加云尚和经销商之间的良性互动，是经销商交流和表彰平台</p>
        </a>
    </section>
    <div class="bottom">COPYRIGHT 2016 云尚集团版权所有</div>
    <script type="text/javascript">
        var section=Array.prototype.slice.call(document.getElementsByTagName("section"));
        section.forEach(function(s,i){
            s.addEventListener("touchstart",function(){
                this.style.background="#fff";
                this.style.border="solid 1px #00baff";
            },false);
        })
        section.forEach(function(s,i){
            s.addEventListener("touchend",function(){
                this.style.background="#e7e7e7";
                this.style.border="solid 1px #fff";
            },false);
        })
    </script>
</body>
</html>