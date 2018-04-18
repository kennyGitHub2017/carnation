


$(function() {
	FastClick.attach(document.body);
	

	/*下拉刷新 
	<div class="weui-pull-to-refresh__layer">
   		<div class='weui-pull-to-refresh__arrow'></div>
      	<div class='weui-pull-to-refresh__preloader'></div>
      	<div class="down pull-tips">
      		<p>下拉可以刷新</p>
      		<p>最后更新：<font class="last-time">今天09：30</font></p>
      	</div>
      	<div class="up pull-tips">
      		<p>松开立即刷新</p>
      		<p>最后更新：<font class="last-time">今天09：30</font></p></div>
      	<div class="refresh">正在刷新</div>
    </div>*/
	    
	//添加下拉刷新html
	var html = '<div class="weui-pull-to-refresh__layer">';
		html += '<div class="weui-pull-to-refresh__arrow"></div>';
		html += '<div class="weui-pull-to-refresh__preloader"></div>';
		html += '<div class="down pull-tips">';
		html += '<p>下拉可以刷新</p>';
		html += '<p>最后更新：今天<font class="last-time">00：00</font></p>';
		html += '</div>';
		html += '<div class="up pull-tips">';
		html += '<p>松开立即刷新</p>';
		html += '<p>最后更新：今天<font class="last-time">00：00</font></p></div>';
		html += '<div class="refresh">正在刷新</div>';
		html += '</div>';
	$(".wrap").css("height", $(window).height()+158 + "px")
	$(".wrap").prepend(html);

	
	setLoadMore();
	
	//点击打开弹出选择时间
	$("#open_popup").click(function (){
		$("#half").popup();
		$("#time_container1").css("display","block");
		$("#date_start").datetimePicker({
		 	container: '#time_container1',
		 	yearSplit:	"年"	,
		 	monthSplit: "月",
		 	dateSplit: "日",
		 	max:getNewDate(),
		 	times: function () {}
		});
	})
	//点击选择开始时间
	$("#date_start").click(function (){
		$("#time_container2").css("display","none");
		$("#time_container1").css("display","block");
		$("#date_start").datetimePicker({
		 	container: '#time_container1',
		 	yearSplit:	"年"	,
		 	monthSplit: "月",
		 	dateSplit: "日",
		 	max:getNewDate(),
		 	times: function () {}
		 });
		 $("#date_end").css({
		 	"color":"#4A4A4A",
		 	"border-bottom":"2px solid #DDDDDD"
		 })
		 $("#date_start").css({
		 	"color":"#119AEE",
		 	"border-bottom":"2px solid #119AEE"
		 })
		 $(".popup-cen").text("至");
	})
	//点击选择结束时间
	$("#date_end").click(function (){
		$("#time_container1").css("display","none");
		$("#time_container2").css("display","block");
		$("#date_end").datetimePicker({
		 	container: '#time_container2',
		 	yearSplit:	"年"	,
		 	monthSplit: "月",
		 	dateSplit: "日",
		 	max:getNewDate(),
		 	times: function () {}
		 });
		 $("#date_start").css({
		 	"color":"#4A4A4A",
		 	"border-bottom":"2px solid #DDDDDD"
		 })
		 $("#date_end").css({
		 	"color":"#119AEE",
		 	"border-bottom":"2px solid #119AEE"
		 })
		 $(".popup-cen").text("To");
	});
	
	
});
//获取现在时间
function getNewDate(){
	var date = new Date();
    var seperator1 = "-";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var rendate = date.getFullYear() + seperator1 + month + seperator1 + strDate;
    return rendate;
}
//获取开始日期 格式转换返回
function getStartDateVal(){
	var date = $("#date_start").val();
	date = date.replace('年', '-');
	date = date.replace('月', '-');
	date = date.replace('日', '');
	return date;
}
//获取结束日期 格式转换返回
function getEndDateVal(){
	var date = $("#date_end").val();
	date = date.replace('年', '-');
	date = date.replace('月', '-');
	date = date.replace('日', '');
	return date;
}
//判断筛选时间是否合法
function istrue(startdate,enddate){
	startdate = startdate.split("-"); 
	enddate = enddate.split("-"); 
	if(startdate[0] > enddate[0]){
		return false;
	}
	if(startdate[0] == enddate[0]){
		if(startdate[1] > enddate[1]){
			return false;
		}
		if(startdate[1] == enddate[1]){
			if(startdate[2] > enddate[2]){
				return false;
			}
		}
	}
	return true;
}
//设置顶部选择时间
function setTimeVal(){
	var date_start = $("#date_start").val();
	var date_end = $("#date_end").val();
	date_start = date_start.replace('年', '-');
	date_start = date_start.replace('月', '-');
	date_start = date_start.substring(0,date_start.length-2);
	date_end = date_end.replace('年', '-');
	date_end = date_end.replace('月', '-');
	date_end = date_end.substring(0,date_end.length-2);
	var date = date_start + " ~ " + date_end;
	$("#open_popup").text(date);
	$("#open_popup").removeClass("date-choose").addClass("date-choose-on");
}
//设置最后更新时间
function setLastTime(){
	var h = new Date().getHours();
	var m = new Date().getMinutes(); 
	if(h <10){ h = "0" + h; }
	if(m <10){ m = "0" + m; }
	$(".last-time").text(h + ':' + m);
}
//添加加载更多html
function setLoadMore(){
	/* 加载更多
	<div class="weui-loadmore">
 		<i class="weui-loading"></i>
 		<span class="weui-loadmore__tips">正在加载</span>
    </div>
    */
	$(".wrap").append('<div class="weui-loadmore"><i class="weui-loading"></i><span class="weui-loadmore__tips">正在加载</span></div>');
}

