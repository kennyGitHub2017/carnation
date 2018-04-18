<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />

    <title>帖子详情</title>

    <%@ include file="include/inc_css.jsp"%>
</head>

<body class="scroll-body">
    <div class="wrapper">



        <div id="wrapper" class="no-bot">
            <div id="scroller">


                <div class="bbs-header">
                    <div class="date">发布于34分钟前</div>
                    <div class="bbs-user-info">
                        <img class="pic" src="assets/images/temp/photo01.jpg" />
                        <div class="info">
                            <div class="name">小萝莉~ </div>
                            <div class="color-pop">楼主</div>
                        </div>
                    </div>
                    <i class="icon-triangle-up up-border-arrow"></i>
                </div>

                <a id="android" class="btn btn-android" href="http://yixin.dl.126.net/update/installer/yixin.apk" title="Android下载">ddddd</a>

                <div class="bbs-cont">
                    <h3 class="title">一天中什么时间跑步最好（生活小经验）</h3>
                    <div class="cont">
                        <p>随着年龄的增长，我们的体力和精神承受
                        能力已经下降到如同悬崖的边缘上了。肌蛋白
                        的减少是随年龄增长而出现的典型病症。在老
                        年人中，由于其肌肉力量的下降和身体极度地
                        虚弱，摔倒和骨折是比较常见的。研究表明：
                        力量训练也能有效地减少老年人摔倒的频率及
                        骨折。</p>
                        <img src="assets/images/temp/pic02.jpg" />
                        <p>不管什么年龄的跑步者，很少有人努力去锻炼
                        腿部以外的肌肉。但是，在日常训练中，有规
                        律地安排一系列简单的上身力量练习，将有效
                        地提高训练者的跑步能力。</p>
                    </div>
                    <div class="reply">
                        <span class="fl"><i class="icon-chat"></i> 跟帖(90)</span>

                        <a href="javascript:void(0)"><i class="icon-warning"></i> 举报</a>
                    </div>
                </div>
                <div class="bbs-action clearfix">
                    <div class="col-3"><i class="icon-star"></i> <span>收藏</span></div>
                    <div class="col-3 text-center"><i class="icon-share-alt"></i> <span>享</span></div>
                    <div class="col-3 text-right"><i class="icon-thumbs-up"></i> <span>57</span></div>
                </div>

                <ul class="bbs-list list">
                    <li>
                        <div class="bbs-header">
                            <div class="date text-right">发布于34分钟前 <div>1 楼</div></div>
                            <div class="bbs-user-info">
                                <img class="pic" src="assets/images/temp/photo01.jpg" />
                                <div class="name">
                                    小萝莉~
                                </div>
                            </div>
                            <i class="icon-triangle-up up-border-arrow"></i>
                        </div>
                        <div class="bbs-reply-cont">
                            我是很想天天跑，但是坚持不下来呀。55555555~~~
                            <div class="pt-10 text-right"><button class="bbs-reply-Btn">回复</button></div>
                        </div>
                    </li>
                    <li>
                        <div class="bbs-header">
                            <div class="date text-right">发布于34分钟前 <div>2 楼</div></div>
                            <div class="bbs-user-info">
                                <img class="pic" src="assets/images/temp/photo01.jpg" />
                                <div class="name">
                                    小萝莉~
                                </div>
                            </div>
                            <i class="icon-triangle-up up-border-arrow"></i>
                        </div>
                        <div class="bbs-reply-cont">
                            每天干完农活，我都会运动一会。
                            <div class="pt-10 text-right"><button class="bbs-reply-Btn">回复</button></div>
                        </div>
                    </li>
                    <li>
                        <div class="bbs-header">
                            <div class="date text-right">发布于34分钟前 <div>3 楼</div></div>
                            <div class="bbs-user-info">
                                <img class="pic" src="assets/images/temp/photo01.jpg" />
                                <div class="name">
                                    小萝莉~
                                </div>
                            </div>
                            <i class="icon-triangle-up up-border-arrow"></i>
                        </div>
                        <div class="bbs-reply-cont">
                            <div class="reply-quotes">
                                <div class="title">回复1楼 小胖墩</div>
                                我是很想天天跑，但是坚持不下来呀。55555555~~~
                            </div>
                            每天干完农活，我都会运动一会。
                            <div class="pt-10 text-right"><button class="bbs-reply-Btn">回复</button></div>
                        </div>
                    </li>
                </ul>

                <div id="pullUp" class="ub ub-pc c-gra">
                    <div class="pullUpIcon"></div>
                    <div class="pullUpLabel">上拉显示更多...</div>
                </div>

        </div></div>


    </div>


    <script src="assets/js/jquery-2.1.4.min.js"></script>
    <script src="assets/widget/iscroll-probe.js"></script>
<script>

    var myScroll;
    var pullDownEl, pullDownL;
    var pullUpEl, pullUpL;
    var Downcount = 0 ,Upcount = 0;
    var loadingStep = 0;//加载状态0默认，1显示加载状态，2执行加载数据，只有当为0时才能再次加载，这是防止过快拉动刷新
    function pullUpAction() {//上拉事件
        setTimeout(function() {
            var el, li, i, html;
            html = '<div class="bbs-header">\
                        <div class="date text-right">发布于34分钟前 <div>2 楼</div></div>\
                        <div class="bbs-user-info">\
                                <img class="pic" src="assets/images/temp/photo01.jpg" />\
                                <div class="name">小萝莉~</div>\
                        </div>\
                        <i class="icon-triangle-up up-border-arrow"></i>\
                        </div>\
                        <div class="bbs-reply-cont">每天干完农活，我都会运动一会。<div class="pt-10 text-right"><button class="bbs-reply-Btn">回复</button></div>\
                    </div>'
            el = $('.bbs-list');
            el.append(html);
            pullUpEl.removeClass('loading');
            pullUpL.html('上拉显示更多...');
            pullUpEl['class'] = pullUpEl.attr('class');
            pullUpEl.attr('class','').hide();
            myScroll.refresh();
            loadingStep = 0;
        }, 1000);
    }

    function loaded() {
        pullUpEl = $('#pullUp');
        pullUpL = pullUpEl.find('.pullUpLabel');
        pullUpEl['class'] = pullUpEl.attr('class');
        pullUpEl.attr('class','').hide();

        myScroll = new IScroll('#wrapper', {
            probeType: 2,//probeType：1对性能没有影响。在滚动事件被触发时，滚动轴是不是忙着做它的东西。probeType：2总执行滚动，除了势头，反弹过程中的事件。这类似于原生的onscroll事件。probeType：3发出的滚动事件与到的像素精度。注意，滚动被迫requestAnimationFrame（即：useTransition：假）。
            scrollbars: true,//有滚动条
            mouseWheel: true,//允许滑轮滚动
            fadeScrollbars: true,//滚动时显示滚动条，默认影藏，并且是淡出淡入效果
            bounce:true,//边界反弹
            shrinkScrollbars:'scale',// 当滚动边界之外的滚动条是由少量的收缩。'clip' or 'scale'.
            click: true ,// 允许点击事件
            momentum:true// 允许有惯性滑动
        });
        //滚动时
        myScroll.on('scroll', function(){
            if(loadingStep == 0 && !pullUpEl.attr('class').match('flip|loading')){
                if (this.y < (this.maxScrollY - 5)) {
                    //上拉刷新效果
                    pullUpEl.attr('class',pullUpEl['class'])
                    pullUpEl.show();
                    myScroll.refresh();
                    pullUpEl.addClass('flip');
                    pullUpL.html('上拉查看更多回复...');
                    loadingStep = 1;
                }
            }
        });
        //滚动完毕
        myScroll.on('scrollEnd',function(){
            if(loadingStep == 1){
                if (pullUpEl.attr('class').match('flip|loading')) {
                    pullUpEl.removeClass('flip').addClass('loading');
                    pullUpL.html('Loading...');
                    loadingStep = 2;
                    pullUpAction();
                }
            }
        });
    }



    document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
    //window.addEventListener('onload', loaded, false);
    window.onload = function() {
        loaded();
    };


    $(".bbs-reply-Btn").click(function() {
        console.log("___________");
    });

</script>

</body>
</html>
