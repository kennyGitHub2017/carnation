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

        <ul id="J_stepTask" class="task task-01 step-task w-max list">
            <li class="active">
                <div class="pic">
                    <img src="../assets/images/task/fast-01.jpg" />
                    <i class="icon-chevron-right J_playNext"></i>
                </div>
                <div class="note">
                    <div class="step-label"><label>STEP</label>1</div>
                    站姿，双脚分开与肩同宽，手臂放在身体两
                    侧。慢慢抬起左腿，直到小腿与大腿呈直角;
                    双手分开高举过头，手心朝内，手指并拢。
                    坚持10秒钟，再回到起始动作。换腿进行。
                    重复10组。</div>
            </li>
            <li>
                <div class="pic">
                    <i class="icon-chevron-left J_playPrev"></i>
                    <img src="../assets/images/task/fast-02.jpg" />
                    <i class="icon-chevron-right J_playNext"></i>
                </div>
                <div class="note">
                    <div class="step-label"><label>STEP</label>2</div>
                    站姿，双手叉腰，提右腿，向前跨一大步，
                    同时左腿向地面屈膝，直至膝盖离地面15厘
                    米左右，保持3秒钟。然后换腿进行。重复该
                    动作10次。</div>
            </li>
            <li>
                <div class="pic">
                    <i class="icon-chevron-left J_playPrev"></i>
                    <img src="../assets/images/task/fast-03.jpg" />
                    <i class="icon-chevron-right J_playNext"></i>
                </div>
                <div class="note">
                    <div class="step-label"><label>STEP</label>3</div>
                    双腿直立，双手叉腰，身体向前倾，深呼吸，
                    左腿用力向后伸展，直到与身体呈一条直线，
                    保持该姿势5秒钟。然后换腿进行。重复该组
                    动作10组。</div>
            </li>
            <li>
                <div class="pic">
                    <i class="icon-chevron-left J_playPrev"></i>
                    <img src="../assets/images/task/fast-04.jpg" />
                    <i class="icon-chevron-right J_playNext"></i>
                </div>
                <div class="note">
                    <div class="step-label"><label>STEP</label>4</div>
                    躺在床上，双腿并拢，屈右膝，双手紧紧抱
                    住膝盖，深呼吸，用力抬起上身，直到右腿
                    与身体呈直角，保持该姿势5秒钟。然后换
                    腿进行。重复10次。
                </div>
            </li>
            <li>
                <div class="pic">
                    <i class="icon-chevron-left J_playPrev"></i>
                    <img src="../assets/images/task/fast-05.jpg" />
                    <i class="icon-chevron-right J_playNext"></i>
                </div>
                <div class="note">
                    <div class="step-label"><label>STEP</label>5</div>
                    双手、双膝贴地，采取匍匐姿势，用力向后
                    抬起右腿，与地面保持平衡，与此同时，向
                    前伸直左手臂，也与地面保持平行。保持该
                    姿势5秒钟。然后换腿进行。重复10次。</div>
            </li>
            <li>
                <div class="pic">
                    <i class="icon-chevron-left J_playPrev"></i>
                    <img src="../assets/images/task/fast-06.jpg" />
                    <i class="icon-chevron-right J_playNext"></i>
                </div>
                <div class="note">
                    <div class="step-label"><label>STEP</label>6</div>
                    跪姿，右手叉腰，左手撑地，支撑住身体重
                    心，抬头挺胸，眼睛向前平视，抬起右腿，
                    直至与地面保持平行。保持该动作5秒钟。然
                    后换侧进行。重复多次。</div>
            </li>
            <li>
                <div class="pic">
                    <i class="icon-chevron-left J_playPrev"></i>
                    <img src="../assets/images/task/fast-07.jpg" />
                    <i class="icon-chevron-right J_playNext"></i>
                </div>
                <div class="note">
                    <div class="step-label"><label>STEP</label>7</div>
                    平躺在地板或床上，双腿并拢，双手放身体两侧，用力撑起上身，双腿缓缓向上举，直到与身体呈90度角，保持该姿势5秒钟，然后放下。重复进行1020次。</div>
            </li>
            <li>
                <div class="pic">
                    <i class="icon-chevron-left J_playPrev"></i>
                    <img src="../assets/images/task/fast-08.jpg" />
                </div>
                <div class="note">
                    <div class="step-label"><label>STEP</label>8</div>
                    侧躺在床或地板上，双腿并拢，左手扶耳撑
                    住头部重心，右手自然地放在胸前，用力抬
                    起右腿，抬到最高处，保持该动作5秒。然后
                    换侧进行。重复多次。</div>
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