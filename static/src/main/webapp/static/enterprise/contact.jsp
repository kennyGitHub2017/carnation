<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />

    <title>云尚平台官网</title>
    <meta name="keywords" content="健康生活" />
    <meta name="description" content="">
	<%@ include file="include/inc_css.jsp"%>

</head>
<body mid="m-contact">
    <%@ include file="include/header.jsp"%>


    <div id="dituContent"></div>

    <div class="contact-content">
        <h4>云尚·中国国际抗衰老中心</h4>
        <div><i class="icon pos"></i> 深圳市南山区科兴科学园A4栋5楼</div>
        <div class="col-md-6"><i class="icon tel"></i> 400-0755-005</div>
        <div class="col-md-6"><i class="icon fox"></i> 0755-82760088</div>
        <div class="col-md-6"><i class="icon mail"></i> pd@jigang.com</div>
        <div class="col-md-6"><i class="icon web"></i> http://www.jgksl.com/</div>
    </div>

    <%@ include file="include/footer.jsp"%>

    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=700b132845ef5b0b135066dfa0222a37"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.js"></script>
    <link rel="stylesheet" href="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.css" />


    <script>



        // 百度地图API功能
        $("#dituContent").height($(window).height() - 200);
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
            arrow.style.background = "url(assets/images/map-point.png) no-repeat";
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