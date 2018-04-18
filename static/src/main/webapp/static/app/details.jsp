<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />

    <title>我的问答</title>

    <%@ include file="include/inc_css.jsp"%>

</head>
<body class="scroll-body">

    <div id="scroll-x" class="">
        <div class="scroll-tab scroll-box">
            <ul class="scroll-x-tab tab list">
                <li>无痕祛眼袋</li>
                <li class="action">激光治疗眼袋</li>
                <li>吸脂治疗眼袋</li>
                <li>吸脂治疗眼袋</li>
            </ul>
        </div>
    </div>

    <div id="wrapper" class="info-wrapper">
        <div id="scroller">
            <div class="info-content-title">项目简介</div>
            <div class="info-content">
                <p>手术祛眼袋介绍: 由于眼袋的形成原因
                不同，它所表现的形式也有所差别：<br>
                1、单纯眼轮匝肌肥厚型眼袋  由于遗传性因素，
                年轻时就有下睑眼袋。其突出特点为靠近下睑缘，
                呈弧形连续分布，皮肤并不松弛，多见于20－32
                岁年轻人。</p>
                <img src="assets/images/temp/pic03.jpg" />
                <p>2、单纯皮肤松弛型  此种情况为下睑及外眦皮肤
                    松弛，但无眶隔松弛，故无眶隔脂肪突出，眼周
                    出现细小皱纹，多见于33-45岁的中年人。</p>
            </div>

        </div>
    </div>

    <div class="fixed-bottom-bar double-btn-bar pt-10">
        <button class="btn btn-blue">附近医院</button>
        <button class="btn btn-blue">咨询专家</button>
    </div>

    <script src="assets/js/jquery-2.1.4.min.js"></script>
    <script src="assets/widget/iscroll-probe.js"></script>

    <script>
        function loaded () {
            var $action = $("#scroll-x .action");
            var myScroll = new IScroll('#scroll-x', { scrollX: true, scrollY: false,
                mouseWheel: true, fixedScrollbar: true,bounce: false
            });
            myScroll.scrollToElement($action[0], 0, -40);

            var myScroll02 = new IScroll('#wrapper', {
                probeType: 2,//probeType：1对性能没有影响。在滚动事件被触发时，滚动轴是不是忙着做它的东西。probeType：2总执行滚动，除了势头，反弹过程中的事件。这类似于原生的onscroll事件。probeType：3发出的滚动事件与到的像素精度。注意，滚动被迫requestAnimationFrame（即：useTransition：假）。
                scrollbars: true,//有滚动条
                mouseWheel: true,//允许滑轮滚动
                fadeScrollbars: true,//滚动时显示滚动条，默认影藏，并且是淡出淡入效果
                bounce:true,//边界反弹
                shrinkScrollbars:'scale',// 当滚动边界之外的滚动条是由少量的收缩。'clip' or 'scale'.
                click: true ,// 允许点击事件
                momentum:true// 允许有惯性滑动
            });
        }
        document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
        document.addEventListener('DOMContentLoaded', loaded, false);

        $(".scroll-x-tab li").click(function() {
            alert(2);
        });
    </script>
</body>
</html>