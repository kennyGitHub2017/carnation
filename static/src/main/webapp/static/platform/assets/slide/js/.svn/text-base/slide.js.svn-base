$.Slider = function (a) {
    if (!(this instanceof arguments.callee))return new arguments.callee(a);
    this.init.apply(this, arguments)
};
$.Slider.prototype = {constructor: $.Slider, init: function (a) {
    var b = this;
    $.extend(this, {wrap: null, effect: "opacity", interval: 5E3, fxTime: 450, easeing: "easeOutBounce", event: "mouseover", selectedClass: "current", countClass: "count", position: "", auto: !0, callback: $.noop}, a || {});
    this.wrap.length && (this.ul = this.wrap.find("ul:first-child"), this.list = this.wrap.find("li"), 1 >= this.list.length || (this.index = 0, this.autoTimer = null, this.creatBtn(), this.btn = this.count.find("li"), this.run(), this.autoTimer = setInterval(function () {
        b.auto &&
        b.next()
    }, b.interval), this.wrap.bind("mouseover", function () {
        clearInterval(b.autoTimer)
    }).bind("mouseout", function () {
        b.autoTimer = setInterval(function () {
            b.auto && b.next()
        }, b.interval)
    }), this.btn.bind(b.event, function () {
        b.index = b.btn.index(this);
        b.run()
    })))
}, creatBtn: function () {
    this.count = $("<ul></ul>");
    var a = document.createDocumentFragment();
    this.count.addClass(this.countClass).addClass(this.position);
    for (var b = 0, c = this.list.length; b < c; b++) {
        var e = document.createElement("li");
        e.innerHTML = b + 1;
        a.appendChild(e)
    }
    this.count.append(a);
    this.wrap.append(this.count)
}, run: function () {
    this.btn.eq(this.index).addClass(this.selectedClass).siblings().removeClass(this.selectedClass);
    this.callback && this.callback.call(this, this.index);
    this.doMove()
}, next: function () {
    this.index++;
    this.index === this.btn.length && (this.index = 0);
    this.run()
}, doMove: function () {
    if ("opacity" === this.effect)this.list.stop(!1, !0).css({top: "0", left: "0", zIndex: "1"}).eq(this.index).css({zIndex: "9"}).animate({opacity: "show"}, {duration: this.fxTime, easing: this.easing,
        complete: function () {
            $(this).css("position", "relative").siblings().css("position", "absolute").hide()
        }}); else {
        var a = "xScroll" === this.effect ? "left" : "top", b = "xScroll" === this.effect ? this.list.eq(0).width() : this.list.eq(0).height(), c = {};
        c[a] = -b * this.index;
        this.ul.css({position: "absolute"}).stop(!1, !0).animate(c, {duration: this.fxTime, easing: this.easing})
    }
}};

jQuery.extend(jQuery.easing, {easeIn: function (a, b, c, e, d) {
    return jQuery.easing.easeInQuad(a, b, c, e, d)
}, easeOut: function (a, b, c, e, d) {
    return jQuery.easing.easeOutQuad(a, b, c, e, d)
}, easeInOut: function (a, b, c, e, d) {
    return jQuery.easing.easeInOutQuad(a, b, c, e, d)
}, expoin: function (a, b, c, e, d) {
    return jQuery.easing.easeInExpo(a, b, c, e, d)
}, expoout: function (a, b, c, e, d) {
    return jQuery.easing.easeOutExpo(a, b, c, e, d)
}, expoinout: function (a, b, c, e, d) {
    return jQuery.easing.easeInOutExpo(a, b, c, e, d)
}, bouncein: function (a, b, c, e, d) {
    return jQuery.easing.easeInBounce(a,
        b, c, e, d)
}, bounceout: function (a, b, c, e, d) {
    return jQuery.easing.easeOutBounce(a, b, c, e, d)
}, bounceinout: function (a, b, c, e, d) {
    return jQuery.easing.easeInOutBounce(a, b, c, e, d)
}, elasin: function (a, b, c, e, d) {
    return jQuery.easing.easeInElastic(a, b, c, e, d)
}, elasout: function (a, b, c, e, d) {
    return jQuery.easing.easeOutElastic(a, b, c, e, d)
}, elasinout: function (a, b, c, e, d) {
    return jQuery.easing.easeInOutElastic(a, b, c, e, d)
}, backin: function (a, b, c, e, d) {
    return jQuery.easing.easeInBack(a, b, c, e, d)
}, backout: function (a, b, c, e, d) {
    return jQuery.easing.easeOutBack(a,
        b, c, e, d)
}, backinout: function (a, b, c, e, d) {
    return jQuery.easing.easeInOutBack(a, b, c, e, d)
}});

new $.Slider({wrap:$("#oScroll-box"),
    effect:"opacity",easeing:"easeOutBounce"});