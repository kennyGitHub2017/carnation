<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />

    <title>眼保健操</title>

    <link href="../assets/widget/iCheck/blue.css" rel="stylesheet" type="text/css">
    <%@ include file="../include/inc_css.jsp"%>

</head>
<body class="task-blue">
    <div class="wrapper">

        <ul id="J_stepTask" class="task task-01 step-task list">
            <li class="active">
                <div class="pic">
                    <img src="../assets/images/task/eye-01.jpg" />
                    <i class="icon-chevron-right J_playNext"></i>
                </div>
            </li>
            <li>
                <div class="pic">
                    <i class="icon-chevron-left J_playPrev"></i>
                    <img src="../assets/images/task/eye-02.jpg" />
                    <i class="icon-chevron-right J_playNext"></i>
                </div>
            </li>
            <li>
                <div class="pic">
                    <i class="icon-chevron-left J_playPrev"></i>
                    <img src="../assets/images/task/eye-03.jpg" />
                    <i class="icon-chevron-right J_playNext"></i>
                </div>
            </li>
            <li>
                <div class="pic">
                    <i class="icon-chevron-left J_playPrev"></i>
                    <img src="../assets/images/task/eye-04.jpg" />
                </div>
            </li>
        </ul>

        <div id="taskMask" class="mask">
            <div><a id="J_playBtn" href="javascript:void(0)" class="startBtn"><img src="../assets/images/start.png" /></a></div>
        </div>



        <canvas id="pCanvas" class="p-canvas" height="100" width="100" ></canvas>
        <audio id="taskAudio" src="../assets/snd/cc_1234.mp3" hidden="hidden"></audio>
        <div id="taskAudioName"></div>
    </div>

    <script src="../assets/js/jquery-2.1.4.min.js"></script>
    <script src="../assets/js/page/task.js"></script>

    <script>
        var audioArr = ["../assets/snd/cc_eye_diyijie.mp3", "../assets/snd/cc_eye_dierjie.mp3",
            "../assets/snd/cc_eye_disanjie.mp3", "../assets/snd/cc_eye_disijie.mp3"];

        var mscList = document.getElementById('taskAudioName');


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