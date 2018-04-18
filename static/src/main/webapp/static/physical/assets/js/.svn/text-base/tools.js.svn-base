/**
 * Created by JG-yes on 2016/2/29.
 */
document.writeln("<div class=\"smalltips\" id=\"smalltips\"></div>");
document.writeln("<div class=\"loading opacityModel\"></div>")
document.writeln("<div class=\"loading paying\"><div class=\"bg\"></div><span class=\"des\">加载中</span><span class=\"cirContainer\"><span class=\"cir fir\"></span><span class=\"cir\"></span><span class=\"cir\"></span></span></div>");

function tips(str) {
    if ($("#smalltips").css("opacity") != "0") return;
    $("#smalltips").css("z-index","999999999").html(str).css("margin-left",-$("#smalltips").innerWidth() / 2).animate({
        opacity:0.9,
        bottom: 80
    }, 500, 'easeOutBack', tipsend).css({ filter: "Alpha(Opacity=90)" });
}

function tipsend() {
    setTimeout(function () {
        $("#smalltips").css("opacity", 0).css("bottom", 0).css("z-index","-1").css("filter", "Alpha(Opacity=0)");
    }, 2500);
}