<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>左右移动</title>


    <%@ include file="../include/inc_css.jsp"%>

</head>
<body class="task-blue">

<div id="img" style="background-color: #f00; width: 40px; height: 40px; position: absolute;">
</div>

<script src="../assets/js/jquery-2.1.4.min.js"></script>

<script>


    var xPos = 5;
    var yPos = $(window).height();
    var step = 1;
    var delay = 500;
    var height = 0;
    var Hoffset = 0;
    var Woffset = 0;
    var yon = 0;
    var xon = 0;
    var pause = true;
    var interval;
    img.style.top = yPos;
    function changePos() {
        width = $(window).width();
        height = $(window).height();


        Hoffset = img.offsetHeight;
        Woffset = img.offsetWidth;

        $(img).css({
            left: xPos + document.body.scrollLeft,
            top: yPos + document.body.scrollTop
        });

        if (yon) {
            yPos = yPos + 1;
        }
        else {
            yPos = yPos - 1;
        }
        if (yPos < 0) {
            yon = 1;
            yPos = 0;
        }
        if (yPos >= (height - Hoffset)) {
            yon = 0;
            yPos = (height - Hoffset);
        }
        if (xon) {
            xPos = xPos + step + 3;
        }
        else {
            xPos = xPos - step - 3;
        }
        if (xPos < 0) {
            xon = 1;
            xPos = 0;
        }
        if (xPos >= (width - Woffset)) {
            xon = 0;
            xPos = (width - Woffset);
        }
    }
    function start() {
        img.visibility = "visible";
        interval = setInterval("changePos()", delay);
    }
    start();

</script>

</body></html>