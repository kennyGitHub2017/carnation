/**
 * Created by thh on 15/6/15.
 */

var ctx = document.getElementById('pCanvas').getContext('2d');

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

function getQueryPar(name) {
	   var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
	   var r = window.location.search.substr(1).match(reg);
	   if (r!=null) return (r[2]); return null;
}
