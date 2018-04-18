(function (window) {
        var default_data = {
            share_url: "http://www.libt.cn/weixin/index.html",
            share_icon_url: "http://www.libt.cn/weixin/images/shareico1.jpg",
            share_img_url: "http://www.libt.cn/weixin/images/shareico1.jpg",
            share_title: "云尚•云尚给您发红包啦！",
            share_content: "云尚一大波红包袭来，快点开看看",
            share_from: ""
        };
        var connectDidiJSBridge = function(callback) {
                if (window.DidiJSBridge) {
                    callback(DidiJSBridge)
                } else {
                    document.addEventListener("DidiJSBridgeReady", function() {
                            callback(DidiJSBridge)
                        }
                        , false)
                }
            }
            ;
        var didi = {
            initShare: function(shareData, callback) {
                if (!shareData) {
                    shareData = default_data
                }
                if (typeof callback !== "function") {
                    callback = function() {}
                }
                var entranceCfg = {
                    entrance: {
                        icon: "http://www.libt.cn/weixin/images/shareico1.jpg"
                    },
                    buttons: [{
                        type: "share_weixin_timeline",
                        name: "微信朋友圈",
                        data: shareData,
                        callback: callback
                    }, {
                        type: "share_weixin_appmsg",
                        name: "微信好友",
                        data: shareData,
                        callback: callback
                    }, {
                        type: "share_sina_weibo",
                        name: "新浪微博",
                        data: shareData,
                        callback: callback
                    }, {
                        type: "page_refresh",
                        name: "刷新"
                    }]
                };
                connectDidiJSBridge(function(bridge) {
                        if (typeof bridge === "undefined") {
                            return
                        }
                        bridge.callHandler("init_entrance", JSON.stringify(entranceCfg));
                        bridge.callHandler("show_entrance")
                    }
                )
            }
        };
        window.didi = didi;


        var weixin = {
            initShare: function(shareData) {
                if (!shareData) {
                    shareData = default_data
                }

                document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {

                    WeixinJSBridge.on('menu:share:appmessage', function(argv) {
                        WeixinJSBridge.invoke('sendAppMessage', {
                            "appid": "wxd6a1ee2bf44fe12c",
                            "img_url": shareData.share_icon_url,
                            "img_width": "",
                            "img_height": "",
                            "link": shareData.share_url,
                            "title": shareData.share_title,
                            "desc": shareData.share_content
                        }, function(res) {

                        });
                    });
                    // 分享到朋友圈
                    WeixinJSBridge.on('menu:share:timeline', function(argv) {

                        WeixinJSBridge.invoke('shareTimeline', {
                            "img_url": shareData.share_icon_url,
                            "img_width": "",
                            "img_height": "",
                            "link": shareData.share_url,
                            "title": shareData.share_title,
                            "desc": shareData.share_content
                        }, function(res) {

                        });
                    });
                });
            }


        };

        window.weixin = weixin;

    }
)(window);
