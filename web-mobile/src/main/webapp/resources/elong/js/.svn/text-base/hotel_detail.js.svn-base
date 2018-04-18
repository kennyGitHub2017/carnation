$(function(){
    function getQueryPar(name) {
 	   var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
 	   var r = window.location.search.substr(1).match(reg);
 	   if (r!=null) return (r[2]); return null;
 	}
    //分享
   	var shareObj={
    	title:$("#hotelname").val(),
    	desc:'价格优惠，评价真实！无论您要高端大气还是低调奢华，总有1间适合您！',
    	imgUrl:$("#hotelphoto").val(),
    	link:location.href,
    	success:function(){
    		
    	},
    	cancel:function(){
    		
    	}
    }

	
	var isApp=getQueryPar("ysysgo_app");
   	
   	var	mobileType=(function(){
		var u = navigator.userAgent, app = navigator.appVersion;
        isAndroid = u.indexOf('Android') > -1 || u.indexOf('Linux') > -1; //android终端或者uc浏览器
        isiOS = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/); //ios终端
        return{
        	isAndroid:isAndroid,
        	isIos:isiOS
        }
	})();
   	
   	var isAndroid=mobileType.isAndroid;
    var isIos=mobileType.isIos;

	$("#share_btn").on('touchstart',function(){
    	//if(isApp=='true'){
    		if(isAndroid){
    			java.requestCommonShare(shareObj.title,shareObj.desc,shareObj.imgUrl,shareObj.link);
    		}else if(isIos){
    			requestCommonShare(shareObj);
    		}
    	//}
    });
	
	$("#appMap").tap(function(){
		if(isAndroid){
			java.callAppMap($("#tLatitude").val(),$("#longitude").val(),$("#hotelname").val(),$("#address").val());
		}else if(isIos){
			callAppMap($("#tLatitude").val(),$("#longitude").val(),$("#hotelname").val(),$("#address").val());
		}
	});
	
	//住客评价
	$(".titles ul li:nth-child(1)").tap(function(){
		if($(this).hasClass('active')) return;
		$(this).addClass("active").siblings().removeClass("active");
		$(this).parent('ul').next('span.line').removeClass('left');
		$(".tabcomment").show();
		$(".tabdetails").hide();
		
	});

	//酒店详情
	$(".titles ul li.hoteldetail").tap(function(event) {
		if($(this).hasClass('active')) return;
		$(this).addClass("active").siblings().removeClass("active");
		$(this).parent('ul').next('span.line').addClass('left');
		$(".tabcomment").hide();
		$(".tabdetails").show();

	});

	//筛选
	$(".fastchoose .choice ").tap(function(event){
		/*$(".ios.iphone").css('overflow', 'hidden');
		$(".bar.stickys").css({"display":"block","top":"44px"});
		$(".page-content.new_detailst").addClass('weixin-overflowhidden');
		$(this).addClass('tjclick').addClass('arrowon');
		$(".weixin-custom-mask").show();
		$(".detail-filter").show();*/
	});

	//酒店详情中间的列表
	$(".type ul li:not([class^='rec_hotel']) div.wrap").tap(function(){		
		$(this).parent().toggleClass("on");
	});
	
	//点击预订
	$(".type ul li:not([class^='rec_hotel']) .info-list ul li.roomdetail").tap(function(){		
		var indate=$(".getin_room_a .indate").html();
		var outdate=$(".getin_room_a .outdate").html();
		location.href=$(this).attr("url")+"&arrivalDate="+indate+"&departureDate="+outdate;
	});
	//酒店详情图片
	$(".pic-wrap").tap(function(){
		$(".page").addClass('page-on-center').addClass('page-form-left');
		setTimeout(function(){
			$(".page").removeClass("plugin-show").removeClass("page-form-left");
		},230);
	});

	$(".cld").show();
	initCLD();
    $(".cld .icon-back").tap(function(){
    	$("html").css("overflow","auto");
    	toBottom($(".cld")[0]);
    });
	
	$(".stickys.indexnew.sticky").tap(function(){
		$("html").css("overflow","hidden");    	
    	toCenter($(".cld")[0]); 
	});
	
});