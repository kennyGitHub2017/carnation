<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />

    <title>联系我们,联系云尚商务 - 云尚招商网</title>
    <meta name="keywords" content="联系云尚, 联系云尚, 联系云尚商务" />
    <meta name="description" content="云尚招商网是云尚中国健康管理集团旗下云尚的招商加盟平台，为云尚运营商提供360度全方位的运营扶持与技术支持。云尚打造了一个集健康管理服务、同业联盟O2O、移动支付和积分通兑为一体的综合性健康管理与增值服务平台。云尚服务热线：xxxxxxxx 。">
	<%@ include file="include/inc_css.jsp"%>

</head>
<body mid="m-contact">
    <%@ include file="include/header.jsp"%>

    <div class="mod-banner" style="background-image: url(${staticPath}/static/enterprise/assets/images/banner-contact.jpg)"></div>

<div class="gray-bg">
    <div class="contact-content cont-width">
        <div id="dituContent"></div>

        <div class="cont">
            <h4>云尚健康管理综合服务平台</h4>
            地址：深圳市南山区科兴科学园A4栋5楼<br>
            服务热线：xxxxxxxx<br>
            固定电话：0755-26920199<br>
            传真：0755-26919066<br>
            QQ: 3273124108<br>
            Email：zs@ysysgo.com<br>
            网址：<a href="http://zs.ysysgo.com"> zs.ysysgo.com</a><br>
            微博：<a target="_blank" href="http://www.weibo.com/jgyys/"> http://www.weibo.com/jgyys</a>
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
        var poi = new BMap.Point(113.949629,22.554534);
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

        var myCompOverlay = new ComplexCustomOverlay(new BMap.Point(113.949288,22.554563), " ",mouseoverTxt);

        map.addOverlay(myCompOverlay);

    </script>

</body>
</html>