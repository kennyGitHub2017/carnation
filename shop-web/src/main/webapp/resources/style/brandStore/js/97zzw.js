$(function(){
$(window).bind('scroll', {
    fixedOffsetBottom: parseInt($('#Fixed').css('bottom'))
},
function(e) {
    var scrollTop = $(window).scrollTop();
    var referFooter =$('#newBottomHtml');
/*    scrollTop > 100 ? $('#goTop').show() : $('#goTop').hide();
*/    if (!/msie 6/i.test(navigator.userAgent)) {
        if ($(window).height() - (referFooter.offset().top - $(window).scrollTop()) > e.data.fixedOffsetBottom) {
            $('#Fixed').css('bottom', $(window).height() - (referFooter.offset().top - $(window).scrollTop()))
        } else {
            $('#Fixed').css('bottom', e.data.fixedOffsetBottom)
        }
    }
});
$('#goTop').click(function() {
    $('body,html').stop().animate({
        'scrollTop': 0,
        'duration': 100,
        'easing': 'ease-in'
    })
});
});
/*
本代码由97站长网收集并编辑整理;
尊重他人劳动成果;
转载请保留97站长网链接 - www.97zzw.com
*/