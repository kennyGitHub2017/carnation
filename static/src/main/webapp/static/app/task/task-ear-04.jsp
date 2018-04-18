<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />

    <title>拉耳廓</title>


    <%@ include file="../include/inc_css.jsp"%>

</head>
<body class="task-blue">
    <div class="wrapper">

        <div class="task-showBox">
            <div class="pic"><img src="../assets/images/task/er-04.jpg" /></div>
            <div class="title">拧耳朵</div>
            <div class="note">双手掌心面对耳廓，向内耳方面轻轻按下，然后轻轻松手，反复进行，反复进行，刚开始每次3~5分钟，以后可增加到5~10分钟，早晚各2次。</div>
        </div>

        <div id="taskMask" class="mask">
            <div><a id="J_playBtn" href="javascript:void(0)" class="startBtn"><img src="../assets/images/start.png" /></a></div>
        </div>



        <canvas id="pCanvas" class="p-canvas" height="100" width="100" ></canvas>
        <audio id="taskAudio" src="../assets/snd/cc_1234.mp3" hidden="hidden"></audio>
    </div>

    <script src="../assets/js/jquery-2.1.4.min.js"></script>
    <script src="../assets/js/page/task.js"></script>
    <script>
        function endTask() {
            if (isAndroid) {
                java.onExercisesEnd();
            } else if (isiOS) {
                onExercisesEnd();
            }
        }
    </script>
</body>
</html>