/**
 * Created by Session on 15/12/13.
 */

function alertFriendly (content){
    if (!content) return;

    $('#payFailAlert .alert-content').html(content);
    $('#alertBg, #payFailAlert').show();
}

function alertFriendly_close(){
	$('#alertBg, #payFailAlert').hide();
}

function resetSubmitBtn(){
    $('#submit').data('disabled', false).html('确认支付');
}

//小弹框
function tips(str) {
    if ($("#smalltips").css("opacity") != "0") return;
    $("#smalltips").css("z-index","999999999").html(str).css("margin-left",-$("#smalltips").innerWidth() / 2).animate({
        opacity:0.9,
        bottom: 80
    }, 500, 'easeOutBack', tipsend).css({ filter: "Alpha(Opacity=90)" });
}

function tipsend() {
    setTimeout(function () {
        $("#smalltips").css("opacity", 0).css("bottom", 0).css("z-index","-1").css("filter", "Alpha(Opacity=0)");
    }, 2500);                
}
//小弹框结束

//检测手机号
function testMobilephone(phone){
	//re = /^(13[0-9]|15[0-9]|16[0-9]|17[0-9]|18[0-9]|14[5|7])\d{8}$/;
	re=/^(1)\d{10}$/;
    if (!re.test(phone)) {
        return false;
    }else{
    	return true;
    }
}

// 清空支付密码
function clearInputPayPwd(){
    
    $("#enteredPwd").val("");

    for(var j=0;j<6;j++){
		$(".pswPoint ul li").eq(j).html("");
	}
}


function discountPay(discount,payValue){
	return  (discount*payValue*0.1).toFixed(2);
}

$(function(){
    // 键盘逻辑
    $('#keyboard').on('touchstart', function(e){
    	//添加一个全局变量allowKeyboard，控制模拟的数字键盘是否可用
    	if((!(typeof allowKeyboard==='undefined'))&&(!allowKeyboard)) return;
        // 如果是密码模式 输入焦点
    	if($("#isPwdKeyBoard").val()=="true"){
    		
    		var pwd=$("#enteredPwd");
    		var clickEl = $(e.target);
	        var key = clickEl.data('key');
	        var originVal = pwd.val();
	        if (key == 'del') {
	            // 删除键
	            newValue = originVal ? originVal.substr(0, originVal.length - 1):'';
	            setPwdPoint(newValue.length);
	        } else {
	            // 普通键	        	
	            newValue = originVal.toString()+ key.toString();
	        }
	       
	        // 不能有.
	        if (newValue.split('.').length > 1){
	            newValue = originVal;	           
	        }
	        //不能超过6位
	        if(newValue.length>6){
	        	newValue = originVal;
	        }
	        
	        setPwdPoint(newValue.length);
	        $("#enteredPwd").val(newValue);
	        if(newValue.length == 6){
	        	// 调用支付密码校验&支付
	        	payPwdValidate();
	        }
	        
    	}else{
	    	var input = $('#addmount');
	        $('#submit').addClass('disabled').data('disabled', true);
	
	        var clickEl = $(e.target);
	        var key = clickEl.data('key');
	
	        var originVal = input.html();
	        var newValue = originVal;
	        if (key == 'del') {
	            // 删除键
	            newValue = originVal ? originVal.substr(0, originVal.length - 1):'';
	        } else {
	            // 普通键
	            newValue = originVal+key;
	        }
	
	        // 不能有太多点
	        if (newValue.split('.').length > 2){
	            newValue = originVal;
	        }
	
	        // 修正显示
	        if (newValue == '.') {
	            newValue = '0.';
	        }
	
	        if (newValue == '00') {
	            newValue = '0';
	        }
	
	        // 不能输入太多 0
	        if (newValue.length > 1 && newValue[0] == '0' && newValue[1] != '0' && newValue[1] != '.'){
	            newValue = newValue[1];
	        }
	
	        // 不能超过两位小数
	        if (newValue.toString().indexOf('.')!=-1 && newValue.toString().split('.')[1].length > 2){
	            newValue = originVal;
	        }
	        // 最大到万级
	        if (newValue.toString().split('.')[0].length > 5) {
	            newValue = originVal;
	        }
	        
	        input.html(newValue);
	
	        	        
	        var payValue=newValue==""?0:newValue;
	        var actualPay=discountPay($("#discount").html(),payValue);
	        $("#actualPay").html(actualPay);
	        
	        if (!isNaN(newValue) && newValue > 0) $('#submit').removeClass('disabled').data('disabled', false);
    	}
    });
});
