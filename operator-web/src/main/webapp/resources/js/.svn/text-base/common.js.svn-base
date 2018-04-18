/**
 * Created by thh on 15/9/6.
 */

;(function($) {

    $.fn.countdown = function(o) {
        var opts = $.extend({
            time: 60000,
            text: "$time秒后重新发送",
            init: function() {},
            callback: function() {}
        }, o || {});
        this.each(function() {
            var $this = $(this), html = $this.html(), nTime = opts.time/1000, timer;
            $this.attr("disabled", true);
            opts.init.call($this);
            timer = setInterval(function() {
                nTime--;
                if (nTime == 0) {
                    $this.removeAttr("disabled").html(html);
                    clearInterval(timer);
                    opts.callback.call($this);
                } else {
                    $this.html(function() {
                        if (/\$time/.test(opts.text)) {
                            return opts.text.replace("$time", nTime);
                        } else {
                            return nTime + opts.text;
                        }
                    });
                }
            }, 1000);
        });
    };

})(jQuery);

function gotoPage(n){
	jQuery("#currentPage").val(n);
	jQuery("#searchForm").submit();
}

function changeAction(action)
{
	jQuery("#searchForm").attr("action", action);
	jQuery("#searchForm").submit();
}