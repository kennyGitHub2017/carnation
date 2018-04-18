<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />

    <title>两个物体</title>


    <%@ include file="../include/inc_css.jsp"%>

</head>
<body class="task-blue">
    <div class="wrapper">

        <div id="activeIndex">
            <div class="pt-p10 text-right"><img class="w-pm90" src="../assets/images/task/eye-13.jpg" /></div>
        </div>

        <div id="doubleBall"></div>

        <div id="taskMask" class="mask">
            <div><a id="J_playBtn" href="javascript:void(0)" class="startBtn"><img src="../assets/images/start.png" /></a></div>
        </div>



        <canvas id="pCanvas" class="p-canvas" height="100" width="100" ></canvas>

    </div>

    <script src="../assets/js/jquery-2.1.4.min.js"></script>
    <script src="../assets/js/page/drawArc.js"></script>

    <script>


        $("#J_playBtn").click(function() {
            $("#activeIndex, #taskMask").hide();
            $("body").attr("class", "task-grid");

            $("#doubleBall").html('<div id="leftBall" class="ball"></div><div id="rightBall" class="ball"></div>');
            var activeTimes = setInterval(function() {
                $("#doubleBall").html('<div id="leftBall" class="ball"></div><div id="rightBall" class="ball"></div>');
            }, 20200);

            var time = 0, mscTimer = setInterval(function() {
                drawArc(ctx, time/70);
                if (time > 70) {
                    clearInterval(mscTimer);
                    clearInterval(activeTimes);

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