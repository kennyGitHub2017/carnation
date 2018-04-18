<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />

    <title>联系我们,联系云尚,云尚联系方式,云尚服务热线,云尚电话,云尚地址 - 云尚</title>
    <meta name="keywords" content="联系云尚,云尚联系方式,云尚服务热线,400-888-2933,云尚电话,云尚地址,云尚" />
    <meta name="description" content="致力提供出色的客户服务，如产品问题，合作问题，入驻问题，平台操作问题或有好的建议和意见都可以联系客服得到解决的方案。云尚服务热线：400-888-2933 。">
	<%@ include file="include/inc_css.jsp"%>
</head>
<body mid="m-contact">
    <%@ include file="include/header.jsp"%>

    <div class="mod-banner" style="background-image: url(${staticPath}/static/enterprise/assets/images/banner-contact.png)"></div>

<div class="gray-bg">
    <div class="contact-content cont-width">
 		<div class="home-title gray-title  fadeInUp wow my" style="visibility: visible; animation-name: fadeInUp;">
            <h2>联系我们</h2>
            <span>Contact Us</span>
        </div>
        <div id="dituContent"></div>

        <div class="cont">
            <h4>云尚大健康综合服务平台</h4>
            地址：深圳市福田区滨河大道彩田路5022号联合广场A座裙楼4楼401<br>
            客服热线：400-888-2933<br>
            企业邮箱：admin@ysysgo.com<br>
           官方网址：<a href="http://www.ysysgo.com">http://www.ysysgo.com</a><br>
          官方微博：<a target="_blank" href="http://weibo.com/ysysgo">http://weibo.com/ysysgo</a><br>
          商户加盟QQ：2201434696&nbsp;&nbsp;&nbsp;&nbsp;商户加盟邮箱：ysysgo_o2o@163.com<br>
          供应商加盟QQ： 3417880264&nbsp;&nbsp;&nbsp;&nbsp;供应商加盟邮箱：ysysgo_shop@163.com<br> 
          
            官方微信：云尚大健康
        </div>
        <div class="contact-code">
            <p class="text-center">微信公众号</p>
            <img src="${staticPath}/static/enterprise/assets/images/wx-code.png" />
        </div>

    </div>


</div>

    <%@ include file="include/footer.jsp"%>

    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=700b132845ef5b0b135066dfa0222a37"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.js"></script>
    <link rel="stylesheet" href="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.css" />


    <script>



        // 百度地图API功能
        var map = new BMap.Map('dituContent');
        var poi = new BMap.Point(114.075753,22.535349);
        map.centerAndZoom(poi, 18);
        map.enableScrollWheelZoom();

        // 复杂的自定义覆盖物
        function ComplexCustomOverlay(point, text, mouseoverText){
            this._point = point;
            this._text = text;
            this._overText = mouseoverText;
        }
        ComplexCustomOverlay.prototype = new BMap.Overlay();
        ComplexCustomOverlay.prototype.initialize = function(map){
            this._map = map;
            var div = this._div = document.createElement("div");
            div.style.position = "absolute";
            div.style.zIndex = BMap.Overlay.getZIndex(this._point.lat);
            div.style.backgroundColor = "none";
            div.style.border = "none";
            div.style.color = "none";
            div.style.height = "18px";
            div.style.padding = "0";
            div.style.lineHeight = "18px";
            div.style.whiteSpace = "nowrap";
            div.style.MozUserSelect = "none";
            div.style.fontSize = "12px"
            var span = this._span = document.createElement("span");
            div.appendChild(span);
            span.appendChild(document.createTextNode(this._text));
            var that = this;

            var arrow = this._arrow = document.createElement("div");
            arrow.style.background = "url(${staticPath}/static/enterprise/assets/images/map-point.png) no-repeat";
            arrow.style.position = "absolute";
            arrow.style.width = "72px";
            arrow.style.height = "116px";
            arrow.style.top = "-72px";
            arrow.style.left = "0";
            arrow.style.overflow = "hidden";
            div.appendChild(arrow);


            map.getPanes().labelPane.appendChild(div);

            return div;
        }
        ComplexCustomOverlay.prototype.draw = function(){
            var map = this._map;
            var pixel = map.pointToOverlayPixel(this._point);
            this._div.style.left = pixel.x - 35 + "px";
            this._div.style.top  = pixel.y - 30 + "px";
        }
        var txt = "", mouseoverTxt = "";

        var myCompOverlay = new ComplexCustomOverlay(new BMap.Point(114.075753,22.535349), " ",mouseoverTxt);

        map.addOverlay(myCompOverlay);

    </script>

</body>
</html>