mui.init({
	swipeBack : true
//启用右滑关闭功能
});
mui('.taskTit .mui-switch')
		.each(
				function() { //循环所有toggle
					//toggle.classList.contains('mui-active') 可识别该toggle的开关状态
					this.parentNode.querySelector('span').innerText = this.classList
							.contains('mui-active') ? 'true' : 'false';
					/**
					 * toggle 事件监听
					 */
					this
							.addEventListener(
									'toggle',
									function(event) {
										//event.detail.isActive 可直接获取当前状态
										this.parentNode.querySelector('span').innerText = event.detail.isActive ? 'true'
												: 'false';
										jQuery(".remindTime,.cycle").toggle();
									});
				});

(function($) {
	$.init();
	var btns = $('#choose');
	btns.each(function(i, btn) {
		btn.addEventListener('tap', function() {
			var optionsJson = this.getAttribute('data-options') || '{}';
			var options = JSON.parse(optionsJson);
			var picker = new $.DtPicker(options);
			picker.show(function(rs) {
				document.getElementById("choose").innerHTML = rs.text;
				picker.dispose();
			});
		}, false);
	});
})(mui);
$(document).ready(function() {
	$(".week ul li").each(function() {
		$(this).click(function() {
			if ($(this).hasClass("curr")) {
				$(this).removeClass("curr");
			} else {
				$(this).addClass("curr");
			}
		});
	});
	$(".submit").on("touchstart",function() {
//		alert("....."+T.split(""));
		var isOpen_ = 1;
		var remindWeek_ = null;
		if ($(".mui-switch").hasClass("mui-active")) {
			console.log("任务开启");
			var reg=/^\d{2}:\d{2}$/ig;
			var choose =$.trim($("#choose").html());
			if (!reg.test(choose)) {
				tipsbox("请选择提醒时间");
				return;
			}
			var T = "";
			$(".week ul li").each(function(index) {
				if ($(this).hasClass("curr")) {
					T += (index + 1);
				}
			});
			if (T == "") {
				tipsbox("请选择提醒周期");
				return;
			}
			if (T == "1234567"){
				T = "0";
			}
			remindWeek_ = T.split("");
		} else {
			console.log("任务关闭");
			isOpen_ = 0;
		}
		var uid = jQuery("#uid").val();
		var webPath = jQuery("#apiPath").val();
		var id_ = jQuery("#taskID").val();
		var taskName_ = jQuery(".taskName").html();
		var remindTime_  = choose;
		/*var remindWeek_ = T.split("");*/
		var operType_ = 10;
		var jumpType_ = jQuery("#jumpType").val();
		var params = null;
		if(isOpen_==1){
			params = "?operType="+operType_+"&id="+id_+"&taskName="+taskName_+"&remindTime="+remindTime_+"&remindWeek="+remindWeek_+"&isOpen="+isOpen_+"&pageSize=10&pageNum=0";
			if(jumpType_.length>0){
				params =params+"&jumpType="+jumpType_;
			}
		}
		else{
			params="?taskName="+taskName_+"&isOpen="+isOpen_+"&operType="+operType_+"&id="+id_;
			if(jumpType_.length>0){
				params =params+"&jumpType="+jumpType_;
			}
		}
		/*jQuery.get(webPath+"/v1/ht/doSet"+params);*/
		window.location.href = webPath+"/v1/ht/doSet"+params+"&userID="+uid;
	});
	//返回键事件
	var refer=document.referrer;
	$(".return").on("touchstart",function(){
		var uid = jQuery("#uid").val();
		var webPath = jQuery("#apiPath").val();
		if(document.referrer.indexOf("proposalDetai")>-1){
			window.location.href=document.referrer;
			return;
		}
		//window.location.href = webPath+"/v1/ht/sysTaskList?userID="+uid;	
		window.location.href = refer;
	});
});