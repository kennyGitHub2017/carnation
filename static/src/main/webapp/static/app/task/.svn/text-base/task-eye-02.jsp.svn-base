<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />

    <title>闭眼移动</title>

    <%@ include file="../include/inc_css.jsp"%>

</head>
<body class="task-blue">
    <div class="wrapper">

        <div id="activeIndex" class="task-showBox">
            <div class="pic"><img src="../assets/images/task/eye-08.jpg" /></div>
            <div class="text-center">闭上双眼，往您听到的方向移动眼睛。</div>
        </div>

        <ul id="activePage" class="openEye list">
            <li><img src="../assets/images/task/eye-09.jpg" /></li>
            <li><img src="../assets/images/task/eye-10.jpg" /></li>
            <li><img src="../assets/images/task/eye-11.jpg" /></li>
            <li><img src="../assets/images/task/eye-12.jpg" /></li>
        </ul>

        <div id="taskMask" class="mask">
            <div><a id="J_playBtn" href="javascript:void(0)" class="startBtn"><img src="../assets/images/start.png" /></a></div>
        </div>



        <canvas id="pCanvas" class="p-canvas" height="100" width="100" ></canvas>
        <audio id="taskAudioName" hidden="hidden"></audio>

    </div>

    <script src="../assets/js/jquery-2.1.4.min.js"></script>
    <script src="../assets/js/page/drawArc.js"></script>

    <script>
        var arrMsc = ["../assets/snd/cc_shang.mp3", "../assets/snd/cc_you.mp3", "../assets/snd/cc_xia.mp3", "../assets/snd/cc_zuo.mp3"],
                curMsc = (parseInt(Math.random()*(9)) % 2), $ul = $("#activePage"), msc = document.getElementById('taskAudioName'), activeTime;
        function getQueryPar(name) {
        	   var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
        	   var r = window.location.search.substr(1).match(reg);
        	   if (r!=null) return (r[2]); return null;
       	}
        $("#J_playBtn").click(function() {
            $("#activeIndex, #taskMask").hide();
            msc.src = arrMsc[curMsc];
            msc.play();
            $ul.find("li").eq(curMsc).show();

            var payTimer = function() {
                var time = 2500;
                activeTime = setTimeout(function() {
                    payTimer();
                }, time);
                var siblings = $ul.find("li:visible").fadeOut(300).siblings();
                var index = Math.floor((Math.random() * siblings.length));
                var mIndex = siblings.eq(index).delay(400).fadeIn(300).index();
                msc.src = arrMsc[mIndex];
                msc.play();
            };
            payTimer();

            var time = 0, mscTimer = setInterval(function() {
                drawArc(ctx, time/70);
                if (time > 70) {
                    clearInterval(mscTimer);
                    clearTimeout(activeTime);

                    var taskID=getQueryPar('taskID');
                    var userID=getQueryPar('userID');
                    if (isAndroid) {
                        java.requestTaskDone(taskID,userID,'taskDone');
                    } else if (isiOS) {
                    	requestTaskDone(taskID,userID,'taskDone');
                    }
                }
                time++
            }, 1000);
        });





    </script>

</body>
</html>