/**
 * Created by Session on 15/11/20.
 */
function getUrlPar(name) {
	   var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
	   var r = window.location.search.substr(1).match(reg);
	   if (r!=null) return (r[2]); return null;
}

$(function(){
    $('#submit').on('touchstart', function(){
    	
        if ($(this).data('disabled')) return;

        // 提交过程中禁用按钮
        $(this).data('disabled', true).html('正在支付');

        var payType = $('#payType').val();
        $("#payConfrimMoney").html($("#addmount").html());
        var money=parseFloat($("#addmount").html());
        var uid=$("#loginUserId").val();
        var sellerId=$("#sellerId").val();
        var t=new Date().getTime();  
        var orderType = $.trim($("#orderType").val());

        if(payType.toLowerCase() == "wxpay"){
            wxPay();
        }
        else if(payType.toLowerCase() == "alipay"){
            aliPay();
        }else if(payType.toLowerCase() == "ysysgo"){
        	 $.ajax({
                 type: 'POST',
                 url:$("#webpath").val()+'/yun_shang/wap.htm?sellerUid='+sellerId+"&uid="+uid+"&money="+money+"&orderType="+orderType+"&t="+t,
                 data: {
                 },
                 async: false,
                 dataType: 'json',
                 success: function (data) {
                 	if(data.uid!=null){
                 		$("#orderNum").val(data.orderNum);
                 		$("#orderId").val(data.orderId);
                 		$("#price").val(data.money);
                 		$("#orderType").val(data.orderType);
                 	}else{//
                 		tips('生成订单失败');
                 		$("#submit").data('disabled', false).html('确认支付');
                 		return;
                 	}
                 	
             	},
             	error:function(){
             		tips('生成订单失败');
             		$("#submit").data('disabled', false).html('确认支付');
             		return;
             	}        	
             });
        	if(isAndroid){
        		var version=getUrlPar('version');
        		if(version==undefined||version<132){//兼容旧版本
        			java.requestOrder($("#orderId").val(),$("#orderNum").val(),$("#price").val(),$("#orderType").val());//兼容未升级版本
        		}else{
        			java.requestOrder($("#orderId").val(),$("#orderNum").val(),$("#price").val(),$("#orderType").val(),$("#discount").html()*0.1);
        		}     		
        		
        	}else if(isiOS){
        		requestOrder($("#orderId").val(),$("#orderNum").val(),$("#price").val(),$("#orderType").val(),$("#discount").html()*0.1);
        	//	requestOrder($("#orderId").val(),$("#orderNum").val(),$("#price").val(),$("#orderType").val());//兼容未升级版本
        	}
        	
          /*  jgPayStart();  */         
        }

    });
    jgGlobal.setFontSize();
    jgGlobal.setTranslate(jQuery (".vip_login_container")[0],jgGlobal.screenHeight,"height:"+jgGlobal.screenHeight+"px");
    

  //会员登录关闭按钮        
    $('.loginBox .title .close').on('touchstart', function(){
    	$(".model").fadeOut();
    	jgGlobal.setTranslate(jQuery (".vip_login_container")[0],jgGlobal.screenHeight,"height:"+jgGlobal.screenHeight+"px",true);
    	resetSubmitBtn();
    	$("#isPwdKeyBoard").val("");
    	allowKeyboard=true;	
    });
    
    //输入密码关闭
    $(".pswBox .title .close").on('touchstart',function(){
    	$(".model").fadeOut();
    	jgGlobal.setTranslate(jQuery (".vip_login_container")[0],jgGlobal.screenHeight,"height:"+jgGlobal.screenHeight+"px",true);
    	resetSubmitBtn();
    	$("#isPwdKeyBoard").val("");
    	allowKeyboard=true;	    	
    });
    
    $('#payFailAlert .alert-button').on('touchstart', function(){
        wx.ready(function () {
            wx.closeWindow();
        });
        
        alertFriendly_close();
    });
    
    $('#pay_userlogin').on('touchstart', function(){
    	userLogin();
    });
    
});


function setPwdPoint(num){
	for(var j=0;j<6;j++){
		$(".pswPoint ul li").eq(j).html("");
	}
	for(var i=0;i<num;i++){
		$(".pswPoint ul li").eq(i).html("●");
	}	
}

// 微信支付
function wxPay(){

        var obj = getParaJson();
        // 下单
        $.ajax({
            type: 'POST',
            url: $('#qrPayUrl').val(),
            data: {
                money: obj.money,
                sellerId: obj.sellerId,
                code: obj.code,
                payType: obj.payType,
                phone: obj.phone,
                serverName: obj.serverName,
            },
            dataType: 'json',
            success: function (data) {
                if (data.code == 0) {
                    // 其他错误
                    alertFriendly(data.errMsg);
                    resetSubmitBtn();
                } else if (data.code == 1) {
                    var order = data.data;
                    function onBridgeReady() {
                        WeixinJSBridge.invoke(
                            'getBrandWCPayRequest', {
                                "appId": order.appId,     //公众号名称，由商户传入
                                "timeStamp": String(order.timeStamp),        //时间戳，自1970年以来的秒数
                                "nonceStr": order.nonceStr, //随机串
                                "package": "prepay_id=" + order.prepayId,
                                "signType": "MD5",      //微信签名方式：
                                "paySign": order.sign,//微信签名
                            },
                            function (res) {
                                
                                //alert(JSON.stringify(res));

                                if (res.err_msg == "get_brand_wcpay_request:ok") {
                                    wx.ready(function () {
                                        wx.closeWindow();
                                    });

                                } else {   

                                    alertFriendly("支付失败");
                                    // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。
                                    resetSubmitBtn();
                                }
                            }
                        );
                    }

                    if (typeof('WeixinJSBridge') == "undefined") {
                        if (document.addEventListener) {
                            document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
                        } else if (document.attachEvent) {
                            document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
                            document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
                        }
                    } else {
                        onBridgeReady();
                    }

                } else {
                    alertFriendly(data.msg);
                    resetSubmitBtn();
                }
            },
            error: function () {
                alertFriendly('呀，付款的人太多了。没挤进去。请重新扫码付款吧。');
            }
        });
}

// 支付宝支付
function aliPay(){

        var obj = getParaJson();

        // 下单
        $.ajax({
            type: 'POST',
            url: obj.qrPayUrl,
            data: {
                money: obj.money,
                sellerId: obj.sellerId,
                code: obj.code,
                payType: obj.payType,
                phone: obj.phone,
                serverName: obj.serverName,
            },
            dataType: 'json',
            success: function (data) {
                if (data.code == 0) {
                    // 其他错误
                    alertFriendly(data.errMsg);
                    resetSubmitBtn();
                } else if (data.code == 1) {
                    var reUrl = data.data;
                    window.location = reUrl; // 跳转
                } else {
                    alertFriendly(data.msg);
                    resetSubmitBtn();
                }
            },
            error: function () {
                alertFriendly('呀，付款的人太多了。没挤进去。请重新扫码付款吧。');
            }
        });
}

//云尚支付
function jgPayStart(){
	//首先打开会员登录框	
	openUserLogin();        
}


function getParaJson(){
    var money = parseFloat($('#addmount').html());
    var sellerId = $('#sellerId').val();
    var code = $('#code').val();
    var qrPayUrl = $('#qrPayUrl').val();
    var payType = $('#payType').val();
    var phone = $('#phone_username').val();
    var serverName = $('#serverName').val();


    var para = JSON.parse('{"sellerId":"' + sellerId +'","money":"' + money +'","code":"' + code +'","qrPayUrl":"' + qrPayUrl 
        +'","phone":"' + phone +'","serverName":"' + serverName 
        +'","payType":"' + payType +'"}');
    return para;

}

// 打开会员登录面版
function openUserLogin(){
	$(".loginBox .input_holder .tips").hide();
	$(".loginBox .input_holder input").val("");
	if($(".vip_login_container .pswBox").css("display")=="none") {
		$(".loginBox").show();
	}else{
		$("#isPwdKeyBoard").val("true");
	}
	$(".model").fadeIn();
    jgGlobal.setTranslate(jQuery (".vip_login_container")[0],0,"height:"+jgGlobal.screenHeight+"px",true);
}

function userLogin(){
    var phone = $('#phone_username').val();
    var pwd =  $('#pwd').val();
    var loginUrl = $('#login_check').val();
    // 验证
    if(!testMobilephone(phone)){
    	$(".loginBox .input_holder .tips").eq(0).show();
    	return;
    }
    if(pwd==""){
    	$(".loginBox .input_holder .tips").eq(1).show();
    	return;
    }

    $('#logoinUserId').val("");
    // 登录
    $.ajax({
            type: 'POST',
            url: loginUrl,
            data: {
                phone: phone,
                pwd: pwd,
            },
            dataType: 'json',
            success: function (data) {
                if (data.code == 0) {
                    // 其他错误
                    tips(data.errMsg);
                    resetSubmitBtn();
                } else if (data.code == 1) {
                    //关闭自己
                	//tips("登录成功");
                    $(".loginBox").hide();
                    $(".vip_login_container .pswBox").show();                    
                    allowKeyboard=true;

                    var logoinUserId = data.data;
                    $('#logoinUserId').val(logoinUserId);

                    //登录成功，输入密码框
                    payPwdInput();

                } 
            },
            error: function () {
                alertFriendly('呀，付款的人太多了。没挤进去。请重新扫码付款吧。');
            }
     });

}

// 输入密码
function payPwdInput(){
    $(".loginBox").hide();
    $(".vip_login_container .pswBox").show();
    allowKeyboard=true;
    $("#isPwdKeyBoard").val("true");
    $("#keyboardContainer").css("z-index",1000);
}

function payPwdValidate(){

    var payPwdValidateUrl = $('#pay_pwd_check').val();
    var payPwd = $('#enteredPwd').val();
    var userId = $('#logoinUserId').val();
    $(".paying").show();
    allowKeyboard=false;
     // 验证支付密码
    $.ajax({
            type: 'POST',
            url: payPwdValidateUrl,
            data: {
                userId: userId,
                payPwd: payPwd,
            },
            dataType: 'json',
            success: function (data) {
                if (data.code == 0) {
                    tips(data.errMsg);   
                    clearInputPayPwd();                 
                    // 跳转到忘记密码的页面
                    
                } else if (data.code == 1) {
                    if (data.data) {
                        //支付
                        jgPay();
                    }
                    else{
                    	$(".paying").hide();
                    	allowKeyboard=true;
                        tips("支付密码错误");
                        clearInputPayPwd();
                    }
                } 
            },
            error: function () {
                alertFriendly('呀，付款的人太多了。没挤进去。请重新扫码付款吧。');
                allowKeyboard=true;
            }
    });
}
function jgPay(){
    var obj = getParaJson();

    var payPwd = $('#enteredPwd').val();
    var userId = $('#logoinUserId').val();

    // 下单
    $.ajax({
        type: 'POST',
        url: obj.qrPayUrl,
        data: {
            money: obj.money,
            sellerId: obj.sellerId,
            code: obj.code,
            payType: obj.payType,
            phone: obj.phone,
            serverName: obj.serverName,
            userId: userId,
            payPwd: payPwd
        },
        dataType: 'json',
        success: function (data) {
             if (data.code == 1) {
                var info = data.data;
                //window.location = reUrl; // 跳转
                $(".paying").hide();
                allowKeyboard=true;
                alert(info);
                clearInputPayPwd();
                location.href=location.href;
            } else{
                // 其他错误
                tips(data.errMsg);
                $(".paying").hide();
            	allowKeyboard=true;
                clearInputPayPwd();
                resetSubmitBtn();
            } 
        },
        error: function () {
            alertFriendly('呀，付款的人太多了。没挤进去。请重新扫码付款吧。');
            $(".paying").hide();
        	allowKeyboard=true;
            clearInputPayPwd();
        }
    });
}