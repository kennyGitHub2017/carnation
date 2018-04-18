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
<body>
    <div class="wrapper">
    
    <div id="wrapper">
        <div id="scroller">
    
        <div class="question-header">
            <div class="qh-info">
                <img src="assets/images/temp/photo01.jpg" />
                <div class="qh-name">
                    <div class="name">韩定心</div>
                    妇产科医生
                </div>
            </div>
            <a href="javascript: void(0)" class="qh-praise">
                <i class="icon-thumbs-up"></i>
                <span>231</span>
            </a>
        </div>

        <div class="clearfix">

            <div class="qh-title">
                <a href="javascript:void(0)" class="fr"><i class="icon-edit"></i></a>
                脸上长痘痘了怎么办?
            </div>
            <div class="qh-cont p-gray-b">
                去年开始就这样了
                <img src="assets/images/temp/pic01.jpg" />
                <p>去年开始就这样了</p>
                <img src="assets/images/temp/pic01.jpg" />
                <div class="qh-date fz-s"><a href="#" class="c-blue">小萝莉</a>  4个小时前发布</div>
            </div>
            <div class="comment clearfix">
                <ul class="cmt-list list">
                    <li class="cmt-reply">
                        <div class="cmt-date"><span>2015-06-01 11:25:35</span></div>
                        <img class="pic" src="assets/images/temp/photo01.jpg" />
                        <div class="cmt-padding">
                            <div class="cmt-pop"><i class="icon-triangle-left"></i>
                                将半汤匙白醋加入到一汤匙食盐中，然后再加点冷开水，等到盐全部融化掉；就用化妆棉去蘸取这个调好的液体，
                                化妆棉被完全浸湿之后敷在有痘痘的地方。每天敷一次，这样坚持下去祛除痘痘效果非常有效，同时还能美白肌肤。
                            </div>
                        </div>
                    </li>
                    <li class="cmt-question">
                        <div class="cmt-date"><span>2015-06-01 11:25:35</span></div>
                        <img class="pic" src="assets/images/temp/photo01.jpg" />
                        <div class="cmt-padding">
                            <div class="cmt-pop"><i class="icon-triangle-right"></i>

                                将半汤匙白醋加入到一汤匙食盐中，然后再加点冷开水，等到盐全部融化掉；就用化妆棉去蘸取这个调好的液体，
                                化妆棉被完全浸湿之后敷在有痘痘的地方。每天敷一次，这样坚持下去祛除痘痘效果非常有效，同时还能美白肌肤。
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            
        </div>
        
        
        
        
        
        </div></div>
        
        <div class="reply-box">
                <button class="reply-btn"><i class="icon-chat-3"></i> 立即回复</button>
            </div>
        
    </div>
    
    
    <script src="assets/js/jquery-2.1.4.min.js"></script>
    <script src="assets/widget/iscroll-probe.js"></script>

    <script>
        function loaded () {

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
    </script>

</body>
</html>