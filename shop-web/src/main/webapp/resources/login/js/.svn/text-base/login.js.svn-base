$(function(){
	/*商户登录*/

	/*登录判断*/
	function logincheck(){
		var username=$("#username").val();
		var password=$("#password").val();
		var checkcode=$("#checkcode").val();

		if(!username){
			$("#J_Message").css("display","block").text("＊ 请输入手机号码");
			return false;
		}
		if(!password){
			$("#J_Message").css("display","block").text("＊ 请输入登录密码");
			return false;
		}
		if(!checkcode){
			$("#J_Message").css("display","block").html("＊ 请输入验证码");
			return false;
		}
		
		if(!/^(1[0-9]{10}$)/.test(username)){
	        $("#J_Message").css("display","block").html("＊ 您输入的账号格式不正确，请重新输入");
	        return false;
		}else{
			$("#J_Message").css("display","none").html("");
		}
		
	}
    /*用户名事件*/
	$("#username").keyup(function(event){
		var username=$(this).val();
		$(this).next("span.close_user").show();
		if(!username){
			$("#J_Message").html("＊ 请输入手机号码");
			$(this).next("span.close_user").hide();
			return false;
		}

		if(!/^(1[0-9]{10}$)/.test(username)){
	        $("#J_Message").css("display","block").html("＊ 您输入的账号格式不正确，请重新输入");
		}else{
			$("#J_Message").css("display","none").html("");
		}

	});
	
    /* 密码事件*/
	$("#password").keyup(function(event){
		var password=$(this).val();
		if(!password){
			$("#J_Message").css("display","block").text("＊ 请输入登录密码");
			$(this).next("span.close_user").hide();
			return false;
		}
		$(this).next("span.close_user").show();
		$("#J_Message").css("display","none").html("");
	});


	$("#checkcode").keyup(function(event){
		var checkcode=$(this).val();
		if(!checkcode){
			$("#J_Message").css("display","block").text("＊ 请输入验证码");
			$(this).next("span.close_user").hide();
			return false;
		}
		$(this).next("span.close_user").show();
		$("#J_Message").css("display","none").html("");
	});


	$("#loginForm").submit(logincheck);
	$("span.close_user").on("click",function(){
		$("#J_Message").css("display","none").html("");
		$(this).prev("input").val("");
		$(this).hide();
	});



	/*申请商户入驻设置账号信息*/
	$("#tanants_submit").on("click",function(){
				var tanants_username = $("#tanants_username").val();
				var tanants_pwd =  $("#tanants_pwd").val();
				var tanants_checkid = $("#tanants_checkid").val();
				if(!tanants_username){
					$(".error_sh_username").css('display','block').text("请输入手机号码");
					return false;
				}
				if(!tanants_pwd){
					$(".error_sh_pwd").css('display','block').text("请输入登录密码");
					return false;
				}
				if(!tanants_checkid){
					$(".error_sh_checkid").css('display','block').text("请输入验证码");
					return false;
				}
				if(!/^(1[0-9]{10}$)/.test(tanants_username)){
					$(".sh_true_id").css("display","none");
				    $(".error_sh_username").css("display","block").text("您输入的账号格式不正确，请重新输入");
				    return false;	
				}else{
					$(".error_sh_username").css("display","none").html("");
					$(".sh_true_id").css("display","block");
				}
				
			})

			$("#tanants_username").keyup(function(event) {
				var tanants_username = $(this).val();
				$(this).next("span.close_user").show();					
				if(!/^(1[0-9]{10}$)/.test(tanants_username)){
					$(".sh_true_id").css("display","none");
				    $(".error_sh_username").css("display","block").text("您输入的账号格式不正确，请重新输入");
						
				}else{
					$(".error_sh_username").css("display","none").html("");
					$(".sh_true_id").css("display","block");
				}
				if(!tanants_username){
					$(".sh_true_id").css("display","none");
					$(".error_sh_username").css('display','block').text("请输入手机号码");
					$(this).next("span.close_user").hide();	
					return false;
				}
			});
			$("#tanants_pwd").keyup(function(event) {
				var tanants_pwd = $(this).val();
				$(this).next("span.close_user").show();	
				if(!tanants_pwd){
					$(".error_sh_pwd").css('display','block').text("请输入登录密码");
					$(this).next("span.close_user").hide();	
				}else{
					$(".error_sh_pwd").css('display','none').text("");
				}

			});
			$("#tanants_checkid").keyup(function(event) {
				var tanants_checkid = $(this).val();
				$(this).next("span.close_user").show();	
				if(!tanants_checkid){
					$(".error_sh_checkid").css('display','block').text("请输入验证码");
					$(this).next("span.close_user").hide();	
				}else{
					$(".error_sh_checkid").css('display','none').text("");
				}			
			});

			$("span.close_user").on("click",function(){
				$(this).next("span.error_sh_login").css('display','none').html("");
				/*$(this).next("span.error_sh_username").css('display','block').html("请输入手机号码");
				$(this).next("span.error_sh_pwd").css('display','block').html("请输入登录密码");
				$(this).siblings("span.error_sh_checkid").css('display','block').html("请输入验证码");*/
				$(this).siblings("span.sh_true_id").hide();
				$(this).prev("input").val("");
				$(this).hide();
			});

});