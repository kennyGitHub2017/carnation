/**
 * Created by thh on 15/6/13.
 */

var msc = document.getElementById('taskAudio');
var ctx = document.getElementById('pCanvas').getContext('2d');
var mscTimer = null, audioArr = null;

$("#J_playBtn").click(function() {
    hideMask();
    playMsc();
});

$(".J_playPrev").click(function() {
    $(this).parents("li").hide().prev().show();
    drawArc(ctx);
    if (msc.src.indexOf("cc_1234.mp3") == -1) {
        msc.src = "../assets/snd/cc_1234.mp3";
    } else {
        msc.currentTime = 0;
    }
    playMsc();
});

$(".J_playNext").click(function() {
    $(this).parents("li").hide().next().show();
    drawArc(ctx);
    if (msc.src.indexOf("cc_1234.mp3") == -1) {
        msc.src = "../assets/snd/cc_1234.mp3";
    } else {
        msc.currentTime = 0;
    }

    playMsc();
});

msc.addEventListener("ended", function() {
    if (msc.src.indexOf("cc_1234.mp3") > -1) {
        var $next = $(".J_playNext:visible");
        if ($next.length == 1) {
            $next.click();
        } else {
            drawArc(ctx);
            endTask();
        }
    } else {
        msc.src = "../assets/snd/cc_1234.mp3";
        playActionMsc();
    }
});

function playMsc() {
    msc.volume = 1;
    if (audioArr && (mscList && (msc.src.indexOf("cc_1234.mp3") > -1))) {
        msc.src = audioArr[$("#J_stepTask > li:visible").index()];
        clearInterval(mscTimer);
        msc.play();
    } else {
        msc.src = "../assets/snd/cc_1234.mp3";
        playActionMsc();
    }
}

function playActionMsc() {
    msc.play();
    clearInterval(mscTimer);
    mscTimer = setInterval(function() {
        drawArc(ctx, msc.currentTime/(msc.duration - 2));
    }, 1000);
}

function hideMask() {
    $("#taskMask").hide();
}

function drawArc(ctx, rate) {
    // 开始一条新路径
    ctx.beginPath();
    // 位移到圆心，方便绘制
    //ctx.translate(50, 50);
    // 移动到圆心
    ctx.clearRect(0,0,100,100);
    if (rate) {
        ctx.moveTo(50, 50);
        // 绘制圆弧
        ctx.arc(50,50,25, -(0.5) * Math.PI, ((Math.PI * 2)) * rate - 0.5 * Math.PI );
        // 闭合路径
        ctx.closePath();
        ctx.fillStyle = "#0493cd";
        ctx.fill();
    }
}

function endTask() {
    //alert("End");
}
