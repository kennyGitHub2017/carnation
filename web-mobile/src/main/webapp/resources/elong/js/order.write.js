$(function(){
	//房型详情
	$(".odr_mm p.ht_more").tap(function(){
		$(".page.page-on-center").addClass('fixed');
		$(".page-content.odr_doc").css("cssText","overflow:hidden!important"); 

		$(".type-pop-box.order_typeilst ").addClass('plugin-show');
		setTimeout(function(){
			$(".type-pop-box.order_typeilst ").addClass('box-active').addClass('page-transitioning');
		},230);
	});
	//关闭房型详情
	$(".order_pri_close.bar").tap(function(){
		$(".page.page-on-center").removeClass('fixed');
		$(".page-content.odr_doc").css('overflow', 'auto');
		$(this).parent('.type-pop-box.order_typeilst').removeClass('plugin-show');
		setTimeout(function(){
			$(".type-pop-box.order_typeilst ").removeClass('box-active').removeClass('page-transitioning');
		},230);
		$(".page-content.odr_doc").css("cssText","");
	});


	//房间数量
	$(".order-occupancy ul  li:eq(0)").tap(function(){
		$(".page.page-on-center").addClass('fixed');
		$(".page-content.odr_doc").css("cssText","overflow:hidden!important"); 
		$(".slide-selector:eq(0)").addClass('plugin-show');
		setTimeout(function(){
			$(".slide-selector:eq(0)").addClass("selector-active");
			$(".advanced-mask-layer").show();
		},230);
		
	});

	//选择房间数量
	$(".slide-selector:eq(0) .page-content li.radio-item ").tap(function(){
		if($(this).hasClass('selected'))  return;
		$(this).addClass('selected').siblings().removeClass('selected');
		var room_number = $(this).find('div.radio-text').html();
		$(".order-occupancy input.cert-type.createorder").val(room_number);
		
		var chooseRoomNum=$(this).attr("value");
		var price=($("#param-price").val()*chooseRoomNum).toFixed(1);
		$("#wborderprice").html(price);
		if(chooseRoomNum > 5){
			$(".room-big").show();
		}else{
			$(".room-big").hide();
		}
		
		var nowRoomNum=$(".order-contact .contact-person ul li").length;
		if(chooseRoomNum>nowRoomNum){
			var html="";
			for(var i=nowRoomNum+1;i<=chooseRoomNum;i++){
				html+="<li><label for=\"cusname"+i+"\"></label>";
                html+="<div class=\"label\">入住人(房间"+i+")</div>";
                html+="<div class=\"content list-input\" style=\"position: relative;\">";
                html+="    <input type=\"text\" class=\"createorder\" name=\"customernames\" id=\"cusname"+i+"\" placeholder=\"姓名，每间填1人\" value=\"\" style=\"padding-right: 24px;\"> <i class=\"icon-cross clear-input\" style=\"display: none; top: 7px;\"></i>";
                html+="</div></li>";
			}
			$(".order-contact .contact-person ul").append(html);			
		}else{
			$(".order-contact .contact-person ul li").eq(chooseRoomNum-1).find("~li").remove();
		}
		//以下是关闭
		$(".slide-selector:eq(0)").removeClass("selector-active");
		setTimeout(function(){
			$(".slide-selector:eq(0)").removeClass('plugin-show');
			$(".advanced-mask-layer").hide();
		},230);
		$(".page.page-on-center").removeClass('fixed');
		$(".page-content.odr_doc").css("cssText","");
	});
	
	//点击空白的地方也应该能关掉选择房间数量的(取消按钮)
	$(".slide-selector:eq(0) .bar-nav").tap(function(){
		$(".slide-selector:eq(0)").removeClass("selector-active");
		setTimeout(function(){
			$(".slide-selector:eq(0)").removeClass('plugin-show');
			$(".advanced-mask-layer").hide();
		},230);
		$(".page.page-on-center").removeClass('fixed');
		$(".page-content.odr_doc").css("cssText","");
	});
	$(".slide-selector:eq(1) .bar-nav").tap(function(){
		$(".slide-selector:eq(1)").removeClass("selector-active");
		setTimeout(function(){
			$(".slide-selector:eq(1)").removeClass('plugin-show');
			$(".advanced-mask-layer").hide();
		},230);
		$(".page.page-on-center").removeClass('fixed');
		$(".page-content.odr_doc").css("cssText","");
	});
	
	$(".advanced-mask-layer").tap(function(){
		$(".slide-selector:eq(0)").removeClass("selector-active");
		$(".slide-selector:eq(1)").removeClass('selector-active');
		$(".slide-selector:eq(2)").removeClass('selector-active');
		$(".slide-selector:eq(3)").removeClass('selector-active');
		$(".slide-selector:eq(4)").removeClass('selector-active');
		setTimeout(function(){
			$(".slide-selector:eq(0)").removeClass('plugin-show');
			$(".slide-selector:eq(1)").removeClass('plugin-show');
			$(".slide-selector:eq(2)").removeClass('plugin-show');
			$(".slide-selector:eq(3)").removeClass('plugin-show');
			$(".slide-selector:eq(4)").removeClass('plugin-show');
			$(".advanced-mask-layer").hide();
		},230);
		$(".page.page-on-center").removeClass('fixed');
		$(".page-content.odr_doc").css("cssText","");
		$(".item-btn").parent(".dialog").removeClass('dialog-active').removeClass('plugin-show');
	});	
	
	//入住联系人输入框发生改变事件
	$(".order-contact .contact-person").delegate("ul li input[name=customernames]","input",function(){
		if($(this).val()!=""){
			$(this).next("i").show();
		}else{
			$(this).next("i").hide();
		}
	})

	//房间保留至
	$(".order-occupancy ul  li:eq(2)").tap(function(){
		$(".page.page-on-center").addClass('fixed');
		$("input[type=text]").blur();
		$(".page-content.odr_doc").css("cssText","overflow:hidden!important");
		$(".slide-selector:eq(1)").addClass('plugin-show');
		setTimeout(function(){
			$(".slide-selector:eq(1)").addClass("selector-active");
			$(".advanced-mask-layer").show();
		},230);
	});

	//选择房间保留至的时间段
	$(".slide-selector:eq(1) .page-content li.radio-item").tap(function(){
		$("input[type=text]").blur();
		if($(this).hasClass('selected')) return;
		$(this).addClass('selected').siblings().removeClass('selected');
		var room_time = $(this).find('div.radio-text').html();
		$(".order-occupancy input#room-reservation").val(room_time);

		$(".slide-selector:eq(1)").removeClass('selector-active');
		setTimeout(function(){
			$(".slide-selector:eq(1)").removeClass('plugin-show');
			$(".advanced-mask-layer").hide();
		},230);
		$(".page.page-on-center").removeClass('fixed');
		$(".page-content.odr_doc").css("cssText","");
	});

	//添加入住人
	$(".add-person-button").tap(function(){
		$("#hiddenfocus").focus();
		$("input[type=text]").blur();
		$(".page.page-on-center").addClass('fixed');
		$(".page-content.odr_doc").css("cssText","overflow:hidden!important"); 
		$(".select-people").addClass("plugin-show").addClass("page-from-right-to-center");
		
	});

	//选择入住人退回
	$(".select-people .bar .icon-back").tap(function(){
		$(".select-people").addClass("page-from-center-to-right");
		setTimeout(function(){
			$(".select-people").removeClass("plugin-show").removeClass("page-from-center-to-right");
		},230);
		$(".page.page-on-center").removeClass('fixed');
		$(".page-content.odr_doc").css("cssText","");
	});

	//新增常用入住人
	$(".person-box .add").tap(function(){
		$(this).hide();
		$(this).next("div.to-input").show();
	});

	//增加常用人到列表
	$(".to-input").on('click', 'div.confirm', function(event) {
		var  Commonpeople = $(this).prev('input#inputaddcusname').val();
		var Commonpeople_value = $(this).prev("input[name='addcusname']").val();
		var Commonpeople_list = "";
		if(!Commonpeople){
			showTab("请输入正确的入住人姓名");
			$(this).parent('div.to-input').hide();
			$(this).parent('div.to-input').prev("div.add").show();
		}else{
			//Commonpeople_list += "<li><div class='checkbox'></div><span>" + Commonpeople_value +" <span></span></span></li>"
			
			if($.cookie('peopleCookie')!=null){
				var arr= $.cookie('peopleCookie').split(",");
				if(!isInArray(arr,Commonpeople_value)){
					peopleCookie.addCookie(Commonpeople_value);
				}		
			}else{
				peopleCookie.addCookie(Commonpeople_value);
			}
			$(this).prev("input[name='addcusname']").val("");
			
				
			$(this).parent('div.to-input').hide();
			$(this).parent('div.to-input').prev("div.add").show();
			//$(".per-list").html(Commonpeople_list);
			//peopleCookie.list();
		
		}


	});
	var expiresDate= new Date();
	expiresDate.setTime(expiresDate.getTime() + (365*24*60 * 60 * 1000)); 
	//添加常用人到cookie
	var peopleCookie={
		"key":"peopleCookie",
		"createli":function(people){
			return "<li><div class='checkbox'></div><span>" + people +" <span></span></span></li>";
		},
		"addCookie":function(people){
			
			var ps=$.cookie(this.key);
			people=people.replace(",","");
			if(ps){
				ps=people+","+ps;
			}else{
				ps=people;
			}
            $.cookie(this.key,ps,{expires:expiresDate});
           $(".per-list").prepend(peopleCookie.createli(people));
		},
		"list":function(){
			var ps=$.cookie(this.key);
			 var html="";
			if(ps){
				var psArr=ps.split(",");
                
                 for(var i=0;i<psArr.length;i++){
                   html+= this.createli(psArr[i]);
                 }
			}
			$(".per-list").html(html);
		}
	};
     peopleCookie.list();//进入页面加载一次
     $(".per-list").on("click","li",function(){

     	/*if($(this).siblings('li').find("div.checked").length>0){
     		showTab("每个房间只需选择一位入住人");
     		return;
     	}*/
     	if(!$(this).find("div").hasClass('checked')){
             $(this).find("div").addClass('checked');
     	}else{
     		$(this).find("div").removeClass('checked');
     	}
     	$(this).parent().find("li div").removeClass("checked");
     	$(this).find("div").addClass("checked");
     })
    function showTab(tip, ff){
     	if(!tip)return;
     	$(".advanced-mask-layer").show();
       	$(".dialog.plugin-inited").addClass('page-transitioning').addClass('dialog-active').find("div.content").html(tip);
    }
     //用户点击过的输入框索引     
     
    var focusCustomernameIndex=0;
    $(".order-contact .contact-person").delegate("ul li input[name=customernames]","focus",function(){
     	focusCustomernameIndex=	$(".order-contact .contact-person ul li input[name=customernames]").index(this);
    });
     
    $("a.submit.pull-right").click(function(){
       	var people=$(".per-list li>div.checked").parent("li").find("span").text();
       	if(people){
       		if($(".order-contact .contact-person ul li").length-1<focusCustomernameIndex) focusCustomernameIndex=0;
       		$("input[name=customernames]").eq(focusCustomernameIndex).val(people);
       	}

        $(".page.page-on-center").removeClass('fixed');
		$(".page-content.odr_doc").css("cssText","auto"); 
		$(".select-people").removeClass("plugin-show").removeClass("page-from-right-to-center");
  	});
    
    function isInArray(arr,value){
        for(var i = 0; i < arr.length; i++){
            if(value === arr[i]){
                return true;
            }
        }
        return false;
    }
    
      //提交订单
  	$("#mobilesubmit").click(function(){
  		var phone=$("#contactormobile").val();
      	 if(!$("#cusname1").val()){
             showTab("请输入入住人姓名");
             return;
       	 }else if(!phone){
             showTab("请输入联系人手机号");
             return;
      	 }else if(!/^1[0-9]\d{9}$/.test(phone)){
      	 	 showTab("手机号码格式不正确");
             return;
         }
   		//联系人手机号本地存储
      	if(window.localStorage){
      		if(localStorage.contactmobile){ 
      			var arr=localStorage.contactmobile.split(",");
      			if(!isInArray(arr,phone)){
      				arr.push(phone);
      				localStorage.contactmobile=arr.join(",");
      			}
      		}else{//undefined
      			localStorage.contactmobile=phone;
      		}
      	} 
      	 
      	 submitElongOrder();
  	})
  	function submitElongOrder(){  		
  		//基础数据
  		var webPath = $("#param-webPath").val();
  		var hotelId = $("#param-hotelId").val();
  		var ratePlanId = $("#param-ratePlanId").val();
  		var roomTypeId = $("#param-roomTypeId").val();
  		var arrivalDate = $("#param-arrivalDate").val();
  		var departureDate = $("#param-departureDate").val();
  		var paymentType = $("#param-paymentType").val();
  		var roomNumber = parseInt($("#room-number").val().replace("间", ""));
  		var roomReservation = arrivalDate + " " + $("#room-reservation").val().replace(/[^0-9:]*/g, "") + ":00";
  		var contactorMobile = $.trim($("#contactormobile").val());
  		var contactor = $.trim($("#cusname1").val());
  		//Ajax请求数据封装
  		var orderData = {
  				"hotelId": hotelId, 
  				"ratePlanId": ratePlanId, 
  				"roomTypeId": roomTypeId, 
  				"arrivalDate": arrivalDate, 
  				"departureDate": departureDate, 
  				"paymentType": paymentType, 
  				"numberOfRooms": roomNumber, 
  				"latestArrivalTimeString": roomReservation,
  				"contact.name": contactor,
  				"contact.mobile": contactorMobile
  			};
  		var ll = {};
  		for(var i = 1; i <= roomNumber; i++){
  			var name = $.trim($("#cusname" + i).val());
  			if(name == ""){
  				showTab("请输入入住人姓名");
  				return;
  			}
  			if(ll[name]){
  				showTab("入住人姓名不能重复");
  				return;
  			}
  			ll[name] = true;
  			orderData["guesterList["+(i-1)+"].name"] = name;
  		}
  		if($("#mobilesubmit").text() == "数据提交中"){
  			return;
  		}
  		$("#mobilesubmit").text("数据提交中");
  		loadingShow();
  		$.ajax({  
            type : "POST",  //提交方式  
            url : webPath + '/elong/order/create.htm',//路径  
            data: orderData, 
            dataType: "json",
            success : function(result) {
            	if (result.state) {
            		//setTimeout(function(){
            			location.href = webPath + '/v1/elong/order/toPay.htm?id=' + result.data.id + "&isNeedPay=" + result.data.isNeedPay;
            		//}, 3000);
                }  else {
                	$("#mobilesubmit").text("提交订单");
                	loadingHide();
                	var msg = (result.msg || "").split("|");
                	var showMsg = msg.length>1?msg[1]:msg[0];
                	showTab(showMsg); 
                	if(showMsg.indexOf("连接超时") != -1){
                		try{
                			fn.requestBack();
                		}catch(e){
                		}
                	}
                }
            },
            error: function(res, status){
            	$("#mobilesubmit").text("提交订单");
            	loadingHide();
            	showTab("订单创建失败！");
            },
            complete: function(){
            	//$("#mobilesubmit").text("提交订单");
            	//loadingHide();
            }
        }); 
  	}
	//确定
	$(".item-btn").tap(function(){
		$(this).parent(".dialog").removeClass('dialog-active').removeClass('plugin-show');
		$(".advanced-mask-layer").hide();
	});
	
	if(window.localStorage&&localStorage.contactmobile){
		$(".tel-choose").css("cssText","");
		$(".icon-tel-choose").css("cssText","");
		var contactmobile=localStorage.contactmobile.split(",");
		var str="";
		for(var i=0,len=contactmobile.length;i<len;i++){
			if(i==0){
				str+="<li class=\"radio-item selected\">";
			}else{
				str+="<li class=\"radio-item\">";	
			}
			str+="<label class=\"label-radio clearfix\">";
			str+="<div class=\"radio-icon\"><span class=\"radio selected\"></span></div>";
			str+="<div class=\"radio-text\">"+contactmobile[i]+"</div>";
			str+="<div class=\"check\"></div>";
			str+="</label>";
			str+="</li>";
		}
		$(".slide-selector:eq(3) .page-content").append(str);
	}
	
	/*联系人号码选择开始*/
	$(".order-contact .tel-choose").tap(function(){
		$("#hiddenfocus").focus();
		$("input[type=text]").blur();
		if($(this).css("color")=="rgb(220, 220, 220)") return;
		$(".page.page-on-center").addClass('fixed');
		$(".page-content.odr_doc").css("cssText","overflow:hidden!important");
		$(".slide-selector:eq(3)").addClass('plugin-show');
		setTimeout(function(){
			$(".slide-selector:eq(3)").addClass("selector-active");
			$(".advanced-mask-layer").show();
		},230);
	});
	$(".slide-selector:eq(3) .page-content li.radio-item").tap(function(){
		$(this).addClass('selected').siblings().removeClass('selected');
		var phone = $(this).find('div.radio-text').html();
		$("#contactormobile").val(phone);
		$(".page.page-on-center").removeClass('fixed');
		$(".page-content.odr_doc").css("cssText","");

		$(".slide-selector:eq(3)").removeClass('selector-active');
		setTimeout(function(){
			$(".slide-selector:eq(3)").removeClass('plugin-show');
			$(".advanced-mask-layer").hide();
		},230);
	});
	
	
	$(".slide-selector:eq(3) .cancel").tap(function(){
		$(".slide-selector:eq(3)").removeClass('selector-active');
		$(".page.page-on-center").removeClass('fixed');
		$(".page-content.odr_doc").css("cssText","");
		setTimeout(function(){
			$(".slide-selector:eq(3)").removeClass('plugin-show');
			$(".advanced-mask-layer").hide();
		},230);
	});
	/*联系人号码选择结束*/
	
	//手机号区域选择
	$(".area-address").tap(function(){
		$(".page.page-on-center").addClass('fixed');
		$(".page-content.odr_doc").css("cssText","overflow:hidden!important");
		$(".slide-selector:eq(2)").addClass('plugin-show');
		setTimeout(function(){
			$(".slide-selector:eq(2)").addClass("selector-active");
			$(".advanced-mask-layer").show();
		},230);
	});
	//手机号地区选择
	$(".slide-selector:eq(2) .page-content li.radio-item").tap(function(){
		$(this).addClass('selected').siblings().removeClass('selected');
		var phone_num = $(this).find('div.radio-text').html();
		var phone_num2 =phone_num.substring(phone_num.lastIndexOf("(")+1,phone_num.length-1);


		$(".contact-tel input#area-code").val(phone_num2);
		$(".page.page-on-center").removeClass('fixed');
		$(".page-content.odr_doc").css("cssText","");

		$(".slide-selector:eq(2)").removeClass('selector-active');
		setTimeout(function(){
			$(".slide-selector:eq(2)").removeClass('plugin-show');
			$(".advanced-mask-layer").hide();
		},230);
	});
	
	$(".slide-selector:eq(2) .cancel").tap(function(){
		$(".slide-selector:eq(2)").removeClass('selector-active');
		$(".page.page-on-center").removeClass('fixed');
		$(".page-content.odr_doc").css("cssText","");
		setTimeout(function(){
			$(".slide-selector:eq(2)").removeClass('plugin-show');
			$(".advanced-mask-layer").hide();
		},230);
	});


	//清空输入框
	$(".order-contact input").focus(function(){
		var input_value = $(this).val();
		
  	});

  	$(".order-contact .contact-person").delegate(".icon-cross.clear-input","click",function(){
  		$(this).prev('input').val('');
  		$(this).hide();
  	});
  	
	/*//发票部分
  	发票开关
  	var switchflag=false;
  	var invoiceli=$(".order-invoice ul li");
  	$(".label-switch.tjclick").tap(function(){
  		
  		$(this).find(".checkbox").toggleClass("active");
  		$(this).find(".open").toggle("");
  		$(this).find(".close").toggle("");
  		if(!switchflag){
  			$("#whetherReceipt").css("cssText","border-bottom-width: 1px; border-bottom-color: rgb(221, 221, 221); border-bottom-style: solid;");
  			invoiceli.not("#whetherReceipt,.invoice-type,.adress_select").css("display","list-item");
  		}else{
  			$("#whetherReceipt").css("cssText","border-bottom-width: 0px;");
  			invoiceli.not("#whetherReceipt,.invoice-type,.adress_select").css("display","none");
  		}
  		switchflag=!switchflag;
  	});
  	发票类型选择
  	$("#invoice-type").tap(function(){
  		$(".advanced-mask-layer").show();
  		$(".slide-selector:eq(4)").addClass('plugin-show');
		setTimeout(function(){
			$(".slide-selector:eq(4)").addClass("selector-active");
		},1);
  	});
  	$(".slide-selector:eq(4) ul li").tap(function(){
  		$(this).addClass("selected").siblings().removeClass("selected");
  		var text=$(this).find(".radio-text").html();
  		$("#invoice-type").html(text);
  		var index=$(".slide-selector:eq(4) ul li").index(this);
  		if(index==0){
  			$(".invoice-type").not("#invoice-phone").css("display","none");
  			if($(".invoice-header .header-type").eq(0).hasClass("active")){
  				$(".inc_tit.taxpayerNumber").css("display","list-item");
  			}
  			$(".invoice-header-type").css("display","list-item");
  		}else{
  			$(".invoice-type").not("#invoice-phone").css("display","list-item");
  			$(".inc_tit.taxpayerNumber").hide();
  			$(".invoice-header-type").hide();
  		}
  		$(".advanced-mask-layer").hide();
  		$(".slide-selector:eq(4)").removeClass("selector-active");
  		setTimeout(function(){
  			$(".slide-selector:eq(4)").removeClass('plugin-show');			
		},230);
  	});
  	$(".slide-selector:eq(4) .cancel").tap(function(){  		
  		$(".advanced-mask-layer").hide();
  		$(".slide-selector:eq(4)").removeClass("selector-active");
  		setTimeout(function(){
  			$(".slide-selector:eq(4)").removeClass('plugin-show');			
		},230);
  	});
  	
  	抬头类型
  	$(".invoice-header a").tap(function(){
  		var index=$(".invoice-header a").index(this);
  		$(this).addClass("active").siblings().removeClass("active");
  		if(index==0){
  			$(".inc_tit.taxpayerNumber").css("display","list-item");
  		}else if(index==1){
  			$(".inc_tit.taxpayerNumber").hide();
  		}else{
  			$(".inc_tit.taxpayerNumber").hide();
  		}
  	});
  	发票抬头
  	$(".invotit").tap(function(){		
		$(".page.page-on-center").addClass('fixed');
		$(".page-content.odr_doc").css("cssText","overflow:hidden!important"); 
		$("#addInvotit").addClass("plugin-show").addClass("page-from-right-to-center");
  	}); 	

	$("#addInvotit .bar .icon-back").tap(function(){
		$("#addInvotit").addClass("page-from-center-to-right");
		setTimeout(function(){
			$("#addInvotit").removeClass("plugin-show").removeClass("page-from-center-to-right");
		},230);
		$(".page.page-on-center").removeClass('fixed');
		$(".page-content.odr_doc").css("cssText","");
	});
	$("#addInvotit .billbtn").tap(function(){
		var text= $("#invoice_title").val();
		console.log(text);
		$("#invoice-title").html(text);
		$(".invotit").removeClass("hui");
		$("#addInvotit").addClass("page-from-center-to-right");
		setTimeout(function(){
			$("#addInvotit").removeClass("plugin-show").removeClass("page-from-center-to-right");
		},230);
		$(".page.page-on-center").removeClass('fixed');
		$(".page-content.odr_doc").css("cssText","");		
	});
	发票内容
	$("#invoice-content").tap(function(){
		$(".advanced-mask-layer").show();
  		$(".slide-selector:eq(5)").addClass('plugin-show');
		setTimeout(function(){
			$(".slide-selector:eq(5)").addClass("selector-active");
		},1);
	});*/

});





