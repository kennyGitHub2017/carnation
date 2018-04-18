/**
 * Created by thh on 15/6/4.
 */

function scaleStyle (o,n) {
    o.css({
        "-webkit-transform": "scale(" + n + "," + n +")",
        "transform": "scale(" + n + "," + n +")",
        "margin-top": o.height() * ((n - 1) / 2),
        "margin-bottom": o.height() * ((n - 1) / 2),
        "margin-left": o.width() * ((n - 1) / 2)
    })
}
scaleStyle($("#modelTouch"), $(window).width() / 640);


$.each($("area") ,function(n, e) {
    $(e)[0].addEventListener('touchstart', function(e) {
        e.preventDefault()
        $("#" + $(e.target).attr("wid")).show();
    });
    $(e)[0].addEventListener('touchend', function(e) {
        e.preventDefault()
        $("#" + $(e.target).attr("wid")).hide();
    });
});

