<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />

    <title>我的问答</title>

    <%@ include file="../include/inc_css.jsp"%>

</head>
<body>
    <div class="wrapper">

        <ul id="J_stepTask" class="task task-01 step-task list">
            <li class="active">
                <div class="title">预备动作</div>
                <div class="pic">
                    <img src="../assets/images/task/1-01.jpg" />
                    <i class="icon-chevron-right J_playNext"></i>
                </div>
                <div class="note">
                    坐在椅子或沙发上，姿势自然端正，正视前方，两臂自然下垂，双手手掌放在大腿上膝关节呈90度角，两足分开与肩同宽，全身肌肉放松，呼吸匀称。</div>
            </li>
            <li>
                <div class="title">1.按揉太阳穴</div>
                <div class="pic">
                    <i class="icon-chevron-left J_playPrev"></i>
                    <img src="../assets/images/task/1-02.jpg" />
                    <i class="icon-chevron-right J_playNext"></i>
                </div>
                <div class="note">
                    <div class="step-label"><label>STEP</label>1</div>
                    顺时针旋转一周为一拍，约做32拍。此法可疏风解表、清脑明目、止头痛。</div>
            </li>
            <li>
                <div class="title">2.按摩百会穴</div>
                <div class="pic">
                    <i class="icon-chevron-left J_playPrev"></i>
                    <img src="../assets/images/task/1-03.jpg" />
                    <i class="icon-chevron-right J_playNext"></i>
                </div>
                <div class="note">
                    <div class="step-label"><label>STEP</label>2</div>
                    百会穴位于头顶正中央。用手掌紧贴百会穴旋转，一周为一拍，共做32拍。此法可降血压。宁神清脑。</div>
            </li>
            <li>
                <div class="title">3.按摩风池穴</div>
                <div class="pic">
                    <i class="icon-chevron-left J_playPrev"></i>
                    <img src="../assets/images/task/1-04.jpg" />
                    <i class="icon-chevron-right J_playNext"></i>
                </div>
                <div class="note">
                    <div class="step-label"><label>STEP</label>3</div>
                    用双手拇指按揉双侧风池穴，顺时针旋转，一周为一拍，共做32拍。
                </div>
            </li>
            <li>
                <div class="title">4.擦颈</div>
                <div class="pic">
                    <i class="icon-chevron-left J_playPrev"></i>
                    <img src="../assets/images/task/1-05.jpg" />
                    <i class="icon-chevron-right J_playNext"></i>
                </div>
                <div class="note">
                    <div class="step-label"><label>STEP</label>4</div>
                    用左手掌大鱼际擦抹右颈部胸锁乳突肌，再换右手擦左颈，一次为一拍，共做32拍此法可解除胸锁乳突肌痉挛，并降血压。</div>
            </li>
            <li>
                <div class="title">5.揉曲池穴</div>
                <div class="pic">
                    <i class="icon-chevron-left J_playPrev"></i>
                    <img src="../assets/images/task/1-06.jpg" />
                    <i class="icon-chevron-right J_playNext"></i>
                </div>
                <div class="note">
                    <div class="step-label"><label>STEP</label>5</div>
                    按揉肘关节处曲池穴，先用右手再换左手，旋转一周为一拍，共做32拍，此法可清热、降压。</div>
            </li>
            <li>
                <div class="title">6.揉关宽胸</div>
                <div class="pic">
                    <i class="icon-chevron-left J_playPrev"></i>
                    <img src="../assets/images/task/1-07.jpg" />
                    <i class="icon-chevron-right J_playNext"></i>
                </div>
                <div class="note">
                    <div class="step-label"><label>STEP</label>6</div>
                    用大拇指按揉内关穴，先揉左手后揉右手，顺时针方向按揉一周为一拍，共32拍。功效为舒心开胸。</div>
            </li>
            <li>
                <div class="title">7.阔胸调气</div>
                <div class="pic">
                    <i class="icon-chevron-left J_playPrev"></i>
                    <img src="../assets/images/task/1-08.jpg" />
                </div>
                <div class="note">
                    <div class="step-label"><label>STEP</label>7</div>
                    两手放松下垂，然后握空拳，屈肘抬至肩高，向后扩胸，最后放松还原。</div>
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