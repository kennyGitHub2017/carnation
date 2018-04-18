/**
 * Created by thh on 15/6/15.
 */


var xPos = 5;
var yPos = document.body.clientHeight;
var step = 1;
var delay = 40;
var height = 0;
var Hoffset = 0;
var Woffset = 0;
var yon = 0;
var xon = 0;
var pause = true;
var interval;
var $img = $("#ball")

$img.css("top", 408);
function changePos(isVertical) {
    width = $(window).width();
    height = $(window).height();
    Hoffset = 30;
    Woffset = 30;

    $img.css({
        left: xPos + document.body.scrollLeft,
        top: yPos + document.body.scrollTop
    });

    if (isVertical) {
        if (yon) {
            yPos = yPos + step + 3;
        }
        else {
            yPos = yPos - step - 3;
        }
    } else {
        if (yon) {
            yPos = yPos + step;
        }
        else {
            yPos = yPos - step;
        }
    }
    if (yPos < 0) {
        yon = 1;
        yPos = 0;
    }
    if (yPos >= (height - Hoffset)) {
        yon = 0;
        yPos = (height - Hoffset);
    }
    if (!isVertical) {
        if (xon) {
            xPos = xPos + step + 4;
        }
        else {
            xPos = xPos - step - 4;
        }
    } else {
        if (xon) {
            xPos = xPos + step + 0.2;
        }
        else {
            xPos = xPos - step - 0.2;
        }
    }

    if (xPos < 0) {
        xon = 1;
        xPos = 0;
    }
    if (xPos >= (width - Woffset)) {
        xon = 0;
        xPos = (width - Woffset);
    }
}
function start(isVertical) {
    $img.css({visibility: "visible"});
    interval = setInterval(function() {
        changePos(isVertical);
    }, delay);
}
