<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />

    <title>睁闭眼</title>


    <%@ include file="../include/inc_css.jsp"%>

</head>
<body class="task-blue">
    <div class="wrapper">

        <div id="activeIndex" class="openEye">
            <img src="../assets/images/task/eye-05.jpg" />
            <div class="text-center">根据听到的指令睁眼或闭眼</div>
        </div>

        <ul id="activePage" class="openEye list">
            <li><img src="../assets/images/task/eye-06.jpg" /></li>
            <li><img src="../assets/images/task/eye-07.jpg" /></li>
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
        var arrMsc = ["../assets/snd/cc_bi.mp3", "../assets/snd/cc_zheng.mp3"], curMsc = (parseInt(Math.random()*(9)) % 2),
                $ul = $("#activePage"), msc = document.getElementById('taskAudioName'), activeTime;
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
                var time = Math.floor((Math.random()*(6-1+1)+1)) * 800;
                activeTime = setTimeout(function() {
                    payTimer();
                }, time);
                var siblings = $ul.find("li:visible").hide().siblings();
                var index = Math.floor((Math.random() * siblings.length));
                var mIndex = siblings.eq(index).show().index();
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