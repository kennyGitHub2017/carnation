
$(function(){
	
	initCLD();
    //选择城市
    $(".cityName").tap(function(){
    	$("html").css("overflow","hidden");
    	$(".advance-city").addClass("plugin-show").addClass("page-from-right-to-center").addClass("page-on-center");
    	setTimeout(function(){
    		$(".advance-city").removeClass("page-from-right-to-center");
    	},230);
    });
    $(".advance-city .icon-back").tap(function(){
    	$("#search_city").blur();
    	$("html").css("overflow","auto");
    	$(".advance-city").addClass("page-from-center-to-right").addClass("page-on-right");
    	setTimeout(function(){
    		$(".advance-city").removeClass("page-from-center-to-right").removeClass("plugin-show").removeClass("page-on-right");
    	},230);
    });
    //选择日期
    $(".cld").show();
    $(".searchMain .time").tap(function(){
    	$("html").css("overflow","hidden");    	
    	toCenter($(".cld")[0]);    	
    });
    $(".cld .icon-back").tap(function(){
    	$("html").css("overflow","auto");
    	toBottom($(".cld")[0]);
    });
    
    function resetPriceStar(){
    	$(".price-star-btn").removeClass("unon");
    	$(".price-star-btn .title-phone").html("价格星级");
    	$("ul.star-list li").eq(0).addClass("on").siblings("li").removeClass("on");
    	$("ul.price-list li").eq(0).addClass("on").siblings("li").removeClass("on");
    	$("#LowRate").val("");
    	$("#HighRate").val("");
    	$("#starval").val("");
    }
    
    $(".clearTxt").on('touchstart',function(e){
    	e.stopPropagation();
		$(this).hide();
		$(this).prev("input").val("");
		if($(this).attr("data-fn")=="price"){
			$("#starval").val('');
			$("#LowRate").val('');
			$("#HighRate").val('');
			resetPriceStar();
		}
	});
    
    $(".searchWords input").on("input",function(){
    	var val=$(this).val();
    	if(val!=""){
    		$(".searchWords .clearTxt").show();
    	}else{
    		$(".searchWords .clearTxt").hide();
    	}
    });
    
    $(document).on("touchstart",function(){
    	$(".searchWords input").blur();
    });
    $(".searchWords input").on('touchstart',function(e){
    	e.stopPropagation();
    });
    
    $(".searchBtn").on('touchstart',function(){
    	var webpath=$("#webpath").val();
    	var cityName=$("#cityName").html();
    	var StarRate=$("#starval").val();
    	var LowRate=$("#LowRate").val();
    	var HighRate=$("#HighRate").val();
    	var arrivalDate=$(".indate").attr("data-value");
    	var departureDate=$(".outdate").attr("data-value");
    	var queryText=$(".searchWords input").val();
    	var longitude=$("#longitude").val();
    	var latitude=$("#latitude").val();
    	location.href=webpath+"/v1/elong_hotel_list.htm?cityName="+cityName+"&longitude="+longitude+"&latitude="+latitude+"&StarRate="+StarRate+"&LowRate="+LowRate+"&HighRate="+HighRate+"&arrivalDate="+arrivalDate+"&departureDate="+departureDate+"&queryText="+queryText;
    });
    
        
    //价格星级
    var filterPriceStar=document.getElementById("filterPriceStar");
    $(".priceStar").tap(function(){
    	if(document.getElementById('mask-layer')){
    		$(".mask-layer").removeAttr('style');
    	}else{
    		$("<div id=\"mask-layer\" class=\"mask-layer\"></div>").appendTo($(".pages"));
    		$(".mask-layer").tap(function(){
	    		$(".mask-layer").hide();
	    		$('.filter-price-star').removeClass('filter-sp-active');
    		});
    	}
	    
    	$('.filter-price-star').addClass('plugin-show');
    	setTimeout(function(){
    		$('.filter-price-star').addClass('filter-sp-active');
    	},10);
    });
	$(".filter-price-star .sp-title .left").tap(function(){
		$(".mask-layer").hide();
    	$('.filter-price-star').removeClass('filter-sp-active');
	});
	
	 //星级可多选
	  $("ul.star-list").on("click","li",function(){
		
	    if(0==$(this).index()){

	    	$(this).addClass("on").siblings().removeClass("on");
	    }else{
	    	
	    	$(this).toggleClass("on");
	    	if($(this).parent().find("li.on").length==0){
	    		$(this).parent().find("li:eq(0)").addClass("on");
	    	}else{
	    		$(this).parent().find("li:eq(0)").removeClass("on");
	    	}
	    }
		
	});
	//价格区间  
	$("ul.price-list").on("click","li",function(){
		$(this).addClass('on');
		$(this).siblings('li').removeClass("on");
	});
	$("div.sp-title > span.right").click(function(){//价格星级确定按钮
		var starli=$("ul.star-list > li[class='on']");
		var starval="";
		var star="";
		var starText="";
		for(var i=0;i<starli.length;i++){
			if($(starli[i]).attr("sn")==-1)continue;
	        starval+=$(starli[i]).attr("sn")+",";
	        if($(starli[i]).text()!="不限"){
	        	starText+=$(starli[i]).text()+",";
	        }	        
	        if(star==""){
	        	star=$(starli[i]).text();
	        }
		}
		starText=starText.replace(/,$/,"");
		console.log(starText);
		if(starli.length>=2){
			star+=",...";
		}
		starval=starval.substring(0,starval.length-1);
		var price=$("ul.price-list > li[class='on']").text();
		$("#starval").val(starval);
		if(price=="不限"){
			$("#LowRate").val("");
			$("#HighRate").val("");
		}else if(price=="700以上"){
			$("#LowRate").val("700");
			$("#HighRate").val("100000");
		}else{
			var arr=price.split("-");
			$("#LowRate").val(arr[0]);
			$("#HighRate").val(arr[1]);
		}
		//￥200;星级不限
		if(price!="不限"){
			$(".price-star-btn").addClass("unon");
			$(".price-star-btn .title-phone").html(price);
		}else if(starval!=""){
			$(".price-star-btn").addClass("unon");
			$(".price-star-btn .title-phone").html(star);
		}else{
			$(".price-star-btn").removeClass("unon");
			$(".price-star-btn .title-phone").html("价格星级");
		}
		var priceStarValue="";
		if(price!="不限"){
			priceStarValue="¥"+price;
		}
		if(starText!=""){
			if(price!="不限"){
				priceStarValue+=","+starText;
			}else{
				priceStarValue=starText;
			}
		}
		if(priceStarValue.length>25){
			priceStarValue=priceStarValue.substring(0,25)+"...";
		}
		$("#priceAndStar").val(priceStarValue);
		if(priceStarValue!=""){
			$(".priceStar .clearTxt").show();
		}else{
			$(".priceStar .clearTxt").hide();
		}
		starpriceHide();
	});
	function starpriceHide(){
		$(".filter-sp").removeClass("filter-sp-active");
		setTimeout(function(){
			$(".filter-sp").removeClass("plugin-show");
			$(".mask-layer").hide();
		},230);
	};
   
      
    //列表页，切换城市，搜索框获取焦点事件
      $("#search_city").focus(function(){
    	 $(".advance-city .inner-mask").show(); 
      });

	$('#search_city').on("input",function(){
		var areaName=$(this).val().trim();
		if(areaName!=""){
			$(".advance-city .page-content.page-search ul").empty();
			$.ajax({
			     type: 'POST',
			     url: $("#webpath").val()+"/v1/get_geo_by_area_name.htm",
			    data: {areaName:areaName},
			    success: function(data){
			    	$(".advance-city .page-content.page-search ul").empty();
			    	var str="";
			    	if(data.length>0){
			    		for(var i=0,len=data.length;i<len;i++){
			    			str+="<li class=\"bdb tjclick\" city-id=\""+data[i].areaCode+"\" city-name=\""+data[i].areaName+"\"><div class=\"\"><div class=\"adr1\">"+data[i].areaName.replace(areaName,"<em>"+areaName+"</em>")+"</div></div></li>";					    	
			    		}
			    		$(".advance-city .page-content.page-search ul").append(str);
				    	$(".advance-city .inner-mask").hide();
				    	$(".advance-city .page-content.page-select").hide()
				    	$(".advance-city .page-content.page-search").show();
			    	}
			    },
			    dataType: 'json'

			});
		}else{
			$(".advance-city .inner-mask").show();
			$(".advance-city .page-content.page-select").show();
	    	$(".advance-city .page-content.page-search").hide();
		}			
	});
	
	//城市搜索建议
	$(".advance-city .page-content.page-search ul").on("click","li",function(){
		console.log($(this).attr("city-id"));
		console.log($(this).attr("city-name"));
		$(".city-area .city").html($(this).attr("city-name"));
		
		$("#cityName").val($(this).attr("city-name"));

		$(".advance-city .page-content.page-select").show();
    	$(".advance-city .page-content.page-search").hide();
    	$("#search_city").val("");
		$("html").css("overflow","auto");
    	$(".advance-city").addClass("page-from-center-to-right").addClass("page-on-right");
    	setTimeout(function(){
    		$(".advance-city").removeClass("page-from-center-to-right").removeClass("plugin-show").removeClass("page-on-right");
    	},230);
	});
	
	/*首页地址赋值  热门城市点击*/
	 search_history_show();
	$(".advance-city .page-content.page-search ul").on("click","li",function(){	
		var cN =  $(this).attr('city-name');
		var cI = $(this).attr('city-id');
		var cityname = cN+'-'+cI ;
		$(".cityname").html(cN);
		$(".city-area .city").html(cN);			
		addCookie(cityname);
		
		$("#cityName").html(cN);
				
		$(".advance-city").addClass("page-from-center-to-right");
		setTimeout(function(){
			$(".advance-city").removeClass("plugin-show").removeClass("page-from-center-to-right");
		},230);
		search_history_show();
	});
	
	$(".advance-city .city-list ul").on('click', 'li', function(event) {
		$(this).addClass("on").siblings().removeClass("on");
		var cN =  $(this).find('span').html();
		var cI = $(this).attr('city-id');
		var cityname = cN+'-'+cI ;
		$(".cityname").html(cN);
		$(".city-area .city").html(cN);
		addCookie(cityname);
		
		$("#cityName").html(cN);
				
		$(".advance-city").addClass("page-from-center-to-right");
		setTimeout(function(){
			$(".advance-city").removeClass("plugin-show").removeClass("page-from-center-to-right");
		},230);	
		//城市名、行政区或景区历史记录
				
	    search_history_show();
	});					
	//添加到cookie方法
	var expiresDate= new Date();
	expiresDate.setTime(expiresDate.getTime() + (365*24*60 * 60 * 1000));
	function addCookie(cityname){
		var address=$.cookie('history_address');
	    if(address){
	    	var arr = address.split(',');
			var valueIndex= findArrIndex(arr,cityname);
			if(valueIndex!=-1){
				arr.splice(valueIndex,1);
			}
			arr.unshift(cityname);
			if(arr.length>6){
				arr.length=6
			}
			address = arr.join(',');				
		}else{
		   address=cityname;
		}
	  $.cookie('history_address',address,{expires:expiresDate});
	}
	function findArrIndex(arr,value){ 
		var str = arr.toString(); 
		var index = str.indexOf(value); 
		if(index >= 0){ 
		//存在返回索引
			var reg1 = new RegExp("((^|,)"+value+"(,|$))","gi"); 
			return str.replace(reg1,"$2@$3").replace(/[^,@]/g,"").indexOf("@"); 
		}else{ 
			return -1;//不存在此项
		} 
	}	
	//显示城市名、行政区或景区历史记录
	function search_history_show(){
		//显示到页面的搜素历史上
		var address=$.cookie('history_address');
		if(address){
			var arr = address.split(',');				
			var address_history_html="";
			for(var i=0;i<arr.length;i++){
				  $(".search-history").show();
			      address_history_html += "<li city-id="+arr[i].split('-')[1]+"><span>"+arr[i].split('-')[0]+"</span></li>";
			 }
			$(".search-history").find('.city-list ul').html(address_history_html);
		};
	}
	
	//定位
	
	function getLocation(){
       	var options={
           enableHighAccuracy:true, 
           maximumAge:1000
       	}
       	if(navigator.geolocation){
           //浏览器支持geolocation
           navigator.geolocation.getCurrentPosition(onSuccess,onError,options);
       	}else{
           //浏览器不支持geolocation
           alert('您的浏览器不支持地理位置定位');
       	}
   	}
	
	$(".myPos").on('touchstart',function(){
		if($(this).html()=="正在定位") return;
		$(this).html('正在定位');
		//getLocation();
		geolocation.getIpLocation(showPosition, showErr);
	})
	//成功时
   	function onSuccess(position){
       //返回用户位置
       //经度
       var longitude =position.coords.longitude;
       //纬度
       var latitude = position.coords.latitude;
	   console.log('经度'+longitude+'，纬度'+latitude);
	    setTimeout(function () {  
		    var gpsPoint = new BMap.Point(longitude, latitude);  
		    BMap.Convertor.translate(gpsPoint, 0, function (point) {
		    	console.log(point);
		        var geoc = new BMap.Geocoder();  
		        geoc.getLocation(point, function (rs) {
		        	$(".myPos").html('我的位置');
		            var addComp = rs.addressComponents;
		            $("#cityName").html(addComp.city.replace("市",""));
		            
		            //alert(addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber);  
		        });  
		    });  
		}, 100);
   	}
   	//失败时
   	function onError(error){
   		$(".myPos").html('我的位置');
       	switch(error.code){
           case 1:
           alert("位置服务被拒绝");
           break;
           case 2:
           alert("暂时获取不到位置信息");
           break;
           case 3:
           alert("获取信息超时");
           break;
           case 4:
            alert("未知错误");
           break;
       }
   	}
   	
   	var geolocation = new qq.maps.Geolocation();  
    var options = {timeout: 9000};
    var positionNum = 0;

    function getCurLocation() {
        geolocation.getLocation(showPosition, showErr, options);
    }
    function showPosition(position) {
        //document.getElementById("demo").appendChild(document.createElement('pre')).innerHTML = JSON.stringify(position, null, 4);
    	$(".myPos").html('我的位置');
        $("#cityName").html(position.city.replace("市",""));
        $("#longitude").val(position.lng);
        $("#latitude").val(position.lat);
    	
    };

    function showErr() {
        $(".myPos").html('定位失败');
    };

    function showWatchPosition() {
        document.getElementById("demo").innerHTML += "开始监听位置！<br /><br />";
        geolocation.watchPosition(showPosition);
        document.getElementById("pos-area").scrollTop = document.getElementById("pos-area").scrollHeight;
    };

    function showClearWatch() {
        geolocation.clearWatch();
        document.getElementById("demo").innerHTML += "停止监听位置！<br /><br />";
        document.getElementById("pos-area").scrollTop = document.getElementById("pos-area").scrollHeight;
    };
	setTimeout(function(){
		geolocation.getIpLocation(showPosition, showErr);
	},10);
	
	
    
    function toCenter(element){    	
    	element.style.transform = 'translate3d(0,0,0)';
    	element.style.WebkitTransform='translate3d(0,0,0)';
    }
    function toBottom(element){    	
    	element.style.transform = 'translate3d(0,100%,0)';
    	element.style.WebkitTransform='translate3d(0,100%,0)';
    }
    function toRight(element){    	
    	element.style.transform = 'translate3d(100%,0,0)';
    	element.style.WebkitTransform='translate3d(100%,0,0)';
    }
	
});

String.prototype.trim = function(){  
	return this.replace(/(^\s*)|(\s*$)/g, "");  
}

//跨浏览器获取视口大小
function getInner() {
	if (typeof window.innerWidth != 'undefined') {
		return {
			width : window.innerWidth,
			height : window.innerHeight
		}
	} else {
		return {
			width : document.documentElement.clientWidth,
			height : document.documentElement.clientHeight
		}
	}
}
//跨浏览器获取滚动条位置
function getScroll() {
	return {
		top : document.documentElement.scrollTop || document.body.scrollTop,
		left : document.documentElement.scrollLeft || document.body.scrollLeft
	}
}

//获取某一个元素到最外层顶点的位置
function offsetTop(element) {
	var top = element.offsetTop;
	var parent = element.offsetParent;
	while (parent != null) {
		top += parent.offsetTop;
		parent = parent.offsetParent;
	}
	return top;
}