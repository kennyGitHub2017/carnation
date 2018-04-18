<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />

    <title>减肥操</title>

    <link href="../assets/widget/iCheck/blue.css" rel="stylesheet" type="text/css">
    <%@ include file="../include/inc_css.jsp"%>

</head>
<body>
    <div class="wrapper">

        <ul id="J_stepTask" class="task task-01 step-task no-pad list">
            <li class="active">
                <div class="pic">
                    <img src="../assets/images/task/loss-01.jpg" />
                    <i class="icon-chevron-right J_playNext"></i>
                </div>
                <div class="note">
                    <div class="step-label"><label>STEP</label>1</div>
                    吸气站好，双脚并拢，脊椎伸直，收紧小腹，夹紧臀部，双手自然垂放于两侧。</div>
            </li>
            <li>
                <div class="pic">
                    <i class="icon-chevron-left J_playPrev"></i>
                    <img src="../assets/images/task/loss-02.jpg" />
                    <i class="icon-chevron-right J_playNext"></i>
                </div>
                <div class="note">
                    <div class="step-label"><label>STEP</label>2</div>
                    吐气，身体慢慢下蹲，感觉尾椎朝下延伸。</div>
            </li>
            <li>
                <div class="pic">
                    <i class="icon-chevron-left J_playPrev"></i>
                    <img src="../assets/images/task/loss-02.jpg" />
                    <i class="icon-chevron-right J_playNext"></i>
                </div>
                <div class="note">
                    <div class="step-label"><label>STEP</label>3</div>
                    吸气，维持半蹲姿势，双手打开与肩同宽，停
                    在胸前，停留3-5个呼吸。</div>
            </li>
            <li>
                <div class="pic">
                    <i class="icon-chevron-left J_playPrev"></i>
                    <img src="../assets/images/task/loss-04.jpg" />
                    <i class="icon-chevron-right J_playNext"></i>
                </div>
                <div class="note">
                    <div class="step-label"><label>STEP</label>4</div>
                    吸气，双手慢慢举起，于头顶上方将掌心合起，
                    感觉脊椎向上伸展。
                </div>
            </li>
            <li>
                <div class="pic">
                    <i class="icon-chevron-left J_playPrev"></i>
                    <img src="../assets/images/task/loss-05.jpg" />
                </div>
                <div class="note">
                    <div class="step-label"><label>STEP</label>5</div>
                    吐气，将右手张开，同时转动头部，眼睛看向右
                    手指尖，膝盖倒向左边，停留3-5个呼吸。

                    <div class="pt-10">吸气，回到动作2，换边进行相同动作。</div></div>
            </li>
        </ul>

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