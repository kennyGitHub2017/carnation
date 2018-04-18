$(function(){
	String.prototype.replaceAll = function(s1,s2){
	　　return this.replace(new RegExp(s1,"gm"),s2);
	}

	//选择城市
	var advanceCity=$(".advance-city");	
	$(".search-lb .search-list .cityname").tap(function(){
		advanceCity.addClass("plugin-show").addClass("page-from-right-to-center");
		setTimeout(function(){
			advanceCity.removeClass("page-from-right-to-center").addClass("page-on-center");
		},230);
	});
	
	$(".advance-city .bar .icon-back").tap(function(){
		$(".advance-city").addClass("page-from-center-to-right");
		setTimeout(function(){
			$(".advance-city").removeClass("plugin-show").removeClass("page-from-center-to-right");
		},230);
	});

	$(".search-list .price-star-btn .title-phone").tap(function(){
		$(".filter-sp").addClass("plugin-show");
		setTimeout(function(){
			$(".filter-sp").addClass("filter-sp-active");
			$(".mask-layer").show();
		},0);
	});

	$(".mask-layer").tap(function(){
		$(".filter-sp").removeClass("filter-sp-active");
		setTimeout(function(){
			$(".filter-sp").removeClass("plugin-show");
			$(".mask-layer").hide();
		},230);
	});


	$(".search-lb .search-list .maskLabel").tap(function(){
		$(".list-pop-city").addClass("plugin-show").addClass("page-from-right-to-center");
		$(".inner-mask").hide();
		setTimeout(function(){
			$(".list-pop-city").removeClass("page-from-right-to-center").addClass("page-on-center");
		},230);
	});

	$(".list-pop-city .bar .icon-back").tap(function(){
		$(".list-pop-city").addClass("page-from-center-to-right");
		setTimeout(function(){
			$(".list-pop-city").removeClass("plugin-show").removeClass("page-from-center-to-right");
		},230);
	});
	
	$(".inner-mask").tap(function(){
		$(this).hide();
	});


/*-------------------------------------------------*/
//城市名、行政区或景区历史搜索list
//search_history_show();
//酒店名称/位置不限历史搜索list
//history_city_show();
/*请输入城市名、行政区或景区 根据字母搜索*/
		var addressArr=['安任县','白银市','昌邑市','大同市','鄂州市','福安市','共和县','汉川市','九台市','昆山市','醴陵市','茂名市','南宁市','平山县','湘潭县','长沙县','清流县','日照市','松原市','泰安市','文登市','宜良县','赵县'];

		$(".letter-list li").click(function(){
		if($(this).hasClass('on')) return;
		$(this).addClass("on").siblings().removeClass("on");
		var addressArrList = " ";
		for (var i = 0; i < addressArr.length; i++) {
			addressArrList += "<li><span>"+ addressArr[i] +"</span></li>";
		}
		$(".city-list-ul").html(addressArrList);
		});
		
		$(".list-pop-city .bar .search-btn").tap(function(){
			var val= $(".list-pop-city .bar .search-input input").val();
			if(val!=""){
				addCookie(val);
				history_city_show();
			}
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
			var cityId=$(this).attr("city-id");
			$("#cityId").val(cityId);
			loadingShow();
			location.href=$("#webpath").val()+"/v1/elong_hotel_list.htm?cityId="+cityId;
			return;
			resetSort();
			resetPriceStar();
			reload_hotel();			
			$(".advance-city").addClass("page-from-center-to-right");
			setTimeout(function(){
				$(".advance-city").removeClass("plugin-show").removeClass("page-from-center-to-right");
			},230);
            search_history_show();
		});
		
		$(".advance-city  .city-list ul").on('click', 'li', function(event) {
			$(this).addClass("on").siblings().removeClass("on");
			var cN =  $(this).find('span').html();
			var cI = $(this).attr('city-id');
			var cityname = cN+'-'+cI ;
			$(".cityname").html(cN);
			$(".city-area .city").html(cN);
			addCookie(cityname);
			var cityId=$(this).attr("city-id")
			$("#cityId").val(cityId);
			loadingShow();
			location.href=$("#webpath").val()+"/v1/elong_hotel_list.htm?cityId="+cityId;
			return;
			resetSort();
			resetPriceStar();
			reload_hotel();			
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
		
		
		/*//首页酒店名称/位置不限
		$(".keyword-list ul").on('click', 'li:not([class^="icon"])', function(event) {
			if($(this).hasClass('on')) return;
			$(this).addClass("on").siblings().removeClass("on");
			var nameoraddress = $(this).find('span').html();
			$(".nameoraddress").val(nameoraddress);
			$(".nameoraddress").next('.clear-btn.icon-clear').show();
			if($(".nameoraddress").val(nameoraddress)){
				$(".nameoraddress").parents('li.name').addClass('on');
			}



			$(".list-pop-city").addClass("page-from-center-to-right");
			setTimeout(function(){
				$(".list-pop-city").removeClass("plugin-show").removeClass('page-from-center-to-right');
			},230);
*/

			//酒店名称/位置不限历史搜索
	/*		addCookie_city(nameoraddress);
			//添加到cookie方法
			function addCookie_city(val){
				var nameOraddress = $.cookie('history_city');
			    if(nameOraddress){
				  nameOraddress = nameOraddress.replaceAll(val+",","");//先移除掉原来存在的地址
				  nameOraddress = val+","+nameOraddress;
				  var arr=nameOraddress.split(',');
				   if(arr.length>6){
					   nameOraddress=arr[0];
					   for(var i=1;i<arr.length;i++){
					       if(i>5)break;
					       nameOraddress+=','+arr[i];
					    }
				   }
				}else{
				   nameOraddress=val;
				}
			  $.cookie('history_city',nameOraddress);
			}
				history_city_show(); 
		});*/

		//酒店名称/位置不限历史记录显示
	/*	function history_city_show(){
			//显示到页面的搜素历史上
			var history_city=$.cookie('history_city');
			if(history_city){
				var arr = history_city.split(',');
				var history_city_html="";
				for(var i=0;i<arr.length;i++){
					  $(".search-history").show();
					  $(".list-pop-city .page-title").show();
					  history_city_html  += "<li><span>"+arr[i]+"</span></li>";
				 }
				$(".advance-city .search-history").find('.city-list ul').html(history_city_html);
			}
		}*/

		//清除酒店名称/位置不限历史
		/*$(".list-pop-city .sea-clear").click(function(event) {
			$(this).parents('.search-history').remove();
		});*/


		/*//首页清空输入框
		$(".close").click(function(event) {
			$(this).siblings().find('input').val("");
			$(this).parent('li').removeClass('on');
			
		});



		$(".keyword-list ul").each(function(){
	           var length = $(this).find('li span').size();
	           if(length < 5 ){
	           	$(this).find('.icon-bottom').addClass('hide');
	           }
	           $(this).find('li:gt(4) span').parents('li').addClass('hide');

		});*/

		 /*$('.icon-bottom').click(function(event) {

	       	$(this).parents(".keyword-list ul").find('li:gt(4) span').parents('li').removeClass('hide');
	       	$(this).addClass('hide');
	       	$(this).siblings('.icon-top').removeClass('hide');
	       	
	       });

	        $('.icon-top').click(function(event) {

	       	$(this).parents(".keyword-list ul").find('li:gt(4) span').parents('li').addClass('hide');
	       	$(this).addClass('hide');
	       	$(this).siblings('.icon-bottom').removeClass('hide');
	       });*/


	   


	  

	  $("#addess_search").keyup(function(event) {
	  	var search_list = $(this).val();
	  	if(!search_list){
	  		$(".page-content.page-search").hide();
	  		$(".page-content.page-select").show();
	  		$(".inner-mask").show();
	  	}else{
	  		$(".page-content.page-search").show();
	  		$(".page-content.page-select").hide();
	  		$(".inner-mask").hide();
	  	}
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
	$("div.sp-title > span.right").click(function(){
		var starli=$("ul.star-list > li[class='on']");
		var starval="";
		var star="";
		for(var i=0;i<starli.length;i++){
			if($(starli[i]).attr("sn")==-1)continue;
	        starval+=$(starli[i]).attr("sn")+",";
	        if(star==""){
	        	star=$(starli[i]).text();
	        }
		}
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
		resetSort();
		reload_hotel();
		starpriceHide();
	});
	function starpriceHide(){
		$(".filter-sp").removeClass("filter-sp-active");
		setTimeout(function(){
			$(".filter-sp").removeClass("plugin-show");
			$(".mask-layer").hide();
		},230);
	};
	//酒店列表清空搜索
	$(".clear-btn.icon-clear").on('click', function(event) {
		$(this).prev('input').val("");
		$(this).hide();
	});

	
	//酒店列表点击事件
	$(".list-main").delegate(".hotel-item","click",function(){//添加按钮事件
		var arrivalDate=$(".indate").attr("data-value");
		var departureDate=$(".outdate").attr("data-value");
		location.href=$(this).attr("data-url")+"&arrivalDate="+arrivalDate+"&departureDate="+departureDate;
	});		
	
	//搜索酒店，列表点击事件
	$(".list-pop-city .page-content ul").on("click","li",function(){
		var arrivalDate=$(".indate").attr("data-value");
		var departureDate=$(".outdate").attr("data-value");
		location.href=$(this).attr("data-url")+"&arrivalDate="+arrivalDate+"&departureDate="+departureDate;
	});
});
	
