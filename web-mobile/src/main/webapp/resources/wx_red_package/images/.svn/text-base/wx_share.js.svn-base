

/**微信初始化配置
 *appId     微信公众帐号id
 *timestamp 创建时间
 *nonceStr  UUID随机码
 *signature 签名
 */
function wxConfig(appId,timestamp,nonceStr,signature){ 
	
	 wx.config({
	        debug: false,
	        appId: appId,
	        timestamp: timestamp,
	        nonceStr: nonceStr,
	        signature: signature,
	        jsApiList: [
	         'checkJsApi',
	          'onMenuShareTimeline',
	          'onMenuShareAppMessage'
	        ]
	    });
}


 
/**微信分享设置
 * title 标题
 * desc  正文内容
 * link  链接
 * imgUrl  分享图标
 */
function wxReady(title,desc,link,imgUrl){
	
	wx.ready(function () {
	    //分享给朋友
        wx.onMenuShareAppMessage({
    	   title: title,
           desc: desc,
           link: link,
           imgUrl: imgUrl,
            trigger: function (res) {
            },
            success: function (res) {
            },
            cancel: function (res) {
            },
            fail: function (res) {
            }
        });
		
        //分享到朋友圈
		wx.onMenuShareTimeline({
			 title: title,
	         desc: desc,
	         link: link,
	         imgUrl: imgUrl,
			success: function () { 
				// 用户确认分享后执行的回调函数
			},
			cancel: function () { 
				// 用户取消分享后执行的回调函数
			}
		});
		
		//分享到QQ
		wx.onMenuShareQQ({
			 title: title,
	         desc: desc,
	         link: link,
	         imgUrl: imgUrl,
		    success: function () { 
		       // 用户确认分享后执行的回调函数
		    },
		    cancel: function () { 
		       // 用户取消分享后执行的回调函数
		    }
		});
		
		//分享到腾讯微博
		wx.onMenuShareWeibo({
			 title: title,
	         desc: desc,
	         link: link,
	         imgUrl: imgUrl,
		    success: function () { 
		       // 用户确认分享后执行的回调函数
		    },
		    cancel: function () { 
		        // 用户取消分享后执行的回调函数
		    }
		});
		
		//分享到QQ空间
		wx.onMenuShareQZone({
			 title: title,
	         desc: desc,
	         link: link,
	         imgUrl: imgUrl,
		    success: function () { 
		       // 用户确认分享后执行的回调函数
		    },
		    cancel: function () { 
		        // 用户取消分享后执行的回调函数
		    }
		});
	
		
    });
	
    wx.error(function (res) {
    	//alert('xx' + res);
    });
}