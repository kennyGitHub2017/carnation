;
function selectAll(obj) {
    var status = jQuery(obj).attr("checked");
    var id = jQuery(obj).attr("id");
    if (status == "checked") {
        jQuery("#ListForm").find(":checkbox[id!=" + id + "]").attr("checked", "checked")
    } else {
        jQuery("#ListForm").find(":checkbox[id!=" + id + "]").attr("checked", false)
    }
}
function cmd() {
    var url = arguments[0];
    var mulitId = "";
    jQuery("#ListForm").find(":checkbox:checked").each(function() {
        if (jQuery(this).val() != "") {
            mulitId += jQuery(this).val() + ","
        }
    });
    if (mulitId != "") {
        jQuery("#ListForm #mulitId").val(mulitId);
        if (confirm(decodeURIComponent("%E7%A1%AE%E5%AE%9A%E8%A6%81%E6%89%A7%E8%A1%8C%E8%AF%A5%E6%93%8D%E4%BD%9C%EF%BC%9F"))) {
            jQuery("#ListForm").attr("action", url);
            jQuery("#ListForm").submit()
        }
    } else {
        alert("至少选择一条数据记录")
    }
}
function getFullPath(obj) {
    if (obj) {
        if (window.navigator.userAgent.indexOf("MSIE") >= 1) {
            obj.select();
            if (window.navigator.userAgent.indexOf("MSIE") == 25) {
                obj.blur()
            }
            return document.selection.createRange().text
        } else if (window.navigator.userAgent.indexOf("Firefox") >= 1) {
            if (obj.files) {
                return window.URL.createObjectURL(obj.files.item(0))
            }
            return obj.value
        }
        return obj.value
    }
}
function query() {
    jQuery("#queryCondition").empty();
    jQuery.each(jQuery("#queryForm :input"),
    function() {
        if (this.type != "button" && this.value != "") {
            jQuery("#queryCondition").append("<input name='q_" + this.name + "'type='hidden' id='q_" + this.name + "' value='" + this.value + "' />")
        }
    });
    jQuery("#ListForm").submit()
}
function gotoPage(n) {
    jQuery("#currentPage").val(n);
    jQuery("#ListForm").submit()
}
function tipStyle() {
    if (jQuery.isFunction(jQuery().poshytip)) {
        jQuery("input[title!='']").poshytip({
            className: 'tip-skyblue',
            timeOnScreen: 2000,
            alignTo: 'cursor',
            alignX: 'right',
            alignY: 'bottom',
            offsetX: 3,
            offsetY: 3
        });
        jQuery("img[title!='']").poshytip({
            className: 'tip-skyblue',
            timeOnScreen: 2000,
            alignTo: 'cursor',
            alignX: 'right',
            alignY: 'bottom',
            offsetX: 3,
            offsetY: 3
        });
        jQuery("a[title!='']").poshytip({
            className: 'tip-skyblue',
            timeOnScreen: 2000,
            alignTo: 'cursor',
            alignX: 'right',
            alignY: 'bottom',
            offsetX: 3,
            offsetY: 3
        });
        jQuery("textarea[title!='']").poshytip({
            className: 'tip-skyblue',
            timeOnScreen: 2000,
            alignTo: 'cursor',
            alignX: 'right',
            alignY: 'bottom',
            offsetX: 3,
            offsetY: 3
        })
    }
}
var alert_timer_id;
function showDialog() {
    var id = arguments[0];
    var title = arguments[1];
    var content = arguments[2];
    var type = arguments[3];
    var icon = arguments[4];
    var second = arguments[5];
    var confirm_action = arguments[6];
    var back_function_args = arguments[7];
    if (id == undefined || id == "") {
        id = 1
    }
    if (title == undefined || title == "") {
        title = decodeURIComponent("%E7%B3%BB%E7%BB%9F%E6%8F%90%E7%A4%BA");
    }
    if (type == undefined || type == "") {
        type == 0
    }
    if (icon == undefined || icon == "") {
        icon = "succeed"
    }
    if (second == undefined || second == "") {
        second = 5
    }
    var s = "<div id='" + id + "'><div class='message_white_content'> <a href='javascript:void(0);' class='white_close' onclick='javascript:jQuery(\"#" + id + "\").remove();'></a><div><div class='message_white_iframe'><h3 class='message_white_title'><span>" + title + "</span></h3><div class='message_white_box'><span class='message_white_img_" + icon + "'></span><span class='message_white_font'>" + content + "</span></div><h3 class='message_white_title_bottom'><span id='time_down'>" + second + "</span>"+decodeURIComponent("%E7%A7%92%E5%90%8E%E7%AA%97%E5%8F%A3%E5%85%B3%E9%97%AD")+"</h3></div></div></div><div class='black_overlay'></div>";
    var c = "<div id='" + id + "'><div class='message_white_content'> <a href='javascript:void(0);' class='white_close' onclick='javascript:jQuery(\"#" + id + "\").remove();'></a><div ><div class='message_white_iframe_del'><h3 class='message_white_title'><span>" + title + "</span></h3><div class='message_white_box_del'><span class='message_white_img_" + icon + "'></span><span class='message_white_font' style='font-size:14px;'>" + content + "</span></div>   <div class='message_white_box1'><input id='sure' type='button' value="+decodeURIComponent('%E7%A1%AE%E5%AE%9A')+"><input id='cancel' type='button' value="+decodeURIComponent('%E5%8F%96%E6%B6%88')+"></div>    </div></div></div><div class='black_overlay'></div>";
    var t = "<div id='" + id + "'><div class='message_white_content'> <a href='javascript:void(0);' class='white_close' onclick='javascript:jQuery(\"#" + id + "\").remove();'></a><div ><div class='message_white_iframe_del'><h3 class='message_white_title'><span>" + title + "</span></h3><div class='message_white_box_del'><span class='message_white_img_" + icon + "'></span><span class='message_white_font' style='font-size:14px;'>" + content + "</span></div>   <div class='message_white_box2'><input id='ok' type='button' value="+decodeURIComponent('%E7%A1%AE%E5%AE%9A')+"></div></div></div></div><div class='black_overlay'></div>";
    var inp = "<div id='" + id + "'><div class='message_white_content'> <a href='javascript:void(0);' class='white_close' onclick='javascript:jQuery(\"#" + id + "\").remove();'></a><div ><div class='message_white_iframe_del'><h3 class='message_white_title'><span>" + title + "</span></h3><div><input id='input_enter' style='width: 382px;margin-top: 20px;margin-bottom: 20px;' /></div>   <div class='message_white_box1'><input id='sure' type='button' value="+decodeURIComponent('%E7%A1%AE%E5%AE%9A')+"><input id='cancel' type='button' value="+decodeURIComponent('%E5%8F%96%E6%B6%88')+"></div>    </div></div></div><div class='black_overlay'></div>";
    if (type == 0) {
        jQuery("body").append(s)
    }
    if (type == 1) {
        jQuery("body").append(c)
    }
    if (type == 2) {
        jQuery("body").append(t)
    }
    if (type == 3) {
        jQuery("body").append(inp)
    }
    var top = jQuery(window).scrollTop() + (jQuery(window).height() - jQuery(document).outerHeight()) / 2;
    jQuery(".message_white_content").css("margin-top", jQuery(window).scrollTop() + "px");
    var h = jQuery(document).height();
    jQuery('.black_overlay').css("height", h);
    if (confirm_action == undefined || confirm_action == "") {
        alert_timer_id = window.setInterval("closewin('" + id + "','')", 1000)
    } else {
        if (back_function_args == undefined || back_function_args == "") {
            alert_timer_id = window.setInterval("closewin('" + id + "'," + confirm_action + ")", 1000)
        } else {
            alert_timer_id = window.setInterval("closewin('" + id + "'," + confirm_action + ",'" + back_function_args + "')", 1000)
        }
    }
    jQuery("#sure").click(function() {
        var inputValue = "";
        if (document.getElementById("input_enter")) {
            inputValue = jQuery("#input_enter").val()
        }
        jQuery("#" + id).remove();
        runcallback(confirm_action, inputValue)
    });
    jQuery("#ok").click(function() {
        jQuery("#" + id).remove();
        runcallback(confirm_action)
    });
    function runcallback(callback) {
        if (confirm_action != undefined && confirm_action != "") {
            if (back_function_args == undefined || back_function_args == "") {
                callback()
            } else if (back_function_args == "input") {
                callback(arguments[1])
            } else {
                callback(back_function_args)
            }
        }
    }
    jQuery("#cancel").click(function() {
        jQuery("#" + id).remove()
    });
    jQuery("a[id^=share_select_]").click(function() {
        jQuery("#share_select_mark").val(jQuery(this).attr("share_mark"));
        jQuery("#" + id).remove();
        runcallback(confirm_action)
    })
}
function closewin(id, callback, args) {
    var count = parseInt(jQuery("#" + id + " span[id=time_down]").text());
    count -= 1;
    if (count == 0) {
        window.clearInterval(alert_timer_id);
        if (callback != "") {
            if (args == undefined || args == "") {
                callback()
            } else {
                callback(args)
            }
        } else {
            jQuery("#" + id).remove()
        }
    } else {
        jQuery("#" + id + " span[id=time_down]").text(count)
    }
}
function open_im() {
    var goods_id = arguments[0];
    var url = arguments[1];
    var type = arguments[2];
    var to_type = arguments[3];
    var store_id = arguments[4];
    if (type == "store") {
        window.open(url + "/store_chatting.htm", 'store', 'height=660,width=1000,top=200,left=400,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no')
    }
    if (type == "user") {
        window.open(url + "/user_chatting.htm?gid=" + goods_id + "&type=" + to_type + "&store_id=" + store_id, '', 'height=660,width=1000,top=200,left=400,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no')
    }
    if (type == "plat") {
        window.open(url + "/admin/plat_chatting.htm", 'plat', 'height=660,width=1000,top=200,left=400,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no')
    }
}
jQuery(document).ready(function() {
    jQuery("span .w").mousemove(function() {
        var id = jQuery(this.parentNode).attr("id");
        if (id = "nothis") {
            jQuery(this.parentNode).attr("id", "this")
        }
    }).mouseout(function() {
        var id = jQuery(this.parentNode).attr("id");
        if (id = "this") {
            jQuery(this.parentNode).attr("id", "nothis")
        }
    });
    tipStyle();
    jQuery("a[dialog_uri],input[dialog_uri],dt[dialog_uri]").on("click",
    function(e) {
        var dialog_uri = jQuery(this).attr("dialog_uri");
        var dialog_title = jQuery(this).attr("dialog_title");
        var dialog_id = jQuery(this).attr("dialog_id");
        var dialog_height = jQuery(this).attr("dialog_height");
        var dialog_width = jQuery(this).attr("dialog_width");
        var dialog_top = jQuery(this).attr("dialog_top");
        var dialog_left = 300;
        jQuery("#" + dialog_id).remove();
        if (dialog_uri != "undefined") {
            jQuery("body").append("<div id='" + dialog_id + "'><div class='white_content'> <a href='javascript:void(0);' dialog_uri='undefined' class='white_close' onclick='javascript:jQuery(\"#" + dialog_id + "\").remove();'></a><div class='white_box'><h1>" + dialog_title + "</h1><div class='content_load'></div></div></div><div class='black_overlay'></div></div>");
            e.preventDefault();
            var h = jQuery(document).height();
            jQuery('.black_overlay').css("height", h);
            var dialog_left = (jQuery(document).width() - dialog_width) / 2;
            jQuery.ajax({
                type: 'POST',
                url: dialog_uri,
                async: false,
                data: '',
                success: function(html) {
                    jQuery(".content_load").remove();
                    jQuery("#" + dialog_id + " .white_content").css("width", dialog_width).css("position", "absolute");
                    jQuery("#" + dialog_id + " .white_box h1").after(html);
                    jQuery("#" + dialog_id).show();
                    if (dialog_top == undefined || dialog_top == "") {
                        dialog_height = jQuery(".white_content").height();
                        dialog_top = jQuery(window).scrollTop() + jQuery(window).height() / 2 - dialog_height / 2
                    } else {
                        dialog_top = parseInt(dialog_top) + jQuery(window).scrollTop()
                    }
                    jQuery(".white_content").css("top", parseInt(dialog_top) + "px").css("left", parseInt(dialog_left) + "px")
                }
            });
            jQuery("#" + dialog_id + " .white_box h1").css("cursor", "move");
            jQuery("#" + dialog_id + " .white_content").draggable({
                handle: " .white_box h1"
            })
        }
    });
    jQuery("a[ck_dialog_uri],input[ck_dialog_uri],dt[ck_dialog_uri]").on("click",
    function(e) {
        var mulitId = "";
        jQuery("#ListForm").find(":checkbox:checked").each(function() {
            if (jQuery(this).val() != "") {
                mulitId += jQuery(this).val() + ","
            }
        });
        var dialog_uri = jQuery(this).attr("ck_dialog_uri");
        var dialog_title = jQuery(this).attr("ck_dialog_title");
        var dialog_id = jQuery(this).attr("ck_dialog_id");
        var dialog_height = jQuery(this).attr("ck_dialog_height");
        var dialog_width = jQuery(this).attr("ck_dialog_width");
        var dialog_top = jQuery(this).attr("ck_dialog_top");
        var dialog_left = 300;
        if (dialog_uri != undefined && dialog_uri != "") {
            if (mulitId != "") {
                jQuery("body").append("<div id='" + dialog_id + "'><div class='white_content'> <a href='javascript:void(0);' class='white_close' onclick='javascript:jQuery(\"#" + dialog_id + "\").remove();'></a><div class='white_box'><h1>" + dialog_title + "</h1><div class='content_load'></div></div></div><div class='black_overlay'></div></div>");
                e.preventDefault();
                if (dialog_top == undefined || dialog_top == "") {
                    dialog_top = jQuery(window).scrollTop() + (jQuery(window).height() - jQuery(document).outerHeight()) / 2 - dialog_height / 2;
                } else {
                    dialog_top = parseInt(dialog_top) + jQuery(window).scrollTop()
                }
                var h = jQuery(document).height();
                jQuery('.black_overlay').css("height", h);
                var dialog_left = (jQuery(document).width() - dialog_width) / 2;
                if (dialog_uri.indexOf("?") >= 0) {
                    dialog_uri = dialog_uri + "&mulitId=" + mulitId
                } else {
                    dialog_uri = dialog_uri + "?mulitId=" + mulitId
                }
                jQuery(".white_content").css("position", "absolute").css("top", parseInt(dialog_top) + "px").css("left", parseInt(dialog_left) + "px");
                jQuery.ajax({
                    type: 'POST',
                    url: dialog_uri,
                    async: false,
                    data: '',
                    success: function(html) {
                        jQuery(".content_load").remove();
                        jQuery("#" + dialog_id + " .white_content").css("width", dialog_width);
                        jQuery("#" + dialog_id + " .white_box h1").after(html);
                        jQuery("#" + dialog_id).show()
                    }
                });
                jQuery("#" + dialog_id + " .white_box h1").css("cursor", "move");
                jQuery("#" + dialog_id + " .white_content").draggable({
                    handle: " .white_box h1"
                })
            } else {
                alert("至少选择一条记录")
            }
        }
    });
});