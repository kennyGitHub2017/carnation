/**
 * Created by thh on 15/6/5.
 */

var scale = $(window).width() / 640;
function scaleStyle (o,arr,callbcak) {
    var wid = o.attr("wid"), arrPos, n = scale;
    o.css({
        "-webkit-transform": "scale(" + n + "," + n +")",
        "transform": "scale(" + n + "," + n +")",
        "margin-top": o.height() * ((n - 1) / 2),
        "margin-bottom": o.height() * ((n - 1) / 2),
        "margin-left": o.width() * ((n - 1) / 2)
    })

    arrPos = setArrPosition(arr, n);

    document.addEventListener('touchmove', function(e) {
        overFace(e, wid, arrPos);
    });
    document.addEventListener('touchstart', function(e) {
        overFace(e, wid, arrPos);
    });
    document.addEventListener('touchend', function(e) {
        e.preventDefault();
        var $over = $(".overItem");
        if ($over.length > 0) {
        	callbcak.call();
            $over.removeClass("overItem");
        }
    });
}

function isInner(x, y, arr) {
    for (o in arr) {
        if (arr.hasOwnProperty(o)) {
            var pos = arr[o];
            if ((pos[0] < x && x < pos[1]) && (pos[2] < y && y < pos[3])) {
                return o;
            }
        }
    }
}

function setArrPosition(o, scale) {
    var arrPos = {};
    for (n in o) {
        if (o.hasOwnProperty(n)) {
            var $dom =o[n], pos = $dom.offset();
            arrPos[n] = [pos.left, pos.left + $dom.width() * scale, pos.top, pos.top + $dom.height() * scale];
        }
    }
    return arrPos;
}

function overFace (e, t, arrPosition) {
    e.preventDefault();
    var _isInner = isInner(e.touches[0].clientX,e.touches[0].clientY,arrPosition);
    $(".overItem").removeClass("overItem");
    if (_isInner) {
        $(t + _isInner).addClass("overItem");
    }
}
