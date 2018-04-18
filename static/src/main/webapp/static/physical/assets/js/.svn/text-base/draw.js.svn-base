/**
 * Created by JG-yes on 2016/2/26.
 */


var tScale  = window.devicePixelRatio,
    tWidth=	jgGlobal.screenWidth,
    tHeight=jgGlobal.screenHeight;

function draw(id,dataArr,min,middle,max,lineColor,distance,str,danwei){
    var canvas=document.getElementById(id),
        ctx=canvas.getContext("2d");
    canvas.style.width = tWidth + "px";
    canvas.style.height =  "150px";
    canvas.width = tWidth * tScale;
    canvas.height = 150 * tScale;
    ctx.translate(0,150*tScale);
    drawlinegrid(ctx);
    drawNum(ctx,min,middle,max,danwei);
    drawHline(ctx,min,dataArr,lineColor,distance,str);
}
function drawlinegrid(ctx) {
    ctx.beginPath();
    for (var i = 0; i <= 6; i++) {
        var y = i * tWidth * 0.7 / 6 + 0.3 * tWidth / 2;
        ctx.moveTo(y * tScale, 0);
        ctx.lineTo(y * tScale, -150 * tScale);
    }
    ctx.moveTo(0, 0);
    ctx.lineTo(tWidth * tScale, 0);
    ctx.lineWidth = 1 * tScale;
    ctx.strokeStyle = "#d4d3d3";
    ctx.stroke();
}
function drawNum(ctx,min,middle,max,danwei){
    ctx.beginPath();
    ctx.fillStyle="#999";
    ctx.font=12*tScale + "px Arial";
    ctx.textAlign="center";
    ctx.textBaseline="bottom";
    ctx.fillText(min,0.3 * tWidth / 4*tScale,0);
    ctx.fillText(middle,0.3 * tWidth / 4*tScale,-65*tScale);
    if(typeof danwei=="string"){
        ctx.fillText(danwei,0.3 * tWidth / 4*tScale,-115*tScale);
    }
    ctx.fillText(max,0.3 * tWidth /4*tScale,-130*tScale);
}

function drawHline(ctx,min,dataH,lineColor,distance,str){
    var pointsH = [];
    for( var i=0; i < dataH.length; i++){
        var v= dataH[i];
        var px = i * tWidth * 0.7 / 6 + 0.3 * tWidth / 2;
        var py = (v-min)/distance*150;
        pointsH.push({"x":px*tScale,"y":-py*tScale});
    }
    ctx.beginPath();

    ctx.moveTo(pointsH[0].x, pointsH[0].y);
    for(var i= 1; i< pointsH.length; i++){
        ctx.lineTo(pointsH[i].x,pointsH[i].y);
    }
    ctx.lineWidth = 2*tScale;
    ctx.strokeStyle = lineColor;
    ctx.stroke();

    ctx.font=11*tScale + "px Arial";
    ctx.textAlign="center";
    ctx.textBaseline="bottom";
    for(var i=0;i<pointsH.length;i++){
        ctx.beginPath();
        ctx.fillStyle=lineColor;
        ctx.fillText(dataH[i]+str,pointsH[i].x, pointsH[i].y-10*tScale);
        ctx.arc(pointsH[i].x,pointsH[i].y,3*tScale,0,2*Math.PI,false);
        ctx.fill();
    }

}