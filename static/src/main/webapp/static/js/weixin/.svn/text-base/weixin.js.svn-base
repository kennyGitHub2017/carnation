/*
var wxDefault = {
    title: '明星给我发红包啦，好开心噻！',
    desc: '什么情况啊，竟然有明星给我发红包！！！开心死了好吗！！！',
    link:"http://dd252.hecoe.com/market/stars1116/index.html",
    imgUrl:"http://dd252.hecoe.com/market/stars1116/images/head3.jpg",
    success: function () {
		_czc.push(["_trackEvent", "微信", "分享", "成功回调", 1, "moment1"]);
    }
};
wxShare();

function updateShareContent(randoS,nameArray)
{
	wxDefault = {
		link: "http://dd252.hecoe.com/market/stars1116/index.html",   //分享出去后落地页的链接
		imgUrl: "http://dd252.hecoe.com/market/stars1116/images/head"+randoS+".jpg",  //分享出去时的ICON 180*180的尺寸
		title: nameArray[randoS-1]+'微信聊天记录被曝光！',   //分享出去时文案标题
		desc: '太不可思议了！'+nameArray[randoS-1]+'在微信里边竟然说的是这些！',   //分享出去时文案描述
		success: function () {
		}
	};
	wxShare();
}


$(function(){
    var pageUrl = location.href;
    $.ajax({
        url:"http://api.hecoe.com/wx/index.php?w=jssdk",
        dataType:"jsonp",
        jsonp:"jsoncallback",
        data:{url:encodeURIComponent(pageUrl)},
        success:function(data){
            data.debug = false;
            wx.config(data);
            wx.ready(function(){
                wxShare();
            });
        }
    })
});

function wxShare(data){
    if(typeof(wx) == "undefined"){
        return;
    }
    var newData = $.extend({},wxDefault, data);
    wx.onMenuShareAppMessage(newData);
    wx.onMenuShareQQ(newData);
    wx.onMenuShareWeibo(newData);
    wx.onMenuShareTimeline({
        title:newData.title,
        imgUrl:newData.imgUrl,
        link:newData.link,
        success: newData.success
    });
}*/



function updateShareContent(randoS,nameArray)
{
	share_data = {
		share_url: "http://www.libt.cn/weixin/index.html",   //分享出去后落地页的链接
		share_icon_url: "http://www.libt.cn/weixin/images/shareico1.jpg",  //分享出去时的ICON 180*180的尺寸
		share_img_url: "http://www.libt.cn/weixin/images/shareico1.jpg",   //这个同上
		share_title: '云尚•云尚给您发红包啦！',   //分享出去时文案标题
		share_content: '云尚一大波红包袭来，快点开看看',   //分享出去时文案描述
		share_from: "云尚•云尚"
	};
	didi.initShare(share_data);  //端内分享
	weixin.initShare(share_data);  //微信分享
}
var share_data = {
	share_url: "http://www.libt.cn/weixin/index.html",   //分享出去后落地页的链接
	share_icon_url: "http://www.libt.cn/weixin/images/shareico1.jpg",  //分享出去时的ICON 180*180的尺寸
	share_img_url: "http://www.libt.cn/weixin/images/shareico1.jpg",   //这个同上
	share_title: "云尚•云尚给您发红包啦！",   //分享出去时文案标题
	share_content: '云尚一大波红包袭来，快点开看看',   //分享出去时文案描述
	share_from: "云尚•云尚"
};
didi.initShare(share_data);  //端内分享
weixin.initShare(share_data);  //微信分享

