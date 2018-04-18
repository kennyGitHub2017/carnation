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

function initCLD(){
//拼接日历
	var cld="";
	var currDay=new Date().getDate();	
	
	for(var i=0;i<7;i++){
		var data=getMonthdata(i);
		cld+="<section class=\"cld-item\">";
		cld+="<h1 class=\"cld-titleDate\">"+data.year+"年"+data.month+"月</h1>";
		cld+="<ul class=\"cld-day\">";
		for(var j=0;j<data.li_num;j++){
			cld+="<li></li>";
		}
		for(var k=1;k<=data.daycount;k++){
			if(i==0&&k<currDay){
				cld+=" <li data-day=\""+data.year+"-"+data.month+"-"+addZero(k)+"\" class=\"disabled\"><span class=\"date-elem\">"+k+"</span></li>";
			}else{
				cld+=" <li data-day=\""+data.year+"-"+data.month+"-"+addZero(k)+"\"><span class=\"date-elem\">"+k+"</span></li>";
			}
		}
		cld+="</ul>";
		cld+="</section>";
	}
	$(".cld .page-content").html(cld);
	$(".cld-item .cld-day .disabled:last").removeClass("disabled");
	
	var todayStr= new Date().Format('yyyy-MM-dd');
	var tomorrow = new Date();
	tomorrow.setDate(tomorrow.getDate()+1);  
	var tomorrowStr=tomorrow.Format('yyyy-MM-dd');
	var startStr="";
	var endStr="";
	
	if(getQueryPar('arrivalDate')){
		startStr=getQueryPar('arrivalDate');
	}else{
		startStr=todayStr;
	}
	if(getQueryPar('departureDate')){
		endStr=getQueryPar('departureDate');		
	}else{
		endStr=tomorrowStr;
	}
	
	var flag=0;
	var dateList_cld=$(".cld .page-content .cld-item li[data-day]");
    $(".search-lb .search-list .date .d1 .indate").attr("data-value",startStr).html(startStr.split("-")[1]+"月"+startStr.split("-")[2]+"日");
	$(".search-lb .search-list .date .d3 .outdate").attr("data-value",endStr).html(endStr.split("-")[1]+"月"+endStr.split("-")[2]+"日");
	
	
	$(".cld .page-content .cld-item li[data-day="+todayStr+"]").attr("text","<div><span class=\"festival\">"+Number(todayStr.split("-")[2])+"</span><span class=\"festivalText\">今天</span></div>");
	
	$(".cld .page-content .cld-item li[data-day="+startStr+"]").addClass("active").attr("text","<span class=\"date-elem\">"+Number(startStr.split("-")[2])+"</span>").html("<div><span class=\"active\">"+Number(startStr.split("-")[2])+"</span><span class=\"activeText\">入住</span></div>");
	$(".cld .page-content .cld-item li[data-day="+endStr+"]").addClass("active").attr("text","<span class=\"date-elem\">"+Number(endStr.split("-")[2])+"</span>").html("<div><span class=\"active\">"+Number(endStr.split("-")[2])+"</span><span class=\"activeText\">离店</span></div>");
	var inIndex=dateList_cld.index($(".cld .page-content .cld-item li[data-day="+startStr+"]"));
	var outIndex=dateList_cld.index($(".cld .page-content .cld-item li[data-day="+endStr+"]"));
	for(var i=inIndex+1;i<outIndex;i++){
		$(".cld .page-content .cld-item li[data-day]").eq(i).addClass("active-during");
	}
	
	
	dateList_cld.tap(function(){
		if($(this).hasClass('disabled')) return;
		todayStr= new Date().Format('yyyy-MM-dd');
		var day= $(this).attr("data-day").split("-")[2];
		var inStr="<div><span class=\"active\">"+Number(day)+"</span><span class=\"activeText\">入住</span></div>";
		var outStr="<div><span class=\"active\">"+Number(day)+"</span><span class=\"activeText\">离店</span></div>";
		var active=$(".cld .page-content .cld-item li.active").length;
		if(active==0){
			$(this).addClass("active").attr("text",$(this).html()).html(inStr);
		}else if(active==1){
			var origin=dateList_cld.index($(".cld .page-content .cld-item li.active"));
			var now=dateList_cld.index(this);
			if(origin==now){
				$(this).removeClass("active").html($(this).attr("text"));
			}else if(origin>now){
				dateList_cld.eq(origin).removeClass("active").html(dateList_cld.eq(origin).attr("text"));
				$(this).addClass("active").attr("text",$(this).html()).html(inStr);
			}else{
				$(this).addClass("active").attr("text",$(this).html()).html(outStr);
				for(var i=origin+1;i<=now-1;i++){
					dateList_cld.eq(i).addClass("active-during");
				}
				var dataValue1=dateList_cld.eq(origin).attr("data-day");
				var dataValue2=dateList_cld.eq(now).attr("data-day");
				
				$(".ht_day.detail-date.detail-hotel .indate").html(dataValue1);
				$(".ht_day.detail-date.detail-hotel .outdate").html(dataValue2);
				$(".search-lb .search-list .date .d1 .indate").attr("data-value",dataValue1).html(dataValue1.split("-")[1]+"月"+dataValue1.split("-")[2]+"日");
				$(".search-lb .search-list .date .d3 .outdate").attr("data-value",dataValue2).html(dataValue2.split("-")[1]+"月"+dataValue2.split("-")[2]+"日");
				$(".indate[name=arrivalDate]").attr("data-value",dataValue1).html(dataValue1.split("-")[1]+"-"+dataValue1.split("-")[2]);
				$(".outdate[name=departureDate]").attr("data-value",dataValue2).html(dataValue2.split("-")[1]+"-"+dataValue2.split("-")[2]);
				
				var todayIndex=dateList_cld.index($(".cld .page-content .cld-item li[data-day="+todayStr+"]"));
				$(".search-lb .search-list .date .d1 .startweek").html(makeDateJump(todayIndex,origin,dataValue1));
				$(".search-lb .search-list .date .d3 .endweek").html(makeDateJump(todayIndex,now,dataValue2));				
				$(".search-lb .search-list .date .d4,span.total").html(now-origin+"晚");
				
				$(".getin_room_b .count_day .count_nmb").html(now-origin);
				console.log(typeof hotel_list_cld_fn);
				
				if(typeof hotel_list_cld_fn =="function"){
					hotel_list_cld_fn();
				}
				
				setTimeout(function(){
					$(".cld").removeClass("cld-active");
					$("html").css("overflow","auto");
			    	toBottom($(".cld")[0]);
				},500);
			}
		}else{
			$(".cld .page-content .cld-item li.active").each(function(){
				$(this).removeClass("active").html($(this).attr("text"));
			});
			$(".cld .page-content .cld-item li.active-during").removeClass("active-during");
			$(this).addClass("active").attr("text",$(this).html()).html(inStr);
		}
		if(!$(".cld .page-content .cld-item li[data-day="+todayStr+"]").hasClass("active")){
			$(".cld .page-content .cld-item li[data-day="+todayStr+"]").html("<div><span class=\"festival\">"+todayStr.split("-")[2]+"</span><span class=\"festivalText\">今天</span></div>");
		}
				
	});
	
		var dataValue1=startStr;
		var dataValue2=endStr;
		$(".search-lb .search-list .date .d1 .indate").attr("data-value",dataValue1).html(dataValue1.split("-")[1]+"月"+dataValue1.split("-")[2]+"日");
		$(".search-lb .search-list .date .d3 .outdate").attr("data-value",dataValue2).html(dataValue2.split("-")[1]+"月"+dataValue2.split("-")[2]+"日");
		$(".indate[name=arrivalDate]").attr("data-value",dataValue1).html(dataValue1.split("-")[1]+"-"+dataValue1.split("-")[2]);
		$(".outdate[name=departureDate]").attr("data-value",dataValue2).html(dataValue2.split("-")[1]+"-"+dataValue2.split("-")[2]);
		var todayIndex=dateList_cld.index($(".cld .page-content .cld-item li[data-day="+todayStr+"]"));
		$(".search-lb .search-list .date .d1 .startweek").html(makeDateJump(todayIndex,inIndex,dataValue1));
		$(".search-lb .search-list .date .d3 .endweek").html(makeDateJump(todayIndex,outIndex,dataValue2));				
		$(".search-lb .search-list .date .d4,span.total").html(outIndex-inIndex+"晚");

}

