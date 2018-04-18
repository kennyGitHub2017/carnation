//更改日期
function hotel_list_cld_fn(){
	pagenum=1;
	isend=!1;
	$(".nomore").eq(1).hide();
	GetData(pagenum,10);
}
function reload_hotel(){
	pagenum=1;
	isend=!1;
	$(".nomore").eq(1).hide();
	GetData(pagenum,10);
}

function resetSort(){
	$(".filter-list .default-btn").removeClass("drop");
	$(".list-sider .filter-list .default-btn .title-phone").html("排序");
	$("#Sort").val("");
}

function resetPriceStar(){
	$(".price-star-btn").removeClass("unon");
	$(".price-star-btn .title-phone").html("价格星级");
	$("ul.star-list li").eq(0).addClass("on").siblings("li").removeClass("on");
	$("ul.price-list li").eq(0).addClass("on").siblings("li").removeClass("on");
	$("#LowRate").val("");
	$("#HighRate").val("");
	$("#starval").val("");
}


$(function(){
	
	initCLD();
	
	$(".page-content").bind("scroll",function() {
		tt.scroll();
		_wait_load();

    });
    tt = {
            visible: !0,
            data: {
                startY_IOS: 0,
                startY_Android: 0,
                endY_IOS: 0,
                endY_Android: 0
            },
            scroll: function() {
                tt.data.endY_IOS = $(".page-content").scrollTop(),
                tt.data.endY_Android = $("body").scrollTop();
                var e = tt.data.endY_IOS - tt.data.startY_IOS,
                t = tt.data.endY_Android - tt.data.startY_Android;
                tt.data.endY_IOS >= 93 || tt.data.endY_Android >= 93 ? ((e > 5 || t > 5) && tt.visible && tt.hide(), ( - 5 > e || -5 > t) && !tt.visible && tt.show()) : tt.visible || tt.show(),
                tt.data.startY_IOS = tt.data.endY_IOS,
                tt.data.startY_Android = tt.data.endY_Android
            },
            show: function() {
                tt.visible = !0,
                $(".search-field").removeClass("hidein").addClass("showout")              
            },
            hide: function() {
                tt.visible = !1,
                $(".search-field").removeClass("showout").addClass("hidein")
            }
    }
    

    //选择城市
    $(".city-area").tap(function(){
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
    $(".sea-date").tap(function(){
    	$("html").css("overflow","hidden");    	
    	toCenter($(".cld")[0]);    	
    });
    $(".cld .icon-back").tap(function(){
    	$("html").css("overflow","auto");
    	toBottom($(".cld")[0]);
    });
    
    var listPopCity=$(".list-pop-city")[0];
    //酒店名称
    $(".sea-box").tap(function(){
    	$(".list-pop-city").show();
    	setTimeout(function(){
    		toCenter(listPopCity);
    	},10);
    });
    $(".list-pop-city .icon-back").tap(function(){
    	$("#query").blur();
    	toRight(listPopCity);
    });
    
    //筛选
    var listPopFliter=document.getElementById('listPopFliter');
    $(".filter-btn").tap(function(){
    	$(listPopFliter).show();
    	setTimeout(function(){
    		toCenter(listPopFliter);
    	},10);
    });
    $(".list-pop-fliter .icon-back").tap(function(){
    	toRight(listPopFliter);
    });
    
    //区域位置
    var listPopArea=document.getElementById("listPopArea");
    $(".area-btn").tap(function(){
    	$(listPopArea).show();
    	setTimeout(function(){
    		toCenter(listPopArea);
    	},10);
    });
    $(".list-pop-area .icon-back").tap(function(){
    	toRight(listPopArea);
    });
    
    //价格星级
    var filterPriceStar=document.getElementById("filterPriceStar");
    $(".price-star-btn").tap(function(){
    	if(document.getElementById('mask-layer')){
    		$(".mask-layer").removeAttr('style');
    	}else{
    		$("<div id=\"mask-layer\" class=\"mask-layer\"></div>").appendTo($(".page"));
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
	//排序
	var slideSelector=$(".slide-selector");
	$(".filter-list .default-btn").tap(function(){
		if(document.getElementById('advancedMaskLayer')){
			$(".advanced-mask-layer").removeAttr("style");
		}else{
			$("<div id=\"advancedMaskLayer\" class=\"advanced-mask-layer\"></div>").appendTo($(".page"));
			$(".advanced-mask-layer").tap(function(){
	    		$(this).hide();
	    		$('.slide-selector').removeClass('selector-active');
    		});
		}
		$('.slide-selector').addClass('plugin-show');
    	setTimeout(function(){
    		$('.slide-selector').addClass('selector-active');
    	},10);
		
	});
	//排序点击
	$(".slide-selector .page-content li").tap(function(){
		$(".filter-list .default-btn").addClass("drop");
		$(this).addClass("selected").siblings().removeClass("selected");
		var text=$(this).find(".radio-text").html();
		var btn=$(".list-sider .filter-list .default-btn .title-phone");
		var sort=$(this).attr("value");
		$("#Sort").val(sort);
		resetPriceStar();
		reload_hotel();
		if(text=="默认"){
			$(".filter-list .default-btn").removeClass("drop");
			btn.html("排序");
		}else{
			$(".filter-list .default-btn").addClass("drop");
			btn.html(text);
		}
		$(".advanced-mask-layer").hide();
		$('.slide-selector').removeClass('selector-active');
	});
	//筛选 点击品牌
	$(".filter-wrap .filter-tit ul li").tap(function(){
        if($(this).hasClass('on')) return;
        $(this).addClass("on").siblings().removeClass("on");
		var cspot=JSON.parse($(this).attr("data-tj")).cspot;
		console.log(cspot);
	});

    //筛选，选中
     $("ul.filter-list-subway-r").on("click","li",function(){
        
       // var filter_list_li = $("ul.filter-list-subway-r > li[class='on']");
        //var filter_list_val = "";
        if(!$(this).hasClass('on')){
            $(this).addClass('on');
             if(0==$(this).index()){
            
            $(this).siblings().removeClass("on");
             $(".list-fliter-box").css('padding-top', '0px');
             $(this).parent('ul').siblings('ul.filter-list-subway-l').find('li.on').removeClass('have');
             $(this).parents('div.filter-con').prev('div.filter-tit').find('li.on').removeClass('have');
             $(".list-fliter-box div.condition.bar > ul ").html("");
        }else{
            $(this).parent().find("li:eq(0)").removeClass("on");
            $(".list-fliter-box").css('padding-top', ' 44px');
            $(this).parent('ul').siblings('ul.filter-list-subway-l').find('li.on').addClass('have');
            $(this).parents('div.filter-con').prev('div.filter-tit').find('li.on').addClass('have');
           createBoxNode(this);
        }
          
        }else{
             $(this).removeClass('on');
             deleteBoxNode(this);
        }
       
        
    });
     //生成关键字标签方法
     function createBoxNode(id){
       
         var dataid=$(id).attr("data-id");
         var datatype=$(id).attr("data-type");
         var datatype2=dataid.substring(0,dataid.lastIndexOf("_"));
         var val=$(id).text();
        var html='<li data-type1="'+dataid+'" data-type2="'+datatype2+'" data-type3="'+datatype+'">'+val+'<i class="icon-cross"></i>';
        $(".list-fliter-box div.condition.bar > ul ").append(html);
     }
     //删除标签
     function deleteBoxNode(id){
    
        var datatype1=$(id).attr("data-id");
      $(".list-fliter-box div.condition.bar > ul ").find("li[data-type1='"+datatype1+"']").remove();

     }
     //标签上的删除操作
      $(".list-fliter-box div.condition.bar > ul ").on("click","i.icon-cross",function(){
           var li=$(this).parent("li");
            var datatype1=  li.attr("data-type1");
            li.remove();
            $("ul.filter-list-subway-r").find("li[data-id='"+datatype1+"']").remove();
            var conditionbar_li = $(".condition ul li").index();
            if(conditionbar_li < 0){
                 $(".list-fliter-box").css('padding-top', ' 0px');
                 $(".filter-list-subway-r").find('li:eq(0)').addClass('on');
            }
     });
      //重置按钮方法-----------------------------------------
    
      function reset(){
        //$("div.list-pop-fliter").html(initHtml);
        
      }
      $("#filter-reset").click(function(){
        window.location.reload();
      });
    //酒店搜索开始      
      $("#query").focus(function(){
     	 $(".list-pop-city .inner-mask").show(); 
       });
      $('#query').on("input",function(){
  		var text=$(this).val().trim();
  		if(text!=""){
  			$(".list-pop-city .page-content.page-search ul").html("<div style=\"text-align:center;margin-top:10px\"><img style=\"width:16px;height:16px;vertical-align: middle;\" src=\""+$("#webpath").val()+"/resources/elong/img/loading.gif\" />搜索中...</div>");
  			$.ajax({
  			     type: 'POST',
  			     url: $("#webpath").val()+"/v1/hotel_list.htm",
  			    data: {queryText:text,cityId:$("#cityId").val(),pageSize:100},
  			    success: function(data){
  			    	var str="";
  			    	$(".list-pop-city .page-content.page-search ul").empty();
  			    	if(data!=null&&data.length>0){
  			    		var webpath=$("#webpath").val();
  			    		for(var i=0,len=data.length;i<len;i++){
  			    			var hotel=data[i];
	  			    		str+="<li class=\"bdb tjclick\" data-url=\""+webpath+"/v1/elong_hotel_detail.htm?hotelId="+hotel.hotelId+"\" hotelname=\""+hotel.hotelName+"\"  hotel-id=\""+hotel.hotelId+"\">";
	  			    		str+="<i class=\"adric adric4\"></i><div class=\"adrall clearfix\">";
	  			    		str+="<div class=\"adr1\">"+hotel.hotelName+"</div>";
	  			    		str+="<i class=\"tags\">"+hotel.grade+"分</i>";
	  			    		str+="</div>";
	  			    		str+="<div class=\"adr2\"><em class=\"col\">¥"+hotel.lowRate+"起</em>｜"+hotel.address+"</div>";
	  			    		str+="<span>酒店</span>";
	  			    		str+="</li>";	
  			    		}
  			    	}else{
  			    		str="<div style=\"text-align:center;line-height:50px\">没有查询到相关酒店</div>";
  			    	}  			    	
  			    	$(".list-pop-city .page-content.page-search ul").append(str);
  			    	$(".list-pop-city .inner-mask").hide();
			    	$(".list-pop-city .page-content.page-select").hide();
			    	$(".list-pop-city .page-content.page-search").show();
  			    },
  			    dataType: 'json'
  			});
  		}else{
  			$(".list-pop-city .inner-mask").show();
  			$(".list-pop-city .page-content.page-select").show();
  	    	$(".list-pop-city .page-content.page-search").hide();
  		}			
  	}); 
      
    //酒店搜索结束
      
      
      
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
		var cityId= $(this).attr("city-id");
		//城市id隐藏域赋值，获取城市酒店数据
		//
		loadingShow();
		location.href=$("#webpath").val()+"/v1/elong_hotel_list.htm?cityId="+cityId;
		return;
		$("#cityId").val(cityId);
		resetSort();
		resetPriceStar();
		reload_hotel();
		$(".advance-city .page-content.page-select").show();
    	$(".advance-city .page-content.page-search").hide();
    	$("#search_city").val("");
		$("html").css("overflow","auto");
    	$(".advance-city").addClass("page-from-center-to-right").addClass("page-on-right");
    	setTimeout(function(){
    		$(".advance-city").removeClass("page-from-center-to-right").removeClass("plugin-show").removeClass("page-on-right");
    	},230);
	});
	
	//区域位置
	$(".filter-con .filter-list-radio li").tap(function(){
	    if($(this).hasClass('on')) return;
	    $(this).addClass("on").siblings().removeClass("on");
	    $(this).parents('div.filter-con').prev('div.filter-tit').find('li.on').addClass('have');

	});
    
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
//函数节流
_debounce = function(func, wait, immediate) {
  var timeout, args, context, timestamp, result;

  var later = function() {
    var last = +new Date() - timestamp;

    if (last < wait && last >= 0) {
      timeout = setTimeout(later, wait - last);
    } else {
      timeout = null;
      if (!immediate) {
        result = func.apply(context, args);
        if (!timeout) context = args = null;
      }
    }
  };

  return function() {
    context = this;
    args = arguments;
    timestamp = +new Date();
    var callNow = immediate && !timeout;
    if (!timeout) timeout = setTimeout(later, wait);
    if (callNow) {
      result = func.apply(context, args);
      context = args = null;
    }

    return result;
  };
};

//图片延迟加载
var wait_load_id=null;
function _wait_load() {
	var wait_load = $('img[src-set]');
	clearTimeout(wait_load_id);
	wait_load_id=setTimeout(function () {
		var top=$(".page-content").scrollTop();
		for (var i = 0; i < wait_load.length; i ++) {
			var _this = wait_load.eq(i)[0];
				
			if (getInner().height + top >= offsetTop(_this)) {
				
				$(_this).attr('src', $(_this).attr('src-set')).removeAttr("src-set");
			}
		}
	}, 100);
}

